package notification.utils.mail

import java.util.Properties

import org.springframework.mail.javamail.JavaMailSenderImpl

object MailSenderConfiguration
{
    private val USERNAME: String = ""
    private val PASSWORD: String = ""

    private[mail] def javaMailSender =
    {
        val properties = new Properties
        val javaMailSender = new JavaMailSenderImpl

        properties.setProperty("mail.smtp.auth", "true")
        properties.setProperty("mail.smtp.starttls.enable", "true")

        javaMailSender.setJavaMailProperties(properties)
        javaMailSender.setHost("smtp.gmail.com")
        javaMailSender.setPort(587)
        javaMailSender.setUsername(USERNAME)
        javaMailSender.setPassword(PASSWORD)

        javaMailSender
    }
}
