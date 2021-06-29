package br.univille.voigtdacs2021.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.voigtdacs2021.model.Produto;
import br.univille.voigtdacs2021.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController extends HttpServlet {

  @Autowired
  private ProdutoService service;

  @GetMapping
  public ModelAndView index() {
    // Produto prod1 = new Produto();
    // prod1.setDescricao("Produto legal 1");
    // prod1.setDataRegistro(new Date());
    // prod1.setPreco(2000);

    // Produto prod2 = new Produto();
    // prod2.setDescricao("Produto legal 2");
    // prod2.setDataRegistro(new Date());
    // prod2.setPreco(5000);

    List<Produto> listaProdutos = service.getAllProdutos();
    // listaProdutos.add(prod1);
    // listaProdutos.add(prod2);

    return new ModelAndView("produto/index", "listaProdutos", listaProdutos);
  }

  @GetMapping("/novo")
  public ModelAndView novo() {
    return new ModelAndView("produto/form");
  }

  // @GetMapping("/save")
  // public WebServlet ae() {
  //   return new ModelAndView("produto/form");
  // }

  // @WebServlet("ae")
  // public class Teste extends HttpServlet {

  //   protected void doPost(HttpServletRequest request, HttpServletResponse response)
  //       throws ServletException, IOException {
  //     // read form fields
  //     String nome = request.getParameter("nome");
  //     String preco = request.getParameter("preco");

  //     System.out.println("nome: " + nome);
  //     System.out.println("preco: " + preco);

  //     // do some processing here...

  //     // get response writer
  //     PrintWriter writer = response.getWriter();

  //     // build HTML code
  //     String htmlRespone = "<html>";
  //     htmlRespone += "<h2>Your username is: " + nome + "<br/>";
  //     htmlRespone += "Your password is: " + preco + "</h2>";
  //     htmlRespone += "</html>";

  //     // return response
  //     writer.println(htmlRespone);
  //   }

  // }

}
