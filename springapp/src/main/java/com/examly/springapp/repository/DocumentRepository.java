package com.examly.springapp.repository;

import com.examly.springapp.entity.DocumentModel;
import com.examly.springapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentModel,Integer>{
    @Query(value =  "select * From document_model WHERE loan_id=:id", nativeQuery = true)
    public DocumentModel getLoanByLoanId(@Param("id") int loanId);
}
