package com.application.covid.repo.db2;

import com.application.covid.Models.db2.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(
        value = "laptopRepo2"
)
public interface LaptopRepo extends JpaRepository<Laptop, Long> {
}
