package com.zhf.mq.service;

public interface MessageProduce<T> {

    T sendMessage(String message);
}