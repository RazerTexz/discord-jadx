package com.discord.widgets.guild_role_subscriptions.tier.model;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DrawableRes;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Benefit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\u0082\u0001\u0002\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "Landroid/os/Parcelable;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefit;", "toGuildRoleSubscriptionBenefit", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefit;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/emoji/Emoji;", "getEmoji", "()Lcom/discord/models/domain/emoji/Emoji;", "emoji", "", "getName", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_NAME, "getDescription", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "<init>", "()V", "ChannelBenefit", "IntangibleBenefit", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$IntangibleBenefit;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$ChannelBenefit;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class Benefit implements Parcelable {

    /* compiled from: Benefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\n\u0010\u001e\u001a\u00060\u0016j\u0002`\u0017¢\u0006\u0004\b2\u00103J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000fJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JJ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\n2\f\b\u0002\u0010\u001e\u001a\u00060\u0016j\u0002`\u0017HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b!\u0010\u000fJ\u0010\u0010\"\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\"\u0010\fJ \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b'\u0010(R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b*\u0010\u000fR\u001c\u0010\u001a\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b+\u0010\u000fR\u001d\u0010\u001e\u001a\u00060\u0016j\u0002`\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010,\u001a\u0004\b-\u0010\u0019R\u001c\u0010\u001b\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b/\u0010\u0012R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00100\u001a\u0004\b1\u0010\u0015¨\u00064"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$ChannelBenefit;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefit;", "toGuildRoleSubscriptionBenefit", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefit;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "Lcom/discord/models/domain/emoji/Emoji;", "component2", "()Lcom/discord/models/domain/emoji/Emoji;", "component3", "component4", "()Ljava/lang/Integer;", "", "Lcom/discord/primitives/ChannelId;", "component5", "()J", ModelAuditLogEntry.CHANGE_KEY_NAME, "emoji", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "channelIconResId", "channelId", "copy", "(Ljava/lang/String;Lcom/discord/models/domain/emoji/Emoji;Ljava/lang/String;Ljava/lang/Integer;J)Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$ChannelBenefit;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "getName", "J", "getChannelId", "Lcom/discord/models/domain/emoji/Emoji;", "getEmoji", "Ljava/lang/Integer;", "getChannelIconResId", "<init>", "(Ljava/lang/String;Lcom/discord/models/domain/emoji/Emoji;Ljava/lang/String;Ljava/lang/Integer;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelBenefit extends Benefit {
        public static final Parcelable.Creator<ChannelBenefit> CREATOR = new Creator();
        private final Integer channelIconResId;
        private final long channelId;
        private final String description;
        private final Emoji emoji;
        private final String name;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ChannelBenefit> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ChannelBenefit createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new ChannelBenefit(parcel.readString(), (Emoji) parcel.readParcelable(ChannelBenefit.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ChannelBenefit createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ChannelBenefit[] newArray(int i) {
                return new ChannelBenefit[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ChannelBenefit[] newArray(int i) {
                return newArray(i);
            }
        }

        public /* synthetic */ ChannelBenefit(String str, Emoji emoji, String str2, Integer num, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, emoji, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, j);
        }

        public static /* synthetic */ ChannelBenefit copy$default(ChannelBenefit channelBenefit, String str, Emoji emoji, String str2, Integer num, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = channelBenefit.getName();
            }
            if ((i & 2) != 0) {
                emoji = channelBenefit.getEmoji();
            }
            Emoji emoji2 = emoji;
            if ((i & 4) != 0) {
                str2 = channelBenefit.getDescription();
            }
            String str3 = str2;
            if ((i & 8) != 0) {
                num = channelBenefit.channelIconResId;
            }
            Integer num2 = num;
            if ((i & 16) != 0) {
                j = channelBenefit.channelId;
            }
            return channelBenefit.copy(str, emoji2, str3, num2, j);
        }

        public final String component1() {
            return getName();
        }

        public final Emoji component2() {
            return getEmoji();
        }

        public final String component3() {
            return getDescription();
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getChannelIconResId() {
            return this.channelIconResId;
        }

        /* renamed from: component5, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        public final ChannelBenefit copy(String name, Emoji emoji, String description, @DrawableRes Integer channelIconResId, long channelId) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            return new ChannelBenefit(name, emoji, description, channelIconResId, channelId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public boolean equals(Object other) {
            if (super.equals(other) && (other instanceof ChannelBenefit)) {
                ChannelBenefit channelBenefit = (ChannelBenefit) other;
                if (Intrinsics3.areEqual(this.channelIconResId, channelBenefit.channelIconResId) && this.channelId == channelBenefit.channelId) {
                    return true;
                }
            }
            return false;
        }

        public final Integer getChannelIconResId() {
            return this.channelIconResId;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public String getDescription() {
            return this.description;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public Emoji getEmoji() {
            return this.emoji;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            int iHashCode = (getEmoji().hashCode() + (getName().hashCode() * 31)) * 31;
            String description = getDescription();
            int iHashCode2 = (iHashCode + (description != null ? description.hashCode() : 0)) * 31;
            Integer num = this.channelIconResId;
            return b.a(this.channelId) + ((iHashCode2 + (num != null ? num.intValue() : 0)) * 31);
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public GuildRoleSubscriptionBenefit toGuildRoleSubscriptionBenefit() {
            Emoji emoji = getEmoji();
            if (!(emoji instanceof ModelEmojiCustom)) {
                emoji = null;
            }
            ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) emoji;
            Long lValueOf = modelEmojiCustom != null ? Long.valueOf(modelEmojiCustom.getId()) : null;
            Emoji emoji2 = getEmoji();
            if (!(emoji2 instanceof ModelEmojiUnicode)) {
                emoji2 = null;
            }
            ModelEmojiUnicode modelEmojiUnicode = (ModelEmojiUnicode) emoji2;
            return new GuildRoleSubscriptionBenefit(lValueOf, modelEmojiUnicode != null ? modelEmojiUnicode.getSurrogates() : null, getName(), GuildRoleSubscriptionBenefitType.CHANNEL, getDescription(), Long.valueOf(this.channelId));
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelBenefit(name=");
            sbU.append(getName());
            sbU.append(", emoji=");
            sbU.append(getEmoji());
            sbU.append(", description=");
            sbU.append(getDescription());
            sbU.append(", channelIconResId=");
            sbU.append(this.channelIconResId);
            sbU.append(", channelId=");
            return outline.C(sbU, this.channelId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            int iIntValue;
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.name);
            parcel.writeParcelable(this.emoji, flags);
            parcel.writeString(this.description);
            Integer num = this.channelIconResId;
            if (num != null) {
                parcel.writeInt(1);
                iIntValue = num.intValue();
            } else {
                iIntValue = 0;
            }
            parcel.writeInt(iIntValue);
            parcel.writeLong(this.channelId);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelBenefit(String str, Emoji emoji, String str2, @DrawableRes Integer num, long j) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            this.name = str;
            this.emoji = emoji;
            this.description = str2;
            this.channelIconResId = num;
            this.channelId = j;
        }
    }

    /* compiled from: Benefit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000fJ0\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u000fJ\u0010\u0010\u001a\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001a\u0010\fJ \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b%\u0010\u000f¨\u0006("}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$IntangibleBenefit;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefit;", "toGuildRoleSubscriptionBenefit", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefit;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "Lcom/discord/models/domain/emoji/Emoji;", "component2", "()Lcom/discord/models/domain/emoji/Emoji;", "component3", ModelAuditLogEntry.CHANGE_KEY_NAME, "emoji", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "copy", "(Ljava/lang/String;Lcom/discord/models/domain/emoji/Emoji;Ljava/lang/String;)Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$IntangibleBenefit;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "Lcom/discord/models/domain/emoji/Emoji;", "getEmoji", "getName", "<init>", "(Ljava/lang/String;Lcom/discord/models/domain/emoji/Emoji;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class IntangibleBenefit extends Benefit {
        public static final Parcelable.Creator<IntangibleBenefit> CREATOR = new Creator();
        private final String description;
        private final Emoji emoji;
        private final String name;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<IntangibleBenefit> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final IntangibleBenefit createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new IntangibleBenefit(parcel.readString(), (Emoji) parcel.readParcelable(IntangibleBenefit.class.getClassLoader()), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ IntangibleBenefit createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final IntangibleBenefit[] newArray(int i) {
                return new IntangibleBenefit[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ IntangibleBenefit[] newArray(int i) {
                return newArray(i);
            }
        }

        public /* synthetic */ IntangibleBenefit(String str, Emoji emoji, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, emoji, (i & 4) != 0 ? null : str2);
        }

        public static /* synthetic */ IntangibleBenefit copy$default(IntangibleBenefit intangibleBenefit, String str, Emoji emoji, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = intangibleBenefit.getName();
            }
            if ((i & 2) != 0) {
                emoji = intangibleBenefit.getEmoji();
            }
            if ((i & 4) != 0) {
                str2 = intangibleBenefit.getDescription();
            }
            return intangibleBenefit.copy(str, emoji, str2);
        }

        public final String component1() {
            return getName();
        }

        public final Emoji component2() {
            return getEmoji();
        }

        public final String component3() {
            return getDescription();
        }

        public final IntangibleBenefit copy(String name, Emoji emoji, String description) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            return new IntangibleBenefit(name, emoji, description);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public boolean equals(Object other) {
            return super.equals(other) && (other instanceof IntangibleBenefit);
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public String getDescription() {
            return this.description;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public Emoji getEmoji() {
            return this.emoji;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            int iHashCode = (getEmoji().hashCode() + (getName().hashCode() * 31)) * 31;
            String description = getDescription();
            return iHashCode + (description != null ? description.hashCode() : 0);
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public GuildRoleSubscriptionBenefit toGuildRoleSubscriptionBenefit() {
            Emoji emoji = getEmoji();
            if (!(emoji instanceof ModelEmojiCustom)) {
                emoji = null;
            }
            ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) emoji;
            Long lValueOf = modelEmojiCustom != null ? Long.valueOf(modelEmojiCustom.getId()) : null;
            Emoji emoji2 = getEmoji();
            if (!(emoji2 instanceof ModelEmojiUnicode)) {
                emoji2 = null;
            }
            ModelEmojiUnicode modelEmojiUnicode = (ModelEmojiUnicode) emoji2;
            return new GuildRoleSubscriptionBenefit(lValueOf, modelEmojiUnicode != null ? modelEmojiUnicode.getSurrogates() : null, getName(), GuildRoleSubscriptionBenefitType.INTANGIBLE, getDescription(), null);
        }

        public String toString() {
            StringBuilder sbU = outline.U("IntangibleBenefit(name=");
            sbU.append(getName());
            sbU.append(", emoji=");
            sbU.append(getEmoji());
            sbU.append(", description=");
            sbU.append(getDescription());
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.name);
            parcel.writeParcelable(this.emoji, flags);
            parcel.writeString(this.description);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntangibleBenefit(String str, Emoji emoji, String str2) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            this.name = str;
            this.emoji = emoji;
            this.description = str2;
        }
    }

    private Benefit() {
    }

    public boolean equals(Object other) {
        if (other instanceof Benefit) {
            Benefit benefit = (Benefit) other;
            if (Intrinsics3.areEqual(getName(), benefit.getName()) && Intrinsics3.areEqual(getDescription(), benefit.getDescription())) {
                Emoji emoji = getEmoji();
                if (!(emoji instanceof ModelEmojiCustom)) {
                    emoji = null;
                }
                ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) emoji;
                Long lValueOf = modelEmojiCustom != null ? Long.valueOf(modelEmojiCustom.getId()) : null;
                Emoji emoji2 = benefit.getEmoji();
                if (!(emoji2 instanceof ModelEmojiCustom)) {
                    emoji2 = null;
                }
                ModelEmojiCustom modelEmojiCustom2 = (ModelEmojiCustom) emoji2;
                if (Intrinsics3.areEqual(lValueOf, modelEmojiCustom2 != null ? Long.valueOf(modelEmojiCustom2.getId()) : null)) {
                    Emoji emoji3 = getEmoji();
                    if (!(emoji3 instanceof ModelEmojiUnicode)) {
                        emoji3 = null;
                    }
                    ModelEmojiUnicode modelEmojiUnicode = (ModelEmojiUnicode) emoji3;
                    String surrogates = modelEmojiUnicode != null ? modelEmojiUnicode.getSurrogates() : null;
                    Emoji emoji4 = benefit.getEmoji();
                    if (!(emoji4 instanceof ModelEmojiUnicode)) {
                        emoji4 = null;
                    }
                    ModelEmojiUnicode modelEmojiUnicode2 = (ModelEmojiUnicode) emoji4;
                    if (Intrinsics3.areEqual(surrogates, modelEmojiUnicode2 != null ? modelEmojiUnicode2.getSurrogates() : null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public abstract String getDescription();

    public abstract Emoji getEmoji();

    public abstract String getName();

    public abstract GuildRoleSubscriptionBenefit toGuildRoleSubscriptionBenefit();

    public /* synthetic */ Benefit(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
