package com.example.backend4f;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "home", value = "/home")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("User Agent:" + request.getHeader("User-Agent"));
        public String getParameter(String Username, String Password)
        System.out.println(request.getParameter("Usename"));
        System.out.println(request.getParameter("Password"));

        if (Usename == "gino" and Password == "pasquale"){
            response.setContentType("text/html");
            PrintWriter oggetto = response.getWriter();
            oggetto.println("<html><body>");
            oggetto.println("<h1>" + Benvenuto + "</h1>");
            oggetto.println("</body></html>");
        } else{
            HttpSession session = request.getSession(true);
            session.setAttribute("Errore", 'Errore credenziali Sbagliate';
            response.sendRedirect("/Errore");
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    System.out.println('host:'+request.getHeader('host'));
        System.out.println('accept_encoding:'+request.getHeader('accept_encoding'));
        System.out.println('if_none_match:'+request.getHeader('if_none_match'));
        response.setContentType('text/plain');
        printWriter Stampa=response.getWriter();
        Stampa.println('buongiorno Galvani!');


    }

    public void destroy() {
    }
}