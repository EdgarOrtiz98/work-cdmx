/*
 * Created on Oct 4, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.meve.sigma.servlet;

import java.rmi.RemoteException;

import com.meve.oracle.cm.ConnectionWebService;
import com.meve.oracle.cm.WsConnection;

/**
 * 
 * Checa el estatus del CS
 * @author Meve Soluciones
 * 
 */
public class statusOCS {
	  /**
	   * Checa el estatus del content
	   * 
	   * @param uriCont	Url para ivocar al ws de OCS
	   * @param userCont	Usuario de content
	   * @param passCont	Password de content
	   * 
	   * @throws RemoteException Si ocurre un error durante la ejecución de un Método remoto
	   */

	
	public static String  statusContent(String uriCont, String userCont, String passCont)throws RemoteException{
		
		//WsConnection s_WsCon = null;
		String content = "activo";		
		/*try{
			try{			
				
		        	ConnectionWebService c = new ConnectionWebService(uriCont, userCont, passCont);
		        	s_WsCon = c.conectaOcs(); 
		        	
					return content;
			}finally{
				s_WsCon.logout();
			}
		 
		 }catch (Throwable t){

		 	//System.out.println("Exception" + t.toString());
		 	content = t.toString();
		 	return content;
		 
		 }*/
        return content;
	}
}
