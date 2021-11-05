package by.bsu.progression.children;

import by.bsu.progression.Progression;

public class Exponential extends Progression {

    public Exponential(double fE, double d, int l){
        super(fE, d, l);
    }
    public double getElement(int index) {
        return super.getFirstElement()*Math.pow(super.getDenominator(),index);
    }
}
