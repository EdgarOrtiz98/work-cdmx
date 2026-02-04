package com.meve.sigma.beans;
import java.util.*;

/**
 * Bean utilizado para autenticarse contra el servidor Ldap
 * @author Meve Soluciones S.A. de C.V.
 */
public class LDAPBean {
	/**
	 * Constructor por defecto
	 */
	public LDAPBean () {}
	
	Map LDAP;
	
	/**
	 * set of key-value mappings in this map.
	 * @param LDAP mapping
	 */
	public void setLDAP (Map LDAP) {
		this.LDAP = LDAP;		
	}
	/**
	 *Extrae nombre del server Ldap
	 * @return nombre del server
	 */
	public String getLDAPServer (){
		return LDAP.get("LDAPServer").toString();
	}
	/**
	 * get key-value mappings
	 * @return key-value
	 */
	public Map getLDAP () {
		return LDAP;
	}

}
