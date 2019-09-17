package com.zhf.mq;

import com.zhf.mq.service.MessageProduce;
import com.zhf.mq.service.impl.MessageProduceImpl;

/**
 * Hello world!
 *
 */
public class Produce
{
    public static void main( String[] args )
    {

        MessageProduce messageProduce = new MessageProduceImpl();
        messageProduce.sendMessage("Hello");
    }
}
