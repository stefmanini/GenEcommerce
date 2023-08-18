package velas;

import java.util.List;
import java.util.Scanner;

import velas.controller.Pedidos;
import velas.repository.VelasAromaticas;
import velas.util.Cores;

public class Menu {
	public static void main(String[] args) {

		Menu.exibirMenu();

	}

	public static void exibirPedidosFeitos() {
		List<Pedidos> pedidos = Pedidos.getPedidosFeitos();
		if (pedidos.isEmpty()) {
			System.out.println("Nenhum pedido feito ainda.");
			return;
		}
		System.out.println("Pedidos feitos:");
		for (Pedidos pedido : pedidos) {
			System.out.println(pedido);
		}
	}

	public static void exibirMenu() {
		Scanner scanner = new Scanner(System.in);
		int opcao;

		System.out.println(Cores.TEXT_PURPLE_BRIGHT
				+ "╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n"
				+ "║                                               HOGWARTS CANDLES                                              ║\n"
				+ "╠═════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n"
				+ "║                                                                                                             ║\n"
				+ "║     \uD83E\uDD81 Gryffindor                \uD83D\uDC0D Slytherin                \uD83E\uDDA1 Hufflepuff                \uD83E\uDD85 Ravenclaw       ║\n"
				+ "║                                                                                                             ║\n"
				+ "║                                                                                                             ║\n"
				+ "╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
		System.out.println("Menu:");
		System.out.println("1. Sobre Nós: ");
		System.out.println("2. Visualizar pedidos: ");
		System.out.println("3. Escolher velas: ");
		System.out.println("0. Sair do Menu. ");
		System.out.print("Digite a opção desejada: ");

		opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			System.out.println("\rVelas Aromatizadas Mágicas do Mundo de Harry Potter!\r"
					+ "\nExplore nossas velas artesanais inspiradas nas casas de Hogwarts, além de poções e feitiços encantadores."
					+ "\nTransforme sua casa em um ambiente mágico com fragrâncias únicas com a essência do universo de Harry Potter."
					+ "\nLumos!");
			break;
		case 2:
			System.out.println("Você escolheu a Opção 2");
			Menu.exibirPedidosFeitos();
			break;
		case 3:
			System.out.println("Você escolheu a Opção 3");
			VelasAromaticas.criarPedido();
			break;
		case 0:
			System.out.println("Saindo do menu.");
			break;
		default:
			System.out.println("Opção inválida. Tente novamente.");

			Menu.exibirMenu();
		}
		scanner.close();

	}

}
