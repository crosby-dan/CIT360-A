package CollectionsThreads;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCollection {

private AtomicInteger count= new AtomicInteger(0);
//This was originally programmed using a plain ArrayList, but an ArrayList is not threadsafe and this was occasionally failing.
CopyOnWriteArrayList<Double> list = new CopyOnWriteArrayList<>();

public int getCount() {
    return this.count.get();
}

public void resetCount() {
    //After this method runs, we will call this to reset the count.
    this.count.set(0);
}

public void Add(int quantity) {
    //System.out.format ("Beginning list count=%d",this.count.get());
    // Loop through and add the specified number of random numbers to a collection.
    for (int i=0;i<quantity;i++) {
        //Add a new list item containing a random number
        try {
            list.add(ThreadLocalRandom.current().nextDouble());
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
        }
        //Increase the atomic counter
        this.count.addAndGet(1);
    }

}

}
