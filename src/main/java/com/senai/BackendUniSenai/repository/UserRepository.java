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
            "left join doctor d on (d.id = u.register_id and :user_type = 'd')\n" +
            "WHERE (p.email = :email or d.email = :email)\n" +
            "and u.password = :password);", nativeQuery = true)
    public int verifyUser(String email, String password, char user_type);

    /**
     * Verifica a existência de um usuário pelo id de médico ou paciente, usando mapeamento pela JPA
     *
     * @param id O id do médico ou paciente
     * @return Retorna o usuário com o id informado
     * */
    public boolean existsByRegisterIdAndUserType(int id, char userType);

    /**
     * Busca usuário pelo id de médico ou paciente, usando mapeamento pela JPA
     *
     * @param id O id do médico ou paciente
     * @return Retorna o usuário com o id informado
     * */
    public User findByRegisterIdAndUserType(int id, char userType);
}
