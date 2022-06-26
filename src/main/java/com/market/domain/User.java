package com.market.domain;

import lombok.*;


import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
public class User {

    public User(Long id, String name, String username, String password, Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String username;
    private String password;


    @ManyToMany(fetch =  FetchType.EAGER)
    private Collection<Role>  roles = new ArrayList<>();

    private boolean isAccountNonExpired =false;
    private boolean isAccountNonLocked = false;
    private boolean isCredentialsNonExpired = false;
    private boolean isEnabled = false;
    private int failedAttempt =10;
    private Date lockTime;



//    @Column(name = "account_non_locked")
//    private boolean accountNonLocked =false;
//
//    @Column(name = "failed_attempt")
//    private int failedAttempt =25;

}
