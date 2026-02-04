package _cgtic;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import gob.hacienda.cgtic.siga.*;
import com.meve.sigma.beans.*;


public class _getPuestosByUA extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html; charset=ISO-8859-1");
    /* set up the intrinsic variables using the pageContext goober:
    ** session = HttpSession
    ** application = ServletContext
    ** out = JspWriter
    ** page = this
    ** config = ServletConfig
    ** all session/app beans declared in globals.jsa
    */
    PageContext pageContext = JspFactory.getDefaultFactory().getPageContext( this, request, response, null, true, JspWriter.DEFAULT_BUFFER, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    int __jsp_tag_starteval;
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _getPuestosByUA page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      
          String action = "";
          String ua = "";
          String usr_ua = "";
          String strOut="";
      	String id_tur = "";
      	String strBan = (request.getParameter("ban")==null?"":request.getParameter("ban"));
          if (request.getParameter("action")!=null){
              action = request.getParameter("action");
          }
          
          if (action.equals("getPtoByUA")){
              if (request.getParameter("ua")!=null){
                  ua = request.getParameter("ua");
      			if (request.getParameter("usr_ua")!=null){
                      usr_ua = request.getParameter("usr_ua");
                  }
      			if (request.getParameter("id_tur")!=null){
                      id_tur = request.getParameter("id_tur");
                  }
      			
                  Puestos ptos = new Puestos();
                  Instruccion instruccion = new Instruccion();
                  if (usr_ua.equals(ua)){
                      ptos.ConsultaPorUA(ua, true, id_tur, strBan);
                  }else{
                      ptos.ConsultaPorUA(ua, id_tur, strBan);
                  }
                      
                  Puesto ptoTmp;
                  strOut+="var ptoSel = parent.document.getElementById('pto');";
                  for (int i= 0;i<ptos.getNumReg();i++){
                      ptoTmp = ptos.getPuesto(i);
                      strOut+="var opt" + i + " = document.createElement('option');";
                      strOut+="opt" + i + ".value='"+ptoTmp.getIdUsuario()+"';";
                      strOut+="opt" + i + ".text='" + ptoTmp.getCargo() + " / " + 
                       ptoTmp.getNombre()+ "';";
                      strOut+="try{ptoSel.add(opt" + i + ",null);}catch(ex){ptoSel.add(opt" + i + ");}";
                  }
      
                  strOut+=" var InsSel = parent.document.getElementById('instrucciones');";
                  strOut+="try{InsSel.innerHTML=\""+instruccion.getComboInstrucciones(ua)+"\"}catch(ex){}";
                  //String [][] regInstr = instruccion.getInstruccionesPorArea(ua,true);
                  //for(int i=0;i<regInstr.length;i++){
                      //strOut+="var optI" + i + " = document.createElement('option');";
                      //strOut+="optI" + i + ".value='"+ regInstr[i][0] +"';";
                  	//if ((regInstr[i][1]).length()>60)
                          //regInstr[i][1] = (regInstr[i][1]).substring(0,60);
                          
                      //strOut+="optI" + i + ".text='" + regInstr[i][1] + "';";
                      //strOut+="try{InsSel.add(optI" + i + ",null);}catch(ex){InsSel.add(optI" + i + ");}";
                  //}
      	    //strOut+="var optOtra = document.createElement('option');";
      	    //strOut+="optOtra.value='[otra]';";
      	    //strOut+="optOtra.text='[ Otra ]...';"; 
      	    //strOut+="try{InsSel.add(optOtra,null);}catch(ex){InsSel.add(optOtra);}";
      
                  out.println(strOut);
                  out.println("parent.document.getElementById('varPtoInst').focus();");
                  
              }
          }
      
      out.write(__oracle_jsp_text[2]);

    }
    catch (Throwable e) {
      if (!(e instanceof javax.servlet.jsp.SkipPageException)){
        try {
          if (out != null) out.clear();
        }
        catch (Exception clearException) {
        }
        pageContext.handlePageException(e);
      }
    }
    finally {
      OracleJspRuntime.extraHandlePCFinally(pageContext, true);
      JspFactory.getDefaultFactory().releasePageContext(pageContext);
    }

  }
  private static final char __oracle_jsp_text[][]=new char[3][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n\n<html>\n  <head>\n    <script language=\"JavaScript\" type=\"text/javascript\">\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n\n    </script>\n  </head>\n  <body></body>\n</html>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
