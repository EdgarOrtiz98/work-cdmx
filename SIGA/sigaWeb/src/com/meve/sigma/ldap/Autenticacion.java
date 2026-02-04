package com.meve.sigma.ldap;

//import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;

import com.meve.sigma.actualiza.ActualizaBitacora;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.beans.AreaBean;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLAutentificacion;
import com.meve.sigma.sql.SQLLdap;

/**
 * Clase que contiene metodos de para el Acceso y Autenticacion de los usuarios
 * de SISAP al LDAP configurado.
 * 
 * @author Gustavo Gonzalez Esquivel gustavo_g_e@hotmail.com
 * @version 1.0
 */
public class Autenticacion {

	/**
	 * Constructor for Autenticacion.
	 */
	public static int AUTENTICADO = 1;
	public static int CREDENCIALES_INVALIDAS = 2;
	public static int ERROR_CONNECT_SERVER = 3;
	public static int USUARIO_NO_EXISTE_DB = 4;
	public static int NO_EXISTE_CONFIG_LDAP = 5;
	public static int ERROR_GENERAL = 6;
	public static int USUARIO_INACTIVO = 7;
	public static int PASSWORD_VACIO = 8;
	public static int intentos = 0;

	public static int AutenticaUsuario(String strUsuario,
			String strPassword/* , Map LDAP */, String limite) {
		// Los datos del Map LDAP se llenan en el index.jsp

		int r = 0;
		boolean br = false;
		boolean bexiste = false;
		boolean bEsActivo = false;
		boolean bSuspender = false;
		boolean bIntentos = false;
		int iLimite = new Integer(limite).intValue();
		int iIntentos = ActualizaUsuario.getIntentos(strUsuario);
		try {
			bexiste = ActualizaUsuario.getExisteUsuario(strUsuario);
			// //System.out.println("bExiste-->"+bexiste);
			bEsActivo = ActualizaUsuario.getEsActivo(strUsuario);
			if (bexiste) {
				if (bEsActivo) {
					if (ActualizaLdap.getExisteSisapConfigurcion()) {
						String strResultado[][] = ConexionDS
								.ejecutarSQL(SQLLdap.getSigmaConfiguracion());
						// String
						// strServidor="ldap://"+strResultado[0][0]+"/"+strResultado[0][3];
						String strServidor = "ldap://" + strResultado[0][0]
								+ "/" + strResultado[0][3];

						// String
						// strServidor="ldap://"+LDAP.get("LDAPServer")+"/"+LDAP.get("DN_SUFFIX");
						// //System.err.println("Servidor="+strServidor);

						Hashtable env1 = new Hashtable();
						env1.put(Context.PROVIDER_URL, strServidor);
						env1.put(Context.SECURITY_AUTHENTICATION, "simple");
						env1.put(Context.SECURITY_PRINCIPAL, strUsuario);
						env1.put(Context.SECURITY_CREDENTIALS, strPassword);
						env1.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
						env1.put(Context.REFERRAL, "follow");
						env1.put("java.naming.ldap.version", "3");
						InitialLdapContext ctx1 = null;

						try {
							ctx1 = new InitialLdapContext(env1, null);
						} catch (AuthenticationException aue) {
							intentos++;
							// System.out.println("No.Intentos="+intentos);
							int y = iIntentos + 1;
							bIntentos = ActualizaUsuario.UpdateIntentos(y,
									strUsuario);
							if (intentos > iLimite) {
								// System.err.println("Se suspende tu
								// cuenta--->");
								intentos = 0;
								bSuspender = ActualizaUsuario
										.SuspenderUsuario(strUsuario);
							}
							System.err
									.println("Fallo la Autenticacion: Credenciales invalidas-->"
											+ aue.getMessage());
							return CREDENCIALES_INVALIDAS;
						} catch (Exception e) {
							System.err
									.println("AutenticaUsuario:Error connecting servers-->"
											+ e);
							e.printStackTrace();
							return ERROR_CONNECT_SERVER;
							// Error connecting servers

						}
					} else {
						// No Existe Configuraicon de LDAP
						//System.err.println("AutenticaUsuario:No Existe Configuraicon de LDAP");
						return NO_EXISTE_CONFIG_LDAP;
					}
				} else {
					// System.err.println("AutentificaUsuario--->El usuario esta
					// inactivo");
					return USUARIO_INACTIVO;
				}
			} else {
				//System.err.println("AutenticaUsuario:El usuario no existe en la Base de Datos");
				return USUARIO_NO_EXISTE_DB;
			}
		} catch (Exception e) {
			// System.out.println("AutenticaUsuario::"+e.getMessage());
			e.printStackTrace();
			return ERROR_GENERAL;
		}
		if (strPassword.length() == 0) {
			// System.err.println("No ha capturado un password-->");
			return PASSWORD_VACIO;
		} else {
			int y = iIntentos + 1;
			bIntentos = ActualizaUsuario.UpdateIntentos(y, strUsuario);
			intentos = 0;
			return AUTENTICADO;
		}
	}

	public static int AutenticaUsuario1(String strUsuario, String strPassword,
			String limite) {
		// Los datos del Map LDAP se llenan en el index.jsp
		int intentos = 0;
		int iIntentos = ActualizaUsuario.getIntentos(strUsuario);
		int iLimite = new Integer(limite).intValue();
		int r = 0;
		boolean br = false;
		boolean bexiste = false;
		boolean bEsActivo = false;
		boolean bSuspender = false;
		boolean bIntentos = false;
		boolean bBitacora = false;
		boolean bResetIntentos = false;

		try {
			bexiste = ActualizaUsuario.getExisteUsuario(strUsuario);
			bEsActivo = ActualizaUsuario.getEsActivo(strUsuario);
			if (bexiste) {
				if (bEsActivo) {
					if (ActualizaLdap.getExisteSisapConfigurcion()) {
						String strResultado[][] = ConexionDS
								.ejecutarSQL(SQLLdap.getSigmaConfiguracion());
						String strServidor = "ldap://" + strResultado[0][0]
								+ "/" + strResultado[0][3];
						// String
						// strServidor="ldap://"+LDAP.get("LDAPServer")+"/"+LDAP.get("DN_SUFFIX");

						Hashtable env1 = new Hashtable();
						env1.put(Context.PROVIDER_URL, strServidor);
						env1.put(Context.SECURITY_AUTHENTICATION, "simple");
						env1.put(Context.SECURITY_PRINCIPAL, strUsuario);
						// env1.put(Context.SECURITY_PRINCIPAL,"uid="+strUsuario+","+strResultado[0][3]);
						env1.put(Context.SECURITY_CREDENTIALS, strPassword);
						env1.put(Context.INITIAL_CONTEXT_FACTORY,
								"com.sun.jndi.ldap.LdapCtxFactory");
						env1.put(Context.REFERRAL, "follow");
						env1.put("java.naming.ldap.version", "3");
						InitialLdapContext ctx1 = null;

						try {
							ctx1 = new InitialLdapContext(env1, null);
							if (ctx1 != null) {
								bResetIntentos = ActualizaUsuario
										.resetIntentos(strUsuario);
								System.err
										.println("AutenticaUsuario:El usuario se Autenticó");
							} else {

							}
						} catch (AuthenticationException aue) {
							intentos++;
							int y = iIntentos + 1;
							bIntentos = ActualizaUsuario.UpdateIntentos(y,
									strUsuario);
							if (y >= iLimite) {
								intentos = 0;
								bSuspender = ActualizaUsuario
										.SuspenderUsuario(strUsuario);
								bBitacora = ActualizaBitacora
										.InsertarEventoSuspencion(
												ActualizaUsuario
														.getIdUsuario(strUsuario),
												y + "");
							} else {
								bBitacora = ActualizaBitacora
										.InsertarEventoIntentoEnt(
												ActualizaUsuario
														.getIdUsuario(strUsuario),
												y + "");
							}
							System.err
									.println("Fallo la Autenticación: Credenciales invalidas-->"
											+ aue);
							return CREDENCIALES_INVALIDAS;
						} catch (Exception e) {
							// System.out.println ("AutenticaUsuario:Error
							// connecting servers---*>"+e);
							System.err.println("AutenticaUsuario:Error connecting servers-->"
											+ e);
							e.printStackTrace();
							return ERROR_CONNECT_SERVER;
						}
					} else {
						// No Existe Configuraicon de LDAP
						//System.err.println("AutenticaUsuario:No Existe Configuraicon de LDAP");
						return NO_EXISTE_CONFIG_LDAP;
					}
				} else {
					// System.err.println("AutentificaUsuario--->El usuario esta
					// inactivo");
					return USUARIO_INACTIVO;
				}
			} else {
				//System.err.println("AutenticaUsuario:El usuario no existe en la Base de Datos");
				return USUARIO_NO_EXISTE_DB;
			}
		} catch (Exception e) {
			// System.out.println("AutenticaUsuario::"+e.getMessage());
			e.printStackTrace();
			return ERROR_GENERAL;
		}
		if (strPassword.length() == 0) {
			return PASSWORD_VACIO;
		} else {
			return AUTENTICADO;
		}
	}

        //Credenciales otorgadas el dia 09 de junio del 2011 para usuario principal; uso de LDAP
        //public static int AutenticaUsuario2(String strUsuario, String strPassword, String limite) {
        public static int AutenticaUsuario2(String strUsuario, String strPassword, String limite, String globalUserLDAP, String globalPassLDAP) {

		// Los datos del Map LDAP se llenan en el index.jsp
		int intentos = 0;
		int iIntentos = ActualizaUsuario.getIntentos(strUsuario);
		int iLimite = new Integer(limite).intValue();
		int r = 0;
		boolean br = false;
		boolean bexiste = false;
		boolean bEsActivo = false;
		boolean bSuspender = false;
		boolean bIntentos = false;
		boolean bExisteUsuario = false;		
		boolean bActivoBorrado = false;
		boolean bBitacora = false;
		boolean bResetIntentos = false;

		try {
			bExisteUsuario = ActualizaUsuario.getExisteUsuario(strUsuario);// ActualizaAutentificacion.getExisteUsuario(strUsuario);
			bActivoBorrado = ActualizaUsuario.getEsBorrado(strUsuario);
			bEsActivo = ActualizaUsuario.getEsActivo(strUsuario);
			if (bExisteUsuario) {
				if (!bActivoBorrado) {
					if (bEsActivo) {
						String strResultado[][] = ConexionDS.ejecutarSQL(SQLLdap.getSigmaConfiguracion());
						DirContext dCtx = null;

						// Build the LDAP url
						String ldapurl = "ldap://" + strResultado[0][0] + "/";// ldap://192.168.246.24:389/";www.autenticacion.hacienda.gob.mx
						// String ldapurl =
						// "ldap://www.autenticacion.hacienda.gob.mx";
						// System.out.println("ldapurl="+ldapurl);
						Hashtable env = new Hashtable();
						env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
						env.put(Context.PROVIDER_URL, ldapurl);
						env.put(Context.SECURITY_AUTHENTICATION, "simple");
                                                //Credenciales otorgadas el dia 09 de junio del 2011 para usuario principal; uso de LDAP
                                                //env.put(Context.SECURITY_PRINCIPAL,"dc=hacienda,dc=ad,dc=gob,dc=mx");
						//env.put(Context.SECURITY_CREDENTIALS, "");
                                                env.put(Context.SECURITY_PRINCIPAL,globalUserLDAP);
                                                env.put(Context.SECURITY_CREDENTIALS, globalPassLDAP);
						env.put(Context.REFERRAL, "follow");
						env.put("java.naming.ldap.version", "3");

						dCtx = new InitialDirContext(env);
						SearchResult searchResult = null;
						NamingEnumeration results = null;
						String userDN = null;
                                                //Credenciales otorgadas el dia 09 de junio del 2011 para usuario principal; uso de LDAP
                                                //String filter = "(uid=" + strUsuario + ")";
                                                String filter = "(mailNickname=" + strUsuario + ")";

						SearchControls searchControls = new SearchControls();
						searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

						results = dCtx.search("dc=hacienda,dc=ad,dc=gob,dc=mx", filter, searchControls);

						if (results.hasMore()){
							searchResult = (SearchResult) results.next();
							userDN = searchResult.getName() + "";

							env = new Hashtable();
							env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
							env.put(Context.PROVIDER_URL, ldapurl);
							env.put(Context.SECURITY_AUTHENTICATION, "simple");
							env.put(Context.SECURITY_PRINCIPAL, userDN + ",dc=hacienda,dc=ad,dc=gob,dc=mx");// cn=Users,
							env.put(Context.SECURITY_CREDENTIALS, strPassword);
							env.put(Context.REFERRAL, "follow");
							env.put("java.naming.ldap.version", "3");
							try {
								dCtx = new InitialDirContext(env);
								if (dCtx != null) {
									bResetIntentos = ActualizaUsuario.resetIntentos(strUsuario);
								} else {									
									/***********  aquí va chequeo de admin area 0 *********///
									//bEsAdmin=ActualizaUsuario.esAdmin(strUsuario));
									if (ActualizaUsuario.esAdmin(strUsuario)){
										intentos=0;
										bResetIntentos = ActualizaUsuario.resetIntentos(strUsuario);								
									}									
									/************************************/
								}
							} catch (AuthenticationException aue) {
								intentos++;
								int y = iIntentos + 1;
								bIntentos = ActualizaUsuario.UpdateIntentos(y, strUsuario);
								if (y >= iLimite) {
									intentos = 0;
									bSuspender = ActualizaUsuario.SuspenderUsuario(strUsuario);
									bBitacora = ActualizaBitacora.InsertarEventoSuspencion(ActualizaUsuario.getIdUsuario(strUsuario), y + "");
								} else {
									bBitacora = ActualizaBitacora.InsertarEventoIntentoEnt(ActualizaUsuario.getIdUsuario(strUsuario), y + "");
								}
								System.err.println("Fallo la Autenticación: Credenciales inválidas-->" + aue);
								return CREDENCIALES_INVALIDAS;
							} catch (Exception e) {
								System.out.println("AutenticaUsuario:Error connecting servers---*>" + e);
								System.err.println("AutenticaUsuario:Error connecting servers-->" + e);
								e.printStackTrace();
								return ERROR_CONNECT_SERVER;
								// Error connecting servers
							}
						} else {
							// No Existe Configuraicon de LDAP
							//System.err.println("AutenticaUsuario:No Existe Configuraicon de LDAP");
							return NO_EXISTE_CONFIG_LDAP;
						}
					} else {
						// No Existe Configuraicon de LDAP
						//System.err.println("AutenticaUsuario:No Existe Configuración de LDAP");
						return NO_EXISTE_CONFIG_LDAP;
					}
				} else {
					// System.err.println("AutentificaUsuario--->El usuario esta
					// inactivo");
					return USUARIO_INACTIVO;
				}
			} else {
				//System.err.println("AutenticaUsuario:El usuario no existe en la Base de Datos");
				return USUARIO_NO_EXISTE_DB;
			}
		} catch (Exception e) {
			// System.out.println("AutenticaUsuario::"+e.getMessage());
			e.printStackTrace();
			return ERROR_GENERAL;
		}
		if (strPassword.length() == 0) {
			return PASSWORD_VACIO;
		} else {
			return AUTENTICADO;
		}
	}

	public static int validaUsuario(String strUsuario) {

		return 0;
	}

	public static List getUsuarioAreas(String usuarioID){
		String sql ="SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA, SD_USUARIO " 
			       +"WHERE ID_AREA = USU_AREA AND USU_UID = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List areas = new ArrayList();
		try{
			conn = ConexionDS.getConexion();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, usuarioID);
			rs=pstmt.executeQuery();
			while(rs.next()){
				AreaBean area = new AreaBean();
				area.setIdArea(rs.getInt("ID_AREA"));
				area.setNombreArea(rs.getString("ARE_NOMBRE"));
				areas.add(area);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}finally{
			ConexionDS.endConnection(rs, pstmt, conn);
		}
		return areas;
	}
}