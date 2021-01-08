package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.exception.UserNotFoundException;
import com.simbirsoft.my_app.model.Role;
import com.simbirsoft.my_app.model.Users;
import com.simbirsoft.my_app.repository.UserRepository;
import com.simbirsoft.my_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Users getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public Users findByUsername(String username){
        Users user = userRepository.findByUsername(username);
        if(isEmpty(user)){
            throw new UserNotFoundException(username);
        }
        else {
            return user;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> mapRolesToPermission(Collection<Role> roles){
        return roles.stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
    }

}
