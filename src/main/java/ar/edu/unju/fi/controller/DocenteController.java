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
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
@Controller

public class DocenteController {

	//Inyeccion de dependencia
	@Autowired
	Docente docente;
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista formDocente.html
		ModelAndView modelAndView = new ModelAndView("formDocente");
		//adiciona un objeto Carrera
		modelAndView.addObject("nuevoDocente", docente);
		modelAndView.addObject("estado", false);
		return modelAndView;
	}
	
	
	@PostMapping("/guardarDocente")
	public ModelAndView guardarDocente(@ModelAttribute("nuevoDocente") Docente docenteNuevoParaGuardar) {
		//guardar el objeto Docente
		ListadoDocentes.agregarDocente(docenteNuevoParaGuardar);
		//mostrar el listado
		ModelAndView modelAndView = new ModelAndView("listaDeDocentes");
		
		modelAndView.addObject("listadoDocentes",ListadoDocentes.listarDocentesHabilitadas());
		return modelAndView;
	}
	
	@GetMapping ("/eliminarDocente/{legajo}")
	public ModelAndView borrarDocente(@PathVariable (name="legajo") String legajo) {
		//borrar el docente
		ListadoDocentes.eliminarDocente(legajo);
		//mostrar listado de docente
		ModelAndView modelAndView = new ModelAndView("listaDeDocentes");
		modelAndView.addObject("listadoDocentes",ListadoDocentes.listarDocentesHabilitadas());
		return modelAndView;
		
	}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView getFormModificarDocente(@PathVariable(name="legajo") String legajo) {
		Docente docenteAModificar = ListadoDocentes.buscarDocentePor(legajo);
		ModelAndView modelAndView = new ModelAndView("formDocente");
		modelAndView.addObject("nuevoDocente", docenteAModificar);
		modelAndView.addObject("estado", true);
		return modelAndView;
	};
	
	@PostMapping("/modificarDocente")
	public ModelAndView modificarDocente(@ModelAttribute("nuevoDocente") Docente docenteaAModificar) {
		ListadoDocentes.modificarDocente(docenteaAModificar);
		ModelAndView modelAndView = new ModelAndView("listaDeDocentes");
		modelAndView.addObject("listadoDocentes",ListadoDocentes.listarDocentesHabilitadas());
		return modelAndView;
		
	}	
	
}
