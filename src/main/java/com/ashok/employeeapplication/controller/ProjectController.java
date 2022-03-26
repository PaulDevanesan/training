package com.ashok.employeeapplication.controller;

import com.ashok.employeeapplication.entity.Project;
import com.ashok.employeeapplication.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restapi/v1")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/project")
    public Project saveProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @GetMapping("/project/{id}")
    public Project getProject(@PathVariable("id") Integer projectId) {
        return projectService.getProject(projectId);
    }

    @GetMapping("/projects")
    public List<Project> getProjects(){
        return projectService.getProjects();
    }

    @PutMapping("/project")
    public Project updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }

    @DeleteMapping("/project/{id}")
    public void deleteProjectById(@PathVariable("id") Integer projectId){
        projectService.deleteProjectById(projectId);
    }

}
