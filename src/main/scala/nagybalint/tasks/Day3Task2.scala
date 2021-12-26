package nagybalint.tasks

class Day3Task2 extends Day3Task1 {
  def mostCommonBit(candidates: Seq[Seq[Int]], i: Int): Int = {
    val amounts = candidates.map(_(i)).groupBy(x => x).map { case (k, v) => (k, v.size) }
    if (amounts(1) >= amounts(0)) 1 else 0
  }
  def leastCommonBit(candidates: Seq[Seq[Int]], i: Int): Int = if (mostCommonBit(candidates, i) == 1) 0 else 1

  def reduceDataFor(targetBit: (Seq[Seq[Int]], Int) => Int): Seq[Int] = {
    diagData.head.indices.foldLeft(diagData)((remainingCandidates, i) => {
      if (remainingCandidates.size == 1) {
        remainingCandidates
      } else {
        remainingCandidates.filter(_(i) ==  targetBit(remainingCandidates, i))
      }
    }).head
  }

  override def solve(): Unit = {
    val oxygenRate = reduceDataFor(mostCommonBit)
    val co2Rate = reduceDataFor(leastCommonBit)
    println(getIntValue(oxygenRate) * getIntValue(co2Rate))
  }
}
