package com.yonghshan.services.newuserapp;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author YonghShan
 * @date 4/12/21 - 17:08
 */
public class CompositeKey implements Serializable {
    private BigInteger userid;
    private BigInteger courseid;
}
