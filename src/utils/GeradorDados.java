package utils;

import java.util.Random;
import java.util.Arrays;

public class GeradorDados {
    private static Random random = new Random();
    
    public static int[] gerarOrdenado(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = i + 1;
        }
        return dados;
    }
    
    public static int[] gerarInverso(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = tamanho - i;
        }
        return dados;
    }
    
    public static int[] gerarAleatorio(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = random.nextInt(tamanho * 10) + 1;
        }
        return dados;
    }
    
    public static int[] copiarArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }
    
    public static int getPrimeiroElemento(int[] dados) {
        return dados[0];
    }
    
    public static int getUltimoElemento(int[] dados) {
        return dados[dados.length - 1];
    }
    
    public static int getElementoMeio(int[] dados) {
        return dados[dados.length / 2];
    }
    
    public static int getElementoAleatorio(int[] dados) {
        return dados[random.nextInt(dados.length)];
    }
    
    public static int getElementoInexistente(int[] dados) {
        return -1;
    }
}