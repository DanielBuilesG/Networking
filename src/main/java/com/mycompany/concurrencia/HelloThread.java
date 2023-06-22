/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concurrencia;

/**
 *
 * @author daniel.builes
 */
public class HelloThread extends Thread {
    
    public void run(){
        System.out.println("Hello from thread!.");
    }
    
    public static void main(String[] args){
        System.out.println("Hello from main!.");
        new HelloThread().start();
    }
    
    
}
