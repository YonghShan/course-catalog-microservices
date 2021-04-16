package com.yonghshan.services.newcourseapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

/**
 * @author YonghShan
 * @date 4/3/21 - 17:02
 */
public interface CourseRepository extends JpaRepository<Course, BigInteger> {
}
