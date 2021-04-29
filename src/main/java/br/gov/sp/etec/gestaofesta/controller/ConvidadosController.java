package br.gov.sp.etec.gestaofesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.etec.gestaofesta.model.Convidado;
import br.gov.sp.etec.gestaofesta.repository.Convidados;


@Controller
public class ConvidadosController{
	
	@Autowired
	Convidados convidados;
	
	@GetMapping("/convidados")
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject(new Convidado());
		modelAndView.addObject("convidados", convidados.findAll());
		return modelAndView;
	}
	
	@PostMapping("/convidados")	
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}

}
