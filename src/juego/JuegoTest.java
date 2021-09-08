package juego;

import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class JuegoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Unidad u1 = new Soldado(new Posicion(0, 0));
		Unidad u2 = new Soldado(new Posicion(1, 1));
		assertEquals(sqrt(2), u1.distanciaCon(u2), 0.001);
	}

	@Test
	public void consignaTest() {
		Unidad u1 = new Arquero(new Posicion(0, 0));
		Unidad u2 = new Caballero(new Posicion(1, 10));
		Unidad u3 = new Soldado(new Posicion(2, 2));

		assertEquals(100, u2.getSalud());
		u1.atacar(u2);
		assertEquals(93, u2.getSalud());

		assertEquals(100, u3.getSalud());
		u1.atacar(u3);
		assertEquals(100, u3.getSalud());
	}

	@Test
	public void atacarHastaMatarTest() {
		Unidad u2 = new Arquero(new Posicion(1, 1));
		Unidad u3 = new Soldado(new Posicion(1, 10));
		int contadorDeAtaques = 0;

		while (u3.estaVivo() && u2.puedeAtacar(u3)) {
			u2.atacar(u3);
			contadorDeAtaques++;
		}
		assertFalse(u2.puedeAtacar(u3));
		assertFalse(u3.puedeAtacar(u2));
		assertEquals(15, contadorDeAtaques);
	}

	@Test
	public void atacarHastaMatarTest2() {
		Unidad u2 = new Soldado(new Posicion(1, 1));
		Unidad u3 = new Arquero(new Posicion(1, 10));
		int contadorDeAtaques = 0;

		while (u3.estaVivo() && u2.puedeAtacar(u3)) {
			u2.atacar(u3);
			contadorDeAtaques++;
		}
		assertFalse(u2.puedeAtacar(u3));
		assertTrue(u3.puedeAtacar(u2));
		assertEquals(0, contadorDeAtaques);
	}

	@Test
	public void atacarHastaQuedarSinFlechas() {
		Unidad u2 = new Arquero(new Posicion(1, 1));
		Unidad u3 = new Soldado(new Posicion(1, 10));
		Unidad u4 = new Soldado(new Posicion(0, 10));

		int contadorDeAtaques = 0;

		while (u2.puedeAtacar(u3)) {
			contadorDeAtaques++;
			u2.atacar(u3);
		}
		while (u2.puedeAtacar(u4)) {
			contadorDeAtaques++;
			u2.atacar(u4);
		}
		assertEquals(24, contadorDeAtaques);
		assertFalse(u3.estaVivo());
		assertTrue(u4.estaVivo());
	}

	@Test
	public void atacarHastaCansarse() {
		Unidad u1 = new Soldado(new Posicion(0, 0));
		Unidad u2 = new Caballero(new Posicion(1, 1));
		Unidad u3 = new Soldado(new Posicion(-1, -1));

		int contadorDeAtaques = 0;

		while (u1.puedeAtacar(u2)) {
			contadorDeAtaques++;
			u1.atacar(u2);
		}
		
		((Soldado) u1).descansar();
		
		while(u1.puedeAtacar(u3)) {
			contadorDeAtaques++;
			u1.atacar(u3);
		}
		assertEquals(10, contadorDeAtaques);
		assertFalse(u2.estaVivo());
		assertFalse(u3.estaVivo());
		assertTrue(u1.estaVivo());
	}
	
	@Test
	public void caballoSeMueveTest() {
		Unidad u1 = new Soldado(new Posicion(0, 0));
		Unidad u2 = new Caballero(new Posicion(1, 1));
		
		u2.atacar(u1);
		System.out.println(u2.getPosicion());
	}

}
