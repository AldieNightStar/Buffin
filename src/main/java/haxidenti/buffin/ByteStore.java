package haxidenti.buffin;

public interface ByteStore {
    boolean writeByte(int pos, byte b);
    byte readByte(int pos);
    int length();

    default byte[] readBytes(int pos1, int pos2) {
        int len = pos2 - pos1;
        if (len < 1) {
            return new byte[0];
        }
        byte[] arr = new byte[len];
        for (int i = pos1; i < pos2; i++) {
            arr[i] = readByte(i);
        }
        return arr;
    }

    default boolean writeBytes(int pos, byte[] bytes) {
        boolean success = true;
        for (int i = 0; i < bytes.length; i++) {
            success = writeByte(i + pos, bytes[i]);
            if (!success) break;
        }
        return success;
    }
}
