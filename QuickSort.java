public class QuickSort {

    //Pivo no Meio
    public static int particaoNoMeio(int[] vetor, int esquerda, int direita) {
        int meio = (int) (esquerda + direita) / 2; // Pega o index do meio do vetor
        int pivo = vetor[meio]; // Pega o valor que esta nesse indice para ser o pivo
        int i = esquerda - 1; // Posição do ponteiro inicial
        int j = direita + 1; // Posição do ponteiro final

        while (true) {
            do {
                i++;
            } while (vetor[i] < pivo); // Quando o vetor na posição i for maior que o pivo ele trava

            do {
                j--;
            } while (vetor[j] > pivo); // Quando o vetor na posição j for menor que o pivo ele trava

            if (i >= j) { // Se for verdadeiro quer dizer que ja foram separados os valores maiores e menores que o pivo
                return j; // Posição do pivo atual
            }

            int aux = vetor[i]; // Aqui faz a troca dos elementos que foram travados
            vetor[i] = vetor[j];
            vetor[j] = aux;

            // Imprimir o vetor em cada troca
            System.out.print("Passo a Passo:  ");
            imprimirVetor(vetor);
        }
    }

    //Pivo no Inicio
    public static int particaoNoInicio(int[] vetor, int esquerda, int direita) {
        int pivo = vetor[esquerda];
        int i = esquerda + 1;
        int j = direita;

        while (true) {
            while (i <= j && vetor[i] <= pivo) { 
                i++;
            }

            while (i <= j && vetor[j] >= pivo) {
                j--;
            }

            if (i > j) {
                break;
            }

            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }

        int aux = vetor[esquerda];
        vetor[esquerda] = vetor[j];
        vetor[j] = aux;

        // Imprimir o vetor em cada troca
        System.out.print("Passo a Passo:  ");
        imprimirVetor(vetor);

        return j;
    }
    
    //Pivo no Fim
    public static int particaoNoFim(int[] vetor, int esquerda, int direita) {
        int pivo = vetor[direita];
        int i = esquerda;
        int j = direita - 1;

        while (true) {
            while (i <= j && vetor[i] <= pivo) {
                i++;
            }

            while (i <= j && vetor[j] >= pivo) {
                j--;
            }

            if (i > j) {
                break;
            }

            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }

        int aux = vetor[direita];
        vetor[direita] = vetor[i];
        vetor[i] = aux;

        // Imprimir o vetor em cada troca
        System.out.print("Passo a Passo:  ");
        imprimirVetor(vetor);

        return i;
    }

    public static void quickSort(int[] vetor, int esquerda, int direita) {// Procesimento recursivo

        if (esquerda < direita) {  /*Se o valor da esqueda do subArray for menor que o valor do subArray a direta
                                  é porque ainda precisa ordenar o subArray verifica se há mais de um elemento
                                  no subarray que está sendo considerado. Se a condição for verdadeira,
                                  significa que ainda há elementos a serem ordenados.*/
            int pivo = particaoNoInicio(vetor, esquerda, direita); // Acontece até que o da esquerda seja maior que o da direita
            quickSort(vetor, esquerda, pivo); // Ordenar a esquerda do pivo
            quickSort(vetor, pivo + 1, direita);// Ordenar a direita do pivo
        }
    }

    public static void imprimirVetor(int[] vetor) {
        System.out.print("{");
        for (int i = 0; i < vetor.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(vetor[i]);
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        int[] vetor = {9, 25, 10, 18, 5, 7, 15, 3};

        System.out.print("Vetor original: ");
        imprimirVetor(vetor);

        quickSort(vetor, 0, vetor.length - 1);

        System.out.print("Vetor ordenado: ");
        imprimirVetor(vetor);
    }
}