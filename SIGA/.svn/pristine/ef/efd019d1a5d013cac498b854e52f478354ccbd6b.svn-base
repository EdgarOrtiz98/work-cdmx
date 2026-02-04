package com.meve.sigma.util;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaDiaFestivo;
import com.meve.sigma.actualiza.ActualizaRemitente;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLUsuario;

/**
 * Diversas utilerias independientes
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class Utilerias {

	/**
	 * Da formato a una fecha que es extraida de la Base de Datos
	 * 
	 * @param fecha
	 *            Contiene la fecha a formatear
	 * @return dd/mm/yyyy
	 */
	public static String formatearFechas(String fecha) {
		if (fecha == null) {
			fecha = "";
		}
		int dia = 0;
		int mes = 0;
		int year = 0;
		if (fecha.length() < 8)
			return "";
		StringTokenizer st = new StringTokenizer(fecha, "-");
		String diaf = "";
		String mesf = "";
		String yearf = "";

		yearf = st.nextToken();
		mesf = st.nextToken();
		diaf = st.nextToken();

		if (diaf.length() == 1)
			diaf = "0" + diaf;
		if (mesf.length() == 1)
			mesf = "0" + mesf;
		return diaf + "/" + mesf + "/" + yearf;
	}

	/**
	 * Da formato a una fecha que es extraida de la Base de Datos
	 * 
	 * @param strFecha
	 *            Contiene la fecha a formatear
	 * @return mm/dd/yyyy
	 */
	public static String FormateaFecha(String strFecha) {
		int dia = 0;
		int mes = 0;
		int anio = 0;
		if (strFecha.length() < 8)
			return "";
		StringTokenizer st = new StringTokenizer(strFecha, "/");
		String diaf = "";
		String aniof = "";
		String mesf = "";

		diaf = st.nextToken();
		mesf = st.nextToken();
		aniof = st.nextToken();
		/*
		 * dia=new Integer(diaf).intValue(); dia--; diaf=""+dia;
		 */
		if (diaf.length() == 1)
			diaf = "0" + diaf;
		if (mesf.length() == 1)
			mesf = "0" + mesf;
		return mesf + "/" + diaf + "/" + aniof;
	}

	/**
	 * Da formato a una fecha que es extraida de la Base de Datos
	 * 
	 * @param strFecha
	 *            Contiene la fecha a formatear
	 * @return dd/mm/aa
	 */
	public static String DeFormateaFecha(String strFecha) {
		int dia = 0;
		int mes = 0;
		int anio = 0;
		if (strFecha.length() < 8)
			return "";

		StringTokenizer st = new StringTokenizer(strFecha, "/");
		String diaf = "";
		String aniof = "";
		String mesf = "";

		mesf = st.nextToken();
		diaf = st.nextToken();
		aniof = st.nextToken();
		/*
		 * dia=new Integer(diaf).intValue(); dia++; diaf=""+dia;
		 */
		if (diaf.length() == 1)
			diaf = "0" + diaf;
		if (mesf.length() == 1)
			mesf = "0" + mesf;

		return diaf + "/" + mesf + "/" + aniof;
	}

	/**
	 * Metodo Recursivo
	 * 
	 * @param strFecha
	 *            es String y es la fecha en formato mm/dd/aaaa
	 * @return el Calendar respectivo a la fecha introducida
	 */
	public static Calendar StringCalendar(String strFecha) {
		int dia = 0;
		int mes = 0;
		int anio = 0;
		if (strFecha.length() < 8)
			return null;

		StringTokenizer st = new StringTokenizer(strFecha, "-");
		anio = new Integer(st.nextToken()).intValue();
		mes = new Integer(st.nextToken()).intValue();
		dia = new Integer(st.nextToken()).intValue();
		// //System.err.println("---->"+anio+mes+dia);
		Calendar c = Calendar.getInstance();
		c.set(anio, mes - 1, dia);

		return c;
	}

	/**
	 * Metodo Recursivo
	 * 
	 * @param strFecha
	 *            es String y es la fecha en formato dd/mm/aaaa
	 * @return el Calendar respectivo a la fecha introducida
	 */
	public static Calendar StringCalendar2(String strFecha) {
		int dia = 0;
		int mes = 0;
		int anio = 0;
		if (strFecha.length() < 8)
			return null;

		StringTokenizer st = new StringTokenizer(strFecha, "/");
		dia = new Integer(st.nextToken()).intValue();
		mes = new Integer(st.nextToken()).intValue();
		anio = new Integer(st.nextToken()).intValue();

		Calendar c = Calendar.getInstance();
		c.set(anio, mes - 1, dia);
		// //System.out.println("la fecha era "+ strFecha+"---> " +c.getTime());
		return c;
	}

	/**
	 * Determina los dias de trabajo entre dos fechas
	 * 
	 * @param Calendar1
	 *            Fecha Inicial
	 * @param Calendar2
	 *            Fecha Final
	 * @param iFines
	 * 
	 * @return Regresa los dias de trabajo
	 */
	public static int DiasdeTrabajoEntre(Calendar Calendar1,
			Calendar Calendar2, int iFines) {
		Calendar cl1 = new GregorianCalendar(Calendar1.get(Calendar.YEAR),
				Calendar1.get(Calendar.MONTH), Calendar1
						.get(Calendar.DAY_OF_MONTH));
		Calendar cl2 = new GregorianCalendar(Calendar2.get(Calendar.YEAR),
				Calendar2.get(Calendar.MONTH), Calendar2
						.get(Calendar.DAY_OF_MONTH));
		int iDiasFin = 0;
		int dias = 0;

		if (cl1.equals(cl2))
			return dias;
		if (cl1.after(cl2))
			return 0;
		while (cl1.before(cl2)) {
			cl1.add(Calendar.DATE, 1);
			if (cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				iDiasFin++;
			} else {
				dias++;
			}
		}
		return dias;

	}

	/**
	 * Determina los dias de trabajo entre dos fechas
	 * 
	 * @param Calendar1
	 *            Fecha Inicial
	 * @param Calendar2
	 *            Fecha Final
	 * @param iFines
	 * 
	 * @return Regresa los dias de trabajo
	 */
	public static int DiasdeTrabajoEntre1(Calendar Calendar1, Calendar Calendar2) {
		Calendar cl1 = new GregorianCalendar(Calendar1.get(Calendar.YEAR),
				Calendar1.get(Calendar.MONTH), Calendar1
						.get(Calendar.DAY_OF_MONTH));
		Calendar cl2 = new GregorianCalendar(Calendar2.get(Calendar.YEAR),
				Calendar2.get(Calendar.MONTH), Calendar2
						.get(Calendar.DAY_OF_MONTH));

		int iDiasFin = 0;
		int dias = 0;

		if (cl1.equals(cl2))
			return dias;
		if (cl1.after(cl2))
			return 0;
		while (cl1.before(cl2)) {
			cl1.add(Calendar.DATE, 1);
			if (cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				iDiasFin++;
			} else {
				dias++;
			}
		}
		return dias;

	}

	/**
	 * Cambia el valor de la columna 1 del arreglo por el valor "0"
	 * 
	 * @param strValores
	 *            Arreglo bidimensional de entrada
	 */
	public static void RecorreDocumentos2(String strValores[][]) {
		int i = 0;
		for (i = 0; i < strValores.length; i++) {
			// System.out.println(strValores[i][0]);
			strValores[i][1] = "0";
			// System.out.println(strValores[i][1]);
		}
	}

	/**
	 * Calcula el el tiempo en el que se deben terminar los Asuntos e
	 * Instrucciones
	 * 
	 * @param iDuracion
	 *            Duracion del documento
	 * @param strFechaInicio
	 *            Fecha inicial
	 * @param strFechaFinal
	 *            Fecha final
	 * @param iDiasSemana
	 *            Dias de la semana
	 * 
	 * @return Regresa un flotante con el semaforeo correspondiente
	 */
	public static float getPorcentajeDebido(int iDuracion,
			String strFechaInicio, String strFechaFinal, int iDiasSemana) {
		int iPorcentaje;
		int iFines = 0;
		float fDebido = 0;
		try {
			if (iDiasSemana == 7)
				iFines = 2;
			else if (iDiasSemana == 6)
				iFines = 1;
			else
				iFines = 0;

			int iDiasTrabajo = DiasdeTrabajoEntre(
					StringCalendar(strFechaInicio), Calendar.getInstance(),
					iFines);
			if (iDuracion == 0)
				fDebido = ((iDiasTrabajo * 100) / (float) 0.9);// 0;
			else
				fDebido = ((iDiasTrabajo * 100) / iDuracion);

			return fDebido;

		} catch (Exception e) {
			// System.out.println("getPorcentajeDebido:"+e);
			e.printStackTrace();
			return 0;
		}

	}

	/**
	 * Calcula la fecha en la que debe terminar un Asunto, tomando como
	 * referencia la fecha inicial y la duracion
	 * 
	 * @param cFechaInicio
	 *            Fecha de Inicio del Asunto
	 * @param strDuracion
	 *            Duracion en dias
	 * @return Regresa un String con formato dd/mm/yyyy
	 */
	public static String getFechaTerminacion(Calendar cFechaInicio,
			String strDuracion) {
		int iDuracion = new Integer(strDuracion).intValue();
		int m1 = 0;
		int iDiasFin = 0;

		String strFechaFin = "";
		/** ************************************************ */
		Calendar cl1 = new GregorianCalendar(cFechaInicio.get(Calendar.YEAR),
				cFechaInicio.get(Calendar.MONTH), cFechaInicio
						.get(Calendar.DAY_OF_MONTH));
		int i = 0;
		int iCont = 0;
		int u = 0;
		for (i = 0; i < iDuracion - 1; i++) {
			cl1.add(Calendar.DATE, 1);
			int as = cl1.get(Calendar.DATE);
			if (cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				iDiasFin++;
			}
		}
		if (iDiasFin > 0) {
			for (i = 0; i < iDiasFin; i++) {
				cl1.add(Calendar.DATE, 1);
				int as = cl1.get(Calendar.DATE);
				if (cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
						|| cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
					iDiasFin++;
				}
			}
		}
		int m = cl1.get(Calendar.MONTH);
		m1 = m + 1;
		strFechaFin = cl1.get(Calendar.DAY_OF_MONTH) + "/" + m1 + "/"
				+ cl1.get(Calendar.YEAR);
		return strFechaFin;
	}

	/**
	 * Calcula la fecha en la que debe terminar una instrucción, tomando como
	 * referencia la fecha inicial y la duracion
	 * 
	 * @param cFechaInicio
	 *            Fecha de Inicio de la instrucción
	 * @param strDuracion
	 *            Duracion en dias
	 * @return Regresa un String con formato dd/mm/yyyy
	 */
	public static String getFechaTerminacionInst(Calendar cFechaInicio,
			String strDuracion) {
		int iDuracion = new Integer(strDuracion).intValue();
		int m1 = 0;
		int iDiasFin = 0;

		String strFechaFin = "";

		Calendar cl1 = new GregorianCalendar(cFechaInicio.get(Calendar.YEAR),
				cFechaInicio.get(Calendar.MONTH), cFechaInicio
						.get(Calendar.DAY_OF_MONTH));
		int i = 0;
		int iCont = 0;
		int u = 0;
		for (i = 0; i < iDuracion; i++) {
			cl1.add(Calendar.DATE, 1);
			if (cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				iDiasFin++;
			}
		}
		if (iDiasFin > 0) {
			for (i = 0; i < iDiasFin; i++) {
				cl1.add(Calendar.DATE, 1);
				int as = cl1.get(Calendar.DATE);
				if (cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
						|| cl1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
					iDiasFin++;
				}
			}
		}
		int m = cl1.get(Calendar.MONTH);
		m1 = m + 1;
		String strMes = String.valueOf(m1);
		if (strMes.length() == 1)
			strMes = "0" + strMes;

		int d = cl1.get(Calendar.DAY_OF_MONTH);
		String strdia = String.valueOf(d);
		if (strdia.length() == 1)
			strdia = "0" + strdia;
		strFechaFin = strdia + "/" + strMes + "/" + cl1.get(Calendar.YEAR);
		return strFechaFin;
	}

	/**
	 * Calcula los dias entre dos fechas sin considerar fines de semana ni Días
	 * festivos
	 * 
	 * @param fechaInicio
	 *            Fecha de Inicio
	 * @param fechaFin
	 *            Fecha Final
	 * 
	 * @return Regresa los dias totales
	 */
	public static int getSinDiasFestivos(Calendar fechaInicio, Calendar fechaFin) {

		Calendar fInicio = new GregorianCalendar(
				fechaInicio.get(Calendar.YEAR),
				fechaInicio.get(Calendar.MONTH), fechaInicio
						.get(Calendar.DAY_OF_MONTH));
		Calendar fFin = new GregorianCalendar(fechaFin.get(Calendar.YEAR),
				fechaFin.get(Calendar.MONTH), fechaFin
						.get(Calendar.DAY_OF_MONTH));
		int iDuracion = 0;

		String[] strDiasFest = null;

		String strDiasFestivos[][] = ActualizaDiaFestivo.getListaDiasFestivos();
		for (int i = 0; i < strDiasFestivos.length; i++) {
			Calendar c1 = StringCalendar2(formatearFechas(strDiasFestivos[i][1]));
			Calendar c2 = new GregorianCalendar(c1.get(Calendar.YEAR), c1
					.get(Calendar.MONTH), c1.get(Calendar.DAY_OF_MONTH));
			int m = c2.get(Calendar.MONTH);
			if ((fInicio.before(c2) && fFin.after(c2)
					&& !(c2.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) && !(c2
					.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY))
					|| fInicio.equals(c2) || fFin.equals(c2)) {
				iDuracion++;
			}
		}
		return iDuracion;
	}

	/**
	 * Determina si la fecha de creacion es un dia no laborable, y en caso de
	 * ser cierto recalcula la fecha de creacion al proximo dia laborable
	 * 
	 * @param strFechaInicio
	 *            Fecha de creacion del Asunto o instrucción
	 * 
	 * @return Regresa un String con la nueva fecha de Creación
	 */
	public static String getFechaInicio(String strFechaInicio, String horaE,
			String horaS) {

		int iDuracion = 0;
		int iDur = 0;
		String strFechaIni = "";
		Calendar cInicio = StringCalendar2(strFechaInicio);
		String strDiasFestivos[][] = null;

		strDiasFestivos = ActualizaDiaFestivo.getListaDiasFestivos();
		if (( /* cInicio.get(Calendar.HOUR_OF_DAY) */ActualizaAsunto.getHora() >= Integer
				.parseInt(horaE)
				&& // Hora de entrada
				/* cInicio.get(Calendar.HOUR_OF_DAY) */ActualizaAsunto.getHora() <= Integer
						.parseInt(horaS) && // Hora de salida
		!(cInicio.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cInicio
				.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY))) {
			int m = cInicio.get(Calendar.MONTH);
			int m1 = m + 1;
			strFechaIni = cInicio.get(Calendar.DAY_OF_MONTH) + "/" + m1 + "/"
					+ cInicio.get(Calendar.YEAR);
			Calendar Finicio = StringCalendar2(strFechaInicio);
			boolean bSiesDiafestivo = false;
			for (int i = 0; i < strDiasFestivos.length; i++) {
				String fechaCambio = formatearFechas(strDiasFestivos[i][1]);
				Calendar Ff = StringCalendar2(fechaCambio);
				boolean bFecha = Finicio.equals(Ff);
				if (bFecha)
					bSiesDiafestivo = true;
			}

			if (bSiesDiafestivo) {
				iDuracion++;
				String strFin = Utilerias.getFechaTerminacionInst(
						(Calendar) Finicio.clone(), String.valueOf(iDuracion));
				Calendar FF = Utilerias.StringCalendar2(strFin);

				boolean bDiaSin = false;
				for (int i = 0; i < strDiasFestivos.length; i++) {
					String fechaCambio = formatearFechas(strDiasFestivos[i][1]);
					Calendar Ff = StringCalendar2(fechaCambio);
					boolean bFecha = FF.equals(Ff);
					if (bFecha) {
						bDiaSin = true;
					}
				}
				if (bDiaSin)
					iDur = Utilerias.getSinDiasFestivos(Finicio, FF);
				else
					iDur = 0;
				String strDuracion = String.valueOf(iDur);
				strFechaIni = Utilerias.getFechaTerminacionInst((Calendar) FF
						.clone(), strDuracion);
			}
		} else if (cInicio.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			cInicio.add(Calendar.DATE, 2);
			int m = cInicio.get(Calendar.MONTH);
			int m1 = m + 1;
			strFechaIni = cInicio.get(Calendar.DAY_OF_MONTH) + "/" + m1 + "/"
					+ cInicio.get(Calendar.YEAR);

			Calendar Finicio = StringCalendar2(strFechaIni);

			boolean bSiesDiafestivo = false;
			for (int i = 0; i < strDiasFestivos.length; i++) {
				String fechaCambio = formatearFechas(strDiasFestivos[i][1]);
				Calendar Ff = StringCalendar2(fechaCambio);
				boolean bFecha = Finicio.equals(Ff);
				if (bFecha) {
					bSiesDiafestivo = true;
					// iDur++;
				}
			}

			if (bSiesDiafestivo) {
				iDuracion++;
				String strFin = Utilerias.getFechaTerminacionInst(
						(Calendar) Finicio.clone(), String.valueOf(iDuracion));
				Calendar FF = Utilerias.StringCalendar2(strFin);

				boolean bDiaSin = false;
				for (int i = 0; i < strDiasFestivos.length; i++) {
					String fechaCambio = formatearFechas(strDiasFestivos[i][1]);
					Calendar Ff = StringCalendar2(fechaCambio);
					boolean bFecha = FF.equals(Ff);
					if (bFecha) {
						bDiaSin = true;
					}
				}
				if (bDiaSin)
					iDur = Utilerias.getSinDiasFestivos(Finicio, FF);
				else
					iDur = 0;
				String strDuracion = String.valueOf(iDur);
				strFechaIni = Utilerias.getFechaTerminacionInst((Calendar) FF
						.clone(), strDuracion);
			}

		} else if (cInicio.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cInicio.add(Calendar.DATE, 1);
			int m = cInicio.get(Calendar.MONTH);
			int m1 = m + 1;
			strFechaIni = cInicio.get(Calendar.DAY_OF_MONTH) + "/" + m1 + "/"
					+ cInicio.get(Calendar.YEAR);

			Calendar Finicio = StringCalendar2(strFechaIni);

			boolean bSiesDiafestivo = false;
			for (int i = 0; i < strDiasFestivos.length; i++) {
				String fechaCambio = formatearFechas(strDiasFestivos[i][1]);
				Calendar Ff = StringCalendar2(fechaCambio);
				boolean bFecha = Finicio.equals(Ff);
				if (bFecha) {
					bSiesDiafestivo = true;
					// iDur++;
				}
			}

			if (bSiesDiafestivo) {
				iDuracion++;
				String strFin = Utilerias.getFechaTerminacionInst(
						(Calendar) Finicio.clone(), String.valueOf(iDuracion));
				Calendar FF = Utilerias.StringCalendar2(strFin);

				boolean bDiaSin = false;
				for (int i = 0; i < strDiasFestivos.length; i++) {
					String fechaCambio = formatearFechas(strDiasFestivos[i][1]);
					Calendar Ff = StringCalendar2(fechaCambio);
					boolean bFecha = FF.equals(Ff);
					if (bFecha) {
						bDiaSin = true;
					}
				}
				if (bDiaSin)
					iDur = Utilerias.getSinDiasFestivos(Finicio, FF);
				else
					iDur = 0;
				String strDuracion = String.valueOf(iDur);
				strFechaIni = Utilerias.getFechaTerminacionInst((Calendar) FF
						.clone(), strDuracion);
			}

		} else {
			/*
			 * String strFechaFin =
			 * Utilerias.getFechaTerminacionInst((Calendar)cInicio.clone(),
			 * "1");
			 * 
			 * Calendar FI = Utilerias.StringCalendar2(strFechaInicio); Calendar
			 * FF = Utilerias.StringCalendar2(strFechaFin); iDuracion =
			 * Utilerias.getSinDiasFestivos(FI, FF); String strDuracion =
			 * String.valueOf(iDuracion); strFechaIni =
			 * Utilerias.getFechaTerminacionInst((Calendar)FF.clone(),
			 * strDuracion);
			 */
			// System.err.println("b4");
			int m = cInicio.get(Calendar.MONTH);
			int m1 = m + 1;
			strFechaIni = cInicio.get(Calendar.DAY_OF_MONTH) + "/" + m1 + "/"
					+ cInicio.get(Calendar.YEAR);
			Calendar Finicio = StringCalendar2(strFechaInicio);
			boolean bSiesDiafestivo = false;
			for (int i = 0; i < strDiasFestivos.length; i++) {
				String fechaCambio = formatearFechas(strDiasFestivos[i][1]);
				Calendar Ff = StringCalendar2(fechaCambio);
				boolean bFecha = Finicio.equals(Ff);
				if (bFecha)
					bSiesDiafestivo = true;
			}

			if (bSiesDiafestivo) {
				iDuracion++;
				String strFin = Utilerias.getFechaTerminacionInst(
						(Calendar) Finicio.clone(), String.valueOf(iDuracion));
				Calendar FF = Utilerias.StringCalendar2(strFin);

				boolean bDiaSin = false;
				for (int i = 0; i < strDiasFestivos.length; i++) {
					String fechaCambio = formatearFechas(strDiasFestivos[i][1]);
					Calendar Ff = StringCalendar2(fechaCambio);
					boolean bFecha = FF.equals(Ff);
					if (bFecha) {
						bDiaSin = true;
					}
				}
				if (bDiaSin)
					iDur = Utilerias.getSinDiasFestivos(Finicio, FF);
				else
					iDur = 0;
				String strDuracion = String.valueOf(iDur);
				strFechaIni = Utilerias.getFechaTerminacionInst((Calendar) FF
						.clone(), strDuracion);
			}
		}
		return strFechaIni;
	}

	/**
	 * Funcion que compara dos fechas, donde si CFechaIni esta antes de la fecha
	 * actual devuelve un true, que determina si el asunto esta atrasado
	 * 
	 * @param CFechaIni
	 *            Fecha de Vencimiento de un asunto sin turnar
	 * @param CFechaFin
	 *            Fecha Actual en la que se genera el reporte
	 * 
	 * @return Regresa un True si el Asunto esta atrasado y False en caso
	 *         contrario
	 */
	public static boolean fechasAtrasadas(Calendar CFechaIni, Calendar CFechaFin) {
		/*
		 * Calendar1 = new GregorianCalendar(2005,4,24); Calendar2 =new
		 * GregorianCalendar(2005,4,24);
		 */
		Calendar cl1 = new GregorianCalendar(CFechaIni.get(Calendar.YEAR),
				CFechaIni.get(Calendar.MONTH), CFechaIni
						.get(Calendar.DAY_OF_MONTH));
		Calendar cl2 = new GregorianCalendar(CFechaFin.get(Calendar.YEAR),
				CFechaFin.get(Calendar.MONTH), CFechaFin
						.get(Calendar.DAY_OF_MONTH));
		boolean bAtrasado = false;
		if (cl1.equals(cl2))
			bAtrasado = false;
		if (cl1.before(cl2)) {
			bAtrasado = true;
		} else {
			bAtrasado = false;
		}
		return bAtrasado;
	}

	/**
	 * Convierte un String con nombres separados por "," a un vector con cada
	 * uno de los nombres
	 * 
	 * @param strNombres
	 *            String de nombres
	 * 
	 * @return Regresa un Vector de nombres
	 */
	public static Vector getNombres(String strNombres) {
		Vector lista = new Vector();
		if (strNombres.length() != 0) {
			StringTokenizer strtST = new StringTokenizer(strNombres, ",");

			while (strtST.hasMoreElements()) {
				lista.add(strtST.nextToken());
			}
		}

		return lista;
	}

	/**
	 * Convierte un String con nombres separados por "|" a un vector con cada
	 * uno de los nombres
	 * 
	 * @param strNombres
	 *            String de nombres
	 * 
	 * @return Regresa un Vector de nombres
	 */
	public static Vector getNombres1(String strNombres) {
		Vector lista = new Vector();
		if (strNombres.length() != 0) {
			StringTokenizer strtST = new StringTokenizer(strNombres, "|");

			while (strtST.hasMoreElements()) {
				lista.add(strtST.nextToken());
			}
		}

		return lista;
	}

	/**
	 * Convierte un String con nombres separados por "," a un String de nombres
	 * separados por un salto de lines <BR>
	 * en HTML
	 * 
	 * @param strNombres
	 *            String de nombres
	 * 
	 * @return Regresa un String de nombres
	 */
	public static String getNombresString(String strNombres) {
		String lista = "";
		if (strNombres.length() != 0) {
			StringTokenizer strtST = new StringTokenizer(strNombres, ",");

			while (strtST.hasMoreElements()) {
				lista += strtST.nextToken() + "<BR>";
				strtST.nextToken();
			}
		}

		return lista;
	}

	/**
	 * Convierte un String con nombres separados por "," a un String de nombres
	 * separados por ","
	 * 
	 * @param strNombres
	 *            String de nombres
	 * 
	 * @return Regresa un String de nombres
	 */
	public static String getNombresStringReporte(String strNombres) {
		String lista = "";
		if (strNombres.length() != 0) {
			StringTokenizer strtST = new StringTokenizer(strNombres, ",");

			while (strtST.hasMoreElements()) {
				lista += strtST.nextToken() + ",";
				strtST.nextToken();
			}
		}

		return lista;
	}

	/**
	 * Recorta un String si este es de longitud mayor a n caracteres y le coloca
	 * puntos suspensivos al final
	 * 
	 * @param cadena
	 *            String de entrada
	 * @param n
	 *            numero de caracteres limite
	 * 
	 * @return Regresa un String de nombres
	 */
	public static String recortaString(String cadena, int n) {
		if (cadena != null && cadena.length() > 0) {
			cadena = (cadena.length() >= n) ? (cadena.substring(0, n) + "...")
					: cadena;
		}
		return cadena;
	}

	/**
	 * Cambia los saltos de linea "\n" por su correspondiente en HTML <BR>
	 * 
	 * @param cadena
	 *            String de entrada
	 * @return String de salida
	 */
	public static String cambioSaltosDeLinea(String cadena) {

		String aux = cadena;
		while (aux != null && aux.indexOf("\n") != -1) {
			int n = aux.indexOf("\n");
			aux = aux.substring(0, n) + "<BR>"
					+ aux.substring(n + 1, aux.length());
		}
		return aux;
	}

	/**
	 * Calcula la duración de dias entre 2 fechas, por default no se toma en
	 * cuenta los sabados y domingos
	 * 
	 * @param fechaInicio
	 *            Fecha Inicial
	 * @param fechaFin
	 *            Fecha Final
	 * 
	 * @return Regresa los dias Totales
	 */
	public static int getDuracion(Calendar fechaInicio, Calendar fechaFin) {

		Calendar fInicio = new GregorianCalendar(
				fechaInicio.get(Calendar.YEAR),
				fechaInicio.get(Calendar.MONTH), fechaInicio
						.get(Calendar.DAY_OF_MONTH));
		Calendar fFin = new GregorianCalendar(fechaFin.get(Calendar.YEAR),
				fechaFin.get(Calendar.MONTH), fechaFin
						.get(Calendar.DAY_OF_MONTH));
		int iDuracion = 0;

		int iDiasFin = 0;
		int dias = 0;

		if (fInicio.equals(fFin))
			return 0;
		if (fInicio.after(fFin))
			return 0;
		while (fInicio.before(fFin)) {
			fInicio.add(Calendar.DATE, 1);
			if (fInicio.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| fInicio.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				iDiasFin++;
			} else {
				if (!fInicio.equals(fFin)) {
					dias++;
				} else {
					dias++;
				}
			}
		}
		return dias;
	}

	/**
	 * Compara la fecha compromiso con la fecha calculada a partir de el tiempo
	 * estimado de una instrucción
	 * 
	 * @param strDur
	 *            Tiempo estimado de la instrucción
	 * @param strIdAsunto
	 *            ID del Asunto
	 * 
	 * @return Regresa un True si la fecha calculada es igual o menor a la de
	 *         compromiso
	 */
	public static boolean calculoFecha(String strDur, String strIdAsunto) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date f = new Date();
		String strFechaCreacion = sdf.format(f);
		String strDatos[][] = null;
		try {
			strDatos = ActualizaAsunto.getFechaVencimiento(strIdAsunto);
		} catch (SQLException io) {
			// System.err.println("io="+io);
		}

		Calendar cFechaInicio = StringCalendar2(strFechaCreacion);
		String strFechaFin = getFechaTerminacionInst((Calendar) cFechaInicio
				.clone(), strDur);
		Calendar cFechaFin = StringCalendar2(strFechaFin);
		int iDuracion = getSinDiasFestivos(cFechaInicio, cFechaFin);
		String strDuracion = String.valueOf(iDuracion);
		strFechaFin = getFechaTerminacionInst((Calendar) cFechaFin.clone(),
				strDuracion);

		Calendar CCalculada = StringCalendar2(strFechaFin);
		Calendar CCompromiso = StringCalendar2(strDatos[0][0]);

		Calendar fCalculada = new GregorianCalendar(CCalculada
				.get(Calendar.YEAR), CCalculada.get(Calendar.MONTH), CCalculada
				.get(Calendar.DAY_OF_MONTH));
		Calendar fCompromiso = new GregorianCalendar(CCompromiso
				.get(Calendar.YEAR), CCompromiso.get(Calendar.MONTH),
				CCompromiso.get(Calendar.DAY_OF_MONTH));

		if (fCalculada.equals(fCompromiso) || fCalculada.before(fCompromiso))
			return true;
		else
			return false;
	}

	/**
	 * Codifica los caracteres reservados de una cadena a su equivalente HTML
	 * para transmision por URL
	 * 
	 * @param cadena
	 *            String para codificar
	 * @return Regresa un String codificado
	 */
	public static String codificaPostHTML(String cadena) {

		int j = 0;
		while (cadena.indexOf('%', j) != -1) {
			int i = cadena.indexOf('%', j);
			j = i + 1;
			String aux = cadena.substring(0, i) + "%25"
					+ cadena.substring(i + 1, cadena.length());
			cadena = aux;
		}
		while (cadena.indexOf('?') != -1) {
			int i = cadena.indexOf('?');
			String aux = cadena.substring(0, i) + "%3F"
					+ cadena.substring(i + 1, cadena.length());
			cadena = aux;
		}
		while (cadena.indexOf('&') != -1) {
			int i = cadena.indexOf('&');
			String aux = cadena.substring(0, i) + "%26"
					+ cadena.substring(i + 1, cadena.length());
			cadena = aux;
		}
		while (cadena.indexOf(' ') != -1) {
			int i = cadena.indexOf(' ');
			String aux = cadena.substring(0, i) + "%20"
					+ cadena.substring(i + 1, cadena.length());
			cadena = aux;
		}
		return cadena;
	}

	/**
	 * Compara dos fechas
	 * 
	 * @param fechaInicio
	 *            Fecha inicial
	 * @param fechaFin
	 *            Fecha Final
	 * @return Regresa 1 si las fechas son iguales o la fecha icnicial es mayor
	 *         a las final. Regresa 2 si la fecha inicial es menor a la final
	 */
	public static int comparaFechas(String fechaInicio, String fechaFin) {

		Calendar FI = StringCalendar(fechaInicio);
		Calendar FF = StringCalendar(fechaFin);

		Calendar fInicio = new GregorianCalendar(FI.get(Calendar.YEAR), FI
				.get(Calendar.MONTH), FI.get(Calendar.DAY_OF_MONTH));
		Calendar fFin = new GregorianCalendar(FF.get(Calendar.YEAR), FF
				.get(Calendar.MONTH), FF.get(Calendar.DAY_OF_MONTH));

		int valor = 0;

		if (fInicio.equals(fFin))
			valor = 1;
		if (fInicio.after(fFin))
			valor = 1;
		if (fInicio.before(fFin))
			valor = 2;

		return valor;
	}

	/**
	 * Detecta si un String contiene ciertos caracteres
	 * 
	 * @param texto
	 *            String de entrada
	 * @return Regresa True si encuentra alguno de los caracteres y False en
	 *         caso contrario
	 */
	public static boolean detectaCEBuscar(String texto) {

		if (texto.indexOf('%') >= 0 || texto.indexOf('\'') >= 0
				|| texto.indexOf('&') >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Recorta la parte dedimal de un numero Flotante a 2 digitos
	 * 
	 * @param strValor
	 *            Numero que se quiere recortar
	 * @return Regresa el numero con parte decinal de dos digitos
	 */
	public static String getNumeroFlotante(String strValor) {
		float fPromedio = new Float(strValor).floatValue();
		NumberFormat df = NumberFormat.getNumberInstance();
		df.setMaximumFractionDigits(2);
		String strNumero = df.format(fPromedio);
		return strNumero;
	}

	/**
	 * Función para calcular los fines de semana que no son laborables
	 * 
	 * @param aAtras
	 *            Numero de Años atras de la fecha actual
	 * @param aAdelante
	 *            Numero de adelante de la fecha acutal
	 * @return Regresa un Vector con todas las fechas correspondientes a Fines
	 *         de semana
	 */
	public static Vector getFinesSemana(int aAtras, int aAdelante) {
		Vector arregloFechas = new Vector();
		Date fecha = new Date();
		fecha.setTime(fecha.getTime() - ((long) aAtras * 31536000000l));
		for (int i = 0; i < (365 * (aAtras + aAdelante)); i++) {
			if (fecha.getDay() == 6 || fecha.getDay() == 0) {
				String dia = (((fecha.getDate()) < 10) ? "0"
						+ (fecha.getDate()) : "" + (fecha.getDate()));
				String mes = (((fecha.getMonth() + 1) < 10) ? "0"
						+ (fecha.getMonth() + 1) : "" + (fecha.getMonth() + 1));
				String anio = "" + (fecha.getYear() + 1900);
				String fechasFines = "" + dia + "/" + mes + "/" + anio;
				arregloFechas.add(fechasFines);
			}
			fecha.setTime(fecha.getTime() + 86400000l);
		}
		return arregloFechas;
	}

	/**
	 * Función que regresa un Vector con el nombre del responsable y el puesto
	 * concatenados
	 * 
	 * @param strNombres
	 *            ID's de los puestos
	 * @return Regresa un Vector con Nombre/Puesto en cada posición
	 */
	public static Vector getNombrePuesto(String strNombres, int y) {
		Vector lista = new Vector();
		Vector vNomPue = new Vector();

		String strTitulo = "";
		if (strNombres.length() != 0) {
			StringTokenizer strtST = new StringTokenizer(strNombres, ",");

			while (strtST.hasMoreElements()) {
				lista.add(strtST.nextToken());
			}
		}
		String strNombre = "";
		String strPuesto = "";
		String strUA = "";
		for (int i = 0; i < lista.size(); i++) {
			strNombre = ActualizaUsuario.NombreUsuario((String) lista.get(i));
			strPuesto = ActualizaUsuario.NombrePuesto((String) lista.get(i));
			strUA = ActualizaArea.NombreArea(ActualizaUsuario
					.getIdAreaUs((String) lista.get(i)));
			vNomPue.add(strNombre + "/" + strPuesto + " -- " + strUA);
		}

		return vNomPue;
	}

	/**
	 * Convierte un vector a String separado por "|"
	 * 
	 * @param vParaCC
	 *            Vector de entrada
	 * @return String de salida
	 */
	public static String getCadenaParaCC(Vector vParaCC) {
		String strCadena = "";
		for (int i = 0; i < vParaCC.size(); i++) {
			strCadena += vParaCC.get(i) + "|";
		}
		return strCadena;
	}

	/**
	 * Convierte un vector a String separado por ","
	 * 
	 * @param vParaCC
	 *            Vector de entrada
	 * @return String de salida
	 */
	public static String getCadenaBajarLinea(Vector vParaCC) {
		String strCadena = "";
		for (int i = 0; i < vParaCC.size(); i++) {
			strCadena += vParaCC.get(i) + "\n";
		}
		return strCadena;
	}

	/**
	 * Función que regresa un Vector con el nombre del remitente y la entidad a
	 * la que pertenece
	 * 
	 * @param strNombres
	 *            String con ID's separados por ","
	 * @return Vectos resultante
	 */
	public static Vector getRemitenteEntidad(String strNombres, int y) {
		Vector lista = new Vector();
		Vector vRemEnt = new Vector();
		String strTitulo = "";
		/*
		 * if(y==0){ strTitulo = "Para Externos:"; vRemEnt.add(strTitulo);
		 * vRemEnt.add(" "); vRemEnt.add(" "); }else{ strTitulo = ""; }
		 */
		if (strNombres.length() != 0) {
			StringTokenizer strtST = new StringTokenizer(strNombres, ",");

			while (strtST.hasMoreElements()) {
				lista.add(strtST.nextToken());
			}
		}
		String strNombre = "";
		for (int i = 0; i < lista.size(); i++) {
			strNombre = ActualizaRemitente.getDestExt((String) lista.get(i));
			vRemEnt.add(strNombre);
		}

		return vRemEnt;
	}

	/**
	 * Convierte un String con nombres separados por "," a un String de nombres
	 * separados por ","
	 * 
	 * @param strNombres
	 *            String de nombres
	 * 
	 * @return String resultante
	 */
	public static String getDatosIn(String strNombres) {
		String strCadena = "";
		if (strNombres.length() != 0) {
			StringTokenizer strtST = new StringTokenizer(strNombres, ",");
			while (strtST.hasMoreElements()) {
				strCadena += strtST.nextToken() + ",";
			}
		}
		return strCadena.substring(0, strCadena.length() - 1).trim();
	}

	/**
	 * Función que regresa un ArrayList con el nombre del responsable y el
	 * puesto concatenados
	 * 
	 * @param strNombres
	 *            ID's de los puestos
	 * @return Regresa un ArrayList con Nombre/Puesto en cada posición
	 */
	public static ArrayList getNombrePuestoList(String strNombres) {
		Vector lista = new Vector();
		ArrayList alLista = new ArrayList();
		if (strNombres.length() != 0) {
			StringTokenizer strtST = new StringTokenizer(strNombres, ",");

			while (strtST.hasMoreElements()) {
				lista.add(strtST.nextToken());
			}
		}
		String strNombre = "";
		String strPuesto = "";
		for (int i = 0; i < lista.size(); i++) {
			strNombre = ActualizaUsuario.NombreUsuario((String) lista.get(i));
			strPuesto = ActualizaUsuario.NombrePuesto((String) lista.get(i));
			alLista.add(strNombre + "/" + strPuesto);
		}

		return alLista;
	}

	/**
	 * Función que regresa un ArrayList con el nombre del Remitente
	 * 
	 * @param strNombres
	 *            ID's de los puestos
	 * @return Regresa un ArrayList con Nombre/Puesto en cada posición
	 */
	public static ArrayList getRemitenteEntidadLista(String strNombres) {
		Vector lista = new Vector();
		ArrayList alLista = new ArrayList();
		if (strNombres.length() != 0) {
			StringTokenizer strtST = new StringTokenizer(strNombres, ",");

			while (strtST.hasMoreElements()) {
				lista.add(strtST.nextToken());
			}
		}
		String strNombre = "";
		for (int i = 0; i < lista.size(); i++) {
			strNombre = ActualizaRemitente.getDestExt((String) lista.get(i));
			alLista.add(strNombre);
		}

		return alLista;
	}

	/**
	 * Agrega ceros al consecutivo para hacerlo de un longitud fija
	 * 
	 * @param iCount
	 *            Numero del consecutivo
	 * @return String con el consecutivo de longitud fija
	 */
	public static String getAgregarCeros(int iCount) {
		String strConsecutivo = "";
		String strTemp = String.valueOf(iCount);
		if (strTemp.length() == 1)// 1
			strConsecutivo = "0000000" + strTemp;
		if (strTemp.length() == 2)// 11
			strConsecutivo = "000000" + strTemp;
		if (strTemp.length() == 3)// 111
			strConsecutivo = "00000" + strTemp;
		if (strTemp.length() == 4)// 1111
			strConsecutivo = "0000" + strTemp;
		if (strTemp.length() == 5)// 11111
			strConsecutivo = "000" + strTemp;
		if (strTemp.length() == 6)// 111111
			strConsecutivo = "00" + strTemp;
		if (strTemp.length() == 7)// 1111111
			strConsecutivo = "0" + strTemp;
		if (strTemp.length() == 8)// 1111111
			strConsecutivo = strTemp;
		return strConsecutivo;

	}

	/**
	 * determina si un usuario es jefe a cualquiere nivel de los usuarios dentro
	 * de los parametros Para, CC y ruta de atención de un asunto
	 * 
	 * @param strIdUsuario
	 *            ID del usuario
	 * @param strIdsPara
	 *            String que contiene los ID separados por ","
	 * @param strIdsCC
	 *            String que contiene los ID separados por ","
	 * @param strRuta
	 *            Arreglo bidimensional con los ID's de la ruta de atención
	 * 
	 * @return Regresa True si el usuario es jefe a cualquier nivel de
	 *         cualquiera de los parametros de entrada y False en caso contrario
	 */
	public static boolean getAccesoJefes(String strIdUsuario,
			String strIdsPara, String strIdsCC, String[][] strRuta) {

		String strUsuarios[][] = ActualizaUsuario
				.getSubalternoSinRol(strIdUsuario);
		Arboles tree = new Arboles(strUsuarios);
		Vector vIdSubalternos = tree.getIds();
		boolean accJefes = false;

		if (vIdSubalternos.size() > 0) {
			StringTokenizer strToken = new StringTokenizer(strIdsPara, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				for (int i = 0; i < vIdSubalternos.size(); i++) {
					if (aux.equals((String) vIdSubalternos.get(i))) {						
						accJefes = true;
					}
				}
				if (aux.equals(strIdUsuario)) {					
					accJefes = true;
				}
			}
			strToken = new StringTokenizer(strIdsCC, ",");
			while (strToken.hasMoreTokens()) {
				String aux = strToken.nextToken().trim();
				for (int i = 0; i < vIdSubalternos.size(); i++) {
					if (aux.equals((String) vIdSubalternos.get(i))) {						
						accJefes = true;
					}
				}
				if (aux.equals(strIdUsuario)) {					
					accJefes = true;
				}
			}
			if (strRuta != null && strRuta.length > 0) {
				for (int j = 0; j < strRuta.length; j++) {
					String aux = strRuta[j][0];
					for (int i = 0; i < vIdSubalternos.size(); i++) {
						if (aux.equals((String) vIdSubalternos.get(i))) {							
							accJefes = true;
						}
					}
					if (aux.equals(strIdUsuario)) {						
						accJefes = true;
					}
				}
			}
		}

		return accJefes;
	}

	
	

	/**
	 * Compara la fecha y hora en strFecha con la fecha y hora actual
	 * 
	 * @param strFecha
	 *            Fecha para comparar en formato "DD/MM/YYYY HH:MI:SS"
	 * @return Regresa True si la Fecha y Hora actual es mayor o igual la de
	 *         comparación o regresa False en caso contrario
	 */
	public static boolean comparaFechaActual(String strFecha) {
		try {
			String sql = "SELECT COUNT(SYSDATE) " + "FROM DUAL "
					+ "WHERE SYSDATE >= TO_DATE('" + strFecha
					+ "','DD/MM/YYYY HH24:MI:SS')";

			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			if (strResult != null && strResult.length > 0) {
				return (strResult[0][0].equals("1")) ? true : false;
			} else {
				return false;
			}
		} catch (SQLException sqle) {
			// System.out.println("comparaFechaActual: "+sqle);
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Obtiene la fecha actual del sistema
	 * 
	 * @return Regresa la fecha actual DD/MM/YYYY
	 */
	public static String getFechaActual() {
		try {
			String sql = "SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM DUAL";

			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			if (strResult != null && strResult.length > 0) {
				return strResult[0][0];
			} else {
				return null;
			}
		} catch (SQLException sqle) {
			// System.out.println("getFechaActual: "+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	public static String getHora() {
		Calendar rightNow = Calendar.getInstance();
		int hora = rightNow.get(Calendar.HOUR_OF_DAY);
		String horaescribe = new Integer(hora).toString();
		if (horaescribe.length() < 2)
			horaescribe = "0" + horaescribe;
		return horaescribe;
	}

	/**
	 * 
	 * @return
	 */
	public static String getMinuto() {
		Calendar rightNow = Calendar.getInstance();
		int minutoint = rightNow.get(Calendar.MINUTE);
		String minuto = new Integer(minutoint).toString();
		if (minuto.length() < 2)
			minuto = "0" + minuto;
		return minuto;

	}

	public static boolean isIdInString(String id, String ids) {
		if (ids != null) {
			StringTokenizer st = new StringTokenizer(ids, ",");
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				if (id.equals(token.trim())) {
					return true;
				}
			}
		}
		return false;
	}

}
