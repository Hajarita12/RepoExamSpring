package com.machmoum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.machmoum.dao.IDao;
import com.machmoum.entities.Employe;
import com.machmoum.entities.Service1;
import com.machmoum.repository.EmployeRepository;




@Service
public class EmployeService implements IDao<Employe>{
	@Autowired
	private EmployeRepository employeRepository;

	

	@Override
	public Employe create(Employe o) {
		return employeRepository.save(o);
	}

	@Override
	public boolean delete(Employe o) {
		try {
			employeRepository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
    public Employe update(Long id,Employe o) {
        
        return employeRepository.save(o);
    }

	@Override
	public List<Employe> findAll() {
		
		return employeRepository.findAll();
	}

	@Override
	public Employe findById(Long id) {
		return employeRepository.findById(id).orElse(null);
	}	
	
	
	public List<Employe> FindEmployeesByService(Service1 service){
		return employeRepository.findByService(service);
	}
}