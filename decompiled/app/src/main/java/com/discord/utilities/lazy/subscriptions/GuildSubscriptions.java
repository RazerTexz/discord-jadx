package com.discord.utilities.lazy.subscriptions;

import b.d.b.a.outline;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* compiled from: GuildSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001By\u0012 \b\u0002\u0010\u0014\u001a\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u0005¢\u0006\u0004\b3\u00104J(\u0010\u0007\u001a\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u001c\u0010\u000f\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u000e\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000bJ\u001c\u0010\u0012\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0082\u0001\u0010\u001a\u001a\u00020\u00002 \b\u0002\u0010\u0014\u001a\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u000e\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R;\u0010(\u001a \u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00050\u0005\u0018\u00010\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\bR%\u0010\u0017\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u000e\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b*\u0010\u0010R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\u000bR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b-\u0010\u000bR1\u0010\u0014\u001a\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010.\u001a\u0004\b/\u0010\bR%\u0010\u0019\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\u0013R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b2\u0010\u000b¨\u00065"}, d2 = {"Lcom/discord/utilities/lazy/subscriptions/GuildSubscriptions;", "", "", "", "Lcom/discord/primitives/ChannelId;", "", "Lkotlin/ranges/IntRange;", "component1", "()Ljava/util/Map;", "", "component2", "()Ljava/lang/Boolean;", "component3", "", "Lcom/discord/primitives/UserId;", "component4", "()Ljava/util/Set;", "component5", "component6", "()Ljava/util/List;", "channels", "typing", "activities", "members", "threads", "threadMemberLists", "copy", "(Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Set;Ljava/lang/Boolean;Ljava/util/List;)Lcom/discord/utilities/lazy/subscriptions/GuildSubscriptions;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "serializedRanges$delegate", "Lkotlin/Lazy;", "getSerializedRanges", "serializedRanges", "Ljava/util/Set;", "getMembers", "Ljava/lang/Boolean;", "getThreads", "getTyping", "Ljava/util/Map;", "getChannels", "Ljava/util/List;", "getThreadMemberLists", "getActivities", "<init>", "(Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Set;Ljava/lang/Boolean;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GuildSubscriptions {
    private final Boolean activities;
    private final Map<Long, List<Ranges2>> channels;
    private final Set<Long> members;

    /* renamed from: serializedRanges$delegate, reason: from kotlin metadata */
    private final Lazy serializedRanges;
    private final List<Long> threadMemberLists;
    private final Boolean threads;
    private final Boolean typing;

    public GuildSubscriptions() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildSubscriptions(Map<Long, ? extends List<Ranges2>> map, Boolean bool, Boolean bool2, Set<Long> set, Boolean bool3, List<Long> list) {
        this.channels = map;
        this.typing = bool;
        this.activities = bool2;
        this.members = set;
        this.threads = bool3;
        this.threadMemberLists = list;
        this.serializedRanges = LazyJVM.lazy(new GuildSubscriptions2(this));
    }

    public static /* synthetic */ GuildSubscriptions copy$default(GuildSubscriptions guildSubscriptions, Map map, Boolean bool, Boolean bool2, Set set, Boolean bool3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            map = guildSubscriptions.channels;
        }
        if ((i & 2) != 0) {
            bool = guildSubscriptions.typing;
        }
        Boolean bool4 = bool;
        if ((i & 4) != 0) {
            bool2 = guildSubscriptions.activities;
        }
        Boolean bool5 = bool2;
        if ((i & 8) != 0) {
            set = guildSubscriptions.members;
        }
        Set set2 = set;
        if ((i & 16) != 0) {
            bool3 = guildSubscriptions.threads;
        }
        Boolean bool6 = bool3;
        if ((i & 32) != 0) {
            list = guildSubscriptions.threadMemberLists;
        }
        return guildSubscriptions.copy(map, bool4, bool5, set2, bool6, list);
    }

    public final Map<Long, List<Ranges2>> component1() {
        return this.channels;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getTyping() {
        return this.typing;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getActivities() {
        return this.activities;
    }

    public final Set<Long> component4() {
        return this.members;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getThreads() {
        return this.threads;
    }

    public final List<Long> component6() {
        return this.threadMemberLists;
    }

    public final GuildSubscriptions copy(Map<Long, ? extends List<Ranges2>> channels, Boolean typing, Boolean activities, Set<Long> members, Boolean threads, List<Long> threadMemberLists) {
        return new GuildSubscriptions(channels, typing, activities, members, threads, threadMemberLists);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildSubscriptions)) {
            return false;
        }
        GuildSubscriptions guildSubscriptions = (GuildSubscriptions) other;
        return Intrinsics3.areEqual(this.channels, guildSubscriptions.channels) && Intrinsics3.areEqual(this.typing, guildSubscriptions.typing) && Intrinsics3.areEqual(this.activities, guildSubscriptions.activities) && Intrinsics3.areEqual(this.members, guildSubscriptions.members) && Intrinsics3.areEqual(this.threads, guildSubscriptions.threads) && Intrinsics3.areEqual(this.threadMemberLists, guildSubscriptions.threadMemberLists);
    }

    public final Boolean getActivities() {
        return this.activities;
    }

    public final Map<Long, List<Ranges2>> getChannels() {
        return this.channels;
    }

    public final Set<Long> getMembers() {
        return this.members;
    }

    public final Map<Long, List<List<Integer>>> getSerializedRanges() {
        return (Map) this.serializedRanges.getValue();
    }

    public final List<Long> getThreadMemberLists() {
        return this.threadMemberLists;
    }

    public final Boolean getThreads() {
        return this.threads;
    }

    public final Boolean getTyping() {
        return this.typing;
    }

    public int hashCode() {
        Map<Long, List<Ranges2>> map = this.channels;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Boolean bool = this.typing;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.activities;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Set<Long> set = this.members;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        Boolean bool3 = this.threads;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        List<Long> list = this.threadMemberLists;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildSubscriptions(channels=");
        sbU.append(this.channels);
        sbU.append(", typing=");
        sbU.append(this.typing);
        sbU.append(", activities=");
        sbU.append(this.activities);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", threads=");
        sbU.append(this.threads);
        sbU.append(", threadMemberLists=");
        return outline.L(sbU, this.threadMemberLists, ")");
    }

    public /* synthetic */ GuildSubscriptions(Map map, Boolean bool, Boolean bool2, Set set, Boolean bool3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : set, (i & 16) != 0 ? null : bool3, (i & 32) != 0 ? null : list);
    }
}
