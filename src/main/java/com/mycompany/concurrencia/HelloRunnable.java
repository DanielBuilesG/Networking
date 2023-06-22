/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concurrencia;

/**
 *
 * @author daniel.builes
 */
public class HelloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from runnable");
    }
    
    public static void main(String[] args){
        new Thread(new HelloRunnable()).start();
    }
    
}
