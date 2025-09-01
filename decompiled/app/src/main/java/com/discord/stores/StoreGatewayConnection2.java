package com.discord.stores;

import com.discord.stores.StoreClientDataState;
import com.discord.stores.StoreGatewayConnection;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;

/* compiled from: StoreGatewayConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "p1", "", "p2", "", "Lcom/discord/primitives/ChannelId;", "p3", "p4", "Lcom/discord/stores/StoreClientDataState$ClientDataState;", "p5", "Lcom/discord/stores/StoreGatewayConnection$ClientState;", "invoke", "(ZLjava/lang/String;JZLcom/discord/stores/StoreClientDataState$ClientDataState;)Lcom/discord/stores/StoreGatewayConnection$ClientState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGatewayConnection$ClientState$Companion$initialize$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreGatewayConnection2 extends FunctionReferenceImpl implements Function5<Boolean, String, Long, Boolean, StoreClientDataState.ClientDataState, StoreGatewayConnection.ClientState> {
    public StoreGatewayConnection2(StoreGatewayConnection.ClientState.Companion companion) {
        super(5, companion, StoreGatewayConnection.ClientState.Companion.class, "create", "create(ZLjava/lang/String;JZLcom/discord/stores/StoreClientDataState$ClientDataState;)Lcom/discord/stores/StoreGatewayConnection$ClientState;", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ StoreGatewayConnection.ClientState invoke(Boolean bool, String str, Long l, Boolean bool2, StoreClientDataState.ClientDataState clientDataState) {
        return invoke(bool.booleanValue(), str, l.longValue(), bool2.booleanValue(), clientDataState);
    }

    public final StoreGatewayConnection.ClientState invoke(boolean z2, String str, long j, boolean z3, StoreClientDataState.ClientDataState clientDataState) {
        Intrinsics3.checkNotNullParameter(clientDataState, "p5");
        return StoreGatewayConnection.ClientState.Companion.access$create((StoreGatewayConnection.ClientState.Companion) this.receiver, z2, str, j, z3, clientDataState);
    }
}
