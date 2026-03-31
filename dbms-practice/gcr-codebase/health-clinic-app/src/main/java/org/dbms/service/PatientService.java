package org.dbms.service;

import org.dbms.dao.PatientDao;
import org.dbms.dao.PatientDaoImpl;
import org.dbms.model.Patient;

import java.util.ArrayList;
import java.util.List;

import static org.dbms.utils.InputUtils.*;

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

    public void updatePatient(String searchParam, boolean isPhone) {
        Patient p;
        if(isPhone){
            p = searchPatientByPhone(searchParam);
        }else{
            p = searchPatientById(Long.parseLong(searchParam));
        }
        if(p==null){
            System.out.print("Patient Not Found.");
            return;
        }
        System.out.print(p);
        System.out.print("\nWould you like to update? (y/n): ");
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("y")){
            Patient updated = read(Patient.class);
            updated.setId(p.getId());
            if(patientDao.update(updated)){
                System.out.println("Patient has been updated successfully");
            }
        }
    }
    public void searchPatient(String query, String searchParam ){
        switch (searchParam){
            case "Phone":{
                Patient p = searchPatientByPhone(query);
                System.out.println(p);
                break;
            } case "Id":{
                Patient p = searchPatientById(Long.parseLong(query));
                System.out.print(p);
                break;
            }case "Name":{
                List<Patient> patients = patientDao.findByName(query);
                System.out.println(patients);
                break;
            } default:{
                System.out.print("Invalid search parameter");
            }
        }
    }

    private Patient searchPatientById(Long id) {
        return patientDao.findById(id);
    }

    private Patient searchPatientByPhone(String phone) {
        return patientDao.findByPhone(phone);
    }
}
