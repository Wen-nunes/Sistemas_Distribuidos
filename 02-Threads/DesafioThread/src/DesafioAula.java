import java.util.ArrayList;
import java.util.Random;

    //Implemente:
    //PupularLista(lista1, 10000)
    //popularLista(lista2, 3000)

    //ondenarBolha (Lista2)
    //ordenarPente(lista1

    class PopulaLista1 extends Thread {
        private ArrayList<Integer> lista;
        private int tamanho;

        public PopulaLista1(ArrayList<Integer> lista, int tamanho) {
            this.lista = lista;
            this.tamanho = tamanho;
        }

        public void run() {
            Random gerador = new Random();
            System.out.println("Iniciando populacao da Lista1");
            for (int i = 0; i < tamanho; i++) {
                lista.add(gerador.nextInt(100000));
            }
            System.out.println("Lista1 populada!");
        }
    }

    class PopulaLista2 extends Thread {
        private ArrayList<Integer> lista;
        private int tamanho;

        public PopulaLista2(ArrayList<Integer> lista, int tamanho) {
            this.lista = lista;
            this.tamanho = tamanho;
        }

        public void run() {
            Random gerador = new Random();
            System.out.println("Iniciando populacao da Lista2");
            for (int i = 0; i < tamanho; i++) {
                lista.add(gerador.nextInt(100000));
            }
            System.out.println("Lista2 populada!");
        }
    }

    class OrdenaListaB extends Thread {
        private ArrayList<Integer> lista;

        public OrdenaListaB(ArrayList<Integer> lista) {
            this.lista = lista;
        }

        public void run() {
            System.out.println("Iniciando ordenacao da Lista2 pelo Bolha");
            int n = lista.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (lista.get(j) > lista.get(j + 1)) {
                        int temp = lista.get(j);
                        lista.set(j, lista.get(j + 1));
                        lista.set(j + 1, temp);
                    }
                }
            }
            System.out.println("metodo bolha finalizado!");
        }
    }

    class OrdenaListaP extends Thread {
        private ArrayList<Integer> lista;

        public OrdenaListaP(ArrayList<Integer> lista) {
            this.lista = lista;
        }

        public void run() {
            System.out.println("Iniciando ordenacao da Lista1 pelo Metodo Pente");
            int n = lista.size();
            int gap = n;
            boolean swapped = true;
            while (gap != 1 || swapped) {
                gap = getNextGap(gap);
                swapped = false;
                for (int i = 0; i < n - gap; i++) {
                    if (lista.get(i) > lista.get(i + gap)) {
                        int temp = lista.get(i);
                        lista.set(i, lista.get(i + gap));
                        lista.set(i + gap, temp);
                        swapped = true;
                    }
                }
            }
            System.out.println("metodo pente finalizado!");
        }

        private int getNextGap(int gap) {
            gap = (gap * 10) / 13;
            if (gap < 1) {
                return 1;
            }
            return gap;
        }
    }
public class DesafioAula {
    public static void main(String[] args) throws InterruptedException {
            ArrayList<Integer> lista1 = new ArrayList<>();
            ArrayList<Integer> lista2 = new ArrayList<>();

            PopulaLista1 t1 = new PopulaLista1(lista1, 10000);
            PopulaLista2 t2 = new PopulaLista2(lista2, 3000);
            t1.start();
            t2.start();

            t1.join();
            t2.join();
            System.out.println("Populacao finalizada.");
            System.out.println("\nOrdenando as listas");

        OrdenaListaB t3 = new OrdenaListaB(lista2);
        OrdenaListaP t4 = new OrdenaListaP(lista1);
            t3.start();
            t4.start();

            t3.join();
            t4.join();
            System.out.println("\nAmbas as listas foram ordenadas.");

        }


}
