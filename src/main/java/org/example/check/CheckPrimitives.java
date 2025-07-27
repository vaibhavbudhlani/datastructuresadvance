package org.example.check;

public class CheckPrimitives {

    public void fun(String s){
        System.out.println("I am String");
    }

    public void fun(Object s){
        System.out.println("I am Object");
    }
    public static void main(String[] args) {
        new CheckPrimitives().fun(null);
    }
}
