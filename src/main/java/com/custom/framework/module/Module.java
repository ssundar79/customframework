package com.custom.framework.module;


public interface Module {

    void configure();

    <T> Class<? extends T> getMapping(Class<T> type);
}
