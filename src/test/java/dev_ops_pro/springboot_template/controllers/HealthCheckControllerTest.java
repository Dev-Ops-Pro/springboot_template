package dev_ops_pro.springboot_template.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HealthCheckControllerTest {

    @InjectMocks
    HealthCheckController controller;
    @Test
    public void getHealthStatus() throws Exception {
        String test = controller.getHealthStatus();
        assertEquals("Feeling healthy", test);
    }

}