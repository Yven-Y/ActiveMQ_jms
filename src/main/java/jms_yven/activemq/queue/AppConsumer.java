package jms_yven.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息消费者
 * Created by yven on 2018/7/22.
 */
public class AppConsumer {

    public static final String URL = "tcp://127.0.0.1:61616";
    public static final String QUEUE_NAME = "queue-test";

    public static void main(String[] args) throws JMSException {
        /* 1、创建FactoryConnetion */
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);

        /* 2、创建Connection*/
        Connection connection = connectionFactory.createConnection();

        /* 3、启动连接*/
        connection.start();

        /* 4、创建session*/
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);// 第一个参数表示是否开启事务

        /* 5、创建目的地*/
        Destination destination = session.createQueue(QUEUE_NAME);

        /* 6、创建消费者*/
        MessageConsumer consumer = session.createConsumer(destination);

        /* 7、创建监听器*/
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接受消息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });


        /* 8、关闭连接*/
        //connection.close();

    }
}