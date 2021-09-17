package com.sf.springboot.hospital.dao;

import com.sf.springboot.hospital.entity.Hospitals;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
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
    public List<String> findName(String data) {
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        String a[]=data.split(",");
//        int b[]=new int[2];
//        for(int i=0;i<a.length;i++){
//            b[i]=Integer.parseInt(a[i]);
//        }
//        int a1=0,a2=0;
//        a1=b[0];
//        a2=b[1];
//
//        NativeQuery res=currentSession.createSQLQuery("select h_name from Hospitals where h_id in (:id1,:id2)");
//
//        res.setParameter("id1",a1);
//        res.setParameter("id2",a2);
//
//        List<String> results=res.getResultList();
//
//        return results;


        Session currentSession = entityManager.unwrap(Session.class);

        List<String> results=new ArrayList<>();
        String a[]=data.split(",");
        int b[]=new int[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=Integer.parseInt(a[i]);
            NativeQuery res=currentSession.createSQLQuery("select h_name from Hospitals where h_id in (:data)");
            res.setParameter("data",b[i]);
            results.addAll(res.getResultList());
        }

        return results;

    }

    @Override
    @Transactional
    public Hospitals findContent(String data) {

        Session currentSession = entityManager.unwrap(Session.class);

        String a[]=data.split(",");
        int b[]=new int[2];
        for(int i=0;i<a.length;i++){
            b[i]=Integer.parseInt(a[i]);
        }
        int a1=0,a2=0;
        a1=b[0];
        a2=b[1];

        Hospitals theHospital = currentSession.get(Hospitals.class,a1);

        return theHospital;
    }

    @Override
    @Transactional
    public List<String> findCon(String data) {
        Session currentSession = entityManager.unwrap(Session.class);

//        String a[]=data.split(",");
//        int b[]=new int[2];
//        for(int i=0;i<a.length;i++){
//            b[i]=Integer.parseInt(a[i]);
//        }
//        int a1=0,a2=0;
//        a1=b[0];
//        a2=b[1];

        NativeQuery res=currentSession.createSQLQuery("select from Hospitals where h_id in (:id1,:id2)");

        res.setParameter("id1",data);
        res.setParameter("id2",data);

        List<String> results=res.getResultList();

        return results;
    }
}
