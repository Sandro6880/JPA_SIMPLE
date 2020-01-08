package com.example.demo.model;

import com.example.demo.model.data.EntityBase;

public abstract class RootBO<T extends EntityBase> extends BaseBO<T>{
    protected RootBO(T state) {
        super(state);
    }

    public T getState(){
        return this.state;
    }
}
