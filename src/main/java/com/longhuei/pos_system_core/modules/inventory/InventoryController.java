package com.longhuei.pos_system_core.modules.inventory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/inventory")
@Tag(description = "Api for inventory operation", name = "Inventory")
public class InventoryController {

    @GetMapping(path = "/")
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Hello world");
    }
}