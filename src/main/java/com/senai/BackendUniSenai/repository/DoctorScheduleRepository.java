package com.senai.BackendUniSenai.repository;

import com.senai.BackendUniSenai.model.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Integer> {

    @Query(value = "SELECT * from doctor_schedule " +
                   "where doctor_id = :doctor_id and day_of_week = DAYOFWEEK(:date)", nativeQuery = true)
    public DoctorSchedule findDoctorScheduleByDayOfWeek(@Param("doctor_id") int doctor_id, @Param("date") String date);
}
