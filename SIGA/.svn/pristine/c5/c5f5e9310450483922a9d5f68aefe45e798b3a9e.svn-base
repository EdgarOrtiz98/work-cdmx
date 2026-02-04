package com.meve.sigma.sql;

/**
* Clase que contiene metodos que contruyen sentencias sql para la 
* actualizacion y lectura de la tabla CONFIGURACIONSISAP
*
* @author  Gustavo Gonzalez Esquivel gustavo_g_e@hotmail.com
* @version 1.0
*/
public class SQLLdap {

	/**
	 * Datos ldap
	 * @param strLdap strLdap
	 * @param strUser_Object_Class strUser_Object_Class
	 * @param strDn_Preffix  strDn_Preffix
	 * @param strDn_Suffix strDn_Suffix
	 * @param strGroup_Object_Class strGroup_Object_Class
	 * @param strGroup_Member strGroup_Member
	 * @param strGroup_Dn strGroup_Dn
	 * @param strDn_Administrador strDn_Administrador
	 * @param strDn_Group_Administracion strDn_Group_Administracion
	 * @param strServidor_SMTP strServidor_SMTP
	 * @return sql query
	 */
	public static String getInsertaSisapConfiguracion(	String strLdap,
											  	String strUser_Object_Class,
											  	String strDn_Preffix,
											  	String strDn_Suffix,
											  	String strGroup_Object_Class,
											  	String strGroup_Member,
											  	String strGroup_Dn,
											  	String strDn_Administrador,
											  	String strDn_Group_Administracion,
											  	String strServidor_SMTP)
	{
		String strSql="";
		
		strSql=	" INSERT INTO SD_LDAP ("+		
		"SD_LDAP,USER_OBJECT_CLASS,DN_PREFFIX,DN_SUFFIX,GROUP_OBJECT_CLASS,"+
		"GROUP_MEMBER,GROUP_DN,DN_ADMINISTRADOR,DN_GROUP_ADMINISTRACION,ID,SERVIDOR_SMTP)"+
		"VALUES ("+
				"'"+strLdap+"',"+
				"'"+strUser_Object_Class +"',"+
				"'"+strDn_Preffix+"',"+				
				"'"+strDn_Suffix+"',"+
				"'"+strGroup_Object_Class+"',"+
				"'"+strGroup_Member+"',"+
				"'"+strGroup_Dn+"',"+
				"'"+strDn_Administrador+"',"+
				"'"+strDn_Group_Administracion+"',"+
				"SD_LDAP_SEQ.NEXTVAL,"+
				"'"+strServidor_SMTP +"'"+
				" )"; 
								
		return strSql;
	}
	
	/**
	 *  actualiza ldap
	 * @param strLdap strLdap
	 * @param strUser_Object_Class strUser_Object_Class
	 * @param strDn_Preffix strDn_Preffix
	 * @param strDn_Suffix strDn_Suffix
	 * @param strGroup_Object_Class strGroup_Object_Class
	 * @param strGroup_Member strGroup_Member
	 * @param strGroup_Dn strGroup_Dn
	 * @param strDn_Administrador strDn_Administrador
	 * @param strDn_Group_Administracion strDn_Group_Administracion
	 * @param strServidor_SMTP strServidor_SMTP
	 * @return true si actualiza correctamente
	 */
	public static String getActualizaSisapConfiguracion(	String strLdap,
											  	String strUser_Object_Class,
											  	String strDn_Preffix,
											  	String strDn_Suffix,
											  	String strGroup_Object_Class,
											  	String strGroup_Member,
											  	String strGroup_Dn,
											  	String strDn_Administrador,
											  	String strDn_Group_Administracion,
											  	String strServidor_SMTP
											  	)
	{
	String strSql="";
		
	strSql=	" UPDATE SD_LDAP SET "+
				"SD_LDAP='"				+strLdap+"',"+
				"USER_OBJECT_CLASS='"	+strUser_Object_Class+"',"+
				"DN_PREFFIX='"			+strDn_Preffix+"',"+				
				"DN_SUFFIX='"			+strDn_Suffix+"',"+
				"GROUP_OBJECT_CLASS='"	+strGroup_Object_Class+"',"+
				"GROUP_MEMBER='"		+strGroup_Member+"',"+
				"GROUP_DN='"			+strGroup_Dn+"',"+
				"DN_ADMINISTRADOR='"	+strDn_Administrador+"',"+
				"DN_GROUP_ADMINISTRACION='"+strDn_Group_Administracion+"',"+
				"SERVIDOR_SMTP='"+strServidor_SMTP +"'"+
				" WHERE ID=1";								
		return strSql;
	}
	
	/**
	 * verifica si existe Configuración
	 * @return true
	 */
	public static String getExisteSigmaConfigurcion()
	{
		String strSql="";		
		strSql=	"SELECT COUNT(*) FROM SD_LDAP";								
			return strSql;	
	}
	
	/**
	 * Configuración
	 * @return sigma Configuración
	 */
	public static String getSigmaConfiguracion()
	{
		String strSql="";		
		strSql=	"SELECT * FROM SD_LDAP";								
			return strSql;	
	}
	
	/**
	 * organización
	 * @return organización
	 */
	public static String getOrganizacionSisap()
	{
		String strSql="";		
		strSql=	"SELECT dn_suffix FROM SD_LDAP";								
			return strSql;	
	}
	
	/**
	 * valida usuario
	 * @param strUsuario usuario
	 * @param password password
	 * @return valida usuario
	 */
	public static String getValidaUsuario(String strUsuario, String password){
	    String sql;
	    sql = "SELECT * FROM SD_CIUDADANO WHERE CIU_USUARIO='"+strUsuario+"' AND CIU_PASSWORD='"+password+"' ";
	    return sql;
	}
	
	
}
