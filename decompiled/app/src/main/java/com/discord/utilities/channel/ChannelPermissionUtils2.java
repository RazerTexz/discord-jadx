package com.discord.utilities.channel;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ChannelPermissionUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004Jz\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b)\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b*\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b+\u0010\u0007R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b,\u0010\u0007¨\u0006/"}, d2 = {"Lcom/discord/utilities/channel/PermissionLabelOverrides;", "", "", "component1", "()Ljava/lang/CharSequence;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "categorySubtext", "categoryLabel", "voiceChannelSubtext", "stageChannelSubtext", "textChannelEveryoneSubtext", "voiceChannelEveryoneSubtext", "stageChannelEveryoneSubtext", "categoryEveryoneSubtext", "announcementChannelSubtext", "copy", "(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Lcom/discord/utilities/channel/PermissionLabelOverrides;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getVoiceChannelSubtext", "Ljava/lang/CharSequence;", "getAnnouncementChannelSubtext", "getCategoryEveryoneSubtext", "getCategorySubtext", "getStageChannelSubtext", "getTextChannelEveryoneSubtext", "getCategoryLabel", "getVoiceChannelEveryoneSubtext", "getStageChannelEveryoneSubtext", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.channel.PermissionLabelOverrides, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class ChannelPermissionUtils2 {
    private final CharSequence announcementChannelSubtext;
    private final CharSequence categoryEveryoneSubtext;
    private final String categoryLabel;
    private final CharSequence categorySubtext;
    private final String stageChannelEveryoneSubtext;
    private final CharSequence stageChannelSubtext;
    private final String textChannelEveryoneSubtext;
    private final String voiceChannelEveryoneSubtext;
    private final String voiceChannelSubtext;

    public ChannelPermissionUtils2(CharSequence charSequence, String str, String str2, CharSequence charSequence2, String str3, String str4, String str5, CharSequence charSequence3, CharSequence charSequence4) {
        Intrinsics3.checkNotNullParameter(charSequence, "categorySubtext");
        this.categorySubtext = charSequence;
        this.categoryLabel = str;
        this.voiceChannelSubtext = str2;
        this.stageChannelSubtext = charSequence2;
        this.textChannelEveryoneSubtext = str3;
        this.voiceChannelEveryoneSubtext = str4;
        this.stageChannelEveryoneSubtext = str5;
        this.categoryEveryoneSubtext = charSequence3;
        this.announcementChannelSubtext = charSequence4;
    }

    public static /* synthetic */ ChannelPermissionUtils2 copy$default(ChannelPermissionUtils2 channelPermissionUtils2, CharSequence charSequence, String str, String str2, CharSequence charSequence2, String str3, String str4, String str5, CharSequence charSequence3, CharSequence charSequence4, int i, Object obj) {
        return channelPermissionUtils2.copy((i & 1) != 0 ? channelPermissionUtils2.categorySubtext : charSequence, (i & 2) != 0 ? channelPermissionUtils2.categoryLabel : str, (i & 4) != 0 ? channelPermissionUtils2.voiceChannelSubtext : str2, (i & 8) != 0 ? channelPermissionUtils2.stageChannelSubtext : charSequence2, (i & 16) != 0 ? channelPermissionUtils2.textChannelEveryoneSubtext : str3, (i & 32) != 0 ? channelPermissionUtils2.voiceChannelEveryoneSubtext : str4, (i & 64) != 0 ? channelPermissionUtils2.stageChannelEveryoneSubtext : str5, (i & 128) != 0 ? channelPermissionUtils2.categoryEveryoneSubtext : charSequence3, (i & 256) != 0 ? channelPermissionUtils2.announcementChannelSubtext : charSequence4);
    }

    /* renamed from: component1, reason: from getter */
    public final CharSequence getCategorySubtext() {
        return this.categorySubtext;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCategoryLabel() {
        return this.categoryLabel;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVoiceChannelSubtext() {
        return this.voiceChannelSubtext;
    }

    /* renamed from: component4, reason: from getter */
    public final CharSequence getStageChannelSubtext() {
        return this.stageChannelSubtext;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTextChannelEveryoneSubtext() {
        return this.textChannelEveryoneSubtext;
    }

    /* renamed from: component6, reason: from getter */
    public final String getVoiceChannelEveryoneSubtext() {
        return this.voiceChannelEveryoneSubtext;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStageChannelEveryoneSubtext() {
        return this.stageChannelEveryoneSubtext;
    }

    /* renamed from: component8, reason: from getter */
    public final CharSequence getCategoryEveryoneSubtext() {
        return this.categoryEveryoneSubtext;
    }

    /* renamed from: component9, reason: from getter */
    public final CharSequence getAnnouncementChannelSubtext() {
        return this.announcementChannelSubtext;
    }

    public final ChannelPermissionUtils2 copy(CharSequence categorySubtext, String categoryLabel, String voiceChannelSubtext, CharSequence stageChannelSubtext, String textChannelEveryoneSubtext, String voiceChannelEveryoneSubtext, String stageChannelEveryoneSubtext, CharSequence categoryEveryoneSubtext, CharSequence announcementChannelSubtext) {
        Intrinsics3.checkNotNullParameter(categorySubtext, "categorySubtext");
        return new ChannelPermissionUtils2(categorySubtext, categoryLabel, voiceChannelSubtext, stageChannelSubtext, textChannelEveryoneSubtext, voiceChannelEveryoneSubtext, stageChannelEveryoneSubtext, categoryEveryoneSubtext, announcementChannelSubtext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelPermissionUtils2)) {
            return false;
        }
        ChannelPermissionUtils2 channelPermissionUtils2 = (ChannelPermissionUtils2) other;
        return Intrinsics3.areEqual(this.categorySubtext, channelPermissionUtils2.categorySubtext) && Intrinsics3.areEqual(this.categoryLabel, channelPermissionUtils2.categoryLabel) && Intrinsics3.areEqual(this.voiceChannelSubtext, channelPermissionUtils2.voiceChannelSubtext) && Intrinsics3.areEqual(this.stageChannelSubtext, channelPermissionUtils2.stageChannelSubtext) && Intrinsics3.areEqual(this.textChannelEveryoneSubtext, channelPermissionUtils2.textChannelEveryoneSubtext) && Intrinsics3.areEqual(this.voiceChannelEveryoneSubtext, channelPermissionUtils2.voiceChannelEveryoneSubtext) && Intrinsics3.areEqual(this.stageChannelEveryoneSubtext, channelPermissionUtils2.stageChannelEveryoneSubtext) && Intrinsics3.areEqual(this.categoryEveryoneSubtext, channelPermissionUtils2.categoryEveryoneSubtext) && Intrinsics3.areEqual(this.announcementChannelSubtext, channelPermissionUtils2.announcementChannelSubtext);
    }

    public final CharSequence getAnnouncementChannelSubtext() {
        return this.announcementChannelSubtext;
    }

    public final CharSequence getCategoryEveryoneSubtext() {
        return this.categoryEveryoneSubtext;
    }

    public final String getCategoryLabel() {
        return this.categoryLabel;
    }

    public final CharSequence getCategorySubtext() {
        return this.categorySubtext;
    }

    public final String getStageChannelEveryoneSubtext() {
        return this.stageChannelEveryoneSubtext;
    }

    public final CharSequence getStageChannelSubtext() {
        return this.stageChannelSubtext;
    }

    public final String getTextChannelEveryoneSubtext() {
        return this.textChannelEveryoneSubtext;
    }

    public final String getVoiceChannelEveryoneSubtext() {
        return this.voiceChannelEveryoneSubtext;
    }

    public final String getVoiceChannelSubtext() {
        return this.voiceChannelSubtext;
    }

    public int hashCode() {
        CharSequence charSequence = this.categorySubtext;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        String str = this.categoryLabel;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.voiceChannelSubtext;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.stageChannelSubtext;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        String str3 = this.textChannelEveryoneSubtext;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.voiceChannelEveryoneSubtext;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.stageChannelEveryoneSubtext;
        int iHashCode7 = (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.categoryEveryoneSubtext;
        int iHashCode8 = (iHashCode7 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.announcementChannelSubtext;
        return iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PermissionLabelOverrides(categorySubtext=");
        sbU.append(this.categorySubtext);
        sbU.append(", categoryLabel=");
        sbU.append(this.categoryLabel);
        sbU.append(", voiceChannelSubtext=");
        sbU.append(this.voiceChannelSubtext);
        sbU.append(", stageChannelSubtext=");
        sbU.append(this.stageChannelSubtext);
        sbU.append(", textChannelEveryoneSubtext=");
        sbU.append(this.textChannelEveryoneSubtext);
        sbU.append(", voiceChannelEveryoneSubtext=");
        sbU.append(this.voiceChannelEveryoneSubtext);
        sbU.append(", stageChannelEveryoneSubtext=");
        sbU.append(this.stageChannelEveryoneSubtext);
        sbU.append(", categoryEveryoneSubtext=");
        sbU.append(this.categoryEveryoneSubtext);
        sbU.append(", announcementChannelSubtext=");
        return outline.E(sbU, this.announcementChannelSubtext, ")");
    }

    public /* synthetic */ ChannelPermissionUtils2(CharSequence charSequence, String str, String str2, CharSequence charSequence2, String str3, String str4, String str5, CharSequence charSequence3, CharSequence charSequence4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : charSequence2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : charSequence3, (i & 256) == 0 ? charSequence4 : null);
    }
}
