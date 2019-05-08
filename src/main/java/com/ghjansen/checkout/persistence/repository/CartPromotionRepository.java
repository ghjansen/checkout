package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.CartPromotion;
import org.springframework.data.repository.CrudRepository;

public interface CartPromotionRepository extends CrudRepository<CartPromotion, Long> {
}
