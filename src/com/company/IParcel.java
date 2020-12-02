package com.company;

public interface IParcel
{
    public SizeType getSizeType();
    public int getCost();
    public void setCost(int cost);
    public void setWeightLimit(double weight);
    public int getWeightLimit();
    public void setWeight(double weight);
    public int getWeight();
}
