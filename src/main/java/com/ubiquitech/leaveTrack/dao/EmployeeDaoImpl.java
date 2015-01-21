package com.ubiquitech.leaveTrack.dao;

import com.ubiquitech.leaveTrack.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vane on 2014/11/20.
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
        return (Employee) session.get(Employee.class,id);
    }

    @Override
    public List<Object[]> getEmployeeNames() {
        String hql = "select e.id, e.firstName, e.lastName from Employee e";
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

}
