package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StickerAdapterItems.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/HeaderType;", "", "", "getId", "()Ljava/lang/String;", "<init>", "()V", "GuildItem", "PackItem", "Recent", "Lcom/discord/widgets/chat/input/sticker/HeaderType$Recent;", "Lcom/discord/widgets/chat/input/sticker/HeaderType$PackItem;", "Lcom/discord/widgets/chat/input/sticker/HeaderType$GuildItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.HeaderType, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class StickerAdapterItems2 {

    /* compiled from: StickerAdapterItems.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/HeaderType$GuildItem;", "Lcom/discord/widgets/chat/input/sticker/HeaderType;", "", "getId", "()Ljava/lang/String;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "guild", "copy", "(Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/chat/input/sticker/HeaderType$GuildItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.HeaderType$GuildItem */
    public static final /* data */ class GuildItem extends StickerAdapterItems2 {
        private final Guild guild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildItem(Guild guild) {
            super(null);
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.guild = guild;
        }

        public static /* synthetic */ GuildItem copy$default(GuildItem guildItem, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = guildItem.guild;
            }
            return guildItem.copy(guild);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildItem copy(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new GuildItem(guild);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildItem) && Intrinsics3.areEqual(this.guild, ((GuildItem) other).guild);
            }
            return true;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerAdapterItems2
        public String getId() {
            return String.valueOf(this.guild.getId());
        }

        public int hashCode() {
            Guild guild = this.guild;
            if (guild != null) {
                return guild.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildItem(guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StickerAdapterItems.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/HeaderType$PackItem;", "Lcom/discord/widgets/chat/input/sticker/HeaderType;", "", "getId", "()Ljava/lang/String;", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "component1", "()Lcom/discord/models/sticker/dto/ModelStickerPack;", "pack", "copy", "(Lcom/discord/models/sticker/dto/ModelStickerPack;)Lcom/discord/widgets/chat/input/sticker/HeaderType$PackItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "getPack", "<init>", "(Lcom/discord/models/sticker/dto/ModelStickerPack;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.HeaderType$PackItem */
    public static final /* data */ class PackItem extends StickerAdapterItems2 {
        private final ModelStickerPack pack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PackItem(ModelStickerPack modelStickerPack) {
            super(null);
            Intrinsics3.checkNotNullParameter(modelStickerPack, "pack");
            this.pack = modelStickerPack;
        }

        public static /* synthetic */ PackItem copy$default(PackItem packItem, ModelStickerPack modelStickerPack, int i, Object obj) {
            if ((i & 1) != 0) {
                modelStickerPack = packItem.pack;
            }
            return packItem.copy(modelStickerPack);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelStickerPack getPack() {
            return this.pack;
        }

        public final PackItem copy(ModelStickerPack pack) {
            Intrinsics3.checkNotNullParameter(pack, "pack");
            return new PackItem(pack);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PackItem) && Intrinsics3.areEqual(this.pack, ((PackItem) other).pack);
            }
            return true;
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerAdapterItems2
        public String getId() {
            StringBuilder sbU = outline.U("owned-header:");
            sbU.append(this.pack.getId());
            return sbU.toString();
        }

        public final ModelStickerPack getPack() {
            return this.pack;
        }

        public int hashCode() {
            ModelStickerPack modelStickerPack = this.pack;
            if (modelStickerPack != null) {
                return modelStickerPack.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PackItem(pack=");
            sbU.append(this.pack);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StickerAdapterItems.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/HeaderType$Recent;", "Lcom/discord/widgets/chat/input/sticker/HeaderType;", "", "getId", "()Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.HeaderType$Recent */
    public static final class Recent extends StickerAdapterItems2 {
        public static final Recent INSTANCE = new Recent();

        private Recent() {
            super(null);
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerAdapterItems2
        public String getId() {
            return "recents";
        }
    }

    private StickerAdapterItems2() {
    }

    public abstract String getId();

    public /* synthetic */ StickerAdapterItems2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
