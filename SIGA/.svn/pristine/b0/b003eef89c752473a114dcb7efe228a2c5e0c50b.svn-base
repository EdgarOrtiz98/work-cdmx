/**
 * Clase:						FiltroUsuarios.java
 * 
 * Paquete:						com.meve.sigma.ldap		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Jan 13, 2006
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		
 */

package com.meve.sigma.ldap;

import java.util.Hashtable;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import com.meve.sigma.actualiza.ActualizaUsuario;

public class FiltroUsuarios {
    
    public static void main(String args[]){
        
        try
		{
				//String strResultado[][]= ConexionDS.ejecutarSQL("SELECT * FROM SD_LDAP");					
				String ldap_url= "ldap://MEVE-F0556C67EF/o=meve";//"ldap://"+strResultado[0][0]+"/"+strResultado[0][3];
				//String ldap_url="ldap://"+strResultado[0][0];
				////System.out.println("*************************:"+ldap_url);				
				try 
				{
				    Hashtable env = new Hashtable();
					env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
					env.put(Context.PROVIDER_URL, ldap_url); 
					//env.put("com.sun.jndi.ldap.trace.ber", System.out);						
										
					DirContext ctx = new InitialDirContext(env);
					SearchControls ctls = new SearchControls();
					////System.out.println("--->" + strResultado[0][2]);
				    String[] attrIDs = {"o","mail","uid"};
        			ctls.setReturningAttributes(attrIDs);
        			ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        			//String filter = "(objectClass="+strResultado[0][1]+")";
        			//String filter = "(objectClass=m*)";
        			String filter = "(ou=*)";
        			////System.out.println("FILTER="+filter);
        			//NamingEnumeration enum = ctx.search("", filter, null);            
        			NamingEnumeration enum1 = ctx.search("", filter, ctls);
        				
        			Vector uvec = new Vector(1);
        			String strOrganizacion = "";
        			String strUnidadOrg = "";
        			String strtmp="";        				
        			String stremail="";
        			String strName = "";
        			if(enum1!=null)    				
        			while (enum1.hasMore()) 
        			{
         				SearchResult sr = (SearchResult)enum1.next();
         				if(sr!=null)
         				{
         				    /*Attributes we = sr.getAttributes();
         					NamingEnumeration ne =  we.getAll();
         					while(ne.hasMore()){
         					    //System.err.println(ne.nextElement());
         					}
         					*/
		         			Attribute atrMail=	sr.getAttributes().get("mail");
		         			Attribute strOrg = sr.getAttributes().get("o");
		         			Attribute strUO = sr.getAttributes().get("ou");
		         			////System.out.println("Org-->"+sr.getAttributes().get("o"));
		         			////System.out.println("OU-->"+sr.getAttributes().get("ou"));
		         			////System.out.println("Mail-->"+sr.getAttributes().get("mail"));
							/*if(atrMail!=null){
	        	 				stremail=atrMail.toString();
	        	 				////System.out.println("MAIL--->="+stremail);
							}
	        	 			else
	        	 				stremail="";*/
         	
         					
         					Vector v=new Vector();         	         					
	         				if(stremail.indexOf(':')!=-1)
    	     				stremail=stremail.substring(stremail.indexOf(':')+2);
	         				////System.out.println("MAIL1="+stremail);
        	 				stremail=stremail.trim();         					        					
        	 				////System.out.println("MAIL2="+stremail);
         					//strtmp=sr.getName();
        	 					
        	 				try{
        	 				    strtmp=sr.getAttributes().get("uid").toString();
           	 					////System.out.println("UID---->"+strtmp);
           	 					strtmp = strtmp.substring(strtmp.indexOf(':')+2);
           	 					////System.out.println("UIDSubstring---->"+strtmp);
           	 					////System.out.println("cn--->*"+sr.getAttributes().get("cn").toString());
           	 					////System.out.println("ou--->*"+sr.getAttributes().get("ou").toString());
        	 				    strName = sr.getName();
        	 				    ////System.out.println("CN-->"+strName);
        	 				    strName = strName.substring(strName.indexOf('=')+1);
        	 				    ////System.out.println("CNSubstring=-->"+strName);
        	 				}catch(Exception e){
        	 				    strName=sr.getName();
        	 				}
         					////System.out.println("NAME="+strtmp);
         					strtmp=strtmp.substring(strtmp.indexOf('=')+1);
         					////System.out.println("strtmpInsexIf="+strtmp);
         					strtmp=strtmp.trim();  
         					////System.out.println("strtmpTrim()="+strtmp);
         					////System.out.println("-------------------------------------");
	         				if(! strtmp.equalsIgnoreCase("Administrator") )
        					{
	         				    String strNNombre = ActualizaUsuario.cambiarNombre(strName);
	         				    v.add(strNNombre);				
    	     					v.add(strtmp);
	        	 				v.add(stremail);
	        	 				
    	     					uvec.add(v);         					
        					}
         				}
		       				////System.out.println("<"+strtmp+">");
        			}
        			String strUsuarios[][]=new String[uvec.size()][2];
        			String organizacion= "o=meve";
        			organizacion=organizacion.substring(organizacion.indexOf('=')+1);	
       				organizacion=organizacion.trim();
       				////System.out.println("Organizacion="+organizacion);
        			for(int i=0;i<uvec.size();i++)
        			{
        				Vector v=(Vector)uvec.elementAt(i);
        				
       					strUsuarios[i][1]=(String)v.elementAt(0) + "/"+ organizacion;
       					////System.out.println("strUsuarios[i][1]="+(String)v.elementAt(0) + "/"+ organizacion);
       					strUsuarios[i][0]=(String)v.elementAt(0)+"|"+(String)v.elementAt(1)+"/"+(String)v.elementAt(2);
       					////System.out.println("strUsuarios[i][0]="+(String)v.elementAt(0)+"|"+(String)v.elementAt(1)+"/"+(String)v.elementAt(2));
        				//strUsuarios[i][0]=(String)v.elementAt(0)+"|"+(String)v.elementAt(1);
       					////System.out.println("-------------------------------------");
        			}
						

  				} 
			 	catch (Exception e) 
  				{
    				System.err.println ("AutenticaUsuario:Error connecting servers");
    				e.printStackTrace ();
    			}					
		}
		catch(Exception e)
		{
			//System.out.println("AutenticaUsuario::"+e.getMessage());
			e.printStackTrace();
			
		}
    }

}

