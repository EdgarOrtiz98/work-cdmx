/*
 * Created on Sep 15, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.meve.sigma.servlet;
/**
 * 
 * Clasifica el tipo de documento entrante
 * @author Meve Soluciones 
 *
 */
public class TypeDoc {
	  /**
	   * Clasifica un documento en base a su extensión
	   * 
	   * @param strNameDoc	Nombre del documento
	   * 
	   * @return una cadena que contiene el nombre y ubicacion de la imagen asignada
	   */
	
	public static String tipoDoc(String strNameDoc){
		
		String strTypeImage = "../Imagenes/fileatt.gif";
		
		if(strNameDoc.endsWith(".pdf")){
			
			return strTypeImage = "../Imagenes/ic_pdf.gif";
		
		}else
			if(strNameDoc.endsWith(".doc")){
				
				return strTypeImage = "../Imagenes/ic_word.gif";
			
			}else
				if(strNameDoc.endsWith(".xls")){
						
					return strTypeImage = "../Imagenes/ic_excel.gif";
					
					}else
						if(strNameDoc.endsWith(".pps")){
								
							return strTypeImage = "../Imagenes/ic_power.gif";
							
							}else
								if(strNameDoc.endsWith(".gif")){
									
									return strTypeImage = "../Imagenes/ic_gif.gif";
								
								}else
									if(strNameDoc.endsWith(".jpg")){
										
										return strTypeImage = "../Imagenes/ic_jpg.gif";
									
									}else
										if(strNameDoc.endsWith(".zip")){
											
											return strTypeImage = "../Imagenes/ic_winzip.gif";
										
										}else
											
											return strTypeImage = "../Imagenes/fileatt.gif";
	
	}
	
	

}
