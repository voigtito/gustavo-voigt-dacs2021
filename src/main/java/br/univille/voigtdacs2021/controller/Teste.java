package br.univille.voigtdacs2021.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/produto/save")
public class Teste extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // read form fields
    String nome = request.getParameter("nome");
    String preco = request.getParameter("preco");
      
    System.out.println("nome: " + nome);
    System.out.println("preco: " + preco);

    // do some processing here...
      
    // get response writer
    PrintWriter writer = response.getWriter();
      
    // build HTML code
    String htmlRespone = "<html>";
    htmlRespone += "<h2>Your username is: " + nome + "<br/>";      
    htmlRespone += "Your password is: " + preco + "</h2>";    
    htmlRespone += "</html>";
      
    // return response
    writer.println(htmlRespone);
  }

}
