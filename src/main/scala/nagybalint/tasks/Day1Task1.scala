package nagybalint.tasks

import nagybalint.Task

class Day1Task1 extends Task {
  override def solve(): Unit = {
    val res = inputs.getLines()
      .toSeq
      .map(_.toInt)
      .sliding(2)
      .count(l => l.head < l(1))
    println(res)
  }
}
