package com.camhub.antiochschool.domain;

/**
 * Created by darith on 6/15/17.
 */
public class Payroll {

    private Long id;
    private Long studentId;
    private String payrollNo;

    private Double tuitionFee;
    private Double adminstrationFee;
    private Double supplyFee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getPayrollNo() {
        return payrollNo;
    }

    public void setPayrollNo(String payrollNo) {
        this.payrollNo = payrollNo;
    }

    public Double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(Double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public Double getAdminstrationFee() {
        return adminstrationFee;
    }

    public void setAdminstrationFee(Double adminstrationFee) {
        this.adminstrationFee = adminstrationFee;
    }

    public Double getSupplyFee() {
        return supplyFee;
    }

    public void setSupplyFee(Double supplyFee) {
        this.supplyFee = supplyFee;
    }
}
