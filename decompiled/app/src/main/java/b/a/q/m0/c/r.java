package b.a.q.m0.c;

import androidx.annotation.NonNull;
import com.hammerandchisel.libdiscord.Discord;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: MediaEngineLegacy.kt */
/* loaded from: classes.dex */
public final class r implements Discord.GetRankedRtcRegionsCallback {
    public final /* synthetic */ Function1 a;

    public r(Function1 function1) {
        this.a = function1;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.GetRankedRtcRegionsCallback
    public final /* synthetic */ void onRankedRtcRegions(@NonNull String[] strArr) {
        Intrinsics3.checkNotNullParameter(strArr, "p0");
        Intrinsics3.checkNotNullExpressionValue(this.a.invoke(strArr), "invoke(...)");
    }
}
