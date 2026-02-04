/*
 **************************************************************
 * Copyright (C) 2007 SHCP
 * CGTIyC - alejandro_gavia@hacienda.gob.mx
 *
 * $$Archivo: 	tablaInstruccionesBean.java
 * $$Revisión: 	DARG - Clase para encapsular los datos del Bean de Sesión que se
 *              utiliza en la tabla de instrucciones.
 *
 * $$Fecha: 	15 de Enero de 2007
 *
 * Este software es información propietaria y confidencial de la SHCP - CGTIyC.
 ***************************************************************
 */

package gob.hacienda.cgtic.siga.beans;

import gob.hacienda.cgtic.siga.Instruccion;
import gob.hacienda.cgtic.siga.Puesto;

import java.sql.SQLException;
import java.util.Hashtable;

import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaPaso;
import com.meve.sigma.db2.ConexionDS;

public class tablaInstruccionesBean {

	private int lastIndexRow = 0;
	private String idAsunto;
	private String idInstr;
	private int tipoTabla;

	// Constantes para diferenciar el tipo de tabla a construir
	public static int TIPO_DELEGADO = 0;
	public static int TIPO_TURNADO = 1;
	private Object[] row = new Object[12];
	private int[] rowDel = new int[256];
	private int[] rowUpgrade = new int[256];
	private int intDel = 0;
	private int intUpgrade = 0;
	private boolean isDeleteZero = false;

	Hashtable tableInstr = new Hashtable();

	public void setTipoTabla(int t) {
		this.tipoTabla = t;
	}

	public int getTipoTabla() {
		return this.tipoTabla;
	}

	public tablaInstruccionesBean(String idAsunto, String idInstr) {
		this.idAsunto = idAsunto;
		this.idInstr = idInstr;
		this.lastIndexRow = 0;
		this.intDel = 0;
		createTable();
	}

	private void createTable() {
		boolean loadRows = false;
		Instruccion instr = new Instruccion();
		String[][] regInstr = instr.getInstruccionesRelacionadas(this.idAsunto,
				this.idInstr);

		for (int i = 0; i < regInstr.length; i++) {
			Object[] rowTmp = new Object[14];
			// indexRow
			rowTmp[0] = new Integer(i);
			// INS.ID_INSTRUCCION_ASUNTO,
			rowTmp[1] = regInstr[i][0];
			// INS.INS_USUARIO,
			rowTmp[2] = regInstr[i][1];
			// USU.USU_NOMBRE,
			rowTmp[3] = regInstr[i][2];
			// INS.INS_INSTRUCCION,
			rowTmp[4] = regInstr[i][3];
			// INS.INS_TIPO_ATENCION,
			rowTmp[5] = regInstr[i][4];
			// INS.INS_TIEMPO,
			rowTmp[6] = regInstr[i][5];
			// INS.INS_ACCESO,
			rowTmp[7] = regInstr[i][6];
			// INS.INS_REQUERIDO,
			rowTmp[8] = regInstr[i][7];
			// INS.INS_CONFIDENCIAL,
			rowTmp[9] = regInstr[i][8];
			// INS_INSTRUCCION
			if (regInstr[i][3] == "") {
				rowTmp[10] = "";
			} else {
				rowTmp[10] = instr.getInstructionById(Integer
						.parseInt(regInstr[i][3]));
			}
			// INS.INS_INSTRUCCION_OTRO
			rowTmp[11] = regInstr[i][9];

			// INS.INS_ESTATUS
			rowTmp[12] = regInstr[i][10];

			// INS.INS_AUTO
			rowTmp[13] = regInstr[i][11];

			this.tableInstr.put(new Integer(i), rowTmp.clone());
			this.lastIndexRow = i;
			loadRows = true;
		}
		if (loadRows)
			this.lastIndexRow++;

	}

	public void insertRow(int Acceso, int Requerido, int idPuesto,
			int idInstruccion, String Instr, String TA, int tiemp) {
		Object[] rowTmp = new Object[14];
		Puesto puesto = new Puesto(Integer.toString(idPuesto));
		// indexRow
		rowTmp[0] = new Integer(this.lastIndexRow);
		// INS.ID_INSTRUCCION_ASUNTO,
		rowTmp[1] = "";
		// INS.INS_USUARIO,
		rowTmp[2] = new Integer(idPuesto);
		// USU.USU_NOMBRE,
		rowTmp[3] = puesto.getPuestoById();
		// INS.INS_INSTRUCCION,
		if (idInstruccion == 0) {
			rowTmp[4] = "";
		} else {
			rowTmp[4] = new Integer(idInstruccion);
		}
		// INS.INS_TIPO_ATENCION,
		rowTmp[5] = TA;
		// INS.INS_TIEMPO,
		rowTmp[6] = new Integer(tiemp);
		// INS.INS_ACCESO,
		rowTmp[7] = new Integer(Acceso);
		// INS.INS_REQUERIDO,
		rowTmp[8] = new Integer(Requerido);
		// INS.INS_CONFIDENCIAL,
		rowTmp[9] = "2";
		// INS_INSTRUCCION
		if (idInstruccion == 0) {
			rowTmp[10] = "";
			// INS.INS_INSTRUCCION_OTRO
			rowTmp[11] = Instr;
		} else {
			Instruccion instr = new Instruccion();
			rowTmp[10] = instr.getInstructionById(idInstruccion);
			// INS.INS_INSTRUCCION_OTRO
			rowTmp[11] = "";
		}
		rowTmp[12] = "0";

		rowTmp[13] = "0";

		this.tableInstr.put(new Integer(this.lastIndexRow), rowTmp.clone());
		this.lastIndexRow++;
	}

	public void updateRow(int Acceso, int Requerido, int idPuesto,
			int idInstruccion, String Instr, String TA, int tiemp,
			int instStat, int indxRow, int auto) {
		Object[] rowTmp = getObjectElementById(indxRow);

		Puesto puesto = new Puesto(Integer.toString(idPuesto));
		// indexRow
		rowTmp[0] = new Integer(indxRow);
		// INS.ID_INSTRUCCION_ASUNTO,
		// rowTmp[1]= ""; //No se asigna para que conserve el mismo ID
		// INS.INS_USUARIO,
		rowTmp[2] = new Integer(idPuesto);
		// USU.USU_NOMBRE,
		rowTmp[3] = puesto.getPuestoById();
		// INS.INS_INSTRUCCION,
		if (idInstruccion == 0) {
			rowTmp[4] = "";
		} else {
			rowTmp[4] = new Integer(idInstruccion);
		}
		// INS.INS_TIPO_ATENCION,
		rowTmp[5] = TA;
		// INS.INS_TIEMPO,
		rowTmp[6] = new Integer(tiemp);
		// INS.INS_ACCESO,
		rowTmp[7] = new Integer(Acceso);
		// INS.INS_REQUERIDO,
		rowTmp[8] = new Integer(Requerido);
		// INS.INS_CONFIDENCIAL,
		rowTmp[9] = "2";
		// INS_INSTRUCCION
		if (idInstruccion == 0) {
			rowTmp[10] = "";
			// INS.INS_INSTRUCCION_OTRO
			rowTmp[11] = Instr;
		} else {
			Instruccion instr = new Instruccion();
			rowTmp[10] = instr.getInstructionById(idInstruccion);
			// INS.INS_INSTRUCCION_OTRO
			rowTmp[11] = "";
		}
		rowTmp[12] = new Integer(instStat);
		rowTmp[13] = new Integer(auto);// "0";
		this.tableInstr.remove(new Integer(indxRow));
		this.tableInstr.put(new Integer(indxRow), rowTmp.clone());

		this.rowUpgrade[this.intUpgrade] = indxRow;
		this.intUpgrade++;

	}

	public void delRow(int indexRow) {
		if (indexRow == 0) {
			isDeleteZero = true;
		}
		this.rowDel[this.intDel] = indexRow;
		this.intDel++;
	}

	public Object[] getObjectElementById(int id) {
		Object[] rowTmp = (Object[]) this.tableInstr.get(new Integer(id));
		return rowTmp;
	}

	public String getHTML() {
		String tablaHTML = "", styleTR = "";

		try {
			boolean isFirst = true;
			for (int i = 0; i < this.tableInstr.size(); i++) {
				if (isDeleted(i)) {
				} else {
					if (!isFirst) {
						tablaHTML += "<tr height='1pt'><td colspan='8'><hr size='1pt' "
								+ "style='color=#D0D0D0;'></td></tr>";
					}
					isFirst = false;
					Object[] rowTmp = getObjectElementById(i);
					if (rowTmp[12].toString().equals("0"))
						styleTR = "tableBody";
					else
						styleTR = "tableBody2";

					if (rowTmp[4].toString().equals("")
							&& rowTmp[10].toString().equals("")
							&& rowTmp[11].toString().equals(""))
						styleTR = "tableBodyRed";
					// Check
					tablaHTML += "<tr id='rowLn" + rowTmp[0] + "' class='"
							+ styleTR + "' >" + "<td id='TDrowLn" + rowTmp[0]
							+ "0'>" + "<input type='checkbox' name='iRw"
							+ rowTmp[0] + "' id='iRw" + rowTmp[0] + "' value='"
							+ rowTmp[0] + "' onclick=\"javascript:getRowBy('"
							+ rowTmp[0] + "')\"></td>";
					if (getTipoTabla() == this.TIPO_TURNADO) {
						// UA
						Puesto puesto = new Puesto(rowTmp[2].toString());
						tablaHTML += "<td id='TDrowLn" + rowTmp[0] + "1'>"
								+ puesto.getUaName() + " ";
						tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
								+ "C2a' " + "value='" + puesto.getIdArea()
								+ "' name='R" + rowTmp[0] + "C2a'></td>";
					} else {
						tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
								+ "C2a' " + "value='0' name='R" + rowTmp[0]
								+ "C2a'>";
					}

					// Puesto / Responsable
					tablaHTML += "<td id='TDrowLn" + rowTmp[0] + "1'>"
							+ rowTmp[3] + " ";
					tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
							+ "C2' " + "value='" + rowTmp[2] + "' name='R"
							+ rowTmp[0] + "C2'></td>";
					// instrucción
					if (rowTmp[4].toString().equals("")) {
						tablaHTML += "<td id='TDrowLn" + rowTmp[0] + "2'>"
								+ rowTmp[11];
						tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
								+ "C1' " + "value='[otra]' name='R" + rowTmp[0]
								+ "C1'>";
						tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
								+ "C1a' " + "value='" + rowTmp[11]
								+ "' name='R" + rowTmp[0] + "C1a'></td>";
					} else {
						tablaHTML += "<td id='TDrowLn" + rowTmp[0] + "2'>"
								+ rowTmp[10] + " ";
						tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
								+ "C1' " + "value='" + rowTmp[4] + "' name='R"
								+ rowTmp[0] + "C1'>";
						tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
								+ "C1a' " + "value='' name='R" + rowTmp[0]
								+ "C1a'></td>";
					}
					// Tipo de atencion
					tablaHTML += "<td id='TDrowLn"
							+ rowTmp[0]
							+ "3'>"
							+ (rowTmp[5].toString().equals("0") ? "ejecución"
									: "Informativa") + " ";
					tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
							+ "C3' " + "value='" + rowTmp[5] + "' name='R"
							+ rowTmp[0] + "C3'></td>";
					// Tiempo
					tablaHTML += "<td id='TDrowLn" + rowTmp[0] + "4'><center>"
							+ rowTmp[6] + " ";
					tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
							+ "C4' " + "value='" + rowTmp[6] + "' name='R"
							+ rowTmp[0] + "C4'></td>";
					// Acceso
					tablaHTML += "<td id='TDrowLn" + rowTmp[0] + "5'><center>"
							+ (rowTmp[7].toString().equals("1") ? "Si" : "No")
							+ " ";
					tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
							+ "C5' " + "value='" + rowTmp[7] + "' name='R"
							+ rowTmp[0] + "C5'></td>";
					// Requerido
					tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
							+ "C6' " + "value='" + rowTmp[8] + "' name='R"
							+ rowTmp[0] + "C6'>";
					// Estatus
					tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
							+ "C7'" + "value='" + rowTmp[12] + "' name='R"
							+ rowTmp[0] + "C7'>";
					// Auto
					tablaHTML += "<input type='hidden' id='R" + rowTmp[0]
							+ "C8'" + "value='" + rowTmp[13] + "' name='R"
							+ rowTmp[0] + "C8'>" + "</tr>";

				}
			}
			return tablaHTML;

		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	  public void Save(){
	    	for(int i=0;i<this.tableInstr.size();i++){
	            if (isDeleted(i)){
	                Object[] rowTmp = getObjectElementById(i);
	                if (!rowTmp[1].toString().equals("")){
	                    try{
	                        String strSql = "DELETE FROM SD_INSTRUCCION_ASUNTO "+
	                        "WHERE ID_ASUNTO=" + this.idAsunto + " AND INS_FOLIO_TURNADO is null " +
	                        "AND INS_FECHA_ASIGNACION is null AND INS_FECHA_TERMINACION " +
	                        "is null AND INS_ESTATUS=0 AND ID_INSTRUCCION_ASUNTO=" + rowTmp[1];
	                        if (this.idInstr==null || this.idInstr.equals(""))
	                            strSql += " AND INS_PADRE IS NULL ";
	                        else
	                            strSql += " AND INS_PADRE=" + this.idInstr;

	                        //System.out.println("tablaInstruccionesBean.Save: "+strSql);
	                        ConexionDS.ejecutarActualizacion(strSql);
	                    }catch(SQLException sqle){
	                        //System.out.println("tablaInstruccionesBean.Save: " +sqle.getMessage());
	                        sqle.printStackTrace();
	                    }
	                }
	            }else{
	                Object[] rowTmp = getObjectElementById(i);
	                String idPto = "";
	                String idInstr= "";
	                String otraInst= "";
	                String ta= "";
	                String tiemp= "";
	                String A= "";
	                String R= "";
	        //Check  rowTmp[0]
	        //Puesto
	                idPto = rowTmp[2].toString();
	        //instrucción
	                if (rowTmp[4].toString().equals("0")||rowTmp[4].toString().equals("")){
	                    idInstr ="";
	                    otraInst=rowTmp[11].toString();
	                }else{
	                    idInstr =rowTmp[4].toString();
	                    otraInst="";
	                }
	        //Tipo de atencion
	                ta =rowTmp[5].toString();
	        //Tiempo
	                tiemp =rowTmp[6].toString();
	        //Acceso
	                A = rowTmp[7].toString();
	        //Requerido
	                R = rowTmp[8].toString();
	                String strSqlIn ="";
	                // Si ha sido actualizado, y el estatus de la instrucción esta Aún sin procesar...
	                if (isUpdated(i) && !rowTmp[1].toString().equals("")){
	                    strSqlIn = "UPDATE sd_instruccion_asunto SET INS_USUARIO = " + idPto +
	                        " , INS_INSTRUCCION='" + idInstr + "', INS_INSTRUCCION_OTRO='" + otraInst +
	                        "', INS_TIPO_ATENCION=" + ta + ", ins_tiempo=" + tiemp + ", INS_ACCESO="+A+
	                        " WHERE ID_INSTRUCCION_ASUNTO=" + rowTmp[1] +" AND id_asunto=" + this.idAsunto;
	                    
	                }else{
	                    if (Integer.parseInt(rowTmp[12].toString())==0){
	                        if (rowTmp[1].toString().equals("")){
	                        	String strDatos[][] = ActualizaAsunto.getParaCC(this.idAsunto);
	                        	if(strDatos.length!=0){
	                        		String strIdDoc = strDatos[0][4];
	                    			String strIdPas[][] = ActualizaPaso.getSecMin(strIdDoc);
	                    			strSqlIn = "INSERT INTO sd_instruccion_asunto (" +
									"ID_INSTRUCCION_ASUNTO, " +
									"id_asunto, " +
									"ins_usuario,";
	                    			if (idInstr!=null&&!idInstr.equals(""))	                    					                    		
	                    				strSqlIn+="ins_instruccion,";	                    				
	                    			//+
									//"ins_instruccion," +
									strSqlIn+="ins_instruccion_otro," +
									"ins_tipo_atencion," +
									"ins_paso," +
									"ins_tiempo," +
									"ins_acceso," +
									"ins_requerido," +
									"ins_confidencial, " +
									"ins_padre, " +
									"INS_ESTATUS," +
									"ins_avance)" +
									"values(" +
									"SD_INSTRUCCION_ASUNTO_SEQ.NEXTVAL," +
									this.idAsunto+"," +
									idPto+",";
									if (idInstr!=null&&!idInstr.equals(""))
										strSqlIn+=idInstr+",";
									//idInstr+"," +
									strSqlIn+="'"+otraInst+"'," +
									ta +"," +
									strIdPas[0][0]+"," +
									tiemp+"," +
									A+"," +
									R+"," +
									"2,";
	                    			if (this.idInstr==null || this.idInstr.equals(""))
	                    				strSqlIn += "'',0,0)";
	                    			else
	                    				strSqlIn += this.idInstr+",0,0)";
	                        	}else{
	                        		strSqlIn = "[Nothing]";
	                        	}
	                        }else{
	                            strSqlIn = "[Nothing]";
	                        }
	                    }else{
	                        strSqlIn = "[Nothing]";
	                    }
	                }
	                try {
	                    if (!strSqlIn.equals("[Nothing]"))
	                    	//System.out.println("query update: " +strSqlIn);
	                        ConexionDS.ejecutarActualizacion(strSqlIn);
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	private boolean isDeleted(int indx) {
		// Si ningun elemento ha sido borrado, regresa false
		if (this.intDel == 0) {
			return false;
		}
		// Si el indice es igual a cero y la bandera isDeleteZero, regresa true
		if (indx == 0 && isDeleteZero) {
			return true;
		}
		// Hace un recorrido, segun el indice enviado, por todos los elementos
		// que estan marcados como eliminados
		for (int i = 0; i < this.intDel; i++) {
			if (indx == this.rowDel[i]) {
				return true;
			}
		}
		return false;
	}

	private boolean isUpdated(int indx) {
		// Hace un recorrido, segun el indice enviado, por todos los elementos
		// que estan marcados como actualizados
		for (int i = 0; i < this.intUpgrade; i++) {
			if (indx == this.rowUpgrade[i]) {
				// //System.out.println("tablaInstruccionesBean.isUpdated:
				// RETURN:true");
				return true;
			}
		}
		// //System.out.println("tablaInstruccionesBean.isUpdated: RETURN:
		// false");
		return false;
	}
}
