import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by liguang on 17/6/10.
  */
class PingActorSpec extends FunSpecLike with Matchers {
  implicit val system = ActorSystem()
  implicit val timeout = Timeout(1.seconds)

  describe("ping pong") {
    it("should future") {
      val actorRef = system.actorOf(Props(classOf[PingActor]))

      val f = actorRef ? "ping"
      Await.result(f.mapTo[String], 2.seconds) should equal("pong")

      val f2 = actorRef ? "unknown"

      intercept[Exception] {
        Await.result(f2.mapTo[String], 2.seconds)
      }

    }
  }
}
