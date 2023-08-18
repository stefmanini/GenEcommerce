package velas.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import velas.repository.VelasAromaticas;
import velas.util.Cores;

public class Pedidos {
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
	private LocalDateTime dataPedido;
	private String status;
	private static int id;
	List<VelasAromaticas> ItensList = new ArrayList<>();

	public Pedidos(LocalDateTime dataPedido, String status, int id) {
		this.dataPedido = dataPedido;
		this.status = status;
		Pedidos.id = id;
	}

	public static int getId() {
		return id;
	}

	public void setId(int id) {
		Pedidos.id = id;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<VelasAromaticas> getItensList() {
		return ItensList;
	}

	public void adicionarItem(VelasAromaticas pedido) {
		ItensList.add(pedido);
	}

	public void removerItem(VelasAromaticas pedido) {
		ItensList.remove(pedido);
	}

	public Double total() {
		double sum = 0.0;
		for (VelasAromaticas pedido : ItensList) {
			sum += pedido.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Cores.TEXT_YELLOW + "\n\tId do pedido: " + Cores.TEXT_RESET);
		sb.append(Cores.TEXT_CYAN + Pedidos.getId() + "\n" + Cores.TEXT_RESET);
		sb.append(Cores.TEXT_YELLOW + "\tMomento do pedido: " + Cores.TEXT_RESET);
		sb.append(Cores.TEXT_WHITE + dataPedido.format(fmt) + "\n" + Cores.TEXT_RESET);
		sb.append(Cores.TEXT_YELLOW + "\tStatus do pedido: " + Cores.TEXT_RESET);
		sb.append(Cores.TEXT_WHITE + this.getStatus() + "\n" + Cores.TEXT_RESET);
		sb.append(Cores.TEXT_YELLOW + "\tPedido: \n" + Cores.TEXT_RESET);
		for (VelasAromaticas item : ItensList) {
			sb.append(item + "\n");
		}
		sb.append(Cores.TEXT_YELLOW + "\tTotal a pagar: " + Cores.TEXT_RESET);
		sb.append(Cores.TEXT_CYAN + "R$" + String.format("%.2f", total()) + Cores.TEXT_RESET);
		return sb.toString();
	}

	private static List<Pedidos> pedidosFeitos = new ArrayList<>();

	// Método para adicionar o pedido à lista estática
	public static void adicionarPedidoFeito(Pedidos pedido) {
		pedidosFeitos.add(pedido);
	}

	// Método estático para obter a lista de pedidos feitos
	public static List<Pedidos> getPedidosFeitos() {
		return pedidosFeitos;
	}
}
