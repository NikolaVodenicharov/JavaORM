package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        var id = user.getId();

        if (id != null){
            if (this.userRepository.existsById(id)){
                throw new IllegalArgumentException("User id already exist.");
            }
        }

        var username = user.getUsername();
        if (username != null){
            var users = this.userRepository.findByUsername(username);

            if (users.size() > 0){
                throw new IllegalArgumentException("User Username already exist.");
            }
        }

        this.userRepository.save(user);
    }
}
