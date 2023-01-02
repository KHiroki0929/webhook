import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.{ActorMaterializer, Materializer}

import scala.io.StdIn

object AkkaServer {
  def main(args: Array[String]) {
    implicit val system = ActorSystem("my-system")
//    implicit val materializer = Materializer(system)
    implicit val executionContext = system.dispatcher

    val route =
      path("hello") {
        get {
          complete("Hello World!")
        }
      }

    val webhookRoute =
      path("webhook") {
        get {
          complete("WEBHOOK VERIFIED")
        }
//        post {
//          parameterMap {
//            parameters => complete("webhook receive" + parameters)
//          }
//        }
      }

    val bindingFuture = Http().newServerAt("localhost", 8080).bind(webhookRoute)
    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}
