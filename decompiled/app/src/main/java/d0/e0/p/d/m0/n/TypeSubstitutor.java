package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.g.FqName;
import kotlin.jvm.functions.Function1;

/* compiled from: TypeSubstitutor.java */
/* renamed from: d0.e0.p.d.m0.n.b1, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypeSubstitutor implements Function1<FqName, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FqName fqName) {
        return invoke2(fqName);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public Boolean invoke2(FqName fqName) {
        if (fqName != null) {
            return Boolean.valueOf(!fqName.equals(StandardNames.a.G));
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", ModelAuditLogEntry.CHANGE_KEY_NAME, "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
    }
}
