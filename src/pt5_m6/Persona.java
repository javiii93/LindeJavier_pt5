package pt5_m6;

import java.io.Serializable;

public class Persona implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	String nombre, apellido;
	int edad;

	public Persona(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}/*
	 * que implemente la interfaz "SERIALIZABLE". Crea un programa que cree un
	 * fichero myPeople.dat y haciendo uso de la clase persona serializable crea los
	 * objetos persona con los siguientes datos:
	 * 
	 * nombre: "María López","Gustavo Gómez","Irene Salas","Roberto Morgade"
	 * ,"Graciela Iglesias" edad: 36,1,36,63,60
	 * 
	 * 
	 * 2 - Crea un programa que lea los datos del fichero myPeople.dat (recuerda que
	 * los guardamos como un objeto serializable) y genere un fichero xml. Utilizar
	 * librería DOM
	 * 
	 * 3 - Crea un programa que lea e imprima por consola los datos del fichero
	 * generado en el ejercicio anterior
	 */