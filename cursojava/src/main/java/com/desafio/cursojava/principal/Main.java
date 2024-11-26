package com.desafio.cursojava.principal;

import com.desafio.cursojava.modelo.Dados;
import com.desafio.cursojava.modelo.Modelos;
import com.desafio.cursojava.modelo.Veiculo;
import com.desafio.cursojava.servico.ConsumoAPI;
import com.desafio.cursojava.servico.ConversaoDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final Scanner leitura = new Scanner(System.in);
    private final ConsumoAPI consumo = new ConsumoAPI();
    private ConversaoDados conversor = new ConversaoDados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    //Tipo do veículo para consulta
    public void exibeMenu() {
        var menu_tipos = """
                *** TIPOS ***
                1 - Carro
                2 - Moto
                3 - Caminhão
                Digite uma das opções para consultar as marcas:
                """;

        System.out.println(menu_tipos);
        var tipos = leitura.nextLine();
        String endereco;

        switch (tipos.toLowerCase()) {
            case "carro", "carros", "1":
                endereco = URL_BASE + "carros/marcas";
                break;
            case "moto", "motos", "2":
                endereco = URL_BASE + "motos/marcas";
                break;
            case "caminhao", "caminhões", "3":
                endereco = URL_BASE + "caminhoes/marcas";
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                return;
        }

        //Conferência se os dados foram recebidos
        var json = consumo.obterDados(endereco);
        if (json != null) {
            System.out.println("Dados recebidos");
        } else {
            System.out.println("Erro ao obter os dados.");
        }
        //Escolher marca
        var marcas = conversor.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::nome))
                .forEach(System.out::println);
        var menu_marca = """
                *** MARCAS ***
                Escolha o código da marca para consulta
                """;
        System.out.println(menu_marca);
        var codigo_marca = leitura.nextLine();
        endereco = endereco + "/" + codigo_marca + "/modelos";
        json = consumo.obterDados(endereco);

        //Escolher modelo
        var modelo = conversor.obterDados(json, Modelos.class);
        modelo.modelos().stream()
                .sorted(Comparator.comparing(Dados::nome))
                .forEach(System.out::println);

        var menu_modelo = """
                *** MODELO DO VEÍCULO ***
                Digite um trecho do nome do carro a ser buscado:
                """;
        System.out.println(menu_modelo);
        var nome_veiculo = leitura.nextLine();
        List<Dados> modelosFiltrados = modelo.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nome_veiculo.toLowerCase()))
                .collect(Collectors.toList());
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite o código do modelo: ");
        var codigo_modelo = leitura.nextLine();
        endereco = endereco + "/" + codigo_modelo + "/anos";
        json = consumo.obterDados(endereco);

        //Escolher ano
        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();
        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados (json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veiculos filtrados com avaliações por ano: "); veiculos.forEach(System.out::println);


    }
}
