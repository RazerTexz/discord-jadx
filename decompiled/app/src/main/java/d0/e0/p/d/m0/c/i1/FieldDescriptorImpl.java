package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.FieldDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotatedImpl;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.z.d.Intrinsics3;

/* compiled from: FieldDescriptorImpl.kt */
/* renamed from: d0.e0.p.d.m0.c.i1.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class FieldDescriptorImpl extends AnnotatedImpl implements FieldDescriptor {
    public final PropertyDescriptor k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FieldDescriptorImpl(Annotations4 annotations4, PropertyDescriptor propertyDescriptor) {
        super(annotations4);
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "correspondingProperty");
        this.k = propertyDescriptor;
    }
}
