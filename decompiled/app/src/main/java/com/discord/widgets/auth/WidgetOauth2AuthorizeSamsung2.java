package com.discord.widgets.auth;

import com.discord.app.AppLog;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetOauth2AuthorizeSamsung.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "p1", "", "p2", "", "invoke", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$Companion$logI$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetOauth2AuthorizeSamsung2 extends FunctionReferenceImpl implements Function2<String, Throwable, Unit> {
    public WidgetOauth2AuthorizeSamsung2(AppLog appLog) {
        super(2, appLog, AppLog.class, "i", "i(Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Throwable th) {
        invoke2(str, th);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Throwable th) {
        Intrinsics3.checkNotNullParameter(str, "p1");
        ((AppLog) this.receiver).i(str, th);
    }
}
