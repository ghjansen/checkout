package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.OrderPromotion;
import org.springframework.data.repository.CrudRepository;

public interface OrderPromotionRepository extends CrudRepository<OrderPromotion, Long> {

}
