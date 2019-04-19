package com.example.chemistrify.models;

public class Element {

    private int atomicNumber;
    private String symbol;
    private String name;

    public Element(int atomicNumber, String symbol, String name){
        this.atomicNumber = atomicNumber;
        this.symbol = symbol;
        this.name = name;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
