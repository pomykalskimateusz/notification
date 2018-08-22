package notification.utils.mail

import javax.mail.MessagingException
import org.springframework.mail.javamail.MimeMessageHelper
import play.api.Logger

class MailUtil
{
    private val EMAIL_FROM = ""
    private val log = Logger("MailServiceLogger")

    def send(content: String, subject: String, receiver: String)
    {
        val mailSender = MailSenderConfiguration.javaMailSender
        val mimeMessage = mailSender.createMimeMessage()
        try
        {
            val mimeMessageHelper = new MimeMessageHelper(mimeMessage, true)

            mimeMessageHelper.setFrom(EMAIL_FROM)
            mimeMessageHelper.setTo(receiver)
            mimeMessageHelper.setSubject(subject)
            mimeMessageHelper.setText(content, true)

            mailSender.send(mimeMessage)
        }
        catch
        {
            case ex: MessagingException =>
                log.info("Error something wrong during sending email")
                log.info(ex.getMessage)
        }
    }
}
