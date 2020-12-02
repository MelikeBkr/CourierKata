# Courier Kata

A system that calculates the cost of delivering the package order. TDD approach is used while implementing use cases. For each use case; a relevant test case is written then implementation is finalized accordingly. TDD helped to refactor the existing system more reliable way. Each phase of implementation is explained in the given requirements. So, implementation is evolved after each use case is implemented.   

## Setup

* Ensure that you have IntelliJ IDEA installed (Ref:IntelliJ IDEA 2020.2.3 (Community Edition))
* Ensure that you have junit-4.12 library is added.
* After cloning the repository to local, the relevant project can be opened in Intellij IDEA


## Cases & Approach

### Case1: Standard Size Based Calculation
```
● Small parcel: all dimensions < 10cm. Cost $3
● Medium parcel: all dimensions < 50cm. Cost $8
● Large parcel: all dimensions < 100cm. Cost $15
● XL parcel: any dimension >= 100cm. Cost $25
```
- **CourierSystem:** main class, initially calculate the cost
- **Parcel  :** contains all properties and their get/set methods
- **IParcel :** Parcel class interface in case of different item types might be added in the future
- **SizeType :** stores size enums
- **Invoice :** stores parcel and total cost information


### Case2: Speedy shipping option
By defining the speedy shipping flag, the delivery option is identified.
When speedy shipping is preferred then the total size become doubled. The calculation is implemented in CourierSystem.


### Case3: Weight Based Calculation

```
+$2/kg over weight limit for parcel size:
● Small parcel: 1kg
● Medium parcel: 3kg
● Large parcel: 6kg
● XL parcel: 10kg

```

From this point on, the Strategy Pattern would be appropriate to be applied due to the variety of calculation methods.

- **ICalculation:** Interface of classes that need to be created for different calculation methods
- **ShippingTypeBasedCalculation:** contains the implementation for Speedy Shipping Option (This calculation was in the CourierSystem class previously)
- **WeightBasedCalculation:** It calculates the additional cost at the rate it exceeds the specified weight limits.
- **SizeBasedCalculation:** Calculates standard size based cost. It is the base calculation method.(This calculation was in the CourierSystem class previously)


### Case4: Overweight Calculation

```
Heavy parcel (limit 50kg), $50. +$1/kg over
```
The **WeightBasedCalculation** class has been added as a new strategy.

### Case5: Promotion Based Calculation

```
● Small parcel mania! Every 4th small parcel in an order is free!
● Medium parcel mania! Every 3rd medium parcel in an order is free!
● Mixed parcel mania! Every 5th parcel in an order is free!


● Each parcel can only be used in a discount once
● Within each discount, the cheapest parcel is the free one
● The combination of discounts which saves the most money should be selected every
time
```

**PromoIncludedCalculation** class is implemented as a new calculation strategy. It makes every 4th small, every 3rd medium, and every 5th parcel(regardless of size) free.

Due to time constraints, the implementation of the following 3 items could not be completed.

```
● Each parcel can only be used in a discount once
● Within each discount, the cheapest parcel is the free one
● The combination of discounts which saves the most money should be selected every
time
```

##Final Solution:
It was noticed that there was more than one calculation requirement, and it was decided to use the Strategy Pattern in the solution. Based on each use case, a different strategy was selected and applied with the corresponding order. Due to many strategies, selection, and application of the corresponding strategy were delegated to the user which leads to more complex operations. For solving this complexity, the Facade Pattern was thought of but could not be applied due to time constraints. So, it can wrap the complexity and provide a simple interface to the user.


##Final Notes:

In 2 hours, the solution could not be completed fully. 

Missing points; adding additional test cases, testing edge cases, implementation of the 3 restrictions in the promotional-based calculation, and adding the Facade pattern to reduce complexity. 


