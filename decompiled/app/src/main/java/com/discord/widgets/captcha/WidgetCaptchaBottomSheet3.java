package com.discord.widgets.captcha;

import android.os.Bundle;
import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetCaptchaBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "resultRequestKey", "Landroid/os/Bundle;", "bundle", "", "invoke", "(Ljava/lang/String;Landroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet3 extends Lambda implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ AppFragment $fragment;
    public final /* synthetic */ Function2 $onCaptchaPayloadReceived;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCaptchaBottomSheet3(String str, Function2 function2, AppFragment appFragment) {
        super(2);
        this.$requestKey = str;
        this.$onCaptchaPayloadReceived = function2;
        this.$fragment = appFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(str, "resultRequestKey");
        Intrinsics3.checkNotNullParameter(bundle, "bundle");
        if (Intrinsics3.areEqual(this.$requestKey, str)) {
            String string = bundle.getString("INTENT_EXTRA_CAPTCHA_TOKEN", "");
            String string2 = bundle.getString("INTENT_EXTRA_CAPTCHA_RQTOKEN", "");
            if (string == null || !(!Intrinsics3.areEqual(string, ""))) {
                return;
            }
            this.$onCaptchaPayloadReceived.invoke(this.$fragment, new CaptchaHelper.CaptchaPayload(string, string2));
        }
    }
}
