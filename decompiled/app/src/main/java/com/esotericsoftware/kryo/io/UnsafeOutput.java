package com.esotericsoftware.kryo.io;

import com.discord.api.permission.Permission;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;
import org.objectweb.asm.Opcodes;

/* loaded from: classes.dex */
public final class UnsafeOutput extends Output {
    private static final boolean isLittleEndian = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);
    private boolean supportVarInts;

    public UnsafeOutput() {
        this.supportVarInts = false;
    }

    private final void writeLittleEndianInt(int i) throws IOException, KryoException {
        if (isLittleEndian) {
            writeInt(i);
        } else {
            writeInt(com.esotericsoftware.kryo.util.Util.swapInt(i));
        }
    }

    private final void writeLittleEndianLong(long j) throws IOException, KryoException {
        if (isLittleEndian) {
            writeLong(j);
        } else {
            writeLong(com.esotericsoftware.kryo.util.Util.swapLong(j));
        }
    }

    public boolean supportVarInts() {
        return this.supportVarInts;
    }

    public final void writeBytes(Object obj, long j, long j2) throws IOException, KryoException {
        writeBytes(obj, 0L, j, j2);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeChar(char c) throws IOException, KryoException {
        require(2);
        UnsafeUtil.unsafe().putChar(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, c);
        this.position += 2;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeChars(char[] cArr) throws IOException, KryoException {
        writeBytes(cArr, UnsafeUtil.charArrayBaseOffset, 0L, cArr.length << 1);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeDouble(double d) throws IOException, KryoException {
        require(8);
        UnsafeUtil.unsafe().putDouble(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, d);
        this.position += 8;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeDoubles(double[] dArr) throws IOException, KryoException {
        writeBytes(dArr, UnsafeUtil.doubleArrayBaseOffset, 0L, dArr.length << 3);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeFloat(float f) throws IOException, KryoException {
        require(4);
        UnsafeUtil.unsafe().putFloat(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, f);
        this.position += 4;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeFloats(float[] fArr) throws IOException, KryoException {
        writeBytes(fArr, UnsafeUtil.floatArrayBaseOffset, 0L, fArr.length << 2);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeInt(int i) throws IOException, KryoException {
        require(4);
        UnsafeUtil.unsafe().putInt(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, i);
        this.position += 4;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeInts(int[] iArr, boolean z2) throws IOException, KryoException {
        if (this.supportVarInts) {
            super.writeInts(iArr, z2);
        } else {
            writeBytes(iArr, UnsafeUtil.intArrayBaseOffset, 0L, iArr.length << 2);
        }
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeLong(long j) throws IOException, KryoException {
        require(8);
        UnsafeUtil.unsafe().putLong(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, j);
        this.position += 8;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeLongs(long[] jArr, boolean z2) throws IOException, KryoException {
        if (this.supportVarInts) {
            super.writeLongs(jArr, z2);
        } else {
            writeBytes(jArr, UnsafeUtil.longArrayBaseOffset, 0L, jArr.length << 3);
        }
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeShort(int i) throws IOException, KryoException {
        require(2);
        UnsafeUtil.unsafe().putShort(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, (short) i);
        this.position += 2;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeShorts(short[] sArr) throws IOException, KryoException {
        writeBytes(sArr, UnsafeUtil.shortArrayBaseOffset, 0L, sArr.length << 1);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final int writeVarInt(int i, boolean z2) throws IOException, KryoException {
        if (!z2) {
            i = (i >> 31) ^ (i << 1);
        }
        int i2 = i & Opcodes.LAND;
        int i3 = i >>> 7;
        if (i3 == 0) {
            write(i2);
            return 1;
        }
        int i4 = i2 | 128 | ((i3 & Opcodes.LAND) << 8);
        int i5 = i3 >>> 7;
        if (i5 == 0) {
            writeLittleEndianInt(i4);
            this.position -= 2;
            return 2;
        }
        int i6 = i4 | 32768 | ((i5 & Opcodes.LAND) << 16);
        int i7 = i5 >>> 7;
        if (i7 == 0) {
            writeLittleEndianInt(i6);
            this.position--;
            return 3;
        }
        int i8 = i6 | 8388608 | ((i7 & Opcodes.LAND) << 24);
        if ((i7 >>> 7) == 0) {
            writeLittleEndianInt(i8);
            this.position += 0;
            return 4;
        }
        writeLittleEndianLong((((r7 & Opcodes.LAND) << 32) | i8 | Permission.USE_APPLICATION_COMMANDS) & 68719476735L);
        this.position -= 3;
        return 5;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final int writeVarLong(long j, boolean z2) throws IOException, KryoException {
        long j2 = !z2 ? (j << 1) ^ (j >> 63) : j;
        int i = (int) (j2 & 127);
        long j3 = j2 >>> 7;
        if (j3 == 0) {
            writeByte(i);
            return 1;
        }
        int i2 = (int) (i | 128 | ((j3 & 127) << 8));
        long j4 = j3 >>> 7;
        if (j4 == 0) {
            writeLittleEndianInt(i2);
            this.position -= 2;
            return 2;
        }
        int i3 = (int) (i2 | 32768 | ((j4 & 127) << 16));
        long j5 = j4 >>> 7;
        if (j5 == 0) {
            writeLittleEndianInt(i3);
            this.position--;
            return 3;
        }
        int i4 = (int) (i3 | 8388608 | ((j5 & 127) << 24));
        long j6 = j5 >>> 7;
        if (j6 == 0) {
            writeLittleEndianInt(i4);
            this.position += 0;
            return 4;
        }
        long j7 = (i4 & 4294967295L) | Permission.USE_APPLICATION_COMMANDS | ((j6 & 127) << 32);
        long j8 = j6 >>> 7;
        if (j8 == 0) {
            writeLittleEndianLong(j7);
            this.position -= 3;
            return 5;
        }
        long j9 = j7 | 549755813888L | ((j8 & 127) << 40);
        long j10 = j8 >>> 7;
        if (j10 == 0) {
            writeLittleEndianLong(j9);
            this.position -= 2;
            return 6;
        }
        long j11 = j9 | 140737488355328L | ((j10 & 127) << 48);
        long j12 = j10 >>> 7;
        if (j12 == 0) {
            writeLittleEndianLong(j11);
            this.position--;
            return 7;
        }
        long j13 = ((127 & j12) << 56) | j11 | 36028797018963968L;
        long j14 = j12 >>> 7;
        if (j14 == 0) {
            writeLittleEndianLong(j13);
            return 8;
        }
        writeLittleEndianLong(j13 | Long.MIN_VALUE);
        write((int) (j14 & 255));
        return 9;
    }

    private final void writeBytes(Object obj, long j, long j2, long j3) throws IOException, KryoException {
        int iMin = Math.min(this.capacity - this.position, (int) j3);
        long j4 = j3;
        long j5 = j2;
        while (true) {
            long j6 = iMin;
            UnsafeUtil.unsafe().copyMemory(obj, j + j5, this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, j6);
            this.position += iMin;
            j4 -= j6;
            if (j4 == 0) {
                return;
            }
            j5 += j6;
            iMin = Math.min(this.capacity, (int) j4);
            require(iMin);
        }
    }

    public void supportVarInts(boolean z2) {
        this.supportVarInts = z2;
    }

    public UnsafeOutput(int i) {
        this(i, i);
    }

    public UnsafeOutput(int i, int i2) {
        super(i, i2);
        this.supportVarInts = false;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final int writeInt(int i, boolean z2) throws IOException, KryoException {
        if (!this.supportVarInts) {
            writeInt(i);
            return 4;
        }
        return writeVarInt(i, z2);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final int writeLong(long j, boolean z2) throws IOException, KryoException {
        if (!this.supportVarInts) {
            writeLong(j);
            return 8;
        }
        return writeVarLong(j, z2);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeInts(int[] iArr) throws IOException, KryoException {
        writeBytes(iArr, UnsafeUtil.intArrayBaseOffset, 0L, iArr.length << 2);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public final void writeLongs(long[] jArr) throws IOException, KryoException {
        writeBytes(jArr, UnsafeUtil.longArrayBaseOffset, 0L, jArr.length << 3);
    }

    public UnsafeOutput(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public UnsafeOutput(byte[] bArr, int i) {
        super(bArr, i);
        this.supportVarInts = false;
    }

    public UnsafeOutput(OutputStream outputStream) {
        super(outputStream);
        this.supportVarInts = false;
    }

    public UnsafeOutput(OutputStream outputStream, int i) {
        super(outputStream, i);
        this.supportVarInts = false;
    }
}
