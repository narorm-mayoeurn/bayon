package com.camhub.antiochschool.domain;

import java.util.Date;

/**
 * Created by nm on 9/6/17.
 */
public class Student {

    private Long id;
    private String studentId;
    private String englishName;
    private String khmerName;
    private String gender;
    private Date birthDate;
    private Long classId;
    private String session;
    private String teacherName;
    private Date registeredDate;
    private Double schoolFee;
    private Double adminstrationFee;
    private Double suppliesFee;
    private String payRollNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getKhmerName() {
        return khmerName;
    }

    public void setKhmerName(String khmerName) {
        this.khmerName = khmerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Double getSchoolFee() {
        return schoolFee;
    }

    public void setSchoolFee(Double schoolFee) {
        this.schoolFee = schoolFee;
    }

    public Double getAdminstrationFee() {
        return adminstrationFee;
    }

    public void setAdminstrationFee(Double adminstrationFee) {
        this.adminstrationFee = adminstrationFee;
    }

    public Double getSuppliesFee() {
        return suppliesFee;
    }

    public void setSuppliesFee(Double suppliesFee) {
        this.suppliesFee = suppliesFee;
    }

    public String getPayRollNumber() {
        return payRollNumber;
    }

    public void setPayRollNumber(String payRollNumber) {
        this.payRollNumber = payRollNumber;
    }
}
