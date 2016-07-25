package Nats;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by tiger on 7/20/2016.
 */
public class Test {

    public static  void main(String[] args) throws Exception {


        Thread consumer = new NatsConsumer();
        Thread producer = new NatsProducer();

        //consumer.start();
        Thread.sleep(1000);


        producer.start();

        // consumer.join();
        // producer.join();

        Thread.sleep(1000);

       /* NatsConsumer consume = new NatsConsumer();
        consume.consume();

        NatsProducer produce = new NatsProducer();
        System.out.println("SYSOUT producer "+ produce.produce());
        */
        Thread.sleep(10000);
       // System.out.println("produce.timeSent :: "+ NatsProducer.timeSent);
        //System.out.println("consume.timeRecieved :: "+ NatsConsumer.timeRecieved);
        //System.out.println( Maps.difference(NatsProducer.timeSent,NatsConsumer.timeRecieved));
        //CalculationOfTime(NatsProducer.timeSent,NatsConsumer.timeRecieved);



    }

    static void CalculationOfTime(Map timeSent, Map timeRecieved){
        ArrayList<Long> timeTakenForMessage = new ArrayList<Long>();
        //Preconditions.checkState(timeSent.size() == timeRecieved.size());
        Iterator<Map.Entry<Integer, Long>> iter1 = timeSent.entrySet().iterator();
        Iterator<Map.Entry<Integer, Long>> iter2 = timeRecieved.entrySet().iterator();
        while(iter1.hasNext() || iter2.hasNext()) {
            Map.Entry<Integer, Long> e1 = iter1.next();
            Map.Entry<Integer, Long> e2 = iter2.next();
            Long timeTaken = e2.getValue()-e1.getValue();
            timeTakenForMessage.add(timeTaken);
            System.out.println("Time Taken for "+e1.getKey()+" message to receive is : "+timeTaken);
            System.out.println("Time Taken for "+e1.getKey()+" message to receive is : "+(TimeUnit.NANOSECONDS.toMillis(timeTaken))+" ms");

        }
        System.out.println("Average Time taken : "+calculateAverage(timeTakenForMessage));

    }

    private static double calculateAverage(List<Long> marks) {
        if (marks == null || marks.isEmpty()) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < marks.size(); i++){
            sum = sum + marks.get(i);
        }
        System.out.println("Sum: "+sum);
        // calculate average
        Long average = sum / marks.size();

        System.out.println("average: " + average);
        long durationInMs = TimeUnit.NANOSECONDS.toMillis(average);
        System.out.println("average in MS: " + durationInMs);
        return average;
    }
}
