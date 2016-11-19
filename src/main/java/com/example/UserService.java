package com.example;

import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService {
    List<User> users();
    void add(String name);
    void remove(Integer id);
}
