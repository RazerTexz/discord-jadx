package b.a.y;

import com.discord.overlay.views.OverlayDialog;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: OverlayAppDialog.kt */
/* renamed from: b.a.y.m, reason: use source file name */
/* loaded from: classes2.dex */
public final class OverlayAppDialog3 extends Lambda implements Function1<OverlayDialog, Unit> {
    public static final OverlayAppDialog3 j = new OverlayAppDialog3();

    public OverlayAppDialog3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(OverlayDialog overlayDialog) {
        Intrinsics3.checkNotNullParameter(overlayDialog, "it");
        return Unit.a;
    }
}
