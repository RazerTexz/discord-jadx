package com.discord.widgets.settings.premium;

import b.a.d.AppToast;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.gifting.GiftingUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsGifting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/billing/GooglePlayInAppSku;", "inAppSku", "", "invoke", "(Lcom/discord/utilities/billing/GooglePlayInAppSku;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$chooseGiftCallback$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsGifting3 extends Lambda implements Function1<GooglePlayInAppSku, Unit> {
    public final /* synthetic */ Traits.Location $locationTrait;
    public final /* synthetic */ WidgetSettingsGifting this$0;

    /* compiled from: WidgetSettingsGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$chooseGiftCallback$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsGifting.access$enableGiftingButtons(WidgetSettingsGifting3.this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGifting3(WidgetSettingsGifting widgetSettingsGifting, Traits.Location location) {
        super(1);
        this.this$0 = widgetSettingsGifting;
        this.$locationTrait = location;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GooglePlayInAppSku googlePlayInAppSku) {
        invoke2(googlePlayInAppSku);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GooglePlayInAppSku googlePlayInAppSku) {
        Intrinsics3.checkNotNullParameter(googlePlayInAppSku, "inAppSku");
        try {
            GiftingUtils giftingUtils = GiftingUtils.INSTANCE;
            AppActivity appActivityRequireAppActivity = this.this$0.requireAppActivity();
            Traits.Location location = this.$locationTrait;
            if (location == null) {
                location = new Traits.Location("Gifting Settings", null, null, null, null, 30, null);
            }
            giftingUtils.buyGift(appActivityRequireAppActivity, googlePlayInAppSku, location, new AnonymousClass1());
        } catch (Exception unused) {
            WidgetSettingsGifting widgetSettingsGifting = this.this$0;
            AppToast.j(widgetSettingsGifting, FormatUtils.k(widgetSettingsGifting, R.string.error_occurred_try_again, new Object[0], null, 4), 0, 4);
        }
    }
}
