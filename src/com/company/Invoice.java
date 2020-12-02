package com.company;


import java.util.ArrayList;
import java.util.List;

public class Invoice
{
    private int totalCost;
    List<IParcel> parcelList;
    public Invoice()
    {
        parcelList = new ArrayList<>();
        parcelList.add(new Parcel(1,1,1));
    }
    public int getTotalCost()
    {
        return totalCost;
    }

    public List<IParcel>  getParcelList()
    {
        return parcelList;
    }

    public void addToTotalCost(int cost)
    {
        totalCost+=cost;
    }
}
