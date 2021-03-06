//enablePlugins(JavaServerAppPackaging, UniversalDeployPlugin)

name := "hwaipydotcom"
version := "0.2.0"
scalaVersion := "2.12.3"
organization := "com.hydra"
libraryDependencies += "com.hydra" %% "sydra" % "0.7.0"
libraryDependencies += "org.eclipse.jetty" % "jetty-server" % "9.4.5.v20170502"
libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "9.4.5.v20170502"
libraryDependencies += "org.eclipse.jetty" % "jetty-servlet" % "9.4.5.v20170502"
libraryDependencies += "org.pegdown" % "pegdown" % "1.6.0"
libraryDependencies += "com.hwaipy" %% "hydrogen" % "0.3.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
scalacOptions ++= Seq("-feature")
scalacOptions ++= Seq("-deprecation")