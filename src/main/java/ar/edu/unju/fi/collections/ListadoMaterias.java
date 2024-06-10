package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

public class ListadoMaterias {

	public static List<Materia> materias = new ArrayList<Materia>();
	


	

	/**
	 * 
	 * Metodo para listar materias
	 */
	public static List<Materia> listarMateriasHabilitadas() {
		//
		return materias;
	}


	
	/**
	 * 
	 * Método para buscar un docente por legajo
	 * */
	public static Materia buscarMateriaPorCodigo(String codigo) {
		for (Materia materia : materias) {
			if (materia.getCodigo().equals(codigo)) {
				return materia;
			}
		}
		return null;
	}
	


	/**
	 * 
	 * Método para agregar un docente
	 * */
	public static void agregarMateria(Materia materia) {
		// agregando el estado
		materia.setEstado(true);
		materias.add(materia);
	}
	
	


	/**
	 * 
	 * Método para modificar una materia
	 * */
	public static void modificarMateria(Materia materiaModificado) {
		for (int i = 0; i < materias.size(); i++) {
			Materia materia = materias.get(i);
			if (materia.getCodigo().equals(materiaModificado.getCodigo())) {
				materiaModificado.setEstado(true);
				materias.set(i, materiaModificado);
				break;
			}
		}
	}

	/**
	 * 
	 * Método para eliminar un docente
	 * */
	public static void eliminarMateria(String codigo) {
		// borrado físico
		// materias.removeIf(materia -> materia.getCodigo().equals(codigo));

		// borrado lógico
		for (int i = 0; i < materias.size(); i++) {
			Materia materia = materias.get(i);
			if (materia.getCodigo().equals(codigo)) {
				materia.setEstado(false);
				break;
			}
		}
	}
	
}
