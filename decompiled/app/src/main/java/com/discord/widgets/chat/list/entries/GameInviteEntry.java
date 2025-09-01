package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import com.discord.api.application.Application;
import com.discord.api.message.activity.MessageActivity;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GameInviteEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b,\u0010-J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ@\u0010\u0012\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u000f\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u000f\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0005R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\nR\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\rR\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b%\u0010\u0005R\u001c\u0010&\u001a\u00020\u00178\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0019R\u001c\u0010)\u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0016¨\u0006."}, d2 = {"Lcom/discord/widgets/chat/list/entries/GameInviteEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "Lcom/discord/primitives/MessageId;", "component2", "Lcom/discord/api/message/activity/MessageActivity;", "component3", "()Lcom/discord/api/message/activity/MessageActivity;", "Lcom/discord/api/application/Application;", "component4", "()Lcom/discord/api/application/Application;", "authorId", "messageId", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "application", "copy", "(JJLcom/discord/api/message/activity/MessageActivity;Lcom/discord/api/application/Application;)Lcom/discord/widgets/chat/list/entries/GameInviteEntry;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getMessageId", "Lcom/discord/api/message/activity/MessageActivity;", "getActivity", "Lcom/discord/api/application/Application;", "getApplication", "getAuthorId", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "<init>", "(JJLcom/discord/api/message/activity/MessageActivity;Lcom/discord/api/application/Application;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GameInviteEntry extends ChatListEntry {
    private final MessageActivity activity;
    private final Application application;
    private final long authorId;
    private final String key;
    private final long messageId;
    private final int type;

    public GameInviteEntry(long j, long j2, MessageActivity messageActivity, Application application) {
        Intrinsics3.checkNotNullParameter(messageActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(application, "application");
        this.authorId = j;
        this.messageId = j2;
        this.activity = messageActivity;
        this.application = application;
        this.type = 22;
        this.key = outline.t("22 -- ", j2);
    }

    public static /* synthetic */ GameInviteEntry copy$default(GameInviteEntry gameInviteEntry, long j, long j2, MessageActivity messageActivity, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            j = gameInviteEntry.authorId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = gameInviteEntry.messageId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            messageActivity = gameInviteEntry.activity;
        }
        MessageActivity messageActivity2 = messageActivity;
        if ((i & 8) != 0) {
            application = gameInviteEntry.application;
        }
        return gameInviteEntry.copy(j3, j4, messageActivity2, application);
    }

    /* renamed from: component1, reason: from getter */
    public final long getAuthorId() {
        return this.authorId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* renamed from: component3, reason: from getter */
    public final MessageActivity getActivity() {
        return this.activity;
    }

    /* renamed from: component4, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final GameInviteEntry copy(long authorId, long messageId, MessageActivity activity, Application application) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(application, "application");
        return new GameInviteEntry(authorId, messageId, activity, application);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameInviteEntry)) {
            return false;
        }
        GameInviteEntry gameInviteEntry = (GameInviteEntry) other;
        return this.authorId == gameInviteEntry.authorId && this.messageId == gameInviteEntry.messageId && Intrinsics3.areEqual(this.activity, gameInviteEntry.activity) && Intrinsics3.areEqual(this.application, gameInviteEntry.application);
    }

    public final MessageActivity getActivity() {
        return this.activity;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final long getAuthorId() {
        return this.authorId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int iA = (b.a(this.messageId) + (b.a(this.authorId) * 31)) * 31;
        MessageActivity messageActivity = this.activity;
        int iHashCode = (iA + (messageActivity != null ? messageActivity.hashCode() : 0)) * 31;
        Application application = this.application;
        return iHashCode + (application != null ? application.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GameInviteEntry(authorId=");
        sbU.append(this.authorId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(")");
        return sbU.toString();
    }
}
