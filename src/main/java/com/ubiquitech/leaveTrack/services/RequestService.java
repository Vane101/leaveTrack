package com.ubiquitech.leaveTrack.services;

import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.form.QueryRequestForm;

import java.util.List;

/**
 * vane created on 2014/12/08.
 */
public interface RequestService {
    public void createRequest(Request request);

    public List getRequestsByStatusAndSupervisorId(String status, Long id);

    public List getRequestsByStatusAndRequestId(String status, Long id);

    public List getRequestsByState(String status);

    public List getQueriedRequests(QueryRequestForm queryRequestForm);

    public List getRequestByEmployeeId( Long id);

  }

