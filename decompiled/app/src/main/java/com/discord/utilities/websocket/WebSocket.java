package com.discord.utilities.websocket;

import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.websocket.ZLibWebSocketListener;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import f0.OkHttpClient;
import f0.e0.k.Platform2;
import j0.l.c.TrampolineScheduler;
import j0.p.Schedulers2;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* compiled from: WebSocket.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Y2\u00020\u0001:\u0005ZY[\\]BQ\u0012\b\u0010V\u001a\u0004\u0018\u00010U\u00124\u0010F\u001a0\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u00060Bj\u0002`C\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010D\u0012\u0004\u0012\u00020\b0Aj\u0002`E\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bW\u0010XJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\u0019RR\u0010$\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b #*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00140\u0014 #*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b #*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00140\u0014\u0018\u00010\"0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R4\u0010(\u001a\u0014\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R.\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\b058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R.\u0010>\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\b058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<RD\u0010F\u001a0\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u00060Bj\u0002`C\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010D\u0012\u0004\u0012\u00020\b0Aj\u0002`E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010HR.\u0010J\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\b058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u00108\u001a\u0004\bK\u0010:\"\u0004\bL\u0010<R$\u0010O\u001a\u00020M2\u0006\u0010N\u001a\u00020M8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0018\u0010S\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006^"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket;", "", "", "throwable", "Lokhttp3/Response;", "response", "", "closed", "", "handleOnFailure", "(Ljava/lang/Throwable;Lokhttp3/Response;Z)V", "", "url", "Ljavax/net/ssl/SSLSocketFactory;", "socketFactory", "Lokhttp3/WebSocketListener;", "listener", "Lokhttp3/WebSocket;", "createWebSocket", "(Ljava/lang/String;Ljavax/net/ssl/SSLSocketFactory;Lokhttp3/WebSocketListener;)Lokhttp3/WebSocket;", "Lkotlin/Function0;", "callback", "schedule", "(Lkotlin/jvm/functions/Function0;)V", "connect", "(Ljava/lang/String;)V", "", ModelAuditLogEntry.CHANGE_KEY_CODE, ModelAuditLogEntry.CHANGE_KEY_REASON, "disconnect", "(ILjava/lang/String;)V", "resetListeners", "()V", "message", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "schedulerSubject", "Lrx/subjects/PublishSubject;", "Lkotlin/Function2;", "Ljava/io/InputStreamReader;", "onMessage", "Lkotlin/jvm/functions/Function2;", "getOnMessage", "()Lkotlin/jvm/functions/Function2;", "setOnMessage", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/discord/utilities/websocket/RawMessageHandler;", "rawMessageHandler", "Lcom/discord/utilities/websocket/RawMessageHandler;", "getRawMessageHandler", "()Lcom/discord/utilities/websocket/RawMessageHandler;", "setRawMessageHandler", "(Lcom/discord/utilities/websocket/RawMessageHandler;)V", "Lkotlin/Function1;", "Lcom/discord/utilities/websocket/WebSocket$Closed;", "onClosed", "Lkotlin/jvm/functions/Function1;", "getOnClosed", "()Lkotlin/jvm/functions/Function1;", "setOnClosed", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/utilities/websocket/WebSocket$Error;", "onError", "getOnError", "setOnError", "Lkotlin/Function3;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "Lcom/discord/utilities/websocket/ErrorLogger;", "errorLogger", "Lkotlin/jvm/functions/Function3;", "Ljavax/net/ssl/SSLSocketFactory;", "Lcom/discord/utilities/websocket/WebSocket$Opened;", "onOpened", "getOnOpened", "setOnOpened", "Lcom/discord/utilities/websocket/WebSocket$State;", "<set-?>", "state", "Lcom/discord/utilities/websocket/WebSocket$State;", "getState", "()Lcom/discord/utilities/websocket/WebSocket$State;", "client", "Lokhttp3/WebSocket;", "Lrx/Scheduler;", "scheduler", "<init>", "(Lrx/Scheduler;Lkotlin/jvm/functions/Function3;Ljavax/net/ssl/SSLSocketFactory;)V", "Companion", "Closed", "Error", "Opened", "State", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WebSocket {
    private static final int CLOSE_NORMAL = 1000;
    private okhttp3.WebSocket client;
    private final Function3<String, Exception, Map<String, String>, Unit> errorLogger;
    private Function1<? super Closed, Unit> onClosed;
    private Function1<? super Error, Unit> onError;
    private Function2<? super InputStreamReader, ? super Integer, Unit> onMessage;
    private Function1<? super Opened, Unit> onOpened;
    private RawMessageHandler rawMessageHandler;
    private final PublishSubject<Function0<Unit>> schedulerSubject;
    private final SSLSocketFactory socketFactory;
    private State state;

    /* compiled from: WebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u00020\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/Function0;", "", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lkotlin/jvm/functions/Function0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.websocket.WebSocket$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Function0<? extends Unit>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Function0<? extends Unit> function0) {
            call2((Function0<Unit>) function0);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Function0<Unit> function0) {
            function0.invoke();
        }
    }

    /* compiled from: WebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.websocket.WebSocket$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Throwable> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            WebSocket webSocket = WebSocket.this;
            Intrinsics3.checkNotNullExpressionValue(th, "it");
            WebSocket.access$handleOnFailure(webSocket, th, null, WebSocket.this.getState() == State.CLOSED);
        }
    }

    /* compiled from: WebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket$Closed;", "", "", ModelAuditLogEntry.CHANGE_KEY_REASON, "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "I", "getCode", "()I", "<init>", "(ILjava/lang/String;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Closed {
        private final int code;
        private final String reason;

        public Closed(int i, String str) {
            this.code = i;
            this.reason = str;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* compiled from: WebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket$Error;", "", "Lokhttp3/Response;", "response", "Lokhttp3/Response;", "getResponse", "()Lokhttp3/Response;", "", "throwable", "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;Lokhttp3/Response;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error {
        private final Response response;
        private final Throwable throwable;

        public Error(Throwable th, Response response) {
            Intrinsics3.checkNotNullParameter(th, "throwable");
            this.throwable = th;
            this.response = response;
        }

        public final Response getResponse() {
            return this.response;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }

    /* compiled from: WebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket$Opened;", "", "Lokhttp3/Response;", "response", "Lokhttp3/Response;", "getResponse", "()Lokhttp3/Response;", "<init>", "(Lokhttp3/Response;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Opened {
        private final Response response;

        public Opened(Response response) {
            this.response = response;
        }

        public final Response getResponse() {
            return this.response;
        }
    }

    /* compiled from: WebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket$State;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_YET_CONNECTED", "CONNECTING", "CONNECTED", "CLOSING", "CLOSED", "utils_release"}, k = 1, mv = {1, 4, 2})
    public enum State {
        NOT_YET_CONNECTED,
        CONNECTING,
        CONNECTED,
        CLOSING,
        CLOSED
    }

    /* compiled from: WebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000O\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0019\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u001f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u001b\u0010!\u001a\u00020\b2\n\u0010 \u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b!\u0010\"R\u001e\u0010$\u001a\u0004\u0018\u00010#8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"com/discord/utilities/websocket/WebSocket$connect$1", "Lcom/discord/utilities/websocket/ZLibWebSocketListener$Listener;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "", "errorMessage", "rawData", "", "handleError", "(Ljava/lang/Exception;Ljava/lang/String;Ljava/lang/String;)V", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "", "t", "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "Ljava/io/InputStreamReader;", "reader", "", "compressedByteLength", "onInflatedMessage", "(Lokhttp3/WebSocket;Ljava/io/InputStreamReader;I)V", ModelAuditLogEntry.CHANGE_KEY_CODE, ModelAuditLogEntry.CHANGE_KEY_REASON, "onClosing", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosed", "e", "onInflateError", "(Ljava/lang/Exception;)V", "Lcom/discord/utilities/websocket/RawMessageHandler;", "rawMessageHandler", "Lcom/discord/utilities/websocket/RawMessageHandler;", "getRawMessageHandler", "()Lcom/discord/utilities/websocket/RawMessageHandler;", "utils_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.websocket.WebSocket$connect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ZLibWebSocketListener.Listener {
        private final RawMessageHandler rawMessageHandler;

        public AnonymousClass1() {
            this.rawMessageHandler = WebSocket.this.getRawMessageHandler();
        }

        private final void handleError(Exception exception, String errorMessage, String rawData) {
            Map mapEmptyMap;
            if (rawData == null || (mapEmptyMap = MapsJVM.mapOf(Tuples.to("raw_data_string", rawData))) == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            WebSocket.access$getErrorLogger$p(WebSocket.this).invoke(errorMessage, exception, mapEmptyMap);
            WebSocket.access$handleOnFailure(WebSocket.this, exception, null, false);
        }

        public static /* synthetic */ void handleError$default(AnonymousClass1 anonymousClass1, Exception exc, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            anonymousClass1.handleError(exc, str, str2);
        }

        @Override // com.discord.utilities.websocket.ZLibWebSocketListener.Listener
        public RawMessageHandler getRawMessageHandler() {
            return this.rawMessageHandler;
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(okhttp3.WebSocket webSocket, int code, String reason) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
            WebSocket.access$schedule(WebSocket.this, new WebSocket2(this, code, reason));
        }

        @Override // okhttp3.WebSocketListener
        public void onClosing(okhttp3.WebSocket webSocket, int code, String reason) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
            WebSocket.access$setState$p(WebSocket.this, State.CLOSING);
            WebSocket.this.getOnClosed().invoke(new Closed(code, reason));
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(okhttp3.WebSocket webSocket, Throwable t, Response response) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(t, "t");
            WebSocket.access$schedule(WebSocket.this, new WebSocket3(this, t, response));
        }

        @Override // com.discord.utilities.websocket.ZLibWebSocketListener.Listener
        public void onInflateError(Exception e) {
            Intrinsics3.checkNotNullParameter(e, "e");
            handleError$default(this, e, "Unable to inflate message.", null, 4, null);
        }

        @Override // com.discord.utilities.websocket.ZLibWebSocketListener.Listener
        public void onInflatedMessage(okhttp3.WebSocket webSocket, InputStreamReader reader, int compressedByteLength) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(reader, "reader");
            try {
                WebSocket.this.getOnMessage().invoke(reader, Integer.valueOf(compressedByteLength));
            } catch (Exception e) {
                handleError$default(this, e, "Unable to parse model.", null, 4, null);
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(okhttp3.WebSocket webSocket, Response response) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(response, "response");
            WebSocket.access$schedule(WebSocket.this, new WebSocket4(this, webSocket, response));
        }
    }

    /* compiled from: WebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket$Opened;", "it", "", "invoke", "(Lcom/discord/utilities/websocket/WebSocket$Opened;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.websocket.WebSocket$resetListeners$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Opened, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Opened opened) {
            invoke2(opened);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Opened opened) {
            Intrinsics3.checkNotNullParameter(opened, "it");
        }
    }

    /* compiled from: WebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket$Closed;", "it", "", "invoke", "(Lcom/discord/utilities/websocket/WebSocket$Closed;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.websocket.WebSocket$resetListeners$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Closed, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Closed closed) {
            invoke2(closed);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Closed closed) {
            Intrinsics3.checkNotNullParameter(closed, "it");
        }
    }

    /* compiled from: WebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/io/InputStreamReader;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "invoke", "(Ljava/io/InputStreamReader;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.websocket.WebSocket$resetListeners$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function2<InputStreamReader, Integer, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(InputStreamReader inputStreamReader, Integer num) {
            invoke(inputStreamReader, num.intValue());
            return Unit.a;
        }

        public final void invoke(InputStreamReader inputStreamReader, int i) {
            Intrinsics3.checkNotNullParameter(inputStreamReader, "<anonymous parameter 0>");
        }
    }

    /* compiled from: WebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket$Error;", "it", "", "invoke", "(Lcom/discord/utilities/websocket/WebSocket$Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.websocket.WebSocket$resetListeners$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebSocket(Scheduler scheduler, Function3<? super String, ? super Exception, ? super Map<String, String>, Unit> function3, SSLSocketFactory sSLSocketFactory) {
        Intrinsics3.checkNotNullParameter(function3, "errorLogger");
        this.errorLogger = function3;
        this.socketFactory = sSLSocketFactory;
        PublishSubject<Function0<Unit>> publishSubjectK0 = PublishSubject.k0();
        this.schedulerSubject = publishSubjectK0;
        this.onOpened = WebSocket8.INSTANCE;
        this.onClosed = WebSocket5.INSTANCE;
        this.onMessage = WebSocket7.INSTANCE;
        this.onError = WebSocket6.INSTANCE;
        this.state = State.NOT_YET_CONNECTED;
        Observable<Function0<Unit>> observableK = publishSubjectK0.K();
        if (scheduler == null) {
            AtomicReference<Schedulers2> atomicReference = Schedulers2.a;
            scheduler = TrampolineScheduler.a;
        }
        observableK.J(scheduler).W(AnonymousClass1.INSTANCE, new AnonymousClass2());
    }

    public static final /* synthetic */ okhttp3.WebSocket access$getClient$p(WebSocket webSocket) {
        return webSocket.client;
    }

    public static final /* synthetic */ Function3 access$getErrorLogger$p(WebSocket webSocket) {
        return webSocket.errorLogger;
    }

    public static final /* synthetic */ State access$getState$p(WebSocket webSocket) {
        return webSocket.state;
    }

    public static final /* synthetic */ void access$handleOnFailure(WebSocket webSocket, Throwable th, Response response, boolean z2) {
        webSocket.handleOnFailure(th, response, z2);
    }

    public static final /* synthetic */ void access$schedule(WebSocket webSocket, Function0 function0) {
        webSocket.schedule(function0);
    }

    public static final /* synthetic */ void access$setClient$p(WebSocket webSocket, okhttp3.WebSocket webSocket2) {
        webSocket.client = webSocket2;
    }

    public static final /* synthetic */ void access$setState$p(WebSocket webSocket, State state) {
        webSocket.state = state;
    }

    private final okhttp3.WebSocket createWebSocket(String url, SSLSocketFactory socketFactory, WebSocketListener listener) throws NumberFormatException {
        OkHttpClient.a aVar = new OkHttpClient.a();
        if (socketFactory != null) {
            Platform2.a aVar2 = Platform2.c;
            aVar.b(socketFactory, Platform2.a.n());
        }
        aVar.a(1L, TimeUnit.MINUTES);
        OkHttpClient okHttpClient = new OkHttpClient(aVar);
        Request.a aVar3 = new Request.a();
        aVar3.f(url);
        return okHttpClient.g(aVar3.a(), listener);
    }

    public static /* synthetic */ void disconnect$default(WebSocket webSocket, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1000;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        webSocket.disconnect(i, str);
    }

    private final void handleOnFailure(Throwable throwable, Response response, boolean closed) {
        if (closed) {
            this.state = State.CLOSED;
        } else {
            disconnect(PointerIconCompat.TYPE_COPY, "Closing due to failure " + throwable + ", " + response);
        }
        this.onError.invoke(new Error(throwable, response));
    }

    private final void schedule(Function0<Unit> callback) {
        this.schedulerSubject.k.onNext(callback);
    }

    public final void connect(String url) {
        Intrinsics3.checkNotNullParameter(url, "url");
        disconnect(1000, "Closing existing connection.");
        this.state = State.CONNECTING;
        this.client = createWebSocket(url, this.socketFactory, new ZLibWebSocketListener(new AnonymousClass1()));
    }

    public final void disconnect() {
        disconnect$default(this, 0, null, 3, null);
    }

    public final void disconnect(int i) {
        disconnect$default(this, i, null, 2, null);
    }

    public final void disconnect(int code, String reason) {
        okhttp3.WebSocket webSocket = this.client;
        if (webSocket != null) {
            this.state = State.CLOSING;
            try {
                try {
                    webSocket.e(code, reason);
                } catch (Exception e) {
                    handleOnFailure(e, null, true);
                }
            } finally {
                this.client = null;
            }
        }
    }

    public final Function1<Closed, Unit> getOnClosed() {
        return this.onClosed;
    }

    public final Function1<Error, Unit> getOnError() {
        return this.onError;
    }

    public final Function2<InputStreamReader, Integer, Unit> getOnMessage() {
        return this.onMessage;
    }

    public final Function1<Opened, Unit> getOnOpened() {
        return this.onOpened;
    }

    public final RawMessageHandler getRawMessageHandler() {
        return this.rawMessageHandler;
    }

    public final State getState() {
        return this.state;
    }

    public final void message(String message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        okhttp3.WebSocket webSocket = this.client;
        if (webSocket == null || this.state != State.CONNECTED) {
            return;
        }
        try {
            webSocket.a(message);
        } catch (IllegalStateException e) {
            handleOnFailure(e, null, true);
        }
    }

    public final void resetListeners() {
        this.onOpened = AnonymousClass1.INSTANCE;
        this.onClosed = AnonymousClass2.INSTANCE;
        this.onMessage = AnonymousClass3.INSTANCE;
        this.rawMessageHandler = null;
        this.onError = AnonymousClass4.INSTANCE;
    }

    public final void setOnClosed(Function1<? super Closed, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClosed = function1;
    }

    public final void setOnError(Function1<? super Error, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onError = function1;
    }

    public final void setOnMessage(Function2<? super InputStreamReader, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "<set-?>");
        this.onMessage = function2;
    }

    public final void setOnOpened(Function1<? super Opened, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onOpened = function1;
    }

    public final void setRawMessageHandler(RawMessageHandler rawMessageHandler) {
        this.rawMessageHandler = rawMessageHandler;
    }
}
