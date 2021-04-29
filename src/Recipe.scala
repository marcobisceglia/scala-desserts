import scala.collection.mutable.{HashMap, ListBuffer}

// Classe astratta
abstract class Recipe(var name: String, var people: Int, var time: Int, var level:LevelEnum.Value) extends Printable{
  var ingredients: HashMap[String, String] = new HashMap[String, String]
  var description: ListBuffer[String] = new ListBuffer[String]

  // overload costruttore
  def this(name: String) = this(name, 1, 60, LevelEnum.Facile)  
  
  // getters
  def getName: String = name
  def getPeople: Int = people
  def getTime: Int = time
  def getLevel: LevelEnum.Value = level
  def getIngredients: HashMap[String, String] = ingredients
  def getDescription: ListBuffer[String] = description

  // setters
  def setIngredients(i:HashMap[String,String]): Unit = {ingredients = i}
  def setDescription(d: ListBuffer[String]): Unit = {description = d}

  // metodi di Printable
  def printInfo(): Unit = {
    println(name.toUpperCase)
    println("Livello: " + level)
    println("Tempo: " + time + " minuti")
    println("Persone: " + people)
  }

  def printIngredients(): Unit = {
    println("INGREDIENTI")
    if (ingredients.nonEmpty) Utility.printMap(ingredients) else println("Non presenti")
  }

  def printDescription(): Unit = {
    println("DESCRIZIONE")
    if (description.nonEmpty) description.foreach(line => println("- " + line)) else println("Non presente")
  }

  def printAll(): Unit = {
    printInfo(); println()
    printIngredients(); println()
    printDescription(); println()
    println("****************************************************\n")
  }

  def printType(): Unit = println("Ricetta")
}
