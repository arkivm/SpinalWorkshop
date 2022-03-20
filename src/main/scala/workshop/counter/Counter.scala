package workshop.counter

import spinal.core._

case class Counter(width: Int) extends Component {
  val io = new Bundle {
    val clear    = in  Bool()
    val value    = out UInt(width bits)
    val full     = out Bool()
  }

  val full_value = UInt(width bits).setAll()
  var value = 0
  value = value + 1

  io.value := value

  when (io.clear === True) {
    io.value := 0
  }

  when (io.value === full_value) {
    io.full := True
  }.otherwise {
    io.full := False
  }
}
