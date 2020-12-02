package com.company;

import java.util.List;

public class WeightBasedCalculation implements ICalculation
{
    private int weightDifference;
    private int extraWeightCost;
    @Override
    public Invoice calculate(List<IParcel> parcelList, Invoice invoice){
        for(IParcel parcel:parcelList)
        {
            weightDifference = parcel.getWeight()-parcel.getWeightLimit();
            if(weightDifference>0)
            {
                extraWeightCost = weightDifference*2;
                parcel.setCost(parcel.getCost()+extraWeightCost);
            }
            invoice.addParcel(parcel);
            invoice.addToTotalCost(extraWeightCost);
        }
        return invoice;
    }
}
