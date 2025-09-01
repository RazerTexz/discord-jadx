package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.message.Message;
import com.discord.stores.StoreChat;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Iterables2;
import d0.t.Sets5;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreMessagesLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 m2\u00020\u0001:\u0003nomB\u0017\u0012\u0006\u0010a\u001a\u00020`\u0012\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\bk\u0010lJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJO\u0010\u0015\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0010\u001a\u00060\bj\u0002`\t2\f\b\u0002\u0010\u0012\u001a\u00060\bj\u0002`\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00042\n\u0010\u0010\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J[\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001a2\u0010\b\u0002\u0010\u001e\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\u0010\b\u0002\u0010\u001f\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u0011H\u0002¢\u0006\u0004\b \u0010!J/\u0010%\u001a\u00020\u00042\n\u0010\u0010\u001a\u00060\bj\u0002`\t2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u0013\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-¢\u0006\u0004\b/\u00100J\u001f\u00101\u001a\b\u0012\u0004\u0012\u00020#0-2\n\u0010\u0010\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\f\u0012\b\u0012\u00060\bj\u0002`\u00110-¢\u0006\u0004\b3\u00100J\u0013\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a0-¢\u0006\u0004\b4\u00100J\u0017\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u0004¢\u0006\u0004\b9\u0010(J\r\u0010:\u001a\u00020\u0004¢\u0006\u0004\b:\u0010(J%\u0010;\u001a\u00020\u00042\n\u0010\u0010\u001a\u00060\bj\u0002`\t2\n\u0010\u0012\u001a\u00060\bj\u0002`\u0011¢\u0006\u0004\b;\u0010<J\u0015\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u001a¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010)¢\u0006\u0004\bA\u0010,J\u0015\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001a¢\u0006\u0004\bC\u0010?J\u001b\u0010E\u001a\u00020\u00042\n\u0010D\u001a\u00060\bj\u0002`\tH\u0007¢\u0006\u0004\bE\u0010\u0018J\u001b\u0010G\u001a\u00020\u00042\n\u0010F\u001a\u00060\bj\u0002`\tH\u0007¢\u0006\u0004\bG\u0010\u0018R\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JRr\u0010N\u001a^\u0012,\u0012*\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020# M*\u0014\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020#\u0018\u00010L0L\u0012,\u0012*\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020# M*\u0014\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020#\u0018\u00010L0L0K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR2\u0010P\u001a\u001e\u0012\f\u0012\n M*\u0004\u0018\u00010\u001a0\u001a\u0012\f\u0012\n M*\u0004\u0018\u00010\u001a0\u001a0K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010OR\u001a\u0010D\u001a\u00060\bj\u0002`\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010QR2\u0010R\u001a\u001e\u0012\f\u0012\n M*\u0004\u0018\u00010.0.\u0012\f\u0012\n M*\u0004\u0018\u00010.0.0K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010OR\u0016\u0010S\u001a\u00020\b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010B\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010TR\u0016\u0010V\u001a\u00020U8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010WR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R \u0010\n\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\\R\u0016\u0010]\u001a\u00020U8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b]\u0010WR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010^R\u0016\u0010_\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010TR\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010JR:\u0010f\u001a&\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020#0dj\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020#`e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010TR\u0016\u0010i\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010QR2\u0010j\u001a\u001e\u0012\f\u0012\n\u0018\u00010\bj\u0004\u0018\u0001`\u0011\u0012\f\u0012\n\u0018\u00010\bj\u0004\u0018\u0001`\u00110K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010O¨\u0006p"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader;", "Lcom/discord/stores/Store;", "Lcom/discord/stores/StoreChat$InteractionState;", "interactionState", "", "handleChatInteraction", "(Lcom/discord/stores/StoreChat$InteractionState;)V", "", "", "Lcom/discord/primitives/ChannelId;", "detachedChannels", "handleChatDetached", "(Ljava/util/Set;)V", "", "Lcom/discord/models/message/Message;", "messages", "channelId", "Lcom/discord/primitives/MessageId;", "messageId", "before", "after", "handleLoadedMessages", "(Ljava/util/List;JJLjava/lang/Long;Ljava/lang/Long;)V", "handleLoadMessagesError", "(J)V", "delay", "", "force", "resetRetry", "resetDelay", "targetChannelId", "targetMessageId", "tryLoadMessages", "(JZZZLjava/lang/Long;Ljava/lang/Long;)V", "Lkotlin/Function1;", "Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "updater", "channelLoadedStateUpdate", "(JLkotlin/jvm/functions/Function1;)V", "channelLoadedStatesReset", "()V", "", "message", "log", "(Ljava/lang/String;)V", "Lrx/Observable;", "Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;", "get", "()Lrx/Observable;", "getMessagesLoadedState", "(J)Lrx/Observable;", "getScrollTo", "observeChannelMessagesLoading", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "clearScrollTo", "requestNewestMessages", "jumpToMessage", "(JJ)V", "connected", "handleConnected", "(Z)V", "authToken", "handleAuthToken", "backgrounded", "handleBackgrounded", "selectedChannelId", "handleChannelSelected", "selectedVoiceChannelId", "handleVoiceChannelJoined", "Lrx/Subscription;", "delayLoadingMessagesSubscription", "Lrx/Subscription;", "Lrx/subjects/SerializedSubject;", "", "kotlin.jvm.PlatformType", "channelLoadedStateSubject", "Lrx/subjects/SerializedSubject;", "channelMessagesLoadingSubject", "J", "channelMessageChunksSubject", "loadingMessagesRetryDelayDefault", "Z", "", "loadingMessagesRetryJitter", "I", "loadingMessagesRetryMax", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Ljava/util/Set;", "messageRequestSize", "Lcom/discord/stores/StoreChat$InteractionState;", "hasConnected", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "loadingMessagesSubscription", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "channelLoadedStates", "Ljava/util/HashMap;", "authed", "loadingMessagesRetryDelayMillis", "scrollToSubject", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;)V", "Companion", "ChannelChunk", "ChannelLoadedState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMessagesLoader extends Store {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long SCROLL_TO_LAST_UNREAD = 0;
    public static final long SCROLL_TO_LATEST = 1;
    private boolean authed;
    private boolean backgrounded;
    private final SerializedSubject<Map<Long, ChannelLoadedState>, Map<Long, ChannelLoadedState>> channelLoadedStateSubject;
    private final HashMap<Long, ChannelLoadedState> channelLoadedStates;
    private final SerializedSubject<ChannelChunk, ChannelChunk> channelMessageChunksSubject;
    private final SerializedSubject<Boolean, Boolean> channelMessagesLoadingSubject;
    private Subscription delayLoadingMessagesSubscription;
    private Set<Long> detachedChannels;
    private final Dispatcher dispatcher;
    private boolean hasConnected;
    private StoreChat.InteractionState interactionState;
    private final long loadingMessagesRetryDelayDefault;
    private long loadingMessagesRetryDelayMillis;
    private final int loadingMessagesRetryJitter;
    private int loadingMessagesRetryMax;
    private Subscription loadingMessagesSubscription;
    private final int messageRequestSize;
    private final SerializedSubject<Long, Long> scrollToSubject;
    private long selectedChannelId;
    private final StoreStream stream;

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b&\u0010'J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u000f\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJV\u0010\u0016\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0012\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0015\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\u0015\u0010\fR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\tR\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\u0005R\u0019\u0010\u0013\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\u0013\u0010\fR\u0019\u0010\u0014\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\u0014\u0010\f¨\u0006("}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "Lcom/discord/models/message/Message;", "component2", "()Ljava/util/List;", "", "component3", "()Z", "component4", "component5", "component6", "channelId", "messages", "isInitial", "isPresent", "isAppendingTop", "isJump", "copy", "(JLjava/util/List;ZZZZ)Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/util/List;", "getMessages", "J", "getChannelId", "<init>", "(JLjava/util/List;ZZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelChunk {
        private final long channelId;
        private final boolean isAppendingTop;
        private final boolean isInitial;
        private final boolean isJump;
        private final boolean isPresent;
        private final List<Message> messages;

        public ChannelChunk(long j, List<Message> list, boolean z2, boolean z3, boolean z4, boolean z5) {
            Intrinsics3.checkNotNullParameter(list, "messages");
            this.channelId = j;
            this.messages = list;
            this.isInitial = z2;
            this.isPresent = z3;
            this.isAppendingTop = z4;
            this.isJump = z5;
        }

        public static /* synthetic */ ChannelChunk copy$default(ChannelChunk channelChunk, long j, List list, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
            return channelChunk.copy((i & 1) != 0 ? channelChunk.channelId : j, (i & 2) != 0 ? channelChunk.messages : list, (i & 4) != 0 ? channelChunk.isInitial : z2, (i & 8) != 0 ? channelChunk.isPresent : z3, (i & 16) != 0 ? channelChunk.isAppendingTop : z4, (i & 32) != 0 ? channelChunk.isJump : z5);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        public final List<Message> component2() {
            return this.messages;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsInitial() {
            return this.isInitial;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsPresent() {
            return this.isPresent;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsAppendingTop() {
            return this.isAppendingTop;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsJump() {
            return this.isJump;
        }

        public final ChannelChunk copy(long channelId, List<Message> messages, boolean isInitial, boolean isPresent, boolean isAppendingTop, boolean isJump) {
            Intrinsics3.checkNotNullParameter(messages, "messages");
            return new ChannelChunk(channelId, messages, isInitial, isPresent, isAppendingTop, isJump);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelChunk)) {
                return false;
            }
            ChannelChunk channelChunk = (ChannelChunk) other;
            return this.channelId == channelChunk.channelId && Intrinsics3.areEqual(this.messages, channelChunk.messages) && this.isInitial == channelChunk.isInitial && this.isPresent == channelChunk.isPresent && this.isAppendingTop == channelChunk.isAppendingTop && this.isJump == channelChunk.isJump;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final List<Message> getMessages() {
            return this.messages;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            List<Message> list = this.messages;
            int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isInitial;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.isPresent;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.isAppendingTop;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.isJump;
            return i6 + (z5 ? 1 : z5 ? 1 : 0);
        }

        public final boolean isAppendingTop() {
            return this.isAppendingTop;
        }

        public final boolean isInitial() {
            return this.isInitial;
        }

        public final boolean isJump() {
            return this.isJump;
        }

        public final boolean isPresent() {
            return this.isPresent;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelChunk(channelId=");
            sbU.append(this.channelId);
            sbU.append(", messages=");
            sbU.append(this.messages);
            sbU.append(", isInitial=");
            sbU.append(this.isInitial);
            sbU.append(", isPresent=");
            sbU.append(this.isPresent);
            sbU.append(", isAppendingTop=");
            sbU.append(this.isAppendingTop);
            sbU.append(", isJump=");
            return outline.O(sbU, this.isJump, ")");
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0018\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJJ\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\r\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u000e\u0010\u0004R!\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u000f\u0010\u0004¨\u0006!"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "", "", "component1", "()Z", "component2", "component3", "component4", "", "Lcom/discord/primitives/MessageId;", "component5", "()Ljava/lang/Long;", "isInitialMessagesLoaded", "isOldestMessagesLoaded", "isLoadingMessages", "isTouchedSinceLastJump", "newestSentByUserMessageId", "copy", "(ZZZZLjava/lang/Long;)Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/Long;", "getNewestSentByUserMessageId", "<init>", "(ZZZZLjava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelLoadedState {
        private final boolean isInitialMessagesLoaded;
        private final boolean isLoadingMessages;
        private final boolean isOldestMessagesLoaded;
        private final boolean isTouchedSinceLastJump;
        private final Long newestSentByUserMessageId;

        public ChannelLoadedState() {
            this(false, false, false, false, null, 31, null);
        }

        public ChannelLoadedState(boolean z2, boolean z3, boolean z4, boolean z5, Long l) {
            this.isInitialMessagesLoaded = z2;
            this.isOldestMessagesLoaded = z3;
            this.isLoadingMessages = z4;
            this.isTouchedSinceLastJump = z5;
            this.newestSentByUserMessageId = l;
        }

        public static /* synthetic */ ChannelLoadedState copy$default(ChannelLoadedState channelLoadedState, boolean z2, boolean z3, boolean z4, boolean z5, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = channelLoadedState.isInitialMessagesLoaded;
            }
            if ((i & 2) != 0) {
                z3 = channelLoadedState.isOldestMessagesLoaded;
            }
            boolean z6 = z3;
            if ((i & 4) != 0) {
                z4 = channelLoadedState.isLoadingMessages;
            }
            boolean z7 = z4;
            if ((i & 8) != 0) {
                z5 = channelLoadedState.isTouchedSinceLastJump;
            }
            boolean z8 = z5;
            if ((i & 16) != 0) {
                l = channelLoadedState.newestSentByUserMessageId;
            }
            return channelLoadedState.copy(z2, z6, z7, z8, l);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsInitialMessagesLoaded() {
            return this.isInitialMessagesLoaded;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsOldestMessagesLoaded() {
            return this.isOldestMessagesLoaded;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsLoadingMessages() {
            return this.isLoadingMessages;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        /* renamed from: component5, reason: from getter */
        public final Long getNewestSentByUserMessageId() {
            return this.newestSentByUserMessageId;
        }

        public final ChannelLoadedState copy(boolean isInitialMessagesLoaded, boolean isOldestMessagesLoaded, boolean isLoadingMessages, boolean isTouchedSinceLastJump, Long newestSentByUserMessageId) {
            return new ChannelLoadedState(isInitialMessagesLoaded, isOldestMessagesLoaded, isLoadingMessages, isTouchedSinceLastJump, newestSentByUserMessageId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelLoadedState)) {
                return false;
            }
            ChannelLoadedState channelLoadedState = (ChannelLoadedState) other;
            return this.isInitialMessagesLoaded == channelLoadedState.isInitialMessagesLoaded && this.isOldestMessagesLoaded == channelLoadedState.isOldestMessagesLoaded && this.isLoadingMessages == channelLoadedState.isLoadingMessages && this.isTouchedSinceLastJump == channelLoadedState.isTouchedSinceLastJump && Intrinsics3.areEqual(this.newestSentByUserMessageId, channelLoadedState.newestSentByUserMessageId);
        }

        public final Long getNewestSentByUserMessageId() {
            return this.newestSentByUserMessageId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isInitialMessagesLoaded;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.isOldestMessagesLoaded;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.isLoadingMessages;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            boolean z3 = this.isTouchedSinceLastJump;
            int i6 = (i5 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            Long l = this.newestSentByUserMessageId;
            return i6 + (l != null ? l.hashCode() : 0);
        }

        public final boolean isInitialMessagesLoaded() {
            return this.isInitialMessagesLoaded;
        }

        public final boolean isLoadingMessages() {
            return this.isLoadingMessages;
        }

        public final boolean isOldestMessagesLoaded() {
            return this.isOldestMessagesLoaded;
        }

        public final boolean isTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelLoadedState(isInitialMessagesLoaded=");
            sbU.append(this.isInitialMessagesLoaded);
            sbU.append(", isOldestMessagesLoaded=");
            sbU.append(this.isOldestMessagesLoaded);
            sbU.append(", isLoadingMessages=");
            sbU.append(this.isLoadingMessages);
            sbU.append(", isTouchedSinceLastJump=");
            sbU.append(this.isTouchedSinceLastJump);
            sbU.append(", newestSentByUserMessageId=");
            return outline.G(sbU, this.newestSentByUserMessageId, ")");
        }

        public /* synthetic */ ChannelLoadedState(boolean z2, boolean z3, boolean z4, boolean z5, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) == 0 ? z5 : false, (i & 16) != 0 ? null : l);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$Companion;", "", "", "Lcom/discord/primitives/MessageId;", "targetMessageId", "", "isScrollToAction", "(J)Z", "SCROLL_TO_LAST_UNREAD", "J", "SCROLL_TO_LATEST", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final boolean isScrollToAction(long targetMessageId) {
            return targetMessageId == 0 || targetMessageId == 1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$getMessagesLoadedState$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends ChannelLoadedState>, ChannelLoadedState> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ ChannelLoadedState call(Map<Long, ? extends ChannelLoadedState> map) {
            return call2((Map<Long, ChannelLoadedState>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ChannelLoadedState call2(Map<Long, ChannelLoadedState> map) {
            ChannelLoadedState channelLoadedState = map.get(Long.valueOf(this.$channelId));
            return channelLoadedState != null ? channelLoadedState : new ChannelLoadedState(false, false, false, false, null, 31, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "it", "invoke", "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$handleChannelSelected$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            return invoke2(channelLoadedState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 23, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "it", "invoke", "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$handleLoadMessagesError$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            return invoke2(channelLoadedState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 27, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "it", "invoke", "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$handleLoadedMessages$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public final /* synthetic */ boolean $isAllLoaded;
        public final /* synthetic */ boolean $isAppendingTop;
        public final /* synthetic */ boolean $isInitial;
        public final /* synthetic */ List $messages;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, boolean z3, boolean z4, List list) {
            super(1);
            this.$isInitial = z2;
            this.$isAppendingTop = z3;
            this.$isAllLoaded = z4;
            this.$messages = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            return invoke2(channelLoadedState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
            Object next;
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            boolean zIsInitialMessagesLoaded = this.$isInitial ? true : channelLoadedState.isInitialMessagesLoaded();
            boolean zIsOldestMessagesLoaded = (this.$isInitial || this.$isAppendingTop) ? this.$isAllLoaded : channelLoadedState.isOldestMessagesLoaded();
            Iterator it = this.$messages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                User author = ((Message) next).getAuthor();
                if (author != null && author.getId() == StoreMessagesLoader.access$getStream$p(StoreMessagesLoader.this).getUsers().getMeSnapshot().getId()) {
                    break;
                }
            }
            Message message = (Message) next;
            return ChannelLoadedState.copy$default(channelLoadedState, zIsInitialMessagesLoaded, zIsOldestMessagesLoaded, false, false, message != null ? Long.valueOf(message.getId()) : null, 8, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreChat$InteractionState;", "p1", "", "invoke", "(Lcom/discord/stores/StoreChat$InteractionState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$init$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreChat.InteractionState, Unit> {
        public AnonymousClass1(StoreMessagesLoader storeMessagesLoader) {
            super(1, storeMessagesLoader, StoreMessagesLoader.class, "handleChatInteraction", "handleChatInteraction(Lcom/discord/stores/StoreChat$InteractionState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreChat.InteractionState interactionState) {
            invoke2(interactionState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreChat.InteractionState interactionState) {
            Intrinsics3.checkNotNullParameter(interactionState, "p1");
            StoreMessagesLoader.access$handleChatInteraction((StoreMessagesLoader) this.receiver, interactionState);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "p1", "", "invoke", "(Ljava/util/Set;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$init$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Set<? extends Long>, Unit> {
        public AnonymousClass2(StoreMessagesLoader storeMessagesLoader) {
            super(1, storeMessagesLoader, StoreMessagesLoader.class, "handleChatDetached", "handleChatDetached(Ljava/util/Set;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
            invoke2((Set<Long>) set);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<Long> set) {
            Intrinsics3.checkNotNullParameter(set, "p1");
            StoreMessagesLoader.access$handleChatDetached((StoreMessagesLoader) this.receiver, set);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/message/Message;", "message", "", "invoke", "(Lcom/discord/models/message/Message;)V", "handleTargetChannelSelected"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* compiled from: StoreMessagesLoader.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "it", "invoke", "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01601 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final C01601 INSTANCE = new C01601();

            public C01601() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                return invoke2(channelLoadedState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 29, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(1);
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final synchronized void invoke2(Message message) {
            if (message != null) {
                SerializedSubject serializedSubjectAccess$getScrollToSubject$p = StoreMessagesLoader.access$getScrollToSubject$p(StoreMessagesLoader.this);
                serializedSubjectAccess$getScrollToSubject$p.k.onNext(Long.valueOf(message.getId()));
            } else {
                StoreMessagesLoader.access$channelLoadedStateUpdate(StoreMessagesLoader.this, this.$channelId, C01601.INSTANCE);
                StoreMessagesLoader.tryLoadMessages$default(StoreMessagesLoader.this, 0L, true, false, false, Long.valueOf(this.$channelId), Long.valueOf(this.$messageId), 9, null);
            }
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "handleTargetChannelResolved"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreMessagesLoader.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "it", "invoke", "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                return invoke2(channelLoadedState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, true, false, false, false, null, 30, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final synchronized void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            if (channel.getId() != StoreMessagesLoader.access$getSelectedChannelId$p(StoreMessagesLoader.this)) {
                StoreMessagesLoader.access$channelLoadedStateUpdate(StoreMessagesLoader.this, this.$channelId, AnonymousClass1.INSTANCE);
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
            }
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/Long;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Boolean> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke2(l));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Long l) {
            return l != null && l.longValue() == this.$channelId;
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lrx/Observable;", "Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<Long, Observable<? extends Message>> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        public AnonymousClass4(long j, long j2) {
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Message> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Message> call2(Long l) {
            return StoreMessagesLoader.access$getStream$p(StoreMessagesLoader.this).getMessages().observeMessagesForChannel(this.$channelId, this.$messageId);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "message", "", "invoke", "(Lcom/discord/models/message/Message;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ AnonymousClass1 $handleTargetChannelSelected$1;

        /* compiled from: StoreMessagesLoader.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Message $message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Message message) {
                super(0);
                this.$message = message;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass5.this.$handleTargetChannelSelected$1.invoke2(this.$message);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(AnonymousClass1 anonymousClass1) {
            super(1);
            this.$handleTargetChannelSelected$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            StoreMessagesLoader.access$getDispatcher$p(StoreMessagesLoader.this).schedule(new AnonymousClass1(message));
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "isConnected", "Lrx/Observable;", "Lcom/discord/api/channel/Channel;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$6, reason: invalid class name */
    public static final class AnonymousClass6<T, R> implements Func1<Boolean, Observable<? extends Channel>> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass6(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Boolean bool) {
            return call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Channel> call2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isConnected");
            int i = bool.booleanValue() ? 1 : 3;
            Observable<R> observableG = StoreMessagesLoader.access$getStream$p(StoreMessagesLoader.this).getChannels().observeChannel(this.$channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            return ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 1000 * i, false, 2, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$7, reason: invalid class name */
    public static final class AnonymousClass7 extends Lambda implements Function1<Error, Unit> {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        public AnonymousClass7() {
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
            Logger.w$default(AppLog.g, "Dropped message jump action", null, 2, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "p1", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$8, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public final /* synthetic */ AnonymousClass2 $handleTargetChannelResolved$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(AnonymousClass2 anonymousClass2) {
            super(1, null, "handleTargetChannelResolved", "invoke(Lcom/discord/api/channel/Channel;)V", 0);
            this.$handleTargetChannelResolved$2 = anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            this.$handleTargetChannelResolved$2.invoke2(channel);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "it", "invoke", "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$requestNewestMessages$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            return invoke2(channelLoadedState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 30, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreMessagesLoader.tryLoadMessages$default(StoreMessagesLoader.this, 0L, false, false, true, null, null, 55, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
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
            StoreMessagesLoader.access$setDelayLoadingMessagesSubscription$p(StoreMessagesLoader.this, subscription);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "messageId", "before", "after", "", "invoke", "(JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "loadMessages"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function4<Long, Long, Long, Long, Unit> {

        /* compiled from: StoreMessagesLoader.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "it", "invoke", "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                return invoke2(channelLoadedState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, false, false, true, false, null, 27, null);
            }
        }

        /* compiled from: StoreMessagesLoader.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0002*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00000\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/api/message/Message;", "kotlin.jvm.PlatformType", "messages", "Lcom/discord/models/message/Message;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<List<? extends com.discord.api.message.Message>, List<? extends Message>> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends com.discord.api.message.Message> list) {
                return call2((List<com.discord.api.message.Message>) list);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Message> call2(List<com.discord.api.message.Message> list) {
                Intrinsics3.checkNotNullExpressionValue(list, "messages");
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new Message((com.discord.api.message.Message) it.next()));
                }
                return arrayList;
            }
        }

        /* compiled from: StoreMessagesLoader.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/models/message/Message;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$3, reason: invalid class name and collision with other inner class name */
        public static final class C01613 extends Lambda implements Function1<List<? extends Message>, Unit> {
            public final /* synthetic */ Long $after;
            public final /* synthetic */ Long $before;
            public final /* synthetic */ long $channelId;
            public final /* synthetic */ Long $messageId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01613(long j, Long l, Long l2, Long l3) {
                super(1);
                this.$channelId = j;
                this.$messageId = l;
                this.$before = l2;
                this.$after = l3;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
                invoke2((List<Message>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Message> list) {
                StoreMessagesLoader storeMessagesLoader = StoreMessagesLoader.this;
                Intrinsics3.checkNotNullExpressionValue(list, "it");
                long j = this.$channelId;
                Long l = this.$messageId;
                StoreMessagesLoader.access$handleLoadedMessages(storeMessagesLoader, list, j, l != null ? l.longValue() : 0L, this.$before, this.$after);
            }
        }

        /* compiled from: StoreMessagesLoader.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$4, reason: invalid class name */
        public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(long j) {
                super(1);
                this.$channelId = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreMessagesLoader.access$handleLoadMessagesError(StoreMessagesLoader.this, this.$channelId);
            }
        }

        /* compiled from: StoreMessagesLoader.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$5, reason: invalid class name */
        public static final class AnonymousClass5 extends Lambda implements Function1<Subscription, Unit> {
            public AnonymousClass5() {
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
                StoreMessagesLoader.access$setLoadingMessagesSubscription$p(StoreMessagesLoader.this, subscription);
            }
        }

        public AnonymousClass3() {
            super(4);
        }

        public static /* synthetic */ void invoke$default(AnonymousClass3 anonymousClass3, long j, Long l, Long l2, Long l3, int i, Object obj) {
            anonymousClass3.invoke(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : l3);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2, Long l3, Long l4) {
            invoke(l.longValue(), l2, l3, l4);
            return Unit.a;
        }

        public final synchronized void invoke(long j, Long l, Long l2, Long l3) {
            Observable<List<com.discord.api.message.Message>> channelMessages;
            StoreMessagesLoader.access$channelLoadedStateUpdate(StoreMessagesLoader.this, j, AnonymousClass1.INSTANCE);
            if (l == null || l.longValue() != 1) {
                if (l == null || l.longValue() != 0) {
                    if (l != null) {
                        channelMessages = RestAPI.INSTANCE.getApi().getChannelMessagesAround(j, StoreMessagesLoader.access$getMessageRequestSize$p(StoreMessagesLoader.this), l.longValue());
                    }
                    SerializedSubject serializedSubjectAccess$getChannelMessagesLoadingSubject$p = StoreMessagesLoader.access$getChannelMessagesLoadingSubject$p(StoreMessagesLoader.this);
                    serializedSubjectAccess$getChannelMessagesLoadingSubject$p.k.onNext(Boolean.TRUE);
                    Observable observableG = ObservableExtensionsKt.restSubscribeOn(channelMessages, false).G(AnonymousClass2.INSTANCE);
                    Intrinsics3.checkNotNullExpressionValue(observableG, "messagesRequest\n        …messages.map(::Message) }");
                    Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(observableG);
                    Class<?> cls = StoreMessagesLoader.this.getClass();
                    C01613 c01613 = new C01613(j, l, l2, l3);
                    ObservableExtensionsKt.appSubscribe$default(observableComputationLatest, cls, (Context) null, new AnonymousClass5(), new AnonymousClass4(j), (Function0) null, (Function0) null, c01613, 50, (Object) null);
                }
            }
            channelMessages = RestAPI.INSTANCE.getApi().getChannelMessages(j, l2, l3, Integer.valueOf(StoreMessagesLoader.access$getMessageRequestSize$p(StoreMessagesLoader.this)));
            SerializedSubject serializedSubjectAccess$getChannelMessagesLoadingSubject$p2 = StoreMessagesLoader.access$getChannelMessagesLoadingSubject$p(StoreMessagesLoader.this);
            serializedSubjectAccess$getChannelMessagesLoadingSubject$p2.k.onNext(Boolean.TRUE);
            Observable observableG2 = ObservableExtensionsKt.restSubscribeOn(channelMessages, false).G(AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG2, "messagesRequest\n        …messages.map(::Message) }");
            Observable observableComputationLatest2 = ObservableExtensionsKt.computationLatest(observableG2);
            Class<?> cls2 = StoreMessagesLoader.this.getClass();
            C01613 c016132 = new C01613(j, l, l2, l3);
            ObservableExtensionsKt.appSubscribe$default(observableComputationLatest2, cls2, (Context) null, new AnonymousClass5(), new AnonymousClass4(j), (Function0) null, (Function0) null, c016132, 50, (Object) null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t2\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/models/message/Message;", "messages", "", "shouldRequestOlder", "shouldRequestNewer", "", "invoke", "(JLjava/util/List;ZZ)V", "loadPagedMessages"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function4<Long, List<? extends Message>, Boolean, Boolean, Unit> {
        public final /* synthetic */ AnonymousClass3 $loadMessages$3;

        /* compiled from: StoreMessagesLoader.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "it", "invoke", "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                return invoke2(channelLoadedState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 27, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AnonymousClass3 anonymousClass3) {
            super(4);
            this.$loadMessages$3 = anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Message> list, Boolean bool, Boolean bool2) {
            invoke(l.longValue(), (List<Message>) list, bool.booleanValue(), bool2.booleanValue());
            return Unit.a;
        }

        public final synchronized void invoke(long j, List<Message> list, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(list, "messages");
            if (list.isEmpty()) {
                StoreMessagesLoader.access$channelLoadedStateUpdate(StoreMessagesLoader.this, j, AnonymousClass1.INSTANCE);
                return;
            }
            if (z2) {
                AnonymousClass3.invoke$default(this.$loadMessages$3, j, null, Long.valueOf(list.get(0).getId()), null, 10, null);
            } else if (z3) {
                AnonymousClass3.invoke$default(this.$loadMessages$3, j, null, null, Long.valueOf(list.get(list.size() - 1).getId()), 6, null);
            }
        }
    }

    public StoreMessagesLoader(StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.messageRequestSize = 50;
        this.channelMessageChunksSubject = new SerializedSubject<>(BehaviorSubject.k0());
        HashMap<Long, ChannelLoadedState> map = new HashMap<>();
        this.channelLoadedStates = map;
        this.channelLoadedStateSubject = new SerializedSubject<>(BehaviorSubject.l0(new HashMap(map)));
        this.scrollToSubject = new SerializedSubject<>(BehaviorSubject.l0(null));
        this.channelMessagesLoadingSubject = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));
        this.detachedChannels = Sets5.emptySet();
        this.backgrounded = true;
        this.loadingMessagesRetryDelayDefault = 1500L;
        this.loadingMessagesRetryJitter = 2000;
        this.loadingMessagesRetryDelayMillis = 1500L;
        this.loadingMessagesRetryMax = 30000;
    }

    public static final /* synthetic */ void access$channelLoadedStateUpdate(StoreMessagesLoader storeMessagesLoader, long j, Function1 function1) {
        storeMessagesLoader.channelLoadedStateUpdate(j, function1);
    }

    public static final /* synthetic */ SerializedSubject access$getChannelMessagesLoadingSubject$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.channelMessagesLoadingSubject;
    }

    public static final /* synthetic */ Subscription access$getDelayLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.delayLoadingMessagesSubscription;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.dispatcher;
    }

    public static final /* synthetic */ Subscription access$getLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.loadingMessagesSubscription;
    }

    public static final /* synthetic */ int access$getMessageRequestSize$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.messageRequestSize;
    }

    public static final /* synthetic */ SerializedSubject access$getScrollToSubject$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.scrollToSubject;
    }

    public static final /* synthetic */ long access$getSelectedChannelId$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.selectedChannelId;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.stream;
    }

    public static final /* synthetic */ void access$handleChatDetached(StoreMessagesLoader storeMessagesLoader, Set set) {
        storeMessagesLoader.handleChatDetached(set);
    }

    public static final /* synthetic */ void access$handleChatInteraction(StoreMessagesLoader storeMessagesLoader, StoreChat.InteractionState interactionState) {
        storeMessagesLoader.handleChatInteraction(interactionState);
    }

    public static final /* synthetic */ void access$handleLoadMessagesError(StoreMessagesLoader storeMessagesLoader, long j) {
        storeMessagesLoader.handleLoadMessagesError(j);
    }

    public static final /* synthetic */ void access$handleLoadedMessages(StoreMessagesLoader storeMessagesLoader, List list, long j, long j2, Long l, Long l2) {
        storeMessagesLoader.handleLoadedMessages(list, j, j2, l, l2);
    }

    public static final /* synthetic */ void access$setDelayLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader, Subscription subscription) {
        storeMessagesLoader.delayLoadingMessagesSubscription = subscription;
    }

    public static final /* synthetic */ void access$setLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader, Subscription subscription) {
        storeMessagesLoader.loadingMessagesSubscription = subscription;
    }

    public static final /* synthetic */ void access$setSelectedChannelId$p(StoreMessagesLoader storeMessagesLoader, long j) {
        storeMessagesLoader.selectedChannelId = j;
    }

    private final synchronized void channelLoadedStateUpdate(long channelId, Function1<? super ChannelLoadedState, ChannelLoadedState> updater) {
        ChannelLoadedState channelLoadedState = this.channelLoadedStates.get(Long.valueOf(channelId));
        if (channelLoadedState == null) {
            channelLoadedState = new ChannelLoadedState(false, false, false, false, null, 31, null);
        }
        Intrinsics3.checkNotNullExpressionValue(channelLoadedState, "channelLoadedStates[chan…] ?: ChannelLoadedState()");
        this.channelLoadedStates.put(Long.valueOf(channelId), updater.invoke(channelLoadedState));
        SerializedSubject<Map<Long, ChannelLoadedState>, Map<Long, ChannelLoadedState>> serializedSubject = this.channelLoadedStateSubject;
        serializedSubject.k.onNext(new HashMap(this.channelLoadedStates));
    }

    private final void channelLoadedStatesReset() {
        this.channelLoadedStates.clear();
        SerializedSubject<Map<Long, ChannelLoadedState>, Map<Long, ChannelLoadedState>> serializedSubject = this.channelLoadedStateSubject;
        serializedSubject.k.onNext(new HashMap(this.channelLoadedStates));
        Subscription subscription = this.loadingMessagesSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.loadingMessagesRetryDelayMillis = this.loadingMessagesRetryDelayDefault;
        log("Disconnected, resetting all message loaded states.");
    }

    private final synchronized void handleChatDetached(Set<Long> detachedChannels) {
        this.detachedChannels = detachedChannels;
        log("Loaded detached channel state: " + detachedChannels);
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    private final synchronized void handleChatInteraction(StoreChat.InteractionState interactionState) {
        channelLoadedStateUpdate(interactionState.getChannelId(), new StoreMessagesLoader4(interactionState));
        this.interactionState = interactionState;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    private final synchronized void handleLoadMessagesError(long channelId) {
        channelLoadedStateUpdate(channelId, AnonymousClass1.INSTANCE);
        long j = this.loadingMessagesRetryDelayMillis;
        if (j < this.loadingMessagesRetryMax) {
            this.loadingMessagesRetryDelayMillis = (j * 2) + new Random().nextInt(this.loadingMessagesRetryJitter);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to load messages for channel [" + channelId + "], ");
        sb.append("retrying in " + this.loadingMessagesRetryDelayMillis + "ms");
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …}ms\")\n        .toString()");
        log(string);
        tryLoadMessages$default(this, this.loadingMessagesRetryDelayMillis, false, false, false, null, null, 58, null);
    }

    private final synchronized void handleLoadedMessages(List<Message> messages, long channelId, long messageId, Long before, Long after) {
        Object next;
        boolean z2 = messages.size() < this.messageRequestSize;
        boolean z3 = after != null;
        boolean z4 = before != null;
        boolean z5 = !INSTANCE.isScrollToAction(messageId);
        boolean z6 = (z5 || z3 || z4) ? false : true;
        boolean z7 = z6 || (z3 && z2);
        channelLoadedStateUpdate(channelId, new AnonymousClass1(z6, z4, z2, messages));
        this.channelMessagesLoadingSubject.k.onNext(Boolean.FALSE);
        this.channelMessageChunksSubject.k.onNext(new ChannelChunk(channelId, messages, z6, z7, z4, z5));
        boolean z8 = z6 && (messages.isEmpty() ^ true) && messageId == 1;
        if (z8) {
            this.scrollToSubject.k.onNext(1L);
        } else if (z6) {
            this.scrollToSubject.k.onNext(0L);
        }
        if (z5) {
            Iterator<T> it = messages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((Message) next).getId() == messageId) {
                        break;
                    }
                }
            }
            Message message = (Message) next;
            if (message == null) {
                StoreStream.INSTANCE.getReadStates().markAsRead(Long.valueOf(channelId));
            } else {
                this.scrollToSubject.k.onNext(Long.valueOf(message.getId()));
            }
        }
        if (!z5 && !z8) {
            clearScrollTo();
        }
        log("Loaded " + messages.size() + " messages for channel [" + channelId + "], all loaded: " + z2 + '.');
        tryLoadMessages$default(this, this.loadingMessagesRetryDelayDefault, false, false, false, null, null, 58, null);
    }

    public static /* synthetic */ void handleLoadedMessages$default(StoreMessagesLoader storeMessagesLoader, List list, long j, long j2, Long l, Long l2, int i, Object obj) {
        storeMessagesLoader.handleLoadedMessages(list, j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
    }

    private final void log(String message) {
        AppLog.i("[MessageLoader] " + message);
    }

    private final synchronized void tryLoadMessages(long delay, boolean force, boolean resetRetry, boolean resetDelay, Long targetChannelId, Long targetMessageId) {
        long jLongValue = targetChannelId != null ? targetChannelId.longValue() : this.selectedChannelId;
        Subscription subscription = this.delayLoadingMessagesSubscription;
        if (subscription != null && resetDelay) {
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.delayLoadingMessagesSubscription = null;
        }
        if (this.delayLoadingMessagesSubscription == null || force) {
            if (delay > 0) {
                Observable<Long> observableD0 = Observable.d0(delay, TimeUnit.MILLISECONDS);
                Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…y, TimeUnit.MILLISECONDS)");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableD0), getClass(), (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 58, (Object) null);
                return;
            }
            if (resetRetry) {
                this.loadingMessagesRetryDelayMillis = this.loadingMessagesRetryDelayDefault;
            }
            ChannelLoadedState channelLoadedState = this.channelLoadedStates.get(Long.valueOf(jLongValue));
            if (channelLoadedState == null || !channelLoadedState.isLoadingMessages() || force) {
                Subscription subscription2 = this.loadingMessagesSubscription;
                if (subscription2 != null) {
                    subscription2.unsubscribe();
                }
                if (jLongValue > 0 && !this.backgrounded && this.authed) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3();
                    AnonymousClass4 anonymousClass4 = new AnonymousClass4(anonymousClass3);
                    if (targetMessageId != null) {
                        AnonymousClass3.invoke$default(anonymousClass3, jLongValue, targetMessageId, null, null, 12, null);
                    } else if (channelLoadedState == null || !channelLoadedState.isInitialMessagesLoaded()) {
                        AnonymousClass3.invoke$default(anonymousClass3, jLongValue, 0L, null, null, 12, null);
                    } else {
                        this.channelMessagesLoadingSubject.k.onNext(Boolean.FALSE);
                        StoreChat.InteractionState interactionState = this.interactionState;
                        if (interactionState != null) {
                            boolean z2 = false;
                            boolean z3 = interactionState.getIsAtTop() && !channelLoadedState.isOldestMessagesLoaded();
                            if (interactionState.getIsAtBottom() && this.detachedChannels.contains(Long.valueOf(jLongValue))) {
                                z2 = true;
                            }
                            if (interactionState.getChannelId() == jLongValue && (z3 || z2)) {
                                channelLoadedStateUpdate(jLongValue, StoreMessagesLoader5.INSTANCE);
                                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(ObservableExtensionsKt.takeSingleUntilTimeout$default(this.stream.getMessages().observeMessagesForChannel(jLongValue), 0L, false, 3, null)), interactionState.getClass(), (Context) null, (Function1) null, new StoreMessagesLoader3(this, channelLoadedState, jLongValue, anonymousClass4), (Function0) null, (Function0) null, new StoreMessagesLoader2(z3, z2, this, channelLoadedState, jLongValue, anonymousClass4), 54, (Object) null);
                            }
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ void tryLoadMessages$default(StoreMessagesLoader storeMessagesLoader, long j, boolean z2, boolean z3, boolean z4, Long l, Long l2, int i, Object obj) {
        storeMessagesLoader.tryLoadMessages((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) == 0 ? z4 : false, (i & 16) != 0 ? null : l, (i & 32) == 0 ? l2 : null);
    }

    public final void clearScrollTo() {
        this.scrollToSubject.k.onNext(null);
    }

    public final Observable<ChannelChunk> get() {
        return ObservableExtensionsKt.computationBuffered(this.channelMessageChunksSubject);
    }

    public final Observable<ChannelLoadedState> getMessagesLoadedState(long channelId) {
        Observable<R> observableG = this.channelLoadedStateSubject.G(new AnonymousClass1(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableG, "channelLoadedStateSubjec…?: ChannelLoadedState() }");
        Observable<ChannelLoadedState> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "channelLoadedStateSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> getScrollTo() {
        Observable<R> observableG = this.scrollToSubject.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        return ObservableExtensionsKt.computationLatest(observableG);
    }

    public final synchronized void handleAuthToken(String authToken) {
        this.authed = authToken != null;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    public final synchronized void handleBackgrounded(boolean backgrounded) {
        this.backgrounded = backgrounded;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    @Store3
    public final synchronized void handleChannelSelected(long selectedChannelId) {
        channelLoadedStateUpdate(this.selectedChannelId, AnonymousClass1.INSTANCE);
        this.selectedChannelId = selectedChannelId;
        tryLoadMessages$default(this, 0L, true, true, false, null, null, 57, null);
    }

    public final synchronized void handleConnected(boolean connected) {
        if (connected) {
            this.hasConnected = true;
        } else if (this.hasConnected) {
            channelLoadedStatesReset();
        }
        tryLoadMessages$default(this, 0L, false, true, this.hasConnected, null, null, 51, null);
    }

    @Store3
    public final synchronized void handleVoiceChannelJoined(long selectedVoiceChannelId) {
        tryLoadMessages$default(this, 0L, true, true, false, Long.valueOf(selectedVoiceChannelId), null, 41, null);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(this.stream.getChat().observeInteractionState()), StoreMessagesLoader.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMessages().getAllDetached(), StoreMessagesLoader.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }

    public final synchronized void jumpToMessage(long channelId, long messageId) {
        if (messageId <= 0) {
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(channelId, messageId);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(channelId);
        Observable observableY = this.stream.getChannelsSelected().observeId().k(o.c(new AnonymousClass3(channelId), -1L, 1000L, TimeUnit.MILLISECONDS)).Y(new AnonymousClass4(channelId, messageId));
        Intrinsics3.checkNotNullExpressionValue(observableY, "stream\n        .channels…lId, messageId)\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null)), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(anonymousClass1), 62, (Object) null);
        Observable observableA = StoreConnectionOpen.observeConnectionOpen$default(this.stream.getConnectionOpen(), false, 1, null).Z(1).A(new AnonymousClass6(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableA, "stream\n        .connecti…mes.ONE_SECOND)\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableA), getClass(), (Context) null, (Function1) null, AnonymousClass7.INSTANCE, (Function0) null, (Function0) null, new AnonymousClass8(anonymousClass2), 54, (Object) null);
    }

    public final Observable<Boolean> observeChannelMessagesLoading() {
        Observable<Boolean> observableR = ObservableExtensionsKt.computationBuffered(this.channelMessagesLoadingSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "channelMessagesLoadingSu…  .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized void requestNewestMessages() {
        ChannelLoadedState channelLoadedState;
        if (!this.detachedChannels.contains(Long.valueOf(this.selectedChannelId)) && (channelLoadedState = this.channelLoadedStates.get(Long.valueOf(this.selectedChannelId))) != null && channelLoadedState.isInitialMessagesLoaded()) {
            this.scrollToSubject.k.onNext(1L);
        } else {
            channelLoadedStateUpdate(this.selectedChannelId, AnonymousClass1.INSTANCE);
            tryLoadMessages$default(this, 0L, true, false, false, null, 1L, 25, null);
        }
    }
}
