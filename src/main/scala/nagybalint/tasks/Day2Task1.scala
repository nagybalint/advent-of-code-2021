package nagybalint.tasks

import nagybalint.Task

case class Command(dir: String, amount: Int)

class Day2Task1 extends Task {
  override def solve(): Unit = {
    val commands = inputs.getLines().toSeq
      .map(_.split(" "))
      .map(commStr => Command(commStr.head, commStr(1).toInt))
    val pos = commands.foldLeft(0, 0)((currentPos, command) => {
      command match {
        case Command("forward", x) => (currentPos._1 + x, currentPos._2)
        case Command("up", y) => (currentPos._1, currentPos._2 - y)
        case Command("down", y) => (currentPos._1, currentPos._2 + y)
      }
    })
    println(pos._1 * pos._2)
  }
}
