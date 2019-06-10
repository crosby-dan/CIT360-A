package CollectionsThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtomicityDemo {

    //This code is for the Thread Executor Demo (#3) where the Atomicity is important.
    //To demonstrate this we are going to get 10 different threads going to add items to a collection within a single class.
    //The array list where the numbers are saved must be synchronized (not just using the standard ArrayList class
    //The .count property of the RandomCollection class uses Atomicity integer type to accurately count the number of times it has executed
    //even when being called from many threads.
    RandomCollection randomCollection = new RandomCollection();
    final int batchSize = 5000;
    Runnable task2 = () -> {

        String currentThread=Thread.currentThread().getName();
        System.out.format("Starting anonymous task from thread %s\n",currentThread);

        //Add the specified number of random numbers to the RandomCollection
        randomCollection.Add(batchSize);

        System.out.format("Finished anonymous task from thread %s\n",currentThread);
    };

    public void startThreadsRandom() {
        System.out.println("********************************************************************************************************");
        System.out.println("Thread demo using ExecutorService, which calls an anonymous method task2 which calls RandomCollection");
        System.out.format("Now starting 10 tasks which will add %d random numbers each, and safely count the new total.\n",batchSize);
        System.out.println("Using a thread pool size of 4.");

        //Pool size of 4 (OK to experiment with different values)
        ExecutorService es = Executors.newFixedThreadPool(4);
        //Queue up 10 tasks to generate random numbers
        for (int i=0;i<10;i++) {
            es.execute(task2);
        }

        try {
            //Without this line of code, the thread pool would not time out upon completion.
            es.shutdown();
            //If the program hasn't finished in 45 seconds then something is wrong.
            es.awaitTermination(1000, TimeUnit.SECONDS);
            System.out.format("The number of random numbers added is %d\n", randomCollection.getCount());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Get user input before returning to the main menu.
        Util.Util.promptEnterKey();
    }
}
