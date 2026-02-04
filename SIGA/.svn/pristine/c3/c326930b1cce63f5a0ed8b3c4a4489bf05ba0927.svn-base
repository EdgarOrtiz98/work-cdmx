/*
 * Creado el 1/02/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.servlet;

import java.sql.SQLException;
import java.util.*;

import com.meve.oracle.cm.ConnectionWebService;
import com.meve.oracle.cm.WsConnection;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLBuscar;
import com.meve.sigma.servlet.SearchArchive;

/**
 * Busqueda de archivos por contenido
 * 
 * @author Meve Soluciones
 *  
 */
public class SearchArchiveByContent {

	String strUriContent;

	String strUserContet;

	String strPassContent;

	String strPathContent;

	/**
	 * Busca por contenidos
	 * 
	 * @param strContenido
	 *            cadena que contiene el criterio a buscar
	 * @param strFolio
	 *            Folio de asunto
	 * @param area
	 *            Area del asunto
	 * @param strUriContent
	 *            Url para ivocar al ws de OCS
	 * @param strUserContet
	 *            Usuario de content
	 * @param strPassContent
	 *            Password de content
	 * @param strPathContent
	 *            Ruta del espacio de trabajo del CS
	 * @param strTipoBusqueda
	 * @return Regresa una lista con las coincidencias
	 */
	public static String[] searchByContent1(String strContenido,
			String[][] strFolio, String area, String strUriContent,
			String strUserContet, String strPassContent, String strPathContent,
			String strTipoBusqueda) {

		String[] strResultados = null;
		Vector vecResultado = new Vector();
		try {
			// authenticate to content services
			ConnectionWebService c = new ConnectionWebService(strUriContent,
					strUserContet, strPassContent);
			WsConnection s_WsCon = c.conectaOcs();

			try {
				if (strFolio.length > 0) {
					
					for (int i = 0; i < strFolio.length; i++) {
						////System.out.println("       " + strFolio[i][0] + "    " + strFolio[i][12] + "    " +strTipoBusqueda);
						////System.out.println("Datos para la busqueda "+ strFolio[i][0] + " " + strContenido + " " + strFolio[i][12]);
						
						if (strTipoBusqueda.equals("A")) {
							strResultados = SearchArchive
									.busquedaSobroContenidos(strFolio[i][12], strContenido,
											strFolio[i][0], strUriContent,
											strUserContet, strPassContent,
											strPathContent, s_WsCon);

						} else if (strTipoBusqueda.equals("I")) {
							strResultados = SearchArchive
									.busquedaSobroContenidos(strFolio[i][16], strContenido,
											strFolio[i][17], strUriContent,
											strUserContet, strPassContent,
											strPathContent, s_WsCon);

						}

						if (strResultados != null) {

							////System.out.println("archives " + strResultados.length);
							for (int j = 0; j < strResultados.length; j++) {

								////System.out.println("Archivos entrantes ... " + strResultados[j]);
								vecResultado.add(strResultados[j]);
							}

						}

					}
				//	System.out.println(vecResultado.size());

				}
			} finally {

				s_WsCon.logout();
			}
		} catch (Throwable e) {

		}
		if (vecResultado != null && vecResultado.size()>0) {

			strResultados = new String[vecResultado.size()];

			for (int k = 0; k < vecResultado.size(); k++) {
				//strResultados[k] = vecResultado.get(k).toString();
				if (vecResultado.get(k)!=null){
					strResultados[k] = (String)vecResultado.get(k);
				}else{
					strResultados[k] = "";
				}
			//	//System.out.println("++++"+strResultados[k]+"++++");
			}
		}
		return strResultados;

	}

	/**
	 * Busca por contenidos
	 * 
	 * @param strContenido
	 *            cadena que contiene el criterio a buscar
	 * @param strUsuarioSiga
	 *            Usuario siga
	 * @param strAreaSiga
	 *            Area siga
	 * @param strUriContent
	 *            Url para ivocar al ws de OCS
	 * @param strUserContet
	 *            Usuario de content
	 * @param strPassContent
	 *            Password de content
	 * @param strPathContent
	 *            Ruta del espacio de trabajo del CS
	 * @return Regresa una lista con las coincidencias
	 */
	public static String[] searchByContent(String strContenido,
			String strUsuarioSiga, String strAreaSiga, String strUriContent,
			String strUserContet, String strPassContent, String strPathContent) {

		String strFolder[][] = null;
		String[] strResultados = null;
		Vector vecResultado = new Vector();

		String sqlAsuntos = SQLBuscar.getAsuntosUsuario(strUsuarioSiga,
				strAreaSiga);
		System.out.println(sqlAsuntos);

		try {
			strFolder = ConexionDS.ejecutarSQL(sqlAsuntos);

		} catch (SQLException sqle) {

			//System.out.println("ERROR:" + sqle.getMessage());
			sqle.printStackTrace();
		}
		System.out.println(strFolder.length);
		try {
			// authenticate to content services
			ConnectionWebService c = new ConnectionWebService(strUriContent,
					strUserContet, strPassContent);
			WsConnection s_WsCon = c.conectaOcs();

			try {
				if (strFolder.length > 0) {

					for (int i = 0; i < strFolder.length; i++) {

					//	//System.out.println("Datos para la busqueda "+ strFolder[i][0] + " " + strContenido + " "+ strFolder[i][2]);

					//	//System.out.println(" *** " + strFolder[i][0]);
					//	//System.out.println(" *** " + strFolder[i][2]);
					//	//System.out.println(" *** " + strAreaSiga);

						strResultados = SearchArchive.busquedaSobroContenidos(
								strFolder[i][0], strContenido, strFolder[i][2],
								strUriContent, strUserContet, strPassContent,
								strPathContent, s_WsCon);

						if (strResultados != null) {

						//	//System.out.println("archives "+ strResultados.length);
							for (int j = 0; j < strResultados.length; j++) {

							//	//System.out.println("Archivos entrantes ... "+ strResultados[j]);
								vecResultado.addElement(strResultados[j]);
							}

						}

					}
				//	System.out.println(vecResultado.size());

				}
			} finally {

				s_WsCon.logout();
			}
		} catch (Throwable e) {

		}

		if (vecResultado != null) {

			strResultados = new String[vecResultado.size()];

			for (int k = 0; k < vecResultado.size(); k++) {
				strResultados[k] = vecResultado.get(k).toString();
			}
		}
		return strResultados;
	}

	/**
	 * Busca el folio de asunto
	 * 
	 * @param strNombreArchivo
	 *            Nombre del archivostrNombreArchivo
	 * 
	 * @return regresa un arreglo con el folio del documento
	 *  
	 */

	public static String[] searchIdFolioAsunto(String strNombreArchivo) {

		String[][] strId = null;
		String[][] strFolio = null;
		String[] strIdFolio = new String[2];
		String sqlFolios = null;

		String sqlAsuntos = SQLBuscar.getIdAsunto(strNombreArchivo);

		try {
			strId = ConexionDS.ejecutarSQL(sqlAsuntos);
			sqlFolios = SQLBuscar.getAsuntoId(strId[0][0]);
			strFolio = ConexionDS.ejecutarSQL(sqlFolios);

			strIdFolio[0] = strId[0][0];
			strIdFolio[1] = strFolio[0][0];

			return strIdFolio;

		} catch (SQLException sqle) {

			//System.out.println("ERROR:" + sqle.getMessage());
			sqle.printStackTrace();
		}

		return strIdFolio;

	}

}

