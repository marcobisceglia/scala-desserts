import java.io.File
import scala.collection.mutable.{HashMap, ListBuffer}
import scala.io.Source

// Singleton object
object Utility{
  def printMap(map: HashMap[String, String]): Unit = {
    map.foreach {
      case(key, value) => if(value!="") println(s"$key: $value") else println(s"$key")
    }
  }

  def getFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      println("File non trovati in " + dir)
      List[File]()
    }
  }

  def fileToListBuffer(fileName: File): ListBuffer[String] = {
    val list = new ListBuffer[String]

    val file = Source.fromFile(fileName)
    for (line <- file.getLines) list+=line.trim()
    file.close()

    list
  }

  def addKeyValue(map:HashMap[String, String], s:String, delimiter:String): HashMap[String, String] = {
    val keyValue:Array[String] = s.split(":")
    val key = s.split(delimiter)(0).trim()
    var value = ""
    if (keyValue.length > 1) value = s.split(":")(1).trim()
    map+= (key -> value)
  }

  def getInfoFromFile(file:File): HashMap[String, String] = {
    // get file lines
    val lines: ListBuffer[String] = fileToListBuffer(file)
    // create map to save info
    var info = new HashMap[String, String]()
    val delimiter = ":"
    val j = lines.indexOf("---ingredients---")
    lines.slice(0, j).foreach(line => info = addKeyValue(info, line, delimiter) )
    info
  }

  def getIngredientsFromFile(file:File): HashMap[String, String] = {
    // get file lines
    val lines: ListBuffer[String] = fileToListBuffer(file)
    // create map to save info
    var info = new HashMap[String, String]()
    val delimiter = ":"
    val i = lines.indexOf("---ingredients---") + 1
    val j = lines.indexOf("---description---")
    lines.slice(i, j).foreach(line => info = addKeyValue(info, line, delimiter) )
    info
  }

  def getDescriptionFromFile(file:File): ListBuffer[String] = {
    // get file lines
    val lines: ListBuffer[String] = fileToListBuffer(file)
    val i = lines.indexOf("---description---") + 1
    lines.slice(i, lines.size)
  }
}