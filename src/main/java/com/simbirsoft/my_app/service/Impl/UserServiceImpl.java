package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.model.Permission;
import com.simbirsoft.my_app.model.Role;
import com.simbirsoft.my_app.model.Users;
import com.simbirsoft.my_app.repository.RoleRepository;
import com.simbirsoft.my_app.repository.UserRepository;
import com.simbirsoft.my_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Users getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Users findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public  Role findByRole(String role_){return roleRepository.findByRole(role_);}

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = findByUsername(username);
        Collection<Role> role = user.getRoles();

        if(isEmpty(user)){
            throw new UsernameNotFoundException("User not found");
        }
        return new User(user.getUsername(), user.getPassword(), mapRolesToPermission(mapRoles(user.getRoles())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToPermission(Collection<Permission> permissions){
     return permissions.stream().map(r -> new SimpleGrantedAuthority(r.getPermission())).collect(Collectors.toList());
    }

    private Collection<Permission> mapRoles(Collection<Role> roles){
        String roleName = roles.stream().map(r -> new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toList()).get(0).toString();
        Role role = findByRole(roleName);
        return role.getPermissions();
    }

}
