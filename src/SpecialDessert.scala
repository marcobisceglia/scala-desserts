// Ereditarietà singola da Dessert
class SpecialDessert(name: String, people: Int, time: Int, level:LevelEnum.Value) extends Dessert(name, people, time, level){

  override def printIngredients(): Unit = println("INGREDIENTI: non resi visibili")

  override def printDescription(): Unit = println("DESCRIZIONE: non resa visibile")

  override def printType(): Unit = println("Dessert speciale")
}
