
<%@page import="com.meve.sigma.asunto.AsuntoStateMachine"%>
<%@page import="com.meve.sigma.util.Estatus"%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0" width="900">
	<TR>
		<TD align="left">
		<A onclick="if(botonBandera){botonBandera=false; regresarURI();}" 
		   onMouseOver="document.MyImage.src='./Imagenes/NavLeft2.gif'" 
		   onMouseOut="document.MyImage.src='./Imagenes/NavLeft.gif'">
		      <IMG border="0" src="./Imagenes/NavLeft.gif" title="Regresar / Cancelar" name="MyImage">
		</A>
 			<%if (AsuntoStateMachine.canChangeStateSolicitud(request,
 			      Estatus.ASU_EN_RECEPCION)) { %>
 			   <A onclick="if(botonBandera){botonBandera=false; guardarAsuntoEnRecepcion();}" 
				  onMouseOver="document.guardarRepBtn.src='./Imagenes/SaveRecepOff.gif';" 
				  onMouseOut="document.guardarRepBtn.src='./Imagenes/SaveRecepOn.gif';">
				    <IMG border="0" src="./Imagenes/SaveRecepOn.gif" name="guardarRepBtn" title="Guardar en Recepción">
			   </A>
			<%}%>
			<%if (AsuntoStateMachine.canChangeStateSolicitud(request,
 			      Estatus.ASU_POR_TURNAR)) { %>
 			    <A onclick="if(botonBandera){botonBandera=false; guardarAsunto();}" 
				   onMouseOver="document.guardarBtn.src='./Imagenes/Save2.gif';" 
				   onMouseOut="document.guardarBtn.src='./Imagenes/Save.gif';">
					<IMG border="0" src="./Imagenes/Save.gif" title="Guardar para Turnar" name="guardarBtn">
				</A>
			<%}%>
		</TD>
	</TR>
</TABLE>
</DIV>