package com.examly.springapp.repoistories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.DocumentModel;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentModel, Integer> {
	// public DocumentModel findByLoanModelLoanId(int loanId);
}
