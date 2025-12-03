package arvores;

public class ArvoreAVL {
    private No raiz;
    private int operacoes;
    
    // INSERÇÃO COM BALANCEAMENTO - O(log n)
    public void inserir(int valor) {
        operacoes = 0;
        raiz = inserirRecursivo(raiz, valor);
    }
    
    private No inserirRecursivo(No no, int valor) {
        operacoes++;
        if (no == null) return new No(valor);
        
        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        } else {
            return no; // Valores duplicados não permitidos
        }
        
        // Atualizar altura e balancear
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        return balancear(no);
    }
    
    private No balancear(No no) {
        int balanceamento = getBalanceamento(no);
        
        // Rotações AVL
        if (balanceamento > 1 && getBalanceamento(no.esquerda) >= 0) {
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && getBalanceamento(no.direita) <= 0) {
            return rotacaoEsquerda(no);
        }
        if (balanceamento > 1 && getBalanceamento(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && getBalanceamento(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }
        
        return no;
    }
    
    // ROTAÇÕES
    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;
        
        x.direita = y;
        y.esquerda = T2;
        
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        
        return x;
    }
    
    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;
        
        y.esquerda = x;
        x.direita = T2;
        
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        
        return y;
    }
    
    // BUSCA - O(log n)
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
    
    // MÉTODOS AUXILIARES
    private int altura(No no) {
        return no == null ? 0 : no.altura;
    }
    
    private int getBalanceamento(No no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }
    
    public int getOperacoes() { return operacoes; }
    public void limpar() { raiz = null; }
}