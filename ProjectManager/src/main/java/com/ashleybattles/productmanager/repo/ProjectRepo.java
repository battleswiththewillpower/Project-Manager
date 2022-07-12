package com.ashleybattles.productmanager.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ashleybattles.productmanager.models.Project;

public interface ProjectRepo extends CrudRepository<Project, Long> {
	List<Project> findAll();

}
