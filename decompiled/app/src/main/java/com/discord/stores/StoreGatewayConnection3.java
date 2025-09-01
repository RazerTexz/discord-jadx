package com.discord.stores;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreGatewayConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "gatewayUrl", "invoke", "(Ljava/lang/String;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGatewayConnection3 extends Lambda implements Function1<String, String> {
    public static final StoreGatewayConnection3 INSTANCE = new StoreGatewayConnection3();

    public StoreGatewayConnection3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String str) {
        return invoke2(str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "gatewayUrl");
        return outline.w("ws://:", Strings4.substringAfterLast$default(str, MentionUtils.EMOJIS_AND_STICKERS_CHAR, null, 2, null));
    }
}
