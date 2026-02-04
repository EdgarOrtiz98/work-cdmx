<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<%
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
</HEAD>
<BODY text=#000000 bgColor=#ffffff>
<FORM name=_header2>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
<TBODY>
  	<TR>
    	<TD background=../Imagenes/h1.jpg>
      		<TABLE cellSpacing=0 cellPadding=0 width=0 align=right border=0>
        	<TBODY>
        	<TR>
          		<TD>    
					<A onmouseover="MM_swapImage('Image19','','../Imagenes/b1_conf.jpg',1)" 
            			onmouseout=MM_swapImgRestore() 
            			href="../jsp/UsuariosView.jsp"></A>
				</TD>
          		<TD>
					<A onmouseover="MM_swapImage('Image18','','../Imagenes/b1_ayu.jpg',1)" 
            			onmouseout=MM_swapImgRestore() 
            			href="http://www.bajacalifornia.gob.mx" 
            			target=B><IMG height=17 src="../Imagenes/b1_ayu.jpg" width=75 
            			border=0 name=Image18>
					</A>
				</TD>
          		<TD>
					<A onmouseover="MM_swapImage('Image20','','../Imagenes/b1_sal.jpg',1)" 
            			onmouseout=MM_swapImgRestore() 
            			href="index.jsp" target="_top">
					<IMG height=17 src="../Imagenes/b1_sal.jpg" width=68 
            			border=0 name=Image20>
					</A>
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
			<IMG height=87 src="../Imagenes/header.jpg" width=772>
			<%}else if(strImagen.equals("2")){ %>
			<IMG height=87 src="../Imagenes/headerISSSTE.jpg" width=772>
			<%}else if(strImagen.equals("3")){ %>
			<IMG height=87 src="../Imagenes/L2header1.jpg" width=772>
			<%}%>
		</TD>
	</TR>
  	<TR>
    	<TD background=../Imagenes/h2.jpg>
      		<TABLE cellSpacing=0 cellPadding=0 width=0 border=0>
        	<TBODY>
        	<TR>
          		<TD>
				</TD>
          		<TD>
				</TD>
				<TD>
					</TD>
          		<TD></TD>
          		<TD></TD>
          		<TD></TD>
          		<TD></TD>
          		<TD></TD>
			</TR>
			</TBODY>
			</TABLE></TD><!--   /TR /TBODY /TABLE -->
</FORM>
</BODY></HTML>
