// Ereditarietà singola da classe astratta Recipe
class Dessert(name: String, people: Int, time: Int, level:LevelEnum.Value) extends Recipe(name, people, time, level){
  override def printType(): Unit = println("Dessert")
}
