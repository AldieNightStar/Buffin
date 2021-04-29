package haxidenti.buffin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BuffTest {

    Buff buff;

    @BeforeEach
    public void prepare() {
        buff = new Buff(32);
    }

    @Test
    public void writeReadStringTest() {
        Assertions.assertTrue(buff.writeString(0, "I am fox!"));
        Assertions.assertEquals("I am fox!", buff.readString(0));
    }

    @Test
    public void writeReadIntTest() {
        Assertions.assertTrue(buff.writeInt(0, 32));
        Assertions.assertEquals(32, buff.readInt(0));
    }

    @Test
    public void writeReadShortTest() {
        Assertions.assertTrue(buff.writeShort(0, (short) 32));
        Assertions.assertEquals(32, buff.readShort(0));
    }

    @Test
    public void writeReadLongTest() {
        Assertions.assertTrue(buff.writeLong(0, (long) 32));
        Assertions.assertEquals(32, buff.readLong(0));
    }

    @Test
    public void writeReadDoubleTest() {
        Assertions.assertTrue(buff.writeDouble(0, (long) 32));
        Assertions.assertEquals(32, buff.readDouble(0));
    }

    @Test
    public void readWriteByteTest() {
        Assertions.assertTrue(buff.writeByte(0, (byte) 32));
        Assertions.assertEquals(32, buff.readByte(0));
    }

    @Test
    public void readWriteStringPos2Test() {
        Assertions.assertTrue(buff.writeString(0, "ABCD"));
        Assertions.assertEquals("ABCD", buff.readString(0, 4));
    }

    @Test
    public void testLength() {
        Assertions.assertEquals(32, buff.size());
        Buff buff2 = new Buff(new ArrayByteStore(8));
        Assertions.assertEquals(8, buff2.size());
    }
}
