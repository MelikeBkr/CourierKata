package com.company;

public class Parcel implements IParcel
{
    private SizeType sizeType;
    private int cost;

    public Parcel(int depth, int height, int width)
    {
        this.cost = 0;

        if(width<10 && depth<10 && height<10)
        {
            this.sizeType = SizeType.SMALL;
        }
        else if(width<50 && depth<50 && height<50)
        {
            this.sizeType = SizeType.MEDIUM;
        }
        else if(width<100 && depth<100 && height<100)
        {
            this.sizeType = SizeType.LARGE;
        }
        else if(width>=100 || depth>=100 || height>=100)
        {
            this.sizeType = SizeType.XLARGE;
        }
    }

    @Override
    public int getCost() {
        return cost;
    }
    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }


    @Override
    public SizeType getSizeType()
    {
        return sizeType;
    }

}
