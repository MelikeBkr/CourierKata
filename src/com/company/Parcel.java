package com.company;

public class Parcel implements IParcel
{
    private SizeType sizeType;
    private int cost;
    private int weightLimit;
    private int weight;

    public Parcel(int weight, int depth, int height, int width)
    {
        this.cost = 0;
        this.weight = weight;

        if(width<10 && depth<10 && height<10)
        {
            this.sizeType = SizeType.SMALL;
            this.weightLimit = 1;
        }
        else if(width<50 && depth<50 && height<50)
        {
            this.sizeType = SizeType.MEDIUM;
            this.weightLimit = 3;
        }
        else if(width<100 && depth<100 && height<100)
        {
            this.sizeType = SizeType.LARGE;
            this.weightLimit = 6;
        }
        else if(width>=100 || depth>=100 || height>=100)
        {
            this.sizeType = SizeType.XLARGE;
            this.weightLimit = 10;
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

    @Override
    public void setWeightLimit(double weight) {

    }
    @Override
    public int getWeightLimit() {
        return weightLimit;
    }

    @Override
    public void setWeight(double weight) {

    }
    @Override
    public int getWeight() {
        return weight;
    }
}
