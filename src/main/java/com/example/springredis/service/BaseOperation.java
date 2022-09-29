package com.example.springredis.service;

/**
 * 定义基础操作
 */
public interface BaseOperation<T> {

    T getData(String key);
}
