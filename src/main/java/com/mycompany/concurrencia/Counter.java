/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concurrencia;

/**
 *
 * @author daniel.builes
 */
public class Counter {
    private int c = 0;
    
    public synchronized  void increment(){
        c++;
    }
    
    public synchronized void decrement(){
        c--;
    }
}
