package ru.kata.spring.boot_security.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        //User findUserById(Long id);
        User findByUsername(String username);

        //@Query("select u From User u join fetch u.roles where u.email =:email")
        //User findUserByEmail(@Param("email") String email);
}








