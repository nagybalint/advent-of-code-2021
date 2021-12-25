package nagybalint.tasks

class Day2Task2 extends Day2Task1 {
  override def solve(): Unit = {
    val x, y, aim = 0
    val pos = commands.foldLeft((x, y, aim))((pos, command) => {
      val (x, y, aim) = pos
      command match {
        case Command("forward", dx) => (x + dx, y + dx * aim, aim)
        case Command("up", dy) => (x, y, aim - dy)
        case Command("down", dy) => (x, y, aim + dy)
      }
    })
    println(pos._1 * pos._2)
  }
}
