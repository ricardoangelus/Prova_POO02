import java.util.*;

public class Main {
    public static void main(String[] args) {

        long tempoInicial = System.currentTimeMillis();

        List<Integer> v = new ArrayList<>();
        int[] v2 = {10000};
        int[] v3 = {100000};
        int[] v4 = {1000000};
        int[] v5 = {5000000};
        int[] v6 = {10000000};

//******************************************************************************************************************************************//
        // Processo de Desordenação do Vetor
        //long start2 = System.nanoTime();
        for (int i = 0; i <= 1000; i++) {
            v.add(i);
            Collections.shuffle(v);
        }


        //System.out.println("Vetores Desordenados: " + v); // Impressão dos números embaralhados

        //long end2 = System.nanoTime();
        //long resultado2 = end2 - start2;

        // 1 segundo é igual a 1_000_000_000
        //double cpu_time_used2 = (double)(resultado2) / 1e+9;
        //System.out.println("Quantidade de Itens: " + (v.toArray().length - 1) + " -----> Tempo de uso da CPU: " + cpu_time_used2 + " segundos\n");
        //System.out.println("O tamanho do vetor é: " + v.toArray().length); //Verificação do tamanho do vetor

        //System.out.println(v.get(2)); //Impressão da posíção do item no vetor
//**************************************************************************************************************//
        System.out.println("######## Ordenação: Inserção Direta ########");
        long tempoInicial2 = System.currentTimeMillis();

        int j;
        int key;
        int i;
        System.out.println("Vetores Desordenados: " + v);
        for (j = 1; j < v.toArray().length; j++)
        {
            key = v.get(j);
            for (i = j - 1; (i >= 0) && (v.get(i) > key); i--)
            {
                v.set(i + 1, v.get(i));
            }
            v.set(i + 1, key);
            }

        System.out.println("Vetores Ordenados: " + v);
        long tempoFinal2 = System.currentTimeMillis();


        System.out.println("Quantidade de Itens: " + (v.toArray().length - 1) + " -----> Tempo de uso da CPU: " + (tempoFinal2 - tempoInicial2) + " ms\n");
//
//
////****************************************************************************************************************
        System.out.println("######## Ordenação: Bubble Sort ########");
        long tempoInicial3 = System.currentTimeMillis();

        System.out.println("Vetores Desordenados: " + v);
        boolean troca = true;
        int aux;
        while (troca) {
            troca = false;
            for (i = 0; i < v.toArray().length - 1; i++) {
                if (v.get(i) > v.get(i + 1)) {
                    aux = v.get(i);
                    v.set(i, v.get(i + 1));
                    v.set(i + 1, aux);
                    troca = true;
                }
            }
        }
        System.out.println("Vetores Ordenados: " + v);
        long tempoFinal3 = System.currentTimeMillis();


        System.out.println("Quantidade de Itens: " + (v.toArray().length - 1) + " -----> Tempo de uso da CPU: " + (tempoFinal3 - tempoInicial3) + " ms\n");
//*************************************************************************************************************************************************//

        System.out.println("######## Ordenação: Shake Sort ########");
        long tempoInicial5 = System.currentTimeMillis();

        System.out.println("Vetores Desordenados: " + v);
        {
            int k,l,r,tam = v.toArray().length;

            l=1;
            r= k=tam-1;
            do {
                for (j=r; j>=l; j--)
                    if (v.get(j - 1) > v.get(j)) {
                        aux= v.get(j - 1);
                        v.set(j - 1, v.get(j));
                        v.set(j, aux);
                        k=j;
                    }
                l= k+1;

                for (j=l; j<=r; j++)
                    if (v.get(j - 1) > v.get(j))
                    {
                        aux= v.get(j - 1);
                        v.set(j - 1, v.get(j));
                        v.set(j, aux);
                        k=j;
                    }

                r=k-1;

            } while (l<=r);

        }
        System.out.println("Vetores Ordenados: " + v);
        long tempoFinal5 = System.currentTimeMillis();


        System.out.println("Quantidade de Itens: " + (v.toArray().length - 1) + " -----> Tempo de uso da CPU: " + (tempoFinal5 - tempoInicial5) + " ms\n");
//*************************************************************************************************************************************************//

        System.out.println("######## Ordenação: Seleção Direta ########");
        long tempoInicial4 = System.currentTimeMillis();

        System.out.println("Vetores Desordenados: " + v);
        for (int fixo = 0; fixo < v.toArray().length - 1; fixo++) {
            int menor = fixo;

            for (i = menor + 1; i < v.toArray().length; i++) {
                if (v.get(i) < v.get(menor)) {
                    menor = i;
                }
            }
            if (menor != fixo) {
                int t = v.get(fixo);
                v.set(fixo, v.get(menor));
                v.set(menor, t);
            }
        }
        System.out.println("Vetores Ordenados: " + v);
        long tempoFinal4 = System.currentTimeMillis();


        System.out.println("Quantidade de Itens: " + (v.toArray().length - 1) + " -----> Tempo de uso da CPU: " + (tempoFinal4 - tempoInicial4) + " ms\n");
//*************************************************************************************************************************************************//

        System.out.println("######## Tempo Total de Uso da CPU ########");

        long tempoFinal = System.currentTimeMillis();

        System.out.println("\nTempo Total de uso da CPU: " + (tempoFinal - tempoInicial) + " ms");


        }
    }

