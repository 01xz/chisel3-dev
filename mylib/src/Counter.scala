package mylib

import chisel3._

class Counter extends Module {
  val io = IO(new Bundle {
    val cond0 = Input(Bool())
    val cond1 = Input(Bool())
    val flag = Output(Bool())
    val state = Output(UInt(8.W))
  })
  val counter = RegInit(0.U(8.W))

  when(io.cond0) {
    counter := counter + 1.U
  }

  io.state := counter
  io.flag := (counter === 0.U) | io.cond1
}

object Codegen extends App {
  (new chisel3.stage.ChiselStage).execute(args, Seq(chisel3.stage.ChiselGeneratorAnnotation(() => new Counter())))
}
