package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {
	//Inyeccion de dependencia
	@Autowired
	Carrera carrera;
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		//vista formCarrera.html
		ModelAndView modelAndView = new ModelAndView("formCarrera");
		//adiciona un objeto Carrera
		modelAndView.addObject("nuevaCarrera", carrera);
		modelAndView.addObject("estado", false);
		return modelAndView;
	}
	
	@PostMapping("/guardarCarrera")
	public ModelAndView guardarCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraNuevaParaGuardar) {
		//guardar el objeto Carrera
		ListadoCarreras.agregarCarrera(carreraNuevaParaGuardar);
		//mostrar el listado
		ModelAndView modelAndView = new ModelAndView("listaDeCarreras");
		
		modelAndView.addObject("listadoCarreras",ListadoCarreras.listarCarrerasHabilitadas());
		return modelAndView;
	}
	
	@GetMapping ("/eliminarCarrera/{codigo}")
	public ModelAndView borrarCarrera(@PathVariable (name="codigo") String codigo) {
		//borrar la carrera
		ListadoCarreras.eliminarCarrera(codigo);
		//mostrar listado de carreras
		ModelAndView modelAndView = new ModelAndView("listaDeCarreras");
		modelAndView.addObject("listadoCarreras",ListadoCarreras.listarCarrerasHabilitadas());
		return modelAndView;
		
	}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView getFormModificarCarrera(@PathVariable(name="codigo") String codigo) {
		Carrera carreraAModificar = ListadoCarreras.buscarCarreraPorCodigo(codigo);
		ModelAndView modelAndView = new ModelAndView("formCarrera");
		modelAndView.addObject("nuevaCarrera", carreraAModificar);
		modelAndView.addObject("estado", true);
		return modelAndView;
	};
	
	@PostMapping("/modificarCarrera")
	public ModelAndView modificarCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraAModificar) {
		ListadoCarreras.modificarCarrera(carreraAModificar);
		ModelAndView modelAndView = new ModelAndView("listaDeCarreras");
		modelAndView.addObject("listadoCarreras",ListadoCarreras.listarCarrerasHabilitadas());
		return modelAndView;
		
	}

}
