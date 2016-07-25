package Nats;

import org.nats.Connection;

import java.util.Properties;

/**
 * Created by tiger on 7/15/2016.
 */

import java.util.Properties;
import org.nats.*;

public class NatsConsumer1 {
    public static void main(String[] args) throws Exception {
        Connection conn = Connection.connect(new Properties());
        conn.subscribe("foo", new MsgHandler() {
            int i=0;
            public void execute(String msg) {
                i++;
                System.out.println(this.i +" Received a message by 2nd Consumer: " + msg);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}