package com.company;

import java.util.List;

public class SizeBasedCalculation implements ICalculation
{
    @Override
    public Invoice calculate(List<IParcel> parcelList, Invoice invoice)
    {
        for(IParcel parcel:parcelList)
        {
            if(parcel.getSizeType()==SizeType.SMALL)
            {
                parcel.setCost(3);
            }
            else if(parcel.getSizeType()==SizeType.MEDIUM)
            {
                parcel.setCost(8);
            }
            else if (parcel.getSizeType()==SizeType.LARGE)
            {
                parcel.setCost(15);
            }
            else if(parcel.getSizeType()==SizeType.XLARGE)
            {
                parcel.setCost(25);
            }
            invoice.addParcelDetails(parcel,0);
            invoice.addToTotalCost(parcel.getCost());
        }
        return invoice;
    }
}
