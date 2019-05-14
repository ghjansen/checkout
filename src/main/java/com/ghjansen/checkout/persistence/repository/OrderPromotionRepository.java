package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.OrderPromotion;
import com.ghjansen.checkout.persistence.model.OrderPromotionPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderPromotionRepository extends CrudRepository<OrderPromotion, OrderPromotionPK> {

}
