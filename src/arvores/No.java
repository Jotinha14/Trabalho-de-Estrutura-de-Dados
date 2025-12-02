package arvores;

public class No {
    public int valor;
    public int altura; // Para AVL
    public No esquerda;
    public No direita;
    
    public No(int valor) {
        this.valor = valor;
        this.altura = 1; // Para AVL
        this.esquerda = null;
        this.direita = null;
    }
}