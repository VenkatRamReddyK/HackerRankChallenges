/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InteviewPreparation;

/**
 *
 * @author venkatramreddykunta
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountLuck {

//    static int startRow,startCol;
    static boolean[][] visited;
    static char[][] input;
    static int N,M,K; 
    static int MaxCount=0;
    static boolean destinationReached=false;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner stdin=new Scanner(System.in);
        int tests=stdin.nextInt();
        N=0;M=0;
        stdin.nextLine();        
        int startRow=0,startCol=0;
        for(int i=0;i<tests;i++){       
            destinationReached=false;
            N=stdin.nextInt();M=stdin.nextInt();
            stdin.nextLine();
            
            input=new char[N][M];            
            visited=new boolean[N][M];                        
            for(int j=0;j<N;j++){                
                input[j]=stdin.nextLine().toCharArray();
                //System.out.println(input[j]);                 
            }                  
            
            for(int j=0;j<N;j++){                
                for(int k=0;k<M;k++){                    
                    if(input[j][k]=='.' || input[j][k]=='*')
                        visited[j][k]=false;
                    else{
                        visited[j][k]=true;
                        
                        if(input[j][k]=='M'){
                            startRow=j;startCol=k;
                        }
                        
                    }
                }    
            }
           K=stdin.nextInt();
           if(stdin.hasNext())
               stdin.nextLine();                
           // System.out.println("N:"+N+",M:"+M);                    
           countLuck(startRow,startCol,0);
          //  System.out.println("Wave COunt:"+MaxCount); 
            if(MaxCount==K)
               System.out.println("Impressed");                    
           else
               System.out.println("Oops!");              
        }        
    }
  // 
public static void countLuck(int nextRow,int nextCol,int waveCount){
     //System.out.println("Inside Count:"); 
     if(input[nextRow][nextCol]=='*'){
       //  System.out.println("Max Wave count found:"+waveCount);
         MaxCount=waveCount;
         destinationReached=true;
         return;
     }
    if(destinationReached)
        return;
    
     int _waveCount=0;
       _waveCount+=(nextRow+1<N && !visited[nextRow+1][nextCol])?1:0; 
       _waveCount+=(nextRow-1>=0 && !visited[nextRow-1][nextCol])?1:0;
       _waveCount+=(nextCol+1<M && !visited[nextRow][nextCol+1])?1:0;
       _waveCount+=(nextCol-1>=0 && !visited[nextRow][nextCol-1])?1:0;    
     if(_waveCount>1)
         ++waveCount;    
    // System.out.println("Next Row: "+nextRow+", Next Col: "+nextCol+", Wave Count:"+waveCount);          
     if(nextRow+1<N && !visited[nextRow+1][nextCol]){ // top side cell is not visited 
       //  System.out.println("Bottom: Next Row: "+(nextRow+1)+", Next Col: "+nextCol);
         visited[nextRow+1][nextCol]=true;
         countLuck(nextRow+1,nextCol,waveCount);         
     }
     
     if(nextRow-1>=0 && !visited[nextRow-1][nextCol]){ // bottom side cell is not visited 
       //  System.out.println("Top: Next Row: "+(nextRow-1)+", Next Col: "+nextCol);         
         visited[nextRow-1][nextCol]=true;
         countLuck(nextRow-1,nextCol,waveCount);         
     }

     if(nextCol+1<M && !visited[nextRow][nextCol+1]){ // right side cell is not visited 
        // System.out.println("Right Side:    Next Row: "+nextRow+", Next Col: "+(nextCol+1));
         visited[nextRow][nextCol+1]=true;
         countLuck(nextRow,nextCol+1,waveCount);         
     }

     if(nextCol-1>=0 && !visited[nextRow][nextCol-1]){ // left side cell is not visited \
       //  System.out.println("Left Side:    Next Row: "+nextRow+", Next Col: "+(nextCol-1));         
         visited[nextRow][nextCol-1]=true;
         countLuck(nextRow,nextCol-1,waveCount);               
     }
 }

}