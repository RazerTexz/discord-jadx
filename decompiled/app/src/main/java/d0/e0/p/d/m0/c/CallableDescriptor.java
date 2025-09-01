package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.n.KotlinType;
import java.util.Collection;
import java.util.List;

/* compiled from: CallableDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface CallableDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility, Substitutable<CallableDescriptor> {

    /* compiled from: CallableDescriptor.java */
    /* renamed from: d0.e0.p.d.m0.c.a$a */
    public interface a<V> {
    }

    ReceiverParameterDescriptor getDispatchReceiverParameter();

    ReceiverParameterDescriptor getExtensionReceiverParameter();

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    CallableDescriptor getOriginal();

    Collection<? extends CallableDescriptor> getOverriddenDescriptors();

    KotlinType getReturnType();

    List<TypeParameterDescriptor> getTypeParameters();

    <V> V getUserData(a<V> aVar);

    List<ValueParameterDescriptor> getValueParameters();

    boolean hasSynthesizedParameterNames();
}
