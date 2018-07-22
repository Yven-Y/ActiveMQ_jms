package jms_yven.activemq.spring.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;


/**
 * Created by yven on 2018/7/22.
 */
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;

    /*@Resource  (name = "queueDestination")*/  // 模式的选择
    @Resource(name = "topicDestination")
    Destination destination;

    @Override
    public void sendMessage(String message) {

        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);

                return textMessage;
            }
        });
        System.out.println("发送消息："+message);
    }
}
