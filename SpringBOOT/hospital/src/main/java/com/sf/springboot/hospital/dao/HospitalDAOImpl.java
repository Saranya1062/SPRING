package com.sf.springboot.hospital.dao;

import com.sf.springboot.hospital.entity.Hospitals;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Repository
public class HospitalDAOImpl implements HospitalDAO {

    private EntityManager entityManager;

    @Autowired
    public HospitalDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Hospitals> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Hospitals> theQuery =
                currentSession.createQuery("from Hospitals", Hospitals.class);

        List<Hospitals> hospitals = theQuery.getResultList();

        return hospitals;
    }

    @Override
    @Transactional
    public Hospitals findName(int h_id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Hospitals theHospital = currentSession.get(Hospitals.class, h_id);

        return theHospital;
    }

    @Override
    public Hospitals findById(int hid) {

        Session currentSession = entityManager.unwrap(Session.class);

        Hospitals theHospital = currentSession.get(Hospitals.class, hid);

        return theHospital;
    }

}
