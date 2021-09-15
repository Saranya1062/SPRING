package com.sf.hospital_crud.dao;

import com.sf.hospital_crud.entity.Hospitals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalDAOTest {

    @Autowired
    private HospitalDAOImpl hospitalDAO;

    @Test
    public void findAll() {
        List<Hospitals> hos=null;
        hos=hospitalDAO.findAll();
        assertEquals(5,hos.size());
        assertNotNull(hos);
    }

    @Test
    public void findById() {
        int hid=1;
        Hospitals hospitals=hospitalDAO.findById(hid);
        assertEquals(1,hospitals.getHid());
        assertNotNull(hospitals.getHid());
    }

    @Test
    public void save() {
       Hospitals hospitals=new Hospitals(6,"Apollo","Chennai");
       hospitalDAO.save(hospitals);
    }

//    @Test
//    public void save() {
//        Hospitals hospitals=new Hospitals(4,"Sri Hospital","Chennai");
//        Hospitals hos=hospitalDAO.save(hospitals);
//        assertEquals(hos,hospitals);
//    }
}
