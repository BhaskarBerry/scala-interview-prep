package apache.berry.scala.qa

/*
"""
What is a Companion Object in Scala?

A companion object is a Scala object that:
Has the same name as a class.
Is defined in the same source file as that class.
Can access the class's private members.
Commonly contains factory methods, constants, utility methods, and apply() methods related to the class.
"""
*/
class Person private  (val name : String, val age : Int){
  private  def secretMsg: String = s"$name is $age years old -secret"
}


object Person {
  // Companion Object
  //1. Apply method
  //2. Constants
  //3. Private constructor
  //4. Accessing Private members

  val DefaultAge = 18
  def apply(name: String, age:Int) : Person = {
    require(age >= 0 , "Age cannot be negative")
    require(name.nonEmpty , "Name cannot be Empty")

    new Person(name, age)
  }

  def apply(name: String) : Person = new Person(name, DefaultAge)

  def describe(person: Person) : String = person.secretMsg

}

object Main{
  def main(args: Array[String]): Unit = {

    val person2  = Person("Berry")
    val person1  = Person( "John", 45)
//    println(person1)
//    println(person1.name)
//    println(person2.age)
   println(Person.describe(person1))

  }

}


/*
class Person(val name: String, val age: Int)

object Person {

  def apply(name: String, age: Int): Person =
    new Person(name, age)

  def main(args: Array[String]): Unit = {

    // Using new
    val person1 = new Person("John", 20)

    // Using companion object's apply()
    val person2 = Person("Alice", 25)

    println(s"Person 1: ${person1.name}, ${person1.age}")
    println(s"Person 2: ${person2.name}, ${person2.age}")
  }
}
 */

/*
unapply and Pattern Matching

So far, we've seen apply for creating objects.

Companion objects can also define unapply, which is commonly used to extract values from objects during pattern matching.

Let's add unapply to our Person companion:

object Person {

  private var counter = 0

  private def nextId(): Int = {
    counter += 1
    counter
  }

  def apply(name: String, age: Int): Person =
    new Person(name, age)

  def unapply(person: Person): Option[(String, Int)] =
    Some((person.name, person.age))
}

Now we can create a person:

val person = Person("John", 25)

And use pattern matching:

person match {
  case Person(name, age) =>
    println(s"$name is $age years old")
}

The output is:

John is 25 years old

Here, apply is commonly used to construct, while unapply is used to extract values for pattern matching.

A simple way to remember this is:

apply → create

unapply → extract
 */