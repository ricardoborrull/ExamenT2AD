import java.util.ArrayList;

public class Accion {
	
	private String nombre;
	private ArrayList <String> compras;
	private ArrayList <String> ventas;	
	private float precio;
	private float cantidad;
	
	public Accion(String nom, ArrayList<String> comp, ArrayList<String> vent, float pre , float cant) {
		nombre = nom;
		compras = comp;
		ventas = vent;
		pre = precio;
		cant = cantidad;
	}
		
	public ArrayList<String> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<String> compras) {
		this.compras = compras;
	}

	public ArrayList<String> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<String> ventas) {
		this.ventas = ventas;
	}


	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void print() {
		
		System.out.println("Nombre: "+nombre);
		System.out.println("Operaciones:");
		System.out.println("Compras: ");
		for(int i=0;i<compras.size();i++)
			System.out.println(compras.get(i));
		System.out.println("	Compra:");
		System.out.println("	Precio: " + precio);
		System.out.println("	Cantidad: "+ cantidad);
		System.out.println("Ventas: ");
		for(int i=0;i<ventas.size();i++)
			System.out.println(ventas.get(i));
		System.out.println("	Venta: ");
		System.out.println("	Precio: " + precio);
		System.out.println("	Cantidad: "+ cantidad);
		
	}
	
	

}
