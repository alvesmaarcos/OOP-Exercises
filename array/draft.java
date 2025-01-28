import java.util.ArrayList;
import java.util.Collections;

public class draft {
    public static void main(String args[]){
        // Criar um array vazio
        ArrayList<Integer> vazio = new ArrayList<>();


        // Criar um array preenchido
        ArrayList<Integer> preenchido = new ArrayList<>();
        preenchido.add(1);
        preenchido.add(2);
        preenchido.add(3);


        // Adicionar e remover elementos ao final
        preenchido.add(4);
        preenchido.remove(preenchido.size() - 1);


        // Fazer impressão formatada
        System.out.println(preenchido);


        // Criar um array com elementos em sequência de zero a n
        ArrayList<Integer> sequencial = new ArrayList<>();
        for (int i = 0; i < sequencial.size(); i++) {
            sequencial.add(i);
        }


        // Criar um array com valores aleatórios
        ArrayList<Integer> aleatorio = new ArrayList<>();
        aleatorio.add(5);
        aleatorio.add(2);
        aleatorio.add(8);


        // Acessar elementos por índice
        int element = sequencial.get(0);


        // Percorrer os elementos utilizando for-range
        for (int num : sequencial) {
            System.out.println(num);
        }


        // Percorrer os elementos utilizando for indexado
        for (int i = 0; i < sequencial.size(); i++) {
            System.out.println(sequencial.get(i));
        }


        // Procurar um elemento X usando laço
        int x = 5;
        boolean found = false;
        for (int i=0; i <sequencial.size(); i++) {
            if (i == x) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Element " + x + " found");
        } else {
            System.out.println("Element " + x + " not found");
        }


        // Criar um novo array com elementos filtrados, por exemplo, pares
        ArrayList<Integer> pares = new ArrayList<>();
        for (int num : sequencial) {
            if (num % 2 == 0) {
                pares.add(num);
            }
        }


        // Criar um novo array com elementos transformados, por exemplo, ao quadrado
        ArrayList<Integer> aoQuadrado = new ArrayList<>();
        for (int num : sequencial) {
            aoQuadrado.add(num * num);
        }


        // Buscar e remover um elemento X
        int elementToRemove = 3;
        preenchido.removeIf(num -> num == elementToRemove);


        // Remover todos os elementos X
        int elementToRemoveAll = 2;
        preenchido.removeAll(Collections.singleton(elementToRemoveAll));


        // Verificar quais funções existem nativamente na linguagem
        // busca: contains, indexOf, lastIndexOf
        // remoção: remove, removeIf, removeAll
        // ordenação: sort, Collections.sort
        // embaralhamento: Collections.shuffle

    }
}

