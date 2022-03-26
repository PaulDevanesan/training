package com.ashok.employeeapplication.service.Impl;

import com.ashok.employeeapplication.entity.Project;
import com.ashok.employeeapplication.exception.ProjectNotFoundException;
import com.ashok.employeeapplication.repository.ProjectRepository;
import com.ashok.employeeapplication.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProject(Integer projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        if(project.isPresent()) {
            return project.get();
        }
        else {
            throw new ProjectNotFoundException("Project not found for this id");
        }
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Project project) {
        Project existingProject = getProject(project.getProjectId());
        existingProject.setEmployeeName(project.getEmployeeName() != null ? project.getEmployeeName() : existingProject.getEmployeeName());
        existingProject.setDepartmentId(project.getDepartmentId() != null ? project.getDepartmentId() : existingProject.getDepartmentId());
        return projectRepository.save(existingProject);
    }

    @Override
    public void deleteProjectById(Integer projectId) {
        projectRepository.deleteById(projectId);
    }
}
