package com.discord.widgets.user;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.a.a.b.MultiValuePropPremiumUpsellDialog;
import b.a.d.AppToast;
import com.discord.R;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Badge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/Badge;", "badge", "", "invoke", "(Lcom/discord/widgets/user/Badge;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.Badge$Companion$onBadgeClick$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Badge2 extends Lambda implements Function1<Badge, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ FragmentManager $fragmentManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Badge2(FragmentManager fragmentManager, Context context) {
        super(1);
        this.$fragmentManager = fragmentManager;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
        invoke2(badge);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Badge badge) {
        Intrinsics3.checkNotNullParameter(badge, "badge");
        if (badge.getShowPremiumUpSell()) {
            MultiValuePropPremiumUpsellDialog.Companion.a(MultiValuePropPremiumUpsellDialog.INSTANCE, this.$fragmentManager, 5, this.$context.getString(R.string.premium_upsell_badge_active_mobile), null, null, "Profile Modal", "Badge", badge.getObjectType(), false, false, 792);
            return;
        }
        Context context = this.$context;
        CharSequence tooltip = badge.getTooltip();
        if (tooltip == null) {
            tooltip = badge.getText();
        }
        AppToast.h(context, tooltip, 0, null, 12);
    }
}
