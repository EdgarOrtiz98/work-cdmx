package com.meve.sigma.servlet;

import java.io.*;
import java.util.Vector;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.meve.sigma.db2.DB2DataSource;
import com.meve.sigma.sql.SQLArchivo;

public class ArchivoCM extends HttpServlet implements Servlet {
	/* (non-Java-doc)                        
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ArchivoCM() {   
		//super(); 
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		ObjectInputStream entrada = new ObjectInputStream(arg0.getInputStream());
        Vector vParametros = new Vector();
        try
        {
            vParametros = (Vector)entrada.readObject();
        }
        catch(ClassNotFoundException x)
        {
            //System.err.println("ArchivosCM.java:" + x);
        }
        catch(Exception e)
        {
            //System.err.println("ArchivosCM.java:" + e);
        }
        entrada.close();
        
        java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
		java.util.Date f 				=	new java.util.Date();
		String strFechaCreacion			=	sdf.format(f);
		
		String strMensaje = "";
        String strIdDocto = "";
        String strFolio = "";
        String strItemType = "";
        String strUsuario = "";
        strItemType = (String)vParametros.elementAt(0);
        if(strItemType != null && strItemType.length() > 0)
        {
            String strNombreArchivo = (String)vParametros.elementAt(1);
            Vector vAtributos = (Vector)vParametros.elementAt(2);
            if(vAtributos.size() > 0)
            {
                strIdDocto = (String)vAtributos.elementAt(0);
                strFolio = (String)vAtributos.elementAt(1);
                if(vAtributos.size() >= 3)
                    strUsuario = (String)vAtributos.elementAt(2);
            }
            String strContentType = (String)vParametros.elementAt(3);
            String strIdArchivo = (String)vParametros.elementAt(4);
            Vector vArchivos = (Vector)vParametros.elementAt(5);
            String strOcr = (String)vArchivos.elementAt(0);
            String strIdOcr = (String)vArchivos.elementAt(1);
            byte btArchivo[] = (byte[])vArchivos.elementAt(2);
            String strOcrImagen = "";
            if(strOcr.trim().length() > 0)
                strOcrImagen = (String)vArchivos.elementAt(3);
            strNombreArchivo = strNombreArchivo.replace('\'', ' ');


            String attrsString = "'IdArchivo'='" + strIdArchivo + "' 'ContentType'='" + strContentType + "' 'NombreArchivo'='" + strFolio + "_" + strNombreArchivo + "' 'IdDocumento'='" + strIdDocto + "' 'Usuario'='" + strUsuario + "'";
            
            //** el documento es preparado para ser guardado a la base de datos
            ////System.out.println("Inserta Archivo en tabla");
		    boolean bInsertArchivo = false;
		    //String[] strArchivos=null; 				 		
			//strArchivos = ufRegistro.getNombreArchivo();
			if(btArchivo!=null && btArchivo.length>0) 
			{							
				//System.out.println(btArchivo[0]);
				//byte arreglo[] = (byte[])vArchivos.elementAt(2);//ufRegistro.getArchivosBytes(strArchivos[0]);
				try{
				bInsertArchivo =DB2DataSource.insertaBlob(SQLArchivo.getInsertaArchivo(strNombreArchivo,
																strContentType,
																strIdDocto, "0",
																strUsuario, 
				        										strFechaCreacion),btArchivo);
				}catch(Exception e){
				    //System.err.println("error->"+e);
				}
				////System.out.println("Insertando Archivo");
			}
			//** fin el documento es preparado para ser guardado a la base de datos
			
        } else
        {
            strMensaje = "No existe el Item Type...";
        }
        arg1.setContentType("application/x-java-serialized-object");
        ObjectOutputStream salida = new ObjectOutputStream(arg1.getOutputStream());
        salida.writeObject(strMensaje);
        salida.close();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doGet(arg0, arg1);
	}

}