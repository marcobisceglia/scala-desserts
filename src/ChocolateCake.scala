// Non posso ereditare da Cake e ChocolateDessert come in C++
// Ereditarietà singola da Dessert
class ChocolateCake(name: String, people: Int, time: Int, level:LevelEnum.Value, diameter:Int, chocolate:String) extends Dessert(name, people, time, level){

  override def printInfo(): Unit = {
    super.printInfo()
    println("Diametro: " + diameter)
    println("Cioccolato: " + chocolate)
  }

  override def printType(): Unit = println("Torta al cioccolato")
}
