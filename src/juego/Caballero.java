package juego;

public class Caballero extends Unidad {

	private static final int DANIO = 30;
	private static final double DISTANCIA_MINIMA_ATAQUE = 1;
	private static final double DISTANCIA_MAXIMA_ATAQUE = 3;
	private Caballo caballo;

	public Caballero(Posicion posicion) {
		super(posicion);
		this.caballo = new Caballo(posicion);
	}

	@Override
	public boolean puedeAtacar(Unidad oponente) {
		return (this != oponente)
				&& (this.distanciaCon(oponente) <= Caballero.DISTANCIA_MAXIMA_ATAQUE
						&& this.distanciaCon(oponente) >= Caballero.DISTANCIA_MINIMA_ATAQUE)
				&& oponente.estaVivo() && this.estaVivo();
	}

	@Override
	protected int getDanio() {
		return Caballero.DANIO;
	}
	
	@Override
	public void atacar(Unidad oponente) {
		super.atacar(oponente);
		this.caballo.seMueve();
		this.setPosicion(this.caballo.getPosicion());
	}
	
	

}
