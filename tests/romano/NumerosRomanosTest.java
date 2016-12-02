package romano;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import romano.NumerosRomanos;
import java.lang.String;


public class NumerosRomanosTest {

	private NumerosRomanos instance;

	@Before
	public void setUp() throws Exception {
		
			this.instance = new NumerosRomanos();
	}

	@After
	public void tearDown() throws Exception {
		this.instance = null;
	}

	@Test
	public void transforma() {
		
		
		String resultado1 = this.instance.transforma(0);
		assertEquals("", resultado1 );
		
		
		String resultado2 = this.instance.transforma(1);
		assertEquals("I", resultado2 );
		
		
		String resultado3 = this.instance.transforma(2);
		assertEquals("II", resultado3 );
		
		
		String resultado4 = this.instance.transforma(5);
		assertEquals("V", resultado4 );
	}
	
}