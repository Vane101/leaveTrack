package com.ubiquitech.leaveTrack.hash;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by vane on 2014/12/02.
 */
public class HashPassword {

    public String hash(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);

    }
}
