package com.discord.widgets.forums;

import android.content.ContentResolver;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.NonceGenerator;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.MessageManager;
import com.lytefast.flexinput.model.Attachment;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.MultipartBody;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: ForumPostCreateManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010.Jy\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u000f0\n2\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00110\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00132\n\u0010\u0018\u001a\u00060\u0004j\u0002`\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0089\u0001\u0010'\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\n\u0010\u001e\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u001c\b\u0002\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$\u0018\u00010#2\u001c\b\u0002\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$\u0018\u00010#¢\u0006\u0004\b'\u0010(R:\u0010+\u001a&\u0012\f\u0012\n **\u0004\u0018\u00010\u00190\u0019 **\u0012\u0012\f\u0012\n **\u0004\u0018\u00010\u00190\u0019\u0018\u00010)0)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/discord/widgets/forums/ForumPostCreateManager;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "content", "", "Lcom/lytefast/flexinput/model/Attachment;", "attachments", "", "autoArchiveDuration", "Lcom/discord/primitives/ForumTagId;", "appliedTags", "Lcom/discord/primitives/StickerId;", "stickerIds", "Lrx/Observable;", "Lcom/discord/api/channel/Channel;", "sendCreateForumPostWithMessageRequest", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/util/List;Ljava/util/List;)Lrx/Observable;", "Lcom/discord/primitives/GuildId;", "guildId", "", "observeIsForumPostCreateInProgress", "(J)Lrx/Observable;", "Lcom/discord/widgets/chat/MessageManager;", "messageManager", "forumChannelId", "Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "threadDraftState", "Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;", "attachmentsRequest", "Lkotlin/Function2;", "", "onMessageTooLong", "onFilesTooLarge", "createForumPostWithMessage", "(Landroid/content/Context;Lcom/discord/widgets/chat/MessageManager;JILjava/lang/String;Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;Lcom/discord/widgets/chat/MessageManager$AttachmentsRequest;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "isCreateInProgressBehaviorSubject", "Lrx/subjects/BehaviorSubject;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ForumPostCreateManager {
    public static final ForumPostCreateManager INSTANCE = new ForumPostCreateManager();
    private static final BehaviorSubject<Boolean> isCreateInProgressBehaviorSubject = BehaviorSubject.l0(Boolean.FALSE);

    /* compiled from: ForumPostCreateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends Channel>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Channel> call2(Channel channel) {
            Observable<R> observableG = StoreStream.INSTANCE.getChannels().observeChannel(channel.getId()).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null));
        }
    }

    /* compiled from: ForumPostCreateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $forumChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$forumChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            StoreStream.INSTANCE.getSlowMode().onThreadCreated(this.$forumChannelId);
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
        }
    }

    /* compiled from: ForumPostCreateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ long $forumChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context, long j) {
            super(1);
            this.$context = context;
            this.$forumChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            ThreadUtils.INSTANCE.handleThreadCreateError(this.$context, error, this.$forumChannelId);
        }
    }

    /* compiled from: ForumPostCreateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ForumPostCreateManager.access$isCreateInProgressBehaviorSubject$p(ForumPostCreateManager.INSTANCE).onNext(Boolean.FALSE);
        }
    }

    /* compiled from: ForumPostCreateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "canAccess", "isCreateInProgress", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumPostCreateManager$observeIsForumPostCreateInProgress$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2) {
            return call2(bool, bool2);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean call2(Boolean bool, Boolean bool2) {
            boolean z2;
            Intrinsics3.checkNotNullExpressionValue(bool, "canAccess");
            if (bool.booleanValue()) {
                Intrinsics3.checkNotNullExpressionValue(bool2, "isCreateInProgress");
                z2 = bool2.booleanValue();
            }
            return Boolean.valueOf(z2);
        }
    }

    /* compiled from: ForumPostCreateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSend;", "kotlin.jvm.PlatformType", "sendPayload", "Lrx/Observable;", "Lcom/discord/api/channel/Channel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSend;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumPostCreateManager$sendCreateForumPostWithMessageRequest$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<SendUtils.SendPayload.ReadyToSend, Observable<? extends Channel>> {
        public final /* synthetic */ List $appliedTags;
        public final /* synthetic */ int $autoArchiveDuration;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ String $name;
        public final /* synthetic */ List $stickerIds;

        public AnonymousClass1(long j, String str, List list, List list2, int i) {
            this.$channelId = j;
            this.$name = str;
            this.$appliedTags = list;
            this.$stickerIds = list2;
            this.$autoArchiveDuration = i;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Channel> call(SendUtils.SendPayload.ReadyToSend readyToSend) {
            return call2(readyToSend);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Channel> call2(SendUtils.SendPayload.ReadyToSend readyToSend) {
            List<SendUtils.FileUpload> uploads = readyToSend.getUploads();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(((SendUtils.FileUpload) it.next()).getPart());
            }
            RestAPI api = RestAPI.INSTANCE.getApi();
            long j = this.$channelId;
            String str = this.$name;
            String content = readyToSend.getMessage().getContent();
            if (content == null) {
                content = "";
            }
            String str2 = content;
            List<Long> list = this.$appliedTags;
            List<Long> list2 = this.$stickerIds;
            Integer numValueOf = Integer.valueOf(this.$autoArchiveDuration);
            Object[] array = arrayList.toArray(new MultipartBody.Part[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return api.createThreadWithMessage(j, str, str2, list, list2, 11, numValueOf, (MultipartBody.Part[]) array);
        }
    }

    private ForumPostCreateManager() {
    }

    public static final /* synthetic */ BehaviorSubject access$isCreateInProgressBehaviorSubject$p(ForumPostCreateManager forumPostCreateManager) {
        return isCreateInProgressBehaviorSubject;
    }

    public static /* synthetic */ void createForumPostWithMessage$default(ForumPostCreateManager forumPostCreateManager, Context context, MessageManager messageManager, long j, int i, String str, StoreThreadDraft.ThreadDraftState threadDraftState, MessageManager.AttachmentsRequest attachmentsRequest, Function2 function2, Function2 function22, int i2, Object obj) {
        forumPostCreateManager.createForumPostWithMessage(context, messageManager, j, i, str, threadDraftState, (i2 & 64) != 0 ? null : attachmentsRequest, (i2 & 128) != 0 ? null : function2, (i2 & 256) != 0 ? null : function22);
    }

    private final Observable<Channel> sendCreateForumPostWithMessageRequest(Context context, long channelId, String name, String content, List<? extends Attachment<?>> attachments, int autoArchiveDuration, List<Long> appliedTags, List<Long> stickerIds) {
        RestAPIParams.Message message = new RestAPIParams.Message(content, String.valueOf(NonceGenerator.Companion.computeNonce$default(NonceGenerator.INSTANCE, null, 1, null)), null, null, stickerIds, null, null, null, null);
        SendUtils sendUtils = SendUtils.INSTANCE;
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        Observable<R> observableG = sendUtils.getSendPayload(contentResolver, message, attachments).y(ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$1.INSTANCE).G(ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        Observable<Channel> observableA = observableG.Z(1).A(new AnonymousClass1(channelId, name, appliedTags, stickerIds, autoArchiveDuration));
        Intrinsics3.checkNotNullExpressionValue(observableA, "SendUtils\n        .getSe…(),\n          )\n        }");
        return observableA;
    }

    public final void createForumPostWithMessage(Context context, MessageManager messageManager, long forumChannelId, int autoArchiveDuration, String content, StoreThreadDraft.ThreadDraftState threadDraftState, MessageManager.AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
        Intrinsics3.checkNotNullParameter(content, "content");
        Intrinsics3.checkNotNullParameter(threadDraftState, "threadDraftState");
        BehaviorSubject<Boolean> behaviorSubject = isCreateInProgressBehaviorSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "isCreateInProgressBehaviorSubject");
        Boolean boolN0 = behaviorSubject.n0();
        Intrinsics3.checkNotNullExpressionValue(boolN0, "isCreateInProgressBehaviorSubject.value");
        if (boolN0.booleanValue()) {
            return;
        }
        String threadName = threadDraftState.getThreadName();
        if (threadName == null || threadName.length() == 0) {
            StoreStream.INSTANCE.getThreadDraft().setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(threadDraftState, false, null, null, false, true, 15, null));
        } else if (messageManager.isValidForumPostFirstMessage(content, attachmentsRequest, onMessageTooLong, onFilesTooLarge)) {
            behaviorSubject.onNext(Boolean.TRUE);
            Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(sendCreateForumPostWithMessageRequest(context, forumChannelId, threadName, content, attachmentsRequest != null ? attachmentsRequest.getAttachments() : null, autoArchiveDuration, Collections2.emptyList(), Collections2.emptyList()), false, 1, null).A(AnonymousClass1.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableA, "sendCreateForumPostWithM…utationLatest()\n        }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableA), ForumPostCreateManager.class, (Context) null, (Function1) null, new AnonymousClass3(context, forumChannelId), (Function0) null, AnonymousClass4.INSTANCE, new AnonymousClass2(forumChannelId), 22, (Object) null);
        }
    }

    public final Observable<Boolean> observeIsForumPostCreateInProgress(long guildId) {
        Observable<Boolean> observableJ = Observable.j(ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, null, 6, null), isCreateInProgressBehaviorSubject, AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…s && isCreateInProgress }");
        return observableJ;
    }
}
