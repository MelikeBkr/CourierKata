package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Invoice
{
    private int totalCost;
    private HashMap<IParcel,Integer> parcelDiscountMap;

    public Invoice(HashMap<IParcel,Integer> parcelDiscountMap)
    {
        this.parcelDiscountMap = parcelDiscountMap;
        totalCost = 0;
    }

    public HashMap<IParcel,Integer> getParcelDetails()
    {
        return parcelDiscountMap;
    }
    public void addParcelDetails(IParcel parcel,int discount)
    {
        parcelDiscountMap.put(parcel,discount);
    }


    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalCost()
    {
        return totalCost;
    }

    public void addToTotalCost(int cost)
    {
        totalCost+=cost;
    }
}
