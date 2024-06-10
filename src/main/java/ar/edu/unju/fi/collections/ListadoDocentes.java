package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;


import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	public static List<Docente> docentes = new ArrayList<Docente>();

	/**
	 * 
	 * Metodo para listar docentes
	 */
	public static List<Docente> listarDocentesHabilitadas() {
		//
		return docentes;
	}

	/**
	 * 
	 * Método para buscar un docente por legajo
	 * */
	public static Docente buscarDocentePor(String legajo) {
		for (Docente docente : docentes) {
			if (docente.getLegajo().equals(legajo)) {
				return docente;
			}
		}
		return null;
	}

	/**
	 * 
	 * Método para agregar un docente
	 * */
	public static void agregarDocente(Docente docente) {
		// agregando el estado
		docente.setEstado(true);
		docentes.add(docente);
	}

	/**
	 * 
	 * Método para modificar un docente
	 * */
	public static void modificarDocente(Docente docenteModificado) {
		for (int i = 0; i < docentes.size(); i++) {
			Docente docente = docentes.get(i);
			if (docente.getLegajo().equals(docenteModificado.getLegajo())) {
				docenteModificado.setEstado(true);
				docentes.set(i, docenteModificado);
				break;
			}
		}
	}

	/**
	 * 
	 * Método para eliminar un docente
	 * */
	public static void eliminarDocente(String legajo) {
		// borrado físico
		// docentes.removeIf(docente -> docente.getLegajo().equals(legajo));

		// borrado lógico
		for (int i = 0; i < docentes.size(); i++) {
			Docente docente = docentes.get(i);
			if (docente.getLegajo().equals(legajo)) {
				docente.setEstado(false);
				break;
			}
		}
	}


}
