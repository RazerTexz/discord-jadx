package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import b.a.q.w;
import b.d.b.a.outline;
import co.discord.media_engine.DeviceDescription4;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.server.VoiceServer;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.App;
import com.discord.app.AppLog;
import com.discord.gateway.io.Outgoing2;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.experiments.domain.Experiment;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollection2;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.debug.DebugPrintable2;
import com.discord.utilities.debug.DebugPrintable3;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.ssl.SecureSocketsLayerUtils;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreRtcConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ø\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Ú\u00012\u00020\u00012\u00020\u0002:\bÚ\u0001Û\u0001Ü\u0001Ý\u0001B]\u0012\b\u0010\u0094\u0001\u001a\u00030\u0093\u0001\u0012\b\u0010«\u0001\u001a\u00030ª\u0001\u0012\b\u0010Ó\u0001\u001a\u00030Ò\u0001\u0012\b\u0010 \u0001\u001a\u00030\u009f\u0001\u0012\b\u0010Ö\u0001\u001a\u00030Õ\u0001\u0012\b\u0010Å\u0001\u001a\u00030Ä\u0001\u0012\n\b\u0002\u0010Ì\u0001\u001a\u00030Ë\u0001\u0012\n\b\u0002\u0010¤\u0001\u001a\u00030£\u0001¢\u0006\u0006\bØ\u0001\u0010Ù\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tH\u0003¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0019\u0010\u0012J\u000f\u0010\u001a\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u001a\u0010\u0012J)\u0010 \u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0010\b\u0002\u0010\u001f\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001eH\u0002¢\u0006\u0004\b \u0010!J'\u0010%\u001a\u00020\u00052\u0016\u0010$\u001a\u0012\u0012\b\u0012\u00060\u001dj\u0002`\u001e\u0012\u0004\u0012\u00020#0\"H\u0003¢\u0006\u0004\b%\u0010&J'\u0010(\u001a\u00020\u00052\u0016\u0010'\u001a\u0012\u0012\b\u0012\u00060\u001dj\u0002`\u001e\u0012\u0004\u0012\u00020\t0\"H\u0003¢\u0006\u0004\b(\u0010&J'\u0010*\u001a\u00020\u00052\u0016\u0010)\u001a\u0012\u0012\b\u0012\u00060\u001dj\u0002`\u001e\u0012\u0004\u0012\u00020\t0\"H\u0003¢\u0006\u0004\b*\u0010&J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0015H\u0002¢\u0006\u0004\b,\u0010\u0018J#\u00100\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00152\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0015H\u0002¢\u0006\u0004\b2\u0010\u0018J;\u00104\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00152\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.2\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\"H\u0002¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0004\b8\u00109J\u0011\u0010:\u001a\u0004\u0018\u000107H\u0007¢\u0006\u0004\b:\u0010;J\u001f\u0010@\u001a\u00020\u00052\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>H\u0007¢\u0006\u0004\b@\u0010AJ\u0017\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0005H\u0004¢\u0006\u0004\bF\u0010\u0012J\u0017\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\tH\u0007¢\u0006\u0004\bH\u0010\fJ\u0017\u0010K\u001a\u00020\u00052\u0006\u0010J\u001a\u00020IH\u0007¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020\u00052\u0006\u0010N\u001a\u00020MH\u0007¢\u0006\u0004\bO\u0010PJ\u001f\u0010S\u001a\u00020\u00052\u000e\u0010R\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`QH\u0007¢\u0006\u0004\bS\u0010TJ\u0017\u0010W\u001a\u00020\u00052\u0006\u0010V\u001a\u00020UH\u0007¢\u0006\u0004\bW\u0010XJ\u0017\u0010[\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020YH\u0016¢\u0006\u0004\b[\u0010\\J#\u0010_\u001a\u00020\u00052\n\u0010]\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010^\u001a\u00020\tH\u0016¢\u0006\u0004\b_\u0010`JC\u0010g\u001a\u00020\u00052\n\u0010]\u001a\u00060\u001dj\u0002`\u001e2\u000e\u0010c\u001a\n\u0018\u00010aj\u0004\u0018\u0001`b2\u0006\u0010d\u001a\u00020a2\u0006\u0010e\u001a\u00020a2\u0006\u0010f\u001a\u00020aH\u0016¢\u0006\u0004\bg\u0010hJ\u0017\u0010j\u001a\u00020\u00052\u0006\u00103\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u000f\u0010l\u001a\u00020\u0005H\u0016¢\u0006\u0004\bl\u0010\u0012J\u0017\u0010n\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u001bH\u0016¢\u0006\u0004\bn\u0010oJ#\u0010p\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u001b2\n\u0010]\u001a\u00060\u001dj\u0002`\u001eH\u0016¢\u0006\u0004\bp\u0010qJ\u000f\u0010r\u001a\u00020\u0005H\u0016¢\u0006\u0004\br\u0010\u0012J\u0017\u0010u\u001a\u00020\u00052\u0006\u0010t\u001a\u00020sH\u0016¢\u0006\u0004\bu\u0010vJ+\u0010|\u001a\u00020\u00052\u0006\u0010x\u001a\u00020w2\u0012\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020z0yH\u0016¢\u0006\u0004\b|\u0010}J\u000f\u0010~\u001a\u00020\u0005H\u0016¢\u0006\u0004\b~\u0010\u0012J\u001f\u0010\u0081\u0001\u001a\u00020\u00052\u000b\u0010\u0080\u0001\u001a\u00060\u001dj\u0002`\u007fH\u0016¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R#\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020Y068\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0005\b\u0088\u0001\u00109R\"\u0010\u008a\u0001\u001a\u000b\u0018\u00010\u0015j\u0005\u0018\u0001`\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R+\u0010\u008e\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u0001068\u0006@\u0006¢\u0006\u000f\n\u0006\b\u008e\u0001\u0010\u0087\u0001\u001a\u0005\b\u008f\u0001\u00109R\u001e\u0010\u0091\u0001\u001a\u00070\u001dj\u0003`\u0090\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R8\u0010\u0098\u0001\u001a!\u0012\r\u0012\u000b \u0097\u0001*\u0004\u0018\u00010Y0Y\u0012\r\u0012\u000b \u0097\u0001*\u0004\u0018\u00010Y0Y0\u0096\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R,\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u001b8\u0000@BX\u0080\u000e¢\u0006\u000f\n\u0005\b\u001c\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R!\u0010t\u001a\b\u0012\u0004\u0012\u00020s068\u0006@\u0006¢\u0006\u000e\n\u0005\bt\u0010\u0087\u0001\u001a\u0005\b\u009e\u0001\u00109R\u001a\u0010 \u0001\u001a\u00030\u009f\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0019\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bN\u0010¢\u0001R\u001a\u0010¤\u0001\u001a\u00030£\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u0019\u0010¦\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010\u008b\u0001R\u0017\u0010=\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b=\u0010§\u0001R\u001b\u0010¨\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010«\u0001\u001a\u00030ª\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001b\u0010\u00ad\u0001\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R!\u0010±\u0001\u001a\n\u0012\u0005\u0012\u00030°\u00010¯\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R&\u0010´\u0001\u001a\n\u0012\u0005\u0012\u00030°\u00010³\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R\"\u0010¹\u0001\u001a\u000b\u0018\u00010\u001dj\u0005\u0018\u0001`¸\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u0019\u0010»\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001c\u0010¾\u0001\u001a\u0005\u0018\u00010½\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001RB\u0010Á\u0001\u001a+\u0012\r\u0012\u000b \u0097\u0001*\u0004\u0018\u00010s0s \u0097\u0001*\u0014\u0012\r\u0012\u000b \u0097\u0001*\u0004\u0018\u00010s0s\u0018\u00010À\u00010À\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R4\u0010Ã\u0001\u001a\u001d\u0012\u0006\u0012\u0004\u0018\u000107 \u0097\u0001*\r\u0012\u0006\u0012\u0004\u0018\u000107\u0018\u00010À\u00010À\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Â\u0001R\u001a\u0010Å\u0001\u001a\u00030Ä\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u0017\u0010?\u001a\u00020>8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b?\u0010Ç\u0001RF\u0010É\u0001\u001a/\u0012\u000f\u0012\r \u0097\u0001*\u0005\u0018\u00010\u008d\u00010\u008d\u0001 \u0097\u0001*\u0016\u0012\u000f\u0012\r \u0097\u0001*\u0005\u0018\u00010\u008d\u00010\u008d\u0001\u0018\u00010È\u00010È\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u001a\u0010Ì\u0001\u001a\u00030Ë\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u001b\u0010Ñ\u0001\u001a\u00070\u001dj\u0003`Î\u00018F@\u0006¢\u0006\b\u001a\u0006\bÏ\u0001\u0010Ð\u0001R\u001a\u0010Ó\u0001\u001a\u00030Ò\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u001a\u0010Ö\u0001\u001a\u00030Õ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001¨\u0006Þ\u0001"}, d2 = {"Lcom/discord/stores/StoreRtcConnection;", "Lcom/discord/rtcconnection/RtcConnection$b;", "Lcom/discord/utilities/debug/DebugPrintable;", "Lcom/discord/api/channel/Channel;", "channel", "", "logChannelJoin", "(Lcom/discord/api/channel/Channel;)V", "logChannelLeave", "", "selfMuted", "handleSelfMuted", "(Z)V", "selfDeafened", "handleSelfDeafened", "selfVideo", "handleSelfVideo", "onVoiceStateUpdated", "()V", "checkForVoiceServerUpdate", "createRtcConnection", "", ModelAuditLogEntry.CHANGE_KEY_REASON, "destroyRtcConnection", "(Ljava/lang/String;)V", "handleMediaSessionIdReceived", "updateMetadata", "Lcom/discord/rtcconnection/RtcConnection;", "rtcConnection", "", "Lcom/discord/primitives/UserId;", "targetUserId", "applyVoiceConfiguration", "(Lcom/discord/rtcconnection/RtcConnection;Ljava/lang/Long;)V", "", "", "usersVolume", "handleUsersVolume", "(Ljava/util/Map;)V", "usersMuted", "handleUsersMuted", "usersOffScreen", "handleUsersOffScreen", "message", "recordBreadcrumb", NotificationCompat.CATEGORY_MESSAGE, "", "e", "logi", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "logw", "metadata", "loge", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", "Lrx/Observable;", "Lcom/discord/rtcconnection/RtcConnection$Metadata;", "observeRtcConnectionMetadata", "()Lrx/Observable;", "getRtcConnectionMetadata", "()Lcom/discord/rtcconnection/RtcConnection$Metadata;", "Landroid/content/Context;", "context", "Lcom/discord/utilities/networking/NetworkMonitor;", "networkMonitor", "init", "(Landroid/content/Context;Lcom/discord/utilities/networking/NetworkMonitor;)V", "Lcom/discord/utilities/debug/DebugPrintBuilder;", "dp", "debugPrint", "(Lcom/discord/utilities/debug/DebugPrintBuilder;)V", "finalize", "connected", "handleConnectionReady", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/voice/server/VoiceServer;", "voiceServer", "handleVoiceServerUpdate", "(Lcom/discord/api/voice/server/VoiceServer;)V", "Lcom/discord/primitives/ChannelId;", "channelId", "handleVoiceChannelSelected", "(Ljava/lang/Long;)V", "Lcom/discord/api/voice/state/VoiceState;", "voiceState", "handleVoiceStateUpdate", "(Lcom/discord/api/voice/state/VoiceState;)V", "Lcom/discord/rtcconnection/RtcConnection$StateChange;", "stateChange", "onStateChange", "(Lcom/discord/rtcconnection/RtcConnection$StateChange;)V", "userId", "isSpeaking", "onSpeaking", "(JZ)V", "", "Lcom/discord/primitives/StreamId;", "streamId", "audioSsrc", "videoSsrc", "rtxSsrc", "onVideoStream", "(JLjava/lang/Integer;III)V", "Lcom/discord/rtcconnection/VideoMetadata;", "onVideoMetadata", "(Lcom/discord/rtcconnection/VideoMetadata;)V", "onMediaSessionIdReceived", "connection", "onMediaEngineConnectionConnected", "(Lcom/discord/rtcconnection/RtcConnection;)V", "onUserCreated", "(Lcom/discord/rtcconnection/RtcConnection;J)V", "onFatalClose", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "quality", "onQualityUpdate", "(Lcom/discord/rtcconnection/RtcConnection$Quality;)V", "Lcom/discord/rtcconnection/RtcConnection$AnalyticsEvent;", "event", "", "", "properties", "onAnalyticsEvent", "(Lcom/discord/rtcconnection/RtcConnection$AnalyticsEvent;Ljava/util/Map;)V", "onFirstFrameSent", "Lcom/discord/primitives/SSRC;", "ssrc", "onFirstFrameReceived", "(J)V", "Lcom/discord/gateway/io/OutgoingPayload$VoiceStateUpdate;", "currentVoiceState", "Lcom/discord/gateway/io/OutgoingPayload$VoiceStateUpdate;", "connectionState", "Lrx/Observable;", "getConnectionState", "Lcom/discord/primitives/SessionId;", "sessionId", "Ljava/lang/String;", "", "Lcom/discord/stores/StoreRtcConnection$SpeakingUserUpdate;", "speakingUpdates", "getSpeakingUpdates", "Lcom/discord/utilities/debug/DebugPrintableId;", "debugDisplayId", "J", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "connectionStateSubject", "Lrx/subjects/SerializedSubject;", "<set-?>", "Lcom/discord/rtcconnection/RtcConnection;", "getRtcConnection$app_productionGoogleRelease", "()Lcom/discord/rtcconnection/RtcConnection;", "getQuality", "Lcom/discord/stores/StoreRtcRegion;", "storeRtcRegion", "Lcom/discord/stores/StoreRtcRegion;", "Lcom/discord/api/voice/server/VoiceServer;", "Lcom/discord/utilities/debug/DebugPrintableCollection;", "dpc", "Lcom/discord/utilities/debug/DebugPrintableCollection;", "loggingTag", "Landroid/content/Context;", "selectedVoiceChannel", "Lcom/discord/api/channel/Channel;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "rtcConnectionMetadata", "Lcom/discord/rtcconnection/RtcConnection$Metadata;", "Lcom/discord/utilities/collections/ListenerCollectionSubject;", "Lcom/discord/stores/StoreRtcConnection$Listener;", "listenerSubject", "Lcom/discord/utilities/collections/ListenerCollectionSubject;", "Lcom/discord/utilities/collections/ListenerCollection;", "listeners", "Lcom/discord/utilities/collections/ListenerCollection;", "getListeners", "()Lcom/discord/utilities/collections/ListenerCollection;", "Lcom/discord/primitives/Timestamp;", "joinedChannelTimestamp", "Ljava/lang/Long;", "hasSelectedVoiceChannel", "Z", "Lcom/discord/stores/VoicePropsTracker;", "voicePropsTracker", "Lcom/discord/stores/VoicePropsTracker;", "Lrx/subjects/BehaviorSubject;", "qualitySubject", "Lrx/subjects/BehaviorSubject;", "rtcConnectionMetadataSubject", "Lcom/discord/stores/StoreVoiceStates;", "storeVoiceStates", "Lcom/discord/stores/StoreVoiceStates;", "Lcom/discord/utilities/networking/NetworkMonitor;", "Lrx/subjects/PublishSubject;", "speakingUsersSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/utilities/logging/Logger;", "logger", "Lcom/discord/utilities/logging/Logger;", "Lcom/discord/primitives/GuildId;", "getConnectedGuildId", "()J", "connectedGuildId", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "Lcom/discord/stores/StoreAnalytics;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/time/Clock;Lcom/discord/stores/StoreRtcRegion;Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/StoreVoiceStates;Lcom/discord/utilities/logging/Logger;Lcom/discord/utilities/debug/DebugPrintableCollection;)V", "Companion", "DefaultListener", "Listener", "SpeakingUserUpdate", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreRtcConnection extends RtcConnection.b implements DebugPrintable {
    private static final long SPEAKING_UPDATES_BUFFER_MS = 300;
    private static int instanceCounter;
    private final Clock clock;
    private final Observable<RtcConnection.StateChange> connectionState;
    private final SerializedSubject<RtcConnection.StateChange, RtcConnection.StateChange> connectionStateSubject;
    private Context context;
    private Outgoing2.VoiceStateUpdate currentVoiceState;
    private final long debugDisplayId;
    private final Dispatcher dispatcher;
    private final DebugPrintable3 dpc;
    private boolean hasSelectedVoiceChannel;
    private Long joinedChannelTimestamp;
    private final ListenerCollection2<Listener> listenerSubject;
    private final ListenerCollection<Listener> listeners;
    private final Logger logger;
    private final String loggingTag;
    private NetworkMonitor networkMonitor;
    private final Observable<RtcConnection.Quality> quality;
    private final BehaviorSubject<RtcConnection.Quality> qualitySubject;
    private RtcConnection rtcConnection;
    private RtcConnection.Metadata rtcConnectionMetadata;
    private final BehaviorSubject<RtcConnection.Metadata> rtcConnectionMetadataSubject;
    private Channel selectedVoiceChannel;
    private String sessionId;
    private final Observable<List<SpeakingUserUpdate>> speakingUpdates;
    private final PublishSubject<SpeakingUserUpdate> speakingUsersSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreRtcRegion storeRtcRegion;
    private final StoreVoiceStates storeVoiceStates;
    private final StoreStream stream;
    private StoreRtcConnection2 voicePropsTracker;
    private VoiceServer voiceServer;

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00022\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/discord/stores/StoreRtcConnection$DefaultListener;", "Lcom/discord/stores/StoreRtcConnection$Listener;", "", "onConnecting", "()V", "onConnected", "onFirstFrameSent", "", "Lcom/discord/primitives/SSRC;", "ssrc", "onFirstFrameReceived", "(J)V", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class DefaultListener implements Listener {
        @Override // com.discord.stores.StoreRtcConnection.Listener
        public void onConnected() {
        }

        @Override // com.discord.stores.StoreRtcConnection.Listener
        public void onConnecting() {
        }

        @Override // com.discord.stores.StoreRtcConnection.Listener
        public void onFirstFrameReceived(long ssrc) {
        }

        @Override // com.discord.stores.StoreRtcConnection.Listener
        public void onFirstFrameSent() {
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/discord/stores/StoreRtcConnection$Listener;", "", "", "onConnecting", "()V", "onConnected", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onConnected();

        void onConnecting();

        /* synthetic */ void onFirstFrameReceived(long j);

        /* synthetic */ void onFirstFrameSent();
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\n\u0010\bR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/discord/stores/StoreRtcConnection$SpeakingUserUpdate;", "", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "", "component2", "()Z", "userId", "isSpeaking", "copy", "(JZ)Lcom/discord/stores/StoreRtcConnection$SpeakingUserUpdate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "J", "getUserId", "<init>", "(JZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SpeakingUserUpdate {
        private final boolean isSpeaking;
        private final long userId;

        public SpeakingUserUpdate(long j, boolean z2) {
            this.userId = j;
            this.isSpeaking = z2;
        }

        public static /* synthetic */ SpeakingUserUpdate copy$default(SpeakingUserUpdate speakingUserUpdate, long j, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = speakingUserUpdate.userId;
            }
            if ((i & 2) != 0) {
                z2 = speakingUserUpdate.isSpeaking;
            }
            return speakingUserUpdate.copy(j, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSpeaking() {
            return this.isSpeaking;
        }

        public final SpeakingUserUpdate copy(long userId, boolean isSpeaking) {
            return new SpeakingUserUpdate(userId, isSpeaking);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpeakingUserUpdate)) {
                return false;
            }
            SpeakingUserUpdate speakingUserUpdate = (SpeakingUserUpdate) other;
            return this.userId == speakingUserUpdate.userId && this.isSpeaking == speakingUserUpdate.isSpeaking;
        }

        public final long getUserId() {
            return this.userId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.userId) * 31;
            boolean z2 = this.isSpeaking;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iA + i;
        }

        public final boolean isSpeaking() {
            return this.isSpeaking;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SpeakingUserUpdate(userId=");
            sbU.append(this.userId);
            sbU.append(", isSpeaking=");
            return outline.O(sbU, this.isSpeaking, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            RtcConnection.AnalyticsEvent.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[RtcConnection.AnalyticsEvent.VOICE_CONNECTION_SUCCESS.ordinal()] = 1;
            iArr[RtcConnection.AnalyticsEvent.VOICE_CONNECTION_FAILURE.ordinal()] = 2;
            iArr[RtcConnection.AnalyticsEvent.VOICE_DISCONNECT.ordinal()] = 3;
            iArr[RtcConnection.AnalyticsEvent.VIDEO_STREAM_ENDED.ordinal()] = 4;
            iArr[RtcConnection.AnalyticsEvent.MEDIA_SESSION_JOINED.ordinal()] = 5;
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreRtcConnection$Listener;", "it", "", "invoke", "(Lcom/discord/stores/StoreRtcConnection$Listener;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$createRtcConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnecting();
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isMuted", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {

        /* compiled from: StoreRtcConnection.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreRtcConnection$init$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01691 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ boolean $isMuted;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01691(boolean z2) {
                super(0);
                this.$isMuted = z2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection.access$handleSelfMuted(StoreRtcConnection.this, this.$isMuted);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreRtcConnection.access$getDispatcher$p(StoreRtcConnection.this).schedule(new C01691(z2));
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isDeafened", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$init$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {

        /* compiled from: StoreRtcConnection.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreRtcConnection$init$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ boolean $isDeafened;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(boolean z2) {
                super(0);
                this.$isDeafened = z2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection.access$handleSelfDeafened(StoreRtcConnection.this, this.$isDeafened);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreRtcConnection.access$getDispatcher$p(StoreRtcConnection.this).schedule(new AnonymousClass1(z2));
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lco/discord/media_engine/VideoInputDeviceDescription;", "deviceDescription", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lco/discord/media_engine/VideoInputDeviceDescription;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$init$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<DeviceDescription4, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(DeviceDescription4 deviceDescription4) {
            return call2(deviceDescription4);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(DeviceDescription4 deviceDescription4) {
            return Boolean.valueOf(deviceDescription4 != null);
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isVideoSelected", "", "invoke", "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$init$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Boolean, Unit> {

        /* compiled from: StoreRtcConnection.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreRtcConnection$init$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Boolean $isVideoSelected;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(0);
                this.$isVideoSelected = bool;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection storeRtcConnection = StoreRtcConnection.this;
                Boolean bool = this.$isVideoSelected;
                Intrinsics3.checkNotNullExpressionValue(bool, "isVideoSelected");
                StoreRtcConnection.access$handleSelfVideo(storeRtcConnection, bool.booleanValue());
            }
        }

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            StoreRtcConnection.access$getDispatcher$p(StoreRtcConnection.this).schedule(new AnonymousClass1(bool));
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "usersVolume", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$init$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Map<Long, ? extends Float>, Unit> {

        /* compiled from: StoreRtcConnection.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreRtcConnection$init$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Map $usersVolume;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Map map) {
                super(0);
                this.$usersVolume = map;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection.access$handleUsersVolume(StoreRtcConnection.this, this.$usersVolume);
            }
        }

        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Float> map) {
            invoke2((Map<Long, Float>) map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, Float> map) {
            Intrinsics3.checkNotNullParameter(map, "usersVolume");
            StoreRtcConnection.access$getDispatcher$p(StoreRtcConnection.this).schedule(new AnonymousClass1(map));
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "usersMuted", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$init$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<Map<Long, ? extends Boolean>, Unit> {

        /* compiled from: StoreRtcConnection.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreRtcConnection$init$6$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Map $usersMuted;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Map map) {
                super(0);
                this.$usersMuted = map;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection.access$handleUsersMuted(StoreRtcConnection.this, this.$usersMuted);
            }
        }

        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Boolean> map) {
            invoke2((Map<Long, Boolean>) map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, Boolean> map) {
            Intrinsics3.checkNotNullParameter(map, "usersMuted");
            StoreRtcConnection.access$getDispatcher$p(StoreRtcConnection.this).schedule(new AnonymousClass1(map));
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "usersOffScreen", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$init$7, reason: invalid class name */
    public static final class AnonymousClass7 extends Lambda implements Function1<Map<Long, ? extends Boolean>, Unit> {

        /* compiled from: StoreRtcConnection.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreRtcConnection$init$7$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Map $usersOffScreen;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Map map) {
                super(0);
                this.$usersOffScreen = map;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection.access$handleUsersOffScreen(StoreRtcConnection.this, this.$usersOffScreen);
            }
        }

        public AnonymousClass7() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Boolean> map) {
            invoke2((Map<Long, Boolean>) map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, Boolean> map) {
            Intrinsics3.checkNotNullParameter(map, "usersOffScreen");
            StoreRtcConnection.access$getDispatcher$p(StoreRtcConnection.this).schedule(new AnonymousClass1(map));
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$onAnalyticsEvent$1, reason: invalid class name */
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
            StoreRtcConnection.access$getStoreAnalytics$p(StoreRtcConnection.this).trackVideoStreamEnded(this.$properties);
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreRtcConnection$Listener;", "it", "", "invoke", "(Lcom/discord/stores/StoreRtcConnection$Listener;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$onFirstFrameReceived$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public final /* synthetic */ long $ssrc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$ssrc = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onFirstFrameReceived(this.$ssrc);
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreRtcConnection$Listener;", "it", "", "invoke", "(Lcom/discord/stores/StoreRtcConnection$Listener;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$onFirstFrameSent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onFirstFrameSent();
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$onMediaEngineConnectionConnected$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RtcConnection $connection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RtcConnection rtcConnection) {
            super(0);
            this.$connection = rtcConnection;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreRtcConnection.applyVoiceConfiguration$default(StoreRtcConnection.this, this.$connection, null, 2, null);
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$onMediaSessionIdReceived$1, reason: invalid class name */
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
            StoreRtcConnection.access$handleMediaSessionIdReceived(StoreRtcConnection.this);
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$onSpeaking$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isSpeaking;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, boolean z2) {
            super(0);
            this.$userId = j;
            this.$isSpeaking = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreRtcConnection2 storeRtcConnection2Access$getVoicePropsTracker$p = StoreRtcConnection.access$getVoicePropsTracker$p(StoreRtcConnection.this);
            if (storeRtcConnection2Access$getVoicePropsTracker$p != null) {
                storeRtcConnection2Access$getVoicePropsTracker$p.handleOnSpeaking(this.$userId, this.$isSpeaking);
            }
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreRtcConnection$Listener;", "it", "", "invoke", "(Lcom/discord/stores/StoreRtcConnection$Listener;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$onStateChange$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnected();
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$onVideoMetadata$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VideoMetadata $metadata;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(VideoMetadata videoMetadata) {
            super(0);
            this.$metadata = videoMetadata;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreRtcConnection.access$getStream$p(StoreRtcConnection.this).handleVideoMetadataUpdate(this.$metadata);
        }
    }

    /* compiled from: StoreRtcConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRtcConnection$onVideoStream$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int $audioSsrc;
        public final /* synthetic */ int $rtxSsrc;
        public final /* synthetic */ Integer $streamId;
        public final /* synthetic */ long $userId;
        public final /* synthetic */ int $videoSsrc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Integer num, int i, int i2, int i3) {
            super(0);
            this.$userId = j;
            this.$streamId = num;
            this.$audioSsrc = i;
            this.$videoSsrc = i2;
            this.$rtxSsrc = i3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreRtcConnection.access$getStream$p(StoreRtcConnection.this).handleVideoStreamUpdate(this.$userId, this.$streamId, this.$audioSsrc, this.$videoSsrc, this.$rtxSsrc);
        }
    }

    public /* synthetic */ StoreRtcConnection(StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreRtcRegion storeRtcRegion, StoreAnalytics storeAnalytics, StoreVoiceStates storeVoiceStates, Logger logger, DebugPrintable3 debugPrintable3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, clock, storeRtcRegion, storeAnalytics, storeVoiceStates, (i & 64) != 0 ? AppLog.g : logger, (i & 128) != 0 ? SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease() : debugPrintable3);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreRtcConnection storeRtcConnection) {
        return storeRtcConnection.dispatcher;
    }

    public static final /* synthetic */ StoreAnalytics access$getStoreAnalytics$p(StoreRtcConnection storeRtcConnection) {
        return storeRtcConnection.storeAnalytics;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreRtcConnection storeRtcConnection) {
        return storeRtcConnection.stream;
    }

    public static final /* synthetic */ StoreRtcConnection2 access$getVoicePropsTracker$p(StoreRtcConnection storeRtcConnection) {
        return storeRtcConnection.voicePropsTracker;
    }

    public static final /* synthetic */ void access$handleMediaSessionIdReceived(StoreRtcConnection storeRtcConnection) {
        storeRtcConnection.handleMediaSessionIdReceived();
    }

    public static final /* synthetic */ void access$handleSelfDeafened(StoreRtcConnection storeRtcConnection, boolean z2) {
        storeRtcConnection.handleSelfDeafened(z2);
    }

    public static final /* synthetic */ void access$handleSelfMuted(StoreRtcConnection storeRtcConnection, boolean z2) {
        storeRtcConnection.handleSelfMuted(z2);
    }

    public static final /* synthetic */ void access$handleSelfVideo(StoreRtcConnection storeRtcConnection, boolean z2) {
        storeRtcConnection.handleSelfVideo(z2);
    }

    public static final /* synthetic */ void access$handleUsersMuted(StoreRtcConnection storeRtcConnection, Map map) {
        storeRtcConnection.handleUsersMuted(map);
    }

    public static final /* synthetic */ void access$handleUsersOffScreen(StoreRtcConnection storeRtcConnection, Map map) {
        storeRtcConnection.handleUsersOffScreen(map);
    }

    public static final /* synthetic */ void access$handleUsersVolume(StoreRtcConnection storeRtcConnection, Map map) {
        storeRtcConnection.handleUsersVolume(map);
    }

    public static final /* synthetic */ void access$setVoicePropsTracker$p(StoreRtcConnection storeRtcConnection, StoreRtcConnection2 storeRtcConnection2) {
        storeRtcConnection.voicePropsTracker = storeRtcConnection2;
    }

    private final void applyVoiceConfiguration(RtcConnection rtcConnection, Long targetUserId) {
        StoreMediaSettings.VoiceConfiguration voiceConfigurationBlocking = this.stream.getMediaSettings().getVoiceConfigurationBlocking();
        for (Map.Entry<Long, Float> entry : voiceConfigurationBlocking.getUserOutputVolumes().entrySet()) {
            long jLongValue = entry.getKey().longValue();
            float fFloatValue = entry.getValue().floatValue();
            if (targetUserId == null || jLongValue == targetUserId.longValue()) {
                rtcConnection.v(jLongValue, fFloatValue);
            }
        }
        for (Map.Entry<Long, Boolean> entry2 : voiceConfigurationBlocking.getMutedUsers().entrySet()) {
            long jLongValue2 = entry2.getKey().longValue();
            boolean zBooleanValue = entry2.getValue().booleanValue();
            if (targetUserId == null || jLongValue2 == targetUserId.longValue()) {
                rtcConnection.mutedUsers.put(Long.valueOf(jLongValue2), Boolean.valueOf(zBooleanValue));
                MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection != null) {
                    mediaEngineConnection.w(jLongValue2, zBooleanValue);
                }
            }
        }
        for (Map.Entry<Long, Boolean> entry3 : voiceConfigurationBlocking.getOffScreenUsers().entrySet()) {
            long jLongValue3 = entry3.getKey().longValue();
            boolean zBooleanValue2 = entry3.getValue().booleanValue();
            if (targetUserId == null || jLongValue3 == targetUserId.longValue()) {
                MediaEngineConnection mediaEngineConnection2 = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection2 == null) {
                    Log.e("RtcConnection", "MediaEngine not connected for setLocalVideoOffscreen.");
                } else {
                    mediaEngineConnection2.d(jLongValue3, zBooleanValue2);
                }
            }
        }
    }

    public static /* synthetic */ void applyVoiceConfiguration$default(StoreRtcConnection storeRtcConnection, RtcConnection rtcConnection, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        storeRtcConnection.applyVoiceConfiguration(rtcConnection, l);
    }

    @Store3
    private final void checkForVoiceServerUpdate() {
        String endpoint;
        RtcConnection rtcConnection = this.rtcConnection;
        VoiceServer voiceServer = this.voiceServer;
        if (rtcConnection == null || voiceServer == null) {
            return;
        }
        if (voiceServer.getGuildId() == null || !(!Intrinsics3.areEqual(voiceServer.getGuildId(), rtcConnection.guildId))) {
            if (voiceServer.getChannelId() != null) {
                Long channelId = voiceServer.getChannelId();
                long j = rtcConnection.channelId;
                if (channelId == null || channelId.longValue() != j) {
                    return;
                }
            }
            Objects.requireNonNull(App.INSTANCE);
            SSLSocketFactory sSLSocketFactoryCreateSocketFactory$default = null;
            if (App.access$getIS_LOCAL$cp()) {
                endpoint = "";
            } else {
                endpoint = voiceServer.getEndpoint();
                sSLSocketFactoryCreateSocketFactory$default = SecureSocketsLayerUtils.createSocketFactory$default(null, 1, null);
            }
            recordBreadcrumb(outline.w("Voice server update, connect to server w/ endpoint: ", endpoint));
            rtcConnection.s(new w(rtcConnection, endpoint, voiceServer.getToken(), sSLSocketFactoryCreateSocketFactory$default));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void createRtcConnection() {
        Long l;
        long id2 = this.stream.getUsers().getMe().getId();
        String str = this.sessionId;
        Channel channel = this.selectedVoiceChannel;
        if (channel != null) {
            Long lValueOf = Long.valueOf(channel.getGuildId());
            l = (lValueOf.longValue() > 0L ? 1 : (lValueOf.longValue() == 0L ? 0 : -1)) > 0 ? lValueOf : null;
        }
        Channel channel2 = this.selectedVoiceChannel;
        Long lValueOf2 = channel2 != null ? Long.valueOf(channel2.getId()) : null;
        MediaEngine mediaEngine = StoreStream.INSTANCE.getMediaEngine().getMediaEngine();
        if (str == null || lValueOf2 == null) {
            return;
        }
        RtcConnection rtcConnection = this.rtcConnection;
        if (Intrinsics3.areEqual(rtcConnection != null ? Long.valueOf(rtcConnection.channelId) : null, lValueOf2)) {
            RtcConnection rtcConnection2 = this.rtcConnection;
            if (Intrinsics3.areEqual(rtcConnection2 != null ? rtcConnection2.sessionId : null, str)) {
                return;
            }
        }
        long jLongValue = l != null ? l.longValue() : 0L;
        this.voicePropsTracker = new StoreRtcConnection2(jLongValue, lValueOf2.longValue(), id2, this.storeVoiceStates.get().get(Long.valueOf(jLongValue)));
        Experiment userExperiment = this.stream.getExperiments().getUserExperiment("2021-03_android_media_sink_wants", false);
        boolean z2 = userExperiment != null && userExperiment.getBucket() == 1;
        RtcConnection rtcConnection3 = this.rtcConnection;
        if (rtcConnection3 != null) {
            rtcConnection3.e();
        }
        long jLongValue2 = lValueOf2.longValue();
        String strValueOf = String.valueOf(l != null ? l.longValue() : lValueOf2.longValue());
        Logger logger = this.logger;
        String str2 = this.loggingTag;
        NetworkMonitor networkMonitor = this.networkMonitor;
        if (networkMonitor == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("networkMonitor");
        }
        RtcConnection rtcConnection4 = new RtcConnection(l, jLongValue2, str, true, strValueOf, id2, mediaEngine, logger, ClockFactory.get(), null, networkMonitor, Maps6.toMutableMap(this.stream.getMediaSettings().getMutedUsers()), null, null, z2, str2, null, 78336);
        rtcConnection4.c(this);
        this.rtcConnection = rtcConnection4;
        this.listenerSubject.notify(AnonymousClass1.INSTANCE);
        updateMetadata();
    }

    @Store3
    private final void destroyRtcConnection(String reason) {
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection != null) {
            recordBreadcrumb(outline.w("destroying rtc connection: ", reason));
            rtcConnection.e();
            this.rtcConnection = null;
            updateMetadata();
        }
    }

    @Store3
    private final void handleMediaSessionIdReceived() {
        AppLog appLog = AppLog.g;
        RtcConnection rtcConnection = this.rtcConnection;
        String str = rtcConnection != null ? rtcConnection.mediaSessionId : null;
        Objects.requireNonNull(appLog);
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        if (str == null) {
            str = "";
        }
        firebaseCrashlytics.setCustomKey("mediaSessionId", str);
        updateMetadata();
    }

    @Store3
    private final void handleSelfDeafened(boolean selfDeafened) {
        this.currentVoiceState = Outgoing2.VoiceStateUpdate.copy$default(this.currentVoiceState, null, null, false, selfDeafened, false, null, 55, null);
        onVoiceStateUpdated();
    }

    @Store3
    private final void handleSelfMuted(boolean selfMuted) {
        this.currentVoiceState = Outgoing2.VoiceStateUpdate.copy$default(this.currentVoiceState, null, null, selfMuted, false, false, null, 59, null);
        onVoiceStateUpdated();
    }

    @Store3
    private final void handleSelfVideo(boolean selfVideo) {
        this.currentVoiceState = Outgoing2.VoiceStateUpdate.copy$default(this.currentVoiceState, null, null, false, false, selfVideo, null, 47, null);
        onVoiceStateUpdated();
    }

    @Store3
    private final void handleUsersMuted(Map<Long, Boolean> usersMuted) {
        for (Map.Entry<Long, Boolean> entry : usersMuted.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            boolean zBooleanValue = entry.getValue().booleanValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                rtcConnection.mutedUsers.put(Long.valueOf(jLongValue), Boolean.valueOf(zBooleanValue));
                MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection != null) {
                    mediaEngineConnection.w(jLongValue, zBooleanValue);
                }
            }
        }
    }

    @Store3
    private final void handleUsersOffScreen(Map<Long, Boolean> usersOffScreen) {
        for (Map.Entry<Long, Boolean> entry : usersOffScreen.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            boolean zBooleanValue = entry.getValue().booleanValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection == null) {
                    Log.e("RtcConnection", "MediaEngine not connected for setLocalVideoOffscreen.");
                } else {
                    mediaEngineConnection.d(jLongValue, zBooleanValue);
                }
            }
        }
    }

    @Store3
    private final void handleUsersVolume(Map<Long, Float> usersVolume) {
        for (Map.Entry<Long, Float> entry : usersVolume.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            float fFloatValue = entry.getValue().floatValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                rtcConnection.v(jLongValue, fFloatValue);
            }
        }
    }

    @Store3
    private final void logChannelJoin(Channel channel) {
        String str;
        long id2 = this.stream.getUsers().getMe().getId();
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (str = rtcConnection.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String) == null) {
            return;
        }
        StageInstance stageInstanceForChannel = this.stream.getStageInstances().getStageInstanceForChannel(channel.getId());
        Long lValueOf = stageInstanceForChannel != null ? Long.valueOf(stageInstanceForChannel.getId()) : null;
        GuildScheduledEvent activeEventForChannel = this.stream.getGuildScheduledEvents().getActiveEventForChannel(Long.valueOf(channel.getGuildId()), Long.valueOf(channel.getId()));
        Long lValueOf2 = activeEventForChannel != null ? Long.valueOf(activeEventForChannel.getId()) : null;
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        Map<Long, VoiceState> mapEmptyMap = (Map) outline.c(channel, this.stream.getVoiceStates().get());
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        Map<Long, VoiceState> map = mapEmptyMap;
        DeviceDescription4 selectedVideoInputDevice = this.stream.getMediaEngine().getSelectedVideoInputDevice();
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Context context = this.context;
        if (context == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("context");
        }
        analyticsTracker.voiceChannelJoin(id2, str, channel, map, selectedVideoInputDevice, networkUtils.getNetworkType(context), lValueOf, lValueOf2);
    }

    @Store3
    private final void logChannelLeave(Channel channel) {
        String str;
        long id2 = this.stream.getUsers().getMe().getId();
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (str = rtcConnection.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String) == null) {
            return;
        }
        String str2 = rtcConnection != null ? rtcConnection.mediaSessionId : null;
        StageInstance stageInstanceForChannel = this.stream.getStageInstances().getStageInstanceForChannel(channel.getId());
        Long lValueOf = stageInstanceForChannel != null ? Long.valueOf(stageInstanceForChannel.getId()) : null;
        GuildScheduledEvent activeEventForChannel = this.stream.getGuildScheduledEvents().getActiveEventForChannel(Long.valueOf(channel.getGuildId()), Long.valueOf(channel.getId()));
        Long lValueOf2 = activeEventForChannel != null ? Long.valueOf(activeEventForChannel.getId()) : null;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        StoreRtcConnection2 storeRtcConnection2 = this.voicePropsTracker;
        if (storeRtcConnection2 != null) {
            storeRtcConnection2.getProps(linkedHashMap);
        }
        this.voicePropsTracker = null;
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        Map<Long, VoiceState> mapEmptyMap = (Map) outline.c(channel, this.stream.getVoiceStates().get());
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        Map<Long, VoiceState> map = mapEmptyMap;
        Long l = this.joinedChannelTimestamp;
        analyticsTracker.voiceChannelLeave(id2, str, channel, map, str2, linkedHashMap, l != null ? Long.valueOf(this.clock.currentTimeMillis() - l.longValue()) : null, lValueOf, lValueOf2);
    }

    private final void loge(String msg, Throwable e, Map<String, String> metadata) {
        this.logger.e(this.loggingTag, msg, e, metadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loge$default(StoreRtcConnection storeRtcConnection, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        storeRtcConnection.loge(str, th, map);
    }

    private final void logi(String msg, Throwable e) {
        this.logger.i(this.loggingTag, msg, e);
    }

    public static /* synthetic */ void logi$default(StoreRtcConnection storeRtcConnection, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        storeRtcConnection.logi(str, th);
    }

    private final void logw(String msg) {
        Logger.w$default(this.logger, this.loggingTag, msg, null, 4, null);
    }

    @Store3
    private final void onVoiceStateUpdated() {
        String preferredRegion;
        if (this.hasSelectedVoiceChannel) {
            StringBuilder sbU = outline.U("Voice state update: ");
            sbU.append(this.currentVoiceState);
            recordBreadcrumb(sbU.toString());
        }
        StoreGatewayConnection gatewaySocket = StoreStream.INSTANCE.getGatewaySocket();
        Long guildId = this.currentVoiceState.getGuildId();
        Long channelId = this.currentVoiceState.getChannelId();
        boolean selfMute = this.currentVoiceState.getSelfMute();
        boolean selfDeaf = this.currentVoiceState.getSelfDeaf();
        boolean selfVideo = this.currentVoiceState.getSelfVideo();
        Long channelId2 = this.currentVoiceState.getChannelId();
        if (channelId2 != null) {
            channelId2.longValue();
            preferredRegion = this.storeRtcRegion.getPreferredRegion();
        } else {
            preferredRegion = null;
        }
        gatewaySocket.voiceStateUpdate(guildId, channelId, selfMute, selfDeaf, selfVideo, preferredRegion, this.storeRtcRegion.shouldIncludePreferredRegion(this.currentVoiceState.getGuildId()));
    }

    private final void recordBreadcrumb(String message) {
        this.logger.recordBreadcrumb(message, this.loggingTag);
    }

    @Store3
    private final void updateMetadata() {
        RtcConnection rtcConnection = this.rtcConnection;
        RtcConnection.Metadata metadataI = rtcConnection != null ? rtcConnection.i() : null;
        this.rtcConnectionMetadata = metadataI;
        this.rtcConnectionMetadataSubject.onNext(metadataI);
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintable2 dp) {
        Intrinsics3.checkNotNullParameter(dp, "dp");
        dp.appendKeyValue("sessionId", this.sessionId);
        dp.appendKeyValue("rtcConnection", (DebugPrintable) this.rtcConnection);
    }

    public final void finalize() {
        this.dpc.remove(this.debugDisplayId);
    }

    public final long getConnectedGuildId() {
        Long l;
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (l = rtcConnection.guildId) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final Observable<RtcConnection.StateChange> getConnectionState() {
        return this.connectionState;
    }

    public final ListenerCollection<Listener> getListeners() {
        return this.listeners;
    }

    public final Observable<RtcConnection.Quality> getQuality() {
        return this.quality;
    }

    /* renamed from: getRtcConnection$app_productionGoogleRelease, reason: from getter */
    public final RtcConnection getRtcConnection() {
        return this.rtcConnection;
    }

    @Store3
    public final RtcConnection.Metadata getRtcConnectionMetadata() {
        return this.rtcConnectionMetadata;
    }

    public final Observable<List<SpeakingUserUpdate>> getSpeakingUpdates() {
        return this.speakingUpdates;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection != null) {
            String sessionId = payload.getSessionId();
            Intrinsics3.checkNotNullExpressionValue(sessionId, "payload.sessionId");
            Intrinsics3.checkNotNullParameter(sessionId, "<set-?>");
            rtcConnection.sessionId = sessionId;
        }
    }

    @Store3
    public final void handleConnectionReady(boolean connected) {
        if (connected) {
            Channel channel = this.selectedVoiceChannel;
            handleVoiceChannelSelected(Long.valueOf(channel != null ? channel.getId() : 0L));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleVoiceChannelSelected(Long channelId) {
        Long l;
        if (!Intrinsics3.areEqual(channelId, this.selectedVoiceChannel != null ? Long.valueOf(r0.getId()) : null)) {
            Channel channel = this.selectedVoiceChannel;
            if (channel != null) {
                logChannelLeave(channel);
            }
            this.joinedChannelTimestamp = null;
            StringBuilder sb = new StringBuilder();
            sb.append("Channel ID changed, ");
            sb.append(channelId);
            sb.append(" != ");
            Channel channel2 = this.selectedVoiceChannel;
            sb.append(channel2 != null ? Long.valueOf(channel2.getId()) : null);
            destroyRtcConnection(sb.toString());
        }
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = channelId != null ? this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId.longValue()) : null;
        this.selectedVoiceChannel = channelFindChannelByIdInternal$app_productionGoogleRelease;
        Outgoing2.VoiceStateUpdate voiceStateUpdate = this.currentVoiceState;
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            Long lValueOf = Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId());
            l = (lValueOf.longValue() > 0L ? 1 : (lValueOf.longValue() == 0L ? 0 : -1)) > 0 ? lValueOf : null;
        }
        this.currentVoiceState = Outgoing2.VoiceStateUpdate.copy$default(voiceStateUpdate, l, channelFindChannelByIdInternal$app_productionGoogleRelease != null ? Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getId()) : null, false, false, false, null, 60, null);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            this.hasSelectedVoiceChannel = true;
            createRtcConnection();
            this.joinedChannelTimestamp = Long.valueOf(this.clock.currentTimeMillis());
            logChannelJoin(channelFindChannelByIdInternal$app_productionGoogleRelease);
        } else {
            this.voiceServer = null;
        }
        onVoiceStateUpdated();
    }

    @Store3
    public final void handleVoiceServerUpdate(VoiceServer voiceServer) {
        Intrinsics3.checkNotNullParameter(voiceServer, "voiceServer");
        recordBreadcrumb("handling voice server update: " + voiceServer);
        this.voiceServer = voiceServer;
        checkForVoiceServerUpdate();
    }

    @Store3
    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        StoreRtcConnection2 storeRtcConnection2 = this.voicePropsTracker;
        if (storeRtcConnection2 != null) {
            storeRtcConnection2.handleVoiceStateUpdate(voiceState);
        }
    }

    @Store3
    public final void init(Context context, NetworkMonitor networkMonitor) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(networkMonitor, "networkMonitor");
        this.context = context;
        this.networkMonitor = networkMonitor;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        ObservableExtensionsKt.appSubscribe$default(companion.getMediaSettings().isSelfMuted(), StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(companion.getMediaSettings().isSelfDeafened(), StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        Observable<R> observableG = companion.getMediaEngine().getSelectedVideoInputDevice().G(AnonymousClass3.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…viceDescription != null }");
        ObservableExtensionsKt.appSubscribe$default(observableG, StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMediaSettings().getUsersVolume(), StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMediaSettings().getUsersMuted(), StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass6(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMediaSettings().getUsersOffScreen(), StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass7(), 62, (Object) null);
    }

    public final Observable<RtcConnection.Metadata> observeRtcConnectionMetadata() {
        BehaviorSubject<RtcConnection.Metadata> behaviorSubject = this.rtcConnectionMetadataSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "rtcConnectionMetadataSubject");
        return behaviorSubject;
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onAnalyticsEvent(RtcConnection.AnalyticsEvent event, Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(event, "event");
        Intrinsics3.checkNotNullParameter(properties, "properties");
        int iOrdinal = event.ordinal();
        if (iOrdinal == 0) {
            this.storeAnalytics.trackVoiceConnectionSuccess(properties);
            return;
        }
        if (iOrdinal == 1) {
            this.storeAnalytics.trackVoiceConnectionFailure(properties);
            return;
        }
        if (iOrdinal == 2) {
            this.storeAnalytics.trackVoiceDisconnect(properties);
        } else if (iOrdinal == 3) {
            this.dispatcher.schedule(new AnonymousClass1(properties));
        } else {
            if (iOrdinal != 4) {
                return;
            }
            this.storeAnalytics.trackMediaSessionJoined(properties);
        }
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onFatalClose() {
        this.stream.getVoiceChannelSelected().clear();
    }

    @Override // com.discord.rtcconnection.RtcConnection.b
    public void onFirstFrameReceived(long ssrc) {
        this.listenerSubject.notify(new AnonymousClass1(ssrc));
    }

    @Override // com.discord.rtcconnection.RtcConnection.b
    public void onFirstFrameSent() {
        this.listenerSubject.notify(AnonymousClass1.INSTANCE);
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onMediaEngineConnectionConnected(RtcConnection connection) {
        Intrinsics3.checkNotNullParameter(connection, "connection");
        this.dispatcher.schedule(new AnonymousClass1(connection));
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onMediaSessionIdReceived() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onQualityUpdate(RtcConnection.Quality quality) {
        Intrinsics3.checkNotNullParameter(quality, "quality");
        this.qualitySubject.onNext(quality);
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onSpeaking(long userId, boolean isSpeaking) {
        PublishSubject<SpeakingUserUpdate> publishSubject = this.speakingUsersSubject;
        publishSubject.k.onNext(new SpeakingUserUpdate(userId, isSpeaking));
        this.dispatcher.schedule(new AnonymousClass1(userId, isSpeaking));
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onStateChange(RtcConnection.StateChange stateChange) {
        Intrinsics3.checkNotNullParameter(stateChange, "stateChange");
        recordBreadcrumb("connection state change: " + stateChange);
        this.connectionStateSubject.k.onNext(stateChange);
        if (Intrinsics3.areEqual(stateChange.state, RtcConnection.State.f.a)) {
            this.listenerSubject.notify(AnonymousClass1.INSTANCE);
        }
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onUserCreated(RtcConnection connection, long userId) {
        Intrinsics3.checkNotNullParameter(connection, "connection");
        applyVoiceConfiguration(connection, Long.valueOf(userId));
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onVideoMetadata(VideoMetadata metadata) {
        Intrinsics3.checkNotNullParameter(metadata, "metadata");
        this.dispatcher.schedule(new AnonymousClass1(metadata));
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onVideoStream(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
        this.dispatcher.schedule(new AnonymousClass1(userId, streamId, audioSsrc, videoSsrc, rtxSsrc));
    }

    public StoreRtcConnection(StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreRtcRegion storeRtcRegion, StoreAnalytics storeAnalytics, StoreVoiceStates storeVoiceStates, Logger logger, DebugPrintable3 debugPrintable3) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeRtcRegion, "storeRtcRegion");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "storeVoiceStates");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(debugPrintable3, "dpc");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.storeRtcRegion = storeRtcRegion;
        this.storeAnalytics = storeAnalytics;
        this.storeVoiceStates = storeVoiceStates;
        this.logger = logger;
        this.dpc = debugPrintable3;
        ListenerCollection2<Listener> listenerCollection2 = new ListenerCollection2<>();
        this.listenerSubject = listenerCollection2;
        this.listeners = listenerCollection2;
        PublishSubject<SpeakingUserUpdate> publishSubjectK0 = PublishSubject.k0();
        this.speakingUsersSubject = publishSubjectK0;
        BehaviorSubject<RtcConnection.Quality> behaviorSubjectL0 = BehaviorSubject.l0(RtcConnection.Quality.UNKNOWN);
        this.qualitySubject = behaviorSubjectL0;
        this.currentVoiceState = new Outgoing2.VoiceStateUpdate(null, null, false, false, false, null, 32, null);
        SerializedSubject<RtcConnection.StateChange, RtcConnection.StateChange> serializedSubject = new SerializedSubject<>(BehaviorSubject.l0(new RtcConnection.StateChange(new RtcConnection.State.d(false), null)));
        this.connectionStateSubject = serializedSubject;
        this.rtcConnectionMetadataSubject = BehaviorSubject.l0(null);
        Observable<RtcConnection.StateChange> observableR = ObservableExtensionsKt.computationLatest(serializedSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "connectionStateSubject\n …  .distinctUntilChanged()");
        this.connectionState = observableR;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "qualitySubject");
        Observable<RtcConnection.Quality> observableR2 = ObservableExtensionsKt.computationLatest(behaviorSubjectL0).r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "qualitySubject\n         …  .distinctUntilChanged()");
        this.quality = observableR2;
        Observable<List<SpeakingUserUpdate>> observableA = publishSubjectK0.a(300L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableA, "speakingUsersSubject\n   …S, TimeUnit.MILLISECONDS)");
        Observable<List<SpeakingUserUpdate>> observableR3 = ObservableExtensionsKt.computationLatest(observableA).r();
        Intrinsics3.checkNotNullExpressionValue(observableR3, "speakingUsersSubject\n   …  .distinctUntilChanged()");
        this.speakingUpdates = observableR3;
        StringBuilder sbU = outline.U("StoreRtcConnection ");
        int i = instanceCounter + 1;
        instanceCounter = i;
        sbU.append(i);
        String string = sbU.toString();
        this.loggingTag = string;
        this.debugDisplayId = debugPrintable3.add(this, string);
    }
}
