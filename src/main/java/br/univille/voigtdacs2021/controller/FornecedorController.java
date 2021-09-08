package br.univille.voigtdacs2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.voigtdacs2021.service.FornecedorService;
import br.univille.voigtdacs2021.model.Fornecedor;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService service;
    
    @GetMapping
    public ModelAndView index(){
        List<Fornecedor> listaFornecedor = service.getAllFornecedores();
        return new ModelAndView("fornecedor/index", "listaFornecedor", listaFornecedor);
    }

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Fornecedor fornecedor){
        return new ModelAndView("fornecedor/form");
    }

    @PostMapping(params = "form")
    public ModelAndView save(Fornecedor fornecedor){
        service.save(fornecedor);
        return new ModelAndView("redirect:/fornecedor");
    }

    @GetMapping(value = "/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Fornecedor fornecedor){
        return new ModelAndView("fornecedor/form","fornecedor",fornecedor);
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Fornecedor fornecedor){
        service.delete(fornecedor);
        return new ModelAndView("redirect:/fornecedor");
    }
}
