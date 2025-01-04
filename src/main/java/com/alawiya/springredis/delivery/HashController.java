package com.alawiya.springredis.delivery;

import com.alawiya.springredis.model.User;
import com.alawiya.springredis.model.UserHash;
import com.alawiya.springredis.services.RedisHashService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/hash")
public class HashController {

    private final RedisHashService redisHashService;

    public HashController(RedisHashService redisHashServicel) {
        this.redisHashService = redisHashServicel;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveDataHash(@RequestBody UserHash value) {

        return ResponseEntity.ok(redisHashService.saveUser(value));
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<UserHash>> getById(@PathVariable String id) {
        return ResponseEntity.ok(redisHashService.getUserById(id));
    }
    @GetMapping("/getAll")
    public ResponseEntity<Iterable<UserHash>> getAllHash() {
        return ResponseEntity.ok(redisHashService.getAllUsers());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        redisHashService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
