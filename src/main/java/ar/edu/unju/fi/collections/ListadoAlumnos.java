package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;



public class ListadoAlumnos {
	public static List<Alumno> alumnos = new ArrayList<Alumno>();

	/**
	 * 
	 * Metodo para listar alumnos
	 */
	public static List<Alumno> listarAlumnosHabilitadas() {
		//
		return alumnos;
	}

	/**
	 * 
	 * Método para buscar un docente por legajo
	 * */
	public static Alumno buscarAlumnoPorLU(String lu) {
		for (Alumno alumno : alumnos) {
			if (alumno.getLu().equals(lu)) {
				return alumno;
			}
		}
		return null;
	}

	/**
	 * 
	 * Método para agregar un alumno
	 * */
	public static void agregarAlumno(Alumno alumno) {
		// agregando el estado
		alumno.setEstado(true);
		alumnos.add(alumno);
	}

	/**
	 * 
	 * Método para modificar un alumno
	 * */
	public static void modificarAlumno(Alumno alumnoModificado) {
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno alumno = alumnos.get(i);
			if (alumno.getLu().equals(alumnoModificado.getLu())) {
				alumnoModificado.setEstado(true);
				alumnos.set(i, alumnoModificado);
				break;
			}
		}
	}

	/**
	 * 
	 * Método para eliminar un alumno
	 * */
	public static void eliminarAlumno(String lu) {
		// borrado físico
		// alumnos.removeIf(alumno -> alumno.getLU().equals(lu));

		// borrado lógico
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno alumno = alumnos.get(i);
			if (alumno.getLu().equals(lu)) {
				alumno.setEstado(false);
				break;
			}
		}
	}

}
