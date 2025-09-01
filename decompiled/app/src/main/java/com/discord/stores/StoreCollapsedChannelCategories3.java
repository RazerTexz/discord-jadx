package com.discord.stores;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreCollapsedChannelCategories.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreCollapsedChannelCategories$Companion$fromCache$1$guildChannelIdsCollapsed$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories3 extends Lambda implements Function1<String, Long> {
    public static final StoreCollapsedChannelCategories3 INSTANCE = new StoreCollapsedChannelCategories3();

    public StoreCollapsedChannelCategories3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(String str) {
        return Long.valueOf(invoke2(str));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        return Long.parseLong(str);
    }
}
