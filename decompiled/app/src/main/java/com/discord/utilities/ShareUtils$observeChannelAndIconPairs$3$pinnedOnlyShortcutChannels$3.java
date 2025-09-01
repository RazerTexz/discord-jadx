package com.discord.utilities;

import d0.z.d.Lambda;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ShareUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "channelId", "", "invoke", "(J)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$3 extends Lambda implements Function1<Long, Boolean> {
    public final /* synthetic */ Set $directShareChannelIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$3(Set set) {
        super(1);
        this.$directShareChannelIds = set;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return Boolean.valueOf(invoke(l.longValue()));
    }

    public final boolean invoke(long j) {
        return !this.$directShareChannelIds.contains(Long.valueOf(j));
    }
}
