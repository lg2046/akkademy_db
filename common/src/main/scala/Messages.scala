object Messages {
  case class SetRequest(key: String, value: Any)

  case class GetRequest(key: String)

  case class KeyNotFoundException(str: String) extends Exception
}
