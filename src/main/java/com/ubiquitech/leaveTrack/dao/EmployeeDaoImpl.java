package com.ubiquitech.leaveTrack.dao;

import com.ubiquitech.leaveTrack.domain.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Iterator;
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
    public List<Object[]> getEmployeeNames() {
      List<Object[]> employees=null ;

        try {
            Session session = sessionFactory.openSession();
            Query q= session.createSQLQuery("select id,firstName,lastName from Employee");
            employees=q.list();

            }

        catch (Exception e) {
                     e.printStackTrace();
        }

       return employees;
    }

    @Override
    public Boolean checkUsername(String userName) {
        String sql_Query= String.format("select count(*) from Employee where(username='%s')", userName);
        Boolean found=false;
        Long count = null;
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query q= session.createQuery(sql_Query);
            for(Iterator it=q.iterate();it.hasNext();)
            {
             count = (Long) it.next();
             }
            session.getTransaction().commit();
            session.close();
             }

        catch (Exception e) {
            e.printStackTrace();
        }

        if (count==1){
            found=true;
        } else
        {
            found=false;
        }

          return found;
    }

    @Override
    public Employee getEmployee(String username) {
       String sql_Query= String.format("select id from Employee where(username='%s')", username);
       BigInteger id=null;
        Employee employee = null;
        List<Object[]> employees=null ;

        try {
            Session session = sessionFactory.openSession();
            Query q= session.createSQLQuery(sql_Query);
            List idList= q.list();
            id= (BigInteger)idList.get(0);
            }
        catch (Exception e) {
            e.printStackTrace();
             id=null;
        }
        if(id==null){
            id=BigInteger.valueOf(0);
        }
        assert id != null;
        Long Id=id.longValue();

        Session session=sessionFactory.openSession();
        employee =(Employee)session.get(Employee.class,Id);
        session.close();

         return employee;
    }

    @Override
    public String getSupervisorEmail(Long id) {
       String email="";
        String sql_Query= String.format("select email from Employee where(id='%s')", id);

        try {
            Session session = sessionFactory.openSession();
            Query q= session.createSQLQuery(sql_Query);
            List idList= q.list();
           email= (String)idList.get(0);
        }
        catch (Exception e) {
            e.printStackTrace();

        }

        return email;
    }

    @Override
    public String getEmployeeName(Long id) {
        String employeeName="";
        String sql_Query= String.format("select firstName,lastName from Employee where(id='%s')", id);

        try {
            Session session = sessionFactory.openSession();
            Query q= session.createSQLQuery(sql_Query);
            List idList= q.list();
            employeeName= (String)idList.get(0);
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();

        }

        return employeeName;
    }

}
