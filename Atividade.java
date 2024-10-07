// Nome dos integrantes do grupo:
// Enzo Davi Zanella Franceschini
// Felipe Kenji Inomata Lamb

package fag;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Atividade {
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
	public static ArrayList<itemCardapio> listaCardapio = new ArrayList<>();
	public static ArrayList<Mesa> listaMesas = new ArrayList<>();
	public static ArrayList<Pedido> listaPedidos = new ArrayList<>();
	
	public static void main(String[] args) {
	while (true) {
		System.out.println("Bem vindo ao sistema de gestão! \n(1) - Funcionários. \n(2) - Cardápio/Pedidos. \n(3) - Mesas. \n(0) - Finalizar dia (exibe relatórios). \n");
			int opcaoMenu = scan.nextInt();
	            switch (opcaoMenu) {
	                case 1:
	                    funcionario();
	                    break;
	                case 2:
	                	cardapio();
	                	break;
	                case 3:
	                	mesas();
	                	break;
	                case 0:
	                    relatorioDiario();
	                    return;
	                default:
	                    System.out.println("Opção inválida.");
	            }
	        }
	    }
	
	public static void funcionario() {
		System.out.println("O quê deseja fazer? \n(1) - Cadastrar funcionários. \n(2) - Listar funcionários e suas vendas. \n(3) - Adicionar Venda. \n");
		int opcaoFuncionario = scan.nextInt();
		switch (opcaoFuncionario) {
		case 1:
			scan.nextLine();
			System.out.println("Entre com o nome do funcionário.\n");
			String nomeFunc = scan.nextLine();
			System.out.println("Entre com o ID do funcionário.\n");
			int idFunc = scan.nextInt();
			scan.nextLine();
			System.out.println("Entre com o cargo do funcionário:\n");
			String cargoFunc = scan.nextLine();
			Funcionario novoFuncionario = new Funcionario(nomeFunc, idFunc, cargoFunc);
			listaFuncionarios.add(novoFuncionario);
			System.out.println("Cadastrado!");
		break;
		case 2:
			for (Funcionario funcionario : listaFuncionarios) {
				System.out.println(funcionario);
			}
		break;
		case 3:
			System.out.println("Entre com o ID do vendedor: \n");
			int buscarId = scan.nextInt();
			Funcionario fazerVenda = buscarFuncionario(buscarId);
			if (fazerVenda != null) {
				System.out.println("Qual foi o valor da venda? \n");
				double valorDaVenda = scan.nextDouble();
				fazerVenda.Venda(valorDaVenda);
				System.out.println("Venda adicionada. \n");
			}	else {
					System.out.println("ID de funcionário não existente. \n");
			}
		break;
		default:
			return;
		}
	}
	public static Funcionario buscarFuncionario(int id) {
	    for (Funcionario funcionario : listaFuncionarios) {
	        if (funcionario.idFunc == id) {
	            return funcionario;
	        }
	    }
	    return null;
	}
	public static void cardapio() {
		System.out.println("O que deseja fazer? \n(1) - Cadastrar produto. \n(2) - Listar produtos. \n");
		int opcaoCardapio = scan.nextInt();
		switch (opcaoCardapio) {
		case 1:
			scan.nextLine();
			System.out.println("Entre com o nome do produto: \n");
			String nomeConsumivel = scan.nextLine();
			System.out.println("Entre com o ID do produto: \n");
			int idConsumivel = scan.nextInt();
			scan.nextLine();
			System.out.println("Entre com o preço do produto: \n");
			double precoConsumivel = scan.nextDouble();
			System.out.println("Entre com a quantidade de estoque: \n");
			int quantConsumivel = scan.nextInt();
			itemCardapio novoProduto = new itemCardapio(nomeConsumivel, idConsumivel, precoConsumivel, quantConsumivel);
			listaCardapio.add(novoProduto);
			System.out.println("Cadastrado!");
		break;
		case 2:
			for (itemCardapio Cardapio : listaCardapio) {
				System.out.println(Cardapio);
			}			
		default:
			return;
		}
	}
	public static void mesas() {
		System.out.println("O que deseja fazer? \n(1) - Cadastrar mesa. \n(2) - Listar mesas. \n(3) - Ocupar/Reservar mesa. \n(4) - Fazer pedido. \n(5) - Fechar conta. \n");
		int opcaoMesa = scan.nextInt();
		switch (opcaoMesa) {
		case 1:
			scan.nextLine();
			System.out.println("Entre com o número da mesa: \n");
			int numeroDaMesa = scan.nextInt();
			System.out.println("Entre com a capacidade da mesa: \n");
			int capacidadeDaMesa = scan.nextInt();
			Mesa novaMesa = new Mesa(numeroDaMesa, capacidadeDaMesa);
			listaMesas.add(novaMesa);
			System.out.println("Mesa cadastrada! \n");
		break;
		case 2:
			for (Mesa mesa : listaMesas) {
				System.out.println(mesa);
			}
		break;
		case 3:
			System.out.println("Qual mesa deseja ocupar/reservar? \n");
			int mesaReserva = scan.nextInt();
			reservarMesa(mesaReserva);
		break;
		case 4:
			System.out.println("Qual mesa deseja pedir? \n");
			int numeroMesaPedido = scan.nextInt();
			
			Mesa mesaPedido = buscarMesa(numeroMesaPedido);
			if (mesaPedido != null) {
				System.out.println("Entre com seu ID: (Garçom). \n");
				int idGarcom = scan.nextInt();
				Funcionario garcom = buscarFuncionario(idGarcom);
				if (garcom != null) {
					Pedido novoPedido = new Pedido(mesaPedido, garcom);
					while (true) {
						System.out.println("Entre com o ID do produto: \n(Entre com 0 para finalizar a venda. \n");
						int idProduto = scan.nextInt();
						if (idProduto == 0) {
							break;
						}
						itemCardapio produto = buscarProduto(idProduto);
						if (produto != null) {
							System.out.println("Entre com a quantidade do produto: \n");
							int quantProduto = scan.nextInt();
							novoPedido.vendaProduto(produto, quantProduto);
						}	else {
								System.out.println("ID Inválido. \n");
						}
					}
					listaPedidos.add(novoPedido);
					mesaPedido.adicionarPedido(novoPedido.getValorVenda());
				}	else {
					System.out.println("ID de garçom não existe.\n");
				}
			}	else {
				System.out.println("ID de mesa não existe.\n");
			}
		break;
		case 5:
			System.out.println("Qual mesa deseja fechar a conta? \n");
		    int fecharMesa = scan.nextInt();
		    Mesa fecharConta = buscarMesa(fecharMesa);
		    
		    if (fecharConta != null) {
		        System.out.println("Total da conta: " + fecharConta.valorMesa);
		        fecharConta.desocuparMesa();
		    }	else {
		        System.out.println("Mesa não encontrada. \n");
		    }
		    break;
		default:
			return;
		}	
	}
	public static void reservarMesa(int numeroDaMesa) {
		for (Mesa mesa : listaMesas) {
			if (mesa.getNumeroDaMesa() == numeroDaMesa) {
				mesa.ocuparMesa();
				return;
			}
		}
		System.out.println("Mesa não existente. \n");
	}
	public static void adicionarPedido(int numeroDaMesa) {
		for (Mesa mesa : listaMesas) {
			if (mesa.getNumeroDaMesa() == numeroDaMesa) {
				System.out.println("Entre com o ");
			}
		}
	}
	public static Mesa buscarMesa(int numeroDaMesa) {
	    for (Mesa mesa : listaMesas) {
	        if (mesa.getNumeroDaMesa() == numeroDaMesa) {
	            return mesa;
	        }
	    }
	    return null;
	}
	public static itemCardapio buscarProduto(int idProduto) {
	    for (itemCardapio produto : listaCardapio) {
	        if (produto.getIdConsumivel() == idProduto) {
	            return produto;
	        }
	    }
	    return null;
	}
	public static void relatorioDiario() {
		double vendasTotais = 0;
		double totalPorMesa;
		double totalPorFuncionario;
		System.out.println("Vendas do dia: \n");
		for (Pedido pedido : listaPedidos) {
			vendasTotais += pedido.getValorVenda();
		}
		    System.out.printf("Total de vendas realizadas no dia: R$%.2f \n",vendasTotais);
		for (Mesa mesa : listaMesas) {
			totalPorMesa = mesa.valorMesa;
		    System.out.println("Total de vendas da Mesa " + mesa.getNumeroDaMesa() + ": R$" + totalPorMesa);
		    }
		for (Funcionario funcionario : listaFuncionarios) {
        	totalPorFuncionario = funcionario.valorVendas;
        	System.out.println("Total de vendas do Funcionário " + funcionario.getNomeFunc() + ": R$ " + totalPorFuncionario);
		}
	}
}
	
