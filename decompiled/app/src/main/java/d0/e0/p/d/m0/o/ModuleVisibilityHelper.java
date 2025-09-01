package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.z.d.Intrinsics3;

/* compiled from: ModuleVisibilityHelper.kt */
/* renamed from: d0.e0.p.d.m0.o.g, reason: use source file name */
/* loaded from: classes3.dex */
public interface ModuleVisibilityHelper {

    /* compiled from: ModuleVisibilityHelper.kt */
    /* renamed from: d0.e0.p.d.m0.o.g$a */
    public static final class a implements ModuleVisibilityHelper {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.o.ModuleVisibilityHelper
        public boolean isInFriendModule(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
            Intrinsics3.checkNotNullParameter(declarationDescriptor, "what");
            Intrinsics3.checkNotNullParameter(declarationDescriptor2, "from");
            return true;
        }
    }

    boolean isInFriendModule(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2);
}
