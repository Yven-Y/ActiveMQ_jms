package jms_yven.activemq.spring.consumer;

import jms_yven.activemq.spring.producer.ProducerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yven on 2018/7/22.
 */
public class AppConsumer {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");


    }
}
