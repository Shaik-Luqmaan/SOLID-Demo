package Solid_Demo;

interface IOrder {
    public void orderDetails();

}
interface IPayment {
    public void paymentDetails();
}

interface IBillInformation {
    void billDetails(String info);
}

class OrderInformation implements IOrder {
    public String order;
    OrderInformation(String order){
        this.order=order;
    }
    @Override
    public void orderDetails() {
        System.out.println(
                "The dish ordered is: "+order
        );
    }
}
class Restaurant extends OrderInformation implements IOrder {
    public int time;
    Restaurant(String order,int time){
        super(order);
        this.time=time;
    }
    public void prepareOrder(){
        System.out.println(
                "Your order "+order+" will be ready in "+time+" mins"
        );
    }
    @Override
    public void orderDetails() {
        super.orderDetails();
        System.out.println(
                "Your order has been accepted by the Restaurant"
        );
    }
}
class PaymentInformation implements IPayment {
    protected String paymentMode;
    private double amount;
    PaymentInformation(String paymentMode, double amount){
        this.amount=amount;
        this.paymentMode = paymentMode;

    }
    @Override
    public void paymentDetails() {
        System.out.println(
                "Payment done through "+ paymentMode +" and the amount is: "+amount
        );
    }
}
class CheckBill implements IBillInformation {
    public void billDetails(String info){
        System.out.println(
                "Bill Status: "+info
        );
    }
}
class BillStatus{
    private IBillInformation IBillInformation;
    BillStatus(IBillInformation IBillInformation){
        this.IBillInformation = IBillInformation;
    }
    public void status(){
        IBillInformation.billDetails("The bill has been paid");
    }
}

public class SolidDemo {
    public static void main(String[] args) {
        Restaurant restaurantObject=new Restaurant("Dosa",10);
        restaurantObject.orderDetails();
        restaurantObject.prepareOrder();
        BillStatus billObject=new BillStatus(new CheckBill());
        billObject.status();
        PaymentInformation paymentObject=new PaymentInformation("Netbanking",30);
        paymentObject.paymentDetails();
      ;
    }
}
