package com.discord.stores;

import com.discord.stores.StoreNotices;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreNotices.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreNotices$Notice;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/stores/StoreNotices$Notice;)Ljava/lang/Comparable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreNotices$noticeQueue$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreNotices5 extends Lambda implements Function1<StoreNotices.Notice, Comparable<?>> {
    public static final StoreNotices5 INSTANCE = new StoreNotices5();

    public StoreNotices5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Comparable<?> invoke(StoreNotices.Notice notice) {
        return invoke2(notice);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Comparable<?> invoke2(StoreNotices.Notice notice) {
        return Integer.valueOf(-notice.getPriority());
    }
}
