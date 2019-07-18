package com.omnicuris.ecommercebasic.controllers;

import com.omnicuris.ecommercebasic.exceptions.BadRequestException;
import com.omnicuris.ecommercebasic.models.Item;
import com.omnicuris.ecommercebasic.services.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems(@RequestParam(value = "page", required = false) int page,
                               @RequestParam(value = "count", required = false) int count) {
        // count is constrained into [1, 100] - else defaults to 10
        if(count > 100 || count <= 0) count = 10;
        return itemService.getItemList(page, count);
    }

    @GetMapping("{id}")
    public Item getItem(@PathVariable("id") int id) {
        return itemService.getItem(id);
    }

    @PutMapping
    public Item updateItem(@Valid @RequestBody Item update) {
        if(update.getStock() < 0) {
            throw new BadRequestException("Item", "stock", update.getStock());
        }
        return itemService.updateItem(update);
    }

    @PostMapping
    public Item addItem(@Valid @RequestBody Item tobeAdded) {
        if(tobeAdded.getStock() < 0) {
            throw new BadRequestException("Item", "stock", tobeAdded.getStock());
        }
        return itemService.addItem(tobeAdded);
    }

    @DeleteMapping("{id}")
    public Item deleteItem(@PathVariable("id") int id) {
        return itemService.deleteItem(id);
    }
}
