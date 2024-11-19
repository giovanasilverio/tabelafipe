package com.desafio.cursojava.principal;

import com.desafio.cursojava.servico.ConsumoAPI;

import java.util.Scanner;

public class Main {
    private final Scanner leitura = new Scanner(System.in);
    private final ConsumoAPI consumo = new ConsumoAPI();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

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
        String endereco_tipo;

        switch (tipos.toLowerCase()) {
            case "carro", "carros", "1":
                endereco_tipo = URL_BASE + "carros/marcas";
                break;
            case "moto", "motos", "2":
                endereco_tipo = URL_BASE + "motos/marcas";
                break;
            case "caminhao", "caminhões", "3":
                endereco_tipo = URL_BASE + "caminhoes/marcas";
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                return;
        }

        var json = consumo.obterDados(endereco_tipo);
        if (json != null) {
            System.out.println("Dados recebidos:\n" + json);
        } else {
            System.out.println("Erro ao obter os dados.");
        }

        var menu_modelo = """
                *** MARCAS ***
                Escolha o código da marca para consulta
                """;
        System.out.println(menu_modelo);
        var codigo_modelo = leitura.nextLine();
        String endereco_modelo;

        endereco_modelo = endereco_tipo + "/" + codigo_modelo + "/modelos";
        var json1 = consumo.obterDados(endereco_modelo);
        System.out.println(json1);

        var menu_carro = """
                *** MODELO DO VEÍCULO ***
                Escolha o código do carro para consulta
                """;
        System.out.println(menu_carro);
        var codigo_carro = leitura.nextLine();
        String endereco_carro;

        endereco_carro = endereco_modelo + "/" + codigo_carro + "/anos";
        var json2 = consumo.obterDados(endereco_carro);
        System.out.println(json2);

        var menu_ano = """
                *** ANO DO VEÍCULO ***
                Escolha o ano do veículo para consulta
                """;
        System.out.println(menu_ano);
        var codigo_ano = leitura.nextLine();
        String endereco_ano;

        endereco_ano = endereco_carro + "/" + codigo_ano + "-1";
        var json3 = consumo.obterDados(endereco_ano);
        System.out.println(json3);

    }
}
