//*******************************************************************************************/
//																							//
//		Nombre Archivo	:	UploadFile.java													//
//		Package			:	com.meve.upload													//
//		Descripción		:	Esta clase lee un request del cual obtiene los campos y sus		//
//							valores, si existe algun archivo entonces lo lee y lo almacena	//
//							en forma de bytes.												//
//							En esta version carga un solo archivo y lo guarda en DB2, el	//
//							nombre de la base de datos y el nombre de la columna se 		//
//							especifican al momneto de hacer el insert.						//
//		Empresa			:	Meve Soluciones S.A. de C.V.									//
//		página Web		:	www.meve.com													//
//		Autor			:	David Contreras Cortés. DOOGIE									//
//		Contacto		:	David.Contreras@meve.com, doogieska@hotmail.com					//
//		Fecha			:	12-01-2004														//
//		Versión			:	1.0																//
//		Modificaciones	:																	//
//		Fecha Ult Mod	:																	//
//																							//
//*******************************************************************************************/

 
/**
 * Autor Modificación		:	David Contreras Cortés - Doogie
 * Fecha Modificación		:	14-01-2004
 * Descripción Modificación	:	Se agregó la Función que regresa un archivo en bytes.
 */

package com.meve.sigma.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*******************************************
 * 
 * @author	David Contreras Cortés - Doogie
 * 
 *******************************************/

public class UploadFile 
{
	private		String		strSalvarRuta;
	private 	String		strRutaArchivo;
	private		String		strNombreArchivo;
	private		String		strContentType;
	private		Dictionary	dicCampos;
	private		Dictionary	dicContentType;
	private		Dictionary	dicRutaArchivo;
	private		Dictionary	dicArchivos;
	private 	Enumeration	enumValores;
	private static int MAXLON=1024;
	
	
	/**************************************************************
	 * Constructor de la clase UploadFile. Inicializa las variables
	 * de la clase.
	 ***************************************************************/
	public UploadFile()
	{
		strContentType="";
		strNombreArchivo="";
		strRutaArchivo="";
		strSalvarRuta="";
		dicArchivos = new Hashtable();
		dicCampos = new Hashtable();
		dicContentType = new Hashtable();
		dicRutaArchivo = new Hashtable();
		enumValores = null;
	}
	
	public String getMensaje(String str)
	{
		return str;
	}
	
	/************************************************************************
	 * Función que regresa los nombres de los archivo que se guardaran en DB2.
	 * 
	 * @return	Regresa un arreglo de String's que son los nombre de los
	 * 			archivos que se almacenarán en la BD's.
	 * 
	 ***********************************************************************/
	public String[] getNombreArchivo()
	{
		if(dicArchivos==null || dicArchivos.size()==0)
			return null;
		
		String[] strNombres = new String[dicArchivos.size()];
		
		enumValores = dicArchivos.keys();
		
		for(int i=0;enumValores.hasMoreElements();i++)
		{
			strNombres[i]=(String)enumValores.nextElement();
		}
		
		return strNombres;
	}
	
	/************************************************************************
	 * Función que regresa los nombres de los archivos y las rutas de los archivos, 
	 * estas rutas son las que los archivos tienen en la maquina cliente.
	 * 
	 * @return	Regresa un arreglo  bidimensional de String's que son las 
	 * 			rutas de los archivos.
	 ***********************************************************************/
	public String[][] getRutaArchivo()
	{
		if(dicRutaArchivo==null || dicRutaArchivo.size()==0)
			return null;
			
		String[][] strRutas = new String[dicRutaArchivo.size()][2];
		enumValores = dicRutaArchivo.keys();
		
		for(int i=0;enumValores.hasMoreElements();i++)
		{
			strRutas[i][0] = (String)enumValores.nextElement();
			strRutas[i][1] = (String)dicRutaArchivo.get(strRutas[i][0]);
		}
		
		return strRutas;
	}
	
	/***************************************************************************
	 * Función que regresa la ruta de un archivo en especifico, el nombre del
	 * archivo es pasado como parámetro.
	 * 
	 * @param	strNombreArchivo	Es un String que contiene el nombre del archivo
	 * 								del cual se quiere la ruta.
	 * @return	Regresa un String que es la ruta del archivo que se le paso como
	 * 			parámetro. Si el nombre del archivo no existe regresa una cadena
	 * 			vacía o en caso de que no exista ninguna ruta almacenada.
	 ****************************************************************************/
	public String getRutaArchivo(String strNombreArchivo)
	{
		if(strNombreArchivo==null || !(strNombreArchivo.trim().length()>0) || dicRutaArchivo==null || dicRutaArchivo.size()==0)
			return "";
		
		return (String)(dicRutaArchivo.get(strNombreArchivo));
	}
	/************************************************************************
	 * Función que obtiene los nombres y los ContentType de los archivos que se
	 * almacenarán en la BD's.
	 * 
	 * @return	Regresa un arreglo bidimensional de String's que es el nombre
	 * 			del archivo y el ContentType que describe el contenido del archivo.
	 ***********************************************************************/
	public String[][] getContentType()
	{
		if(dicContentType==null || dicContentType.size()==0)
			return null;
		
		String[][] strContentTypes = new String[dicContentType.size()][2];
		enumValores = dicContentType.keys();
		
		for(int i=0;enumValores.hasMoreElements();i++)
		{
			strContentTypes[i][0] = (String)enumValores.nextElement();
			strContentTypes[i][1] = (String)dicContentType.get(strContentTypes[i][0]);
		}
		
		return strContentTypes;
	}
	
	/*****************************************************************************
	 * Función que obtiene el ContentType de un archivo especifico que es pasado
	 * como parámetro.
	 * 
	 * @param	strNombreArchivo	Es un String que contiene el nombre del archivo 
	 * 								del cual se quiere saber el ContentType.
	 * @return	Regresa un String que es el ContentType del archivo que se le paso
	 * 			como parámetro. si el nombre el archivo no existe regresa una cadena 
	 * 			vacía o en caso de no existir ningun ContentType almacenado.
	 ********************************************************************************/
	
	public String getContentType(String strNombreArchivo)
	{
		if(strNombreArchivo==null || !(strNombreArchivo.trim().length()>0) || dicContentType==null || dicContentType.size()==0)
			return "";
			
		return (String)(dicContentType.get(strNombreArchivo));
	}
	
	/************************************************************************
	 * Función que pone la ruta donde se guardará el archivo en el servidor.
	 *
	 * @param	strSalvarRuta	Es un String que contiene la ruta donde	se
	 * 							se almacenará el archivo en el servidor.
	 ***********************************************************************/
	public void setSalvarRuta(String strSalvarRuta)
	{
		this.strSalvarRuta = strSalvarRuta;
	}
	
	/************************************************************************
	 * Función que obtiene el valor de un campo en especial del request pasado
	 * como parámetro.
	 * 
	 * @param	strNombreCampo	Es un String que contiene el nombre del campo
	 * 							del cual se busca su valor.
	 * @return	Regresa un String que es el valor del campo que recibe como
	 * 			parámetro, en caso de no existir ese nombre de campo, la Función
	 * 			regresa una cadena vacía.
	 ***********************************************************************/
	public String getCampo(String strNombreCampo)
	{
		if(dicCampos==null || strNombreCampo==null)
			return "";
			
		return (String)dicCampos.get(strNombreCampo);
	}
        
    /************************************************************************
     * Función 2 que coloca el nombre del archivo en la variable strNombreArchivo,
     * esta Función es privada.
     * 
     * @param       strNombreArchivo        Es un Stirng que contiene una linea de encabezado
     *                                                              dentro de la cual esta el nombre del archivo que
     *                                                              se almacena.
     ***********************************************************************/
        private void setNombreArchivo2(String strNombreArchivo)
        {
                        strRutaArchivo = strNombreArchivo;
                        int pos = strNombreArchivo.lastIndexOf("\\");
                        
                        if(pos!=-1)
                                this.strNombreArchivo = strNombreArchivo.substring(pos+1);
                        else
                                this.strNombreArchivo = strNombreArchivo;
        }
	
	/************************************************************************
	 * Función que coloca el nombre del archivo en la variable strNombreArchivo,
	 * esta Función es privada.
	 * 
	 * @param	strNombreArchivo	Es un Stirng que contiene una linea de encabezado
	 * 								dentro de la cual esta el nombre del archivo que
	 * 								se almacena.
	 ***********************************************************************/
	private void setNombreArchivo(String strNombreArchivo)
	{
		if(strNombreArchivo==null)
			return;
			
		int pos= strNombreArchivo.indexOf("filename=\"");
		
		if(pos != -1)
		{
			strRutaArchivo = strNombreArchivo.substring(pos+10,strNombreArchivo.length()-1);
			
			pos = strRutaArchivo.lastIndexOf("\\");
			
			if(pos!=-1)
				this.strNombreArchivo = strRutaArchivo.substring(pos+1);
			else
				this.strNombreArchivo = strRutaArchivo;
		}
		
	}
	
        
        /******************************************************************************
         * Función2 que coloca en los diccionarios los datos relacionados con el archivo
         * como el  contentType, a ruta del Archivo, y el archivo binario, teniendo
         * como clave el nombre del archivo.
         * 
         * @param       baosArchivo             Es un InputStream que contiene el archivo
         *                                                      en binario, que será almacenado.
         * ****************************************************************************/
        private void setArchivos2(FileItem baosArchivo)
        {
                if(strContentType.trim().length()>0 && strRutaArchivo.trim().length()>0)
                {
                        dicArchivos.put(this.strNombreArchivo,baosArchivo);
                        dicContentType.put(this.strNombreArchivo,strContentType);
                        dicRutaArchivo.put(this.strNombreArchivo,strRutaArchivo);
                }
                return;
        }
        
	/******************************************************************************
	 * Función que coloca en los diccionarios los datos relacionados con el archivo
	 * como el  contentType, a ruta del Archivo, y el archivo binario, teniendo
	 * como clave el nombre del archivo.
	 * 
	 * @param	baosArchivo		Es un ByteArrayOutputStream que contiene el archivo
	 * 							en binario, que será almacenado.
	 * ****************************************************************************/
	private void setArchivos(ByteArrayOutputStream baosArchivo)
	{
		if(strContentType.trim().length()>0 && strRutaArchivo.trim().length()>0)
		{
			dicArchivos.put(this.strNombreArchivo,baosArchivo);
			dicContentType.put(this.strNombreArchivo,strContentType);
			dicRutaArchivo.put(this.strNombreArchivo,strRutaArchivo);
		}
		return;
	}
        
        
    private void setContentType2(String strContentType)
    {
            this.strContentType = strContentType;
    }
        
	/************************************************************************
	 * Función que coloca el ContentType en la variable strContentType.
	 * 
	 * @param	strContentType	Es un String que contiene el tipo de contenido
	 * 							del archivo que se esta almacenando.
	 ***********************************************************************/
	private void setContentType(String strContentType)
	{
		if(strContentType==null)	
			return;
			
		int pos = strContentType.indexOf(": ");
		
		if(pos!=-1)
			this.strContentType = strContentType.substring(pos+2,strContentType.length());
	}
	
	/**********************************************************************
	 * Función que salva en disco los archivo que almacena en memoria, estos
	 * archivos son los que se guardan en el servidor.En caso de que no se
	 * coloque un Ruta para almacenar los archivos se colocaran en el 
	 * directorio default del servidor.
	 * 
	 * @return	Regresa un Boolean que indica si se pudieron guardar los
	 * 			lo archivos.
	 **********************************************************************/
	
	public boolean setEnDisco() throws FileNotFoundException,IOException
	{
		if(dicArchivos==null || dicArchivos.size()==0)
			return false;
		
		enumValores = dicArchivos.keys();	
		
		ByteArrayOutputStream baosArchivoBinario;
		String strNombreArchivo ="";
		
		for(int i = 0;enumValores.hasMoreElements();i++)
		{
			baosArchivoBinario = new ByteArrayOutputStream();
			strNombreArchivo = (String)enumValores.nextElement();
			baosArchivoBinario = (ByteArrayOutputStream)dicArchivos.get(strNombreArchivo);
			
			File archivo = new File((strSalvarRuta==null)?"":strSalvarRuta +strNombreArchivo);
			FileOutputStream fos = new FileOutputStream(archivo);
			fos.write(baosArchivoBinario.toByteArray());
			fos.close();
		}
			
		return true;
	}
	
        
    public FileItem getArchivoFileItem(String strNombreArchivo)
    {
        if(dicArchivos==null || dicArchivos.size()==0 || strNombreArchivo==null)
                return null;
        
        FileItem archivo = null;
        archivo = (FileItem)dicArchivos.get(strNombreArchivo);
                
        return archivo;
    }
        
	/**************************************************************************
	 * Función que regresa un archivo en bytes, especificando el nombre
	 * del archivo que se pide.
	 * 
	 * @param	strNombreArchivo	Es un String que contiene el nombre
	 * 								del archivo que se desea obtener.
	 * @return	ByteArrayOutputStream	Es el conjunto de bytes que conforman
	 * 									el archivo pedido.Encaso de que no exista
	 * 									ese nombre de archivo regresara un valor
	 * 									de null.
	 ***************************************************************************/
	
	
	
	public byte[] getArchivosBytes(String strNombreArchivo)
	{
		if(dicArchivos==null || dicArchivos.size()==0 || strNombreArchivo==null)
			return null;
		
		ByteArrayOutputStream baosArchivo = new ByteArrayOutputStream();
		baosArchivo = (ByteArrayOutputStream)dicArchivos.get(strNombreArchivo);
		byte[] byArchivo =null;
		byArchivo = baosArchivo.toByteArray();
			
		return byArchivo;
	}

    
    /**
     * 
     * @param request
     * @throws IOException
     */
    public void doUpload2(HttpServletRequest request) throws IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        
        
        Iterator iter;
        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List  items = upload.parseRequest(request);
            
            iter = items.iterator(); 

            while (iter.hasNext()) {
                FileItem item = (FileItem)iter.next();
                
                if (!item.isFormField()) {
                    setNombreArchivo2(item.getName());
                    setContentType2(item.getContentType());
                    setArchivos2(item);
                    dicCampos.put(item.getFieldName(),this.strNombreArchivo);
                } else {
                    dicCampos.put(item.getFieldName(),item.getString());
                }
            }

        } catch (FileUploadException e) {
            throw new IOException(e.getMessage());
        }
    }

	/************************************************************************
	 * Función que obtiene las parejas de campo y valor, asi como el archivo
	 * que se encuentran contenidos dentro del request que es pasado como 
	 * parámetro.
	 *
	 * @param	request		Es un objeto de tipo HttpServletRequest el cual
	 * 						contiene todos los campos con sus valores, asi como 
	 * 						el archivo que será almacenado. 
	 ***********************************************************************/
	
	 
        
	public void doUpload(HttpServletRequest request) throws IOException
	{
		ServletInputStream in = request.getInputStream();
		byte[] line = new byte[MAXLON];
		byte[] ar = new byte[MAXLON];
		int iLimite =0;
		int pos=0;
		int bandera=0;
		String strLimite="";
		String strNuevaLinea="";
		String strNombreCampo="";
		StringBuffer strbuValorCampo=null;
		ByteArrayOutputStream baosArchivoBinario=null;
		ByteArrayOutputStream baosAuxiliar=null;
		
		int iBytes = in.readLine(line,0,MAXLON);
		if(iBytes!=-1)
		{
			iLimite = iBytes -2;
			strLimite = new String(line,0,iLimite);
			dicCampos = new Hashtable();
			
			while(iBytes!=-1)
			{
				strNuevaLinea = new String(line,0,iBytes);
				
				//El componente que se analiza es el archivo agregado
				if(strNuevaLinea.startsWith("Content-Disposition: form-data; name=\""))
				{
					if(strNuevaLinea.indexOf("filename=\"")!=-1)
					{
						setNombreArchivo(new String(line,0,iBytes-2));
						
						if(strNombreArchivo==null)
							return;
						
						
						pos = strNuevaLinea.indexOf("name=\"");
						strNombreCampo = strNuevaLinea.substring(pos+6, strNuevaLinea.length() -3);
						
						pos=strNombreCampo.indexOf(";");
						
						strNombreCampo=strNombreCampo.substring(0,pos-1);
						
						dicCampos.put(strNombreCampo,strNombreArchivo);
						
						
						Object obj=dicCampos.get(strNombreCampo);
							
						iBytes = in.readLine(line,0,MAXLON);
						setContentType(new String(line,0,iBytes-2));
						
						iBytes = in.readLine(line,0,MAXLON);
						iBytes = in.readLine(line,0,MAXLON);
						strNuevaLinea = new String(line,0,iBytes);
						baosArchivoBinario = new ByteArrayOutputStream();
						baosAuxiliar = new ByteArrayOutputStream();
						
						baosAuxiliar.write(line,0,iBytes);
						
						while(iBytes!=-1 && !strNuevaLinea.startsWith(strLimite))
						{
							
							iBytes = in.readLine(line,0,MAXLON);
							
							if((iBytes == iLimite+2 || iBytes==iLimite+4) && (new String(line,0,iBytes).startsWith(strLimite)))
							{
								baosArchivoBinario.write(baosAuxiliar.toByteArray(),0,baosAuxiliar.size()-2);
							}
							else
							{
								baosArchivoBinario.write(baosAuxiliar.toByteArray(),0,baosAuxiliar.size());
							}
							strNuevaLinea = new String(line,0,iBytes);
							baosAuxiliar = new ByteArrayOutputStream();
							baosAuxiliar.write(line,0,iBytes);
						}//Fin de while(iBytes!=-1 && !strNuevaLinea.startsWith(strLimite))
						
						
						setArchivos(baosArchivoBinario);
					}
					else // Es un componente diferente a un archivo
					{
						pos = strNuevaLinea.indexOf("name=\"");
						strNombreCampo = strNuevaLinea.substring(pos+6, strNuevaLinea.length() -3);
						iBytes = in.readLine(line,0,MAXLON);
						iBytes = in.readLine(line,0,MAXLON);
						strNuevaLinea = new String(line,0,iBytes);
						strbuValorCampo = new StringBuffer(MAXLON);
						
						while(iBytes!=-1  && !strNuevaLinea.startsWith(strLimite))
						{
							iBytes = in.readLine(line,0,MAXLON);
							
							if((iBytes==iLimite+2 || iBytes==iLimite+4) && (new String(line,0,iBytes).startsWith(strLimite)))
								strbuValorCampo.append(strNuevaLinea.substring(0,strNuevaLinea.length() -2));
							else
								strbuValorCampo.append(strNuevaLinea);
						
							strNuevaLinea = new String(line,0,iBytes);
						}
						dicCampos.put(strNombreCampo,strbuValorCampo.toString());
					}
					
				}//fin de if(strNuevaLinea.startsWith("Content-Disposition: form-data; name=\""))
				
				iBytes = in.readLine(line,0,MAXLON);
				
			}//fin de while(iBytes!=-1)
			
		}//fin de if(iBytes!=-1)
		
	}//Fin de public void doUpload(HttpServletRequest request) throws IOException
	
}//Fin de public class UploadFile