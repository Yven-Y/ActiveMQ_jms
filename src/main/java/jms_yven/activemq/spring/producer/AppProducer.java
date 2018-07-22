package jms_yven.activemq.spring.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yven on 2018/7/22.
 */
public class AppProducer {

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");

        ProducerService producerService = (ProducerService) context.getBean("producerService");

        for (int i = 0; i < 100; i++) {
            producerService.sendMessage("message - " + i);
        }


        // 关闭
        context.close();

    }
}
