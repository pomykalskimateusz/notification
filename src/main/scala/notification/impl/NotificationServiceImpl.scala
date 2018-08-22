package notification.impl

import akka.NotUsed
import notification.api.NotificationService
import com.lightbend.lagom.scaladsl.api.ServiceCall
import notification.utils.mail.MailUtil

import scala.concurrent.Future

class NotificationServiceImpl(mailService: MailUtil) extends NotificationService
{
    private val EMAIL_SUBJECT = ""

    override def notify(email: String) = ServiceCall
    {
        trigger => {
            if(trigger.isLogged)
            {
              // TODO generate popup
            }
            else
            {
                mailService.send(trigger.content, EMAIL_SUBJECT, email)
            }

            Future.successful(NotUsed)
        }
    }
}