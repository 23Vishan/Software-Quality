package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    // Testing when no arguments are passed
    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", ""))
			.andExpect(model().attribute("operand1Focused", false));
    }
	
    // Testing with 'argument: operand 1'
	@Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1","111"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", "111"))
			.andExpect(model().attribute("operand1Focused", true));
    }

    // ============================================
    // MISSING OPERATOR TESTS
    // ============================================

    @Test
    public void invalidOperator() throws Exception {
    this.mvc.perform(post("/").param("operand1","111").param("operator","").param("operand2","111"))
        .andExpect(status().isOk())
        .andExpect(view().name("Error"));
    }

    // ============================================
    // ADDITION TESTS
    // ============================================

    // both operands are given
	@Test
	    public void addGivenBothOperands() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1110"))
			.andExpect(model().attribute("operand1", "111"));
    }

    // missing operand 1
	@Test
    public void addMissingOperand1() throws Exception {
    this.mvc.perform(post("/").param("operand1","").param("operator","+").param("operand2","111"))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "111"))
        .andExpect(model().attribute("operand1", ""))
        .andExpect(model().attribute("operand2", "111"));
    }

    // missing operand 2
    @Test
    public void addMissingOperand2() throws Exception {
    this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2",""))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "111"))
        .andExpect(model().attribute("operand1", "111"))
        .andExpect(model().attribute("operand2", ""));
    }

    // missing operand 1 and 2
    @Test
    public void addMissingBothOperands() throws Exception {
    this.mvc.perform(post("/").param("operand1","").param("operator","+").param("operand2",""))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "0"))
        .andExpect(model().attribute("operand1", ""))
        .andExpect(model().attribute("operand2", ""));
    }

    // ============================================
    // MULTIPLICATION TESTS
    // ============================================

    @Test
    public void mulGivenBothOperands() throws Exception {
    this.mvc.perform(post("/").param("operand1","111").param("operator","*").param("operand2","111"))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "110001"))
        .andExpect(model().attribute("operand1", "111"))
        .andExpect(model().attribute("operand2", "111"));
    }

    @Test
    public void mulMissingOperand1() throws Exception {
    this.mvc.perform(post("/").param("operand1","111").param("operator","*").param("operand2",""))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "0"))
        .andExpect(model().attribute("operand1", "111"))
        .andExpect(model().attribute("operand2", ""));
    }

    @Test
    public void mulMissingOperand2() throws Exception {
    this.mvc.perform(post("/").param("operand1","").param("operator","*").param("operand2","111"))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "0"))
        .andExpect(model().attribute("operand1", ""))
        .andExpect(model().attribute("operand2", "111"));
    }

    @Test
    public void mulMissingBothOperands() throws Exception {
    this.mvc.perform(post("/").param("operand1","").param("operator","*").param("operand2",""))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "0"))
        .andExpect(model().attribute("operand1", ""))
        .andExpect(model().attribute("operand2", ""));
    }

    // ============================================
    // BINARY OR TESTS
    // ============================================

    @Test
    public void orGivenBothOperands() throws Exception {
    this.mvc.perform(post("/").param("operand1","111").param("operator","|").param("operand2","111"))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "111"))
        .andExpect(model().attribute("operand1", "111"))
        .andExpect(model().attribute("operand2", "111"));
    }

    @Test
    public void orMissingOperand1() throws Exception {
    this.mvc.perform(post("/").param("operand1","").param("operator","|").param("operand2","111"))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "111"))
        .andExpect(model().attribute("operand1", ""))
        .andExpect(model().attribute("operand2", "111"));
    }

    @Test
    public void orMissingOperand2() throws Exception {
    this.mvc.perform(post("/").param("operand1","111").param("operator","|").param("operand2",""))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "111"))
        .andExpect(model().attribute("operand1", "111"))
        .andExpect(model().attribute("operand2", ""));
    }

    @Test
    public void orMissingBothOperands() throws Exception {
    this.mvc.perform(post("/").param("operand1","").param("operator","|").param("operand2",""))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "0"))
        .andExpect(model().attribute("operand1", ""))
        .andExpect(model().attribute("operand2", ""));
    }

    // ============================================
    // BINARY AND TESTS
    // ============================================

    @Test
    public void andGivenBothOperands() throws Exception {
    this.mvc.perform(post("/").param("operand1","111").param("operator","&").param("operand2","111"))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "111"))
        .andExpect(model().attribute("operand1", "111"))
        .andExpect(model().attribute("operand2", "111"));
    }

    @Test
    public void andMissingOperand1() throws Exception {
    this.mvc.perform(post("/").param("operand1","").param("operator","&").param("operand2","111"))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "0"))
        .andExpect(model().attribute("operand1", ""))
        .andExpect(model().attribute("operand2", "111"));
    }

    @Test
    public void andMissingOperand2() throws Exception {
    this.mvc.perform(post("/").param("operand1","111").param("operator","&").param("operand2",""))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "0"))
        .andExpect(model().attribute("operand1", "111"))
        .andExpect(model().attribute("operand2", ""));
    }

    @Test
    public void andMissingBothOperands() throws Exception {
    this.mvc.perform(post("/").param("operand1","").param("operator","&").param("operand2",""))
        .andExpect(status().isOk())
        .andExpect(view().name("result"))
        .andExpect(model().attribute("result", "0"))
        .andExpect(model().attribute("operand1", ""))
        .andExpect(model().attribute("operand2", ""));
    }
}