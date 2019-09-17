package com.zhf.mq.common;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author:zuohf
 * @description:
 * @date:created in 2019/9/16
 * mofify:by
 */
public class ProduceUtil extends AbstractMqProduceUtil {

    @Override
    protected void produceMessgae(MessageProducer producer, Session session,String message) {
        for (int i = 1 ; i <= 100 ; i++){
            TextMessage mes = null;
            try {
                mes = session.createTextMessage("我发送queue-message: " + i+"--"+message);
                //发送消息
                producer.send(mes);
                //在本地打印消息
                System.out.println("我现在发的消息是：" + mes.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}