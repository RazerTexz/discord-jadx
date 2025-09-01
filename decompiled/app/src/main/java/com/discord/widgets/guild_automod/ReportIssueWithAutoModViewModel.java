package com.discord.widgets.guild_automod;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.guildautomod.AutoModUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: ReportIssueWithAutoModViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eB9\u0012\n\u0010\u0015\u001a\u00060\u0010j\u0002`\u0014\u0012\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00060\u0010j\u0002`\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00060\u0010j\u0002`\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState;", "Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;)V", "Lcom/discord/widgets/guild_automod/FeedbackType;", "feedbackType", "onFeedbackTypeSelected", "(Lcom/discord/widgets/guild_automod/FeedbackType;)V", "Lkotlin/Function0;", "onCompleted", "onSubmit", "(Lkotlin/jvm/functions/Function0;)V", "", "Lcom/discord/primitives/MessageId;", "messageId", "J", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreMessages;", "messageStore", "Lrx/Observable;", "storeStateObservable", "<init>", "(JJLcom/discord/stores/StoreMessages;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ReportIssueWithAutoModViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long messageId;

    /* compiled from: ReportIssueWithAutoModViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(ReportIssueWithAutoModViewModel reportIssueWithAutoModViewModel) {
            super(1, reportIssueWithAutoModViewModel, ReportIssueWithAutoModViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ReportIssueWithAutoModViewModel.access$handleStoreState((ReportIssueWithAutoModViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: ReportIssueWithAutoModViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "messageId", "Lcom/discord/stores/StoreMessages;", "messageStore", "Lrx/Observable;", "Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;", "observeStores", "(JJLcom/discord/stores/StoreMessages;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j, long j2, StoreMessages storeMessages) {
            return companion.observeStores(j, j2, storeMessages);
        }

        private final Observable<StoreState> observeStores(long channelId, long messageId, StoreMessages messageStore) {
            Observable observableG = messageStore.observeMessagesForChannel(channelId, messageId).G(ReportIssueWithAutoModViewModel3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "messageStore.observeMess…te(clientMessage)\n      }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ReportIssueWithAutoModViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;", "", "Lcom/discord/models/message/Message;", "component1", "()Lcom/discord/models/message/Message;", "message", "copy", "(Lcom/discord/models/message/Message;)Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/message/Message;", "getMessage", "<init>", "(Lcom/discord/models/message/Message;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Message message;

        public StoreState(Message message) {
            this.message = message;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Message message, int i, Object obj) {
            if ((i & 1) != 0) {
                message = storeState.message;
            }
            return storeState.copy(message);
        }

        /* renamed from: component1, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        public final StoreState copy(Message message) {
            return new StoreState(message);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && Intrinsics3.areEqual(this.message, ((StoreState) other).message);
            }
            return true;
        }

        public final Message getMessage() {
            return this.message;
        }

        public int hashCode() {
            Message message = this.message;
            if (message != null) {
                return message.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(message=");
            sbU.append(this.message);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: ReportIssueWithAutoModViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: ReportIssueWithAutoModViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: ReportIssueWithAutoModViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState$Valid;", "Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState;", "Lcom/discord/models/message/Message;", "component1", "()Lcom/discord/models/message/Message;", "", "component2", "()Ljava/lang/String;", "message", "selectedOption", "copy", "(Lcom/discord/models/message/Message;Ljava/lang/String;)Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$ViewState$Valid;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSelectedOption", "Lcom/discord/models/message/Message;", "getMessage", "<init>", "(Lcom/discord/models/message/Message;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends ViewState {
            private final Message message;
            private final String selectedOption;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Message message, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(str, "selectedOption");
                this.message = message;
                this.selectedOption = str;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Message message, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    message = valid.message;
                }
                if ((i & 2) != 0) {
                    str = valid.selectedOption;
                }
                return valid.copy(message, str);
            }

            /* renamed from: component1, reason: from getter */
            public final Message getMessage() {
                return this.message;
            }

            /* renamed from: component2, reason: from getter */
            public final String getSelectedOption() {
                return this.selectedOption;
            }

            public final Valid copy(Message message, String selectedOption) {
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(selectedOption, "selectedOption");
                return new Valid(message, selectedOption);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.message, valid.message) && Intrinsics3.areEqual(this.selectedOption, valid.selectedOption);
            }

            public final Message getMessage() {
                return this.message;
            }

            public final String getSelectedOption() {
                return this.selectedOption;
            }

            public int hashCode() {
                Message message = this.message;
                int iHashCode = (message != null ? message.hashCode() : 0) * 31;
                String str = this.selectedOption;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(message=");
                sbU.append(this.message);
                sbU.append(", selectedOption=");
                return outline.J(sbU, this.selectedOption, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ReportIssueWithAutoModViewModel(long j, long j2, StoreMessages storeMessages, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeMessages = (i & 4) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages;
        this(j, j2, storeMessages, (i & 8) != 0 ? Companion.access$observeStores(INSTANCE, j, j2, storeMessages) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(ReportIssueWithAutoModViewModel reportIssueWithAutoModViewModel, StoreState storeState) {
        reportIssueWithAutoModViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        String value;
        ViewState valid;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid2 = (ViewState.Valid) viewState;
        if (storeState.getMessage() == null) {
            valid = ViewState.Invalid.INSTANCE;
        } else {
            Message message = storeState.getMessage();
            if (valid2 == null || (value = valid2.getSelectedOption()) == null) {
                value = ReportIssueWithAutoModViewModel2.ALLOWED.getValue();
            }
            valid = new ViewState.Valid(message, value);
        }
        updateViewState(valid);
    }

    public final void onFeedbackTypeSelected(ReportIssueWithAutoModViewModel2 feedbackType) {
        Intrinsics3.checkNotNullParameter(feedbackType, "feedbackType");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            updateViewState(ViewState.Valid.copy$default((ViewState.Valid) viewState, null, feedbackType.getValue(), 1, null));
        }
    }

    public final void onSubmit(Function0<Unit> onCompleted) {
        String embedFieldValue;
        Intrinsics3.checkNotNullParameter(onCompleted, "onCompleted");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            ViewState.Valid valid = (ViewState.Valid) viewState;
            List<MessageEmbed> embeds = valid.getMessage().getEmbeds();
            MessageEmbed messageEmbed = embeds != null ? (MessageEmbed) _Collections.first((List) embeds) : null;
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            if (messageEmbed == null || (embedFieldValue = AutoModUtils.INSTANCE.getEmbedFieldValue(messageEmbed, "decision_id")) == null) {
                embedFieldValue = "";
            }
            long id2 = valid.getMessage().getId();
            String content = valid.getMessage().getContent();
            analyticsTracker.trackReportIssueWithAutoMod(embedFieldValue, id2, valid.getSelectedOption(), content != null ? content : "");
            onCompleted.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportIssueWithAutoModViewModel(long j, long j2, StoreMessages storeMessages, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeMessages, "messageStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.messageId = j2;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ReportIssueWithAutoModViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
