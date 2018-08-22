package notification.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import com.lightbend.lagom.scaladsl.api.transport.Method
import notification.model.Trigger

trait NotificationService extends Service
{
    def notify(email: String): ServiceCall[Trigger, NotUsed]

    override def descriptor: Descriptor =
    {
      import Service._
        named("notificationService").withCalls(restCall(Method.POST, "/notify/:email",notify _))
          .withAutoAcl(true)
    }
}