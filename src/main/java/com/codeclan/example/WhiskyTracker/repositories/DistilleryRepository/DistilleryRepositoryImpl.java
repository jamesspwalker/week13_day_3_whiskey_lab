package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Distillery> findDistilleriesbyRegion(String region) {
        List<Distillery> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Distillery.class);
//            cr.createAlias("regions", "regionAlias");
            cr.add(Restrictions.eq("region", region));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {


        }

        return result;
    }
}
