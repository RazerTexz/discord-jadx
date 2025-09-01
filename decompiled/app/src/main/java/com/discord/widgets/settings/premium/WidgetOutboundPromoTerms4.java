package com.discord.widgets.settings.premium;

import android.content.Context;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetOutboundPromoTerms.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/content/Context;", "context", "", "url", "<anonymous parameter 2>", "", "invoke", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.WidgetOutboundPromoTerms$renderContext$1$onClickUrl$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetOutboundPromoTerms4 extends Lambda implements Function3<Context, String, String, Unit> {
    public static final WidgetOutboundPromoTerms4 INSTANCE = new WidgetOutboundPromoTerms4();

    public WidgetOutboundPromoTerms4() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
        invoke2(context, str, str2);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context context, String str, String str2) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(str, "url");
        UriHandler.handle$default(UriHandler.INSTANCE, context, str, false, false, null, 28, null);
    }
}
