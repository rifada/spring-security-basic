package me.holytiger.springsecuritybasic.member;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

@Data
@Entity
@Table
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

    private String role;
}
