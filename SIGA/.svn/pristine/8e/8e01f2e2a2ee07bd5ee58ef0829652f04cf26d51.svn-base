/*
 * Creado el 17/08/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.util;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.reportes.ActualizaInst;

/**
 * @author Leonardo Lechuga
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ListaInstrucciones {
	
	public static String instruccionesPorAtender(	String[][] lista,
													String idusuario,
													String idArea,
													boolean esAsistente,
													String idPuesto,
													String orden,
													String tipo,
													int contPag,
													int contligas,
													int regPorPagina,
													int muestraPaginas,
													int iSAmarillo,
													int numRegistros,
													int numPaginas,
													boolean bMostrar,
													int t,
													String strTmp,
													float fPorcentaje){
		StringBuffer html = new StringBuffer();//variable para crear html
		String imagen	=	"";
		int j = 0;//Contador
		
		//**Verifica si el usuario es un titular de una UA
    	String esTitular = "0";
        ActualizaArea.esEncargadoUA(idArea, idusuario);
    	
		if (lista!=null && lista.length>0){
			if(esTitular.equals("1")){//Instruccione para un titular de UA
				if (lista!=null && lista.length>0){
					for(int i=0;i<lista.length;i++){
						bMostrar = idPuesto.equals(lista[i][0]);
						if (ActualizaInstrucciones.TieneInstruccionesPorAtenderUsuario(lista[i][0])){
							html.append("<TR>");
							html.append("<TD>");
							html.append("<table border='0' cellpadding='2' cellspacing='0'>");
							html.append("<TBODY>");
							html.append("<tr valign='top'>");
							html.append("	<td colspan='5' width='100%'>");
							html.append("		<a onClick='desplegar("+lista[i][0]+")'>");
							if(bMostrar)
								imagen = "collapseUa.gif";
							else
								imagen = "expandUa.gif";
							html.append("		<img src='../Imagenes/"+imagen+"' border='0' ");
							html.append("			height='16' width='16'>"+ActualizaUsuario.NombreUsuario(lista[i][0])+" / "+ ActualizaUsuario.NombrePuesto(lista[i][0]));
							html.append("		</a>");
							html.append("	</td>");
							html.append("</tr>");
							j++;
							//String str[][]=ActualizaInstrucciones.getInstruccionAtenderUsuario(lista[i][0],orden,tipo);
							if(bMostrar/*  && str.length!=0*/){
								html.append("<TR>");
								html.append("<TD align='left' colspan='2'>");
								numRegistros = ActualizaInstrucciones.getInstruccionAtenderUsuario(lista[i][0], orden, tipo).length;
								if (numRegistros>0){
									html.append("&nbsp;&nbsp;&nbsp;&nbsp;");
									html.append("<A href='../ReporteAsuntoExcel?tip=inst_atender_01&id_remitente="+lista[i][0]+"'>");
									html.append("<img src='../Imagenes/button_xls.gif' border='0' height='16' width='16'>");
									html.append("<FONT face='Arial' size='2'>Exportar a Excel</FONT>");
									html.append("</A>");
								}
								html.append("</TD>");
								html.append("<TD align='right' colspan='3'>");
								numPaginas = numRegistros/regPorPagina;	
								if (numRegistros%regPorPagina != 0)
									numPaginas++;
								if (numRegistros > 0){
									html.append(numRegistros+" registros mostrados.");
								}
								if (numPaginas > 1){
									html.append("Pagina "+(contPag+1)+" de "+numPaginas+"");
								}
								html.append("&nbsp;&nbsp;&nbsp;&nbsp;");
								html.append("</TD>");
								html.append("</TR>");
								String[][] sql = ActualizaInstrucciones.getInstruccionAtenderUsuario(lista[i][0], orden, tipo);
								for (int ix=contPag*regPorPagina; ix<sql.length && ix<(contPag+1)*regPorPagina; ix++){
									String usuario1 = sql[ix][0];
									String usuario2 = sql[ix][1];
									String usuario3 = sql[ix][2];
									String usuario4 = sql[ix][3];
									String usuario6 = sql[ix][5];
									String usuario7 = sql[ix][6];
									String usuario8 = sql[ix][7];
									String usuario9 = sql[ix][8];
									String usuario10 = sql[ix][9];
									String usuario14 = sql[ix][13];
									String usuario17 = sql[ix][16];
								
									t++;
									String bgColor = "";
									if(par(t)==true)
										bgColor = "";
									else
										bgColor = "#f6f6f6";
									html.append("<tr valign='top' bgcolor='"+bgColor+"'>");
									html.append("<td width='2%'></td>");
									html.append("<td align='left' width='17%'>");
									html.append("<font size='1' color='#000080' face='Arial'>");
								
									if(usuario14.equals("0")){
										String padre1 = usuario17;
										if(padre1.length() != 0){
											html.append("<A href='InstruccionHija.jsp?id_ins="+usuario1+"&retURI="+Utilerias.codificaPostHTML(strTmp+"?idUs="+idPuesto+"&contPag="+contPag+"&contligas="+contligas+"&orden="+orden+"&tipo="+tipo)+"' title='"+usuario6+"'>");
											html.append(Utilerias.recortaString(usuario6,30));
											html.append("</A>");
										}else{
											html.append("<A href='InstruccionesAtender.jsp?id_ins="+usuario1+"&retURI="+Utilerias.codificaPostHTML(strTmp+"?idUs="+idPuesto+"&contPag="+contPag+"&contligas="+contligas+"&orden="+orden+"&tipo="+tipo)+"' title='"+usuario6+"'>");
											html.append(Utilerias.recortaString(usuario6,30));
											html.append("</A>");
										}
									}else if(usuario14.equals("1")){
										html.append("<A href='InstruccionTurnada.jsp?id_ins="+usuario1+"&retURI="+Utilerias.codificaPostHTML(strTmp+"?idUs="+idPuesto+"&contPag="+contPag+"&contligas="+contligas+"&orden="+orden+"&tipo="+tipo)+"' title='"+usuario6+"'>");
										html.append(Utilerias.recortaString(usuario6,30));
										html.append("</A>");
									}
									html.append("</font>");
									html.append("</td>");
								
									html.append("<td align='center' width='368'>");
									String inst = "";
									if(usuario2.length() == 0)
										inst = usuario8;
									else
										inst = ActualizaInst.getNombreInstruccion1(usuario2);
									html.append("<a title='"+usuario7+"("+inst+")'>");

									html.append("<font size='1' color='#000080' face='Arial'>");
									html.append(Utilerias.recortaString(usuario7,20));
									if(usuario2.length() == 0){
										html.append("("+Utilerias.recortaString(usuario8,20)+")");
									}else{
										html.append("("+Utilerias.recortaString(ActualizaInst.getNombreInstruccion1(usuario2),20)+")");
									}
									html.append("</font></a>");
									html.append("</td>");
									html.append("<td align='center' width='368'>");
									html.append("<font size='1' color='#000080' face='Arial'>");
									html.append(Utilerias.formatearFechas(usuario3)+"--"+Utilerias.formatearFechas(usuario4));
									html.append("</font>");
									html.append("</td>");
									html.append("<td align='center' width='243'>");
									html.append("<font size='1' color='#000080' face='Arial'>");
									fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(usuario9).intValue(), usuario3, usuario4, 5);
									float iAvance = new Float(usuario10).floatValue();
									if(fPorcentaje > 100){
										html.append("<IMG border='0' src='../Imagenes/rojob5.gif' width='10' height='10'>");
									}else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
										if(fPorcentaje<=iAvance){
											html.append("<IMG border='0' src='../Imagenes/verde5.gif' width='11' height='11'>");
										}else{
											html.append("<IMG border='0' src='../Imagenes/amarillo5.gif' width='11' height='11' alt='Debería llevar el "+fPorcentaje+"%'>");
										}
									}else if(fPorcentaje<iSAmarillo){
										html.append("<IMG border='0' src='../Imagenes/verde5.gif' width='11' height='11'>");
									}
									html.append("</font>");
									html.append("</td>");
									html.append("</tr>");
								}
								html.append("<TR>");
								html.append("<TD colspan='5' align='center'><BR>");
								if (contligas>0 && numPaginas > muestraPaginas){
									int liga = 0;
									if(contligas-muestraPaginas<0)
										liga = 0;
									else
										liga = contligas-muestraPaginas;
									html.append("<A onclick='paginaLiga("+liga+");pagina("+liga+");'> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;");
								}
								if (contPag > 0){
									if (contPag > contligas){
										html.append("<A onclick='paginaLiga("+contligas+");pagina("+(contPag-1)+");'> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;");
									}else{
										html.append("<A onclick='paginaLiga("+(contligas-1)+");pagina("+(contPag-1)+");'> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;");
									}
								}
								if (numPaginas > 1){
									for (int ik=contligas; ik<muestraPaginas+contligas && ik<numPaginas; ik++){ 
										if (ik==contPag){
											html.append("<A onclick='pagina("+ik+")'><FONT color='red'><B>["+(ik+1)+"]</B></FONT></A> &nbsp;");
										}else{
											html.append("<A onclick='pagina("+ik+">)'>"+(ik+1)+"</A> &nbsp;");
										}
									}
								}
								if (contPag < numPaginas-1){  
									if (contPag < contligas + muestraPaginas-1){
										html.append("<A onclick='paginaLiga("+contligas+");pagina("+(contPag+1)+");'> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;");
									}else{
										html.append("<A onclick='paginaLiga("+(contligas+1)+");pagina("+(contPag+1)+");'> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;");
									}
								}
								if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){
									html.append("<A onclick='paginaLiga("+(numPaginas-muestraPaginas)+");pagina("+(numPaginas-1)+");'> <B>FINAL</B> </A>");
								}
								html.append("</TD>");
								html.append("</TR>");
							}
							html.append("</TBODY>");
							html.append("</table>");
							html.append("</TD>");
							html.append("</TR>");
						}
					}
				}
				if(j == 0){
					html.append("<TR>");
					html.append("<TD width='100%'>");
					html.append("<div align='center'>");
					html.append("<FONT face='verdana' size='4'>****** No tiene Instrucciones por Atender ******</FONT>");
					html.append("</div>");
					html.append("</TD>");
					html.append("</TR>");
				}
			}else if(esTitular.equals("0")){//Instrucciones para un puesto normal
				if (lista!=null && lista.length>0){
					for(int i=0;i<lista.length;i++){
						bMostrar = idPuesto.equals(lista[i][0]);
						if (ActualizaInstrucciones.TieneInstruccionesPorAtenderUsuario(lista[i][0])){
							html.append("<TR>");
							html.append("<TD>");
							html.append("<table border='0' cellpadding='2' cellspacing='0'>");
							html.append("<TBODY>");
							html.append("<tr valign='top'>");
							html.append("	<td colspan='5' width='100%'>");
							html.append("		<a onClick='desplegar("+lista[i][0]+")'>");
							if(bMostrar)
								imagen = "collapse.gif";
							else
								imagen = "expand.gif";
							html.append("		<img src='../Imagenes/"+imagen+"' border='0' ");
							html.append("			height='16' width='16'>"+ActualizaUsuario.NombreUsuario(lista[i][0])+" / "+ ActualizaUsuario.NombrePuesto(lista[i][0]));
							html.append("		</a>");
							html.append("	</td>");
							html.append("</tr>");
							j++;
							//String str[][]=ActualizaInstrucciones.getInstruccionAtenderUsuario(lista[i][0],orden,tipo);
							if(bMostrar){
								html.append("<TR>");
								html.append("<TD align='left' colspan='2'>");
								numRegistros = ActualizaInstrucciones.getInstruccionAtenderUsuario(lista[i][0], orden, tipo).length;
								if (numRegistros>0){
									html.append("&nbsp;&nbsp;&nbsp;&nbsp;");
									html.append("<A href='../ReporteAsuntoExcel?tip=inst_atender_01&id_remitente="+lista[i][0]+"'>");
									html.append("<img src='../Imagenes/button_xls.gif' border='0' height='16' width='16'>");
									html.append("<FONT face='Arial' size='2'>Exportar a Excel</FONT>");
									html.append("</A>");
								}
								html.append("</TD>");
								html.append("<TD align='right' colspan='3'>");
								numPaginas = numRegistros/regPorPagina;	
								if (numRegistros%regPorPagina != 0)
									numPaginas++;
								if (numRegistros > 0){
									html.append(numRegistros+" registros mostrados.");
								}
								if (numPaginas > 1){
									html.append("Pagina "+(contPag+1)+" de "+numPaginas+"");
								}
								html.append("&nbsp;&nbsp;&nbsp;&nbsp;");
								html.append("</TD>");
								html.append("</TR>");
								String[][] sql = ActualizaInstrucciones.getInstruccionAtenderUsuario(lista[i][0], orden, tipo);
								for (int ix=contPag*regPorPagina; ix<sql.length && ix<(contPag+1)*regPorPagina; ix++){
									String usuario1 = sql[ix][0];
									String usuario2 = sql[ix][1];
									String usuario3 = sql[ix][2];
									String usuario4 = sql[ix][3];
									String usuario6 = sql[ix][5];
									String usuario7 = sql[ix][6];
									String usuario8 = sql[ix][7];
									String usuario9 = sql[ix][8];
									String usuario10 = sql[ix][9];
									String usuario14 = sql[ix][13];
									String usuario17 = sql[ix][16];
								
									t++;
									String bgColor = "";
									if(par(t)==true)
										bgColor = "";
									else
										bgColor = "#f6f6f6";
									html.append("<tr valign='top' bgcolor='"+bgColor+"'>");
									html.append("<td width='2%'></td>");
									html.append("<td align='left' width='17%'>");
									html.append("<font size='1' color='#000080' face='Arial'>");
								
									if(usuario14.equals("0")){
										String padre1 = usuario17;
										if(padre1.length() != 0){
											html.append("<A href='InstruccionHija.jsp?id_ins="+usuario1+"&retURI="+Utilerias.codificaPostHTML(strTmp+"?idUs="+idPuesto+"&contPag="+contPag+"&contligas="+contligas+"&orden="+orden+"&tipo="+tipo)+"' title='"+usuario6+"'>");
											html.append(Utilerias.recortaString(usuario6,30));
											html.append("</A>");
										}else{
											html.append("<A href='InstruccionesAtender.jsp?id_ins="+usuario1+"&retURI="+Utilerias.codificaPostHTML(strTmp+"?idUs="+idPuesto+"&contPag="+contPag+"&contligas="+contligas+"&orden="+orden+"&tipo="+tipo)+"' title='"+usuario6+"'>");
											html.append(Utilerias.recortaString(usuario6,30));
											html.append("</A>");
										}
									}else if(usuario14.equals("1")){
										html.append("<A href='InstruccionTurnada.jsp?id_ins="+usuario1+"&retURI="+Utilerias.codificaPostHTML(strTmp+"?idUs="+idPuesto+"&contPag="+contPag+"&contligas="+contligas+"&orden="+orden+"&tipo="+tipo)+"' title='"+usuario6+"'>");
										html.append(Utilerias.recortaString(usuario6,30));
										html.append("</A>");
									}
									html.append("</font>");
									html.append("</td>");
								
									html.append("<td align='center' width='368'>");
									String inst = "";
									if(usuario2.length() == 0)
										inst = usuario8;
									else
										inst = ActualizaInst.getNombreInstruccion1(usuario2);
									html.append("<a title='"+usuario7+"("+inst+")'>");

									html.append("<font size='1' color='#000080' face='Arial'>");
									html.append(Utilerias.recortaString(usuario7,20));
									if(usuario2.length() == 0){
										html.append("("+Utilerias.recortaString(usuario8,20)+")");
									}else{
										html.append("("+Utilerias.recortaString(ActualizaInst.getNombreInstruccion1(usuario2),20)+")");
									}
									html.append("</font></a>");
									html.append("</td>");
									html.append("<td align='center' width='368'>");
									html.append("<font size='1' color='#000080' face='Arial'>");
									html.append(Utilerias.formatearFechas(usuario3)+"--"+Utilerias.formatearFechas(usuario4));
									html.append("</font>");
									html.append("</td>");
									html.append("<td align='center' width='243'>");
									html.append("<font size='1' color='#000080' face='Arial'>");
									fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(usuario9).intValue(), usuario3, usuario4, 5);
									float iAvance = new Float(usuario10).floatValue();
									if(fPorcentaje > 100){
										html.append("<IMG border='0' src='../Imagenes/rojob5.gif' width='10' height='10'>");
									}else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
										if(fPorcentaje<=iAvance){
											html.append("<IMG border='0' src='../Imagenes/verde5.gif' width='11' height='11'>");
										}else{
											html.append("<IMG border='0' src='../Imagenes/amarillo5.gif' width='11' height='11' alt='Debería llevar el "+fPorcentaje+"%'>");
										}
									}else if(fPorcentaje<iSAmarillo){
										html.append("<IMG border='0' src='../Imagenes/verde5.gif' width='11' height='11'>");
									}
									html.append("</font>");
									html.append("</td>");
									html.append("</tr>");
								}
								html.append("<TR>");
								html.append("<TD colspan='5' align='center'><BR>");
								if (contligas>0 && numPaginas > muestraPaginas){
									int liga = 0;
									if(contligas-muestraPaginas<0)
										liga = 0;
									else
										liga = contligas-muestraPaginas;
									html.append("<A onclick='paginaLiga("+liga+");pagina("+liga+");'> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;");
								}
								if (contPag > 0){
									if (contPag > contligas){
										html.append("<A onclick='paginaLiga("+contligas+");pagina("+(contPag-1)+");'> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;");
									}else{
										html.append("<A onclick='paginaLiga("+(contligas-1)+");pagina("+(contPag-1)+");'> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;");
									}
								}
								if (numPaginas > 1){
									for (int ik=contligas; ik<muestraPaginas+contligas && ik<numPaginas; ik++){ 
										if (ik==contPag){
											html.append("<A onclick='pagina("+ik+")'><FONT color='red'><B>["+(ik+1)+"]</B></FONT></A> &nbsp;");
										}else{
											html.append("<A onclick='pagina("+ik+")'>"+(ik+1)+"</A> &nbsp;");
										}
									}
								}
								if (contPag < numPaginas-1){  
									if (contPag < contligas + muestraPaginas-1){
										html.append("<A onclick='paginaLiga("+contligas+");pagina("+(contPag+1)+");'> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;");
									}else{
										html.append("<A onclick='paginaLiga("+(contligas+1)+");pagina("+(contPag+1)+");'> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;");
									}
								}
								if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){
									html.append("<A onclick='paginaLiga("+(numPaginas-muestraPaginas)+");pagina("+(numPaginas-1)+");'> <B>FINAL</B> </A>");
								}
								html.append("</TD>");
								html.append("</TR>");
							}
							html.append("</TBODY>");
							html.append("</table>");
							html.append("</TD>");
							html.append("</TR>");
						}
					}
				}
				if(j == 0){
					html.append("<TR>");
					html.append("<TD width='100%'>");
					html.append("<div align='center'>");
					html.append("<FONT face='verdana' size='4'>****** No tiene Instrucciones por Atender ******</FONT>");
					html.append("</div>");
					html.append("</TD>");
					html.append("</TR>");
				}
			}
		}
		return html.toString();
	}
	
	private static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }

}
