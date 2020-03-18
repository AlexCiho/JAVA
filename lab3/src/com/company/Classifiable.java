package com.company;
import java.util.List;

public interface  Classifiable {
    public enum Rank{
        oneStar, twoStars, threeStars;
    }
    public void setClass(Rank clas);
    public Rank getClass();

}
