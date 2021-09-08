package juego;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Posicion {

	private double x;
	private double y;

	public Posicion(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double distanciaCon(Posicion otraPosicion) {
		return sqrt(pow(this.x - otraPosicion.x, 2) + pow(this.y - otraPosicion.y, 2));
	}

	public void moverPosicion(double deltaX, double deltaY) {
		this.x += deltaX;
		this.y += deltaY;
	}

	@Override
	public String toString() {
		return "(" + this.x + " , " + this.y + ")";
	}

}
