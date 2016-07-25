package Nats;

/**
 * Created by tiger on 7/20/2016.
 */
public class Calculation {
    public static void main(String[] args){
        System.out.println(NatsProducer.timeSent);
        System.out.println(NatsConsumer.timeRecieved);
    }
}
