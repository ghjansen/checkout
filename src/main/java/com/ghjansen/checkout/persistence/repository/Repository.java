package com.ghjansen.checkout.persistence.repository;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Validated
public abstract class Repository<T> {

    protected final AtomicLong counter;
    protected final HashMap<Long, T> repository;

    Repository(){
        this.counter = new AtomicLong();
        this.repository = new HashMap<>();
    }

    public abstract T save(@Valid final T entity);

    public abstract Optional<T> findById(final Long id);

    public abstract Iterable<T> findAll();

    public abstract void delete(final T entity);

    public abstract void deleteById(final Long id);

    public Long getCandidateId(){
        return this.counter.get()+1;
    }

}
