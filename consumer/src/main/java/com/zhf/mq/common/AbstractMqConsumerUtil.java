package com.zhf.mq.common;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author:zuohf
 * @description:
 * @date:created in 2019/9/16
 * mofify:by
 */
public abstract class AbstractMqConsumerUtil {

    //定义ActivMQ的连接地址
    private static final String ACTIVEMQ_URL = "tcp://192.168.3.191:61616";
    //定义发送消息的队列名称
    private static final String QUEUE_NAME = "queue-message";

    private static final String TOPIC_NAME = "topic-message";

    public void consumerQueueMessage() throws JMSException {
        Connection connection = getConnection();

        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createQueue(QUEUE_NAME);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);
        consumerMessage(consumer);
    }

    public void consumerTopicMessage() throws JMSException {
        //创建连接工厂
        Connection connection = getConnection();
        //创建会话
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //创建主题目标
        Destination destination = session.createTopic(TOPIC_NAME);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);
        consumerMessage(consumer);
        session.commit();
    }

    private Connection getConnection() throws JMSException {
        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        return connection;
    }

    protected abstract void consumerMessage(MessageConsumer consumer) throws JMSException;
}