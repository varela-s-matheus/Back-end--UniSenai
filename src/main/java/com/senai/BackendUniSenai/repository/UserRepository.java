package com.senai.BackendUniSenai.repository;

import com.senai.BackendUniSenai.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT EXISTS (SELECT 1\n" +
            "FROM user u\n" +
            "left join patient p on (p.id = u.register_id and :user_type = 'p')\n" +
            "left join doctor d on (d.id = u.register_id and :user_type = 'm')\n" +
            "WHERE (p.email = :email or d.email = :email)\n" +
            "and u.password = :password);", nativeQuery = true)
    public int verifyUser(String email, String password, char user_type);

    public boolean existsByRegisterId(int id);
    public User findByRegisterId(int id);
}
