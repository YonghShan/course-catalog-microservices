package com.yonghshan.services.newuserapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * @author YonghShan
 * @date 4/12/21 - 16:55
 */
public interface UserRepository extends JpaRepository<User, BigInteger> {

    List<User> findByuserid(BigInteger id);
    List<User> findBycourseid(BigInteger id);
}
