package com.demo.springsecurity.service;

import com.demo.springsecurity.entity.User;
import com.demo.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repo;

    public User get(long id) {
       return repo.findById(id).get();
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
