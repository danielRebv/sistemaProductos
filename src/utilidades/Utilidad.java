package utilidades;

public class Utilidad {
	public static void stopAndContinue() {
		timeToWait();
		cleanScreen();
	}

	public static void cleanScreen() {
		for (int i = 0; i < 10; i++) {
			System.out.println("");
		}
		System.out.flush();
	}

	public static void timeToWait() {
		int timeWait = 10; // Segundos
		try {
			for (int i = 0; i < timeWait; i++) {
				Thread.sleep(150);
			}
		} catch (InterruptedException ie) {
			System.out.println("Tiempo de espera interrumpido");
		}
	}
}
