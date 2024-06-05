package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		//vista formCarrera.html
		ModelAndView modelAndView = new ModelAndView("formCarrera");
		//adiciona un objeto Carrera
		modelAndView.addObject(new Carrera());
		return modelAndView;
	}

}
