package com.discord.utilities.captcha;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Emitter;

/* compiled from: CaptchaHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/captcha/CaptchaHelper$Failure;", "it", "", "invoke", "(Lcom/discord/utilities/captcha/CaptchaHelper$Failure;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.captcha.CaptchaHelper$tryShowCaptcha$1$errorHandler$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class CaptchaHelper3 extends Lambda implements Function1<CaptchaHelper.Failure, Unit> {
    public final /* synthetic */ Emitter $emitter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaHelper3(Emitter emitter) {
        super(1);
        this.$emitter = emitter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper.Failure failure) {
        invoke2(failure);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper.Failure failure) {
        Intrinsics3.checkNotNullParameter(failure, "it");
        AnalyticsTracker.INSTANCE.captchaFailed(failure.getReasonCode());
        this.$emitter.onError(failure);
    }
}
