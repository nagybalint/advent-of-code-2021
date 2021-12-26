package nagybalint.tasks

import nagybalint.Task

class Day3Task1 extends Task {
  def getIntValue(binDigits: Seq[Int]): Int = Integer.parseInt(binDigits.map(_.toString).mkString(""), 2)

  val diagData: Seq[Seq[Int]] = inputs.getLines().toSeq
    .map(_.split("").map(_.toInt))
  val bitCols: Seq[Seq[Int]] = diagData.head.map(_ => Seq[Int]())
  val gamma: Seq[Int] = diagData.foldLeft(bitCols)((bc, current) => {
    current.zipWithIndex.map { case (v, i) => bc(i) :+ v }
  }).map(col => col.count(v => v == 1))
    .map(ones => if (ones >= diagData.size / 2) 1 else 0)
  val epsilon: Seq[Int] = gamma.map(v => if(v == 1) 0 else 1)

  override def solve(): Unit = {
    val res = getIntValue(gamma) * getIntValue(epsilon)
    println(res)
  }
}
