package org.dbms;

import org.dbms.model.Patient;
import org.dbms.service.PatientService;
import org.dbms.utils.InputUtils;

import java.util.Scanner;

public class Main {
    static PatientService patientService;
    static {
        patientService = new PatientService();
    }
    static  void printOptions(){
        System.out.println("Please select a option.");
        System.out.println("Add Patient:- ( 1 )");
        System.out.println("Close Application:- ( -1 )");
    }
    public static void main(String[] args) {
        Patient p = new Patient();
        Scanner sc = InputUtils.sc;
        Boolean run  = true;
        while (run) {
            printOptions();
            String choice = sc.nextLine();
            switch (choice) {
                case "1":{
                    Patient p1 = InputUtils.read(Patient.class);
                    patientService.addPatient(p1);
                    break;
                } case "-1":{
                    run = false;
                    break;
                } default:{
                    System.out.println("Wrong choice.");
                }
            }
        }
    }
}
