import akka.actor.{Actor, Status}

/**
  * Created by liguang on 17/6/10.
  */
class PingActor extends Actor {
  override def receive: Receive = {
    case "ping" => sender() ! "pong"
    case _ => sender() ! Status.Failure(new Exception("unknown message"))
  }
}
