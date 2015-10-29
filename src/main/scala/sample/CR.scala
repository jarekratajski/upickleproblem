package sample


import upickle.default._



case class CR(price: PI, products : Map[String, PR] ) {
  def toJSValue(): upickle.Js.Value = {
    writeJs(this)
  }
}

