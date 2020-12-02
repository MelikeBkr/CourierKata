import com.company.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


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

        List<IParcel> calculateParcelList = invoice.getParcelList();

        //Then
        for(IParcel parcel: calculateParcelList)
        {
            Assert.assertEquals(SizeType.SMALL, parcel.getSizeType());
            Assert.assertEquals(3, parcel.getCost());
        }
        Assert.assertEquals(3, invoice.getTotalCost());

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
        List<IParcel> calculateParcelList = invoice.getParcelList();

        //Then
        for(IParcel parcel: calculateParcelList)
        {
            Assert.assertEquals(SizeType.SMALL, parcel.getSizeType());
            Assert.assertEquals(3, parcel.getCost());
        }
        Assert.assertEquals(6, invoice.getTotalCost());

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
        List<IParcel> calculateParcelList = invoice.getParcelList();

        //Then
        for(IParcel parcel: calculateParcelList)
        {
            Assert.assertEquals(SizeType.SMALL, parcel.getSizeType());
            Assert.assertEquals(13, parcel.getCost());
        }
        Assert.assertEquals(13, invoice.getTotalCost());

    }
}
