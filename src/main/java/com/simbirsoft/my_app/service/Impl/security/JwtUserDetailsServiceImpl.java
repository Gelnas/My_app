package com.simbirsoft.my_app.service.Impl.security;

import com.simbirsoft.my_app.model.Users;
import com.simbirsoft.my_app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.findByUsername(username);

        if (isEmpty(user)) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
       } else {
            return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
        }
    }
//        if (!"javainuse".equals(username)) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        } else {
//            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//                    new ArrayList<>());
//        }

}
