name := "play-spring-data-jpa"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
    javaJdbc,
    javaJpa,
    "org.springframework" % "spring-context" % "4.0.5.RELEASE",
    "javax.inject" % "javax.inject" % "1",
    "org.springframework.data" % "spring-data-jpa" % "1.6.0.RELEASE",
    "org.springframework" % "spring-expression" % "4.0.5.RELEASE",
    "org.hibernate" % "hibernate-entitymanager" % "4.3.5.Final",
    "org.mockito" % "mockito-core" % "1.9.5" % "test"
)