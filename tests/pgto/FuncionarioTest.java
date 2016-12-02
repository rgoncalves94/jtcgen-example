package pgto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pgto.Funcionario;
import static org.mockito.Mockito.*;


public class FuncionarioTest {

	private Funcionario instance;

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		this.instance = null;
	}
	
	@Test
	public void calculaDescontoVT() {
		TipoContratacao tipocontratacao = mock(TipoContratacao.class);
		when(tipocontratacao.getSigla()).thenReturn("CLT");

		Funcionario funcionario = new Funcionario("Jose", 3000.0, tipocontratacao);

		double expected = funcionario.calculaDescontoVT(140.0);
		assertEquals(180.0, expected, 0.0001);

		TipoContratacao tipocontratacao1 = mock(TipoContratacao.class);
		when(tipocontratacao1.getSigla()).thenReturn("CLT");

		Funcionario funcionario1 = new Funcionario("Jose", 1500.0, tipocontratacao1);

		double expected1 = funcionario1.calculaDescontoVT(140.0);
		assertEquals(0.0, expected1, 0.0001);
	}
	
}