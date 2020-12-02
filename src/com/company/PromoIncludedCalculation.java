package com.company;

import java.util.List;

public class PromoIncludedCalculation implements ICalculation
{
    private int smallParcelCount;
    private int mediumParcelCount;
    private int otherParcelCount;
    private static final int SMALL_PARCEL_PROMO = 4;
    private static final int MEDIUM_PARCEL_PROMO = 3;
    private static final int OTHER_PARCEL_PROMO = 5;
    private int bestPromo = Integer.MAX_VALUE;
    private int discountAmount;
    @Override
    public Invoice calculate(List<IParcel> parcelList, Invoice invoice)
    {
        for(IParcel parcel:parcelList)
        {
            discountAmount = 0;
            if(parcel.getSizeType()==SizeType.SMALL)
            {
                smallParcelCount++;
                if(smallParcelCount==SMALL_PARCEL_PROMO)
                {
                    discountAmount -= parcel.getCost();
                    parcel.setCost(0);
                    smallParcelCount = 0;
                }
            }
            else if(parcel.getSizeType()==SizeType.MEDIUM)
            {
                mediumParcelCount++;
                if(mediumParcelCount==MEDIUM_PARCEL_PROMO)
                {
                    discountAmount -= parcel.getCost();
                    parcel.setCost(0);
                    mediumParcelCount = 0;
                }
            }
            else
            {
                otherParcelCount++;
                if(otherParcelCount+smallParcelCount+mediumParcelCount==OTHER_PARCEL_PROMO)
                {
                    discountAmount -= parcel.getCost();
                    parcel.setCost(0);
                    otherParcelCount=0;
                    smallParcelCount=0;
                    mediumParcelCount=0;
                }
            }
            bestPromo = Math.min(discountAmount,bestPromo);
            invoice.addToTotalCost(bestPromo);
            invoice.addParcelDetails(parcel,discountAmount);
        }
        return invoice;
    }
}
