package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.controller.CrudController;
import com.example.demo.domain.User;
import com.example.demo.service.CrudServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerUnitTests {
	
	//run before tests
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	//Mark a field as a mock.
	@Mock
	CrudServiceImpl crudServiceImpl;
	
	@InjectMocks
	CrudController crudController;

	private Dummy dummy = new Dummy();
	private User user = new User();
	long id=1;
	
	
	@Test
	public void getUsers() {
		List<User> users = dummy.getUsersDomainDummy();
		when(crudServiceImpl.getUsers()).thenReturn(users);
		assertNotNull(crudController.getUsers());
		
	}
	
	@Test
	public void getById() {
		User user = dummy.getUserDomainDummy();
		when(crudServiceImpl.getById(id)).thenReturn(user);
		assertNotNull(crudController.getById(id));
	}
	
	@Test
	public void addNewUser() {
		doNothing().when(crudServiceImpl).addNewUser(user);
		assertNotNull(crudController.addNewUser(user));
	}
	
	@Test
	public void updateById() {
		doNothing().when(crudServiceImpl).updateById(id, user);
		assertNotNull(crudController.updateById(id, user));
	}
	
	@Test
	public void deleteById() {
		doNothing().when(crudServiceImpl).deleteById(id);
		assertNotNull(crudController.deleteById(id));
	}

	/*@Test
	public void test() {
		Dummy2 dummyMethod = new Dummy2();
		dummyMethod.getUserModelDummy();
		System.err.println(dummyMethod);
		
		doNothing().when(crudServiceImpl).deleteById(id);
		assertNotNull(crudController.deleteById(id));
	}*/
}
