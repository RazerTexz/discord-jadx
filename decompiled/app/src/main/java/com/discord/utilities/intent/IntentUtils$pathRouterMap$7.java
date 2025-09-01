package com.discord.utilities.intent;

import android.content.Context;
import android.net.Uri;
import com.discord.utilities.intent.RouteHandlers;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;

/* compiled from: IntentUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/net/Uri;", "p1", "Lkotlin/text/MatchResult;", "p2", "Landroid/content/Context;", "p3", "Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "invoke", "(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class IntentUtils$pathRouterMap$7 extends FunctionReferenceImpl implements Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata> {
    public IntentUtils$pathRouterMap$7(RouteHandlers routeHandlers) {
        super(3, routeHandlers, RouteHandlers.class, "selectFeature", "selectFeature(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ RouteHandlers.AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
        return invoke2(uri, matchResult, context);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final RouteHandlers.AnalyticsMetadata invoke2(Uri uri, MatchResult matchResult, Context context) {
        Intrinsics3.checkNotNullParameter(uri, "p1");
        Intrinsics3.checkNotNullParameter(context, "p3");
        return ((RouteHandlers) this.receiver).selectFeature(uri, matchResult, context);
    }
}
