/*
 * Creado el 22/02/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de cÃ³digo
 */
package com.meve.oracle.cm;

/**
 * Crea un objeto de conexión a Oracle Content Services web services server
 * @author Meve Soluciones
 */
public class ConnectionWebService {
	
	String strUriContent;
	String strUserContet;
	String strPassContent;
	
	public ConnectionWebService(String strUriContet, String strUserContet,String strPassContent){
		
                this.strUriContent = strUriContet;
                this.strUserContet = strUserContet;
                this.strPassContent = strPassContent;
	}

	/**
	 * Connects to a Oracle Content Services web services server.
	 * This is a factory method which returns an instance of this class.
	 * 
	 * @return          an instance of this class.
	 *                  
	 * @throws Throwable
	 */
	public WsConnection conectaOcs()throws Throwable{
		WsConnection s_WsCon = null;		
		try{
                    try{
                        String serverUrl = strUriContent+ "/content/ws";
                        s_WsCon = WsConnection.login(serverUrl,strUserContet,strPassContent);
                        s_WsCon.getSessionCookie();
                        return s_WsCon;
                    }finally{/*s_WsCon.logout();*/}
		}catch (Throwable t){t.printStackTrace();}
        return s_WsCon;
	}
}