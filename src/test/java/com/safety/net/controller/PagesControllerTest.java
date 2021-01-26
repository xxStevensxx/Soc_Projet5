package com.safety.net.controller;

import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.HandlerAdapter;
//import org.springframework.web.servlet.ModelAndView;

import jdk.jfr.Name;


public class PagesControllerTest {
	
	@InjectMocks
	private ApplicationContext applicationContext;
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private HandlerAdapter handlerAdaptater;
	private PagesController pagesController;
	
	@BeforeAll
	public void setUp() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		handlerAdaptater = applicationContext.getBean(HandlerAdapter.class);
		pagesController = new PagesController();
	}

//	@Test
	@Name("Test du controller pour la redirection vers les données de l'utilisateurs")
	public void homeTest() throws Exception {
		
		//GIVEN
		request.setRequestURI("/");
//		final ModelAndView modelAndView = handlerAdaptater.handle(request, response, pagesController);
		
		//WHEN
		
		
		//THEN
		/*
		 * assertViewName(modelAndView, null);
		 * assertAndReturnModelAttributeOfType(modelAndView, "image", Image.class);
		 */
		
	}
}
