package com.fishfarming.repository;


import com.fishfarming.model.Customer;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepo extends CommonRepo {

    public boolean customerSignUp(Customer customer) {
        Session session = getDbSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        return true;
    }

    public boolean userIdExists(String userId) {
        boolean exists = true;
        Session session = getDbSession();
        Customer customer = session.get(Customer.class, userId);
        if (null == customer) {
            exists = false;
        }
        return exists;
    }

    public int authenticate(Customer customer) {
           int loginState = 2; //un-authenticated
           Session session = getDbSession();
           Customer existingCustomer = session.get(Customer.class, customer.getLoginId());
           if(null == existingCustomer) {
                    loginState = 0; //doesn't exists
           } else if (existingCustomer.equals(customer)) {
               loginState = 1;
           }
           return loginState;
    }

}
