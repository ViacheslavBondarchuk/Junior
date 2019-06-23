package com.org.house.DB.Repository;

import com.org.house.DB.Entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepos extends JpaRepository<Phone, Long> {
}
