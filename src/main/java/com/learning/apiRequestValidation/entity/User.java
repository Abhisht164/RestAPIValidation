package com.learning.apiRequestValidation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name="USER_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private String age;
    private String nationality;
}

