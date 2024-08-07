package com.cbtc.cbtc.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbtc.cbtc.models.HistoricoBTCUSDModels;

@Repository
public interface HistoricoBTCUSDRepository extends JpaRepository<HistoricoBTCUSDModels, UUID>{
    
}
