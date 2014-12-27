package log

import auxlib.log.Logging

/**
 * @author Anastasios Skarlatidis
 */
object LoggingExample extends App with Logging {

  // Info messages:
  info("This is an info message")
  info("This is an info message with an exception.",
    new Exception("This a demo exception when an info is logged."))

  whenInfo {
    // The following println will be executed only when info level is enabled
    println("This message is printed when info is enabled.")
  }

  // Warning messages:
  warn("This is a warning message")
  warn("This is a warning message with an exception.",
    new Exception("This a demo exception when a warning is logged."))

  whenWarn {
    // The following println will be executed only when warning level is enabled
    println("This message is printed when warning is enabled.")
  }

  // Error messages:
  error("This is an error message")
  error("This is an error message with an exception.",
    new Exception("This a demo exception when an error is logged."))

  whenError {
    // The following println will be executed only when error level is enabled
    println("This message is printed when error is enabled.")
  }

  // Fatal error messages:
  // Please note that the following lines are intentionally commented out, because fatal error messages
  // force application to exit with some error code (default is 1) --- i.e., sys.exit(1)

  //fatal("This is a fatal error message, with default exit code (1).")
  /*fatal("This is a fatal error message, with an exception and default exit code (1).",
    new Exception("This a demo exception when a fatal error is logged."))*/

  /*fatal("This is a fatal error message, with an exception and a user specified exit code (10).",
    new Exception("This an exception when a fatal error is logged."),
    exitCode = 10)*/

  // Trace messages:
  trace("This is a trace message")
  trace("This is a trace message with an exception.",
    new Exception("This a demo exception when a trace is logged."))

  whenTrace {
    // The following println will be executed only when trace level is enabled
    println("This message is printed when trace is enabled.")
  }

}
