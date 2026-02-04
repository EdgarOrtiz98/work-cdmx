package com.meve.sigma.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.db2.ConexionDocs;
import com.meve.sigma.db2.DB2DataSource;
import com.meve.sigma.parametros.ParametrosForm;
import com.meve.sigma.parametros.dao.ParametrosDao;
import com.meve.sigma.sql.SQLArchivo;
import com.meve.sigma.sql.SQLDocs;
import com.meve.sigma.util.UploadFile;
import com.meve.sigma.util.Utilerias;

import oracle.jdbc.OracleConnection;

import java.io.InputStream;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class UploadArchivo extends HttpServlet implements Servlet {

	// property object
	String strUriContent;
	String strUserContet;
	String strPassContent;
	String strPathContent;
	String strActiCont;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public UploadArchivo() {
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
	protected void doPost(HttpServletRequest arg0, HttpServletResponse response)
			throws ServletException, IOException {

		if (arg0.getMethod().equals("POST")) {
			
			String[] configContent = new String[3];

			try {

				strUriContent = getServletConfig().getServletContext()
						.getInitParameter("content");
				strUserContet = getServletConfig().getServletContext()
						.getInitParameter("user");
				strPassContent = getServletConfig().getServletContext()
						.getInitParameter("passwd");
				strPathContent = getServletConfig().getServletContext()
						.getInitParameter("path");
				strActiCont=getServletConfig().getServletContext().getInitParameter("ActivarContent");
				// //System.out.println(" <------->" +strUriContent + " " +
				// strUserContet + " " + strPassContent);

			} catch (Exception e) {
				// System.err.println(e.toString());

			}

			UsuarioBean BUsuario = (UsuarioBean) arg0.getSession()
					.getAttribute("UsuarioBean");
			UploadFile ufRegistro = new UploadFile();
			
			try {
				if (strActiCont.equals("si")) {
					ufRegistro.doUpload2(arg0);
				}
				else{
					ufRegistro.doUpload(arg0);
				}
			} catch (java.io.IOException io) {
				System.err.println("ERROR--->" + io);
			}

			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			java.util.Date f = new java.util.Date();
			String strFechaCreacion = sdf.format(f);

			String strAccion = ufRegistro.getCampo("accion");
			String strActivarCM = ufRegistro.getCampo("ActivarCM");
			String strBase = ufRegistro.getCampo("Ruta");
			
			if (strAccion.equalsIgnoreCase("guardar")) {
				String strIdAsunto = ufRegistro.getCampo("IdAsunto");
				// String strIdInst = (ufRegistro.getCampo("id_ins")==
				// null)?"-1":ufRegistro.getCampo("id_ins");//
				String strIdInst = (ufRegistro.getCampo("id_ins") == null || ufRegistro
						.getCampo("id_ins").equals("")) ? "-1" : ufRegistro
						.getCampo("id_ins");
				String a1 = ufRegistro.getCampo("a1");
				String strUrl = ufRegistro.getCampo("url");
				String serverContentManager = ufRegistro.getCampo("cm");
				String strRutaArchivo = ufRegistro.getCampo("rutaArchivo");
				String strArchivo = ufRegistro.getCampo("solicitud_archivo");
				String srtTypeDoc = ufRegistro.getCampo("optionDoc");
				String strIdUsuari = ufRegistro.getCampo("idUsuario");
				String strFolio = ufRegistro.getCampo("Folio");
				String itemType = ufRegistro.getCampo("ItemType");
				String server = ufRegistro.getCampo("server");
				String uri = ufRegistro.getCampo("uri");
				String retURI = ufRegistro.getCampo("retURI");
				String url = "";
				String strMessage = "";
				String name = "";
				//System.out.println("*****instrucción******");				
				if (a1.equals("1")) {
					url = uri + "?Folio=" + strFolio + "&IdAsunto="
							+ strIdAsunto + "&a=1&retURI="
							+ Utilerias.codificaPostHTML(retURI);
				} else if (a1.equals("2")) {
					url = uri + "?Folio=" + strFolio + "&IdAsunto="
							+ strIdAsunto + "&a=2&id_ins=" + strIdInst
							+ "&retURI=" + Utilerias.codificaPostHTML(retURI);
				} else if (a1.equals("3")) {
					url = uri + "?Folio=" + strFolio + "&IdAsunto="
							+ strIdAsunto + "&a=3&id_ins=" + strIdInst
							+ "&retURI=" + Utilerias.codificaPostHTML(retURI);
				} else if (a1.equals("4")) {
					url = uri + "?Folio=" + strFolio + "&IdAsunto="
							+ strIdAsunto + "&a=4" + "&retURI="
							+ Utilerias.codificaPostHTML(retURI);
				} else if (a1.equals("5")) {
					url = uri + "?Folio=" + strFolio + "&IdAsunto="
							+ strIdAsunto + "&a=5&id_ins=" + strIdInst
							+ "&retURI=" + Utilerias.codificaPostHTML(retURI);
				}
				if (strActivarCM.equals("si")) {
					String bArchive = "";
					// ** Content de Oracle **//					
					FileItem flujoArchivo = ufRegistro.getArchivoFileItem(strArchivo);

					if (flujoArchivo.getSize() > 0) {
						String[] strArchivos = null;
						String strContType = null;
						strArchivos = ufRegistro.getNombreArchivo();
						strContType = ufRegistro.getContentType(strArchivos[0]);
						// **Guarda registro en la tabla SD_CONTENT_ORACLE
						String strIdArchivo = "";
						String strFolderCont = "";
						int r = 0;
						String[][] result = null;
						String[][] strRol = null;
						String intIdAsunto = null;
						String intIdInst = null;
						String intIdUsu = null;
						// String bArchive = "";

						try {
							if (!strIdInst.equals("-1"))
								strIdUsuari = ActualizaInstrucciones
										.getIdUsuarioInstruccion(strIdInst);

							String strSqlC = "SELECT ID_ASUNTO, ID_INSTRUCCION_ASUNTO, INS_USUARIO FROM SD_INSTRUCCION_ASUNTO "
									+ "WHERE ID_ASUNTO ="
									+ strIdAsunto
									+ " AND INS_USUARIO = " + strIdUsuari;

							result = ConexionDS.ejecutarSQL(strSqlC);
							// System.out.println("Consulta nueva " + strSqlC );

							if (result.length > 0) {
								intIdAsunto = result[0][0];
								// intIdInst = result[0][1];
								intIdInst = strIdInst;
								intIdUsu = result[0][2];

							} else {

								intIdAsunto = strIdUsuari;
								intIdInst = "-1";
								intIdUsu = strIdUsuari;

							}

							String strSqlRol = "SELECT ID_ROL FROM SD_USUARIO_ROL WHERE ID_USUARIO1 = "
									+ strIdUsuari;
							strRol = ConexionDS.ejecutarSQL(strSqlRol);
							// Verifica rol de asistente
							if (strRol[0][0].equals("6")) {
								intIdInst = strIdInst;
							}
							String strResult[][] = ConexionDS
									.ejecutarSQL("SELECT MAX(ID_REFERENCIA) FROM SD_CONTENT_ORACLE");
							if (strResult != null && strResult.length > 0)
								strIdArchivo = strResult[0][0];
							else
								strIdArchivo = "";

							String strFolder[][] = ConexionDS
									.ejecutarSQL("SELECT ASU_FOLIO_RECEPCION FROM SD_ASUNTO WHERE ID_ASUNTO = "
											+ strIdAsunto);
							if (strResult != null && strResult.length > 0)
								strFolderCont = strFolder[0][0];
							else
								strIdArchivo = "";
                                                                
                                                        //strFolderCont = strIdAsunto;//Despues de eliminar el content no se generaba nombre de folder.        

						} catch (SQLException sqle) {
							sqle.printStackTrace();
						}
						/*bArchive = Dos.guardar(flujoArchivo, strArchivos[0],
								strIdArchivo + 1, strFolderCont, strIdAsunto,
								strUriContent, strUserContet, strPassContent,
								strPathContent);
						if (bArchive.equals("success")) {*/
							try {
								//Mike
                                                                Boolean lbln_ins = false;
                                                                System.out.println("flujoArchivo.getSize(): "+flujoArchivo.getSize());
                                                                List<ParametrosForm> llst_param = null;
                                                                long lon_fileSize = 52428800;
                                                                try{
                                                                	Connection con=null;
                                                                	con = ConexionDS.getConexion();
                                                                    llst_param = ParametrosDao.getParametros(con);
                                                                        for(ParametrosForm parametro: llst_param) {
                                                                            if(parametro.getParametroId().equals("app.siga.SizeFile")) {
                                                                                lon_fileSize = Long.parseLong(parametro.getParametroValor());
                                                                            }
                                                                        }
                                                                        ConexionDS.cerrarConexion(con);
                                                                }catch(Exception e){
                                                                	e.printStackTrace();
                                                                }
                                                                    
                                                            if(flujoArchivo.getSize()<=lon_fileSize){
                                                                if(!DB2DataSource.ExisteArc(strArchivos[0],strIdAsunto)){
                                                                    String[][] referencia = ConexionDS.ejecutarSQL("SELECT SD_REFERENCIA_SEQ.NEXTVAL FROM DUAL"); 
                                                                    try{//inserta docuemnto en base de datos
                                                                        lbln_ins = ConexionDocs.insertaBlob(SQLDocs.insArchivo(referencia[0][0],strIdAsunto,strArchivos[0],strFolderCont),flujoArchivo.get());                                                                
                                                                    }catch(Exception e){
                                                                    	System.out.println(e.getMessage());
                                                                    }
                                                                    if(lbln_ins==true){
                                                                    String strSql = "INSERT INTO SD_CONTENT_ORACLE(ID_REFERENCIA, ID_ASUNTO_CONTENT, ID_USUARIO_CONTENT, ID_INS_CONTENT, NOMBRE_ARCHIVO, CONTENT_TYPE,TIPO_DOCUMENTO) VALUES"
                                                                                    +" ('"
                                                                                    + referencia[0][0]
                                                                                    +"', "
                                                                                    + strIdAsunto
                                                                                    + ", "
                                                                                    + intIdUsu
                                                                                    + ", "
                                                                                    + intIdInst
                                                                                    + ", '"
                                                                                    + strArchivos[0]
                                                                                    + "', '"
                                                                                    + strContType
                                                                                    + "','"
                                                                                    + srtTypeDoc + "')";
                                                                    r = ConexionDS.ejecutarActualizacion(strSql);
                                                                    }
                                                                }else{url=url+"&arcrep=1";}//if existe archivo
                                                            }else{url=url+"&arcbig=1";}// archivo mas grande a 50Mb.
							} catch (SQLException sqle) {
								sqle.printStackTrace();
							}

						/*} else {
							if (strArchivos[0].length() > 0) {
								name = strArchivos[0];
							} else {
								name = "";
							}
							strMessage = "s";
							response.sendRedirect(url + "&mess=" + strMessage
									+ "&name=" + name + "&excp=" + bArchive);
							return;
						}*/
					} else {
						strMessage = "s";
						bArchive = "java.io.FileNotFoundException";
						response.sendRedirect(url + "&excp=" + bArchive
								+ "&mess=" + strMessage);
						return;
					}
					response.sendRedirect(url + "&excp=" + bArchive + "&mess="
							+ strMessage);

				}else{
					// //System.out.println("Inserta Archivo en tabla");
					boolean bInsertArchivo = false;
					String[] strArchivos = null;
					strArchivos = ufRegistro.getNombreArchivo();
					if (strArchivos != null && strArchivos.length > 0) {						
							byte arreglo[] = ufRegistro.getArchivosBytes(strArchivos[0]);
							try {
								if (!DB2DataSource.ExisteArc(strArchivos[0],strIdAsunto)){
									bInsertArchivo = DB2DataSource
											.insertaBlob(SQLArchivo.getInsertaArchivo(
																	strArchivos[0],
																	ufRegistro.getContentType(strArchivos[0]),
																	strIdAsunto,
																	strIdInst,
																	BUsuario.getIdUsuario(),
																	srtTypeDoc),
													arreglo);
									response.sendRedirect(url);
								}
								else{
									//System.out.println("ya existe="+url+ "&excp=yaexistearchivo&mess=s&name="+strArchivos[0]);
                                                                        response.sendRedirect(url+ "&excp=yaexistearchivo&mess=s&name="+strArchivos[0]);
											
								}
							} catch (Exception e) {
							}
					}					
				}
			}
		}
	}

}