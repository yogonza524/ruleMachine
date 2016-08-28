/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.core.enums.Value;
import com.core.model.Operation;
import com.core.model.Rule;
import com.core.model.Rule.RuleBuilder;
import com.core.model.RuleMachine;
import com.core.model.Variable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gonzalo
 */
public class RulesTest {
    
    public RulesTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void contextTest() throws Exception {
         RuleMachine machine = new RuleMachine();
         machine.addRule(new RuleBuilder()
            .withName("Rule 1")
            .first(new Variable("A", false))
            .and(new Variable("B", true))
            .or(new Variable("C", false))
            .then(new Variable("D", true))
         );
        machine.setValueToVariable("D", Value.FALSE);
        System.out.println(machine.getVariable("D"));
        
        System.out.println(machine.getRules().get(0));
     }
}
