package com.zhf.mq.common;

import javax.jms.*;

/**
 * @author:zuohf
 * @description:
 * @date:created in 2019/9/16
 * mofify:by
 */
public class ConsumerUtil extends AbstractMqConsumerUtil {

    @Override
    protected void consumerMessage(MessageConsumer consumer) throws JMSException {
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("获取消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}