package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {
	

	 
	//Inyeccion de dependencia
	@Autowired
	Alumno alumno;
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista formAlumno.html
		ModelAndView modelAndView = new ModelAndView("formAlumno");
		//adiciona un objeto Alumno
		modelAndView.addObject("nuevoAlumno", alumno);
		modelAndView.addObject("estado", false);
		return modelAndView;
	}
	
	
	@PostMapping("/guardarAlumno")
	public ModelAndView guardarAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoNuevoParaGuardar) {
		//guardar el objeto Alumno
		ListadoAlumnos.agregarAlumno(alumnoNuevoParaGuardar);
		//mostrar el listado
		ModelAndView modelAndView = new ModelAndView("listaDeAlumnos");
		
		modelAndView.addObject("listadoAlumnos",ListadoAlumnos.listarAlumnosHabilitadas());
		return modelAndView;
	}

	@GetMapping ("/eliminarAlumno/{lu}")
	public ModelAndView borrarAlumno(@PathVariable (name="lu") String lu) {
		//borrar el docente
		ListadoAlumnos.eliminarAlumno(lu);
		//mostrar listado de docente
		ModelAndView modelAndView = new ModelAndView("listaDeAlumnos");
		modelAndView.addObject("listadoAlumnos",ListadoAlumnos.listarAlumnosHabilitadas());
		return modelAndView;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/modificarAlumno/{lu}")
	public ModelAndView getFormModificarAlumno(@PathVariable(name="lu") String lu) {
		Alumno alumnoAModificar = ListadoAlumnos.buscarAlumnoPorLU(lu);
		ModelAndView modelAndView = new ModelAndView("formAlumno");
		modelAndView.addObject("nuevoAlumno", alumnoAModificar);
		modelAndView.addObject("estado", true);
		return modelAndView;
	};

	@PostMapping("/modificarAlumno")
	public ModelAndView modificarAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoAModificar) {
		ListadoAlumnos.modificarAlumno(alumnoAModificar);
		ModelAndView modelAndView = new ModelAndView("listaDeAlumnos");
		modelAndView.addObject("listadoAlumnos",ListadoAlumnos.listarAlumnosHabilitadas());
		return modelAndView;
		
	}

}
