package com.timetable.timetable.web.webapp;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.timetable.timetable.model.InvalidException;
import com.timetable.timetable.persist.ExamDAO;
import com.timetable.timetable.persist.ExamDAOImplement;
import com.timetable.timetable.service.ExamService;
import com.timetable.timetable.service.ExamServiceImplement;
import com.timetable.timetable.persist.StudentDAO;
import com.timetable.timetable.persist.StudentDAOImplement;
import com.timetable.timetable.service.StudentService;
import com.timetable.timetable.service.StudentServiceImplement;
import com.timetable.timetable.persist.SubjectDAO;
import com.timetable.timetable.persist.SubjectDAOImplement;
import com.timetable.timetable.service.SubjectService;
import com.timetable.timetable.service.SubjectServiceImplement;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.timetable.timetable.controller")
public class Webconfig  {
	 
    
    @Bean
    public StudentService StudentService() throws InvalidException {
        return new StudentServiceImplement(StudentDAO());
    }
    
    @Bean(value = "StudentDAO")
    public StudentDAO StudentDAO() throws InvalidException {
        return new StudentDAOImplement();
    }
    
    @Bean
    public SubjectService SubjectService() throws InvalidException {
        return new SubjectServiceImplement(SubjectDAO());
    }
    
    
    @Bean(value = "SubjectDAO")
    public SubjectDAO SubjectDAO() throws InvalidException {
        return new SubjectDAOImplement();
    }
 
    @Bean
    public ExamService ExamService() throws InvalidException {
        return new ExamServiceImplement(ExamDAO());
    }
    
    @Bean(value = "ExamDAO")
    public ExamDAO ExamDAO() throws InvalidException {
        return new ExamDAOImplement();
    }
    
    
    
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver result = new InternalResourceViewResolver();
        result.setViewClass(JstlView.class);
        result.setPrefix("/WEB-INF/");
        result.setSuffix(".html");
        return result;
    }
    
    
    
    
    
}