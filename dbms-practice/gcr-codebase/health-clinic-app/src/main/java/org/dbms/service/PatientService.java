package org.dbms.service;

import org.dbms.dao.PatientDao;
import org.dbms.dao.PatientDaoImpl;
import org.dbms.model.Patient;

public class PatientService {
    private PatientDao patientDao;
    public PatientService() {
        patientDao = new PatientDaoImpl();
    }

    public void addPatient(Patient p) {
        if(patientDao.save(p)){
            System.out.println("Patient has been saved successfully");
        }else{
            System.out.println("Patient has not been saved successfully");
        }
    }
}
