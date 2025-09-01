package com.discord.restapi;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import f0.OkHttpClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: RestAPIBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "<anonymous parameter 0>", "Lf0/x;", "<anonymous parameter 1>", "", "invoke", "(Ljava/lang/String;Lf0/x;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.restapi.RestAPIBuilder$Companion$clientCallback$1, reason: use source file name */
/* loaded from: classes.dex */
public final class RestAPIBuilder2 extends Lambda implements Function2<String, OkHttpClient, Unit> {
    public static final RestAPIBuilder2 INSTANCE = new RestAPIBuilder2();

    public RestAPIBuilder2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, OkHttpClient okHttpClient) {
        invoke2(str, okHttpClient);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, OkHttpClient okHttpClient) {
        Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(okHttpClient, "<anonymous parameter 1>");
    }
}
