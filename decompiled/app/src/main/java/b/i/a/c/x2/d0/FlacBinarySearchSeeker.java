package b.i.a.c.x2.d0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.BinarySearchSeeker;
import b.i.a.c.x2.BinarySearchSeeker2;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.FlacFrameReader;
import b.i.a.c.x2.FlacStreamMetadata;
import com.discord.api.permission.Permission;
import java.io.IOException;
import java.util.Objects;

/* compiled from: FlacBinarySearchSeeker.java */
/* renamed from: b.i.a.c.x2.d0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class FlacBinarySearchSeeker extends BinarySearchSeeker {

    /* compiled from: FlacBinarySearchSeeker.java */
    /* renamed from: b.i.a.c.x2.d0.c$b */
    public static final class b implements BinarySearchSeeker.f {
        public final FlacStreamMetadata a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1168b;
        public final FlacFrameReader.a c = new FlacFrameReader.a();

        public b(FlacStreamMetadata flacStreamMetadata, int i, a aVar) {
            this.a = flacStreamMetadata;
            this.f1168b = i;
        }

        @Override // b.i.a.c.x2.BinarySearchSeeker.f
        public /* synthetic */ void a() {
            BinarySearchSeeker2.a(this);
        }

        @Override // b.i.a.c.x2.BinarySearchSeeker.f
        public BinarySearchSeeker.e b(ExtractorInput extractorInput, long j) throws IOException {
            long position = extractorInput.getPosition();
            long jC = c(extractorInput);
            long jF = extractorInput.f();
            extractorInput.g(Math.max(6, this.a.c));
            long jC2 = c(extractorInput);
            return (jC > j || jC2 <= j) ? jC2 <= j ? BinarySearchSeeker.e.c(jC2, extractorInput.f()) : BinarySearchSeeker.e.a(jC, position) : BinarySearchSeeker.e.b(jF);
        }

        public final long c(ExtractorInput extractorInput) throws IOException {
            while (extractorInput.f() < extractorInput.b() - 6) {
                FlacStreamMetadata flacStreamMetadata = this.a;
                int i = this.f1168b;
                FlacFrameReader.a aVar = this.c;
                long jF = extractorInput.f();
                byte[] bArr = new byte[2];
                boolean zB = false;
                extractorInput.o(bArr, 0, 2);
                if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                    extractorInput.k();
                    extractorInput.g((int) (jF - extractorInput.getPosition()));
                } else {
                    ParsableByteArray parsableByteArray = new ParsableByteArray(16);
                    System.arraycopy(bArr, 0, parsableByteArray.a, 0, 2);
                    parsableByteArray.D(AnimatableValueParser.z1(extractorInput, parsableByteArray.a, 2, 14));
                    extractorInput.k();
                    extractorInput.g((int) (jF - extractorInput.getPosition()));
                    zB = FlacFrameReader.b(parsableByteArray, flacStreamMetadata, i, aVar);
                }
                if (zB) {
                    break;
                }
                extractorInput.g(1);
            }
            if (extractorInput.f() < extractorInput.b() - 6) {
                return this.c.a;
            }
            extractorInput.g((int) (extractorInput.b() - extractorInput.f()));
            return this.a.j;
        }
    }

    public FlacBinarySearchSeeker(FlacStreamMetadata flacStreamMetadata, int i, long j, long j2) {
        long j3;
        long j4;
        Objects.requireNonNull(flacStreamMetadata);
        b.i.a.c.x2.d0.b bVar = new b.i.a.c.x2.d0.b(flacStreamMetadata);
        b bVar2 = new b(flacStreamMetadata, i, null);
        long jD = flacStreamMetadata.d();
        long j5 = flacStreamMetadata.j;
        int i2 = flacStreamMetadata.d;
        if (i2 > 0) {
            j3 = (i2 + flacStreamMetadata.c) / 2;
            j4 = 1;
        } else {
            int i3 = flacStreamMetadata.a;
            j3 = ((((i3 != flacStreamMetadata.f1292b || i3 <= 0) ? Permission.SEND_TTS_MESSAGES : i3) * flacStreamMetadata.g) * flacStreamMetadata.h) / 8;
            j4 = 64;
        }
        super(bVar, bVar2, jD, 0L, j5, j, j2, j3 + j4, Math.max(6, flacStreamMetadata.c));
    }
}
