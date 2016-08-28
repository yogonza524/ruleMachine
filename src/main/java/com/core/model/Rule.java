/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gonzalo
 */
public class Rule {
    
    private List<Variable> variables;
    private List<Operation> operations;
    private Variable consequent;
    private String name = "";

    private Rule() {}

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Variable getConsequent() {
        return consequent;
    }

    public void setConsequent(Variable consequent) {
        this.consequent = consequent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String output = (this.name.isEmpty()? "Unknown name rule" : this.name) + ": ";
        for (int i = 0; i < this.variables.size() - 1; i++) {
            Variable v = this.variables.get(i);
            if (v.isNegated()) {
                output += Operation.NOT.toString();
            }
            output += v.getLabel() + " " + this.operations.get(i) + " ";
        }
        Variable v = this.variables.get(this.variables.size() - 1);
        if (v.isNegated()) {
            output += Operation.NOT.toString();
        }
        output += v.getLabel() + " => " + (this.consequent.isNegated()? Operation.NOT.toString(): "") + this.consequent.getLabel();
        return output;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.variables);
        hash = 53 * hash + Objects.hashCode(this.operations);
        hash = 53 * hash + Objects.hashCode(this.consequent);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rule other = (Rule) obj;
        if (!Objects.equals(this.variables, other.variables)) {
            return false;
        }
        if (!Objects.equals(this.operations, other.operations)) {
            return false;
        }
        if (!Objects.equals(this.consequent, other.consequent)) {
            return false;
        }
        return true;
    }
    
    
    
    public static class RuleBuilder{
        
        private List<Variable> variables;
        private List<Operation> operations;
        private Variable consequent;
        private String name = "";

        public RuleBuilder() {
            variables = new ArrayList<>();
            operations = new ArrayList<>();
        }
        
        public RuleBuilder first(Variable var) throws Exception{
            if (this.variables != null && this.variables.isEmpty() && var != null) {
                //The list is empty, the first is ok
                this.variables.add(var);
            }
            else{
                throw new Exception("first(Variable var) says: the rule has an item, don't use first method in this context");
            }
            return this;
        }
        
        public RuleBuilder and(Variable var) throws Exception{
            if (this.variables != null && !this.variables.isEmpty() 
                    && this.operations != null && this.operations.size() >= 0
                    && this.variables.size() > 0
                    && this.variables.size() -1 == this.operations.size()) {
                this.operations.add(Operation.AND);
                this.variables.add(var);
            }
            else{
                throw new Exception("and(Operation op) says: this operation need a a pair variable-operation");
            }
            return this;
        }
        
        public RuleBuilder or(Variable var) throws Exception{
            if (this.variables != null && !this.variables.isEmpty() 
                    && this.operations != null && this.operations.size() >= 0
                    && this.variables.size() > 0
                    && this.variables.size() -1 == this.operations.size()) {
                this.operations.add(Operation.OR);
                this.variables.add(var);
            }
            else{
                throw new Exception("or(Operation op) says: this operation need a a pair variable-operation");
            }
            return this;
        }

//        public RuleBuilder last(Variable var) throws Exception{
//            if (this.variables != null && !this.variables.isEmpty() 
//                    && this.operations != null && this.operations.size() >= 0
//                    && this.variables.size() > 0
//                    && this.variables.size() == this.operations.size()) {
//                this.variables.add(var);
//            }
//            else{
//                throw new Exception("last(Variable var) says: this operation need a single variable");
//            }
//            return this;
//        }
        
        public RuleBuilder withName(String name){
            this.name = name;
            return this;
        }
        
        public Rule then(Variable consequent) throws Exception{
            if (this.variables != null && !this.variables.isEmpty() 
                    && this.operations != null && this.operations.size() >= 0
                    && this.variables.size() > 0
                    && this.consequent == null) {
                this.consequent = consequent;
            }
            else{
                throw new Exception("then(Variable consequent) says: ");
            }
            Rule r = new Rule();
            r.setConsequent(consequent);
            r.setOperations(operations);
            r.setVariables(variables);
            if (name.isEmpty()) {
                name = "Unknown name rule";
            }
            r.setName(name);
            return r;
        }
        
        public List<Variable> getVariables() {
            return variables;
        }

        public void setVariables(List<Variable> variables) {
            this.variables = variables;
        }

        public List<Operation> getOperations() {
            return operations;
        }

        public void setOperations(List<Operation> operations) {
            this.operations = operations;
        }
        
        
    }
    
}
