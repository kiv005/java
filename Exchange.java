import java.util.*;

public class Exchange{
  public static void main(String[] args){
    System.out.print("Hi, and welcome to yet another INF100 retakee's program.\nThis one converts currency between NOK and USD.\nPlease enter the currency to convert to (USD/GBP/EUR).");
    
    boolean usd = false;
    boolean eur = false;
    boolean gbp = false;
    boolean done = false;
    
    Scanner sc = new Scanner(System.in);
    String answer = "";
    
    while(!done){
    answer = sc.next();
    answer = answer.toLowerCase();
   
      if(answer.equals("usd"))
      {usd = true; done = true;}
      else if(answer.equals("eur"))
      {eur = true; done = true;}
      else if(answer.equals("gbp"))
      {gbp = true; done = true;}
      else System.out.println("Feed me a currency!");
     }
    
    sc.close();
    
    System.out.println("How much NOK would you like to convert?");
    double amount = 0;
    
    Scanner sc2 = new Scanner(System.in);
    
    boolean ready = false;
    
    while(!ready){
      try{
        amount = sc2.nextDouble();
        ready = true;
      } catch(Exception e){
        System.out.println("This is not a number, silly!");
        sc2.next();
      }
    }

    
      if(usd == true){
        System.out.printf("%.2f NOK equals %.2f USD.", amount, (amount*(0.13)));
      }
      else if(eur == true){
        System.out.printf("%.2f NOK equals %.2f EUR.", amount, (amount*(0.11)));
      }
      else if(gbp == true){
        System.out.printf("%.2f NOK equals %.2f GBP.", amount, (amount*(0.099)));
      }
    }
}     
