<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<%
	String strActivarPortal = application.getInitParameter("ActivarPortal");
	String strImagen = application.getInitParameter("Imagen");
%>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/link.css" />
<script type="text/javascript" src="../js/link.js">

</script> 
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
<TBODY>
  	<TR>
    	<TD background=../Imagenes/h1.jpg>
      		<TABLE cellSpacing=0 cellPadding=0 width=0 align=right border=0>
        	<TBODY>
        	<TR>
          		<!-- <TD>
					<A onmouseover="MM_swapImage('Image19','','../Imagenes/b1_conf.jpg',1)" 
            			onmouseout=MM_swapImgRestore() 
            			href="portalPrincipal.jsp"><IMG height=17 src="../Imagenes/b1_conf.jpg" width=123 border=0 
            			name=Image19>
					</A>
				</TD> -->
          		<TD>

				</TD>
          		<TD>

				</TD>
			</TR>
			</TBODY>
			</TABLE>
		</TD>
	</TR>
  	<TR>
    	<TD <% if(strImagen.equals("1")){ %>background=../Imagenes/fon_head.jpg
			<% }else if(strImagen.equals("2")){ %>background=../Imagenes/fon_head1.jpg
			<% }else if(strImagen.equals("3")){ %>background=../Imagenes/fon_head1.jpg<%}%>>
			<% if(strImagen.equals("1")){ %>
			<IMG height=87 src="../Imagenes/header_shcp.jpg" width=772>
			<%}else if(strImagen.equals("2")){ %>
			<IMG height=87 src="../Imagenes/headerISSSTE.jpg" width=772>
			<%}else if(strImagen.equals("3")){ %>
			<IMG height=87 src="../Imagenes/L2header1.jpg" width=772>
			<%}%>
		</TD>
	</TR>
  	<TR>
    	<TD background=../Imagenes/h2.jpg>

		</TD>
	</TR>
</TBODY>
</TABLE>

