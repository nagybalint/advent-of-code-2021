package nagybalint.tasks

import nagybalint.Task

class Day1Task2 extends Task {
  override def solve(): Unit = {
    val res = inputs.getLines()
      .toSeq
      .map(_.toInt)
      .sliding(3)
      .map(_.sum)
      .sliding(2)
      .toSeq
      .count(l => l.head < l(1))
    println(res)
  }
}
