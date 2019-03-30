package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.Entity;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Validated
public abstract class Repository<T extends Entity> {

    protected final AtomicLong counter;
    protected final HashMap<Long, T> repository;

    Repository(){
        this.counter = new AtomicLong();
        this.repository = new HashMap<>();
    }

    public T save(@Valid final T entity){
        entity.setId(this.counter.incrementAndGet());
        this.repository.put(entity.getId(), entity);
        return entity;
    }

    public Optional<T> findById(final Long id){
        return Optional.ofNullable(this.repository.get(id));
    }

    public Iterable<T> findAll(){
        return this.repository.values();
    }

    public void delete(final T entity){
        this.deleteById(entity.getId());
    }

    public void deleteById(final Long id){
        this.repository.remove(id);
    };

    public Long getCandidateId(){
        return this.counter.get()+1;
    }

}
