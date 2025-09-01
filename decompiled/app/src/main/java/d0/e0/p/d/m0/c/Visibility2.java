package d0.e0.p.d.m0.c;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: Visibility.kt */
/* renamed from: d0.e0.p.d.m0.c.f1, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Visibility2 {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3247b;

    public Visibility2(String str, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.a = str;
        this.f3247b = z2;
    }

    public Integer compareTo(Visibility2 visibility2) {
        Intrinsics3.checkNotNullParameter(visibility2, "visibility");
        return Visibilities.a.compareLocal$compiler_common(this, visibility2);
    }

    public String getInternalDisplayName() {
        return this.a;
    }

    public final boolean isPublicAPI() {
        return this.f3247b;
    }

    public Visibility2 normalize() {
        return this;
    }

    public final String toString() {
        return getInternalDisplayName();
    }
}
