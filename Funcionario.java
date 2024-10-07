package fag;
public class Funcionario {
	public String nomeFunc;
	public int idFunc;
	public String cargoFunc;
	public double valorVendas;
	public int contVendas;
	public Funcionario(String nomeFunc, int idFunc, String cargoFunc) {
		this.nomeFunc = nomeFunc;
		this.idFunc = idFunc;
		this.cargoFunc = cargoFunc;
		this.valorVendas = 0;
		this.contVendas = 0;
	}
	
	public String getNomeFunc() {
		return nomeFunc;
	}
	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}
	public int getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}
	public String getCargoFunc() {
		return cargoFunc;
	}
	public void setCargoFunc(String cargoFunc) {
		this.cargoFunc = cargoFunc;
	}
	public void Venda(double valorVenda) {
		valorVendas += valorVenda;
		this.contVendas++;
	}
	@Override
	public String toString() {
		return "Funcionario [Nome do funcionário =" + nomeFunc + ", ID do funcionário =" + idFunc + ", Cargo do funcionário =" + cargoFunc + ", valorVendas=" + valorVendas + ", Vendas realizadas =" + contVendas +"]";
	}
}
