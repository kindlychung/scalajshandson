
enablePlugins(ScalaJSPlugin)

name := "scalajsLearn"

version := "1.0"

scalaVersion := "2.11.7"


/////////////////// libs ///////////////////////////////
// automatically download js libs for you
skip in packageJSDependencies := false

jsDependencies += RuntimeDOM

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0"

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.8.0"

libraryDependencies += "com.lihaoyi" %%% "utest" % "0.3.0" % "test"

// core = essentials only. No bells or whistles.
libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "0.9.2"
/////////////////// libs end ///////////////////////////////

testFrameworks += new TestFramework("utest.runner.Framework")

/////////////////// launch main method for you ///////////////////////
// does not work for main methods that take args
//persistLauncher in Compile := true
//
//persistLauncher in Test := false
/////////////////// launch main method for you method ///////////////////////



///////////////////// live reload //////////////////////////////////
workbenchSettings

// live reload needs to know where to begin
//bootSnippet := "tutorial.webapp.TutorialApp.main();"
bootSnippet := "tutorial.webapp.Sierpinski().main(document.getElementById('canvas'));"

updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)
///////////////////// live reload end //////////////////////////////////


