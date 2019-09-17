package com.zhf.mq.service.impl;

import com.zhf.mq.common.AbstractMqProduceUtil;
import com.zhf.mq.common.ProduceUtil;
import com.zhf.mq.service.MessageProduce;

import javax.jms.JMSException;

/**
 * @author:zuohf
 * @description:
 * @date:created in 2019/9/16
 * mofify:by
 */
public class MessageProduceImpl implements MessageProduce {

    private AbstractMqProduceUtil abstractMqProduceUtil;

    @Override
    public Object sendMessage(String message) {
        abstractMqProduceUtil= new ProduceUtil();
        try {
            //abstractMqProduceUtil.produceQueueMessage(message);
            abstractMqProduceUtil.produceTopicMessage(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return "========完成消息发送========";
    }
}