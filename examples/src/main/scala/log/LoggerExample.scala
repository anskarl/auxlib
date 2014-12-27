package log

import auxlib.log.Logger

/**
 * @author Anastasios Skarlatidis
 */
object LoggerExample extends App {

  // Initialize a logger:
  val logger = Logger(LoggerExample.getClass) // provide class as identifier
  // val logger = Logger("some name") // alternatively, you can specify name as identifier.

  // Info messages:
  logger.info("This is an info message")
  logger.info("This is an info message with an exception.",
      new Exception("This a demo exception when an info is logged."))

  logger.whenInfo {
      // The following println will be executed only when info level is enabled
      println("This message is printed when info is enabled.")
    }

    // Warning messages:
  logger.warn("This is a warning message")
  logger.warn("This is a warning message with an exception.",
      new Exception("This a demo exception when a warning is logged."))

  logger.whenWarn {
      // The following println will be executed only when warning level is enabled
      println("This message is printed when warning is enabled.")
    }

    // Error messages:
  logger.error("This is an error message")
  logger.error("This is an error message with an exception.",
      new Exception("This a demo exception when an error is logged."))

  logger.whenError {
      // The following println will be executed only when error level is enabled
      println("This message is printed when error is enabled.")
    }

    // Fatal error messages:
    // Please note that the following lines are intentionally commented out, because fatal error messages
    // force application to exit with some error code (default is 1) --- i.e., sys.exit(1)

    //logger.fatal("This is a fatal error message, with default exit code (1).")
    /*logger.fatal("This is a fatal error message, with an exception and default exit code (1).",
      new Exception("This a demo exception when a fatal error is logged."))*/

    /*logger.fatal("This is a fatal error message, with an exception and a user specified exit code (10).",
      new Exception("This an exception when a fatal error is logged."),
      exitCode = 10)*/

    // Trace messages:
  logger.trace("This is a trace message")
  logger.trace("This is a trace message with an exception.",
      new Exception("This a demo exception when a trace is logged."))

  logger.whenTrace {
      // The following println will be executed only when trace level is enabled
      println("This message is printed when trace is enabled.")
    }
}
