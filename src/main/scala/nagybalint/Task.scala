package nagybalint

import scala.io.{BufferedSource, Source}

trait Task {
  def solve(): Unit
  def inputs: BufferedSource = Source.fromResource(s"${this.getClass.getName.replace(".", "/")}.txt")
}

