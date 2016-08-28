/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.model;

/**
 *
 * @author gonzalo
 */
public enum Operation {
    
    AND("and"), OR("or"), NOT("~");
    
    private String value;
    
    private Operation(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
