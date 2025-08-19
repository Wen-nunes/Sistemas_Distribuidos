package org.example;

import java.util.ArrayList;
import java.util.List;

class ListaCompartilhada {
    private final List<Integer> numeros = new ArrayList<>();

    public synchronized void adicionarNumero(int umNumero) {
        numeros.add(umNumero);
        System.out.println(Thread.currentThread().getName() + " adicionou: " + umNumero);
    }

    public synchronized List<Integer> retornarNumeros() {
        return new ArrayList<>(numeros);
    }
}

class ThreadDeTrabalho extends Thread {
    private final ListaCompartilhada listaCompartilhada;
    private final int inicio;
    private final int fim;
    private final boolean ehPar;
    private static final int qnt= 6;

    public ThreadDeTrabalho(ListaCompartilhada lista, int inicio, int fim, boolean ehPar) {
        this.listaCompartilhada = lista;
        this.inicio = inicio;
        this.fim = fim;
        this.ehPar = ehPar;
    }

    @Override
    public void run() {
        int contador = 0;
        for (int i = inicio; i <= fim && contador < qnt; i++) {
            if (ehPar) {
                if (i % 2 == 0) {
                    listaCompartilhada.adicionarNumero(i);
                    contador++;
                }
            } else {
                if (i % 2 != 0) {
                    listaCompartilhada.adicionarNumero(i);
                    contador++;
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ignored) {}
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ListaCompartilhada listaCompartilhada = new ListaCompartilhada();

        Thread t1 = new ThreadDeTrabalho(listaCompartilhada, 100, 200, true);
        Thread t2 = new ThreadDeTrabalho(listaCompartilhada, 1, 99, false);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Lista final: " + listaCompartilhada.retornarNumeros());
    }
}