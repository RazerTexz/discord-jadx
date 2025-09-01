package com.discord.utilities.search.suggestion.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import d0.g0.Strings4;
import d0.g0._Strings;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ChannelSuggestion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u001b\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\u0010\n\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\f\b\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001d\u0010\n\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\b¨\u0006\""}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/ChannelSuggestion;", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion;", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/ChannelId;", "component2", "()J", "channelName", "channelId", "copy", "(Ljava/lang/String;J)Lcom/discord/utilities/search/suggestion/entries/ChannelSuggestion;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "category", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "getCategory", "()Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "Ljava/lang/String;", "getChannelName", "J", "getChannelId", "<init>", "(Ljava/lang/String;J)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelSuggestion implements SearchSuggestion {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SearchSuggestion.Category category;
    private final long channelId;
    private final String channelName;

    /* compiled from: ChannelSuggestion.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/ChannelSuggestion$Companion;", "", "", "channelName", "", "currentInput", "", "canComplete", "(Ljava/lang/String;Ljava/lang/CharSequence;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final boolean canComplete(String channelName, CharSequence currentInput) {
            Intrinsics3.checkNotNullParameter(channelName, "channelName");
            Intrinsics3.checkNotNullParameter(currentInput, "currentInput");
            if ((currentInput.length() > 0) && currentInput.charAt(0) == '#') {
                currentInput = _Strings.drop(currentInput, 1);
            }
            return Strings4.contains((CharSequence) channelName, currentInput, true);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChannelSuggestion(String str, long j) {
        Intrinsics3.checkNotNullParameter(str, "channelName");
        this.channelName = str;
        this.channelId = j;
        this.category = SearchSuggestion.Category.IN_CHANNEL;
    }

    public static /* synthetic */ ChannelSuggestion copy$default(ChannelSuggestion channelSuggestion, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelSuggestion.channelName;
        }
        if ((i & 2) != 0) {
            j = channelSuggestion.channelId;
        }
        return channelSuggestion.copy(str, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final ChannelSuggestion copy(String channelName, long channelId) {
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        return new ChannelSuggestion(channelName, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelSuggestion)) {
            return false;
        }
        ChannelSuggestion channelSuggestion = (ChannelSuggestion) other;
        return Intrinsics3.areEqual(this.channelName, channelSuggestion.channelName) && this.channelId == channelSuggestion.channelId;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
        return this.category;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public int hashCode() {
        String str = this.channelName;
        return b.a(this.channelId) + ((str != null ? str.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelSuggestion(channelName=");
        sbU.append(this.channelName);
        sbU.append(", channelId=");
        return outline.C(sbU, this.channelId, ")");
    }
}
