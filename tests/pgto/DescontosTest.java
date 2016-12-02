package pgto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pgto.Descontos;


public class DescontosTest {

	private Descontos instance;

	@Before
	public void setUp() throws Exception {
		this.instance = new Descontos(100.0,100.0,100.0,100.0);
	}

	@After
	public void tearDown() throws Exception {
		this.instance = null;
	}

	@Test
	public void obtemDescontosSomados() {
		
		
		double resultado1 = this.instance.obtemDescontosSomados();
		assertEquals(400.0, resultado1 , 0.00001);
	}
	
}