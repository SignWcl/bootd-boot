package com.sign.repository;


import com.sign.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<Long, User> repository = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong();


    public Boolean save(User user) {
        long id = idGenerator.incrementAndGet();
        return repository.put(id, user) == null;
    }

    public Collection<User> findAll() {
        return repository.values();
    }
}
