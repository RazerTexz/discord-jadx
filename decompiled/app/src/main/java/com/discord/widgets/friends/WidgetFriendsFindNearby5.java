package com.discord.widgets.friends;

import com.discord.utilities.captcha.CaptchaHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFriendsFindNearby.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "token", "", "invoke", "(Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$captchaLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFriendsFindNearby5 extends Lambda implements Function1<CaptchaHelper.CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetFriendsFindNearby this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsFindNearby5(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        super(1);
        this.this$0 = widgetFriendsFindNearby;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper.CaptchaPayload captchaPayload) {
        invoke2(captchaPayload);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper.CaptchaPayload captchaPayload) {
        Integer discriminator;
        Intrinsics3.checkNotNullParameter(captchaPayload, "token");
        String username = WidgetFriendsFindNearby.access$getViewModel$p(this.this$0).getUsername();
        if (username == null || (discriminator = WidgetFriendsFindNearby.access$getViewModel$p(this.this$0).getDiscriminator()) == null) {
            return;
        }
        WidgetFriendsFindNearby.access$sendFriendRequest(this.this$0, username, discriminator.intValue(), captchaPayload);
    }
}
