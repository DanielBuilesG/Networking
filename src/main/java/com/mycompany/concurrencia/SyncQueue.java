/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concurrencia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel.builes
 */
public class SyncQueue {
    private String value;
    private boolean isEmpty = true;

    public synchronized void put(String value){
        
        while(!isEmpty){
           try {
               wait();
           } catch (InterruptedException ex) {
               Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        this.value= value;
        isEmpty=false;
        notifyAll();
        
    }
    
    public synchronized String get(){
         while(isEmpty){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        isEmpty=true;
        notifyAll();
        return value;
       
    }
    
    public boolean isEmpty(){
        return isEmpty;
    }
    
    public static void main(String[] args){
        SyncQueue cola = new SyncQueue();
        Thread P = new Thread(new Producer(cola));
        Thread c = new Thread(new Consumer(cola));
        
        P.start();
        c.start();
    }
    
}
