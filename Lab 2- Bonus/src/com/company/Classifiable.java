package com.company;
import java.util.List;

public interface  Classifiable {
    public enum Rank{
        oneStar, twoStars, threeStars;
    }
    public void setRank(Rank rank);
    public Rank getRank();

}
