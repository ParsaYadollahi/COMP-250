package A1;
// Collaborator: Nicholas Nikas

import java.io.*;
import java.util.*;

public class Open_Addressing {
    public int m; // number of SLOTS AVAILABLE
    public int A; // the default random number
    int w;
    int r;
    public int[] Table;

    protected Open_Addressing(int w, int seed, int A) {

        this.w = w;
        this.r = (int) (w - 1) / 2 + 1;
        this.m = power2(r);
        if (A == -1) {
            this.A = generateRandom((int) power2(w - 1), (int) power2(w), seed);
        } else {
            this.A = A;
        }
        this.Table = new int[m];
        for (int i = 0; i < m; i++) {
            Table[i] = -1;
        }

    }

    /**
     * Calculate 2^w
     */
    public static int power2(int w) {
        return (int) Math.pow(2, w);
    }

    public static int generateRandom(int min, int max, int seed) {
        Random generator = new Random();
        if (seed >= 0) {
            generator.setSeed(seed);
        }
        int i = generator.nextInt(max - min - 1);
        return i + min + 1;
    }

    /**
     * Implements the hash function g(k)
     */
    public int probe(int key, int i) {
        int modulus = (int) Math.pow(2, r); // Probe mod
        int mod_chain = (int) Math.pow(2, w); // Chaining mod
        int chain_value = ((A) * key) % mod_chain >> (w-r); // Chaining hash value

        int hash_value = ((chain_value) + i) % modulus; // Probing hash value
        return hash_value;

    }


    /**
     * Inserts key k into hash table. Returns the number of collisions encountered
     */
    public int insertKey(int key) {
        //TODO : implement this and change the return statement.

        int collision = 0;
        int value;
        int i = 0;
        for (; i < m; i++) {
            value = probe(key, i); // Index for the table

            if (Table[value] == -1) {
                Table[value] = key; // Value at index is 1, replace it by key
                return collision;
            }
            collision++;
        }
        return collision;
    }

    /**
     * Sequentially inserts a list of keys into the HashTable. Outputs total number of collisions
     */
    public int insertKeyArray(int[] keyArray) {
        //TODO
        int collision = 0;
        for (int key : keyArray) {
            collision += insertKey(key);
        }
        return collision;
    }

    /**
     * Inserts key k into hash table. Returns the number of collisions encountered
     */
    public int removeKey(int key) {
        //TODO: implement this and change the return statement
        int collisions = 0;
        int value;
//        loop through the same route the key would have taken if it was inserted
        for (int i = 0; i < m; i++) {
            value = probe(key, i);
            if (key == Table[value]) { // Found the index where kay is stored and replace the  value by 1
                Table[value] = -1;
                return collisions;
            }
            collisions++;
        }
        return collisions;
    }
}
