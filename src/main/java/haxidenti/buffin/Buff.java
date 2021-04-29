package haxidenti.buffin;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Buff {
    private ByteStore store;

    public Buff(ByteStore store) {
        this.store = store;
    }

    public Buff(int len) {
        this.store = new ArrayByteStore(len);
    }

    public int readInt(int pos) {
        return ByteBuffer.wrap(store.readBytes(pos, pos + 4)).getInt();
    }

    public short readShort(int pos) {
        return ByteBuffer.wrap(store.readBytes(pos, pos + 2)).getShort();
    }

    public long readLong(int pos) {
        return ByteBuffer.wrap(store.readBytes(pos, pos + 8)).getLong();
    }

    public double readDouble(int pos) {
        return ByteBuffer.wrap(store.readBytes(pos, pos + 8)).getDouble();
    }

    public String readString(int pos, int pos2) {
        byte[] arr = store.readBytes(pos, pos2);
        return new String(arr, StandardCharsets.UTF_8);
    }

    public String readString(int pos) {
        ArrayList<Byte> list = new ArrayList<>(100);
        byte[] arr = store.readBytes(pos, pos + 2048);
        for (byte b : arr) {
            if (b == 0x0) break;
            list.add(b);
        }

        byte[] arr2 = new byte[list.size()];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = list.get(i);
        }
        return new String(arr2, StandardCharsets.UTF_8);
    }

    public byte readByte(int pos) {
        return store.readByte(pos);
    }

    // ==========================
    public boolean writeInt(int pos, int n) {
        return store.writeBytes(pos, ByteBuffer.allocate(4).putInt(n).array());
    }

    public boolean writeShort(int pos, short n) {
        return store.writeBytes(pos, ByteBuffer.allocate(2).putShort(n).array());
    }

    public boolean writeLong(int pos, long n) {
        return store.writeBytes(pos, ByteBuffer.allocate(8).putLong(n).array());
    }

    public boolean writeDouble(int pos, double n) {
        return store.writeBytes(pos, ByteBuffer.allocate(8).putDouble(n).array());
    }

    public boolean writeString(int pos, String str) {
        return store.writeBytes(pos, str.getBytes(StandardCharsets.UTF_8));
    }

    public boolean writeByte(int pos, byte b) {
        return store.writeByte(pos, b);
    }

    // ==============================

    public int size() {
        return store.length();
    }
}
