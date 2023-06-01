package vohohungthinh.lab3.service;

import vohohungthinh.lab3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vohohungthinh.lab3.repository.IUserRepository;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public void  save(User user){
        userRepository.save(user);
    }
}
