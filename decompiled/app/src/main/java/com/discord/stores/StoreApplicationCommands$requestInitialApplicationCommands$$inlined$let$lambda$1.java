package com.discord.stores;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: StoreApplicationCommands.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()V", "com/discord/stores/StoreApplicationCommands$requestInitialApplicationCommands$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreApplicationCommands$requestInitialApplicationCommands$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Ref$IntRef $offset$inlined;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$requestInitialApplicationCommands$$inlined$let$lambda$1(StoreApplicationCommands storeApplicationCommands, Ref$IntRef ref$IntRef) {
        super(0);
        this.this$0 = storeApplicationCommands;
        this.$offset$inlined = ref$IntRef;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationCommands storeApplicationCommands = this.this$0;
        StoreApplicationCommands.access$handleDiscoverCommandsUpdate(storeApplicationCommands, StoreApplicationCommands.access$getBuiltInCommandsProvider$p(storeApplicationCommands).getBuiltInCommands());
    }
}
