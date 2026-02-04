package com.meve.sigma.quartz;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.meve.sigma.db2.ConexionDS;

/**
 * @version 1.0
 */
public class Principal  implements Job {

    private static final String SQL_SELECT_CADUCA = "SELECT  B.USU_CORREO,A.ASU_DESCRIPCION, A.ASU_FOLIO_RECEPCION,A.ID_ASUNTO " + 
												    "FROM SD_ASUNTO A,SD_USUARIO B "+ 
													"WHERE A.ASU_USR_TURNA = B.ID_USUARIO AND SYSDATE >= A.ASU_FECHA_CADUCIDAD  " +
													"AND A.ASU_ESTATUS = 2";
    private static final String SQL_SELECT_CONTROL_CADUCA = "INSERT INTO SD_MAIL_CADUCO (ID_FOLIO_ENVIA, MAIL_DESCRIPCION, V_FEC_ACTUALIZACION, ESTATUS_ENVIADO) VALUES (?,?,SYSDATE,1)";
    private static final String SQL_SELECT_VERIFICA = "SELECT ID_FOLIO_ENVIA FROM  SD_MAIL_CADUCO WHERE ID_FOLIO_ENVIA = ? AND ESTATUS_ENVIADO = 1";
    
    /**
     * Constructor por defecto
     */
    public Principal(){
    	
    }
    
    /**
     * Interface
     */
    public void performPaymentNotice() {

    }
    
    public void execute1(JobExecutionContext context)
    throws JobExecutionException {
    	 //getDatosAsuntoTramite();
    }
    /**
     * EJECUTA EL TRABAJO DE MONITOREO
     */
    public void execute(JobExecutionContext context)
    throws JobExecutionException {
    	
    	JobDataMap jdm = context.getJobDetail().getJobDataMap();
    	//ServletContext servletContext = (ServletContext) jdm.get("servletContext");
    	
    	/*try {
            Connection con=null;
			String correo = null;
			String folioNombre = null;
			String cveFolio = null;
			String meshis = null;
			String ServerMail = null;
			String MailPort = null;
            ResultSet rsHist;
			ResultSet rsHistPas2;
			String user = null;
			String pass = null;
			String driverType = null;
			String portNumer = null;
			String db = null;
			String sn = null;
			
			ServerMail = (String)jdm.get("serverMail");
			MailPort = (String)jdm.get("mailPort");
			user = (String)jdm.get("user");
			pass = (String)jdm.get("pass");
			driverType = (String)jdm.get("driverType");
			portNumer = (String)jdm.get("portNumer");
			db = (String)jdm.get("db");
			sn = (String)jdm.get("sn");
			
			int verifica = 0;
			SenderMail mail = new SenderMail();
			con = ConexionDS.getConexionQ(user, pass, driverType, portNumer, db, sn);
		
			PreparedStatement pshist = con.prepareStatement(SQL_SELECT_CADUCA);
			rsHist = pshist.executeQuery();
			while (rsHist.next()) {
				correo = rsHist.getString("USU_CORREO");
	            meshis  = rsHist.getString("ASU_DESCRIPCION");
	            folioNombre  = rsHist.getString("ASU_FOLIO_RECEPCION");
	            cveFolio  = rsHist.getString("ID_ASUNTO");
	            
	            verifica = 0;
	            PreparedStatement psasun2 = con.prepareStatement(SQL_SELECT_VERIFICA);
			    psasun2.setInt(1, Integer.parseInt(cveFolio));
			    rsHistPas2 = psasun2.executeQuery();
			    while(rsHistPas2.next())
			    {
			    	verifica = 1;
			    }
			    rsHistPas2.close();
			    psasun2.close();
	            	  

	            if(verifica == 0)
	            {
	            	PreparedStatement psinst = con.prepareStatement(SQL_SELECT_CONTROL_CADUCA);
				    psinst.setInt(1, Integer.parseInt(cveFolio));
				    psinst.setString(2,cveFolio);
				    psinst.executeUpdate(); 
				    psinst.close();  
				    mail.sendConfirmacionCaduca(meshis,correo,folioNombre,ServerMail ,MailPort); 
	             }
	        }

			con.close();
             
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }*/ /*catch (NamingException e){
        	 e.printStackTrace();
        } */
    	
    	
    }
}