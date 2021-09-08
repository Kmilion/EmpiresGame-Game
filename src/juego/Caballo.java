package juego;

public class Caballo {

	private Posicion posicion;

	public Caballo(Posicion posicion) {
		this.posicion = posicion;
	}

	public boolean seAsusta() {
		double aleatorio = Math.random();
		return (int) (aleatorio * 2)  + 1 == 2;
	}

	public void seMueve() {
		if (this.seAsusta()) {
			double aleatorio1 = Math.random();
			double aleatorio2 = Math.random();
			double deltaX = 3;
			double deltaY = 3;
			double signoX = (int) (aleatorio1 * 2) + 1;
			double signoY = (int) (aleatorio2 * 2) + 1;
			if (signoX == 1) {
				deltaX = deltaX * -1;
			}
			if (signoY == 1) {
				deltaY = deltaY * -1;
			}
			this.posicion.moverPosicion(deltaX, deltaY);
		}
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

}
