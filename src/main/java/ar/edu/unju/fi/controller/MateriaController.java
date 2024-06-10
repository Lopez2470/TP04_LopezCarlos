package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Materia;


@Controller
public class MateriaController {
	
	//Inyeccion de dependencia
		@Autowired
		Materia materia;
	
	

	 

	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		//vista formMateria.html
		ModelAndView modelAndView = new ModelAndView("formMateria");
		//adiciona un objeto materia
		modelAndView.addObject("nuevaMateria", materia);
		modelAndView.addObject("listadoDocentes",ListadoDocentes.listarDocentesHabilitadas());
		modelAndView.addObject("listadoCarreras",ListadoCarreras.listarCarrerasHabilitadas());
		modelAndView.addObject("estado", false);
		return modelAndView;
	}
	
	
	@PostMapping("/guardarMateria")
	public ModelAndView guardarMateria(@ModelAttribute("nuevaMateria") Materia materiaNuevaParaGuardar) {
		//guardar el objeto materia
		materiaNuevaParaGuardar.setDocente(ListadoDocentes.buscarDocentePor(materiaNuevaParaGuardar.getDocente().getLegajo()));
		materiaNuevaParaGuardar.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaNuevaParaGuardar.getCarrera().getCodigo()));
		ListadoMaterias.agregarMateria(materiaNuevaParaGuardar);
		//mostrar el listado
		ModelAndView modelAndView = new ModelAndView("listaDeMaterias");
		
		modelAndView.addObject("listadoMaterias",ListadoMaterias.listarMateriasHabilitadas());
		return modelAndView;
	}
	
	@GetMapping ("/eliminarMateria/{codigo}")
	public ModelAndView borrarMateria(@PathVariable (name="codigo") String codigo) {
		//borrar la materia
		ListadoMaterias.eliminarMateria(codigo);
		//mostrar listado de materias
		ModelAndView modelAndView = new ModelAndView("listaDeMaterias");
		modelAndView.addObject("listadoMaterias",ListadoMaterias.listarMateriasHabilitadas());
		return modelAndView;
		
	}

	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView getFormModificarMateria(@PathVariable(name="codigo") String codigo) {
		Materia materiaAModificar = ListadoMaterias.buscarMateriaPorCodigo(codigo);
		ModelAndView modelAndView = new ModelAndView("formMateria");
		modelAndView.addObject("nuevaMateria", materiaAModificar);
		modelAndView.addObject("estado", true);
		return modelAndView;
	};
	
	@PostMapping("/modificarMateria")
	public ModelAndView modificarMateria(@ModelAttribute("nuevaMateria") Materia materiaAModificar) {
		ListadoMaterias.modificarMateria(materiaAModificar);
		ModelAndView modelAndView = new ModelAndView("listaDeMaterias");
		modelAndView.addObject("listadoMaterias",ListadoMaterias.listarMateriasHabilitadas());
		return modelAndView;
		
	}	
	 


}
