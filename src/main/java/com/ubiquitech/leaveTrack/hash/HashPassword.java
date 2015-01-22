package com.ubiquitech.leaveTrack.hash;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * vane created on 2014/12/02.
 */
public class HashPassword {

    public String hash(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);

    }
}
