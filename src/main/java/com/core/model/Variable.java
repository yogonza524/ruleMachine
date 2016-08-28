/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.model;

import com.core.enums.Value;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gonzalo
 */
public class Variable implements Serializable{
    private Value value;
    private String label;
    private boolean negated;
    
    public Variable(String label, boolean negated) {
        this.value = Value.UNKNOWN;
        this.label = label;
        this.negated = negated;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public boolean isNegated() {
        return negated;
    }

    public void setNegated(boolean negated) {
        this.negated = negated;
    }

    @Override
    public String toString() {
        return "Variable{" + "value=" + value + ", label=" + label + ", negated=" + negated + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.value);
        hash = 97 * hash + Objects.hashCode(this.label);
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
        final Variable other = (Variable) obj;
        if (!Objects.equals(this.label, other.label)) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        return true;
    }
    
    
}
