package sample

import upickle.default._


case class PI( bundles : Map[String, BPI])   {
  def toJSValue:upickle.Js.Value = {
    writeJs[PI](this)
  }

}

case class BPI(total : Float, discount: Float, discountedSum : Float, products : Seq[PPI]) {

}




case class PPI( label : String, price : Float)


