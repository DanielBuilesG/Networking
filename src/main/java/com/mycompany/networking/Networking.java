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
            
            System.out.println("Protocol: "+ aSite.getProtocol()); // expected output: https
            System.out.println("Authority: "+ aSite.getAuthority()); // expected output: www.google.com
            System.out.println("Host: "+ aSite.getHost()); // expected output: www.google.com
            System.out.println("Port: "+ aSite.getPort()); // expected output: -1, can be altered bu typing a ":" after Host
            System.out.println("Path: "+ aSite.getPath()); // expected output: /search,  path is expected after host or port if given
            System.out.println("Query: "+ aSite.getQuery()); // expected output: q=que+es+el+path&rlz=1C1U.........=UTF-8. querty goes after "?" 
            System.out.println("File: "+ aSite.getFile()); // expected output: /search?q=que+es+el+.......&sourceid=chrome&ie=UTF-8
            System.out.println("Ref: "+ aSite.getRef()); // expected output: address,is anything that goes after "#" 
            
            
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Networking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
