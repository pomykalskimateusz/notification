package notification.impl

import akka.NotUsed
import notification.api.NotificationService
import com.lightbend.lagom.scaladsl.api.ServiceCall
import notification.model.Trigger
import notification.utils.mail.MailUtil

import scala.concurrent.Future

class NotificationServiceImpl(mailUtil: MailUtil) extends NotificationService
{
    private val EMAIL_SUBJECT = ""

    override def notifyByTrigger: ServiceCall[Trigger, NotUsed] = ServiceCall
    {
        trigger => {
            if(trigger.isLogged)
            {
                // TODO generate popup
            }
            else
            {
                mailUtil.send(trigger.content, EMAIL_SUBJECT, trigger.email)
            }
            Future.successful(NotUsed)
        }
    }
}