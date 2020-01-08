package com.example.demo.repository;

import com.example.demo.model.RootBO;
import com.example.demo.model.data.EntityBase;

import javax.persistence.EntityManager;

public abstract class RepositoryBase<T extends EntityBase> {

    protected final EntityManager entityManager;

    protected RepositoryBase(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected void persist (RootBO<T> object){
        this.entityManager.persist(object.getState());
    }
}
