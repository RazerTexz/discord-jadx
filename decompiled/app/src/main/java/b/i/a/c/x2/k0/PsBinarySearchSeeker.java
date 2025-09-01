package b.i.a.c.x2.k0;

import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.TimestampAdjuster;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.BinarySearchSeeker;

/* compiled from: PsBinarySearchSeeker.java */
/* renamed from: b.i.a.c.x2.k0.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class PsBinarySearchSeeker extends BinarySearchSeeker {

    /* compiled from: PsBinarySearchSeeker.java */
    /* renamed from: b.i.a.c.x2.k0.z$b */
    public static final class b implements BinarySearchSeeker.f {
        public final TimestampAdjuster a;

        /* renamed from: b, reason: collision with root package name */
        public final ParsableByteArray f1284b = new ParsableByteArray();

        public b(TimestampAdjuster timestampAdjuster, a aVar) {
            this.a = timestampAdjuster;
        }

        @Override // b.i.a.c.x2.BinarySearchSeeker.f
        public void a() {
            this.f1284b.B(Util2.f);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:36:0x00d5
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        @Override // b.i.a.c.x2.BinarySearchSeeker.f
        public b.i.a.c.x2.BinarySearchSeeker.e b(b.i.a.c.x2.ExtractorInput r17, long r18) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 284
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: b.i.a.c.x2.k0.PsBinarySearchSeeker.b.b(b.i.a.c.x2.i, long):b.i.a.c.x2.a$e");
        }
    }

    public PsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j, long j2) {
        super(new BinarySearchSeeker.b(), new b(timestampAdjuster, null), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    public static int g(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
