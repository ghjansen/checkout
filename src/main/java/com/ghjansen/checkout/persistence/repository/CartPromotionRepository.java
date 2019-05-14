package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.CartPromotion;
import com.ghjansen.checkout.persistence.model.CartPromotionPK;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CartPromotionRepository extends CrudRepository<CartPromotion, CartPromotionPK> {

    /**
     * Additional repository method to clean cart promotions before
     * recalculating them. The promotions are recalculated each time
     * a item is added to or removed from the cart, therefore, this
     * operation must preceed both cases.
     * The Query command was written using JPQL.
     * https://stackoverflow.com/questions/10649691/using-embeddedid-with-jparepository
     * https://stackoverflow.com/questions/4676904/how-to-write-jpql-select-with-embedded-id
     * @param cartId
     * @return
     */
    @Modifying
    @Query(value = "DELETE FROM CartPromotion c WHERE c.pk.cart.id = :cartId")
    int deleteCartPromotions(@Param("cartId") Long cartId);

}
