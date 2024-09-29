/*

Today's topic is about reviewing object-oriented programming (abbreviated OOP)
This basically means classes and objects

What is a class?
Classes are "categories" that can be a template for objects.
A class is a custom data type
A class is a collection of properties and methods that all "things" of that category (objects of that class) have
Classes allow us to simulate / represent real world entities
Classes allow us to easily reuse code (for properties/methods) for different "things" (objects) of the class

What is an object?
An object is a thing
An object is an instance of a class
An object is an individual example of a class
An object is a collection of properties (with values) and methods

What does the static keyword mean?
static means "related to the class"

What does static apply to?
methods (AKA functions)
variables (AKA properties)

What is a static method?
A method that is applied to the class
A method that can be called without an object
"An action performed by the class"

What is a static property?
A property of the class
A variable that can be referenced from the class without an object
Shared data that can be used by the entire class / all objects
Basically either information about the class or information used by all members of the class

What does non-static mean (the static term was omitted)?
Related to an object

What is a non-static method?
A method that is performed by an object of the class

What is a non-static property?
A property (variable, data, information, etc.) related to a specific object of that class

What is a constructor?
A special method that initializes all of the properties of an object
Creates and sets up objects

What does a constructor return?
A pointer

What is a pointer?
A reference to a specific memory address where some object's data resides
(see notes)

When you use == on two object variables (AKA two pointers), it checks that
the object variables are pointing to the same object (AKA the pointer addresses are the same)
This effectively causes the == operator to check if two object variables are the same object

This is different than the equals() method which checks if two objects have the same data
If two object variables point to the same object data, then obviously they have the same data
In other words, if == gives true, then .equals() will give true too
But the inverse is not necessarily true
Because you have two objects with the same data (causesing equals() to return true)
But they are indeed two different objects (so == would give false)

What is an overloaded method?
An overloaded method is a method whose NAME is used multiple times in the project
The method definition uses the same name but different return values and/or parameters
In other words, an overloaded method is one that has different versions for the same name
This could be applied to ANY kind of function, commonly including constructors
the Java compiler can figure out which function your calling based on its method signature (see below)
often with overloaded methods (especially constructors), we want these methods to do similar things
merely given the fact that they have the same function name 
(i.e. we expect two calculatAverage functions to do similar things)
however, since they both have their own function blocks, its possible they could do radically
different things
thus very often with method overloading, we put the code for the algorithm in one function
then have the other overloaded versions of the method setup different parameters
but then call the function that contains the main algorithm code

What is a method signature?
In Java, a method is identified not only by its name, but also its return value and parameters
because we can have overloaded methods, where the functions have the same name
but maybe different return values, different parameters
Java needs to be able to distinguish between these functions that have the same name
It does by also identifying a function by its inputs (parameters) and outputs (return values)
so basically when we create a method, its not identified just by its name,
the return type / parameters are what distinguish this method
method signature = return value + method name + parameters

What does it mean for a programming language to be "pass by value"?
Pass by value means that when an argument is passed to a function
The function will receive a COPY of the VALUE of that argument / that parameter
See the example changeX function below
Crucially, the function cannot change the value of the variable outside the function
If you want to update the value of a variable using a function, you need to use a return value
See the example doubleSquare function below
In general, the form for using a function to update a variable is as follows:
x = function(x)
Obviously there are other arrangements that are possible i.e.
x = function(x,y,z)
But the main idea is that, if we want a function to update a variable, we do so through its 
return value
Java is indeed pass by value ... there is often misconception about this
Contrasted with pass by value is pass by pointer
Although Java uses pointers, by being pass by value, Java just passes around COPIES
of the pointer number value
If some calling code and the function have copies of the same pointer value
They can manipulate and interact with the same object data
A technical note is that if the function tried to change what the pointer was pointing to
Then that change would NOT persist outside the function
See newMovie example below

What does it mean for a programming language to be "pass by pointer"?
Pass by pointer means that when an argument is passed to a function
The function receives a POINTER to where that variable is stored
Although Java uses pointers, it is NOT pass by pointer
Specifically, in Java, when you use a pointer (i.e. Object variable) as a parameter
The function receives a COPY of the POINTER VALUE
Remember that pointers are just numbers
So for example
Dog d = new Dog("Fido", 5);
d is just a number (often represented in hex, like 0xFA258E018)
When d is handed off to a function
That number (0xFA258E018) is just copied into the function's parameter
If Java were pass by pointer, it would actually pass a POINTER to that POINTER
Luckily, we don't have to mess with that
With primitives even, it would pass a pointer to the location of that primitive data
In pass by pointer languages, you can more easily allow functions to directly change primitive data
Making it a little more convenient to make persistent changes to the value of a parameter even outside the function
Again, Java is NOT pass by pointer
It uses pointers, but actually just passes around COPIES of that pointer number value



LETS PRACTICE

Create a new class Movie
Give it the following properties:
String title
String director
int publicationYear
String genre


*/

public class Main
{
  public static void main(String[] args)
  {

    /*
    Movie mov1 = new Movie("Super Mario Bros.", "Rocky Morton and Annabel Jankel", 1993, "Video Games");
    Movie mov2 = new Movie("Gino's Cool Movie", "Gino M", 2026, "Action");
    Movie mov3 = new Movie("Gino's Cooler Movie", "Gino M", 2027, "Action/Thriller");

    Movie mov4 = new Movie("SpiderMan", "MovieGuy", "Action");

    System.out.println(mov1.isNewMillenium());
    System.out.println(mov2.isNewMillenium());
    System.out.println(mov3.isNewMillenium());
    */

    // changeX example - notice value of myNumber is unchanged by changeX!
    /*
    int myNumber = 5;
    System.out.println("myNumber before function call:" + myNumber); // 5
    changeX(myNumber);
    System.out.println("myNumber after function call:" + myNumber); // 5 (importantly, myNumber did not change!)
    */

    // doubleSquare example - notice how we use the return value to update myOtherNumber
    /*
    double myOtherNumber = 5;
    System.out.println("myOtherNumber before function call: " + myOtherNumber); // 5
    myOtherNumber = doubleSquare(myOtherNumber);
    System.out.println("myOtherNumber after catching return value of function call: " + myOtherNumber); // 100
    */

    Movie m = new Movie("Teenage Mutant Ninja Turtles", "Jeff Rowe", 1990, "Action");
    System.out.println("Movie m pointer value outside newMovie function before change: " + m); // should be the same as pointer value before function call
    System.out.println("Movie m title outside newMovie function before change: " + m.title); // here prints titanic
    newMovie(m);
    System.out.println("Movie m pointer value outside newMovie function after change: " + m); // should be the same as pointer value before function call
    System.out.println("Movie m title outside newMovie function after change: " + m.title); // here prints "Teenage Mutant Ninja Turtles"
    
  }

  // notice this is VOID - no return value
  public static void changeX(int x)
  {
    System.out.println("x inside function call before change: " + x); // 5
    x = 0;
    System.out.println("x inside function call after change: " + x); // 0
  }

  // notice this is DOUBLE - returns a double
  public static double doubleSquare(double y)
  {
    System.out.println("y inside function call before change: " + y); // 5
    y = (y * 2) * (y * 2); // ()s unnecessary, just readability
    System.out.println("y inside function call after change: " + y); // 100
    return y;
    
  }

  // this function receives parameter Movie m
  // as discussed, since Java is pass by value
  // that means this function just receives a copy of the pointer VALUE given by m
  // if this function tries to change what m is pointing to
  // that is really just changing this function's number for the pointer m
  // and that change will not persist outside the function
  // notice this is VOID - no return value
  public static void newMovie(Movie m)
  {
    System.out.println("Movie m pointer value inside newMovie function before change: " + m); // should be the same as pointer value before function call
    System.out.println("Movie m title inside newMovie function before change: " + m.title); // here prints titanic
    m = new Movie("Titanic", "James Cameron", 1997, "Drama");
    System.out.println("Movie m pointer value inside newMovie function after change: " + m); // should be a new pointer value
    System.out.println("Movie m title inside newMovie function after change: " + m.title); // here prints Titanic
    
  }
  
}