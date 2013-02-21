package me.masahito

import util.matching.Regex

case class Status(code: String, message: String){
  def show() {
    println("Status %s: %s".format(this.code, this.message))
  }

  def isPrefixOf(pattern: String): Boolean = {
    val matcher: (CharSequence => Option[Regex.Match]) = (pattern r).findFirstMatchIn

    (matcher(this.code), matcher(this.message)) match {
      case (None, None) => false
      case (_, _) => true
    }
  }
}

object HttpStatus{
  val httpStatusList = List(
    Status("100", "Continue"),
    Status("101", "Switching Protocols"),
    Status("102", "Processing"),
    Status("200", "OK"),
    Status("201", "Created"),
    Status("202", "Accepted"),
    Status("203", "Non-Authoritative Information"),
    Status("204", "No Content"),
    Status("205", "Reset Content"),
    Status("206", "Partial Content"),
    Status("207", "Multi-Status"),
    Status("208", "Already Reported"),
    Status("300", "Multiple Choices"),
    Status("301", "Moved Permanently"),
    Status("302", "Found"),
    Status("303", "See Other"),
    Status("304", "Not Modified"),
    Status("305", "Use Proxy"),
    Status("307", "Temporary Redirect"),
    Status("400", "Bad Request"),
    Status("401", "Unauthorized"),
    Status("402", "Payment Required"),
    Status("403", "Forbidden"),
    Status("404", "Not Found"),
    Status("405", "Method Not Allowed"),
    Status("406", "Not Acceptable"),
    Status("407", "Proxy Authentication Required"),
    Status("408", "Request Timeout"),
    Status("409", "Conflict"),
    Status("410", "Gone"),
    Status("411", "Length Required"),
    Status("412", "Precondition Failed"),
    Status("413", "Request Entity Too Large"),
    Status("414", "Request-URI Too Large"),
    Status("415", "Unsupported Media Type"),
    Status("416", "Request Range Not Satisfiable"),
    Status("417", "Expectation Failed"),
    Status("418", "I'm a teapot"),
    Status("422", "Unprocessable Entity"),
    Status("423", "Locked"),
    Status("424", "Failed Dependency"),
    Status("425", "No code"),
    Status("426", "Upgrade Required"),
    Status("428", "Precondition Required"),
    Status("429", "Too Many Requests"),
    Status("431", "Request Header Fields Too Large"),
    Status("449", "Retry with"),
    Status("500", "Internal Server Error"),
    Status("501", "Not Implemented"),
    Status("502", "Bad Gateway"),
    Status("503", "Service Unavailable"),
    Status("504", "Gateway Timeout"),
    Status("505", "HTTP Version Not Supported"),
    Status("506", "Variant Also Negotiates"),
    Status("507", "Insufficient Storage"),
    Status("509", "Bandwidth Limit Exceeded"),
    Status("510", "Not Extended"),
    Status("511", "Network Authentication Required")
  )

  def matchStatus(pattern: String, httpStatus: Status): Boolean  = {
    httpStatus.isPrefixOf(pattern)
  }

  def filterStatus(pattern: String, httpStatusList: List[Status]): List[Status] = {
    httpStatusList.filter(matchStatus(pattern, _))
  }

  def filterStatus(list: List[String]): List[Status] = {
    list match {
      case List() => httpStatusList
      case List(head, _*) =>  filterStatus(head, httpStatusList)
    }
  }

  def main(args: Array[String]) {
    filterStatus(args.toList).map(_.show())
  }
}
