import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DepositoCombustibleTest {

	// Probando dep�sito inicialmente vac�o
	DepositoCombustible Deposito = new DepositoCombustible(40.0, 0.0);
	
    //PRUEBAS DE NIVEL ACTUAL
	@Test
	public void testGetDepositoNivel() { //Buscamos el nivel actual
		assertEquals(0.0, Deposito.getDepositoNivel(), 0.1); //Es 0.0, as� que la salida es la esperada
	}
	
	
	//PRUEBA DE NIVEL M�XIMO

	@Test
	public void testGetDepositoMax() { //Buscamos el nivel m�ximo 
		assertEquals(40.0, Deposito.getDepositoMax(), 0.1);//Es 40.0, as� que la salida es la esperada
	}
	//PRUEBAS DEP�SITO VAC�O

	@Test
	public void testEstaVacio() { //Buscamos si el dep�sito est� vac�o
		assertSame(true, Deposito.estaVacio()); //depNivel==0.0, as� que esperamos true 
	}
	
	@Test
	public void testEstaVacioFillConsumir() { //Buscamos si el dep�sito est� vac�o
		Deposito.fill(40.0); //Al tener 0.0, utilizamos el m�todo fill para probarlo y llenamos 40
		Deposito.consumir(20.0); //Probamos de paso el m�todo consumir, eliminamos 20 y quedan 20
		assertSame(false, Deposito.estaVacio()); //depNivel!=0.0, as� que esperamos false
	}
	//PRUEBAS DEP�SITO LLENO
	
	@Test
	public void testEstaLleno() { //Queremos probar si el dep�sito est� lleno
		assertSame(false, Deposito.estaLleno());//depNivel!=depMax, as� que esperamos false
	}	
	
	@Test
	public void testEstaLlenoFillMax() { //Queremos probar si el dep�sito est� lleno, probando m�todo fill
		Deposito.fill(40.0); //Al tener 0.0, utilizamos el m�todo fill y llenamos 40
		assertSame(true, Deposito.estaLleno());//Ahora estar� lleno, true
	}
	@Test
	public void testEstaLlenoFillMed() { //Queremos probar si el dep�sito est� lleno, m�todo fill sin llenarlo
		Deposito.fill(20.0);  //Esta vez utilizamos el m�todo fill y llenamos solo 20
		assertSame(false, Deposito.estaLleno()); //No estar� lleno, false
	}

}
