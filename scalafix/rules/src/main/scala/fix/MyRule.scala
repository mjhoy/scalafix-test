package fix

import scalafix.v1._
import scala.meta._

case class Println(position: Position) extends Diagnostic {
  def message = "Use loggers instead of println"
}

class MyRule extends SemanticRule("LocalTime") {

  override def fix(implicit doc: SemanticDocument): Patch = {
    doc.tree.collect {
      case println @ Term.Apply.After_4_6_0(Term.Name("println"), _) =>
        Patch.lint(Println(println.pos))
    }.asPatch
  }

}
