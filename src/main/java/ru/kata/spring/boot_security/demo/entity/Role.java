package ru.kata.spring.boot_security.demo.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String name;
    @Column(name = "name", unique = true)
   private String name;

    public Role() {
    }


    public Role(String name) {
        this.name= name;
    }

    @Transient
    @ManyToMany(fetch = FetchType.LAZY)
    private List <User> userList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }


   @Override
   public String toString() {
       return "Role{" +
               "name='" + name + '\'' +
               '}';
   }
}



