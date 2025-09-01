package b.a.q.l0;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WiredHeadsetState.kt */
/* renamed from: b.a.q.l0.a, reason: use source file name */
/* loaded from: classes.dex */
public abstract class WiredHeadsetState {

    /* compiled from: WiredHeadsetState.kt */
    /* renamed from: b.a.q.l0.a$a */
    public static final class a extends WiredHeadsetState {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f265b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, boolean z2) {
            super(false, null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.a = str;
            this.f265b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.a, aVar.a) && this.f265b == aVar.f265b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.a;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.f265b;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PluggedIn(name=");
            sbU.append(this.a);
            sbU.append(", hasMic=");
            return outline.O(sbU, this.f265b, ")");
        }
    }

    /* compiled from: WiredHeadsetState.kt */
    /* renamed from: b.a.q.l0.a$b */
    public static final class b extends WiredHeadsetState {
        public static final b a = new b();

        public b() {
            super(false, null);
        }

        public String toString() {
            return "WiredHeadsetState.Unplugged";
        }
    }

    public WiredHeadsetState(boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
    }
}
