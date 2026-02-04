
package com.meve.sigma.beans.catalogos;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.meve.sigma.actualiza.ActualizaBitacora;
import com.meve.sigma.actualiza.ActualizaTramite;
import com.meve.sigma.beans.UsuarioBean;

/**
 * Clase para Guardar o editar Tramites en los Catalogos
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class Tramite {

	public Tramite(){}
	
	/**
	 * Metodo para procesar la informacion proporcionada por el Bean BUsuario. Da de alta o edita Tramites en el 
	 * Catalogo ademas de validar duplisidad en el nombre del Tramite y que sean capturados los campor obligatorios 
	 * 
	 * @param request Parametro para obtener informacion de la sesion 
	 * @param BUsuario Parametros del Tramite
	 * @return Regresa un Vector, el cual si su longitud es mayor a cero, indica que hubo algun problema y no se pudo realizar 
	 * el proceso satisfactoriamente.
	 */
	public synchronized Vector procesoTramite(HttpServletRequest request, UsuarioBean BUsuario){                
		final boolean msg = true;
                
		String strIdArea = request.getParameter("tArea");
		String strIdTramite = request.getParameter("tIdTramite");
		String strNombre = request.getParameter("tNombre");
		String strClave = request.getParameter("tClave");
		String strDescripcion = request.getParameter("tDescripcion");
		String strTiempo = request.getParameter("tTiempo");
		
		String strAux  = "123";
		String strAux2 = "123";
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date f = new java.util.Date();
		String strFechaCreacion = sdf.format(f);
/*                
                if(msg){
	                    //System.out.println("Parámetros de base de datos.");
	                    //System.out.println("strIdTramite: "+strIdTramite);
	                    //System.out.println("strIdArea: "+strIdArea);
	                    //System.out.println("strNombre: "+strNombre);
	                    //System.out.println("strClave: "+strClave);
	                    //System.out.println("strDescripcion: "+strDescripcion);
	                    //System.out.println("strTiempo: "+strTiempo);
	                    //System.out.println("strFechaCreacion: "+strFechaCreacion);
	        }
*/                
		Vector vmensajes = new Vector();
		int iRedireccion = 0;
		int count = 0;
		boolean bInsert = false;
		boolean bActualiza = false;
		if(strIdTramite != null && strIdTramite.length() > 0){
			//System.err.println("actualzar******");
                        
			strAux  = request.getParameter("aux");
			strAux2 = request.getParameter("aux2");

			if(strIdArea.equals("-1")){
				count++;
				vmensajes.add("Selecciona una Unidad Administrativa");
			}else{
				vmensajes.add("");
			}
			if(strNombre.trim().length() == 0){
				count++;
				vmensajes.add("Captura Nombre");
			}else{
				vmensajes.add("");
			}
			if(strClave.trim().length() == 0){
				count++;
				vmensajes.add("Captura Clave");
			}else{
				vmensajes.add("");
			}
			if(strTiempo.trim().length() == 0){
				count++;
				vmensajes.add("Captura Tiempo");
			}else{
				vmensajes.add("");
			}
			
			if(ActualizaTramite.getTramiteExiste(strClave, strAux, strIdArea, strAux2) == 1){
				count++;
				vmensajes.add("La clave &quot;" + strClave + "&quot; ya existe");
			}else{
				vmensajes.add("");
			}
			
			if(count==0){
				String datos[][] = ActualizaTramite.getTramite(strIdTramite);
				bActualiza = ActualizaTramite.actualizaTramite(strIdTramite, strIdArea, strNombre, 
															strClave, strDescripcion, strTiempo, 
															strFechaCreacion, BUsuario.getIdUsuario());
				boolean b = ActualizaBitacora.InsertarEventoCambioTramite(BUsuario.getIdUsuario(),strClave,strIdArea,strIdTramite,datos);
				vmensajes.add("si");
			}else{
				vmensajes.add("no");
			}
		}else{
			//System.err.println("guardar******");
			if(strIdArea.equals("-1")){
				count++;
				vmensajes.add("Selecciona una Unidad Administrativa");
			}else{
				vmensajes.add("");
			}
			if(strNombre.trim().length() == 0){
				count++;
				vmensajes.add("Captura Nombre");
			}else{
				vmensajes.add("");
			}
			if(strClave.trim().length() == 0){
				count++;
				vmensajes.add("Captura Clave");
			}else{
				vmensajes.add("");
			}
			if(strTiempo.trim().length() == 0){
				count++;
				vmensajes.add("Captura Tiempo");
			}else{
				vmensajes.add("");
			}

			if(ActualizaTramite.getTramiteExiste(strClave, strAux, strIdArea, strAux2) == 1){
				count++;
				vmensajes.add("La clave &quot;" + strClave + "&quot; ya existe");
			}else{
				vmensajes.add("");
			}
			
			if(count==0){
				bInsert = ActualizaTramite.insertaTramite(strNombre, strClave, strDescripcion, 
															strTiempo, BUsuario.getIdUsuario(), 
															strIdArea);
				boolean b = ActualizaBitacora.InsertarEventoAltaTramite(BUsuario.getIdUsuario(),strClave,strIdArea);
				vmensajes.add("si");
			}else{
				vmensajes.add("no");
			}
				
		}
		return vmensajes;
	}
}
