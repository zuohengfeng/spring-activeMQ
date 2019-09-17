package com.zhf.mq.service;

public interface MessageConsumer<T> {
    T receiveMessage();
}