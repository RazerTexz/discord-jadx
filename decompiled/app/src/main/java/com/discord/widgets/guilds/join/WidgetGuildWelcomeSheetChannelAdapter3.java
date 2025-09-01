package com.discord.widgets.guilds.join;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0002\n\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guilds/join/ChannelItem;", "", "", "type", "I", "getType", "()I", "<init>", "(I)V", "Companion", "ChannelData", "Lcom/discord/widgets/guilds/join/ChannelItem$ChannelData;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.join.ChannelItem, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class WidgetGuildWelcomeSheetChannelAdapter3 {
    public static final int TYPE_CHANNEL = 0;
    private final int type;

    /* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\f\u0012\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JZ\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0014\u001a\u00020\t2\u001a\b\u0002\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\f2\b\b\u0002\u0010\u0016\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0011J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\bR+\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010\u000fR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u000bR\u0019\u0010\u0016\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\u0011¨\u0006."}, d2 = {"Lcom/discord/widgets/guilds/join/ChannelItem$ChannelData;", "Lcom/discord/widgets/guilds/join/ChannelItem;", "Lcom/discord/api/guild/welcome/GuildWelcomeChannel;", "component1", "()Lcom/discord/api/guild/welcome/GuildWelcomeChannel;", "Lkotlin/Function0;", "", "component2", "()Lkotlin/jvm/functions/Function0;", "", "component3", "()J", "Lkotlin/Function2;", "", "component4", "()Lkotlin/jvm/functions/Function2;", "component5", "()I", "welcomeChannel", "dismissSheet", "guildId", "goToChannel", "index", "copy", "(Lcom/discord/api/guild/welcome/GuildWelcomeChannel;Lkotlin/jvm/functions/Function0;JLkotlin/jvm/functions/Function2;I)Lcom/discord/widgets/guilds/join/ChannelItem$ChannelData;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function0;", "getDismissSheet", "Lkotlin/jvm/functions/Function2;", "getGoToChannel", "Lcom/discord/api/guild/welcome/GuildWelcomeChannel;", "getWelcomeChannel", "J", "getGuildId", "I", "getIndex", "<init>", "(Lcom/discord/api/guild/welcome/GuildWelcomeChannel;Lkotlin/jvm/functions/Function0;JLkotlin/jvm/functions/Function2;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.join.ChannelItem$ChannelData */
    public static final /* data */ class ChannelData extends WidgetGuildWelcomeSheetChannelAdapter3 {
        private final Function0<Unit> dismissSheet;
        private final Function2<Long, Integer, Unit> goToChannel;
        private final long guildId;
        private final int index;
        private final GuildWelcomeChannel welcomeChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ChannelData(GuildWelcomeChannel guildWelcomeChannel, Function0<Unit> function0, long j, Function2<? super Long, ? super Integer, Unit> function2, int i) {
            super(0, null);
            Intrinsics3.checkNotNullParameter(guildWelcomeChannel, "welcomeChannel");
            Intrinsics3.checkNotNullParameter(function0, "dismissSheet");
            Intrinsics3.checkNotNullParameter(function2, "goToChannel");
            this.welcomeChannel = guildWelcomeChannel;
            this.dismissSheet = function0;
            this.guildId = j;
            this.goToChannel = function2;
            this.index = i;
        }

        public static /* synthetic */ ChannelData copy$default(ChannelData channelData, GuildWelcomeChannel guildWelcomeChannel, Function0 function0, long j, Function2 function2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                guildWelcomeChannel = channelData.welcomeChannel;
            }
            if ((i2 & 2) != 0) {
                function0 = channelData.dismissSheet;
            }
            Function0 function02 = function0;
            if ((i2 & 4) != 0) {
                j = channelData.guildId;
            }
            long j2 = j;
            if ((i2 & 8) != 0) {
                function2 = channelData.goToChannel;
            }
            Function2 function22 = function2;
            if ((i2 & 16) != 0) {
                i = channelData.index;
            }
            return channelData.copy(guildWelcomeChannel, function02, j2, function22, i);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildWelcomeChannel getWelcomeChannel() {
            return this.welcomeChannel;
        }

        public final Function0<Unit> component2() {
            return this.dismissSheet;
        }

        /* renamed from: component3, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final Function2<Long, Integer, Unit> component4() {
            return this.goToChannel;
        }

        /* renamed from: component5, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public final ChannelData copy(GuildWelcomeChannel welcomeChannel, Function0<Unit> dismissSheet, long guildId, Function2<? super Long, ? super Integer, Unit> goToChannel, int index) {
            Intrinsics3.checkNotNullParameter(welcomeChannel, "welcomeChannel");
            Intrinsics3.checkNotNullParameter(dismissSheet, "dismissSheet");
            Intrinsics3.checkNotNullParameter(goToChannel, "goToChannel");
            return new ChannelData(welcomeChannel, dismissSheet, guildId, goToChannel, index);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelData)) {
                return false;
            }
            ChannelData channelData = (ChannelData) other;
            return Intrinsics3.areEqual(this.welcomeChannel, channelData.welcomeChannel) && Intrinsics3.areEqual(this.dismissSheet, channelData.dismissSheet) && this.guildId == channelData.guildId && Intrinsics3.areEqual(this.goToChannel, channelData.goToChannel) && this.index == channelData.index;
        }

        public final Function0<Unit> getDismissSheet() {
            return this.dismissSheet;
        }

        public final Function2<Long, Integer, Unit> getGoToChannel() {
            return this.goToChannel;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final int getIndex() {
            return this.index;
        }

        public final GuildWelcomeChannel getWelcomeChannel() {
            return this.welcomeChannel;
        }

        public int hashCode() {
            GuildWelcomeChannel guildWelcomeChannel = this.welcomeChannel;
            int iHashCode = (guildWelcomeChannel != null ? guildWelcomeChannel.hashCode() : 0) * 31;
            Function0<Unit> function0 = this.dismissSheet;
            int iA = (b.a(this.guildId) + ((iHashCode + (function0 != null ? function0.hashCode() : 0)) * 31)) * 31;
            Function2<Long, Integer, Unit> function2 = this.goToChannel;
            return ((iA + (function2 != null ? function2.hashCode() : 0)) * 31) + this.index;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelData(welcomeChannel=");
            sbU.append(this.welcomeChannel);
            sbU.append(", dismissSheet=");
            sbU.append(this.dismissSheet);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", goToChannel=");
            sbU.append(this.goToChannel);
            sbU.append(", index=");
            return outline.B(sbU, this.index, ")");
        }
    }

    private WidgetGuildWelcomeSheetChannelAdapter3(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    public /* synthetic */ WidgetGuildWelcomeSheetChannelAdapter3(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
