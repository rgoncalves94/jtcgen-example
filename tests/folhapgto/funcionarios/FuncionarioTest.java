package folhapgto.funcionarios;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import folhapgto.funcionarios.Funcionario;
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
	public void calculaSalarioLiquidoComBonificacao() {
		TipoContratacao tipocontratacao = mock(TipoContratacao.class);
		when(tipocontratacao.getSigla()).thenReturn("CLT");

		Funcionario funcionario = new Funcionario("User", 5000.0, tipocontratacao);

		Descontos descontos = mock(Descontos.class);
		when(descontos.obtemDescontosSomados()).thenReturn(500.0);

		double expected = funcionario.calculaSalarioLiquidoComBonificacao(descontos, 200);
		assertEquals(4700.0, expected, 0.0001);
	}
	
	@Test
	public void calculaDescontoVT() {
		TipoContratacao tipocontratacao = mock(TipoContratacao.class);
		when(tipocontratacao.getSigla()).thenReturn("CLT");

		when(tipocontratacao.getNome()).thenReturn("Contrato");

		Funcionario funcionario = new Funcionario("User", 5000.0, tipocontratacao);

		double expected = funcionario.calculaDescontoVT();
		assertEquals(250.0, expected, 0.0001);
	}
	
	@Test
	public void calculaSalarioLiquido() {
		TipoContratacao tipocontratacao = mock(TipoContratacao.class);
		when(tipocontratacao.getSigla()).thenReturn("CLT");

		Funcionario funcionario = new Funcionario("User", 5000.0, tipocontratacao);

		Descontos descontos = mock(Descontos.class);
		when(descontos.getValeTransporte()).thenReturn(100.0);

		when(descontos.getAssistMedica()).thenReturn(100.5);

		when(descontos.getAssistDental()).thenReturn(100.0);

		when(descontos.getAdiantamento()).thenReturn(100.5);

		double expected = funcionario.calculaSalarioLiquido(descontos);
		assertEquals(4599.0, expected, 0.0001);
	}
	
}