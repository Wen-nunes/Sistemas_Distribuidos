import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

    class ThreadsTarefa1 extends Thread{
    public void run(){
        ArrayList<Integer> lista = new ArrayList<>();
        Random gerador = new Random();
        int n = 1000;

        for(; n>0; n--){
            lista.add(gerador.nextInt(10000));
        }
        System.out.println("Tarefa 1 Concluida");
    }

}

class ThreadsTarefa2 extends Thread{
    public void run(){
        Random gerador = new Random();

        for(int n = 100; n > 0 ; n--){
            System.out.println(gerador.nextInt(500, 800));
        }
        System.out.println("Tarefa 2 Concluida");
    }

}

class ThreadsTarefa3 extends Thread{

    public void run(){

        ArrayList<Integer> lista = new ArrayList<>();
        Random gerador = new Random();
        ArrayList<Integer> lista2 = new ArrayList<>();

        for(int n=50; n>0; n--){
            lista.add(gerador.nextInt(50000, 80000));
        }
        System.out.println("Tarefa 3 Concluida");
    }

}
public class AulaThreads {
    public static void main(String[] args) throws InterruptedException {
        //tarefa1
        //popularuma lista com n numeros
        ThreadsTarefa1 t1 = new ThreadsTarefa1();
        t1.run();
        t1.join();


        //tarefa2
        //exibir n numeros aleatorios na tela
        ThreadsTarefa2 t2 = new ThreadsTarefa2();
        t2.run();



        //tarefa3
        //popular outra lista com n numero
        ThreadsTarefa3 t3 = new ThreadsTarefa3();
        t3.run();

    }
}
