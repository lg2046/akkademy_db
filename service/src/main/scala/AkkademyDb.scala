import Messages._
import akka.actor.{Actor, Status}
import akka.event.Logging

import scala.collection.mutable

class AkkademyDb extends Actor {
  val log = Logging(context.system, this)

  val map = new mutable.HashMap[String, Any]()
  override def receive: Receive = {
    case SetRequest(key, value) =>
      log.info(s"received SetRequest key: $key, value: $value")
      map.update(key, value)
      println(map)
      sender() ! Status.Success

    case GetRequest(key) =>
      log.info(s"received GetRequest - key: $key")
      val response = map.get(key)
      response match {
        case Some(x) => sender() ! x
        case None => sender() ! Status.Failure(KeyNotFoundException(key))
      }
    case _ => Status.Failure(new ClassNotFoundException())
  }
}

