package com.camhub.antiochschool.domain;

import java.util.Date;

/**
 * Created by darith on 6/15/17.
 */
public class Invoice {

    private Long id;
    private Long studentId;
    private String invoiceNo;

    private Double tuitionFee;
    private Double administrationFee;
    private Double supplyFee;

    private Date invoiceDate;
    private Date startDate;
    private Date endDate;

    private Double totalDiscount;

    private Boolean archived = false;

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

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(Double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public Double getAdministrationFee() {
        return administrationFee;
    }

    public void setAdministrationFee(Double administrationFee) {
        this.administrationFee = administrationFee;
    }

    public Double getSupplyFee() {
        return supplyFee;
    }

    public void setSupplyFee(Double supplyFee) {
        this.supplyFee = supplyFee;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }
}
