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
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalCost()
    {
        return totalCost;
    }

    public List<IParcel>  getParcelList()
    {
        return parcelList;
    }

    public void addParcel(IParcel parcel)
    {
        parcelList.add(parcel);
    }

    public void addToTotalCost(int cost)
    {
        totalCost+=cost;
    }
}
