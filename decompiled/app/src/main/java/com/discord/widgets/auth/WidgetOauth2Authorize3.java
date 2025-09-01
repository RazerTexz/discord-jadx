package com.discord.widgets.auth;

import android.net.Uri;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetOauth2Authorize.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/net/Uri;", "", "parameterName", "invoke", "(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;", "getQueryParameterOrThrow"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$Companion$createOauthAuthorize$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetOauth2Authorize3 extends Lambda implements Function2<Uri, String, String> {
    public static final WidgetOauth2Authorize3 INSTANCE = new WidgetOauth2Authorize3();

    public WidgetOauth2Authorize3() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ String invoke(Uri uri, String str) {
        return invoke2(uri, str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Uri uri, String str) {
        Intrinsics3.checkNotNullParameter(uri, "$this$getQueryParameterOrThrow");
        Intrinsics3.checkNotNullParameter(str, "parameterName");
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter != null) {
            return queryParameter;
        }
        throw new IllegalArgumentException(str);
    }
}
