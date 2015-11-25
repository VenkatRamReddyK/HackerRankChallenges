/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InteviewPreparation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author venkatramreddykunta
 */
public class SumOf2Numbers {

    public static void main(String[] args) {
        int[] list={1,2,3,6,7,4,1,6,0,8,-1};
        int sum=7; // 70,61,61,8-1,43
        Map<Integer,Integer> map;
        map=readArrayIntoMap(list,sum);
        displayMap(map);
        findTupleSumtoANumber(map,sum);
        
    }

    private static Map<Integer,Integer> readArrayIntoMap(int[] list,int sum) {
        Map<Integer,Integer> map=new HashMap<>();
        int key,value;
        for (int i = 0; i < list.length; i++) {
            key=list[i];
            if(map.containsKey(key)){
                value=map.get(key)+1;
            }
            else
                value=1;
            map.put(key, value);
        }
//        System.out.println("Hash Map: "+map);
        return map;
    }

    private static void displayMap(Map<Integer, Integer> map) {
        //Attach and Iterator to the map
        Iterator<Map.Entry<Integer,Integer>> entries=map.entrySet().iterator();        
        System.err.println("Entries List: ");
        while(entries.hasNext()){
            Map.Entry<Integer,Integer> currentEntry=entries.next();
                System.out.println(currentEntry.getKey()+","+currentEntry.getValue());
        }
    }

    private static void findTupleSumtoANumber(Map<Integer, Integer> map, int sum) {
// sum =7
// 0,1,3,11,7,5,2,9,4,3,4,2
//  0 - 1
//  1 - 1
//  2 - 1
//  3 - 2              
//  4 - 2     
//  5 - 2     
//  7 - 0        
// (0,7), (3,4), (3,4), (2,5)                
        
        int key,value;
        Iterator<Map.Entry<Integer,Integer>> iterator=map.entrySet().iterator();       
        for(Integer key:map.keySet()){            
            if(map.get(key)!=0 && map.containsKey(sum-key)){
                System.out.print("("+key+","+(sum-key)+") ");
                value=map.get(key)-1;
                map.put(key, value);
                map.put(sum-key, value);
            } 
            if(map.get(key)==0 && iterator.next()){
                map.remove();
            }
//      1-0  <-key
//      2-1  remove 
//      3-1   
        
        }       
//        for(Entry<Integer,Integer> entry:map.entrySet()){
//            key=entry.getKey(); value=entry.getValue();
//            
//        }
        
//        while(iterator.hasNext()){            
//            Entry<Integer,Integer> entry=iterator.next();
//            key=entry.getKey();
//            if(map.containsKey(key) && map.containsKey(sum-key) ){ // 3-1, 4-2,
//               map.put(key, map.get(key)-1);
//               map.put(sum-key, map.get(sum-key)-1); // 3-0 , 4-1               
//                if(map.get(key)==0){
//                    map.remove(key);
//                }    
//                if(map.get(sum-key)==0){
//                    map.remove(sum-key);
//                }// 4-1
//            }
//        }
        displayMap(map);
    }               
}

