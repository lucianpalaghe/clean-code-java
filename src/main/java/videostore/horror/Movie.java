package videostore.horror;


// Daniel, dupa 2 min: "nu facem si noi Movie abstract" <- extinsa de ChildrenMovie, RegularMovie...   polimorfic sa contina metode diferite de a face compute>XXX
public class Movie {
   enum Category {
      REGULAR,
      NEW_RELEASE,
      CHILDREN
   }

   private final String title;
   private final Category category;

   public Movie(String title, Category category) {
      this.title = title;
      this.category = category;
   }

   public Category getCategory() {
      return category;
   }

   public String getTitle() {
      return title;
   }

   ;
}