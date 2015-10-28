package tutorial.webapp

/**
 * Created by IDEA on 28/10/15.
 */

import org.scalajs.dom
import dom.html
import scalajs.js.annotation.JSExport
import scalatags.JsDom.all._

@JSExport
object HelloWorld1 extends {
  @JSExport
  def main(target: html.Div) = {
    val (animalA, animalB) = ("fox", "dog")
    target.appendChild(
      div(
        h1("Hello World!"),
        p(
          "The quick brown ", b(animalA),
          " jumps over the lazy ",
          i(animalB), "."
        )
      ).render
    )
    val box = input(
      `type` := "text",
      placeholder := "Type here!"
    ).render

    val output = span.render

    box.onkeyup = (e: dom.Event) => {
      output.textContent =
        box.value.toUpperCase
    }

    target.appendChild(
      div(
        // safety feature: if you insert script into an element, it will become plain text (special chars are escaped)
        //        h1("<script>console.log('Capital Box!')</script>"),
        h1("Capital box"),
        p(
          "Type here and " +
            "have it capitalized!"
        ),
        div(box),
        div(output)
      ).render
    )


  }


}
