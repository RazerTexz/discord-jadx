package d0.e0.p.d.m0.e.b.b0;

import d0.e0.p.d.m0.e.b.b0.ReadKotlinClassHeaderAnnotationVisitor;

/* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* renamed from: d0.e0.p.d.m0.e.b.b0.d, reason: use source file name */
/* loaded from: classes3.dex */
public class ReadKotlinClassHeaderAnnotationVisitor3 extends ReadKotlinClassHeaderAnnotationVisitor.b {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor.c f3370b;

    public ReadKotlinClassHeaderAnnotationVisitor3(ReadKotlinClassHeaderAnnotationVisitor.c cVar) {
        this.f3370b = cVar;
    }

    @Override // d0.e0.p.d.m0.e.b.b0.ReadKotlinClassHeaderAnnotationVisitor.b
    public void b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
        }
        ReadKotlinClassHeaderAnnotationVisitor.this.i = strArr;
    }
}
