package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: StoreGuildsSorted.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u000289B'\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b6\u00107J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0010¢\u0006\u0004\b\u0015\u0010\u0012J1\u0010\u001b\u001a&\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012\u0004\u0012\u00020\u00190\u0016j\u0012\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012\u0004\u0012\u00020\u0019`\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\u001d\u001a,\u0012(\u0012&\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012\u0004\u0012\u00020\u00190\u0016j\u0012\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012\u0004\u0012\u00020\u0019`\u001a0\u0010¢\u0006\u0004\b\u001d\u0010\u0012J\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u000eJ\u001b\u0010#\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b#\u0010\u000bR\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020*0'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010)R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/discord/stores/StoreGuildsSorted;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/stores/StoreGuildsSorted$State;", "state", "", "handleNewState", "(Lcom/discord/stores/StoreGuildsSorted$State;)V", "", "Lcom/discord/stores/StoreGuildsSorted$Entry;", "guildPositions", "handleNewPositionsFromUser", "(Ljava/util/List;)V", "updatePositions", "ensureValidPositions", "()V", "rebuildSortedGuilds", "Lrx/Observable;", "observeStores", "()Lrx/Observable;", "getEntries", "()Ljava/util/List;", "observeEntries", "Ljava/util/LinkedHashMap;", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "Lkotlin/collections/LinkedHashMap;", "getOrderedGuilds", "()Ljava/util/LinkedHashMap;", "observeOrderedGuilds", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "snapshotData", "setPositions", "Lcom/discord/stores/StoreLurking;", "lurkingGuildStore", "Lcom/discord/stores/StoreLurking;", "", "entries", "Ljava/util/List;", "Lcom/discord/models/domain/ModelGuildFolder;", "positions", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "entriesSnapshot", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreLurking;)V", "Entry", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildsSorted extends StoreV2 {
    private final Dispatcher dispatcher;
    private final List<Entry> entries;
    private List<? extends Entry> entriesSnapshot;
    private final StoreGuilds guildStore;
    private final StoreLurking lurkingGuildStore;
    private final ObservationDeck observationDeck;
    private final List<ModelGuildFolder> positions;

    /* compiled from: StoreGuildsSorted.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/discord/stores/StoreGuildsSorted$Entry;", "", "Lcom/discord/models/domain/ModelGuildFolder;", "asModelGuildFolder", "()Lcom/discord/models/domain/ModelGuildFolder;", "<init>", "()V", "Folder", "SingletonGuild", "Lcom/discord/stores/StoreGuildsSorted$Entry$SingletonGuild;", "Lcom/discord/stores/StoreGuildsSorted$Entry$Folder;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Entry {

        /* compiled from: StoreGuildsSorted.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\u0010\u0013\u001a\u00060\u0005j\u0002`\u0006\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JF\u0010\u0017\u001a\u00020\u00002\f\b\u0002\u0010\u0013\u001a\u00060\u0005j\u0002`\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0012J\u0010\u0010\u001a\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\fR\u001d\u0010\u0013\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\bR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010\u000f¨\u0006+"}, d2 = {"Lcom/discord/stores/StoreGuildsSorted$Entry$Folder;", "Lcom/discord/stores/StoreGuildsSorted$Entry;", "Lcom/discord/models/domain/ModelGuildFolder;", "asModelGuildFolder", "()Lcom/discord/models/domain/ModelGuildFolder;", "", "Lcom/discord/primitives/FolderId;", "component1", "()J", "", "Lcom/discord/models/guild/Guild;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/Integer;", "", "component4", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_ID, "guilds", ModelAuditLogEntry.CHANGE_KEY_COLOR, ModelAuditLogEntry.CHANGE_KEY_NAME, "copy", "(JLjava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/discord/stores/StoreGuildsSorted$Entry$Folder;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getGuilds", "J", "getId", "Ljava/lang/String;", "getName", "Ljava/lang/Integer;", "getColor", "<init>", "(JLjava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Folder extends Entry {
            private final Integer color;
            private final List<Guild> guilds;
            private final long id;
            private final String name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Folder(long j, List<Guild> list, Integer num, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "guilds");
                this.id = j;
                this.guilds = list;
                this.color = num;
                this.name = str;
            }

            public static /* synthetic */ Folder copy$default(Folder folder, long j, List list, Integer num, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = folder.id;
                }
                long j2 = j;
                if ((i & 2) != 0) {
                    list = folder.guilds;
                }
                List list2 = list;
                if ((i & 4) != 0) {
                    num = folder.color;
                }
                Integer num2 = num;
                if ((i & 8) != 0) {
                    str = folder.name;
                }
                return folder.copy(j2, list2, num2, str);
            }

            @Override // com.discord.stores.StoreGuildsSorted.Entry
            public ModelGuildFolder asModelGuildFolder() {
                Long lValueOf = Long.valueOf(this.id);
                List<Guild> list = this.guilds;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((Guild) it.next()).getId()));
                }
                return new ModelGuildFolder(lValueOf, arrayList, this.color, this.name);
            }

            /* renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            public final List<Guild> component2() {
                return this.guilds;
            }

            /* renamed from: component3, reason: from getter */
            public final Integer getColor() {
                return this.color;
            }

            /* renamed from: component4, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final Folder copy(long id2, List<Guild> guilds, Integer color, String name) {
                Intrinsics3.checkNotNullParameter(guilds, "guilds");
                return new Folder(id2, guilds, color, name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Folder)) {
                    return false;
                }
                Folder folder = (Folder) other;
                return this.id == folder.id && Intrinsics3.areEqual(this.guilds, folder.guilds) && Intrinsics3.areEqual(this.color, folder.color) && Intrinsics3.areEqual(this.name, folder.name);
            }

            public final Integer getColor() {
                return this.color;
            }

            public final List<Guild> getGuilds() {
                return this.guilds;
            }

            public final long getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }

            public int hashCode() {
                int iA = b.a(this.id) * 31;
                List<Guild> list = this.guilds;
                int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
                Integer num = this.color;
                int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
                String str = this.name;
                return iHashCode2 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Folder(id=");
                sbU.append(this.id);
                sbU.append(", guilds=");
                sbU.append(this.guilds);
                sbU.append(", color=");
                sbU.append(this.color);
                sbU.append(", name=");
                return outline.J(sbU, this.name, ")");
            }
        }

        /* compiled from: StoreGuildsSorted.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/discord/stores/StoreGuildsSorted$Entry$SingletonGuild;", "Lcom/discord/stores/StoreGuildsSorted$Entry;", "Lcom/discord/models/domain/ModelGuildFolder;", "asModelGuildFolder", "()Lcom/discord/models/domain/ModelGuildFolder;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "guild", "copy", "(Lcom/discord/models/guild/Guild;)Lcom/discord/stores/StoreGuildsSorted$Entry$SingletonGuild;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SingletonGuild extends Entry {
            private final Guild guild;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SingletonGuild(Guild guild) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.guild = guild;
            }

            public static /* synthetic */ SingletonGuild copy$default(SingletonGuild singletonGuild, Guild guild, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = singletonGuild.guild;
                }
                return singletonGuild.copy(guild);
            }

            @Override // com.discord.stores.StoreGuildsSorted.Entry
            public ModelGuildFolder asModelGuildFolder() {
                return new ModelGuildFolder(null, CollectionsJVM.listOf(Long.valueOf(this.guild.getId())), null, null, 8, null);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final SingletonGuild copy(Guild guild) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new SingletonGuild(guild);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SingletonGuild) && Intrinsics3.areEqual(this.guild, ((SingletonGuild) other).guild);
                }
                return true;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public int hashCode() {
                Guild guild = this.guild;
                if (guild != null) {
                    return guild.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SingletonGuild(guild=");
                sbU.append(this.guild);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Entry() {
        }

        public abstract ModelGuildFolder asModelGuildFolder();

        public /* synthetic */ Entry(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildsSorted.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\u001a\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0003j\u0002`\b0\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b$\u0010%J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\t\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0003j\u0002`\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJR\u0010\u0012\u001a\u00020\u00002\u0012\b\u0002\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0003j\u0002`\b0\u00072\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR-\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0003j\u0002`\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\u000eR#\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0006¨\u0006&"}, d2 = {"Lcom/discord/stores/StoreGuildsSorted$State;", "", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()Ljava/util/Set;", "", "Lcom/discord/primitives/Timestamp;", "component2", "()Ljava/util/Map;", "", "Lcom/discord/models/domain/ModelGuildFolder;", "component3", "()Ljava/util/List;", "mutedGuilds", "joinedAt", "userSettingsGuildPositions", "copy", "(Ljava/util/Set;Ljava/util/Map;Ljava/util/List;)Lcom/discord/stores/StoreGuildsSorted$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getJoinedAt", "Ljava/util/List;", "getUserSettingsGuildPositions", "Ljava/util/Set;", "getMutedGuilds", "<init>", "(Ljava/util/Set;Ljava/util/Map;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class State {
        private final Map<Long, Long> joinedAt;
        private final Set<Long> mutedGuilds;
        private final List<ModelGuildFolder> userSettingsGuildPositions;

        public State(Set<Long> set, Map<Long, Long> map, List<ModelGuildFolder> list) {
            Intrinsics3.checkNotNullParameter(set, "mutedGuilds");
            Intrinsics3.checkNotNullParameter(map, "joinedAt");
            Intrinsics3.checkNotNullParameter(list, "userSettingsGuildPositions");
            this.mutedGuilds = set;
            this.joinedAt = map;
            this.userSettingsGuildPositions = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Set set, Map map, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                set = state.mutedGuilds;
            }
            if ((i & 2) != 0) {
                map = state.joinedAt;
            }
            if ((i & 4) != 0) {
                list = state.userSettingsGuildPositions;
            }
            return state.copy(set, map, list);
        }

        public final Set<Long> component1() {
            return this.mutedGuilds;
        }

        public final Map<Long, Long> component2() {
            return this.joinedAt;
        }

        public final List<ModelGuildFolder> component3() {
            return this.userSettingsGuildPositions;
        }

        public final State copy(Set<Long> mutedGuilds, Map<Long, Long> joinedAt, List<ModelGuildFolder> userSettingsGuildPositions) {
            Intrinsics3.checkNotNullParameter(mutedGuilds, "mutedGuilds");
            Intrinsics3.checkNotNullParameter(joinedAt, "joinedAt");
            Intrinsics3.checkNotNullParameter(userSettingsGuildPositions, "userSettingsGuildPositions");
            return new State(mutedGuilds, joinedAt, userSettingsGuildPositions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.mutedGuilds, state.mutedGuilds) && Intrinsics3.areEqual(this.joinedAt, state.joinedAt) && Intrinsics3.areEqual(this.userSettingsGuildPositions, state.userSettingsGuildPositions);
        }

        public final Map<Long, Long> getJoinedAt() {
            return this.joinedAt;
        }

        public final Set<Long> getMutedGuilds() {
            return this.mutedGuilds;
        }

        public final List<ModelGuildFolder> getUserSettingsGuildPositions() {
            return this.userSettingsGuildPositions;
        }

        public int hashCode() {
            Set<Long> set = this.mutedGuilds;
            int iHashCode = (set != null ? set.hashCode() : 0) * 31;
            Map<Long, Long> map = this.joinedAt;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            List<ModelGuildFolder> list = this.userSettingsGuildPositions;
            return iHashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(mutedGuilds=");
            sbU.append(this.mutedGuilds);
            sbU.append(", joinedAt=");
            sbU.append(this.joinedAt);
            sbU.append(", userSettingsGuildPositions=");
            return outline.L(sbU, this.userSettingsGuildPositions, ")");
        }
    }

    /* compiled from: StoreGuildsSorted.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelGuildFolder;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelGuildFolder;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildsSorted$ensureValidPositions$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<ModelGuildFolder, Boolean> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelGuildFolder modelGuildFolder) {
            return Boolean.valueOf(invoke2(modelGuildFolder));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelGuildFolder modelGuildFolder) {
            Intrinsics3.checkNotNullParameter(modelGuildFolder, "it");
            return modelGuildFolder.getGuildIds().isEmpty();
        }
    }

    /* compiled from: StoreGuildsSorted.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildsSorted$State;", "state", "", "invoke", "(Lcom/discord/stores/StoreGuildsSorted$State;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildsSorted$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<State, Unit> {

        /* compiled from: StoreGuildsSorted.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildsSorted$init$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01401 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ State $state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01401(State state) {
                super(0);
                this.$state = state;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildsSorted.access$handleNewState(StoreGuildsSorted.this, this.$state);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(State state) {
            invoke2(state);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(State state) {
            Intrinsics3.checkNotNullParameter(state, "state");
            StoreGuildsSorted.access$getDispatcher$p(StoreGuildsSorted.this).schedule(new C01401(state));
        }
    }

    /* compiled from: StoreGuildsSorted.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/stores/StoreGuildsSorted$Entry;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildsSorted$observeEntries$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends Entry>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends Entry> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends Entry> invoke2() {
            return StoreGuildsSorted.this.getEntries();
        }
    }

    /* compiled from: StoreGuildsSorted.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a&\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/util/LinkedHashMap;", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "Lkotlin/collections/LinkedHashMap;", "invoke", "()Ljava/util/LinkedHashMap;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildsSorted$observeOrderedGuilds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<LinkedHashMap<Long, Guild>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ LinkedHashMap<Long, Guild> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final LinkedHashMap<Long, Guild> invoke2() {
            return StoreGuildsSorted.this.getOrderedGuilds();
        }
    }

    /* compiled from: StoreGuildsSorted.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u0010\b\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00050\u00052\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildsSorted$observeStores$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<? extends Long>, Set<? extends Long>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Set<? extends Long> call(List<? extends Long> list) {
            return call2((List<Long>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Set<Long> call2(List<Long> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            return _Collections.toSet(list);
        }
    }

    /* compiled from: StoreGuildsSorted.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0010\u001a\n \u0004*\u0004\u0018\u00010\r0\r2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002\"\u0010\u0007\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0004*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00060\u000626\u0010\t\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\b \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\b\u0018\u00010\u00000\u00002\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b \u0004*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\nH\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "mutedGuilds", "Lcom/discord/primitives/Timestamp;", "joinedAt", "", "Lcom/discord/models/domain/ModelGuildFolder;", "folders", "Lcom/discord/stores/StoreGuildsSorted$State;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/List;)Lcom/discord/stores/StoreGuildsSorted$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildsSorted$observeStores$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends Guild>, Set<? extends Long>, Map<Long, ? extends Long>, List<? extends ModelGuildFolder>, State> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ State call(Map<Long, ? extends Guild> map, Set<? extends Long> set, Map<Long, ? extends Long> map2, List<? extends ModelGuildFolder> list) {
            return call2((Map<Long, Guild>) map, (Set<Long>) set, (Map<Long, Long>) map2, (List<ModelGuildFolder>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final State call2(Map<Long, Guild> map, Set<Long> set, Map<Long, Long> map2, List<ModelGuildFolder> list) {
            Intrinsics3.checkNotNullExpressionValue(set, "mutedGuilds");
            Intrinsics3.checkNotNullExpressionValue(map2, "joinedAt");
            Intrinsics3.checkNotNullExpressionValue(list, "folders");
            return new State(set, map2, list);
        }
    }

    /* compiled from: StoreGuildsSorted.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildsSorted$setPositions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $guildPositions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$guildPositions = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildsSorted.access$handleNewPositionsFromUser(StoreGuildsSorted.this, this.$guildPositions);
        }
    }

    /* compiled from: StoreGuildsSorted.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u00012\u0018\u0010\u0004\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "guildId1", "guildId2", "", "compare", "(Ljava/lang/Long;Ljava/lang/Long;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildsSorted$updatePositions$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Comparator<Long> {
        public final /* synthetic */ Map $guilds;
        public final /* synthetic */ State $state;

        public AnonymousClass1(State state, Map map) {
            this.$state = state;
            this.$guilds = map;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Long l, Long l2) {
            return compare2(l, l2);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(Long l, Long l2) {
            String name;
            String name2;
            boolean zContains = this.$state.getMutedGuilds().contains(l);
            if (this.$state.getMutedGuilds().contains(l2) != zContains) {
                return zContains ? 1 : -1;
            }
            Long l3 = this.$state.getJoinedAt().get(l);
            long jLongValue = l3 != null ? l3.longValue() : Long.MIN_VALUE;
            Long l4 = this.$state.getJoinedAt().get(l);
            long jLongValue2 = l4 != null ? l4.longValue() : Long.MIN_VALUE;
            if (jLongValue != jLongValue2) {
                return (int) (jLongValue - jLongValue2);
            }
            Guild guild = (Guild) this.$guilds.get(l);
            String str = "";
            if (guild == null || (name = guild.getName()) == null) {
                name = "";
            }
            Guild guild2 = (Guild) this.$guilds.get(l2);
            if (guild2 != null && (name2 = guild2.getName()) != null) {
                str = name2;
            }
            return StringsJVM.compareTo(name, str, false);
        }
    }

    public StoreGuildsSorted(ObservationDeck observationDeck, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreLurking storeLurking) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildStore");
        Intrinsics3.checkNotNullParameter(storeLurking, "lurkingGuildStore");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.guildStore = storeGuilds;
        this.lurkingGuildStore = storeLurking;
        this.entries = new ArrayList();
        this.entriesSnapshot = Collections2.emptyList();
        this.positions = new ArrayList();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildsSorted storeGuildsSorted) {
        return storeGuildsSorted.dispatcher;
    }

    public static final /* synthetic */ void access$handleNewPositionsFromUser(StoreGuildsSorted storeGuildsSorted, List list) {
        storeGuildsSorted.handleNewPositionsFromUser(list);
    }

    public static final /* synthetic */ void access$handleNewState(StoreGuildsSorted storeGuildsSorted, State state) {
        storeGuildsSorted.handleNewState(state);
    }

    @Store3
    private final void ensureValidPositions() {
        Map<Long, Guild> guildsInternal$app_productionGoogleRelease = this.guildStore.getGuildsInternal$app_productionGoogleRelease();
        Set<Long> unavailableGuildsInternal$app_productionGoogleRelease = this.guildStore.getUnavailableGuildsInternal$app_productionGoogleRelease();
        HashSet hashSet = new HashSet();
        Iterator<T> it = this.positions.iterator();
        while (it.hasNext()) {
            hashSet.addAll(((ModelGuildFolder) it.next()).getGuildIds());
        }
        for (Guild guild : guildsInternal$app_productionGoogleRelease.values()) {
            if (!hashSet.contains(Long.valueOf(guild.getId())) && !this.lurkingGuildStore.isLurking$app_productionGoogleRelease(guild)) {
                this.positions.add(0, new ModelGuildFolder(null, CollectionsJVM.listOf(Long.valueOf(guild.getId())), null, null, 8, null));
            }
        }
        int i = 0;
        for (Object obj : this.positions) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            ModelGuildFolder modelGuildFolder = (ModelGuildFolder) obj;
            List<Long> guildIds = modelGuildFolder.getGuildIds();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : guildIds) {
                long jLongValue = ((Number) obj2).longValue();
                Guild guild2 = guildsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue));
                if ((!guildsInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue)) || unavailableGuildsInternal$app_productionGoogleRelease.contains(Long.valueOf(jLongValue)) || guild2 == null || this.lurkingGuildStore.isLurking$app_productionGoogleRelease(guild2)) ? false : true) {
                    arrayList.add(obj2);
                }
            }
            this.positions.set(i, ModelGuildFolder.copy$default(modelGuildFolder, null, arrayList, null, null, 13, null));
            i = i2;
        }
        Set<Long> lurkingGuildIdsSync = this.lurkingGuildStore.getLurkingGuildIdsSync();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = lurkingGuildIdsSync.iterator();
        while (it2.hasNext()) {
            Guild guild3 = this.guildStore.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(((Number) it2.next()).longValue()));
            Long lValueOf = guild3 != null ? Long.valueOf(guild3.getId()) : null;
            if (lValueOf != null) {
                arrayList2.add(lValueOf);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            this.positions.add(0, new ModelGuildFolder(null, CollectionsJVM.listOf(Long.valueOf(((Number) it3.next()).longValue())), null, null, 8, null));
        }
        MutableCollections.removeAll((List) this.positions, (Function1) AnonymousClass6.INSTANCE);
    }

    @Store3
    private final void handleNewPositionsFromUser(List<? extends Entry> guildPositions) {
        this.positions.clear();
        List<ModelGuildFolder> list = this.positions;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(guildPositions, 10));
        Iterator<T> it = guildPositions.iterator();
        while (it.hasNext()) {
            arrayList.add(((Entry) it.next()).asModelGuildFolder());
        }
        list.addAll(arrayList);
        ensureValidPositions();
        rebuildSortedGuilds();
    }

    @Store3
    private final void handleNewState(State state) {
        updatePositions(state);
        ensureValidPositions();
        rebuildSortedGuilds();
    }

    private final Observable<State> observeStores() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<State> observableH = Observable.h(companion.getGuilds().observeGuilds(), companion.getUserGuildSettings().observeMutedGuildIds().G(AnonymousClass1.INSTANCE), companion.getGuilds().observeJoinedAt(), companion.getUserSettings().observeGuildFolders(), AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…lds, joinedAt, folders) }");
        return observableH;
    }

    @Store3
    private final void rebuildSortedGuilds() {
        this.entries.clear();
        for (ModelGuildFolder modelGuildFolder : this.positions) {
            Long id2 = modelGuildFolder.getId();
            if (id2 != null) {
                long jLongValue = id2.longValue();
                List<Long> guildIds = modelGuildFolder.getGuildIds();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(guildIds, 10));
                Iterator<T> it = guildIds.iterator();
                while (it.hasNext()) {
                    Guild guild = this.guildStore.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(((Number) it.next()).longValue()));
                    Intrinsics3.checkNotNull(guild);
                    arrayList.add(guild);
                }
                this.entries.add(new Entry.Folder(jLongValue, arrayList, modelGuildFolder.getColor(), modelGuildFolder.getName()));
            } else {
                Guild guild2 = this.guildStore.getGuildsInternal$app_productionGoogleRelease().get(_Collections.first((List) modelGuildFolder.getGuildIds()));
                Intrinsics3.checkNotNull(guild2);
                this.entries.add(new Entry.SingletonGuild(guild2));
            }
        }
        markChanged();
    }

    @Store3
    private final void updatePositions(State state) {
        this.positions.clear();
        Map<Long, Guild> guildsInternal$app_productionGoogleRelease = this.guildStore.getGuildsInternal$app_productionGoogleRelease();
        if (!state.getUserSettingsGuildPositions().isEmpty()) {
            this.positions.addAll(state.getUserSettingsGuildPositions());
            return;
        }
        List<ModelGuildFolder> list = this.positions;
        List listSortedWith = _Collections.sortedWith(guildsInternal$app_productionGoogleRelease.keySet(), new AnonymousClass1(state, guildsInternal$app_productionGoogleRelease));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
        Iterator it = listSortedWith.iterator();
        while (it.hasNext()) {
            arrayList.add(new ModelGuildFolder(null, CollectionsJVM.listOf(Long.valueOf(((Number) it.next()).longValue())), null, null, 8, null));
        }
        list.addAll(arrayList);
    }

    public final List<Entry> getEntries() {
        return this.entriesSnapshot;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LinkedHashMap<Long, Guild> getOrderedGuilds() {
        LinkedHashMap<Long, Guild> linkedHashMap = new LinkedHashMap<>();
        for (Entry entry : getEntries()) {
            if (entry instanceof Entry.SingletonGuild) {
                Entry.SingletonGuild singletonGuild = (Entry.SingletonGuild) entry;
                linkedHashMap.put(Long.valueOf(singletonGuild.getGuild().getId()), singletonGuild.getGuild());
            } else if (entry instanceof Entry.Folder) {
                for (Object obj : ((Entry.Folder) entry).getGuilds()) {
                    linkedHashMap.put(Long.valueOf(((Guild) obj).getId()), obj);
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.leadingEdgeThrottle(ObservableExtensionsKt.computationLatest(observeStores()), 1L, TimeUnit.SECONDS), StoreGuildsSorted.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final Observable<List<Entry>> observeEntries() {
        Observable<List<Entry>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<LinkedHashMap<Long, Guild>> observeOrderedGuilds() {
        Observable<LinkedHashMap<Long, Guild>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setPositions(List<? extends Entry> guildPositions) {
        Intrinsics3.checkNotNullParameter(guildPositions, "guildPositions");
        this.dispatcher.schedule(new AnonymousClass1(guildPositions));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.entriesSnapshot = new ArrayList(this.entries);
    }
}
