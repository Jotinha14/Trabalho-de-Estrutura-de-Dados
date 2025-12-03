package testes;

import vetor.*;
import arvores.*;
import utils.GeradorDados;
import java.util.*;

public class AnaliseDesempenho {
    // CONFIGURAÇÕES
    private static final int[] TAMANHOS = {100, 1000, 10000};
    private static final int EXECUCOES = 5;
    
    // Estruturas
    private static Vetor vetor;
    private static ArvoreBinaria abb;
    private static ArvoreAVL avl;
    
    // Algoritmos de ordenação
    private static BubbleSort bubbleSort;
    private static QuickSort quickSort;
    
    // Resultados
    private static Map<String, Double> temposInsercao;
    private static Map<String, Double> temposBusca;
    private static Map<String, Double> temposOrdenacao;
    
    // CRONÔMETRO
    public static class Cronometro {
        public static double medirTempo(Runnable operacao) {
            long tempoTotal = 0;
            
            for (int i = 0; i < EXECUCOES; i++) {
                long inicio = System.nanoTime();
                operacao.run();
                long fim = System.nanoTime();
                tempoTotal += (fim - inicio);
            }
            
            return (tempoTotal / EXECUCOES) / 1_000_000.0; // Média em ms
        }
    }
    
    public static void main(String[] args) {
        System.out.println("INICIANDO ANALISE DE DESEMPENHO");
        System.out.println("================================");
        
        inicializar();
        executarTestesCompletos();
        gerarRelatorio();
    }
    
    private static void inicializar() {
        bubbleSort = new BubbleSort();
        quickSort = new QuickSort();
        
        temposInsercao = new HashMap<>();
        temposBusca = new HashMap<>();
        temposOrdenacao = new HashMap<>();
    }
    
    private static void executarTestesCompletos() {
        for (int tamanho : TAMANHOS) {
            System.out.println("\nANALISANDO: " + tamanho + " elementos");
            System.out.println("----------------------------------------");
            
            int[] ordenados = GeradorDados.gerarOrdenado(tamanho);
            int[] inversos = GeradorDados.gerarInverso(tamanho);
            int[] aleatorios = GeradorDados.gerarAleatorio(tamanho);
            
            testarOrdem("ORDENADA", ordenados, tamanho);
            testarOrdem("INVERSA", inversos, tamanho);
            testarOrdem("ALEATORIA", aleatorios, tamanho);
        }
    }
    
    private static void testarOrdem(String ordem, int[] dados, int tamanho) {
        System.out.println("\n   ORDEM: " + ordem);
        
        // INSERÇÃO
        System.out.println("   Insercao...");
        double tempoVetor = Cronometro.medirTempo(() -> {
            vetor = new Vetor(tamanho * 2);
            for (int valor : dados) vetor.inserir(valor);
        });
        
        double tempoABB = Cronometro.medirTempo(() -> {
            abb = new ArvoreBinaria();
            for (int valor : dados) abb.inserir(valor);
        });
        
        double tempoAVL = Cronometro.medirTempo(() -> {
            avl = new ArvoreAVL();
            for (int valor : dados) avl.inserir(valor);
        });
        
        String chave = tamanho + "_" + ordem;
        temposInsercao.put(chave + "_VETOR", tempoVetor);
        temposInsercao.put(chave + "_ABB", tempoABB);
        temposInsercao.put(chave + "_AVL", tempoAVL);
        
        System.out.printf("      Vetor: %.3fms | ABB: %.3fms | AVL: %.3fms%n", 
                         tempoVetor, tempoABB, tempoAVL);
        
        // BUSCA
        System.out.println("   Busca...");
        testarBuscas(dados, tamanho, ordem);
        
        // ORDENAÇÃO
        System.out.println("   Ordenacao...");
        testarOrdenacao(dados, tamanho, ordem);
    }
    
    private static void testarBuscas(int[] dados, int tamanho, String ordem) {
        popularEstruturas(dados);
        
        int[] elementos = {
            GeradorDados.getPrimeiroElemento(dados),
            GeradorDados.getUltimoElemento(dados),
            GeradorDados.getElementoMeio(dados),
            GeradorDados.getElementoAleatorio(dados),
            GeradorDados.getElementoAleatorio(dados),
            GeradorDados.getElementoAleatorio(dados),
            GeradorDados.getElementoInexistente(dados)
        };
        
        for (int i = 0; i < elementos.length; i++) {
            int elemento = elementos[i];
            
            double tempoVetor = Cronometro.medirTempo(() -> vetor.buscaSequencial(elemento));
            double tempoABB = Cronometro.medirTempo(() -> abb.buscar(elemento));
            double tempoAVL = Cronometro.medirTempo(() -> avl.buscar(elemento));
            
            String chave = tamanho + "_" + ordem + "_" + i;
            temposBusca.put(chave + "_VETOR", tempoVetor);
            temposBusca.put(chave + "_ABB", tempoABB);
            temposBusca.put(chave + "_AVL", tempoAVL);
        }
        
        System.out.println("      7 elementos testados");
    }
    
    private static void testarOrdenacao(int[] dados, int tamanho, String ordem) {
        double tempoBubble = Cronometro.medirTempo(() -> {
            int[] copia = GeradorDados.copiarArray(dados);
            bubbleSort.ordenar(copia);
        });
        
        double tempoQuick = Cronometro.medirTempo(() -> {
            int[] copia = GeradorDados.copiarArray(dados);
            quickSort.ordenar(copia);
        });
        
        String chave = tamanho + "_" + ordem;
        temposOrdenacao.put(chave + "_BUBBLE", tempoBubble);
        temposOrdenacao.put(chave + "_QUICK", tempoQuick);
        
        System.out.printf("      Bubble: %.3fms | Quick: %.3fms%n", tempoBubble, tempoQuick);
    }
    
    private static void popularEstruturas(int[] dados) {
        vetor = new Vetor(dados.length * 2);
        abb = new ArvoreBinaria();
        avl = new ArvoreAVL();
        
        for (int valor : dados) {
            vetor.inserir(valor);
            abb.inserir(valor);
            avl.inserir(valor);
        }
    }
    
    private static void gerarRelatorio() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("RELATORIO FINAL");
        System.out.println("=".repeat(60));
        
        // Tabelas (mantenha as que já tinha)
        exibirTabelaInsercao();
        exibirTabelaOrdenacao();
        
        System.out.println("\nANALISE:");
        System.out.println("- Vetor: Insercao O(1), Busca O(n)");
        System.out.println("- ABB: Insercao/Busca O(n) pior caso, O(log n) medio");
        System.out.println("- AVL: Insercao/Busca O(log n) garantido");
        System.out.println("- Bubble Sort: O(n^2)");
        System.out.println("- Quick Sort: O(n log n)");
    }
    
    private static void exibirTabelaInsercao() {
        System.out.println("\nINSERCAO (ms):");
        System.out.println("Tamanho | Ordem     | Vetor   | ABB     | AVL     ");
        System.out.println("--------|-----------|---------|---------|---------");
        
        for (int tamanho : TAMANHOS) {
            for (String ordem : new String[]{"ORDENADA", "INVERSA", "ALEATORIA"}) {
                String chave = tamanho + "_" + ordem;
                double vetor = temposInsercao.get(chave + "_VETOR");
                double abb = temposInsercao.get(chave + "_ABB");
                double avl = temposInsercao.get(chave + "_AVL");
                
                System.out.printf("%7d | %-9s | %7.3f | %7.3f | %7.3f%n", 
                                tamanho, ordem, vetor, abb, avl);
            }
        }
    }
    
    private static void exibirTabelaOrdenacao() {
        System.out.println("\nORDENACAO (ms):");
        System.out.println("Tamanho | Ordem     | Bubble  | Quick   ");
        System.out.println("--------|-----------|---------|---------");
        
        for (int tamanho : TAMANHOS) {
            for (String ordem : new String[]{"ORDENADA", "INVERSA", "ALEATORIA"}) {
                String chave = tamanho + "_" + ordem;
                double bubble = temposOrdenacao.get(chave + "_BUBBLE");
                double quick = temposOrdenacao.get(chave + "_QUICK");
                
                System.out.printf("%7d | %-9s | %7.3f | %7.3f%n", 
                                tamanho, ordem, bubble, quick);
            }
        }
    }
}