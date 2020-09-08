package Solid_Demo;

//Interface Segregation
interface Order{
    public void orderDetails();
}
interface Payment{
    public void paymentDetails();
}

interface billInfo{
    void billDetails(String info);
}

class orderInfo implements Order{
    public String order;
    orderInfo(String order){
        this.order=order;
    }
    @Override
    public void orderDetails() {
        System.out.println("The dish ordered is: "+order);
    }
}

//Open-Closed, LSP
class Restaurant extends orderInfo implements Order{
    public int time;
    Restaurant(String order,int time){
        super(order);
        this.time=time;
    }
    public void prepare(){
        System.out.println("Your order "+order+" will be ready in "+time+" mins");
    }
    @Override
    public void orderDetails() {
        super.orderDetails();
        System.out.println("Your order has been accepted by the Restaurant");
    }
}
//Single Responsibility
class paymentInfo implements Payment{
    protected String paymode;
    private double amount;
    paymentInfo(String paymode,double amount){
        this.amount=amount;
        this.paymode=paymode;

    }
    @Override
    public void paymentDetails() {
        System.out.println("Payment done through "+paymode+" and the amount is: "+amount);
    }
}

//Dependency Inverse

class checkBill implements billInfo {
    public void billDetails(String info){
        System.out.println("Bill Status: "+info);
    }
}

class billStatus{
    private billInfo b;
    billStatus(billInfo b){
        this.b=b;
    }
    public void status(){
        b.billDetails("The bill has been paid");
    }

}

public class SolidDemo {
    public static void main(String[] args) {
        Restaurant r=new Restaurant("Dosa",10);
        r.orderDetails();
        r.prepare();
        billStatus obj=new billStatus(new checkBill());
        obj.status();
        paymentInfo p=new paymentInfo("Netbanking",30);
        p.paymentDetails();
      ;
    }
}
