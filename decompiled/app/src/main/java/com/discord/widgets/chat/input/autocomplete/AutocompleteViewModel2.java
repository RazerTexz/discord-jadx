package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.member.GuildMember;
import com.discord.stores.CommandAutocompleteState;
import com.discord.stores.StoreApplicationCommandFrecency;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func9;

/* compiled from: AutocompleteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AutocompleteViewModel2<T, R> implements Func1<Channel, Observable<? extends AutocompleteViewModel.StoreState>> {
    public final /* synthetic */ StoreApplicationCommands $storeApplicationCommands;
    public final /* synthetic */ StoreApplicationCommandFrecency $storeApplicationCommandsFrecency;

    /* compiled from: AutocompleteViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001b\u001a\n \u0002*\u0004\u0018\u00010\u00180\u00182\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u000126\u0010\u0007\u001a2\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\b\u0012\u00060\u0005j\u0002`\u0006 \u0002*\u0018\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0018\u00010\u00040\u00042\u000e\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\b0\b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b \u0002*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\n22\u0010\u0010\u001a.\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e \u0002*\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\u00040\u00042\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0011 \u0002*\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n0\n2>\u0010\u0015\u001a:\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0004 \u0002*\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0004\u0018\u00010\u00040\u00042\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0013 \u0002*\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\n0\n2\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u000b \u0002*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\nH\n¢\u0006\u0004\b\u0019\u0010\u001a"}, d2 = {"", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "userId", "", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "computedRoles", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "browserCommands", "", "Lcom/discord/models/commands/ApplicationCommand;", "queriedCommands", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "autocompletables", "Lcom/discord/models/commands/Application;", "apps", "", "Lcom/discord/stores/CommandAutocompleteState;", "autoOptions", "frecencyIds", "frecencyApps", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Ljava/util/Map;Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$Companion$observeStores$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Long, Map<Long, ? extends GuildMember>, WidgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand>, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>, List<? extends Application>, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>>, List<? extends String>, List<? extends ApplicationCommand>, AutocompleteViewModel.StoreState> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func9
        public /* bridge */ /* synthetic */ AutocompleteViewModel.StoreState call(Long l, Map<Long, ? extends GuildMember> map, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand> list, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map2, List<? extends Application> list2, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map3, List<? extends String> list3, List<? extends ApplicationCommand> list4) {
            return call2(l, (Map<Long, GuildMember>) map, widgetChatInputDiscoveryCommandsModel, list, map2, (List<Application>) list2, map3, (List<String>) list3, list4);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final AutocompleteViewModel.StoreState call2(Long l, Map<Long, GuildMember> map, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand> list, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map2, List<Application> list2, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map3, List<String> list3, List<? extends ApplicationCommand> list4) {
            Intrinsics3.checkNotNullExpressionValue(l, "userId");
            long jLongValue = l.longValue();
            GuildMember guildMember = map.get(l);
            List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
            if (roles == null) {
                roles = Collections2.emptyList();
            }
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            Intrinsics3.checkNotNullExpressionValue(list, "queriedCommands");
            Intrinsics3.checkNotNullExpressionValue(list2, "apps");
            Intrinsics3.checkNotNullExpressionValue(map3, "autoOptions");
            Intrinsics3.checkNotNullExpressionValue(map2, "autocompletables");
            Intrinsics3.checkNotNullExpressionValue(list3, "frecencyIds");
            Intrinsics3.checkNotNullExpressionValue(list4, "frecencyApps");
            return new AutocompleteViewModel.StoreState(jLongValue, roles, channel, list, list2, map3, map2, widgetChatInputDiscoveryCommandsModel, list3, list4);
        }
    }

    public AutocompleteViewModel2(StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
        this.$storeApplicationCommands = storeApplicationCommands;
        this.$storeApplicationCommandsFrecency = storeApplicationCommandFrecency;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends AutocompleteViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends AutocompleteViewModel.StoreState> call2(Channel channel) {
        Intrinsics3.checkNotNullExpressionValue(channel, "channel");
        Observable<List<ApplicationCommand>> scalarSynchronousObservable = ChannelUtils.j(channel) ? new ScalarSynchronousObservable<>(Collections2.emptyList()) : this.$storeApplicationCommands.observeQueryCommands(channel.getId());
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.c(companion.getUsers().observeMeId(), companion.getGuilds().observeComputed(channel.getGuildId()), ApplicationCommandsAutocompletableSource.INSTANCE.getDiscoveryCommands(true, 3, channel), scalarSynchronousObservable, InputAutocompletables.INSTANCE.observeChannelAutocompletables(channel.getId()), this.$storeApplicationCommands.observeGuildApplications(channel.getId()), this.$storeApplicationCommands.observeAutocompleteResults(), this.$storeApplicationCommandsFrecency.observeTopCommandIds(Long.valueOf(channel.getGuildId())), this.$storeApplicationCommands.observeFrecencyCommands(channel.getGuildId()), new AnonymousClass1(channel));
    }
}
