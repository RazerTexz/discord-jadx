package com.discord.widgets.user.profile;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: UserProfileConnectionsView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "invoke", "(Ljava/lang/String;ILjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.profile.UserProfileConnectionsView$ConnectedAccountsAdapter$onConnectedAccountClick$1, reason: use source file name */
/* loaded from: classes.dex */
public final class UserProfileConnectionsView2 extends Lambda implements Function3<String, Integer, String, Unit> {
    public static final UserProfileConnectionsView2 INSTANCE = new UserProfileConnectionsView2();

    public UserProfileConnectionsView2() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
        invoke(str, num.intValue(), str2);
        return Unit.a;
    }

    public final void invoke(String str, int i, String str2) {
        Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 0>");
    }
}
