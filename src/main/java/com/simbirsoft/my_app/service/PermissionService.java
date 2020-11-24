package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.model.Permission;
import jdk.jfr.Percentage;

public interface PermissionService {
    Permission getById(Long id);
}
