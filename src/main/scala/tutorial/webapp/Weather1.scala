package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.html
import scala.scalajs.js.annotation.JSExport
import scalatags.JsDom.all._

/**
 * Created by IDEA on 28/10/15.
 */
@JSExport
object Weather1 {
  @JSExport
  def main(target: html.Div): Unit = {
    val xhr = new dom.XMLHttpRequest()
    xhr.open("GET",
      "http://api.openweathermap.org/" +
        "data/2.5/weather?q=Singapore"
    )
    xhr.onload = (e: dom.Event) => {
      if (xhr.status == 200) {
        val res = pre(xhr.responseText).render
        println(res)
        target.appendChild(
          res
        )
      }
    }
    xhr.send()
  }
}
