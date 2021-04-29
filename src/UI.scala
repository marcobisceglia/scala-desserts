import scala.annotation.tailrec
import scala.io.StdIn.readLine

// Singleton object
object UI {
  private def showMenu(): Unit = {
    println("Scegli opzione: ")
    println("1. Stampa le ricette complete")
    println("2. Stampa solo le informazioni")
    println("3. Stampa solo i tipi di ricette")
    println("4. Esci\n")
  }

  @tailrec
  private def setMenuChoice(): Unit = {
    print("Inserisci opzione: ")
    val choice: String = readLine()
    println()

    choice match {
      case "1" => Cookbook.printDesserts(); exitDialog()
      case "2" => Cookbook.printDessertsInfo(); exitDialog()
      case "3" => Cookbook.printDessertsTypes(); exitDialog()
      case "4" => println("Ciao")
      case _ => println("Opzione non valida\n"); setMenuChoice()
    }
  }

  @tailrec
  private def exitDialog(): Unit = {
    print("\nVuoi continuare? (y/n) ")
    val s = readLine()
    println()
    if (s=="y" || s=="Y") start()
    else if (s=="n" || s=="N") println("Ciao")
    else {
      println("Input non valido")
      exitDialog()
    }
  }

  def start(): Unit = {
    showMenu()
    setMenuChoice()
  }
}
