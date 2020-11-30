package com.simbirsoft.my_app.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;

@Entity
@Table(name = "roles")
@Data
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_")
    private String role;

    @ManyToMany
    @JoinTable(name = "roles_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "perm_id"))
    private Collection<Permission> permissions;
}
