package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommand2;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandAutocompletable;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandChoiceAutocompletable;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: ApplicationCommandsAutocompletableSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b&\u0010'J[\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f0\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/sources/ApplicationCommandsAutocompletableSource;", "", "", "Lcom/discord/primitives/UserId;", "myId", "", "Lcom/discord/primitives/RoleId;", "myChannelRoles", "Lcom/discord/models/commands/Application;", "apps", "Lcom/discord/models/commands/ApplicationCommand;", "appCommands", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "createAutocompletablesForApplicationCommands", "(JLjava/util/List;Ljava/util/List;Ljava/util/List;)Ljava/util/Map;", "Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "observeApplicationCommandAutocompletables", "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "getStoreGuilds", "()Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreApplicationCommands;", "storeApplicationCommands", "Lcom/discord/stores/StoreApplicationCommands;", "getStoreApplicationCommands", "()Lcom/discord/stores/StoreApplicationCommands;", "Lcom/discord/stores/StoreUser;", "storeUsers", "Lcom/discord/stores/StoreUser;", "getStoreUsers", "()Lcom/discord/stores/StoreUser;", "<init>", "(Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreApplicationCommands;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ApplicationCommandsAutocompletableSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreApplicationCommands storeApplicationCommands;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUsers;

    /* compiled from: ApplicationCommandsAutocompletableSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/sources/ApplicationCommandsAutocompletableSource$Companion;", "", "Lcom/discord/models/commands/ApplicationCommandOption;", "option", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "createFromCommandOption", "(Lcom/discord/models/commands/ApplicationCommandOption;)Ljava/util/List;", "", "includeHeaders", "", "placeholdersCount", "Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "getDiscoveryCommands", "(ZILcom/discord/api/channel/Channel;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final List<Autocompletable> createFromCommandOption(ApplicationCommandOption option) {
            Intrinsics3.checkNotNullParameter(option, "option");
            ArrayList arrayList = new ArrayList();
            if (option.getType() == ApplicationCommandType.BOOLEAN) {
                arrayList.add(new ApplicationCommandChoiceAutocompletable(new CommandChoice("true", "true"), null, 2, null));
                arrayList.add(new ApplicationCommandChoiceAutocompletable(new CommandChoice("false", "false"), null, 2, null));
            } else {
                List<CommandChoice> choices = option.getChoices();
                if (!(choices == null || choices.isEmpty())) {
                    List<CommandChoice> choices2 = option.getChoices();
                    ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(choices2, 10));
                    Iterator<T> it = choices2.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new ApplicationCommandChoiceAutocompletable((CommandChoice) it.next(), null, 2, null));
                    }
                    arrayList.addAll(arrayList2);
                }
            }
            return arrayList;
        }

        public final Observable<WidgetChatInputDiscoveryCommandsModel> getDiscoveryCommands(boolean includeHeaders, int placeholdersCount, Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<WidgetChatInputDiscoveryCommandsModel> observableG = Observable.g(companion.getUsers().observeMeId(), companion.getGuilds().observeComputed(channel.getGuildId()), companion.getApplicationCommands().observeDiscoverCommands(channel.getId()), companion.getApplicationCommands().observeGuildApplications(channel.getId()), companion.getApplicationCommands().observeFrecencyCommands(channel.getGuildId()), new ApplicationCommandsAutocompletableSource2(includeHeaders, placeholdersCount));
            Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…recency\n        )\n      }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ApplicationCommandsAutocompletableSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0012\u001a.\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e \u0002*\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u000126\u0010\u0007\u001a2\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\b\u0012\u00060\u0005j\u0002`\u0006 \u0002*\u0018\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0018\u00010\u00040\u00042\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t \u0002*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b \u0002*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b0\bH\n¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "myId", "", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "computedRoles", "", "Lcom/discord/models/commands/Application;", "apps", "Lcom/discord/models/commands/ApplicationCommand;", "queries", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource$observeApplicationCommandAutocompletables$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<Long, Map<Long, ? extends GuildMember>, List<? extends Application>, List<? extends ApplicationCommand>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Long l, Map<Long, ? extends GuildMember> map, List<? extends Application> list, List<? extends ApplicationCommand> list2) {
            return call2(l, (Map<Long, GuildMember>) map, (List<Application>) list, list2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Long l, Map<Long, GuildMember> map, List<Application> list, List<? extends ApplicationCommand> list2) {
            Intrinsics3.checkNotNullExpressionValue(list2, "queries");
            if (!(!list2.isEmpty())) {
                return MapsJVM.mapOf(Tuples.to(LeadingIdentifier.APP_COMMAND, new TreeSet()));
            }
            ApplicationCommandsAutocompletableSource applicationCommandsAutocompletableSource = ApplicationCommandsAutocompletableSource.this;
            Intrinsics3.checkNotNullExpressionValue(l, "myId");
            long jLongValue = l.longValue();
            GuildMember guildMember = map.get(l);
            List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
            if (roles == null) {
                roles = Collections2.emptyList();
            }
            Intrinsics3.checkNotNullExpressionValue(list, "apps");
            return ApplicationCommandsAutocompletableSource.access$createAutocompletablesForApplicationCommands(applicationCommandsAutocompletableSource, jLongValue, roles, list, list2);
        }
    }

    public ApplicationCommandsAutocompletableSource(StoreUser storeUser, StoreGuilds storeGuilds, StoreApplicationCommands storeApplicationCommands) {
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeApplicationCommands, "storeApplicationCommands");
        this.storeUsers = storeUser;
        this.storeGuilds = storeGuilds;
        this.storeApplicationCommands = storeApplicationCommands;
    }

    public static final /* synthetic */ Map access$createAutocompletablesForApplicationCommands(ApplicationCommandsAutocompletableSource applicationCommandsAutocompletableSource, long j, List list, List list2, List list3) {
        return applicationCommandsAutocompletableSource.createAutocompletablesForApplicationCommands(j, list, list2, list3);
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createAutocompletablesForApplicationCommands(long myId, List<Long> myChannelRoles, List<Application> apps, List<? extends ApplicationCommand> appCommands) {
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        HashMap map = new HashMap();
        for (Application application : apps) {
            map.put(Long.valueOf(application.getId()), application);
        }
        for (ApplicationCommand applicationCommand : appCommands) {
            treeSet.add(new ApplicationCommandAutocompletable((Application) map.get(Long.valueOf(applicationCommand.getApplicationId())), applicationCommand, ApplicationCommand2.hasPermission(applicationCommand, myId, myChannelRoles), true));
        }
        return MapsJVM.mapOf(Tuples.to(LeadingIdentifier.APP_COMMAND, treeSet));
    }

    public final StoreApplicationCommands getStoreApplicationCommands() {
        return this.storeApplicationCommands;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StoreUser getStoreUsers() {
        return this.storeUsers;
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeApplicationCommandAutocompletables(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Observable observableH = Observable.h(ObservableExtensionsKt.computationLatest(this.storeUsers.observeMeId()), ObservableExtensionsKt.computationLatest(this.storeGuilds.observeComputed(channel.getGuildId())), ObservableExtensionsKt.computationLatest(this.storeApplicationCommands.observeGuildApplications(channel.getId())), ObservableExtensionsKt.computationLatest(this.storeApplicationCommands.observeQueryCommands(channel.getId())), new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest… TreeSet())\n      }\n    }");
        Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observableR = ObservableExtensionsKt.computationLatest(observableH).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }
}
