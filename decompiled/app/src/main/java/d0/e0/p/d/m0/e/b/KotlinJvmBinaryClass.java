package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.e.b.b0.KotlinClassHeader;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.v.ClassLiteralValue;

/* compiled from: KotlinJvmBinaryClass.kt */
/* renamed from: d0.e0.p.d.m0.e.b.p, reason: use source file name */
/* loaded from: classes3.dex */
public interface KotlinJvmBinaryClass {

    /* compiled from: KotlinJvmBinaryClass.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.p$a */
    public interface a {
        void visit(Name name, Object obj);

        a visitAnnotation(Name name, ClassId classId);

        b visitArray(Name name);

        void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue);

        void visitEnd();

        void visitEnum(Name name, ClassId classId, Name name2);
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.p$b */
    public interface b {
        void visit(Object obj);

        void visitClassLiteral(ClassLiteralValue classLiteralValue);

        void visitEnd();

        void visitEnum(ClassId classId, Name name);
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.p$c */
    public interface c {
        a visitAnnotation(ClassId classId, SourceElement sourceElement);

        void visitEnd();
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.p$d */
    public interface d {
        c visitField(Name name, String str, Object obj);

        e visitMethod(Name name, String str);
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.p$e */
    public interface e extends c {
        a visitParameterAnnotation(int i, ClassId classId, SourceElement sourceElement);
    }

    KotlinClassHeader getClassHeader();

    ClassId getClassId();

    String getLocation();

    void loadClassAnnotations(c cVar, byte[] bArr);

    void visitMembers(d dVar, byte[] bArr);
}
