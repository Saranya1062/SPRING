package com.sf.assignment.dao;

import com.sf.assignment.entity.Hospitals;

import java.util.List;
import java.util.Map;

public interface HospitalDAO {

    public List<Hospitals> findAll();

    public Hospitals listName(int hid);
}
