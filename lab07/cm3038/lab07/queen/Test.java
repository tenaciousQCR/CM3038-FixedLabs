package cm3038.lab07.queen;

import java.util.*;
import cm3038.search.local.*;

public class Test {
    public static void main(String[] arg) {
        State state = new NqState(4);

        System.out.println("---toString() method returns:---");
        System.out.println(state.toString());

        Set<State> neighbours=state.neighbours();
        System.out.println("---Number of neighbours returned by neighbours() method:---");
        System.out.println(neighbours.size());

        System.out.println("---Neighours found:---");
        System.out.println(neighbours.size());
        
        Object[] neighbourArray=neighbours.toArray();
        
        for (int i = 0; i < neighbourArray.length; i++) {
            System.out.println(neighbourArray[i].toString() + "\n");
        }
    }
}
