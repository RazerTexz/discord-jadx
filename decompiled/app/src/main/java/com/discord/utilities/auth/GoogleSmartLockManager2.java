package com.discord.utilities.auth;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.api.ResolvableApiException;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: GoogleSmartLockManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.auth.GoogleSmartLockManager$resolveResult$notice$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GoogleSmartLockManager2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ ResolvableApiException $rae;
    public final /* synthetic */ GoogleSmartLockManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleSmartLockManager2(GoogleSmartLockManager googleSmartLockManager, ResolvableApiException resolvableApiException) {
        super(1);
        this.this$0 = googleSmartLockManager;
        this.$rae = resolvableApiException;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Object next;
        Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics3.checkNotNullExpressionValue(fragments, "activity.supportFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (_Collections.contains(GoogleSmartLockManager.access$getResolvableFragments$p(this.this$0), Reflection2.getOrCreateKotlinClass(((Fragment) next).getClass()))) {
                break;
            }
        }
        Fragment fragment = (Fragment) next;
        if (fragment == null) {
            return true;
        }
        GoogleSmartLockManager.access$resolveResult(this.this$0, fragment, GoogleSmartLockManager.GOOGLE_SMART_LOCK_REQUEST_CODE_RESOLVE, this.$rae);
        return true;
    }
}
