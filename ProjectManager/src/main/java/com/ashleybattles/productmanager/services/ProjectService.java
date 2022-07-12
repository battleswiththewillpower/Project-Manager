package com.ashleybattles.productmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashleybattles.productmanager.models.Project;
import com.ashleybattles.productmanager.repo.ProjectRepo;



@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepo projectRepo;
	
	public Project save(Project a) {
		return projectRepo.save(a);
	}
	
	public List<Project> getAll(){
		return projectRepo.findAll();
	}
	
	public Project getOne(Long id) {
		Optional<Project> a = projectRepo.findById(id);
		
		if(a.isPresent()) {
			return a.get();
		}else {
			return null;
		}
	}
	
	public void delete(Long id) {
		projectRepo.deleteById(id);
	}

}
