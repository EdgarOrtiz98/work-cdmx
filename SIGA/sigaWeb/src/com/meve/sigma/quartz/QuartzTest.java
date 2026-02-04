/*
 * Created on Dec 14, 2006
 *
 * Creador: Enrique Velazco Acosta.
 */
package com.meve.sigma.quartz;

// import com.meve.sigma.util.ServiceLocator;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Clase que calendariza mensajes de cambio de semaforo
 * 
 * @author Meve Soluciones
 */
public class QuartzTest extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1217412690487197667L;
	private static final SchedulerFactory sf = new StdSchedulerFactory();
	private static Scheduler sched = null;

	public void destroy() {
		try {
			sched.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void init(ServletConfig arg0) throws ServletException {
		String segundo = arg0.getServletContext().getInitParameter("segundo");
		String minuto = arg0.getServletContext().getInitParameter("minuto");
		String hora = arg0.getServletContext().getInitParameter("hora");
		String diaMes = arg0.getServletContext().getInitParameter("diaMes");
		String mes = arg0.getServletContext().getInitParameter("mes");
		String diaSemana = arg0.getServletContext().getInitParameter(
				"diaSemana");
		String ServerMail = arg0.getServletContext().getAttribute(
				"app.siga.serverMail").toString();
		String MailPort = arg0.getServletContext().getInitParameter("PortMail");
		try {
			schedTest(sf, segundo, minuto, hora, diaMes, mes, diaSemana,
					ServerMail, MailPort,arg0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que inicia la tarea a calendarizar
	 * 
	 * @param sf
	 *            Instancia de scheduler
	 * @param strServerMail
	 *            servidor de correo
	 * @param strPortMail
	 *            puerto de servidor de correo
	 * @throws Exception
	 *             manejor de errores del scheduler
	 */
	public static void schedTest(SchedulerFactory sf, String segundo,
			String minuto, String hora, String diaMes, String mes,
			String diaSemana, String ServerMail, String MailPort,ServletConfig servletConfig)
			throws Exception {

		try {
			sched = sf.getScheduler();

			JobDetail job = new JobDetail("job1", "group1", Principal.class);
			JobDataMap jdm = new JobDataMap();
			jdm.put("serverMail", ServerMail);
			jdm.put("mailPort", MailPort);
			jdm.put("servletContext", servletConfig.getServletContext());
			job.setJobDataMap(jdm);
			CronTrigger trigger = new CronTrigger("trigger1", "group1", "job1",
					"group1", "" + segundo + " " + minuto + " " + hora + " "
							+ diaMes + " " + mes + " " + diaSemana + "");
			sched.scheduleJob(job, trigger);
			sched.addJob(job, true);

			job = new JobDetail("job2", "group1", EnviaAlerta.class);
			jdm = new JobDataMap();
			jdm.put("serverMail", ServerMail);
			jdm.put("mailPort", MailPort);
			jdm.put("servletContext", servletConfig.getServletContext());
			job.setJobDataMap(jdm);
			trigger = new CronTrigger("trigger2", "group1", "job2", "group1",
					"" + segundo + " " + minuto + " " + hora + " " + diaMes
							+ " " + mes + " " + diaSemana + "");
			sched.scheduleJob(job, trigger);
			sched.addJob(job, true);

			job = new JobDetail("job3", "group1", EnviaAlertaInst.class);
			jdm = new JobDataMap();
			jdm.put("serverMail", ServerMail);
			jdm.put("mailPort", MailPort);
			jdm.put("servletContext", servletConfig.getServletContext());
			job.setJobDataMap(jdm);
			trigger = new CronTrigger("trigger3", "group1", "job3", "group1",
					"" + segundo + " " + minuto + " " + hora + " " + diaMes
							+ " " + mes + " " + diaSemana + "");
			sched.scheduleJob(job, trigger);
			sched.addJob(job, true);

			// Inicia tareas
			sched.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}
}
