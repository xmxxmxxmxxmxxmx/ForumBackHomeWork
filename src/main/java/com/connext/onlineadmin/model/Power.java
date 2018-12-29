package com.connext.onlineadmin.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String powername;





}
