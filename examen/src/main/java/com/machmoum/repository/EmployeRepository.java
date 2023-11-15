package com.machmoum.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.machmoum.entities.Employe;
import com.machmoum.entities.Service1;


@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
	public List<Employe> findByService(Service1 service);


}
