package com.examly.springapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LoanApplicationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanId;

    private String loanType;
    private String applicantName;
    private String applicantAddress;
    private String applicantMobile;
    private String applicantEmail;
    private String applicantAadhar;
    private String applicantPan;
    private String applicantSalary;
    private String loanAmountRequired;
    private String loanRepaymentMonths;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public LoanApplicationModel() {
    }

    public LoanApplicationModel(String applicantName, String applicantAddress,
            String applicantMobile, String applicantEmail, String applicantAadhar, String applicantPan,
            String applicantSalary) {
        this.applicantName = applicantName;
        this.applicantAddress = applicantAddress;
        this.applicantMobile = applicantMobile;
        this.applicantEmail = applicantEmail;
        this.applicantAadhar = applicantAadhar;
        this.applicantPan = applicantPan;
        this.applicantSalary = applicantSalary;       
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantAadhar() {
        return applicantAadhar;
    }

    public void setApplicantAadhar(String applicantAadhar) {
        this.applicantAadhar = applicantAadhar;
    }

    public String getApplicantPan() {
        return applicantPan;
    }

    public void setApplicantPan(String applicantPan) {
        this.applicantPan = applicantPan;
    }

    public String getApplicantSalary() {
        return applicantSalary;
    }

    public void setApplicantSalary(String applicantSalary) {
        this.applicantSalary = applicantSalary;
    }

    public String getLoanAmountRequired() {
        return loanAmountRequired;
    }

    public void setLoanAmountRequired(String loanAmountRequired) {
        this.loanAmountRequired = loanAmountRequired;
    }

    public String getLoanRepaymentMonths() {
        return loanRepaymentMonths;
    }

    public void setLoanRepaymentMonths(String loanRepaymentMonths) {
        this.loanRepaymentMonths = loanRepaymentMonths;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

