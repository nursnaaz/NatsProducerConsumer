package Nats;

import org.nats.Connection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by tiger on 7/15/2016.
 */

import java.util.Properties;
import org.nats.*;

public class NatsConsumer extends Thread{
    public static Map timeRecieved = null;
    //public static void main(String[] args) throws Exception {
        public void consume()throws Exception{
        Connection conn = Connection.connect(new Properties());
        timeRecieved =  new LinkedHashMap();
        conn.subscribe("foo", new MsgHandler() {
            int i=0;
            public void execute(String msg) {
                i++;
                System.out.println(this.i +" Received a message: " + msg);
                timeRecieved.put(i,System.nanoTime());

                //System.out.println(i+" "+System.nanoTime());
                //System.out.println(i+" "+System.currentTimeMillis());
            }
        });
            //return timeRecieved;
    }

    @Override
    public void run() {
        NatsConsumer consume = new NatsConsumer();
        try {
            consume.consume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}