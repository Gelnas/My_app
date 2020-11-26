package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.model.Role;

public interface RoleService {
    Role getById(Long id);
}
