import scala.collection.mutable.{HashMap, ListBuffer}

// Singleton object
object Cookbook{
  var desserts = new ListBuffer[Recipe]

  def getDessertFromInfo(map: HashMap[String, String]):Dessert = {
    var isCake = false
    var isChocolate = false
    var name:String = ""
    var level:LevelEnum.Value = LevelEnum.Facile
    var minutes:Int = 0
    var people:Int = 0
    var diameter:Int = 0
    var chocolate:String = ""
    var dessert:Dessert = null

    for ((key, value) <- map){
      // stabilisco se è dessert, cake, chocolate o chocolate dessert
      if (key == "diametro"){
        isCake = true
        diameter = value.toInt
      }else if(key == "cioccolato"){
        isChocolate = true
        chocolate = value
      }else if(key == "nome"){
        name = value
      }else if(key == "minuti"){
        minutes = value.toInt
      }else if(key == "persone"){
        people = value.toInt
      }else if(key == "livello"){
        level = LevelEnum(value.toInt) // converto in intero e poi in enum
      }

      // sfrutto polimorfismo
      if (isCake && !isChocolate){
        dessert = new Cake(name, people, minutes, level, diameter)
      }else if(!isCake && isChocolate){
        dessert = new ChocolateDessert(name, people, minutes, level, chocolate)
      }else if(isCake && isChocolate){
        dessert = new ChocolateCake(name, people, minutes, level, diameter, chocolate)
      }else{
        dessert = new Dessert(name, people, minutes, level)
      }
    }
    dessert
  }

  def getSpecialDessertFromInfo(map: HashMap[String, String]):SpecialDessert = {
    var name:String = ""
    var level:LevelEnum.Value = LevelEnum.Facile
    var minutes:Int = 0
    var people:Int = 0

    for((key, value) <- map){
      if(key == "nome"){
        name = value
      }else if(key == "minuti"){
        minutes = value.toInt
      }else if(key == "persone"){
        people = value.toInt
      }else if(key == "livello"){
        level = LevelEnum(value.toInt) // converto in intero e poi in enum
      }
    }
    new SpecialDessert(name, people, minutes, level)
  }

  def printDesserts(): Unit = {
    println("****************************************************")
    println("RICETTARIO DI DOLCI")
    println("****************************************************\n")
    desserts.foreach(dessert => dessert.printAll())
  }

  def printDessertsInfo(): Unit = {
    println("****************************************************")
    println("RICETTARIO DI DOLCI (solo info)")
    println("****************************************************")
    desserts.foreach(dessert =>{
      dessert.printInfo()
      println("****************************************************")
    })
  }

  def printDessertsTypes(): Unit = {
    println("****************************************************")
    println("RICETTARIO DI DOLCI (solo tipi)")
    println("****************************************************")
    desserts.foreach(dessert => dessert.printType())
  }

  def loadDesserts(path:String): Unit = {
    val files = Utility.getFiles(path)
    var d:Dessert = null
    files.foreach( file => {
      if (path == "./recipes/special_desserts")
        d = getSpecialDessertFromInfo(Utility.getInfoFromFile(file))
      else
        d = getDessertFromInfo(Utility.getInfoFromFile(file))
      d.setIngredients(Utility.getIngredientsFromFile(file))
      d.setDescription(Utility.getDescriptionFromFile(file))
      desserts+=d
    }
    )
  }

  println("Caricamento ricettario...")
  loadDesserts("./recipes/desserts")
  loadDesserts("./recipes/special_desserts")
}
