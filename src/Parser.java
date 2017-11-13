import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<Accion> acciones = null;

	public Parser() {
		acciones = new ArrayList<Accion>();
	}

	public void parseFicheroXml(String fichero) {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parseamos el XML y obtenemos una representación DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public void parseDocument() {
		// obtenemos el elemento raíz
		Element docEle = dom.getDocumentElement();

		// obtenemos el nodelist de elementos
		NodeList nl = docEle.getElementsByTagName("accion");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// obtenemos un elemento de la lista
				Element el = (Element) nl.item(i);

				// obtenemos una persona
				Accion p = getAccion(el);

				// lo añadimos al array
				acciones.add(p);
			}
		}
	}

	private Accion getAccion(Element accionEle) {

		String nombre = getTextValue(accionEle, "nombre");
		float precio = getFloatValuePrecio(accionEle, "precio");
		float cantidad = getFloatValueCantidad(accionEle, "cantidad");
		ArrayList<String> listaC = getCompras(accionEle,"compra");
		ArrayList<String> listaP = getVentas(accionEle,"venta");
		
		Accion a = new Accion (nombre, listaC, listaP, precio, cantidad);

		return a;

	}

	private ArrayList<String> getCompras(Element ele, String tag) {
		
		ArrayList<String> lista_compras = new ArrayList<String>();
		
		NodeList nl = ele.getElementsByTagName(tag);

		if (nl != null && nl.getLength() > 0) {
			Element ele_compras = (Element) nl.item(0);

			NodeList nodelist_compras = ele_compras.getElementsByTagName("compras");

			if (nodelist_compras != null && nodelist_compras.getLength() > 0) {
				Element algo = (Element) nl.item(0);

				NodeList s = algo.getElementsByTagName("compra");
			
				for (int i = 0; i < s.getLength(); i++) {
					Element el_nombre = (Element) s.item(i);
					String texto = el_nombre.getFirstChild().getNodeValue();
					lista_compras.add(texto);					
				}
			}

		}
		return lista_compras;
	}
	
	private ArrayList<String> getVentas(Element ele, String tag) {
		
		ArrayList<String> lista_ventas = new ArrayList<String>();
		
		NodeList nl = ele.getElementsByTagName(tag);

		if (nl != null && nl.getLength() > 0) {
			Element ele_ventas = (Element) nl.item(0);

			NodeList nodelist_ventas = ele_ventas.getElementsByTagName("ventas");

			if (nodelist_ventas != null && nodelist_ventas.getLength() > 0) {
				Element algo = (Element) nl.item(0);

				NodeList s = algo.getElementsByTagName("venta");
			
				for (int i = 0; i < s.getLength(); i++) {
					Element el_nombre = (Element) s.item(i);
					String texto = el_nombre.getFirstChild().getNodeValue();
					lista_ventas.add(texto);					
				}
			}

		}
		return lista_ventas;
	}

	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}
		return textVal;
	}

	private float getFloatValuePrecio(Element ele, String tagName) {
		return Float.parseFloat(getTextValue(ele, tagName));
	}
	
	private float getFloatValueCantidad(Element ele, String tagName) {
		return Float.parseFloat(getTextValue(ele, tagName));
	}

	public void print() {

		Iterator it = acciones.iterator();
		while (it.hasNext()) {
			Accion l = (Accion) it.next();
			l.print();
			System.out.println("-----------------------------\n");
		}
	}

}