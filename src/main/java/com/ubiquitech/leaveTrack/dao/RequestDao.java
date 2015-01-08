package com.ubiquitech.leaveTrack.dao;

import com.ubiquitech.leaveTrack.domain.Request;

import java.util.List;

/**
 * Created by vane on 2014/12/08.
 */
public interface RequestDao {
    public void createRequest(Request request);
    public List getRequestsByStatusAndSupervisorId(String status, Long id);
    public List getRequestsByStatusAndRequestId(String status,Long id);
}
