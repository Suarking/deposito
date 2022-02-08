import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DepositoCombustibleTest {

	// Probando depósito inicialmente vacío
	DepositoCombustible Deposito = new DepositoCombustible(40.0, 0.0);
	
    //PRUEBAS DE NIVEL ACTUAL
	@Test
	public void testGetDepositoNivel() { //Buscamos el nivel actual
		assertEquals(0.0, Deposito.getDepositoNivel(), 0.1); //Es 0.0, así que la salida es la esperada
	}
	
	
	//PRUEBA DE NIVEL MÁXIMO

	@Test
	public void testGetDepositoMax() { //Buscamos el nivel máximo 
		assertEquals(40.0, Deposito.getDepositoMax(), 0.1);//Es 40.0, así que la salida es la esperada
	}
	//PRUEBAS DEPÓSITO VACÍO

	@Test
	public void testEstaVacio() { //Buscamos si el depósito está vacío
		assertSame(true, Deposito.estaVacio()); //depNivel==0.0, así que esperamos true 
	}
	
	@Test
	public void testEstaVacioFillConsumir() { //Buscamos si el depósito está vacío
		Deposito.fill(40.0); //Al tener 0.0, utilizamos el método fill para probarlo y llenamos 40
		Deposito.consumir(20.0); //Probamos de paso el método consumir, eliminamos 20 y quedan 20
		assertSame(false, Deposito.estaVacio()); //depNivel!=0.0, así que esperamos false
	}
	//PRUEBAS DEPÓSITO LLENO
	
	@Test
	public void testEstaLleno() { //Queremos probar si el depósito está lleno
		assertSame(false, Deposito.estaLleno());//depNivel!=depMax, así que esperamos false
	}	
	
	@Test
	public void testEstaLlenoFillMax() { //Queremos probar si el depósito está lleno, probando método fill
		Deposito.fill(40.0); //Al tener 0.0, utilizamos el método fill y llenamos 40
		assertSame(true, Deposito.estaLleno());//Ahora estará lleno, true
	}
	@Test
	public void testEstaLlenoFillMed() { //Queremos probar si el depósito está lleno, método fill sin llenarlo
		Deposito.fill(20.0);  //Esta vez utilizamos el método fill y llenamos solo 20
		assertSame(false, Deposito.estaLleno()); //No estará lleno, false
	}

}
