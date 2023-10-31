package com.oscartrugo.users.repositories;

import com.oscartrugo.users.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByUsername(String username);

    public Optional<User> findByUsernameAndPassword(String username, String password);

    /*
    * ESTO NO ES SQL, se llama JPQL (Java Persistence Query Language)
    * */
    @Query("SELECT u.username FROM User u WHERE u.username like '%collins'")
    public Page<String> findUsernames(Pageable pageable);
}
