package com.discord.stores;

import com.discord.models.message.Message;
import com.discord.stores.StoreMessagesLoader;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreMessagesLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u00052\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "kotlin.jvm.PlatformType", "messages", "", "invoke", "(Ljava/util/List;)V", "com/discord/stores/StoreMessagesLoader$tryLoadMessages$5$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreMessagesLoader2 extends Lambda implements Function1<List<? extends Message>, Unit> {
    public final /* synthetic */ long $channelId$inlined;
    public final /* synthetic */ StoreMessagesLoader.ChannelLoadedState $channelLoadedState$inlined;
    public final /* synthetic */ StoreMessagesLoader.AnonymousClass4 $loadPagedMessages$4$inlined;
    public final /* synthetic */ boolean $shouldRequestNewerMessages;
    public final /* synthetic */ boolean $shouldRequestOlderMessages;
    public final /* synthetic */ StoreMessagesLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader2(boolean z2, boolean z3, StoreMessagesLoader storeMessagesLoader, StoreMessagesLoader.ChannelLoadedState channelLoadedState, long j, StoreMessagesLoader.AnonymousClass4 anonymousClass4) {
        super(1);
        this.$shouldRequestOlderMessages = z2;
        this.$shouldRequestNewerMessages = z3;
        this.this$0 = storeMessagesLoader;
        this.$channelLoadedState$inlined = channelLoadedState;
        this.$channelId$inlined = j;
        this.$loadPagedMessages$4$inlined = anonymousClass4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
        invoke2((List<Message>) list);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Message> list) {
        StoreMessagesLoader.AnonymousClass4 anonymousClass4 = this.$loadPagedMessages$4$inlined;
        long j = this.$channelId$inlined;
        Intrinsics3.checkNotNullExpressionValue(list, "messages");
        anonymousClass4.invoke(j, list, this.$shouldRequestOlderMessages, this.$shouldRequestNewerMessages);
    }
}
