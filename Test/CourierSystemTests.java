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
        IParcel smallParcel = new Parcel(2,3,3);

        //When
        sys.addParcel(smallParcel);
        Invoice invoice = sys.calculateParcelCost();
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
        IParcel smallParcel = new Parcel(2,3,3);

        //When
        sys.addParcel(smallParcel);
        sys.setSpeedyShipping(true);
        Invoice invoice = sys.calculateParcelCost();
        List<IParcel> calculateParcelList = invoice.getParcelList();

        //Then
        for(IParcel parcel: calculateParcelList)
        {
            Assert.assertEquals(SizeType.SMALL, parcel.getSizeType());
            Assert.assertEquals(3, parcel.getCost());
        }
        Assert.assertEquals(6, invoice.getTotalCost());

    }


}
