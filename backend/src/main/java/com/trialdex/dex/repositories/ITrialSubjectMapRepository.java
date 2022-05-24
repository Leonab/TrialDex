package com.trialdex.dex.repositories;

import com.trialdex.dex.models.TrialSubjectMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrialSubjectMapRepository extends JpaRepository<TrialSubjectMap, Long> {

}
