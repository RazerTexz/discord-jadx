package com.discord.widgets.captcha;

import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetCaptcha.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "", "isCaptchaError", "(Lcom/discord/utilities/error/Error;)Z", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.captcha.WidgetCaptchaKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetCaptcha4 {
    public static final boolean isCaptchaError(Error error) {
        Intrinsics3.checkNotNullParameter(error, "$this$isCaptchaError");
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "response");
        return response.getMessages().keySet().contains(CaptchaHelper.CAPTCHA_KEY);
    }
}
