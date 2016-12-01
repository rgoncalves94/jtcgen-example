package pgto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pgto.SalarioUtil;
import static org.mockito.Mockito.*;


public class SalarioUtilTest {

	private SalarioUtil instance;

	@Before
	public void setUp() throws Exception {
		
			this.instance = new SalarioUtil();
	}

	@After
	public void tearDown() throws Exception {
		this.instance = null;
	}

	@Test
	public void calculaDissidio() {
		SalarioUtil salarioutil = new SalarioUtil();

		double expected = salarioutil.calculaDissidio(3000.0, 0.05);
		assertEquals(3150.0, expected, 0.0001);
	}
	
}