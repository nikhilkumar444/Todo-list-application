package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.demo.controllers.TaskController;
import com.example.demo.services.TaskService;
import com.example.demo.models.Task;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TaskControllerTest {
	
	 private MockMvc mockMvc;

	    @InjectMocks
	    TaskController taskController;

	    @Mock
	    TaskService taskService;

	    @Before
	    public void setUp() throws Exception {
	        this.mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
	    }
	    
	    @Test
	    public void getAllCompletedTasks() throws Exception {
	        List<Task> todos = new ArrayList<>();
	        when(taskService.getAllTask()).thenReturn(todos);

	        mockMvc.perform(
	                get("/completed")
	        )
	                .andExpect(model().attribute("todos", equalTo(todos)))
	                .andExpect(view().name("completed"));
	    }
	    
	    @Test
	    public void getAllIncompleteTasks() throws Exception {
	        List<Task> todos = new ArrayList<>();
	        when(taskService.getAllTask()).thenReturn(todos);

	        mockMvc.perform(
	                get("/incomplete")
	        )
	                .andExpect(model().attribute("todos", equalTo(todos)))
	                .andExpect(view().name("incomplete"));
	    }
	    
	    @Test
	    public void createTask() throws Exception {
	        List<Task> todos = new ArrayList<>();
	        when(taskService.getAllTask()).thenReturn(todos);

	        mockMvc.perform(
	                get("/")
	        )
	                .andExpect(model().attribute("todos", equalTo(todos)))
	                .andExpect(view().name(""));
	    }

	    @Test
	    public void updateTask() throws Exception {
	        mockMvc.perform(
	                post("/")
	                        .param("task")
	        )
	                .andExpect(flash().attribute("taskcompletetrue", "Complete the GFG Article & Publish it as soon as possible"))
	                .andExpect(redirectedUrl("/{id}"));

	        verify(taskService).findAllCompletedTask();
	    }
	    
	    @Test
	    public void getAllTasks() throws Exception {
	        mockMvc.perform(
	                post("/")
	                        .param("task")
	        )
	                .andExpect(flash().attribute("taskcompletetrue", ""))
	                .andExpect(redirectedUrl("/{id}"));

	        verify(taskService).findAllCompletedTask();
	    }

}
