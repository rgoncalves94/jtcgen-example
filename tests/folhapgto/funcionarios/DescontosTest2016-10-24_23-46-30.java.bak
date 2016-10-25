package folhapgto.funcionarios;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import folhapgto.funcionarios.Descontos;


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
		
		
		double resultado = this.instance.obtemDescontosSomados();
		assertEquals(400.0, resultado, 0.00001);
	}
	
}