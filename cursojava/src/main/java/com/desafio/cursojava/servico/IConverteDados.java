package com.desafio.cursojava.servico;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
