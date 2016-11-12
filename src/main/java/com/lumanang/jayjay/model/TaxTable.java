package com.lumanang.jayjay.model;

public enum TaxTable {
    LOW(0,18200,0,0,0),
    BELOW_AVERAGE(18201,37000,18200,0.19,0),
    AVERAGE(37001,80000,37000,0.325,3572),
    ABOVE_AVERAGE(80001,180000,80000,0.37,17547),
    HIGH(180001,999999,180000,0.45,54547);

    private double rangeFirst;
    private double rangeLast;
    private double subtrahend;
    private double multiplier;
    private double addend;

    TaxTable(double rangeFirst, double rangeLast, double subtrahend, double multiplier, double addend){
        this.rangeFirst = rangeFirst;
        this.rangeLast = rangeLast;
        this.subtrahend = subtrahend;
        this.multiplier = multiplier;
        this.addend = addend;
    }

    public double getRangeFirst() {
        return rangeFirst;
    }

    public double getRangeLast() {
        return rangeLast;
    }

    public double getSubtrahend() {
        return subtrahend;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public double getAddend() {
        return addend;
    }
}
