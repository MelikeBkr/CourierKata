package com.company;

import java.util.List;

public class ShippingTypeBasedCalculation implements ICalculation
{
    @Override
    public Invoice calculate(List<IParcel> parcelList, Invoice invoice)
    {
        invoice.setTotalCost(invoice.getTotalCost()*2);

        return invoice;
    }
}
