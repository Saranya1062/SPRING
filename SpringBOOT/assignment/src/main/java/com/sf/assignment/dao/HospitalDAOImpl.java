package com.sf.assignment.dao;

import com.sf.assignment.entity.Hospitals;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public class HospitalDAOImpl implements HospitalDAO{

    private EntityManager entityManager;

    @Autowired
    public HospitalDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Hospitals> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Hospitals> theQuery = currentSession.createQuery("from Hospitals", Hospitals.class);

        List<Hospitals> hospitals = theQuery.getResultList();

        return hospitals;
    }

    @Override
    public Hospitals listName(int hid) {

        Session currentSession = entityManager.unwrap(Session.class);

        Hospitals theHospital = currentSession.get(Hospitals.class, hid);

        return theHospital;
    }
}
