package com.meve.sigma.instruccion;

import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.util.Arboles;

public class InstruccionUtil {

	public static void setCatalogos(HttpServletRequest request,
			List instrucciones) {
		for (int i = 0; i < instrucciones.size(); i++) {
			InstruccionForm instruccion = (InstruccionForm) instrucciones.get(i);
		//TODO Terminar 

		}

	}

	public static boolean getAccesoInstruccion(String strIdUsuario,String strIdAsunto) {
		try {
			String sql = "select * from sd_instruccion_asunto where id_asunto ="+strIdAsunto+" and ins_usuario="+strIdUsuario+" and ins_acceso=1";
			//System.out.println("sql"+sql);
			String strResult[][] = ConexionDS.ejecutarSQL(sql);
			if (strResult != null && strResult.length > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}	
	}

}
