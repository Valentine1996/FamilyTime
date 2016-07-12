/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-07-08 18:50:40 :: 2016-07-12 10:51:40
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.familytime.config.PersistenceTest;
import com.familytime.model.entity.Family;
import com.familytime.model.repository.FamilyRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * Main test class. Example of sample tests.
 */
@ActiveProfiles("tests")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceTest.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration

public class HelloControllerTest {

    private MockMvc mvc;

    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * Setup Web Application context.
     *
     * @throws Exception General application exception
     */
    @Before
    public void setUp() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(
            this.webApplicationContext
        )
            .build();
        
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }


    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void testFindAll()  {
        
        List<Family> familyList = familyRepository.findAll();

        Assert.assertEquals(familyList.size(), 2);
        
    }
}
