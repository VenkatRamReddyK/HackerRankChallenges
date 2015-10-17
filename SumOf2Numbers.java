/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InteviewPreparation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author venkatramreddykunta
 */
public class SumOf2Numbers {

    public static void main(String[] args) {
        int[] list={1,2,3,6,7,4,1,6,0,8,-1};
        int sum=7; // 70,61,61,8-1,43
        Map<Integer,Integer> map;
        map=sumInList(list,sum);
        displayMap(map);
    }

    private static Map<Integer,Integer> sumInList(int[] list,int sum) {
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
}
