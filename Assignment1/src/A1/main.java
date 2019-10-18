package A1;
// Parsa Yadollahi 260869949
// Collaborator: Nicholas Nikas
import java.io.*;
import java.util.*;


public class main {     

     
    public static void main(String[] args) {
    //TODO:build the hash table and insert keys using the insertKeyArray function.
        int A1 = 590;
        int A2 = 1018;
        int [] list1 = {79, 13, 45, 64, 32, 95, 67, 27, 78, 18, 41, 69, 15, 29, 72, 57, 81, 50, 60, 14};
        int [] list2 = {52, 71, 34, 95, 68, 25, 44, 38, 47, 77, 92, 84, 94, 12, 61, 9, 89, 56, 28, 75};
        Chaining chain_table = new Chaining(10, 0, 590);
        Chaining chain_table2 = new Chaining(10, 0, 1018);

        Open_Addressing open_table = new Open_Addressing(10,0,590);
        Open_Addressing open_table2 = new Open_Addressing(10,0,1018);

        int collisions = chain_table.insertKeyArray(list1);
        System.out.println(collisions);

        int collisions2 = chain_table2.insertKeyArray(list2);
        System.out.println(collisions2);

        System.out.println();

        int open_collisions = open_table.insertKeyArray(list1);
        System.out.println(open_collisions);

        int open_collisions2 = open_table2.insertKeyArray(list2);
        System.out.println(open_collisions2);

    }
}