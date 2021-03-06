package pgto;

import br.com.jtcgen.annotations.JTCGen;
import br.com.jtcgen.annotations.SetUp;
import br.com.jtcgen.annotations.Test;
import br.com.jtcgen.annotations.TestEquals;
import br.com.jtcgen.annotations.TestFalse;
import br.com.jtcgen.annotations.TestNotNull;
import br.com.jtcgen.annotations.TestTrue;
import br.com.jtcgen.annotations.TestVoidEquals;

public class Funcionario {
	
	protected String nome;
	protected double salarioBase;
	protected Contrato tipoContrato;
	
	public Funcionario(){
		super();
		this.nome = "";
		this.salarioBase = 0.0;
		this.tipoContrato = null;
	}
	
	public Funcionario(String nome, double salarioBase, Contrato tipoContrato) {
		super();
		this.nome = nome;
		this.salarioBase = salarioBase;
		this.tipoContrato = tipoContrato;
	}
	
	public Funcionario(String nome, double salarioBase) {
		super();
		this.nome = nome;
		this.salarioBase = salarioBase;
		this.tipoContrato = new Contrato("CPS", "Prestador de Servico");
	}
	
	@Test("setup(['Jose', 3000.0]).parameter([140.0]).isTrue()")
	public boolean salarioExcedenteVT(double valeTransporte) {
		return valeTransporte < (salarioBase * 0.06);		
	}
	
	@Test("setup(['Jose', 3000.0, {c:'TipoContratacao@getSigla()', v:['CLT']}]).parameter([140.0]).eq(180.0)")
	@Test("setup(['Jose', 1500.0, {c:'TipoContratacao@getSigla()', v:['CLT']}]).parameter([140.0]).eq(0)")
	public double calculaDescontoVT(double valeTransporte) {
		double percentualDesconto = 0.0;
		if(salarioExcedenteVT(valeTransporte) && this.tipoContrato.getSigla().equals("CLT"))
			percentualDesconto = 0.06;
		
		return (this.salarioBase * percentualDesconto);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Contrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(Contrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}	
	
}