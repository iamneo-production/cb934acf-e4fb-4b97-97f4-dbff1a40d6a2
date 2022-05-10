package com.examly.springapp.service;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.DocumentModel;
import com.examly.springapp.entity.LoanApplicationModel;
import com.examly.springapp.entity.User;
import com.examly.springapp.repository.DocumentRepository;
import com.examly.springapp.repository.LoanRepository;
import com.examly.springapp.repository.UserRepo;

@Service
public class AdminService {
	
	@Autowired
	private LoanRepository loanRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private DocumentRepository docRepo;
	
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
        loan.setLoanId(id);
        if(loan.getLoanType().toLowerCase().equals("approve")) {
			double emi = Integer.valueOf(loan.getLoanAmountRequired())/Integer.valueOf(loan.getLoanRepaymentMonths());
	    	loan.setMonthlyEmi(emi);
		}else {
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

