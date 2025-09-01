package com.discord.stores;

import com.discord.models.commands.ApplicationCommandLocalSendData;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: StoreApplicationInteractions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()V", "com/discord/stores/StoreApplicationInteractions$fetchInteractionDataIfNonExisting$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreApplicationInteractions2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ long $interactionId$inlined;
    public final /* synthetic */ ApplicationCommandLocalSendData $it;
    public final /* synthetic */ StoreApplicationInteractions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions2(ApplicationCommandLocalSendData applicationCommandLocalSendData, StoreApplicationInteractions storeApplicationInteractions, long j) {
        super(0);
        this.$it = applicationCommandLocalSendData;
        this.this$0 = storeApplicationInteractions;
        this.$interactionId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationInteractions.access$handleInteractionDataFetchSuccess(this.this$0, this.$interactionId$inlined, this.$it.toRestApiApplicationCommandDataParam());
    }
}
