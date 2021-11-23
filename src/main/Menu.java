package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exportador.ExportadorTxt;
import modelo.Producto;
import modelo.ProductoServicio;
import utilidades.Utilidad;

public class Menu {
	ProductoServicio productoServicio = new ProductoServicio();
	ExportadorTxt exportartxt = new ExportadorTxt();
	String fileName = "productos";
	Scanner scanner = new Scanner(System.in);

		public void iniciarMenu() {
			List<String> opcionesMenu = new ArrayList<String>();
			opcionesMenu.add("Listar Producto");
			opcionesMenu.add("Agregar Producto");
			opcionesMenu.add("Exportar Datos");
			opcionesMenu.add("Salir");
			Menu menu = new Menu();
			menu.seleccionOpcion(opcionesMenu);
		}

		protected int construirMenu(List<String> pOpcionesMenu) {
			List<String> opcionesMenu = pOpcionesMenu;
			int largo = opcionesMenu.size();
			for (int i = 0; i < largo; i++) {
				System.out.println(i + 1 + " " + opcionesMenu.get(i));
			}
			int opcion = 0;
			System.out.println("Ingrese una opción:");
			try {
				opcion = scanner.nextInt();
			} catch (Exception error) {
				scanner.nextLine();
			}
			if (opcion < 1 || opcion >= largo + 1) {
				System.out.println("Selección no permitida");
			}
			return opcion;
		}

		public void seleccionOpcion(List<String> pOpcionesMenu) {
			boolean continuar = false;
			int resultado;

			do {
				resultado = construirMenu(pOpcionesMenu);
				switch (resultado) {
				case 1:
					listarProductos();
					break;
				case 2:
					agregarProductos();
					break;
			    case 3:
					exportarDatos();
					break;
				case 4:
					salirSistema();
				default:
					System.out.println("Opción no válida");
				}
			} while (!continuar);
		}

		private void listarProductos() {
			productoServicio.listarProductos();
			Utilidad.stopAndContinue();
		}
		private void agregarProductos() {
			System.out.println("Crear Producto");
			scanner.nextLine(); 
			System.out.println("Ingresar nombre articulo:");
			String articulo = scanner.nextLine();
			System.out.println("Ingresa precio:");
			String precio = scanner.nextLine();
			System.out.println("Ingresa descripcion:");
			String descripcion = scanner.nextLine();
			System.out.println("Ingresa codigo:");
			String codigo = scanner.nextLine();
			System.out.println("Ingresa talla:");
			String talla = scanner.nextLine();
			System.out.println("Ingresa marca:");
			String marca = scanner.nextLine();
			System.out.println("Ingresa color:");
			String color = scanner.nextLine();

			productoServicio.agregarProductos(articulo, precio, descripcion, codigo, talla, marca, color);
			Utilidad.stopAndContinue();
		}
		private void exportarDatos() {
			System.out.println("Exportar Datos");
			System.out.println("Ingrese la opción 1 para exportar:");
			
			List<Producto> listaProductos = productoServicio.getListaProductoss();
			int opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				exportartxt.exportar(fileName + ".txt", listaProductos);
				Utilidad.stopAndContinue();
				break;
			case 2:
				System.out.println("Número de opción ingresado incorrectamente.");
			}
		}
		private void salirSistema() {
			System.out.println("Abandonando el sistema de productos...");
			Utilidad.timeToWait();
			System.out.println("Acaba de salir del sistema");
			Utilidad.stopAndContinue();
			System.exit(0);
		}
	}


