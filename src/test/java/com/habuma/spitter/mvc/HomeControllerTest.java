package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author ralvarado
 */
public class HomeControllerTest {
    
    public HomeControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of showHomePage method, of class HomeController.
     */
    @Test
    public void testShowHomePage() {
        System.out.println("showHomePage");
        
        List<Spittle> expectedSpittles = Arrays.asList(
                new Spittle(), new Spittle(), new Spittle());
        
        SpitterService spitterService = Mockito.mock(SpitterService.class);
        Mockito.when(spitterService.getRecentSpittles(HomeController.DEFAULT_SPITTLES_PER_PAGE))
               .thenReturn(expectedSpittles);
        
        HomeController homeController = new HomeController();
        homeController.setSpitterService(spitterService);
        Map<String, Object> model = new HashMap<String, Object>();
        
        String viewName = homeController.showHomePage(model);
        assertEquals("hello", viewName);
    }
}
