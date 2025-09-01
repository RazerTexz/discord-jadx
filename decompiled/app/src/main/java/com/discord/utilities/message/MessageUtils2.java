package com.discord.utilities.message;

import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: MessageUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "messageId1", "messageId2", "", "compare", "(Ljava/lang/Long;Ljava/lang/Long;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.message.MessageUtils$SORT_BY_IDS_COMPARATOR$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MessageUtils2<T> implements Comparator<Long> {
    public static final MessageUtils2 INSTANCE = new MessageUtils2();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Long l, Long l2) {
        return compare2(l, l2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(Long l, Long l2) {
        return MessageUtils.compareMessages(l, l2);
    }
}
