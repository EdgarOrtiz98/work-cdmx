package com.meve.sigma.servlet;

import java.io.FileWriter;

import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import java.io.*;

import com.meve.sigma.reportes.ActualizaComentario;
import com.meve.sigma.util.*;

import com.meve.sigma.actualiza.*;

public class AsuntoWord extends HttpServlet implements Servlet {
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
    private String strNombreAsunto=""; 
    private String strIdAsunto="";
    String[][] strValores=null;
	String[][] strDest=null;
	String[][] strUbi=null;
	String[][] strClas=null;
	String strCaptu = "";
	String[][] strHistorial = null;
	String[][] strExpediente = null;
    
	public AsuntoWord() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    //String strMachoteAsunto = getInitParameter("machoteAsunto");
	    strIdAsunto = (arg0.getParameter("id")==null)?"":arg0.getParameter("id");
		if(strIdAsunto.length()>0){
		strValores=ActualizaAsuntoTurnado.getAsuntoTurnado(strIdAsunto);
		if(strValores!=null && strValores.length>0 && strValores[0].length>35){
			strDest = ActualizaUsuario.getNombreCargoAreaUsr(strValores[0][32]);
			strUbi = ActualizaUbicacion.getNombreUbicacion(strValores[0][8]);
			//strClas = ActualizaClasificacion.getNombreTipoClasificacion(strValores[0][12]);//
			strCaptu  = ActualizaUsuario.NombreUsuario(strValores[0][24]);
			strHistorial = ActualizaComentario.getDatosComentarios(strIdAsunto);
			
			if(strValores[0][6].length()!=0){
				strExpediente = ActualizaExpediente.getNombreExpediente(strValores[0][6]);
			}
		}
		try{
			SAXBuilder saxobj = new SAXBuilder();

			//Document doc= saxobj.build(strMachoteAsunto);
			Document doc= saxobj.build(getServletConfig().getServletContext().getResourceAsStream("/WEB-INF/AsuntoXmlTemplate.xml"));
			
			Element root = doc.getRootElement();
			exploreNode(root);
			Calendar cCal = Calendar.getInstance();
	        String strComplemento = "" + cCal.get(5) + (cCal.get(2) + 1) + cCal.get(1) + cCal.get(11) + cCal.get(12) + cCal.get(14);
			File temp = File.createTempFile("Asunto_"+strComplemento, ".tmp");
			FileWriter fw = new FileWriter(temp);
			XMLOutputter op = new XMLOutputter();
			op.setFormat(op.getFormat().setEncoding("iso-8859-1"));
			op.output(doc,fw);
			fw.close(); 
			//arg1.setContentType("text/xml");
			arg1.setContentType("application/msword");
			arg1.setHeader("Content-Disposition", "filename=\"" + strNombreAsunto + ".doc\"");
			BufferedReader in = new BufferedReader(new FileReader(temp));
	        String str;
	        PrintWriter pw = arg1.getWriter();
	        while ((str = in.readLine()) != null) { 
	            pw.write(str);
	        }
	        in.close();			
			temp.delete();
		}catch(Exception e){
			//System.err.println(e.toString());
		}
		}
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doGet(arg0, arg1);
	}
	
	private void exploreNode(Element node){
		
		
		//strClas[0][0]="Publica"; // sale de una consulta por el campo strValores[0][12]
		//strUbi[0][0]="La quemada No. 226 Col. Narvarte"; //sale de una consulta por el campo strValores[0][8]
		//strDest[0][0]="david contreras"; //salen de una consulta por el campo strValores[0][36]
		//strDest[0][1]="Consultor";
		//strDest[0][2]="Java";
		//strCaptu[0][0]="jorge venegas"; //sale de una consulta por el campo strValores[0][24]
        //strHistorial[0][0] = "Pruebas historial Asunto Test 29Nov";
        //strHistorial[0][1] = "2005-11-29 10:44:46.0";
		/*strValores[0][0]="2"; //ASU_ENTIDAD
		strValores[0][1]="null"; //ASU_ENTIDAD_OTRO
		strValores[0][2]="1"; //ASU_REMITENTE
		strValores[0][3]="Pedro Perez"; //ASU_REMITENTE_OTRO
		strValores[0][4]="null"; //ASU_FIRMANTE
		strValores[0][5]="Test29Nov"; //ASU_DESCRIPCION
		strValores[0][6]="null"; //ASU_EXPEDIENTE
		strValores[0][7]="null"; //ASU_EXPEDIENTE_OTRO
		strValores[0][8]="0"; //ASU_UBICACION
		strValores[0][9]="null"; //ASU_REF_EXPEDIENTE
		strValores[0][10]="1";  //ASU_TIP_DOCTO
		strValores[0][11]="null"; //ASU_TIP_DOCTO_OTRO
		strValores[0][12]="1"; //ASU_CATEGORIA
		strValores[0][13]="null"; //ASU_FECHA_RECEPCION
		strValores[0][14]="null"; //ASU_FECHA_DOCTO
		strValores[0][15]="null"; //ASU_FECHA_CADUCIDAD
		strValores[0][16]="null"; //ASU_FOLIO_EXTERNO
		strValores[0][17]="null"; //ASU_FOLIO_INTERMEDIO
		strValores[0][18]="asfsadfsd"; //ASU_SINTESIS
		strValores[0][19]="sdfasdsdfasdf";//ASU_COMENTARIOS
		strValores[0][20]="null"; //ASU_PALABRA_CLAVE
		strValores[0][21]="null"; //ASU_REF_ASUNTO_ANTERIOR
		strValores[0][22]="1"; //ASU_PRIORIDAD
		strValores[0][23]="OF-Jav-00001"; //ASU_FOLIO_RECEPCION
		strValores[0][24]="2"; //ASU_USUARIO_CAPTURA
		strValores[0][25]="2005-11-29"; //ASU_FECHA_CAPTURA
		strValores[0][26]="1"; //ASU_AREA_RECEPCION
		strValores[0][27]="1"; //ASU_TIPO_ASUNTO
		strValores[0][28]="2"; //ASU_ESTATUS
		strValores[0][29]="50.0"; //ASU_AVANCE
		strValores[0][30]="Java2"; //ENT_NOMBRE
		strValores[0][31]="Mensajero";//RMT_CARGO
		strValores[0][32]="rodrigo.soto@meve.com";//RMT_CORREO
		strValores[0][33]="Pedro Perez"; //RMT_NOMBRE
		strValores[0][34]="Oficio"; //TIP_DOCTO_NOMBRE
		strValores[0][35]="Alta";//PRI_NOMBRE
		strValores[0][36]="3"; //ASU_USR_TURNA
		strValores[0][37]="1"; //USU_AREA
		strValores[0][38]="0"; //ASU_CONTROL*/
		
		String strValor="";
		 
		
		if(node.getName().equalsIgnoreCase("fldSimple")){
		    
		   if(((String)node.getValue()).trim().equalsIgnoreCase("cmpcapturado")){
		        strValor = strCaptu.trim() + " - " +Utilerias.formatearFechas(strValores[0][25] );
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpestatus")){
		        
		        /*
				 * 0 - 
				 * 1 - Recepcion
				 * 2 - Turnado
				 * 3 - Terminado
				 */
		        if(strValores[0][28].trim().equalsIgnoreCase("0")){
		            strValor = "";
		        }else if(strValores[0][28].trim().equalsIgnoreCase("1")){
		            strValor = "Recepcion";
		        }else if(strValores[0][28].trim().equalsIgnoreCase("2")){
		            strValor = "Turnado";
		        }else if(strValores[0][28].trim().equalsIgnoreCase("3")){
		            strValor = "Terminado";
		        }
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpfoliorecepcion")){
		        strValor = strValores[0][23];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpentidad")){
		        strValor = (strValores[0][30].length()==0)?strValores[0][1]:strValores[0][30];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpremitente")){
		        strValor = (strValores[0][33].length()==0)?strValores[0][3]:strValores[0][33];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpcargo")){
		        strValor = strValores[0][31];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpcorreo")){
		        strValor = strValores[0][32];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpfirmante")){
		        strValor = strValores[0][4];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpdestinatario")){
		        strValor = strDest[0][0];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpcargodes")){
		        strValor = strDest[0][1];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpareades")){
		        strValor = strDest[0][2];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpasunto")){
		        strValor = strValores[0][5];
		        strNombreAsunto = strValor;
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpexpediente")){
		        strValor = (strValores[0][6].length()==0)?strValores[0][7]:strExpediente[0][0];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpubicacion")){
		        strValor = strUbi[0][0];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpreferencia")){
		        strValor = strValores[0][9];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmptipodocumento")){
		        strValor = (strValores[0][34].length()==0)?strValores[0][11]:strValores[0][34];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpclasificacion")){
		        strValor = "";//strClas[0][0];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpfecharecepcion")){
		        strValor = strValores[0][13];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpfechadocumento")){
		        strValor = strValores[0][14];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpfolioexterno")){
		        strValor = strValores[0][16];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpfechacaducidad")){
		        strValor = strValores[0][15];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpfoliointermedio")){
		        strValor = strValores[0][17];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpsintesis")){
		        strValor = strValores[0][18];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpcomentarios")){
		        strValor = strValores[0][19];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmppalabras")){
		        strValor = strValores[0][20];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpfolioturnado")){
		        strValor = "";
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpareaturna")){
		        strValor = "";
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpprioridad")){
		        strValor = strValores[0][35];
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpturnado")){
		        strValor = "Ninguno";
		    }else if(node.getValue().trim().equalsIgnoreCase("cmpcomentarioshistorial")){
		        strValor="";
		        for(int i=0; i<strHistorial.length;i++){
		            strValor+=strHistorial[i][1]+"   " + strHistorial[i][0] + "   ";
		        }
		    }
		    
		    
		    List hijos = node.getChildren();
		    Iterator ite = hijos.iterator();
		    while(ite.hasNext()){
		        exploreChilds((Element)ite.next(),strValor);
		    }
		}
		
		List children = node.getChildren();
		for(int i=0;i<children.size();i++){
			exploreNode((Element)children.get(i));
		}
	}
	
	private void exploreChilds(Element node,String strValor){
	    if(node.getName().equalsIgnoreCase("t")){
	        node.removeContent();
		    node.addContent(strValor);
		    
		    List hijos = node.getChildren();
		    Iterator ite = hijos.iterator();
		    while(ite.hasNext()){
		        exploreNode((Element)ite.next());
		    }
		}
	    
	    List children = node.getChildren();
		for(int i=0;i<children.size();i++){
			exploreChilds((Element)children.get(i),strValor);
		}
	}

}