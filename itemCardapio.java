package fag;
public class itemCardapio {
	public String nomeConsumivel;
	public int idConsumivel;
	public double precoConsumivel;
	public int quantConsumivel;
	public boolean itemDisponivel;
	public itemCardapio(String nomeConsumivel, int idConsumivel, double precoConsumivel, int quantConsumivel) {
		this.nomeConsumivel = nomeConsumivel;
		this.idConsumivel = idConsumivel;
		this.precoConsumivel = precoConsumivel;
		this.quantConsumivel = quantConsumivel;
		this.itemDisponivel = quantConsumivel >=1;
	}
	public void setQuantConsumivel(int quantidade) {
		this.quantConsumivel = quantidade;
		this.itemDisponivel = quantConsumivel >=1;
	}
	public String getNomeConsumivel() {
		return nomeConsumivel;
	}
	public void setNomeConsumivel(String nomeConsumivel) {
		this.nomeConsumivel = nomeConsumivel;
	}
	public int getIdConsumivel() {
		return idConsumivel;
	}
	public void setIdConsumivel(int idConsumivel) {
		this.idConsumivel = idConsumivel;
	}
	public double getPrecoConsumivel() {
		return precoConsumivel;
	}
	public void setPrecoConsumivel(double precoConsumivel) {
		this.precoConsumivel = precoConsumivel;
	}
	public int getQuantConsumivel() {
		return quantConsumivel;
	}
	public boolean vendaProduto(int quantVenda) {
		if (quantVenda <= quantConsumivel) {
			quantConsumivel -= quantVenda;
			itemDisponivel = quantConsumivel >= 1;
			return true;
		}
			return false;
	}
	@Override
	public String toString() {
		return "itemCardapio [Nome do produto = " + nomeConsumivel + ", Id do produto = " + idConsumivel
				+ ", Preco do produto = " + precoConsumivel + ", Quantidade do produto = " + quantConsumivel + ", Item disponivel = "
				+ itemDisponivel + "]";
	}
	
}