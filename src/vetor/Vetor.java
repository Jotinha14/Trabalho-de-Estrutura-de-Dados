package vetor;

public class Vetor {
    private int[] elementos;
    private int tamanho;
    private int capacidade;
    
    public Vetor(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }
    
    // INSERÇÃO
    public void inserir(int elemento) {
        if (tamanho == capacidade) {
            redimensionar();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }
    
    // BUSCA SEQUENCIAL - O(n)
    public boolean buscaSequencial(int elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == elemento) {
                return true;
            }
        }
        return false;
    }
    
    // BUSCA BINÁRIA - O(log n)
    public boolean buscaBinaria(int elemento) {
        int esquerda = 0;
        int direita = tamanho - 1;
        
        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            
            if (elementos[meio] == elemento) {
                return true;
            } else if (elementos[meio] < elemento) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return false;
    }
    
    // ORDENAR USANDO QUICKSORT (simplificado - não depende da classe)
    public void ordenarParaBusca() {
        quicksort(elementos, 0, tamanho - 1);
    }
    
    // QUICKSORT IMPLEMENTADO DIRETO AQUI
    private void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = particionar(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }
    
    private int particionar(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    private void redimensionar() {
        capacidade *= 2;
        int[] novoArray = new int[capacidade];
        System.arraycopy(elementos, 0, novoArray, 0, tamanho);
        elementos = novoArray;
    }
    
    // GETTERS
    public int[] getElementos() { return elementos; }
    public int getTamanho() { return tamanho; }
    public void setElementos(int[] elementos) { 
        this.elementos = elementos; 
        this.tamanho = elementos.length;
    }
}