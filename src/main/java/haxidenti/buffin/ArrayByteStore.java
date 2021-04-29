package haxidenti.buffin;

public class ArrayByteStore implements ByteStore {

    byte[] arr;

    public ArrayByteStore(int len) {
        this.arr = new byte[len];
    }

    private boolean limit(int pos) {
        return pos < 0 || pos >= arr.length;
    }

    @Override
    public boolean writeByte(int pos, byte b) {
        if (limit(pos)) return false;
        arr[pos] = b;
        return true;
    }

    @Override
    public byte readByte(int pos) {
        if (limit(pos)) return 0;
        return arr[pos];
    }

    @Override
    public int length() {
        return arr.length;
    }
}
