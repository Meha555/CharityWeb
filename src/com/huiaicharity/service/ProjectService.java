package com.huiaicharity.service;

import com.huiaicharity.entity.Activities;
import com.huiaicharity.entity.News;
import com.huiaicharity.entity.Projects;
import com.huiaicharity.mapper.ProjectsDao;

import java.util.ArrayList;

public class ProjectService {
    private ProjectsDao projectsDao=new ProjectsDao();
    public int addProjects(String name, String organizer, String start_date,String end_date,String aid){
        Projects projects=new Projects();
        projects.setPid(projectsDao.countAll()+1);
        projects.setName(name);
        projects.setOrganizer(organizer);
        projects.setStart_date(start_date);
        projects.setEnd_date(end_date);
        projects.setAid(aid);
        return projectsDao.insertProject(projects);
    }
    public int deleteProjects(int pid){
        return projectsDao.deleteProjectByPID(pid);
    }
    public ArrayList<Projects> showProjects(){
        return projectsDao.selectAll();
    }
    public int editProject(int pid,String name,String organizer,String start_time,String end_time) {
        Projects projects=projectsDao.selectByPid(pid);
        projects.setName(name);
        projects.setOrganizer(organizer);
        projects.setStart_date(start_time);
        projects.setEnd_date(end_time);
        return projectsDao.updateProjects(projects);
    }
}
