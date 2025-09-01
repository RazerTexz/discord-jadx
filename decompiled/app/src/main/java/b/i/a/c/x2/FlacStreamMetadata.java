package b.i.a.c.x2;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: FlacStreamMetadata.java */
/* renamed from: b.i.a.c.x2.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class FlacStreamMetadata {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1292b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final long j;

    @Nullable
    public final a k;

    @Nullable
    public final Metadata l;

    /* compiled from: FlacStreamMetadata.java */
    /* renamed from: b.i.a.c.x2.o$a */
    public static class a {
        public final long[] a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f1293b;

        public a(long[] jArr, long[] jArr2) {
            this.a = jArr;
            this.f1293b = jArr2;
        }
    }

    public FlacStreamMetadata(byte[] bArr, int i) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.k(i * 8);
        this.a = parsableBitArray.g(16);
        this.f1292b = parsableBitArray.g(16);
        this.c = parsableBitArray.g(24);
        this.d = parsableBitArray.g(24);
        int iG = parsableBitArray.g(20);
        this.e = iG;
        this.f = h(iG);
        this.g = parsableBitArray.g(3) + 1;
        int iG2 = parsableBitArray.g(5) + 1;
        this.h = iG2;
        this.i = c(iG2);
        this.j = (Util2.L(parsableBitArray.g(4)) << 32) | Util2.L(parsableBitArray.g(32));
        this.k = null;
        this.l = null;
    }

    @Nullable
    public static Metadata a(List<String> list, List<PictureFrame> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] strArrI = Util2.I(str, "=");
            if (strArrI.length != 2) {
                String strValueOf = String.valueOf(str);
                Log.w("FlacStreamMetadata", strValueOf.length() != 0 ? "Failed to parse Vorbis comment: ".concat(strValueOf) : new String("Failed to parse Vorbis comment: "));
            } else {
                arrayList.add(new VorbisComment(strArrI[0], strArrI[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static int c(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    public static int h(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public FlacStreamMetadata b(@Nullable a aVar) {
        return new FlacStreamMetadata(this.a, this.f1292b, this.c, this.d, this.e, this.g, this.h, this.j, aVar, this.l);
    }

    public long d() {
        long j = this.j;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / this.e;
    }

    public Format2 e(byte[] bArr, @Nullable Metadata metadata) {
        bArr[4] = -128;
        int i = this.d;
        if (i <= 0) {
            i = -1;
        }
        Metadata metadataF = f(metadata);
        Format2.b bVar = new Format2.b();
        bVar.k = "audio/flac";
        bVar.l = i;
        bVar.f1023x = this.g;
        bVar.f1024y = this.e;
        bVar.m = Collections.singletonList(bArr);
        bVar.i = metadataF;
        return bVar.a();
    }

    @Nullable
    public Metadata f(@Nullable Metadata metadata) {
        Metadata metadata2 = this.l;
        return metadata2 == null ? metadata : metadata == null ? metadata2 : metadata2.a(metadata.j);
    }

    public long g(long j) {
        return Util2.i((j * this.e) / 1000000, 0L, this.j - 1);
    }

    public FlacStreamMetadata(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, @Nullable a aVar, @Nullable Metadata metadata) {
        this.a = i;
        this.f1292b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = h(i5);
        this.g = i6;
        this.h = i7;
        this.i = c(i7);
        this.j = j;
        this.k = aVar;
        this.l = metadata;
    }
}
