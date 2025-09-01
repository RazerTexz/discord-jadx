package com.discord.widgets.bugreports;

import a0.a.a.b;
import androidx.annotation.StringRes;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Metadata;

/* compiled from: WidgetBugReport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/bugreports/Priority;", "", "", "component1", "()I", "component2", "", "component3", "()J", "title", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "emojiId", "copy", "(IIJ)Lcom/discord/widgets/bugreports/Priority;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getEmojiId", "I", "getTitle", "getDescription", "<init>", "(IIJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class Priority {
    private final int description;
    private final long emojiId;
    private final int title;

    public Priority(@StringRes int i, @StringRes int i2, long j) {
        this.title = i;
        this.description = i2;
        this.emojiId = j;
    }

    public static /* synthetic */ Priority copy$default(Priority priority, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = priority.title;
        }
        if ((i3 & 2) != 0) {
            i2 = priority.description;
        }
        if ((i3 & 4) != 0) {
            j = priority.emojiId;
        }
        return priority.copy(i, i2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEmojiId() {
        return this.emojiId;
    }

    public final Priority copy(@StringRes int title, @StringRes int description, long emojiId) {
        return new Priority(title, description, emojiId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Priority)) {
            return false;
        }
        Priority priority = (Priority) other;
        return this.title == priority.title && this.description == priority.description && this.emojiId == priority.emojiId;
    }

    public final int getDescription() {
        return this.description;
    }

    public final long getEmojiId() {
        return this.emojiId;
    }

    public final int getTitle() {
        return this.title;
    }

    public int hashCode() {
        return b.a(this.emojiId) + (((this.title * 31) + this.description) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Priority(title=");
        sbU.append(this.title);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", emojiId=");
        return outline.C(sbU, this.emojiId, ")");
    }
}
