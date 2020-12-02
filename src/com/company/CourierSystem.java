package com.company;
import java.util.List;


public class CourierSystem
{
    List<IParcel> parcelList;
    Invoice curInvoice;

    public CourierSystem()
    {

        curInvoice = new Invoice();

    }

    public void addParcel(IParcel parcel)
    {
        //TODO
    }

    public Invoice calculateParcelCost()
    {

       //TODO:Calculate Parcel Cost
        return curInvoice;
    }

    public static void main(String[] args)
    {

    }

}
