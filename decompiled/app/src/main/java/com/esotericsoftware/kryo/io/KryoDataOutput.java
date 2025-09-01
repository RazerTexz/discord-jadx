package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import java.io.DataOutput;
import java.io.IOException;

/* loaded from: classes.dex */
public class KryoDataOutput implements DataOutput {
    public Output output;

    public KryoDataOutput(Output output) {
        setOutput(output);
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    @Override // java.io.DataOutput
    public void write(int i) throws IOException, KryoException {
        this.output.write(i);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z2) throws IOException, KryoException {
        this.output.writeBoolean(z2);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i) throws IOException, KryoException {
        this.output.writeByte(i);
    }

    @Override // java.io.DataOutput
    public void writeBytes(String str) throws IOException, KryoException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            this.output.write((byte) str.charAt(i));
        }
    }

    @Override // java.io.DataOutput
    public void writeChar(int i) throws IOException, KryoException {
        this.output.writeChar((char) i);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) throws IOException, KryoException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            this.output.write((cCharAt >>> '\b') & 255);
            this.output.write((cCharAt >>> 0) & 255);
        }
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d) throws IOException, KryoException {
        this.output.writeDouble(d);
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f) throws IOException, KryoException {
        this.output.writeFloat(f);
    }

    @Override // java.io.DataOutput
    public void writeInt(int i) throws IOException, KryoException {
        this.output.writeInt(i);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j) throws IOException, KryoException {
        this.output.writeLong(j);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i) throws IOException, KryoException {
        this.output.writeShort(i);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException, KryoException {
        this.output.writeString(str);
    }

    @Override // java.io.DataOutput
    public void write(byte[] bArr) throws IOException, KryoException {
        this.output.write(bArr);
    }

    @Override // java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws IOException, KryoException {
        this.output.write(bArr, i, i2);
    }
}
