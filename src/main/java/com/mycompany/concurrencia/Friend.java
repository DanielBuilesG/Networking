/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concurrencia;

/**
 *
 * @author daniel.builes
 */
public class Friend {
    
    private final String name;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    
    public Friend(String name){
        this.name = name;
        
    }
    
    public String getName(){
        return this.name;
    }
    
    public void bow(Friend bower){
        synchronized (lock1){
            System.out.format("%s: %s" + " has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }
    }
    public void bowBack(Friend bower){
        synchronized (lock2){
            System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
        }
    }
    
    public static void main(String[] args){
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        
        
        new Thread(new Runnable(){
            public void run(){
                gaston.bow(alphonse);
            }
        }).start();
        
        new Thread(new Runnable(){
            public void run(){
                alphonse.bow(gaston);
            }
        }).start();
    }
    
}