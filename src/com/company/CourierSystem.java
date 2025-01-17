package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CourierSystem
{
    List<IParcel> parcelList;
    Invoice curInvoice;


    public CourierSystem()
    {
       parcelList = new ArrayList<>();
        HashMap<IParcel,Integer> parcelDiscountMap = new HashMap<>();
        curInvoice = new Invoice(parcelDiscountMap);
    }
    public void addParcel(IParcel parcel)
    {
        parcelList.add(parcel);
    }

    public Invoice calculateParcelCost(ICalculation costType)
    {
        costType.calculate(parcelList, curInvoice);

        return curInvoice;
    }

    public static void main(String[] args)
    {

    }

}
