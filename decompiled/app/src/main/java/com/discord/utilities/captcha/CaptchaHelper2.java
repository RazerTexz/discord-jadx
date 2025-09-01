package com.discord.utilities.captcha;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.discord.app.AppActivity;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: CaptchaHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "com/discord/utilities/captcha/CaptchaHelper$showCaptchaHelpDialog$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.captcha.CaptchaHelper$showCaptchaHelpDialog$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class CaptchaHelper2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ AppActivity $activity$inlined;
    public final /* synthetic */ Function0 $onOpenBrowser$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaHelper2(AppActivity appActivity, Function0 function0) {
        super(1);
        this.$activity$inlined = appActivity;
        this.$onOpenBrowser$inlined = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://discord.com/app")));
        Function0 function0 = this.$onOpenBrowser$inlined;
        if (function0 != null) {
        }
    }
}
