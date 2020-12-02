package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CourierSystem
{
    List<IParcel> parcelList;
    Invoice curInvoice;
    boolean speedyShipping;

    public void setSpeedyShipping(boolean speedyShipping) {
        this.speedyShipping = speedyShipping;
    }

    public CourierSystem()
    {
        this.parcelList = new ArrayList<>();
        this.curInvoice = new Invoice();
        this.speedyShipping = false;
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
            this.curInvoice.addParcel(parcel);
            this.curInvoice.addToTotalCost(parcel.getCost());
        }
        if(this.speedyShipping)
        {
            this.curInvoice.setTotalCost(curInvoice.getTotalCost()*2);
        }

        return this.curInvoice;
    }

    public static void main(String[] args)
    {

    }

}
