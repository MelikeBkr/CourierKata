package com.company;

import java.util.List;

public class HeavyParcelCalculation implements ICalculation
{
    private int weightDifference;
    private int updatedCost;
    static final int HEAVY_PARCEL_WEIGHT_LIMIT = 50;
    static final int OVERWEIGHT_UNIT_COST = 1;
    static final int HEAVY_PARCEL_STD_COST = 50;
    @Override
    public Invoice calculate(List<IParcel> parcelList, Invoice invoice)
    {
        for(IParcel parcel:parcelList)
        {
            if(parcel.getWeight()>HEAVY_PARCEL_WEIGHT_LIMIT)
            {
                invoice.setTotalCost(invoice.getTotalCost()-parcel.getCost());
                weightDifference = parcel.getWeight()-HEAVY_PARCEL_WEIGHT_LIMIT;
                updatedCost = HEAVY_PARCEL_STD_COST + weightDifference*OVERWEIGHT_UNIT_COST;
                parcel.setCost(updatedCost);
            }
            invoice.addParcelDetails(parcel,0);
            invoice.addToTotalCost(updatedCost);
        }
        return  invoice;
    }
}
