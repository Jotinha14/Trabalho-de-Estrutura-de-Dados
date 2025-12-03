# 📊 Análise de Desempenho de Estruturas de Dados em Java

## 📖 Descrição
Projeto acadêmico desenvolvido para a disciplina de Estrutura de Dados que realiza uma análise comparativa do desempenho de diferentes estruturas de dados (Vetores, Árvores Binárias de Busca e Árvores AVL) em operações de inserção, busca e ordenação.

## 🎯 Objetivos
- Implementar estruturas de dados do zero
- Comparar desempenho prático vs complexidade teórica
- Analisar impacto da ordem de inserção no desempenho
- Testar algoritmos de ordenação com diferentes características

## 🏗️ Estrutura do Projeto
TrabalhoEDD/
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