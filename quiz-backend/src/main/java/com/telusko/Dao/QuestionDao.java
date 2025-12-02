package com.telusko.Dao;

import com.telusko.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    // ADD THIS FOR YOUR SERVICE
    List<Question> findByCategory(String category);

    // Your random question method (optional)
    @Query(value = "SELECT * FROM question WHERE LOWER(category) = LOWER(:category) ORDER BY RAND() LIMIT :numQ",
            nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category,
                                                 @Param("numQ") int numQ);

}
