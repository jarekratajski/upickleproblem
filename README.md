# upickle issue

This project demonstrates strange problem with upickle marcos.
Class names are changed (anonimized)
Command 
sbt clean fastOptJS 

gives 
```
dev/upikle2/src/main/scala/sample/CR.scala:10: ambiguous implicit values:
[error]  both value derive$macro$12 of type => upickle.default.Writer[sample.CR]
[error]  and value derive$macro$13 of type => upickle.default.Writer[sample.PI]
[error]  match expected type upickle.default.Writer[T1]
[error]     writeJs(this)
[error]            ^
[error] one error found
[error] (compile:compileIncremental) Compilation failed
```
# workaround  - strange behaviour

If in this  case class I remove map 
```
case class CR(price: PI, products : Map[String, PR] ) {
  def toJSValue(): upickle.Js.Value = {
    writeJs(this)
  }
}
```
An then it looks like below:
```
case class CR(price: PI ) {
  def toJSValue(): upickle.Js.Value = {
    writeJs(this)
  }
}
```
Code compiles without problems.

#workaround 2

If PR trait and classes are moved to the same file where CR

```
sealed trait PR {
}


case class CP(aa: Float, bb: Float) extends PR {
}

case class CR(price: PI, products : Map[String, PR] ) {
  def toJSValue(): upickle.Js.Value = {
    writeJs(this)
  }
}
```

code also compiles without problems.
