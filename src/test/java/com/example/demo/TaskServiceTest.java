package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.demo.repositories.TaskRepository;
import com.example.demo.services.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TaskServiceTest {
	
	@InjectMocks
	TaskService taskService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void createNewTask() throws Exception {

    }
    
    @Test
    public void getAllTask() throws Exception {

    }
    
    @Test
    public void findTaskById() throws Exception {

    }

    @Test
    public void findAllCompletedTask() throws Exception {

    }

    @Test
    public void findAllInCompleteTask() throws Exception {

    }

    @Test
    public void deleteTask() throws Exception {

  }
    
    @Test
    public void updateTask() throws Exception {

  }
    
}
