package com.zhf.mq.service.impl;

import com.zhf.mq.common.AbstractMqConsumerUtil;
import com.zhf.mq.common.ConsumerUtil;
import com.zhf.mq.service.MessageConsumer;

import javax.jms.JMSException;

/**
 * @author:zuohf
 * @description:
 * @date:created in  2019/9/16
 * mofify:by
 */
public class MessageConsumerImpl implements MessageConsumer {

    private AbstractMqConsumerUtil abstractMqConsumerUtil;
    @Override
    public Object receiveMessage() {
        abstractMqConsumerUtil= new ConsumerUtil();
        try {
            abstractMqConsumerUtil.consumerTopicMessage();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return "=======消息已经消费完毕========";
    }
}