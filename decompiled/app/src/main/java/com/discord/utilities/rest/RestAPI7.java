package com.discord.utilities.rest;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import f0.f0.HttpLoggingInterceptor;
import kotlin.Metadata;

/* compiled from: RestAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/utilities/rest/RestAPI$Companion$buildLoggingInterceptor$1", "Lf0/f0/a$b;", "", "message", "", "log", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rest.RestAPI$Companion$buildLoggingInterceptor$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RestAPI7 implements HttpLoggingInterceptor.b {
    @Override // f0.f0.HttpLoggingInterceptor.b
    public void log(String message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Logger.v$default(AppLog.g, message, null, 2, null);
    }
}
