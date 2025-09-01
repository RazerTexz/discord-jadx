package com.discord.widgets.voice.fullscreen;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import co.discord.media_engine.DeviceDescription4;
import co.discord.media_engine.DeviceDescription5;
import com.discord.R;
import com.discord.api.application.Application;
import com.discord.api.application.ApplicationAsset;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.permission.Permission;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.socket.io.Payloads;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreApplication;
import com.discord.stores.StoreApplicationAssets;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStreamRtcConnection;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVideoStreams;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.EmbeddedActivityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.VideoPermissionsManager;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.video.VideoPlayerIdleDetector;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.channels.TextInVoiceOnboardingManager;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageCallModel;
import com.discord.widgets.stage.model.StageCallModel5;
import com.discord.widgets.voice.controls.VoiceControlsOutputSelectorState;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.model.CameraState;
import d0.LazyJVM;
import d0.Tuples;
import d0.d0._Ranges;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.p.Schedulers2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.RendererCommon;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* compiled from: WidgetCallFullscreenViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000e\u0093\u0002\u0094\u0002\u0095\u0002\u0096\u0002\u0097\u0002\u0098\u0002\u0099\u0002BÝ\u0002\u0012\n\u0010,\u001a\u00060\tj\u0002`+\u0012\n\b\u0002\u0010Ò\u0001\u001a\u00030Ñ\u0001\u0012\n\b\u0002\u0010à\u0001\u001a\u00030ß\u0001\u0012\n\b\u0002\u0010¶\u0001\u001a\u00030µ\u0001\u0012\n\b\u0002\u0010\u0080\u0002\u001a\u00030ÿ\u0001\u0012\n\b\u0002\u0010Ì\u0001\u001a\u00030Ë\u0001\u0012\n\b\u0002\u0010ò\u0001\u001a\u00030ñ\u0001\u0012\n\b\u0002\u0010©\u0001\u001a\u00030¨\u0001\u0012\n\b\u0002\u0010\u008f\u0002\u001a\u00030\u008e\u0002\u0012\n\b\u0002\u0010±\u0001\u001a\u00030°\u0001\u0012\n\b\u0002\u0010Ã\u0001\u001a\u00030Â\u0001\u0012\n\b\u0002\u0010Ù\u0001\u001a\u00030Ø\u0001\u0012\n\b\u0002\u0010\u0083\u0002\u001a\u00030\u0082\u0002\u0012\n\b\u0002\u0010ë\u0001\u001a\u00030ê\u0001\u0012\n\b\u0002\u0010ã\u0001\u001a\u00030â\u0001\u0012\n\b\u0002\u0010\u0086\u0002\u001a\u00030\u0085\u0002\u0012\n\b\u0002\u0010È\u0001\u001a\u00030Ç\u0001\u0012\n\b\u0002\u0010æ\u0001\u001a\u00030å\u0001\u0012\n\b\u0002\u0010ï\u0001\u001a\u00030î\u0001\u0012\n\b\u0002\u0010é\u0001\u001a\u00030Î\u0001\u0012\n\b\u0002\u0010\u00ad\u0001\u001a\u00030¬\u0001\u0012\n\b\u0002\u0010¹\u0001\u001a\u00030¸\u0001\u0012\n\b\u0002\u0010Ï\u0001\u001a\u00030Î\u0001\u0012\n\b\u0002\u0010õ\u0001\u001a\u00030ô\u0001\u0012\n\b\u0002\u0010ø\u0001\u001a\u00030÷\u0001\u0012\n\b\u0002\u0010Õ\u0001\u001a\u00030Ô\u0001\u0012\n\b\u0002\u0010¼\u0001\u001a\u00030»\u0001\u0012\u000e\u0010P\u001a\n\u0018\u00010$j\u0004\u0018\u0001`=¢\u0006\u0006\b\u0091\u0002\u0010\u0092\u0002J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u001d\u0010\u001c\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\"\u001a\u00020\u00142\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006H\u0003¢\u0006\u0004\b\"\u0010#J\u0013\u0010%\u001a\u00020$*\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010(JO\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010*\u001a\u00020)2\n\u0010,\u001a\u00060\tj\u0002`+2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u00100\u001a\u0004\u0018\u00010/2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u00103J!\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b5\u00106J\u0017\u0010:\u001a\u0002092\u0006\u00108\u001a\u000207H\u0002¢\u0006\u0004\b:\u0010;J;\u0010A\u001a\u0012\u0012\u0004\u0012\u00020)0?j\b\u0012\u0004\u0012\u00020)`@2\b\b\u0002\u0010<\u001a\u00020\u00062\u0010\b\u0002\u0010>\u001a\n\u0018\u00010$j\u0004\u0018\u0001`=H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020CH\u0002¢\u0006\u0004\bE\u0010FJ\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020)0\u00032\u0006\u0010D\u001a\u00020CH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0014H\u0002¢\u0006\u0004\bI\u0010\u0016J\u000f\u0010J\u001a\u00020\u0014H\u0002¢\u0006\u0004\bJ\u0010\u0016J\u000f\u0010K\u001a\u00020\u0014H\u0002¢\u0006\u0004\bK\u0010\u0016J\u000f\u0010L\u001a\u00020\u0014H\u0002¢\u0006\u0004\bL\u0010\u0016J\u000f\u0010M\u001a\u00020\u0014H\u0002¢\u0006\u0004\bM\u0010\u0016J\u000f\u0010N\u001a\u00020\u0014H\u0002¢\u0006\u0004\bN\u0010\u0016J\u000f\u0010O\u001a\u00020\u0014H\u0003¢\u0006\u0004\bO\u0010\u0016J-\u0010T\u001a\u00020\u00142\n\u0010P\u001a\u00060$j\u0002`=2\b\u0010Q\u001a\u0004\u0018\u00010$2\u0006\u0010S\u001a\u00020RH\u0002¢\u0006\u0004\bT\u0010UJ\u0017\u0010X\u001a\u00020\u00062\u0006\u0010W\u001a\u00020VH\u0002¢\u0006\u0004\bX\u0010YJ\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020[0ZH\u0002¢\u0006\u0004\b\\\u0010]J\u0013\u0010_\u001a\b\u0012\u0004\u0012\u00020^0Z¢\u0006\u0004\b_\u0010]J\u0019\u0010`\u001a\u00020\u00142\n\u0010,\u001a\u00060\tj\u0002`+¢\u0006\u0004\b`\u0010aJ\r\u0010b\u001a\u00020\u0014¢\u0006\u0004\bb\u0010\u0016J\u0017\u0010d\u001a\u00020\u00142\u0006\u0010c\u001a\u00020RH\u0007¢\u0006\u0004\bd\u0010eJ\u0017\u0010g\u001a\u00020\u00142\u0006\u0010f\u001a\u00020\u0002H\u0014¢\u0006\u0004\bg\u0010hJ\u000f\u0010i\u001a\u00020\u0014H\u0007¢\u0006\u0004\bi\u0010\u0016J\u000f\u0010j\u001a\u00020\u0014H\u0007¢\u0006\u0004\bj\u0010\u0016J\u0017\u0010l\u001a\u00020\u00142\u0006\u0010k\u001a\u00020[H\u0007¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020\u0014H\u0007¢\u0006\u0004\bn\u0010\u0016J\u0017\u0010q\u001a\u00020\u00142\u0006\u0010p\u001a\u00020oH\u0007¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020\u0014H\u0007¢\u0006\u0004\bs\u0010\u0016J\u001b\u0010t\u001a\u00020\u00142\n\u0010P\u001a\u00060$j\u0002`=H\u0007¢\u0006\u0004\bt\u0010uJ\u001b\u0010v\u001a\u00020\u00142\n\u0010P\u001a\u00060$j\u0002`=H\u0007¢\u0006\u0004\bv\u0010uJ\u000f\u0010w\u001a\u00020\u0014H\u0007¢\u0006\u0004\bw\u0010\u0016J\u000f\u0010x\u001a\u00020\u0014H\u0007¢\u0006\u0004\bx\u0010\u0016J\u000f\u0010y\u001a\u00020\u0014H\u0007¢\u0006\u0004\by\u0010\u0016J\u000f\u0010z\u001a\u00020\u0014H\u0007¢\u0006\u0004\bz\u0010\u0016J\u000f\u0010{\u001a\u00020\u0014H\u0007¢\u0006\u0004\b{\u0010\u0016J\u000f\u0010|\u001a\u00020\u0014H\u0007¢\u0006\u0004\b|\u0010\u0016J\u0017\u0010}\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0004H\u0007¢\u0006\u0004\b}\u0010~J\u0017\u0010\u007f\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u007f\u0010~J\u001b\u0010\u0081\u0001\u001a\u00020\u00142\u0007\u0010\u0080\u0001\u001a\u00020\u0006H\u0007¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0011\u0010\u0083\u0001\u001a\u00020\u0014H\u0007¢\u0006\u0005\b\u0083\u0001\u0010\u0016J\u0011\u0010\u0084\u0001\u001a\u00020\u0014H\u0007¢\u0006\u0005\b\u0084\u0001\u0010\u0016J(\u0010\u0089\u0001\u001a\u00020\u00142\b\u0010\u0086\u0001\u001a\u00030\u0085\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0007¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J(\u0010\u008b\u0001\u001a\u00020\u00142\b\u0010\u0086\u0001\u001a\u00030\u0085\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0007¢\u0006\u0006\b\u008b\u0001\u0010\u008a\u0001J\u0011\u0010\u008c\u0001\u001a\u00020\u0014H\u0007¢\u0006\u0005\b\u008c\u0001\u0010\u0016J\u001a\u0010\u008e\u0001\u001a\u00020\u00142\u0007\u0010\u008d\u0001\u001a\u00020$H\u0007¢\u0006\u0005\b\u008e\u0001\u0010uJ#\u0010\u0092\u0001\u001a\u00020\u00142\b\u0010\u0090\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u0006¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001d\u0010\u0096\u0001\u001a\u00020\u00142\f\u0010\u0095\u0001\u001a\u00070\tj\u0003`\u0094\u0001¢\u0006\u0005\b\u0096\u0001\u0010aJ\u000f\u0010\u0097\u0001\u001a\u00020\u0014¢\u0006\u0005\b\u0097\u0001\u0010\u0016J\u001d\u0010\u0098\u0001\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003¢\u0006\u0005\b\u0098\u0001\u0010\u001dJ\u0011\u0010\u0099\u0001\u001a\u00020\u0014H\u0015¢\u0006\u0005\b\u0099\u0001\u0010\u0016J\u000f\u0010\u009a\u0001\u001a\u00020\u0014¢\u0006\u0005\b\u009a\u0001\u0010\u0016J\u0011\u0010\u009b\u0001\u001a\u00020\u0014H\u0007¢\u0006\u0005\b\u009b\u0001\u0010\u0016J\u0011\u0010\u009c\u0001\u001a\u00020\u0014H\u0007¢\u0006\u0005\b\u009c\u0001\u0010\u0016J\u0011\u0010\u009d\u0001\u001a\u00020\u0014H\u0007¢\u0006\u0005\b\u009d\u0001\u0010\u0016J&\u0010 \u0001\u001a\u00020\u00022\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00022\u0007\u0010\u009f\u0001\u001a\u00020\u0002H\u0014¢\u0006\u0006\b \u0001\u0010¡\u0001R\u001a\u0010£\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001c\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001a\u0010©\u0001\u001a\u00030¨\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u0019\u0010c\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bc\u0010«\u0001R\u001a\u0010\u00ad\u0001\u001a\u00030¬\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u001a\u0010¯\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010¤\u0001R\u001a\u0010±\u0001\u001a\u00030°\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0019\u0010³\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u001a\u0010¶\u0001\u001a\u00030µ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001a\u0010¹\u0001\u001a\u00030¸\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001a\u0010¼\u0001\u001a\u00030»\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001RB\u0010À\u0001\u001a+\u0012\r\u0012\u000b ¿\u0001*\u0004\u0018\u00010^0^ ¿\u0001*\u0014\u0012\r\u0012\u000b ¿\u0001*\u0004\u0018\u00010^0^\u0018\u00010¾\u00010¾\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001a\u0010Ã\u0001\u001a\u00030Â\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u001f\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001a\u0010È\u0001\u001a\u00030Ç\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u0019\u0010Ê\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010´\u0001R\u001a\u0010Ì\u0001\u001a\u00030Ë\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u001a\u0010Ï\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u001a\u0010Ò\u0001\u001a\u00030Ñ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001a\u0010Õ\u0001\u001a\u00030Ô\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u001c\u0010×\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010§\u0001R\u001a\u0010Ù\u0001\u001a\u00030Ø\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\"\u0010Ü\u0001\u001a\u000b\u0018\u00010$j\u0005\u0018\u0001`Û\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u0019\u0010Þ\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010´\u0001R\u001a\u0010à\u0001\u001a\u00030ß\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u001a\u0010ã\u0001\u001a\u00030â\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u001a\u0010æ\u0001\u001a\u00030å\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001RZ\u0010è\u0001\u001aC\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001a ¿\u0001*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00030\u0003 ¿\u0001* \u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001a ¿\u0001*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00030\u0003\u0018\u00010¾\u00010¾\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bè\u0001\u0010Á\u0001R\u001a\u0010é\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bé\u0001\u0010Ð\u0001R\u001a\u0010ë\u0001\u001a\u00030ê\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R!\u0010í\u0001\u001a\n\u0018\u00010$j\u0004\u0018\u0001`=8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0001\u0010Ý\u0001R\u001a\u0010ï\u0001\u001a\u00030î\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u001a\u0010ò\u0001\u001a\u00030ñ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u001a\u0010õ\u0001\u001a\u00030ô\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bõ\u0001\u0010ö\u0001R\u001a\u0010ø\u0001\u001a\u00030÷\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R\u001b\u0010ú\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R\u001c\u0010ý\u0001\u001a\u0005\u0018\u00010ü\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010þ\u0001R\u001a\u0010\u0080\u0002\u001a\u00030ÿ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0002\u0010\u0081\u0002R\u001a\u0010\u0083\u0002\u001a\u00030\u0082\u00028\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R\u001a\u0010\u0086\u0002\u001a\u00030\u0085\u00028\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0002\u0010\u0087\u0002R\u001b\u0010\u0088\u0002\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0002\u0010\u0089\u0002R\u001b\u0010,\u001a\u00060\tj\u0002`+8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b,\u0010\u008a\u0002R(\u0010\u008b\u0002\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u008b\u0002\u0010´\u0001\u001a\u0005\b\u008c\u0002\u0010(\"\u0006\b\u008d\u0002\u0010\u0082\u0001R\u001a\u0010\u008f\u0002\u001a\u00030\u008e\u00028\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u0090\u0002¨\u0006\u009a\u0002"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState;", "", "Lcom/discord/widgets/voice/fullscreen/CallParticipant;", "callParticipants", "", "isOneOnOneMeCall", "(Ljava/util/List;)Z", "", "Lcom/discord/primitives/UserId;", "myUserId", "Lco/discord/media_engine/VideoInputDeviceDescription;", "selectedVideoInputDevice", "isStreaming", "Lcom/discord/widgets/voice/model/CameraState;", "cameraState", "Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "computePipParticipant", "(JLco/discord/media_engine/VideoInputDeviceDescription;ZLcom/discord/widgets/voice/model/CameraState;)Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "", "startTapForwardingJob", "()V", "cancelTapForwardingJob", "clearFocusedVideoParticipant", "stopWatchingStreamIfEnded", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "visibleVideoParticipants", "setOffScreenVideoParticipants", "(Ljava/util/List;)V", "computeVisibleVideoParticipants", "()Ljava/util/List;", "isIdleFooter", "isIdleHeader", "onIdleStateChanged", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "", "getParticipantFocusKey", "(Lcom/discord/widgets/voice/fullscreen/CallParticipant;)Ljava/lang/String;", "hasVideoPermission", "()Z", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "participant", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "activeApplicationStream", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "streamQuality", "showLabels", "createVideoGridEntriesForParticipant", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;JLcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;Lcom/discord/rtcconnection/RtcConnection$Quality;Lco/discord/media_engine/VideoInputDeviceDescription;Z)Ljava/util/List;", "callParticipant", "addStreamQualityMetadata", "(Lcom/discord/widgets/voice/fullscreen/CallParticipant;Lcom/discord/rtcconnection/RtcConnection$Quality;)Lcom/discord/widgets/voice/fullscreen/CallParticipant;", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream$State;", "applicationStreamState", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$ApplicationStreamState;", "getParticipantStreamState", "(Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream$State;)Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$ApplicationStreamState;", "prioritizeSpectators", "Lcom/discord/primitives/StreamKey;", "mySpectatingStreamKey", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "createUserItemsComparator", "(ZLjava/lang/String;)Ljava/util/Comparator;", "Lcom/discord/widgets/voice/model/CallModel;", "callModel", "shouldShowMoreAudioOutputs", "(Lcom/discord/widgets/voice/model/CallModel;)Z", "createPrivateCallParticipantListItems", "(Lcom/discord/widgets/voice/model/CallModel;)Ljava/util/List;", "emitSuppressedDialogEvent", "emitServerMutedDialogEvent", "emitShowNoVideoPermissionDialogEvent", "emitShowNoScreenSharePermissionDialogEvent", "emitShowNoVadPermissionDialogEvent", "emitServerDeafenedDialogEvent", "stopWatchingStream", "streamKey", "mediaSessionId", "", "triggerRateDenominator", "enqueueStreamFeedbackSheet", "(Ljava/lang/String;Ljava/lang/String;I)V", "Lcom/discord/models/domain/ModelApplicationStream;", "stream", "isStreamFocused", "(Lcom/discord/models/domain/ModelApplicationStream;)Z", "Lrx/Observable;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;", "observeStoreState", "()Lrx/Observable;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "observeEvents", "setTargetChannelId", "(J)V", "disableControlFading", "bottomSheetState", "handleBottomSheetState", "(I)V", "viewState", "updateViewState", "(Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState;)V", "stopIdle", "startIdle", "storeState", "handleStoreState", "(Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;)V", "onScreenShareClick", "Landroid/content/Intent;", "intent", "startScreenShare", "(Landroid/content/Intent;)V", "stopScreenShare", "targetStream", "(Ljava/lang/String;)V", "targetAndFocusStream", "tryConnectToVoice", "disconnect", "toggleCameraPressed", "onCameraPermissionsGranted", "switchCameraInputPressed", "onDeafenPressed", "onGridParticipantTapped", "(Lcom/discord/widgets/voice/fullscreen/CallParticipant;)V", "onGridParticipantLongPressed", "isPressed", "onPushToTalkPressed", "(Z)V", "onEmptyStateTapped", "onShowParticipantsPressed", "Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;", "resolution", "Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;", "fps", "onStreamQualityIndicatorShown", "(Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;)V", "onStreamQualityIndicatorClicked", "onTextInVoiceTapped", "participantKey", "focusVideoParticipant", "", "perceptualVolume", "fromUser", "onStreamPerceptualVolumeChanged", "(FZ)V", "Lcom/discord/primitives/GuildId;", "guildId", "onVisitCommunityButtonClicked", "selectTextChannelAfterFinish", "updateOffScreenParticipantsFromScroll", "onCleared", "requestStopWatchingStreamFromUserInput", "onMuteClicked", "moveMeToAudience", "toggleRequestToSpeak", "previousViewState", "pendingViewState", "modifyPendingViewState", "(Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState;Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState;)Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState;", "Lcom/discord/utilities/video/VideoPlayerIdleDetector;", "videoPlayerIdleDetectorHeader", "Lcom/discord/utilities/video/VideoPlayerIdleDetector;", "Lrx/Subscription;", "storeObservableSubscription", "Lrx/Subscription;", "Lcom/discord/stores/StoreApplicationStreaming;", "applicationStreamingStore", "Lcom/discord/stores/StoreApplicationStreaming;", "Ljava/lang/Integer;", "Lcom/discord/stores/StoreConnectivity;", "connectivityStore", "Lcom/discord/stores/StoreConnectivity;", "videoPlayerIdleDetectorFooter", "Lcom/discord/stores/StoreMediaSettings;", "mediaSettingsStore", "Lcom/discord/stores/StoreMediaSettings;", "logStreamQualityIndicatorViewed", "Z", "Lcom/discord/stores/StoreVoiceChannelSelected;", "selectedVoiceChannelStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "Lcom/discord/stores/StoreStageChannels;", "stageStore", "Lcom/discord/stores/StoreStageChannels;", "Lcom/discord/stores/StoreApplicationAssets;", "applicationAssetsStore", "Lcom/discord/stores/StoreApplicationAssets;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StorePermissions;", "allVideoParticipants", "Ljava/util/List;", "Lcom/discord/stores/StoreAccessibility;", "accessibilityStore", "Lcom/discord/stores/StoreAccessibility;", "wasEverConnected", "Lcom/discord/stores/StoreTabsNavigation;", "tabsNavigationStore", "Lcom/discord/stores/StoreTabsNavigation;", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "Lcom/discord/stores/StoreAnalytics;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreApplication;", "applicationStore", "Lcom/discord/stores/StoreApplication;", "forwardVideoGridInteractionSubscription", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/widgets/voice/fullscreen/ParticipantKey;", "focusedVideoParticipantKey", "Ljava/lang/String;", "wasEverMultiParticipant", "Lcom/discord/stores/StoreNavigation;", "storeNavigation", "Lcom/discord/stores/StoreNavigation;", "Lcom/discord/utilities/voice/VoiceEngineServiceController;", "voiceEngineServiceController", "Lcom/discord/utilities/voice/VoiceEngineServiceController;", "Lcom/discord/stores/StoreAudioManagerV2;", "audioManagerStore", "Lcom/discord/stores/StoreAudioManagerV2;", "offScreenSubject", "analyticsStore", "Lcom/discord/utilities/permissions/VideoPermissionsManager;", "videoPermissionsManager", "Lcom/discord/utilities/permissions/VideoPermissionsManager;", "autotargetStreamKey", "Lcom/discord/stores/StoreMentions;", "mentionsStore", "Lcom/discord/stores/StoreMentions;", "Lcom/discord/stores/StoreUserSettings;", "userSettingsStore", "Lcom/discord/stores/StoreUserSettings;", "Lcom/discord/stores/StoreExperiments;", "experimentsStore", "Lcom/discord/stores/StoreExperiments;", "Lcom/discord/stores/StoreChannelsSelected;", "channelsSelectedStore", "Lcom/discord/stores/StoreChannelsSelected;", "startedAsVideo", "Ljava/lang/Boolean;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ParticipantTap;", "lastParticipantTap", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ParticipantTap;", "Lcom/discord/stores/StoreGuildSelected;", "guildSelectedStore", "Lcom/discord/stores/StoreGuildSelected;", "Lrx/Scheduler;", "backgroundThreadScheduler", "Lrx/Scheduler;", "Lcom/discord/stores/StoreStreamRtcConnection;", "streamRtcConnectionStore", "Lcom/discord/stores/StoreStreamRtcConnection;", "mostRecentStoreState", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;", "J", "showStageCallBottomSheet", "getShowStageCallBottomSheet", "setShowStageCallBottomSheet", "Lcom/discord/stores/StoreMediaEngine;", "mediaEngineStore", "Lcom/discord/stores/StoreMediaEngine;", "<init>", "(JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreNavigation;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreGuildSelected;Lcom/discord/stores/StoreTabsNavigation;Lcom/discord/stores/StoreUserSettings;Lcom/discord/stores/StoreApplicationStreaming;Lcom/discord/stores/StoreMediaEngine;Lcom/discord/stores/StoreMediaSettings;Lcom/discord/stores/StorePermissions;Lcom/discord/utilities/time/Clock;Lrx/Scheduler;Lcom/discord/utilities/permissions/VideoPermissionsManager;Lcom/discord/utilities/voice/VoiceEngineServiceController;Lcom/discord/stores/StoreStreamRtcConnection;Lcom/discord/stores/StoreAccessibility;Lcom/discord/stores/StoreAudioManagerV2;Lcom/discord/stores/StoreMentions;Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/StoreConnectivity;Lcom/discord/stores/StoreStageChannels;Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreApplication;Lcom/discord/stores/StoreApplicationAssets;Ljava/lang/String;)V", "DisplayMode", "Event", "MenuItem", "OverlayStatus", "ParticipantTap", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel extends AppViewModel<ViewState> {
    private final StoreAccessibility accessibilityStore;
    private List<? extends CallParticipant> allVideoParticipants;
    private final StoreAnalytics analyticsStore;
    private final StoreApplicationAssets applicationAssetsStore;
    private final StoreApplication applicationStore;
    private final StoreApplicationStreaming applicationStreamingStore;
    private final StoreAudioManagerV2 audioManagerStore;
    private String autotargetStreamKey;
    private final Scheduler backgroundThreadScheduler;
    private Integer bottomSheetState;
    private long channelId;
    private final StoreChannelsSelected channelsSelectedStore;
    private final Clock clock;
    private final StoreConnectivity connectivityStore;
    private final PublishSubject<Event> eventSubject;
    private final StoreExperiments experimentsStore;
    private String focusedVideoParticipantKey;
    private Subscription forwardVideoGridInteractionSubscription;
    private final StoreGuildSelected guildSelectedStore;
    private ParticipantTap lastParticipantTap;
    private boolean logStreamQualityIndicatorViewed;
    private final StoreMediaEngine mediaEngineStore;
    private final StoreMediaSettings mediaSettingsStore;
    private final StoreMentions mentionsStore;
    private StoreState mostRecentStoreState;
    private final PublishSubject<List<VideoCallParticipantView.ParticipantData>> offScreenSubject;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private boolean showStageCallBottomSheet;
    private final StoreStageChannels stageStore;
    private Boolean startedAsVideo;
    private final StoreAnalytics storeAnalytics;
    private final StoreChannels storeChannels;
    private final StoreNavigation storeNavigation;
    private Subscription storeObservableSubscription;
    private final StoreStreamRtcConnection streamRtcConnectionStore;
    private final StoreTabsNavigation tabsNavigationStore;
    private final StoreUserSettings userSettingsStore;
    private final VideoPermissionsManager videoPermissionsManager;
    private final VideoPlayerIdleDetector videoPlayerIdleDetectorFooter;
    private final VideoPlayerIdleDetector videoPlayerIdleDetectorHeader;
    private final VoiceEngineServiceController voiceEngineServiceController;
    private boolean wasEverConnected;
    private boolean wasEverMultiParticipant;

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends VideoCallParticipantView.ParticipantData>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends VideoCallParticipantView.ParticipantData> list) {
            invoke2((List<VideoCallParticipantView.ParticipantData>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<VideoCallParticipantView.ParticipantData> list) {
            WidgetCallFullscreenViewModel widgetCallFullscreenViewModel = WidgetCallFullscreenViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            WidgetCallFullscreenViewModel.access$setOffScreenVideoParticipants(widgetCallFullscreenViewModel, list);
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$DisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "GRID", "STAGE", "PRIVATE_CALL_PARTICIPANTS", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum DisplayMode {
        GRID,
        STAGE,
        PRIVATE_CALL_PARTICIPANTS
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0012\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0012\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'¨\u0006("}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "", "<init>", "()V", "AccessibilityAnnouncement", "EnqueueCallFeedbackSheet", "EnqueueStreamFeedbackSheet", "NavigateToPremiumSettings", "OnIdleStateChanged", "RequestStartStream", "ShowActivitiesDesktopOnlyDialog", "ShowCameraCapacityDialog", "ShowGuildVideoAtCapacityDialog", "ShowNoScreenSharePermissionDialog", "ShowNoVadPermissionDialog", "ShowNoVideoPermissionDialog", "ShowRequestCameraPermissionsDialog", "ShowServerDeafenedDialog", "ShowServerMutedDialog", "ShowSuppressedDialog", "ShowTextInVoiceNux", "ShowUserSheet", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowSuppressedDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowServerMutedDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowServerDeafenedDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowNoVideoPermissionDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowNoVadPermissionDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowNoScreenSharePermissionDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowGuildVideoAtCapacityDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowRequestCameraPermissionsDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowTextInVoiceNux;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowUserSheet;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$OnIdleStateChanged;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$RequestStartStream;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$NavigateToPremiumSettings;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowActivitiesDesktopOnlyDialog;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "", "component1", "()I", "messageResId", "copy", "(I)Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getMessageResId", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class AccessibilityAnnouncement extends Event {
            private final int messageResId;

            public AccessibilityAnnouncement(@StringRes int i) {
                super(null);
                this.messageResId = i;
            }

            public static /* synthetic */ AccessibilityAnnouncement copy$default(AccessibilityAnnouncement accessibilityAnnouncement, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = accessibilityAnnouncement.messageResId;
                }
                return accessibilityAnnouncement.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getMessageResId() {
                return this.messageResId;
            }

            public final AccessibilityAnnouncement copy(@StringRes int messageResId) {
                return new AccessibilityAnnouncement(messageResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof AccessibilityAnnouncement) && this.messageResId == ((AccessibilityAnnouncement) other).messageResId;
                }
                return true;
            }

            public final int getMessageResId() {
                return this.messageResId;
            }

            public int hashCode() {
                return this.messageResId;
            }

            public String toString() {
                return outline.B(outline.U("AccessibilityAnnouncement(messageResId="), this.messageResId, ")");
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\u0011\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\u000e\u0010\u0012\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b&\u0010'J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJV\u0010\u0015\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\tJ\u0010\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000fJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR!\u0010\u0012\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\tR!\u0010\u0011\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b \u0010\tR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\u0005R\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b#\u0010\u0005R\u0019\u0010\u0014\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\u000f¨\u0006("}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "Lcom/discord/primitives/RtcConnectionId;", "component2", "()Ljava/lang/String;", "Lcom/discord/primitives/MediaSessionId;", "component3", "component4", "", "component5", "()I", "channelId", "rtcConnectionId", "mediaSessionId", "callDuration", "triggerRateDenominator", "copy", "(JLjava/lang/String;Ljava/lang/String;JI)Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMediaSessionId", "getRtcConnectionId", "J", "getCallDuration", "getChannelId", "I", "getTriggerRateDenominator", "<init>", "(JLjava/lang/String;Ljava/lang/String;JI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class EnqueueCallFeedbackSheet extends Event {
            private final long callDuration;
            private final long channelId;
            private final String mediaSessionId;
            private final String rtcConnectionId;
            private final int triggerRateDenominator;

            public EnqueueCallFeedbackSheet(long j, String str, String str2, long j2, int i) {
                super(null);
                this.channelId = j;
                this.rtcConnectionId = str;
                this.mediaSessionId = str2;
                this.callDuration = j2;
                this.triggerRateDenominator = i;
            }

            public static /* synthetic */ EnqueueCallFeedbackSheet copy$default(EnqueueCallFeedbackSheet enqueueCallFeedbackSheet, long j, String str, String str2, long j2, int i, int i2, Object obj) {
                return enqueueCallFeedbackSheet.copy((i2 & 1) != 0 ? enqueueCallFeedbackSheet.channelId : j, (i2 & 2) != 0 ? enqueueCallFeedbackSheet.rtcConnectionId : str, (i2 & 4) != 0 ? enqueueCallFeedbackSheet.mediaSessionId : str2, (i2 & 8) != 0 ? enqueueCallFeedbackSheet.callDuration : j2, (i2 & 16) != 0 ? enqueueCallFeedbackSheet.triggerRateDenominator : i);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getRtcConnectionId() {
                return this.rtcConnectionId;
            }

            /* renamed from: component3, reason: from getter */
            public final String getMediaSessionId() {
                return this.mediaSessionId;
            }

            /* renamed from: component4, reason: from getter */
            public final long getCallDuration() {
                return this.callDuration;
            }

            /* renamed from: component5, reason: from getter */
            public final int getTriggerRateDenominator() {
                return this.triggerRateDenominator;
            }

            public final EnqueueCallFeedbackSheet copy(long channelId, String rtcConnectionId, String mediaSessionId, long callDuration, int triggerRateDenominator) {
                return new EnqueueCallFeedbackSheet(channelId, rtcConnectionId, mediaSessionId, callDuration, triggerRateDenominator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EnqueueCallFeedbackSheet)) {
                    return false;
                }
                EnqueueCallFeedbackSheet enqueueCallFeedbackSheet = (EnqueueCallFeedbackSheet) other;
                return this.channelId == enqueueCallFeedbackSheet.channelId && Intrinsics3.areEqual(this.rtcConnectionId, enqueueCallFeedbackSheet.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, enqueueCallFeedbackSheet.mediaSessionId) && this.callDuration == enqueueCallFeedbackSheet.callDuration && this.triggerRateDenominator == enqueueCallFeedbackSheet.triggerRateDenominator;
            }

            public final long getCallDuration() {
                return this.callDuration;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final String getMediaSessionId() {
                return this.mediaSessionId;
            }

            public final String getRtcConnectionId() {
                return this.rtcConnectionId;
            }

            public final int getTriggerRateDenominator() {
                return this.triggerRateDenominator;
            }

            public int hashCode() {
                int iA = b.a(this.channelId) * 31;
                String str = this.rtcConnectionId;
                int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.mediaSessionId;
                return ((b.a(this.callDuration) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31) + this.triggerRateDenominator;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EnqueueCallFeedbackSheet(channelId=");
                sbU.append(this.channelId);
                sbU.append(", rtcConnectionId=");
                sbU.append(this.rtcConnectionId);
                sbU.append(", mediaSessionId=");
                sbU.append(this.mediaSessionId);
                sbU.append(", callDuration=");
                sbU.append(this.callDuration);
                sbU.append(", triggerRateDenominator=");
                return outline.B(sbU, this.triggerRateDenominator, ")");
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0010\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0005R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "", "Lcom/discord/primitives/StreamKey;", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "streamKey", "mediaSessionId", "triggerRateDenominator", "copy", "(Ljava/lang/String;Ljava/lang/String;I)Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMediaSessionId", "getStreamKey", "I", "getTriggerRateDenominator", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class EnqueueStreamFeedbackSheet extends Event {
            private final String mediaSessionId;
            private final String streamKey;
            private final int triggerRateDenominator;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EnqueueStreamFeedbackSheet(String str, String str2, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "streamKey");
                this.streamKey = str;
                this.mediaSessionId = str2;
                this.triggerRateDenominator = i;
            }

            public static /* synthetic */ EnqueueStreamFeedbackSheet copy$default(EnqueueStreamFeedbackSheet enqueueStreamFeedbackSheet, String str, String str2, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = enqueueStreamFeedbackSheet.streamKey;
                }
                if ((i2 & 2) != 0) {
                    str2 = enqueueStreamFeedbackSheet.mediaSessionId;
                }
                if ((i2 & 4) != 0) {
                    i = enqueueStreamFeedbackSheet.triggerRateDenominator;
                }
                return enqueueStreamFeedbackSheet.copy(str, str2, i);
            }

            /* renamed from: component1, reason: from getter */
            public final String getStreamKey() {
                return this.streamKey;
            }

            /* renamed from: component2, reason: from getter */
            public final String getMediaSessionId() {
                return this.mediaSessionId;
            }

            /* renamed from: component3, reason: from getter */
            public final int getTriggerRateDenominator() {
                return this.triggerRateDenominator;
            }

            public final EnqueueStreamFeedbackSheet copy(String streamKey, String mediaSessionId, int triggerRateDenominator) {
                Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
                return new EnqueueStreamFeedbackSheet(streamKey, mediaSessionId, triggerRateDenominator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EnqueueStreamFeedbackSheet)) {
                    return false;
                }
                EnqueueStreamFeedbackSheet enqueueStreamFeedbackSheet = (EnqueueStreamFeedbackSheet) other;
                return Intrinsics3.areEqual(this.streamKey, enqueueStreamFeedbackSheet.streamKey) && Intrinsics3.areEqual(this.mediaSessionId, enqueueStreamFeedbackSheet.mediaSessionId) && this.triggerRateDenominator == enqueueStreamFeedbackSheet.triggerRateDenominator;
            }

            public final String getMediaSessionId() {
                return this.mediaSessionId;
            }

            public final String getStreamKey() {
                return this.streamKey;
            }

            public final int getTriggerRateDenominator() {
                return this.triggerRateDenominator;
            }

            public int hashCode() {
                String str = this.streamKey;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.mediaSessionId;
                return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.triggerRateDenominator;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EnqueueStreamFeedbackSheet(streamKey=");
                sbU.append(this.streamKey);
                sbU.append(", mediaSessionId=");
                sbU.append(this.mediaSessionId);
                sbU.append(", triggerRateDenominator=");
                return outline.B(sbU, this.triggerRateDenominator, ")");
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$NavigateToPremiumSettings;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class NavigateToPremiumSettings extends Event {
            public static final NavigateToPremiumSettings INSTANCE = new NavigateToPremiumSettings();

            private NavigateToPremiumSettings() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$OnIdleStateChanged;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "", "component1", "()Z", "isIdle", "copy", "(Z)Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$OnIdleStateChanged;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class OnIdleStateChanged extends Event {
            private final boolean isIdle;

            public OnIdleStateChanged(boolean z2) {
                super(null);
                this.isIdle = z2;
            }

            public static /* synthetic */ OnIdleStateChanged copy$default(OnIdleStateChanged onIdleStateChanged, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = onIdleStateChanged.isIdle;
                }
                return onIdleStateChanged.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsIdle() {
                return this.isIdle;
            }

            public final OnIdleStateChanged copy(boolean isIdle) {
                return new OnIdleStateChanged(isIdle);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof OnIdleStateChanged) && this.isIdle == ((OnIdleStateChanged) other).isIdle;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.isIdle;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public final boolean isIdle() {
                return this.isIdle;
            }

            public String toString() {
                return outline.O(outline.U("OnIdleStateChanged(isIdle="), this.isIdle, ")");
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$RequestStartStream;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class RequestStartStream extends Event {
            public static final RequestStartStream INSTANCE = new RequestStartStream();

            private RequestStartStream() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowActivitiesDesktopOnlyDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowActivitiesDesktopOnlyDialog extends Event {
            public static final ShowActivitiesDesktopOnlyDialog INSTANCE = new ShowActivitiesDesktopOnlyDialog();

            private ShowActivitiesDesktopOnlyDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "", "component1", "()I", "guildMaxVideoChannelUsers", "copy", "(I)Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getGuildMaxVideoChannelUsers", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowCameraCapacityDialog extends Event {
            private final int guildMaxVideoChannelUsers;

            public ShowCameraCapacityDialog(int i) {
                super(null);
                this.guildMaxVideoChannelUsers = i;
            }

            public static /* synthetic */ ShowCameraCapacityDialog copy$default(ShowCameraCapacityDialog showCameraCapacityDialog, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showCameraCapacityDialog.guildMaxVideoChannelUsers;
                }
                return showCameraCapacityDialog.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getGuildMaxVideoChannelUsers() {
                return this.guildMaxVideoChannelUsers;
            }

            public final ShowCameraCapacityDialog copy(int guildMaxVideoChannelUsers) {
                return new ShowCameraCapacityDialog(guildMaxVideoChannelUsers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowCameraCapacityDialog) && this.guildMaxVideoChannelUsers == ((ShowCameraCapacityDialog) other).guildMaxVideoChannelUsers;
                }
                return true;
            }

            public final int getGuildMaxVideoChannelUsers() {
                return this.guildMaxVideoChannelUsers;
            }

            public int hashCode() {
                return this.guildMaxVideoChannelUsers;
            }

            public String toString() {
                return outline.B(outline.U("ShowCameraCapacityDialog(guildMaxVideoChannelUsers="), this.guildMaxVideoChannelUsers, ")");
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowGuildVideoAtCapacityDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowGuildVideoAtCapacityDialog extends Event {
            public static final ShowGuildVideoAtCapacityDialog INSTANCE = new ShowGuildVideoAtCapacityDialog();

            private ShowGuildVideoAtCapacityDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowNoScreenSharePermissionDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowNoScreenSharePermissionDialog extends Event {
            public static final ShowNoScreenSharePermissionDialog INSTANCE = new ShowNoScreenSharePermissionDialog();

            private ShowNoScreenSharePermissionDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowNoVadPermissionDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowNoVadPermissionDialog extends Event {
            public static final ShowNoVadPermissionDialog INSTANCE = new ShowNoVadPermissionDialog();

            private ShowNoVadPermissionDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowNoVideoPermissionDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowNoVideoPermissionDialog extends Event {
            public static final ShowNoVideoPermissionDialog INSTANCE = new ShowNoVideoPermissionDialog();

            private ShowNoVideoPermissionDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowRequestCameraPermissionsDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowRequestCameraPermissionsDialog extends Event {
            public static final ShowRequestCameraPermissionsDialog INSTANCE = new ShowRequestCameraPermissionsDialog();

            private ShowRequestCameraPermissionsDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowServerDeafenedDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowServerDeafenedDialog extends Event {
            public static final ShowServerDeafenedDialog INSTANCE = new ShowServerDeafenedDialog();

            private ShowServerDeafenedDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowServerMutedDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowServerMutedDialog extends Event {
            public static final ShowServerMutedDialog INSTANCE = new ShowServerMutedDialog();

            private ShowServerMutedDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowSuppressedDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowSuppressedDialog extends Event {
            public static final ShowSuppressedDialog INSTANCE = new ShowSuppressedDialog();

            private ShowSuppressedDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowTextInVoiceNux;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowTextInVoiceNux extends Event {
            public static final ShowTextInVoiceNux INSTANCE = new ShowTextInVoiceNux();

            private ShowTextInVoiceNux() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J,\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\b\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowUserSheet;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "userId", "channelId", "copy", "(JJ)Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event$ShowUserSheet;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getUserId", "getChannelId", "<init>", "(JJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowUserSheet extends Event {
            private final long channelId;
            private final long userId;

            public ShowUserSheet(long j, long j2) {
                super(null);
                this.userId = j;
                this.channelId = j2;
            }

            public static /* synthetic */ ShowUserSheet copy$default(ShowUserSheet showUserSheet, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = showUserSheet.userId;
                }
                if ((i & 2) != 0) {
                    j2 = showUserSheet.channelId;
                }
                return showUserSheet.copy(j, j2);
            }

            /* renamed from: component1, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final ShowUserSheet copy(long userId, long channelId) {
                return new ShowUserSheet(userId, channelId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowUserSheet)) {
                    return false;
                }
                ShowUserSheet showUserSheet = (ShowUserSheet) other;
                return this.userId == showUserSheet.userId && this.channelId == showUserSheet.channelId;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getUserId() {
                return this.userId;
            }

            public int hashCode() {
                return b.a(this.channelId) + (b.a(this.userId) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ShowUserSheet(userId=");
                sbU.append(this.userId);
                sbU.append(", channelId=");
                return outline.C(sbU, this.channelId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$MenuItem;", "", "<init>", "(Ljava/lang/String;I)V", "LAUNCH_OVERLAY", "CHANNEL_SETTINGS", "VOICE_SETTINGS", "SWITCH_CAMERA", "SHOW_PARTICIPANT_LIST", "TEXT_IN_VOICE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum MenuItem {
        LAUNCH_OVERLAY,
        CHANNEL_SETTINGS,
        VOICE_SETTINGS,
        SWITCH_CAMERA,
        SHOW_PARTICIPANT_LIST,
        TEXT_IN_VOICE
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$OverlayStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "ENABLED", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum OverlayStatus {
        DISABLED,
        ENABLED
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\u0010\n\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\f\b\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\n\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ParticipantTap;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/Timestamp;", "component2", "()J", "participantFocusKey", "timestamp", "copy", "(Ljava/lang/String;J)Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ParticipantTap;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimestamp", "Ljava/lang/String;", "getParticipantFocusKey", "<init>", "(Ljava/lang/String;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ParticipantTap {
        private final String participantFocusKey;
        private final long timestamp;

        public ParticipantTap(String str, long j) {
            Intrinsics3.checkNotNullParameter(str, "participantFocusKey");
            this.participantFocusKey = str;
            this.timestamp = j;
        }

        public static /* synthetic */ ParticipantTap copy$default(ParticipantTap participantTap, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = participantTap.participantFocusKey;
            }
            if ((i & 2) != 0) {
                j = participantTap.timestamp;
            }
            return participantTap.copy(str, j);
        }

        /* renamed from: component1, reason: from getter */
        public final String getParticipantFocusKey() {
            return this.participantFocusKey;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final ParticipantTap copy(String participantFocusKey, long timestamp) {
            Intrinsics3.checkNotNullParameter(participantFocusKey, "participantFocusKey");
            return new ParticipantTap(participantFocusKey, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParticipantTap)) {
                return false;
            }
            ParticipantTap participantTap = (ParticipantTap) other;
            return Intrinsics3.areEqual(this.participantFocusKey, participantTap.participantFocusKey) && this.timestamp == participantTap.timestamp;
        }

        public final String getParticipantFocusKey() {
            return this.participantFocusKey;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            String str = this.participantFocusKey;
            return b.a(this.timestamp) + ((str != null ? str.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ParticipantTap(participantFocusKey=");
            sbU.append(this.participantFocusKey);
            sbU.append(", timestamp=");
            return outline.C(sbU, this.timestamp, ")");
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState$Invalid;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState$Invalid;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Bª\u0001\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010-\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010.\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u0012\u0006\u0010/\u001a\u00020\u000f\u0012\b\u00100\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u00101\u001a\u00020\b\u0012\u0006\u00102\u001a\u00020\u0017\u0012\u0006\u00103\u001a\u00020\u001a\u0012\b\u00104\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u00105\u001a\u00020\b\u0012\u0006\u00106\u001a\u00020\b\u0012\u0006\u00107\u001a\u00020\b\u0012\u0006\u00108\u001a\u00020\u0017\u0012\u0006\u00109\u001a\u00020\u0017\u0012\u0016\u0010:\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`'\u0012\u0004\u0012\u00020(0&ø\u0001\u0000¢\u0006\u0004\b^\u0010_J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010 \u001a\u0004\u0018\u00010\u001dHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b!\u0010\u0016J\u0010\u0010\"\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\"\u0010\u0016J\u0010\u0010#\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b#\u0010\u0016J\u0010\u0010$\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b$\u0010\u0019J\u0010\u0010%\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b%\u0010\u0019J \u0010)\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`'\u0012\u0004\u0012\u00020(0&HÆ\u0003¢\u0006\u0004\b)\u0010*JÖ\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010+\u001a\u00020\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010.\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\b\b\u0002\u0010/\u001a\u00020\u000f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u00101\u001a\u00020\b2\b\b\u0002\u00102\u001a\u00020\u00172\b\b\u0002\u00103\u001a\u00020\u001a2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u00106\u001a\u00020\b2\b\b\u0002\u00107\u001a\u00020\b2\b\b\u0002\u00108\u001a\u00020\u00172\b\b\u0002\u00109\u001a\u00020\u00172\u0018\b\u0002\u0010:\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`'\u0012\u0004\u0012\u00020(0&HÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b;\u0010<J\u0010\u0010?\u001a\u00020>HÖ\u0001¢\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\bA\u0010\u0019J\u001a\u0010D\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010BHÖ\u0003¢\u0006\u0004\bD\u0010ER\u0019\u00106\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010F\u001a\u0004\b6\u0010\u0016R\u0019\u00108\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010G\u001a\u0004\bH\u0010\u0019R\u001b\u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010I\u001a\u0004\bJ\u0010\u0007R\u001b\u0010-\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010K\u001a\u0004\bL\u0010\nR\u0019\u00101\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010F\u001a\u0004\b1\u0010\u0016R\u0019\u00103\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010M\u001a\u0004\bN\u0010\u001cR\u0019\u0010+\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010O\u001a\u0004\bP\u0010\u0004R\u0019\u0010/\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010Q\u001a\u0004\bR\u0010\u0011R$\u00104\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b4\u0010S\u001a\u0004\bT\u0010\u001fR\u001b\u00100\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010U\u001a\u0004\bV\u0010\u0014R\u0019\u00102\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010G\u001a\u0004\bW\u0010\u0019R!\u0010.\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010X\u001a\u0004\bY\u0010\u000eR\u0019\u00105\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010F\u001a\u0004\bZ\u0010\u0016R\u0019\u00107\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010F\u001a\u0004\b7\u0010\u0016R\u0019\u00109\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010G\u001a\u0004\b[\u0010\u0019R)\u0010:\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`'\u0012\u0004\u0012\u00020(0&8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\\\u001a\u0004\b]\u0010*\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006`"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState$Valid;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;", "Lcom/discord/widgets/voice/model/CallModel;", "component1", "()Lcom/discord/widgets/voice/model/CallModel;", "Lcom/discord/widgets/stage/model/StageCallModel;", "component2", "()Lcom/discord/widgets/stage/model/StageCallModel;", "", "component3", "()Ljava/lang/Boolean;", "", "Lcom/discord/api/permission/PermissionBit;", "component4", "()Ljava/lang/Long;", "", "component5", "()F", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "component6", "()Lcom/discord/rtcconnection/RtcConnection$Quality;", "component7", "()Z", "", "component8", "()I", "Lcom/discord/stores/StoreConnectivity$DelayedState;", "component9", "()Lcom/discord/stores/StoreConnectivity$DelayedState;", "Lcom/discord/widgets/stage/StageRoles;", "component10-twRsX-0", "()Lcom/discord/widgets/stage/StageRoles;", "component10", "component11", "component12", "component13", "component14", "component15", "", "Lcom/discord/primitives/ApplicationId;", "Lcom/discord/api/application/ApplicationAsset;", "component16", "()Ljava/util/Map;", "callModel", "stageCallModel", "noiseCancellation", "myPermissions", "streamVolume", "streamQuality", "isScreenReaderEnabled", "totalMentionsCount", "connectivityState", "myStageRoles", "stopOffscreenVideo", "isTextInVoiceEnabled", "isTextInVoiceChannelSelected", "channelMentionsCount", "unreadsCount", "embeddedAppBackgrounds", "copy-G15NlYY", "(Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/widgets/stage/model/StageCallModel;Ljava/lang/Boolean;Ljava/lang/Long;FLcom/discord/rtcconnection/RtcConnection$Quality;ZILcom/discord/stores/StoreConnectivity$DelayedState;Lcom/discord/widgets/stage/StageRoles;ZZZIILjava/util/Map;)Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState$Valid;", "copy", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "I", "getChannelMentionsCount", "Lcom/discord/widgets/stage/model/StageCallModel;", "getStageCallModel", "Ljava/lang/Boolean;", "getNoiseCancellation", "Lcom/discord/stores/StoreConnectivity$DelayedState;", "getConnectivityState", "Lcom/discord/widgets/voice/model/CallModel;", "getCallModel", "F", "getStreamVolume", "Lcom/discord/widgets/stage/StageRoles;", "getMyStageRoles-twRsX-0", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "getStreamQuality", "getTotalMentionsCount", "Ljava/lang/Long;", "getMyPermissions", "getStopOffscreenVideo", "getUnreadsCount", "Ljava/util/Map;", "getEmbeddedAppBackgrounds", "<init>", "(Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/widgets/stage/model/StageCallModel;Ljava/lang/Boolean;Ljava/lang/Long;FLcom/discord/rtcconnection/RtcConnection$Quality;ZILcom/discord/stores/StoreConnectivity$DelayedState;Lcom/discord/widgets/stage/StageRoles;ZZZIILjava/util/Map;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends StoreState {
            private final CallModel callModel;
            private final int channelMentionsCount;
            private final StoreConnectivity.DelayedState connectivityState;
            private final Map<Long, ApplicationAsset> embeddedAppBackgrounds;
            private final boolean isScreenReaderEnabled;
            private final boolean isTextInVoiceChannelSelected;
            private final boolean isTextInVoiceEnabled;
            private final Long myPermissions;
            private final StageRoles myStageRoles;
            private final Boolean noiseCancellation;
            private final StageCallModel stageCallModel;
            private final boolean stopOffscreenVideo;
            private final RtcConnection.Quality streamQuality;
            private final float streamVolume;
            private final int totalMentionsCount;
            private final int unreadsCount;

            public /* synthetic */ Valid(CallModel callModel, StageCallModel stageCallModel, Boolean bool, Long l, float f, RtcConnection.Quality quality, boolean z2, int i, StoreConnectivity.DelayedState delayedState, StageRoles stageRoles, boolean z3, boolean z4, boolean z5, int i2, int i3, Map map, DefaultConstructorMarker defaultConstructorMarker) {
                this(callModel, stageCallModel, bool, l, f, quality, z2, i, delayedState, stageRoles, z3, z4, z5, i2, i3, map);
            }

            /* renamed from: copy-G15NlYY$default, reason: not valid java name */
            public static /* synthetic */ Valid m65copyG15NlYY$default(Valid valid, CallModel callModel, StageCallModel stageCallModel, Boolean bool, Long l, float f, RtcConnection.Quality quality, boolean z2, int i, StoreConnectivity.DelayedState delayedState, StageRoles stageRoles, boolean z3, boolean z4, boolean z5, int i2, int i3, Map map, int i4, Object obj) {
                return valid.m67copyG15NlYY((i4 & 1) != 0 ? valid.callModel : callModel, (i4 & 2) != 0 ? valid.stageCallModel : stageCallModel, (i4 & 4) != 0 ? valid.noiseCancellation : bool, (i4 & 8) != 0 ? valid.myPermissions : l, (i4 & 16) != 0 ? valid.streamVolume : f, (i4 & 32) != 0 ? valid.streamQuality : quality, (i4 & 64) != 0 ? valid.isScreenReaderEnabled : z2, (i4 & 128) != 0 ? valid.totalMentionsCount : i, (i4 & 256) != 0 ? valid.connectivityState : delayedState, (i4 & 512) != 0 ? valid.myStageRoles : stageRoles, (i4 & 1024) != 0 ? valid.stopOffscreenVideo : z3, (i4 & 2048) != 0 ? valid.isTextInVoiceEnabled : z4, (i4 & 4096) != 0 ? valid.isTextInVoiceChannelSelected : z5, (i4 & 8192) != 0 ? valid.channelMentionsCount : i2, (i4 & 16384) != 0 ? valid.unreadsCount : i3, (i4 & 32768) != 0 ? valid.embeddedAppBackgrounds : map);
            }

            /* renamed from: component1, reason: from getter */
            public final CallModel getCallModel() {
                return this.callModel;
            }

            /* renamed from: component10-twRsX-0, reason: not valid java name and from getter */
            public final StageRoles getMyStageRoles() {
                return this.myStageRoles;
            }

            /* renamed from: component11, reason: from getter */
            public final boolean getStopOffscreenVideo() {
                return this.stopOffscreenVideo;
            }

            /* renamed from: component12, reason: from getter */
            public final boolean getIsTextInVoiceEnabled() {
                return this.isTextInVoiceEnabled;
            }

            /* renamed from: component13, reason: from getter */
            public final boolean getIsTextInVoiceChannelSelected() {
                return this.isTextInVoiceChannelSelected;
            }

            /* renamed from: component14, reason: from getter */
            public final int getChannelMentionsCount() {
                return this.channelMentionsCount;
            }

            /* renamed from: component15, reason: from getter */
            public final int getUnreadsCount() {
                return this.unreadsCount;
            }

            public final Map<Long, ApplicationAsset> component16() {
                return this.embeddedAppBackgrounds;
            }

            /* renamed from: component2, reason: from getter */
            public final StageCallModel getStageCallModel() {
                return this.stageCallModel;
            }

            /* renamed from: component3, reason: from getter */
            public final Boolean getNoiseCancellation() {
                return this.noiseCancellation;
            }

            /* renamed from: component4, reason: from getter */
            public final Long getMyPermissions() {
                return this.myPermissions;
            }

            /* renamed from: component5, reason: from getter */
            public final float getStreamVolume() {
                return this.streamVolume;
            }

            /* renamed from: component6, reason: from getter */
            public final RtcConnection.Quality getStreamQuality() {
                return this.streamQuality;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getIsScreenReaderEnabled() {
                return this.isScreenReaderEnabled;
            }

            /* renamed from: component8, reason: from getter */
            public final int getTotalMentionsCount() {
                return this.totalMentionsCount;
            }

            /* renamed from: component9, reason: from getter */
            public final StoreConnectivity.DelayedState getConnectivityState() {
                return this.connectivityState;
            }

            /* renamed from: copy-G15NlYY, reason: not valid java name */
            public final Valid m67copyG15NlYY(CallModel callModel, StageCallModel stageCallModel, Boolean noiseCancellation, Long myPermissions, float streamVolume, RtcConnection.Quality streamQuality, boolean isScreenReaderEnabled, int totalMentionsCount, StoreConnectivity.DelayedState connectivityState, StageRoles myStageRoles, boolean stopOffscreenVideo, boolean isTextInVoiceEnabled, boolean isTextInVoiceChannelSelected, int channelMentionsCount, int unreadsCount, Map<Long, ApplicationAsset> embeddedAppBackgrounds) {
                Intrinsics3.checkNotNullParameter(callModel, "callModel");
                Intrinsics3.checkNotNullParameter(connectivityState, "connectivityState");
                Intrinsics3.checkNotNullParameter(embeddedAppBackgrounds, "embeddedAppBackgrounds");
                return new Valid(callModel, stageCallModel, noiseCancellation, myPermissions, streamVolume, streamQuality, isScreenReaderEnabled, totalMentionsCount, connectivityState, myStageRoles, stopOffscreenVideo, isTextInVoiceEnabled, isTextInVoiceChannelSelected, channelMentionsCount, unreadsCount, embeddedAppBackgrounds);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.callModel, valid.callModel) && Intrinsics3.areEqual(this.stageCallModel, valid.stageCallModel) && Intrinsics3.areEqual(this.noiseCancellation, valid.noiseCancellation) && Intrinsics3.areEqual(this.myPermissions, valid.myPermissions) && Float.compare(this.streamVolume, valid.streamVolume) == 0 && Intrinsics3.areEqual(this.streamQuality, valid.streamQuality) && this.isScreenReaderEnabled == valid.isScreenReaderEnabled && this.totalMentionsCount == valid.totalMentionsCount && Intrinsics3.areEqual(this.connectivityState, valid.connectivityState) && Intrinsics3.areEqual(this.myStageRoles, valid.myStageRoles) && this.stopOffscreenVideo == valid.stopOffscreenVideo && this.isTextInVoiceEnabled == valid.isTextInVoiceEnabled && this.isTextInVoiceChannelSelected == valid.isTextInVoiceChannelSelected && this.channelMentionsCount == valid.channelMentionsCount && this.unreadsCount == valid.unreadsCount && Intrinsics3.areEqual(this.embeddedAppBackgrounds, valid.embeddedAppBackgrounds);
            }

            public final CallModel getCallModel() {
                return this.callModel;
            }

            public final int getChannelMentionsCount() {
                return this.channelMentionsCount;
            }

            public final StoreConnectivity.DelayedState getConnectivityState() {
                return this.connectivityState;
            }

            public final Map<Long, ApplicationAsset> getEmbeddedAppBackgrounds() {
                return this.embeddedAppBackgrounds;
            }

            public final Long getMyPermissions() {
                return this.myPermissions;
            }

            /* renamed from: getMyStageRoles-twRsX-0, reason: not valid java name */
            public final StageRoles m68getMyStageRolestwRsX0() {
                return this.myStageRoles;
            }

            public final Boolean getNoiseCancellation() {
                return this.noiseCancellation;
            }

            public final StageCallModel getStageCallModel() {
                return this.stageCallModel;
            }

            public final boolean getStopOffscreenVideo() {
                return this.stopOffscreenVideo;
            }

            public final RtcConnection.Quality getStreamQuality() {
                return this.streamQuality;
            }

            public final float getStreamVolume() {
                return this.streamVolume;
            }

            public final int getTotalMentionsCount() {
                return this.totalMentionsCount;
            }

            public final int getUnreadsCount() {
                return this.unreadsCount;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                CallModel callModel = this.callModel;
                int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
                StageCallModel stageCallModel = this.stageCallModel;
                int iHashCode2 = (iHashCode + (stageCallModel != null ? stageCallModel.hashCode() : 0)) * 31;
                Boolean bool = this.noiseCancellation;
                int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
                Long l = this.myPermissions;
                int iFloatToIntBits = (Float.floatToIntBits(this.streamVolume) + ((iHashCode3 + (l != null ? l.hashCode() : 0)) * 31)) * 31;
                RtcConnection.Quality quality = this.streamQuality;
                int iHashCode4 = (iFloatToIntBits + (quality != null ? quality.hashCode() : 0)) * 31;
                boolean z2 = this.isScreenReaderEnabled;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (((iHashCode4 + i) * 31) + this.totalMentionsCount) * 31;
                StoreConnectivity.DelayedState delayedState = this.connectivityState;
                int iHashCode5 = (i2 + (delayedState != null ? delayedState.hashCode() : 0)) * 31;
                StageRoles stageRoles = this.myStageRoles;
                int iHashCode6 = (iHashCode5 + (stageRoles != null ? stageRoles.hashCode() : 0)) * 31;
                boolean z3 = this.stopOffscreenVideo;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (iHashCode6 + i3) * 31;
                boolean z4 = this.isTextInVoiceEnabled;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.isTextInVoiceChannelSelected;
                int i7 = (((((i6 + (z5 ? 1 : z5 ? 1 : 0)) * 31) + this.channelMentionsCount) * 31) + this.unreadsCount) * 31;
                Map<Long, ApplicationAsset> map = this.embeddedAppBackgrounds;
                return i7 + (map != null ? map.hashCode() : 0);
            }

            public final boolean isScreenReaderEnabled() {
                return this.isScreenReaderEnabled;
            }

            public final boolean isTextInVoiceChannelSelected() {
                return this.isTextInVoiceChannelSelected;
            }

            public final boolean isTextInVoiceEnabled() {
                return this.isTextInVoiceEnabled;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(callModel=");
                sbU.append(this.callModel);
                sbU.append(", stageCallModel=");
                sbU.append(this.stageCallModel);
                sbU.append(", noiseCancellation=");
                sbU.append(this.noiseCancellation);
                sbU.append(", myPermissions=");
                sbU.append(this.myPermissions);
                sbU.append(", streamVolume=");
                sbU.append(this.streamVolume);
                sbU.append(", streamQuality=");
                sbU.append(this.streamQuality);
                sbU.append(", isScreenReaderEnabled=");
                sbU.append(this.isScreenReaderEnabled);
                sbU.append(", totalMentionsCount=");
                sbU.append(this.totalMentionsCount);
                sbU.append(", connectivityState=");
                sbU.append(this.connectivityState);
                sbU.append(", myStageRoles=");
                sbU.append(this.myStageRoles);
                sbU.append(", stopOffscreenVideo=");
                sbU.append(this.stopOffscreenVideo);
                sbU.append(", isTextInVoiceEnabled=");
                sbU.append(this.isTextInVoiceEnabled);
                sbU.append(", isTextInVoiceChannelSelected=");
                sbU.append(this.isTextInVoiceChannelSelected);
                sbU.append(", channelMentionsCount=");
                sbU.append(this.channelMentionsCount);
                sbU.append(", unreadsCount=");
                sbU.append(this.unreadsCount);
                sbU.append(", embeddedAppBackgrounds=");
                return outline.M(sbU, this.embeddedAppBackgrounds, ")");
            }

            private Valid(CallModel callModel, StageCallModel stageCallModel, Boolean bool, Long l, float f, RtcConnection.Quality quality, boolean z2, int i, StoreConnectivity.DelayedState delayedState, StageRoles stageRoles, boolean z3, boolean z4, boolean z5, int i2, int i3, Map<Long, ApplicationAsset> map) {
                super(null);
                this.callModel = callModel;
                this.stageCallModel = stageCallModel;
                this.noiseCancellation = bool;
                this.myPermissions = l;
                this.streamVolume = f;
                this.streamQuality = quality;
                this.isScreenReaderEnabled = z2;
                this.totalMentionsCount = i;
                this.connectivityState = delayedState;
                this.myStageRoles = stageRoles;
                this.stopOffscreenVideo = z3;
                this.isTextInVoiceEnabled = z4;
                this.isTextInVoiceChannelSelected = z5;
                this.channelMentionsCount = i2;
                this.unreadsCount = i3;
                this.embeddedAppBackgrounds = map;
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Uninitialized", "Valid", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState$Invalid;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState$Invalid;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\bF\b\u0086\b\u0018\u00002\u00020\u0001BÒ\u0002\u0012\u0006\u0010U\u001a\u00020\u000f\u0012\b\u0010V\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010W\u001a\u00020\u0015\u0012\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00180\b\u0012\u0006\u0010Y\u001a\u00020\u0002\u0012\u0006\u0010Z\u001a\u00020\u0002\u0012\u0006\u0010[\u001a\u00020\u0002\u0012\u0006\u0010\\\u001a\u00020\u0002\u0012\u0006\u0010]\u001a\u00020 \u0012\u0006\u0010^\u001a\u00020#\u0012\u0006\u0010_\u001a\u00020&\u0012\b\u0010`\u001a\u0004\u0018\u00010)\u0012\u0006\u0010a\u001a\u00020\u0002\u0012\b\u0010b\u001a\u0004\u0018\u00010-\u0012\b\u0010c\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010d\u001a\b\u0012\u0004\u0012\u0002020\b\u0012\u0006\u0010e\u001a\u00020\u0002\u0012\u0006\u0010f\u001a\u00020\u0002\u0012\u0006\u0010g\u001a\u00020\u0002\u0012\u0006\u0010h\u001a\u000207\u0012\u0006\u0010i\u001a\u00020:\u0012\u0006\u0010j\u001a\u00020\u0002\u0012\b\u0010k\u001a\u0004\u0018\u00010>\u0012\u0006\u0010l\u001a\u00020\u0002\u0012\u0006\u0010m\u001a\u00020\u0002\u0012\u0006\u0010n\u001a\u00020:\u0012\u0006\u0010o\u001a\u00020\u0002\u0012\u000e\u0010p\u001a\n\u0018\u00010Fj\u0004\u0018\u0001`G\u0012\b\u0010q\u001a\u0004\u0018\u00010J\u0012\b\u0010r\u001a\u0004\u0018\u00010J\u0012\u0006\u0010s\u001a\u00020:\u0012\u0006\u0010t\u001a\u00020:\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010u\u001a\u00020\u0002\u0012\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020-0Rø\u0001\u0000¢\u0006\u0006\bÀ\u0001\u0010Á\u0001JM\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001cJ\u0010\u0010!\u001a\u00020 HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010*\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u001cJ\u0012\u0010.\u001a\u0004\u0018\u00010-HÆ\u0003¢\u0006\u0004\b.\u0010/J\u0012\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u00101J\u0016\u00103\u001a\b\u0012\u0004\u0012\u0002020\bHÆ\u0003¢\u0006\u0004\b3\u0010\u001aJ\u0010\u00104\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b4\u0010\u001cJ\u0010\u00105\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b5\u0010\u001cJ\u0010\u00106\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b6\u0010\u001cJ\u0010\u00108\u001a\u000207HÆ\u0003¢\u0006\u0004\b8\u00109J\u0010\u0010;\u001a\u00020:HÆ\u0003¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b=\u0010\u001cJ\u001b\u0010A\u001a\u0004\u0018\u00010>HÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b?\u0010@J\u0010\u0010B\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\bB\u0010\u001cJ\u0010\u0010C\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\bC\u0010\u001cJ\u0010\u0010D\u001a\u00020:HÆ\u0003¢\u0006\u0004\bD\u0010<J\u0010\u0010E\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\bE\u0010\u001cJ\u0018\u0010H\u001a\n\u0018\u00010Fj\u0004\u0018\u0001`GHÆ\u0003¢\u0006\u0004\bH\u0010IJ\u0012\u0010K\u001a\u0004\u0018\u00010JHÆ\u0003¢\u0006\u0004\bK\u0010LJ\u0012\u0010M\u001a\u0004\u0018\u00010JHÆ\u0003¢\u0006\u0004\bM\u0010LJ\u0010\u0010N\u001a\u00020:HÆ\u0003¢\u0006\u0004\bN\u0010<J\u0010\u0010O\u001a\u00020:HÆ\u0003¢\u0006\u0004\bO\u0010<J\u0010\u0010P\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\bP\u0010\u001cJ\u0010\u0010Q\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\bQ\u0010\u001cJ\u001c\u0010S\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020-0RHÆ\u0003¢\u0006\u0004\bS\u0010TJ¢\u0003\u0010y\u001a\u00020\u00002\b\b\u0002\u0010U\u001a\u00020\u000f2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010W\u001a\u00020\u00152\u000e\b\u0002\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\b\b\u0002\u0010Y\u001a\u00020\u00022\b\b\u0002\u0010Z\u001a\u00020\u00022\b\b\u0002\u0010[\u001a\u00020\u00022\b\b\u0002\u0010\\\u001a\u00020\u00022\b\b\u0002\u0010]\u001a\u00020 2\b\b\u0002\u0010^\u001a\u00020#2\b\b\u0002\u0010_\u001a\u00020&2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010a\u001a\u00020\u00022\n\b\u0002\u0010b\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010d\u001a\b\u0012\u0004\u0012\u0002020\b2\b\b\u0002\u0010e\u001a\u00020\u00022\b\b\u0002\u0010f\u001a\u00020\u00022\b\b\u0002\u0010g\u001a\u00020\u00022\b\b\u0002\u0010h\u001a\u0002072\b\b\u0002\u0010i\u001a\u00020:2\b\b\u0002\u0010j\u001a\u00020\u00022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010l\u001a\u00020\u00022\b\b\u0002\u0010m\u001a\u00020\u00022\b\b\u0002\u0010n\u001a\u00020:2\b\b\u0002\u0010o\u001a\u00020\u00022\u0010\b\u0002\u0010p\u001a\n\u0018\u00010Fj\u0004\u0018\u0001`G2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010J2\b\b\u0002\u0010s\u001a\u00020:2\b\b\u0002\u0010t\u001a\u00020:2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010u\u001a\u00020\u00022\u0014\b\u0002\u0010v\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020-0RHÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\bw\u0010xJ\u0010\u0010z\u001a\u00020)HÖ\u0001¢\u0006\u0004\bz\u0010+J\u0010\u0010{\u001a\u00020:HÖ\u0001¢\u0006\u0004\b{\u0010<J\u001a\u0010~\u001a\u00020\u00022\b\u0010}\u001a\u0004\u0018\u00010|HÖ\u0003¢\u0006\u0004\b~\u0010\u007fR\u001b\u0010^\u001a\u00020#8\u0006@\u0006¢\u0006\u000e\n\u0005\b^\u0010\u0080\u0001\u001a\u0005\b\u0081\u0001\u0010%R\u001d\u0010\u0082\u0001\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0005\b\u0084\u0001\u0010\u001cR\u001b\u0010t\u001a\u00020:8\u0006@\u0006¢\u0006\u000e\n\u0005\bt\u0010\u0085\u0001\u001a\u0005\b\u0086\u0001\u0010<R\u001d\u0010c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000e\n\u0005\bc\u0010\u0087\u0001\u001a\u0005\b\u0088\u0001\u00101R\u001b\u0010U\u001a\u00020\u000f8\u0006@\u0006¢\u0006\u000e\n\u0005\bU\u0010\u0089\u0001\u001a\u0005\b\u008a\u0001\u0010\u0011R&\u0010k\u001a\u0004\u0018\u00010>8\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u000e\n\u0005\bk\u0010\u008b\u0001\u001a\u0005\b\u008c\u0001\u0010@R\u001d\u0010\u008d\u0001\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000f\n\u0006\b\u008d\u0001\u0010\u0083\u0001\u001a\u0005\b\u008d\u0001\u0010\u001cR\u001a\u0010m\u001a\u00020\u00028\u0006@\u0006¢\u0006\r\n\u0005\bm\u0010\u0083\u0001\u001a\u0004\bm\u0010\u001cR\u001a\u0010Y\u001a\u00020\u00028\u0006@\u0006¢\u0006\r\n\u0005\bY\u0010\u0083\u0001\u001a\u0004\bY\u0010\u001cR\u001a\u0010a\u001a\u00020\u00028\u0006@\u0006¢\u0006\r\n\u0005\ba\u0010\u0083\u0001\u001a\u0004\ba\u0010\u001cR(\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F@\u0006X\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R'\u0010v\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020-0R8\u0006@\u0006¢\u0006\u000e\n\u0005\bv\u0010\u0093\u0001\u001a\u0005\b\u0094\u0001\u0010TR\u001d\u0010\u0095\u0001\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0095\u0001\u0010\u0083\u0001\u001a\u0005\b\u0095\u0001\u0010\u001cR\u001b\u0010o\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000e\n\u0005\bo\u0010\u0083\u0001\u001a\u0005\b\u0096\u0001\u0010\u001cR#\u0010\u0099\u0001\u001a\u0004\u0018\u00010)8F@\u0006X\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b\u0097\u0001\u0010\u008f\u0001\u001a\u0005\b\u0098\u0001\u0010+R\u001b\u0010W\u001a\u00020\u00158\u0006@\u0006¢\u0006\u000e\n\u0005\bW\u0010\u009a\u0001\u001a\u0005\b\u009b\u0001\u0010\u0017R\u001b\u0010n\u001a\u00020:8\u0006@\u0006¢\u0006\u000e\n\u0005\bn\u0010\u0085\u0001\u001a\u0005\b\u009c\u0001\u0010<R\u001a\u0010u\u001a\u00020\u00028\u0006@\u0006¢\u0006\r\n\u0005\bu\u0010\u0083\u0001\u001a\u0004\bu\u0010\u001cR!\u0010d\u001a\b\u0012\u0004\u0012\u0002020\b8\u0006@\u0006¢\u0006\u000e\n\u0005\bd\u0010\u009d\u0001\u001a\u0005\b\u009e\u0001\u0010\u001aR!\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00180\b8\u0006@\u0006¢\u0006\u000e\n\u0005\bX\u0010\u009d\u0001\u001a\u0005\b\u009f\u0001\u0010\u001aR\u001b\u0010j\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000e\n\u0005\bj\u0010\u0083\u0001\u001a\u0005\b \u0001\u0010\u001cR\u001a\u0010l\u001a\u00020\u00028\u0006@\u0006¢\u0006\r\n\u0005\bl\u0010\u0083\u0001\u001a\u0004\bl\u0010\u001cR#\u0010p\u001a\n\u0018\u00010Fj\u0004\u0018\u0001`G8\u0006@\u0006¢\u0006\u000e\n\u0005\bp\u0010¡\u0001\u001a\u0005\b¢\u0001\u0010IR\u001b\u0010]\u001a\u00020 8\u0006@\u0006¢\u0006\u000e\n\u0005\b]\u0010£\u0001\u001a\u0005\b¤\u0001\u0010\"R\u001d\u0010b\u001a\u0004\u0018\u00010-8\u0006@\u0006¢\u0006\u000e\n\u0005\bb\u0010¥\u0001\u001a\u0005\b¦\u0001\u0010/R\u001d\u0010§\u0001\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000f\n\u0006\b§\u0001\u0010\u0083\u0001\u001a\u0005\b¨\u0001\u0010\u001cR\u001d\u0010©\u0001\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000f\n\u0006\b©\u0001\u0010\u0083\u0001\u001a\u0005\b©\u0001\u0010\u001cR\u001a\u0010\\\u001a\u00020\u00028\u0006@\u0006¢\u0006\r\n\u0005\b\\\u0010\u0083\u0001\u001a\u0004\b\\\u0010\u001cR\u001d\u0010ª\u0001\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000f\n\u0006\bª\u0001\u0010\u0083\u0001\u001a\u0005\bª\u0001\u0010\u001cR\u001d\u0010«\u0001\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000f\n\u0006\b«\u0001\u0010\u0083\u0001\u001a\u0005\b¬\u0001\u0010\u001cR\u001b\u0010s\u001a\u00020:8\u0006@\u0006¢\u0006\u000e\n\u0005\bs\u0010\u0085\u0001\u001a\u0005\b\u00ad\u0001\u0010<R#\u0010°\u0001\u001a\u0004\u0018\u00010)8F@\u0006X\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b®\u0001\u0010\u008f\u0001\u001a\u0005\b¯\u0001\u0010+R\u001d\u0010q\u001a\u0004\u0018\u00010J8\u0006@\u0006¢\u0006\u000e\n\u0005\bq\u0010±\u0001\u001a\u0005\b²\u0001\u0010LR\u001b\u0010i\u001a\u00020:8\u0006@\u0006¢\u0006\u000e\n\u0005\bi\u0010\u0085\u0001\u001a\u0005\b³\u0001\u0010<R\u001b\u0010_\u001a\u00020&8\u0006@\u0006¢\u0006\u000e\n\u0005\b_\u0010´\u0001\u001a\u0005\bµ\u0001\u0010(R\u001b\u0010h\u001a\u0002078\u0006@\u0006¢\u0006\u000e\n\u0005\bh\u0010¶\u0001\u001a\u0005\b·\u0001\u00109R\u001d\u0010V\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000e\n\u0005\bV\u0010¸\u0001\u001a\u0005\b¹\u0001\u0010\u0014R\u001a\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\r\n\u0005\b\n\u0010\u0083\u0001\u001a\u0004\b\n\u0010\u001cR\u001d\u0010r\u001a\u0004\u0018\u00010J8\u0006@\u0006¢\u0006\u000e\n\u0005\br\u0010±\u0001\u001a\u0005\bº\u0001\u0010LR\u001b\u0010f\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000e\n\u0005\bf\u0010\u0083\u0001\u001a\u0005\b»\u0001\u0010\u001cR\u001b\u0010e\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000e\n\u0005\be\u0010\u0083\u0001\u001a\u0005\b¼\u0001\u0010\u001cR\u001b\u0010g\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000e\n\u0005\bg\u0010\u0083\u0001\u001a\u0005\b½\u0001\u0010\u001cR\u001a\u0010Z\u001a\u00020\u00028\u0006@\u0006¢\u0006\r\n\u0005\bZ\u0010\u0083\u0001\u001a\u0004\bZ\u0010\u001cR\u001a\u0010[\u001a\u00020\u00028\u0006@\u0006¢\u0006\r\n\u0005\b[\u0010\u0083\u0001\u001a\u0004\b[\u0010\u001cR\u001d\u0010`\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\u000e\n\u0005\b`\u0010¾\u0001\u001a\u0005\b¿\u0001\u0010+\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006Â\u0001"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState$Valid;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState;", "", "canManageChannel", "isConnected", "isStageChannel", "Lco/discord/media_engine/VideoInputDeviceDescription;", "selectedVideoInputDevice", "", "availableVideoInputDevices", "isTextInVoiceEnabled", "", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$MenuItem;", "computeMenuItems", "(ZZZLco/discord/media_engine/VideoInputDeviceDescription;Ljava/util/List;Z)Ljava/util/Set;", "Lcom/discord/widgets/voice/model/CallModel;", "component1", "()Lcom/discord/widgets/voice/model/CallModel;", "Lcom/discord/widgets/stage/model/StageCallModel;", "component2", "()Lcom/discord/widgets/stage/model/StageCallModel;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$OverlayStatus;", "component3", "()Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$OverlayStatus;", "Lcom/discord/widgets/voice/fullscreen/CallParticipant;", "component4", "()Ljava/util/List;", "component5", "()Z", "component6", "component7", "component8", "Lcom/discord/widgets/voice/model/CameraState;", "component9", "()Lcom/discord/widgets/voice/model/CameraState;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$DisplayMode;", "component10", "()Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$DisplayMode;", "Lcom/discord/widgets/voice/controls/VoiceControlsOutputSelectorState;", "component11", "()Lcom/discord/widgets/voice/controls/VoiceControlsOutputSelectorState;", "", "component12", "()Ljava/lang/String;", "component13", "Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "component14", "()Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "component15", "()Ljava/lang/Boolean;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component16", "component17", "component18", "component19", "", "component20", "()F", "", "component21", "()I", "component22", "Lcom/discord/widgets/stage/StageRoles;", "component23-twRsX-0", "()Lcom/discord/widgets/stage/StageRoles;", "component23", "component24", "component25", "component26", "component27", "", "Lcom/discord/api/permission/PermissionBit;", "component28", "()Ljava/lang/Long;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component29", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component30", "component31", "component32", "component33", "component34", "", "component35", "()Ljava/util/Map;", "callModel", "stageCallModel", "overlayStatus", "visibleVideoParticipants", "isIdleFooter", "isIdleHeader", "isControlFadingDisabled", "isSwitchCameraButtonVisible", "cameraState", "displayMode", "outputSelectorState", "focusedParticipantKey", "isAnyoneUsingVideo", "pipParticipant", "noiseCancellation", "privateCallUserListItems", "showParticipantsHiddenView", "lockCallScreenControls", "startedAsVideo", "perceptualStreamVolume", "totalMentionsCount", "showLowConnectivityBar", "stageRoles", "isUpdatingRequestToSpeak", "isMovingToAudience", "requestingToSpeakCount", "stopOffscreenVideo", "channelPermissions", "startableEvent", "activeEvent", "textInVoiceMentionsCount", "textInVoiceUnreadsCount", "isTextInVoiceChannelSelected", "allVideoParticipants", "copy-J3xfKWQ", "(Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/widgets/stage/model/StageCallModel;Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$OverlayStatus;Ljava/util/List;ZZZZLcom/discord/widgets/voice/model/CameraState;Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$DisplayMode;Lcom/discord/widgets/voice/controls/VoiceControlsOutputSelectorState;Ljava/lang/String;ZLcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;Ljava/lang/Boolean;Ljava/util/List;ZZZFIZLcom/discord/widgets/stage/StageRoles;ZZIZLjava/lang/Long;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;IIZZLjava/util/Map;)Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState$Valid;", "copy", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$DisplayMode;", "getDisplayMode", "showHeader", "Z", "getShowHeader", "I", "getTextInVoiceUnreadsCount", "Ljava/lang/Boolean;", "getNoiseCancellation", "Lcom/discord/widgets/voice/model/CallModel;", "getCallModel", "Lcom/discord/widgets/stage/StageRoles;", "getStageRoles-twRsX-0", "isDeafened", "menuItems$delegate", "Lkotlin/Lazy;", "getMenuItems", "()Ljava/util/Set;", "menuItems", "Ljava/util/Map;", "getAllVideoParticipants", "isStreamFocused", "getStopOffscreenVideo", "titleText$delegate", "getTitleText", "titleText", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$OverlayStatus;", "getOverlayStatus", "getRequestingToSpeakCount", "Ljava/util/List;", "getPrivateCallUserListItems", "getVisibleVideoParticipants", "getShowLowConnectivityBar", "Ljava/lang/Long;", "getChannelPermissions", "Lcom/discord/widgets/voice/model/CameraState;", "getCameraState", "Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "getPipParticipant", "showFooter", "getShowFooter", "isPushToTalk", "isVideoCallGridVisible", "showStreamVolume", "getShowStreamVolume", "getTextInVoiceMentionsCount", "analyticsVideoLayout$delegate", "getAnalyticsVideoLayout", "analyticsVideoLayout", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getStartableEvent", "getTotalMentionsCount", "Lcom/discord/widgets/voice/controls/VoiceControlsOutputSelectorState;", "getOutputSelectorState", "F", "getPerceptualStreamVolume", "Lcom/discord/widgets/stage/model/StageCallModel;", "getStageCallModel", "getActiveEvent", "getLockCallScreenControls", "getShowParticipantsHiddenView", "getStartedAsVideo", "Ljava/lang/String;", "getFocusedParticipantKey", "<init>", "(Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/widgets/stage/model/StageCallModel;Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$OverlayStatus;Ljava/util/List;ZZZZLcom/discord/widgets/voice/model/CameraState;Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$DisplayMode;Lcom/discord/widgets/voice/controls/VoiceControlsOutputSelectorState;Ljava/lang/String;ZLcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;Ljava/lang/Boolean;Ljava/util/List;ZZZFIZLcom/discord/widgets/stage/StageRoles;ZZIZLjava/lang/Long;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;IIZZLjava/util/Map;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends ViewState {
            private final GuildScheduledEvent activeEvent;
            private final Map<String, CallParticipant.UserOrStreamParticipant> allVideoParticipants;

            /* renamed from: analyticsVideoLayout$delegate, reason: from kotlin metadata */
            private final Lazy analyticsVideoLayout;
            private final CallModel callModel;
            private final CameraState cameraState;
            private final Long channelPermissions;
            private final DisplayMode displayMode;
            private final String focusedParticipantKey;
            private final boolean isAnyoneUsingVideo;
            private final boolean isControlFadingDisabled;
            private final boolean isDeafened;
            private final boolean isIdleFooter;
            private final boolean isIdleHeader;
            private final boolean isMovingToAudience;
            private final boolean isPushToTalk;
            private final boolean isStreamFocused;
            private final boolean isSwitchCameraButtonVisible;
            private final boolean isTextInVoiceChannelSelected;
            private final boolean isTextInVoiceEnabled;
            private final boolean isUpdatingRequestToSpeak;
            private final boolean isVideoCallGridVisible;
            private final boolean lockCallScreenControls;

            /* renamed from: menuItems$delegate, reason: from kotlin metadata */
            private final Lazy menuItems;
            private final Boolean noiseCancellation;
            private final VoiceControlsOutputSelectorState outputSelectorState;
            private final OverlayStatus overlayStatus;
            private final float perceptualStreamVolume;
            private final CallParticipant.UserOrStreamParticipant pipParticipant;
            private final List<StoreVoiceParticipants.VoiceUser> privateCallUserListItems;
            private final int requestingToSpeakCount;
            private final boolean showFooter;
            private final boolean showHeader;
            private final boolean showLowConnectivityBar;
            private final boolean showParticipantsHiddenView;
            private final boolean showStreamVolume;
            private final StageCallModel stageCallModel;
            private final StageRoles stageRoles;
            private final GuildScheduledEvent startableEvent;
            private final boolean startedAsVideo;
            private final boolean stopOffscreenVideo;
            private final int textInVoiceMentionsCount;
            private final int textInVoiceUnreadsCount;

            /* renamed from: titleText$delegate, reason: from kotlin metadata */
            private final Lazy titleText;
            private final int totalMentionsCount;
            private final List<CallParticipant> visibleVideoParticipants;

            public /* synthetic */ Valid(CallModel callModel, StageCallModel stageCallModel, OverlayStatus overlayStatus, List list, boolean z2, boolean z3, boolean z4, boolean z5, CameraState cameraState, DisplayMode displayMode, VoiceControlsOutputSelectorState voiceControlsOutputSelectorState, String str, boolean z6, CallParticipant.UserOrStreamParticipant userOrStreamParticipant, Boolean bool, List list2, boolean z7, boolean z8, boolean z9, float f, int i, boolean z10, StageRoles stageRoles, boolean z11, boolean z12, int i2, boolean z13, Long l, GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2, int i3, int i4, boolean z14, boolean z15, Map map, DefaultConstructorMarker defaultConstructorMarker) {
                this(callModel, stageCallModel, overlayStatus, list, z2, z3, z4, z5, cameraState, displayMode, voiceControlsOutputSelectorState, str, z6, userOrStreamParticipant, bool, list2, z7, z8, z9, f, i, z10, stageRoles, z11, z12, i2, z13, l, guildScheduledEvent, guildScheduledEvent2, i3, i4, z14, z15, map);
            }

            public static final /* synthetic */ Set access$computeMenuItems(Valid valid, boolean z2, boolean z3, boolean z4, DeviceDescription4 deviceDescription4, List list, boolean z5) {
                return valid.computeMenuItems(z2, z3, z4, deviceDescription4, list, z5);
            }

            private final Set<MenuItem> computeMenuItems(boolean canManageChannel, boolean isConnected, boolean isStageChannel, DeviceDescription4 selectedVideoInputDevice, List<DeviceDescription4> availableVideoInputDevices, boolean isTextInVoiceEnabled) {
                HashSet hashSetHashSetOf = Sets5.hashSetOf(MenuItem.VOICE_SETTINGS);
                if (canManageChannel) {
                    hashSetHashSetOf.add(MenuItem.CHANNEL_SETTINGS);
                }
                if (isConnected && StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled()) {
                    hashSetHashSetOf.add(MenuItem.LAUNCH_OVERLAY);
                }
                if (selectedVideoInputDevice != null && availableVideoInputDevices.size() > 1) {
                    hashSetHashSetOf.add(MenuItem.SWITCH_CAMERA);
                }
                if (!isStageChannel && isTextInVoiceEnabled) {
                    hashSetHashSetOf.add(MenuItem.TEXT_IN_VOICE);
                }
                if (!isStageChannel) {
                    hashSetHashSetOf.add(MenuItem.SHOW_PARTICIPANT_LIST);
                }
                return hashSetHashSetOf;
            }

            /* renamed from: copy-J3xfKWQ$default, reason: not valid java name */
            public static /* synthetic */ Valid m69copyJ3xfKWQ$default(Valid valid, CallModel callModel, StageCallModel stageCallModel, OverlayStatus overlayStatus, List list, boolean z2, boolean z3, boolean z4, boolean z5, CameraState cameraState, DisplayMode displayMode, VoiceControlsOutputSelectorState voiceControlsOutputSelectorState, String str, boolean z6, CallParticipant.UserOrStreamParticipant userOrStreamParticipant, Boolean bool, List list2, boolean z7, boolean z8, boolean z9, float f, int i, boolean z10, StageRoles stageRoles, boolean z11, boolean z12, int i2, boolean z13, Long l, GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2, int i3, int i4, boolean z14, boolean z15, Map map, int i5, int i6, Object obj) {
                return valid.m71copyJ3xfKWQ((i5 & 1) != 0 ? valid.callModel : callModel, (i5 & 2) != 0 ? valid.stageCallModel : stageCallModel, (i5 & 4) != 0 ? valid.overlayStatus : overlayStatus, (i5 & 8) != 0 ? valid.visibleVideoParticipants : list, (i5 & 16) != 0 ? valid.isIdleFooter : z2, (i5 & 32) != 0 ? valid.isIdleHeader : z3, (i5 & 64) != 0 ? valid.isControlFadingDisabled : z4, (i5 & 128) != 0 ? valid.isSwitchCameraButtonVisible : z5, (i5 & 256) != 0 ? valid.cameraState : cameraState, (i5 & 512) != 0 ? valid.displayMode : displayMode, (i5 & 1024) != 0 ? valid.outputSelectorState : voiceControlsOutputSelectorState, (i5 & 2048) != 0 ? valid.focusedParticipantKey : str, (i5 & 4096) != 0 ? valid.isAnyoneUsingVideo : z6, (i5 & 8192) != 0 ? valid.pipParticipant : userOrStreamParticipant, (i5 & 16384) != 0 ? valid.noiseCancellation : bool, (i5 & 32768) != 0 ? valid.privateCallUserListItems : list2, (i5 & 65536) != 0 ? valid.showParticipantsHiddenView : z7, (i5 & 131072) != 0 ? valid.lockCallScreenControls : z8, (i5 & 262144) != 0 ? valid.startedAsVideo : z9, (i5 & 524288) != 0 ? valid.perceptualStreamVolume : f, (i5 & 1048576) != 0 ? valid.totalMentionsCount : i, (i5 & 2097152) != 0 ? valid.showLowConnectivityBar : z10, (i5 & 4194304) != 0 ? valid.stageRoles : stageRoles, (i5 & 8388608) != 0 ? valid.isUpdatingRequestToSpeak : z11, (i5 & 16777216) != 0 ? valid.isMovingToAudience : z12, (i5 & 33554432) != 0 ? valid.requestingToSpeakCount : i2, (i5 & 67108864) != 0 ? valid.stopOffscreenVideo : z13, (i5 & 134217728) != 0 ? valid.channelPermissions : l, (i5 & 268435456) != 0 ? valid.startableEvent : guildScheduledEvent, (i5 & 536870912) != 0 ? valid.activeEvent : guildScheduledEvent2, (i5 & BasicMeasure.EXACTLY) != 0 ? valid.textInVoiceMentionsCount : i3, (i5 & Integer.MIN_VALUE) != 0 ? valid.textInVoiceUnreadsCount : i4, (i6 & 1) != 0 ? valid.isTextInVoiceEnabled : z14, (i6 & 2) != 0 ? valid.isTextInVoiceChannelSelected : z15, (i6 & 4) != 0 ? valid.allVideoParticipants : map);
            }

            /* renamed from: component1, reason: from getter */
            public final CallModel getCallModel() {
                return this.callModel;
            }

            /* renamed from: component10, reason: from getter */
            public final DisplayMode getDisplayMode() {
                return this.displayMode;
            }

            /* renamed from: component11, reason: from getter */
            public final VoiceControlsOutputSelectorState getOutputSelectorState() {
                return this.outputSelectorState;
            }

            /* renamed from: component12, reason: from getter */
            public final String getFocusedParticipantKey() {
                return this.focusedParticipantKey;
            }

            /* renamed from: component13, reason: from getter */
            public final boolean getIsAnyoneUsingVideo() {
                return this.isAnyoneUsingVideo;
            }

            /* renamed from: component14, reason: from getter */
            public final CallParticipant.UserOrStreamParticipant getPipParticipant() {
                return this.pipParticipant;
            }

            /* renamed from: component15, reason: from getter */
            public final Boolean getNoiseCancellation() {
                return this.noiseCancellation;
            }

            public final List<StoreVoiceParticipants.VoiceUser> component16() {
                return this.privateCallUserListItems;
            }

            /* renamed from: component17, reason: from getter */
            public final boolean getShowParticipantsHiddenView() {
                return this.showParticipantsHiddenView;
            }

            /* renamed from: component18, reason: from getter */
            public final boolean getLockCallScreenControls() {
                return this.lockCallScreenControls;
            }

            /* renamed from: component19, reason: from getter */
            public final boolean getStartedAsVideo() {
                return this.startedAsVideo;
            }

            /* renamed from: component2, reason: from getter */
            public final StageCallModel getStageCallModel() {
                return this.stageCallModel;
            }

            /* renamed from: component20, reason: from getter */
            public final float getPerceptualStreamVolume() {
                return this.perceptualStreamVolume;
            }

            /* renamed from: component21, reason: from getter */
            public final int getTotalMentionsCount() {
                return this.totalMentionsCount;
            }

            /* renamed from: component22, reason: from getter */
            public final boolean getShowLowConnectivityBar() {
                return this.showLowConnectivityBar;
            }

            /* renamed from: component23-twRsX-0, reason: not valid java name and from getter */
            public final StageRoles getStageRoles() {
                return this.stageRoles;
            }

            /* renamed from: component24, reason: from getter */
            public final boolean getIsUpdatingRequestToSpeak() {
                return this.isUpdatingRequestToSpeak;
            }

            /* renamed from: component25, reason: from getter */
            public final boolean getIsMovingToAudience() {
                return this.isMovingToAudience;
            }

            /* renamed from: component26, reason: from getter */
            public final int getRequestingToSpeakCount() {
                return this.requestingToSpeakCount;
            }

            /* renamed from: component27, reason: from getter */
            public final boolean getStopOffscreenVideo() {
                return this.stopOffscreenVideo;
            }

            /* renamed from: component28, reason: from getter */
            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            /* renamed from: component29, reason: from getter */
            public final GuildScheduledEvent getStartableEvent() {
                return this.startableEvent;
            }

            /* renamed from: component3, reason: from getter */
            public final OverlayStatus getOverlayStatus() {
                return this.overlayStatus;
            }

            /* renamed from: component30, reason: from getter */
            public final GuildScheduledEvent getActiveEvent() {
                return this.activeEvent;
            }

            /* renamed from: component31, reason: from getter */
            public final int getTextInVoiceMentionsCount() {
                return this.textInVoiceMentionsCount;
            }

            /* renamed from: component32, reason: from getter */
            public final int getTextInVoiceUnreadsCount() {
                return this.textInVoiceUnreadsCount;
            }

            /* renamed from: component33, reason: from getter */
            public final boolean getIsTextInVoiceEnabled() {
                return this.isTextInVoiceEnabled;
            }

            /* renamed from: component34, reason: from getter */
            public final boolean getIsTextInVoiceChannelSelected() {
                return this.isTextInVoiceChannelSelected;
            }

            public final Map<String, CallParticipant.UserOrStreamParticipant> component35() {
                return this.allVideoParticipants;
            }

            public final List<CallParticipant> component4() {
                return this.visibleVideoParticipants;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getIsIdleFooter() {
                return this.isIdleFooter;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsIdleHeader() {
                return this.isIdleHeader;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getIsControlFadingDisabled() {
                return this.isControlFadingDisabled;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getIsSwitchCameraButtonVisible() {
                return this.isSwitchCameraButtonVisible;
            }

            /* renamed from: component9, reason: from getter */
            public final CameraState getCameraState() {
                return this.cameraState;
            }

            /* renamed from: copy-J3xfKWQ, reason: not valid java name */
            public final Valid m71copyJ3xfKWQ(CallModel callModel, StageCallModel stageCallModel, OverlayStatus overlayStatus, List<? extends CallParticipant> visibleVideoParticipants, boolean isIdleFooter, boolean isIdleHeader, boolean isControlFadingDisabled, boolean isSwitchCameraButtonVisible, CameraState cameraState, DisplayMode displayMode, VoiceControlsOutputSelectorState outputSelectorState, String focusedParticipantKey, boolean isAnyoneUsingVideo, CallParticipant.UserOrStreamParticipant pipParticipant, Boolean noiseCancellation, List<StoreVoiceParticipants.VoiceUser> privateCallUserListItems, boolean showParticipantsHiddenView, boolean lockCallScreenControls, boolean startedAsVideo, float perceptualStreamVolume, int totalMentionsCount, boolean showLowConnectivityBar, StageRoles stageRoles, boolean isUpdatingRequestToSpeak, boolean isMovingToAudience, int requestingToSpeakCount, boolean stopOffscreenVideo, Long channelPermissions, GuildScheduledEvent startableEvent, GuildScheduledEvent activeEvent, int textInVoiceMentionsCount, int textInVoiceUnreadsCount, boolean isTextInVoiceEnabled, boolean isTextInVoiceChannelSelected, Map<String, CallParticipant.UserOrStreamParticipant> allVideoParticipants) {
                Intrinsics3.checkNotNullParameter(callModel, "callModel");
                Intrinsics3.checkNotNullParameter(overlayStatus, "overlayStatus");
                Intrinsics3.checkNotNullParameter(visibleVideoParticipants, "visibleVideoParticipants");
                Intrinsics3.checkNotNullParameter(cameraState, "cameraState");
                Intrinsics3.checkNotNullParameter(displayMode, "displayMode");
                Intrinsics3.checkNotNullParameter(outputSelectorState, "outputSelectorState");
                Intrinsics3.checkNotNullParameter(privateCallUserListItems, "privateCallUserListItems");
                Intrinsics3.checkNotNullParameter(allVideoParticipants, "allVideoParticipants");
                return new Valid(callModel, stageCallModel, overlayStatus, visibleVideoParticipants, isIdleFooter, isIdleHeader, isControlFadingDisabled, isSwitchCameraButtonVisible, cameraState, displayMode, outputSelectorState, focusedParticipantKey, isAnyoneUsingVideo, pipParticipant, noiseCancellation, privateCallUserListItems, showParticipantsHiddenView, lockCallScreenControls, startedAsVideo, perceptualStreamVolume, totalMentionsCount, showLowConnectivityBar, stageRoles, isUpdatingRequestToSpeak, isMovingToAudience, requestingToSpeakCount, stopOffscreenVideo, channelPermissions, startableEvent, activeEvent, textInVoiceMentionsCount, textInVoiceUnreadsCount, isTextInVoiceEnabled, isTextInVoiceChannelSelected, allVideoParticipants);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.callModel, valid.callModel) && Intrinsics3.areEqual(this.stageCallModel, valid.stageCallModel) && Intrinsics3.areEqual(this.overlayStatus, valid.overlayStatus) && Intrinsics3.areEqual(this.visibleVideoParticipants, valid.visibleVideoParticipants) && this.isIdleFooter == valid.isIdleFooter && this.isIdleHeader == valid.isIdleHeader && this.isControlFadingDisabled == valid.isControlFadingDisabled && this.isSwitchCameraButtonVisible == valid.isSwitchCameraButtonVisible && Intrinsics3.areEqual(this.cameraState, valid.cameraState) && Intrinsics3.areEqual(this.displayMode, valid.displayMode) && Intrinsics3.areEqual(this.outputSelectorState, valid.outputSelectorState) && Intrinsics3.areEqual(this.focusedParticipantKey, valid.focusedParticipantKey) && this.isAnyoneUsingVideo == valid.isAnyoneUsingVideo && Intrinsics3.areEqual(this.pipParticipant, valid.pipParticipant) && Intrinsics3.areEqual(this.noiseCancellation, valid.noiseCancellation) && Intrinsics3.areEqual(this.privateCallUserListItems, valid.privateCallUserListItems) && this.showParticipantsHiddenView == valid.showParticipantsHiddenView && this.lockCallScreenControls == valid.lockCallScreenControls && this.startedAsVideo == valid.startedAsVideo && Float.compare(this.perceptualStreamVolume, valid.perceptualStreamVolume) == 0 && this.totalMentionsCount == valid.totalMentionsCount && this.showLowConnectivityBar == valid.showLowConnectivityBar && Intrinsics3.areEqual(this.stageRoles, valid.stageRoles) && this.isUpdatingRequestToSpeak == valid.isUpdatingRequestToSpeak && this.isMovingToAudience == valid.isMovingToAudience && this.requestingToSpeakCount == valid.requestingToSpeakCount && this.stopOffscreenVideo == valid.stopOffscreenVideo && Intrinsics3.areEqual(this.channelPermissions, valid.channelPermissions) && Intrinsics3.areEqual(this.startableEvent, valid.startableEvent) && Intrinsics3.areEqual(this.activeEvent, valid.activeEvent) && this.textInVoiceMentionsCount == valid.textInVoiceMentionsCount && this.textInVoiceUnreadsCount == valid.textInVoiceUnreadsCount && this.isTextInVoiceEnabled == valid.isTextInVoiceEnabled && this.isTextInVoiceChannelSelected == valid.isTextInVoiceChannelSelected && Intrinsics3.areEqual(this.allVideoParticipants, valid.allVideoParticipants);
            }

            public final GuildScheduledEvent getActiveEvent() {
                return this.activeEvent;
            }

            public final Map<String, CallParticipant.UserOrStreamParticipant> getAllVideoParticipants() {
                return this.allVideoParticipants;
            }

            public final String getAnalyticsVideoLayout() {
                return (String) this.analyticsVideoLayout.getValue();
            }

            public final CallModel getCallModel() {
                return this.callModel;
            }

            public final CameraState getCameraState() {
                return this.cameraState;
            }

            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final DisplayMode getDisplayMode() {
                return this.displayMode;
            }

            public final String getFocusedParticipantKey() {
                return this.focusedParticipantKey;
            }

            public final boolean getLockCallScreenControls() {
                return this.lockCallScreenControls;
            }

            public final Set<MenuItem> getMenuItems() {
                return (Set) this.menuItems.getValue();
            }

            public final Boolean getNoiseCancellation() {
                return this.noiseCancellation;
            }

            public final VoiceControlsOutputSelectorState getOutputSelectorState() {
                return this.outputSelectorState;
            }

            public final OverlayStatus getOverlayStatus() {
                return this.overlayStatus;
            }

            public final float getPerceptualStreamVolume() {
                return this.perceptualStreamVolume;
            }

            public final CallParticipant.UserOrStreamParticipant getPipParticipant() {
                return this.pipParticipant;
            }

            public final List<StoreVoiceParticipants.VoiceUser> getPrivateCallUserListItems() {
                return this.privateCallUserListItems;
            }

            public final int getRequestingToSpeakCount() {
                return this.requestingToSpeakCount;
            }

            public final boolean getShowFooter() {
                return this.showFooter;
            }

            public final boolean getShowHeader() {
                return this.showHeader;
            }

            public final boolean getShowLowConnectivityBar() {
                return this.showLowConnectivityBar;
            }

            public final boolean getShowParticipantsHiddenView() {
                return this.showParticipantsHiddenView;
            }

            public final boolean getShowStreamVolume() {
                return this.showStreamVolume;
            }

            public final StageCallModel getStageCallModel() {
                return this.stageCallModel;
            }

            /* renamed from: getStageRoles-twRsX-0, reason: not valid java name */
            public final StageRoles m72getStageRolestwRsX0() {
                return this.stageRoles;
            }

            public final GuildScheduledEvent getStartableEvent() {
                return this.startableEvent;
            }

            public final boolean getStartedAsVideo() {
                return this.startedAsVideo;
            }

            public final boolean getStopOffscreenVideo() {
                return this.stopOffscreenVideo;
            }

            public final int getTextInVoiceMentionsCount() {
                return this.textInVoiceMentionsCount;
            }

            public final int getTextInVoiceUnreadsCount() {
                return this.textInVoiceUnreadsCount;
            }

            public final String getTitleText() {
                return (String) this.titleText.getValue();
            }

            public final int getTotalMentionsCount() {
                return this.totalMentionsCount;
            }

            public final List<CallParticipant> getVisibleVideoParticipants() {
                return this.visibleVideoParticipants;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                CallModel callModel = this.callModel;
                int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
                StageCallModel stageCallModel = this.stageCallModel;
                int iHashCode2 = (iHashCode + (stageCallModel != null ? stageCallModel.hashCode() : 0)) * 31;
                OverlayStatus overlayStatus = this.overlayStatus;
                int iHashCode3 = (iHashCode2 + (overlayStatus != null ? overlayStatus.hashCode() : 0)) * 31;
                List<CallParticipant> list = this.visibleVideoParticipants;
                int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
                boolean z2 = this.isIdleFooter;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode4 + i) * 31;
                boolean z3 = this.isIdleHeader;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.isControlFadingDisabled;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.isSwitchCameraButtonVisible;
                int i7 = z5;
                if (z5 != 0) {
                    i7 = 1;
                }
                int i8 = (i6 + i7) * 31;
                CameraState cameraState = this.cameraState;
                int iHashCode5 = (i8 + (cameraState != null ? cameraState.hashCode() : 0)) * 31;
                DisplayMode displayMode = this.displayMode;
                int iHashCode6 = (iHashCode5 + (displayMode != null ? displayMode.hashCode() : 0)) * 31;
                VoiceControlsOutputSelectorState voiceControlsOutputSelectorState = this.outputSelectorState;
                int iHashCode7 = (iHashCode6 + (voiceControlsOutputSelectorState != null ? voiceControlsOutputSelectorState.hashCode() : 0)) * 31;
                String str = this.focusedParticipantKey;
                int iHashCode8 = (iHashCode7 + (str != null ? str.hashCode() : 0)) * 31;
                boolean z6 = this.isAnyoneUsingVideo;
                int i9 = z6;
                if (z6 != 0) {
                    i9 = 1;
                }
                int i10 = (iHashCode8 + i9) * 31;
                CallParticipant.UserOrStreamParticipant userOrStreamParticipant = this.pipParticipant;
                int iHashCode9 = (i10 + (userOrStreamParticipant != null ? userOrStreamParticipant.hashCode() : 0)) * 31;
                Boolean bool = this.noiseCancellation;
                int iHashCode10 = (iHashCode9 + (bool != null ? bool.hashCode() : 0)) * 31;
                List<StoreVoiceParticipants.VoiceUser> list2 = this.privateCallUserListItems;
                int iHashCode11 = (iHashCode10 + (list2 != null ? list2.hashCode() : 0)) * 31;
                boolean z7 = this.showParticipantsHiddenView;
                int i11 = z7;
                if (z7 != 0) {
                    i11 = 1;
                }
                int i12 = (iHashCode11 + i11) * 31;
                boolean z8 = this.lockCallScreenControls;
                int i13 = z8;
                if (z8 != 0) {
                    i13 = 1;
                }
                int i14 = (i12 + i13) * 31;
                boolean z9 = this.startedAsVideo;
                int i15 = z9;
                if (z9 != 0) {
                    i15 = 1;
                }
                int iFloatToIntBits = (((Float.floatToIntBits(this.perceptualStreamVolume) + ((i14 + i15) * 31)) * 31) + this.totalMentionsCount) * 31;
                boolean z10 = this.showLowConnectivityBar;
                int i16 = z10;
                if (z10 != 0) {
                    i16 = 1;
                }
                int i17 = (iFloatToIntBits + i16) * 31;
                StageRoles stageRoles = this.stageRoles;
                int iHashCode12 = (i17 + (stageRoles != null ? stageRoles.hashCode() : 0)) * 31;
                boolean z11 = this.isUpdatingRequestToSpeak;
                int i18 = z11;
                if (z11 != 0) {
                    i18 = 1;
                }
                int i19 = (iHashCode12 + i18) * 31;
                boolean z12 = this.isMovingToAudience;
                int i20 = z12;
                if (z12 != 0) {
                    i20 = 1;
                }
                int i21 = (((i19 + i20) * 31) + this.requestingToSpeakCount) * 31;
                boolean z13 = this.stopOffscreenVideo;
                int i22 = z13;
                if (z13 != 0) {
                    i22 = 1;
                }
                int i23 = (i21 + i22) * 31;
                Long l = this.channelPermissions;
                int iHashCode13 = (i23 + (l != null ? l.hashCode() : 0)) * 31;
                GuildScheduledEvent guildScheduledEvent = this.startableEvent;
                int iHashCode14 = (iHashCode13 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0)) * 31;
                GuildScheduledEvent guildScheduledEvent2 = this.activeEvent;
                int iHashCode15 = (((((iHashCode14 + (guildScheduledEvent2 != null ? guildScheduledEvent2.hashCode() : 0)) * 31) + this.textInVoiceMentionsCount) * 31) + this.textInVoiceUnreadsCount) * 31;
                boolean z14 = this.isTextInVoiceEnabled;
                int i24 = z14;
                if (z14 != 0) {
                    i24 = 1;
                }
                int i25 = (iHashCode15 + i24) * 31;
                boolean z15 = this.isTextInVoiceChannelSelected;
                int i26 = (i25 + (z15 ? 1 : z15 ? 1 : 0)) * 31;
                Map<String, CallParticipant.UserOrStreamParticipant> map = this.allVideoParticipants;
                return i26 + (map != null ? map.hashCode() : 0);
            }

            public final boolean isAnyoneUsingVideo() {
                return this.isAnyoneUsingVideo;
            }

            public final boolean isControlFadingDisabled() {
                return this.isControlFadingDisabled;
            }

            /* renamed from: isDeafened, reason: from getter */
            public final boolean getIsDeafened() {
                return this.isDeafened;
            }

            public final boolean isIdleFooter() {
                return this.isIdleFooter;
            }

            public final boolean isIdleHeader() {
                return this.isIdleHeader;
            }

            public final boolean isMovingToAudience() {
                return this.isMovingToAudience;
            }

            /* renamed from: isPushToTalk, reason: from getter */
            public final boolean getIsPushToTalk() {
                return this.isPushToTalk;
            }

            /* renamed from: isStreamFocused, reason: from getter */
            public final boolean getIsStreamFocused() {
                return this.isStreamFocused;
            }

            public final boolean isSwitchCameraButtonVisible() {
                return this.isSwitchCameraButtonVisible;
            }

            public final boolean isTextInVoiceChannelSelected() {
                return this.isTextInVoiceChannelSelected;
            }

            public final boolean isTextInVoiceEnabled() {
                return this.isTextInVoiceEnabled;
            }

            public final boolean isUpdatingRequestToSpeak() {
                return this.isUpdatingRequestToSpeak;
            }

            /* renamed from: isVideoCallGridVisible, reason: from getter */
            public final boolean getIsVideoCallGridVisible() {
                return this.isVideoCallGridVisible;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(callModel=");
                sbU.append(this.callModel);
                sbU.append(", stageCallModel=");
                sbU.append(this.stageCallModel);
                sbU.append(", overlayStatus=");
                sbU.append(this.overlayStatus);
                sbU.append(", visibleVideoParticipants=");
                sbU.append(this.visibleVideoParticipants);
                sbU.append(", isIdleFooter=");
                sbU.append(this.isIdleFooter);
                sbU.append(", isIdleHeader=");
                sbU.append(this.isIdleHeader);
                sbU.append(", isControlFadingDisabled=");
                sbU.append(this.isControlFadingDisabled);
                sbU.append(", isSwitchCameraButtonVisible=");
                sbU.append(this.isSwitchCameraButtonVisible);
                sbU.append(", cameraState=");
                sbU.append(this.cameraState);
                sbU.append(", displayMode=");
                sbU.append(this.displayMode);
                sbU.append(", outputSelectorState=");
                sbU.append(this.outputSelectorState);
                sbU.append(", focusedParticipantKey=");
                sbU.append(this.focusedParticipantKey);
                sbU.append(", isAnyoneUsingVideo=");
                sbU.append(this.isAnyoneUsingVideo);
                sbU.append(", pipParticipant=");
                sbU.append(this.pipParticipant);
                sbU.append(", noiseCancellation=");
                sbU.append(this.noiseCancellation);
                sbU.append(", privateCallUserListItems=");
                sbU.append(this.privateCallUserListItems);
                sbU.append(", showParticipantsHiddenView=");
                sbU.append(this.showParticipantsHiddenView);
                sbU.append(", lockCallScreenControls=");
                sbU.append(this.lockCallScreenControls);
                sbU.append(", startedAsVideo=");
                sbU.append(this.startedAsVideo);
                sbU.append(", perceptualStreamVolume=");
                sbU.append(this.perceptualStreamVolume);
                sbU.append(", totalMentionsCount=");
                sbU.append(this.totalMentionsCount);
                sbU.append(", showLowConnectivityBar=");
                sbU.append(this.showLowConnectivityBar);
                sbU.append(", stageRoles=");
                sbU.append(this.stageRoles);
                sbU.append(", isUpdatingRequestToSpeak=");
                sbU.append(this.isUpdatingRequestToSpeak);
                sbU.append(", isMovingToAudience=");
                sbU.append(this.isMovingToAudience);
                sbU.append(", requestingToSpeakCount=");
                sbU.append(this.requestingToSpeakCount);
                sbU.append(", stopOffscreenVideo=");
                sbU.append(this.stopOffscreenVideo);
                sbU.append(", channelPermissions=");
                sbU.append(this.channelPermissions);
                sbU.append(", startableEvent=");
                sbU.append(this.startableEvent);
                sbU.append(", activeEvent=");
                sbU.append(this.activeEvent);
                sbU.append(", textInVoiceMentionsCount=");
                sbU.append(this.textInVoiceMentionsCount);
                sbU.append(", textInVoiceUnreadsCount=");
                sbU.append(this.textInVoiceUnreadsCount);
                sbU.append(", isTextInVoiceEnabled=");
                sbU.append(this.isTextInVoiceEnabled);
                sbU.append(", isTextInVoiceChannelSelected=");
                sbU.append(this.isTextInVoiceChannelSelected);
                sbU.append(", allVideoParticipants=");
                return outline.M(sbU, this.allVideoParticipants, ")");
            }

            /* JADX WARN: Multi-variable type inference failed */
            private Valid(CallModel callModel, StageCallModel stageCallModel, OverlayStatus overlayStatus, List<? extends CallParticipant> list, boolean z2, boolean z3, boolean z4, boolean z5, CameraState cameraState, DisplayMode displayMode, VoiceControlsOutputSelectorState voiceControlsOutputSelectorState, String str, boolean z6, CallParticipant.UserOrStreamParticipant userOrStreamParticipant, Boolean bool, List<StoreVoiceParticipants.VoiceUser> list2, boolean z7, boolean z8, boolean z9, float f, int i, boolean z10, StageRoles stageRoles, boolean z11, boolean z12, int i2, boolean z13, Long l, GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2, int i3, int i4, boolean z14, boolean z15, Map<String, CallParticipant.UserOrStreamParticipant> map) {
                super(null);
                this.callModel = callModel;
                this.stageCallModel = stageCallModel;
                this.overlayStatus = overlayStatus;
                this.visibleVideoParticipants = list;
                this.isIdleFooter = z2;
                this.isIdleHeader = z3;
                this.isControlFadingDisabled = z4;
                this.isSwitchCameraButtonVisible = z5;
                this.cameraState = cameraState;
                this.displayMode = displayMode;
                this.outputSelectorState = voiceControlsOutputSelectorState;
                this.focusedParticipantKey = str;
                this.isAnyoneUsingVideo = z6;
                this.pipParticipant = userOrStreamParticipant;
                this.noiseCancellation = bool;
                this.privateCallUserListItems = list2;
                this.showParticipantsHiddenView = z7;
                this.lockCallScreenControls = z8;
                this.startedAsVideo = z9;
                this.perceptualStreamVolume = f;
                this.totalMentionsCount = i;
                this.showLowConnectivityBar = z10;
                this.stageRoles = stageRoles;
                this.isUpdatingRequestToSpeak = z11;
                this.isMovingToAudience = z12;
                this.requestingToSpeakCount = i2;
                this.stopOffscreenVideo = z13;
                this.channelPermissions = l;
                this.startableEvent = guildScheduledEvent;
                this.activeEvent = guildScheduledEvent2;
                this.textInVoiceMentionsCount = i3;
                this.textInVoiceUnreadsCount = i4;
                this.isTextInVoiceEnabled = z14;
                this.isTextInVoiceChannelSelected = z15;
                this.allVideoParticipants = map;
                this.menuItems = LazyJVM.lazy(new WidgetCallFullscreenViewModel3(this));
                this.titleText = LazyJVM.lazy(new WidgetCallFullscreenViewModel4(this));
                boolean z16 = false;
                this.isStreamFocused = str != null && StringsJVM.endsWith$default(str, "STREAM", false, 2, null);
                boolean z17 = (list.isEmpty() ^ true) && !callModel.isStreaming() && displayMode == DisplayMode.GRID;
                this.isVideoCallGridVisible = z17;
                this.isPushToTalk = callModel.getInputMode() == MediaEngineConnection.InputMode.PUSH_TO_TALK;
                this.showFooter = (z17 && z2 && !z8) ? false : true;
                this.showHeader = (z17 && z3 && !z8) ? false : true;
                if (callModel.getActiveStream() != null && !callModel.isStreaming()) {
                    z16 = true;
                }
                this.showStreamVolume = z16;
                this.analyticsVideoLayout = LazyJVM.lazy(new WidgetCallFullscreenViewModel2(this));
                this.isDeafened = callModel.isDeafenedByAnySource();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            DisplayMode.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[DisplayMode.GRID.ordinal()] = 1;
            iArr[DisplayMode.PRIVATE_CALL_PARTICIPANTS.ordinal()] = 2;
            VideoCallParticipantView.ParticipantData.Type.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            VideoCallParticipantView.ParticipantData.Type type = VideoCallParticipantView.ParticipantData.Type.DEFAULT;
            iArr2[type.ordinal()] = 1;
            VideoCallParticipantView.ParticipantData.Type type2 = VideoCallParticipantView.ParticipantData.Type.APPLICATION_STREAMING;
            iArr2[type2.ordinal()] = 2;
            DiscordAudioManager.DeviceTypes.values();
            int[] iArr3 = new int[6];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET.ordinal()] = 1;
            iArr3[DiscordAudioManager.DeviceTypes.SPEAKERPHONE.ordinal()] = 2;
            VideoCallParticipantView.ParticipantData.Type.values();
            int[] iArr4 = new int[2];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[type2.ordinal()] = 1;
            iArr4[type.ordinal()] = 2;
            VideoCallParticipantView.ParticipantData.Type.values();
            int[] iArr5 = new int[2];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[type2.ordinal()] = 1;
            iArr5[type.ordinal()] = 2;
            StoreApplicationStreaming.ActiveApplicationStream.State.values();
            int[] iArr6 = new int[6];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.CONNECTING.ordinal()] = 1;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.RECONNECTING.ordinal()] = 2;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.ACTIVE.ordinal()] = 3;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.PAUSED.ordinal()] = 4;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.DENIED_FULL.ordinal()] = 5;
            iArr6[StoreApplicationStreaming.ActiveApplicationStream.State.ENDED.ordinal()] = 6;
            StoreMediaSettings.SelfMuteFailure.values();
            int[] iArr7 = new int[1];
            $EnumSwitchMapping$6 = iArr7;
            iArr7[StoreMediaSettings.SelfMuteFailure.CANNOT_USE_VAD.ordinal()] = 1;
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "kotlin.jvm.PlatformType", "user1", "user2", "", "compare", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$createUserItemsComparator$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Comparator<StoreVoiceParticipants.VoiceUser> {
        public final /* synthetic */ String $mySpectatingStreamKey;
        public final /* synthetic */ boolean $prioritizeSpectators;

        public AnonymousClass1(String str, boolean z2) {
            this.$mySpectatingStreamKey = str;
            this.$prioritizeSpectators = z2;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
            return compare2(voiceUser, voiceUser2);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
            boolean z2 = false;
            boolean z3 = this.$mySpectatingStreamKey != null;
            ModelApplicationStream applicationStream = voiceUser.getApplicationStream();
            String encodedStreamKey = applicationStream != null ? applicationStream.getEncodedStreamKey() : null;
            ModelApplicationStream applicationStream2 = voiceUser2.getApplicationStream();
            String encodedStreamKey2 = applicationStream2 != null ? applicationStream2.getEncodedStreamKey() : null;
            boolean z4 = encodedStreamKey != null;
            boolean z5 = encodedStreamKey2 != null;
            VoiceState voiceState = voiceUser.getVoiceState();
            boolean z6 = voiceState != null && voiceState.getSelfVideo();
            VoiceState voiceState2 = voiceUser2.getVoiceState();
            boolean z7 = voiceState2 != null && voiceState2.getSelfVideo();
            boolean z8 = z3 && Intrinsics3.areEqual(encodedStreamKey, this.$mySpectatingStreamKey);
            if (z3 && Intrinsics3.areEqual(encodedStreamKey2, this.$mySpectatingStreamKey)) {
                z2 = true;
            }
            boolean z9 = this.$prioritizeSpectators;
            if (!z9 || !z8) {
                if (z9 && z2) {
                    return 1;
                }
                if (!z9 || !z3 || !Intrinsics3.areEqual(voiceUser.getWatchingStream(), this.$mySpectatingStreamKey) || !(!Intrinsics3.areEqual(voiceUser2.getWatchingStream(), this.$mySpectatingStreamKey))) {
                    if (this.$prioritizeSpectators && z3 && Intrinsics3.areEqual(voiceUser2.getWatchingStream(), this.$mySpectatingStreamKey) && (!Intrinsics3.areEqual(voiceUser.getWatchingStream(), this.$mySpectatingStreamKey))) {
                        return 1;
                    }
                    if (!z4 || z5) {
                        if (!z4 && z5) {
                            return 1;
                        }
                        if (!z6 || z7) {
                            if (z6 || !z7) {
                                return UserUtils.INSTANCE.compareUserNames(voiceUser.getUser(), voiceUser2.getUser(), voiceUser.getNickname(), voiceUser2.getNickname());
                            }
                            return 1;
                        }
                    }
                }
            }
            return -1;
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$moveMeToAudience$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ViewState viewStateAccess$getViewState$p = WidgetCallFullscreenViewModel.access$getViewState$p(WidgetCallFullscreenViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Valid)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Valid valid = (ViewState.Valid) viewStateAccess$getViewState$p;
            if (valid != null) {
                WidgetCallFullscreenViewModel.this.updateViewState2((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -16777217, 7, null));
            }
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$moveMeToAudience$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$observeStoreState$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends StoreState>> {

        /* compiled from: WidgetCallFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/voice/model/CallModel;", "callModel", "Lrx/Observable;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/voice/model/CallModel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$observeStoreState$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03621<T, R> implements Func1<CallModel, Observable<? extends StoreState>> {
            public final /* synthetic */ Channel $channel;

            /* compiled from: WidgetCallFullscreenViewModel.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010!\u001a\u00020\u001e2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0018\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u001a\u001a\u00020\f2\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u001b\u0012\u0004\u0012\u00020\u001c0\u0017H\n¢\u0006\u0004\b\u001f\u0010 "}, d2 = {"Lcom/discord/widgets/stage/model/StageCallModel;", "stageCallModel", "", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "", "kotlin.jvm.PlatformType", "streamVolume", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "streamQuality", "", "isScreenReaderEnabled", "", "totalMentionsCount", "Lcom/discord/stores/StoreConnectivity$DelayedState;", "connectivityState", "Lcom/discord/widgets/stage/StageRoles;", "stageRoles", "Lcom/discord/models/experiments/domain/Experiment;", "stopOffscreenVideoExperiment", "isTextInVoiceEnabled", "Lcom/discord/api/channel/Channel;", "selectedTextChannel", "", "Lcom/discord/primitives/ChannelId;", "mentionsMap", "textInVoiceUnreadsCount", "Lcom/discord/primitives/ApplicationId;", "Lcom/discord/api/application/ApplicationAsset;", "embeddedAppBackgrounds", "Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;", "invoke", "(Lcom/discord/widgets/stage/model/StageCallModel;Ljava/lang/Long;Ljava/lang/Float;Lcom/discord/rtcconnection/RtcConnection$Quality;ZILcom/discord/stores/StoreConnectivity$DelayedState;Lcom/discord/widgets/stage/StageRoles;Lcom/discord/models/experiments/domain/Experiment;ZLcom/discord/api/channel/Channel;Ljava/util/Map;ILjava/util/Map;)Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$observeStoreState$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C03631 extends Lambda implements Function14<StageCallModel, Long, Float, RtcConnection.Quality, Boolean, Integer, StoreConnectivity.DelayedState, StageRoles, Experiment, Boolean, Channel, Map<Long, ? extends Integer>, Integer, Map<Long, ? extends ApplicationAsset>, StoreState> {
                public final /* synthetic */ CallModel $callModel;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C03631(CallModel callModel) {
                    super(14);
                    this.$callModel = callModel;
                }

                @Override // kotlin.jvm.functions.Function14
                public /* bridge */ /* synthetic */ StoreState invoke(StageCallModel stageCallModel, Long l, Float f, RtcConnection.Quality quality, Boolean bool, Integer num, StoreConnectivity.DelayedState delayedState, StageRoles stageRoles, Experiment experiment, Boolean bool2, Channel channel, Map<Long, ? extends Integer> map, Integer num2, Map<Long, ? extends ApplicationAsset> map2) {
                    return invoke(stageCallModel, l, f, quality, bool.booleanValue(), num.intValue(), delayedState, stageRoles, experiment, bool2.booleanValue(), channel, (Map<Long, Integer>) map, num2.intValue(), (Map<Long, ApplicationAsset>) map2);
                }

                public final StoreState invoke(StageCallModel stageCallModel, Long l, Float f, RtcConnection.Quality quality, boolean z2, int i, StoreConnectivity.DelayedState delayedState, StageRoles stageRoles, Experiment experiment, boolean z3, Channel channel, Map<Long, Integer> map, int i2, Map<Long, ApplicationAsset> map2) {
                    Intrinsics3.checkNotNullParameter(delayedState, "connectivityState");
                    Intrinsics3.checkNotNullParameter(map, "mentionsMap");
                    Intrinsics3.checkNotNullParameter(map2, "embeddedAppBackgrounds");
                    CallModel callModel = this.$callModel;
                    if (callModel == null) {
                        return StoreState.Invalid.INSTANCE;
                    }
                    boolean z4 = callModel.getVoiceSettings().getNoiseProcessing() == StoreMediaSettings.NoiseProcessing.Cancellation;
                    CallModel callModel2 = this.$callModel;
                    Boolean boolValueOf = Boolean.valueOf(z4);
                    Intrinsics3.checkNotNullExpressionValue(f, "streamVolume");
                    float fFloatValue = f.floatValue();
                    boolean z5 = experiment != null && experiment.getBucket() == 1;
                    boolean z6 = channel != null && ChannelUtils.J(channel);
                    Integer num = map.get(Long.valueOf(WidgetCallFullscreenViewModel.access$getChannelId$p(WidgetCallFullscreenViewModel.this)));
                    return new StoreState.Valid(callModel2, stageCallModel, boolValueOf, l, fFloatValue, quality, z2, i, delayedState, stageRoles, z5, z3, z6, num != null ? num.intValue() : 0, i2, map2, null);
                }
            }

            public C03621(Channel channel) {
                this.$channel = channel;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends StoreState> call(CallModel callModel) {
                return call2(callModel);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends StoreState> call2(CallModel callModel) {
                Observable<StageCallModel> observableObserveStageCallModel = StageCallModel.INSTANCE.observeStageCallModel(WidgetCallFullscreenViewModel.access$getChannelId$p(WidgetCallFullscreenViewModel.this));
                Observable<Long> observableObservePermissionsForChannel = WidgetCallFullscreenViewModel.access$getPermissionsStore$p(WidgetCallFullscreenViewModel.this).observePermissionsForChannel(WidgetCallFullscreenViewModel.access$getChannelId$p(WidgetCallFullscreenViewModel.this));
                Observable<Float> observableR = WidgetCallFullscreenViewModel.access$getStreamRtcConnectionStore$p(WidgetCallFullscreenViewModel.this).observeStreamVolume().r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "streamRtcConnectionStore…().distinctUntilChanged()");
                Observable<RtcConnection.Quality> observableR2 = WidgetCallFullscreenViewModel.access$getStreamRtcConnectionStore$p(WidgetCallFullscreenViewModel.this).observeConnectionQuality().r();
                Intrinsics3.checkNotNullExpressionValue(observableR2, "streamRtcConnectionStore…().distinctUntilChanged()");
                Observable<Boolean> observableObserveScreenreaderEnabled = WidgetCallFullscreenViewModel.access$getAccessibilityStore$p(WidgetCallFullscreenViewModel.this).observeScreenreaderEnabled();
                Observable<Integer> observableObserveTotalMentions = WidgetCallFullscreenViewModel.access$getMentionsStore$p(WidgetCallFullscreenViewModel.this).observeTotalMentions();
                Observable<StoreConnectivity.DelayedState> observableObserveState = WidgetCallFullscreenViewModel.access$getConnectivityStore$p(WidgetCallFullscreenViewModel.this).observeState();
                Observable<StageRoles> observableR3 = WidgetCallFullscreenViewModel.access$getStageStore$p(WidgetCallFullscreenViewModel.this).observeMyRoles(WidgetCallFullscreenViewModel.access$getChannelId$p(WidgetCallFullscreenViewModel.this)).r();
                Intrinsics3.checkNotNullExpressionValue(observableR3, "stageStore.observeMyRole…d).distinctUntilChanged()");
                Observable<Experiment> observableObserveUserExperiment = WidgetCallFullscreenViewModel.access$getExperimentsStore$p(WidgetCallFullscreenViewModel.this).observeUserExperiment("2021-03_stop_offscreen_video_streams", true);
                TextInVoiceFeatureFlag instance = TextInVoiceFeatureFlag.INSTANCE.getINSTANCE();
                Channel channel = this.$channel;
                Observable<Boolean> observableObserveEnabled = instance.observeEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null);
                Observable<Channel> observableObserveSelectedChannel = WidgetCallFullscreenViewModel.access$getChannelsSelectedStore$p(WidgetCallFullscreenViewModel.this).observeSelectedChannel();
                StoreStream.Companion companion = StoreStream.INSTANCE;
                return ObservableCombineLatestOverloads2.combineLatest(observableObserveStageCallModel, observableObservePermissionsForChannel, observableR, observableR2, observableObserveScreenreaderEnabled, observableObserveTotalMentions, observableObserveState, observableR3, observableObserveUserExperiment, observableObserveEnabled, observableObserveSelectedChannel, companion.getMentions().observeMentionCounts(), companion.getReadStates().observeUnreadCountForChannel(WidgetCallFullscreenViewModel.access$getChannelId$p(WidgetCallFullscreenViewModel.this), new UtcDateTime(callModel != null ? callModel.getTimeConnectedMs() : 0L)), WidgetCallFullscreenViewModel.access$getApplicationAssetsStore$p(WidgetCallFullscreenViewModel.this).observeEmbeddedAppBackgrounds(), new C03631(callModel));
            }
        }

        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends StoreState> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends StoreState> call2(Channel channel) {
            return CallModel.INSTANCE.get(WidgetCallFullscreenViewModel.access$getChannelId$p(WidgetCallFullscreenViewModel.this)).Y(new C03621(channel));
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$setTargetChannelId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetCallFullscreenViewModel.access$setStoreObservableSubscription$p(WidgetCallFullscreenViewModel.this, subscription);
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$setTargetChannelId$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetCallFullscreenViewModel widgetCallFullscreenViewModel = WidgetCallFullscreenViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            widgetCallFullscreenViewModel.handleStoreState(storeState);
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$startTapForwardingJob$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetCallFullscreenViewModel.access$setForwardVideoGridInteractionSubscription$p(WidgetCallFullscreenViewModel.this, subscription);
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$startTapForwardingJob$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            boolean isIdle = WidgetCallFullscreenViewModel.access$getVideoPlayerIdleDetectorFooter$p(WidgetCallFullscreenViewModel.this).getIsIdle();
            WidgetCallFullscreenViewModel.access$getVideoPlayerIdleDetectorFooter$p(WidgetCallFullscreenViewModel.this).onInteraction(WidgetCallFullscreenViewModel.access$getVideoPlayerIdleDetectorHeader$p(WidgetCallFullscreenViewModel.this).getIsIdle());
            WidgetCallFullscreenViewModel.access$getVideoPlayerIdleDetectorHeader$p(WidgetCallFullscreenViewModel.this).onInteraction(isIdle);
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$toggleRequestToSpeak$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ViewState viewStateAccess$getViewState$p = WidgetCallFullscreenViewModel.access$getViewState$p(WidgetCallFullscreenViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Valid)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Valid valid = (ViewState.Valid) viewStateAccess$getViewState$p;
            if (valid != null) {
                WidgetCallFullscreenViewModel.this.updateViewState2((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -8388609, 7, null));
            }
        }
    }

    /* compiled from: WidgetCallFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$toggleRequestToSpeak$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ boolean $isRaisingMyHand;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2, Channel channel) {
            super(1);
            this.$isRaisingMyHand = z2;
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            if (this.$isRaisingMyHand) {
                AnalyticsTracker.INSTANCE.requestToSpeakInitiated(this.$channel.getId());
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetCallFullscreenViewModel(long j, StoreChannels storeChannels, StoreNavigation storeNavigation, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildSelected storeGuildSelected, StoreTabsNavigation storeTabsNavigation, StoreUserSettings storeUserSettings, StoreApplicationStreaming storeApplicationStreaming, StoreMediaEngine storeMediaEngine, StoreMediaSettings storeMediaSettings, StorePermissions storePermissions, Clock clock, Scheduler scheduler, VideoPermissionsManager videoPermissionsManager, VoiceEngineServiceController voiceEngineServiceController, StoreStreamRtcConnection storeStreamRtcConnection, StoreAccessibility storeAccessibility, StoreAudioManagerV2 storeAudioManagerV2, StoreMentions storeMentions, StoreAnalytics storeAnalytics, StoreConnectivity storeConnectivity, StoreStageChannels storeStageChannels, StoreAnalytics storeAnalytics2, StoreExperiments storeExperiments, StoreChannelsSelected storeChannelsSelected, StoreApplication storeApplication, StoreApplicationAssets storeApplicationAssets, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Scheduler scheduler2;
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreNavigation navigation = (i & 4) != 0 ? StoreStream.INSTANCE.getNavigation() : storeNavigation;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 8) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreGuildSelected guildSelected = (i & 16) != 0 ? StoreStream.INSTANCE.getGuildSelected() : storeGuildSelected;
        StoreTabsNavigation tabsNavigation = (i & 32) != 0 ? StoreStream.INSTANCE.getTabsNavigation() : storeTabsNavigation;
        StoreUserSettings userSettings = (i & 64) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        StoreApplicationStreaming applicationStreaming = (i & 128) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming;
        StoreMediaEngine mediaEngine = (i & 256) != 0 ? StoreStream.INSTANCE.getMediaEngine() : storeMediaEngine;
        StoreMediaSettings mediaSettings = (i & 512) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings;
        StorePermissions permissions = (i & 1024) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        Clock clock2 = (i & 2048) != 0 ? ClockFactory.get() : clock;
        if ((i & 4096) != 0) {
            Scheduler schedulerA = Schedulers2.a();
            Intrinsics3.checkNotNullExpressionValue(schedulerA, "Schedulers.computation()");
            scheduler2 = schedulerA;
        } else {
            scheduler2 = scheduler;
        }
        this(j, channels, navigation, voiceChannelSelected, guildSelected, tabsNavigation, userSettings, applicationStreaming, mediaEngine, mediaSettings, permissions, clock2, scheduler2, (i & 8192) != 0 ? new VideoPermissionsManager(null, 1, null) : videoPermissionsManager, (i & 16384) != 0 ? VoiceEngineServiceController.INSTANCE.getINSTANCE() : voiceEngineServiceController, (32768 & i) != 0 ? StoreStream.INSTANCE.getStreamRtcConnection() : storeStreamRtcConnection, (65536 & i) != 0 ? StoreStream.INSTANCE.getAccessibility() : storeAccessibility, (131072 & i) != 0 ? StoreStream.INSTANCE.getAudioManagerV2() : storeAudioManagerV2, (262144 & i) != 0 ? StoreStream.INSTANCE.getMentions() : storeMentions, (524288 & i) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, (1048576 & i) != 0 ? StoreStream.INSTANCE.getConnectivity() : storeConnectivity, (2097152 & i) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels, (4194304 & i) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics2, (8388608 & i) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (16777216 & i) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (33554432 & i) != 0 ? StoreStream.INSTANCE.getApplication() : storeApplication, (i & 67108864) != 0 ? StoreStream.INSTANCE.getApplicationAssets() : storeApplicationAssets, str);
    }

    public static final /* synthetic */ StoreAccessibility access$getAccessibilityStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.accessibilityStore;
    }

    public static final /* synthetic */ StoreApplicationAssets access$getApplicationAssetsStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.applicationAssetsStore;
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.channelId;
    }

    public static final /* synthetic */ StoreChannelsSelected access$getChannelsSelectedStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.channelsSelectedStore;
    }

    public static final /* synthetic */ StoreConnectivity access$getConnectivityStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.connectivityStore;
    }

    public static final /* synthetic */ StoreExperiments access$getExperimentsStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.experimentsStore;
    }

    public static final /* synthetic */ Subscription access$getForwardVideoGridInteractionSubscription$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.forwardVideoGridInteractionSubscription;
    }

    public static final /* synthetic */ StoreMentions access$getMentionsStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.mentionsStore;
    }

    public static final /* synthetic */ StorePermissions access$getPermissionsStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.permissionsStore;
    }

    public static final /* synthetic */ StoreStageChannels access$getStageStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.stageStore;
    }

    public static final /* synthetic */ Subscription access$getStoreObservableSubscription$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.storeObservableSubscription;
    }

    public static final /* synthetic */ StoreStreamRtcConnection access$getStreamRtcConnectionStore$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.streamRtcConnectionStore;
    }

    public static final /* synthetic */ VideoPlayerIdleDetector access$getVideoPlayerIdleDetectorFooter$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.videoPlayerIdleDetectorFooter;
    }

    public static final /* synthetic */ VideoPlayerIdleDetector access$getVideoPlayerIdleDetectorHeader$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.videoPlayerIdleDetectorHeader;
    }

    public static final /* synthetic */ ViewState access$getViewState$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        return widgetCallFullscreenViewModel.getViewState();
    }

    public static final /* synthetic */ void access$setChannelId$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, long j) {
        widgetCallFullscreenViewModel.channelId = j;
    }

    public static final /* synthetic */ void access$setForwardVideoGridInteractionSubscription$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, Subscription subscription) {
        widgetCallFullscreenViewModel.forwardVideoGridInteractionSubscription = subscription;
    }

    public static final /* synthetic */ void access$setOffScreenVideoParticipants(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, List list) {
        widgetCallFullscreenViewModel.setOffScreenVideoParticipants(list);
    }

    public static final /* synthetic */ void access$setStoreObservableSubscription$p(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, Subscription subscription) {
        widgetCallFullscreenViewModel.storeObservableSubscription = subscription;
    }

    private final CallParticipant addStreamQualityMetadata(CallParticipant callParticipant, RtcConnection.Quality streamQuality) {
        boolean z2 = callParticipant instanceof CallParticipant.UserOrStreamParticipant;
        if (z2 || (callParticipant instanceof CallParticipant.EmbeddedActivityParticipant)) {
            return callParticipant;
        }
        if (!z2) {
            throw new NoWhenBranchMatchedException();
        }
        CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
        VideoCallParticipantView.ParticipantData participantData = userOrStreamParticipant.getParticipantData();
        StoreVideoStreams.UserStreams streams = participantData.voiceParticipant.getStreams();
        VideoMetadata applicationStreamMetadata = streams != null ? streams.getApplicationStreamMetadata() : null;
        if (applicationStreamMetadata != null) {
            Intrinsics3.checkNotNullParameter(applicationStreamMetadata, "metadata");
            VideoCallParticipantView.StreamResolution aVar = applicationStreamMetadata.type == Payloads.ResolutionType.Source ? VideoCallParticipantView.StreamResolution.b.a : new VideoCallParticipantView.StreamResolution.a(applicationStreamMetadata.maxHeight);
            Integer num = applicationStreamMetadata.maxFrameRate;
            VideoCallParticipantView.StreamFps streamFps = num != null ? new VideoCallParticipantView.StreamFps(num.intValue()) : null;
            participantData = VideoCallParticipantView.ParticipantData.a(participantData, null, false, null, null, null, null, false, false, new VideoCallParticipantView.ParticipantData.a(aVar.b() || (streamFps != null && streamFps.a()), aVar, streamFps, streamQuality == RtcConnection.Quality.BAD), 255);
        }
        return userOrStreamParticipant.copy(participantData);
    }

    @MainThread
    private final void cancelTapForwardingJob() {
        Subscription subscription = this.forwardVideoGridInteractionSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.forwardVideoGridInteractionSubscription = null;
    }

    @MainThread
    private final void clearFocusedVideoParticipant() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            this.focusedVideoParticipantKey = null;
            stopWatchingStreamIfEnded();
            updateViewState2((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, computeVisibleVideoParticipants(), false, false, false, false, null, null, null, this.focusedVideoParticipantKey, false, computePipParticipant(valid.getCallModel().getMyId(), valid.getCallModel().getSelectedVideoDevice(), valid.getCallModel().isStreaming(), valid.getCameraState()), null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -10249, 7, null));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final CallParticipant.UserOrStreamParticipant computePipParticipant(long myUserId, DeviceDescription4 selectedVideoInputDevice, boolean isStreaming, CameraState cameraState) {
        Object next;
        if (this.allVideoParticipants.isEmpty()) {
            return null;
        }
        Iterator<T> it = this.allVideoParticipants.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            CallParticipant callParticipant = (CallParticipant) next;
            if (callParticipant instanceof CallParticipant.UserOrStreamParticipant) {
                CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
                VoiceState voiceState = userOrStreamParticipant.getParticipantData().voiceParticipant.getVoiceState();
                boolean z2 = voiceState != null && voiceState.getSelfVideo() && userOrStreamParticipant.getParticipantData().voiceParticipant.isMe();
                if (z2) {
                    break;
                }
            }
        }
        CallParticipant callParticipant2 = (CallParticipant) next;
        boolean z3 = isStreaming && cameraState == CameraState.CAMERA_ON;
        String str = this.focusedVideoParticipantKey;
        boolean z4 = isOneOnOneMeCall(this.allVideoParticipants) || (str != null && !Intrinsics3.areEqual(str, String.valueOf(myUserId))) || z3;
        if (callParticipant2 == null || !(callParticipant2 instanceof CallParticipant.UserOrStreamParticipant) || !z4) {
            return null;
        }
        CallParticipant.UserOrStreamParticipant userOrStreamParticipant2 = (CallParticipant.UserOrStreamParticipant) callParticipant2;
        return userOrStreamParticipant2.copy(VideoCallParticipantView.ParticipantData.a(userOrStreamParticipant2.getParticipantData(), null, (selectedVideoInputDevice != null ? selectedVideoInputDevice.getFacing() : null) == DeviceDescription5.Front, null, null, null, null, false, false, null, 445));
    }

    @MainThread
    private final List<CallParticipant> computeVisibleVideoParticipants() {
        Object next;
        CallParticipant callParticipantCopy;
        String str = this.focusedVideoParticipantKey;
        Object obj = null;
        if (str != null) {
            Iterator<T> it = this.allVideoParticipants.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics3.areEqual(getParticipantFocusKey((CallParticipant) next), str)) {
                    break;
                }
            }
            CallParticipant callParticipant = (CallParticipant) next;
            if (callParticipant != null) {
                if (callParticipant instanceof CallParticipant.UserOrStreamParticipant) {
                    CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
                    VideoCallParticipantView.ParticipantData participantData = userOrStreamParticipant.getParticipantData();
                    RendererCommon.ScalingType scalingType = participantData.scalingType;
                    RendererCommon.ScalingType scalingType2 = participantData.scalingTypeMismatchOrientation;
                    RendererCommon.ScalingType scalingType3 = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
                    callParticipantCopy = userOrStreamParticipant;
                    if (scalingType != scalingType3 || scalingType2 != scalingType3) {
                        callParticipantCopy = userOrStreamParticipant.copy(VideoCallParticipantView.ParticipantData.a(userOrStreamParticipant.getParticipantData(), null, false, scalingType3, scalingType3, null, null, false, false, null, 499));
                    }
                } else {
                    boolean z2 = callParticipant instanceof CallParticipant.EmbeddedActivityParticipant;
                    callParticipantCopy = callParticipant;
                    if (!z2) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return CollectionsJVM.listOf(callParticipantCopy);
            }
            this.focusedVideoParticipantKey = null;
            stopWatchingStreamIfEnded();
        }
        if (isOneOnOneMeCall(this.allVideoParticipants)) {
            Iterator<T> it2 = this.allVideoParticipants.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                CallParticipant callParticipant2 = (CallParticipant) next2;
                if ((callParticipant2 instanceof CallParticipant.EmbeddedActivityParticipant) || ((callParticipant2 instanceof CallParticipant.UserOrStreamParticipant) && !((CallParticipant.UserOrStreamParticipant) callParticipant2).getParticipantData().voiceParticipant.isMe())) {
                    obj = next2;
                    break;
                }
            }
            CallParticipant callParticipant3 = (CallParticipant) obj;
            if (callParticipant3 != null) {
                return CollectionsJVM.listOf(callParticipant3);
            }
        }
        return this.allVideoParticipants;
    }

    private final List<StoreVoiceParticipants.VoiceUser> createPrivateCallParticipantListItems(CallModel callModel) {
        return _Collections.toList(callModel.getParticipants().values());
    }

    private final Comparator<StoreVoiceParticipants.VoiceUser> createUserItemsComparator(boolean prioritizeSpectators, String mySpectatingStreamKey) {
        return new AnonymousClass1(mySpectatingStreamKey, prioritizeSpectators);
    }

    public static /* synthetic */ Comparator createUserItemsComparator$default(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return widgetCallFullscreenViewModel.createUserItemsComparator(z2, str);
    }

    private final List<CallParticipant> createVideoGridEntriesForParticipant(StoreVoiceParticipants.VoiceUser participant, long channelId, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection.Quality streamQuality, DeviceDescription4 selectedVideoInputDevice, boolean showLabels) {
        VoiceState voiceState;
        ModelApplicationStream stream;
        ArrayList arrayList = new ArrayList();
        if (!participant.isConnected() && !participant.isRinging()) {
            return Collections2.emptyList();
        }
        String encodedStreamKey = null;
        arrayList.add(new CallParticipant.UserOrStreamParticipant(new VideoCallParticipantView.ParticipantData(participant, participant.isMe() && ((selectedVideoInputDevice != null ? selectedVideoInputDevice.getFacing() : null) == DeviceDescription5.Front), null, null, null, null, showLabels, false, null, 444)));
        if (participant.getApplicationStream() == null || (voiceState = participant.getVoiceState()) == null || !voiceState.getSelfStream()) {
            if (activeApplicationStream != null) {
                ModelApplicationStream stream2 = activeApplicationStream.getStream();
                if (participant.getUser().getId() == stream2.getOwnerId()) {
                    VideoCallParticipantView.ParticipantData.ApplicationStreamState participantStreamState = getParticipantStreamState(activeApplicationStream.getState());
                    RendererCommon.ScalingType scalingType = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
                    VideoCallParticipantView.ParticipantData participantData = new VideoCallParticipantView.ParticipantData(participant, false, scalingType, scalingType, participantStreamState, VideoCallParticipantView.ParticipantData.Type.APPLICATION_STREAMING, showLabels, false, null, 384);
                    if (isStreamFocused(stream2)) {
                        arrayList.add(new CallParticipant.UserOrStreamParticipant(participantData));
                    } else {
                        stopWatchingStreamIfEnded();
                    }
                }
            }
        } else {
            if (participant.getApplicationStream().getChannelId() != channelId) {
                return arrayList;
            }
            if (activeApplicationStream != null && (stream = activeApplicationStream.getStream()) != null) {
                encodedStreamKey = stream.getEncodedStreamKey();
            }
            VideoCallParticipantView.ParticipantData.ApplicationStreamState participantStreamState2 = Intrinsics3.areEqual(encodedStreamKey, participant.getApplicationStream().getEncodedStreamKey()) ? getParticipantStreamState(activeApplicationStream.getState()) : VideoCallParticipantView.ParticipantData.ApplicationStreamState.INACTIVE;
            RendererCommon.ScalingType scalingType2 = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
            arrayList.add(new CallParticipant.UserOrStreamParticipant(new VideoCallParticipantView.ParticipantData(participant, false, scalingType2, scalingType2, participantStreamState2, VideoCallParticipantView.ParticipantData.Type.APPLICATION_STREAMING, showLabels, false, null, 384)));
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(addStreamQualityMetadata((CallParticipant) it.next(), streamQuality));
        }
        return arrayList2;
    }

    private final void emitServerDeafenedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowServerDeafenedDialog.INSTANCE);
    }

    private final void emitServerMutedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowServerMutedDialog.INSTANCE);
    }

    private final void emitShowNoScreenSharePermissionDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowNoScreenSharePermissionDialog.INSTANCE);
    }

    private final void emitShowNoVadPermissionDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowNoVadPermissionDialog.INSTANCE);
    }

    private final void emitShowNoVideoPermissionDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowNoVideoPermissionDialog.INSTANCE);
    }

    private final void emitSuppressedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowSuppressedDialog.INSTANCE);
    }

    private final void enqueueStreamFeedbackSheet(String streamKey, String mediaSessionId, int triggerRateDenominator) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.EnqueueStreamFeedbackSheet(streamKey, mediaSessionId, triggerRateDenominator));
    }

    private final String getParticipantFocusKey(CallParticipant callParticipant) {
        if (!(callParticipant instanceof CallParticipant.UserOrStreamParticipant)) {
            if (callParticipant instanceof CallParticipant.EmbeddedActivityParticipant) {
                return String.valueOf(((CallParticipant.EmbeddedActivityParticipant) callParticipant).getApplication().getId());
            }
            throw new NoWhenBranchMatchedException();
        }
        CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
        long id2 = userOrStreamParticipant.getParticipantData().voiceParticipant.getUser().getId();
        int iOrdinal = userOrStreamParticipant.getParticipantData().type.ordinal();
        if (iOrdinal == 0) {
            return String.valueOf(id2);
        }
        if (iOrdinal != 1) {
            throw new NoWhenBranchMatchedException();
        }
        return id2 + "--STREAM";
    }

    private final VideoCallParticipantView.ParticipantData.ApplicationStreamState getParticipantStreamState(StoreApplicationStreaming.ActiveApplicationStream.State applicationStreamState) {
        int iOrdinal = applicationStreamState.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return VideoCallParticipantView.ParticipantData.ApplicationStreamState.ACTIVE;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return VideoCallParticipantView.ParticipantData.ApplicationStreamState.ENDED;
                }
                if (iOrdinal == 4) {
                    return VideoCallParticipantView.ParticipantData.ApplicationStreamState.PAUSED;
                }
                if (iOrdinal == 5) {
                    return VideoCallParticipantView.ParticipantData.ApplicationStreamState.INACTIVE;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return VideoCallParticipantView.ParticipantData.ApplicationStreamState.CONNECTING;
    }

    private final boolean hasVideoPermission() {
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null) {
            return false;
        }
        VideoPermissionsManager videoPermissionsManager = this.videoPermissionsManager;
        Channel channel = valid.getCallModel().getChannel();
        Guild guild = valid.getCallModel().getGuild();
        return videoPermissionsManager.hasVideoPermission(channel, guild != null ? guild.getAfkChannelId() : null, valid.getMyPermissions());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isOneOnOneMeCall(List<? extends CallParticipant> callParticipants) {
        boolean z2;
        if (callParticipants.size() == 2) {
            if (callParticipants.isEmpty()) {
                z2 = false;
                if (!z2) {
                    return true;
                }
            } else {
                for (CallParticipant callParticipant : callParticipants) {
                    if ((callParticipant instanceof CallParticipant.UserOrStreamParticipant) && ((CallParticipant.UserOrStreamParticipant) callParticipant).getParticipantData().voiceParticipant.isMe()) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (!z2) {
                }
            }
        }
        return false;
    }

    private final boolean isStreamFocused(ModelApplicationStream stream) {
        return Intrinsics3.areEqual(this.focusedVideoParticipantKey, stream.getOwnerId() + "--STREAM");
    }

    private final Observable<StoreState> observeStoreState() {
        Observable observableY = this.storeChannels.observeChannel(this.channelId).Y(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannels.observeCha…}\n        }\n      }\n    }");
        return observableY;
    }

    @MainThread
    private final void onIdleStateChanged(Boolean isIdleFooter, Boolean isIdleHeader) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            boolean z2 = isIdleFooter != null && (Intrinsics3.areEqual(isIdleFooter, Boolean.valueOf(valid.isIdleFooter())) ^ true);
            boolean z3 = isIdleHeader != null && (Intrinsics3.areEqual(isIdleHeader, Boolean.valueOf(valid.isIdleHeader())) ^ true);
            if (z2) {
                if (isIdleFooter != null) {
                    isIdleFooter.booleanValue();
                    updateViewState2((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, isIdleFooter.booleanValue(), false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -17, 7, null));
                }
                if (isIdleFooter != null) {
                    isIdleFooter.booleanValue();
                    this.eventSubject.k.onNext(new Event.OnIdleStateChanged(isIdleFooter.booleanValue()));
                }
            }
            if (!z3 || isIdleHeader == null) {
                return;
            }
            isIdleHeader.booleanValue();
            updateViewState2((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, isIdleHeader.booleanValue(), false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -33, 7, null));
        }
    }

    public static /* synthetic */ void onIdleStateChanged$default(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            bool2 = null;
        }
        widgetCallFullscreenViewModel.onIdleStateChanged(bool, bool2);
    }

    @MainThread
    private final void setOffScreenVideoParticipants(List<VideoCallParticipantView.ParticipantData> visibleVideoParticipants) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || !valid.getStopOffscreenVideo()) {
            return;
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(visibleVideoParticipants, 10));
        Iterator<T> it = visibleVideoParticipants.iterator();
        while (it.hasNext()) {
            arrayList.add(((VideoCallParticipantView.ParticipantData) it.next()).com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String);
        }
        HashSet hashSet = _Collections.toHashSet(arrayList);
        for (CallParticipant callParticipant : computeVisibleVideoParticipants()) {
            if (callParticipant instanceof CallParticipant.UserOrStreamParticipant) {
                VideoCallParticipantView.ParticipantData participantData = ((CallParticipant.UserOrStreamParticipant) callParticipant).getParticipantData();
                if (participantData.type == VideoCallParticipantView.ParticipantData.Type.DEFAULT) {
                    this.mediaSettingsStore.setUserOffScreen(participantData.voiceParticipant.getUser().getId(), !hashSet.contains(participantData.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String));
                }
            }
        }
    }

    private final boolean shouldShowMoreAudioOutputs(CallModel callModel) {
        List<DiscordAudioManager.AudioDevice> audioDevices = callModel.getAudioManagerState().getAudioDevices();
        if (!(audioDevices instanceof Collection) || !audioDevices.isEmpty()) {
            for (DiscordAudioManager.AudioDevice audioDevice : audioDevices) {
                if (audioDevice.type == DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET && audioDevice.isAvailable) {
                    return true;
                }
            }
        }
        return false;
    }

    @MainThread
    private final void startTapForwardingJob() {
        cancelTapForwardingJob();
        Observable<Long> observableE0 = Observable.e0(255L, TimeUnit.MILLISECONDS, this.backgroundThreadScheduler);
        Intrinsics3.checkNotNullExpressionValue(observableE0, "Observable\n        .time…ackgroundThreadScheduler)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableE0, this, null, 2, null), WidgetCallFullscreenViewModel.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
    }

    @MainThread
    private final void stopWatchingStream() {
        StoreApplicationStreaming.ActiveApplicationStream activeStream;
        ModelApplicationStream stream;
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Valid)) {
            viewStateRequireViewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewStateRequireViewState;
        if (valid == null || (activeStream = valid.getCallModel().getActiveStream()) == null || (stream = activeStream.getStream()) == null) {
            return;
        }
        this.applicationStreamingStore.stopStream(stream.getEncodedStreamKey());
        CallModel callModel = valid.getCallModel();
        if (isStreamFocused(stream)) {
            this.focusedVideoParticipantKey = null;
            updateViewState2((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, computeVisibleVideoParticipants(), false, false, false, false, null, null, null, this.focusedVideoParticipantKey, false, computePipParticipant(callModel.getMyId(), callModel.getSelectedVideoDevice(), callModel.isStreaming(), valid.getCameraState()), null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -10249, 7, null));
        }
    }

    @MainThread
    private final void stopWatchingStreamIfEnded() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            StoreApplicationStreaming.ActiveApplicationStream activeStream = valid.getCallModel().getActiveStream();
            StoreApplicationStreaming.ActiveApplicationStream activeStream2 = valid.getCallModel().getActiveStream();
            if (activeStream2 != null) {
                activeStream2.getStream();
            }
            if ((activeStream != null ? activeStream.getState() : null) == StoreApplicationStreaming.ActiveApplicationStream.State.ENDED) {
                stopWatchingStream();
            }
        }
    }

    public final void disableControlFading() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null && !valid.isControlFadingDisabled()) {
            updateViewState2((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, false, true, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -65, 7, null));
        }
    }

    @MainThread
    public final void disconnect() {
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        this.selectedVoiceChannelStore.clear();
        if (!this.wasEverConnected || this.wasEverMultiParticipant) {
            ViewState viewState = getViewState();
            if (!(viewState instanceof ViewState.Valid)) {
                viewState = null;
            }
            ViewState.Valid valid = (ViewState.Valid) viewState;
            if (valid != null) {
                CallModel callModel = valid.getCallModel();
                RtcConnection.Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
                this.eventSubject.k.onNext(new Event.EnqueueCallFeedbackSheet(this.channelId, rtcConnectionMetadata != null ? rtcConnectionMetadata.rtcConnectionId : null, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getCallDurationMs(this.clock), callModel.getCallFeedbackTriggerRateDenominator()));
            }
        }
    }

    @MainThread
    public final void focusVideoParticipant(String participantKey) {
        Intrinsics3.checkNotNullParameter(participantKey, "participantKey");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            if (!isOneOnOneMeCall(this.allVideoParticipants)) {
                this.focusedVideoParticipantKey = participantKey;
            }
            updateViewState2((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, computeVisibleVideoParticipants(), false, false, false, false, null, null, null, this.focusedVideoParticipantKey, false, computePipParticipant(valid.getCallModel().getMyId(), valid.getCallModel().getSelectedVideoDevice(), valid.getCallModel().isStreaming(), valid.getCameraState()), null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -10249, 7, null));
        }
    }

    public final boolean getShowStageCallBottomSheet() {
        return this.showStageCallBottomSheet;
    }

    @MainThread
    public final void handleBottomSheetState(int bottomSheetState) {
        this.bottomSheetState = Integer.valueOf(bottomSheetState);
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0633  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x065c  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0645 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0673 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0176  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleStoreState(StoreState storeState) {
        boolean z2;
        VoiceState voiceState;
        VoiceState voiceState2;
        StoreState storeState2;
        int channelMentionsCount;
        StoreState storeState3;
        int unreadsCount;
        ViewState viewState;
        ViewState viewState2;
        ViewState viewState3;
        CallModel callModel;
        CallModel callModel2;
        int i;
        int i2;
        int i3;
        StageCallModel stageCallModel;
        List<? extends CallParticipant> listEmptyList;
        List<StageCallModel5> mediaParticipants;
        List<? extends CallParticipant> list;
        CameraState cameraState;
        boolean zShouldShowMoreAudioOutputs;
        VoiceControlsOutputSelectorState voiceControlsOutputSelectorState;
        String str;
        CallModel callModel3;
        ViewState viewState4;
        boolean z3;
        ViewState viewState5;
        ViewState viewState6;
        Iterator it;
        Object next;
        Iterator<T> it2;
        Object next2;
        String str2;
        StageRoles stageRolesM68getMyStageRolestwRsX0;
        StageRoles stageRolesM68getMyStageRolestwRsX02;
        boolean z4;
        ModelApplicationStream applicationStream;
        Iterator<Map.Entry<Long, EmbeddedActivity>> it3;
        int i4;
        CallParticipant.EmbeddedActivityParticipant embeddedActivityParticipant;
        ModelApplicationStream stream;
        CallModel callModel4;
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            updateViewState2((ViewState) ViewState.Invalid.INSTANCE);
        } else if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            boolean zD = ChannelUtils.D(valid.getCallModel().getChannel());
            if (!zD && new TextInVoiceOnboardingManager().shouldShowTextInVoiceOnboarding(valid.getCallModel().getMyId(), Long.valueOf(valid.getCallModel().getChannel().getGuildId()))) {
                this.eventSubject.k.onNext(Event.ShowTextInVoiceNux.INSTANCE);
            }
            if (this.startedAsVideo == null) {
                this.startedAsVideo = Boolean.valueOf(valid.getCallModel().getIsVideoCall());
            }
            StoreState storeState4 = this.mostRecentStoreState;
            if (!(storeState4 instanceof StoreState.Valid)) {
                storeState4 = null;
            }
            StoreState.Valid valid2 = (StoreState.Valid) storeState4;
            boolean zIsChannelSelected = (valid2 == null || (callModel4 = valid2.getCallModel()) == null) ? false : callModel4.isChannelSelected();
            boolean zIsChannelSelected2 = valid.getCallModel().isChannelSelected();
            if (zIsChannelSelected && !zIsChannelSelected2) {
                updateViewState2((ViewState) ViewState.Invalid.INSTANCE);
                return;
            }
            OverlayStatus overlayStatus = this.userSettingsStore.getIsMobileOverlayEnabled() ? OverlayStatus.ENABLED : OverlayStatus.DISABLED;
            DeviceDescription4 selectedVideoDevice = valid.getCallModel().getSelectedVideoDevice();
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = valid.getCallModel().getParticipants().values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                z2 = false;
                storeState2 = this.mostRecentStoreState;
                if (!(storeState2 instanceof StoreState.Valid)) {
                }
                StoreState.Valid valid3 = (StoreState.Valid) storeState2;
                if (valid3 == null) {
                }
                storeState3 = this.mostRecentStoreState;
                if (!(storeState3 instanceof StoreState.Valid)) {
                }
                StoreState.Valid valid4 = (StoreState.Valid) storeState3;
                if (valid4 == null) {
                }
                viewState = getViewState();
                if (!(viewState instanceof ViewState.Valid)) {
                }
                ViewState.Valid valid5 = (ViewState.Valid) viewState;
                if (valid5 == null) {
                }
                viewState2 = getViewState();
                if (!(viewState2 instanceof ViewState.Valid)) {
                }
                ViewState.Valid valid6 = (ViewState.Valid) viewState2;
                if (valid6 == null) {
                }
                viewState3 = getViewState();
                if (!(viewState3 instanceof ViewState.Valid)) {
                }
                ViewState.Valid valid7 = (ViewState.Valid) viewState3;
                if (valid7 == null) {
                }
                StoreApplicationStreaming.ActiveApplicationStream activeStream = valid.getCallModel().getActiveStream();
                if (activeStream != null) {
                    callModel = valid.getCallModel();
                    if (callModel.isConnected()) {
                        callModel2 = callModel;
                        i = unreadsCount;
                        i2 = channelMentionsCount;
                        i3 = 10;
                        listEmptyList = !valid.getCallModel().isConnected() ? Collections2.emptyList() : Collections2.emptyList();
                        list = listEmptyList;
                        this.allVideoParticipants = list;
                        if (isOneOnOneMeCall(list)) {
                        }
                        List<CallParticipant> listComputeVisibleVideoParticipants = computeVisibleVideoParticipants();
                        if (zD) {
                            cameraState = CameraState.CAMERA_DISABLED;
                        }
                        CameraState cameraState2 = cameraState;
                        if (callModel2.getVideoDevices().size() < 2) {
                            if (ChannelUtils.B(callModel2.getChannel())) {
                                DisplayMode displayMode = (ChannelUtils.B(callModel2.getChannel()) || z2) ? !zD ? DisplayMode.STAGE : DisplayMode.GRID : DisplayMode.PRIVATE_CALL_PARTICIPANTS;
                                StoreAudioManagerV2.State audioManagerState = callModel2.getAudioManagerState();
                                zShouldShowMoreAudioOutputs = shouldShowMoreAudioOutputs(valid.getCallModel());
                                DiscordAudioManager.DeviceTypes activeAudioDevice = audioManagerState.getActiveAudioDevice();
                                if (zShouldShowMoreAudioOutputs) {
                                }
                                VoiceControlsOutputSelectorState voiceControlsOutputSelectorState2 = voiceControlsOutputSelectorState;
                                str = this.autotargetStreamKey;
                                if (str != null) {
                                    if (list instanceof Collection) {
                                        while (r1.hasNext()) {
                                        }
                                        z4 = false;
                                        if (z4) {
                                        }
                                        this.autotargetStreamKey = null;
                                    }
                                }
                                CallParticipant.UserOrStreamParticipant userOrStreamParticipantComputePipParticipant = computePipParticipant(callModel2.getMyId(), callModel2.getSelectedVideoDevice(), callModel2.isStreaming(), cameraState2);
                                callModel3 = callModel2;
                                List<StoreVoiceParticipants.VoiceUser> listCreatePrivateCallParticipantListItems = createPrivateCallParticipantListItems(callModel3);
                                StoreConnectivity.State state = valid.getConnectivityState().getState();
                                if (state != StoreConnectivity.State.OFFLINE) {
                                    if (ChannelUtils.D(callModel3.getChannel())) {
                                    }
                                    if (this.wasEverMultiParticipant) {
                                        this.wasEverMultiParticipant = this.wasEverMultiParticipant || valid.getCallModel().getNumUsersConnected() > 1;
                                        if (this.wasEverConnected) {
                                            this.wasEverConnected = !this.wasEverConnected || valid.getCallModel().isConnected();
                                            ArrayList<CallParticipant.UserOrStreamParticipant> arrayList = new ArrayList();
                                            while (r2.hasNext()) {
                                            }
                                            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, i3));
                                            while (r1.hasNext()) {
                                            }
                                            Map map = Maps6.toMap(arrayList2);
                                            if (i2 >= valid.getChannelMentionsCount()) {
                                                viewState4 = null;
                                                VideoPlayerIdleDetector.onInteraction$default(this.videoPlayerIdleDetectorHeader, false, 1, null);
                                                z3 = false;
                                                StageCallModel stageCallModel2 = valid.getStageCallModel();
                                                String str3 = this.focusedVideoParticipantKey;
                                                Boolean noiseCancellation = valid.getNoiseCancellation();
                                                if (valid.getCallModel().getVoiceSettings().getVoiceParticipantsHidden()) {
                                                    boolean zIsScreenReaderEnabled = valid.isScreenReaderEnabled();
                                                    Boolean bool = this.startedAsVideo;
                                                    if (bool == null) {
                                                    }
                                                    float fAmplitudeToPerceptual = PerceptualVolumeUtils.INSTANCE.amplitudeToPerceptual(valid.getStreamVolume(), 300.0f);
                                                    int iCoerceAtLeast = _Ranges.coerceAtLeast(valid.getTotalMentionsCount() - valid.getChannelMentionsCount(), 0);
                                                    StageRoles stageRolesM68getMyStageRolestwRsX03 = valid.m68getMyStageRolestwRsX0();
                                                    viewState5 = getViewState();
                                                    if (!(viewState5 instanceof ViewState.Valid)) {
                                                    }
                                                    ViewState.Valid valid8 = (ViewState.Valid) viewState5;
                                                    if (valid8 == null) {
                                                        viewState6 = getViewState();
                                                        if (!(viewState6 instanceof ViewState.Valid)) {
                                                        }
                                                        ViewState.Valid valid9 = (ViewState.Valid) viewState6;
                                                        if (valid9 == null) {
                                                        }
                                                        StageCallModel stageCallModel3 = valid.getStageCallModel();
                                                        if (stageCallModel3 == null) {
                                                        }
                                                        boolean stopOffscreenVideo = valid.getStopOffscreenVideo();
                                                        Long myPermissions = valid.getMyPermissions();
                                                        it = _Collections.sortedWith(valid.getCallModel().getGuildScheduledEvents(), new WidgetCallFullscreenViewModel$handleStoreState$$inlined$sortedBy$1()).iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                            }
                                                        }
                                                        GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
                                                        it2 = valid.getCallModel().getGuildScheduledEvents().iterator();
                                                        while (true) {
                                                            if (!it2.hasNext()) {
                                                            }
                                                        }
                                                        updateViewState2((ViewState) new ViewState.Valid(callModel3, stageCallModel2, overlayStatus, listComputeVisibleVideoParticipants, zIsIdleFooter, z3, zIsControlFadingDisabled, z, cameraState2, displayMode, voiceControlsOutputSelectorState2, str3, z2, userOrStreamParticipantComputePipParticipant, noiseCancellation, listCreatePrivateCallParticipantListItems, z, zIsScreenReaderEnabled, zBooleanValue, fAmplitudeToPerceptual, iCoerceAtLeast, z, stageRolesM68getMyStageRolestwRsX03, z, z, requestingToSpeakCount, stopOffscreenVideo, myPermissions, guildScheduledEvent, (GuildScheduledEvent) next2, valid.getChannelMentionsCount(), valid.getUnreadsCount(), valid.isTextInVoiceEnabled(), valid.isTextInVoiceChannelSelected(), map, null));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else if (ChannelUtils.D(callModel3.getChannel())) {
                                }
                            }
                        }
                    }
                }
            } else {
                for (StoreVoiceParticipants.VoiceUser voiceUser : collectionValues) {
                    if (voiceUser.isConnected() && (((voiceState = voiceUser.getVoiceState()) != null && voiceState.getSelfVideo()) || ((voiceState2 = voiceUser.getVoiceState()) != null && voiceState2.getSelfStream()))) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                storeState2 = this.mostRecentStoreState;
                if (!(storeState2 instanceof StoreState.Valid)) {
                    storeState2 = null;
                }
                StoreState.Valid valid32 = (StoreState.Valid) storeState2;
                channelMentionsCount = valid32 == null ? valid32.getChannelMentionsCount() : 0;
                storeState3 = this.mostRecentStoreState;
                if (!(storeState3 instanceof StoreState.Valid)) {
                    storeState3 = null;
                }
                StoreState.Valid valid42 = (StoreState.Valid) storeState3;
                unreadsCount = valid42 == null ? valid42.getUnreadsCount() : 0;
                viewState = getViewState();
                if (!(viewState instanceof ViewState.Valid)) {
                    viewState = null;
                }
                ViewState.Valid valid52 = (ViewState.Valid) viewState;
                boolean zIsIdleFooter = valid52 == null ? valid52.isIdleFooter() : false;
                viewState2 = getViewState();
                if (!(viewState2 instanceof ViewState.Valid)) {
                    viewState2 = null;
                }
                ViewState.Valid valid62 = (ViewState.Valid) viewState2;
                boolean zIsIdleHeader = valid62 == null ? valid62.isIdleHeader() : false;
                viewState3 = getViewState();
                if (!(viewState3 instanceof ViewState.Valid)) {
                    viewState3 = null;
                }
                ViewState.Valid valid72 = (ViewState.Valid) viewState3;
                boolean zIsControlFadingDisabled = valid72 == null ? valid72.isControlFadingDisabled() : false;
                StoreApplicationStreaming.ActiveApplicationStream activeStream2 = valid.getCallModel().getActiveStream();
                String encodedStreamKey = (activeStream2 != null || (stream = activeStream2.getStream()) == null) ? null : stream.getEncodedStreamKey();
                callModel = valid.getCallModel();
                if (callModel.isConnected() || zD) {
                    callModel2 = callModel;
                    i = unreadsCount;
                    i2 = channelMentionsCount;
                    i3 = 10;
                    if (!valid.getCallModel().isConnected() && (stageCallModel = valid.getStageCallModel()) != null && (mediaParticipants = stageCallModel.getMediaParticipants()) != null) {
                        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(mediaParticipants, 10));
                        Iterator<T> it4 = mediaParticipants.iterator();
                        while (it4.hasNext()) {
                            arrayList3.add(createVideoGridEntriesForParticipant(((StageCallModel5) it4.next()).getVoiceUser(), valid.getCallModel().getChannel().getId(), valid.getCallModel().getActiveStream(), valid.getStreamQuality(), valid.getCallModel().getSelectedVideoDevice(), !zIsIdleFooter));
                        }
                        listEmptyList = Iterables2.flatten(arrayList3);
                        if (listEmptyList == null) {
                        }
                    }
                } else {
                    Map<Long, EmbeddedActivity> embeddedActivitiesForChannel = callModel.getEmbeddedActivitiesForChannel();
                    Iterator<Long> it5 = embeddedActivitiesForChannel.keySet().iterator();
                    while (it5.hasNext()) {
                        long jLongValue = it5.next().longValue();
                        this.applicationStore.fetchIfNonexisting(jLongValue);
                        this.applicationAssetsStore.fetchIfNonExisting(jLongValue);
                    }
                    ArrayList arrayList4 = new ArrayList(embeddedActivitiesForChannel.size());
                    Iterator<Map.Entry<Long, EmbeddedActivity>> it6 = embeddedActivitiesForChannel.entrySet().iterator();
                    while (it6.hasNext()) {
                        Map.Entry<Long, EmbeddedActivity> next3 = it6.next();
                        long jLongValue2 = next3.getKey().longValue();
                        EmbeddedActivity value = next3.getValue();
                        Application application = callModel.getApplications().get(Long.valueOf(jLongValue2));
                        if (application != null) {
                            it3 = it6;
                            i4 = unreadsCount;
                            embeddedActivityParticipant = new CallParticipant.EmbeddedActivityParticipant(value, EmbeddedActivityUtils.getActivityParticipants(value, callModel.getParticipants()), com.discord.models.commands.Application.INSTANCE.fromApiApplication(application), valid.getEmbeddedAppBackgrounds().get(Long.valueOf(jLongValue2)));
                        } else {
                            it3 = it6;
                            i4 = unreadsCount;
                            embeddedActivityParticipant = null;
                        }
                        arrayList4.add(embeddedActivityParticipant);
                        it6 = it3;
                        unreadsCount = i4;
                    }
                    int i5 = unreadsCount;
                    List listFilterNotNull = _Collections.filterNotNull(arrayList4);
                    List listSortedWith = _Collections.sortedWith(callModel.getParticipants().values(), createUserItemsComparator$default(this, false, encodedStreamKey, 1, null));
                    ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
                    Iterator it7 = listSortedWith.iterator();
                    while (it7.hasNext()) {
                        arrayList5.add(createVideoGridEntriesForParticipant((StoreVoiceParticipants.VoiceUser) it7.next(), valid.getCallModel().getChannel().getId(), valid.getCallModel().getActiveStream(), valid.getStreamQuality(), valid.getCallModel().getSelectedVideoDevice(), !zIsIdleFooter));
                        callModel = callModel;
                        it7 = it7;
                        channelMentionsCount = channelMentionsCount;
                    }
                    callModel2 = callModel;
                    i2 = channelMentionsCount;
                    i = i5;
                    i3 = 10;
                    List listFlatten = Iterables2.flatten(arrayList5);
                    ArrayList arrayList6 = new ArrayList();
                    for (Object obj : listFlatten) {
                        if (!valid.getCallModel().getVoiceSettings().getVoiceParticipantsHidden() || ((CallParticipant) obj).hasActiveVideo()) {
                            arrayList6.add(obj);
                        }
                    }
                    listEmptyList = _Collections.plus((Collection) listFilterNotNull, (Iterable) arrayList6);
                }
                list = listEmptyList;
                this.allVideoParticipants = list;
                if (isOneOnOneMeCall(list)) {
                    this.focusedVideoParticipantKey = null;
                }
                List<CallParticipant> listComputeVisibleVideoParticipants2 = computeVisibleVideoParticipants();
                cameraState = (zD && callModel2.isConnected()) ? selectedVideoDevice == null ? CameraState.CAMERA_ON : CameraState.CAMERA_OFF : CameraState.CAMERA_DISABLED;
                CameraState cameraState22 = cameraState;
                boolean z5 = !(callModel2.getVideoDevices().size() < 2) && cameraState22 == CameraState.CAMERA_ON;
                DisplayMode displayMode2 = (ChannelUtils.B(callModel2.getChannel()) || z2) ? !zD ? DisplayMode.STAGE : DisplayMode.GRID : DisplayMode.PRIVATE_CALL_PARTICIPANTS;
                StoreAudioManagerV2.State audioManagerState2 = callModel2.getAudioManagerState();
                zShouldShowMoreAudioOutputs = shouldShowMoreAudioOutputs(valid.getCallModel());
                DiscordAudioManager.DeviceTypes activeAudioDevice2 = audioManagerState2.getActiveAudioDevice();
                if (zShouldShowMoreAudioOutputs) {
                    voiceControlsOutputSelectorState = activeAudioDevice2 == DiscordAudioManager.DeviceTypes.SPEAKERPHONE ? VoiceControlsOutputSelectorState.SPEAKER_ON : VoiceControlsOutputSelectorState.SPEAKER_OFF;
                } else {
                    int iOrdinal = activeAudioDevice2.ordinal();
                    voiceControlsOutputSelectorState = iOrdinal != 2 ? iOrdinal != 5 ? VoiceControlsOutputSelectorState.SPEAKER_OFF_AND_MORE : VoiceControlsOutputSelectorState.BLUETOOTH_ON_AND_MORE : VoiceControlsOutputSelectorState.SPEAKER_ON_AND_MORE;
                }
                VoiceControlsOutputSelectorState voiceControlsOutputSelectorState22 = voiceControlsOutputSelectorState;
                str = this.autotargetStreamKey;
                if (str != null && (!list.isEmpty())) {
                    if ((list instanceof Collection) || !list.isEmpty()) {
                        for (CallParticipant callParticipant : list) {
                            if (!(callParticipant instanceof CallParticipant.UserOrStreamParticipant)) {
                                callParticipant = null;
                            }
                            CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
                            if (Intrinsics3.areEqual((userOrStreamParticipant == null || (applicationStream = userOrStreamParticipant.getParticipantData().voiceParticipant.getApplicationStream()) == null) ? null : applicationStream.getEncodedStreamKey(), str)) {
                                z4 = true;
                                break;
                            }
                        }
                        z4 = false;
                        if (z4) {
                            targetAndFocusStream(str);
                        }
                        this.autotargetStreamKey = null;
                    } else {
                        z4 = false;
                        if (z4) {
                        }
                        this.autotargetStreamKey = null;
                    }
                }
                CallParticipant.UserOrStreamParticipant userOrStreamParticipantComputePipParticipant2 = computePipParticipant(callModel2.getMyId(), callModel2.getSelectedVideoDevice(), callModel2.isStreaming(), cameraState22);
                callModel3 = callModel2;
                List<StoreVoiceParticipants.VoiceUser> listCreatePrivateCallParticipantListItems2 = createPrivateCallParticipantListItems(callModel3);
                StoreConnectivity.State state2 = valid.getConnectivityState().getState();
                boolean z6 = (state2 != StoreConnectivity.State.OFFLINE || state2 == StoreConnectivity.State.OFFLINE_AIRPLANE_MODE) && displayMode2 == DisplayMode.PRIVATE_CALL_PARTICIPANTS;
                if (ChannelUtils.D(callModel3.getChannel())) {
                    StoreState storeState5 = this.mostRecentStoreState;
                    if (!(storeState5 instanceof StoreState.Valid)) {
                        storeState5 = null;
                    }
                    StoreState.Valid valid10 = (StoreState.Valid) storeState5;
                    if (valid10 != null && (stageRolesM68getMyStageRolestwRsX0 = valid10.m68getMyStageRolestwRsX0()) != null && !StageRoles.m33isSpeakerimpl(stageRolesM68getMyStageRolestwRsX0.m35unboximpl()) && (stageRolesM68getMyStageRolestwRsX02 = valid.m68getMyStageRolestwRsX0()) != null && StageRoles.m33isSpeakerimpl(stageRolesM68getMyStageRolestwRsX02.m35unboximpl()) && !PermissionUtils.can(Permission.USE_VAD, valid.getMyPermissions()) && callModel3.getInputMode() != MediaEngineConnection.InputMode.PUSH_TO_TALK) {
                        emitShowNoVadPermissionDialogEvent();
                    }
                }
                this.wasEverMultiParticipant = this.wasEverMultiParticipant || valid.getCallModel().getNumUsersConnected() > 1;
                this.wasEverConnected = !this.wasEverConnected || valid.getCallModel().isConnected();
                ArrayList<CallParticipant.UserOrStreamParticipant> arrayList7 = new ArrayList();
                for (Object obj2 : list) {
                    if (obj2 instanceof CallParticipant.UserOrStreamParticipant) {
                        arrayList7.add(obj2);
                    }
                }
                ArrayList arrayList22 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList7, i3));
                for (CallParticipant.UserOrStreamParticipant userOrStreamParticipant2 : arrayList7) {
                    Objects.requireNonNull(userOrStreamParticipant2, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.UserOrStreamParticipant");
                    int iOrdinal2 = userOrStreamParticipant2.getParticipantData().type.ordinal();
                    if (iOrdinal2 == 0) {
                        str2 = "USER";
                    } else {
                        if (iOrdinal2 != 1) {
                            throw new NoWhenBranchMatchedException();
                        }
                        str2 = "STREAM";
                    }
                    arrayList22.add(Tuples.to(str2 + '-' + userOrStreamParticipant2.getParticipantData().voiceParticipant.getUser().getId(), userOrStreamParticipant2));
                }
                Map map2 = Maps6.toMap(arrayList22);
                if (i2 >= valid.getChannelMentionsCount() || i < valid.getUnreadsCount()) {
                    viewState4 = null;
                    VideoPlayerIdleDetector.onInteraction$default(this.videoPlayerIdleDetectorHeader, false, 1, null);
                    z3 = false;
                } else {
                    z3 = zIsIdleHeader;
                    viewState4 = null;
                }
                StageCallModel stageCallModel22 = valid.getStageCallModel();
                String str32 = this.focusedVideoParticipantKey;
                Boolean noiseCancellation2 = valid.getNoiseCancellation();
                boolean z7 = !valid.getCallModel().getVoiceSettings().getVoiceParticipantsHidden() && !callModel3.isStreaming() && listComputeVisibleVideoParticipants2.isEmpty() && displayMode2 == DisplayMode.GRID;
                boolean zIsScreenReaderEnabled2 = valid.isScreenReaderEnabled();
                Boolean bool2 = this.startedAsVideo;
                boolean zBooleanValue = bool2 == null ? bool2.booleanValue() : false;
                float fAmplitudeToPerceptual2 = PerceptualVolumeUtils.INSTANCE.amplitudeToPerceptual(valid.getStreamVolume(), 300.0f);
                int iCoerceAtLeast2 = _Ranges.coerceAtLeast(valid.getTotalMentionsCount() - valid.getChannelMentionsCount(), 0);
                StageRoles stageRolesM68getMyStageRolestwRsX032 = valid.m68getMyStageRolestwRsX0();
                viewState5 = getViewState();
                if (!(viewState5 instanceof ViewState.Valid)) {
                    viewState5 = viewState4;
                }
                ViewState.Valid valid82 = (ViewState.Valid) viewState5;
                boolean z8 = valid82 == null && valid82.isUpdatingRequestToSpeak();
                viewState6 = getViewState();
                if (!(viewState6 instanceof ViewState.Valid)) {
                    viewState6 = viewState4;
                }
                ViewState.Valid valid92 = (ViewState.Valid) viewState6;
                boolean z9 = valid92 == null && valid92.isMovingToAudience();
                StageCallModel stageCallModel32 = valid.getStageCallModel();
                int requestingToSpeakCount = stageCallModel32 == null ? stageCallModel32.getRequestingToSpeakCount() : 0;
                boolean stopOffscreenVideo2 = valid.getStopOffscreenVideo();
                Long myPermissions2 = valid.getMyPermissions();
                it = _Collections.sortedWith(valid.getCallModel().getGuildScheduledEvents(), new WidgetCallFullscreenViewModel$handleStoreState$$inlined$sortedBy$1()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = it.next();
                        if (GuildScheduledEventUtilities5.getEventTiming((GuildScheduledEvent) next).isStartable()) {
                            break;
                        }
                    } else {
                        next = viewState4;
                        break;
                    }
                }
                GuildScheduledEvent guildScheduledEvent2 = (GuildScheduledEvent) next;
                it2 = valid.getCallModel().getGuildScheduledEvents().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = it2.next();
                        if (((GuildScheduledEvent) next2).getStatus() == GuildScheduledEventStatus.ACTIVE) {
                            break;
                        }
                    } else {
                        next2 = null;
                        break;
                    }
                }
                updateViewState2((ViewState) new ViewState.Valid(callModel3, stageCallModel22, overlayStatus, listComputeVisibleVideoParticipants2, zIsIdleFooter, z3, zIsControlFadingDisabled, z5, cameraState22, displayMode2, voiceControlsOutputSelectorState22, str32, z2, userOrStreamParticipantComputePipParticipant2, noiseCancellation2, listCreatePrivateCallParticipantListItems2, z7, zIsScreenReaderEnabled2, zBooleanValue, fAmplitudeToPerceptual2, iCoerceAtLeast2, z6, stageRolesM68getMyStageRolestwRsX032, z8, z9, requestingToSpeakCount, stopOffscreenVideo2, myPermissions2, guildScheduledEvent2, (GuildScheduledEvent) next2, valid.getChannelMentionsCount(), valid.getUnreadsCount(), valid.isTextInVoiceEnabled(), valid.isTextInVoiceChannelSelected(), map2, null));
            }
        }
        this.mostRecentStoreState = storeState;
    }

    @Override // b.a.d.AppViewModel
    public /* bridge */ /* synthetic */ ViewState modifyPendingViewState(ViewState viewState, ViewState viewState2) {
        return modifyPendingViewState2(viewState, viewState2);
    }

    @MainThread
    public final void moveMeToAudience() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || valid.isMovingToAudience()) {
            return;
        }
        updateViewState2((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, true, 0, false, null, null, null, 0, 0, false, false, null, -16777217, 7, null));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().setMeSuppressed(valid.getCallModel().getChannel(), true), false, 1, null), this, null, 2, null), WidgetCallFullscreenViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, new AnonymousClass1(), AnonymousClass2.INSTANCE, 30, (Object) null);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onCameraPermissionsGranted() {
        StoreMediaEngine.selectDefaultVideoDevice$default(this.mediaEngineStore, null, 1, null);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.AccessibilityAnnouncement(R.string.camera_a11y_turned_on));
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
    @MainThread
    public void onCleared() {
        super.onCleared();
        this.videoPlayerIdleDetectorFooter.dispose();
        this.videoPlayerIdleDetectorHeader.dispose();
    }

    @MainThread
    public final void onDeafenPressed() {
        CallModel callModel;
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null && (callModel = valid.getCallModel()) != null && callModel.isServerDeafened()) {
            emitServerDeafenedDialogEvent();
            return;
        }
        this.mediaSettingsStore.toggleSelfDeafened();
        ViewState viewState = getViewState();
        ViewState.Valid valid2 = (ViewState.Valid) (viewState instanceof ViewState.Valid ? viewState : null);
        if (valid2 != null) {
            this.eventSubject.k.onNext(new Event.AccessibilityAnnouncement(valid2.getIsDeafened() ? R.string.voice_channel_undeafened : R.string.voice_channel_deafened));
        }
    }

    @MainThread
    public final void onEmptyStateTapped() {
        startTapForwardingJob();
    }

    @MainThread
    public final void onGridParticipantLongPressed(CallParticipant participant) {
        Intrinsics3.checkNotNullParameter(participant, "participant");
        if (participant instanceof CallParticipant.UserOrStreamParticipant) {
            CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) participant;
            if (userOrStreamParticipant.getParticipantData().type == VideoCallParticipantView.ParticipantData.Type.DEFAULT) {
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(new Event.ShowUserSheet(userOrStreamParticipant.getParticipantData().voiceParticipant.getUser().getId(), this.channelId));
            }
        }
    }

    @MainThread
    public final void onGridParticipantTapped(CallParticipant callParticipant) {
        Intrinsics3.checkNotNullParameter(callParticipant, "callParticipant");
        if (callParticipant instanceof CallParticipant.EmbeddedActivityParticipant) {
            this.eventSubject.k.onNext(Event.ShowActivitiesDesktopOnlyDialog.INSTANCE);
        }
        String participantFocusKey = getParticipantFocusKey(callParticipant);
        ParticipantTap participantTap = new ParticipantTap(participantFocusKey, this.clock.currentTimeMillis());
        ParticipantTap participantTap2 = this.lastParticipantTap;
        this.lastParticipantTap = participantTap;
        if (participantTap2 == null || (!Intrinsics3.areEqual(participantTap2.getParticipantFocusKey(), participantFocusKey))) {
            startTapForwardingJob();
            return;
        }
        if (!(participantTap.getTimestamp() - participantTap2.getTimestamp() <= 255) || !(callParticipant instanceof CallParticipant.UserOrStreamParticipant)) {
            startTapForwardingJob();
            return;
        }
        if (!Intrinsics3.areEqual(this.focusedVideoParticipantKey, participantFocusKey)) {
            focusVideoParticipant(participantFocusKey);
        } else {
            clearFocusedVideoParticipant();
        }
        cancelTapForwardingJob();
        this.lastParticipantTap = null;
    }

    @MainThread
    public final void onMuteClicked() {
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            CallModel callModel = valid.getCallModel();
            if (callModel.isSuppressed()) {
                emitSuppressedDialogEvent();
                return;
            } else if (callModel.isMuted()) {
                emitServerMutedDialogEvent();
                return;
            }
        }
        StoreMediaSettings.SelfMuteFailure selfMuteFailure = this.mediaSettingsStore.toggleSelfMuted();
        if (selfMuteFailure != null) {
            if (selfMuteFailure.ordinal() != 0) {
                return;
            }
            emitShowNoVadPermissionDialogEvent();
        } else if (valid != null) {
            boolean zIsMeMutedByAnySource = valid.getCallModel().isMeMutedByAnySource();
            this.eventSubject.k.onNext(new Event.AccessibilityAnnouncement(zIsMeMutedByAnySource ? R.string.voice_channel_unmuted : R.string.voice_channel_muted));
        }
    }

    @MainThread
    public final void onPushToTalkPressed(boolean isPressed) {
        if (isPressed) {
            this.videoPlayerIdleDetectorFooter.endIdleDetection();
            this.videoPlayerIdleDetectorHeader.endIdleDetection();
        } else {
            startIdle();
        }
        this.mediaEngineStore.setPttActive(isPressed);
    }

    @MainThread
    public final void onScreenShareClick() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            if (valid.getCallModel().isStreaming()) {
                stopScreenShare();
            } else {
                if (!hasVideoPermission()) {
                    emitShowNoScreenSharePermissionDialogEvent();
                    return;
                }
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(Event.RequestStartStream.INSTANCE);
            }
        }
    }

    @MainThread
    public final void onShowParticipantsPressed() {
        this.mediaSettingsStore.updateVoiceParticipantsHidden(false);
    }

    public final void onStreamPerceptualVolumeChanged(float perceptualVolume, boolean fromUser) {
        if (fromUser) {
            this.streamRtcConnectionStore.updateStreamVolume(PerceptualVolumeUtils.INSTANCE.perceptualToAmplitude(perceptualVolume, 300.0f));
            this.audioManagerStore.updateMediaVolume(perceptualVolume / 300.0f);
        }
    }

    @MainThread
    public final void onStreamQualityIndicatorClicked(VideoCallParticipantView.StreamResolution resolution, VideoCallParticipantView.StreamFps fps) {
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        if (resolution.b() || (fps != null && fps.a())) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(Event.NavigateToPremiumSettings.INSTANCE);
        }
    }

    @MainThread
    public final void onStreamQualityIndicatorShown(VideoCallParticipantView.StreamResolution resolution, VideoCallParticipantView.StreamFps fps) {
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        boolean zB = resolution.b();
        Boolean boolValueOf = fps != null ? Boolean.valueOf(fps.a()) : null;
        if (this.logStreamQualityIndicatorViewed) {
            if (zB || Intrinsics3.areEqual(boolValueOf, Boolean.TRUE)) {
                this.logStreamQualityIndicatorViewed = false;
                this.storeAnalytics.streamQualityIndicatorViewed(zB, boolValueOf);
            }
        }
    }

    @MainThread
    public final void onTextInVoiceTapped() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), valid.getCallModel().getChannel(), null, StoreChannelsSelected3.TEXT_IN_VOICE, 2, null);
            StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, StoreNavigation.PanelAction.CLOSE, null, 2, null);
        }
    }

    public final void onVisitCommunityButtonClicked(long guildId) {
        this.guildSelectedStore.set(guildId);
        StoreTabsNavigation.selectHomeTab$default(this.tabsNavigationStore, StoreNavigation.PanelAction.CLOSE, false, 2, null);
    }

    public final void requestStopWatchingStreamFromUserInput() {
        StoreApplicationStreaming.ActiveApplicationStream activeStream;
        ModelApplicationStream stream;
        stopWatchingStream();
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Valid)) {
            viewStateRequireViewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewStateRequireViewState;
        if (valid == null || (activeStream = valid.getCallModel().getActiveStream()) == null || (stream = activeStream.getStream()) == null) {
            return;
        }
        CallModel callModel = valid.getCallModel();
        String encodedStreamKey = stream.getEncodedStreamKey();
        RtcConnection.Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
        enqueueStreamFeedbackSheet(encodedStreamKey, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getStreamFeedbackTriggerRateDenominator());
    }

    public final void selectTextChannelAfterFinish() {
        Guild guild;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || !valid.isTextInVoiceEnabled() || !valid.isTextInVoiceChannelSelected() || (guild = valid.getCallModel().getGuild()) == null) {
            return;
        }
        ChannelSelector.INSTANCE.getInstance().selectPreviousChannel(guild.getId());
    }

    public final void setShowStageCallBottomSheet(boolean z2) {
        this.showStageCallBottomSheet = z2;
    }

    public final void setTargetChannelId(long channelId) {
        Subscription subscription = this.storeObservableSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.channelId = channelId;
        Observable<StoreState> observableR = observeStoreState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetCallFullscreenViewModel.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
    }

    @MainThread
    public final void startIdle() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || valid.isControlFadingDisabled() || valid.getDisplayMode() != DisplayMode.GRID) {
            return;
        }
        Integer num = this.bottomSheetState;
        if (num != null && num.intValue() == 3) {
            return;
        }
        this.videoPlayerIdleDetectorFooter.beginIdleDetection();
        this.videoPlayerIdleDetectorHeader.beginIdleDetection();
    }

    @MainThread
    public final void startScreenShare(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        this.voiceEngineServiceController.startStream(intent);
    }

    @MainThread
    public final void stopIdle() {
        this.videoPlayerIdleDetectorFooter.endIdleDetection();
        this.videoPlayerIdleDetectorHeader.endIdleDetection();
    }

    @MainThread
    public final void stopScreenShare() {
        StoreApplicationStreaming.ActiveApplicationStream activeStream;
        ModelApplicationStream stream;
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        this.voiceEngineServiceController.stopStream();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || (activeStream = valid.getCallModel().getActiveStream()) == null || (stream = activeStream.getStream()) == null) {
            return;
        }
        CallModel callModel = valid.getCallModel();
        String encodedStreamKey = stream.getEncodedStreamKey();
        RtcConnection.Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
        enqueueStreamFeedbackSheet(encodedStreamKey, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getStreamFeedbackTriggerRateDenominator());
    }

    @MainThread
    public final void switchCameraInputPressed() {
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || valid.getCameraState() == CameraState.CAMERA_DISABLED) {
            return;
        }
        if (valid.getCameraState() == CameraState.CAMERA_ON) {
            this.mediaEngineStore.cycleVideoInputDevice();
        }
    }

    @MainThread
    public final void targetAndFocusStream(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        targetStream(streamKey);
        focusVideoParticipant(ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey).getOwnerId() + "--STREAM");
    }

    @MainThread
    public final void targetStream(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        StoreApplicationStreaming.targetStream$default(this.applicationStreamingStore, streamKey, false, 2, null);
    }

    @MainThread
    public final void toggleCameraPressed() {
        this.videoPlayerIdleDetectorFooter.onPreventIdle();
        this.videoPlayerIdleDetectorHeader.onPreventIdle();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || valid.getCameraState() == CameraState.CAMERA_DISABLED) {
            return;
        }
        if (!hasVideoPermission()) {
            emitShowNoVideoPermissionDialogEvent();
            return;
        }
        if (valid.getCameraState() == CameraState.CAMERA_ON) {
            this.mediaEngineStore.selectVideoInputDevice(null);
            this.eventSubject.k.onNext(new Event.AccessibilityAnnouncement(R.string.camera_a11y_turned_off));
            return;
        }
        int numUsersConnected = valid.getCallModel().getNumUsersConnected();
        GuildMaxVideoChannelUsers guildMaxVideoChannelMembers = valid.getCallModel().getGuildMaxVideoChannelMembers();
        if (guildMaxVideoChannelMembers instanceof GuildMaxVideoChannelUsers.Limited) {
            GuildMaxVideoChannelUsers.Limited limited = (GuildMaxVideoChannelUsers.Limited) guildMaxVideoChannelMembers;
            if (numUsersConnected > limited.getLimit()) {
                this.eventSubject.k.onNext(new Event.ShowCameraCapacityDialog(limited.getLimit()));
                return;
            }
        }
        this.eventSubject.k.onNext(Event.ShowRequestCameraPermissionsDialog.INSTANCE);
    }

    @MainThread
    public final void toggleRequestToSpeak() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid == null || valid.isUpdatingRequestToSpeak()) {
            return;
        }
        updateViewState2((ViewState) ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, null, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, true, false, 0, false, null, null, null, 0, 0, false, false, null, -8388609, 7, null));
        Channel channel = valid.getCallModel().getChannel();
        boolean z2 = !valid.getCallModel().isMyHandRaised();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(!z2 ? RestAPI.INSTANCE.getApiSerializeNulls().setMeSuppressed(channel, true) : RestAPI.requestToSpeak$default(RestAPI.INSTANCE.getApi(), channel, null, 2, null), false, 1, null), this, null, 2, null), WidgetCallFullscreenViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, new AnonymousClass1(), new AnonymousClass2(z2, channel), 30, (Object) null);
    }

    @MainThread
    public final void tryConnectToVoice() {
        this.selectedVoiceChannelStore.selectVoiceChannel(this.channelId);
    }

    public final void updateOffScreenParticipantsFromScroll(List<VideoCallParticipantView.ParticipantData> visibleVideoParticipants) {
        Intrinsics3.checkNotNullParameter(visibleVideoParticipants, "visibleVideoParticipants");
        this.offScreenSubject.k.onNext(visibleVideoParticipants);
    }

    @Override // b.a.d.AppViewModel
    public /* bridge */ /* synthetic */ void updateViewState(ViewState viewState) {
        updateViewState2(viewState);
    }

    /* renamed from: modifyPendingViewState, reason: avoid collision after fix types in other method */
    public ViewState modifyPendingViewState2(ViewState previousViewState, ViewState pendingViewState) {
        Intrinsics3.checkNotNullParameter(pendingViewState, "pendingViewState");
        if (!(previousViewState instanceof ViewState.Valid) || !(pendingViewState instanceof ViewState.Valid)) {
            return pendingViewState;
        }
        ViewState.Valid valid = (ViewState.Valid) pendingViewState;
        boolean zIsIdleFooter = valid.isIdleFooter();
        List<CallParticipant> visibleVideoParticipants = valid.getVisibleVideoParticipants();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(visibleVideoParticipants, 10));
        for (Object objCopy : visibleVideoParticipants) {
            boolean z2 = (zIsIdleFooter || valid.getVisibleVideoParticipants().size() == 1) ? false : true;
            boolean z3 = this.focusedVideoParticipantKey != null;
            if (objCopy instanceof CallParticipant.UserOrStreamParticipant) {
                CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) objCopy;
                if (userOrStreamParticipant.getParticipantData().showLabel != z2 || userOrStreamParticipant.getParticipantData().isFocused != z3) {
                    objCopy = userOrStreamParticipant.copy(VideoCallParticipantView.ParticipantData.a(userOrStreamParticipant.getParticipantData(), null, false, null, null, null, null, z2, z3, null, 319));
                }
            }
            arrayList.add(objCopy);
        }
        return ViewState.Valid.m69copyJ3xfKWQ$default(valid, null, null, null, arrayList, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -9, 7, null);
    }

    /* renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(ViewState viewState) {
        Object next;
        StoreVoiceParticipants.VoiceUser voiceUser;
        User user;
        CallModel callModel;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof ViewState.Valid)) {
            viewState2 = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState2;
        String analyticsVideoLayout = valid != null ? valid.getAnalyticsVideoLayout() : null;
        DisplayMode displayMode = valid != null ? valid.getDisplayMode() : null;
        super.updateViewState((WidgetCallFullscreenViewModel) viewState);
        if (!(viewState instanceof ViewState.Valid)) {
            this.streamRtcConnectionStore.updateFocusedParticipant(null);
            RtcConnection rtcConnection = StoreStream.INSTANCE.getRtcConnection().getRtcConnection();
            if (rtcConnection != null) {
                rtcConnection.w(null);
                return;
            }
            return;
        }
        ViewState.Valid valid2 = (ViewState.Valid) viewState;
        String analyticsVideoLayout2 = valid2.getAnalyticsVideoLayout();
        if (analyticsVideoLayout2 != null && (!Intrinsics3.areEqual(analyticsVideoLayout2, analyticsVideoLayout))) {
            long myId = valid2.getCallModel().getMyId();
            ViewState viewState3 = getViewState();
            if (!(viewState3 instanceof ViewState.Valid)) {
                viewState3 = null;
            }
            ViewState.Valid valid3 = (ViewState.Valid) viewState3;
            this.analyticsStore.trackVideoLayoutToggled(analyticsVideoLayout2, myId, (valid3 == null || (callModel = valid3.getCallModel()) == null) ? null : callModel.getChannel());
        }
        DisplayMode displayMode2 = valid2.getDisplayMode();
        if (displayMode2 != displayMode) {
            int iOrdinal = displayMode2.ordinal();
            if (iOrdinal == 0) {
                startIdle();
            } else if (iOrdinal == 2) {
                this.videoPlayerIdleDetectorHeader.endIdleDetection();
                this.videoPlayerIdleDetectorFooter.endIdleDetection();
            }
        }
        String focusedParticipantKey = valid2.getFocusedParticipantKey();
        Iterator<T> it = valid2.getVisibleVideoParticipants().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics3.areEqual(getParticipantFocusKey((CallParticipant) next), focusedParticipantKey)) {
                    break;
                }
            }
        }
        CallParticipant callParticipant = (CallParticipant) next;
        if (callParticipant != null ? callParticipant instanceof CallParticipant.UserOrStreamParticipant : true) {
            CallParticipant.UserOrStreamParticipant userOrStreamParticipant = (CallParticipant.UserOrStreamParticipant) callParticipant;
            VideoCallParticipantView.ParticipantData participantData = userOrStreamParticipant != null ? userOrStreamParticipant.getParticipantData() : null;
            Long lValueOf = (participantData == null || (voiceUser = participantData.voiceParticipant) == null || (user = voiceUser.getUser()) == null) ? null : Long.valueOf(user.getId());
            VideoCallParticipantView.ParticipantData.Type type = participantData != null ? participantData.type : null;
            if (type == null) {
                this.streamRtcConnectionStore.updateFocusedParticipant(null);
                RtcConnection rtcConnection2 = StoreStream.INSTANCE.getRtcConnection().getRtcConnection();
                if (rtcConnection2 != null) {
                    rtcConnection2.w(null);
                    return;
                }
                return;
            }
            int iOrdinal2 = type.ordinal();
            if (iOrdinal2 != 0) {
                if (iOrdinal2 != 1) {
                    return;
                }
                this.streamRtcConnectionStore.updateFocusedParticipant(lValueOf);
                RtcConnection rtcConnection3 = StoreStream.INSTANCE.getRtcConnection().getRtcConnection();
                if (rtcConnection3 != null) {
                    rtcConnection3.w(null);
                    return;
                }
                return;
            }
            this.streamRtcConnectionStore.updateFocusedParticipant(null);
            RtcConnection rtcConnection4 = StoreStream.INSTANCE.getRtcConnection().getRtcConnection();
            if (rtcConnection4 != null) {
                rtcConnection4.w(lValueOf);
            }
            if (lValueOf != null) {
                this.mediaSettingsStore.setUserOffScreen(lValueOf.longValue(), false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel(long j, StoreChannels storeChannels, StoreNavigation storeNavigation, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildSelected storeGuildSelected, StoreTabsNavigation storeTabsNavigation, StoreUserSettings storeUserSettings, StoreApplicationStreaming storeApplicationStreaming, StoreMediaEngine storeMediaEngine, StoreMediaSettings storeMediaSettings, StorePermissions storePermissions, Clock clock, Scheduler scheduler, VideoPermissionsManager videoPermissionsManager, VoiceEngineServiceController voiceEngineServiceController, StoreStreamRtcConnection storeStreamRtcConnection, StoreAccessibility storeAccessibility, StoreAudioManagerV2 storeAudioManagerV2, StoreMentions storeMentions, StoreAnalytics storeAnalytics, StoreConnectivity storeConnectivity, StoreStageChannels storeStageChannels, StoreAnalytics storeAnalytics2, StoreExperiments storeExperiments, StoreChannelsSelected storeChannelsSelected, StoreApplication storeApplication, StoreApplicationAssets storeApplicationAssets, String str) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeNavigation, "storeNavigation");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        Intrinsics3.checkNotNullParameter(storeGuildSelected, "guildSelectedStore");
        Intrinsics3.checkNotNullParameter(storeTabsNavigation, "tabsNavigationStore");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        Intrinsics3.checkNotNullParameter(storeApplicationStreaming, "applicationStreamingStore");
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(scheduler, "backgroundThreadScheduler");
        Intrinsics3.checkNotNullParameter(videoPermissionsManager, "videoPermissionsManager");
        Intrinsics3.checkNotNullParameter(voiceEngineServiceController, "voiceEngineServiceController");
        Intrinsics3.checkNotNullParameter(storeStreamRtcConnection, "streamRtcConnectionStore");
        Intrinsics3.checkNotNullParameter(storeAccessibility, "accessibilityStore");
        Intrinsics3.checkNotNullParameter(storeAudioManagerV2, "audioManagerStore");
        Intrinsics3.checkNotNullParameter(storeMentions, "mentionsStore");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analyticsStore");
        Intrinsics3.checkNotNullParameter(storeConnectivity, "connectivityStore");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "stageStore");
        Intrinsics3.checkNotNullParameter(storeAnalytics2, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "channelsSelectedStore");
        Intrinsics3.checkNotNullParameter(storeApplication, "applicationStore");
        Intrinsics3.checkNotNullParameter(storeApplicationAssets, "applicationAssetsStore");
        this.channelId = j;
        this.storeChannels = storeChannels;
        this.storeNavigation = storeNavigation;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.guildSelectedStore = storeGuildSelected;
        this.tabsNavigationStore = storeTabsNavigation;
        this.userSettingsStore = storeUserSettings;
        this.applicationStreamingStore = storeApplicationStreaming;
        this.mediaEngineStore = storeMediaEngine;
        this.mediaSettingsStore = storeMediaSettings;
        this.permissionsStore = storePermissions;
        this.clock = clock;
        this.backgroundThreadScheduler = scheduler;
        this.videoPermissionsManager = videoPermissionsManager;
        this.voiceEngineServiceController = voiceEngineServiceController;
        this.streamRtcConnectionStore = storeStreamRtcConnection;
        this.accessibilityStore = storeAccessibility;
        this.audioManagerStore = storeAudioManagerV2;
        this.mentionsStore = storeMentions;
        this.analyticsStore = storeAnalytics;
        this.connectivityStore = storeConnectivity;
        this.stageStore = storeStageChannels;
        this.storeAnalytics = storeAnalytics2;
        this.experimentsStore = storeExperiments;
        this.channelsSelectedStore = storeChannelsSelected;
        this.applicationStore = storeApplication;
        this.applicationAssetsStore = storeApplicationAssets;
        this.showStageCallBottomSheet = j != StoreStream.INSTANCE.getVoiceChannelSelected().getSelectedVoiceChannelId();
        this.logStreamQualityIndicatorViewed = true;
        this.eventSubject = PublishSubject.k0();
        PublishSubject<List<VideoCallParticipantView.ParticipantData>> publishSubjectK0 = PublishSubject.k0();
        this.offScreenSubject = publishSubjectK0;
        this.videoPlayerIdleDetectorFooter = new VideoPlayerIdleDetector(0L, null, null, new WidgetCallFullscreenViewModel5(this), 7, null);
        this.videoPlayerIdleDetectorHeader = new VideoPlayerIdleDetector(0L, null, null, new WidgetCallFullscreenViewModel6(this), 7, null);
        this.allVideoParticipants = Collections2.emptyList();
        if (str != null) {
            this.autotargetStreamKey = str;
            storeVoiceChannelSelected.selectVoiceChannel(ModelApplicationStream.INSTANCE.decodeStreamKey(str).getChannelId());
        }
        Observable<List<VideoCallParticipantView.ParticipantData>> observableP = publishSubjectK0.p(1000L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "offScreenSubject\n       …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableP, WidgetCallFullscreenViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
