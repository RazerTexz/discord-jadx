package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.k.a0.p.ReceiverValue;
import d0.e0.p.d.m0.n.TypeSubstitutor2;

/* compiled from: ReceiverParameterDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.q0, reason: use source file name */
/* loaded from: classes3.dex */
public interface ReceiverParameterDescriptor extends ParameterDescriptor {
    ReceiverValue getValue();

    ReceiverParameterDescriptor substitute(TypeSubstitutor2 typeSubstitutor2);
}
