
package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Admins,Long>{
    Admins findByUsername(String username);

}
