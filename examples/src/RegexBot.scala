import info.mukel.telegrambot4s.api.{Polling, _}
import info.mukel.telegrambot4s.api.declarative.RegexCommands

class RegexBot(token: String) extends ExampleBot(token) with Polling with RegexCommands {
  onRegex("""/regex\s+(\w+)""".r) { implicit msg =>
    groups =>
      reply(groups mkString ", ")
  }

  onRegex("""1?|^(11+?)\1+""".r) { implicit msg =>
    _ =>
      reply("Not prime!")
  }
}