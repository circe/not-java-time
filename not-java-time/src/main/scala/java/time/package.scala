package java
package object time {
  private[time] def unimplemented: Nothing = throw new NotImplementedError("Get a real java.time")
}

package time {
  import java.time.format.DateTimeFormatter

  class DateTimeException extends Exception

  trait Duration
  object Duration {
    def parse(input: CharSequence): Duration = unimplemented
  }

  trait Instant
  object Instant {
    def parse(input: CharSequence): Instant = unimplemented
  }

  trait LocalDate
  object LocalDate {
    def parse(input: CharSequence, format: DateTimeFormatter): LocalDate = unimplemented
  }

  trait LocalDateTime
  object LocalDateTime {
    def parse(input: CharSequence, format: DateTimeFormatter): LocalDateTime = unimplemented
  }

  trait LocalTime
  object LocalTime {
    def parse(input: CharSequence, format: DateTimeFormatter): LocalTime = unimplemented
  }

  trait MonthDay
  object MonthDay {
    def parse(input: CharSequence): MonthDay = unimplemented
  }

  trait OffsetDateTime
  object OffsetDateTime {
    def parse(input: CharSequence, format: DateTimeFormatter): OffsetDateTime = unimplemented
  }

  trait OffsetTime
  object OffsetTime {
    def parse(input: CharSequence, format: DateTimeFormatter): OffsetTime = unimplemented
  }

  trait Period
  object Period {
    def parse(input: CharSequence): Period = unimplemented
  }

  trait Year
  object Year {
    def parse(input: CharSequence): Year = unimplemented
  }

  trait YearMonth
  object YearMonth {
    def parse(input: CharSequence): YearMonth = unimplemented
  }

  trait ZoneId
  object ZoneId {
    def of(input: String): ZoneId = unimplemented
  }

  trait ZoneOffset
  object ZoneOffset {
    def of(input: String): ZoneOffset = unimplemented
  }

  trait ZonedDateTime
  object ZonedDateTime {
    def parse(input: CharSequence, format: DateTimeFormatter): ZonedDateTime = unimplemented
  }
}
