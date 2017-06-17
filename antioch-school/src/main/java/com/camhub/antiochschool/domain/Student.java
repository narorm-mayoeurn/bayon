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
    private Character gender;
    private Date birthDate;
    private String contactPhone;
    private String contactAddress;


    private Long currentClassroomId;
    private Long currentSessionId;
    private Long teacherId;
    private Date registeredDate;
    private Long payrollId;

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

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getCurrentClassroomId() {
        return currentClassroomId;
    }

    public void setCurrentClassroomId(Long currentClassroomId) {
        this.currentClassroomId = currentClassroomId;
    }

    public Long getCurrentSessionId() {
        return currentSessionId;
    }

    public void setCurrentSessionId(Long currentSessionId) {
        this.currentSessionId = currentSessionId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Long getPayRollNumber() {
        return payrollId;
    }

    public void setPayRollNumber(Long payrollId) {
        this.payrollId = payrollId;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }
}
