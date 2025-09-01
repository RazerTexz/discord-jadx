package com.discord.models.commands;

import b.d.b.a.outline;
import com.discord.stores.StoreApplicationInteractions;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ActionComponentStoreState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/discord/models/commands/ActionComponentStoreState;", "Lcom/discord/models/commands/ComponentState;", "", "component1", "()Z", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState$Failed;", "component2", "()Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState$Failed;", "component3", "loading", "failed", "disabled", "copy", "(ZLcom/discord/stores/StoreApplicationInteractions$InteractionSendState$Failed;Z)Lcom/discord/models/commands/ActionComponentStoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getDisabled", "getLoading", "Lcom/discord/stores/StoreApplicationInteractions$InteractionSendState$Failed;", "getFailed", "<init>", "(ZLcom/discord/stores/StoreApplicationInteractions$InteractionSendState$Failed;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ActionComponentStoreState extends ActionComponentStoreState2 {
    private final boolean disabled;
    private final StoreApplicationInteractions.InteractionSendState.Failed failed;
    private final boolean loading;

    public ActionComponentStoreState(boolean z2, StoreApplicationInteractions.InteractionSendState.Failed failed, boolean z3) {
        super(null);
        this.loading = z2;
        this.failed = failed;
        this.disabled = z3;
    }

    public static /* synthetic */ ActionComponentStoreState copy$default(ActionComponentStoreState actionComponentStoreState, boolean z2, StoreApplicationInteractions.InteractionSendState.Failed failed, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = actionComponentStoreState.loading;
        }
        if ((i & 2) != 0) {
            failed = actionComponentStoreState.failed;
        }
        if ((i & 4) != 0) {
            z3 = actionComponentStoreState.disabled;
        }
        return actionComponentStoreState.copy(z2, failed, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLoading() {
        return this.loading;
    }

    /* renamed from: component2, reason: from getter */
    public final StoreApplicationInteractions.InteractionSendState.Failed getFailed() {
        return this.failed;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    public final ActionComponentStoreState copy(boolean loading, StoreApplicationInteractions.InteractionSendState.Failed failed, boolean disabled) {
        return new ActionComponentStoreState(loading, failed, disabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionComponentStoreState)) {
            return false;
        }
        ActionComponentStoreState actionComponentStoreState = (ActionComponentStoreState) other;
        return this.loading == actionComponentStoreState.loading && Intrinsics3.areEqual(this.failed, actionComponentStoreState.failed) && this.disabled == actionComponentStoreState.disabled;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final StoreApplicationInteractions.InteractionSendState.Failed getFailed() {
        return this.failed;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z2 = this.loading;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        StoreApplicationInteractions.InteractionSendState.Failed failed = this.failed;
        int iHashCode = (i + (failed != null ? failed.hashCode() : 0)) * 31;
        boolean z3 = this.disabled;
        return iHashCode + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActionComponentStoreState(loading=");
        sbU.append(this.loading);
        sbU.append(", failed=");
        sbU.append(this.failed);
        sbU.append(", disabled=");
        return outline.O(sbU, this.disabled, ")");
    }
}
