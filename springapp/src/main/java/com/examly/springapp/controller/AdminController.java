package com.examly.springapp.controller;

import java.util.List;

import com.examly.springapp.entity.LoanApplicationModel;
import com.examly.springapp.service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/getAllLoans")
    public ResponseEntity<List<LoanApplicationModel>> getAllLoans() {
        List<LoanApplicationModel> ls = loanService.getAllLoan();
        if (ls.size() <= 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(ls);
    }
}

