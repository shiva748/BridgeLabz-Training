package org.dbms;

import org.dbms.model.Patient;
import org.dbms.service.PatientService;
import org.dbms.utils.InputUtils;

import java.util.List;
import java.util.Scanner;

public class Main {
    static PatientService patientService;
    static {
        patientService = new PatientService();
    }
    static  void printOptions(){
        System.out.println("Please select a option.");
        System.out.println("Add Patient:- ( 1 )");
        System.out.println("Update Patient:- ( 2 )");
        System.out.println("Search Patient:- ( 3 )");
        System.out.println("Close Application:- ( -1 )");
    }
    public static void main(String[] args) {
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
                } case "2":{
                  System.out.print("Search Patient To Update By? (Phone/Id): ");
                  String param = sc.nextLine();
                  if(param.equals("phone")){
                      System.out.print("Enter Patient Phone Number: ");
                  }else if(param.equals("id")){
                      System.out.print("Enter Patient Id: ");
                  }else{
                      System.out.println("Invalid Input");
                      break;
                  }
                  patientService.updatePatient(sc.nextLine(), param.equals("phone"));
                  break;
                } case "3":{
                  System.out.print("Search Patient Record By? (Name/Id/Phone): ");
                  String param = sc.nextLine();
                  if(!List.of("Name", "Id", "Phone").contains(param)){
                      System.out.println("Invalid Input");
                      break;
                  }
                  System.out.printf("Enter Patient's %s: ",  param);
                  String query = sc.nextLine();
                  patientService.searchPatient(query, param);
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
