package b.f.j.h;

import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Closeables;
import b.f.d.d.Throwables;
import b.f.d.g.ByteArrayPool;
import b.f.d.g.PooledByteArrayBufferedInputStream;
import b.f.j.j.EncodedImage2;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* compiled from: ProgressiveJpegParser.java */
/* renamed from: b.f.j.h.e, reason: use source file name */
/* loaded from: classes.dex */
public class ProgressiveJpegParser {
    public int a;

    /* renamed from: b, reason: collision with root package name */
    public int f589b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public final ByteArrayPool h;

    public ProgressiveJpegParser(ByteArrayPool byteArrayPool) {
        Objects.requireNonNull(byteArrayPool);
        this.h = byteArrayPool;
        this.c = 0;
        this.f589b = 0;
        this.d = 0;
        this.f = 0;
        this.e = 0;
        this.a = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b7, code lost:
    
        if (r11.a == 6) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bb, code lost:
    
        if (r11.e == r0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bd, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(InputStream inputStream) throws Throwable {
        int i;
        int i2 = this.e;
        while (true) {
            try {
                boolean z2 = false;
                if (this.a == 6 || (i = inputStream.read()) == -1) {
                    break;
                }
                int i3 = this.c + 1;
                this.c = i3;
                if (this.g) {
                    this.a = 6;
                    this.g = false;
                    return false;
                }
                int i4 = this.a;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 == 4) {
                                    this.a = 5;
                                } else if (i4 != 5) {
                                    AnimatableValueParser.B(false);
                                } else {
                                    int i5 = ((this.f589b << 8) + i) - 2;
                                    AnimatableValueParser.c2(inputStream, i5);
                                    this.c += i5;
                                    this.a = 2;
                                }
                            } else if (i == 255) {
                                this.a = 3;
                            } else if (i == 0) {
                                this.a = 2;
                            } else if (i == 217) {
                                this.g = true;
                                int i6 = i3 - 2;
                                int i7 = this.d;
                                if (i7 > 0) {
                                    this.f = i6;
                                }
                                this.d = i7 + 1;
                                this.e = i7;
                                this.a = 2;
                            } else {
                                if (i == 218) {
                                    int i8 = i3 - 2;
                                    int i9 = this.d;
                                    if (i9 > 0) {
                                        this.f = i8;
                                    }
                                    this.d = i9 + 1;
                                    this.e = i9;
                                }
                                if (i != 1 && ((i < 208 || i > 215) && i != 217 && i != 216)) {
                                    z2 = true;
                                }
                                if (z2) {
                                    this.a = 4;
                                } else {
                                    this.a = 2;
                                }
                            }
                        } else if (i == 255) {
                            this.a = 3;
                        }
                    } else if (i == 216) {
                        this.a = 2;
                    } else {
                        this.a = 6;
                    }
                } else if (i == 255) {
                    this.a = 1;
                } else {
                    this.a = 6;
                }
                this.f589b = i;
            } catch (IOException e) {
                Throwables.a(e);
                throw new RuntimeException(e);
            }
        }
    }

    public boolean b(EncodedImage2 encodedImage2) {
        if (this.a == 6 || encodedImage2.n() <= this.c) {
            return false;
        }
        PooledByteArrayBufferedInputStream pooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(encodedImage2.f(), this.h.get(16384), this.h);
        try {
            try {
                AnimatableValueParser.c2(pooledByteArrayBufferedInputStream, this.c);
                return a(pooledByteArrayBufferedInputStream);
            } catch (IOException e) {
                Throwables.a(e);
                throw new RuntimeException(e);
            }
        } finally {
            Closeables.b(pooledByteArrayBufferedInputStream);
        }
    }
}
