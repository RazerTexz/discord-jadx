package b.i.c.u.p;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* compiled from: InstallationResponse.java */
@AutoValue
/* renamed from: b.i.c.u.p.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class InstallationResponse {

    /* compiled from: InstallationResponse.java */
    /* renamed from: b.i.c.u.p.d$a */
    public enum a {
        OK,
        BAD_CONFIG
    }

    @Nullable
    public abstract TokenResult a();

    @Nullable
    public abstract String b();

    @Nullable
    public abstract String c();

    @Nullable
    public abstract a d();

    @Nullable
    public abstract String e();
}
