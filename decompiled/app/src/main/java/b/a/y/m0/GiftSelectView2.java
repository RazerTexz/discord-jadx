package b.a.y.m0;

import android.view.View;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.views.premium.GiftSelectView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GiftSelectView.kt */
/* renamed from: b.a.y.m0.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class GiftSelectView2 implements View.OnClickListener {
    public final /* synthetic */ GiftSelectView j;

    public GiftSelectView2(GiftSelectView giftSelectView) {
        this.j = giftSelectView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<? super GooglePlayInAppSku, Unit> function1;
        GiftSelectView giftSelectView = this.j;
        GooglePlayInAppSku googlePlayInAppSku = giftSelectView.inAppSku;
        if (googlePlayInAppSku != null && (function1 = giftSelectView.onClickPlan) != null) {
            function1.invoke(googlePlayInAppSku);
        }
        giftSelectView.binding.c.setOnClickListener(null);
    }
}
