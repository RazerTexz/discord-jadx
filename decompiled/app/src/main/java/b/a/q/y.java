package b.a.q;

import com.discord.rtcconnection.RtcConnection;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: RtcConnection.kt */
/* loaded from: classes.dex */
public final class y extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Throwable $throwable;
    public final /* synthetic */ RtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(RtcConnection rtcConnection, Throwable th) {
        super(0);
        this.this$0 = rtcConnection;
        this.$throwable = th;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() throws NumberFormatException {
        RtcConnection.j(this.this$0, false, "Unable to prepare media engine.", this.$throwable, false, 8);
        return Unit.a;
    }
}
