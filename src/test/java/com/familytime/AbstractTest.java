/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-22-08 01:05:24 :: 2016-22-08 16:55:20
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

import com.familytime.config.PersistenceTest;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Base class for functional tests.
 *
 * @version 1.0
 */
@ActiveProfiles("tests")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PersistenceTest.class)
@WebAppConfiguration
public abstract class AbstractTest {

    /**
     * Rest documentation generator.
     */
    @Rule
    public JUnitRestDocumentation restDocumentation =
        new JUnitRestDocumentation( "build/generated-snippets" );
    /**
     * MVC mock use for test with real data base.
     */
    protected MockMvc mvc;

    /**
     * Application context.
     */
    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * Setup Web Application context.
     *
     * @throws Exception General application exception
     */
    public void tearUp() throws Exception {

        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
            .apply(documentationConfiguration(this.restDocumentation))
            .build();
    }
}
