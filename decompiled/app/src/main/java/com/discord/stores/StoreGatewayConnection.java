package com.discord.stores;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import b.a.d.AppState;
import b.a.d.AppState2;
import b.a.e.Backgrounded4;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.api.activity.Activity;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipient;
import com.discord.api.commands.ApplicationCommandAutocompleteResult;
import com.discord.api.commands.GuildApplicationCommands;
import com.discord.api.embeddedactivities.EmbeddedActivityInboundUpdate;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.forum.ForumUnreads;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.friendsuggestions.FriendSuggestionDelete;
import com.discord.api.guild.Guild;
import com.discord.api.guildjoinrequest.GuildJoinRequest2;
import com.discord.api.guildjoinrequest.GuildJoinRequest3;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildmember.GuildMemberRemove;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventUserUpdate;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.api.interaction.InteractionStateUpdate;
import com.discord.api.message.Message;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.Presence;
import com.discord.api.requiredaction.UserRequiredActionUpdate;
import com.discord.api.role.GuildRoleCreate;
import com.discord.api.role.GuildRoleDelete;
import com.discord.api.role.GuildRoleUpdate;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.TypingUser;
import com.discord.api.user.User;
import com.discord.api.voice.server.VoiceServer;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.App;
import com.discord.app.AppLog;
import com.discord.gateway.GatewayEventHandler;
import com.discord.gateway.GatewaySocket;
import com.discord.gateway.io.Outgoing2;
import com.discord.gateway.rest.RestConfig;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream3;
import com.discord.models.domain.ModelApplicationStream5;
import com.discord.models.domain.ModelApplicationStream7;
import com.discord.models.domain.ModelBan;
import com.discord.models.domain.ModelCall;
import com.discord.models.domain.ModelChannelUnreadUpdate;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.domain.ModelSession;
import com.discord.models.domain.ModelUserNote;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreClientDataState;
import com.discord.stores.utilities.BatchManager;
import com.discord.stores.utilities.Batched;
import com.discord.utilities.analytics.AnalyticSuperProperties;
import com.discord.utilities.fcm.NotificationData;
import com.discord.utilities.lazy.subscriptions.GuildSubscriptions;
import com.discord.utilities.logging.AppGatewaySocketLogger;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.ssl.SecureSocketsLayerUtils;
import com.discord.utilities.time.Clock;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.c.ExecutorScheduler;
import j0.p.Schedulers2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Executors;
import okhttp3.Interceptor;
import rx.Observable;
import rx.Scheduler;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import s.a.Executors6;

/* compiled from: StoreGatewayConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002Ù\u0002B?\b\u0007\u0012\b\u0010õ\u0001\u001a\u00030ô\u0001\u0012\b\u0010´\u0002\u001a\u00030³\u0002\u0012\n\b\u0002\u0010\u008a\u0002\u001a\u00030\u0089\u0002\u0012\b\b\u0002\u0010\u007f\u001a\u00020~\u0012\b\u0010\u008d\u0002\u001a\u00030\u008c\u0002¢\u0006\u0006\b×\u0002\u0010Ø\u0002J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ.\u0010!\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u001d*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010 \u001a\u00020\u001fH\u0082\b¢\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b#\u0010$J\u0019\u0010(\u001a\u00020\u001a2\n\u0010'\u001a\u00060%j\u0002`&¢\u0006\u0004\b(\u0010)JA\u00101\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010%2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b1\u00102J[\u0010:\u001a\u00020\u001a2\u000e\u00104\u001a\n\u0018\u00010%j\u0004\u0018\u0001`32\u000e\u0010'\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&2\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001a2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00109\u001a\u00020\u001a¢\u0006\u0004\b:\u0010;JI\u0010A\u001a\u00020\u001a2\n\u00104\u001a\u00060%j\u0002`32\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010>\u001a\u000e\u0012\b\u0012\u00060%j\u0002`=\u0018\u00010-2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?H\u0007¢\u0006\u0004\bA\u0010BJ!\u0010E\u001a\u00020\u001a2\n\u00104\u001a\u00060%j\u0002`32\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bE\u0010FJ[\u0010L\u001a\u00020\u001a2\n\u00104\u001a\u00060%j\u0002`32\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u001a2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010I\u001a\u0004\u0018\u00010?2\u0006\u0010J\u001a\u00020?2\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010-¢\u0006\u0004\bL\u0010MJG\u0010Q\u001a\u00020\u001a2\n\u00104\u001a\u00060%j\u0002`32\n\u0010'\u001a\u00060%j\u0002`&2 \u0010P\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060%j\u0002`&\u0012\b\u0012\u00060%j\u0002`O0N0-¢\u0006\u0004\bQ\u0010RJ\r\u0010S\u001a\u00020\u0002¢\u0006\u0004\bS\u0010\u0004J\u001b\u0010T\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0007¢\u0006\u0004\bT\u0010\tJ!\u0010U\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\bU\u0010VJ\u0019\u0010W\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\bW\u0010\tJ\r\u0010X\u001a\u00020\u0002¢\u0006\u0004\bX\u0010\u0004J\u0015\u0010[\u001a\u00020\u00022\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b[\u0010\\J\u0013\u0010^\u001a\b\u0012\u0004\u0012\u00020\u001a0]¢\u0006\u0004\b^\u0010_J\u0013\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001a0]¢\u0006\u0004\b`\u0010_J\u000f\u0010a\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\ba\u0010bJ\u0017\u0010d\u001a\u00020\u00022\u0006\u0010c\u001a\u00020\u001aH\u0016¢\u0006\u0004\bd\u0010eJ\u0017\u0010g\u001a\u00020\u00022\u0006\u0010f\u001a\u00020\u001aH\u0016¢\u0006\u0004\bg\u0010eJ!\u0010i\u001a\u00020\u00022\b\u0010h\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\bi\u0010jJ\u0017\u0010l\u001a\u00020\u00022\u0006\u0010k\u001a\u00020\u001aH\u0016¢\u0006\u0004\bl\u0010eR5\u0010o\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010m0m\u0012\f\u0012\n n*\u0004\u0018\u00010m0m0\u001e8\u0006@\u0006¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR5\u0010t\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010s0s\u0012\f\u0012\n n*\u0004\u0018\u00010s0s0\u001e8\u0006@\u0006¢\u0006\f\n\u0004\bt\u0010p\u001a\u0004\bu\u0010rR5\u0010v\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010s0s\u0012\f\u0012\n n*\u0004\u0018\u00010s0s0\u001e8\u0006@\u0006¢\u0006\f\n\u0004\bv\u0010p\u001a\u0004\bw\u0010rR5\u0010y\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010x0x\u0012\f\u0012\n n*\u0004\u0018\u00010x0x0\u001e8\u0006@\u0006¢\u0006\f\n\u0004\by\u0010p\u001a\u0004\bz\u0010rR5\u0010|\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010{0{\u0012\f\u0012\n n*\u0004\u0018\u00010{0{0\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b|\u0010p\u001a\u0004\b}\u0010rR\u0017\u0010\u007f\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R<\u0010\u0082\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0081\u00010\u0081\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0081\u00010\u0081\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010p\u001a\u0005\b\u0083\u0001\u0010rR\u001f\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R<\u0010\u008a\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0089\u00010\u0089\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0089\u00010\u0089\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010p\u001a\u0005\b\u008b\u0001\u0010rR8\u0010\u008c\u0001\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010s0s\u0012\f\u0012\n n*\u0004\u0018\u00010s0s0\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010p\u001a\u0005\b\u008d\u0001\u0010rR<\u0010\u008f\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u008e\u00010\u008e\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u008e\u00010\u008e\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008f\u0001\u0010p\u001a\u0005\b\u0090\u0001\u0010rR<\u0010\u0092\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0091\u00010\u0091\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0091\u00010\u0091\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010p\u001a\u0005\b\u0093\u0001\u0010rR<\u0010\u0095\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0094\u00010\u0094\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0094\u00010\u0094\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0095\u0001\u0010p\u001a\u0005\b\u0096\u0001\u0010rR<\u0010\u0098\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0097\u00010\u0097\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0097\u00010\u0097\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010p\u001a\u0005\b\u0099\u0001\u0010rR<\u0010\u009b\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009a\u00010\u009a\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009a\u00010\u009a\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u009b\u0001\u0010p\u001a\u0005\b\u009c\u0001\u0010rR<\u0010\u009e\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009d\u00010\u009d\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009d\u00010\u009d\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010p\u001a\u0005\b\u009f\u0001\u0010rR<\u0010¡\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010 \u00010 \u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010 \u00010 \u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b¡\u0001\u0010p\u001a\u0005\b¢\u0001\u0010rR<\u0010¤\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010£\u00010£\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010£\u00010£\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b¤\u0001\u0010p\u001a\u0005\b¥\u0001\u0010rR<\u0010§\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010¦\u00010¦\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010¦\u00010¦\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b§\u0001\u0010p\u001a\u0005\b¨\u0001\u0010rR<\u0010ª\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010©\u00010©\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010©\u00010©\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bª\u0001\u0010p\u001a\u0005\b«\u0001\u0010rR<\u0010\u00ad\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010¬\u00010¬\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010¬\u00010¬\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u00ad\u0001\u0010p\u001a\u0005\b®\u0001\u0010rR<\u0010°\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010¯\u00010¯\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010¯\u00010¯\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b°\u0001\u0010p\u001a\u0005\b±\u0001\u0010rR<\u0010²\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010£\u00010£\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010£\u00010£\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b²\u0001\u0010p\u001a\u0005\b³\u0001\u0010rR$\u0010:\u001a\n\u0012\u0005\u0012\u00030µ\u00010´\u00018\u0006@\u0006¢\u0006\u000f\n\u0005\b:\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001R<\u0010¹\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0091\u00010\u0091\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0091\u00010\u0091\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b¹\u0001\u0010p\u001a\u0005\bº\u0001\u0010rR<\u0010¼\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010»\u00010»\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010»\u00010»\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b¼\u0001\u0010p\u001a\u0005\b½\u0001\u0010rR<\u0010¿\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010¾\u00010¾\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010¾\u00010¾\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b¿\u0001\u0010p\u001a\u0005\bÀ\u0001\u0010rR\u001a\u0010Â\u0001\u001a\u00030Á\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R<\u0010Ä\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009d\u00010\u009d\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009d\u00010\u009d\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÄ\u0001\u0010p\u001a\u0005\bÅ\u0001\u0010rR<\u0010Ç\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Æ\u00010Æ\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010Æ\u00010Æ\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÇ\u0001\u0010p\u001a\u0005\bÈ\u0001\u0010rR<\u0010Ê\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010É\u00010É\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010É\u00010É\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÊ\u0001\u0010p\u001a\u0005\bË\u0001\u0010rR<\u0010Í\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ì\u00010Ì\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ì\u00010Ì\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÍ\u0001\u0010p\u001a\u0005\bÎ\u0001\u0010rR<\u0010Ï\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010»\u00010»\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010»\u00010»\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÏ\u0001\u0010p\u001a\u0005\bÐ\u0001\u0010rR<\u0010Ò\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ñ\u00010Ñ\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ñ\u00010Ñ\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÒ\u0001\u0010p\u001a\u0005\bÓ\u0001\u0010rR<\u0010Ô\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010£\u00010£\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010£\u00010£\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÔ\u0001\u0010p\u001a\u0005\bÕ\u0001\u0010rR<\u0010Ö\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010»\u00010»\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010»\u00010»\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÖ\u0001\u0010p\u001a\u0005\b×\u0001\u0010rR<\u0010Ù\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ø\u00010Ø\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ø\u00010Ø\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÙ\u0001\u0010p\u001a\u0005\bÚ\u0001\u0010rR<\u0010Ü\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Û\u00010Û\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010Û\u00010Û\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÜ\u0001\u0010p\u001a\u0005\bÝ\u0001\u0010rR<\u0010ß\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Þ\u00010Þ\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010Þ\u00010Þ\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bß\u0001\u0010p\u001a\u0005\bà\u0001\u0010rR:\u0010W\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010á\u00010á\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010á\u00010á\u00010\u001e8\u0006@\u0006¢\u0006\r\n\u0004\bW\u0010p\u001a\u0005\bâ\u0001\u0010rR<\u0010ä\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010ã\u00010ã\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010ã\u00010ã\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bä\u0001\u0010p\u001a\u0005\bå\u0001\u0010rR<\u0010ç\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010æ\u00010æ\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010æ\u00010æ\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bç\u0001\u0010p\u001a\u0005\bè\u0001\u0010rR<\u0010é\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009a\u00010\u009a\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009a\u00010\u009a\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bé\u0001\u0010p\u001a\u0005\bê\u0001\u0010rR<\u0010ì\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010ë\u00010ë\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010ë\u00010ë\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bì\u0001\u0010p\u001a\u0005\bí\u0001\u0010rR<\u0010ï\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010î\u00010î\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010î\u00010î\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bï\u0001\u0010p\u001a\u0005\bð\u0001\u0010rR<\u0010ò\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010ñ\u00010ñ\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010ñ\u00010ñ\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bò\u0001\u0010p\u001a\u0005\bó\u0001\u0010rR\u001a\u0010õ\u0001\u001a\u00030ô\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bõ\u0001\u0010ö\u0001R<\u0010ø\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010÷\u00010÷\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010÷\u00010÷\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bø\u0001\u0010p\u001a\u0005\bù\u0001\u0010rR8\u0010ú\u0001\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n n*\u0004\u0018\u00010\u00020\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bú\u0001\u0010p\u001a\u0005\bû\u0001\u0010rR<\u0010ü\u0001\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ñ\u00010Ñ\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ñ\u00010Ñ\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bü\u0001\u0010p\u001a\u0005\bý\u0001\u0010rR\u001b\u0010þ\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010ÿ\u0001R<\u0010\u0081\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0080\u00020\u0080\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0080\u00020\u0080\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0081\u0002\u0010p\u001a\u0005\b\u0082\u0002\u0010rR2\u0010f\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010\u001a0\u001a\u0012\f\u0012\n n*\u0004\u0018\u00010\u001a0\u001a0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010pR<\u0010\u0083\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Û\u00010Û\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010Û\u00010Û\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0083\u0002\u0010p\u001a\u0005\b\u0084\u0002\u0010rR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0015\u0010\u0085\u0002R<\u0010\u0087\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0086\u00020\u0086\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0086\u00020\u0086\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0087\u0002\u0010p\u001a\u0005\b\u0088\u0002\u0010rR\u001a\u0010\u008a\u0002\u001a\u00030\u0089\u00028\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0002\u0010\u008b\u0002R\u001a\u0010\u008d\u0002\u001a\u00030\u008c\u00028\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0002\u0010\u008e\u0002R<\u0010\u008f\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010£\u00010£\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010£\u00010£\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008f\u0002\u0010p\u001a\u0005\b\u0090\u0002\u0010rR8\u0010\u0091\u0002\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010m0m\u0012\f\u0012\n n*\u0004\u0018\u00010m0m0\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0091\u0002\u0010p\u001a\u0005\b\u0092\u0002\u0010rR8\u0010\u0093\u0002\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n n*\u0004\u0018\u00010\u00020\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0093\u0002\u0010p\u001a\u0005\b\u0094\u0002\u0010rR<\u0010\u0096\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0095\u00020\u0095\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u0095\u00020\u0095\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0096\u0002\u0010p\u001a\u0005\b\u0097\u0002\u0010rR<\u0010\u0098\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009d\u00010\u009d\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009d\u00010\u009d\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0098\u0002\u0010p\u001a\u0005\b\u0099\u0002\u0010rR<\u0010\u009a\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010÷\u00010÷\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010÷\u00010÷\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u009a\u0002\u0010p\u001a\u0005\b\u009b\u0002\u0010rRT\u0010\u009d\u0002\u001a:\u0012\u001a\u0012\u0018\u0012\u0005\u0012\u00030\u009c\u0002 n*\u000b\u0012\u0005\u0012\u00030\u009c\u0002\u0018\u00010-0-\u0012\u001a\u0012\u0018\u0012\u0005\u0012\u00030\u009c\u0002 n*\u000b\u0012\u0005\u0012\u00030\u009c\u0002\u0018\u00010-0-0\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u009d\u0002\u0010p\u001a\u0005\b\u009e\u0002\u0010rR8\u0010\u009f\u0002\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010x0x\u0012\f\u0012\n n*\u0004\u0018\u00010x0x0\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u009f\u0002\u0010p\u001a\u0005\b \u0002\u0010rR<\u0010¢\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010¡\u00020¡\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010¡\u00020¡\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b¢\u0002\u0010p\u001a\u0005\b£\u0002\u0010rR<\u0010¥\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010¤\u00020¤\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010¤\u00020¤\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b¥\u0002\u0010p\u001a\u0005\b¦\u0002\u0010rR<\u0010¨\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010§\u00020§\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010§\u00020§\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b¨\u0002\u0010p\u001a\u0005\b©\u0002\u0010rR<\u0010«\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010ª\u00020ª\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010ª\u00020ª\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b«\u0002\u0010p\u001a\u0005\b¬\u0002\u0010rR<\u0010®\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u00ad\u00020\u00ad\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u00ad\u00020\u00ad\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b®\u0002\u0010p\u001a\u0005\b¯\u0002\u0010rR<\u0010±\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010°\u00020°\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010°\u00020°\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b±\u0002\u0010p\u001a\u0005\b²\u0002\u0010rR2\u0010c\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010\u001a0\u001a\u0012\f\u0012\n n*\u0004\u0018\u00010\u001a0\u001a0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010pR\u001a\u0010´\u0002\u001a\u00030³\u00028\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b´\u0002\u0010µ\u0002R:\u0010U\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010¤\u00020¤\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010¤\u00020¤\u00020\u001e8\u0006@\u0006¢\u0006\r\n\u0004\bU\u0010p\u001a\u0005\b¶\u0002\u0010rR<\u0010·\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010»\u00010»\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010»\u00010»\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b·\u0002\u0010p\u001a\u0005\b¸\u0002\u0010rR<\u0010¹\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010ã\u00010ã\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010ã\u00010ã\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b¹\u0002\u0010p\u001a\u0005\bº\u0002\u0010rR<\u0010»\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009a\u00010\u009a\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009a\u00010\u009a\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b»\u0002\u0010p\u001a\u0005\b¼\u0002\u0010rR8\u0010½\u0002\u001a\u001e\u0012\f\u0012\n n*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n n*\u0004\u0018\u00010\u00020\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\b½\u0002\u0010p\u001a\u0005\b¾\u0002\u0010rR<\u0010À\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010¿\u00020¿\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010¿\u00020¿\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÀ\u0002\u0010p\u001a\u0005\bÁ\u0002\u0010rR<\u0010Ã\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Â\u00020Â\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010Â\u00020Â\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÃ\u0002\u0010p\u001a\u0005\bÄ\u0002\u0010rR<\u0010Æ\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Å\u00020Å\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010Å\u00020Å\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÆ\u0002\u0010p\u001a\u0005\bÇ\u0002\u0010rR<\u0010È\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Û\u00010Û\u0001\u0012\u000e\u0012\f n*\u0005\u0018\u00010Û\u00010Û\u00010\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÈ\u0002\u0010p\u001a\u0005\bÉ\u0002\u0010rR<\u0010Ë\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ê\u00020Ê\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ê\u00020Ê\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bË\u0002\u0010p\u001a\u0005\bÌ\u0002\u0010rR<\u0010Î\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Í\u00020Í\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010Í\u00020Í\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÎ\u0002\u0010p\u001a\u0005\bÏ\u0002\u0010rR<\u0010Ñ\u0002\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ð\u00020Ð\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010Ð\u00020Ð\u00020\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÑ\u0002\u0010p\u001a\u0005\bÒ\u0002\u0010rR:\u00101\u001a\"\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009c\u00020\u009c\u0002\u0012\u000e\u0012\f n*\u0005\u0018\u00010\u009c\u00020\u009c\u00020\u001e8\u0006@\u0006¢\u0006\r\n\u0004\b1\u0010p\u001a\u0005\bÓ\u0002\u0010rRT\u0010Õ\u0002\u001a:\u0012\u001a\u0012\u0018\u0012\u0005\u0012\u00030Ô\u0002 n*\u000b\u0012\u0005\u0012\u00030Ô\u0002\u0018\u00010-0-\u0012\u001a\u0012\u0018\u0012\u0005\u0012\u00030Ô\u0002 n*\u000b\u0012\u0005\u0012\u00030Ô\u0002\u0018\u00010-0-0\u001e8\u0006@\u0006¢\u0006\u000e\n\u0005\bÕ\u0002\u0010p\u001a\u0005\bÖ\u0002\u0010r¨\u0006Ú\u0002"}, d2 = {"Lcom/discord/stores/StoreGatewayConnection;", "Lcom/discord/gateway/GatewayEventHandler;", "", "voiceServerPing", "()V", "", "Lcom/discord/primitives/StreamKey;", "streamKey", "streamPing", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Lcom/discord/utilities/networking/NetworkMonitor;", "networkMonitor", "Lcom/discord/gateway/GatewaySocket;", "buildGatewaySocket", "(Landroid/content/Context;Lcom/discord/utilities/networking/NetworkMonitor;)Lcom/discord/gateway/GatewaySocket;", "Lcom/discord/gateway/GatewaySocket$IdentifyData;", "getIdentifyData", "()Lcom/discord/gateway/GatewaySocket$IdentifyData;", "Lcom/discord/stores/StoreGatewayConnection$ClientState;", "clientState", "handleClientStateUpdate", "(Lcom/discord/stores/StoreGatewayConnection$ClientState;)V", "Lkotlin/Function1;", "socketCallback", "", "requestIfSessionEstablished", "(Lkotlin/jvm/functions/Function1;)Z", ExifInterface.GPS_DIRECTION_TRUE, "Lrx/subjects/SerializedSubject;", "", "data", "onNext", "(Lrx/subjects/SerializedSubject;Ljava/lang/Object;)V", "init", "(Landroid/content/Context;Lcom/discord/utilities/networking/NetworkMonitor;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "callConnect", "(J)Z", "Lcom/discord/api/presence/ClientStatus;", "status", "since", "", "Lcom/discord/api/activity/Activity;", "activities", "afk", "presenceUpdate", "(Lcom/discord/api/presence/ClientStatus;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;)Z", "Lcom/discord/primitives/GuildId;", "guildId", "selfMute", "selfDeaf", "selfVideo", "preferredRegion", "shouldIncludePreferredRegion", "voiceStateUpdate", "(Ljava/lang/Long;Ljava/lang/Long;ZZZLjava/lang/String;Z)Z", "query", "Lcom/discord/primitives/UserId;", "userIds", "", "limit", "requestGuildMembers", "(JLjava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Z", "Lcom/discord/utilities/lazy/subscriptions/GuildSubscriptions;", "guildSubscriptions", "updateGuildSubscriptions", "(JLcom/discord/utilities/lazy/subscriptions/GuildSubscriptions;)Z", "nonce", "applications", "offset", "commandLimit", "commandIds", "requestApplicationCommands", "(JLjava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;ILjava/util/List;)Z", "Lkotlin/Pair;", "Lcom/discord/primitives/MessageId;", "threadMessagePairs", "requestForumUnreads", "(JJLjava/util/List;)Z", "simulateReconnectForTesting", "streamWatch", "streamCreate", "(Ljava/lang/String;Ljava/lang/String;)V", "streamDelete", "handlePreLogout", "Lcom/discord/rtcconnection/RtcConnection$StateChange;", "stateChange", "handleRtcConnectionStateChanged", "(Lcom/discord/rtcconnection/RtcConnection$StateChange;)V", "Lrx/Observable;", "getConnected", "()Lrx/Observable;", "getConnectionReady", "resetOnError", "()Lkotlin/Unit;", "connectionReady", "handleConnectionReady", "(Z)V", "connected", "handleConnected", "type", "handleDispatch", "(Ljava/lang/String;Ljava/lang/Object;)V", "authenticationFailed", "handleDisconnect", "Lcom/discord/api/channel/ChannelRecipient;", "kotlin.jvm.PlatformType", "channelRecipientAdd", "Lrx/subjects/SerializedSubject;", "getChannelRecipientAdd", "()Lrx/subjects/SerializedSubject;", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstanceDelete", "getStageInstanceDelete", "stageInstanceCreate", "getStageInstanceCreate", "Lcom/discord/models/domain/ModelUserRelationship;", "relationshipAdd", "getRelationshipAdd", "Lcom/discord/models/domain/ModelMessageDelete;", "messageDelete", "getMessageDelete", "Lrx/Scheduler;", "scheduler", "Lrx/Scheduler;", "Lcom/discord/models/domain/ModelNotificationSettings;", "userGuildSettingsUpdate", "getUserGuildSettingsUpdate", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "coroutineDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getCoroutineDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lcom/discord/api/thread/ThreadMembersUpdate;", "threadMembersUpdate", "getThreadMembersUpdate", "stageInstanceUpdate", "getStageInstanceUpdate", "Lcom/discord/models/domain/ModelGuildMemberListUpdate;", "guildMemberListUpdate", "getGuildMemberListUpdate", "Lcom/discord/api/message/Message;", "messageCreate", "getMessageCreate", "Lcom/discord/models/domain/ModelPayload;", "ready", "getReady", "Lcom/discord/api/user/User;", "userUpdate", "getUserUpdate", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEventCreate", "getGuildScheduledEventCreate", "Lcom/discord/api/interaction/InteractionStateUpdate;", "interactionFailure", "getInteractionFailure", "Lcom/discord/models/domain/StreamServerUpdate;", "streamServerUpdate", "getStreamServerUpdate", "Lcom/discord/api/message/reaction/MessageReactionUpdate;", "messageReactionRemoveEmoji", "getMessageReactionRemoveEmoji", "Lcom/discord/api/requiredaction/UserRequiredActionUpdate;", "userRequiredActionUpdate", "getUserRequiredActionUpdate", "Lcom/discord/api/guildmember/GuildMember;", "guildMembersAdd", "getGuildMembersAdd", "Lcom/discord/api/guildmember/GuildMemberRemove;", "guildMemberRemove", "getGuildMemberRemove", "Lcom/discord/api/voice/server/VoiceServer;", "voiceServerUpdate", "getVoiceServerUpdate", "messageReactionRemove", "getMessageReactionRemove", "Lcom/discord/stores/utilities/Batched;", "Lcom/discord/api/voice/state/VoiceState;", "Lcom/discord/stores/utilities/Batched;", "getVoiceStateUpdate", "()Lcom/discord/stores/utilities/Batched;", "messageUpdate", "getMessageUpdate", "Lcom/discord/api/channel/Channel;", "channelDeleted", "getChannelDeleted", "Lcom/discord/models/domain/ModelChannelUnreadUpdate;", "channelUnreadUpdate", "getChannelUnreadUpdate", "Lcom/discord/stores/utilities/BatchManager;", "batches", "Lcom/discord/stores/utilities/BatchManager;", "interactionSuccess", "getInteractionSuccess", "Lcom/discord/api/emoji/GuildEmojisUpdate;", "guildEmojisUpdate", "getGuildEmojisUpdate", "Lcom/discord/api/friendsuggestions/FriendSuggestionDelete;", "friendSuggestionDelete", "getFriendSuggestionDelete", "Lcom/discord/api/user/TypingUser;", "typingStart", "getTypingStart", "threadCreateOrUpdate", "getThreadCreateOrUpdate", "Lcom/discord/models/domain/ModelBan;", "guildBanRemove", "getGuildBanRemove", "messageReactionAdd", "getMessageReactionAdd", "channelCreateOrUpdate", "getChannelCreateOrUpdate", "Lcom/discord/api/forum/ForumUnreads;", "forumUnreads", "getForumUnreads", "Lcom/discord/api/guild/Guild;", "guildUpdate", "getGuildUpdate", "Lcom/discord/models/thread/dto/ModelThreadListSync;", "threadListSync", "getThreadListSync", "Lcom/discord/models/domain/StreamDelete;", "getStreamDelete", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventUserUpdate;", "guildScheduledEventUserRemove", "getGuildScheduledEventUserRemove", "Lcom/discord/api/commands/ApplicationCommandAutocompleteResult;", "applicationCommandAutocompleteResult", "getApplicationCommandAutocompleteResult", "guildScheduledEventUpdate", "getGuildScheduledEventUpdate", "Lcom/discord/api/thread/ThreadMemberUpdate;", "threadMemberUpdate", "getThreadMemberUpdate", "Lcom/discord/api/interaction/InteractionModalCreate;", "interactionModalCreate", "getInteractionModalCreate", "Lcom/discord/api/role/GuildRoleDelete;", "guildRoleDelete", "getGuildRoleDelete", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Lcom/discord/models/domain/ModelCall;", "callCreateOrUpdate", "getCallCreateOrUpdate", "userConnectionUpdate", "getUserConnectionUpdate", "guildBanAdd", "getGuildBanAdd", "socket", "Lcom/discord/gateway/GatewaySocket;", "Lcom/discord/models/domain/ModelReadState;", "messageAck", "getMessageAck", "guildDeleted", "getGuildDeleted", "Lcom/discord/stores/StoreGatewayConnection$ClientState;", "Lcom/discord/api/friendsuggestions/FriendSuggestion;", "friendSuggestionCreate", "getFriendSuggestionCreate", "Ljava/util/concurrent/ExecutorService;", "executor", "Ljava/util/concurrent/ExecutorService;", "Lcom/discord/utilities/logging/AppGatewaySocketLogger;", "gatewaySocketLogger", "Lcom/discord/utilities/logging/AppGatewaySocketLogger;", "messageReactionRemoveAll", "getMessageReactionRemoveAll", "channelRecipientRemove", "getChannelRecipientRemove", "userSubscriptionsUpdate", "getUserSubscriptionsUpdate", "Lcom/discord/api/guildmember/GuildMembersChunk;", "guildMembersChunk", "getGuildMembersChunk", "interactionCreate", "getInteractionCreate", "callDelete", "getCallDelete", "Lcom/discord/api/presence/Presence;", "presenceReplace", "getPresenceReplace", "relationshipRemove", "getRelationshipRemove", "Lcom/discord/api/guildjoinrequest/GuildJoinRequestCreateOrUpdate;", "guildJoinRequestCreateOrUpdate", "getGuildJoinRequestCreateOrUpdate", "Lcom/discord/models/domain/StreamCreateOrUpdate;", "streamUpdate", "getStreamUpdate", "Lcom/discord/api/sticker/GuildStickersUpdate;", "guildStickersUpdate", "getGuildStickersUpdate", "Lcom/discord/api/guildjoinrequest/GuildJoinRequestDelete;", "guildJoinRequestDelete", "getGuildJoinRequestDelete", "Lcom/discord/models/domain/ModelUserNote$Update;", "userNoteUpdate", "getUserNoteUpdate", "Lcom/discord/api/thread/ThreadMemberListUpdate;", "threadMemberListUpdate", "getThreadMemberListUpdate", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "getStreamCreate", "threadDelete", "getThreadDelete", "guildScheduledEventUserAdd", "getGuildScheduledEventUserAdd", "guildScheduledEventDelete", "getGuildScheduledEventDelete", "userPaymentSourcesUpdate", "getUserPaymentSourcesUpdate", "Lcom/discord/models/domain/ModelGuildIntegration$Update;", "guildIntegrationsUpdate", "getGuildIntegrationsUpdate", "Lcom/discord/api/role/GuildRoleUpdate;", "guildRoleUpdate", "getGuildRoleUpdate", "Lcom/discord/api/role/GuildRoleCreate;", "guildRoleCreate", "getGuildRoleCreate", "guildCreate", "getGuildCreate", "Lcom/discord/api/embeddedactivities/EmbeddedActivityInboundUpdate;", "embeddedActivityInboundUpdate", "getEmbeddedActivityInboundUpdate", "Lcom/discord/api/commands/GuildApplicationCommands;", "guildApplicationCommands", "getGuildApplicationCommands", "Lcom/discord/models/domain/ModelUserSettings;", "userSettingsUpdate", "getUserSettingsUpdate", "getPresenceUpdate", "Lcom/discord/models/domain/ModelSession;", "sessionsReplace", "getSessionsReplace", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/utilities/time/Clock;Ljava/util/concurrent/ExecutorService;Lrx/Scheduler;Lcom/discord/utilities/logging/AppGatewaySocketLogger;)V", "ClientState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGatewayConnection implements GatewayEventHandler {
    private final SerializedSubject<ApplicationCommandAutocompleteResult, ApplicationCommandAutocompleteResult> applicationCommandAutocompleteResult;
    private final BatchManager batches;
    private final SerializedSubject<ModelCall, ModelCall> callCreateOrUpdate;
    private final SerializedSubject<ModelCall, ModelCall> callDelete;
    private final SerializedSubject<Channel, Channel> channelCreateOrUpdate;
    private final SerializedSubject<Channel, Channel> channelDeleted;
    private final SerializedSubject<ChannelRecipient, ChannelRecipient> channelRecipientAdd;
    private final SerializedSubject<ChannelRecipient, ChannelRecipient> channelRecipientRemove;
    private final SerializedSubject<ModelChannelUnreadUpdate, ModelChannelUnreadUpdate> channelUnreadUpdate;
    private ClientState clientState;
    private final Clock clock;
    private final SerializedSubject<Boolean, Boolean> connected;
    private final SerializedSubject<Boolean, Boolean> connectionReady;
    private final Executors coroutineDispatcher;
    private final SerializedSubject<EmbeddedActivityInboundUpdate, EmbeddedActivityInboundUpdate> embeddedActivityInboundUpdate;
    private final ExecutorService executor;
    private final SerializedSubject<ForumUnreads, ForumUnreads> forumUnreads;
    private final SerializedSubject<FriendSuggestion, FriendSuggestion> friendSuggestionCreate;
    private final SerializedSubject<FriendSuggestionDelete, FriendSuggestionDelete> friendSuggestionDelete;
    private final AppGatewaySocketLogger gatewaySocketLogger;
    private final SerializedSubject<GuildApplicationCommands, GuildApplicationCommands> guildApplicationCommands;
    private final SerializedSubject<ModelBan, ModelBan> guildBanAdd;
    private final SerializedSubject<ModelBan, ModelBan> guildBanRemove;
    private final SerializedSubject<Guild, Guild> guildCreate;
    private final SerializedSubject<Guild, Guild> guildDeleted;
    private final SerializedSubject<GuildEmojisUpdate, GuildEmojisUpdate> guildEmojisUpdate;
    private final SerializedSubject<ModelGuildIntegration.Update, ModelGuildIntegration.Update> guildIntegrationsUpdate;
    private final SerializedSubject<GuildJoinRequest2, GuildJoinRequest2> guildJoinRequestCreateOrUpdate;
    private final SerializedSubject<GuildJoinRequest3, GuildJoinRequest3> guildJoinRequestDelete;
    private final SerializedSubject<ModelGuildMemberListUpdate, ModelGuildMemberListUpdate> guildMemberListUpdate;
    private final SerializedSubject<GuildMemberRemove, GuildMemberRemove> guildMemberRemove;
    private final SerializedSubject<GuildMember, GuildMember> guildMembersAdd;
    private final SerializedSubject<GuildMembersChunk, GuildMembersChunk> guildMembersChunk;
    private final SerializedSubject<GuildRoleCreate, GuildRoleCreate> guildRoleCreate;
    private final SerializedSubject<GuildRoleDelete, GuildRoleDelete> guildRoleDelete;
    private final SerializedSubject<GuildRoleUpdate, GuildRoleUpdate> guildRoleUpdate;
    private final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> guildScheduledEventCreate;
    private final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> guildScheduledEventDelete;
    private final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> guildScheduledEventUpdate;
    private final SerializedSubject<GuildScheduledEventUserUpdate, GuildScheduledEventUserUpdate> guildScheduledEventUserAdd;
    private final SerializedSubject<GuildScheduledEventUserUpdate, GuildScheduledEventUserUpdate> guildScheduledEventUserRemove;
    private final SerializedSubject<GuildStickersUpdate, GuildStickersUpdate> guildStickersUpdate;
    private final SerializedSubject<Guild, Guild> guildUpdate;
    private final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> interactionCreate;
    private final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> interactionFailure;
    private final SerializedSubject<InteractionModalCreate, InteractionModalCreate> interactionModalCreate;
    private final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> interactionSuccess;
    private final SerializedSubject<ModelReadState, ModelReadState> messageAck;
    private final SerializedSubject<Message, Message> messageCreate;
    private final SerializedSubject<ModelMessageDelete, ModelMessageDelete> messageDelete;
    private final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> messageReactionAdd;
    private final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> messageReactionRemove;
    private final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> messageReactionRemoveAll;
    private final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> messageReactionRemoveEmoji;
    private final SerializedSubject<Message, Message> messageUpdate;
    private final SerializedSubject<List<Presence>, List<Presence>> presenceReplace;
    private final SerializedSubject<Presence, Presence> presenceUpdate;
    private final SerializedSubject<ModelPayload, ModelPayload> ready;
    private final SerializedSubject<ModelUserRelationship, ModelUserRelationship> relationshipAdd;
    private final SerializedSubject<ModelUserRelationship, ModelUserRelationship> relationshipRemove;
    private final Scheduler scheduler;
    private final SerializedSubject<List<ModelSession>, List<ModelSession>> sessionsReplace;
    private GatewaySocket socket;
    private final SerializedSubject<StageInstance, StageInstance> stageInstanceCreate;
    private final SerializedSubject<StageInstance, StageInstance> stageInstanceDelete;
    private final SerializedSubject<StageInstance, StageInstance> stageInstanceUpdate;
    private final StoreStream stream;
    private final SerializedSubject<ModelApplicationStream3, ModelApplicationStream3> streamCreate;
    private final SerializedSubject<ModelApplicationStream5, ModelApplicationStream5> streamDelete;
    private final SerializedSubject<ModelApplicationStream7, ModelApplicationStream7> streamServerUpdate;
    private final SerializedSubject<ModelApplicationStream3, ModelApplicationStream3> streamUpdate;
    private final SerializedSubject<Channel, Channel> threadCreateOrUpdate;
    private final SerializedSubject<Channel, Channel> threadDelete;
    private final SerializedSubject<ModelThreadListSync, ModelThreadListSync> threadListSync;
    private final SerializedSubject<ThreadMemberListUpdate, ThreadMemberListUpdate> threadMemberListUpdate;
    private final SerializedSubject<ThreadMemberUpdate, ThreadMemberUpdate> threadMemberUpdate;
    private final SerializedSubject<ThreadMembersUpdate, ThreadMembersUpdate> threadMembersUpdate;
    private final SerializedSubject<TypingUser, TypingUser> typingStart;
    private final SerializedSubject<Unit, Unit> userConnectionUpdate;
    private final SerializedSubject<ModelNotificationSettings, ModelNotificationSettings> userGuildSettingsUpdate;
    private final SerializedSubject<ModelUserNote.Update, ModelUserNote.Update> userNoteUpdate;
    private final SerializedSubject<Unit, Unit> userPaymentSourcesUpdate;
    private final SerializedSubject<UserRequiredActionUpdate, UserRequiredActionUpdate> userRequiredActionUpdate;
    private final SerializedSubject<ModelUserSettings, ModelUserSettings> userSettingsUpdate;
    private final SerializedSubject<Unit, Unit> userSubscriptionsUpdate;
    private final SerializedSubject<User, User> userUpdate;
    private final SerializedSubject<VoiceServer, VoiceServer> voiceServerUpdate;
    private final Batched<VoiceState> voiceStateUpdate;

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\b\u0082\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B!\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ0\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006#"}, d2 = {"Lcom/discord/stores/StoreGatewayConnection$ClientState;", "", "Lcom/discord/gateway/GatewaySocket$IdentifyData;", "getIdentifyData", "()Lcom/discord/gateway/GatewaySocket$IdentifyData;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "Lcom/discord/stores/StoreClientDataState$ClientDataState;", "component3", "()Lcom/discord/stores/StoreClientDataState$ClientDataState;", "tokenIfAvailable", "authed", "clientDataState", "copy", "(Ljava/lang/String;ZLcom/discord/stores/StoreClientDataState$ClientDataState;)Lcom/discord/stores/StoreGatewayConnection$ClientState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreClientDataState$ClientDataState;", "getClientDataState", "Z", "getAuthed", "Ljava/lang/String;", "getTokenIfAvailable", "<init>", "(Ljava/lang/String;ZLcom/discord/stores/StoreClientDataState$ClientDataState;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ClientState {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean authed;
        private final StoreClientDataState.ClientDataState clientDataState;
        private final String tokenIfAvailable;

        /* compiled from: StoreGatewayConnection.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J=\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/stores/StoreGatewayConnection$ClientState$Companion;", "", "", "backgrounded", "", "token", "", "Lcom/discord/primitives/ChannelId;", "selectedVoiceChannelId", "hasGatewayConnectionConsumers", "Lcom/discord/stores/StoreClientDataState$ClientDataState;", "clientDataState", "Lcom/discord/stores/StoreGatewayConnection$ClientState;", "create", "(ZLjava/lang/String;JZLcom/discord/stores/StoreClientDataState$ClientDataState;)Lcom/discord/stores/StoreGatewayConnection$ClientState;", "Lcom/discord/stores/StoreStream;", "stream", "Lrx/Scheduler;", "scheduler", "Lkotlin/Function1;", "", "callback", "initialize", "(Lcom/discord/stores/StoreStream;Lrx/Scheduler;Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ ClientState access$create(Companion companion, boolean z2, String str, long j, boolean z3, StoreClientDataState.ClientDataState clientDataState) {
                return companion.create(z2, str, j, z3, clientDataState);
            }

            private final ClientState create(boolean backgrounded, String token, long selectedVoiceChannelId, boolean hasGatewayConnectionConsumers, StoreClientDataState.ClientDataState clientDataState) {
                boolean z2 = token != null;
                if (backgrounded && selectedVoiceChannelId <= 0 && !hasGatewayConnectionConsumers) {
                    token = null;
                }
                return new ClientState(token, z2, clientDataState);
            }

            public final void initialize(StoreStream stream, Scheduler scheduler, Function1<? super ClientState, Unit> callback) {
                Intrinsics3.checkNotNullParameter(stream, "stream");
                Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
                Intrinsics3.checkNotNullParameter(callback, "callback");
                Observable<Boolean> observableA = Backgrounded4.d.a();
                Observable<String> authedToken$app_productionGoogleRelease = stream.getAuthentication().getAuthedToken$app_productionGoogleRelease();
                Observable<Long> observableObserveSelectedVoiceChannelId = stream.getVoiceChannelSelected().observeSelectedVoiceChannelId();
                AppState2 appState2 = AppState2.c;
                Observable observableR = AppState2.f59b.G(AppState.j).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "numGatewayConnectionCons…  .distinctUntilChanged()");
                Observable observableG = Observable.g(observableA, authedToken$app_productionGoogleRelease, observableObserveSelectedVoiceChannelId, observableR, stream.getClientDataState().observeClientState(), new StoreGatewayConnection6(new StoreGatewayConnection2(this)));
                Intrinsics3.checkNotNullExpressionValue(observableG, "Observable\n            .…   ::create\n            )");
                Observable observableJ = ObservableExtensionsKt.computationLatest(observableG).J(scheduler);
                Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n            .…    .observeOn(scheduler)");
                ObservableExtensionsKt.appSubscribe$default(observableJ, (Context) null, "clientState", (Function1) null, callback, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ClientState(String str, boolean z2, StoreClientDataState.ClientDataState clientDataState) {
            Intrinsics3.checkNotNullParameter(clientDataState, "clientDataState");
            this.tokenIfAvailable = str;
            this.authed = z2;
            this.clientDataState = clientDataState;
        }

        public static /* synthetic */ ClientState copy$default(ClientState clientState, String str, boolean z2, StoreClientDataState.ClientDataState clientDataState, int i, Object obj) {
            if ((i & 1) != 0) {
                str = clientState.tokenIfAvailable;
            }
            if ((i & 2) != 0) {
                z2 = clientState.authed;
            }
            if ((i & 4) != 0) {
                clientDataState = clientState.clientDataState;
            }
            return clientState.copy(str, z2, clientDataState);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTokenIfAvailable() {
            return this.tokenIfAvailable;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAuthed() {
            return this.authed;
        }

        /* renamed from: component3, reason: from getter */
        public final StoreClientDataState.ClientDataState getClientDataState() {
            return this.clientDataState;
        }

        public final ClientState copy(String tokenIfAvailable, boolean authed, StoreClientDataState.ClientDataState clientDataState) {
            Intrinsics3.checkNotNullParameter(clientDataState, "clientDataState");
            return new ClientState(tokenIfAvailable, authed, clientDataState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClientState)) {
                return false;
            }
            ClientState clientState = (ClientState) other;
            return Intrinsics3.areEqual(this.tokenIfAvailable, clientState.tokenIfAvailable) && this.authed == clientState.authed && Intrinsics3.areEqual(this.clientDataState, clientState.clientDataState);
        }

        public final boolean getAuthed() {
            return this.authed;
        }

        public final StoreClientDataState.ClientDataState getClientDataState() {
            return this.clientDataState;
        }

        public final GatewaySocket.IdentifyData getIdentifyData() {
            String str = this.tokenIfAvailable;
            if (str != null) {
                return new GatewaySocket.IdentifyData(str, this.clientDataState.toIdentifyData());
            }
            return null;
        }

        public final String getTokenIfAvailable() {
            return this.tokenIfAvailable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.tokenIfAvailable;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.authed;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            StoreClientDataState.ClientDataState clientDataState = this.clientDataState;
            return i2 + (clientDataState != null ? clientDataState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ClientState(tokenIfAvailable=");
            sbU.append(this.tokenIfAvailable);
            sbU.append(", authed=");
            sbU.append(this.authed);
            sbU.append(", clientDataState=");
            sbU.append(this.clientDataState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$callConnect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.callConnect(this.$channelId);
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreGatewayConnection$ClientState;", "it", "", "invoke", "(Lcom/discord/stores/StoreGatewayConnection$ClientState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ClientState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClientState clientState) {
            invoke2(clientState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClientState clientState) {
            Intrinsics3.checkNotNullParameter(clientState, "it");
            StoreGatewayConnection.access$handleClientStateUpdate(StoreGatewayConnection.this, clientState);
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$presenceUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ List $activities;
        public final /* synthetic */ Boolean $afk;
        public final /* synthetic */ Long $since;
        public final /* synthetic */ ClientStatus $status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ClientStatus clientStatus, Long l, List list, Boolean bool) {
            super(1);
            this.$status = clientStatus;
            this.$since = l;
            this.$activities = list;
            this.$afk = bool;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.presenceUpdate(this.$status, this.$since, this.$activities, this.$afk);
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$requestApplicationCommands$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ boolean $applications;
        public final /* synthetic */ List $commandIds;
        public final /* synthetic */ int $commandLimit;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ String $nonce;
        public final /* synthetic */ Integer $offset;
        public final /* synthetic */ String $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, String str, boolean z2, Integer num, String str2, int i, List list) {
            super(1);
            this.$guildId = j;
            this.$nonce = str;
            this.$applications = z2;
            this.$offset = num;
            this.$query = str2;
            this.$commandLimit = i;
            this.$commandIds = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "it");
            long j = this.$guildId;
            String str = this.$nonce;
            boolean z2 = this.$applications;
            gatewaySocket.requestApplicationCommands(new Outgoing2.ApplicationCommandRequest(j, this.$query, this.$offset, Integer.valueOf(this.$commandLimit), z2, str, this.$commandIds));
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$requestForumUnreads$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ List $threadMessagePairs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, List list) {
            super(1);
            this.$guildId = j;
            this.$channelId = j2;
            this.$threadMessagePairs = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "it");
            long j = this.$guildId;
            long j2 = this.$channelId;
            List<Tuples2> list = this.$threadMessagePairs;
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (Tuples2 tuples2 : list) {
                arrayList.add(new Outgoing2.ForumUnreadsRequestThread(((Number) tuples2.component1()).longValue(), ((Number) tuples2.component2()).longValue()));
            }
            gatewaySocket.requestForumUnreads(new Outgoing2.ForumUnreadsRequest(j, j2, arrayList));
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$requestGuildMembers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Integer $limit;
        public final /* synthetic */ String $query;
        public final /* synthetic */ List $userIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, String str, List list, Integer num) {
            super(1);
            this.$guildId = j;
            this.$query = str;
            this.$userIds = list;
            this.$limit = num;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.requestGuildMembers(CollectionsJVM.listOf(Long.valueOf(this.$guildId)), this.$query, this.$userIds, this.$limit);
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "gatewaySocket", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$streamCreate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ ModelApplicationStream $newStream;
        public final /* synthetic */ String $preferredRegion;
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, ModelApplicationStream modelApplicationStream, String str2) {
            super(1);
            this.$streamKey = str;
            this.$newStream = modelApplicationStream;
            this.$preferredRegion = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            String activeApplicationStreamKeyInternal$app_productionGoogleRelease = StoreGatewayConnection.access$getStream$p(StoreGatewayConnection.this).getApplicationStreaming().getActiveApplicationStreamKeyInternal$app_productionGoogleRelease();
            if (activeApplicationStreamKeyInternal$app_productionGoogleRelease != null && (!Intrinsics3.areEqual(activeApplicationStreamKeyInternal$app_productionGoogleRelease, this.$streamKey))) {
                StoreGatewayConnection.this.streamDelete(activeApplicationStreamKeyInternal$app_productionGoogleRelease);
            }
            ModelApplicationStream modelApplicationStream = this.$newStream;
            gatewaySocket.streamCreate(this.$newStream.getType(), this.$newStream.getChannelId(), modelApplicationStream instanceof ModelApplicationStream.GuildStream ? Long.valueOf(((ModelApplicationStream.GuildStream) modelApplicationStream).getGuildId()) : null, this.$preferredRegion);
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$streamDelete$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.streamDelete(this.$streamKey);
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$streamPing$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.streamPing(this.$streamKey);
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$streamWatch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "it");
            String activeApplicationStreamKeyInternal$app_productionGoogleRelease = StoreGatewayConnection.access$getStream$p(StoreGatewayConnection.this).getApplicationStreaming().getActiveApplicationStreamKeyInternal$app_productionGoogleRelease();
            if (activeApplicationStreamKeyInternal$app_productionGoogleRelease != null && (!Intrinsics3.areEqual(activeApplicationStreamKeyInternal$app_productionGoogleRelease, this.$streamKey))) {
                StoreGatewayConnection.this.streamDelete(activeApplicationStreamKeyInternal$app_productionGoogleRelease);
            }
            gatewaySocket.streamWatch(this.$streamKey);
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$updateGuildSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Outgoing2.GuildSubscriptions $payload;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Outgoing2.GuildSubscriptions guildSubscriptions) {
            super(1);
            this.$guildId = j;
            this.$payload = guildSubscriptions;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.updateGuildSubscriptions(this.$guildId, this.$payload);
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$voiceServerPing$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.voiceServerPing();
        }
    }

    /* compiled from: StoreGatewayConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/gateway/GatewaySocket;", "it", "", "invoke", "(Lcom/discord/gateway/GatewaySocket;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGatewayConnection$voiceStateUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ String $preferredRegion;
        public final /* synthetic */ boolean $selfDeaf;
        public final /* synthetic */ boolean $selfMute;
        public final /* synthetic */ boolean $selfVideo;
        public final /* synthetic */ boolean $shouldIncludePreferredRegion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, Long l2, boolean z2, boolean z3, boolean z4, String str, boolean z5) {
            super(1);
            this.$guildId = l;
            this.$channelId = l2;
            this.$selfMute = z2;
            this.$selfDeaf = z3;
            this.$selfVideo = z4;
            this.$preferredRegion = str;
            this.$shouldIncludePreferredRegion = z5;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.voiceStateUpdate(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo, this.$preferredRegion, this.$shouldIncludePreferredRegion);
        }
    }

    public StoreGatewayConnection(StoreStream storeStream, Clock clock, AppGatewaySocketLogger appGatewaySocketLogger) {
        this(storeStream, clock, null, null, appGatewaySocketLogger, 12, null);
    }

    public StoreGatewayConnection(StoreStream storeStream, Clock clock, ExecutorService executorService, AppGatewaySocketLogger appGatewaySocketLogger) {
        this(storeStream, clock, executorService, null, appGatewaySocketLogger, 8, null);
    }

    public StoreGatewayConnection(StoreStream storeStream, Clock clock, ExecutorService executorService, Scheduler scheduler, AppGatewaySocketLogger appGatewaySocketLogger) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(executorService, "executor");
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics3.checkNotNullParameter(appGatewaySocketLogger, "gatewaySocketLogger");
        this.stream = storeStream;
        this.clock = clock;
        this.executor = executorService;
        this.scheduler = scheduler;
        this.gatewaySocketLogger = appGatewaySocketLogger;
        Executors6 executors6 = new Executors6(executorService);
        this.coroutineDispatcher = executors6;
        BatchManager batchManager = new BatchManager(executors6, null, 2, null);
        this.batches = batchManager;
        Boolean bool = Boolean.FALSE;
        this.connected = new SerializedSubject<>(BehaviorSubject.l0(bool));
        this.connectionReady = new SerializedSubject<>(BehaviorSubject.l0(bool));
        this.callCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.callDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.channelCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.channelDeleted = new SerializedSubject<>(BehaviorSubject.k0());
        this.channelRecipientAdd = new SerializedSubject<>(BehaviorSubject.k0());
        this.channelRecipientRemove = new SerializedSubject<>(BehaviorSubject.k0());
        this.channelUnreadUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.embeddedActivityInboundUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildApplicationCommands = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildBanAdd = new SerializedSubject<>(PublishSubject.k0());
        this.guildBanRemove = new SerializedSubject<>(PublishSubject.k0());
        this.guildCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildEmojisUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildStickersUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildDeleted = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildMembersAdd = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildMembersChunk = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildMemberRemove = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildJoinRequestCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildJoinRequestDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildRoleCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildRoleUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildRoleDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildIntegrationsUpdate = new SerializedSubject<>(PublishSubject.k0());
        this.messageAck = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageReactionAdd = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageReactionRemove = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageReactionRemoveEmoji = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageReactionRemoveAll = new SerializedSubject<>(BehaviorSubject.k0());
        this.presenceUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.presenceReplace = new SerializedSubject<>(BehaviorSubject.k0());
        this.ready = new SerializedSubject<>(BehaviorSubject.k0());
        this.relationshipAdd = new SerializedSubject<>(BehaviorSubject.k0());
        this.relationshipRemove = new SerializedSubject<>(BehaviorSubject.k0());
        this.typingStart = new SerializedSubject<>(BehaviorSubject.k0());
        this.userConnectionUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userSettingsUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userGuildSettingsUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userNoteUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userRequiredActionUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.sessionsReplace = new SerializedSubject<>(BehaviorSubject.k0());
        this.voiceStateUpdate = BatchManager.createBatched$default(batchManager, "VOICE_STATE_UPDATE", 0L, 0L, 6, null);
        this.voiceServerUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildMemberListUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userPaymentSourcesUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userSubscriptionsUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.streamCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.streamUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.streamServerUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.streamDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadListSync = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadMemberUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadMembersUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadMemberListUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.interactionCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.interactionSuccess = new SerializedSubject<>(BehaviorSubject.k0());
        this.interactionFailure = new SerializedSubject<>(BehaviorSubject.k0());
        this.interactionModalCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.applicationCommandAutocompleteResult = new SerializedSubject<>(BehaviorSubject.k0());
        this.stageInstanceCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.stageInstanceUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.stageInstanceDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.friendSuggestionCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.friendSuggestionDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildScheduledEventCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildScheduledEventUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildScheduledEventDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildScheduledEventUserAdd = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildScheduledEventUserRemove = new SerializedSubject<>(BehaviorSubject.k0());
        this.forumUnreads = new SerializedSubject<>(BehaviorSubject.k0());
    }

    public static final /* synthetic */ GatewaySocket.IdentifyData access$getIdentifyData(StoreGatewayConnection storeGatewayConnection) {
        return storeGatewayConnection.getIdentifyData();
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreGatewayConnection storeGatewayConnection) {
        return storeGatewayConnection.stream;
    }

    public static final /* synthetic */ void access$handleClientStateUpdate(StoreGatewayConnection storeGatewayConnection, ClientState clientState) {
        storeGatewayConnection.handleClientStateUpdate(clientState);
    }

    private final GatewaySocket buildGatewaySocket(Context context, NetworkMonitor networkMonitor) {
        RestAPI.Companion companion = RestAPI.INSTANCE;
        List listListOf = Collections2.listOf((Object[]) new Interceptor[]{companion.buildAnalyticsInterceptor(), companion.buildLoggingInterceptor()});
        App.Companion aVar = App.INSTANCE;
        Objects.requireNonNull(aVar);
        SSLSocketFactory sSLSocketFactoryCreateSocketFactory$default = App.access$getIS_LOCAL$cp() ? null : SecureSocketsLayerUtils.createSocketFactory$default(null, 1, null);
        Objects.requireNonNull(aVar);
        GatewaySocket gatewaySocket = new GatewaySocket(new StoreGatewayConnection4(this), StoreGatewayConnection5.INSTANCE, this, this.scheduler, AppLog.g, networkMonitor, new RestConfig(BuildConfig.HOST_API, RestAPI.AppHeadersProvider.INSTANCE, listListOf), context, App.access$getIS_LOCAL$cp() ? StoreGatewayConnection3.INSTANCE : null, sSLSocketFactoryCreateSocketFactory$default, AnalyticSuperProperties.INSTANCE.getSuperProperties(), this.gatewaySocketLogger);
        this.stream.getConnectionTimeStats().addListener(gatewaySocket);
        return gatewaySocket;
    }

    private final GatewaySocket.IdentifyData getIdentifyData() {
        ClientState clientState = this.clientState;
        if (clientState != null) {
            return clientState.getIdentifyData();
        }
        return null;
    }

    private final void handleClientStateUpdate(ClientState clientState) {
        this.clientState = clientState;
        if (clientState.getTokenIfAvailable() != null) {
            GatewaySocket gatewaySocket = this.socket;
            if (gatewaySocket != null) {
                gatewaySocket.connect();
                return;
            }
            return;
        }
        GatewaySocket gatewaySocket2 = this.socket;
        if (gatewaySocket2 != null) {
            gatewaySocket2.close(!clientState.getAuthed());
        }
    }

    private final <T> void onNext(SerializedSubject<T, T> serializedSubject, Object obj) {
        serializedSubject.k.onNext(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean presenceUpdate$default(StoreGatewayConnection storeGatewayConnection, ClientStatus clientStatus, Long l, List list, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            l = Long.valueOf(storeGatewayConnection.clock.currentTimeMillis());
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        return storeGatewayConnection.presenceUpdate(clientStatus, l, list, bool);
    }

    public static /* synthetic */ boolean requestApplicationCommands$default(StoreGatewayConnection storeGatewayConnection, long j, String str, boolean z2, String str2, Integer num, int i, List list, int i2, Object obj) {
        return storeGatewayConnection.requestApplicationCommands(j, str, z2, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : num, i, (i2 & 64) != 0 ? null : list);
    }

    public static /* synthetic */ boolean requestGuildMembers$default(StoreGatewayConnection storeGatewayConnection, long j, String str, List list, Integer num, int i, Object obj) {
        String str2 = (i & 2) != 0 ? null : str;
        List list2 = (i & 4) != 0 ? null : list;
        if ((i & 8) != 0) {
            num = 100;
        }
        return storeGatewayConnection.requestGuildMembers(j, str2, list2, num);
    }

    private final boolean requestIfSessionEstablished(Function1<? super GatewaySocket, Unit> socketCallback) {
        GatewaySocket gatewaySocket = this.socket;
        if (gatewaySocket == null) {
            return false;
        }
        boolean zIsSessionEstablished = gatewaySocket.isSessionEstablished();
        if (zIsSessionEstablished) {
            socketCallback.invoke(gatewaySocket);
        }
        return zIsSessionEstablished;
    }

    private final void streamPing(String streamKey) {
        requestIfSessionEstablished(new AnonymousClass1(streamKey));
    }

    private final void voiceServerPing() {
        requestIfSessionEstablished(AnonymousClass1.INSTANCE);
    }

    public static /* synthetic */ boolean voiceStateUpdate$default(StoreGatewayConnection storeGatewayConnection, Long l, Long l2, boolean z2, boolean z3, boolean z4, String str, boolean z5, int i, Object obj) {
        return storeGatewayConnection.voiceStateUpdate(l, l2, z2, z3, z4, (i & 32) != 0 ? null : str, (i & 64) != 0 ? true : z5);
    }

    public final boolean callConnect(long channelId) {
        return requestIfSessionEstablished(new AnonymousClass1(channelId));
    }

    public final SerializedSubject<ApplicationCommandAutocompleteResult, ApplicationCommandAutocompleteResult> getApplicationCommandAutocompleteResult() {
        return this.applicationCommandAutocompleteResult;
    }

    public final SerializedSubject<ModelCall, ModelCall> getCallCreateOrUpdate() {
        return this.callCreateOrUpdate;
    }

    public final SerializedSubject<ModelCall, ModelCall> getCallDelete() {
        return this.callDelete;
    }

    public final SerializedSubject<Channel, Channel> getChannelCreateOrUpdate() {
        return this.channelCreateOrUpdate;
    }

    public final SerializedSubject<Channel, Channel> getChannelDeleted() {
        return this.channelDeleted;
    }

    public final SerializedSubject<ChannelRecipient, ChannelRecipient> getChannelRecipientAdd() {
        return this.channelRecipientAdd;
    }

    public final SerializedSubject<ChannelRecipient, ChannelRecipient> getChannelRecipientRemove() {
        return this.channelRecipientRemove;
    }

    public final SerializedSubject<ModelChannelUnreadUpdate, ModelChannelUnreadUpdate> getChannelUnreadUpdate() {
        return this.channelUnreadUpdate;
    }

    public final Observable<Boolean> getConnected() {
        Observable<Boolean> observableR = this.connected.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "connected.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> getConnectionReady() {
        Observable<Boolean> observableR = this.connectionReady.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "connectionReady.distinctUntilChanged()");
        return observableR;
    }

    public final Executors getCoroutineDispatcher() {
        return this.coroutineDispatcher;
    }

    public final SerializedSubject<EmbeddedActivityInboundUpdate, EmbeddedActivityInboundUpdate> getEmbeddedActivityInboundUpdate() {
        return this.embeddedActivityInboundUpdate;
    }

    public final SerializedSubject<ForumUnreads, ForumUnreads> getForumUnreads() {
        return this.forumUnreads;
    }

    public final SerializedSubject<FriendSuggestion, FriendSuggestion> getFriendSuggestionCreate() {
        return this.friendSuggestionCreate;
    }

    public final SerializedSubject<FriendSuggestionDelete, FriendSuggestionDelete> getFriendSuggestionDelete() {
        return this.friendSuggestionDelete;
    }

    public final SerializedSubject<GuildApplicationCommands, GuildApplicationCommands> getGuildApplicationCommands() {
        return this.guildApplicationCommands;
    }

    public final SerializedSubject<ModelBan, ModelBan> getGuildBanAdd() {
        return this.guildBanAdd;
    }

    public final SerializedSubject<ModelBan, ModelBan> getGuildBanRemove() {
        return this.guildBanRemove;
    }

    public final SerializedSubject<Guild, Guild> getGuildCreate() {
        return this.guildCreate;
    }

    public final SerializedSubject<Guild, Guild> getGuildDeleted() {
        return this.guildDeleted;
    }

    public final SerializedSubject<GuildEmojisUpdate, GuildEmojisUpdate> getGuildEmojisUpdate() {
        return this.guildEmojisUpdate;
    }

    public final SerializedSubject<ModelGuildIntegration.Update, ModelGuildIntegration.Update> getGuildIntegrationsUpdate() {
        return this.guildIntegrationsUpdate;
    }

    public final SerializedSubject<GuildJoinRequest2, GuildJoinRequest2> getGuildJoinRequestCreateOrUpdate() {
        return this.guildJoinRequestCreateOrUpdate;
    }

    public final SerializedSubject<GuildJoinRequest3, GuildJoinRequest3> getGuildJoinRequestDelete() {
        return this.guildJoinRequestDelete;
    }

    public final SerializedSubject<ModelGuildMemberListUpdate, ModelGuildMemberListUpdate> getGuildMemberListUpdate() {
        return this.guildMemberListUpdate;
    }

    public final SerializedSubject<GuildMemberRemove, GuildMemberRemove> getGuildMemberRemove() {
        return this.guildMemberRemove;
    }

    public final SerializedSubject<GuildMember, GuildMember> getGuildMembersAdd() {
        return this.guildMembersAdd;
    }

    public final SerializedSubject<GuildMembersChunk, GuildMembersChunk> getGuildMembersChunk() {
        return this.guildMembersChunk;
    }

    public final SerializedSubject<GuildRoleCreate, GuildRoleCreate> getGuildRoleCreate() {
        return this.guildRoleCreate;
    }

    public final SerializedSubject<GuildRoleDelete, GuildRoleDelete> getGuildRoleDelete() {
        return this.guildRoleDelete;
    }

    public final SerializedSubject<GuildRoleUpdate, GuildRoleUpdate> getGuildRoleUpdate() {
        return this.guildRoleUpdate;
    }

    public final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> getGuildScheduledEventCreate() {
        return this.guildScheduledEventCreate;
    }

    public final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> getGuildScheduledEventDelete() {
        return this.guildScheduledEventDelete;
    }

    public final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> getGuildScheduledEventUpdate() {
        return this.guildScheduledEventUpdate;
    }

    public final SerializedSubject<GuildScheduledEventUserUpdate, GuildScheduledEventUserUpdate> getGuildScheduledEventUserAdd() {
        return this.guildScheduledEventUserAdd;
    }

    public final SerializedSubject<GuildScheduledEventUserUpdate, GuildScheduledEventUserUpdate> getGuildScheduledEventUserRemove() {
        return this.guildScheduledEventUserRemove;
    }

    public final SerializedSubject<GuildStickersUpdate, GuildStickersUpdate> getGuildStickersUpdate() {
        return this.guildStickersUpdate;
    }

    public final SerializedSubject<Guild, Guild> getGuildUpdate() {
        return this.guildUpdate;
    }

    public final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> getInteractionCreate() {
        return this.interactionCreate;
    }

    public final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> getInteractionFailure() {
        return this.interactionFailure;
    }

    public final SerializedSubject<InteractionModalCreate, InteractionModalCreate> getInteractionModalCreate() {
        return this.interactionModalCreate;
    }

    public final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> getInteractionSuccess() {
        return this.interactionSuccess;
    }

    public final SerializedSubject<ModelReadState, ModelReadState> getMessageAck() {
        return this.messageAck;
    }

    public final SerializedSubject<Message, Message> getMessageCreate() {
        return this.messageCreate;
    }

    public final SerializedSubject<ModelMessageDelete, ModelMessageDelete> getMessageDelete() {
        return this.messageDelete;
    }

    public final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> getMessageReactionAdd() {
        return this.messageReactionAdd;
    }

    public final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> getMessageReactionRemove() {
        return this.messageReactionRemove;
    }

    public final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> getMessageReactionRemoveAll() {
        return this.messageReactionRemoveAll;
    }

    public final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> getMessageReactionRemoveEmoji() {
        return this.messageReactionRemoveEmoji;
    }

    public final SerializedSubject<Message, Message> getMessageUpdate() {
        return this.messageUpdate;
    }

    public final SerializedSubject<List<Presence>, List<Presence>> getPresenceReplace() {
        return this.presenceReplace;
    }

    public final SerializedSubject<Presence, Presence> getPresenceUpdate() {
        return this.presenceUpdate;
    }

    public final SerializedSubject<ModelPayload, ModelPayload> getReady() {
        return this.ready;
    }

    public final SerializedSubject<ModelUserRelationship, ModelUserRelationship> getRelationshipAdd() {
        return this.relationshipAdd;
    }

    public final SerializedSubject<ModelUserRelationship, ModelUserRelationship> getRelationshipRemove() {
        return this.relationshipRemove;
    }

    public final SerializedSubject<List<ModelSession>, List<ModelSession>> getSessionsReplace() {
        return this.sessionsReplace;
    }

    public final SerializedSubject<StageInstance, StageInstance> getStageInstanceCreate() {
        return this.stageInstanceCreate;
    }

    public final SerializedSubject<StageInstance, StageInstance> getStageInstanceDelete() {
        return this.stageInstanceDelete;
    }

    public final SerializedSubject<StageInstance, StageInstance> getStageInstanceUpdate() {
        return this.stageInstanceUpdate;
    }

    public final SerializedSubject<ModelApplicationStream3, ModelApplicationStream3> getStreamCreate() {
        return this.streamCreate;
    }

    public final SerializedSubject<ModelApplicationStream5, ModelApplicationStream5> getStreamDelete() {
        return this.streamDelete;
    }

    public final SerializedSubject<ModelApplicationStream7, ModelApplicationStream7> getStreamServerUpdate() {
        return this.streamServerUpdate;
    }

    public final SerializedSubject<ModelApplicationStream3, ModelApplicationStream3> getStreamUpdate() {
        return this.streamUpdate;
    }

    public final SerializedSubject<Channel, Channel> getThreadCreateOrUpdate() {
        return this.threadCreateOrUpdate;
    }

    public final SerializedSubject<Channel, Channel> getThreadDelete() {
        return this.threadDelete;
    }

    public final SerializedSubject<ModelThreadListSync, ModelThreadListSync> getThreadListSync() {
        return this.threadListSync;
    }

    public final SerializedSubject<ThreadMemberListUpdate, ThreadMemberListUpdate> getThreadMemberListUpdate() {
        return this.threadMemberListUpdate;
    }

    public final SerializedSubject<ThreadMemberUpdate, ThreadMemberUpdate> getThreadMemberUpdate() {
        return this.threadMemberUpdate;
    }

    public final SerializedSubject<ThreadMembersUpdate, ThreadMembersUpdate> getThreadMembersUpdate() {
        return this.threadMembersUpdate;
    }

    public final SerializedSubject<TypingUser, TypingUser> getTypingStart() {
        return this.typingStart;
    }

    public final SerializedSubject<Unit, Unit> getUserConnectionUpdate() {
        return this.userConnectionUpdate;
    }

    public final SerializedSubject<ModelNotificationSettings, ModelNotificationSettings> getUserGuildSettingsUpdate() {
        return this.userGuildSettingsUpdate;
    }

    public final SerializedSubject<ModelUserNote.Update, ModelUserNote.Update> getUserNoteUpdate() {
        return this.userNoteUpdate;
    }

    public final SerializedSubject<Unit, Unit> getUserPaymentSourcesUpdate() {
        return this.userPaymentSourcesUpdate;
    }

    public final SerializedSubject<UserRequiredActionUpdate, UserRequiredActionUpdate> getUserRequiredActionUpdate() {
        return this.userRequiredActionUpdate;
    }

    public final SerializedSubject<ModelUserSettings, ModelUserSettings> getUserSettingsUpdate() {
        return this.userSettingsUpdate;
    }

    public final SerializedSubject<Unit, Unit> getUserSubscriptionsUpdate() {
        return this.userSubscriptionsUpdate;
    }

    public final SerializedSubject<User, User> getUserUpdate() {
        return this.userUpdate;
    }

    public final SerializedSubject<VoiceServer, VoiceServer> getVoiceServerUpdate() {
        return this.voiceServerUpdate;
    }

    public final Batched<VoiceState> getVoiceStateUpdate() {
        return this.voiceStateUpdate;
    }

    @Override // com.discord.gateway.GatewayEventHandler
    public void handleConnected(boolean connected) {
        SerializedSubject<Boolean, Boolean> serializedSubject = this.connected;
        serializedSubject.k.onNext(Boolean.valueOf(connected));
    }

    @Override // com.discord.gateway.GatewayEventHandler
    public void handleConnectionReady(boolean connectionReady) {
        SerializedSubject<Boolean, Boolean> serializedSubject = this.connectionReady;
        serializedSubject.k.onNext(Boolean.valueOf(connectionReady));
    }

    @Override // com.discord.gateway.GatewayEventHandler
    public void handleDisconnect(boolean authenticationFailed) {
        if (authenticationFailed) {
            this.stream.getAuthentication().logout();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // com.discord.gateway.GatewayEventHandler
    public void handleDispatch(String type, Object data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.batches.flushBatches(type);
        if (type == null) {
            return;
        }
        switch (type.hashCode()) {
            case -2137365335:
                if (type.equals("MESSAGE_REACTION_REMOVE_EMOJI")) {
                    this.messageReactionRemoveEmoji.k.onNext(data);
                    break;
                }
                break;
            case -2067017195:
                if (!type.equals("GUILD_JOIN_REQUEST_CREATE")) {
                }
                this.guildJoinRequestCreateOrUpdate.k.onNext(data);
                break;
            case -2050181436:
                if (type.equals("GUILD_JOIN_REQUEST_DELETE")) {
                    this.guildJoinRequestDelete.k.onNext(data);
                    break;
                }
                break;
            case -2026522382:
                if (type.equals("SESSIONS_REPLACE")) {
                    this.sessionsReplace.k.onNext(data);
                    break;
                }
                break;
            case -2002723137:
                if (type.equals("GUILD_SCHEDULED_EVENT_CREATE")) {
                    this.guildScheduledEventCreate.k.onNext(data);
                    break;
                }
                break;
            case -1985887378:
                if (type.equals("GUILD_SCHEDULED_EVENT_DELETE")) {
                    this.guildScheduledEventDelete.k.onNext(data);
                    break;
                }
                break;
            case -1967037287:
                if (type.equals("THREAD_MEMBER_UPDATE")) {
                    this.threadMemberUpdate.k.onNext(data);
                    break;
                }
                break;
            case -1921449515:
                if (type.equals("APPLICATION_COMMAND_AUTOCOMPLETE_RESPONSE")) {
                    this.applicationCommandAutocompleteResult.k.onNext(data);
                    break;
                }
                break;
            case -1862771270:
                if (type.equals("THREAD_MEMBER_LIST_UPDATE")) {
                    this.threadMemberListUpdate.k.onNext(data);
                    break;
                }
                break;
            case -1825641445:
                if (type.equals("GUILD_MEMBERS_CHUNK")) {
                    this.guildMembersChunk.k.onNext(data);
                    break;
                }
                break;
            case -1580624828:
                if (type.equals("EMBEDDED_ACTIVITY_UPDATE")) {
                    this.embeddedActivityInboundUpdate.k.onNext(data);
                    break;
                }
                break;
            case -1553569310:
                if (!type.equals("GUILD_JOIN_REQUEST_UPDATE")) {
                }
                this.guildJoinRequestCreateOrUpdate.k.onNext(data);
                break;
            case -1553064252:
                if (type.equals("MESSAGE_REACTION_REMOVE_ALL")) {
                    this.messageReactionRemoveAll.k.onNext(data);
                    break;
                }
                break;
            case -1533134522:
                if (type.equals("FORUM_UNREADS")) {
                    this.forumUnreads.k.onNext(data);
                    break;
                }
                break;
            case -1489275252:
                if (type.equals(NotificationData.TYPE_GUILD_SCHEDULED_EVENT_UPDATE)) {
                    this.guildScheduledEventUpdate.k.onNext(data);
                    break;
                }
                break;
            case -1484942443:
                if (type.equals("GUILD_SCHEDULED_EVENT_USER_REMOVE")) {
                    this.guildScheduledEventUserRemove.k.onNext(data);
                    break;
                }
                break;
            case -1467383482:
                if (type.equals("USER_REQUIRED_ACTION_UPDATE")) {
                    this.userRequiredActionUpdate.k.onNext(data);
                    break;
                }
                break;
            case -1446088218:
                if (type.equals("GUILD_STICKERS_UPDATE")) {
                    this.guildStickersUpdate.k.onNext(data);
                    break;
                }
                break;
            case -1327124998:
                if (type.equals(NotificationData.TYPE_RELATIONSHIP_ADD)) {
                    this.relationshipAdd.k.onNext(data);
                    break;
                }
                break;
            case -1263316859:
                if (type.equals(NotificationData.TYPE_STAGE_INSTANCE_CREATE)) {
                    this.stageInstanceCreate.k.onNext(data);
                    break;
                }
                break;
            case -1261304891:
                if (type.equals("GUILD_BAN_ADD")) {
                    this.guildBanAdd.k.onNext(data);
                    break;
                }
                break;
            case -1248965304:
                if (!type.equals("GUILD_MEMBER_ADD")) {
                }
                this.guildMembersAdd.k.onNext(data);
                break;
            case -1246481100:
                if (type.equals("STAGE_INSTANCE_DELETE")) {
                    this.stageInstanceDelete.k.onNext(data);
                    break;
                }
                break;
            case -1238538557:
                if (type.equals("MESSAGE_REACTION_ADD")) {
                    this.messageReactionAdd.k.onNext(data);
                    break;
                }
                break;
            case -1201943215:
                if (type.equals("GUILD_MEMBER_LIST_UPDATE")) {
                    this.guildMemberListUpdate.k.onNext(data);
                    break;
                }
                break;
            case -974414266:
                if (type.equals("USER_SUBSCRIPTIONS_UPDATE")) {
                    this.userSubscriptionsUpdate.k.onNext(data);
                    break;
                }
                break;
            case -960563390:
                if (type.equals("USER_NOTE_UPDATE")) {
                    this.userNoteUpdate.k.onNext(data);
                    break;
                }
                break;
            case -903406451:
                if (type.equals("PRESENCE_UPDATE")) {
                    this.presenceUpdate.k.onNext(data);
                    break;
                }
                break;
            case -850953239:
                if (type.equals("INTERACTION_CREATE")) {
                    this.interactionCreate.k.onNext(data);
                    break;
                }
                break;
            case -843352707:
                if (type.equals("GUILD_INTEGRATIONS_UPDATE")) {
                    this.guildIntegrationsUpdate.k.onNext(data);
                    break;
                }
                break;
            case -778017807:
                if (type.equals("USER_SETTINGS_UPDATE")) {
                    this.userSettingsUpdate.k.onNext(data);
                    break;
                }
                break;
            case -767350043:
                if (type.equals("GUILD_APPLICATION_COMMANDS_UPDATE")) {
                    this.guildApplicationCommands.k.onNext(data);
                    break;
                }
                break;
            case -749868974:
                if (type.equals("STAGE_INSTANCE_UPDATE")) {
                    this.stageInstanceUpdate.k.onNext(data);
                    break;
                }
                break;
            case -718889877:
                if (type.equals("RELATIONSHIP_REMOVE")) {
                    this.relationshipRemove.k.onNext(data);
                    break;
                }
                break;
            case -675064872:
                if (!type.equals("CHANNEL_CREATE")) {
                }
                this.channelCreateOrUpdate.k.onNext(data);
                break;
            case -658229113:
                if (type.equals("CHANNEL_DELETE")) {
                    this.channelDeleted.k.onNext(data);
                    break;
                }
                break;
            case -548091546:
                if (type.equals("CHANNEL_RECIPIENT_REMOVE")) {
                    this.channelRecipientRemove.k.onNext(data);
                    break;
                }
                break;
            case -510741638:
                if (type.equals("TYPING_START")) {
                    this.typingStart.k.onNext(data);
                    break;
                }
                break;
            case -300870211:
                if (type.equals("USER_PAYMENT_SOURCES_UPDATE")) {
                    this.userPaymentSourcesUpdate.k.onNext(data);
                    break;
                }
                break;
            case -273749272:
                if (type.equals("GUILD_CREATE")) {
                    this.guildCreate.k.onNext(data);
                    break;
                }
                break;
            case -256913513:
                if (type.equals("GUILD_DELETE")) {
                    this.guildDeleted.k.onNext(data);
                    break;
                }
                break;
            case -233612803:
                if (!type.equals("CALL_CREATE")) {
                }
                this.callCreateOrUpdate.k.onNext(data);
                break;
            case -216777044:
                if (type.equals("CALL_DELETE")) {
                    this.callDelete.k.onNext(data);
                    break;
                }
                break;
            case -207118083:
                if (type.equals("CHANNEL_UNREAD_UPDATE")) {
                    this.channelUnreadUpdate.k.onNext(data);
                    break;
                }
                break;
            case -161616987:
                if (!type.equals("CHANNEL_UPDATE")) {
                }
                this.channelCreateOrUpdate.k.onNext(data);
                break;
            case -135720355:
                if (type.equals("GUILD_MEMBER_REMOVE")) {
                    this.guildMemberRemove.k.onNext(data);
                    break;
                }
                break;
            case -107601202:
                if (!type.equals("MESSAGE_DELETE_BULK")) {
                }
                this.messageDelete.k.onNext(data);
                break;
            case -45642698:
                if (type.equals("FRIEND_SUGGESTION_CREATE")) {
                    this.friendSuggestionCreate.k.onNext(data);
                    break;
                }
                break;
            case -39955806:
                if (!type.equals("GUILD_MEMBER_UPDATE")) {
                }
                this.guildMembersAdd.k.onNext(data);
                break;
            case -28806939:
                if (type.equals("FRIEND_SUGGESTION_DELETE")) {
                    this.friendSuggestionDelete.k.onNext(data);
                    break;
                }
                break;
            case 77848963:
                if (type.equals("READY")) {
                    this.ready.k.onNext(data);
                    break;
                }
                break;
            case 85547718:
                if (type.equals("STREAM_SERVER_UPDATE")) {
                    this.streamServerUpdate.k.onNext(data);
                    break;
                }
                break;
            case 151900580:
                if (type.equals("THREAD_MEMBERS_UPDATE")) {
                    this.threadMembersUpdate.k.onNext(data);
                    break;
                }
                break;
            case 239698613:
                if (type.equals("GUILD_UPDATE")) {
                    this.guildUpdate.k.onNext(data);
                    break;
                }
                break;
            case 279835082:
                if (!type.equals("CALL_UPDATE")) {
                }
                this.callCreateOrUpdate.k.onNext(data);
                break;
            case 391412669:
                if (type.equals("USER_UPDATE")) {
                    this.userUpdate.k.onNext(data);
                    break;
                }
                break;
            case 789496470:
                if (type.equals("INTERACTION_SUCCESS")) {
                    this.interactionSuccess.k.onNext(data);
                    break;
                }
                break;
            case 998188116:
                if (type.equals(NotificationData.TYPE_MESSAGE_CREATE)) {
                    this.messageCreate.k.onNext(data);
                    break;
                }
                break;
            case 1015023875:
                if (!type.equals("MESSAGE_DELETE")) {
                }
                this.messageDelete.k.onNext(data);
                break;
            case 1190664927:
                if (type.equals("CHANNEL_RECIPIENT_ADD")) {
                    this.channelRecipientAdd.k.onNext(data);
                    break;
                }
                break;
            case 1249854210:
                if (type.equals("MESSAGE_REACTION_REMOVE")) {
                    this.messageReactionRemove.k.onNext(data);
                    break;
                }
                break;
            case 1268388049:
                if (!type.equals("THREAD_CREATE")) {
                }
                this.threadCreateOrUpdate.k.onNext(data);
                break;
            case 1276846319:
                if (type.equals("GUILD_EMOJIS_UPDATE")) {
                    this.guildEmojisUpdate.k.onNext(data);
                    break;
                }
                break;
            case 1281125393:
                if (type.equals("MESSAGE_ACK")) {
                    this.messageAck.k.onNext(data);
                    break;
                }
                break;
            case 1285223808:
                if (type.equals("THREAD_DELETE")) {
                    this.threadDelete.k.onNext(data);
                    break;
                }
                break;
            case 1389895301:
                if (type.equals("USER_GUILD_SETTINGS_UPDATE")) {
                    this.userGuildSettingsUpdate.k.onNext(data);
                    break;
                }
                break;
            case 1476675193:
                if (type.equals("GUILD_ROLE_CREATE")) {
                    this.guildRoleCreate.k.onNext(data);
                    break;
                }
                break;
            case 1478484999:
                if (type.equals("USER_CONNECTIONS_UPDATE")) {
                    SerializedSubject<Unit, Unit> serializedSubject = this.userConnectionUpdate;
                    serializedSubject.k.onNext(Unit.a);
                    break;
                }
                break;
            case 1493510952:
                if (type.equals("GUILD_ROLE_DELETE")) {
                    this.guildRoleDelete.k.onNext(data);
                    break;
                }
                break;
            case 1511636001:
                if (type.equals("MESSAGE_UPDATE")) {
                    this.messageUpdate.k.onNext(data);
                    break;
                }
                break;
            case 1570092061:
                if (type.equals("INTERACTION_FAILURE")) {
                    this.interactionFailure.k.onNext(data);
                    break;
                }
                break;
            case 1616207515:
                if (type.equals("STREAM_CREATE")) {
                    this.streamCreate.k.onNext(data);
                    break;
                }
                break;
            case 1622830784:
                if (type.equals("GUILD_BAN_REMOVE")) {
                    this.guildBanRemove.k.onNext(data);
                    break;
                }
                break;
            case 1633043274:
                if (type.equals("STREAM_DELETE")) {
                    this.streamDelete.k.onNext(data);
                    break;
                }
                break;
            case 1689894925:
                if (type.equals("PRESENCES_REPLACE")) {
                    this.presenceReplace.k.onNext(data);
                    break;
                }
                break;
            case 1699412580:
                if (type.equals("VOICE_STATE_UPDATE")) {
                    this.voiceStateUpdate.onNext(data);
                    break;
                }
                break;
            case 1737758480:
                if (type.equals("GUILD_SCHEDULED_EVENT_USER_ADD")) {
                    this.guildScheduledEventUserAdd.k.onNext(data);
                    break;
                }
                break;
            case 1781835934:
                if (!type.equals("THREAD_UPDATE")) {
                }
                this.threadCreateOrUpdate.k.onNext(data);
                break;
            case 1882183896:
                if (type.equals("VOICE_SERVER_UPDATE")) {
                    this.voiceServerUpdate.k.onNext(data);
                    break;
                }
                break;
            case 1901414427:
                if (type.equals("INTERACTION_MODAL_CREATE")) {
                    this.interactionModalCreate.k.onNext(data);
                    break;
                }
                break;
            case 1928220071:
                if (type.equals("THREAD_LIST_SYNC")) {
                    this.threadListSync.k.onNext(data);
                    break;
                }
                break;
            case 1990123078:
                if (type.equals("GUILD_ROLE_UPDATE")) {
                    this.guildRoleUpdate.k.onNext(data);
                    break;
                }
                break;
            case 2129655400:
                if (type.equals("STREAM_UPDATE")) {
                    this.streamUpdate.k.onNext(data);
                    break;
                }
                break;
        }
    }

    public final void handlePreLogout() {
        voiceStateUpdate$default(this, null, null, false, false, false, null, false, 96, null);
    }

    public final void handleRtcConnectionStateChanged(RtcConnection.StateChange stateChange) {
        Intrinsics3.checkNotNullParameter(stateChange, "stateChange");
        RtcConnection.State state = stateChange.state;
        if ((state instanceof RtcConnection.State.d) && ((RtcConnection.State.d) state).a) {
            RtcConnection.Metadata metadata = stateChange.metadata;
            String str = metadata != null ? metadata.streamKey : null;
            if (str instanceof String) {
                streamPing(str);
            } else {
                voiceServerPing();
            }
        }
    }

    public final void init(Context context, NetworkMonitor networkMonitor) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(networkMonitor, "networkMonitor");
        this.socket = buildGatewaySocket(context, networkMonitor);
        ClientState.INSTANCE.initialize(this.stream, this.scheduler, new AnonymousClass1());
    }

    public final boolean presenceUpdate(ClientStatus status, Long since, List<Activity> activities, Boolean afk) {
        return requestIfSessionEstablished(new AnonymousClass1(status, since, activities, afk));
    }

    public final boolean requestApplicationCommands(long guildId, String nonce, boolean applications, String query, Integer offset, int commandLimit, List<String> commandIds) {
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
        return requestIfSessionEstablished(new AnonymousClass1(guildId, nonce, applications, offset, query, commandLimit, commandIds));
    }

    public final boolean requestForumUnreads(long guildId, long channelId, List<Tuples2<Long, Long>> threadMessagePairs) {
        Intrinsics3.checkNotNullParameter(threadMessagePairs, "threadMessagePairs");
        return requestIfSessionEstablished(new AnonymousClass1(guildId, channelId, threadMessagePairs));
    }

    public final boolean requestGuildMembers(long j) {
        return requestGuildMembers$default(this, j, null, null, null, 14, null);
    }

    public final boolean requestGuildMembers(long j, String str) {
        return requestGuildMembers$default(this, j, str, null, null, 12, null);
    }

    public final boolean requestGuildMembers(long j, String str, List<Long> list) {
        return requestGuildMembers$default(this, j, str, list, null, 8, null);
    }

    public final boolean requestGuildMembers(long guildId, String query, List<Long> userIds, Integer limit) {
        return requestIfSessionEstablished(new AnonymousClass1(guildId, query, userIds, limit));
    }

    public final Unit resetOnError() {
        GatewaySocket gatewaySocket = this.socket;
        if (gatewaySocket == null) {
            return null;
        }
        gatewaySocket.resetOnError();
        return Unit.a;
    }

    public final void simulateReconnectForTesting() {
        GatewaySocket gatewaySocket = this.socket;
        if (gatewaySocket != null) {
            gatewaySocket.simulateReconnectForTesting();
        }
    }

    @Store3
    public final void streamCreate(String streamKey, String preferredRegion) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        requestIfSessionEstablished(new AnonymousClass1(streamKey, ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey), preferredRegion));
    }

    public final void streamDelete(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        requestIfSessionEstablished(new AnonymousClass1(streamKey));
    }

    @Store3
    public final void streamWatch(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        requestIfSessionEstablished(new AnonymousClass1(streamKey));
    }

    public final boolean updateGuildSubscriptions(long guildId, GuildSubscriptions guildSubscriptions) {
        Intrinsics3.checkNotNullParameter(guildSubscriptions, "guildSubscriptions");
        Map<Long, List<List<Integer>>> serializedRanges = guildSubscriptions.getSerializedRanges();
        Boolean typing = guildSubscriptions.getTyping();
        Boolean activities = guildSubscriptions.getActivities();
        Boolean threads = guildSubscriptions.getThreads();
        Set<Long> members = guildSubscriptions.getMembers();
        return requestIfSessionEstablished(new AnonymousClass1(guildId, new Outgoing2.GuildSubscriptions(serializedRanges, typing, activities, members != null ? _Collections.toList(members) : null, threads, guildSubscriptions.getThreadMemberLists())));
    }

    public final boolean voiceStateUpdate(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo, String preferredRegion, boolean shouldIncludePreferredRegion) {
        return requestIfSessionEstablished(new AnonymousClass1(guildId, channelId, selfMute, selfDeaf, selfVideo, preferredRegion, shouldIncludePreferredRegion));
    }

    public StoreGatewayConnection(StoreStream storeStream, Clock clock, ExecutorService executorService, Scheduler scheduler, AppGatewaySocketLogger appGatewaySocketLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            executorService = java.util.concurrent.Executors.newFixedThreadPool(1);
            Intrinsics3.checkNotNullExpressionValue(executorService, "Executors.newFixedThreadPool(1)");
        }
        ExecutorService executorService2 = executorService;
        if ((i & 8) != 0) {
            AtomicReference<Schedulers2> atomicReference = Schedulers2.a;
            scheduler = new ExecutorScheduler(executorService2);
            Intrinsics3.checkNotNullExpressionValue(scheduler, "Schedulers.from(executor)");
        }
        this(storeStream, clock, executorService2, scheduler, appGatewaySocketLogger);
    }
}
