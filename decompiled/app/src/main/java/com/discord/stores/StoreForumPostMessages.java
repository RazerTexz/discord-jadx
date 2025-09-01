package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.forum.ForumPostFirstMessages;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelPayload;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.f0._Sequences2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* compiled from: StoreForumPostMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 [2\u00020\u0001:\u0001[B!\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010N\u001a\u00020M\u0012\b\b\u0002\u0010T\u001a\u00020S¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u001b\u0010\u0015\u001a\u00020\u00142\n\u0010\u0013\u001a\u00060\fj\u0002`\rH\u0003¢\u0006\u0004\b\u0015\u0010\u0016J;\u0010\u001b\u001a\u00020\u00142\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019H\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\u00020\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\"\u0010!J\u001b\u0010$\u001a\u00020\u00142\n\u0010#\u001a\u00060\fj\u0002`\rH\u0007¢\u0006\u0004\b$\u0010\u0016J\u0017\u0010'\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b)\u0010(J\u0017\u0010,\u001a\u00020\u00142\u0006\u0010+\u001a\u00020*H\u0007¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b.\u0010!J\u0017\u0010/\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b/\u0010!J\u0017\u00102\u001a\u00020\u00142\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b6\u00105J\u0017\u00107\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b7\u00105J\u0017\u00108\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b8\u00105J%\u00109\u001a\u00020\u00142\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\n\u0010\u000e\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\u00142\n\u0010\u0013\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b;\u0010\u0016J#\u0010>\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\t0=0<¢\u0006\u0004\b>\u0010?J7\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0<2\n\u0010\u0013\u001a\u00060\fj\u0002`\r2\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\b\b\u0002\u0010@\u001a\u00020\u0004¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0014H\u0016¢\u0006\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR0\u0010J\u001a\u001c\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u000e\u0012\f\u0012\b\u0012\u00060\fj\u0002`\r0I0H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR&\u0010L\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\t0=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010KR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR&\u0010P\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\t0H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010KR\u0016\u0010Q\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR \u0010V\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR \u0010X\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010W¨\u0006\\"}, d2 = {"Lcom/discord/stores/StoreForumPostMessages;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/message/Message;", "message", "", "isFirstMessage", "(Lcom/discord/api/message/Message;)Z", "Lcom/discord/api/message/reaction/MessageReactionUpdate;", "update", "Lcom/discord/models/message/Message;", "getFirstMessageForReactionUpdate", "(Lcom/discord/api/message/reaction/MessageReactionUpdate;)Lcom/discord/models/message/Message;", "", "Lcom/discord/primitives/ChannelId;", "postId", "isFetchingForumPostFirstMessage", "(J)Z", "expectForumPostFirstMessageFromGateway", "hasForumPostFirstMessage", "parentChannelId", "", "flushForumPostFirstMessageQueueHelper", "(J)V", "", "postIds", "Lkotlin/Function0;", "onTerminated", "fetchForumPosts", "(JLjava/util/List;Lkotlin/jvm/functions/Function0;)V", "messages", "bulkCreateFirstMessage", "(Ljava/util/List;)V", "createFirstMessage", "(Lcom/discord/api/message/Message;)V", "updateFirstMessage", "channelId", "deleteFirstMessage", "Lcom/discord/api/channel/Channel;", "channel", "handleThreadCreateOrUpdate", "(Lcom/discord/api/channel/Channel;)V", "handleThreadDelete", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleMessageCreate", "handleMessageUpdate", "Lcom/discord/models/domain/ModelMessageDelete;", "messageDelete", "handleMessageDelete", "(Lcom/discord/models/domain/ModelMessageDelete;)V", "handleReactionAdd", "(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", "handleReactionRemove", "handleReactionRemoveEmoji", "handleReactionRemoveAll", "enqueueForumPostFirstMessageFetch", "(JJ)V", "flushForumPostFirstMessageQueue", "Lrx/Observable;", "", "observeForumPostFirstMessages", "()Lrx/Observable;", "fetchIfMissing", "observeForumPostFirstMessage", "(JJZ)Lrx/Observable;", "snapshotData", "()V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "", "", "forumPostFetchQueue", "Ljava/util/Map;", "forumPostFirstMessageSnapshot", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "forumPostFirstMessage", "forumPostRequestQueueProcessing", "Z", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "shouldGetForumPostFirstMessageFromGateway", "Ljava/util/Set;", "forumPostFirstMessageFetchSent", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreUser;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreForumPostMessages extends StoreV2 {
    public static final int MAX_REQUEST_BODY_POST_IDS = 10;
    private final Dispatcher dispatcher;
    private Map<Long, Set<Long>> forumPostFetchQueue;
    private final Map<Long, Message> forumPostFirstMessage;
    private Set<Long> forumPostFirstMessageFetchSent;
    private Map<Long, Message> forumPostFirstMessageSnapshot;
    private boolean forumPostRequestQueueProcessing;
    private final ObservationDeck observationDeck;
    private Set<Long> shouldGetForumPostFirstMessageFromGateway;
    private final StoreUser storeUser;

    /* compiled from: StoreForumPostMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreForumPostMessages$enqueueForumPostFirstMessageFetch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $parentChannelId;
        public final /* synthetic */ long $postId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$postId = j;
            this.$parentChannelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreForumPostMessages.access$hasForumPostFirstMessage(StoreForumPostMessages.this, this.$postId) || StoreForumPostMessages.access$isFetchingForumPostFirstMessage(StoreForumPostMessages.this, this.$postId) || StoreForumPostMessages.access$expectForumPostFirstMessageFromGateway(StoreForumPostMessages.this, this.$postId)) {
                return;
            }
            Set linkedHashSet = (Set) StoreForumPostMessages.access$getForumPostFetchQueue$p(StoreForumPostMessages.this).get(Long.valueOf(this.$parentChannelId));
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
            }
            linkedHashSet.add(Long.valueOf(this.$postId));
            StoreForumPostMessages.access$getForumPostFetchQueue$p(StoreForumPostMessages.this).put(Long.valueOf(this.$parentChannelId), linkedHashSet);
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 $onTerminated;

        /* compiled from: StoreForumPostMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01101 extends Lambda implements Function0<Unit> {
            public C01101() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1.this.$onTerminated.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(0);
            this.$onTerminated = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreForumPostMessages.access$getDispatcher$p(StoreForumPostMessages.this).schedule(new C01101());
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/forum/ForumPostFirstMessages;", "response", "", "invoke", "(Lcom/discord/api/forum/ForumPostFirstMessages;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ForumPostFirstMessages, Unit> {

        /* compiled from: StoreForumPostMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ForumPostFirstMessages $response;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ForumPostFirstMessages forumPostFirstMessages) {
                super(0);
                this.$response = forumPostFirstMessages;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreForumPostMessages.this.bulkCreateFirstMessage(_Sequences2.toList(_Sequences2.filterNotNull(_Sequences2.map(_Collections.asSequence(this.$response.a().values()), StoreForumPostMessages2.INSTANCE))));
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ForumPostFirstMessages forumPostFirstMessages) {
            invoke2(forumPostFirstMessages);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForumPostFirstMessages forumPostFirstMessages) {
            Intrinsics3.checkNotNullParameter(forumPostFirstMessages, "response");
            StoreForumPostMessages.access$getDispatcher$p(StoreForumPostMessages.this).schedule(new AnonymousClass1(forumPostFirstMessages));
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreForumPostMessages$flushForumPostFirstMessageQueue$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $parentChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$parentChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreForumPostMessages.access$getForumPostRequestQueueProcessing$p(StoreForumPostMessages.this)) {
                return;
            }
            StoreForumPostMessages.access$setForumPostRequestQueueProcessing$p(StoreForumPostMessages.this, true);
            StoreForumPostMessages.access$flushForumPostFirstMessageQueueHelper(StoreForumPostMessages.this, this.$parentChannelId);
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreForumPostMessages$flushForumPostFirstMessageQueueHelper$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $parentChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$parentChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Collection collection = (Collection) StoreForumPostMessages.access$getForumPostFetchQueue$p(StoreForumPostMessages.this).get(Long.valueOf(this.$parentChannelId));
            if (collection == null || collection.isEmpty()) {
                StoreForumPostMessages.access$setForumPostRequestQueueProcessing$p(StoreForumPostMessages.this, false);
            } else {
                StoreForumPostMessages.access$flushForumPostFirstMessageQueueHelper(StoreForumPostMessages.this, this.$parentChannelId);
            }
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/message/Message;", "invoke", "()Lcom/discord/models/message/Message;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreForumPostMessages$observeForumPostFirstMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Message> {
        public final /* synthetic */ long $postId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$postId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Message invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Message invoke() {
            return (Message) StoreForumPostMessages.access$getForumPostFirstMessageSnapshot$p(StoreForumPostMessages.this).get(Long.valueOf(this.$postId));
        }
    }

    /* compiled from: StoreForumPostMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/models/message/Message;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreForumPostMessages$observeForumPostFirstMessages$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Message>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Message> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Message> invoke2() {
            return StoreForumPostMessages.access$getForumPostFirstMessageSnapshot$p(StoreForumPostMessages.this);
        }
    }

    public /* synthetic */ StoreForumPostMessages(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUser, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ boolean access$expectForumPostFirstMessageFromGateway(StoreForumPostMessages storeForumPostMessages, long j) {
        return storeForumPostMessages.expectForumPostFirstMessageFromGateway(j);
    }

    public static final /* synthetic */ void access$flushForumPostFirstMessageQueueHelper(StoreForumPostMessages storeForumPostMessages, long j) {
        storeForumPostMessages.flushForumPostFirstMessageQueueHelper(j);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.dispatcher;
    }

    public static final /* synthetic */ Map access$getForumPostFetchQueue$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.forumPostFetchQueue;
    }

    public static final /* synthetic */ Map access$getForumPostFirstMessageSnapshot$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.forumPostFirstMessageSnapshot;
    }

    public static final /* synthetic */ boolean access$getForumPostRequestQueueProcessing$p(StoreForumPostMessages storeForumPostMessages) {
        return storeForumPostMessages.forumPostRequestQueueProcessing;
    }

    public static final /* synthetic */ boolean access$hasForumPostFirstMessage(StoreForumPostMessages storeForumPostMessages, long j) {
        return storeForumPostMessages.hasForumPostFirstMessage(j);
    }

    public static final /* synthetic */ boolean access$isFetchingForumPostFirstMessage(StoreForumPostMessages storeForumPostMessages, long j) {
        return storeForumPostMessages.isFetchingForumPostFirstMessage(j);
    }

    public static final /* synthetic */ void access$setForumPostFetchQueue$p(StoreForumPostMessages storeForumPostMessages, Map map) {
        storeForumPostMessages.forumPostFetchQueue = map;
    }

    public static final /* synthetic */ void access$setForumPostFirstMessageSnapshot$p(StoreForumPostMessages storeForumPostMessages, Map map) {
        storeForumPostMessages.forumPostFirstMessageSnapshot = map;
    }

    public static final /* synthetic */ void access$setForumPostRequestQueueProcessing$p(StoreForumPostMessages storeForumPostMessages, boolean z2) {
        storeForumPostMessages.forumPostRequestQueueProcessing = z2;
    }

    @Store3
    private final boolean expectForumPostFirstMessageFromGateway(long postId) {
        return this.shouldGetForumPostFirstMessageFromGateway.contains(Long.valueOf(postId));
    }

    @Store3
    private final void fetchForumPosts(long parentChannelId, List<Long> postIds, Function0<Unit> onTerminated) {
        this.forumPostFirstMessageFetchSent.addAll(postIds);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RetryWithDelay.restRetry$default(RetryWithDelay.INSTANCE, RestAPI.INSTANCE.getApi().getForumPostData(parentChannelId, new RestAPIParams.GetForumPostData(postIds)), 0L, null, null, 7, null), false, 1, null), StoreForumPostMessages.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, new AnonymousClass1(onTerminated), new AnonymousClass2(), 30, (Object) null);
    }

    @Store3
    private final void flushForumPostFirstMessageQueueHelper(long parentChannelId) {
        Set<Long> set = this.forumPostFetchQueue.get(Long.valueOf(parentChannelId));
        if (set == null || set.isEmpty()) {
            this.forumPostRequestQueueProcessing = false;
            return;
        }
        List<Long> listTake = _Collections.take(set, 10);
        this.forumPostFetchQueue.put(Long.valueOf(parentChannelId), _Collections.toMutableSet(_Sets.minus((Set) set, (Iterable) listTake)));
        fetchForumPosts(parentChannelId, listTake, new AnonymousClass1(parentChannelId));
    }

    @Store3
    private final Message getFirstMessageForReactionUpdate(MessageReactionUpdate update) {
        Message message = this.forumPostFirstMessage.get(Long.valueOf(update.getChannelId()));
        if (message == null || message.getId() != update.getMessageId()) {
            return null;
        }
        return message;
    }

    @Store3
    private final boolean hasForumPostFirstMessage(long postId) {
        return this.forumPostFirstMessage.containsKey(Long.valueOf(postId));
    }

    @Store3
    private final boolean isFetchingForumPostFirstMessage(long postId) {
        return this.forumPostFirstMessageFetchSent.contains(Long.valueOf(postId));
    }

    private final boolean isFirstMessage(com.discord.api.message.Message message) {
        return message.getId() == message.getChannelId();
    }

    public static /* synthetic */ Observable observeForumPostFirstMessage$default(StoreForumPostMessages storeForumPostMessages, long j, long j2, boolean z2, int i, Object obj) {
        return storeForumPostMessages.observeForumPostFirstMessage(j, j2, (i & 4) != 0 ? false : z2);
    }

    @Store3
    public final void bulkCreateFirstMessage(List<com.discord.api.message.Message> messages) {
        Intrinsics3.checkNotNullParameter(messages, "messages");
        ArrayList<com.discord.api.message.Message> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (isFirstMessage((com.discord.api.message.Message) obj)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            for (com.discord.api.message.Message message : arrayList) {
                this.forumPostFirstMessage.put(Long.valueOf(message.getChannelId()), new Message(message));
                this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(message.getChannelId()));
            }
            markChanged();
        }
    }

    @Store3
    public final void createFirstMessage(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        if (isFirstMessage(message)) {
            this.forumPostFirstMessage.put(Long.valueOf(message.getChannelId()), new Message(message));
            this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(message.getChannelId()));
            markChanged();
        }
    }

    @Store3
    public final void deleteFirstMessage(long channelId) {
        Message messageRemove = this.forumPostFirstMessage.remove(Long.valueOf(channelId));
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(channelId));
        if (messageRemove != null) {
            markChanged();
        }
    }

    public final void enqueueForumPostFirstMessageFetch(long parentChannelId, long postId) {
        this.dispatcher.schedule(new AnonymousClass1(postId, parentChannelId));
    }

    public final void flushForumPostFirstMessageQueue(long parentChannelId) {
        this.dispatcher.schedule(new AnonymousClass1(parentChannelId));
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.forumPostFirstMessage.clear();
        this.forumPostFetchQueue.clear();
        this.shouldGetForumPostFirstMessageFromGateway.clear();
        this.forumPostFirstMessageFetchSent.clear();
        this.forumPostRequestQueueProcessing = false;
    }

    @Store3
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        createFirstMessage(message);
    }

    @Store3
    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        Intrinsics3.checkNotNullParameter(messageDelete, "messageDelete");
        Message message = this.forumPostFirstMessage.get(Long.valueOf(messageDelete.getChannelId()));
        if (message == null || !messageDelete.getMessageIds().contains(Long.valueOf(message.getId()))) {
            return;
        }
        deleteFirstMessage(message.getChannelId());
    }

    @Store3
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        updateFirstMessage(message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    @Store3
    public final void handleReactionAdd(MessageReactionUpdate update) {
        ArrayList list;
        List arrayList;
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            MessageReaction messageReaction = null;
            if (reactions != null) {
                Iterator it = reactions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ?? next = it.next();
                    if (Intrinsics3.areEqual(((MessageReaction) next).getEmoji().c(), update.getEmoji().c())) {
                        messageReaction = next;
                        break;
                    }
                }
                messageReaction = messageReaction;
            }
            if (messageReaction == null) {
                boolean z2 = update.getUserId() == this.storeUser.getMeSnapshot().getId();
                List<MessageReaction> reactions2 = firstMessageForReactionUpdate.getReactions();
                if (reactions2 == null || (arrayList = _Collections.toMutableList((Collection) reactions2)) == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(new MessageReaction(1, update.getEmoji(), z2));
                list = _Collections.toList(arrayList);
            } else {
                List<MessageReaction> reactions3 = firstMessageForReactionUpdate.getReactions();
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(reactions3, 10));
                for (MessageReaction messageReaction2 : reactions3) {
                    if (Intrinsics3.areEqual(messageReaction2.getEmoji().c(), update.getEmoji().c())) {
                        messageReaction2 = new MessageReaction(messageReaction2.getCount() + 1, messageReaction2.getEmoji(), update.getUserId() == this.storeUser.getMeSnapshot().getId() ? true : messageReaction2.getMe());
                    }
                    arrayList2.add(messageReaction2);
                }
                list = arrayList2;
            }
            this.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, list, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @Store3
    public final void handleReactionRemove(MessageReactionUpdate update) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            if (reactions != null) {
                ArrayList arrayList2 = new ArrayList();
                for (MessageReaction messageReaction : reactions) {
                    if (Intrinsics3.areEqual(messageReaction.getEmoji().c(), update.getEmoji().c())) {
                        boolean me2 = update.getUserId() == this.storeUser.getMeSnapshot().getId() ? false : messageReaction.getMe();
                        int count = messageReaction.getCount() - 1;
                        messageReaction = count > 0 ? new MessageReaction(count, messageReaction.getEmoji(), me2) : null;
                    }
                    if (messageReaction != null) {
                        arrayList2.add(messageReaction);
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            this.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @Store3
    public final void handleReactionRemoveAll(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            this.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @Store3
    public final void handleReactionRemoveEmoji(MessageReactionUpdate update) {
        ArrayList arrayList;
        StoreForumPostMessages storeForumPostMessages;
        Intrinsics3.checkNotNullParameter(update, "update");
        Message firstMessageForReactionUpdate = getFirstMessageForReactionUpdate(update);
        if (firstMessageForReactionUpdate != null) {
            List<MessageReaction> reactions = firstMessageForReactionUpdate.getReactions();
            if (reactions != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : reactions) {
                    if (!Intrinsics3.areEqual(((MessageReaction) obj).getEmoji().c(), update.getEmoji().c())) {
                        arrayList2.add(obj);
                    }
                }
                storeForumPostMessages = this;
                arrayList = arrayList2;
            } else {
                arrayList = null;
                storeForumPostMessages = this;
            }
            storeForumPostMessages.forumPostFirstMessage.put(Long.valueOf(firstMessageForReactionUpdate.getChannelId()), Message.copy$default(firstMessageForReactionUpdate, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null));
            markChanged();
        }
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (hasForumPostFirstMessage(channel.getId()) || isFetchingForumPostFirstMessage(channel.getId())) {
            return;
        }
        this.shouldGetForumPostFirstMessageFromGateway.add(Long.valueOf(channel.getId()));
    }

    @Store3
    public final void handleThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(channel.getId()));
    }

    public final Observable<Message> observeForumPostFirstMessage(long parentChannelId, long postId, boolean fetchIfMissing) {
        if (fetchIfMissing && this.forumPostFirstMessageSnapshot.get(Long.valueOf(postId)) == null) {
            enqueueForumPostFirstMessageFetch(parentChannelId, postId);
            flushForumPostFirstMessageQueue(parentChannelId);
        }
        Observable<Message> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(postId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Message>> observeForumPostFirstMessages() {
        Observable<Map<Long, Message>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.forumPostFirstMessageSnapshot = new HashMap(this.forumPostFirstMessage);
    }

    @Store3
    public final void updateFirstMessage(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Message message2 = this.forumPostFirstMessage.get(Long.valueOf(message.getChannelId()));
        if (message2 == null || !isFirstMessage(message)) {
            return;
        }
        this.forumPostFirstMessage.put(Long.valueOf(message.getChannelId()), message2.merge(message));
        this.shouldGetForumPostFirstMessageFromGateway.remove(Long.valueOf(message.getChannelId()));
        markChanged();
    }

    public StoreForumPostMessages(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeUser = storeUser;
        this.observationDeck = observationDeck;
        this.forumPostFirstMessage = new HashMap();
        this.forumPostFirstMessageSnapshot = Maps6.emptyMap();
        this.shouldGetForumPostFirstMessageFromGateway = new LinkedHashSet();
        this.forumPostFirstMessageFetchSent = new HashSet();
        this.forumPostFetchQueue = new HashMap();
    }
}
