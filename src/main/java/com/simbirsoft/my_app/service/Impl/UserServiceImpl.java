package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.exception.UserNotFoundException;
import com.simbirsoft.my_app.model.Role;
import com.simbirsoft.my_app.model.Users;
import com.simbirsoft.my_app.repository.RoleRepository;
import com.simbirsoft.my_app.repository.UserRepository;
import com.simbirsoft.my_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService /*, UserDetailsService*/ {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

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

    public  Role findByRole(String role){
        if(isEmpty(role)){
            throw new UserNotFoundException(role);
        }
        else {
            return roleRepository.findByRole(role);
        }
        }

   /* @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = findByUsername(username);

        if(isEmpty(user)){
            throw new UsernameNotFoundException("User not found");
        }
        return new User(user.getUsername(), user.getPassword(), mapRolesToPermission(user.getRoles()));
    }
*/


    @Override
    public Collection<? extends GrantedAuthority> mapRolesToPermission(Collection<Role> roles){
        return roles.stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
    }

}
