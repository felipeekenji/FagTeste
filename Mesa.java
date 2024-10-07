package fag;
public class Mesa {
	public int numeroDaMesa;
	public int capacidadeDaMesa;
	public boolean mesaLivre;
	public double valorMesa;
	
	public Mesa(int numeroDaMesa, int capacidadeDaMesa) {
		this.numeroDaMesa = numeroDaMesa;
		this.capacidadeDaMesa = capacidadeDaMesa;
		this.mesaLivre = true;
	}
	public void ocuparMesa() {
		if (mesaLivre) {
			mesaLivre = false;
			System.out.println("Mesa " + numeroDaMesa + "reservada.");
		}	else {
				System.out.println("Mesa " + numeroDaMesa + "ocupada.");
		}
	}
	public void desocuparMesa() {
		mesaLivre = true;
	}
	public void adicionarPedido(double valorPedido) {
		valorMesa += valorPedido;
	}
	public int getNumeroDaMesa() {
		return numeroDaMesa;
	}
	public void setNumeroDaMesa(int numeroDaMesa) {
		this.numeroDaMesa = numeroDaMesa;
	}
	public int getCapacidadeDaMesa() {
		return capacidadeDaMesa;
	}
	public void setCapacidadeDaMesa(int capacidadeDaMesa) {
		this.capacidadeDaMesa = capacidadeDaMesa;
	}
	@Override
	public String toString() {
		return "Mesa [Número da mesa = " + numeroDaMesa + ", Capacidade da mesa = " + capacidadeDaMesa + ", Disponibilidade da mesa = "
				+ (mesaLivre ? "Livre" : "Ocupada") + "]";
	}
}
