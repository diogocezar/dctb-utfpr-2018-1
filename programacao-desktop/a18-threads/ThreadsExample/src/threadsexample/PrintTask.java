package threadsexample;

import java.util.Random;

class PrintTask implements Runnable{
    private int sleepTime;
    private String threadName;
    private static Random generator = new Random();

    public PrintTask(String name){
        threadName = name;
        // seleciona tempo de adormecimento aleatório entre 0 e 5 segundos
        sleepTime = generator.nextInt(5000);
    }

    // método run é o código a ser executado pela nova thread 
    public void run() {
        try{ // coloca a thread para dormir a pela quantidade de tempo sleepTime
            System.out.printf("%s going to sleep for %d milliseconds.\n",
                    threadName, sleepTime);
            Thread.sleep(sleepTime); // coloca a thread para dormir
        }
        catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.printf("%s done sleeping\n", threadName);
    }
} 