package com.senai.BackendUniSenai.repository;

import com.senai.BackendUniSenai.model.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Integer> {
}
