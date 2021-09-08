package juego;

public abstract class Unidad {

	private Posicion posicion;
	private int salud;
	private static final int SALUD_INICIAL = 100;

	public Unidad(Posicion posicion) {
		this.salud = SALUD_INICIAL;
		this.posicion = posicion;
	}
	
	public abstract boolean puedeAtacar(Unidad oponente);
	protected abstract int getDanio();

	public double distanciaCon(Unidad oponente) {
		return this.posicion.distanciaCon(oponente.posicion);
	}

	public void atacar(Unidad oponente) {
		if (this.puedeAtacar(oponente)) {
			oponente.recibirDanio(this);
		}
	}

	public int getSalud() {
		return this.salud;
	}

	public boolean estaVivo() {
		return this.salud > 0;
	}

	protected void recibirDanio(Unidad oponente) {
		this.salud -= oponente.getDanio();
	}
	
	protected void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	protected Posicion getPosicion() {
		return this.posicion;
	}
}
