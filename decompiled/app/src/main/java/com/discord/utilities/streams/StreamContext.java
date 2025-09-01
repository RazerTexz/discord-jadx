package com.discord.utilities.streams;

import b.d.b.a.outline;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreamPreviews;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StreamContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001:\u00018BM\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001e\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u0014¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016Jf\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\"\u0010\u0013J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0019\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010\rR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010\u0007R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b.\u0010\nR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b0\u0010\u0013R\u0019\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b2\u0010\u0010R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00103\u001a\u0004\b4\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b\u001f\u0010\u0016R\u0019\u0010\u001e\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b\u001e\u0010\u0016¨\u00069"}, d2 = {"Lcom/discord/utilities/streams/StreamContext;", "", "Lcom/discord/models/domain/ModelApplicationStream;", "component1", "()Lcom/discord/models/domain/ModelApplicationStream;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "component3", "()Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "Lcom/discord/utilities/streams/StreamContext$Joinability;", "component4", "()Lcom/discord/utilities/streams/StreamContext$Joinability;", "Lcom/discord/models/user/User;", "component5", "()Lcom/discord/models/user/User;", "", "component6", "()Ljava/lang/String;", "", "component7", "()Z", "component8", "stream", "guild", "preview", "joinability", "user", "userNickname", "isCurrentUserParticipating", "isSelfStream", "copy", "(Lcom/discord/models/domain/ModelApplicationStream;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;Lcom/discord/utilities/streams/StreamContext$Joinability;Lcom/discord/models/user/User;Ljava/lang/String;ZZ)Lcom/discord/utilities/streams/StreamContext;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/streams/StreamContext$Joinability;", "getJoinability", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "getPreview", "Ljava/lang/String;", "getUserNickname", "Lcom/discord/models/user/User;", "getUser", "Lcom/discord/models/domain/ModelApplicationStream;", "getStream", "Z", "<init>", "(Lcom/discord/models/domain/ModelApplicationStream;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;Lcom/discord/utilities/streams/StreamContext$Joinability;Lcom/discord/models/user/User;Ljava/lang/String;ZZ)V", "Joinability", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class StreamContext {
    private final Guild guild;
    private final boolean isCurrentUserParticipating;
    private final boolean isSelfStream;
    private final Joinability joinability;
    private final StoreApplicationStreamPreviews.StreamPreview preview;
    private final ModelApplicationStream stream;
    private final User user;
    private final String userNickname;

    /* compiled from: StreamContext.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/streams/StreamContext$Joinability;", "", "<init>", "(Ljava/lang/String;I)V", "CAN_CONNECT", "VOICE_CHANNEL_FULL", "MISSING_PERMISSIONS", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum Joinability {
        CAN_CONNECT,
        VOICE_CHANNEL_FULL,
        MISSING_PERMISSIONS
    }

    public StreamContext(ModelApplicationStream modelApplicationStream, Guild guild, StoreApplicationStreamPreviews.StreamPreview streamPreview, Joinability joinability, User user, String str, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(modelApplicationStream, "stream");
        Intrinsics3.checkNotNullParameter(joinability, "joinability");
        Intrinsics3.checkNotNullParameter(user, "user");
        this.stream = modelApplicationStream;
        this.guild = guild;
        this.preview = streamPreview;
        this.joinability = joinability;
        this.user = user;
        this.userNickname = str;
        this.isCurrentUserParticipating = z2;
        this.isSelfStream = z3;
    }

    public static /* synthetic */ StreamContext copy$default(StreamContext streamContext, ModelApplicationStream modelApplicationStream, Guild guild, StoreApplicationStreamPreviews.StreamPreview streamPreview, Joinability joinability, User user, String str, boolean z2, boolean z3, int i, Object obj) {
        return streamContext.copy((i & 1) != 0 ? streamContext.stream : modelApplicationStream, (i & 2) != 0 ? streamContext.guild : guild, (i & 4) != 0 ? streamContext.preview : streamPreview, (i & 8) != 0 ? streamContext.joinability : joinability, (i & 16) != 0 ? streamContext.user : user, (i & 32) != 0 ? streamContext.userNickname : str, (i & 64) != 0 ? streamContext.isCurrentUserParticipating : z2, (i & 128) != 0 ? streamContext.isSelfStream : z3);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelApplicationStream getStream() {
        return this.stream;
    }

    /* renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: component3, reason: from getter */
    public final StoreApplicationStreamPreviews.StreamPreview getPreview() {
        return this.preview;
    }

    /* renamed from: component4, reason: from getter */
    public final Joinability getJoinability() {
        return this.joinability;
    }

    /* renamed from: component5, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUserNickname() {
        return this.userNickname;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsCurrentUserParticipating() {
        return this.isCurrentUserParticipating;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsSelfStream() {
        return this.isSelfStream;
    }

    public final StreamContext copy(ModelApplicationStream stream, Guild guild, StoreApplicationStreamPreviews.StreamPreview preview, Joinability joinability, User user, String userNickname, boolean isCurrentUserParticipating, boolean isSelfStream) {
        Intrinsics3.checkNotNullParameter(stream, "stream");
        Intrinsics3.checkNotNullParameter(joinability, "joinability");
        Intrinsics3.checkNotNullParameter(user, "user");
        return new StreamContext(stream, guild, preview, joinability, user, userNickname, isCurrentUserParticipating, isSelfStream);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamContext)) {
            return false;
        }
        StreamContext streamContext = (StreamContext) other;
        return Intrinsics3.areEqual(this.stream, streamContext.stream) && Intrinsics3.areEqual(this.guild, streamContext.guild) && Intrinsics3.areEqual(this.preview, streamContext.preview) && Intrinsics3.areEqual(this.joinability, streamContext.joinability) && Intrinsics3.areEqual(this.user, streamContext.user) && Intrinsics3.areEqual(this.userNickname, streamContext.userNickname) && this.isCurrentUserParticipating == streamContext.isCurrentUserParticipating && this.isSelfStream == streamContext.isSelfStream;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Joinability getJoinability() {
        return this.joinability;
    }

    public final StoreApplicationStreamPreviews.StreamPreview getPreview() {
        return this.preview;
    }

    public final ModelApplicationStream getStream() {
        return this.stream;
    }

    public final User getUser() {
        return this.user;
    }

    public final String getUserNickname() {
        return this.userNickname;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ModelApplicationStream modelApplicationStream = this.stream;
        int iHashCode = (modelApplicationStream != null ? modelApplicationStream.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        StoreApplicationStreamPreviews.StreamPreview streamPreview = this.preview;
        int iHashCode3 = (iHashCode2 + (streamPreview != null ? streamPreview.hashCode() : 0)) * 31;
        Joinability joinability = this.joinability;
        int iHashCode4 = (iHashCode3 + (joinability != null ? joinability.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode5 = (iHashCode4 + (user != null ? user.hashCode() : 0)) * 31;
        String str = this.userNickname;
        int iHashCode6 = (iHashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isCurrentUserParticipating;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode6 + i) * 31;
        boolean z3 = this.isSelfStream;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final boolean isCurrentUserParticipating() {
        return this.isCurrentUserParticipating;
    }

    public final boolean isSelfStream() {
        return this.isSelfStream;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StreamContext(stream=");
        sbU.append(this.stream);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", preview=");
        sbU.append(this.preview);
        sbU.append(", joinability=");
        sbU.append(this.joinability);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", userNickname=");
        sbU.append(this.userNickname);
        sbU.append(", isCurrentUserParticipating=");
        sbU.append(this.isCurrentUserParticipating);
        sbU.append(", isSelfStream=");
        return outline.O(sbU, this.isSelfStream, ")");
    }
}
