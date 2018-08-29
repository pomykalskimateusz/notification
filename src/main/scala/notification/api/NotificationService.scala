package notification.api

import akka.NotUsed

import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

import notification.model.Trigger

trait NotificationService extends Service
{
    def notifyTrigger: ServiceCall[Trigger, NotUsed]

    override def descriptor: Descriptor =
    {
      import Service._
        named("notificationService").withCalls(namedCall("notify", notifyTrigger))
          .withAutoAcl(true)
    }
}