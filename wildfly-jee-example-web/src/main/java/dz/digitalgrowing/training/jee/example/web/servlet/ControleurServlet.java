package dz.digitalgrowing.training.jee.example.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name= "controleur", urlPatterns= { "/controleur" })
public class ControleurServlet extends HttpServlet {

  private static final long serialVersionUID = -1003975910993698547L;


  public void init() throws ServletException {
    System.out.println("Init ..... dz.digitalgrowing.training.jee.example.web.servlet.ControleurServlet Servlet ....");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    System.out.println("dz.digitalgrowing.training.jee.example.web.servlet.ControleurServlet Start, Thread Name="+ Thread.currentThread() .getName());

    // Traitement effcetué si une requête Http est envoyée avec GET
    // Lire le paramètre name à parir de l'URL de la requête HTTP
    String name = request.getParameter("name");

    // Envoyer la réponse HTTP
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head></head>");
    out.println("<body>");
    out.println("<h3>Bonjour : " + name + " </h3>");
    out.println("</body>");
    out.println("</html>");

  }
}

