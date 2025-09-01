package com.discord.models.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelTypingResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/discord/models/domain/ModelTypingResponse;", "", "", "component1", "()Ljava/lang/Long;", "component2", "messageSendCooldownMs", "threadCreateCooldownMs", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/discord/models/domain/ModelTypingResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getMessageSendCooldownMs", "getThreadCreateCooldownMs", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelTypingResponse {
    private final Long messageSendCooldownMs;
    private final Long threadCreateCooldownMs;

    public ModelTypingResponse(Long l, Long l2) {
        this.messageSendCooldownMs = l;
        this.threadCreateCooldownMs = l2;
    }

    public static /* synthetic */ ModelTypingResponse copy$default(ModelTypingResponse modelTypingResponse, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = modelTypingResponse.messageSendCooldownMs;
        }
        if ((i & 2) != 0) {
            l2 = modelTypingResponse.threadCreateCooldownMs;
        }
        return modelTypingResponse.copy(l, l2);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getMessageSendCooldownMs() {
        return this.messageSendCooldownMs;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getThreadCreateCooldownMs() {
        return this.threadCreateCooldownMs;
    }

    public final ModelTypingResponse copy(Long messageSendCooldownMs, Long threadCreateCooldownMs) {
        return new ModelTypingResponse(messageSendCooldownMs, threadCreateCooldownMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelTypingResponse)) {
            return false;
        }
        ModelTypingResponse modelTypingResponse = (ModelTypingResponse) other;
        return Intrinsics3.areEqual(this.messageSendCooldownMs, modelTypingResponse.messageSendCooldownMs) && Intrinsics3.areEqual(this.threadCreateCooldownMs, modelTypingResponse.threadCreateCooldownMs);
    }

    public final Long getMessageSendCooldownMs() {
        return this.messageSendCooldownMs;
    }

    public final Long getThreadCreateCooldownMs() {
        return this.threadCreateCooldownMs;
    }

    public int hashCode() {
        Long l = this.messageSendCooldownMs;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.threadCreateCooldownMs;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelTypingResponse(messageSendCooldownMs=");
        sbU.append(this.messageSendCooldownMs);
        sbU.append(", threadCreateCooldownMs=");
        return outline.G(sbU, this.threadCreateCooldownMs, ")");
    }
}
