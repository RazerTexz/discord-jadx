package b.g.a.c;

import b.g.a.a.JsonFormat;
import b.g.a.a.JsonInclude;
import b.g.a.c.c0.AnnotatedMember;

/* compiled from: BeanDescription.java */
/* renamed from: b.g.a.c.c, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BeanDescription {
    public final JavaType a;

    public BeanDescription(JavaType javaType) {
        this.a = javaType;
    }

    public abstract JsonFormat.d a(JsonFormat.d dVar);

    public abstract AnnotatedMember b();

    public abstract JsonInclude.b c(JsonInclude.b bVar);
}
