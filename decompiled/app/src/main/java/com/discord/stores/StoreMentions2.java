package com.discord.stores;

import com.discord.models.domain.ModelReadState;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreMentions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelReadState;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelReadState;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreMentions$processMarkUnread$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreMentions2 extends Lambda implements Function1<ModelReadState, Boolean> {
    public final /* synthetic */ long $channelId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMentions2(long j) {
        super(1);
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
        return Boolean.valueOf(invoke2(modelReadState));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(ModelReadState modelReadState) {
        Intrinsics3.checkNotNullParameter(modelReadState, "it");
        return modelReadState.getChannelId() == this.$channelId;
    }
}
