package folhapgto.funcionarios;

import br.com.jtcgen.annotations.JTCGen;
import br.com.jtcgen.annotations.Test;

@JTCGen
public class Funcionario {
	
	protected String nome;
	protected double salarioBase;
	protected TipoContratacao tipoContrato;
	
	public Funcionario(String nome, double salarioBase, TipoContratacao tipoContrato) {
		super();
		this.nome = nome;
		this.salarioBase = salarioBase;
		this.tipoContrato = tipoContrato;
	}
	
	/**
	 * Calcula descontos do vale transporte
	 * */
	@Test("setup(['User', 5000.0, {c:'TipoContratacao@getSigla()@getNome()', v:['CLT', 'Contrato']}]).parameter().eq(250.0)")
	public double calculaDescontoVT() {
		
		double percentualDesconto = 0.0;
		
		if(this.salarioBase > 2000.0 && this.tipoContrato.getSigla().equals("CLT") 
				&& this.tipoContrato.getNome().equals("Contrato")){
			percentualDesconto = 0.05;
		}
		
		return this.salarioBase * percentualDesconto;
	}
	
	@Test("setup(['User', 5000.0, {c:'TipoContratacao@getSigla()', v:'CLT'}])"
	+ ".parameter([{c:'Descontos@getValeTransporte()@getAssistMedica()@getAssistDental()@getAdiantamento()',"
	+ "v:[100.0, 100.5, 100.0, 100.5]}]).eq(4599.0)")
	public double calculaSalarioLiquido(Descontos desc) {
		return this.salarioBase - desc.getValeTransporte() - desc.getAssistMedica()
				- desc.getAssistDental() - desc.getAdiantamento();
	}
	
	@Test("setup(['User', 5000.0, {c:'TipoContratacao@getSigla()', v:'CLT'}])"
		+ ".parameter([{c:'Descontos@obtemDescontosSomados()',v:500.0}, 200.0]).eq(4700.0)")
		public double calculaSalarioLiquidoComBonificacao(Descontos desc, double bonificacao) {
			return this.salarioBase - desc.obtemDescontosSomados() + bonificacao;
		}
	
}
