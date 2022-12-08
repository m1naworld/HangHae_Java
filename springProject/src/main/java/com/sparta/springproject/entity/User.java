package com.sparta.springproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING) // ADMIN 권한 부여는 DB로 조작한다고 가정.
    private UserRoleEnum role = UserRoleEnum.USER;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }


}
