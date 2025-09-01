package com.discord.utilities.lazy.memberlist;

import a0.a.a.b;
import androidx.annotation.ColorInt;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MemberListRow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "", "", "rowId", "Ljava/lang/String;", "getRowId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Member", "RoleHeader", "StatusHeader", "Lcom/discord/utilities/lazy/memberlist/MemberListRow$RoleHeader;", "Lcom/discord/utilities/lazy/memberlist/MemberListRow$StatusHeader;", "Lcom/discord/utilities/lazy/memberlist/MemberListRow$Member;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class MemberListRow {
    private final String rowId;

    /* compiled from: MemberListRow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\n\u0010\u001a\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\"\u001a\u00020\t\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010$\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\f¢\u0006\u0004\b>\u0010?J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\bJ\u0010\u0010\u0015\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000bJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\bJ\u0010\u0010\u0017\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0096\u0001\u0010&\u001a\u00020\u00002\f\b\u0002\u0010\u001a\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001e\u001a\u00020\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\"\u001a\u00020\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b(\u0010\bJ\u0010\u0010)\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b)\u0010\u0019J\u001a\u0010,\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0019\u0010$\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010.\u001a\u0004\b$\u0010\u000bR\u0019\u0010\u001e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u0010\u000bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00100\u001a\u0004\b1\u0010\u000eR\u0019\u0010\u001b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b3\u0010\bR\u001b\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u00102\u001a\u0004\b4\u0010\bR\u001d\u0010\u001a\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00105\u001a\u0004\b6\u0010\u0005R\u0019\u0010\u001c\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b\u001c\u0010\u000bR\u001b\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b7\u0010\u000eR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\u0012R\u0019\u0010\"\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010.\u001a\u0004\b:\u0010\u000bR\u001b\u0010#\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b#\u00102\u001a\u0004\b;\u0010\bR\u0019\u0010%\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010<\u001a\u0004\b=\u0010\u0019¨\u0006@"}, d2 = {"Lcom/discord/utilities/lazy/memberlist/MemberListRow$Member;", "Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "", "component4", "()Ljava/lang/Integer;", "component5", "Lcom/discord/models/presence/Presence;", "component6", "()Lcom/discord/models/presence/Presence;", "component7", "component8", "component9", "component10", "component11", "component12", "()I", "userId", ModelAuditLogEntry.CHANGE_KEY_NAME, "isBot", "tagText", "tagVerified", "presence", ModelAuditLogEntry.CHANGE_KEY_COLOR, "avatarUrl", "showOwnerIndicator", "premiumSince", "isApplicationStreaming", "userFlags", "copy", "(JLjava/lang/String;ZLjava/lang/Integer;ZLcom/discord/models/presence/Presence;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;ZI)Lcom/discord/utilities/lazy/memberlist/MemberListRow$Member;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getTagVerified", "Ljava/lang/Integer;", "getTagText", "Ljava/lang/String;", "getName", "getAvatarUrl", "J", "getUserId", "getColor", "Lcom/discord/models/presence/Presence;", "getPresence", "getShowOwnerIndicator", "getPremiumSince", "I", "getUserFlags", "<init>", "(JLjava/lang/String;ZLjava/lang/Integer;ZLcom/discord/models/presence/Presence;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;ZI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Member extends MemberListRow {
        private final String avatarUrl;
        private final Integer color;
        private final boolean isApplicationStreaming;
        private final boolean isBot;
        private final String name;
        private final String premiumSince;
        private final Presence presence;
        private final boolean showOwnerIndicator;
        private final Integer tagText;
        private final boolean tagVerified;
        private final int userFlags;
        private final long userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Member(long j, String str, boolean z2, Integer num, boolean z3, Presence presence, @ColorInt Integer num2, String str2, boolean z4, String str3, boolean z5, int i) {
            super(String.valueOf(j), null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.userId = j;
            this.name = str;
            this.isBot = z2;
            this.tagText = num;
            this.tagVerified = z3;
            this.presence = presence;
            this.color = num2;
            this.avatarUrl = str2;
            this.showOwnerIndicator = z4;
            this.premiumSince = str3;
            this.isApplicationStreaming = z5;
            this.userFlags = i;
        }

        public static /* synthetic */ Member copy$default(Member member, long j, String str, boolean z2, Integer num, boolean z3, Presence presence, Integer num2, String str2, boolean z4, String str3, boolean z5, int i, int i2, Object obj) {
            return member.copy((i2 & 1) != 0 ? member.userId : j, (i2 & 2) != 0 ? member.name : str, (i2 & 4) != 0 ? member.isBot : z2, (i2 & 8) != 0 ? member.tagText : num, (i2 & 16) != 0 ? member.tagVerified : z3, (i2 & 32) != 0 ? member.presence : presence, (i2 & 64) != 0 ? member.color : num2, (i2 & 128) != 0 ? member.avatarUrl : str2, (i2 & 256) != 0 ? member.showOwnerIndicator : z4, (i2 & 512) != 0 ? member.premiumSince : str3, (i2 & 1024) != 0 ? member.isApplicationStreaming : z5, (i2 & 2048) != 0 ? member.userFlags : i);
        }

        /* renamed from: component1, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        /* renamed from: component10, reason: from getter */
        public final String getPremiumSince() {
            return this.premiumSince;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getIsApplicationStreaming() {
            return this.isApplicationStreaming;
        }

        /* renamed from: component12, reason: from getter */
        public final int getUserFlags() {
            return this.userFlags;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsBot() {
            return this.isBot;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getTagText() {
            return this.tagText;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getTagVerified() {
            return this.tagVerified;
        }

        /* renamed from: component6, reason: from getter */
        public final Presence getPresence() {
            return this.presence;
        }

        /* renamed from: component7, reason: from getter */
        public final Integer getColor() {
            return this.color;
        }

        /* renamed from: component8, reason: from getter */
        public final String getAvatarUrl() {
            return this.avatarUrl;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getShowOwnerIndicator() {
            return this.showOwnerIndicator;
        }

        public final Member copy(long userId, String name, boolean isBot, Integer tagText, boolean tagVerified, Presence presence, @ColorInt Integer color, String avatarUrl, boolean showOwnerIndicator, String premiumSince, boolean isApplicationStreaming, int userFlags) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return new Member(userId, name, isBot, tagText, tagVerified, presence, color, avatarUrl, showOwnerIndicator, premiumSince, isApplicationStreaming, userFlags);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Member)) {
                return false;
            }
            Member member = (Member) other;
            return this.userId == member.userId && Intrinsics3.areEqual(this.name, member.name) && this.isBot == member.isBot && Intrinsics3.areEqual(this.tagText, member.tagText) && this.tagVerified == member.tagVerified && Intrinsics3.areEqual(this.presence, member.presence) && Intrinsics3.areEqual(this.color, member.color) && Intrinsics3.areEqual(this.avatarUrl, member.avatarUrl) && this.showOwnerIndicator == member.showOwnerIndicator && Intrinsics3.areEqual(this.premiumSince, member.premiumSince) && this.isApplicationStreaming == member.isApplicationStreaming && this.userFlags == member.userFlags;
        }

        public final String getAvatarUrl() {
            return this.avatarUrl;
        }

        public final Integer getColor() {
            return this.color;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPremiumSince() {
            return this.premiumSince;
        }

        public final Presence getPresence() {
            return this.presence;
        }

        public final boolean getShowOwnerIndicator() {
            return this.showOwnerIndicator;
        }

        public final Integer getTagText() {
            return this.tagText;
        }

        public final boolean getTagVerified() {
            return this.tagVerified;
        }

        public final int getUserFlags() {
            return this.userFlags;
        }

        public final long getUserId() {
            return this.userId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.userId) * 31;
            String str = this.name;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.isBot;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            Integer num = this.tagText;
            int iHashCode2 = (i2 + (num != null ? num.hashCode() : 0)) * 31;
            boolean z3 = this.tagVerified;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (iHashCode2 + i3) * 31;
            Presence presence = this.presence;
            int iHashCode3 = (i4 + (presence != null ? presence.hashCode() : 0)) * 31;
            Integer num2 = this.color;
            int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
            String str2 = this.avatarUrl;
            int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z4 = this.showOwnerIndicator;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (iHashCode5 + i5) * 31;
            String str3 = this.premiumSince;
            int iHashCode6 = (i6 + (str3 != null ? str3.hashCode() : 0)) * 31;
            boolean z5 = this.isApplicationStreaming;
            return ((iHashCode6 + (z5 ? 1 : z5 ? 1 : 0)) * 31) + this.userFlags;
        }

        public final boolean isApplicationStreaming() {
            return this.isApplicationStreaming;
        }

        public final boolean isBot() {
            return this.isBot;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Member(userId=");
            sbU.append(this.userId);
            sbU.append(", name=");
            sbU.append(this.name);
            sbU.append(", isBot=");
            sbU.append(this.isBot);
            sbU.append(", tagText=");
            sbU.append(this.tagText);
            sbU.append(", tagVerified=");
            sbU.append(this.tagVerified);
            sbU.append(", presence=");
            sbU.append(this.presence);
            sbU.append(", color=");
            sbU.append(this.color);
            sbU.append(", avatarUrl=");
            sbU.append(this.avatarUrl);
            sbU.append(", showOwnerIndicator=");
            sbU.append(this.showOwnerIndicator);
            sbU.append(", premiumSince=");
            sbU.append(this.premiumSince);
            sbU.append(", isApplicationStreaming=");
            sbU.append(this.isApplicationStreaming);
            sbU.append(", userFlags=");
            return outline.B(sbU, this.userFlags, ")");
        }
    }

    /* compiled from: MemberListRow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ2\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u000b¨\u0006 "}, d2 = {"Lcom/discord/utilities/lazy/memberlist/MemberListRow$RoleHeader;", "Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "", "Lcom/discord/primitives/RoleId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "roleId", "roleName", "memberCount", "copy", "(JLjava/lang/String;I)Lcom/discord/utilities/lazy/memberlist/MemberListRow$RoleHeader;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getRoleId", "Ljava/lang/String;", "getRoleName", "I", "getMemberCount", "<init>", "(JLjava/lang/String;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class RoleHeader extends MemberListRow {
        private final int memberCount;
        private final long roleId;
        private final String roleName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleHeader(long j, String str, int i) {
            super(String.valueOf(j), null);
            Intrinsics3.checkNotNullParameter(str, "roleName");
            this.roleId = j;
            this.roleName = str;
            this.memberCount = i;
        }

        public static /* synthetic */ RoleHeader copy$default(RoleHeader roleHeader, long j, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = roleHeader.roleId;
            }
            if ((i2 & 2) != 0) {
                str = roleHeader.roleName;
            }
            if ((i2 & 4) != 0) {
                i = roleHeader.memberCount;
            }
            return roleHeader.copy(j, str, i);
        }

        /* renamed from: component1, reason: from getter */
        public final long getRoleId() {
            return this.roleId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getRoleName() {
            return this.roleName;
        }

        /* renamed from: component3, reason: from getter */
        public final int getMemberCount() {
            return this.memberCount;
        }

        public final RoleHeader copy(long roleId, String roleName, int memberCount) {
            Intrinsics3.checkNotNullParameter(roleName, "roleName");
            return new RoleHeader(roleId, roleName, memberCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoleHeader)) {
                return false;
            }
            RoleHeader roleHeader = (RoleHeader) other;
            return this.roleId == roleHeader.roleId && Intrinsics3.areEqual(this.roleName, roleHeader.roleName) && this.memberCount == roleHeader.memberCount;
        }

        public final int getMemberCount() {
            return this.memberCount;
        }

        public final long getRoleId() {
            return this.roleId;
        }

        public final String getRoleName() {
            return this.roleName;
        }

        public int hashCode() {
            int iA = b.a(this.roleId) * 31;
            String str = this.roleName;
            return ((iA + (str != null ? str.hashCode() : 0)) * 31) + this.memberCount;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RoleHeader(roleId=");
            sbU.append(this.roleId);
            sbU.append(", roleName=");
            sbU.append(this.roleName);
            sbU.append(", memberCount=");
            return outline.B(sbU, this.memberCount, ")");
        }
    }

    /* compiled from: MemberListRow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006 "}, d2 = {"Lcom/discord/utilities/lazy/memberlist/MemberListRow$StatusHeader;", "Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "", "component1", "()Ljava/lang/String;", "Lcom/discord/utilities/lazy/memberlist/MemberListRow$StatusHeader$Type;", "component2", "()Lcom/discord/utilities/lazy/memberlist/MemberListRow$StatusHeader$Type;", "", "component3", "()I", "rowId", "type", "memberCount", "copy", "(Ljava/lang/String;Lcom/discord/utilities/lazy/memberlist/MemberListRow$StatusHeader$Type;I)Lcom/discord/utilities/lazy/memberlist/MemberListRow$StatusHeader;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRowId", "I", "getMemberCount", "Lcom/discord/utilities/lazy/memberlist/MemberListRow$StatusHeader$Type;", "getType", "<init>", "(Ljava/lang/String;Lcom/discord/utilities/lazy/memberlist/MemberListRow$StatusHeader$Type;I)V", "Type", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StatusHeader extends MemberListRow {
        private final int memberCount;
        private final String rowId;
        private final Type type;

        /* compiled from: MemberListRow.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/lazy/memberlist/MemberListRow$StatusHeader$Type;", "", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "()J", "<init>", "(Ljava/lang/String;IJ)V", "ONLINE", "OFFLINE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum Type {
            ONLINE(0),
            OFFLINE(1);

            private final long id;

            Type(long j) {
                this.id = j;
            }

            public final long getId() {
                return this.id;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StatusHeader(String str, Type type, int i) {
            super(str, null);
            Intrinsics3.checkNotNullParameter(str, "rowId");
            Intrinsics3.checkNotNullParameter(type, "type");
            this.rowId = str;
            this.type = type;
            this.memberCount = i;
        }

        public static /* synthetic */ StatusHeader copy$default(StatusHeader statusHeader, String str, Type type, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = statusHeader.getRowId();
            }
            if ((i2 & 2) != 0) {
                type = statusHeader.type;
            }
            if ((i2 & 4) != 0) {
                i = statusHeader.memberCount;
            }
            return statusHeader.copy(str, type, i);
        }

        public final String component1() {
            return getRowId();
        }

        /* renamed from: component2, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        /* renamed from: component3, reason: from getter */
        public final int getMemberCount() {
            return this.memberCount;
        }

        public final StatusHeader copy(String rowId, Type type, int memberCount) {
            Intrinsics3.checkNotNullParameter(rowId, "rowId");
            Intrinsics3.checkNotNullParameter(type, "type");
            return new StatusHeader(rowId, type, memberCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StatusHeader)) {
                return false;
            }
            StatusHeader statusHeader = (StatusHeader) other;
            return Intrinsics3.areEqual(getRowId(), statusHeader.getRowId()) && Intrinsics3.areEqual(this.type, statusHeader.type) && this.memberCount == statusHeader.memberCount;
        }

        public final int getMemberCount() {
            return this.memberCount;
        }

        @Override // com.discord.utilities.lazy.memberlist.MemberListRow
        public String getRowId() {
            return this.rowId;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            String rowId = getRowId();
            int iHashCode = (rowId != null ? rowId.hashCode() : 0) * 31;
            Type type = this.type;
            return ((iHashCode + (type != null ? type.hashCode() : 0)) * 31) + this.memberCount;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StatusHeader(rowId=");
            sbU.append(getRowId());
            sbU.append(", type=");
            sbU.append(this.type);
            sbU.append(", memberCount=");
            return outline.B(sbU, this.memberCount, ")");
        }
    }

    private MemberListRow(String str) {
        this.rowId = str;
    }

    public String getRowId() {
        return this.rowId;
    }

    public /* synthetic */ MemberListRow(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
