package com.trialdex.dex.repositories;

import com.trialdex.dex.models.Trial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrialRepository extends JpaRepository<Trial, Long> {

    List<Trial> findTrialsByOwnerId(Long ownerId);
}
