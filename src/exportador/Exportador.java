package exportador;

import java.util.List;

import modelo.Producto;

public abstract class Exportador {
	public abstract void exportar(String fileName, List<Producto> listaProductos);

}
