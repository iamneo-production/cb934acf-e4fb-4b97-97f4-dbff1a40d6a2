package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;
import java.util.List;
import com.examly.springapp.entity.LoanApplicationModel;
import com.examly.springapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface LoanRepository extends JpaRepository<LoanApplicationModel, Integer> {

    public LoanApplicationModel getLoanByLoanId(int loanId);

    @Query("select l from LoanApplicationModel l where l.user=:user")
    List<LoanApplicationModel> findByUser(User user);
}
