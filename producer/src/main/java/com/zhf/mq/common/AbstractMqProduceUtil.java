package com.zhf.mq.common;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author:zuohf
 * @description:
 * @date:created in 2019/9/16
 * mofify:by
 */
public abstract class AbstractMqProduceUtil {

    //定义ActivMQ的连接地址
    private static final String ACTIVEMQ_URL = "tcp://192.168.3.191:61616";
    //定义发送消息的队列名称
    private static final String QUEUE_NAME = "queue-message";

    private static final String TOPIC_NAME = "topic-message";

    public void produceQueueMessage(String message) throws JMSException {
        Connection connection = getConnection();
        //创建会话
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createQueue(QUEUE_NAME);
        //创建一个生产者
        MessageProducer producer = session.createProducer(destination);
        // 设置持久化/非持久化， 如果非持久化，MQ重启后可能后不会导致消息丢失
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        produceMessgae(producer,session,message);
        // 如果设置了事务，会话就必须提交
        session.commit();
        connection.close();
    }

    public void produceTopicMessage(String message) throws JMSException {
        Connection connection = getConnection();
        //创建会话
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createTopic(TOPIC_NAME);
        //创建一个生产者
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        produceMessgae(producer,session,message);
        // 如果设置了事务，会话就必须提交
        session.commit();
        connection.close();
    }

    private Connection getConnection() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        return connection;
    }

    protected abstract void produceMessgae(MessageProducer producer,Session session,String message);

}