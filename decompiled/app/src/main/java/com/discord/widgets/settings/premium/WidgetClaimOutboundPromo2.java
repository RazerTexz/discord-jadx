package com.discord.widgets.settings.premium;

import android.os.Bundle;
import android.os.Parcelable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetClaimOutboundPromo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "requestKey", "Landroid/os/Bundle;", "bundle", "", "invoke", "(Ljava/lang/String;Landroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$Companion$showAndRegisterForClaimResult$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetClaimOutboundPromo2 extends Lambda implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function1 $onPromoClaimed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetClaimOutboundPromo2(Function1 function1) {
        super(2);
        this.$onPromoClaimed = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(str, "requestKey");
        Intrinsics3.checkNotNullParameter(bundle, "bundle");
        if (Intrinsics3.areEqual("KEY_PROMO_CLAIMED", str)) {
            Function1 function1 = this.$onPromoClaimed;
            Parcelable parcelable = bundle.getParcelable("KEY_PROMO_CLAIMED");
            Intrinsics3.checkNotNull(parcelable);
            function1.invoke(parcelable);
        }
    }
}
