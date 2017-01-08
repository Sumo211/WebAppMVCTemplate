package com.leon.webapp.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by ntcong on 12/30/2016.
 */
@Entity
@Table(name = "user")
//@Data
@Getter
@Setter
//@ToString
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 5, max = 20)
    private String username;

    @Email
    private String email;

    @Size(min = 5, max = 20)
    private String password;

    @ManyToOne()
    @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "role_id"))
    private Role role;

    @Builder
    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
