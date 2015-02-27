package com.ubiquitech.leaveTrack.dao;

import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.form.QueryEmployeeForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * vane created on 2014/11/20.
 */
@Repository
@SuppressWarnings("unchecked")
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Employee) session.get(Employee.class, id);
    }

    @Override
    public List<Object[]> getEmployeeNames() {
        String hql = "select e.employeeName from Employee e";
        return (List<Object[]>) sessionFactory.getCurrentSession().createQuery(hql).list();
    }

    @Override
    public Boolean checkUsername(String userName) {
        List<Employee> results = sessionFactory.getCurrentSession()
                .createQuery("from Employee where username = :val")
                .setParameter("val", userName)
                .list();
        return !results.isEmpty();
    }

    @Override
    public Employee getEmployee(String username) {
        List<Employee> results = sessionFactory.getCurrentSession()
                .createQuery("from Employee where username = :val")
                .setParameter("val", username)
                .list();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List getQueriedEmployees(QueryEmployeeForm queryEmployeeForm) {
        String username = queryEmployeeForm.getUsername();
        String employeeName = queryEmployeeForm.getEmployeeName();
        String supervisorName = queryEmployeeForm.getSupervisorName();
        String jobTitle = queryEmployeeForm.getJobTitle();

        Map<String,Object> parms = new HashMap<String,Object>();
        StringBuffer hql= new StringBuffer("from Employee emp");
        boolean first=true;

        if (!username.equals("")) {
            hql.append(first ? " where " : " and ");
            hql.append("emp.username = :username");
            parms.put("username",username);
            first=false;
        }

        if (!employeeName.equals("")) {
            hql.append(first ? " where " : " and ");
            hql.append("emp.employeeName = :employeeName");
            parms.put("employeeName",employeeName);
            first=false;
        }

        if (!jobTitle.equals("")) {
            hql.append(first ? " where " : " and ");
            hql.append("emp.jobTitle = :jobTitle");
            parms.put("jobTitle",jobTitle);
            first=false;
        }

        if (!jobTitle.equals("")) {
            hql.append(first ? " where " : " and ");
            hql.append("emp.jobTitle = :jobTitle");
            parms.put("jobTitle",jobTitle);
            first=false;
        }

        if (!supervisorName.equals("")) {
            hql.append(first ? " where " : " and ");
            hql.append("emp.supervisor.employeeName = :supervisorName");
            parms.put("supervisorName",supervisorName);
            first=false;
        }
        org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
        for (String name : parms.keySet()) {
            Object value = parms.get(name);
            query.setParameter(name, value);
        }

          return query.list();
        }

}
