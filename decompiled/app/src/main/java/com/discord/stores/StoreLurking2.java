package com.discord.stores;

import com.discord.stores.StoreLurking;
import com.discord.utilities.channel.ChannelSelector;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: StoreLurking.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreLurking$startLurkingAndNavigate$1$1$jumpToDestination$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreLurking2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ StoreLurking.AnonymousClass1.C01461 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLurking2(StoreLurking.AnonymousClass1.C01461 c01461, Long l) {
        super(0);
        this.this$0 = c01461;
        this.$channelId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Long l;
        Long l2 = this.$channelId;
        if (l2 == null || ((l2 != null && l2.longValue() == 0) || ((l = this.$channelId) != null && l.longValue() == -1))) {
            StoreLurking.access$getStream$p(StoreLurking.this).getGuildSelected().set(StoreLurking.AnonymousClass1.this.$guildId);
        } else {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), StoreLurking.AnonymousClass1.this.$guildId, this.$channelId.longValue(), null, null, 12, null);
        }
    }
}
