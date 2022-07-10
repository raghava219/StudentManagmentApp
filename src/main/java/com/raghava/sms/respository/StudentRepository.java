package com.raghava.sms.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghava.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
