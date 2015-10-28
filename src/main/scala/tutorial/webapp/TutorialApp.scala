package tutorial.webapp



/**
 * Created by IDEA on 27/10/15.
 */
import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document
import scala.scalajs.js.annotation.JSExport
import org.scalajs.jquery.jQuery



object TutorialApp extends JSApp {
  def main: Unit = {
    setupUI
    setupBehavior
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  def addClickedMessage(msg: String): Unit = {
    jQuery("body").append("<p>%s</p>".format(msg))
  }

  def setupUI: Unit = {
    jQuery("body").append("<p>Hello World!</p>")
    jQuery("body").append("""<button id="click-me-button" type="button">Click me!</button>""")
  }

  def setupBehavior: Unit = {
    jQuery("#click-me-button").click(() => addClickedMessage("Bang!"))
  }

}

