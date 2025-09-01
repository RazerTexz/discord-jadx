package com.discord.widgets.voice.fullscreen;

import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.EmbeddedActivityUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities6;
import com.discord.utilities.streams.StreamContext;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ParticipantsListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/ParticipantsListItemGenerator;", "", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ParticipantsListItemGenerator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ParticipantsListItemGenerator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b(\u0010)J1\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u0002¢\u0006\u0004\b\b\u0010\tJe\u0010\u0019\u001a\u00020\u00182\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0016\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u00060\u00112\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0015\u0012\u0004\u0012\u00020\u00160\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJq\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0016\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u00060\u00112\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0015\u0012\u0004\u0012\u00020\u00160\u0011¢\u0006\u0004\b\u001f\u0010 J5\u0010&\u001a\u00020%2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0010\u0010\"\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030!2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/ParticipantsListItemGenerator$Companion;", "", "", "Lcom/discord/primitives/StreamKey;", "mySpectatingStreamKey", "Ljava/util/Comparator;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "Lkotlin/Comparator;", "createUserItemsComparator", "(Ljava/lang/String;)Ljava/util/Comparator;", "Ljava/util/ArrayList;", "Lcom/discord/widgets/voice/sheet/CallParticipantsAdapter$ListItem;", "Lkotlin/collections/ArrayList;", "listItems", "", "Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "embeddedActivities", "", "", "Lcom/discord/primitives/UserId;", "voiceParticipants", "Lcom/discord/primitives/ApplicationId;", "Lcom/discord/api/application/Application;", "applications", "", "addEmbeddedActivitiesToListItems", "(Ljava/util/ArrayList;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)V", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/widgets/voice/model/CallModel;", "callModel", "createConnectedListItems", "(Ljava/util/Map;Ljava/lang/String;Lcom/discord/api/channel/Channel;Lcom/discord/widgets/voice/model/CallModel;Ljava/util/List;Ljava/util/Map;)Ljava/util/List;", "", "fetchedPreviews", "Lcom/discord/stores/StoreApplicationStreamPreviews;", "storeApplicationStreamPreviews", "", "refreshStreams", "(Ljava/util/List;Ljava/util/Set;Lcom/discord/stores/StoreApplicationStreamPreviews;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final void addEmbeddedActivitiesToListItems(ArrayList<CallParticipantsAdapter.ListItem> listItems, List<EmbeddedActivity> embeddedActivities, Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, Map<Long, Application> applications) {
            for (EmbeddedActivity embeddedActivity : embeddedActivities) {
                List<UserGuildMember> activityParticipants = EmbeddedActivityUtils.getActivityParticipants(embeddedActivity, voiceParticipants);
                Application application = applications.get(Long.valueOf(embeddedActivity.getApplicationId()));
                if (application != null) {
                    listItems.add(new CallParticipantsAdapter.ListItem.EmbeddedActivityItem(embeddedActivity, activityParticipants, com.discord.models.commands.Application.INSTANCE.fromApiApplication(application)));
                }
            }
        }

        private final Comparator<StoreVoiceParticipants.VoiceUser> createUserItemsComparator(String mySpectatingStreamKey) {
            return new ParticipantsListItemGenerator2(mySpectatingStreamKey);
        }

        public static /* synthetic */ Comparator createUserItemsComparator$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.createUserItemsComparator(str);
        }

        public final List<CallParticipantsAdapter.ListItem> createConnectedListItems(Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, String mySpectatingStreamKey, Channel channel, CallModel callModel, List<EmbeddedActivity> embeddedActivities, Map<Long, Application> applications) {
            Intrinsics3.checkNotNullParameter(voiceParticipants, "voiceParticipants");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(callModel, "callModel");
            Intrinsics3.checkNotNullParameter(embeddedActivities, "embeddedActivities");
            Intrinsics3.checkNotNullParameter(applications, "applications");
            ArrayList<CallParticipantsAdapter.ListItem> arrayList = new ArrayList<>();
            List<GuildScheduledEvent> guildScheduledEvents = callModel.getGuildScheduledEvents();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = guildScheduledEvents.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                GuildScheduledEventUtilities2 eventTiming = GuildScheduledEventUtilities5.getEventTiming((GuildScheduledEvent) next);
                if (eventTiming.isStartable() || eventTiming == GuildScheduledEventUtilities2.LIVE) {
                    arrayList2.add(next);
                }
            }
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) _Collections.minWithOrNull(arrayList2, GuildScheduledEventUtilities6.INSTANCE);
            if (guildScheduledEvent != null) {
                arrayList.add(new CallParticipantsAdapter.ListItem.Event(guildScheduledEvent, callModel.canManageEvent(), callModel.isConnected()));
            }
            addEmbeddedActivitiesToListItems(arrayList, embeddedActivities, voiceParticipants, applications);
            ArrayList arrayList3 = new ArrayList();
            for (StoreVoiceParticipants.VoiceUser voiceUser : voiceParticipants.values()) {
                if (voiceUser.isConnected() || ChannelUtils.B(channel)) {
                    arrayList3.add(voiceUser);
                }
            }
            boolean z2 = !arrayList3.isEmpty();
            boolean z3 = mySpectatingStreamKey != null;
            if (z2) {
                List<StoreVoiceParticipants.VoiceUser> listSortedWith = _Collections.sortedWith(arrayList3, createUserItemsComparator(mySpectatingStreamKey));
                ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
                for (StoreVoiceParticipants.VoiceUser voiceUser2 : listSortedWith) {
                    arrayList4.add(new CallParticipantsAdapter.ListItem.VoiceUser(voiceUser2, ChannelUtils.B(channel) && !voiceUser2.isConnected(), z3 && Intrinsics3.areEqual(mySpectatingStreamKey, voiceUser2.getWatchingStream())));
                }
                arrayList.addAll(arrayList4);
            }
            if ((!arrayList3.isEmpty()) && callModel.canInvite()) {
                arrayList.add(CallParticipantsAdapter.ListItem.Invite.INSTANCE);
            }
            return arrayList;
        }

        public final boolean refreshStreams(List<? extends CallParticipantsAdapter.ListItem> listItems, Set<String> fetchedPreviews, StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
            ModelApplicationStream stream;
            Intrinsics3.checkNotNullParameter(listItems, "listItems");
            Intrinsics3.checkNotNullParameter(fetchedPreviews, "fetchedPreviews");
            Intrinsics3.checkNotNullParameter(storeApplicationStreamPreviews, "storeApplicationStreamPreviews");
            boolean z2 = false;
            for (CallParticipantsAdapter.ListItem listItem : listItems) {
                if (listItem instanceof CallParticipantsAdapter.ListItem.VoiceUser) {
                    z2 = true;
                    StreamContext streamContext = ((CallParticipantsAdapter.ListItem.VoiceUser) listItem).getParticipant().getStreamContext();
                    String encodedStreamKey = (streamContext == null || (stream = streamContext.getStream()) == null) ? null : stream.getEncodedStreamKey();
                    if (encodedStreamKey != null && !fetchedPreviews.contains(encodedStreamKey)) {
                        storeApplicationStreamPreviews.fetchStreamPreviewIfNotFetching(streamContext);
                        fetchedPreviews.add(encodedStreamKey);
                    }
                }
            }
            return z2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
