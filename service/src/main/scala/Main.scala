import akka.actor.{ActorSystem, Props}

object Main extends App {
  val system = ActorSystem("akkademy")
  system.actorOf(Props(classOf[AkkademyDb]), name = "akkademy-db")
}
