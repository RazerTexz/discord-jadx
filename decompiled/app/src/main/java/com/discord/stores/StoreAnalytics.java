package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import co.discord.media_engine.DeviceDescription4;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.Message;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreGifting;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.analytics.AppStartAnalyticsTracker;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelNotificationSettingsUtils;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.intent.RouteHandlers;
import com.discord.utilities.rest.SendUtils2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.auth.WidgetAuthLanding;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.guilds.invite.GuildInvite;
import com.discord.widgets.guilds.invite.WidgetGuildInvite;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.Tuples;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: StoreAnalytics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ø\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0096\u0002B'\u0012\b\u0010ü\u0001\u001a\u00030û\u0001\u0012\b\u0010\u0083\u0002\u001a\u00030\u0082\u0002\u0012\b\u0010\u0080\u0002\u001a\u00030ÿ\u0001¢\u0006\u0006\b\u0094\u0002\u0010\u0095\u0002J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00122\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00122\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00122\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u001cJ%\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\n\u0010 \u001a\u00060\u000fj\u0002`\u001fH\u0002¢\u0006\u0004\b!\u0010\u0016J#\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b!\u0010$J'\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140%2\n\u0010 \u001a\u00060\u000fj\u0002`\u001fH\u0003¢\u0006\u0004\b&\u0010\u0016Ja\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140%2\n\u0010 \u001a\u00060\u000fj\u0002`\u001f2\u0006\u0010(\u001a\u00020'2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001a0)2\u0006\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020'2\n\u0010.\u001a\u00060\u000fj\u0002`-2\u0006\u0010/\u001a\u00020\u0004H\u0002¢\u0006\u0004\b0\u00101J\u001b\u00104\u001a\u0004\u0018\u00010\u00132\b\u00103\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\b4\u00105J5\u0010;\u001a\u00020\u00062\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u0002082\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u0019\u0010B\u001a\u00020\u00062\b\u0010A\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\bB\u0010CJ\u0019\u0010E\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\bE\u0010CJ\u000f\u0010F\u001a\u00020\u0006H\u0007¢\u0006\u0004\bF\u0010\u000eJ\u0017\u0010H\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u0004H\u0007¢\u0006\u0004\bH\u0010IJ\u0017\u0010L\u001a\u00020\u00062\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0004\bL\u0010MJ\u0019\u0010O\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\bQ\u0010IJ+\u0010U\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u00132\n\u0010T\u001a\u00060\u000fj\u0002`S2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\bU\u0010VJ\u001d\u0010Y\u001a\u00020\u00062\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000f0WH\u0007¢\u0006\u0004\bY\u0010ZJ\u001d\u0010^\u001a\u00020\u00062\u000e\u0010]\u001a\n\u0012\u0006\b\u0001\u0012\u00020\\0[¢\u0006\u0004\b^\u0010_J\u0019\u0010`\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010¢\u0006\u0004\b`\u0010aJ\u001d\u0010f\u001a\u00020\u00062\u0006\u0010c\u001a\u00020b2\u0006\u0010e\u001a\u00020d¢\u0006\u0004\bf\u0010gJ'\u0010m\u001a\u00020\u00062\b\u0010i\u001a\u0004\u0018\u00010h2\u0006\u0010k\u001a\u00020j2\u0006\u0010l\u001a\u00020\u0013¢\u0006\u0004\bm\u0010nJ1\u0010m\u001a\u00020\u00062\b\u0010i\u001a\u0004\u0018\u00010o2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010k\u001a\u00020j2\u0006\u0010l\u001a\u00020\u0013¢\u0006\u0004\bm\u0010pJ\u0015\u0010r\u001a\u00020\u00062\u0006\u0010q\u001a\u00020\u0004¢\u0006\u0004\br\u0010IJ!\u0010t\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\u00132\n\u0010 \u001a\u00060\u000fj\u0002`\u001f¢\u0006\u0004\bt\u0010uJ!\u0010w\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\u00132\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bw\u0010xJ%\u0010{\u001a\u00020\u00062\u0006\u0010z\u001a\u00020y2\u000e\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010¢\u0006\u0004\b{\u0010|J8\u0010\u0080\u0001\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\n\u0010}\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010~\u001a\u00020'2\u0006\u0010\u007f\u001a\u00020'¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J)\u0010\u0083\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020\u00132\u0006\u0010l\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001d\u0010\u0085\u0001\u001a\u00020\u00062\n\u0010 \u001a\u00060\u000fj\u0002`\u001fH\u0007¢\u0006\u0005\b\u0085\u0001\u0010aJ4\u0010\u008a\u0001\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\b\u0010\u0087\u0001\u001a\u00030\u0086\u00012\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0007¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J*\u0010\u008c\u0001\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0007¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001b\u0010\u008e\u0001\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010¢\u0006\u0005\b\u008e\u0001\u0010aJ\u001a\u0010\u0091\u0001\u001a\u00020\u00062\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001a\u0010\u0095\u0001\u001a\u00020\u00062\b\u0010\u0094\u0001\u001a\u00030\u0093\u0001¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J$\u0010\u0097\u0001\u001a\u00020\u00062\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140%¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J$\u0010\u0099\u0001\u001a\u00020\u00062\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140%¢\u0006\u0006\b\u0099\u0001\u0010\u0098\u0001J&\u0010\u009a\u0001\u001a\u00020\u00062\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140%H\u0007¢\u0006\u0006\b\u009a\u0001\u0010\u0098\u0001J$\u0010\u009b\u0001\u001a\u00020\u00062\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140%¢\u0006\u0006\b\u009b\u0001\u0010\u0098\u0001J&\u0010\u009c\u0001\u001a\u00020\u00062\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140%H\u0007¢\u0006\u0006\b\u009c\u0001\u0010\u0098\u0001J\u001b\u0010\u009d\u0001\u001a\u00020\u00062\n\u0010 \u001a\u00060\u000fj\u0002`\u001f¢\u0006\u0005\b\u009d\u0001\u0010aJ3\u0010£\u0001\u001a\u00020\u00062\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012\f\b\u0002\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00012\t\b\u0002\u0010¢\u0001\u001a\u00020\u0004¢\u0006\u0006\b£\u0001\u0010¤\u0001J3\u0010¥\u0001\u001a\u00020\u00062\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012\f\b\u0002\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00012\t\b\u0002\u0010¢\u0001\u001a\u00020\u0004¢\u0006\u0006\b¥\u0001\u0010¤\u0001JI\u0010¨\u0001\u001a\u00020\u00062\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0007\u0010¦\u0001\u001a\u00020'2\u000b\b\u0002\u0010§\u0001\u001a\u0004\u0018\u00010'2\f\b\u0002\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00012\t\b\u0002\u0010¢\u0001\u001a\u00020\u0004¢\u0006\u0006\b¨\u0001\u0010©\u0001J?\u0010¬\u0001\u001a\u00020\u00062\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0007\u0010¦\u0001\u001a\u00020'2\f\b\u0002\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00012\f\b\u0002\u0010«\u0001\u001a\u0005\u0018\u00010ª\u0001¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\u0017\u0010®\u0001\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0013¢\u0006\u0005\b®\u0001\u0010CJP\u0010·\u0001\u001a\u00020\u00062\b\u0010°\u0001\u001a\u00030¯\u00012\u0007\u0010±\u0001\u001a\u00020'2\u0007\u0010²\u0001\u001a\u00020'2\u0007\u0010³\u0001\u001a\u00020'2\u0007\u0010´\u0001\u001a\u00020\u00042\u0007\u0010µ\u0001\u001a\u00020\u00042\u0007\u0010¶\u0001\u001a\u00020\u0004¢\u0006\u0006\b·\u0001\u0010¸\u0001Jj\u0010¾\u0001\u001a\u00020\u00062\u0007\u0010±\u0001\u001a\u00020'2\u0007\u0010²\u0001\u001a\u00020'2\u0007\u0010³\u0001\u001a\u00020'2\u0007\u0010´\u0001\u001a\u00020\u00042\u0007\u0010µ\u0001\u001a\u00020\u00042\b\u0010º\u0001\u001a\u00030¹\u00012\f\u0010¼\u0001\u001a\u00070\u000fj\u0003`»\u00012\u0007\u0010½\u0001\u001a\u00020'2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010¢\u0006\u0006\b¾\u0001\u0010¿\u0001J\u001b\u0010À\u0001\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010¢\u0006\u0005\bÀ\u0001\u0010aJ.\u0010Ã\u0001\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0007\u0010Á\u0001\u001a\u00020\u000f2\u0007\u0010Â\u0001\u001a\u00020\u000f¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J\u000f\u0010Å\u0001\u001a\u00020\u0006¢\u0006\u0005\bÅ\u0001\u0010\u000eJ\u0018\u0010Ç\u0001\u001a\u00020\u00062\u0007\u0010Æ\u0001\u001a\u00020\u000f¢\u0006\u0005\bÇ\u0001\u0010aJ4\u0010Ê\u0001\u001a\u00020\u00062\u0007\u0010Á\u0001\u001a\u00020\u000f2\u0007\u0010Â\u0001\u001a\u00020\u000f2\u0007\u0010È\u0001\u001a\u00020\u00132\u0007\u0010É\u0001\u001a\u00020\u0004¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J=\u0010Ð\u0001\u001a\u00020\u00062\n\u0010 \u001a\u00060\u000fj\u0002`\u001f2\u000e\u0010Í\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0Ì\u00012\u000f\u0010Ï\u0001\u001a\n\u0012\u0005\u0012\u00030Î\u00010Ì\u0001¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J%\u0010Ó\u0001\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0007\u0010Ò\u0001\u001a\u00020\u0013¢\u0006\u0006\bÓ\u0001\u0010Ô\u0001J\u000f\u0010Õ\u0001\u001a\u00020\u0006¢\u0006\u0005\bÕ\u0001\u0010\u000eJ\u0018\u0010Ö\u0001\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0006\bÖ\u0001\u0010×\u0001JA\u0010Ü\u0001\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010Ù\u0001\u001a\u00070\u000fj\u0003`Ø\u00012\u0007\u0010¶\u0001\u001a\u00020\u00042\u0007\u0010Ú\u0001\u001a\u00020\u00042\u0007\u0010Û\u0001\u001a\u00020\u0004¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J\u0018\u0010Þ\u0001\u001a\u00020\u00062\u0006\u00109\u001a\u000208¢\u0006\u0006\bÞ\u0001\u0010ß\u0001J!\u0010á\u0001\u001a\u00020\u00062\u0006\u00109\u001a\u0002082\u0007\u0010à\u0001\u001a\u00020\u0004¢\u0006\u0006\bá\u0001\u0010â\u0001J$\u0010å\u0001\u001a\u00020\u00062\u0007\u0010ã\u0001\u001a\u00020\u00042\t\u0010ä\u0001\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\bå\u0001\u0010æ\u0001J\u000f\u0010ç\u0001\u001a\u00020\u0006¢\u0006\u0005\bç\u0001\u0010\u000eJ\u000f\u0010è\u0001\u001a\u00020\u0006¢\u0006\u0005\bè\u0001\u0010\u000eJ7\u0010ì\u0001\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0007\u0010é\u0001\u001a\u00020\u00132\u0007\u0010ê\u0001\u001a\u00020'2\u0007\u0010ë\u0001\u001a\u00020'¢\u0006\u0006\bì\u0001\u0010í\u0001J_\u0010ò\u0001\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0007\u0010é\u0001\u001a\u00020\u00132\u0007\u0010ê\u0001\u001a\u00020'2\u0007\u0010ë\u0001\u001a\u00020'2\t\u0010î\u0001\u001a\u0004\u0018\u00010\u00132\t\u0010ï\u0001\u001a\u0004\u0018\u00010\u00132\u0010\u0010ñ\u0001\u001a\u000b\u0018\u00010\u000fj\u0005\u0018\u0001`ð\u0001¢\u0006\u0006\bò\u0001\u0010ó\u0001J0\u0010÷\u0001\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\b\u0010õ\u0001\u001a\u00030ô\u00012\b\u0010ö\u0001\u001a\u00030ô\u0001¢\u0006\u0006\b÷\u0001\u0010ø\u0001R\u001b\u0010ù\u0001\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R\u001a\u0010ü\u0001\u001a\u00030û\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bü\u0001\u0010ý\u0001R\u0019\u0010D\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bD\u0010þ\u0001R\u001a\u0010\u0080\u0002\u001a\u00030ÿ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0002\u0010\u0081\u0002R\u001a\u0010\u0083\u0002\u001a\u00030\u0082\u00028\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R'\u0010\u0087\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00128B@\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002R\u0019\u0010A\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bA\u0010þ\u0001RB\u0010\u008a\u0002\u001a+\u0012\r\u0012\u000b \u0089\u0002*\u0004\u0018\u00010\t0\t \u0089\u0002*\u0014\u0012\r\u0012\u000b \u0089\u0002*\u0004\u0018\u00010\t0\t\u0018\u00010\u0088\u00020\u0088\u00028\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0002\u0010\u008b\u0002R\u001b\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010þ\u0001R\u001b\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0002\u0010þ\u0001R\u001a\u0010\u008f\u0002\u001a\u00030\u008e\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u0090\u0002R\u0017\u0010\u0093\u0002\u001a\u00030 \u00018F@\u0006¢\u0006\b\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002¨\u0006\u0097\u0002"}, d2 = {"Lcom/discord/stores/StoreAnalytics;", "Lcom/discord/stores/Store;", "Lco/discord/media_engine/VideoInputDeviceDescription;", "selectedVideoInputDevice", "", "isScreenSharing", "", "handleVideoInputUpdate", "(Lco/discord/media_engine/VideoInputDeviceDescription;Z)V", "Lcom/discord/stores/StoreAnalytics$ScreenViewed;", "screenViewed", "onScreenViewed", "(Lcom/discord/stores/StoreAnalytics$ScreenViewed;)V", "updateTrackingData", "()V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "", "", "getGuildAndChannelSnapshotAnalyticsProperties", "(J)Ljava/util/Map;", "includeNsfw", "getChannelSnapshotAnalyticsProperties", "(JZ)Ljava/util/Map;", "Lcom/discord/api/channel/Channel;", "channel", "(Lcom/discord/api/channel/Channel;Z)Ljava/util/Map;", "getThreadSnapshotAnalyticsProperties", "(Lcom/discord/api/channel/Channel;)Ljava/util/Map;", "Lcom/discord/primitives/GuildId;", "guildId", "getGuildSnapshotAnalyticsProperties", "Lcom/discord/models/guild/Guild;", "guild", "(Lcom/discord/models/guild/Guild;)Ljava/util/Map;", "", "getGuildAnalyticsPropertiesInternal", "", "guildSize", "", "guildChannels", "numGuildRoles", "guildMemberNumRoles", "Lcom/discord/api/permission/PermissionBit;", "guildPermissions", "isVip", "guildPropertiesMap", "(JILjava/util/Collection;IIJZ)Ljava/util/Map;", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "issue", "getStreamFeedbackReasonFromIssue", "(Lcom/discord/widgets/voice/feedback/FeedbackIssue;)Ljava/lang/String;", "Lcom/discord/utilities/analytics/AnalyticsTracker$PremiumUpsellType;", "type", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;", "emojiPickerContextType", "properties", "emojiPickerUpsellViewed", "(Lcom/discord/utilities/analytics/AnalyticsTracker$PremiumUpsellType;Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;Ljava/util/Map;)V", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "authToken", "handleAuthToken", "(Ljava/lang/String;)V", "fingerprint", "handleFingerprint", "handlePreLogout", "connected", "handleConnected", "(Z)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "videoInputDevice", "handleVideoInputDeviceSelected", "(Lco/discord/media_engine/VideoInputDeviceDescription;)V", "handleIsScreenSharingChanged", "videoLayout", "Lcom/discord/primitives/UserId;", "meId", "trackVideoLayoutToggled", "(Ljava/lang/String;JLcom/discord/api/channel/Channel;)V", "", "speakingUsers", "handleUserSpeaking", "(Ljava/util/Set;)V", "Ljava/lang/Class;", "Lcom/discord/app/AppComponent;", "screen", "appUiViewed", "(Ljava/lang/Class;)V", "ackMessage", "(J)V", "Landroid/content/Intent;", "intent", "Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "metadata", "deepLinkReceived", "(Landroid/content/Intent;Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;)V", "Lcom/discord/models/domain/ModelInvite;", "invite", "Lcom/discord/api/message/Message;", "message", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "inviteSent", "(Lcom/discord/models/domain/ModelInvite;Lcom/discord/api/message/Message;Ljava/lang/String;)V", "Lcom/discord/widgets/guilds/invite/GuildInvite;", "(Lcom/discord/widgets/guilds/invite/GuildInvite;Lcom/discord/api/channel/Channel;Lcom/discord/api/message/Message;Ljava/lang/String;)V", "isActive", "onOverlayVoiceEvent", "pane", "onGuildSettingsPaneViewed", "(Ljava/lang/String;J)V", "locationSection", "onUserSettingsPaneViewed", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/discord/models/domain/ModelNotificationSettings;", "notifSettings", "onNotificationSettingsUpdated", "(Lcom/discord/models/domain/ModelNotificationSettings;Ljava/lang/Long;)V", "parentChannelId", "flags", "oldFlags", "onThreadNotificationSettingsUpdated", "(JJII)V", "giftCode", "trackOpenGiftAcceptModal", "(Ljava/lang/String;Ljava/lang/String;J)V", "trackGuildViewed", "Lcom/discord/stores/ChannelAnalyticsViewType;", "channelView", "Lcom/discord/stores/SelectedChannelAnalyticsLocation;", "analyticsLocation", "trackChannelOpened", "(JLcom/discord/stores/ChannelAnalyticsViewType;Lcom/discord/stores/SelectedChannelAnalyticsLocation;)V", "trackTextInVoiceOpened", "(JLcom/discord/stores/SelectedChannelAnalyticsLocation;)V", "trackShowCallFeedbackSheet", "Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;", "pendingCallFeedback", "trackCallReportProblem", "(Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;)V", "Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;", "pendingStreamFeedback", "trackStreamReportProblem", "(Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;)V", "trackVoiceConnectionSuccess", "(Ljava/util/Map;)V", "trackVoiceConnectionFailure", "trackVoiceDisconnect", "trackMediaSessionJoined", "trackVideoStreamEnded", "trackGuildProfileOpened", "Lcom/discord/utilities/analytics/SearchType;", "searchType", "Lcom/discord/utilities/analytics/Traits$Location;", "locationTrait", "throttle", "trackSearchStarted", "(Lcom/discord/utilities/analytics/SearchType;Lcom/discord/utilities/analytics/Traits$Location;Z)V", "trackSearchResultsEmpty", "totalResultsCount", "lockedResultsCount", "trackSearchResultViewed", "(Lcom/discord/utilities/analytics/SearchType;ILjava/lang/Integer;Lcom/discord/utilities/analytics/Traits$Location;Z)V", "Lcom/discord/utilities/analytics/Traits$Source;", "sourceTrait", "trackSearchResultSelected", "(Lcom/discord/utilities/analytics/SearchType;ILcom/discord/utilities/analytics/Traits$Location;Lcom/discord/utilities/analytics/Traits$Source;)V", "trackChatInputComponentViewed", "Lcom/discord/utilities/rest/FileUploadAlertType;", "alertType", "numAttachments", "maxAttachmentSize", "totalAttachmentSize", "hasImage", "hasVideo", "isPremium", "trackFileUploadAlertViewed", "(Lcom/discord/utilities/rest/FileUploadAlertType;IIIZZZ)V", "Lcom/discord/stores/FailedMessageResolutionType;", "resolutionType", "Lcom/discord/primitives/Timestamp;", "initialAttemptTimestamp", "numRetries", "trackFailedMessageResolved", "(IIIZZLcom/discord/stores/FailedMessageResolutionType;JIJ)V", "trackApplicationCommandBrowserOpened", "applicationId", "commandId", "trackApplicationCommandSelected", "(JJJ)V", "trackApplicationCommandBrowserScrolled", "targetApplicationId", "trackApplicationCommandBrowserJump", "argumentType", "isRequired", "trackApplicationCommandValidationFailure", "(JJLjava/lang/String;Z)V", "", "channelSuggestions", "Lcom/discord/models/user/User;", "userSuggestions", "inviteSuggestionOpened", "(JLjava/util/List;Ljava/util/List;)V", "tabType", "trackThreadBrowserTabChanged", "(JLjava/lang/String;)V", "appLandingViewed", "openUnicodeEmojiPopout", "(Lcom/discord/api/channel/Channel;)V", "Lcom/discord/primitives/EmojiId;", "emojiId", "joinedSourceGuild", "sourceGuildPrivate", "openCustomEmojiPopout", "(Lcom/discord/api/channel/Channel;JZZZ)V", "emojiPickerUpsellHeaderViewed", "(Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;)V", "isAnimated", "emojiPickerUpsellLockedItemClicked", "(Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;Z)V", "hasPremiumStreamResolution", "hasPremiumStreamFps", "streamQualityIndicatorViewed", "(ZLjava/lang/Boolean;)V", "emojiAutocompleteUpsellInlineViewed", "emojiAutocompleteUpsellModalViewed", "autocompleteType", "numEmojiResults", "numStickerResults", "trackAutocompleteOpen", "(JLjava/lang/String;II)V", "selectionType", "selection", "Lcom/discord/primitives/StickerId;", "stickerId", "trackAutocompleteSelect", "(JLjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;", "fromAudioOutputMode", "toAudioOutputMode", "trackVoiceAudioOutputModeSelected", "(JLcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;)V", "selectedVoiceChannel", "Lcom/discord/api/channel/Channel;", "Lcom/discord/stores/StoreStream;", "stores", "Lcom/discord/stores/StoreStream;", "Ljava/lang/String;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "getSnapshotAnalyticsProperties", "()Ljava/util/Map;", "snapshotAnalyticsProperties", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "screenViewedSubject", "Lrx/subjects/PublishSubject;", "analyticsToken", "inputMode", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasTrackedAppUiShown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getEmojiPickerUpsellLocation", "()Lcom/discord/utilities/analytics/Traits$Location;", "emojiPickerUpsellLocation", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/time/Clock;)V", "ScreenViewed", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreAnalytics extends Store {
    private String analyticsToken;
    private String authToken;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private String fingerprint;
    private AtomicBoolean hasTrackedAppUiShown;
    private String inputMode;
    private final PublishSubject<ScreenViewed> screenViewedSubject;
    private Channel selectedVoiceChannel;
    private final StoreStream stores;

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\f\b\u0002\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u000b\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\tR!\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/discord/stores/StoreAnalytics$ScreenViewed;", "", "Ljava/lang/Class;", "Lcom/discord/app/AppComponent;", "component1", "()Ljava/lang/Class;", "", "Lcom/discord/primitives/Timestamp;", "component2", "()J", "screen", "timestamp", "copy", "(Ljava/lang/Class;J)Lcom/discord/stores/StoreAnalytics$ScreenViewed;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimestamp", "Ljava/lang/Class;", "getScreen", "<init>", "(Ljava/lang/Class;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ScreenViewed {
        private final Class<? extends AppComponent> screen;
        private final long timestamp;

        public ScreenViewed(Class<? extends AppComponent> cls, long j) {
            Intrinsics3.checkNotNullParameter(cls, "screen");
            this.screen = cls;
            this.timestamp = j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ScreenViewed copy$default(ScreenViewed screenViewed, Class cls, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                cls = screenViewed.screen;
            }
            if ((i & 2) != 0) {
                j = screenViewed.timestamp;
            }
            return screenViewed.copy(cls, j);
        }

        public final Class<? extends AppComponent> component1() {
            return this.screen;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final ScreenViewed copy(Class<? extends AppComponent> screen, long timestamp) {
            Intrinsics3.checkNotNullParameter(screen, "screen");
            return new ScreenViewed(screen, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScreenViewed)) {
                return false;
            }
            ScreenViewed screenViewed = (ScreenViewed) other;
            return Intrinsics3.areEqual(this.screen, screenViewed.screen) && this.timestamp == screenViewed.timestamp;
        }

        public final Class<? extends AppComponent> getScreen() {
            return this.screen;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            Class<? extends AppComponent> cls = this.screen;
            return b.a(this.timestamp) + ((cls != null ? cls.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ScreenViewed(screen=");
            sbU.append(this.screen);
            sbU.append(", timestamp=");
            return outline.C(sbU, this.timestamp, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FeedbackIssue.values();
            int[] iArr = new int[24];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_BLACK.ordinal()] = 1;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_BLURRY.ordinal()] = 2;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_LAGGING.ordinal()] = 3;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_OUT_OF_SYNC.ordinal()] = 4;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_MISSING.ordinal()] = 5;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_POOR.ordinal()] = 6;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY.ordinal()] = 7;
            iArr[FeedbackIssue.OTHER.ordinal()] = 8;
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$ackMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreAnalytics.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAnalytics$ackMessage$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00741 extends Lambda implements Function0<Map<String, ? extends Object>> {
            public final /* synthetic */ Map $properties;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00741(Map map) {
                super(0);
                this.$properties = map;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Map<String, ? extends Object> invoke2() {
                return this.$properties;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                AnalyticsTracker.INSTANCE.ackMessage(channelFindChannelByIdInternal$app_productionGoogleRelease, new C00741(Maps6.plus(StoreAnalytics.access$getGuildAnalyticsPropertiesInternal(StoreAnalytics.this, channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId()), StoreAnalytics.getChannelSnapshotAnalyticsProperties$default(StoreAnalytics.this, channelFindChannelByIdInternal$app_productionGoogleRelease, false, 2, (Object) null))));
            }
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "it", "", "invoke", "(Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MediaEngineConnection.InputMode, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MediaEngineConnection.InputMode inputMode) {
            invoke2(inputMode);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MediaEngineConnection.InputMode inputMode) {
            Intrinsics3.checkNotNullParameter(inputMode, "it");
            StoreAnalytics.access$setInputMode$p(StoreAnalytics.this, inputMode.toString());
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$init$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            StoreAnalytics.access$setSelectedVoiceChannel$p(StoreAnalytics.this, channel);
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreAnalytics$ScreenViewed;", "kotlin.jvm.PlatformType", "screenViewed", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreAnalytics$ScreenViewed;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$init$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<ScreenViewed, Observable<? extends ScreenViewed>> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        /* compiled from: StoreAnalytics.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/stores/StoreAnalytics$ScreenViewed;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lcom/discord/stores/StoreAnalytics$ScreenViewed;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAnalytics$init$3$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Long, ScreenViewed> {
            public final /* synthetic */ ScreenViewed $screenViewed;

            public AnonymousClass1(ScreenViewed screenViewed) {
                this.$screenViewed = screenViewed;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ ScreenViewed call(Long l) {
                return call2(l);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final ScreenViewed call2(Long l) {
                return this.$screenViewed;
            }
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ScreenViewed> call(ScreenViewed screenViewed) {
            return call2(screenViewed);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ScreenViewed> call2(ScreenViewed screenViewed) {
            return Intrinsics3.areEqual(screenViewed.getScreen(), WidgetHome.class) ? Observable.d0(2L, TimeUnit.SECONDS).G(new AnonymousClass1(screenViewed)) : new ScalarSynchronousObservable(screenViewed);
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreAnalytics$ScreenViewed;", "p1", "", "invoke", "(Lcom/discord/stores/StoreAnalytics$ScreenViewed;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$init$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<ScreenViewed, Unit> {
        public AnonymousClass4(StoreAnalytics storeAnalytics) {
            super(1, storeAnalytics, StoreAnalytics.class, "onScreenViewed", "onScreenViewed(Lcom/discord/stores/StoreAnalytics$ScreenViewed;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ScreenViewed screenViewed) {
            invoke2(screenViewed);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ScreenViewed screenViewed) {
            Intrinsics3.checkNotNullParameter(screenViewed, "p1");
            StoreAnalytics.access$onScreenViewed((StoreAnalytics) this.receiver, screenViewed);
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$onGuildSettingsPaneViewed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ String $pane;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, String str) {
            super(0);
            this.$guildId = j;
            this.$pane = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnalyticsTracker.INSTANCE.settingsPaneViewed("guild", this.$pane, StoreAnalytics.access$getGuildAnalyticsPropertiesInternal(StoreAnalytics.this, this.$guildId));
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$onNotificationSettingsUpdated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ ModelNotificationSettings $notifSettings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, ModelNotificationSettings modelNotificationSettings) {
            super(0);
            this.$channelId = l;
            this.$notifSettings = modelNotificationSettings;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2() {
            Long l = this.$channelId;
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = null;
            if (l != null) {
                long jLongValue = l.longValue();
                List<ModelNotificationSettings.ChannelOverride> channelOverrides = this.$notifSettings.getChannelOverrides();
                Intrinsics3.checkNotNullExpressionValue(channelOverrides, "notifSettings.channelOverrides");
                boolean z2 = true;
                if ((channelOverrides instanceof Collection) && channelOverrides.isEmpty()) {
                    z2 = false;
                    if (!z2) {
                    }
                    if (l != null) {
                    }
                } else {
                    for (ModelNotificationSettings.ChannelOverride channelOverride : channelOverrides) {
                        Intrinsics3.checkNotNullExpressionValue(channelOverride, "it");
                        if (channelOverride.getChannelId() == jLongValue) {
                            break;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                        l = null;
                    }
                    if (l != null) {
                        channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(l.longValue());
                    }
                }
            }
            AnalyticsTracker.INSTANCE.notificationSettingsUpdated(this.$notifSettings, channelFindChannelByIdInternal$app_productionGoogleRelease);
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$onOverlayVoiceEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isActive;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$isActive = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map<String, String> mapEmptyMap;
            RtcConnection rtcConnection$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getRtcConnection().getRtcConnection();
            if (rtcConnection$app_productionGoogleRelease == null || (mapEmptyMap = AnalyticsUtils.INSTANCE.getProperties$app_productionGoogleRelease(rtcConnection$app_productionGoogleRelease)) == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            if (!this.$isActive) {
                AnalyticsTracker.INSTANCE.overlayVoiceClosed(mapEmptyMap);
                return;
            }
            Channel channelAccess$getSelectedVoiceChannel$p = StoreAnalytics.access$getSelectedVoiceChannel$p(StoreAnalytics.this);
            Map mapAccess$getGuildAnalyticsPropertiesInternal = channelAccess$getSelectedVoiceChannel$p != null ? StoreAnalytics.access$getGuildAnalyticsPropertiesInternal(StoreAnalytics.this, channelAccess$getSelectedVoiceChannel$p.getGuildId()) : null;
            if (mapAccess$getGuildAnalyticsPropertiesInternal == null) {
                mapAccess$getGuildAnalyticsPropertiesInternal = Maps6.emptyMap();
            }
            Map mapPlus = Maps6.plus(mapAccess$getGuildAnalyticsPropertiesInternal, mapEmptyMap);
            Channel channelAccess$getSelectedVoiceChannel$p2 = StoreAnalytics.access$getSelectedVoiceChannel$p(StoreAnalytics.this);
            Map<String, Object> properties$app_productionGoogleRelease = channelAccess$getSelectedVoiceChannel$p2 != null ? AnalyticsUtils.INSTANCE.getProperties$app_productionGoogleRelease(channelAccess$getSelectedVoiceChannel$p2) : null;
            if (properties$app_productionGoogleRelease == null) {
                properties$app_productionGoogleRelease = Maps6.emptyMap();
            }
            AnalyticsTracker.INSTANCE.overlayVoiceOpened(Maps6.plus(mapPlus, properties$app_productionGoogleRelease));
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$onScreenViewed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ScreenViewed $screenViewed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ScreenViewed screenViewed) {
            super(0);
            this.$screenViewed = screenViewed;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Class<? extends AppComponent> screen = this.$screenViewed.getScreen();
            String simpleName = Intrinsics3.areEqual(screen, WidgetHome.class) ? StoreAnalytics.access$getStores$p(StoreAnalytics.this).getGuildSelected().getSelectedGuildId() == 0 ? "private_channel" : "guild" : Intrinsics3.areEqual(screen, WidgetGuildInvite.class) ? "invite" : Intrinsics3.areEqual(screen, WidgetIncomingShare.class) ? AnalyticsTracker.ATTACHMENT_SOURCE_SHARE : Intrinsics3.areEqual(screen, WidgetAuthLanding.class) ? "app_landing" : this.$screenViewed.getScreen().getSimpleName();
            AppStartAnalyticsTracker companion = AppStartAnalyticsTracker.INSTANCE.getInstance();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "screenName");
            companion.appUiViewed(simpleName, this.$screenViewed.getTimestamp());
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$onThreadNotificationSettingsUpdated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ int $flags;
        public final /* synthetic */ int $oldFlags;
        public final /* synthetic */ long $parentChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, int i, int i2) {
            super(0);
            this.$channelId = j;
            this.$parentChannelId = j2;
            this.$oldFlags = i;
            this.$flags = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease;
            ModelNotificationSettings modelNotificationSettings;
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease2 = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease2 == null || (channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$parentChannelId)) == null) {
                return;
            }
            boolean z2 = (this.$oldFlags & 1) != 0;
            long guildId = channelFindChannelByIdInternal$app_productionGoogleRelease2.getGuildId();
            Guild guild = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getGuilds().getGuild(guildId);
            if (guild == null || (modelNotificationSettings = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getGuildSettings().getGuildSettingsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId))) == null) {
                return;
            }
            AnalyticsTracker.INSTANCE.threadNotificationSettingsUpdated(StoreAnalytics.access$getThreadSnapshotAnalyticsProperties(StoreAnalytics.this, channelFindChannelByIdInternal$app_productionGoogleRelease2), z2, NotificationTextUtils.INSTANCE.isGuildOrCategoryOrChannelMuted(modelNotificationSettings, channelFindChannelByIdInternal$app_productionGoogleRelease), ChannelNotificationSettingsUtils.INSTANCE.computeNotificationSetting(guild, channelFindChannelByIdInternal$app_productionGoogleRelease2, modelNotificationSettings), this.$oldFlags, this.$flags);
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$trackCallReportProblem$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PendingFeedback.CallFeedback $pendingCallFeedback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PendingFeedback.CallFeedback callFeedback) {
            super(0);
            this.$pendingCallFeedback = callFeedback;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            long id2 = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getUsers().getMe().getId();
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$pendingCallFeedback.getChannelId());
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                StoreMediaSettings mediaSettings = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getMediaSettings();
                DiscordAudioManager.AudioDevice lastActiveAudioDevice$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getAudioManagerV2().getLastActiveAudioDevice();
                AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                String rtcConnectionId = this.$pendingCallFeedback.getRtcConnectionId();
                Map<Long, VoiceState> mapEmptyMap = (Map) outline.c(channelFindChannelByIdInternal$app_productionGoogleRelease, StoreAnalytics.access$getStores$p(StoreAnalytics.this).getVoiceStates().get());
                if (mapEmptyMap == null) {
                    mapEmptyMap = Maps6.emptyMap();
                }
                analyticsTracker.callReportProblem(id2, rtcConnectionId, channelFindChannelByIdInternal$app_productionGoogleRelease, mapEmptyMap, this.$pendingCallFeedback.getDurationMs(), this.$pendingCallFeedback.getMediaSessionId(), this.$pendingCallFeedback.getFeedbackRating(), this.$pendingCallFeedback.getReasonCode(), this.$pendingCallFeedback.getReasonDescription(), mediaSettings.getVoiceConfigurationBlocking(), lastActiveAudioDevice$app_productionGoogleRelease, mediaSettings.getVideoHardwareScalingBlocking(), this.$pendingCallFeedback.getIssueDetails());
            }
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$trackGuildViewed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends Object>> {
        public final /* synthetic */ Map $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(0);
            this.$properties = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends Object> invoke2() {
            return this.$properties;
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$trackMediaSessionJoined$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Map $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(0);
            this.$properties = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnalyticsTracker.INSTANCE.mediaSessionJoined(this.$properties, StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreAnalytics.access$getStores$p(StoreAnalytics.this).getVoiceChannelSelected().getLastSelectedVoiceChannelId()));
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$trackOpenGiftAcceptModal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ String $giftCode;
        public final /* synthetic */ String $location;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, long j, String str2) {
            super(0);
            this.$giftCode = str;
            this.$channelId = j;
            this.$location = str2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.GiftState giftState = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getGifting().getKnownGifts().get(this.$giftCode);
            ModelGift gift = giftState instanceof StoreGifting.GiftState.Resolved ? ((StoreGifting.GiftState.Resolved) giftState).getGift() : giftState instanceof StoreGifting.GiftState.Redeeming ? ((StoreGifting.GiftState.Redeeming) giftState).getGift() : giftState instanceof StoreGifting.GiftState.RedeemedFailed ? ((StoreGifting.GiftState.RedeemedFailed) giftState).getGift() : null;
            if (gift != null) {
                AnalyticsTracker.openGiftModal(gift, StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId), this.$location);
            }
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$trackShowCallFeedbackSheet$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                AnalyticsTracker.INSTANCE.openCallFeedbackSheet(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId(), channelFindChannelByIdInternal$app_productionGoogleRelease.getId(), channelFindChannelByIdInternal$app_productionGoogleRelease.getType());
            }
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$trackVoiceAudioOutputModeSelected$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ DiscordAudioManager.DeviceTypes $fromAudioOutputMode;
        public final /* synthetic */ DiscordAudioManager.DeviceTypes $toAudioOutputMode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, DiscordAudioManager.DeviceTypes deviceTypes, DiscordAudioManager.DeviceTypes deviceTypes2) {
            super(0);
            this.$channelId = j;
            this.$fromAudioOutputMode = deviceTypes;
            this.$toAudioOutputMode = deviceTypes2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            long id2 = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getUsers().getMe().getId();
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                RtcConnection.Metadata rtcConnectionMetadata = StoreAnalytics.access$getStores$p(StoreAnalytics.this).getRtcConnection().getRtcConnectionMetadata();
                AnalyticsTracker.INSTANCE.voiceAudioOutputModeSelected(id2, rtcConnectionMetadata != null ? rtcConnectionMetadata.rtcConnectionId : null, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, channelFindChannelByIdInternal$app_productionGoogleRelease, this.$fromAudioOutputMode, this.$toAudioOutputMode);
            }
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$trackVoiceConnectionFailure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Map $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(0);
            this.$properties = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnalyticsTracker.INSTANCE.voiceConnectionFailure(this.$properties, StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreAnalytics.access$getStores$p(StoreAnalytics.this).getVoiceChannelSelected().getSelectedVoiceChannelId()), StoreAnalytics.access$getStores$p(StoreAnalytics.this).getRtcRegion().getPreferredRegion());
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$trackVoiceConnectionSuccess$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Map $properties;

        /* compiled from: StoreAnalytics.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngine$AudioInfo;", "audioInfo", "", "invoke", "(Lcom/discord/rtcconnection/mediaengine/MediaEngine$AudioInfo;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAnalytics$trackVoiceConnectionSuccess$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00751 extends Lambda implements Function1<MediaEngine.AudioInfo, Unit> {
            public final /* synthetic */ Channel $channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00751(Channel channel) {
                super(1);
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaEngine.AudioInfo audioInfo) {
                invoke2(audioInfo);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MediaEngine.AudioInfo audioInfo) {
                Intrinsics3.checkNotNullParameter(audioInfo, "audioInfo");
                AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                analyticsTracker.voiceConnectionSuccess(anonymousClass1.$properties, audioInfo, this.$channel, StoreAnalytics.access$getStores$p(StoreAnalytics.this).getRtcRegion().getPreferredRegion());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(0);
            this.$properties = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(StoreAnalytics.access$getStores$p(StoreAnalytics.this).getMediaEngine().getMediaEngine().e()), StoreAnalytics.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C00751(StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreAnalytics.access$getStores$p(StoreAnalytics.this).getVoiceChannelSelected().getSelectedVoiceChannelId())), 62, (Object) null);
        }
    }

    /* compiled from: StoreAnalytics.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAnalytics$trackVoiceDisconnect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Map $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(0);
            this.$properties = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnalyticsTracker.INSTANCE.voiceDisconnect(this.$properties, StoreAnalytics.access$getStores$p(StoreAnalytics.this).getMediaSettings().getVoiceConfigurationBlocking(), StoreAnalytics.access$getStores$p(StoreAnalytics.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreAnalytics.access$getStores$p(StoreAnalytics.this).getVoiceChannelSelected().getLastSelectedVoiceChannelId()), StoreAnalytics.access$getStores$p(StoreAnalytics.this).getRtcRegion().getPreferredRegion());
        }
    }

    public StoreAnalytics(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        Intrinsics3.checkNotNullParameter(storeStream, "stores");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.stores = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.hasTrackedAppUiShown = new AtomicBoolean(false);
        this.screenViewedSubject = PublishSubject.k0();
    }

    public static final /* synthetic */ Map access$getChannelSnapshotAnalyticsProperties(StoreAnalytics storeAnalytics, Channel channel, boolean z2) {
        return storeAnalytics.getChannelSnapshotAnalyticsProperties(channel, z2);
    }

    public static final /* synthetic */ Map access$getGuildAnalyticsPropertiesInternal(StoreAnalytics storeAnalytics, long j) {
        return storeAnalytics.getGuildAnalyticsPropertiesInternal(j);
    }

    public static final /* synthetic */ String access$getInputMode$p(StoreAnalytics storeAnalytics) {
        return storeAnalytics.inputMode;
    }

    public static final /* synthetic */ Channel access$getSelectedVoiceChannel$p(StoreAnalytics storeAnalytics) {
        return storeAnalytics.selectedVoiceChannel;
    }

    public static final /* synthetic */ StoreStream access$getStores$p(StoreAnalytics storeAnalytics) {
        return storeAnalytics.stores;
    }

    public static final /* synthetic */ Map access$getThreadSnapshotAnalyticsProperties(StoreAnalytics storeAnalytics, Channel channel) {
        return storeAnalytics.getThreadSnapshotAnalyticsProperties(channel);
    }

    public static final /* synthetic */ void access$onScreenViewed(StoreAnalytics storeAnalytics, ScreenViewed screenViewed) {
        storeAnalytics.onScreenViewed(screenViewed);
    }

    public static final /* synthetic */ void access$setInputMode$p(StoreAnalytics storeAnalytics, String str) {
        storeAnalytics.inputMode = str;
    }

    public static final /* synthetic */ void access$setSelectedVoiceChannel$p(StoreAnalytics storeAnalytics, Channel channel) {
        storeAnalytics.selectedVoiceChannel = channel;
    }

    private final void emojiPickerUpsellViewed(AnalyticsTracker.PremiumUpsellType type, EmojiPickerContextType emojiPickerContextType, Map<String, ? extends Object> properties) {
        String str;
        if (Intrinsics3.areEqual(emojiPickerContextType, EmojiPickerContextType.Global.INSTANCE)) {
            str = "Custom Status Modal";
        } else if (Intrinsics3.areEqual(emojiPickerContextType, EmojiPickerContextType.Chat.INSTANCE)) {
            Channel channel = this.stores.getChannels().getChannel(this.stores.getChannelsSelected().getId());
            str = (channel == null || channel.getGuildId() != 0) ? Traits.Location.Page.GUILD_CHANNEL : "DM Channel";
        } else {
            str = "";
        }
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, type, new Traits.Location((String) KotlinExtensions.getExhaustive(str), Traits.Location.Section.EMOJI_PICKER_POPOUT, Traits.Location.Obj.BUTTON_UPSELL, Traits.Location.ObjType.SEARCH, null, 16, null), Maps6.plus(properties, Tuples.to("has_search_query", Boolean.TRUE)), null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void emojiPickerUpsellViewed$default(StoreAnalytics storeAnalytics, AnalyticsTracker.PremiumUpsellType premiumUpsellType, EmojiPickerContextType emojiPickerContextType, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = Maps6.emptyMap();
        }
        storeAnalytics.emojiPickerUpsellViewed(premiumUpsellType, emojiPickerContextType, map);
    }

    private final Map<String, Object> getChannelSnapshotAnalyticsProperties(long channelId, boolean includeNsfw) {
        Channel channel = this.stores.getChannels().getChannel(channelId);
        Map<String, Object> channelSnapshotAnalyticsProperties = channel != null ? getChannelSnapshotAnalyticsProperties(channel, includeNsfw) : null;
        return channelSnapshotAnalyticsProperties != null ? channelSnapshotAnalyticsProperties : Maps6.emptyMap();
    }

    public static /* synthetic */ Map getChannelSnapshotAnalyticsProperties$default(StoreAnalytics storeAnalytics, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return storeAnalytics.getChannelSnapshotAnalyticsProperties(j, z2);
    }

    @Store3
    private final Map<String, Object> getGuildAnalyticsPropertiesInternal(long guildId) {
        Collection<Channel> collectionEmptyList;
        GuildMember guildMember;
        List<Long> roles;
        Guild guild = this.stores.getGuilds().getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (guild == null) {
            return new HashMap();
        }
        int approximateMemberCount = this.stores.getGuildMemberCounts().getApproximateMemberCount(guildId);
        Map<Long, Channel> channelsForGuildInternal$app_productionGoogleRelease = this.stores.getChannels().getChannelsForGuildInternal$app_productionGoogleRelease(guildId);
        if (channelsForGuildInternal$app_productionGoogleRelease == null || (collectionEmptyList = channelsForGuildInternal$app_productionGoogleRelease.values()) == null) {
            collectionEmptyList = Collections2.emptyList();
        }
        Collection<Channel> collection = collectionEmptyList;
        Map<Long, GuildRole> map = this.stores.getGuilds().getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        int size = map != null ? map.size() : 0;
        long id2 = this.stores.getUsers().getMe().getId();
        Map<Long, GuildMember> map2 = this.stores.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        int size2 = (map2 == null || (guildMember = map2.get(Long.valueOf(id2))) == null || (roles = guildMember.getRoles()) == null) ? 0 : roles.size();
        Long l = this.stores.getPermissions().getGuildPermissions().get(Long.valueOf(guildId));
        return guildPropertiesMap(guild.getId(), approximateMemberCount, collection, size, size2, l != null ? l.longValue() : 0L, guild.getFeatures().contains(GuildFeature.VIP_REGIONS));
    }

    private final Map<String, Object> getGuildAndChannelSnapshotAnalyticsProperties(long channelId) {
        Channel channel = this.stores.getChannels().getChannel(channelId);
        Map<String, Object> mapPlus = channel != null ? Maps6.plus(getGuildSnapshotAnalyticsProperties(channel.getGuildId()), getChannelSnapshotAnalyticsProperties$default(this, channel, false, 2, (Object) null)) : null;
        return mapPlus != null ? mapPlus : Maps6.emptyMap();
    }

    private final Map<String, Object> getGuildSnapshotAnalyticsProperties(long guildId) {
        Guild guild = this.stores.getGuilds().getGuilds().get(Long.valueOf(guildId));
        Map<String, Object> guildSnapshotAnalyticsProperties = guild != null ? getGuildSnapshotAnalyticsProperties(guild) : null;
        return guildSnapshotAnalyticsProperties != null ? guildSnapshotAnalyticsProperties : Maps6.emptyMap();
    }

    private final Map<String, Object> getSnapshotAnalyticsProperties() {
        return getGuildAndChannelSnapshotAnalyticsProperties(this.stores.getChannelsSelected().getId());
    }

    private final String getStreamFeedbackReasonFromIssue(FeedbackIssue issue) {
        if (issue != null) {
            int iOrdinal = issue.ordinal();
            if (iOrdinal == 0) {
                return "OTHER";
            }
            switch (iOrdinal) {
                case 10:
                    return "BLACK_SCREEN";
                case 11:
                    return "BLURRY";
                case 12:
                    return "LAGGING";
                case 13:
                    return "OUT_OF_SYNC";
                case 14:
                    return "AUDIO_MISSING";
                case 15:
                    return "AUDIO_POOR";
                case 16:
                    return "STREAM_STOPPED_UNEXPECTEDLY";
            }
        }
        return null;
    }

    private final Map<String, Object> getThreadSnapshotAnalyticsProperties(Channel channel) {
        Integer threadMessageCount = this.stores.getThreadMessages().getThreadMessageCount(channel.getId());
        boolean z2 = false;
        int iIntValue = threadMessageCount != null ? threadMessageCount.intValue() : 0;
        Tuples2[] tuples2Arr = new Tuples2[9];
        tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId()));
        tuples2Arr[1] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(channel.getGuildId()));
        tuples2Arr[2] = Tuples.to("parent_id", Long.valueOf(channel.getParentId()));
        tuples2Arr[3] = Tuples.to("channel_type", Integer.valueOf(channel.getType()));
        tuples2Arr[4] = Tuples.to("thread_approximate_message_count", Integer.valueOf(_Ranges.coerceAtMost(iIntValue, 50)));
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        tuples2Arr[5] = Tuples.to("thread_archived", Boolean.valueOf(threadMetadata != null && threadMetadata.getArchived()));
        ThreadMetadata threadMetadata2 = channel.getThreadMetadata();
        if (threadMetadata2 != null && threadMetadata2.getLocked()) {
            z2 = true;
        }
        tuples2Arr[6] = Tuples.to("thread_locked", Boolean.valueOf(z2));
        ThreadMetadata threadMetadata3 = channel.getThreadMetadata();
        tuples2Arr[7] = Tuples.to("thread_auto_archive_duration_minutes", threadMetadata3 != null ? Integer.valueOf(threadMetadata3.getAutoArchiveDuration()) : null);
        tuples2Arr[8] = Tuples.to("thread_approximate_creation_date", Long.valueOf((channel.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH));
        return Maps6.mapOf(tuples2Arr);
    }

    private final Map<String, Object> guildPropertiesMap(long guildId, int guildSize, Collection<Channel> guildChannels, int numGuildRoles, int guildMemberNumRoles, long guildPermissions, boolean isVip) {
        int i;
        Tuples2[] tuples2Arr = new Tuples2[9];
        int i2 = 0;
        tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId));
        tuples2Arr[1] = Tuples.to("guild_size_total", Integer.valueOf(guildSize));
        tuples2Arr[2] = Tuples.to("guild_num_channels", Integer.valueOf(guildChannels.size()));
        if (guildChannels.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = guildChannels.iterator();
            i = 0;
            while (it.hasNext()) {
                if (ChannelUtils.v((Channel) it.next()) && (i = i + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        tuples2Arr[3] = Tuples.to("guild_num_text_channels", Integer.valueOf(i));
        if (!guildChannels.isEmpty()) {
            Iterator<T> it2 = guildChannels.iterator();
            while (it2.hasNext()) {
                if (ChannelUtils.w((Channel) it2.next()) && (i2 = i2 + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        tuples2Arr[4] = Tuples.to("guild_num_voice_channels", Integer.valueOf(i2));
        tuples2Arr[5] = Tuples.to("guild_num_roles", Integer.valueOf(numGuildRoles));
        tuples2Arr[6] = Tuples.to("guild_member_num_roles", Integer.valueOf(guildMemberNumRoles));
        tuples2Arr[7] = Tuples.to("guild_member_perms", Long.valueOf(guildPermissions));
        tuples2Arr[8] = Tuples.to("guild_is_vip", Boolean.valueOf(isVip));
        return Maps6.mutableMapOf(tuples2Arr);
    }

    @Store3
    private final void handleVideoInputUpdate(DeviceDescription4 selectedVideoInputDevice, boolean isScreenSharing) {
        Channel channel = this.selectedVoiceChannel;
        if (channel != null) {
            Map<Long, VoiceState> mapEmptyMap = this.stores.getVoiceStates().get().get(Long.valueOf(channel.getGuildId()));
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            Map<Long, VoiceState> map = mapEmptyMap;
            long id2 = this.stores.getUsers().getMe().getId();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            RtcConnection.Metadata rtcConnectionMetadata = this.stores.getRtcConnection().getRtcConnectionMetadata();
            analyticsTracker.videoInputsUpdate(id2, channel, map, selectedVideoInputDevice, isScreenSharing, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null);
        }
    }

    private final void onScreenViewed(ScreenViewed screenViewed) {
        if (this.hasTrackedAppUiShown.getAndSet(true)) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(screenViewed));
    }

    public static /* synthetic */ void onUserSettingsPaneViewed$default(StoreAnalytics storeAnalytics, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        storeAnalytics.onUserSettingsPaneViewed(str, str2);
    }

    public static /* synthetic */ void trackSearchResultSelected$default(StoreAnalytics storeAnalytics, SearchType searchType, int i, Traits.Location location, Traits.Source source, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            location = null;
        }
        if ((i2 & 8) != 0) {
            source = null;
        }
        storeAnalytics.trackSearchResultSelected(searchType, i, location, source);
    }

    public static /* synthetic */ void trackSearchResultViewed$default(StoreAnalytics storeAnalytics, SearchType searchType, int i, Integer num, Traits.Location location, boolean z2, int i2, Object obj) {
        storeAnalytics.trackSearchResultViewed(searchType, i, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : location, (i2 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ void trackSearchResultsEmpty$default(StoreAnalytics storeAnalytics, SearchType searchType, Traits.Location location, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            location = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeAnalytics.trackSearchResultsEmpty(searchType, location, z2);
    }

    public static /* synthetic */ void trackSearchStarted$default(StoreAnalytics storeAnalytics, SearchType searchType, Traits.Location location, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            location = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeAnalytics.trackSearchStarted(searchType, location, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateTrackingData() {
        boolean z2;
        boolean z3;
        String str = this.authToken;
        boolean z4 = !(str == null || str.length() == 0);
        if (z4) {
            z2 = false;
        } else {
            String str2 = this.fingerprint;
            if (!(str2 == null || str2.length() == 0)) {
                z2 = true;
            }
        }
        if (z4) {
            String str3 = this.analyticsToken;
            if (!(str3 == null || str3.length() == 0)) {
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (z2) {
            AnalyticsTracker.INSTANCE.getTracker().setTrackingData(null, true);
        } else if (z3) {
            AnalyticsUtils.Tracker.setTrackingData$default(AnalyticsTracker.INSTANCE.getTracker(), this.analyticsToken, false, 2, null);
        } else {
            AnalyticsTracker.INSTANCE.getTracker().setTrackingData(null, false);
        }
    }

    public final void ackMessage(long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(channelId));
    }

    public final void appLandingViewed() {
        AnalyticsTracker.appLandingViewed(getPrefsSessionDurable().getLong("CACHE_KEY_LOGOUT_TS", 0L));
    }

    public final void appUiViewed(Class<? extends AppComponent> screen) {
        Intrinsics3.checkNotNullParameter(screen, "screen");
        PublishSubject<ScreenViewed> publishSubject = this.screenViewedSubject;
        publishSubject.k.onNext(new ScreenViewed(screen, this.clock.currentTimeMillis()));
    }

    public final void deepLinkReceived(Intent intent, RouteHandlers.AnalyticsMetadata metadata) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Intrinsics3.checkNotNullParameter(metadata, "metadata");
        Long channelId = metadata.getChannelId();
        Map<String, ? extends Object> guildAndChannelSnapshotAnalyticsProperties = channelId != null ? getGuildAndChannelSnapshotAnalyticsProperties(channelId.longValue()) : null;
        if (guildAndChannelSnapshotAnalyticsProperties == null) {
            guildAndChannelSnapshotAnalyticsProperties = Maps6.emptyMap();
        }
        AnalyticsTracker.INSTANCE.deepLinkReceived(intent, metadata, guildAndChannelSnapshotAnalyticsProperties);
    }

    public final void emojiAutocompleteUpsellInlineViewed() {
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.EmojiAutocompleteInline, null, Maps6.emptyMap(), null, 8, null);
    }

    public final void emojiAutocompleteUpsellModalViewed() {
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.EmojiAutocompleteModal, null, Maps6.emptyMap(), null, 8, null);
    }

    public final void emojiPickerUpsellHeaderViewed(EmojiPickerContextType emojiPickerContextType) {
        Intrinsics3.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
        emojiPickerUpsellViewed$default(this, AnalyticsTracker.PremiumUpsellType.EmojiPickerHeaderViewed, emojiPickerContextType, null, 4, null);
    }

    public final void emojiPickerUpsellLockedItemClicked(EmojiPickerContextType emojiPickerContextType, boolean isAnimated) {
        Intrinsics3.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
        emojiPickerUpsellViewed(AnalyticsTracker.PremiumUpsellType.EmojiPickerLockedItemClicked, emojiPickerContextType, Maps6.mapOf(Tuples.to("is_animated", Boolean.valueOf(isAnimated)), Tuples.to("is_external", Boolean.TRUE)));
    }

    public final Traits.Location getEmojiPickerUpsellLocation() {
        Channel channel = this.stores.getChannels().getChannel(this.stores.getChannelsSelected().getId());
        return new Traits.Location((channel == null || channel.getGuildId() != 0) ? Traits.Location.Page.GUILD_CHANNEL : "DM Channel", Traits.Location.Section.EMOJI_PICKER_POPOUT, null, null, null, 28, null);
    }

    @Store3
    public final void handleAuthToken(String authToken) {
        this.authToken = authToken;
        updateTrackingData();
    }

    @Store3
    public final void handleConnected(boolean connected) {
        if (connected) {
            return;
        }
        this.analyticsToken = null;
        updateTrackingData();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.analyticsToken = payload.getAnalyticsToken();
        updateTrackingData();
    }

    @Store3
    public final void handleFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        updateTrackingData();
    }

    @Store3
    public final void handleIsScreenSharingChanged(boolean isScreenSharing) {
        handleVideoInputUpdate(this.stores.getMediaEngine().getSelectedVideoInputDevice(), isScreenSharing);
    }

    @Store3
    public final void handlePreLogout() {
        SharedPreferences.Editor editorEdit = getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putLong("CACHE_KEY_LOGOUT_TS", this.clock.currentTimeMillis());
        editorEdit.apply();
    }

    @Store3
    public final void handleUserSpeaking(Set<Long> speakingUsers) {
        Channel channel;
        Intrinsics3.checkNotNullParameter(speakingUsers, "speakingUsers");
        String str = this.inputMode;
        if (str == null || (channel = this.selectedVoiceChannel) == null) {
            return;
        }
        long id2 = this.stores.getUsers().getMe().getId();
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        analyticsTracker.userSpeaking(id2, speakingUsers, str, channel);
        analyticsTracker.userListening(id2, speakingUsers, str, channel);
    }

    @Store3
    public final void handleVideoInputDeviceSelected(DeviceDescription4 videoInputDevice) {
        handleVideoInputUpdate(videoInputDevice, this.stores.getApplicationStreaming().isScreenSharing());
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(this.stores.getMediaSettings().getInputMode()), StoreAnalytics.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(this.stores.getVoiceChannelSelected().observeSelectedChannel()), StoreAnalytics.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        Observable observableZ = this.screenViewedSubject.Y(AnonymousClass3.INSTANCE).z();
        Intrinsics3.checkNotNullExpressionValue(observableZ, "screenViewedSubject\n    …       }\n        .first()");
        ObservableExtensionsKt.appSubscribe$default(observableZ, StoreAnalytics.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(this), 62, (Object) null);
    }

    public final void inviteSent(ModelInvite invite, Message message, String location) {
        GuildScheduledEvent guildScheduledEvent;
        Channel channel;
        com.discord.api.guild.Guild guild;
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Tuples2[] tuples2Arr = new Tuples2[5];
        tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        tuples2Arr[1] = Tuples.to("message_id", Long.valueOf(message.getId()));
        Long lValueOf = null;
        tuples2Arr[2] = Tuples.to("invite_guild_id", (invite == null || (guild = invite.guild) == null) ? null : Long.valueOf(guild.getId()));
        tuples2Arr[3] = Tuples.to("invite_channel_id", (invite == null || (channel = invite.getChannel()) == null) ? null : Long.valueOf(channel.getId()));
        if (invite != null && (guildScheduledEvent = invite.getGuildScheduledEvent()) != null) {
            lValueOf = Long.valueOf(guildScheduledEvent.getId());
        }
        tuples2Arr[4] = Tuples.to("invite_guild_scheduled_event_id", lValueOf);
        AnalyticsTracker.INSTANCE.inviteSent(invite, Maps6.plus(Maps6.mapOf(tuples2Arr), getGuildAndChannelSnapshotAnalyticsProperties(message.getChannelId())));
    }

    public final void inviteSuggestionOpened(long guildId, List<Channel> channelSuggestions, List<? extends User> userSuggestions) {
        Intrinsics3.checkNotNullParameter(channelSuggestions, "channelSuggestions");
        Intrinsics3.checkNotNullParameter(userSuggestions, "userSuggestions");
        AnalyticsTracker.INSTANCE.inviteSuggestionOpened(guildId, channelSuggestions, userSuggestions);
    }

    public final void onGuildSettingsPaneViewed(String pane, long guildId) {
        Intrinsics3.checkNotNullParameter(pane, "pane");
        this.dispatcher.schedule(new AnonymousClass1(guildId, pane));
    }

    public final void onNotificationSettingsUpdated(ModelNotificationSettings notifSettings, Long channelId) {
        Intrinsics3.checkNotNullParameter(notifSettings, "notifSettings");
        this.dispatcher.schedule(new AnonymousClass1(channelId, notifSettings));
    }

    public final void onOverlayVoiceEvent(boolean isActive) {
        this.dispatcher.schedule(new AnonymousClass1(isActive));
    }

    public final void onThreadNotificationSettingsUpdated(long channelId, long parentChannelId, int flags, int oldFlags) {
        this.dispatcher.schedule(new AnonymousClass1(channelId, parentChannelId, oldFlags, flags));
    }

    public final void onUserSettingsPaneViewed(String pane, String locationSection) {
        Intrinsics3.checkNotNullParameter(pane, "pane");
        AnalyticsTracker.INSTANCE.settingsPaneViewed("user", pane, locationSection != null ? MapsJVM.mapOf(Tuples.to("location_section", locationSection)) : null);
    }

    public final void openCustomEmojiPopout(Channel channel, long emojiId, boolean isPremium, boolean joinedSourceGuild, boolean sourceGuildPrivate) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        AnalyticsTracker.INSTANCE.openCustomEmojiPopout(channel.getGuildId(), emojiId, isPremium, joinedSourceGuild, sourceGuildPrivate, CollectionExtensions.filterNonNullValues(getChannelSnapshotAnalyticsProperties$default(this, channel, false, 2, (Object) null)));
    }

    public final void openUnicodeEmojiPopout(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        AnalyticsTracker.INSTANCE.openUnicodeEmojiPopout(channel.getGuildId(), CollectionExtensions.filterNonNullValues(getChannelSnapshotAnalyticsProperties$default(this, channel, false, 2, (Object) null)));
    }

    public final void streamQualityIndicatorViewed(boolean hasPremiumStreamResolution, Boolean hasPremiumStreamFps) {
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.StreamQualityIndicator, null, CollectionExtensions.filterNonNullValues(Maps6.mapOf(Tuples.to("has_premium_stream_fps", hasPremiumStreamFps), Tuples.to("has_premium_stream_resolution", Boolean.valueOf(hasPremiumStreamResolution)))), null, 8, null);
    }

    public final void trackApplicationCommandBrowserJump(long targetApplicationId) {
        AnalyticsTracker.INSTANCE.applicationCommandBrowserJump(targetApplicationId);
    }

    public final void trackApplicationCommandBrowserOpened(long channelId) {
        AnalyticsTracker.INSTANCE.applicationCommandBrowserOpened(getGuildAndChannelSnapshotAnalyticsProperties(channelId));
    }

    public final void trackApplicationCommandBrowserScrolled() {
        AnalyticsTracker.INSTANCE.applicationCommandBrowserScrolled();
    }

    public final void trackApplicationCommandSelected(long channelId, long applicationId, long commandId) {
        AnalyticsTracker.INSTANCE.applicationCommandSelected(applicationId, commandId, getGuildAndChannelSnapshotAnalyticsProperties(channelId));
    }

    public final void trackApplicationCommandValidationFailure(long applicationId, long commandId, String argumentType, boolean isRequired) {
        Intrinsics3.checkNotNullParameter(argumentType, "argumentType");
        AnalyticsTracker.INSTANCE.applicationCommandValidationFailure(applicationId, commandId, argumentType, isRequired);
    }

    public final void trackAutocompleteOpen(long channelId, String autocompleteType, int numEmojiResults, int numStickerResults) {
        Intrinsics3.checkNotNullParameter(autocompleteType, "autocompleteType");
        AnalyticsTracker.INSTANCE.autocompleteOpen(CollectionExtensions.filterNonNullValues(getGuildAndChannelSnapshotAnalyticsProperties(channelId)), autocompleteType, numEmojiResults, numStickerResults);
    }

    public final void trackAutocompleteSelect(long channelId, String autocompleteType, int numEmojiResults, int numStickerResults, String selectionType, String selection, Long stickerId) {
        Intrinsics3.checkNotNullParameter(autocompleteType, "autocompleteType");
        AnalyticsTracker.INSTANCE.autocompleteSelect(CollectionExtensions.filterNonNullValues(getGuildAndChannelSnapshotAnalyticsProperties(channelId)), autocompleteType, numEmojiResults, numStickerResults, selectionType, selection, stickerId);
    }

    public final void trackCallReportProblem(PendingFeedback.CallFeedback pendingCallFeedback) {
        Intrinsics3.checkNotNullParameter(pendingCallFeedback, "pendingCallFeedback");
        this.dispatcher.schedule(new AnonymousClass1(pendingCallFeedback));
    }

    @Store3
    public final void trackChannelOpened(long channelId, StoreChannelsSelected2 channelView, StoreChannelsSelected3 analyticsLocation) {
        Intrinsics3.checkNotNullParameter(channelView, "channelView");
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            AnalyticsTracker.INSTANCE.channelOpened(channelId, new StoreAnalytics2(channelFindChannelByIdInternal$app_productionGoogleRelease, this, channelId, channelView, analyticsLocation));
        }
    }

    public final void trackChatInputComponentViewed(String type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        AnalyticsTracker.INSTANCE.chatInputComponentViewed(type);
    }

    public final void trackFailedMessageResolved(int numAttachments, int maxAttachmentSize, int totalAttachmentSize, boolean hasImage, boolean hasVideo, StoreMessages2 resolutionType, long initialAttemptTimestamp, int numRetries, long channelId) {
        Intrinsics3.checkNotNullParameter(resolutionType, "resolutionType");
        AnalyticsTracker.INSTANCE.failedMessageResolved(numAttachments, maxAttachmentSize, totalAttachmentSize, hasImage, hasVideo, resolutionType, initialAttemptTimestamp, numRetries, getGuildAndChannelSnapshotAnalyticsProperties(channelId));
    }

    public final void trackFileUploadAlertViewed(SendUtils2 alertType, int numAttachments, int maxAttachmentSize, int totalAttachmentSize, boolean hasImage, boolean hasVideo, boolean isPremium) {
        Intrinsics3.checkNotNullParameter(alertType, "alertType");
        AnalyticsTracker.INSTANCE.fileUploadAlertViewed(alertType, numAttachments, maxAttachmentSize, totalAttachmentSize, hasImage, hasVideo, isPremium, getSnapshotAnalyticsProperties());
    }

    public final void trackGuildProfileOpened(long guildId) {
        AnalyticsTracker.INSTANCE.openGuildProfileSheet(guildId);
    }

    @Store3
    public final void trackGuildViewed(long guildId) {
        boolean zContains;
        GuildMember guildMember;
        Guild guild = this.stores.getGuilds().getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (guild != null) {
            long id2 = this.stores.getUsers().getMe().getId();
            Map<Long, GuildMember> map = this.stores.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
            boolean pending = (map == null || (guildMember = map.get(Long.valueOf(id2))) == null) ? false : guildMember.getPending();
            try {
                zContains = guild.getFeatures().contains(GuildFeature.PREVIEW_ENABLED);
            } catch (Exception e) {
                AppLog.g.e("Guild is missing feature set", e, MapsJVM.mapOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, String.valueOf(guild.getId()))));
                zContains = false;
            }
            AnalyticsTracker.INSTANCE.guildViewed(guildId, new AnonymousClass1(Maps6.plus(getGuildAnalyticsPropertiesInternal(guildId), Maps6.mapOf(Tuples.to("is_pending", Boolean.valueOf(pending)), Tuples.to("preview_enabled", Boolean.valueOf(zContains))))));
        }
    }

    public final void trackMediaSessionJoined(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new AnonymousClass1(properties));
    }

    public final void trackOpenGiftAcceptModal(String giftCode, String location, long channelId) {
        Intrinsics3.checkNotNullParameter(giftCode, "giftCode");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        this.dispatcher.schedule(new AnonymousClass1(giftCode, channelId, location));
    }

    public final void trackSearchResultSelected(SearchType searchType, int totalResultsCount, Traits.Location locationTrait, Traits.Source sourceTrait) {
        Intrinsics3.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchResultSelected(searchType, locationTrait, sourceTrait, totalResultsCount, getSnapshotAnalyticsProperties());
    }

    public final void trackSearchResultViewed(SearchType searchType, int totalResultsCount, Integer lockedResultsCount, Traits.Location locationTrait, boolean throttle) {
        Intrinsics3.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchResultViewed(searchType, totalResultsCount, lockedResultsCount, locationTrait, getSnapshotAnalyticsProperties(), throttle);
    }

    public final void trackSearchResultsEmpty(SearchType searchType, Traits.Location locationTrait, boolean throttle) {
        Intrinsics3.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchResultsEmpty(searchType, locationTrait, getSnapshotAnalyticsProperties(), throttle);
    }

    public final void trackSearchStarted(SearchType searchType, Traits.Location locationTrait, boolean throttle) {
        Intrinsics3.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchStart(searchType, locationTrait, getSnapshotAnalyticsProperties(), throttle);
    }

    public final void trackShowCallFeedbackSheet(long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(channelId));
    }

    public final void trackStreamReportProblem(PendingFeedback.StreamFeedback pendingStreamFeedback) {
        Intrinsics3.checkNotNullParameter(pendingStreamFeedback, "pendingStreamFeedback");
        AnalyticsTracker.INSTANCE.reportStreamProblem(pendingStreamFeedback.getStream(), pendingStreamFeedback.getFeedbackRating(), getStreamFeedbackReasonFromIssue(pendingStreamFeedback.getIssue()), pendingStreamFeedback.getMediaSessionId(), pendingStreamFeedback.getIssueDetails());
    }

    @Store3
    public final void trackTextInVoiceOpened(long channelId, StoreChannelsSelected3 analyticsLocation) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            AnalyticsTracker.INSTANCE.textInVoiceOpened(channelId, new StoreAnalytics3(channelFindChannelByIdInternal$app_productionGoogleRelease, this, channelId, analyticsLocation));
        }
    }

    public final void trackThreadBrowserTabChanged(long channelId, String tabType) {
        Intrinsics3.checkNotNullParameter(tabType, "tabType");
        AnalyticsTracker.INSTANCE.threadBrowserTabChanged(getGuildAndChannelSnapshotAnalyticsProperties(channelId), tabType);
    }

    public final void trackVideoLayoutToggled(String videoLayout, long meId, Channel channel) {
        Intrinsics3.checkNotNullParameter(videoLayout, "videoLayout");
        AnalyticsTracker.INSTANCE.videoLayoutToggled(videoLayout, meId, channel);
    }

    @Store3
    public final void trackVideoStreamEnded(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        Object obj = properties.get("sender_user_id");
        if (!(obj instanceof Long)) {
            obj = null;
        }
        Long l = (Long) obj;
        if (l != null) {
            long jLongValue = l.longValue();
            Object obj2 = properties.get(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID);
            if (!(obj2 instanceof Long)) {
                obj2 = null;
            }
            Long l2 = (Long) obj2;
            if (l2 != null) {
                long jLongValue2 = l2.longValue();
                Object obj3 = properties.get(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID);
                Integer maxViewersForStream = this.stores.getApplicationStreaming().getMaxViewersForStream(jLongValue, jLongValue2, (Long) (obj3 instanceof Long ? obj3 : null));
                if (maxViewersForStream != null) {
                    properties.put("max_viewers", maxViewersForStream);
                }
                AnalyticsTracker.INSTANCE.videoStreamEnded(properties);
            }
        }
    }

    public final void trackVoiceAudioOutputModeSelected(long channelId, DiscordAudioManager.DeviceTypes fromAudioOutputMode, DiscordAudioManager.DeviceTypes toAudioOutputMode) {
        Intrinsics3.checkNotNullParameter(fromAudioOutputMode, "fromAudioOutputMode");
        Intrinsics3.checkNotNullParameter(toAudioOutputMode, "toAudioOutputMode");
        this.dispatcher.schedule(new AnonymousClass1(channelId, fromAudioOutputMode, toAudioOutputMode));
    }

    public final void trackVoiceConnectionFailure(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new AnonymousClass1(properties));
    }

    public final void trackVoiceConnectionSuccess(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new AnonymousClass1(properties));
    }

    @Store3
    public final void trackVoiceDisconnect(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new AnonymousClass1(properties));
    }

    public static /* synthetic */ Map getChannelSnapshotAnalyticsProperties$default(StoreAnalytics storeAnalytics, Channel channel, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return storeAnalytics.getChannelSnapshotAnalyticsProperties(channel, z2);
    }

    private final Map<String, Object> getGuildSnapshotAnalyticsProperties(Guild guild) {
        GuildMember guildMember;
        List<Long> roles;
        int approximateMemberCount = this.stores.getGuildMemberCounts().getApproximateMemberCount(guild.getId());
        Collection<Channel> collectionValues = this.stores.getChannels().getChannelsForGuild(guild.getId()).values();
        Map map = (Map) outline.e(guild, this.stores.getGuilds().getRoles());
        int size = map != null ? map.size() : 0;
        long id2 = this.stores.getUsers().getMeSnapshot().getId();
        Map map2 = (Map) outline.e(guild, this.stores.getGuilds().getMembers());
        int size2 = (map2 == null || (guildMember = (GuildMember) map2.get(Long.valueOf(id2))) == null || (roles = guildMember.getRoles()) == null) ? 0 : roles.size();
        Long l = (Long) outline.e(guild, this.stores.getPermissions().getGuildPermissions());
        return guildPropertiesMap(guild.getId(), approximateMemberCount, collectionValues, size, size2, l != null ? l.longValue() : 0L, guild.getFeatures().contains(GuildFeature.VIP_REGIONS));
    }

    private final Map<String, Object> getChannelSnapshotAnalyticsProperties(Channel channel, boolean includeNsfw) {
        PermissionOverwrite permissionOverwrite;
        Object next;
        Long l = (Long) outline.d(channel, this.stores.getPermissions().getPermissionsByChannel());
        List<PermissionOverwrite> listV = channel.v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((PermissionOverwrite) next).e() == channel.getGuildId()) {
                    break;
                }
            }
            permissionOverwrite = (PermissionOverwrite) next;
        } else {
            permissionOverwrite = null;
        }
        return Maps6.plus(Maps6.plus(AnalyticsUtils.INSTANCE.getProperties$app_productionGoogleRelease(channel), Maps6.mapOf(Tuples.to("channel_member_perms", l), Tuples.to("channel_hidden", permissionOverwrite != null ? Boolean.valueOf(PermissionOverwriteUtils.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) : null))), includeNsfw ? MapsJVM.mapOf(Tuples.to("channel_is_nsfw", Boolean.valueOf(channel.getNsfw()))) : Maps6.emptyMap());
    }

    public final void inviteSent(GuildInvite invite, Channel channel, Message message, String location) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Tuples2[] tuples2Arr = new Tuples2[5];
        tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        tuples2Arr[1] = Tuples.to("message_id", Long.valueOf(message.getId()));
        tuples2Arr[2] = Tuples.to("invite_guild_id", invite != null ? invite.getGuildId() : null);
        tuples2Arr[3] = Tuples.to("invite_channel_id", invite != null ? invite.getChannelId() : null);
        tuples2Arr[4] = Tuples.to("invite_guild_scheduled_event_id", invite != null ? invite.getGuildScheduledEventId() : null);
        AnalyticsTracker.INSTANCE.inviteSent(invite, channel, Maps6.plus(Maps6.mapOf(tuples2Arr), getGuildAndChannelSnapshotAnalyticsProperties(message.getChannelId())));
    }
}
