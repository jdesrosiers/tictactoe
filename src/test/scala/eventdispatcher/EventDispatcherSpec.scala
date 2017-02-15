package eventdispatcher

import org.scalatest._

class EventDispatcherSpec extends FunSpec with Matchers {
  describe("EventDispatcher.dispatch") {
    it("should do nothing if there are no listeners") {
      val dispatcher = new EventDispatcher[String]

      dispatcher.dispatch('foo, "bar") // should not throw an error
    }

    it("should call a registered listener") {
      val dispatcher = new EventDispatcher[String]
      var spy = false

      dispatcher.addListener('foo) { _ => spy = true }

      dispatcher.dispatch('foo, "bar")

      spy should equal (true)
    }

    it("should call a registered listeners in the order they were registered") {
      val dispatcher = new EventDispatcher[String]
      var spy = List[String]()

      dispatcher.addListener('foo) { _ => spy = spy :+ "first" }
      dispatcher.addListener('foo) { _ => spy = spy :+ "second" }

      dispatcher.dispatch('foo, "bar")

      spy should equal (List("first", "second"))
    }
  }
}
