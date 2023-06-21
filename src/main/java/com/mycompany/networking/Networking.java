/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.networking;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel.builes
 */
public class Networking {

    public static void main(String[] args) {
        
        try {
            URL aSite = new URL("https://www.google.com/search?q=que+es+el+path&rlz=1C1UUXU_esCO1062CO1062&oq=que+es+el+path&aqs=chrome..69i57j0i512l9.5815j1j7&sourceid=chrome&ie=UTF-8#address");
            
            System.out.println("Protocol: "+ aSite.getProtocol());
            System.out.println("Authority: "+ aSite.getAuthority());
            System.out.println("Host: "+ aSite.getHost());
            System.out.println("Port: "+ aSite.getPort());
            System.out.println("Path: "+ aSite.getPath());
            System.out.println("Query: "+ aSite.getQuery());
            System.out.println("File: "+ aSite.getFile());
            System.out.println("Ref: "+ aSite.getRef());
            
            
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Networking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
