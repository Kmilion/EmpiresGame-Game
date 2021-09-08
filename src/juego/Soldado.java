package juego;

public class Soldado extends Unidad {

	private static final int DANIO = 20;
	private static final double DISTANCIA_MAXIMA_ATAQUE = 1.5;
	private static final double CANTIDAD_MAXIMA_ATAQUES = 5;
	private int cantidadDeAtaques;

	public Soldado(Posicion posicion) {
		super(posicion);
	}

	@Override
	public boolean puedeAtacar(Unidad oponente) {
		return (this != oponente) && (this.distanciaCon(oponente) <= Soldado.DISTANCIA_MAXIMA_ATAQUE)
				&& oponente.estaVivo() && this.estaVivo() && (!this.estaCansado());
	}

	@Override
	protected int getDanio() {
		return Soldado.DANIO;

	}
	
	private boolean estaCansado() {
		return this.cantidadDeAtaques >= Soldado.CANTIDAD_MAXIMA_ATAQUES;
	}
	
	public void descansar() {
		this.cantidadDeAtaques = 0;
	}
	
	@Override
	public void atacar(Unidad oponente) {
		super.atacar(oponente);
		this.cantidadDeAtaques++;
	}

}
