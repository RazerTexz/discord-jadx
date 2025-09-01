package com.discord.models.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelRemoteAuthHandshake.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/discord/models/domain/ModelRemoteAuthHandshake;", "", "", "component1", "()Ljava/lang/String;", "handshakeToken", "copy", "(Ljava/lang/String;)Lcom/discord/models/domain/ModelRemoteAuthHandshake;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getHandshakeToken", "<init>", "(Ljava/lang/String;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelRemoteAuthHandshake {
    private final String handshakeToken;

    public ModelRemoteAuthHandshake(String str) {
        Intrinsics3.checkNotNullParameter(str, "handshakeToken");
        this.handshakeToken = str;
    }

    public static /* synthetic */ ModelRemoteAuthHandshake copy$default(ModelRemoteAuthHandshake modelRemoteAuthHandshake, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelRemoteAuthHandshake.handshakeToken;
        }
        return modelRemoteAuthHandshake.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHandshakeToken() {
        return this.handshakeToken;
    }

    public final ModelRemoteAuthHandshake copy(String handshakeToken) {
        Intrinsics3.checkNotNullParameter(handshakeToken, "handshakeToken");
        return new ModelRemoteAuthHandshake(handshakeToken);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelRemoteAuthHandshake) && Intrinsics3.areEqual(this.handshakeToken, ((ModelRemoteAuthHandshake) other).handshakeToken);
        }
        return true;
    }

    public final String getHandshakeToken() {
        return this.handshakeToken;
    }

    public int hashCode() {
        String str = this.handshakeToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.J(outline.U("ModelRemoteAuthHandshake(handshakeToken="), this.handshakeToken, ")");
    }
}
