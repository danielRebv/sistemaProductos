package exportador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import modelo.Producto;

public class ExportadorTxt extends Exportador {
	  Scanner scanner = new Scanner(System.in);

	@Override
	public void exportar(String fileName, List<Producto> listaProductos) {
		if (listaProductos == null) {
			System.out.println("La lista está vacía...");
		} else {
			System.out.println("Exportar Datos");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo productos.txt: ");
			String cvsSeparatorValue = ",";
			String filePath = scanner.nextLine();
			String file = filePath + "/" + fileName;
			File fl = new File(file);
			if (fl.exists()) {
				fl.delete();
			}

			try {
				PrintWriter pWriter = new PrintWriter(new FileWriter(file));

				listaProductos.forEach(producto -> {
					pWriter.append(producto.getArticulo()).append(cvsSeparatorValue)
					.append(producto.getCodigo()).append(cvsSeparatorValue)
					.append(producto.getDescripcion()).append(cvsSeparatorValue)
					.append(producto.getMarca()).append(cvsSeparatorValue)
					.append(producto.getPrecio()).append(cvsSeparatorValue)
					.append(producto.getTalla()).append(cvsSeparatorValue)
					.append(producto.getColor()).append(System.lineSeparator());
				});
				pWriter.close();
				System.out.println("Datos de productos exportados correctamente en formato .txt");
			} catch (IOException error) {
				System.out.println("El archivo no pudo ser creado en formato .txt");
			} finally {
				System.out.println("---------------------------------------");
			}

		}

		
	}
}
