package com.alawiya.springredis.services;

import com.alawiya.springredis.model.User;
import com.alawiya.springredis.model.UserHash;
import com.alawiya.springredis.repository.RedisHashRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedisHashService {
    private final RedisHashRepository repository;

    public RedisHashService(RedisHashRepository repository) {
        this.repository = repository;
    }

    public UserHash saveUser(UserHash userHash){
        return repository.save(userHash);
    }

    public Optional<UserHash> getUserById(String id) {
        return repository.findById(id);
    }

    public Iterable<UserHash> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUserById(String id) {
        repository.deleteById(id);
    }
}
