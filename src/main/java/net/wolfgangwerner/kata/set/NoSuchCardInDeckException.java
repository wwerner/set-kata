package net.wolfgangwerner.kata.set;


public class NoSuchCardInDeckException extends Exception{
    public NoSuchCardInDeckException(String s) {
        super(s);
    }
}
