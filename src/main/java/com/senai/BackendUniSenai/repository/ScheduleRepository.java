package com.senai.BackendUniSenai.repository;

import com.senai.BackendUniSenai.model.Schedule;
import com.senai.BackendUniSenai.service.ScheduleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query(value = "select d.id, d.name from doctor_schedule ds " +
                   "join doctor d on d.id = ds.doctor_id " +
                   "where ds.day_of_week = DAYOFWEEK(:date)", nativeQuery = true)
    public List<ScheduleService.DoctorsAvailable> getDoctorsAvailableByDayOfWeek(@Param("date") String date);

    @Query(value = "select * from schedule " +
                   "where doctor_id = :doctor_id and schedule_date = :date", nativeQuery = true)
    public List<Schedule> getSchedulesByDoctorIdAndDate(@Param("doctor_id") int doctor_id, @Param("date") String date);
}
