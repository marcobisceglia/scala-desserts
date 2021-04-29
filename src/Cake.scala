// Ereditarietà singola da Dessert
class Cake(name: String, people: Int, time: Int, level:LevelEnum.Value, diameter:Int) extends Dessert(name, people, time, level){

  override def printInfo(): Unit = {
    super.printInfo()
    println("Diametro: " + diameter + " cm")
  }

  override def printType(): Unit = println("Torta")
}
