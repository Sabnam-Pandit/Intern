/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentform.studentform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
//import javax.faces.application.FacesMessage;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
//import  javax.faces.bean.ViewScoped;
//import javax.inject.Named;
//import javax.inject.Named;

/**
 *
 * @author Sabnam
 */

@ManagedBean(name="st")
//@Named
@SessionScoped
//implements Serializable
public class Student implements Serializable
{
    
    private String firstname,lastname,middlename;
    private String faculty, program;
    private  Map<String,Map<String,String>> data= new HashMap<>();
  
    //list of faculty for dropdown list
    private Map <String, String> facultyOptions;
    private Map <String, String> programOptions;
    private ArrayList<Student> studentList;
    //Getter and setter methods
  //  private String HashMap;
  

    public Student() {
      //  this.data = new HashMap<>();
    }

   

    public Map<String, String> getFacultyOptions() {
        return facultyOptions;
    }
    

    public void setFacultyOptions(Map<String, String> facultyOptions) {
        this.facultyOptions = facultyOptions;
    }

    public Map<String, String> getProgramOptions() {
        return programOptions;
    }

    public void setProgramOptions(Map<String, String> programOptions) {
        this.programOptions = programOptions;
    }
        
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    
    
    
    // constructor sets the value of faculty and program option
  @PostConstruct
    public void init(){
        
        studentList=new ArrayList<>();
        facultyOptions = new HashMap<String,String>();
        facultyOptions.put("Management","Management");
        facultyOptions.put("Science and Technology", "Science and Technology");
        
                
        Map <String, String> map = new HashMap<String,String>();
        map.put("BBA","BBA");
        map.put("BBS", "BBS");
        data.put("Management", map);
        
        map = new HashMap <String, String>();
        map.put("BSc CSIT", "BSc CSIT");
        map.put("BE Comp.","BE Comp.");
        map.put("BCA","BCA");
        data.put("Science and Technology",map);
    }
    public Map<String,Map<String,String>> getData(){
        return data;
    }
    
    // method to change program values on selection of faculty
    public void onFacultyChange(){
        if(faculty != null && !faculty.equals(""))
            programOptions = data.get(faculty);
        else
            programOptions = new HashMap<>();
               
    } 
    
    
     public void save() {

        Student student = new Student();

        student.setFirstname(firstname);
        student.setMiddlename(middlename);
        student.setLastname(lastname);
        student.setFaculty(faculty);
        student.setProgram(program);
        studentList.add(student);
        
        
        firstname=null;
        middlename=null;
        lastname=null;
        faculty=null;
        onFacultyChange();
        program=null;
    }

    public void delete(Student student) {
        studentList.remove(student);
    }

    public void edit(Student student) {
        firstname = student.firstname;
        middlename = student.middlename;
        lastname = student.lastname;
        faculty = student.faculty;
        onFacultyChange();
        program = student.program;
        delete(student);
    }

    
}

 

  
   
    




  
