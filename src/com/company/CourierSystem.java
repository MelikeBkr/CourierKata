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
        curInvoice = new Invoice();
    }
    public void addParcel(IParcel parcel)
    {
        parcelList.add(parcel);
    }

    public Invoice calculateParcelCost()
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
            curInvoice.addParcel(parcel);
            curInvoice.addToTotalCost(parcel.getCost());
        }
        return curInvoice;
    }

    public static void main(String[] args)
    {

    }

}
