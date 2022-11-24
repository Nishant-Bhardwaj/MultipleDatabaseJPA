package com.application.covid.repo.db1;

import com.application.covid.Modles.db1.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(
        value = "laptopRepo1"
)
public interface LaptopRepo extends JpaRepository<Laptop, Long> {
}
