package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.DoubleAdder;

class PopulaLista implements Runnable {
    private final List<Integer> lista;
    private final int tamanho;
    private final int min;
    private final int max;
    private final DoubleAdder totalSoma;
    private final DoubleAdder totalQnt;

    public PopulaLista(List<Integer> lista, int tamanho, int min, int max, DoubleAdder totalSoma, DoubleAdder totalQnt) {
        this.lista = lista;
        this.tamanho = tamanho;
        this.min = min;
        this.max = max;
        this.totalSoma = totalSoma;
        this.totalQnt = totalQnt;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Thread " + t.getName() + " iniciada para popular a lista com tamanho: " + tamanho);
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            int number = random.nextInt(max - min + 1) + min;
            lista.add(number);
            totalSoma.add(number);
            totalQnt.add(1);
        }
        System.out.println("Thread finalizada " + t.getName());
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 100000;
        int m = 10;
        int min = 1000;
        int max = 100000;

        List<List<Integer>> listasDeListas = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        DoubleAdder totalSoma = new DoubleAdder();
        DoubleAdder totalQnt = new DoubleAdder();

        int tamanhoPorLista = n / m;
        int numerosRestantes = n % m;

        for (int i = 0; i < m; i++) {
            List<Integer> lista = new ArrayList<>();
            listasDeListas.add(lista);

            int tamanhoAtual = tamanhoPorLista;
            if (i == m - 1) {
                tamanhoAtual += numerosRestantes;
            }

            PopulaLista populaLista = new PopulaLista(lista, tamanhoAtual, min, max, totalSoma, totalQnt);
            Thread t = new Thread(populaLista, "PopulaLista-" + (i + 1));
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\n--- Média Geral ---");

        double mediaGeral = totalSoma.doubleValue() / totalQnt.doubleValue();

        System.out.println("Total de números gerados: " + totalQnt.longValue());
        System.out.println("Média geral de todos os números: " + String.format("%.2f", mediaGeral));
    }
}