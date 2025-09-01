package com.discord.widgets.hubs;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubDescriptionViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJB\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u0007R\u0015\u0010'\u001a\u0004\u0018\u00010$8F@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/discord/widgets/hubs/HubDescriptionState;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Ljava/lang/Integer;", "", "component3", "()Ljava/lang/String;", "Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/directory/DirectoryEntryGuild;", "component4", "()Lcom/discord/stores/utilities/RestCallState;", "channel", "primaryCategoryId", "guildName", "addServerAsync", "copy", "(Lcom/discord/api/channel/Channel;Ljava/lang/Integer;Ljava/lang/String;Lcom/discord/stores/utilities/RestCallState;)Lcom/discord/widgets/hubs/HubDescriptionState;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Ljava/lang/String;", "getGuildName", "Lcom/discord/stores/utilities/RestCallState;", "getAddServerAsync", "Ljava/lang/Integer;", "getPrimaryCategoryId", "Lcom/discord/models/hubs/DirectoryEntryCategory;", "getSelectedCategory", "()Lcom/discord/models/hubs/DirectoryEntryCategory;", "selectedCategory", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/lang/Integer;Ljava/lang/String;Lcom/discord/stores/utilities/RestCallState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.HubDescriptionState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubDescriptionViewModel3 {
    private final RestCallState<DirectoryEntryGuild> addServerAsync;
    private final Channel channel;
    private final String guildName;
    private final Integer primaryCategoryId;

    public WidgetHubDescriptionViewModel3() {
        this(null, null, null, null, 15, null);
    }

    public WidgetHubDescriptionViewModel3(Channel channel, Integer num, String str, RestCallState<DirectoryEntryGuild> restCallState) {
        Intrinsics3.checkNotNullParameter(str, "guildName");
        Intrinsics3.checkNotNullParameter(restCallState, "addServerAsync");
        this.channel = channel;
        this.primaryCategoryId = num;
        this.guildName = str;
        this.addServerAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubDescriptionViewModel3 copy$default(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3, Channel channel, Integer num, String str, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetHubDescriptionViewModel3.channel;
        }
        if ((i & 2) != 0) {
            num = widgetHubDescriptionViewModel3.primaryCategoryId;
        }
        if ((i & 4) != 0) {
            str = widgetHubDescriptionViewModel3.guildName;
        }
        if ((i & 8) != 0) {
            restCallState = widgetHubDescriptionViewModel3.addServerAsync;
        }
        return widgetHubDescriptionViewModel3.copy(channel, num, str, restCallState);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public final RestCallState<DirectoryEntryGuild> component4() {
        return this.addServerAsync;
    }

    public final WidgetHubDescriptionViewModel3 copy(Channel channel, Integer primaryCategoryId, String guildName, RestCallState<DirectoryEntryGuild> addServerAsync) {
        Intrinsics3.checkNotNullParameter(guildName, "guildName");
        Intrinsics3.checkNotNullParameter(addServerAsync, "addServerAsync");
        return new WidgetHubDescriptionViewModel3(channel, primaryCategoryId, guildName, addServerAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubDescriptionViewModel3)) {
            return false;
        }
        WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3 = (WidgetHubDescriptionViewModel3) other;
        return Intrinsics3.areEqual(this.channel, widgetHubDescriptionViewModel3.channel) && Intrinsics3.areEqual(this.primaryCategoryId, widgetHubDescriptionViewModel3.primaryCategoryId) && Intrinsics3.areEqual(this.guildName, widgetHubDescriptionViewModel3.guildName) && Intrinsics3.areEqual(this.addServerAsync, widgetHubDescriptionViewModel3.addServerAsync);
    }

    public final RestCallState<DirectoryEntryGuild> getAddServerAsync() {
        return this.addServerAsync;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final Integer getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    public final DirectoryEntryCategory getSelectedCategory() {
        Integer num = this.primaryCategoryId;
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        DirectoryEntryCategory.Companion companion = DirectoryEntryCategory.INSTANCE;
        Channel channel = this.channel;
        return companion.findByKey(iIntValue, channel != null && ChannelUtils.x(channel));
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Integer num = this.primaryCategoryId;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.guildName;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        RestCallState<DirectoryEntryGuild> restCallState = this.addServerAsync;
        return iHashCode3 + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubDescriptionState(channel=");
        sbU.append(this.channel);
        sbU.append(", primaryCategoryId=");
        sbU.append(this.primaryCategoryId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", addServerAsync=");
        sbU.append(this.addServerAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubDescriptionViewModel3(Channel channel, Integer num, String str, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : channel, (i & 2) != 0 ? null : num, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
