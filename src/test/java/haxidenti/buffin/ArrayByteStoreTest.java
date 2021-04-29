package haxidenti.buffin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class ArrayByteStoreTest {

    ArrayByteStore store;

    @BeforeEach
    public void prepare() {
        store = new ArrayByteStore(10);
    }

    @Test
    void writeByte() {
        for (int i = 0; i < 20; i++) {
            boolean b = store.writeByte(i, (byte) i);
            if (i < 10) assertTrue(b);
            else assertFalse(b);
        }
    }

    @Test
    void readByte() {
        for (int i = 0; i < 20; i++) {
            boolean b = store.writeByte(i, (byte) i);
            if (i < 10) assertTrue(b);
            else assertFalse(b);
        }
        for (int i = 0; i < 20; i++) {
            byte b = store.readByte(i);
            if (i < 10) assertEquals(i, b);
            else assertEquals(0, b);
        }
    }

    @Test
    void readBytes() {
        store.writeByte(5, (byte) 11);

        byte[] arr = store.readBytes(0, 100);
        assertEquals(100, arr.length);
        assertEquals(11, arr[5]);
        assertEquals(0, arr[99]);
    }

    @Test
    void writeBytes() {
        store.writeBytes(0, "Hello".getBytes(StandardCharsets.UTF_8));

        byte[] arr = store.readBytes(0, 5);
        assertEquals("Hello", new String(arr));
    }
}