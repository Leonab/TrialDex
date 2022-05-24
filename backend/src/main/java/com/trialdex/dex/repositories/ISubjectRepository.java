package com.trialdex.dex.repositories;

import com.trialdex.dex.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long> {

    Subject findSubjectById(Long id);

    @Query("select s from Subject s JOIN s.belongsTo tsm JOIN tsm.trial t where t.id = ?1")
    List<Subject> findSubjectsByTrialId(Long id);
}
