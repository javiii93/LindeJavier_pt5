package pt5_m6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class MainClass {
	static int cantidadPersonas = 5;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
/*
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myPeople.dat"));
		Persona p1 = new Persona("María", "López", 36);
		oos.writeObject(p1);
		Persona p2 = new Persona("Gustavo", "Gómez", 1);
		oos.writeObject(p2);
		Persona p3 = new Persona("Irene", "Salas", 36);
		oos.writeObject(p3);
		Persona p4 = new Persona("Roberto", "Morgade", 63);
		oos.writeObject(p4);
		Persona p5 = new Persona("Graciela", "Iglesias", 60);
		oos.writeObject(p5);
		oos.close();
*/
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myPeople.dat"));
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// root element
			Element rootElement = doc.createElement("Personas");
			doc.appendChild(rootElement);

			// definimos cada uno de los elementos y le asignamos un valor

			for (int i = 0; i < cantidadPersonas; i++) {
				Element persona = doc.createElement("Persona");
				rootElement.appendChild(persona);
				Persona aux = (Persona) ois.readObject();
				System.out.println(aux.toString());
				Attr attid = doc.createAttribute("id");
				attid.setValue(String.valueOf(i+1));
				persona.setAttributeNode(attid);

				Element eNombre = doc.createElement("nombre");
				eNombre.appendChild(doc.createTextNode(aux.getNombre()));
				persona.appendChild(eNombre);

				Element eApellido = doc.createElement("apellido");
				eApellido.appendChild(doc.createTextNode(aux.getApellido()));
				persona.appendChild(eApellido);

				Element eEdad = doc.createElement("edad");
				eEdad.appendChild(doc.createTextNode(String.valueOf(aux.getEdad())));
				persona.appendChild(eEdad);
			}
			ois.close();
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("Fichero.xml"));
			transformer.transform(source, result);
			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
