# 📊 Análise de Desempenho de Estruturas de Dados em Java

## 📖 Descrição
Projeto acadêmico desenvolvido para a disciplina de Estrutura de Dados que realiza uma análise comparativa do desempenho de diferentes estruturas de dados (Vetores, Árvores Binárias de Busca e Árvores AVL) em operações de inserção, busca e ordenação.

## 🎯 Objetivos
- Implementar estruturas de dados do zero
- Comparar desempenho prático vs complexidade teórica
- Analisar impacto da ordem de inserção no desempenho
- Testar algoritmos de ordenação com diferentes características

## 🏗️ Estrutura do Projeto
Trabalho De Estrtura De Dados/
├── src/
│   ├── vetor/
│   │   ├── Vetor.java              # Vetor + buscas (sequencial e binária)
│   │   ├── BubbleSort.java         # Ordenação
│   │   └── QuickSort.java          # Ordenação
│   ├── arvores/
│   │   ├── ArvoreBinaria.java      # ABB + busca
│   │   ├── ArvoreAVL.java          # AVL + busca
│   │   └── No.java                 # Nó para ambas árvores
│   ├── utils/
│   │   └── GeradorDados.java       # Gerador de datasets
│   └── testes/
│       └── AnaliseDesempenho.java  # Sistema principal + cronômetro
└──

## 🚀 Como Executar

### 1. Clonar e Preparar
```bash
# Clone o repositório (ou baixe o ZIP)
git clone https://github.com/Jotinha14/Trabalho-de-Estrutura-de-Dados.git
cd Trabalho de Estrutura de Dados

 ## 📊 Metodologia de Testes

Conjuntos de Dados
Tamanhos: 100, 1.000 e 10.000 elementos
Ordens de Inserção:
Ordenada (1, 2, 3, ...)
Inversamente Ordenada (n, n-1, n-2, ...)
Aleatória

Operações Testadas
Inserção: Tempo para inserir todos elementos
Busca: 7 elementos por estrutura:
Primeiro elemento
Último elemento
Elemento do meio
3 elementos aleatórios existentes
1 elemento inexistente
Ordenação: Apenas para vetores:
Bubble Sort
Quick Sort

Métricas
Cada teste executado 5 vezes
Tempo médio calculado em milissegundos (ms)
Complexidade teórica vs desempenho prático

## 🔍 Estruturas Implementadas
1. Vetor (vetor/Vetor.java)
Inserção: O(1) amortizado
Busca Sequencial: O(n)
Busca Binária: O(log n) - requer ordenação
Ordenação: Implementa Quick Sort internamente

2. Árvore Binária de Busca (arvores/ArvoreBinaria.java)
Inserção: O(n) pior caso, O(log n) caso médio
Busca: O(n) pior caso, O(log n) caso médio
Característica: Degenera com dados ordenados

3. Árvore AVL (arvores/ArvoreAVL.java)
Inserção: O(log n) garantido
Busca: O(log n) garantido
Característica: Auto-balanceamento com rotações

## 🧪 Algoritmos de Ordenação
Bubble Sort (vetor/BubbleSort.java)
Complexidade: O(n²)
Estável: Sim
In-place: Sim
Melhor para: n ≤ 100
Quick Sort (vetor/QuickSort.java)
Complexidade: O(n log n) caso médio, O(n²) pior caso
Estável: Não
In-place: Sim
Melhor para: n > 100

## 📈 RESULTADOS ESPERADOS

📊 Comportamento Teórico das Estruturas

Estrutura	     Inserção (Pior Caso)	     Busca (Pior Caso)	   Impacto da Ordem de Inserção
Vetor	             O(1)amortizado	          O(n)	                 Não impacta
ÁrvoreBinária(ABB)	 O(n)	                  O(n)	                SIM - Degenera com dados ordenados
ÁrvoreAVL	         O(log n)	              O(log n)	            NÃO - Mantém balanceamento

🔄 Comparação de Algoritmos de Ordenação

Tempos Esperados (em milissegundos)
Algoritmo	100 elementos	1.000 elementos	  10.000 elementos
BubbleSort	  ~0.1 ms	        ~1.5 ms	        ~22 ms
QuickSort	  ~0.1 ms	        ~0.6 ms	        ~0.6 ms

📈 Crescimento da Complexidade
Algoritmo	    Complexidade	 Crescimento	     Recomendação
BubbleSort	      O(n²)	          Quadrático	       n ≤ 100
QuickSort	      O(n log n)	  Quase linear	       n > 100
DadosOrdenados	  O(n)	          Linear	           Evitar
AVL	              O(log n)	      Logarítmico	       Sempre bom

🎯 Resumo Visual
Crescimento de Tempo:
               ▲
               │              Bubble Sort (O(n²))
               │            /
Tempo          │          /
               │        /
               │      /  Quick Sort (O(n log n))
               │    /    /
               │  /    /   AVL (O(log n))
               │/    /
               └─────────────────►
                       Tamanho (n)

💡 Explicação dos Resultados
Vetor:
Vantagem: Inserção extremamente rápida
Desvantagem: Busca lenta em dados não ordenados
Melhor uso: Quando há muitas inserções e poucas buscas

Árvore Binária (ABB):
Problema: Degenera para lista com dados ordenados
Solução: Usar apenas com dados aleatórios
Complexidade: O(n) no pior caso, O(log n) no caso médio

Árvore AVL:
Vantagem: Performance garantida O(log n)
Custo: Overhead das rotações
Ideal: Quando performance consistente é crítica

Ordenação:
Bubble Sort: Simples mas ineficiente para n grande
Quick Sort: Eficiente na maioria dos casos

## 💡 Análises e Conclusões

Insights Obtidos
AVL mantém desempenho consistente independente da ordem
ABB sofre degradação significativa com dados ordenados
Vetores são excelentes para inserção, ruins para busca não ordenada
Quick Sort é drasticamente mais eficiente que Bubble Sort para n grande

Casos de Uso Recomendados
Vetor: Aplicações com muitas inserções e poucas buscas
ABB: Quando os dados chegam em ordem aleatória
AVL: Sistemas que exigem performance garantida
Quick Sort: Ordenação geral de grandes conjuntos de dados



## 👥 Autor
Nome - João Vitor Façanha Neves

Disciplina: Estrutura de Dados

Professor: Flavio 

Instituição: Faminas

Ano: 2025