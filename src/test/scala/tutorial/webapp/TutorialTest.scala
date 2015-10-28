package tutorial.webapp

import utest._

import org.scalajs.jquery.{JQuery, jQuery}

object TutorialTest extends TestSuite {

  // Initialize App
  TutorialApp.main


  def tests = TestSuite {
    'HelloWorld {
      val ps = jQuery("p:contains('Hello World')")
      log("Number of hello-world paragraphs", ps.length)
      assert(ps.length == 1)
    }

    'ButtonClick {
      def messageCount =
        jQuery("p:contains('Bang!')").length
      val button = jQuery("button:contains('Click me!')")
      log("Number of bang paragraphs", messageCount)
      log("Number of button", button.length)
      assert(button.length == 1)
      assert(messageCount == 0)

//      for (c <- 1 to 5) {
//        log("Number of bang paragraphs", messageCount)
//        log("Number of button", button.length)
//        button.click()
//        assert(messageCount == c)
//      }
    }

  }

  def log[A](header: String, msg: A): Unit = {
    println(
      """
        |
        |
        |=========================================
        |%s : %s
        |=========================================
        |
        |
      """.format(header, msg.toString).stripMargin)
  }
}
