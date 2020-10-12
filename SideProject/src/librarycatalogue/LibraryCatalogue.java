
package librarycatalogue;

import java.util.HashMap;
import java.util.Map;


public class LibraryCatalogue {
    
    // Properties/Fields/Global Variables
    Map<String, Book> bookCokkection = new HashMap<String,Book>();
    int currentDay = 0;
    int lengthOfCheckoutPeriod = 7;
    double initialLateFee = 0.50;
    double feePerLateDay = 1.00;
    
    
    //Constructors
    public LibraryCatalogue(Map<String, Book> collection){
        this.bookCokkection = collection;
    }
    
    public LibraryCatalogue(Map<String, Book> collection, int lengthOfCheckoutPeriod,
            double initialLateFee, double feePerLateDay){
        this.bookCokkection = collection;
        this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
        this.initialLateFee = initialLateFee;
    }
    
    // Getters 
    public int getCurrentDay(){
        return this.currentDay;
    }
    
    public Map<String, Book> getBookCollection(){
        return this.bookCokkection;
    }
    
    public Book getBook(String bookTitle){
        return getBookCollection().get(bookTitle);
    }
    
    public int getLengthOfCheckoutPerioud(){
        return this.lengthOfCheckoutPeriod;
    }
    
    public double getInitialLateFee(){
        return this.initialLateFee;
    }
    
    public double getFeePerLateDay(){
        return this.feePerLateDay;
    }
    
    // Setters 
    public void nextDay(){
        currentDay++;
    }
    public void setDay(int day){
        currentDay = day;
    }
    
    //Instance methods
    
    public void checkOutBook(String title){
      Book book =  getBook(title);
      if(book.getIsCheckedOut()){
          sorryBookAlreadyCheckOut(book);
      }else{
          book.setIsCheckedOut(true, currentDay);
          System.out.println("You just checked out "+ title +". It is due on day " +
                  (book.getDayCheckedOut()+
                          getLengthOfCheckoutPerioud())+".");
      }
    }
    
     public void returnBook(String title){
         Book book =  getBook(title);
         int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfCheckoutPerioud());
         if(daysLate > 0) {
             System.out.println("You owe the library $" + (getInitialLateFee() + daysLate * getFeePerLateDay()) +
                     "because your book is " + daysLate + "days overdue.");
         }else{
             System.out.println("Book Reruned. Thank you");
     }
         book.setIsCheckedOut(false, -1);
     }
     
     public void sorryBookAlreadyCheckOut(Book book){
         System.out.println("Sorry, " + book.getTitile() + "is already checked out ."
            + "It should be back on day " + (book.getDayCheckedOut() + getLengthOfCheckoutPerioud())+ ".");
     }
    
    

    public static void main(String[] args) {
        
        Map<String, Book> bookCollection =  new HashMap<String, Book>();
        Book harry =  new Book("harry Potter", 827132, 999999);
        bookCollection.put("Harry Potter", harry);
        LibraryCatalogue lib =  new LibraryCatalogue(bookCollection);
        lib.checkOutBook("Harry Potter");
        lib.nextDay();
        lib.nextDay();
        lib.checkOutBook("Harry Potter");
        lib.setDay(17);
        lib.returnBook("Harry Potter");
        lib.checkOutBook("Harry Potter");
        
       
    
}
}