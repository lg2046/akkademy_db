import org.scalatest.{FunSpecLike, Matchers}
import scala.concurrent.duration._
import scala.concurrent.Await

class SClientSpec extends FunSpecLike with Matchers {

  val client = new SClient("127.0.0.1:2552")

  describe("akkademyDb client") {
    it("should set a value") {
      client.set("123", 123)
      val futureResult = client.get("123")
      Await.result(futureResult.mapTo[Int], 5 seconds) should equal(123)
    }
  }
}
