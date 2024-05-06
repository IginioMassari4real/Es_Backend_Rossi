package com.example.backend4f;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Errore", value = "/Errore")
public class ErroreServlet extends HttpServlet {

    @Override
    public void init (){

    }
    @Override
    public void destroy(){

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = (String) session.getAttribute(true);
        String Attributo=(String) session.getAttribute('Errore');
        System.out.println(Attributo);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>" + Attributo + '</h1></body></html>');

    }
}