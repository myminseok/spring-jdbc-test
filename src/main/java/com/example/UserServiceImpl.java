package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> users() {
        return userRepository.findAll();
    }


    @Override
    public void add(String name) {
        userRepository.save(new User(name));

    }

    @Override
    public void remove(Integer id) {
        userRepository.delete(id);
    }
}
