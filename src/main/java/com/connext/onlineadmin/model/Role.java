package com.connext.onlineadmin.model;

import lombok.Data;
import org.apache.ibatis.annotations.One;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String rolename;

    @OneToMany(mappedBy = "role")
    private List<RoleReleatedPower> roleReleatedPowerList;



}
