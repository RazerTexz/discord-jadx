package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.k.a0.p.ReceiverValue;

/* compiled from: ReceiverParameterDescriptorImpl.java */
/* renamed from: d0.e0.p.d.m0.c.i1.f0, reason: use source file name */
/* loaded from: classes3.dex */
public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {
    public final DeclarationDescriptor m;
    public final ReceiverValue n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiverParameterDescriptorImpl(DeclarationDescriptor declarationDescriptor, ReceiverValue receiverValue, Annotations4 annotations4) {
        super(annotations4);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        }
        if (receiverValue == null) {
            a(1);
            throw null;
        }
        if (annotations4 == null) {
            a(2);
            throw null;
        }
        this.m = declarationDescriptor;
        this.n = receiverValue;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "value";
        } else if (i == 2) {
            objArr[0] = "annotations";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else if (i != 5) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 3) {
            objArr[1] = "getValue";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 3 && i != 4) {
            if (i != 5) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.m;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ReceiverValue receiverValue = this.n;
        if (receiverValue != null) {
            return receiverValue;
        }
        a(3);
        throw null;
    }
}
