package com.example.demo.model;

import com.example.demo.model.data.EntityBase;

public abstract class BaseBO<T extends EntityBase> {
    protected final T state;

    protected BaseBO(T state) {
        this.state = state;
    }
}
