package com.senai.BackendUniSenai.repository;

import com.senai.BackendUniSenai.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "select exists (select 1 from patient " +
            "where patient.cpf = :cpf)", nativeQuery = true)
    public int checkIfHasPatientWithSameCpf(@Param("cpf") String cpf);

}
