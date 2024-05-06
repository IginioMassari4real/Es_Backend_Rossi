package com.example.backend4f;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "home", value = "/home") //collegare la classe all'url
public class HelloServlet extends HttpServlet {

    @Override
    public void init (){

    }
    @Override
    public void destroy(){

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.Header(name:'User-Agent'));
        String username = request.getParameter(name:'Username');
        String password = request.getParameter(name:'Password');

        if(username.equals('Gino') && password.equals('Pasquale')){
            response.setContentType('text/html');
            PrintWriter out = response.getWriter();
            out.println('<html><body><h1>Ciao</h1></body></html>');
        } else {
            HttpSession session = request.getSession(create:true);
            String message = 'Hai sbagliato il login, sfigato....'
            session.setAttribute(name:'Error', message);
            response.sendRedirect(location: '/Errore')
    }
}
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(request.getHeader('host'));
        System.out.println(request.getHeader('Accept-Encoding'));
        System.out.println(request.getHeader('If-Nome-Match'));
        response.setContentType('text/txt');
        PrintWriter out = response.getWriter();
}       out.println('buongiorno galvani');