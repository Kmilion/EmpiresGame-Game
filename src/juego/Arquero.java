package juego;

public class Arquero extends Unidad {

	private static final int DANIO = 7;
	private static final double DISTANCIA_MINIMA_ATAQUE = 5;
	private static final double DISTANCIA_MAXIMA_ATAQUE = 25;
	private static final int CANTIDAD_INICIAL_DE_FLECHAS = 24;
	private int cantidadDeFlechas;

	public Arquero(Posicion posicion) {
		super(posicion);
		this.cantidadDeFlechas = Arquero.CANTIDAD_INICIAL_DE_FLECHAS;
	}

	@Override
	public boolean puedeAtacar(Unidad oponente) {
		return (this != oponente)
				&& (this.distanciaCon(oponente) <= Arquero.DISTANCIA_MAXIMA_ATAQUE
						&& this.distanciaCon(oponente) >= Arquero.DISTANCIA_MINIMA_ATAQUE)
				&& oponente.estaVivo() && this.estaVivo() && this.tieneFlechasSuficientes();
	}

	@Override
	protected int getDanio() {
		return Arquero.DANIO;
	}

	private boolean tieneFlechasSuficientes() {
		return this.cantidadDeFlechas > 0;
	}

	@Override
	public void atacar(Unidad oponente) {
		super.atacar(oponente);
		this.cantidadDeFlechas--;
	}

	public void recargar() {
		this.cantidadDeFlechas = Arquero.CANTIDAD_INICIAL_DE_FLECHAS;
	}

}
