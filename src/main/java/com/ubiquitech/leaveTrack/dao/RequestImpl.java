package com.ubiquitech.leaveTrack.dao;

import com.ubiquitech.leaveTrack.domain.Request;
import com.ubiquitech.leaveTrack.form.RequestQueryForm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List getQueriedRequests(RequestQueryForm requestQueryForm) {
        String state = requestQueryForm.getState();
        String leaveType = requestQueryForm.getLeaveType();
        String employeeFirstName = requestQueryForm.getEmployeeFirstName();
        String employeeLastName = requestQueryForm.getEmployeeLastName();
        String supervisorFirstName = requestQueryForm.getSupervisorFirstName();
        String supervisorLastName = requestQueryForm.getEmployeeLastName();
        Long requestId = requestQueryForm.getRequestId();

        Session session = sessionFactory.openSession();

        Criteria request = session.createCriteria(Request.class);
        Criteria employee = request.createCriteria("employee");
        Criteria supervisor = employee.createCriteria("supervisor");

        if (!state.equals("")) {
            request.add(Restrictions.and(Restrictions.eq("state", state)));
        }

        if (!leaveType.equals("")) {
            request.add(Restrictions.and(Restrictions.eq("leaveType", leaveType)));
        }

        if (!(requestId == null)) {
            request.add(Restrictions.and(Restrictions.eq("id", requestId)));
        }

        if (!employeeFirstName.equals("")) {
            employee.add(Restrictions.and(Restrictions.eq("firstName", employeeFirstName)));
        }

        if (!employeeLastName.equals("")) {
            employee.add(Restrictions.and(Restrictions.eq("lastName", employeeLastName)));
        }

        if (!supervisorFirstName.equals("")) {
            supervisor.add(Restrictions.and(Restrictions.eq("firstName", supervisorFirstName)));
        }

        if (!supervisorLastName.equals("")) {
            supervisor.add(Restrictions.and(Restrictions.eq("lastName", supervisorLastName)));
        }

        return request.list();
    }

}
