/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concurrencia;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel.builes
 */
public class synchronizedQueue {
    
    private String valor;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    
    public void producer(String producto){
        synchronized (lock1) {
            for (int i =0; i<10 ; i++){
                
                if(valor == null){
                    valor = producto;
                    consumer(producto);
                }else{
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(synchronizedQueue.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                System.out.println("producto añaido: " + producto);
            }
            
            
        }
    }
    
    public void consumer(String producto){
        synchronized (lock2) {
            for (int i =0; i<10 ; i++){
                if (valor != null){
                    valor = null;
                } else{
                    notifyAll();
                }
                System.out.println("producto quitado: "+ producto);
            }
        }
    }
    
    public static void main(String[] args){
        synchronizedQueue productor = new synchronizedQueue();
        synchronizedQueue consumidor = new synchronizedQueue();
        
        new Thread(new Runnable(){
            public void run(){
                productor.producer("leche");
            }
        }).start();
        
        new Thread(new Runnable(){
            public void run(){
                consumidor.consumer("leche");
            }
        }).start();
        
    }
    
    
}
