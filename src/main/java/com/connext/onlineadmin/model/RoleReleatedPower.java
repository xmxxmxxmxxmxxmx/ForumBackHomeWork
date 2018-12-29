package com.connext.onlineadmin.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "role_releated_power")
public class RoleReleatedPower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "power_id")
    @ManyToOne
    private Power power;

    @JoinColumn(name = "role_id")
    @ManyToOne
    private Role role;
}
