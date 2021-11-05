package by.bsu.progression.children;

import by.bsu.progression.Progression;

public class Liner extends Progression {

    public Liner(double fE, double d, int l){
        super(fE, d, l);
    }

    public double getElement(int index) {
        return super.getFirstElement()+index*super.getDenominator();
    }
}
