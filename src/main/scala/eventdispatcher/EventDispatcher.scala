package eventdispatcher

class EventDispatcher[T] {
  private var listeners = Map[Symbol, List[T => Unit]]()

  def addListener(name: Symbol)(handler: T => Unit): Unit = listeners.get(name) match {
    case Some(handlers) =>
      listeners += (name -> (handlers :+ handler))
    case None =>
      listeners += (name -> List(handler))
  }

  def dispatch(name: Symbol, event: T): Unit = listeners.get(name) match {
    case Some(handlers) => for (handler <- handlers) handler(event)
    case None => ()
  }
}
