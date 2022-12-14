package com.bayraktolga.springapiserver.service;


import com.bayraktolga.springapiserver.model.Product;
import com.bayraktolga.springapiserver.model.User;
import com.bayraktolga.springapiserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User create(User userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    public void delete (Long id){
        userRepository.deleteById(id);
    }

    public Optional<User> update(Long id, User userRequest){
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(user1 -> {
            user1.setUsername(userRequest.getUsername());
            user1.setEmail(userRequest.getEmail());
            user1.setPassword(userRequest.getPassword());
            userRepository.save(user1);

        });
        return user;
    }

    public Optional<User> show(Long id){
        return userRepository.findById(id);
    }


}
