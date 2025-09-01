package com.discord.stores;

import d0.Tuples;
import d0.f0._Sequences2;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreCollapsedChannelCategories.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u001c\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u00070\u00060\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "key", "value", "Lkotlin/Pair;", "", "Lcom/discord/primitives/GuildId;", "", "Lcom/discord/primitives/ChannelId;", "invoke", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreCollapsedChannelCategories$Companion$fromCache$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories2 extends Lambda implements Function2<String, String, Tuples2<? extends Long, ? extends Set<Long>>> {
    public static final StoreCollapsedChannelCategories2 INSTANCE = new StoreCollapsedChannelCategories2();

    public StoreCollapsedChannelCategories2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Tuples2<? extends Long, ? extends Set<Long>> invoke(String str, String str2) {
        return invoke2(str, str2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Tuples2<Long, Set<Long>> invoke2(String str, String str2) throws NumberFormatException {
        Intrinsics3.checkNotNullParameter(str, "key");
        Intrinsics3.checkNotNullParameter(str2, "value");
        long j = Long.parseLong(str);
        return Tuples.to(Long.valueOf(j), _Sequences2.toHashSet(_Sequences2.map(Strings4.splitToSequence$default(str2, new String[]{","}, false, 0, 6, null), StoreCollapsedChannelCategories3.INSTANCE)));
    }
}
