package com.examly.springapp.repository;

import com.examly.springapp.entity.DocumentModel;
import com.examly.springapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentModel,Integer>{
    @Query("select l from DocumentModel l where l.user=:user")
    List<DocumentModel> findByUser(User user);
}
