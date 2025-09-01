package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: MentionToken.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\rJ\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u0010\u0010\nR\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u001e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/discord/widgets/chat/input/models/MentionToken;", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "component1", "()Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "", "component4", "()I", "leadingIdentifier", "token", "isAtStart", "startIndex", "copy", "(Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;Ljava/lang/String;ZI)Lcom/discord/widgets/chat/input/models/MentionToken;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "I", "getStartIndex", "Ljava/lang/String;", "getToken", "formattedToken", "getFormattedToken", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "getLeadingIdentifier", "<init>", "(Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;Ljava/lang/String;ZI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class MentionToken {
    private final String formattedToken;
    private final boolean isAtStart;
    private final LeadingIdentifier leadingIdentifier;
    private final int startIndex;
    private final String token;

    public MentionToken(LeadingIdentifier leadingIdentifier, String str, boolean z2, int i) {
        Intrinsics3.checkNotNullParameter(leadingIdentifier, "leadingIdentifier");
        Intrinsics3.checkNotNullParameter(str, "token");
        this.leadingIdentifier = leadingIdentifier;
        this.token = str;
        this.isAtStart = z2;
        this.startIndex = i;
        this.formattedToken = StringsJVM.replaceFirst$default(str, String.valueOf(leadingIdentifier.getIdentifier()), "", false, 4, null);
    }

    public static /* synthetic */ MentionToken copy$default(MentionToken mentionToken, LeadingIdentifier leadingIdentifier, String str, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            leadingIdentifier = mentionToken.leadingIdentifier;
        }
        if ((i2 & 2) != 0) {
            str = mentionToken.token;
        }
        if ((i2 & 4) != 0) {
            z2 = mentionToken.isAtStart;
        }
        if ((i2 & 8) != 0) {
            i = mentionToken.startIndex;
        }
        return mentionToken.copy(leadingIdentifier, str, z2, i);
    }

    /* renamed from: component1, reason: from getter */
    public final LeadingIdentifier getLeadingIdentifier() {
        return this.leadingIdentifier;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsAtStart() {
        return this.isAtStart;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStartIndex() {
        return this.startIndex;
    }

    public final MentionToken copy(LeadingIdentifier leadingIdentifier, String token, boolean isAtStart, int startIndex) {
        Intrinsics3.checkNotNullParameter(leadingIdentifier, "leadingIdentifier");
        Intrinsics3.checkNotNullParameter(token, "token");
        return new MentionToken(leadingIdentifier, token, isAtStart, startIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MentionToken)) {
            return false;
        }
        MentionToken mentionToken = (MentionToken) other;
        return Intrinsics3.areEqual(this.leadingIdentifier, mentionToken.leadingIdentifier) && Intrinsics3.areEqual(this.token, mentionToken.token) && this.isAtStart == mentionToken.isAtStart && this.startIndex == mentionToken.startIndex;
    }

    public final String getFormattedToken() {
        return this.formattedToken;
    }

    public final LeadingIdentifier getLeadingIdentifier() {
        return this.leadingIdentifier;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final String getToken() {
        return this.token;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        LeadingIdentifier leadingIdentifier = this.leadingIdentifier;
        int iHashCode = (leadingIdentifier != null ? leadingIdentifier.hashCode() : 0) * 31;
        String str = this.token;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isAtStart;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return ((iHashCode2 + i) * 31) + this.startIndex;
    }

    public final boolean isAtStart() {
        return this.isAtStart;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MentionToken(leadingIdentifier=");
        sbU.append(this.leadingIdentifier);
        sbU.append(", token=");
        sbU.append(this.token);
        sbU.append(", isAtStart=");
        sbU.append(this.isAtStart);
        sbU.append(", startIndex=");
        return outline.B(sbU, this.startIndex, ")");
    }
}
