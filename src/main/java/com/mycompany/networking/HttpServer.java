/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.networking;

/**
 *
 * @author daniel.builes
 */
import java.net.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.nio.file.Files;

public class HttpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        
        
        while (running){
            
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine, outputLine;
                
            boolean firstReqLine = true;
            String request = "";
            
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (firstReqLine){
                    firstReqLine = false;
                    request = inputLine;
                }
                if (!in.ready()) {
                    break;
                }
            }
            
            
            createResponse(request, out);
            

            out.close();
            in.close();
            clientSocket.close();
            
        }
        serverSocket.close();
    }
    
    private static void createResponse(String request, PrintWriter out) {
        //GET /index.html HTTP/1.1
        System.out.println("Request interpret: " + request);
        if(request.equals("")){return;}
        String[] tokenizedRequest = request.split(" ");
        
        String httpVerb = tokenizedRequest[0];
        String path = tokenizedRequest[1];
        String protocol = tokenizedRequest[2];
        
        Path file= Paths.get("./www" + path);
        
        String defaultHeader ="HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n";
        
        Charset charset = Charset.forName("UTF-8");
        out.println(defaultHeader);
        try(BufferedReader reader = Files.newBufferedReader(file, charset)){
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                out.println(line);
            }
        }catch(IOException x){
            System.err.format("IOExeception: %s%n", x);
        }
    }
    
    public static String defaultResponse(){
        return "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Title of the document</title>\n"
                    + "</head>"
                    + "<body>"
                    + "My Web Site"
                    + "</body>"
                    + "</html>"; 

            
    }

    
}
