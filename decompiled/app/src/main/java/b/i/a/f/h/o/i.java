package b.i.a.f.h.o;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.zzf;

/* loaded from: classes3.dex */
public class i implements SafetyNetApi {

    public static abstract class a extends d<SafetyNetApi.a> {
        public e l;

        public a(b.i.a.f.e.h.c cVar) {
            super(cVar);
            this.l = new k(this);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ b.i.a.f.e.h.h d(Status status) {
            return new b(status, null);
        }
    }

    public static class b implements SafetyNetApi.a {
        public final Status j;
        public final zzf k;

        public b(Status status, zzf zzfVar) {
            this.j = status;
            this.k = zzfVar;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.a
        public final String C() {
            zzf zzfVar = this.k;
            if (zzfVar == null) {
                return null;
            }
            return zzfVar.j;
        }

        @Override // b.i.a.f.e.h.h
        public final Status b0() {
            return this.j;
        }
    }
}
