package by.bsu;

import by.bsu.progression.children.Exponential;
import by.bsu.progression.children.Liner;
import by.bsu.window.MyWindow;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	Liner l = new Liner(1,2,5);
    System.out.println(l);
    Exponential e = new Exponential(1,2,5);
    System.out.println(e);
    MyWindow w = new MyWindow();
    w.setVisible(true);
    }
}
