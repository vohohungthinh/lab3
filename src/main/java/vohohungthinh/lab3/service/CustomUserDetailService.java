package vohohungthinh.lab3.service;

import vohohungthinh.lab3.entity.CustomUserDetail;
import vohohungthinh.lab3.entity.User;
import vohohungthinh.lab3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User không tìm thấy");
        return new CustomUserDetail(user, userRepository);
    }
}
