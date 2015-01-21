package com.ubiquitech.leaveTrack.dao;

import com.ubiquitech.leaveTrack.domain.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vane on 2014/11/20.
 */
@Repository
@Transactional
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
        Session session = sessionFactory.openSession();
        Employee employee=(Employee) session.get(Employee.class,id);
        session.close();
        return employee;
    }

    @Override
    public List<Object[]> getEmployeeNames() {
      List<Object[]> employees=null ;
        Session session = sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Employee.class);
        ProjectionList projectionList= Projections.projectionList();
        projectionList.add(Projections.property("id"));
        projectionList.add(Projections.property("firstName"));
        projectionList.add(Projections.property("lastName"));
        criteria.setProjection(projectionList);
        employees=criteria.list();
        session.close();
        return employees;
    }

    @Override
    public Boolean checkUsername(String userName) {
        Boolean found=true;
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.eq("username", userName));
        found = !criteria.list().isEmpty();
        session.close();
        return found;
    }

    @Override
    public Employee getEmployee(String username) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.eq("username", username));
        Employee employee =(Employee)criteria.list().get(0);
        session.close();
        return employee;
    }

}
