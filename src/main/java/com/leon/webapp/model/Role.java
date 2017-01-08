package com.leon.webapp.model;

import com.leon.webapp.constant.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ntcong on 12/30/2016.
 */
@Entity
@Table(name = "role")
//@Data
@Getter
@Setter
//@ToString
@NoArgsConstructor
@NamedEntityGraph(name = "graph.Users", attributeNodes = @NamedAttributeNode(value = "users"))
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleType type;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    //@LazyCollection(LazyCollectionOption.FALSE)
    private Set<User> users;

    public Role(RoleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "type=" + type +
                ", users=" + users +
                '}';
    }

}
