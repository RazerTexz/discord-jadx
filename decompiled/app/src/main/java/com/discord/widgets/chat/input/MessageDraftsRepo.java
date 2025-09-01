package com.discord.widgets.chat.input;

import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import d0.LazyJVM;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MessageDraftsRepo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\n\u0010\u000bR&\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00050\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/chat/input/MessageDraftsRepo;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "setTextChannelInput", "(JLjava/lang/CharSequence;)V", "getTextChannelInput", "(J)Ljava/lang/CharSequence;", "Ljava/util/HashMap;", "textChannelInput", "Ljava/util/HashMap;", "<init>", "()V", "Provider", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MessageDraftsRepo {
    private final HashMap<Long, CharSequence> textChannelInput;

    /* compiled from: MessageDraftsRepo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\b\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/chat/input/MessageDraftsRepo$Provider;", "", "Lcom/discord/widgets/chat/input/MessageDraftsRepo;", "get", "()Lcom/discord/widgets/chat/input/MessageDraftsRepo;", "MESSAGE_DRAFTS_REPO_INSTANCE$delegate", "Lkotlin/Lazy;", "getMESSAGE_DRAFTS_REPO_INSTANCE", "MESSAGE_DRAFTS_REPO_INSTANCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Provider {
        public static final Provider INSTANCE = new Provider();

        /* renamed from: MESSAGE_DRAFTS_REPO_INSTANCE$delegate, reason: from kotlin metadata */
        private static final Lazy MESSAGE_DRAFTS_REPO_INSTANCE = LazyJVM.lazy(MessageDraftsRepo2.INSTANCE);

        private Provider() {
        }

        private final MessageDraftsRepo getMESSAGE_DRAFTS_REPO_INSTANCE() {
            return (MessageDraftsRepo) MESSAGE_DRAFTS_REPO_INSTANCE.getValue();
        }

        public final MessageDraftsRepo get() {
            return getMESSAGE_DRAFTS_REPO_INSTANCE();
        }
    }

    private MessageDraftsRepo() {
        this.textChannelInput = new HashMap<>();
    }

    @MainThread
    public final CharSequence getTextChannelInput(long channelId) {
        return this.textChannelInput.get(Long.valueOf(channelId));
    }

    @MainThread
    public final void setTextChannelInput(long channelId, CharSequence text) {
        if (text != null) {
            if (!(text.length() == 0)) {
                this.textChannelInput.put(Long.valueOf(channelId), text);
                return;
            }
        }
        this.textChannelInput.remove(Long.valueOf(channelId));
    }

    public /* synthetic */ MessageDraftsRepo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
