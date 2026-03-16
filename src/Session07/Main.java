//package Session07;
//
//public class Main {
//    public static void main(String[] args){
//
//        Database database=new Database();
//        PaymentMethod paymentMethod=new CreditCard();
//        Notification notification=new EmailSender();
//
//        OrderProcessor processor=new OrderProcessor(database,paymentMethod,notification);
//
//        Order order=new Order(1,500);
//
//        processor.process(order);
//    }
//}
