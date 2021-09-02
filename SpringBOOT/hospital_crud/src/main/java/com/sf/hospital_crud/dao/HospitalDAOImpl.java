package com.sf.hospital_crud.dao;

import com.sf.hospital_crud.entity.Hospitals;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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
    public Hospitals findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Hospitals theHospital = currentSession.get(Hospitals.class, theId);

        return theHospital;
    }

    @Override
    public void save(Hospitals theHospital) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theHospital);
    }

    @Override
    public void deleteById(int theId) {

    }
}
