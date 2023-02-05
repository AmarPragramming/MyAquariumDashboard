package com.fishfarming.repository;

import com.fishfarming.model.ItemCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InitialDataRepo extends  CommonRepo{


    public boolean addCategory(List<ItemCategory> categories) {
        Session session = getDbSession();
        session.beginTransaction();
        for (ItemCategory category: categories) {
            session.save(category);
        }
        session.getTransaction().commit();

        return true;
    }

}
