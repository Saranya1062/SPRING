package com.sf.hospital_crud.service;

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
public class HospitalServiceTest {

    @Autowired
    private HospitalServiceImpl hospitalService;

    @Test
    public void findAll() {
        List<Hospitals> hos=null;
        hos=hospitalService.findAll();
        assertEquals(5,hos.size());
        assertNotNull(hos);
    }

    @Test
    public void findById() {
        int hid=1;
        Hospitals hospitals=hospitalService.findById(hid);
        assertEquals(1,hospitals.getHid());
        assertNotNull(hospitals.getHid());
    }

//    @Test
//    public void save() {
//        Hospitals hospitals=new Hospitals(4,"KMCH","Chennai");
//        hospitalService.save(hospitals);
//    }

    @Test
    public void save() {
        Hospitals hospitals=new Hospitals(3,"AC Hospital","Coimbatore");
        Hospitals hos=hospitalService.save(hospitals);
        assertEquals(hos,hospitals);
    }
}
