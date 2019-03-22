package ciphers;

import java.util.ArrayList;

public class RotorMachine {
    private ArrayList<Rotor> rotors;

    public class Rotor {
        private int key;

        public Rotor(int key) {
            this.key = key;
        }

        public char apply(char c) {
            return (char) ('a' + ((c - 'a' + this.key) % 26));
        }
    }

    public RotorMachine() {

    }

    public void addRotor(int key) {
        this.rotors.add(new Rotor(key));
    }

    public void encrypt(String clearText) {
    }
}
