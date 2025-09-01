package b.a.q.k0;

import android.content.Context;
import android.os.Process;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AudioPermissions.kt */
/* renamed from: b.a.q.k0.b, reason: use source file name */
/* loaded from: classes.dex */
public final class AudioPermissions {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final boolean f262b;
    public final boolean c;
    public final boolean d;

    /* compiled from: AudioPermissions.kt */
    /* renamed from: b.a.q.k0.b$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public AudioPermissions(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        boolean z2 = context.checkPermission("android.permission.MODIFY_AUDIO_SETTINGS", Process.myPid(), Process.myUid()) == 0;
        boolean z3 = context.checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) == 0;
        boolean z4 = context.checkPermission("android.permission.BLUETOOTH", Process.myPid(), Process.myUid()) == 0;
        this.f262b = z2;
        this.c = z3;
        this.d = z4;
        if (!z2) {
            AnimatableValueParser.f1("AudioPermissions", "MODIFY_AUDIO_SETTINGS permission is missing");
        }
        if (!z3) {
            AnimatableValueParser.f1("AudioPermissions", "RECORD_AUDIO permission is missing");
        }
        if (z4) {
            return;
        }
        AnimatableValueParser.f1("AudioPermissions", "BLUETOOTH permission is missing");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioPermissions)) {
            return false;
        }
        AudioPermissions audioPermissions = (AudioPermissions) obj;
        return this.f262b == audioPermissions.f262b && this.c == audioPermissions.c && this.d == audioPermissions.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.f262b;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.c;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z3 = this.d;
        return i3 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AudioPermissions(hasModifyAudioSettingsPermission=");
        sbU.append(this.f262b);
        sbU.append(", hasRecordAudioPermission=");
        sbU.append(this.c);
        sbU.append(", hasBluetoothPermission=");
        return outline.O(sbU, this.d, ")");
    }
}
