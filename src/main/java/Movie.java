/*
Create a new class Movie
Give it the following properties:
String title
String director
int publicationYear
String genre
*/

public class Movie
{
  
  public String title;
  public String director;
  public int publicationYear;
  public String genre;

  public Movie(String title, String director, int publicationYear, String genre)
  {
    this.title = title;
    this.director = director;
    this.publicationYear = publicationYear;
    this.genre = genre;
  }

  public Movie(String title, String director, String genre)
  {
    this(title, director, 2024, genre);
  }

  // create a public non-static boolean method called isNewMillenium
  // which returns true if the publicationYear of this movie is greater than or equal to 2000

  public boolean cameOutAfter(int year)
  {
    return publicationYear >= year;
    /*
    if (this.publicationYear >= 2000)
    {
      return true;
    }
    return false;
    */
  }
  
}