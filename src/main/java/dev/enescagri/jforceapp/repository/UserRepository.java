package dev.enescagri.jforceapp.repository;

import dev.enescagri.jforceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.userName = :userName AND u.password = :password")
    Optional<User> findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

}
