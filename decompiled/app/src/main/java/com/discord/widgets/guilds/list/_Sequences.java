package com.discord.widgets.guilds.list;

import com.discord.stores.StoreGuildsSorted;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: _Sequences.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "", "it", "", "invoke", "(Ljava/lang/Object;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$handleStoreState$$inlined$filterIsInstance$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class _Sequences extends Lambda implements Function1<Object, Boolean> {
    public static final _Sequences INSTANCE = new _Sequences();

    public _Sequences() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2(obj));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Object obj) {
        return obj instanceof StoreGuildsSorted.Entry.SingletonGuild;
    }
}
