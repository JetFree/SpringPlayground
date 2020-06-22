package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.supportclasses.Customer_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> theQuery = session.createQuery("from Customer order by lastName",
                Customer.class);
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer theCustomer = currentSession.get(Customer.class, id);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
//        :parameter -> parameter that can be set
        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", theId);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> root =  criteriaQuery.from(Customer.class);
        criteriaQuery.select(root).where(
                criteriaBuilder.or(criteriaBuilder.equal(root.get(Customer_.FIRST_NAME), name),
                        criteriaBuilder.equal(root.get(Customer_.LAST_NAME), name)));
        List<Customer> customerList = currentSession.createQuery(criteriaQuery).getResultList();
        return customerList;
    }
}
