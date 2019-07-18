package com.omnicuris.ecommercebasic.repositories;

import com.omnicuris.ecommercebasic.models.Item;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpecifications {
    public static Specification<Item> isNotDeleted() {
        return (item, query, builder) ->
                builder.equal(item.get("deleted"), false);
    }
}
