package com.discord.stores;

import a0.a.a.b;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.d.b.a.outline;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: StoreChat.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0003<=>B\u0019\u0012\u0006\u00101\u001a\u000200\u0012\b\b\u0002\u0010+\u001a\u00020*¢\u0006\u0004\b:\u0010;J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00060\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u0015\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u00152\n\u0010\u001b\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\"\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\u0010!\u001a\u00060\u0007j\u0002` ¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\u00152\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0015H\u0016¢\u0006\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R \u0010.\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u00103R \u00104\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010/R:\u00107\u001a&\u0012\f\u0012\n 6*\u0004\u0018\u00010\u00030\u0003 6*\u0012\u0012\f\u0012\n 6*\u0004\u0018\u00010\u00030\u0003\u0018\u000105058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u00109¨\u0006?"}, d2 = {"Lcom/discord/stores/StoreChat;", "Lcom/discord/stores/StoreV2;", "Lrx/Observable;", "Lcom/discord/stores/StoreChat$Event;", "observeEvents", "()Lrx/Observable;", "", "", "Lcom/discord/primitives/MessageId;", "getExpandedBlockedMessageGroups", "()Ljava/util/List;", "observeExpandedBlockedMessageIds", "Lcom/discord/stores/StoreChat$InteractionState;", "getInteractionState", "()Lcom/discord/stores/StoreChat$InteractionState;", "Lcom/discord/stores/StoreChat$EditingMessage;", "getEditingMessage", "()Lcom/discord/stores/StoreChat$EditingMessage;", "observeInteractionState", "observeEditingMessage", "interactionState", "", "setInteractionState", "(Lcom/discord/stores/StoreChat$InteractionState;)V", "editingMessage", "setEditingMessage", "(Lcom/discord/stores/StoreChat$EditingMessage;)V", "messageId", "toggleBlockedMessageGroup", "(J)V", "Lcom/discord/models/user/User;", "user", "Lcom/discord/primitives/GuildId;", "guildId", "appendMention", "(Lcom/discord/models/user/User;J)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "replaceChatText", "(Ljava/lang/String;)V", "snapshotData", "()V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "expandedBlockedMessageGroups", "Ljava/util/List;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreChat$InteractionState;", "expandedBlockedMessageGroupsSnapshot", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreChat$EditingMessage;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "EditingMessage", "Event", "InteractionState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreChat extends StoreV2 {
    private final Dispatcher dispatcher;
    private EditingMessage editingMessage;
    private final PublishSubject<Event> eventSubject;
    private final List<Long> expandedBlockedMessageGroups;
    private List<Long> expandedBlockedMessageGroupsSnapshot;
    private InteractionState interactionState;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreChat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/StoreChat$EditingMessage;", "", "Lcom/discord/models/message/Message;", "component1", "()Lcom/discord/models/message/Message;", "", "component2", "()Ljava/lang/CharSequence;", "message", "content", "copy", "(Lcom/discord/models/message/Message;Ljava/lang/CharSequence;)Lcom/discord/stores/StoreChat$EditingMessage;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/message/Message;", "getMessage", "Ljava/lang/CharSequence;", "getContent", "<init>", "(Lcom/discord/models/message/Message;Ljava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class EditingMessage {
        private final CharSequence content;
        private final Message message;

        public EditingMessage(Message message, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(charSequence, "content");
            this.message = message;
            this.content = charSequence;
        }

        public static /* synthetic */ EditingMessage copy$default(EditingMessage editingMessage, Message message, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                message = editingMessage.message;
            }
            if ((i & 2) != 0) {
                charSequence = editingMessage.content;
            }
            return editingMessage.copy(message, charSequence);
        }

        /* renamed from: component1, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getContent() {
            return this.content;
        }

        public final EditingMessage copy(Message message, CharSequence content) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(content, "content");
            return new EditingMessage(message, content);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditingMessage)) {
                return false;
            }
            EditingMessage editingMessage = (EditingMessage) other;
            return Intrinsics3.areEqual(this.message, editingMessage.message) && Intrinsics3.areEqual(this.content, editingMessage.content);
        }

        public final CharSequence getContent() {
            return this.content;
        }

        public final Message getMessage() {
            return this.message;
        }

        public int hashCode() {
            Message message = this.message;
            int iHashCode = (message != null ? message.hashCode() : 0) * 31;
            CharSequence charSequence = this.content;
            return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("EditingMessage(message=");
            sbU.append(this.message);
            sbU.append(", content=");
            return outline.E(sbU, this.content, ")");
        }
    }

    /* compiled from: StoreChat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/stores/StoreChat$Event;", "", "<init>", "()V", "AppendChatText", "ReplaceChatText", "Lcom/discord/stores/StoreChat$Event$AppendChatText;", "Lcom/discord/stores/StoreChat$Event$ReplaceChatText;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: StoreChat.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/stores/StoreChat$Event$AppendChatText;", "Lcom/discord/stores/StoreChat$Event;", "", "component1", "()Ljava/lang/String;", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "copy", "(Ljava/lang/String;)Lcom/discord/stores/StoreChat$Event$AppendChatText;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class AppendChatText extends Event {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AppendChatText(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                this.text = str;
            }

            public static /* synthetic */ AppendChatText copy$default(AppendChatText appendChatText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = appendChatText.text;
                }
                return appendChatText.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final AppendChatText copy(String text) {
                Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                return new AppendChatText(text);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof AppendChatText) && Intrinsics3.areEqual(this.text, ((AppendChatText) other).text);
                }
                return true;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("AppendChatText(text="), this.text, ")");
            }
        }

        /* compiled from: StoreChat.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/stores/StoreChat$Event$ReplaceChatText;", "Lcom/discord/stores/StoreChat$Event;", "", "component1", "()Ljava/lang/String;", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "copy", "(Ljava/lang/String;)Lcom/discord/stores/StoreChat$Event$ReplaceChatText;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ReplaceChatText extends Event {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReplaceChatText(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                this.text = str;
            }

            public static /* synthetic */ ReplaceChatText copy$default(ReplaceChatText replaceChatText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = replaceChatText.text;
                }
                return replaceChatText.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final ReplaceChatText copy(String text) {
                Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                return new ReplaceChatText(text);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ReplaceChatText) && Intrinsics3.areEqual(this.text, ((ReplaceChatText) other).text);
                }
                return true;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("ReplaceChatText(text="), this.text, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreChat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreChat$EditingMessage;", "invoke", "()Lcom/discord/stores/StoreChat$EditingMessage;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChat$observeEditingMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<EditingMessage> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ EditingMessage invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EditingMessage invoke() {
            return StoreChat.this.getEditingMessage();
        }
    }

    /* compiled from: StoreChat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/primitives/MessageId;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChat$observeExpandedBlockedMessageIds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends Long> invoke2() {
            return StoreChat.this.getExpandedBlockedMessageGroups();
        }
    }

    /* compiled from: StoreChat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreChat$InteractionState;", "invoke", "()Lcom/discord/stores/StoreChat$InteractionState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChat$observeInteractionState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<InteractionState> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ InteractionState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InteractionState invoke() {
            return StoreChat.this.getInteractionState();
        }
    }

    /* compiled from: StoreChat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChat$setEditingMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EditingMessage $editingMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EditingMessage editingMessage) {
            super(0);
            this.$editingMessage = editingMessage;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreChat.access$setEditingMessage$p(StoreChat.this, this.$editingMessage);
            StoreChat.this.markChanged();
        }
    }

    /* compiled from: StoreChat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChat$setInteractionState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InteractionState $interactionState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InteractionState interactionState) {
            super(0);
            this.$interactionState = interactionState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreChat.access$setInteractionState$p(StoreChat.this, this.$interactionState);
            StoreChat.this.markChanged();
        }
    }

    /* compiled from: StoreChat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChat$toggleBlockedMessageGroup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$messageId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreChat.access$getExpandedBlockedMessageGroups$p(StoreChat.this).contains(Long.valueOf(this.$messageId))) {
                StoreChat.access$getExpandedBlockedMessageGroups$p(StoreChat.this).remove(Long.valueOf(this.$messageId));
            } else {
                StoreChat.access$getExpandedBlockedMessageGroups$p(StoreChat.this).add(Long.valueOf(this.$messageId));
            }
            StoreChat.this.markChanged();
        }
    }

    public /* synthetic */ StoreChat(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ EditingMessage access$getEditingMessage$p(StoreChat storeChat) {
        return storeChat.editingMessage;
    }

    public static final /* synthetic */ List access$getExpandedBlockedMessageGroups$p(StoreChat storeChat) {
        return storeChat.expandedBlockedMessageGroups;
    }

    public static final /* synthetic */ InteractionState access$getInteractionState$p(StoreChat storeChat) {
        return storeChat.interactionState;
    }

    public static final /* synthetic */ void access$setEditingMessage$p(StoreChat storeChat, EditingMessage editingMessage) {
        storeChat.editingMessage = editingMessage;
    }

    public static final /* synthetic */ void access$setInteractionState$p(StoreChat storeChat, InteractionState interactionState) {
        storeChat.interactionState = interactionState;
    }

    public final void appendMention(User user, long guildId) {
        if (user != null) {
            if (user.getUsername().length() == 0) {
                return;
            }
            StoreGatewayConnection.requestGuildMembers$default(StoreStream.INSTANCE.getGatewaySocket(), guildId, user.getUsername(), null, null, 12, null);
            StringBuilder sbU = outline.U("@");
            sbU.append(user.getUsername());
            sbU.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
            String string = sbU.toString();
            this.eventSubject.k.onNext(new Event.AppendChatText(string + ' '));
        }
    }

    public final EditingMessage getEditingMessage() {
        return this.editingMessage;
    }

    public final List<Long> getExpandedBlockedMessageGroups() {
        return this.expandedBlockedMessageGroupsSnapshot;
    }

    public final InteractionState getInteractionState() {
        return this.interactionState;
    }

    public final Observable<EditingMessage> observeEditingMessage() {
        Observable<EditingMessage> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<List<Long>> observeExpandedBlockedMessageIds() {
        Observable<List<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<InteractionState> observeInteractionState() {
        Observable observableG = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable<InteractionState> observableR = observableG.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void replaceChatText(String text) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.eventSubject.k.onNext(new Event.ReplaceChatText(text + ' '));
    }

    public final void setEditingMessage(EditingMessage editingMessage) {
        this.dispatcher.schedule(new AnonymousClass1(editingMessage));
    }

    public final void setInteractionState(InteractionState interactionState) {
        Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
        this.dispatcher.schedule(new AnonymousClass1(interactionState));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.expandedBlockedMessageGroupsSnapshot = new ArrayList(this.expandedBlockedMessageGroups);
    }

    public final void toggleBlockedMessageGroup(long messageId) {
        this.dispatcher.schedule(new AnonymousClass1(messageId));
    }

    public StoreChat(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.expandedBlockedMessageGroups = new ArrayList();
        this.expandedBlockedMessageGroupsSnapshot = Collections2.emptyList();
        this.eventSubject = PublishSubject.k0();
    }

    /* compiled from: StoreChat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B/\u0012\n\u0010\u0011\u001a\u00060\nj\u0002`\u000b\u0012\n\u0010\u0012\u001a\u00060\nj\u0002`\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'B3\b\u0016\u0012\n\u0010\u0011\u001a\u00060\nj\u0002`\u000b\u0012\n\u0010\u0012\u001a\u00060\nj\u0002`\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b&\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\u0014\u0010\f\u001a\u00060\nj\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000f\u001a\u00060\nj\u0002`\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J@\u0010\u0015\u001a\u00020\u00002\f\b\u0002\u0010\u0011\u001a\u00060\nj\u0002`\u000b2\f\b\u0002\u0010\u0012\u001a\u00060\nj\u0002`\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010 \u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b \u0010\u0007R\u001d\u0010\u0012\u001a\u00060\nj\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010\u0011\u001a\u00060\nj\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b%\u0010\rR\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b\u0013\u0010\u0007¨\u0006,"}, d2 = {"Lcom/discord/stores/StoreChat$InteractionState;", "", "", "component4", "()I", "", "isAtTopIgnoringTouch", "()Z", "isAtBottomIgnoringTouch", "isNearBottomIgnoringTouch", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/MessageId;", "component2", "component3", "channelId", "lastMessageId", "isTouchedSinceLastJump", "scrollState", "copy", "(JJZI)Lcom/discord/stores/StoreChat$InteractionState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "isAtTop", "Z", "isAtBottom", "J", "getLastMessageId", "scrollState$1", "I", "getChannelId", "<init>", "(JJZI)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "(JJZLandroidx/recyclerview/widget/LinearLayoutManager;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class InteractionState {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int NEAR_EDGE_THRESHOLD = 15;
        private static final int SCROLLED = 0;
        private static final int SCROLLED_BOTTOM = 1;
        private static final int SCROLLED_NEAR_BOTTOM = 4;
        private static final int SCROLLED_TOP = 2;
        private final long channelId;
        private final boolean isAtBottom;
        private final boolean isAtTop;
        private final boolean isTouchedSinceLastJump;
        private final long lastMessageId;

        /* renamed from: scrollState$1, reason: from kotlin metadata */
        private final int scrollState;

        /* compiled from: StoreChat.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u0003*\u0004\u0018\u00010\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/discord/stores/StoreChat$InteractionState$Companion;", "", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "getScrollState", "(Landroidx/recyclerview/widget/LinearLayoutManager;)I", "scrollState", "NEAR_EDGE_THRESHOLD", "I", "SCROLLED", "SCROLLED_BOTTOM", "SCROLLED_NEAR_BOTTOM", "SCROLLED_TOP", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ int access$getScrollState$p(Companion companion, LinearLayoutManager linearLayoutManager) {
                return companion.getScrollState(linearLayoutManager);
            }

            private final int getScrollState(LinearLayoutManager linearLayoutManager) {
                if (linearLayoutManager == null) {
                    return 0;
                }
                int itemCount = linearLayoutManager.getItemCount() - 1;
                int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                int iMax = Math.max(0, itemCount - 15);
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                boolean z2 = 1 <= iFindFirstVisibleItemPosition && 15 >= iFindFirstVisibleItemPosition;
                int i = iFindFirstVisibleItemPosition <= 0 ? 1 : 0;
                if (iFindLastVisibleItemPosition == itemCount || iFindLastVisibleItemPosition >= iMax) {
                    i |= 2;
                }
                return z2 ? i | 4 : i;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public InteractionState(long j, long j2, boolean z2, int i) {
            this.channelId = j;
            this.lastMessageId = j2;
            this.isTouchedSinceLastJump = z2;
            this.scrollState = i;
            this.isAtTop = z2 && isAtTopIgnoringTouch();
            this.isAtBottom = z2 && isAtBottomIgnoringTouch();
        }

        /* renamed from: component4, reason: from getter */
        private final int getScrollState() {
            return this.scrollState;
        }

        public static /* synthetic */ InteractionState copy$default(InteractionState interactionState, long j, long j2, boolean z2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = interactionState.channelId;
            }
            long j3 = j;
            if ((i2 & 2) != 0) {
                j2 = interactionState.lastMessageId;
            }
            long j4 = j2;
            if ((i2 & 4) != 0) {
                z2 = interactionState.isTouchedSinceLastJump;
            }
            boolean z3 = z2;
            if ((i2 & 8) != 0) {
                i = interactionState.scrollState;
            }
            return interactionState.copy(j3, j4, z3, i);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getLastMessageId() {
            return this.lastMessageId;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        public final InteractionState copy(long channelId, long lastMessageId, boolean isTouchedSinceLastJump, int scrollState) {
            return new InteractionState(channelId, lastMessageId, isTouchedSinceLastJump, scrollState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InteractionState)) {
                return false;
            }
            InteractionState interactionState = (InteractionState) other;
            return this.channelId == interactionState.channelId && this.lastMessageId == interactionState.lastMessageId && this.isTouchedSinceLastJump == interactionState.isTouchedSinceLastJump && this.scrollState == interactionState.scrollState;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final long getLastMessageId() {
            return this.lastMessageId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = (b.a(this.lastMessageId) + (b.a(this.channelId) * 31)) * 31;
            boolean z2 = this.isTouchedSinceLastJump;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return ((iA + i) * 31) + this.scrollState;
        }

        /* renamed from: isAtBottom, reason: from getter */
        public final boolean getIsAtBottom() {
            return this.isAtBottom;
        }

        public final boolean isAtBottomIgnoringTouch() {
            return (this.scrollState & 1) != 0;
        }

        /* renamed from: isAtTop, reason: from getter */
        public final boolean getIsAtTop() {
            return this.isAtTop;
        }

        public final boolean isAtTopIgnoringTouch() {
            return (this.scrollState & 2) != 0;
        }

        public final boolean isNearBottomIgnoringTouch() {
            return (this.scrollState & 4) != 0;
        }

        public final boolean isTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        public String toString() {
            StringBuilder sbU = outline.U("InteractionState(channelId=");
            sbU.append(this.channelId);
            sbU.append(", lastMessageId=");
            sbU.append(this.lastMessageId);
            sbU.append(", isTouchedSinceLastJump=");
            sbU.append(this.isTouchedSinceLastJump);
            sbU.append(", scrollState=");
            return outline.B(sbU, this.scrollState, ")");
        }

        public InteractionState(long j, long j2, boolean z2, LinearLayoutManager linearLayoutManager) {
            this(j, j2, z2, Companion.access$getScrollState$p(INSTANCE, linearLayoutManager));
        }
    }
}
