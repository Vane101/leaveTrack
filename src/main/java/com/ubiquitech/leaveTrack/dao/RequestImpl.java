package com.ubiquitech.leaveTrack.dao;

import com.ubiquitech.leaveTrack.domain.Request;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vane on 2014/12/08.
 */

@Repository
@Transactional
public class RequestImpl implements RequestDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createRequest(Request request) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(request);

    }

    @Override
    public List getRequestsByStatusAndSupervisorId(String status, Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Request where supervisorId= :id and status=:status");
        query.setLong("id", id);
        query.setString("status",status);
        return query.list();
    }

    @Override
    public List getRequestsByStatusAndRequestId(String status, Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Request where id= :id and status=:status");
        query.setLong("id", id);
        query.setString("status",status);
       return  query.list();
    }

}
