package com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository;

import com.codeclan.dinopark.DinoPark.models.Dinosaur;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;

public class DinosaurRepositoryImpl implements DinosaurRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Dinosaur> findDinosaurByPaddockId(Long id) {
        List <Dinosaur> result = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Dinosaur.class);
            criteria.createAlias("paddock", "paddockAlias");
            criteria.add(Restrictions.eq("paddockAlias.id", id));

            result = criteria.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
