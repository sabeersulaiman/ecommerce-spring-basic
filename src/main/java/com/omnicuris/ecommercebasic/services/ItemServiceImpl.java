package com.omnicuris.ecommercebasic.services;

import com.omnicuris.ecommercebasic.exceptions.ResourceNotFoundException;
import com.omnicuris.ecommercebasic.models.Item;
import com.omnicuris.ecommercebasic.repositories.ItemRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.omnicuris.ecommercebasic.repositories.ItemSpecifications.isNotDeleted;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem(@NonNull Item toAdd) {
        return itemRepository.save(toAdd);
    }

    @Override
    public List<Item> getItemList(int page, int count) {
        Pageable pageInfo = PageRequest.of(page, count);

        return itemRepository.findAll(isNotDeleted(), pageInfo).getContent();
    }

    @Override
    public Item getItem(int id) {
        return itemRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Item", "itemId", id)
        );
    }

    @Override
    public Item updateItem(@NonNull Item update) {
        Item toBeUpdated = getItem(update.getItemId());

        toBeUpdated.setTitle(update.getTitle());
        toBeUpdated.setDescription(update.getDescription());
        toBeUpdated.setTags(update.getTags());
        toBeUpdated.setStock(update.getStock());

        return itemRepository.save(toBeUpdated);
    }

    @Override
    public Item deleteItem(int id) {
        Item toBeDeleted = getItem(id);

        if(toBeDeleted.isDeleted()) {
            return toBeDeleted;
        }
        else {
            toBeDeleted.setDeleted(true);
            return itemRepository.save(toBeDeleted);
        }
    }
}
