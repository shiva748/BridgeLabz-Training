package org.dbms.dao;

import org.dbms.model.Patient;

public interface PatientDao {
    public boolean save(Patient p);

    public boolean delete(Patient p);

    public boolean update(Patient p);

    public Patient findById(Long id);
}
