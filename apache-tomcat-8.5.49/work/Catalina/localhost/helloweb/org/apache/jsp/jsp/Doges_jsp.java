/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.49
 * Generated at: 2019-12-09 09:53:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.ipartek.formacion.modelo.pojo.Perro;
import java.util.ArrayList;

public final class Doges_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/jsp/../includes/Pie.jsp", Long.valueOf(1575270650676L));
    _jspx_dependants.put("/jsp/../includes/Cabecera.jsp", Long.valueOf(1575885168721L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.ipartek.formacion.modelo.pojo.Perro");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

String titulo = "Doges";
String mensaje = String.valueOf(request.getParameter("mensaje"));

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" user-scalable=\"no\" >\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("    <base href=\"/helloweb/\">\r\n");
      out.write("    \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/stylesTabla.css?time=");
System.currentTimeMillis();
      out.write("\">\r\n");
      out.write("\t<!-- <link rel=\"stylesheet\" href=\"ejercicios/css/responsivemenu.css\" media=\"all\" /> -->\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("    <title id = \"Title\">Inicio | ");
      out.print(titulo );
      out.write("</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<section id=\"usuario\">\r\n");
      out.write("\t\t");

			String usuario = (String)session.getAttribute("usuarioLogeado");
			String idioma = (String)session.getAttribute("idioma");
		
			
			if(usuario == null || idioma == null || session == null){ 
      out.write("\r\n");
      out.write("\t\t\t\t<p>Por favor<a href=\"jsp/login.jsp\"> inicia sesion</a></p>\r\n");
      out.write("\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<p>Usuario: ");
      out.print(usuario );
      out.write("</p>\r\n");
      out.write("\t\t\t\t<p>Idioma: ");
      out.print(idioma );
      out.write(" </p>\r\n");
      out.write("\t\t\t\t<p><a href=\"logout\">Cerrar sesion</a></p>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
      out.write("\t<!-- <nav class=\"topnav\" id=\"myTopnav\">\r\n");
      out.write("\t\t<a href=\"#home\" class=\"active\">Home</a> <a href=\"#news\">News</a> <a\r\n");
      out.write("\t\t\thref=\"#contact\">Contact</a>\r\n");
      out.write("\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t<button class=\"dropbtn\">\r\n");
      out.write("\t\t\t\tDropdown <i class=\"fa fa-caret-down\"></i>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<div class=\"dropdown-content\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">Link 1</a> <a href=\"#\">Link 2</a> <a href=\"#\">Link 3</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<a href=\"#about\">About</a> <a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\tstyle=\"font-size: 15px;\" class=\"icon\" onclick=\"myFunction()\">&#9776;</a>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction myFunction() {\r\n");
      out.write("\t\t\tvar x = document.getElementById(\"myTopnav\");\r\n");
      out.write("\t\t\tif (x.className === \"topnav\") {\r\n");
      out.write("\t\t\t\tx.className += \" responsive\";\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tx.className = \"topnav\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class = \"nav-wrapper\">\t\r\n");
      out.write("\t\t<nav>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<a href=\"index.jsp\">Index</a>\r\n");
      out.write("\t\t\t\t<a href =\"jsp/login.jsp\">Login </a>\r\n");
      out.write("\t\t\t\t<a href=\"ejercicios/howto/top-menu-responsive.jsp\">Menu responsive</a>\r\n");
      out.write("\t\t\t\t<a href  =\"jsp/calculadora.jsp\">Calculadora </a>\r\n");
      out.write("\t\t\t\t<a href = \"https://es.wallapop.com/search?keywords=cafetera&min_sale_price=20&max_sale_price=50\">Wallapop.</a>\r\n");
      out.write("\t\t\t\t<a href = \"ejercicios/css/flexbox.jsp\">Enlace para flexbox</a>\r\n");
      out.write("\t\t\t\t<a href=\"html/animaciones.html\">Animacion</a>\r\n");
      out.write("\t\t\t\t<a href = \"http://www.indicedejuegos.com/\">Juegos de mi epoca</a>\r\n");
      out.write("\t            <a href = \"html/auxiliar.html\">Viaja a la otra pagina</a>\r\n");
      out.write("\t            <a href=\"js/datatable.jsp\">Datatable</a>\r\n");
      out.write("\t            <a href = \"ejercicios/css/mediaqueries.jsp\">Media Queries</a>\r\n");
      out.write("\t            <a href = \"doge\">Perros</a>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("<main>");
      out.write("\r\n");
      out.write("<style>img{\r\n");
      out.write("\twidth: 10vw;\r\n");
      out.write("\theight: 20vh;\r\n");
      out.write("}</style>\r\n");
      out.write("<h1>Perroz</h1>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<p style =\"color:teal; font-size:2em;\"> ");
      out.print(mensaje );
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("\t<form action=\"doge\" method=\"get\">\r\n");
      out.write("        <fieldset>\r\n");
      out.write("            <legend>Añadir perros </legend>\r\n");
      out.write("            <br> <br>\r\n");
      out.write("            <input type =\"text\" name=\"nombre\" id=\"nombre\" placeholder=\"Nombre\">\r\n");
      out.write("            <br> <br>\r\n");
      out.write("            <input type =\"image\" name=\"imagen\" id=\"imagen\" placeholder=\"Imagen\">\r\n");
      out.write("            <br> <br>\r\n");
      out.write("            <input type =\"text\" name=\"nombre\" id=\"nombre\" placeholder=\"Nombre\">\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("            <br><br>\r\n");
      out.write("\r\n");
      out.write("            <input type =\"submit\" value =\"Añadir\">\r\n");
      out.write("\r\n");
      out.write("        </fieldset>\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("    \r\n");
      out.write("    <br />\r\n");
      out.write("    <br />\r\n");
      out.write("    <br />\r\n");
      out.write("    <br />\r\n");
      out.write("    \r\n");
      out.write("    <form action=\"doge\" method=\"post\">\r\n");
      out.write("        <fieldset>\r\n");
      out.write("            <legend>Matar Perro :D </legend>\r\n");
      out.write("            <label for=\"Matar\">Oprima el boton de abajo para hacer \r\n");
      out.write("            una suculenta hamburguesa de perro</label>\r\n");
      out.write("            <br><br>\r\n");
      out.write("\r\n");
      out.write("            <input type =\"submit\" value =\"Matalooooooo\">\r\n");
      out.write("\r\n");
      out.write("        </fieldset>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
	ArrayList<Perro> listaPerros = (ArrayList<Perro>)request.getAttribute("perros");  
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<h2>Tenemos estos perros</h2>\r\n");
      out.write("\r\n");
      out.write("\t");
if(listaPerros == null){ 
		
	
      out.write("\r\n");
      out.write("\t<h3>Actualmente no disponemos de un perro :c</h3>\r\n");
      out.write("\t\t\r\n");
      out.write("\t");
}else if(!listaPerros.isEmpty()){
		int cont = 0;
		
      out.write("\t\r\n");
      out.write("\t\t<ol>\r\n");
      out.write("\t\t");
for(Perro p : listaPerros){ 
      out.write("\r\n");
      out.write("\t\t\t<li>Su nombre es: ");
      out.print(p.getNombre() );
      out.write("  Su id es: ");
      out.print(cont+1 );
      out.write(" <img src=\"");
      out.print(p.getFoto());
      out.write("\" alt=\"\" />  </li>\r\n");
      out.write("\t\t");
 cont++;
		} 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("    </main>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class = \"footer-wraper\">\r\n");
      out.write("\t    <footer>\r\n");
      out.write("\t        <div class=\"container2\">\r\n");
      out.write("\t            <p> ipsum, dolor sit amet consectetur adipisicing elit. Quia molestias eaque iure maiores </p>\r\n");
      out.write("\t            <p> nesciunt incidunt numquam quo aliquam sint repudiandae doloribus iste facere labore natus ea earum, repellat\r\n");
      out.write("\t                autem?</p>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t    </footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}