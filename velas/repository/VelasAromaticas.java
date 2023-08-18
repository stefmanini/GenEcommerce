package velas.repository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import velas.Menu;
import velas.controller.Pedidos;
import velas.util.Cores;

public class VelasAromaticas {

    private String name;
    private String essencia;
private int quantidade;

    private double preco;
    public VelasAromaticas() {}
    public VelasAromaticas (String name, String essencia, int quantidade, double preco) {
        this.name = name;
        this.essencia = essencia;
        this.quantidade = quantidade;
        this.preco = preco;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEssencia() {
        return essencia;
    }

    public void setEssencia(String essencia) {
        this.essencia = essencia;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public Double subTotal() {
        return quantidade * preco;
    }
    public static void criarPedido() {
        Scanner scanner = new Scanner(System.in);
        List<VelasAromaticas> pedido = new ArrayList<>();

        VelasAromaticas gryffindor = new VelasAromaticas("Gryffindor", "Canela", 100, 18.99);
        VelasAromaticas slytherin = new VelasAromaticas("Slytherin", "Eucalipto", 100, 18.99);
        VelasAromaticas hufflepuff = new VelasAromaticas("Hufflepuff", "Citrus", 100, 15.99);
        VelasAromaticas ravenclaw = new VelasAromaticas("Ravenclaw", "Lavanda", 100, 15.99);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Bem-vindo à loja de velas aromáticas!");
            System.out.println("Escolha a vela pelo número e quantidade desejados:");
            System.out.println(Cores.TEXT_RED_BRIGHT + "1.\uD83E\uDD81 " + gryffindor.getName());
            System.out.println(Cores.TEXT_GREEN_BRIGHT + "2.\uD83D\uDC0D " + slytherin.getName());
            System.out.println(Cores.TEXT_YELLOW_BRIGHT + "3.\uD83E\uDDA1 " + hufflepuff.getName());
            System.out.println(Cores.TEXT_BLUE_BRIGHT + "4.\uD83E\uDD85 " + ravenclaw.getName() + Cores.TEXT_RESET);

            System.out.print(Cores.TEXT_PURPLE_BRIGHT + "Escolha o número da vela (1-4) ou 0 para finalizar o pedido: ");
            int escolha = scanner.nextInt();
            if (escolha >= 1 && escolha <= 4) {
                System.out.print("Digite a quantidade desejada: ");
                int quantidade = scanner.nextInt();

                VelasAromaticas velaEscolhida = null;

                switch (escolha) {
                    case 1:
                        velaEscolhida = gryffindor;
                        break;
                    case 2:
                        velaEscolhida = slytherin;
                        break;
                    case 3:
                        velaEscolhida = hufflepuff;
                        break;
                    case 4:
                        velaEscolhida = ravenclaw;
                        break;
                }

                if (velaEscolhida != null) {
                    velaEscolhida.setQuantidade(quantidade);
                    pedido.add(velaEscolhida);
                    System.out.println("Vela adicionada ao pedido!");
                }

                System.out.print("Deseja adicionar mais velas (S/N)? ");
                String resposta = scanner.next();
                if (resposta.equalsIgnoreCase("N")) {
                    continuar = false;
                    if (!pedido.isEmpty()) {
                        System.out.println("Pedido finalizado. Itens no pedido:");
                        double totalPedido = 0.0;
                        for (VelasAromaticas vela : pedido) {
                            System.out.println("Nome: " + vela.getName() + ", Quantidade: " + vela.getQuantidade());
                            double soma = vela.getPreco() * vela.getQuantidade();
                            totalPedido += soma;
                        }
                        Pedidos novoPedido = new Pedidos(LocalDateTime.now(), "Em andamento", Pedidos.getId());
                        for (VelasAromaticas vela : pedido) {
                            novoPedido.adicionarItem(vela);
                        }
                        novoPedido.setStatus("Concluído");
                        novoPedido.setId(Pedidos.getId());
                        Pedidos.adicionarPedidoFeito(novoPedido);
                        System.out.println("Pedido finalizado. Itens no pedido:");
                        System.out.println("Valor total do pedido: " + totalPedido);
                        System.out.println("Finalizando a compra. Obrigado por escolher nossas velas aromáticas!");
                    }

                    Menu.exibirMenu(); // Chamando o método exibirMenu() para retornar ao menu principal
                }
                }
            scanner.close();
            }
        }

}

