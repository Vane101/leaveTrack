package com.ubiquitech.leaveTrack.services;


import com.ubiquitech.leaveTrack.dao.RequestDao;
import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.form.RequestQueryForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by vane on 2014/12/08.
 */
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestDao requestDao;

       @Override
    public void createRequest(Request request) {
        requestDao.createRequest(request);
    }

    @Override
    public List getRequestsByStatusAndSupervisorId(String status, Long id) {
       return requestDao.getRequestsByStatusAndSupervisorId(status,id);
    }

    @Override
    public List getRequestsByStatusAndRequestId(String status,Long id) {
        return requestDao.getRequestsByStatusAndRequestId(status,id);
    }

    @Override
    public List getRequestsByState(String state) {
        return requestDao.getRequestsByState(state);
    }

    @Override
    public List getQueriedRequests(RequestQueryForm requestQueryForm) {
        return requestDao.getQueriedRequests(requestQueryForm);
    }
}


