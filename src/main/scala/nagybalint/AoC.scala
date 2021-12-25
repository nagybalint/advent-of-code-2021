package nagybalint

object AoC extends App {
   if (args.length == 0) {
      println("Please specify a task")
   }
   val taskName = args(0)
   try {
      val task = Class.forName(s"nagybalint.tasks.${taskName}")
        .getDeclaredConstructor()
        .newInstance()
        .asInstanceOf[Task]
      println(s"The solution to ${taskName} is:")
      task.solve()
   } catch {
      case ex: ClassNotFoundException =>
       println("Please specify a valid task")
      case e: Throwable =>
       e.printStackTrace()
   }
}
