package com.company;

public class Parcel implements IParcel
{
    private SizeType sizeType;

    private  int cost;

    public Parcel(int depth, int height, int width)
    {

    }

    public int getCost()
    {
        return cost;
    }

    public SizeType getSizeType()
    {
        return sizeType;
    }

}
