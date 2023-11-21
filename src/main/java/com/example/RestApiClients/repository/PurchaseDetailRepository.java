package com.example.RestApiClients.repository;

import com.example.RestApiClients.models.PurchaseDetail;
import com.example.RestApiClients.models.PurchaseDetailID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, PurchaseDetailID> {
}
