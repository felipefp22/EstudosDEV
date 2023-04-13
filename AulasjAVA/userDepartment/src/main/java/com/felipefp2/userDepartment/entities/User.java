package com.felipefp2.userDepartment.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;
    @Getter @Setter private  String name;
    @Getter @Setter private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @Getter @Setter private Department department;
}
