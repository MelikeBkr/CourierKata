package com.company;

import java.util.List;

public interface ICalculation
{
    public Invoice calculate(List<IParcel> parcelList, Invoice invoice);
}
