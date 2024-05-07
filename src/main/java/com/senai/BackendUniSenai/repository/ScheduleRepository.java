package com.senai.BackendUniSenai.repository;

import com.senai.BackendUniSenai.model.Schedule;
import com.senai.BackendUniSenai.service.ScheduleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query(value = "select doctor.id, doctor.name from doctor_schedule " +
            "join doctor on doctor.id = doctor_schedule.doctor_id " +
            "where doctor_schedule.day_of_week = DAYOFWEEK(:date)", nativeQuery = true)
    List<ScheduleService.DoctorsAvailable> getDoctorsAvailableByDayOfWeek(@Param("date") String date);

    @Query(value = "select * from schedule " +
            "where doctor_id = :doctor_id and schedule_date = :date", nativeQuery = true)
    List<Schedule> getSchedulesByDoctorIdAndDate(@Param("doctor_id") int doctor_id, @Param("date") String date);

    @Query(value = "select exists (select id from schedule " +
            "where doctor_id = :doctor_id and schedule_date = :date and initial_time = :initial_time)", nativeQuery = true)
    int checkIfHasScheduleRegister(@Param("doctor_id") int doctor_id, @Param("date") Date date, @Param("initial_time") LocalTime initial_time);
}
