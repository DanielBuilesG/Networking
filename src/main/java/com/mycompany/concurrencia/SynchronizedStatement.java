/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concurrencia;

/**
 *
 * @author daniel.builes
 */
public class SynchronizedStatement {
    private long c1 =0;
    private long c2 =0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    
    public void inc1(){
        synchronized(lock1){
            c1++;   
        }
    }
    
    public void inc2(){
        synchronized(lock2){
            c2++;
        }
    }
            
    
}
