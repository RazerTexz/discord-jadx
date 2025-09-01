package com.discord.widgets.voice.model;

import a0.a.a.b;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import co.discord.media_engine.DeviceDescription4;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: CallModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\b\u0086\b\u0018\u0000 \u009a\u00012\u00020\u0001:\u0002\u009a\u0001B\u0089\u0002\u0012\u0016\u0010T\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`+\u0012\u0004\u0012\u00020&0*\u0012\n\u0010U\u001a\u00060\bj\u0002`+\u0012\u0006\u0010V\u001a\u00020\b\u0012\f\u0010W\u001a\b\u0012\u0004\u0012\u00020201\u0012\b\u0010X\u001a\u0004\u0018\u000102\u0012\u0006\u0010Y\u001a\u000207\u0012\b\u0010Z\u001a\u0004\u0018\u00010:\u0012\u0006\u0010[\u001a\u00020\u0005\u0012\u0006\u0010\\\u001a\u00020\u0005\u0012\b\u0010]\u001a\u0004\u0018\u00010?\u0012\u0006\u0010^\u001a\u00020B\u0012\u0006\u0010_\u001a\u00020E\u0012\b\u0010`\u001a\u0004\u0018\u00010H\u0012\u0006\u0010a\u001a\u00020\u0010\u0012\u0006\u0010b\u001a\u00020\u0010\u0012\f\u0010c\u001a\b\u0012\u0004\u0012\u00020M01\u0012\u0016\u0010d\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`O\u0012\u0004\u0012\u00020P0*\u0012\u0016\u0010e\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`O\u0012\u0004\u0012\u00020R0*\u0012\u0006\u0010f\u001a\u00020\u0002\u0012\u0006\u0010g\u001a\u00020\u0005\u0012\u000e\u0010h\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u0006\u0010i\u001a\u00020\f¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÂ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÂ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÂ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u000eJ\r\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0012J\r\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0012J\r\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u0012J\r\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u0012J\r\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u0012J\r\u0010\u001c\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u0012J\r\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u0007J\u0015\u0010\u001e\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b\u001e\u0010\u000bJ\u0015\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0010¢\u0006\u0004\b#\u0010\u0012J\r\u0010$\u001a\u00020\u0010¢\u0006\u0004\b$\u0010\u0012J\r\u0010%\u001a\u00020\u0010¢\u0006\u0004\b%\u0010\u0012J\u000f\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0010¢\u0006\u0004\b)\u0010\u0012J \u0010,\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`+\u0012\u0004\u0012\u00020&0*HÆ\u0003¢\u0006\u0004\b,\u0010-J\u0014\u0010.\u001a\u00060\bj\u0002`+HÆ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b0\u0010/J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020201HÆ\u0003¢\u0006\u0004\b3\u00104J\u0012\u00105\u001a\u0004\u0018\u000102HÆ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00108\u001a\u000207HÆ\u0003¢\u0006\u0004\b8\u00109J\u0012\u0010;\u001a\u0004\u0018\u00010:HÆ\u0003¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b=\u0010\u0007J\u0010\u0010>\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b>\u0010\u0007J\u0012\u0010@\u001a\u0004\u0018\u00010?HÆ\u0003¢\u0006\u0004\b@\u0010AJ\u0010\u0010C\u001a\u00020BHÆ\u0003¢\u0006\u0004\bC\u0010DJ\u0010\u0010F\u001a\u00020EHÆ\u0003¢\u0006\u0004\bF\u0010GJ\u0012\u0010I\u001a\u0004\u0018\u00010HHÆ\u0003¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\bK\u0010\u0012J\u0010\u0010L\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\bL\u0010\u0012J\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00020M01HÆ\u0003¢\u0006\u0004\bN\u00104J \u0010Q\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`O\u0012\u0004\u0012\u00020P0*HÆ\u0003¢\u0006\u0004\bQ\u0010-J \u0010S\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`O\u0012\u0004\u0012\u00020R0*HÆ\u0003¢\u0006\u0004\bS\u0010-J¼\u0002\u0010j\u001a\u00020\u00002\u0018\b\u0002\u0010T\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`+\u0012\u0004\u0012\u00020&0*2\f\b\u0002\u0010U\u001a\u00060\bj\u0002`+2\b\b\u0002\u0010V\u001a\u00020\b2\u000e\b\u0002\u0010W\u001a\b\u0012\u0004\u0012\u000202012\n\b\u0002\u0010X\u001a\u0004\u0018\u0001022\b\b\u0002\u0010Y\u001a\u0002072\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010[\u001a\u00020\u00052\b\b\u0002\u0010\\\u001a\u00020\u00052\n\b\u0002\u0010]\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010^\u001a\u00020B2\b\b\u0002\u0010_\u001a\u00020E2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010H2\b\b\u0002\u0010a\u001a\u00020\u00102\b\b\u0002\u0010b\u001a\u00020\u00102\u000e\b\u0002\u0010c\u001a\b\u0012\u0004\u0012\u00020M012\u0018\b\u0002\u0010d\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`O\u0012\u0004\u0012\u00020P0*2\u0018\b\u0002\u0010e\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`O\u0012\u0004\u0012\u00020R0*2\b\b\u0002\u0010f\u001a\u00020\u00022\b\b\u0002\u0010g\u001a\u00020\u00052\u0010\b\u0002\u0010h\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\b\b\u0002\u0010i\u001a\u00020\fHÆ\u0001¢\u0006\u0004\bj\u0010kJ\u0010\u0010m\u001a\u00020lHÖ\u0001¢\u0006\u0004\bm\u0010nJ\u0010\u0010o\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\bo\u0010\u0007J\u001a\u0010q\u001a\u00020\u00102\b\u0010p\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bq\u0010rR\u0019\u0010t\u001a\u00020s8\u0006@\u0006¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR)\u0010e\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`O\u0012\u0004\u0012\u00020R0*8\u0006@\u0006¢\u0006\f\n\u0004\be\u0010x\u001a\u0004\by\u0010-R)\u0010d\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`O\u0012\u0004\u0012\u00020P0*8\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010x\u001a\u0004\bz\u0010-R\u001b\u0010]\u001a\u0004\u0018\u00010?8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010{\u001a\u0004\b|\u0010AR\u0019\u0010}\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b}\u0010~\u001a\u0004\b}\u0010\u0012R\u001a\u0010^\u001a\u00020B8\u0006@\u0006¢\u0006\r\n\u0004\b^\u0010\u007f\u001a\u0005\b\u0080\u0001\u0010DR\u001b\u0010[\u001a\u00020\u00058\u0006@\u0006¢\u0006\u000e\n\u0005\b[\u0010\u0081\u0001\u001a\u0005\b\u0082\u0001\u0010\u0007R\u001f\u0010U\u001a\u00060\bj\u0002`+8\u0006@\u0006¢\u0006\u000e\n\u0005\bU\u0010\u0083\u0001\u001a\u0005\b\u0084\u0001\u0010/R\u0019\u0010a\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010~\u001a\u0004\ba\u0010\u0012R*\u0010T\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`+\u0012\u0004\u0012\u00020&0*8\u0006@\u0006¢\u0006\r\n\u0004\bT\u0010x\u001a\u0005\b\u0085\u0001\u0010-R\u001b\u0010V\u001a\u00020\b8\u0006@\u0006¢\u0006\u000e\n\u0005\bV\u0010\u0083\u0001\u001a\u0005\b\u0086\u0001\u0010/R\u001b\u0010Y\u001a\u0002078\u0006@\u0006¢\u0006\u000e\n\u0005\bY\u0010\u0087\u0001\u001a\u0005\b\u0088\u0001\u00109R\u001b\u0010_\u001a\u00020E8\u0006@\u0006¢\u0006\u000e\n\u0005\b_\u0010\u0089\u0001\u001a\u0005\b\u008a\u0001\u0010GR\u001d\u0010`\u001a\u0004\u0018\u00010H8\u0006@\u0006¢\u0006\u000e\n\u0005\b`\u0010\u008b\u0001\u001a\u0005\b\u008c\u0001\u0010JR\u0017\u0010f\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bf\u0010\u008d\u0001R\u0017\u0010g\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bg\u0010\u0081\u0001R\u001f\u0010h\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bh\u0010\u008e\u0001R\u0017\u0010i\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bi\u0010\u008f\u0001R!\u0010c\u001a\b\u0012\u0004\u0012\u00020M018\u0006@\u0006¢\u0006\u000e\n\u0005\bc\u0010\u0090\u0001\u001a\u0005\b\u0091\u0001\u00104R\u001d\u0010X\u001a\u0004\u0018\u0001028\u0006@\u0006¢\u0006\u000e\n\u0005\bX\u0010\u0092\u0001\u001a\u0005\b\u0093\u0001\u00106R\u001d\u0010Z\u001a\u0004\u0018\u00010:8\u0006@\u0006¢\u0006\u000e\n\u0005\bZ\u0010\u0094\u0001\u001a\u0005\b\u0095\u0001\u0010<R\u001b\u0010\\\u001a\u00020\u00058\u0006@\u0006¢\u0006\u000e\n\u0005\b\\\u0010\u0081\u0001\u001a\u0005\b\u0096\u0001\u0010\u0007R\u0019\u0010b\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010~\u001a\u0004\bb\u0010\u0012R!\u0010W\u001a\b\u0012\u0004\u0012\u000202018\u0006@\u0006¢\u0006\u000e\n\u0005\bW\u0010\u0090\u0001\u001a\u0005\b\u0097\u0001\u00104¨\u0006\u009b\u0001"}, d2 = {"Lcom/discord/widgets/voice/model/CallModel;", "", "Lcom/discord/api/channel/Channel;", "component19", "()Lcom/discord/api/channel/Channel;", "", "component20", "()I", "", "Lcom/discord/api/permission/PermissionBit;", "component21", "()Ljava/lang/Long;", "Lcom/discord/stores/StoreAudioManagerV2$State;", "component22", "()Lcom/discord/stores/StoreAudioManagerV2$State;", "getChannel", "", "isConnected", "()Z", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "getInputMode", "()Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "getAudioManagerState", "isMeMutedByAnySource", "isMuted", "isSuppressed", "isSelfDeafened", "isServerDeafened", "isDeafenedByAnySource", "getNumUsersConnected", "getChannelPermissions", "Lcom/discord/utilities/time/Clock;", "clock", "getCallDurationMs", "(Lcom/discord/utilities/time/Clock;)J", "canRequestToSpeak", "canInvite", "canManageEvent", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "getDmRecipient", "()Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "isStreaming", "", "Lcom/discord/primitives/UserId;", "component1", "()Ljava/util/Map;", "component2", "()J", "component3", "", "Lco/discord/media_engine/VideoInputDeviceDescription;", "component4", "()Ljava/util/List;", "component5", "()Lco/discord/media_engine/VideoInputDeviceDescription;", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "component6", "()Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "Lcom/discord/rtcconnection/RtcConnection$Metadata;", "component7", "()Lcom/discord/rtcconnection/RtcConnection$Metadata;", "component8", "component9", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "component10", "()Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "Lcom/discord/utilities/voice/VoiceChannelJoinability;", "component11", "()Lcom/discord/utilities/voice/VoiceChannelJoinability;", "Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "component12", "()Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "Lcom/discord/models/guild/Guild;", "component13", "()Lcom/discord/models/guild/Guild;", "component14", "component15", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component16", "Lcom/discord/primitives/ApplicationId;", "Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "component17", "Lcom/discord/api/application/Application;", "component18", "participants", "myId", "timeConnectedMs", "videoDevices", "selectedVideoDevice", "voiceSettings", "rtcConnectionMetadata", "callFeedbackTriggerRateDenominator", "streamFeedbackTriggerRateDenominator", "activeStream", "voiceChannelJoinability", "guildMaxVideoChannelMembers", "guild", "isChannelSelected", "isMyHandRaised", "guildScheduledEvents", "embeddedActivitiesForChannel", "applications", "channel", "numUsersConnected", "channelPermissions", "audioManagerState", "copy", "(Ljava/util/Map;JJLjava/util/List;Lco/discord/media_engine/VideoInputDeviceDescription;Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Lcom/discord/rtcconnection/RtcConnection$Metadata;IILcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;Lcom/discord/utilities/voice/VoiceChannelJoinability;Lcom/discord/api/guild/GuildMaxVideoChannelUsers;Lcom/discord/models/guild/Guild;ZZLjava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/discord/api/channel/Channel;ILjava/lang/Long;Lcom/discord/stores/StoreAudioManagerV2$State;)Lcom/discord/widgets/voice/model/CallModel;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/voice/model/CameraState;", "cameraState", "Lcom/discord/widgets/voice/model/CameraState;", "getCameraState", "()Lcom/discord/widgets/voice/model/CameraState;", "Ljava/util/Map;", "getApplications", "getEmbeddedActivitiesForChannel", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "getActiveStream", "isVideoCall", "Z", "Lcom/discord/utilities/voice/VoiceChannelJoinability;", "getVoiceChannelJoinability", "I", "getCallFeedbackTriggerRateDenominator", "J", "getMyId", "getParticipants", "getTimeConnectedMs", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "getVoiceSettings", "Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "getGuildMaxVideoChannelMembers", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/api/channel/Channel;", "Ljava/lang/Long;", "Lcom/discord/stores/StoreAudioManagerV2$State;", "Ljava/util/List;", "getGuildScheduledEvents", "Lco/discord/media_engine/VideoInputDeviceDescription;", "getSelectedVideoDevice", "Lcom/discord/rtcconnection/RtcConnection$Metadata;", "getRtcConnectionMetadata", "getStreamFeedbackTriggerRateDenominator", "getVideoDevices", "<init>", "(Ljava/util/Map;JJLjava/util/List;Lco/discord/media_engine/VideoInputDeviceDescription;Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Lcom/discord/rtcconnection/RtcConnection$Metadata;IILcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;Lcom/discord/utilities/voice/VoiceChannelJoinability;Lcom/discord/api/guild/GuildMaxVideoChannelUsers;Lcom/discord/models/guild/Guild;ZZLjava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/discord/api/channel/Channel;ILjava/lang/Long;Lcom/discord/stores/StoreAudioManagerV2$State;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class CallModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreApplicationStreaming.ActiveApplicationStream activeStream;
    private final Map<Long, Application> applications;
    private final StoreAudioManagerV2.State audioManagerState;
    private final int callFeedbackTriggerRateDenominator;
    private final CameraState cameraState;
    private final Channel channel;
    private final Long channelPermissions;
    private final Map<Long, EmbeddedActivity> embeddedActivitiesForChannel;
    private final Guild guild;
    private final GuildMaxVideoChannelUsers guildMaxVideoChannelMembers;
    private final List<GuildScheduledEvent> guildScheduledEvents;
    private final boolean isChannelSelected;
    private final boolean isMyHandRaised;
    private final boolean isVideoCall;
    private final long myId;
    private final int numUsersConnected;
    private final Map<Long, StoreVoiceParticipants.VoiceUser> participants;
    private final RtcConnection.Metadata rtcConnectionMetadata;
    private final DeviceDescription4 selectedVideoDevice;
    private final int streamFeedbackTriggerRateDenominator;
    private final long timeConnectedMs;
    private final List<DeviceDescription4> videoDevices;
    private final VoiceChannelJoinabilityUtils2 voiceChannelJoinability;
    private final StoreMediaSettings.VoiceConfiguration voiceSettings;

    /* compiled from: CallModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u00016B\t\b\u0002¢\u0006\u0004\b4\u00105J÷\u0001\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u0010\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00112\u0016\u0010&\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`$\u0012\u0004\u0012\u00020%0\f2\u0016\u0010(\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`$\u0012\u0004\u0012\u00020'0\fH\u0002¢\u0006\u0004\b*\u0010+J\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b.\u0010/J!\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0,2\n\u00101\u001a\u00060\u0006j\u0002`0¢\u0006\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/discord/widgets/voice/model/CallModel$Companion;", "", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/primitives/UserId;", "myUserId", "timeConnectedMs", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "voiceConfig", "", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "voiceParticipants", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "", "Lco/discord/media_engine/VideoInputDeviceDescription;", "videoDevices", "", "isChannelSelected", "selectedVideoDevice", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "activeStream", "Lcom/discord/rtcconnection/RtcConnection$Metadata;", "rtcConnectionMetadata", "", "callFeedbackTriggerRateDenominator", "streamFeedbackTriggerRateDenominator", "Lcom/discord/stores/StoreAudioManagerV2$State;", "audioManagerState", "Lcom/discord/utilities/voice/VoiceChannelJoinability;", "voiceChannelJoinability", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvents", "Lcom/discord/primitives/ApplicationId;", "Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "embeddedActivitiesForChannel", "Lcom/discord/api/application/Application;", "applications", "Lcom/discord/widgets/voice/model/CallModel;", "create", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;JJLcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Ljava/util/Map;Ljava/lang/Long;Ljava/util/List;ZLco/discord/media_engine/VideoInputDeviceDescription;Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;Lcom/discord/rtcconnection/RtcConnection$Metadata;IILcom/discord/stores/StoreAudioManagerV2$State;Lcom/discord/utilities/voice/VoiceChannelJoinability;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/voice/model/CallModel;", "Lrx/Observable;", "Lcom/discord/widgets/voice/model/CallModel$Companion$Chunk;", "observeChunk", "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "Lcom/discord/primitives/ChannelId;", "channelId", "get", "(J)Lrx/Observable;", "<init>", "()V", "Chunk", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: CallModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0082\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\n\u0010\u001e\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\n\u0012\u0016\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\u0010\"\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0011\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010%\u001a\u00020\u001a¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u008e\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00022\f\b\u0002\u0010\u001e\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\n2\u0018\b\u0002\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\r2\u0010\b\u0002\u0010\"\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00112\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010%\u001a\u00020\u001aHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010,\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-J\u001a\u00100\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101R\u001d\u0010\u001e\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00102\u001a\u0004\b3\u0010\bR\u0019\u0010 \u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b \u00104\u001a\u0004\b5\u0010\fR\u001b\u0010$\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b$\u00106\u001a\u0004\b7\u0010\u0019R)\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\b9\u0010\u0010R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010:\u001a\u0004\b;\u0010\u0004R\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010<\u001a\u0004\b=\u0010\u0017R!\u0010\"\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010>\u001a\u0004\b?\u0010\u0013R\u0019\u0010\u001f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\b@\u0010\bR\u0019\u0010%\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010A\u001a\u0004\bB\u0010\u001c¨\u0006E"}, d2 = {"Lcom/discord/widgets/voice/model/CallModel$Companion$Chunk;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "Lcom/discord/primitives/UserId;", "component2", "()J", "component3", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "component4", "()Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component5", "()Ljava/util/Map;", "Lcom/discord/api/permission/PermissionBit;", "component6", "()Ljava/lang/Long;", "", "Lco/discord/media_engine/VideoInputDeviceDescription;", "component7", "()Ljava/util/List;", "component8", "()Lco/discord/media_engine/VideoInputDeviceDescription;", "Lcom/discord/stores/StoreAudioManagerV2$State;", "component9", "()Lcom/discord/stores/StoreAudioManagerV2$State;", "channel", "myUserId", "timeConnectedMs", "voiceConfig", "voiceParticipants", "channelPermissions", "videoDevices", "selectedVideoDevice", "audioManagerState", "copy", "(Lcom/discord/api/channel/Channel;JJLcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Ljava/util/Map;Ljava/lang/Long;Ljava/util/List;Lco/discord/media_engine/VideoInputDeviceDescription;Lcom/discord/stores/StoreAudioManagerV2$State;)Lcom/discord/widgets/voice/model/CallModel$Companion$Chunk;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getMyUserId", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "getVoiceConfig", "Lco/discord/media_engine/VideoInputDeviceDescription;", "getSelectedVideoDevice", "Ljava/util/Map;", "getVoiceParticipants", "Lcom/discord/api/channel/Channel;", "getChannel", "Ljava/util/List;", "getVideoDevices", "Ljava/lang/Long;", "getChannelPermissions", "getTimeConnectedMs", "Lcom/discord/stores/StoreAudioManagerV2$State;", "getAudioManagerState", "<init>", "(Lcom/discord/api/channel/Channel;JJLcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Ljava/util/Map;Ljava/lang/Long;Ljava/util/List;Lco/discord/media_engine/VideoInputDeviceDescription;Lcom/discord/stores/StoreAudioManagerV2$State;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Chunk {
            private final StoreAudioManagerV2.State audioManagerState;
            private final Channel channel;
            private final Long channelPermissions;
            private final long myUserId;
            private final DeviceDescription4 selectedVideoDevice;
            private final long timeConnectedMs;
            private final List<DeviceDescription4> videoDevices;
            private final StoreMediaSettings.VoiceConfiguration voiceConfig;
            private final Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants;

            public Chunk(Channel channel, long j, long j2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, StoreVoiceParticipants.VoiceUser> map, Long l, List<DeviceDescription4> list, DeviceDescription4 deviceDescription4, StoreAudioManagerV2.State state) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(voiceConfiguration, "voiceConfig");
                Intrinsics3.checkNotNullParameter(map, "voiceParticipants");
                Intrinsics3.checkNotNullParameter(list, "videoDevices");
                Intrinsics3.checkNotNullParameter(state, "audioManagerState");
                this.channel = channel;
                this.myUserId = j;
                this.timeConnectedMs = j2;
                this.voiceConfig = voiceConfiguration;
                this.voiceParticipants = map;
                this.channelPermissions = l;
                this.videoDevices = list;
                this.selectedVideoDevice = deviceDescription4;
                this.audioManagerState = state;
            }

            public static /* synthetic */ Chunk copy$default(Chunk chunk, Channel channel, long j, long j2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map map, Long l, List list, DeviceDescription4 deviceDescription4, StoreAudioManagerV2.State state, int i, Object obj) {
                return chunk.copy((i & 1) != 0 ? chunk.channel : channel, (i & 2) != 0 ? chunk.myUserId : j, (i & 4) != 0 ? chunk.timeConnectedMs : j2, (i & 8) != 0 ? chunk.voiceConfig : voiceConfiguration, (i & 16) != 0 ? chunk.voiceParticipants : map, (i & 32) != 0 ? chunk.channelPermissions : l, (i & 64) != 0 ? chunk.videoDevices : list, (i & 128) != 0 ? chunk.selectedVideoDevice : deviceDescription4, (i & 256) != 0 ? chunk.audioManagerState : state);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            /* renamed from: component3, reason: from getter */
            public final long getTimeConnectedMs() {
                return this.timeConnectedMs;
            }

            /* renamed from: component4, reason: from getter */
            public final StoreMediaSettings.VoiceConfiguration getVoiceConfig() {
                return this.voiceConfig;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> component5() {
                return this.voiceParticipants;
            }

            /* renamed from: component6, reason: from getter */
            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final List<DeviceDescription4> component7() {
                return this.videoDevices;
            }

            /* renamed from: component8, reason: from getter */
            public final DeviceDescription4 getSelectedVideoDevice() {
                return this.selectedVideoDevice;
            }

            /* renamed from: component9, reason: from getter */
            public final StoreAudioManagerV2.State getAudioManagerState() {
                return this.audioManagerState;
            }

            public final Chunk copy(Channel channel, long myUserId, long timeConnectedMs, StoreMediaSettings.VoiceConfiguration voiceConfig, Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, Long channelPermissions, List<DeviceDescription4> videoDevices, DeviceDescription4 selectedVideoDevice, StoreAudioManagerV2.State audioManagerState) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(voiceConfig, "voiceConfig");
                Intrinsics3.checkNotNullParameter(voiceParticipants, "voiceParticipants");
                Intrinsics3.checkNotNullParameter(videoDevices, "videoDevices");
                Intrinsics3.checkNotNullParameter(audioManagerState, "audioManagerState");
                return new Chunk(channel, myUserId, timeConnectedMs, voiceConfig, voiceParticipants, channelPermissions, videoDevices, selectedVideoDevice, audioManagerState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Chunk)) {
                    return false;
                }
                Chunk chunk = (Chunk) other;
                return Intrinsics3.areEqual(this.channel, chunk.channel) && this.myUserId == chunk.myUserId && this.timeConnectedMs == chunk.timeConnectedMs && Intrinsics3.areEqual(this.voiceConfig, chunk.voiceConfig) && Intrinsics3.areEqual(this.voiceParticipants, chunk.voiceParticipants) && Intrinsics3.areEqual(this.channelPermissions, chunk.channelPermissions) && Intrinsics3.areEqual(this.videoDevices, chunk.videoDevices) && Intrinsics3.areEqual(this.selectedVideoDevice, chunk.selectedVideoDevice) && Intrinsics3.areEqual(this.audioManagerState, chunk.audioManagerState);
            }

            public final StoreAudioManagerV2.State getAudioManagerState() {
                return this.audioManagerState;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            public final DeviceDescription4 getSelectedVideoDevice() {
                return this.selectedVideoDevice;
            }

            public final long getTimeConnectedMs() {
                return this.timeConnectedMs;
            }

            public final List<DeviceDescription4> getVideoDevices() {
                return this.videoDevices;
            }

            public final StoreMediaSettings.VoiceConfiguration getVoiceConfig() {
                return this.voiceConfig;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> getVoiceParticipants() {
                return this.voiceParticipants;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iA = (b.a(this.timeConnectedMs) + ((b.a(this.myUserId) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31)) * 31;
                StoreMediaSettings.VoiceConfiguration voiceConfiguration = this.voiceConfig;
                int iHashCode = (iA + (voiceConfiguration != null ? voiceConfiguration.hashCode() : 0)) * 31;
                Map<Long, StoreVoiceParticipants.VoiceUser> map = this.voiceParticipants;
                int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                Long l = this.channelPermissions;
                int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
                List<DeviceDescription4> list = this.videoDevices;
                int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
                DeviceDescription4 deviceDescription4 = this.selectedVideoDevice;
                int iHashCode5 = (iHashCode4 + (deviceDescription4 != null ? deviceDescription4.hashCode() : 0)) * 31;
                StoreAudioManagerV2.State state = this.audioManagerState;
                return iHashCode5 + (state != null ? state.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Chunk(channel=");
                sbU.append(this.channel);
                sbU.append(", myUserId=");
                sbU.append(this.myUserId);
                sbU.append(", timeConnectedMs=");
                sbU.append(this.timeConnectedMs);
                sbU.append(", voiceConfig=");
                sbU.append(this.voiceConfig);
                sbU.append(", voiceParticipants=");
                sbU.append(this.voiceParticipants);
                sbU.append(", channelPermissions=");
                sbU.append(this.channelPermissions);
                sbU.append(", videoDevices=");
                sbU.append(this.videoDevices);
                sbU.append(", selectedVideoDevice=");
                sbU.append(this.selectedVideoDevice);
                sbU.append(", audioManagerState=");
                sbU.append(this.audioManagerState);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ CallModel access$create(Companion companion, Channel channel, Guild guild, long j, long j2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map map, Long l, List list, boolean z2, DeviceDescription4 deviceDescription4, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection.Metadata metadata, int i, int i2, StoreAudioManagerV2.State state, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, List list2, Map map2, Map map3) {
            return companion.create(channel, guild, j, j2, voiceConfiguration, map, l, list, z2, deviceDescription4, activeApplicationStream, metadata, i, i2, state, voiceChannelJoinabilityUtils2, list2, map2, map3);
        }

        public static final /* synthetic */ Observable access$observeChunk(Companion companion, Channel channel) {
            return companion.observeChunk(channel);
        }

        private final CallModel create(Channel channel, Guild guild, long myUserId, long timeConnectedMs, StoreMediaSettings.VoiceConfiguration voiceConfig, Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, Long channelPermissions, List<DeviceDescription4> videoDevices, boolean isChannelSelected, DeviceDescription4 selectedVideoDevice, StoreApplicationStreaming.ActiveApplicationStream activeStream, RtcConnection.Metadata rtcConnectionMetadata, int callFeedbackTriggerRateDenominator, int streamFeedbackTriggerRateDenominator, StoreAudioManagerV2.State audioManagerState, VoiceChannelJoinabilityUtils2 voiceChannelJoinability, List<GuildScheduledEvent> guildScheduledEvents, Map<Long, EmbeddedActivity> embeddedActivitiesForChannel, Map<Long, Application> applications) {
            int i;
            GuildMaxVideoChannelUsers maxVideoChannelUsers;
            if (voiceParticipants.isEmpty()) {
                i = 0;
            } else {
                Iterator<Map.Entry<Long, StoreVoiceParticipants.VoiceUser>> it = voiceParticipants.entrySet().iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (it.next().getValue().isConnected()) {
                        i2++;
                    }
                }
                i = i2;
            }
            StoreVoiceParticipants.VoiceUser voiceUser = voiceParticipants.get(Long.valueOf(myUserId));
            boolean z2 = voiceUser != null && voiceUser.getIsRequestingToSpeak();
            if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
                maxVideoChannelUsers = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
            }
            return new CallModel(voiceParticipants, myUserId, timeConnectedMs, videoDevices, selectedVideoDevice, voiceConfig, rtcConnectionMetadata, callFeedbackTriggerRateDenominator, streamFeedbackTriggerRateDenominator, activeStream, voiceChannelJoinability, maxVideoChannelUsers, guild, isChannelSelected, z2, guildScheduledEvents, embeddedActivitiesForChannel, applications, channel, i, channelPermissions, audioManagerState);
        }

        private final Observable<Chunk> observeChunk(Channel channel) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Chunk> observableD = Observable.d(companion.getUsers().observeMeId(), companion.getVoiceChannelSelected().observeTimeSelectedMs(), companion.getMediaSettings().getVoiceConfiguration(), ObservableExtensionsKt.leadingEdgeThrottle(companion.getVoiceParticipants().get(channel.getId()), 250L, TimeUnit.MILLISECONDS), companion.getPermissions().observePermissionsForChannel(channel.getId()), companion.getMediaEngine().getVideoInputDevices(), companion.getMediaEngine().getSelectedVideoInputDevice(), companion.getAudioManagerV2().observeAudioManagerState(), new CallModel3(channel));
            Intrinsics3.checkNotNullExpressionValue(observableD, "Observable\n          .co…            )\n          }");
            return observableD;
        }

        public final Observable<CallModel> get(long channelId) {
            Observable observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new CallModel2(channelId));
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CallModel(Map<Long, StoreVoiceParticipants.VoiceUser> map, long j, long j2, List<DeviceDescription4> list, DeviceDescription4 deviceDescription4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, RtcConnection.Metadata metadata, int i, int i2, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, Guild guild, boolean z2, boolean z3, List<GuildScheduledEvent> list2, Map<Long, EmbeddedActivity> map2, Map<Long, Application> map3, Channel channel, int i3, Long l, StoreAudioManagerV2.State state) {
        boolean z4;
        Intrinsics3.checkNotNullParameter(map, "participants");
        Intrinsics3.checkNotNullParameter(list, "videoDevices");
        Intrinsics3.checkNotNullParameter(voiceConfiguration, "voiceSettings");
        Intrinsics3.checkNotNullParameter(voiceChannelJoinabilityUtils2, "voiceChannelJoinability");
        Intrinsics3.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelMembers");
        Intrinsics3.checkNotNullParameter(list2, "guildScheduledEvents");
        Intrinsics3.checkNotNullParameter(map2, "embeddedActivitiesForChannel");
        Intrinsics3.checkNotNullParameter(map3, "applications");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(state, "audioManagerState");
        this.participants = map;
        this.myId = j;
        this.timeConnectedMs = j2;
        this.videoDevices = list;
        this.selectedVideoDevice = deviceDescription4;
        this.voiceSettings = voiceConfiguration;
        this.rtcConnectionMetadata = metadata;
        this.callFeedbackTriggerRateDenominator = i;
        this.streamFeedbackTriggerRateDenominator = i2;
        this.activeStream = activeApplicationStream;
        this.voiceChannelJoinability = voiceChannelJoinabilityUtils2;
        this.guildMaxVideoChannelMembers = guildMaxVideoChannelUsers;
        this.guild = guild;
        this.isChannelSelected = z2;
        this.isMyHandRaised = z3;
        this.guildScheduledEvents = list2;
        this.embeddedActivitiesForChannel = map2;
        this.applications = map3;
        this.channel = channel;
        this.numUsersConnected = i3;
        this.channelPermissions = l;
        this.audioManagerState = state;
        this.cameraState = deviceDescription4 != null ? CameraState.CAMERA_ON : CameraState.CAMERA_OFF;
        boolean z5 = true;
        if (!isStreaming()) {
            if (map.isEmpty()) {
                z4 = false;
                if (!z4) {
                    z5 = false;
                }
            } else {
                Iterator<Map.Entry<Long, StoreVoiceParticipants.VoiceUser>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    VoiceState voiceState = it.next().getValue().getVoiceState();
                    if (voiceState != null ? voiceState.getSelfVideo() : false) {
                        z4 = true;
                        break;
                    }
                }
                z4 = false;
                if (!z4) {
                }
            }
        }
        this.isVideoCall = z5;
    }

    /* renamed from: component19, reason: from getter */
    private final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component20, reason: from getter */
    private final int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    /* renamed from: component21, reason: from getter */
    private final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    /* renamed from: component22, reason: from getter */
    private final StoreAudioManagerV2.State getAudioManagerState() {
        return this.audioManagerState;
    }

    public static /* synthetic */ CallModel copy$default(CallModel callModel, Map map, long j, long j2, List list, DeviceDescription4 deviceDescription4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, RtcConnection.Metadata metadata, int i, int i2, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, Guild guild, boolean z2, boolean z3, List list2, Map map2, Map map3, Channel channel, int i3, Long l, StoreAudioManagerV2.State state, int i4, Object obj) {
        return callModel.copy((i4 & 1) != 0 ? callModel.participants : map, (i4 & 2) != 0 ? callModel.myId : j, (i4 & 4) != 0 ? callModel.timeConnectedMs : j2, (i4 & 8) != 0 ? callModel.videoDevices : list, (i4 & 16) != 0 ? callModel.selectedVideoDevice : deviceDescription4, (i4 & 32) != 0 ? callModel.voiceSettings : voiceConfiguration, (i4 & 64) != 0 ? callModel.rtcConnectionMetadata : metadata, (i4 & 128) != 0 ? callModel.callFeedbackTriggerRateDenominator : i, (i4 & 256) != 0 ? callModel.streamFeedbackTriggerRateDenominator : i2, (i4 & 512) != 0 ? callModel.activeStream : activeApplicationStream, (i4 & 1024) != 0 ? callModel.voiceChannelJoinability : voiceChannelJoinabilityUtils2, (i4 & 2048) != 0 ? callModel.guildMaxVideoChannelMembers : guildMaxVideoChannelUsers, (i4 & 4096) != 0 ? callModel.guild : guild, (i4 & 8192) != 0 ? callModel.isChannelSelected : z2, (i4 & 16384) != 0 ? callModel.isMyHandRaised : z3, (i4 & 32768) != 0 ? callModel.guildScheduledEvents : list2, (i4 & 65536) != 0 ? callModel.embeddedActivitiesForChannel : map2, (i4 & 131072) != 0 ? callModel.applications : map3, (i4 & 262144) != 0 ? callModel.channel : channel, (i4 & 524288) != 0 ? callModel.numUsersConnected : i3, (i4 & 1048576) != 0 ? callModel.channelPermissions : l, (i4 & 2097152) != 0 ? callModel.audioManagerState : state);
    }

    public final boolean canInvite() {
        boolean zB = ChannelUtils.B(this.channel);
        boolean z2 = ChannelUtils.w(this.channel) && PermissionUtils.can(1L, this.channelPermissions);
        StageInstance stageInstanceForChannel = StoreStream.INSTANCE.getStageInstances().getStageInstanceForChannel(this.channel.getId());
        return zB || z2 || ((stageInstanceForChannel != null ? stageInstanceForChannel.getInviteCode() : null) != null);
    }

    public final boolean canManageEvent() {
        return GuildScheduledEventUtilities.INSTANCE.canStartEventInChannel(this.channel, this.channelPermissions);
    }

    public final boolean canRequestToSpeak() {
        return ChannelUtils.D(this.channel) && PermissionUtils.can(Permission.REQUEST_TO_SPEAK, this.channelPermissions);
    }

    public final Map<Long, StoreVoiceParticipants.VoiceUser> component1() {
        return this.participants;
    }

    /* renamed from: component10, reason: from getter */
    public final StoreApplicationStreaming.ActiveApplicationStream getActiveStream() {
        return this.activeStream;
    }

    /* renamed from: component11, reason: from getter */
    public final VoiceChannelJoinabilityUtils2 getVoiceChannelJoinability() {
        return this.voiceChannelJoinability;
    }

    /* renamed from: component12, reason: from getter */
    public final GuildMaxVideoChannelUsers getGuildMaxVideoChannelMembers() {
        return this.guildMaxVideoChannelMembers;
    }

    /* renamed from: component13, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsChannelSelected() {
        return this.isChannelSelected;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getIsMyHandRaised() {
        return this.isMyHandRaised;
    }

    public final List<GuildScheduledEvent> component16() {
        return this.guildScheduledEvents;
    }

    public final Map<Long, EmbeddedActivity> component17() {
        return this.embeddedActivitiesForChannel;
    }

    public final Map<Long, Application> component18() {
        return this.applications;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMyId() {
        return this.myId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimeConnectedMs() {
        return this.timeConnectedMs;
    }

    public final List<DeviceDescription4> component4() {
        return this.videoDevices;
    }

    /* renamed from: component5, reason: from getter */
    public final DeviceDescription4 getSelectedVideoDevice() {
        return this.selectedVideoDevice;
    }

    /* renamed from: component6, reason: from getter */
    public final StoreMediaSettings.VoiceConfiguration getVoiceSettings() {
        return this.voiceSettings;
    }

    /* renamed from: component7, reason: from getter */
    public final RtcConnection.Metadata getRtcConnectionMetadata() {
        return this.rtcConnectionMetadata;
    }

    /* renamed from: component8, reason: from getter */
    public final int getCallFeedbackTriggerRateDenominator() {
        return this.callFeedbackTriggerRateDenominator;
    }

    /* renamed from: component9, reason: from getter */
    public final int getStreamFeedbackTriggerRateDenominator() {
        return this.streamFeedbackTriggerRateDenominator;
    }

    public final CallModel copy(Map<Long, StoreVoiceParticipants.VoiceUser> participants, long myId, long timeConnectedMs, List<DeviceDescription4> videoDevices, DeviceDescription4 selectedVideoDevice, StoreMediaSettings.VoiceConfiguration voiceSettings, RtcConnection.Metadata rtcConnectionMetadata, int callFeedbackTriggerRateDenominator, int streamFeedbackTriggerRateDenominator, StoreApplicationStreaming.ActiveApplicationStream activeStream, VoiceChannelJoinabilityUtils2 voiceChannelJoinability, GuildMaxVideoChannelUsers guildMaxVideoChannelMembers, Guild guild, boolean isChannelSelected, boolean isMyHandRaised, List<GuildScheduledEvent> guildScheduledEvents, Map<Long, EmbeddedActivity> embeddedActivitiesForChannel, Map<Long, Application> applications, Channel channel, int numUsersConnected, Long channelPermissions, StoreAudioManagerV2.State audioManagerState) {
        Intrinsics3.checkNotNullParameter(participants, "participants");
        Intrinsics3.checkNotNullParameter(videoDevices, "videoDevices");
        Intrinsics3.checkNotNullParameter(voiceSettings, "voiceSettings");
        Intrinsics3.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
        Intrinsics3.checkNotNullParameter(guildMaxVideoChannelMembers, "guildMaxVideoChannelMembers");
        Intrinsics3.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
        Intrinsics3.checkNotNullParameter(embeddedActivitiesForChannel, "embeddedActivitiesForChannel");
        Intrinsics3.checkNotNullParameter(applications, "applications");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(audioManagerState, "audioManagerState");
        return new CallModel(participants, myId, timeConnectedMs, videoDevices, selectedVideoDevice, voiceSettings, rtcConnectionMetadata, callFeedbackTriggerRateDenominator, streamFeedbackTriggerRateDenominator, activeStream, voiceChannelJoinability, guildMaxVideoChannelMembers, guild, isChannelSelected, isMyHandRaised, guildScheduledEvents, embeddedActivitiesForChannel, applications, channel, numUsersConnected, channelPermissions, audioManagerState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallModel)) {
            return false;
        }
        CallModel callModel = (CallModel) other;
        return Intrinsics3.areEqual(this.participants, callModel.participants) && this.myId == callModel.myId && this.timeConnectedMs == callModel.timeConnectedMs && Intrinsics3.areEqual(this.videoDevices, callModel.videoDevices) && Intrinsics3.areEqual(this.selectedVideoDevice, callModel.selectedVideoDevice) && Intrinsics3.areEqual(this.voiceSettings, callModel.voiceSettings) && Intrinsics3.areEqual(this.rtcConnectionMetadata, callModel.rtcConnectionMetadata) && this.callFeedbackTriggerRateDenominator == callModel.callFeedbackTriggerRateDenominator && this.streamFeedbackTriggerRateDenominator == callModel.streamFeedbackTriggerRateDenominator && Intrinsics3.areEqual(this.activeStream, callModel.activeStream) && Intrinsics3.areEqual(this.voiceChannelJoinability, callModel.voiceChannelJoinability) && Intrinsics3.areEqual(this.guildMaxVideoChannelMembers, callModel.guildMaxVideoChannelMembers) && Intrinsics3.areEqual(this.guild, callModel.guild) && this.isChannelSelected == callModel.isChannelSelected && this.isMyHandRaised == callModel.isMyHandRaised && Intrinsics3.areEqual(this.guildScheduledEvents, callModel.guildScheduledEvents) && Intrinsics3.areEqual(this.embeddedActivitiesForChannel, callModel.embeddedActivitiesForChannel) && Intrinsics3.areEqual(this.applications, callModel.applications) && Intrinsics3.areEqual(this.channel, callModel.channel) && this.numUsersConnected == callModel.numUsersConnected && Intrinsics3.areEqual(this.channelPermissions, callModel.channelPermissions) && Intrinsics3.areEqual(this.audioManagerState, callModel.audioManagerState);
    }

    public final StoreApplicationStreaming.ActiveApplicationStream getActiveStream() {
        return this.activeStream;
    }

    public final Map<Long, Application> getApplications() {
        return this.applications;
    }

    public final StoreAudioManagerV2.State getAudioManagerState() {
        return this.audioManagerState;
    }

    public final long getCallDurationMs(Clock clock) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return clock.currentTimeMillis() - this.timeConnectedMs;
    }

    public final int getCallFeedbackTriggerRateDenominator() {
        return this.callFeedbackTriggerRateDenominator;
    }

    public final CameraState getCameraState() {
        return this.cameraState;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    public final StoreVoiceParticipants.VoiceUser getDmRecipient() {
        Object obj = null;
        if (this.channel.getType() != 1) {
            return null;
        }
        Iterator<T> it = this.participants.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((StoreVoiceParticipants.VoiceUser) next).getUser().getId() != this.myId) {
                obj = next;
                break;
            }
        }
        return (StoreVoiceParticipants.VoiceUser) obj;
    }

    public final Map<Long, EmbeddedActivity> getEmbeddedActivitiesForChannel() {
        return this.embeddedActivitiesForChannel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final GuildMaxVideoChannelUsers getGuildMaxVideoChannelMembers() {
        return this.guildMaxVideoChannelMembers;
    }

    public final List<GuildScheduledEvent> getGuildScheduledEvents() {
        return this.guildScheduledEvents;
    }

    public final MediaEngineConnection.InputMode getInputMode() {
        return this.voiceSettings.getInputMode();
    }

    public final long getMyId() {
        return this.myId;
    }

    public final int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    public final Map<Long, StoreVoiceParticipants.VoiceUser> getParticipants() {
        return this.participants;
    }

    public final RtcConnection.Metadata getRtcConnectionMetadata() {
        return this.rtcConnectionMetadata;
    }

    public final DeviceDescription4 getSelectedVideoDevice() {
        return this.selectedVideoDevice;
    }

    public final int getStreamFeedbackTriggerRateDenominator() {
        return this.streamFeedbackTriggerRateDenominator;
    }

    public final long getTimeConnectedMs() {
        return this.timeConnectedMs;
    }

    public final List<DeviceDescription4> getVideoDevices() {
        return this.videoDevices;
    }

    public final VoiceChannelJoinabilityUtils2 getVoiceChannelJoinability() {
        return this.voiceChannelJoinability;
    }

    public final StoreMediaSettings.VoiceConfiguration getVoiceSettings() {
        return this.voiceSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Map<Long, StoreVoiceParticipants.VoiceUser> map = this.participants;
        int iA = (b.a(this.timeConnectedMs) + ((b.a(this.myId) + ((map != null ? map.hashCode() : 0) * 31)) * 31)) * 31;
        List<DeviceDescription4> list = this.videoDevices;
        int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
        DeviceDescription4 deviceDescription4 = this.selectedVideoDevice;
        int iHashCode2 = (iHashCode + (deviceDescription4 != null ? deviceDescription4.hashCode() : 0)) * 31;
        StoreMediaSettings.VoiceConfiguration voiceConfiguration = this.voiceSettings;
        int iHashCode3 = (iHashCode2 + (voiceConfiguration != null ? voiceConfiguration.hashCode() : 0)) * 31;
        RtcConnection.Metadata metadata = this.rtcConnectionMetadata;
        int iHashCode4 = (((((iHashCode3 + (metadata != null ? metadata.hashCode() : 0)) * 31) + this.callFeedbackTriggerRateDenominator) * 31) + this.streamFeedbackTriggerRateDenominator) * 31;
        StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = this.activeStream;
        int iHashCode5 = (iHashCode4 + (activeApplicationStream != null ? activeApplicationStream.hashCode() : 0)) * 31;
        VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2 = this.voiceChannelJoinability;
        int iHashCode6 = (iHashCode5 + (voiceChannelJoinabilityUtils2 != null ? voiceChannelJoinabilityUtils2.hashCode() : 0)) * 31;
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = this.guildMaxVideoChannelMembers;
        int iHashCode7 = (iHashCode6 + (guildMaxVideoChannelUsers != null ? guildMaxVideoChannelUsers.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode8 = (iHashCode7 + (guild != null ? guild.hashCode() : 0)) * 31;
        boolean z2 = this.isChannelSelected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode8 + i) * 31;
        boolean z3 = this.isMyHandRaised;
        int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        List<GuildScheduledEvent> list2 = this.guildScheduledEvents;
        int iHashCode9 = (i3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Map<Long, EmbeddedActivity> map2 = this.embeddedActivitiesForChannel;
        int iHashCode10 = (iHashCode9 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, Application> map3 = this.applications;
        int iHashCode11 = (iHashCode10 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode12 = (((iHashCode11 + (channel != null ? channel.hashCode() : 0)) * 31) + this.numUsersConnected) * 31;
        Long l = this.channelPermissions;
        int iHashCode13 = (iHashCode12 + (l != null ? l.hashCode() : 0)) * 31;
        StoreAudioManagerV2.State state = this.audioManagerState;
        return iHashCode13 + (state != null ? state.hashCode() : 0);
    }

    public final boolean isChannelSelected() {
        return this.isChannelSelected;
    }

    public final boolean isConnected() {
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser != null) {
            return voiceUser.isConnected();
        }
        return false;
    }

    public final boolean isDeafenedByAnySource() {
        return isSelfDeafened() || isServerDeafened();
    }

    public final boolean isMeMutedByAnySource() {
        VoiceState voiceState;
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
            return false;
        }
        return AnimatableValueParser.V0(voiceState);
    }

    public final boolean isMuted() {
        VoiceState voiceState;
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
            return false;
        }
        return voiceState.getMute();
    }

    public final boolean isMyHandRaised() {
        return this.isMyHandRaised;
    }

    public final boolean isSelfDeafened() {
        return this.voiceSettings.isSelfDeafened();
    }

    public final boolean isServerDeafened() {
        VoiceState voiceState;
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
            return false;
        }
        return voiceState.getDeaf();
    }

    public final boolean isStreaming() {
        ModelApplicationStream stream;
        long j = this.myId;
        StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = this.activeStream;
        return (activeApplicationStream == null || (stream = activeApplicationStream.getStream()) == null || j != stream.getOwnerId()) ? false : true;
    }

    public final boolean isSuppressed() {
        VoiceState voiceState;
        StoreVoiceParticipants.VoiceUser voiceUser = this.participants.get(Long.valueOf(this.myId));
        if (voiceUser == null || (voiceState = voiceUser.getVoiceState()) == null) {
            return false;
        }
        return voiceState.getSuppress();
    }

    /* renamed from: isVideoCall, reason: from getter */
    public final boolean getIsVideoCall() {
        return this.isVideoCall;
    }

    public String toString() {
        StringBuilder sbU = outline.U("CallModel(participants=");
        sbU.append(this.participants);
        sbU.append(", myId=");
        sbU.append(this.myId);
        sbU.append(", timeConnectedMs=");
        sbU.append(this.timeConnectedMs);
        sbU.append(", videoDevices=");
        sbU.append(this.videoDevices);
        sbU.append(", selectedVideoDevice=");
        sbU.append(this.selectedVideoDevice);
        sbU.append(", voiceSettings=");
        sbU.append(this.voiceSettings);
        sbU.append(", rtcConnectionMetadata=");
        sbU.append(this.rtcConnectionMetadata);
        sbU.append(", callFeedbackTriggerRateDenominator=");
        sbU.append(this.callFeedbackTriggerRateDenominator);
        sbU.append(", streamFeedbackTriggerRateDenominator=");
        sbU.append(this.streamFeedbackTriggerRateDenominator);
        sbU.append(", activeStream=");
        sbU.append(this.activeStream);
        sbU.append(", voiceChannelJoinability=");
        sbU.append(this.voiceChannelJoinability);
        sbU.append(", guildMaxVideoChannelMembers=");
        sbU.append(this.guildMaxVideoChannelMembers);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", isChannelSelected=");
        sbU.append(this.isChannelSelected);
        sbU.append(", isMyHandRaised=");
        sbU.append(this.isMyHandRaised);
        sbU.append(", guildScheduledEvents=");
        sbU.append(this.guildScheduledEvents);
        sbU.append(", embeddedActivitiesForChannel=");
        sbU.append(this.embeddedActivitiesForChannel);
        sbU.append(", applications=");
        sbU.append(this.applications);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", numUsersConnected=");
        sbU.append(this.numUsersConnected);
        sbU.append(", channelPermissions=");
        sbU.append(this.channelPermissions);
        sbU.append(", audioManagerState=");
        sbU.append(this.audioManagerState);
        sbU.append(")");
        return sbU.toString();
    }
}
