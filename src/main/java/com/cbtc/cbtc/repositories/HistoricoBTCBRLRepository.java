package com.cbtc.cbtc.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbtc.cbtc.models.HistoricoBTCBRLModels;

@Repository
public interface HistoricoBTCBRLRepository extends JpaRepository<HistoricoBTCBRLModels, UUID>{

}
