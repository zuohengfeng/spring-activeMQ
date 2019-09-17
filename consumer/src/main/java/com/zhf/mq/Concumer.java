package com.zhf.mq;

import com.zhf.mq.service.MessageConsumer;
import com.zhf.mq.service.impl.MessageConsumerImpl;

/**
 * Hello world!
 *
 */
public class Concumer
{
    public static void main( String[] args )
    {
        MessageConsumer messageConsumer = new MessageConsumerImpl();
        System.out.println("consumer1:"+messageConsumer.receiveMessage());
    }
}
