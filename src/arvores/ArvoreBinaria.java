package arvores;

public class ArvoreBinaria {
    private No raiz;
    private int operacoes;
    
    // INSERÇÃO - O(h)
    public void inserir(int valor) {
        operacoes = 0;
        raiz = inserirRecursivo(raiz, valor);
    }
    
    private No inserirRecursivo(No no, int valor) {
        operacoes++;
        if (no == null) {
            return new No(valor);
        }
        
        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        }
        
        return no;
    }
    
    // BUSCA - O(h)
    public boolean buscar(int valor) {
        operacoes = 0;
        return buscarRecursivo(raiz, valor);
    }
    
    private boolean buscarRecursivo(No no, int valor) {
        operacoes++;
        if (no == null) return false;
        if (no.valor == valor) return true;
        
        if (valor < no.valor) {
            return buscarRecursivo(no.esquerda, valor);
        } else {
            return buscarRecursivo(no.direita, valor);
        }
    }
    
    public int getOperacoes() { return operacoes; }
    public void limpar() { raiz = null; }
}