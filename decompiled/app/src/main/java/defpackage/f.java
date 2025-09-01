package defpackage;

import android.content.Context;
import android.view.View;
import b.a.d.AppToast;
import b.a.y.OverlayMenuView4;
import b.a.y.OverlayMenuView5;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.OverlayMenuView;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: java-style lambda group */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Object l;

    public f(int i, Object obj, Object obj2) {
        this.j = i;
        this.k = obj;
        this.l = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i != 0) {
            if (i != 1) {
                throw null;
            }
            OverlayMenuView overlayMenuView = (OverlayMenuView) this.k;
            Long lValueOf = Long.valueOf(((OverlayMenuView.a) this.l).c.getChannel().getId());
            int i2 = OverlayMenuView.j;
            Objects.requireNonNull(overlayMenuView);
            overlayMenuView.getContext().startActivity(IntentUtils.RouteBuilders.INSTANCE.connectVoice(lValueOf != null ? lValueOf.longValue() : 0L).setClass(overlayMenuView.getContext(), AppActivity.Main.class).addFlags(268435456));
            overlayMenuView.onDismissRequested.invoke();
            return;
        }
        OverlayMenuView overlayMenuView2 = (OverlayMenuView) this.k;
        Long lValueOf2 = Long.valueOf(((OverlayMenuView.a) this.l).c.getChannel().getId());
        int i3 = OverlayMenuView.j;
        Objects.requireNonNull(overlayMenuView2);
        if (lValueOf2 != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreInviteSettings.generateInvite$default(StoreStream.INSTANCE.getInviteSettings(), lValueOf2.longValue(), null, 2, null), overlayMenuView2, null, 2, null), OverlayMenuView.class, (Context) null, (Function1) null, new OverlayMenuView4(overlayMenuView2), (Function0) null, (Function0) null, new OverlayMenuView5(overlayMenuView2), 54, (Object) null);
        } else {
            AppToast.g(overlayMenuView2.getContext(), R.string.instant_invite_failed_to_generate, 0, null, 12);
        }
    }
}
