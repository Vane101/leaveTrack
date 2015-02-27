package com.ubiquitech.leaveTrack.services;


import com.ubiquitech.leaveTrack.dao.RequestDao;
import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.form.QueryRequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * vane created on 2014/12/08.
 */
@Service("requestService")
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestDao requestDao;

    @Transactional
    @Override
    public void createRequest(Request request) {
        requestDao.createRequest(request);
    }

    @Override
    public List getRequestsByStatusAndSupervisorId(String status, Long id) {
        return requestDao.getRequestsByStatusAndSupervisorId(status, id);
    }

    @Override
    public List getRequestsByStatusAndRequestId(String status, Long id) {
        return requestDao.getRequestsByStatusAndRequestId(status, id);
    }

    @Override
    public List getRequestsByState(String state) {
        return requestDao.getRequestsByState(state);
    }

    @Override
    public List getQueriedRequests(QueryRequestForm queryRequestForm) {
        return requestDao.getQueriedRequests(queryRequestForm);
    }

    @Override
    public List getRequestByEmployeeId(Long id) {
        return requestDao.getRequestByEmployeeId(id);
    }


}


