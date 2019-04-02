package com.ghjansen.checkout.persistence.model;

/**
 * The interface that is implemented by all entities in the data model.<p>
 * This interface helps to handle all entities the same way, facilitating
 * the abstraction of CRUD operations, thus, allowing the implementation
 * of a abstract repository as {@link com.ghjansen.checkout.persistence.repository.Repository}
 */
public interface Entity {

    public void setId(final Long id);
    public Long getId();

}
