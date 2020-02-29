package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.LoginStatus;
import com.white_wolf.threeeyedcrows.model.User;
import com.white_wolf.threeeyedcrows.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LoginStatus login(String username, String password) {
        Optional<User> userOptional = this.userRepository.getUserByUsername(username);
        if(userOptional.isEmpty())
            return LoginStatus.WRONG_USER;
        User user = userOptional.get();
        if(!password.equals(user.getPassword()))
            return LoginStatus.WRONG_PASSWORD;
        else
            return LoginStatus.OK;

    }

    @Override
    public boolean register(User user) {
        Optional<User> userOptional = this.userRepository.getUserByUsername(user.getUsername());
        if(userOptional.isPresent())
            return false;
        this.userRepository.save(user);
        return true;
    }
}
