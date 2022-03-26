package com.ashok.employeeapplication.service;

import com.ashok.employeeapplication.entity.Project;
import com.ashok.employeeapplication.exception.ProjectNotFoundException;

import java.util.List;

public interface ProjectService {
    Project saveProject(Project project);

    Project getProject(Integer projectId) throws ProjectNotFoundException;

    List<Project> getProjects();

    Project updateProject(Project project);

    void deleteProjectById(Integer projectId);
}
