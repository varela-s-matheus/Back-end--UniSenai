package com.senai.BackendUniSenai.service;

import com.senai.BackendUniSenai.repository.DoctorScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorScheduleService {
    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;


}
