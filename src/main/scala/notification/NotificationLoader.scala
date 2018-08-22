package notification

import notification.api.NotificationService
import notification.impl.NotificationServiceImpl

import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext, LagomApplicationLoader}

import play.api.libs.ws.ahc.AhcWSComponents

import com.softwaremill.macwire.wire

class NotificationLoader extends LagomApplicationLoader
{
    override def loadDevMode(context: LagomApplicationContext) = new HelloApplication(context) with LagomDevModeComponents

    override def load(context: LagomApplicationContext) =
        new HelloApplication(context)
        {
          override def serviceLocator: ServiceLocator = NoServiceLocator
        }

    override def describeService = Some(readDescriptor[NotificationService])
}

abstract class HelloApplication(context: LagomApplicationContext) extends LagomApplication(context) with AhcWSComponents
{
    override lazy val lagomServer = serverFor[NotificationService](wire[NotificationServiceImpl])
}