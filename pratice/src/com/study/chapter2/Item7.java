package com.study.chapter2;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by Administrator on 2019/7/10 0010.
 * 消除对过期对象的引用
 */
 class Stack {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPCITY = 16;//默认的初始化大小
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPCITY];
    }
    //压栈
    public void push(Object o) {
        //首先判断是否还有容量,若容量不够则进行扩容
        ensureCapcity();
        elements[size++] = o;
    }
    //弹栈
    public Object pop() {
        //判断栈是否为空，若是，则抛出异常
        if(size == 0)
            throw new EmptyStackException();
        Object o = elements[--size];
        elements[size] = null;//这一步很关键，可消除对过期对象的引用，避免内存泄漏
        return o;
    }
    public void ensureCapcity() {
        if(elements.length == size)
            elements = Arrays.copyOf(elements,2 * size + 1);
    }
}
public class Item7 {
}
