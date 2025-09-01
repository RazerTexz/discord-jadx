package com.discord.rtcconnection;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.a.q.MediaEngineExecutorService;
import b.a.q.MediaSinkWantsLadder3;
import b.a.q.MediaSinkWantsManager2;
import b.a.q.MediaSinkWantsManager5;
import b.a.q.a0;
import b.a.q.b0;
import b.a.q.f0;
import b.a.q.g0;
import b.a.q.h0;
import b.a.q.n0.RtcControlSocket;
import b.a.q.o0.RtcStatsCollector4;
import b.a.q.o0.VideoQuality;
import b.a.q.p;
import b.a.q.q;
import b.a.q.r;
import b.a.q.x;
import b.a.q.z;
import b.d.b.a.outline;
import co.discord.media_engine.InboundRtpAudio;
import co.discord.media_engine.OutboundRtpAudio;
import co.discord.media_engine.Stats;
import co.discord.media_engine.VoiceQuality;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.debug.DebugPrintable2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.time.Clock;
import d0.Tuples;
import d0.a0.MathJVM;
import d0.g0.StringNumberConversions;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* compiled from: RtcConnection.kt */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ñ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0003O¯\u0001\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u000eÚ\u0001N.?Û\u0001Ü\u0001\rÝ\u0001Þ\u0001J=\u0010\r\u001a\u00020\f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u00072\n\u0010\t\u001a\u00060\u0004j\u0002`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010 \u001a\u00020\f2\n\u0010\u001d\u001a\u00060\u0004j\u0002`\u00052\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u001eH\u0002¢\u0006\u0004\b \u0010!J1\u0010\"\u001a\u00020\f2\n\u0010\u001d\u001a\u00060\u0004j\u0002`\u00052\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH\u0002¢\u0006\u0004\b\"\u0010!J1\u0010#\u001a\u00020\f2\n\u0010\u001d\u001a\u00060\u0004j\u0002`\u00052\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH\u0002¢\u0006\u0004\b#\u0010!J\u001b\u0010$\u001a\u00020\u00192\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b$\u0010%J\u001b\u0010'\u001a\u00020&2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b'\u0010(J+\u0010,\u001a\u00020\f2\u0006\u0010*\u001a\u00020)2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030+H\u0002¢\u0006\u0004\b,\u0010-J+\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030+*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030+H\u0002¢\u0006\u0004\b.\u0010/J\u001d\u00102\u001a\u00020\f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\f00H\u0003¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\f2\u0006\u00104\u001a\u00020\u000fH\u0002¢\u0006\u0004\b5\u0010\u0012J\u0017\u00108\u001a\u00020\f2\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\r\u0010;\u001a\u00020:¢\u0006\u0004\b;\u0010<J\u0015\u0010?\u001a\u00020\f2\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\f¢\u0006\u0004\bA\u0010\u0014J!\u0010C\u001a\u00020\f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010B\u001a\u00020&¢\u0006\u0004\bC\u0010DJ#\u0010I\u001a\u00020\f2\b\u0010F\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bK\u0010LJ=\u0010N\u001a\u00020\f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u00072\n\u0010M\u001a\u00060\u0004j\u0002`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\bN\u0010\u000eR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u001d\u0010`\u001a\u00060\u0004j\u0002`[8\u0006@\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\"\u0010j\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0019\u0010n\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010k\u001a\u0004\bl\u0010mR\u001a\u0010\t\u001a\u00060\u0004j\u0002`\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010]R\u001e\u0010s\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010t\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010kR\u001c\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00040u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010vR\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010]R!\u0010}\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`y8\u0006@\u0006¢\u0006\f\n\u0004\bz\u0010r\u001a\u0004\b{\u0010|R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010\u007fR\u001a\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0087\u0001\u001a\u00030\u0085\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0013\u0010\u0086\u0001R\u001a\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010kR\u0018\u0010\u008b\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010kR)\u0010\u008e\u0001\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00190+8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R(\u0010\u008f\u0001\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020&0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\be\u0010\u008d\u0001R\u0019\u0010\u0092\u0001\u001a\u00030\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b2\u0010\u0091\u0001R \u0010\u0094\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`p8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010rR\u0017\u0010\u0095\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010eR\u001a\u0010\u0097\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0083\u0001R&\u0010\u009b\u0001\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010k\u001a\u0005\b\u0099\u0001\u0010m\"\u0005\b\u009a\u0001\u0010\u0012R \u0010\u009d\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`p8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010rR\u001f\u0010 \u0001\u001a\t\u0012\u0004\u0012\u00020=0\u009e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001b\u0010\u009f\u0001R\u0018\u0010¢\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b¡\u0001\u0010eR\u001c\u0010¥\u0001\u001a\u00020\u000f8\u0006@\u0006¢\u0006\u000e\n\u0005\b£\u0001\u0010k\u001a\u0005\b¤\u0001\u0010mR\u001a\u0010©\u0001\u001a\u00030¦\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u0018\u0010«\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bª\u0001\u0010eR\u001c\u0010®\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u001a\u0010²\u0001\u001a\u00030¯\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001RE\u0010¶\u0001\u001a/\u0012\u000f\u0012\r ´\u0001*\u0005\u0018\u00010\u0090\u00010\u0090\u0001 ´\u0001*\u0016\u0012\u000f\u0012\r ´\u0001*\u0005\u0018\u00010\u0090\u00010\u0090\u0001\u0018\u00010³\u00010³\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bI\u0010µ\u0001R\u001c\u0010º\u0001\u001a\u0005\u0018\u00010·\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0017\u0010»\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010eR\u001a\u0010¿\u0001\u001a\u00030¼\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001c\u0010Ã\u0001\u001a\u0005\u0018\u00010À\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R!\u0010Æ\u0001\u001a\u000b\u0018\u00010\u000fj\u0005\u0018\u0001`Ä\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÅ\u0001\u0010kR\u001b\u0010É\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bK\u0010È\u0001R\u001a\u0010Ê\u0001\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010cR\u001a\u0010Ì\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bË\u0001\u0010kR:\u0010Ñ\u0001\u001a\u000b\u0018\u00010\u000fj\u0005\u0018\u0001`Í\u00012\u0010\u0010Î\u0001\u001a\u000b\u0018\u00010\u000fj\u0005\u0018\u0001`Í\u00018\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\bÏ\u0001\u0010k\u001a\u0005\bÐ\u0001\u0010mR\u001a\u0010Õ\u0001\u001a\u00030Ò\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u001a\u0010Ù\u0001\u001a\u00030Ö\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001¨\u0006ß\u0001"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection;", "Lcom/discord/utilities/debug/DebugPrintable;", "Lcom/discord/rtcconnection/MediaSinkWantsManager$a;", "", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/primitives/SSRC;", "audioSsrc", "videoSsrc", "Lcom/discord/rtcconnection/VideoMetadata;", "metadata", "", "d", "(JJJLcom/discord/rtcconnection/VideoMetadata;)V", "", ModelAuditLogEntry.CHANGE_KEY_REASON, "f", "(Ljava/lang/String;)V", "q", "()V", "Lcom/discord/rtcconnection/RtcConnection$State;", "state", "u", "(Lcom/discord/rtcconnection/RtcConnection$State;)V", "", "willReconnect", "n", "(ZLjava/lang/String;)V", "senderId", "", "properties", "k", "(JLjava/util/Map;)V", "l", "m", "g", "(J)Z", "", "h", "(J)F", "Lcom/discord/rtcconnection/RtcConnection$AnalyticsEvent;", "event", "", "p", "(Lcom/discord/rtcconnection/RtcConnection$AnalyticsEvent;Ljava/util/Map;)V", "b", "(Ljava/util/Map;)Ljava/util/Map;", "Lkotlin/Function0;", "action", "s", "(Lkotlin/jvm/functions/Function0;)V", "message", "r", "Lcom/discord/utilities/debug/DebugPrintBuilder;", "dp", "debugPrint", "(Lcom/discord/utilities/debug/DebugPrintBuilder;)V", "Lcom/discord/rtcconnection/RtcConnection$Metadata;", "i", "()Lcom/discord/rtcconnection/RtcConnection$Metadata;", "Lcom/discord/rtcconnection/RtcConnection$c;", "listener", "c", "(Lcom/discord/rtcconnection/RtcConnection$c;)V", "e", "volume", "v", "(JF)V", "Landroid/content/Intent;", "intent", "Lcom/discord/rtcconnection/mediaengine/ThumbnailEmitter;", "thumbnailEmitter", "t", "(Landroid/content/Intent;Lcom/discord/rtcconnection/mediaengine/ThumbnailEmitter;)V", "w", "(Ljava/lang/Long;)V", "videoSSRC", "a", "b/a/q/b0", "N", "Lb/a/q/b0;", "mediaEngineConnectionListener", "Lb/a/q/o0/d;", "o", "Lb/a/q/o0/d;", "rtcStatsCollector", "Lb/a/q/o0/e;", "B", "Lb/a/q/o0/e;", "videoQuality", "Lcom/discord/primitives/ChannelId;", "P", "J", "getChannelId", "()J", "channelId", "Lrx/Subscription;", "F", "Lrx/Subscription;", "mediaEnginePrepareSubscription", "Z", "getConnected", "()Z", "setConnected", "(Z)V", "connected", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_ID, "L", "Lcom/discord/primitives/Timestamp;", "C", "Ljava/lang/Long;", "connectStartTime", "loggingTag", "", "Ljava/util/List;", "pings", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/primitives/GuildId;", "O", "getGuildId", "()Ljava/lang/Long;", "guildId", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$TransportInfo;", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$TransportInfo;", "transportInfo", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "I", "pingBadCount", "Lcom/discord/utilities/networking/Backoff;", "Lcom/discord/utilities/networking/Backoff;", "reconnectBackoff", "a0", "parentMediaSessionId", ExifInterface.LATITUDE_SOUTH, "rtcServerId", "Y", "Ljava/util/Map;", "mutedUsers", "userVolumes", "Lcom/discord/rtcconnection/RtcConnection$StateChange;", "Lcom/discord/rtcconnection/RtcConnection$StateChange;", "connectionStateChange", "G", "networkLossTime", "sentVideo", ExifInterface.LONGITUDE_EAST, "connectCount", "Q", "getSessionId", "setSessionId", "sessionId", "D", "connectCompletedTime", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "R", "isVideoEnabled", "c0", "getLoggingTagPrefix", "loggingTagPrefix", "Lcom/discord/rtcconnection/RtcConnection$d;", "X", "Lcom/discord/rtcconnection/RtcConnection$d;", "rtcConnectionType", "b0", "enableMediaSinkWants", "z", "Ljava/lang/Integer;", "port", "b/a/q/h0", "M", "Lb/a/q/h0;", "socketListener", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "Lrx/subjects/BehaviorSubject;", "connectionStateSubject", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection;", "x", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection;", "mediaEngineConnection", "destroyed", "Lcom/discord/utilities/logging/Logger;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/discord/utilities/logging/Logger;", "logger", "Lcom/discord/rtcconnection/MediaSinkWantsManager;", "H", "Lcom/discord/rtcconnection/MediaSinkWantsManager;", "localMediaSinkWantsManager", "Lcom/discord/primitives/StreamKey;", "d0", "streamKey", "Lb/a/q/n0/a;", "Lb/a/q/n0/a;", "socket", "localMediaSinkWantsSubscription", "y", "hostname", "Lcom/discord/primitives/MediaSessionId;", "<set-?>", "K", "getMediaSessionId", "mediaSessionId", "Lcom/discord/utilities/time/Clock;", ExifInterface.LONGITUDE_WEST, "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/rtcconnection/mediaengine/MediaEngine;", "U", "Lcom/discord/rtcconnection/mediaengine/MediaEngine;", "mediaEngine", "AnalyticsEvent", "Metadata", "Quality", "State", "StateChange", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class RtcConnection implements DebugPrintable, MediaSinkWantsManager.a {
    public static int j;

    /* renamed from: A, reason: from kotlin metadata */
    public int pingBadCount;

    /* renamed from: B, reason: from kotlin metadata */
    public final VideoQuality videoQuality;

    /* renamed from: C, reason: from kotlin metadata */
    public Long connectStartTime;

    /* renamed from: D, reason: from kotlin metadata */
    public Long connectCompletedTime;

    /* renamed from: E, reason: from kotlin metadata */
    public int connectCount;

    /* renamed from: F, reason: from kotlin metadata */
    public Subscription mediaEnginePrepareSubscription;

    /* renamed from: G, reason: from kotlin metadata */
    public Long networkLossTime;

    /* renamed from: H, reason: from kotlin metadata */
    public final MediaSinkWantsManager localMediaSinkWantsManager;

    /* renamed from: I, reason: from kotlin metadata */
    public final Subscription localMediaSinkWantsSubscription;

    /* renamed from: J, reason: from kotlin metadata */
    public boolean connected;

    /* renamed from: K, reason: from kotlin metadata */
    public String mediaSessionId;

    /* renamed from: L, reason: from kotlin metadata */
    public long videoSsrc;

    /* renamed from: M, reason: from kotlin metadata */
    public final h0 socketListener;

    /* renamed from: N, reason: from kotlin metadata */
    public final b0 mediaEngineConnectionListener;

    /* renamed from: O, reason: from kotlin metadata */
    public final Long guildId;

    /* renamed from: P, reason: from kotlin metadata */
    public final long channelId;

    /* renamed from: Q, reason: from kotlin metadata */
    public String sessionId;

    /* renamed from: R, reason: from kotlin metadata */
    public final boolean isVideoEnabled;

    /* renamed from: S, reason: from kotlin metadata */
    public final String rtcServerId;

    /* renamed from: T, reason: from kotlin metadata */
    public final long userId;

    /* renamed from: U, reason: from kotlin metadata */
    public final MediaEngine mediaEngine;

    /* renamed from: V, reason: from kotlin metadata */
    public final Logger logger;

    /* renamed from: W, reason: from kotlin metadata */
    public final Clock clock;

    /* renamed from: X, reason: from kotlin metadata */
    public final d rtcConnectionType;

    /* renamed from: Y, reason: from kotlin metadata */
    public final Map<Long, Boolean> mutedUsers;

    /* renamed from: Z, reason: from kotlin metadata */
    public final Map<Long, Float> userVolumes;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    public final String parentMediaSessionId;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    public final boolean enableMediaSinkWants;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    public final String loggingTagPrefix;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    public final String streamKey;

    /* renamed from: l, reason: from kotlin metadata */
    public final String loggingTag;

    /* renamed from: m, reason: from kotlin metadata */
    public final String id;

    /* renamed from: n, reason: from kotlin metadata */
    public final CopyOnWriteArrayList<c> listeners;

    /* renamed from: o, reason: from kotlin metadata */
    public RtcStatsCollector4 rtcStatsCollector;

    /* renamed from: p, reason: from kotlin metadata */
    public boolean sentVideo;

    /* renamed from: q, reason: from kotlin metadata */
    public final Backoff reconnectBackoff;

    /* renamed from: r, reason: from kotlin metadata */
    public MediaEngineConnection.TransportInfo transportInfo;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public StateChange connectionStateChange;

    /* renamed from: t, reason: from kotlin metadata */
    public BehaviorSubject<StateChange> connectionStateSubject;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean destroyed;

    /* renamed from: v, reason: from kotlin metadata */
    public List<Long> pings;

    /* renamed from: w, reason: from kotlin metadata */
    public RtcControlSocket socket;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public MediaEngineConnection mediaEngineConnection;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public String hostname;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public Integer port;

    /* compiled from: RtcConnection.kt */
    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$AnalyticsEvent;", "", "<init>", "(Ljava/lang/String;I)V", "VOICE_CONNECTION_SUCCESS", "VOICE_CONNECTION_FAILURE", "VOICE_DISCONNECT", "VIDEO_STREAM_ENDED", "MEDIA_SESSION_JOINED", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public enum AnalyticsEvent {
        VOICE_CONNECTION_SUCCESS,
        VOICE_CONNECTION_FAILURE,
        VOICE_DISCONNECT,
        VIDEO_STREAM_ENDED,
        MEDIA_SESSION_JOINED
    }

    /* compiled from: RtcConnection.kt */
    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\f\u0012\u000e\u0010\u0014\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0011\u0012\u000e\u0010\u001f\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u001c\u0012\u000e\u0010\u001b\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016\u0012\u000e\u0010#\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001` ¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R!\u0010\u0014\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0004R!\u0010\u001b\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u001f\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR!\u0010#\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001` 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0004¨\u0006&"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$Metadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/primitives/RtcConnectionId;", "a", "Ljava/lang/String;", "getRtcConnectionId", "rtcConnectionId", "Lcom/discord/primitives/MediaSessionId;", "b", "getMediaSessionId", "mediaSessionId", "", "Lcom/discord/primitives/GuildId;", "d", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "guildId", "Lcom/discord/primitives/ChannelId;", "c", "getChannelId", "channelId", "Lcom/discord/primitives/StreamKey;", "e", "getStreamKey", "streamKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Metadata {

        /* renamed from: a, reason: from kotlin metadata */
        public final String rtcConnectionId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String mediaSessionId;

        /* renamed from: c, reason: from kotlin metadata */
        public final Long channelId;

        /* renamed from: d, reason: from kotlin metadata */
        public final Long guildId;

        /* renamed from: e, reason: from kotlin metadata */
        public final String streamKey;

        public Metadata(String str, String str2, Long l, Long l2, String str3) {
            Intrinsics3.checkNotNullParameter(str, "rtcConnectionId");
            this.rtcConnectionId = str;
            this.mediaSessionId = str2;
            this.channelId = l;
            this.guildId = l2;
            this.streamKey = str3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Metadata)) {
                return false;
            }
            Metadata metadata = (Metadata) other;
            return Intrinsics3.areEqual(this.rtcConnectionId, metadata.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, metadata.mediaSessionId) && Intrinsics3.areEqual(this.channelId, metadata.channelId) && Intrinsics3.areEqual(this.guildId, metadata.guildId) && Intrinsics3.areEqual(this.streamKey, metadata.streamKey);
        }

        public int hashCode() {
            String str = this.rtcConnectionId;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.mediaSessionId;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.channelId;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            Long l2 = this.guildId;
            int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
            String str3 = this.streamKey;
            return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Metadata(rtcConnectionId=");
            sbU.append(this.rtcConnectionId);
            sbU.append(", mediaSessionId=");
            sbU.append(this.mediaSessionId);
            sbU.append(", channelId=");
            sbU.append(this.channelId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", streamKey=");
            return outline.J(sbU, this.streamKey, ")");
        }
    }

    /* compiled from: RtcConnection.kt */
    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$Quality;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "UNKNOWN", "BAD", "AVERAGE", "FINE", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public enum Quality {
        UNKNOWN,
        BAD,
        AVERAGE,
        FINE;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: RtcConnection.kt */
        /* renamed from: com.discord.rtcconnection.RtcConnection$Quality$a, reason: from kotlin metadata */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }
    }

    /* compiled from: RtcConnection.kt */
    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$State;", "", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", "h", "Lcom/discord/rtcconnection/RtcConnection$State$d;", "Lcom/discord/rtcconnection/RtcConnection$State$b;", "Lcom/discord/rtcconnection/RtcConnection$State$a;", "Lcom/discord/rtcconnection/RtcConnection$State$c;", "Lcom/discord/rtcconnection/RtcConnection$State$h;", "Lcom/discord/rtcconnection/RtcConnection$State$g;", "Lcom/discord/rtcconnection/RtcConnection$State$f;", "Lcom/discord/rtcconnection/RtcConnection$State$e;", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        /* compiled from: RtcConnection.kt */
        public static final class a extends State {
            public static final a a = new a();

            public a() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class b extends State {
            public static final b a = new b();

            public b() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class c extends State {
            public static final c a = new c();

            public c() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class d extends State {
            public final boolean a;

            public d(boolean z2) {
                super(null);
                this.a = z2;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof d) && this.a == ((d) obj).a;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.a;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            @Override // com.discord.rtcconnection.RtcConnection.State
            public String toString() {
                return outline.O(outline.U("Disconnected(willReconnect="), this.a, ")");
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class e extends State {
            public static final e a = new e();

            public e() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class f extends State {
            public static final f a = new f();

            public f() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class g extends State {
            public static final g a = new g();

            public g() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class h extends State {
            public static final h a = new h();

            public h() {
                super(null);
            }
        }

        public State() {
        }

        public String toString() {
            if (this instanceof d) {
                return super.toString();
            }
            String simpleName = getClass().getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            return simpleName;
        }

        public State(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: RtcConnection.kt */
    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$StateChange;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/rtcconnection/RtcConnection$State;", "a", "Lcom/discord/rtcconnection/RtcConnection$State;", "getState", "()Lcom/discord/rtcconnection/RtcConnection$State;", "state", "Lcom/discord/rtcconnection/RtcConnection$Metadata;", "b", "Lcom/discord/rtcconnection/RtcConnection$Metadata;", "getMetadata", "()Lcom/discord/rtcconnection/RtcConnection$Metadata;", "metadata", "<init>", "(Lcom/discord/rtcconnection/RtcConnection$State;Lcom/discord/rtcconnection/RtcConnection$Metadata;)V", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StateChange {

        /* renamed from: a, reason: from kotlin metadata */
        public final State state;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Metadata metadata;

        public StateChange(State state, Metadata metadata) {
            Intrinsics3.checkNotNullParameter(state, "state");
            this.state = state;
            this.metadata = metadata;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateChange)) {
                return false;
            }
            StateChange stateChange = (StateChange) other;
            return Intrinsics3.areEqual(this.state, stateChange.state) && Intrinsics3.areEqual(this.metadata, stateChange.metadata);
        }

        public int hashCode() {
            State state = this.state;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            Metadata metadata = this.metadata;
            return iHashCode + (metadata != null ? metadata.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StateChange(state=");
            sbU.append(this.state);
            sbU.append(", metadata=");
            sbU.append(this.metadata);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: RtcConnection.kt */
    public static abstract class b implements c {
        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onAnalyticsEvent(AnalyticsEvent analyticsEvent, Map<String, Object> map) {
            Intrinsics3.checkNotNullParameter(analyticsEvent, "event");
            Intrinsics3.checkNotNullParameter(map, "properties");
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onFatalClose() {
        }

        public void onFirstFrameReceived(long j) {
        }

        public void onFirstFrameSent() {
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onMediaEngineConnectionConnected(RtcConnection rtcConnection) {
            Intrinsics3.checkNotNullParameter(rtcConnection, "connection");
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onMediaSessionIdReceived() {
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onQualityUpdate(Quality quality) {
            Intrinsics3.checkNotNullParameter(quality, "quality");
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onSpeaking(long j, boolean z2) {
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public abstract void onStateChange(StateChange stateChange);

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onUserCreated(RtcConnection rtcConnection, long j) {
            Intrinsics3.checkNotNullParameter(rtcConnection, "connection");
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onVideoMetadata(VideoMetadata videoMetadata) {
            Intrinsics3.checkNotNullParameter(videoMetadata, "metadata");
        }

        @Override // com.discord.rtcconnection.RtcConnection.c
        public void onVideoStream(long j, Integer num, int i, int i2, int i3) {
        }
    }

    /* compiled from: RtcConnection.kt */
    public interface c {
        void onAnalyticsEvent(AnalyticsEvent analyticsEvent, Map<String, Object> map);

        void onFatalClose();

        void onMediaEngineConnectionConnected(RtcConnection rtcConnection);

        void onMediaSessionIdReceived();

        void onQualityUpdate(Quality quality);

        void onSpeaking(long j, boolean z2);

        void onStateChange(StateChange stateChange);

        void onUserCreated(RtcConnection rtcConnection, long j);

        void onVideoMetadata(VideoMetadata videoMetadata);

        void onVideoStream(long j, Integer num, int i, int i2, int i3);
    }

    /* compiled from: RtcConnection.kt */
    public static abstract class d {

        /* compiled from: RtcConnection.kt */
        public static final class a extends d {
            public static final a a = new a();

            public a() {
                super(null);
            }
        }

        /* compiled from: RtcConnection.kt */
        public static final class b extends d {
            public final long a;

            public b(long j) {
                super(null);
                this.a = j;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof b) && this.a == ((b) obj).a;
                }
                return true;
            }

            public int hashCode() {
                return a0.a.a.b.a(this.a);
            }

            public String toString() {
                return outline.C(outline.U("Stream(senderId="), this.a, ")");
            }
        }

        public d(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: RtcConnection.kt */
    public static final class e extends Lambda implements Function0<Unit> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            RtcConnection.this.f("Force Close");
            return Unit.a;
        }
    }

    public RtcConnection(Long l, long j2, String str, boolean z2, String str2, long j3, MediaEngine mediaEngine, Logger logger, Clock clock, d dVar, NetworkMonitor networkMonitor, Map map, Map map2, String str3, boolean z3, String str4, String str5, int i) {
        MediaSinkWantsManager mediaSinkWantsManager;
        Subscription subscriptionV;
        d dVar2 = (i & 512) != 0 ? d.a.a : dVar;
        Map linkedHashMap = (i & 2048) != 0 ? new LinkedHashMap() : map;
        LinkedHashMap linkedHashMap2 = (i & 4096) != 0 ? new LinkedHashMap() : null;
        String str6 = (i & 8192) != 0 ? null : str3;
        boolean z4 = (i & 16384) != 0 ? false : z3;
        String str7 = (i & 65536) != 0 ? null : str5;
        Intrinsics3.checkNotNullParameter(str, "sessionId");
        Intrinsics3.checkNotNullParameter(str2, "rtcServerId");
        Intrinsics3.checkNotNullParameter(mediaEngine, "mediaEngine");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(dVar2, "rtcConnectionType");
        boolean z5 = z4;
        Intrinsics3.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics3.checkNotNullParameter(linkedHashMap, "mutedUsers");
        Intrinsics3.checkNotNullParameter(linkedHashMap2, "userVolumes");
        Intrinsics3.checkNotNullParameter(str4, "loggingTagPrefix");
        this.guildId = l;
        this.channelId = j2;
        this.sessionId = str;
        this.isVideoEnabled = z2;
        this.rtcServerId = str2;
        this.userId = j3;
        this.mediaEngine = mediaEngine;
        this.logger = logger;
        this.clock = clock;
        this.rtcConnectionType = dVar2;
        this.mutedUsers = linkedHashMap;
        this.userVolumes = linkedHashMap2;
        this.parentMediaSessionId = str6;
        this.enableMediaSinkWants = z5;
        this.loggingTagPrefix = str4;
        this.streamKey = str7;
        StringBuilder sbX = outline.X(str4, "->RtcConnection ");
        int i2 = j + 1;
        j = i2;
        sbX.append(i2);
        this.loggingTag = sbX.toString();
        String string = UUID.randomUUID().toString();
        Intrinsics3.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        this.id = string;
        CopyOnWriteArrayList<c> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.listeners = copyOnWriteArrayList;
        this.reconnectBackoff = new Backoff(1000L, 10000L, 0, false, null, 28, null);
        StateChange stateChange = new StateChange(new State.d(false), null);
        this.connectionStateChange = stateChange;
        this.connectionStateSubject = BehaviorSubject.l0(stateChange);
        this.pings = new ArrayList();
        VideoQuality videoQuality = new VideoQuality(logger, clock);
        videoQuality.f.add(new x(this));
        this.videoQuality = videoQuality;
        if (z5) {
            subscriptionV = null;
            mediaSinkWantsManager = new MediaSinkWantsManager(j3, mediaEngine.c(), new MediaSinkWantsLadder3(null, 1), logger, this);
        } else {
            mediaSinkWantsManager = null;
            subscriptionV = null;
        }
        this.localMediaSinkWantsManager = mediaSinkWantsManager;
        if (z5) {
            Intrinsics3.checkNotNull(mediaSinkWantsManager);
            Observable<Map<String, MediaSinkWantsManager9>> observableR = mediaSinkWantsManager.f.r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "mediaSinkWantsSubject.distinctUntilChanged()");
            subscriptionV = Observable.j(observableR, this.connectionStateSubject, z.j).V(new g0(new a0(this)));
        }
        this.localMediaSinkWantsSubscription = subscriptionV;
        r("Created RtcConnection. GuildID: " + l + " ChannelID: " + j2);
        networkMonitor.observeIsConnected().S(1).W(new p(this), new q(this));
        copyOnWriteArrayList.add(new r(this));
        this.socketListener = new h0(this);
        this.mediaEngineConnectionListener = new b0(this);
    }

    public static void j(RtcConnection rtcConnection, boolean z2, String str, Throwable th, boolean z3, int i) throws NumberFormatException {
        if ((i & 4) != 0) {
            th = null;
        }
        if ((i & 8) != 0) {
            z3 = true;
        }
        if (z3) {
            o(rtcConnection, str, th, null, 4);
        } else {
            rtcConnection.logger.i(rtcConnection.loggingTag, str, th);
        }
        RtcStatsCollector4 rtcStatsCollector4 = rtcConnection.rtcStatsCollector;
        if (rtcStatsCollector4 != null) {
            rtcStatsCollector4.a();
        }
        rtcConnection.rtcStatsCollector = null;
        MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.destroy();
        }
        rtcConnection.mediaEngineConnection = null;
        rtcConnection.sentVideo = false;
        rtcConnection.reconnectBackoff.cancel();
        rtcConnection.u(new State.d(z2));
        if (z2) {
            rtcConnection.q();
            return;
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onFatalClose();
        }
        rtcConnection.f(str);
    }

    public static void o(RtcConnection rtcConnection, String str, Throwable th, Map map, int i) {
        if ((i & 2) != 0) {
            th = null;
        }
        int i2 = i & 4;
        rtcConnection.logger.e(rtcConnection.loggingTag, str, th, null);
    }

    @Override // com.discord.rtcconnection.MediaSinkWantsManager.a
    public void a(long userId, long audioSsrc, long videoSSRC, VideoMetadata metadata) {
        d(userId, audioSsrc, videoSSRC, metadata);
    }

    public final Map<String, Object> b(Map<String, Object> map) {
        String str = this.hostname;
        if (str != null) {
            map.put("hostname", str);
        }
        Integer num = this.port;
        if (num != null) {
            map.put("port", Integer.valueOf(num.intValue()));
        }
        return map;
    }

    public final void c(c listener) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void d(long userId, long audioSsrc, long videoSsrc, VideoMetadata metadata) {
        MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.s(userId, (int) audioSsrc, Integer.valueOf((int) videoSsrc), g(userId), h(userId));
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onUserCreated(this, userId);
        }
        if (metadata != null) {
            Iterator<T> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                ((c) it2.next()).onVideoMetadata(metadata);
            }
        }
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintable2 dp) {
        Intrinsics3.checkNotNullParameter(dp, "dp");
        dp.appendKeyValue(ModelAuditLogEntry.CHANGE_KEY_ID, this.id);
        dp.appendKeyValue("mediaSessionId", this.mediaSessionId);
        dp.appendKeyValue("parentMediaSessionId", this.parentMediaSessionId);
        dp.appendKeyValue("hostname", this.hostname);
        dp.appendKeyValue("channelId", Long.valueOf(this.channelId));
        dp.appendKeyValue("guildId", this.guildId);
        dp.appendKeyValue("streamKey", this.streamKey);
        dp.appendKeyValue("isVideoEnabled", Boolean.valueOf(this.isVideoEnabled));
        dp.appendKeyValue("rtcServerId", this.rtcServerId);
        dp.appendKeyValue("userId", Long.valueOf(this.userId));
        dp.appendKeyValue("rtcConnectionType", this.rtcConnectionType);
        dp.appendKeyValue("enableMediaSinkWants", Boolean.valueOf(this.enableMediaSinkWants));
        dp.appendKeyValue("socket", (DebugPrintable) this.socket);
        dp.appendKeyValue("sentVideo", Boolean.valueOf(this.sentVideo));
    }

    public final void e() {
        s(new e());
    }

    public final void f(String reason) {
        this.reconnectBackoff.cancel();
        RtcControlSocket rtcControlSocket = this.socket;
        if (rtcControlSocket != null) {
            rtcControlSocket.q.clear();
            rtcControlSocket.c();
        }
        this.socket = null;
        VideoQuality videoQuality = this.videoQuality;
        synchronized (videoQuality) {
            videoQuality.o.stop();
            videoQuality.h = Long.valueOf(videoQuality.q.currentTimeMillis());
        }
        if (!(this.connectionStateChange.state instanceof State.d)) {
            n(false, reason);
            d dVar = this.rtcConnectionType;
            if (dVar instanceof d.b) {
                Map<String, Object> mapC = this.videoQuality.c(String.valueOf(((d.b) dVar).a));
                if (mapC != null) {
                    l(((d.b) this.rtcConnectionType).a, mapC);
                }
                if (this.sentVideo) {
                    m(this.userId, this.videoQuality.d());
                }
            }
        }
        MediaSinkWantsManager mediaSinkWantsManager = this.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.b(new MediaSinkWantsManager2(mediaSinkWantsManager));
        }
        Subscription subscription = this.localMediaSinkWantsSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.mediaEnginePrepareSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.mediaEnginePrepareSubscription = null;
        MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.destroy();
        }
        this.mediaEngineConnection = null;
        u(new State.d(false));
        r("Destroy internal RTC connection: " + reason);
        this.listeners.clear();
        this.sentVideo = false;
        this.destroyed = true;
    }

    public final boolean g(long userId) {
        Boolean bool = this.mutedUsers.get(Long.valueOf(userId));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final float h(long userId) {
        Float f = this.userVolumes.get(Long.valueOf(userId));
        if (f != null) {
            return f.floatValue();
        }
        return 1.0f;
    }

    public final Metadata i() {
        return new Metadata(this.id, this.mediaSessionId, Long.valueOf(this.channelId), this.guildId, this.streamKey);
    }

    public final void k(long senderId, Map<String, ? extends Object> properties) {
        HashMap map = new HashMap();
        Long l = this.guildId;
        if (l != null) {
            l.longValue();
            map.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, this.guildId);
        }
        map.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(this.channelId));
        map.put("sender_user_id", Long.valueOf(senderId));
        map.putAll(properties);
        p(AnalyticsEvent.VIDEO_STREAM_ENDED, map);
    }

    public final void l(long senderId, Map<String, ? extends Object> properties) {
        if (properties != null) {
            k(senderId, Maps6.plus(properties, MapsJVM.mapOf(Tuples.to("participant_type", "receiver"))));
        }
    }

    public final void m(long senderId, Map<String, ? extends Object> properties) {
        if (properties != null) {
            k(senderId, Maps6.plus(properties, MapsJVM.mapOf(Tuples.to("participant_type", this.rtcConnectionType instanceof d.b ? "streamer" : NotificationCompat.MessagingStyle.Message.KEY_SENDER))));
        }
    }

    public final void n(boolean willReconnect, String reason) {
        List<String> list;
        String str;
        Stats stats;
        VoiceQuality voiceQuality;
        Map<String, Object> mapMutableMapOf = Maps6.mutableMapOf(Tuples.to("ping_bad_count", Integer.valueOf(this.pingBadCount)), Tuples.to("connect_count", Integer.valueOf(this.connectCount)), Tuples.to("channel_count", 1));
        b(mapMutableMapOf);
        mapMutableMapOf.put("reconnect", Boolean.valueOf(willReconnect));
        if (reason != null) {
            mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_REASON, reason);
        }
        double dAverageOfLong = _Collections.averageOfLong(this.pings);
        if (!Double.isNaN(dAverageOfLong)) {
            mapMutableMapOf.put("ping_average", Integer.valueOf(MathJVM.roundToInt(dAverageOfLong)));
        }
        String str2 = this.mediaSessionId;
        if (str2 != null) {
            mapMutableMapOf.put("media_session_id", str2);
        }
        RtcStatsCollector4 rtcStatsCollector4 = this.rtcStatsCollector;
        if (rtcStatsCollector4 != null && (stats = (Stats) _Collections.lastOrNull(rtcStatsCollector4.a)) != null) {
            OutboundRtpAudio outboundRtpAudio = stats.getOutboundRtpAudio();
            if (outboundRtpAudio != null) {
                mapMutableMapOf.put("packets_sent", Long.valueOf(outboundRtpAudio.getPacketsSent()));
                mapMutableMapOf.put("packets_sent_lost", Integer.valueOf(outboundRtpAudio.getPacketsLost()));
            }
            long packetsReceived = 0;
            long packetsLost = 0;
            for (InboundRtpAudio inboundRtpAudio : stats.getInboundRtpAudio().values()) {
                packetsLost += inboundRtpAudio.getPacketsLost();
                packetsReceived += inboundRtpAudio.getPacketsReceived();
            }
            mapMutableMapOf.put("packets_received", Long.valueOf(packetsReceived));
            mapMutableMapOf.put("packets_received_lost", Long.valueOf(packetsLost));
            RtcStatsCollector4 rtcStatsCollector42 = this.rtcStatsCollector;
            if (rtcStatsCollector42 != null && (voiceQuality = rtcStatsCollector42.f) != null) {
                voiceQuality.getDurationStats(mapMutableMapOf);
                voiceQuality.getMosStats(mapMutableMapOf);
                voiceQuality.getPacketStats(mapMutableMapOf);
                voiceQuality.getBufferStats(mapMutableMapOf);
                voiceQuality.getFrameOpStats(mapMutableMapOf);
            }
        }
        Long l = this.connectCompletedTime;
        Long lValueOf = l != null ? Long.valueOf(this.clock.currentTimeMillis() - l.longValue()) : null;
        if (lValueOf != null) {
            mapMutableMapOf.put("duration", Long.valueOf(lValueOf.longValue()));
        }
        MediaEngineConnection.TransportInfo transportInfo = this.transportInfo;
        MediaEngineConnection.TransportInfo.Protocol protocol = transportInfo != null ? transportInfo.protocol : null;
        if (protocol != null) {
            int iOrdinal = protocol.ordinal();
            if (iOrdinal == 0) {
                str = "udp";
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "tcp";
            }
            mapMutableMapOf.put("protocol", str);
        }
        p(AnalyticsEvent.VOICE_DISCONNECT, mapMutableMapOf);
        if (this.rtcConnectionType instanceof d.a) {
            VideoQuality videoQuality = this.videoQuality;
            synchronized (videoQuality) {
                list = _Collections.toList(videoQuality.m.keySet());
            }
            for (String str3 : list) {
                Long longOrNull = StringNumberConversions.toLongOrNull(str3);
                if (longOrNull != null) {
                    l(longOrNull.longValue(), this.videoQuality.c(str3));
                }
            }
            if (this.sentVideo) {
                m(this.userId, this.videoQuality.d());
            }
        }
    }

    public final void p(AnalyticsEvent event, Map<String, Object> properties) {
        String str;
        properties.put("rtc_connection_id", this.id);
        d dVar = this.rtcConnectionType;
        if (Intrinsics3.areEqual(dVar, d.a.a)) {
            str = "default";
        } else {
            if (!(dVar instanceof d.b)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "stream";
        }
        properties.put("context", str);
        String str2 = this.mediaSessionId;
        if (str2 != null) {
            properties.put("media_session_id", str2);
        }
        String str3 = this.parentMediaSessionId;
        if (str3 != null) {
            properties.put("parent_media_session_id", str3);
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onAnalyticsEvent(event, properties);
        }
    }

    public final void q() throws NumberFormatException {
        this.logger.recordBreadcrumb("reconnect", this.loggingTag);
        if (this.connected) {
            this.connectStartTime = Long.valueOf(this.clock.currentTimeMillis());
        }
        this.connectCount++;
        RtcControlSocket rtcControlSocket = this.socket;
        if (rtcControlSocket != null) {
            rtcControlSocket.c();
            rtcControlSocket.d();
        }
    }

    public final void r(String message) {
        this.logger.recordBreadcrumb(message, this.loggingTag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [b.a.q.f0] */
    @AnyThread
    public final void s(Function0<Unit> action) {
        MediaEngineExecutorService mediaEngineExecutorServiceC = this.mediaEngine.c();
        if (action != null) {
            action = new f0(action);
        }
        mediaEngineExecutorServiceC.l.execute((Runnable) action);
    }

    public final void t(Intent intent, ThumbnailEmitter thumbnailEmitter) {
        if (this.rtcConnectionType instanceof d.b) {
            r("Setting screenshare " + intent + ' ' + this.mediaEngineConnection);
            MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
            if (mediaEngineConnection == null) {
                Log.e("RtcConnection", "MediaEngine not connected for setScreenshare.");
            } else if (intent != null) {
                mediaEngineConnection.a(intent, thumbnailEmitter);
            } else {
                mediaEngineConnection.h();
            }
        }
    }

    public final void u(State state) {
        if (!Intrinsics3.areEqual(this.connectionStateChange.state, state)) {
            StateChange stateChange = new StateChange(state, i());
            this.connectionStateChange = stateChange;
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((c) it.next()).onStateChange(stateChange);
            }
        }
    }

    public final void v(long userId, float volume) {
        this.userVolumes.put(Long.valueOf(userId), Float.valueOf(volume));
        MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.e(userId, volume);
        }
    }

    public final void w(Long userId) {
        MediaSinkWantsManager mediaSinkWantsManager = this.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.b(new MediaSinkWantsManager5(mediaSinkWantsManager, userId));
        }
    }
}
