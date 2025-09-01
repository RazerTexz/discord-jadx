package com.discord.stores;

import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreCollapsedChannelCategories.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "value", "", "invoke", "(Ljava/util/Set;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreCollapsedChannelCategories$Companion$toCache$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories4 extends Lambda implements Function1<Set<Long>, String> {
    public static final StoreCollapsedChannelCategories4 INSTANCE = new StoreCollapsedChannelCategories4();

    public StoreCollapsedChannelCategories4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Set<Long> set) {
        return invoke2(set);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Set<Long> set) {
        Intrinsics3.checkNotNullParameter(set, "value");
        return _Collections.joinToString$default(set, ",", null, null, 0, null, null, 62, null);
    }
}
