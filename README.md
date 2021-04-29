# Buffin

Manipulate with data in one buffer

# Import (gradle)
```groovy
repositories {
    // ...
  
    // Add this line down below
    maven { url 'https://jitpack.io' }
}

dependencies {
    // ...
    
    // Add this line down below
    implementation 'com.github.AldieNightStar:Buffin:b66d4d9215'
}
```

# Usage
```java
// Constructors
Buff buff = new Buff(SIZE);
Buff buff = new Buff(new ArrayByteStore(SIZE));

// Read
int n = buff.readInt(POS)
short n = buff.readShort(POS)
long n = buff.readLong(POS)
double n = buff.readDouble(POS)
String s = buff.readString(POS)
String s = buff.readString(POS, POS2)
byte b = buff.readByte(POS)

// Write
boolean ok = buff.writeInt(POS, NUMBER)
boolean ok = buff.writeShort(POS, NUMBER)
boolean ok = buff.writeLong(POS, NUMBER)
boolean ok = buff.writeDouble(POS, NUMBER)
boolean ok = buff.writeString(POS, STRING)
boolean ok = buff.writeByte(POS, NUMBER)

// Get size
int size = buff.size()
```

# Example
```java
Buff buff = new Buff(32);

buff.writeString(0, "Hi!");
System.out.println(buff.readString(0));

buff.writeByte(0, (byte) 11);
System.out.println(buff.readByte(0));

buff.writeInt(5, 125);
System.out.println(buff.readInt(5));
```
