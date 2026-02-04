package com.meve.sigma.ldap;

import java.sql.*;

import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.db2.*;
import com.meve.sigma.sql.SQLLdap;

import javax.naming.*;
import javax.naming.directory.*;
//import javax.naming.ldap.*;
import java.util.*;
//import com.meve.util.*;
/**
* Clase que contiene metodos de Actualizacion y Lectura sobre la Tabla CONFIGURACIONSISAP
*
* @author  Gustavo Gonzalez Esquivel gustavo_g_e@hotmail.com
* @version 1.0
*/
public class ActualizaLdap {

	/**
	 * Constructor for ActualizaLdap.
	 */
	public static boolean InsertaSisapConfiguracion(	String strLdap,
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
		int r=0;
		try
		{
			String strsql=SQLLdap.getInsertaSisapConfiguracion(	strLdap,
																strUser_Object_Class,
																strDn_Preffix,
																strDn_Suffix,
																strGroup_Object_Class,
																strGroup_Member,
																strGroup_Dn,
																strDn_Administrador,
																strDn_Group_Administracion,
																strServidor_SMTP);
			//System.out.println("InsertaSisapConfiguracion:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("InsertaSisapConfiguracion:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}
	
		if(r>0)
		return true;
		return false;		
	}
	public static boolean ActaulizaSisapConfiguracion(	String strLdap,
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
		int r=0;
		try
		{
			String strsql=SQLLdap.getActualizaSisapConfiguracion(strLdap,
																strUser_Object_Class,
																strDn_Preffix,
																strDn_Suffix,
																strGroup_Object_Class,
																strGroup_Member,
																strGroup_Dn,
																strDn_Administrador,
																strDn_Group_Administracion,
																strServidor_SMTP);
			//System.out.println("ActualizaSisapConfiguracion:"+strsql);
			r=ConexionDS.ejecutarActualizacion(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("ActualizaSisapConfiguracion:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}
	
		if(r>0)
		return true;
		return false;		
	}
	public static boolean getExisteSisapConfigurcion()
	{
		int r=0;
		int nconfiguracion=0;
		try
		{
			String strsql			=	SQLLdap.getExisteSigmaConfigurcion();
			String strResultado[][]	=	ConexionDS.ejecutarSQL(strsql);
			nconfiguracion			= 	new Integer(strResultado[0][0]).intValue();
		}
		catch(SQLException sqle)
		{
				//System.out.println("ExisteSigmaConfiguracion:"+sqle.getMessage());
				sqle.printStackTrace();
				nconfiguracion=0;
	
		}
		catch(NumberFormatException nfe)
		{		
			nconfiguracion=0;				
		}	
		
		if(nconfiguracion==0)
			return false;
			
		return true;	
	}
	public static boolean AplicaSisapConfiguracion(String strLdap,
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
		int r=0;
		boolean br=false;
		boolean bexiste=false;
		try
		{
			bexiste=getExisteSisapConfigurcion();
			if(bexiste)			
			{
				br=ActaulizaSisapConfiguracion(strLdap,
											strUser_Object_Class,
											strDn_Preffix,
											strDn_Suffix,
											strGroup_Object_Class,
											strGroup_Member,
											strGroup_Dn,
											strDn_Administrador,
											strDn_Group_Administracion,
											strServidor_SMTP
											);
				//System.out.println("Actulizando SisapConfiguracion");
			}
			else
			{
				br=InsertaSisapConfiguracion(strLdap,
											strUser_Object_Class,
											strDn_Preffix,
											strDn_Suffix,
											strGroup_Object_Class,
											strGroup_Member,
											strGroup_Dn,
											strDn_Administrador,
											strDn_Group_Administracion,
											strServidor_SMTP);
				//System.out.println("Insertando SisapConfiguracion");
			}									
			
		}
		catch(Exception e)
		{
				//System.out.println("AplicaSisapConfiguracion:"+e.getMessage());
				e.printStackTrace();
				return false;
		}
	
		return br;
	}
	public static String[] getUsuariosLdap()											  	
	{
		int r=0;
		boolean br=false;
		boolean bexiste=false;
		try
		{
			
				if(ActualizaLdap.getExisteSisapConfigurcion())
				{
					String strResultado[][]= ConexionDS.ejecutarSQL(SQLLdap.getSigmaConfiguracion());					
					String ldap_url="ldap://"+strResultado[0][0]+"/"+strResultado[0][3];										
					
					try 
					{
						Hashtable env = new Hashtable();
						env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
						env.put(Context.PROVIDER_URL, ldap_url); 
						DirContext ctx = new InitialDirContext(env);
						SearchControls ctls = new SearchControls();
				        String[] attrIDs = {strResultado[0][2]};
        				ctls.setReturningAttributes(attrIDs);
        				ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        				String filter = "(objectClass="+strResultado[0][1]+")";
        				NamingEnumeration enum1 = ctx.search("", filter, null);    
   
        
        				Vector uvec = new Vector(1);
        				String strtmp="";        				
        				while (enum1.hasMore()) 
        				{
         					SearchResult sr = (SearchResult)enum1.next();
         					strtmp=sr.getName();
         					strtmp=strtmp.substring(strtmp.indexOf('=')+1);	
         					strtmp=strtmp.trim();
         					uvec.add(strtmp);         					
		       				////System.out.println("<"+strtmp+">");
        				}
        				String strUsuarios[]=new String[uvec.size()];
        				for(int i=0;i<uvec.size();i++)
        				strUsuarios[i]=(String)uvec.elementAt(i);	 				
						return strUsuarios;

  					} 
			 	 	catch (Exception e) 
  					{
    					System.err.println ("AutenticaUsuario:Error connecting servers");
    					e.printStackTrace ();
    					return null;
    					//Error connecting servers

  					}
				}
				else
				{
					//No Existe Configuraicon de LDAP
					System.err.println ("AutenticaUsuario:No Existe Configuraicon de LDAP");
					return null;
				}					
		}
		catch(Exception e)
		{
				//System.out.println("AutenticaUsuario::"+e.getMessage());
				e.printStackTrace();
				return null;
		}	
		
	}
	public static String[][] getComboUsuariosLdap()											  	
	{
		int r=0;
		boolean br=false;
		boolean bexiste=false;
		try
		{
			if(ActualizaLdap.getExisteSisapConfigurcion())
			{
				String strResultado[][]= ConexionDS.ejecutarSQL(SQLLdap.getSigmaConfiguracion());					
				String ldap_url="ldap://"+strResultado[0][0]+"/"+strResultado[0][3];										
				System.out.println(ldap_url);
			
				try 
				{
				    Hashtable env = new Hashtable();
					env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
					env.put(Context.PROVIDER_URL, ldap_url); 
					DirContext ctx = new InitialDirContext(env);
					SearchControls ctls = new SearchControls();
				    String[] attrIDs = {strResultado[0][2]};
        			ctls.setReturningAttributes(attrIDs);
        			ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        			String filter = "(objectClass="+strResultado[0][1]+")";
        			NamingEnumeration enum1 = ctx.search("", filter, null);    
   
        			Vector uvec = new Vector(1);
        			String strtmp="";        				
        			String stremail="";        				
        			while (enum1.hasMore()) 
        			{
         				SearchResult sr = (SearchResult)enum1.next();
         				stremail=sr.getAttributes().get("mail").toString();
         				
         				Vector v=new Vector();
         				
         				if(stremail.indexOf(':')!=-1)
         				stremail=stremail.substring(stremail.indexOf(':')+2);	
         				stremail=stremail.trim();         					        					
         					
         				strtmp=sr.getName();
         				strtmp=strtmp.substring(strtmp.indexOf('=')+1);	
         				strtmp=strtmp.trim();         					
         				v.add(strtmp);
         				v.add(stremail);
         				uvec.add(v);         					
		       			////System.out.println("<"+strtmp+">");
        			}
        			String strUsuarios[][]=new String[uvec.size()][2];
        			String organizacion= strResultado[0][3];
        			organizacion=organizacion.substring(organizacion.indexOf('=')+1);	
       				organizacion=organizacion.trim();
        				
        			for(int i=0;i<uvec.size();i++)
        			{
        				Vector v=(Vector)uvec.elementAt(i);
        				strUsuarios[i][1]=(String)v.elementAt(0) + "/"+ organizacion;	 				
        				strUsuarios[i][0]=(String)v.elementAt(0)+"|"+(String)v.elementAt(1);	 				        					
        			}
					return strUsuarios;

  				} 
			 	catch (Exception e) 
  				{
    				System.err.println ("AutenticaUsuario:Error connecting servers");
    				e.printStackTrace ();
    				return null;
    				//Error connecting servers

  				}
			}
			else
			{
				//No Existe Configuraicon de LDAP
				System.err.println ("AutenticaUsuario:No Existe Configuraicon de LDAP");
				return null;
			}					
		}
		catch(Exception e)
		{
				//System.out.println("AutenticaUsuario::"+e.getMessage());
				e.printStackTrace();
				return null;
		}	
		
	}
	
	public static String getOrganizacion()
	{
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLLdap.getOrganizacionSisap());
			if(strResult.length>0)
			{
				String strorganizacion=strResult[0][0];
				strorganizacion=strorganizacion.substring(strorganizacion.indexOf('=')+1);
				return strorganizacion;
			}
			return "";			
		}
		catch(SQLException sqle)
		{
				//System.out.println("getOrganizacion:"+sqle.getMessage());
				sqle.printStackTrace();
				return "";
		}
	

	
	}
	public static String[][] getComboUsuariosLdapA()											  	
	{
		int r=0;
		boolean br=false;
		boolean bexiste=false;
		try
		{
				if(ActualizaLdap.getExisteSisapConfigurcion())
				{
						String strResultado[][]= ConexionDS.ejecutarSQL(SQLLdap.getSigmaConfiguracion());					
						String ldap_url="ldap://"+strResultado[0][0]+"/"+strResultado[0][3];
						//String ldap_url="ldap://"+strResultado[0][0];
						////System.out.println("*************************:"+ldap_url);				
					try 
					{
						Hashtable env = new Hashtable();
						env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
						env.put(Context.PROVIDER_URL, ldap_url); 
//						env.put("com.sun.jndi.ldap.trace.ber", System.out);						
										
						DirContext ctx = new InitialDirContext(env);
						SearchControls ctls = new SearchControls();
						////System.out.println("--->" + strResultado[0][2]);
				        String[] attrIDs = {strResultado[0][2],"mail","uid"};
        				ctls.setReturningAttributes(attrIDs);
        				ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        				//String filter = "(objectClass="+strResultado[0][1]+")";
        				String filter = "(objectClass=*)";
        				////System.out.println("FILTER="+filter);
        				//NamingEnumeration enum = ctx.search("", filter, null);            
        				NamingEnumeration enum1 = ctx.search("", filter, ctls);
        				
        				Vector uvec = new Vector(1);
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
		         				
		         				////System.out.println("Mail-->"+sr.getAttributes().get("mail"));
								if(atrMail!=null){
	        	 					stremail=atrMail.toString();
	        	 					////System.out.println("MAIL--->="+stremail);
								}
	        	 				else
	        	 					stremail="";
         	
         					
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
        	 					    //strName = sr.getAttributes().get("cn").toString();//sr.getName();
        	 					    strName = sr.getName(); 
        	 					    ////System.out.println("CN-->"+strName);
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
        				String organizacion= strResultado[0][3];
        				organizacion=organizacion.substring(organizacion.indexOf('=')+1);	
       					organizacion=organizacion.trim();
       					////System.out.println("Organizacion="+organizacion);
        				for(int i=0;i<uvec.size();i++)
        				{
        					Vector v=(Vector)uvec.elementAt(i);
        					
       						strUsuarios[i][1]=(String)v.elementAt(0) + "/"+ organizacion;
       						////System.out.println("strUsuarios[i][1]="+(String)v.elementAt(0))+"/"+ organizacion;
       						strUsuarios[i][0]=(String)v.elementAt(0)+"|"+(String)v.elementAt(1)+"~"+(String)v.elementAt(2);
       						////System.out.println("strUsuarios[i][0]="+(String)v.elementAt(0)+"|"+(String)v.elementAt(1)+"~"+(String)v.elementAt(2));
        					//strUsuarios[i][0]=(String)v.elementAt(0)+"|"+(String)v.elementAt(1);
       						////System.out.println("-------------------------------------");
        				}
						return strUsuarios;

  					} 
			 	 	catch (Exception e) 
  					{
    					System.err.println ("AutenticaUsuario:Error connecting servers");
    					e.printStackTrace ();
    					return null;
    					//Error connecting servers

  					}
				}
				else
				{
					//No Existe Configuraicon de LDAP
					System.err.println ("AutenticaUsuario:No Existe Configuraicon de LDAP");
					return null;
				}					
		}
		catch(Exception e)
		{
			//System.out.println("AutenticaUsuario::"+e.getMessage());
			e.printStackTrace();
			return null;
		}	
		
	}
	
	public static String[][] getComboUsuariosLdapB()
	{
	    String[][] strValores = new String[0][0];
		Hashtable env;
		SearchResult sr;
		Attributes atr;
		DirContext ctx;
		SearchControls ctls;
		NamingEnumeration enum1;
		UsuariosLdap usldap;
		String filter ;
		Vector vUsuarios;
		try{
			String strResultado[][]= ConexionDS.ejecutarSQL(SQLLdap.getSigmaConfiguracion());					
			String ldap_url="ldap://"+strResultado[0][0]+"/"+strResultado[0][3];
			try{
			    env = new Hashtable();
			    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			    env.put(Context.PROVIDER_URL, "ldap://10.1.21.11:2389/"+strResultado[0][3]); 
			    ctx = new InitialDirContext(env);
			    ctls = new SearchControls();
			    ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			    filter = "(uid=*)";
			    enum1 = ctx.search("", filter, null);
			    //System.out.println("entrara" + enum1.hasMore());
			    vUsuarios = new Vector();
			    while (enum1.hasMore()){
			        sr = (SearchResult)enum1.next();
			        atr= sr.getAttributes();
			        usldap = new UsuariosLdap();
					usldap.setNombre((sr.getAttributes().get("cn")==null)?"":sr.getAttributes().get("cn").toString());
					usldap.setCorreo((sr.getAttributes().get("mail")==null)?"":sr.getAttributes().get("mail").toString());
					usldap.setUid((sr.getAttributes().get("uid")==null)?"":sr.getAttributes().get("uid").toString());
					vUsuarios.addElement(usldap);
			    }
			
			    if(vUsuarios.size()>0){
			        strValores = new String[vUsuarios.size()][2];
			        	for(int i=0;i<vUsuarios.size();i++){
			        	    strValores[i][0]=((UsuariosLdap)vUsuarios.elementAt(i)).getCombinado();
			        	    strValores[i][1]=((UsuariosLdap)vUsuarios.elementAt(i)).getNombre();
			        	}
			    }
			
			    /*for(int i=0;i<strValores.length;i++){
			     //System.out.println("["+i+"][0]= " + strValores[i][0]);
			     //System.out.println("["+i+"][1]= " + strValores[i][1]);
			     }*/
			}catch(Exception e){
			    System.err.println ("AutenticaUsuario:Error connecting servers");
				e.printStackTrace();
				return null;
			}
			return strValores;
			
		}catch(Exception e){
		    //System.out.println("AutenticaUsuario::"+e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Valida usuario
	 * @param strUsuario usuario
	 * @param strPassword password
	 * @return 1 si esta validado el usuario, 2 no
	 */
	public static int getValidaUsuario(String strUsuario, String strPassword)
	{
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLLdap.getValidaUsuario(strUsuario, strPassword));
			
			if(strResult!=null && strResult.length>0)
			    return 1;
			return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getIntentos:"+sqle);
			sqle.printStackTrace();
			return 2;		
		}
	}
}


class UsuariosLdap{
	private String strNombre;
	private String strCorreo;
	private String strUid;
	
	UsuariosLdap(){
		strNombre = "";
		strCorreo = "";
		strUid = "";
	}
	
	public void setNombre(String strNombre){
		this.strNombre = quitaPuntos(strNombre);
	}
	
	public void setCorreo(String strCorreo){
		this.strCorreo = quitaPuntos(strCorreo);
	}
	
	public void setUid(String strUid){
		this.strUid = quitaPuntos(strUid);
	}
	
	public String getNombre(){
		return this.strNombre;
	}
	
	public String getCorreo(){
		return this.strCorreo;
	}
	
	public String getUid(){
		return this.strUid;
	}
	
	public String getCombinado(){
		return this.strUid+"|"+this.strCorreo;
	}
	
	private String quitaPuntos(String strCadena){
		if(strCadena.indexOf(':')!=-1){
			strCadena=(strCadena.substring(strCadena.indexOf(':')+2)).trim();
		}
		return strCadena;
	}
}