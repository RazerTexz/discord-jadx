package com.discord.widgets.captcha;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppFragment;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetCaptchaBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "appActivity", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$Companion$enqueue$captchaNotice$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ CaptchaErrorBody $error;
    public final /* synthetic */ Function0 $onCaptchaAttemptFailed;
    public final /* synthetic */ Function2 $onCaptchaPayloadReceived;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCaptchaBottomSheet2(String str, CaptchaErrorBody captchaErrorBody, Function0 function0, Function2 function2) {
        super(1);
        this.$requestKey = str;
        this.$error = captchaErrorBody;
        this.$onCaptchaAttemptFailed = function0;
        this.$onCaptchaPayloadReceived = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Object next;
        Intrinsics3.checkNotNullParameter(fragmentActivity, "appActivity");
        WidgetCaptchaBottomSheet.Companion companion = WidgetCaptchaBottomSheet.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        companion.show(supportFragmentManager, this.$requestKey, this.$error, this.$onCaptchaAttemptFailed);
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), "captcha notice", 0L, 2, null);
        FragmentManager supportFragmentManager2 = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager2, "appActivity.supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager2.getFragments();
        Intrinsics3.checkNotNullExpressionValue(fragments, "appActivity.supportFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (_Collections.contains(WidgetCaptchaBottomSheet.access$getResolvableFragments$cp(), Reflection2.getOrCreateKotlinClass(((Fragment) next).getClass()))) {
                break;
            }
        }
        Fragment fragment = (Fragment) next;
        if (fragment == null) {
            return true;
        }
        WidgetCaptchaBottomSheet.INSTANCE.registerForResult((AppFragment) fragment, this.$requestKey, this.$onCaptchaPayloadReceived);
        return true;
    }
}
