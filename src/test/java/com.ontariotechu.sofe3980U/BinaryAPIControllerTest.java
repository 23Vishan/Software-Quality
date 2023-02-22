package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }

	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // ============================================
    // ADD JSON API TESTS
    // ============================================

    // Operand 1 and Operand2 are given
    @Test
    public void addJsonBothOperandsGiven() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1110))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // Operand 1 is missing
    @Test
    public void addJsonMissingOperand1() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // Operand 2 missing
    @Test
    public void addJsonMissingOperand2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // Both operands are missing
    @Test
    public void addJsonMissingBothOperands() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // ============================================
    // ADD JSON STRING TESTS
    // ============================================

    // Operand 1 and Operand2 are given
    @Test
    public void addStringGivenBothOperands() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(content().string("1110"));
    }

    // Operand 1 is missing
    @Test
    public void addStringMissingOperand1() throws Exception {
        this.mvc.perform(get("/add").param("operand1","").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(content().string("111"));
    }

    // Operand 2 missing
    @Test
    public void addStringMissingOperand2() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(content().string("111"));
    }

    // Both operands are missing
    @Test
    public void addStringMissingBothOperands() throws Exception {
        this.mvc.perform(get("/add").param("operand1","").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }
    
    // ============================================
    // MULTIPLICATION JSON API TESTS
    // ============================================

    // Operand 1 and Operand2 are given
    @Test
    public void mulJsonBothOperandsGiven() throws Exception {
        this.mvc.perform(get("/mul_json").param("operand1","111").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(110001))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    // Operand 1 is missing
    @Test
    public void mulJsonMissingOperand1() throws Exception {
        this.mvc.perform(get("/mul_json").param("operand1","").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    // Operand 2 missing
    @Test
    public void mulJsonMissingOperand2() throws Exception {
        this.mvc.perform(get("/mul_json").param("operand1","111").param("operand2","0"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    // Both operands are missing
    @Test
    public void mulJsonMissingBothOperands() throws Exception {
        this.mvc.perform(get("/mul_json").param("operand1","").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    // ============================================
    // MULTIPLICATION JSON STRING TESTS
    // ============================================

    // Operand 1 and Operand2 are given
    @Test
    public void mulStringGivenBothOperands() throws Exception {
        this.mvc.perform(get("/mul").param("operand1","111").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(content().string("110001"));
    }

    // Operand 1 is missing
    @Test
    public void mulStringMissingOperand1() throws Exception {
        this.mvc.perform(get("/mul").param("operand1","").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    // Operand 2 missing
    @Test
    public void mulStringMissingOperand2() throws Exception {
        this.mvc.perform(get("/mul").param("operand1","111").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    // Both operands are missing
    @Test
    public void mulStringMissingBothOperands() throws Exception {
        this.mvc.perform(get("/mul").param("operand1","").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }
    
    // ============================================
    // AND JSON API TESTS
    // ============================================

    // Operand 1 and Operand2 are given
    @Test
    public void andJsonBothOperandsGiven() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","111").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    // Operand 1 is missing
    @Test
    public void andJsonMissingOperand1() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    // Operand 2 missing
    @Test
    public void andJsonMissingOperand2() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","111").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    // Both operands are missing
    @Test
    public void andJsonMissingBothOperands() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    // ============================================
    // AND JSON STRING TESTS
    // ============================================

    // Operand 1 and Operand2 are given
    @Test
    public void andStringGivenBothOperands() throws Exception {
        this.mvc.perform(get("/and").param("operand1","111").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(content().string("111"));
    }

    // Operand 1 is missing
    @Test
    public void andStringMissingOperand1() throws Exception {
        this.mvc.perform(get("/and").param("operand1","").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    // Operand 2 missing
    @Test
    public void andStringMissingOperand2() throws Exception {
        this.mvc.perform(get("/and").param("operand1","111").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    // Both operands are missing
    @Test
    public void andStringMissingBothOperands() throws Exception {
        this.mvc.perform(get("/and").param("operand1","").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }
    
    // ============================================
    // OR JSON API TESTS
    // ============================================

    // Operand 1 and Operand2 are given
    @Test
    public void orJsonBothOperandsGiven() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","111").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    // Operand 1 is missing
    @Test
    public void orJsonMissingOperand1() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    // Operand 2 missing
    @Test
    public void orJsonMissingOperand2() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","111").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    // Both operands are missing
    @Test
    public void orJsonMissingBothOperands() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    // ============================================
    // OR JSON STRING TESTS
    // ============================================

    // Operand 1 and Operand2 are given
    @Test
    public void orStringGivenBothOperands() throws Exception {
        this.mvc.perform(get("/or").param("operand1","111").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(content().string("111"));
    }

    // Operand 1 is missing
    @Test
    public void orStringMissingOperand1() throws Exception {
        this.mvc.perform(get("/or").param("operand1","").param("operand2","111"))
            .andExpect(status().isOk())
            .andExpect(content().string("111"));
    }

    // Operand 2 missing
    @Test
    public void orStringMissingOperand2() throws Exception {
        this.mvc.perform(get("/or").param("operand1","111").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(content().string("111"));
    }

    // Both operands are missing
    @Test
    public void orStringMissingBothOperands() throws Exception {
        this.mvc.perform(get("/or").param("operand1","").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }
}