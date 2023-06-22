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
public class Producer implements Runnable{
    
    private final SyncQueue cola;
    
    public Producer(SyncQueue cola){
        this.cola = cola;
        
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 10; i++){
            cola.put("val_" + i);
        }
    }
    
}
