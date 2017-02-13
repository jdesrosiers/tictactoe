package commandline

import org.scalatest._

class CommandLineSpec extends FunSpec with Matchers {
  describe("CommandLine.options") {
    it("should collect --{key}={value} into a map") {
      val args = Array("--foo=bar")
      CommandLine.options(args, Map()) should equal (Map('foo -> "bar"))
    }

    it("should collect multiple --{key}={value} pairs into a map") {
      val args = Array("--foo=bar", "--bar=foo")
      CommandLine.options(args, Map()) should equal (Map('foo -> "bar", 'bar -> "foo"))
    }

    it("should fill in defaults") {
      val args = Array("--foo=bar")
      CommandLine.options(args, Map('bar -> "foo")) should equal (Map('foo -> "bar", 'bar -> "foo"))
    }

    it("should override defaults") {
      val args = Array("--foo=bar", "--bar=foo")
      CommandLine.options(args, Map('bar -> "bar")) should equal (Map('foo -> "bar", 'bar -> "foo"))
    }
  }
}
