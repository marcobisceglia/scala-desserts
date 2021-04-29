// Ereditarietà singola da Dessert
class ChocolateDessert(name: String, people: Int, time: Int, level:LevelEnum.Value, chocolate:String) extends Dessert(name, people, time, level){

  override def printInfo(): Unit = {
    super.printInfo()
    println("Cioccolato: " + chocolate)
  }

  override def printType(): Unit = println("Dessert al cioccolato")
}
