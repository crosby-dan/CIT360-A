package CollectionsThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsDemo {

    private Runnable task = () -> {

        String currentThread=Thread.currentThread().getName();
        System.out.format("Running anonymous task from thread %s\n",currentThread);

        try {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.format("Finished anonymous task from thread %s\n",currentThread);
    };

    public void startThreads() {
        System.out.println("***************************************************************************************************");
        System.out.println("Simple direct thread demo, which calls an anonymous method");
        System.out.println("Now starting a 2 second task on 5 threads + the main thread.");
        System.out.println("Note that these are not synchronized and not guaranteed to run in sequence.");
        System.out.println("Since these are not synchronized, the prompt for 'enter' may occur before all the threads complete.");
        //Starting task on the main thread
        task.run();
        Thread thread= new Thread(task);
        thread.start();
        Thread thread2= new Thread(task);
        thread2.start();
        Thread thread3= new Thread(task);
        thread3.start();
        Thread thread4= new Thread(task);
        thread4.start();
        Thread thread5= new Thread(task);
        thread5.start();
        Util.Util.promptEnterKey();

        }
    public void startThreadsES() {
        System.out.println("***************************************************************************************************");
        System.out.println("Thread demo using ExecutorService, which calls an anonymous method");
        System.out.println("Now starting 10 tasks that will run for 2 second tasks with a thread pool size of 3.");
        System.out.println("The process will not start the next three tasks until a thread in the pool becomes available.");
        ExecutorService es = Executors.newFixedThreadPool(3);
        //Queue up 6 tasks that run for 2 seconds each
        for (int i=0;i<10;i++) {
            es.execute(task);
        }

        try {
            //Without this line of code, the threadpool would not time out upon completion.
            es.shutdown();
            //If the program hasn't finished in 15 seconds then something is wrong (since it should take 6 seconds).
            es.awaitTermination(45,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Get user input before returning to the main menu.
        Util.Util.promptEnterKey();
    }

}

