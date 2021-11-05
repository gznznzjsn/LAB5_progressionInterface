package by.bsu.progression;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Progression {

    private double firstElement;
    private double denominator;
    private int length;

    public Progression(double fE, double d, int l){
        this.firstElement = fE;
        this.denominator = d;
        this.length = l;
    }

    public double getFirstElement() {
        return firstElement;
    }
    public void setFirstElement(double firstElement) {
        this.firstElement = firstElement;
    }

    public double getDenominator() {
        return denominator;
    }
    public void setDenominator(double denominator) {
        this.denominator = denominator;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public double sum(){
        double result = 0;
        for(int i =0; i <length; i++){
            result += getElement(i);
        }
        return result;
    }

    @Override
    public String toString(){
        StringBuilder resultStr = new StringBuilder(sum()+": ");
        for(int i =0; i <length; i++){
            resultStr.append(getElement(i)).append(" ");
        }
        return resultStr.toString();}

    public void writeToFile(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
            writer.write(this.toString());
            writer.flush();
    }

    public abstract double getElement(int index);
}
