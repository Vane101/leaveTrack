package com.ubiquitech.leaveTrack.dao;

import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.form.QueryRequestForm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * vane created on 2014/12/08.
 */
@Repository
@SuppressWarnings("unchecked")
public class RequestImpl implements RequestDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createRequest(Request request) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(request);
    }

    @Override
    public List getRequestsByStatusAndSupervisorId(String state, Long id) {
        Session session = sessionFactory.openSession();
        Criteria request = session.createCriteria(Request.class);
        Criteria employee = request.createCriteria("employee");
        Criteria supervisor = employee.createCriteria("supervisor");
        supervisor.add(Restrictions.eq("id", id));
        request.add((Restrictions.eq("state", state)));
        return request.list();
    }

    @Override
    public List getRequestsByStatusAndRequestId(String state, Long id) {
        Session session = sessionFactory.openSession();
        Criteria request = session.createCriteria(Request.class);
        request.add(Restrictions.eq("id", id));

        if (!state.equals("")) {
            request.add(Restrictions.and(Restrictions.eq("state", state)));
        }
        return request.list();
    }

    @Override
    public List getRequestsByState(String state) {
        Session session = sessionFactory.openSession();
        Criteria request = session.createCriteria(Request.class);
        request.add(Restrictions.eq("state", state));
        return request.list();
    }

    @Override
    public List getQueriedRequests(QueryRequestForm queryRequestForm) {
        String state = queryRequestForm.getState();
        String leaveType = queryRequestForm.getLeaveType();
        String employeeName = queryRequestForm.getEmployeeName();
        String supervisorName = queryRequestForm.getSupervisorName();
        Long requestId = queryRequestForm.getRequestId();

        Map<String,Object> parms = new HashMap<String,Object>();
        StringBuffer hql= new StringBuffer("from Request state");
        boolean first=true;

        if (!state.equals("")) {
            hql.append(first ? " where " : " and ");
            hql.append("q.state = :state");
            parms.put("state",state);
            first=false;
        }

        if (!leaveType.equals("")) {
            hql.append(first ? " where " : " and ");
            hql.append("q.leaveType = :leaveType");
            parms.put("leaveType",leaveType);
            first=false;
        }

        if (!employeeName.equals("")) {
            hql.append(first ? " where " : " and ");
            hql.append("q.employee.employeeName = :employeeName");
            parms.put("employeeName",employeeName);
            first=false;
        }

        if (!supervisorName.equals("")) {
            hql.append(first ? " where " : " and ");
            hql.append("q.employee.supervisor.employeeName = :supervisorName");
            parms.put("supervisorName",supervisorName);
            first=false;
        }

        if (!(requestId ==null)) {
            hql.append(first ? " where " : " and ");
            hql.append("q.requestId = :requestId");
            parms.put("requestId",requestId);
            first=false;
        }

        org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
        for (String name : parms.keySet()) {
            Object value = parms.get(name);
            query.setParameter(name, value);
        }

        return query.list();
    }

    @Override
    public List getRequestByEmployeeId(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Request e where  e.employee.id = :val")
                .setParameter("val", id)
                .list();

    }

}
