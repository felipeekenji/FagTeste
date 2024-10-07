package fag;
import java.util.ArrayList;
import java.util.List;
public class Pedido {
	public Mesa mesaVenda;
	public Funcionario garcom;
	public List<itemCardapio> produtos;
	public double valorVenda;
	
	public Pedido(Mesa mesaVenda, Funcionario garcom) {
		this.mesaVenda = mesaVenda;
		this.garcom = garcom;
		this.produtos = new ArrayList<>();
		this.valorVenda = 0.0;
	}
	
	public void vendaProduto(itemCardapio produto, int quantProduto) {
		if (produto.vendaProduto(quantProduto)) {
			produtos.add(produto);
			valorVenda += quantProduto * produto.getPrecoConsumivel();
			garcom.Venda(quantProduto * produto.getPrecoConsumivel());
		}	else {
				System.out.println("Produto sem estoque. \n");
		}
	}

	public Mesa getMesaVenda() {
		return mesaVenda;
	}

	public void setMesaVenda(Mesa mesaVenda) {
		this.mesaVenda = mesaVenda;
	}

	public Funcionario getGarcom() {
		return garcom;
	}

	public void setGarcom(Funcionario garcom) {
		this.garcom = garcom;
	}

	public List<itemCardapio> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<itemCardapio> produtos) {
		this.produtos = produtos;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
}