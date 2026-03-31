package org.dbms.dao;

import org.dbms.model.Patient;

import java.util.List;

public interface PatientDao {
    public boolean save(Patient p);

    public boolean delete(Patient p);

    public boolean update(Patient p);

    public Patient findById(Long id);

    public Patient findByPhone(String phone);

    public List<Patient> findByName(String name);
}
