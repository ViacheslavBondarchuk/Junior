package com.org.house.DB.Repository;

import com.org.house.DB.Entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepos extends JpaRepository<Contact, Long> {
    Contact findByEmail(String email);

}
