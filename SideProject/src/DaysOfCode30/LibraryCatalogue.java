
package DaysOfCode30;

import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {

    // Properties/ Filds / Global Variables
   Map<String, Book> bookCollection = new HashMap<String, Book>();
   int currentDay = 0;
   int lengthOfCheckoutPeriod = 7;
   double initialLateFee = 0.50;
   double feePerLateDay = 1.00;
   
   
   //Constructors
   public LibraryCatalogue(Map<String, Book> collection){
       this.bookCollection = collection;
   }
   
   public LibraryCatalogue(Map<String, Book> collection, int lengthOfCheckoutPeriod, 
           double initialLateFee, double feePerLateDay ){
       this.bookCollection = collection;
       this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
       this.initialLateFee = initialLateFee;
       this.feePerLateDay = feePerLateDay;
   }

   // Getters Setters
   public Map<String, Book> getBookCollection() {
        return this.bookCollection;
    }

    public void setBookCollection(Map<String, Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    public int getCurrentDay() {
        return this.currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public int getLengthOfCheckoutPeriod() {
        return this.lengthOfCheckoutPeriod;
    }

    public void setLengthOfCheckoutPeriod(int lengthOfCheckoutPeriod) {
        this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
    }

    public double getInitialLateFee() {
        return this.initialLateFee;
    }

    public void setInitialLateFee(double initialLateFee) {
        this.initialLateFee = initialLateFee;
    }

    public double getFeePerLateDay() {
        return this.feePerLateDay;
    }

    public void setFeePerLateDay(double feePerLateDay) {
        this.feePerLateDay = feePerLateDay;
    }
    public Book getBook(String bookTitle){
        return  getBookCollection().get(bookTitle);
    }
    
    public void nextDay(){
        currentDay++;
    }
    
    public void setDay(int day){
        currentDay = day;
    }
    
    
    
    // INSTANCE METHODS
    
    public void checkOutBook(String title){
      Book book =  getBook(title);
      if(book.getIsCheckedOut()){
          sorryBookAlreadyCheckOut(book);
      }else{
          book.setIsCheckedOut(true, currentDay);
          System.out.println("You just checked out "+ title +". It is due on day " +
                  (book.getDayCheckedOut()+
                          getLengthOfCheckoutPeriod())+".");
      }
    }
    
     public void returnBook(String title){
         Book book =  getBook(title);
         int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfCheckoutPeriod());
         if(daysLate > 0) {
             System.out.println("You owe the library $" + (getInitialLateFee() + daysLate * getFeePerLateDay()) +
                     "because your book is " + daysLate + "days overdue.");
         }else{
             System.out.println("Book Reruned. Thank you");
     }
         book.setIsCheckedOut(false, -1);
     }
     
     public void sorryBookAlreadyCheckOut(Book book){
         System.out.println("Sorry, " + book.getTitle() + "is already checked out ."
            + "It should be back on day " + (book.getDayCheckedOut() + getLengthOfCheckoutPeriod())+ ".");
     }
   
    public static void main(String[] args) {
        // TODO code application logic here
        Map<String, Book> bookCollection = new HashMap<String, Book>();
        Book harry =  new Book("Harry Potter", 827123, 99999998 );
        bookCollection.put("Herry Potter", harry);
        LibraryCatalogue lib  =  new LibraryCatalogue(bookCollection);
        lib.checkOutBook("Harry Potter");
        lib.nextDay();
        lib.nextDay();
        lib.checkOutBook("Harry Potter");
        lib.setDay(17);
        lib.returnBook("Harry Potter");
        lib.checkOutBook("Harry Potter");
        
        
    }
}

    

