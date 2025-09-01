package com.discord.widgets.hubs;

import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubAddNameViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R!\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000b¨\u0006!"}, d2 = {"Lcom/discord/widgets/hubs/AddNameState;", "", "", "component1", "()Ljava/lang/String;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/stores/utilities/RestCallState;", "Ljava/lang/Void;", "component3", "()Lcom/discord/stores/utilities/RestCallState;", "nickname", "guild", "changeNicknameAsync", "copy", "(Ljava/lang/String;Lcom/discord/models/guild/Guild;Lcom/discord/stores/utilities/RestCallState;)Lcom/discord/widgets/hubs/AddNameState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getNickname", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/stores/utilities/RestCallState;", "getChangeNicknameAsync", "<init>", "(Ljava/lang/String;Lcom/discord/models/guild/Guild;Lcom/discord/stores/utilities/RestCallState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.AddNameState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubAddNameViewModel2 {
    private final RestCallState<Void> changeNicknameAsync;
    private final Guild guild;
    private final String nickname;

    public WidgetHubAddNameViewModel2() {
        this(null, null, null, 7, null);
    }

    public WidgetHubAddNameViewModel2(String str, Guild guild, RestCallState<Void> restCallState) {
        Intrinsics3.checkNotNullParameter(str, "nickname");
        Intrinsics3.checkNotNullParameter(restCallState, "changeNicknameAsync");
        this.nickname = str;
        this.guild = guild;
        this.changeNicknameAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubAddNameViewModel2 copy$default(WidgetHubAddNameViewModel2 widgetHubAddNameViewModel2, String str, Guild guild, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubAddNameViewModel2.nickname;
        }
        if ((i & 2) != 0) {
            guild = widgetHubAddNameViewModel2.guild;
        }
        if ((i & 4) != 0) {
            restCallState = widgetHubAddNameViewModel2.changeNicknameAsync;
        }
        return widgetHubAddNameViewModel2.copy(str, guild, restCallState);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final RestCallState<Void> component3() {
        return this.changeNicknameAsync;
    }

    public final WidgetHubAddNameViewModel2 copy(String nickname, Guild guild, RestCallState<Void> changeNicknameAsync) {
        Intrinsics3.checkNotNullParameter(nickname, "nickname");
        Intrinsics3.checkNotNullParameter(changeNicknameAsync, "changeNicknameAsync");
        return new WidgetHubAddNameViewModel2(nickname, guild, changeNicknameAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubAddNameViewModel2)) {
            return false;
        }
        WidgetHubAddNameViewModel2 widgetHubAddNameViewModel2 = (WidgetHubAddNameViewModel2) other;
        return Intrinsics3.areEqual(this.nickname, widgetHubAddNameViewModel2.nickname) && Intrinsics3.areEqual(this.guild, widgetHubAddNameViewModel2.guild) && Intrinsics3.areEqual(this.changeNicknameAsync, widgetHubAddNameViewModel2.changeNicknameAsync);
    }

    public final RestCallState<Void> getChangeNicknameAsync() {
        return this.changeNicknameAsync;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public int hashCode() {
        String str = this.nickname;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        RestCallState<Void> restCallState = this.changeNicknameAsync;
        return iHashCode2 + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AddNameState(nickname=");
        sbU.append(this.nickname);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", changeNicknameAsync=");
        sbU.append(this.changeNicknameAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubAddNameViewModel2(String str, Guild guild, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : guild, (i & 4) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
