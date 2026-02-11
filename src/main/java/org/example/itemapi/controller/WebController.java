package com.example.itemapi.controller;

import com.example.itemapi.model.Item;
import com.example.itemapi.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final ItemService service;

    public WebController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", service.getAllItems());
        return "index";
    }
    @PostMapping("/get")
    public String getItem(@RequestParam int id, Model model) {

        Item item = service.getItemById(id);

        if (item == null) {
            model.addAttribute("message", "Item not found!");
        } else {
            model.addAttribute("foundItem", item);
        }

        model.addAttribute("items", service.getAllItems());
        return "index";
    }

    @PostMapping("/add")
    public String addItem(@RequestParam String name,
                          @RequestParam String description,
                          @RequestParam double price,
                          Model model) {

        if (name.isBlank() || description.isBlank() || price <= 0) {
            model.addAttribute("message", "Invalid input!");
            model.addAttribute("items", service.getAllItems());
            return "index";
        }

        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);

        Item saved = service.addItem(item);

        model.addAttribute("message", "Item added! ID = " + saved.getId());
        model.addAttribute("items", service.getAllItems());

        return "index";
    }
}
