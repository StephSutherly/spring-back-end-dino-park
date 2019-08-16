package com.codeclan.dinopark.DinoPark.repositories.paddock_repository;

import com.codeclan.dinopark.DinoPark.models.Paddock;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class PaddockRepositoryImpl implements PaddockRepositoryCustom {

  @Autowired
  EntityManager entityManager;

  @Transactional
  public List<Paddock> findPaddocksWithDinosaursNamed(String name) {
    List<Paddock> result = null;

    Session session = entityManager.unwrap(Session.class);

    try {
      Criteria criteria =session.createCriteria(Paddock.class);
      criteria.createAlias("dinosaurs", "dinosaurAlias");
      criteria.add(Restrictions.eq("dinosaurAlias.name", name));

      result = criteria.list();
    } catch(HibernateException ex) {
      ex.printStackTrace();
    }

    return result;
  }
}
