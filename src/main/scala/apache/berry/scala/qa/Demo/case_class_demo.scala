package apache.berry.scala.qa.Demo

case class Person(name : String, age : Int)

object  case_class_demo extends  App {

  // 1. NO New keyword is required
  val person1 = Person("John", 30)

  //2. Built in  value Equality

  val person2 = Person("John", 30)
  val person3 = Person("Berry", 32)

//  println(person1 == person2)
//  println(person1 == person3)

  //3. copy() method
  val olderJohn  = person1.copy(age = 40)
  println(person1)
  println( olderJohn)

  // toString
  println(person1)

  def pattern_match(person: Person): String = person match {
    case Person("John", age) => s"Hello John, you age is $age"
    case Person(name, age) if age>39 => s"Hey $name , you are matured"
    case Person(name, _) => s"Welcome , $name!!"
  }

  println(pattern_match(Person("John", 30)))
  println(pattern_match(Person("Berry", 50)))
}


