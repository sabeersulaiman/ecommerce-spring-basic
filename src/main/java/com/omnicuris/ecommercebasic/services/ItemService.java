package com.omnicuris.ecommercebasic.services;

import com.omnicuris.ecommercebasic.models.Item;

import java.util.List;

public interface ItemService {
    Item addItem(Item toAdd);

    List<Item> getItemList(int page, int count);

    Item getItem(int id);

    Item updateItem(Item toUpdate);

    Item deleteItem(int id);
}
