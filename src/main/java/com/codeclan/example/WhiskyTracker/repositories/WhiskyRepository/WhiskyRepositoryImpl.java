package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Whisky> getAllWhiskiesByYear(int year) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
//            cr.createAlias("regions", "regionAlias");
            cr.add(Restrictions.eq("year", year));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {


        }

        return result;
    }

    @Override
    @Transactional
    public List<Whisky> getAllWhiskiesFromDistilleryByAge(String distillery, int age) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distilleryAlias");
            cr.add(Restrictions.eq("distilleryAlias.name", distillery));
            cr.add(Restrictions.eq("age", age));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {


        }

        return result;
    }
}
