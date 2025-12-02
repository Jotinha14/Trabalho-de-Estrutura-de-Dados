package vetor;

public class QuickSort {
    private long operacoes;
    
    public void ordenar(int[] arr) {
        operacoes = 0;
        quickSort(arr, 0, arr.length - 1);
    }
    
    private void quickSort(int[] arr, int low, int high) {
        operacoes++;
        if (low < high) {
            int pi = particionar(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private int particionar(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            operacoes++;
            if (arr[j] <= pivot) {
                i++;
                // Troca arr[i] e arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                operacoes += 3;
            }
        }
        
        // Troca arr[i+1] e arr[high] (pivô)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        operacoes += 3;
        
        return i + 1;
    }
    
    public long getOperacoes() { return operacoes; }
}