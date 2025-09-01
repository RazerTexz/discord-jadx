package com.discord.widgets.hubs;

import com.discord.stores.StoreNux;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubAuthentication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "it", "invoke", "(Lcom/discord/stores/StoreNux$NuxState;)Lcom/discord/stores/StoreNux$NuxState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$1$1$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAuthentication3 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
    public static final WidgetHubAuthentication3 INSTANCE = new WidgetHubAuthentication3();

    public WidgetHubAuthentication3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
        return invoke2(nuxState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
        Intrinsics3.checkNotNullParameter(nuxState, "it");
        return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 62, null);
    }
}
