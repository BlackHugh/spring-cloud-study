package com.zephyr.user.service;

import com.zephyr.user.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface JpaService<T,K> {
    public List<T> findAll();
    public Optional<T> findById(K id);
    public void save(T t);
    public void deleteById(K id);
}
