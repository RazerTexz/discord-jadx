package com.discord.widgets.chat.overlay;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorDistinctUntilChanged2;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: ChatTypingModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/discord/widgets/chat/overlay/ChatTypingModel;", "", "<init>", "()V", "Companion", "Hide", "Typing", "Lcom/discord/widgets/chat/overlay/ChatTypingModel$Typing;", "Lcom/discord/widgets/chat/overlay/ChatTypingModel$Hide;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class ChatTypingModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ChatTypingModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0007J#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0007J\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/chat/overlay/ChatTypingModel$Companion;", "", "Lcom/discord/api/channel/Channel;", "resolvedChannel", "Lrx/Observable;", "Lcom/discord/widgets/chat/overlay/ChatTypingModel;", "getTypingObservableForChannel", "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "parentChannel", "getTypingObservableForDraft", "channel", "", "", "getTypingUsers", "get", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$getTypingObservableForChannel(Companion companion, Channel channel) {
            return companion.getTypingObservableForChannel(channel);
        }

        public static final /* synthetic */ Observable access$getTypingObservableForDraft(Companion companion, Channel channel) {
            return companion.getTypingObservableForDraft(channel);
        }

        public static final /* synthetic */ Observable access$getTypingUsers(Companion companion, Channel channel) {
            return companion.getTypingUsers(channel);
        }

        private final Observable<ChatTypingModel> getTypingObservableForChannel(Channel resolvedChannel) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(resolvedChannel);
            Observable<ChatTypingModel> observableY = Observable.h0(new OnSubscribeLift(scalarSynchronousObservable.j, new OperatorDistinctUntilChanged2(ChatTypingModel3.INSTANCE))).Y(ChatTypingModel4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "Observable.just(resolved…          }\n            }");
            return observableY;
        }

        private final Observable<ChatTypingModel> getTypingObservableForDraft(Channel parentChannel) {
            Observable observableY = StoreStream.INSTANCE.getSlowMode().observeCooldownSecs(Long.valueOf(parentChannel.getId()), StoreSlowMode.Type.ThreadCreate.INSTANCE).Y(new ChatTypingModel5(parentChannel));
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …ldownSecs))\n            }");
            return observableY;
        }

        private final Observable<List<CharSequence>> getTypingUsers(Channel channel) {
            Observable<List<CharSequence>> observableR = StoreStream.INSTANCE.getUsersTyping().observeTypingUsers(channel.getId()).Y(new ChatTypingModel6(channel)).G(ChatTypingModel7.INSTANCE).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n          .g…  .distinctUntilChanged()");
            return observableR;
        }

        public final Observable<ChatTypingModel> get() {
            Observable<ChatTypingModel> observableR = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().Y(ChatTypingModel2.INSTANCE).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream.getChannelsS…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatTypingModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/overlay/ChatTypingModel$Hide;", "Lcom/discord/widgets/chat/overlay/ChatTypingModel;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Hide extends ChatTypingModel {
        public static final Hide INSTANCE = new Hide();

        private Hide() {
            super(null);
        }
    }

    /* compiled from: ChatTypingModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ4\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\bJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/chat/overlay/ChatTypingModel$Typing;", "Lcom/discord/widgets/chat/overlay/ChatTypingModel;", "", "", "component1", "()Ljava/util/List;", "", "component2", "()I", "component3", "typingUsers", "channelRateLimit", "cooldownSecs", "copy", "(Ljava/util/List;II)Lcom/discord/widgets/chat/overlay/ChatTypingModel$Typing;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getChannelRateLimit", "Ljava/util/List;", "getTypingUsers", "getCooldownSecs", "<init>", "(Ljava/util/List;II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Typing extends ChatTypingModel {
        private final int channelRateLimit;
        private final int cooldownSecs;
        private final List<CharSequence> typingUsers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Typing(List<? extends CharSequence> list, int i, int i2) {
            super(null);
            Intrinsics3.checkNotNullParameter(list, "typingUsers");
            this.typingUsers = list;
            this.channelRateLimit = i;
            this.cooldownSecs = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Typing copy$default(Typing typing, List list, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = typing.typingUsers;
            }
            if ((i3 & 2) != 0) {
                i = typing.channelRateLimit;
            }
            if ((i3 & 4) != 0) {
                i2 = typing.cooldownSecs;
            }
            return typing.copy(list, i, i2);
        }

        public final List<CharSequence> component1() {
            return this.typingUsers;
        }

        /* renamed from: component2, reason: from getter */
        public final int getChannelRateLimit() {
            return this.channelRateLimit;
        }

        /* renamed from: component3, reason: from getter */
        public final int getCooldownSecs() {
            return this.cooldownSecs;
        }

        public final Typing copy(List<? extends CharSequence> typingUsers, int channelRateLimit, int cooldownSecs) {
            Intrinsics3.checkNotNullParameter(typingUsers, "typingUsers");
            return new Typing(typingUsers, channelRateLimit, cooldownSecs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Typing)) {
                return false;
            }
            Typing typing = (Typing) other;
            return Intrinsics3.areEqual(this.typingUsers, typing.typingUsers) && this.channelRateLimit == typing.channelRateLimit && this.cooldownSecs == typing.cooldownSecs;
        }

        public final int getChannelRateLimit() {
            return this.channelRateLimit;
        }

        public final int getCooldownSecs() {
            return this.cooldownSecs;
        }

        public final List<CharSequence> getTypingUsers() {
            return this.typingUsers;
        }

        public int hashCode() {
            List<CharSequence> list = this.typingUsers;
            return ((((list != null ? list.hashCode() : 0) * 31) + this.channelRateLimit) * 31) + this.cooldownSecs;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Typing(typingUsers=");
            sbU.append(this.typingUsers);
            sbU.append(", channelRateLimit=");
            sbU.append(this.channelRateLimit);
            sbU.append(", cooldownSecs=");
            return outline.B(sbU, this.cooldownSecs, ")");
        }
    }

    private ChatTypingModel() {
    }

    public /* synthetic */ ChatTypingModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
