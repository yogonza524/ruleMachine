/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.model;

import com.core.enums.Value;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gonzalo
 */
public class RuleMachine {
    
    private final List<Rule> rules;

    public RuleMachine() {
        this.rules = new ArrayList<>();
    }
    
    public boolean addRule(Rule rule){
        return this.rules.add(rule);
    }
    
    public boolean removeRule(Rule rule){
        return this.rules.remove(rule);
    }
    
    public List<Rule> getRules(){
        return this.rules;
    }
    
    public boolean setValueToVariable(String label, Value val){
        boolean result = false;
        if (label != null && !label.isEmpty() && val != null && val != Value.UNKNOWN) {
            for(Rule r : this.rules){
                for(Variable v : r.getVariables()){
                    if (v.getLabel().equals(label)) {
                        v.setValue(val);
                        result = true;
                        break;
                    }
                }
                if (r.getConsequent() != null && r.getConsequent().getLabel().equals(label)) {
                    r.getConsequent().setValue(val);
                    break;
                }
            }
        }
        return result;
    }
    
    public Variable getVariable(String label){
        Variable output = null;
        if (label != null && !label.isEmpty()) {
            for(Rule r : this.rules){
                for(Variable v : r.getVariables()){
                    if (v.getLabel().equals(label)) {
                        output = v;
                        break;
                    }
                }
                if (output == null && r.getConsequent().getLabel().equals(label)) {
                    output = r.getConsequent();
                    break;
                }
            }
        }
        return output;
    }
}
