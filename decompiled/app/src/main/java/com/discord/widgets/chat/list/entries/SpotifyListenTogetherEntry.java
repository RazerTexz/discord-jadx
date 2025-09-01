package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import com.discord.api.message.activity.MessageActivity;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SpotifyListenTogetherEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b%\u0010&J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ2\u0010\r\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001c\u0010\u0005R\u001c\u0010\u001d\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0011R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u00020\u00128\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0014¨\u0006'"}, d2 = {"Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "component2", "Lcom/discord/api/message/activity/MessageActivity;", "component3", "()Lcom/discord/api/message/activity/MessageActivity;", "userId", "messageId", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "copy", "(JJLcom/discord/api/message/activity/MessageActivity;)Lcom/discord/widgets/chat/list/entries/SpotifyListenTogetherEntry;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getMessageId", "getUserId", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/api/message/activity/MessageActivity;", "getActivity", "type", "I", "getType", "<init>", "(JJLcom/discord/api/message/activity/MessageActivity;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class SpotifyListenTogetherEntry extends ChatListEntry {
    private final MessageActivity activity;
    private final String key;
    private final long messageId;
    private final int type;
    private final long userId;

    public SpotifyListenTogetherEntry(long j, long j2, MessageActivity messageActivity) {
        Intrinsics3.checkNotNullParameter(messageActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.userId = j;
        this.messageId = j2;
        this.activity = messageActivity;
        this.type = 23;
        this.key = outline.t("23 -- ", j2);
    }

    public static /* synthetic */ SpotifyListenTogetherEntry copy$default(SpotifyListenTogetherEntry spotifyListenTogetherEntry, long j, long j2, MessageActivity messageActivity, int i, Object obj) {
        if ((i & 1) != 0) {
            j = spotifyListenTogetherEntry.userId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = spotifyListenTogetherEntry.messageId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            messageActivity = spotifyListenTogetherEntry.activity;
        }
        return spotifyListenTogetherEntry.copy(j3, j4, messageActivity);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* renamed from: component3, reason: from getter */
    public final MessageActivity getActivity() {
        return this.activity;
    }

    public final SpotifyListenTogetherEntry copy(long userId, long messageId, MessageActivity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        return new SpotifyListenTogetherEntry(userId, messageId, activity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpotifyListenTogetherEntry)) {
            return false;
        }
        SpotifyListenTogetherEntry spotifyListenTogetherEntry = (SpotifyListenTogetherEntry) other;
        return this.userId == spotifyListenTogetherEntry.userId && this.messageId == spotifyListenTogetherEntry.messageId && Intrinsics3.areEqual(this.activity, spotifyListenTogetherEntry.activity);
    }

    public final MessageActivity getActivity() {
        return this.activity;
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

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iA = (b.a(this.messageId) + (b.a(this.userId) * 31)) * 31;
        MessageActivity messageActivity = this.activity;
        return iA + (messageActivity != null ? messageActivity.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("SpotifyListenTogetherEntry(userId=");
        sbU.append(this.userId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(")");
        return sbU.toString();
    }
}
