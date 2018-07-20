package com.hydra.web

import java.awt.{Color, Font, Graphics2D}
import java.awt.image.BufferedImage
import java.io.File
import java.net.{HttpURLConnection, URL}
import java.util.regex.Pattern
import javax.imageio.ImageIO
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

import com.hwaipy.hydrogen.web.servlet.AsyncHttpServlet

object WeatherServlet {
  val path = "/weathers/*"
  val pathPattern = Pattern.compile("/weathers/(.*)\\??.*")
}

class WeatherServlet extends AsyncHttpServlet {

  override def doGetAsync(req: HttpServletRequest, resp: HttpServletResponse) {
    val lon = req.getParameter("lon")
    val lat = req.getParameter("lat")
    val stationName = req.getParameter("station")
    val originalImage = ImageIO.read(new URL(s"http://www.7timer.info/bin/astro.php?lon=${lon}&lat=${lat}&lang=zh-CN&ac=0&unit=metric&tzshift=0&nsukey=UZeWmez8Mq1FslMOuZqryuxKA5OtNkB2G7RdW%2B8mY8RzT4M0hYjx8zvKtMl7yx6gaSdAUs8Grv9yWKqMqR1D4EYbV6WXVzhQu3Xycw6kC6BaKdVVgO5TjFAJbskoV14q6IH3smbe6RFf7Lb2Dq6P0r9y5b%2FN7YYCnKgFP6gme7uxEbEmy8VEYyPmwOphHT8rLLVbrU9ifWkDbSKy97XCGA%3D%3D"))

    val image = new BufferedImage(originalImage.getWidth, originalImage.getHeight, BufferedImage.TYPE_INT_ARGB)
    val g2 = image.getGraphics.asInstanceOf[Graphics2D]
    g2.drawImage(originalImage, 0, 0, null)
    g2.setColor(Color.BLACK)
    g2.fillRect(440, 0, 130, 30)
    g2.setColor(Color.WHITE)
    g2.setFont(new Font("Ariel", Font.BOLD, 15))
    g2.drawString(s"${stationName}", 452, 22)
    g2.drawString(s"@Hwaipy", 500, 22)

    g2.dispose
    ImageIO.write(image, "png", resp.getOutputStream)
  }
}
