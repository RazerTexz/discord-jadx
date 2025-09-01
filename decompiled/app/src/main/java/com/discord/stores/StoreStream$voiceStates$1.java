package com.discord.stores;

import d0.z.d.FunctionReferenceImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: StoreStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "p1", "Lcom/discord/primitives/ChannelId;", "p2", "Lcom/discord/primitives/UserId;", "p3", "", "invoke", "(JJJ)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$voiceStates$1 extends FunctionReferenceImpl implements Function3<Long, Long, Long, Unit> {
    public StoreStream$voiceStates$1(StoreStream storeStream) {
        super(3, storeStream, StoreStream.class, "handleVoiceStatesUpdated", "handleVoiceStatesUpdated(JJJ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2, Long l3) {
        invoke(l.longValue(), l2.longValue(), l3.longValue());
        return Unit.a;
    }

    public final void invoke(long j, long j2, long j3) {
        ((StoreStream) this.receiver).handleVoiceStatesUpdated(j, j2, j3);
    }
}
