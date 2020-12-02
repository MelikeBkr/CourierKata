import com.company.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CourierSystemTests {

    @Test
    public void sizeBasedCalcTest()
    {
        //Given
        CourierSystem sys = new CourierSystem();
        IParcel smallParcel = new Parcel(1,2,3,3);
        ICalculation sizeBasedCalc = new SizeBasedCalculation();

        //When
        sys.addParcel(smallParcel);
        Invoice invoice;
        invoice = sys.calculateParcelCost(sizeBasedCalc);

        for(Map.Entry<IParcel,Integer> entry:invoice.getParcelDetails().entrySet())
        {

            Assert.assertEquals(SizeType.SMALL, entry.getKey().getSizeType());
            Assert.assertEquals(3, entry.getKey().getCost());
            System.out.println("parcel type: "+ entry.getKey().getSizeType() +" saving: "+ entry.getValue());
        }
        Assert.assertEquals(3, invoice.getTotalCost());
        System.out.println("total cost after calculation:"+ invoice.getTotalCost());

    }

    @Test
    public void speedyShippingTest()
    {
        //Given
        CourierSystem sys = new CourierSystem();
        IParcel smallParcel = new Parcel(1,2,3,3);
        ICalculation sizeBasedCalc = new SizeBasedCalculation();
        ICalculation shippingTypeBasedCalc = new ShippingTypeBasedCalculation();

        //When
        sys.addParcel(smallParcel);
        Invoice invoice;
        invoice = sys.calculateParcelCost(sizeBasedCalc);
        invoice = sys.calculateParcelCost(shippingTypeBasedCalc);

        //Then
        for(Map.Entry<IParcel,Integer> entry:invoice.getParcelDetails().entrySet())
        {

            Assert.assertEquals(SizeType.SMALL, entry.getKey().getSizeType());
            Assert.assertEquals(3, entry.getKey().getCost());
            System.out.println("parcel type: "+ entry.getKey().getSizeType() +" saving: "+ entry.getValue());
        }
        Assert.assertEquals(6, invoice.getTotalCost());
        System.out.println("total cost after calculation:"+ invoice.getTotalCost());

    }

    @Test
    public void weightBasedCalculationTest()
    {
        //Given
        CourierSystem sys = new CourierSystem();
        IParcel smallParcel = new Parcel(6,2,3,3);
        ICalculation sizeBasedCalc = new SizeBasedCalculation();
        ICalculation shippingTypeBasedCalc = new ShippingTypeBasedCalculation();
        ICalculation weightBasedCalc = new WeightBasedCalculation();

        //When
        sys.addParcel(smallParcel);
        Invoice invoice;
        invoice = sys.calculateParcelCost(sizeBasedCalc);
        invoice = sys.calculateParcelCost(weightBasedCalc);

        //Then
        for(Map.Entry<IParcel,Integer> entry:invoice.getParcelDetails().entrySet())
        {

            Assert.assertEquals(SizeType.SMALL, entry.getKey().getSizeType());
            Assert.assertEquals(13, entry.getKey().getCost());
            System.out.println("parcel type: "+ entry.getKey().getSizeType() +" saving: "+ entry.getValue());
        }
        Assert.assertEquals(13, invoice.getTotalCost());
        System.out.println("total cost after calculation:"+ invoice.getTotalCost());

    }


    @Test
    public void heavyParcelCalculationTest()
    {
        //Given
        CourierSystem sys = new CourierSystem();
        IParcel smallParcel = new Parcel(60,2,3,3);
        //Heavy parcel calculation should override size based calculation
        //Size based calc will be discarded
        ICalculation sizeBasedCalc = new SizeBasedCalculation();
        ICalculation heavyParcelCalc = new HeavyParcelCalculation();

        //When
        sys.addParcel(smallParcel);
        Invoice invoice;
        invoice = sys.calculateParcelCost(sizeBasedCalc);
        invoice = sys.calculateParcelCost(heavyParcelCalc);

        //Then
        for(Map.Entry<IParcel,Integer> entry:invoice.getParcelDetails().entrySet())
        {

            Assert.assertEquals(SizeType.SMALL, entry.getKey().getSizeType());
            Assert.assertEquals(60, entry.getKey().getCost());
            System.out.println("parcel type: "+ entry.getKey().getSizeType() +" saving: "+ entry.getValue());
        }
        Assert.assertEquals(60, invoice.getTotalCost());
        System.out.println("total cost after calculation:"+ invoice.getTotalCost());

    }

    @Test
    public void promoIncludedCalculationTest()
    {
        //Given
        CourierSystem sys = new CourierSystem();
        IParcel smallParcel1 = new Parcel(1,2,3,3);
        IParcel smallParcel2 = new Parcel(1,2,3,3);
        IParcel smallParcel3 = new Parcel(1,2,3,3);
        IParcel smallParcel4 = new Parcel(1,2,3,3);


        ICalculation sizeBasedCalc = new SizeBasedCalculation();
        ICalculation promoIncludedCalc = new PromoIncludedCalculation();

        //When
        sys.addParcel(smallParcel1);
        sys.addParcel(smallParcel2);
        sys.addParcel(smallParcel3);
        sys.addParcel(smallParcel4);
        Invoice invoice;
        invoice = sys.calculateParcelCost(sizeBasedCalc);
        invoice = sys.calculateParcelCost(promoIncludedCalc);

        //Then
        int promoCount = 3;
        for(Map.Entry<IParcel,Integer> entry:invoice.getParcelDetails().entrySet())
        {
            Assert.assertEquals(SizeType.SMALL, entry.getKey().getSizeType());
            if(promoCount != 0)
            {
                Assert.assertEquals(3, entry.getKey().getCost());
            }
            else
            {
                Assert.assertEquals(0, entry.getKey().getCost());
            }
            --promoCount;
            System.out.println("parcel type: "+ entry.getKey().getSizeType() +" saving: "+ entry.getValue());
        }
        Assert.assertEquals(9, invoice.getTotalCost());
        System.out.println("total cost after calculation:"+ invoice.getTotalCost());

    }
}
