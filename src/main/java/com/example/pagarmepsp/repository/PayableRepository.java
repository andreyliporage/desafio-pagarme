package com.example.pagarmepsp.repository;

import com.example.pagarmepsp.domain.Payable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayableRepository extends JpaRepository<Payable, Long> {
}
