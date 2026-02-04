package com.meve.sigma.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Vector; //import java.util.Vector;

//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.ibm.ws.webservices.metadata.ServerPortMetaData;
import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaCiudadano;
import com.meve.sigma.actualiza.ActualizaRemitente;
import com.meve.sigma.actualiza.ActualizaTipo_Doc;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.beans.AsuntoBean; //import com.meve.sigma.db2.DB2DataSource;
//import com.meve.sigma.sql.SQLCiudadano;
import com.meve.sigma.util.UploadFile;
import com.meve.sigma.util.Utilerias;

public class CrearAsuntoCiudadano extends HttpServlet implements Servlet {
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CrearAsuntoCiudadano() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0,
	 *      HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {

		doPost(arg0, arg1);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0,
	 *      HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {

		String strAccion = "";
		String strSolicitud = "";
		String strArchivo = "";
		String strFecha = "";
		String strFechaFol = "";
		String strIdRem = "";
		// String strTipoSol = "";
		String stridUsuario = "";// arg0.getParameter("id_ciudadano");
		String strNombre = "";// arg0.getParameter("nombre");
		String strApellidoP = "";// arg0.getParameter("AP");
		String strApellidoM = "";// arg0.getParameter("AM");
		String strOcupacion = "";// arg0.getParameter("ocupacion");
		String strMail = "";// arg0.getParameter("mail");
		String strUrl = "";
		String strSolicitud1 = "";
		String strFechaHora = "";
		String strfechaCaducidad = "";
		String strConfFolio = "";

		String itemType = "";

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"dd/MM/yyyy");
		java.util.Date f = new java.util.Date();
		strFecha = sdf.format(f);

		String strFechaIncio = Utilerias.getFechaInicio(strFecha, "", "");
		Calendar cFechaInicio = Utilerias.StringCalendar2(strFechaIncio);
		strfechaCaducidad = Utilerias.getFechaTerminacion(
				(Calendar) cFechaInicio.clone(), "10");

		String serverContentManager = "";// getInitParameter("content");

		java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat(
				"ddMMyyyy");
		java.util.Date f1 = new java.util.Date();
		strFechaFol = sdf1.format(f1);

		java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		java.util.Date f2 = new java.util.Date();
		strFechaHora = sdf2.format(f2);

		String serverMail = "";// getInitParameter("ServerMail");
		String portServer = "";// getInitParameter("PortMail");
		String serverName = "";// getInitParameter("servername");

		AsuntoBean BAsunto = new AsuntoBean();

		if (arg0.getMethod().equals("POST")) {

			UploadFile ufRegistro = new UploadFile();
			try {
				ufRegistro.doUpload(arg0);
			} catch (java.io.IOException io) {
				// System.err.println("ERROR--->"+io);
			}

			strAccion = ufRegistro.getCampo("accion");

			if (strAccion != null && strAccion.equals("guardar")) {
				System.out.println("Guardando Asunto...");
				strSolicitud = ufRegistro.getCampo("solicitud");
				strArchivo = ufRegistro.getCampo("solicitud_archivo");
				stridUsuario = ufRegistro.getCampo("id_ciudadano");
				strNombre = ufRegistro.getCampo("nombre");
				strApellidoP = ufRegistro.getCampo("AP");
				strApellidoM = ufRegistro.getCampo("AM");
				strOcupacion = ufRegistro.getCampo("ocupacion");
				strMail = ufRegistro.getCampo("mail");
				serverMail = ufRegistro.getCampo("serverM");
				portServer = ufRegistro.getCampo("portS");
				serverName = ufRegistro.getCampo("serverName");
				strUrl = ufRegistro.getCampo("url");
				strSolicitud1 = ufRegistro.getCampo("solicitud1");
				serverContentManager = ufRegistro.getCampo("cm");
				strConfFolio = ufRegistro.getCampo("confFol");
				itemType = ufRegistro.getCampo("ItemType");
				String strFolio = "fol";

				String strRespondable[][] = ActualizaUsuario
						.getCorreoNombreResponsableArea();
				String strIdRes = strRespondable[0][0];
				String strNombreRes = strRespondable[0][1];
				String strMailRes = strRespondable[0][2];
				String strAreaRes = strRespondable[0][3];

				String[][] strIdDoctos = ActualizaTipo_Doc.getIdDocto0();
				String strIdDoc = strIdDoctos[0][0];
				String strNombreTD = strIdDoctos[0][1];
				if (strArchivo.length() != 0) {

					byte archivoCiudadano[] = ufRegistro
							.getArchivosBytes(strArchivo);
					/*
					 * String sql =
					 * SQLCiudadano.insertarSolicitudConArch(strSolicitud1,
					 * strFecha, stridUsuario, strFolio, strSolicitud,
					 * strFechaHora);
					 */
					String[] strArchivos = null;
					String strContType = null;
					strArchivos = ufRegistro.getNombreArchivo();
					strContType = ufRegistro.getContentType(strArchivos[0]);
					boolean bInsertArchivo = false;

					try {
						String ultimoID = ActualizaCiudadano
								.insertarSolicitudSinArch(strSolicitud1,
										strFecha, stridUsuario, strFolio,
										strSolicitud, strFechaHora);
						String strNombreFormado = strNombre + " "
								+ strApellidoP + " " + strApellidoM;
						boolean bExisteRem = ActualizaRemitente
								.existeRemitente(strNombreFormado);
						if (bExisteRem) {
							strIdRem = ActualizaRemitente
									.getIdRemitente(strNombreFormado);
						} else {
							boolean insertaRemitente = ActualizaRemitente
									.insertarRemitenteDesdeAsunto("0", "0",
											strNombre + " " + strApellidoP
													+ " " + strApellidoM,
											strOcupacion, strMail, "0",
											strFecha);
							strIdRem = ActualizaRemitente.ultimoIdRemitente();
						}
						String idAsunto = BAsunto.guardarAsunto("1", strIdRem,
								null, strNombreTD, null, null, null, strIdDoc,
								null, strFecha, null, strfechaCaducidad, null,
								null, strSolicitud, null, null, null, null,
								null, strIdRes, "null", strNombreRes,
								strMailRes, strNombre, strMail, strAreaRes,
								"1", "0", true, serverMail, portServer,
								serverName, arg0.getContextPath(),
								strConfFolio, "1",arg0);
						String FolioGen = ActualizaAsunto
								.getFolioAsunto(idAsunto);
						boolean bActFolio = ActualizaCiudadano
								.actualizarFolioSolicitud(ultimoID, FolioGen,
										idAsunto);

						Vector v1 = new Vector();
						Vector v2 = new Vector();
						Vector v3 = new Vector();

						v3.add("");
						v3.add("");
						v3.add(archivoCiudadano);
						// System.out.println("el id del asunto es: " +
						// idAsunto);
						v2.add(idAsunto);
						v2.add(FolioGen);
						v2.add(strNombre);

						v1.add(itemType);
						// System.out.println("el nombre del archivo es: " +
						// strArchivos[0]);
						v1.add(strArchivos[0]);
						v1.add(v2);
						v1.add(strContType);
						v1.add(FolioGen + strFechaFol);
						// v1.add(CalculaNombreArchivo(""));
						v1.add(v3);

						String strUrlCM = serverContentManager
								+ "/eclient/ArchivoCM";
						if (sentToCM(v1, strUrlCM) == 0) {
							// System.err.println("Se guardo el archivo en CM");
						} else {
							// System.err.println("Exisitio un error al enviar
							// el archivo a CM");
						}

						// System.err.println("El valor del url al que se
						// redirecciona es: " + strUrl);

						arg1.sendRedirect(strUrl + ultimoID);

						// }catch(java.sql.SQLException sio){
						// //System.err.println("Error insertado
						// archivo-->"+sio);
					} catch (java.io.IOException io) {
						// System.err.println("Error de redireccion->"+io);
					}
					// ** If no se insertaron archivos ejecuta el siguiet bloque
				} else {

					/*
					 * boolean bInsertar =
					 * ActualizaCiudadano.insertarSolicitudSinArch(strSolicitud1,
					 * strFecha, stridUsuario, strFolio, strSolicitud,
					 * strFechaHora); String ultimoID1 =
					 * ActualizaCiudadano.getUltimoIdSolicitud();
					 */
					String ultimoID1 = ActualizaCiudadano
							.insertarSolicitudSinArch(strSolicitud1, strFecha,
									stridUsuario, strFolio, strSolicitud,
									strFechaHora);

					String strNombreFormado = strNombre + " " + strApellidoP
							+ " " + strApellidoM;
					boolean bExisteRem = ActualizaRemitente
							.existeRemitente(strNombreFormado);
					if (bExisteRem) {
						strIdRem = ActualizaRemitente
								.getIdRemitente(strNombreFormado);
					} else {
						boolean insertaRemitente = ActualizaRemitente
								.insertarRemitenteDesdeAsunto("0", "0",
										strNombre + " " + strApellidoP + " "
												+ strApellidoM, strOcupacion,
										strMail, "0", strFecha);
						strIdRem = ActualizaRemitente.ultimoIdRemitente();
					}
					String idAsunto = BAsunto.guardarAsunto("1", strIdRem,
							null, strNombreTD, null, null, null, strIdDoc,
							null, strFecha, null, strfechaCaducidad, null,
							null, strSolicitud, null, null, null, null, null,
							strIdRes, "null", strNombreRes, strMailRes,
							strNombre, strMail, strAreaRes, "1", "0", true,
							serverMail, portServer, serverName, arg0
									.getContextPath(), strConfFolio, "1",arg0);

					// boolean bInsertarAsunto =
					// ActualizaAsunto.InsertarAsunto()
					// String idAsunto = ActualizaAsunto.getUltimoIdAsunto();
					String FolioGen = ActualizaAsunto.getFolioAsunto(idAsunto);
					// boolean bActFolio =
					// ActualizaCiudadano.actualizarFolioSolicitud(ultimoID,
					// FolioGen);

					boolean bActFolio1 = ActualizaCiudadano
							.actualizarFolioSolicitud(ultimoID1, FolioGen,
									idAsunto);
					try {
						arg1.sendRedirect(strUrl + ultimoID1);

					} catch (java.io.IOException io) {
						// System.err.println("Error de redireccion->"+io);
					}
				}
			}
		}
	}

	/**
	 * Verifica el estatus del servicion de content services.
	 * 
	 * @param strfolio
	 *            Folio del asunto
	 * @return la cadena que contiene el nombre del archivo
	 */
	private String CalculaNombreArchivo(String strfolio) {
		Calendar cCal = Calendar.getInstance();
		String strComplemento = "";
		strComplemento = "" + cCal.get(5) + (cCal.get(2) + 1) + cCal.get(1)
				+ cCal.get(11) + cCal.get(12) + cCal.get(14);

		if (strfolio != null && strfolio.trim().length() > 0) {
			return strfolio + "_" + strComplemento;
		} else {
			return strComplemento;
		}
	}

	private int sentToCM(Vector v1, String strUrl) {
		int res = 0;
		try {
			URL direccion = new URL(strUrl);
			URLConnection conexion = direccion.openConnection();
			conexion.setUseCaches(false);
			conexion.setDoOutput(true);
			ByteArrayOutputStream bs = new ByteArrayOutputStream(1512);
			ObjectOutputStream salida = new ObjectOutputStream(bs);
			salida.writeObject(v1);
			// //System.out.println("AppletGestion -----> Envio Vectores....");
			conexion.setRequestProperty("Content-Length", String.valueOf(bs
					.size()));
			conexion.setRequestProperty("Content-Type",
					"application/x-java-serialized-object");
			bs.writeTo(conexion.getOutputStream());

			// //System.out.println("AppletGestion -----> Envio Vectores....");
			ObjectInputStream entrada = new ObjectInputStream(conexion
					.getInputStream());
			// if(entrada==null)
			// //System.err.println("la entrada es null");
			// else
			// //System.err.println("la entrada no es null");
			String strMensaje = (String) entrada.readObject();

			entrada.close();

			if (strMensaje != null && strMensaje.trim().length() > 0) {
				// this.setVisible(true);
				// res= JOptionPane.showConfirmDialog( new
				// JFrame(),strMensaje,"Information",
				// JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,
				// null );
				res = 0;
			}
		} catch (Exception e) {
			// System.err.println("CrearAsuntoCuidadano --> sentoCM --> Error
			// --> " + e.toString());
			res = -1;
		}

		return res;
	}
}