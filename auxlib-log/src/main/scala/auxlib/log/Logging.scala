/*
 *                   __     _ _           _             
 *                   \ \   (_) |         | |            
 *   __ _ _   ___  __ \ \   _| |__ ______| | ___   __ _ 
 *  / _` | | | \ \/ /  > \ | | '_ \______| |/ _ \ / _` |
 * | (_| | |_| |>  <  / ^ \| | |_) |     | | (_) | (_| |
 *  \__,_|\__,_/_/\_\/_/ \_\_|_.__/      |_|\___/ \__, |
 *                                                 __/ |
 *                                                |___/    
 *
 */

package auxlib.log

/**
 *
 * Provides standard logging functionality, using scala-friendly syntax. The logging is managed by the SLF4j library.
 * Each class that implements this trait will be associated with a logger and the logging identity is defined by the
 * class name.
 *
 * @author Anastasios Skarlatidis
 */
trait Logging {

  // Lazy initialization of logger instance, using the current class name as logger name
  protected lazy val loggerInstance: Logger = Logger(getClass.getName)

  /**
   * Log debug messages only when debug is enabled, otherwise the message is ignored.
   *
   * @param message: the message to log
   */
  protected def debug(message: => String): Unit = loggerInstance.debug(message)

  /**
   * Log debug messages only when debug is enabled, otherwise the message is ignored.
   *
   * @param message: the message to log
   * @param ex: the thrown exception
   */
  protected def debug(message: => String, ex: => Throwable): Unit = loggerInstance.debug(message, ex)

  /**
   * Log the returned value of a particular instance (it is strongly suggested to use real debug,
   * instead of this utility function).
   *
   * @param valueName: the name of a particular instance
   * @param value: the instance's value
   * @return the instance's value
   */
  protected def debugValue[T](valueName: => String, value: => T): T = loggerInstance.debugValue(valueName, value)

  /**
   * Log informational messages (only when info is enabled, otherwise the message is ignored).
   *
   * @param message: the informational message to log
   */
  protected def info(message: => String): Unit = loggerInstance.info(message)

  /**
   * Log informational messages (only when info messages are enabled, otherwise the message is ignored) accompanied
   * with the thrown exception.
   *
   * @param message: the informational message to log
   * @param ex: the thrown exception
   */
  protected def info(message: => String, ex: => Throwable): Unit = loggerInstance.info(message, ex)

  /**
   * Log warning messages (only when info is enabled, otherwise the message is ignored).
   *
   * @param message: the informational message to log
   */
  protected def warn(message: => String): Unit = loggerInstance.warn(message)

  /**
   * Log warning messages (only when warning messages are enabled, otherwise the message is ignored) accompanied with
   * the thrown exception.
   *
   * @param message: the warning message to log
   * @param ex: the thrown exception to log
   */
  protected def warn(message: => String, ex: => Throwable): Any = loggerInstance.warn(message, ex)

  /**
   * Log error messages (only when error messages are enabled, otherwise the message is ignored) accompanied with
   * the thrown exception.
   *
   * @param message: the error message to log
   */
  protected def error(message: => String): Unit = loggerInstance.error(message)

  /**
   * Log error messages (only when error messages are enabled, otherwise the message is ignored) accompanied with
   * the thrown exception.
   *
   * @param message: the error message to log
   * @param ex: the thrown exception to log
   */
  protected def error(message: => String, ex: => Throwable): Unit = loggerInstance.error(message, ex)

  /**
   * Logs the given message and exits with exit code '1'
   *
   * @param message: the message to log before exiting
   */
  protected def fatal(message: => String): Nothing = loggerInstance.fatal(message)

  /**
   * Logs the given message and exception and exits with the specified exit code (default is '1')
   *
   * @param message: the message to log before exiting
   * @param ex: the thrown exception to log
   * @param exitCode exit code (default is '1')
   */
  protected def fatal(message: => String, ex: => Throwable, exitCode: Int = 1): Nothing = loggerInstance.fatal(message, ex, exitCode)

  /**
   * Log a trace message
   *
   * @param message: the message to log
   *
   * @see <a href="http://www.slf4j.org/faq.html#trace">www.slf4j.org/faq.html#trace</a>
   */
  protected def trace(message: => String): Unit = loggerInstance.trace(message)

  /**
   * Log trace message and exception
   *
   * @param message:the message to log
   * @param ex: the thrown exception to log
   *
   * @see <a href="http://www.slf4j.org/faq.html#trace">www.slf4j.org/faq.html#trace</a>
   */
  protected def trace(message: => String, ex: => Throwable): Unit = loggerInstance.trace(message, ex)

  /**
   * Determine whether INFO log messages are enabled in logger's configuration/runtime.
   *
   * @return true when INFO log messages are enabled, otherwise false.
   */
  protected def isInfoEnabled: Boolean = loggerInstance.isInfoEnabled

  /**
   * Determine whether WARN log messages are enabled in logger's configuration/runtime.
   *
   * @return true when WARN log messages are enabled, otherwise false.
   */
  protected def isWarnEnabled: Boolean = loggerInstance.isWarnEnabled

  /**
   * Determine whether ERROR log messages are enabled in logger's configuration/runtime.
   *
   * @return true when ERROR log messages are enabled, otherwise false.
   */
  protected def isErrorEnabled: Boolean = loggerInstance.isErrorEnabled

  /**
   * Determine whether FATAL log messages are enabled in logger's configuration/runtime.
   *
   * @return true when ERROR log messages are also enabled, otherwise false.
   */
  protected def isFatalEnabled: Boolean = loggerInstance.isErrorEnabled

  /**
   * Determine whether TRACE log messages are enabled in logger's configuration/runtime.
   *
   * @return true when TRACE log messages are enabled, otherwise false.
   */
  protected def isTraceEnabled: Boolean = loggerInstance.isTraceEnabled

  /**
   * Determine whether DEBUG log messages are enabled in logger's configuration/runtime.
   *
   * @return true when DEBUG log messages are enabled, otherwise false.
   */
  protected def isDebugEnabled: Boolean = loggerInstance.isDebugEnabled

  /**
   * Execute the given body when info is enabled
   *
   * @param body code to execute
   */
  protected def whenInfo(body: => Unit): Unit = if (loggerInstance.isInfoEnabled) body

  /**
   * Execute the given body when warn is enabled
   *
   * @param body code to execute
   */
  protected def whenWarn(body: => Unit): Unit = if (loggerInstance.isWarnEnabled) body

  /**
   * Execute the given body when error is enabled
   *
   * @param body code to execute
   */
  protected def whenError(body: => Unit): Unit = if (loggerInstance.isErrorEnabled) body

  /**
   * Execute the given body when trace is enabled
   *
   * @param body code to execute
   */
  protected def whenTrace(body: => Unit): Unit = if (loggerInstance.isTraceEnabled) body

  /**
   * Execute the given body when debug is enabled
   *
   * @param body code to execute
   */
  protected def whenDebug(body: => Unit): Unit = if (loggerInstance.isDebugEnabled) body

}