package zhttp.http

import zio.test.Assertion.equalTo
import zio.test.{DefaultRunnableSpec, ZSpec, assertM}

import java.io.File

object HttpDataSpec extends DefaultRunnableSpec {
  val suite1 = suite("Test toByteBuf")(testM("HttpData.File") {
    val file = new File(getClass.getResource("/TestFile.txt").getPath)
    val res  = HttpData.fromFile(file).toByteBuf.map(_.toString(HTTP_CHARSET))
    assertM(res)(equalTo("abc\nfoo"))
  })
  override def spec = suite("HttpDataSpec")(suite1)
}
