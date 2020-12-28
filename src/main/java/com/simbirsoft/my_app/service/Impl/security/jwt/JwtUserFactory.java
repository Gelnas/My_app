package com.simbirsoft.my_app.service.Impl.security.jwt;

import com.simbirsoft.my_app.model.Users;
import com.simbirsoft.my_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public final class JwtUserFactory {

    @Autowired
    private static UserService userService;

    public static JwtUser create(Users user){
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                userService.mapRolesToPermission(user.getRoles())
        );
    }

}
