package com.discord.utilities;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function1;

/* compiled from: ShareUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/utilities/ChannelShortcutInfo;", "", "<name for destructuring parameter 0>", "invoke", "(Lkotlin/Pair;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ShareUtils$updateDirectShareTargets$1$uris$1 extends Lambda implements Function1<Tuples2<? extends ChannelShortcutInfo, ? extends String>, String> {
    public static final ShareUtils$updateDirectShareTargets$1$uris$1 INSTANCE = new ShareUtils$updateDirectShareTargets$1$uris$1();

    public ShareUtils$updateDirectShareTargets$1$uris$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Tuples2<? extends ChannelShortcutInfo, ? extends String> tuples2) {
        return invoke2((Tuples2<ChannelShortcutInfo, String>) tuples2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Tuples2<ChannelShortcutInfo, String> tuples2) {
        Intrinsics3.checkNotNullParameter(tuples2, "<name for destructuring parameter 0>");
        return tuples2.component2();
    }
}
