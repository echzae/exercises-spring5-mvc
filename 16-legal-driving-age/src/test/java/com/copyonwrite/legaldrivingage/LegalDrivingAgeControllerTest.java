package com.copyonwrite.legaldrivingage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author wolf
 */
@RunWith(SpringRunner.class)
public class LegalDrivingAgeControllerTest {
    private final String ILLEGAL_AGE_PARAM = "15";
    private final String LEGAL_AGE_PARAM = "30";
    
    private LegalDrivingAgeController legalDrivingController;
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        legalDrivingController = new LegalDrivingAgeController(new CheckAgeService());
        mockMvc = MockMvcBuilders.standaloneSetup(this.legalDrivingController).build();
    }

    @Test
    public void getIndexShouldReturnCorrectTemplate() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
    
    @Test
    public void postIsLegalShouldReturnCorrectTemplate() throws Exception {
        mockMvc.perform(post("/is-legal").param("age", LEGAL_AGE_PARAM))
                .andExpect(status().isOk())
                .andExpect(view().name("islegal"));
    }
    
    @Test
    public void postIsLegalShouldReturnCorrectAnswerForUnderAgedPersons() throws Exception {
        mockMvc.perform(post("/is-legal").param("age", ILLEGAL_AGE_PARAM))
                .andExpect(status().isOk())
                .andExpect(model().attribute("legal", equalTo("You are not old enough to legally drive.")));
    }
    
    @Test
    public void postIsLegalShouldReturnCorrectAnswerForOldEnoughPersons() throws Exception {
        mockMvc.perform(post("/is-legal").param("age", LEGAL_AGE_PARAM))
                .andExpect(status().isOk())
                .andExpect(model().attribute("legal", equalTo("You are old enough to legally drive.")));
    }

}
