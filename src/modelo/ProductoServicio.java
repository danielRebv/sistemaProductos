package modelo;

import java.util.ArrayList;
import java.util.List;
import utilidades.Utilidad;

public class ProductoServicio {
	
	List<Producto> listaProductos;

	public ProductoServicio() {
		listaProductos = new ArrayList<>();
	}

	public void listarProductos() {
		if (listaProductos != null) {

			for (Producto producto : listaProductos) {
				System.out.println("Datos del Producto:");
				System.out.println("Nombre articulo: " + producto.getArticulo());
				System.out.println("Código: " + producto.getCodigo());
				System.out.println("Marca: " + producto.getMarca());
				System.out.println("Color: " + producto.getColor());
				System.out.println("Descripcion: " + producto.getDescripcion());
				System.out.println("Precio: " + producto.getPrecio());
				System.out.println("Talla: " + producto.getTalla());
				System.out.println("---------------------------------");
			}
		} else {
			System.out.println("No se ha podido listar a los productos, aún no carga datos");
		}
		Utilidad.stopAndContinue();
	}

	public void agregarProductos(String articulo, String precio, String descripcion, String codigo, String talla, String marca,
			String color) {
		Producto producto = new Producto(articulo, precio, descripcion, codigo, talla, marca, color);

		if (listaProductos != null) {
			listaProductos.add(producto);
		} else {
			System.out.println("El Producto al cual usted está agregando viene nulo");
		}
	}

	public List<Producto> getListaProductoss() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
}
