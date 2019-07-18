package com.omnicuris.ecommercebasic.repositories;

import com.omnicuris.ecommercebasic.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>,
        JpaSpecificationExecutor<Item> {
}
