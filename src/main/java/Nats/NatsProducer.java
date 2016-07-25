package Nats; /**
 * Created by tiger on 7/15/2016.
 */

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.nats.*;

public class NatsProducer extends Thread {
    public static Map timeSent = null;
   // public static void main(String[] args) throws Exception{
        public Map produce()throws Exception{

            Connection conn = Connection.connect(new Properties());

// Simple Publisher
        System.out.println("Publish going to start");
        long start = System.currentTimeMillis();
        long startns = System.nanoTime();
        timeSent =  new LinkedHashMap();
        for(int i=1;i<=1000000;i++) {
            conn.publish("foo", "Hello World!");
            timeSent.put(i, System.nanoTime());
        }
        System.out.println("Publish end");

        long millis = (System.currentTimeMillis()-start);

        System.out.println("Time taken to publish :"+millis+" ms");
        System.out.println("Time taken to publish :"+(System.nanoTime()-startns)+" ns");

        System.out.println("Time taken to publish :"+(((System.currentTimeMillis()-start) / 1000) % 60)+" seconds");
        return timeSent;
    }

    @Override
    public void run() {
        NatsProducer produce = new NatsProducer();
        try {
            produce.produce();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}