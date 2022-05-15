package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.repository.LoanRepository;
import com.examly.springapp.repository.DocumentRepository;
import com.examly.springapp.repository.UserRepo;
import com.examly.springapp.entity.LoanApplicationModel;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.examly.springapp.entity.DocumentModel;

@Service
public class AdminService {
    
    @Autowired
    private LoanRepository loanRepo;

    @Autowired
    private DocumentRepository docRepo;

    @Autowired
    private UserRepo userRepo;

    public LoanApplicationModel approveLoan(LoanApplicationModel loan) {
		if(loan.getLoanType().equals("Approve")) {
			double emi = Integer.valueOf(loan.getLoanAmountRequired())/Integer.valueOf(loan.getLoanRepaymentMonths());
	    	loan.setMonthlyEmi(emi);
		}else {
			loan.setMonthlyEmi(0);
		}
		
    	return loanRepo.save(loan);
    }
	public byte[] verifyDocuments(DocumentModel data,HttpServletResponse request) {

	        DocumentModel doc = docRepo.getLoanByLoanId(data.getLoan().getLoanId());
	        System.out.println("Doc contains: ");
	        System.out.println(doc);

	        request.setHeader("Content-Disposition", "attachment; filename=" + doc.getFileName());
	        return doc.getData();
	    
	}
	public void editLoan(LoanApplicationModel loan, int id) {
		LoanApplicationModel ln=loanRepo.getLoanByLoanId(id);
        ln.setLoanId(id);
        if(loan.getLoanType().toLowerCase().equals("approve")) {
			ln.setLoanType("approve");
			double emi = Integer.valueOf(loan.getLoanAmountRequired())/Integer.valueOf(loan.getLoanRepaymentMonths());
	    	ln.setMonthlyEmi(emi);
		}
		else if(loan.getLoanType().toLowerCase().equals("reject")){
			ln.setLoanType("reject");
			ln.setMonthlyEmi(0);
		}
		else {
			ln.setLoanType("pending");
			loan.setMonthlyEmi(0);
		}
        loanRepo.save(loan);
    }

    public void deleteLoan(int id) {

        loanRepo.deleteById(id);
    }
    public List<LoanApplicationModel> getAllLoans() {
        return loanRepo.findAll();
    }
	public LoanApplicationModel getLoanById(int loanId) {
    	return loanRepo.getLoanByLoanId(loanId);
    }
    
    
    public LoanApplicationModel generateSchedule(int loanId) {
    	LoanApplicationModel ln = loanRepo.getLoanByLoanId(loanId);
    	double emi = Integer.valueOf(ln.getLoanAmountRequired())/Integer.valueOf(ln.getLoanRepaymentMonths());
    	ln.setMonthlyEmi(emi);
    	return loanRepo.save(ln);
    }
	
    public LoanApplicationModel editSchedule(LoanApplicationModel loan, int loanId) {
    	
    	double emi = Integer.valueOf(loan.getLoanAmountRequired())/Integer.valueOf(loan.getLoanRepaymentMonths());
    	loan.setMonthlyEmi(emi);
    	return loanRepo.save(loan);
    }

    public void deleteSchedule(int loanId) {
    	LoanApplicationModel ln = loanRepo.getLoanByLoanId(loanId);
    	ln.setMonthlyEmi(0);
        loanRepo.save(ln);
    }
}
