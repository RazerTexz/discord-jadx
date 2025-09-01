package d0.e0.p.d.m0.c;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: ModuleCapability.kt */
/* renamed from: d0.e0.p.d.m0.c.b0, reason: use source file name */
/* loaded from: classes3.dex */
public final class ModuleCapability<T> {
    public final String a;

    public ModuleCapability(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.a = str;
    }

    public String toString() {
        return this.a;
    }
}
