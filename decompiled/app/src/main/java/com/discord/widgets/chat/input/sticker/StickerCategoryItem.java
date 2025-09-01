package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.utilities.recycler.DiffKeyProvider;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StickerCategoryItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00132\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B-\b\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0003\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem;", "Lcom/discord/utilities/recycler/DiffKeyProvider;", "Lkotlin/Pair;", "", "categoryRange", "Lkotlin/Pair;", "getCategoryRange", "()Lkotlin/Pair;", "", "isSelected", "Z", "()Z", "", "categoryId", "J", "getCategoryId", "()J", "<init>", "(ZLkotlin/Pair;J)V", "Companion", "GuildItem", "PackItem", "RecentItem", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$RecentItem;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$PackItem;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$GuildItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class StickerCategoryItem implements DiffKeyProvider {
    public static final int TYPE_GUILD = 2;
    public static final int TYPE_PACK = 1;
    public static final int TYPE_RECENT = 0;
    private final long categoryId;
    private final Tuples2<Integer, Integer> categoryRange;
    private final boolean isSelected;

    /* compiled from: StickerCategoryItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJJ\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u0013\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0013\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b\u0013\u0010\u000fR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\bR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u0004R\u001c\u0010$\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0018R(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\f¨\u0006+"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$GuildItem;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "Lcom/discord/api/sticker/Sticker;", "component2", "()Ljava/util/List;", "Lkotlin/Pair;", "", "component3", "()Lkotlin/Pair;", "", "component4", "()Z", "guild", "stickers", "categoryRange", "isSelected", "copy", "(Lcom/discord/models/guild/Guild;Ljava/util/List;Lkotlin/Pair;Z)Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$GuildItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/util/List;", "getStickers", "Lcom/discord/models/guild/Guild;", "getGuild", "key", "Ljava/lang/String;", "getKey", "Lkotlin/Pair;", "getCategoryRange", "<init>", "(Lcom/discord/models/guild/Guild;Ljava/util/List;Lkotlin/Pair;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildItem extends StickerCategoryItem {
        private final Tuples2<Integer, Integer> categoryRange;
        private final Guild guild;
        private final boolean isSelected;
        private final String key;
        private final List<Sticker> stickers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildItem(Guild guild, List<Sticker> list, Tuples2<Integer, Integer> tuples2, boolean z2) {
            super(z2, tuples2, guild.getId(), null);
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(list, "stickers");
            Intrinsics3.checkNotNullParameter(tuples2, "categoryRange");
            this.guild = guild;
            this.stickers = list;
            this.categoryRange = tuples2;
            this.isSelected = z2;
            this.key = String.valueOf(guild.getId());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildItem copy$default(GuildItem guildItem, Guild guild, List list, Tuples2 tuples2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = guildItem.guild;
            }
            if ((i & 2) != 0) {
                list = guildItem.stickers;
            }
            if ((i & 4) != 0) {
                tuples2 = guildItem.getCategoryRange();
            }
            if ((i & 8) != 0) {
                z2 = guildItem.getIsSelected();
            }
            return guildItem.copy(guild, list, tuples2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final List<Sticker> component2() {
            return this.stickers;
        }

        public final Tuples2<Integer, Integer> component3() {
            return getCategoryRange();
        }

        public final boolean component4() {
            return getIsSelected();
        }

        public final GuildItem copy(Guild guild, List<Sticker> stickers, Tuples2<Integer, Integer> categoryRange, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(stickers, "stickers");
            Intrinsics3.checkNotNullParameter(categoryRange, "categoryRange");
            return new GuildItem(guild, stickers, categoryRange, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildItem)) {
                return false;
            }
            GuildItem guildItem = (GuildItem) other;
            return Intrinsics3.areEqual(this.guild, guildItem.guild) && Intrinsics3.areEqual(this.stickers, guildItem.stickers) && Intrinsics3.areEqual(getCategoryRange(), guildItem.getCategoryRange()) && getIsSelected() == guildItem.getIsSelected();
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        public Tuples2<Integer, Integer> getCategoryRange() {
            return this.categoryRange;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final List<Sticker> getStickers() {
            return this.stickers;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            List<Sticker> list = this.stickers;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            Tuples2<Integer, Integer> categoryRange = getCategoryRange();
            int iHashCode3 = (iHashCode2 + (categoryRange != null ? categoryRange.hashCode() : 0)) * 31;
            boolean isSelected = getIsSelected();
            ?? r1 = isSelected;
            if (isSelected) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        /* renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildItem(guild=");
            sbU.append(this.guild);
            sbU.append(", stickers=");
            sbU.append(this.stickers);
            sbU.append(", categoryRange=");
            sbU.append(getCategoryRange());
            sbU.append(", isSelected=");
            sbU.append(getIsSelected());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StickerCategoryItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R(\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001c\u0010\u001c\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0013R\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$PackItem;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem;", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "component1", "()Lcom/discord/models/sticker/dto/ModelStickerPack;", "Lkotlin/Pair;", "", "component2", "()Lkotlin/Pair;", "", "component3", "()Z", "pack", "categoryRange", "isSelected", "copy", "(Lcom/discord/models/sticker/dto/ModelStickerPack;Lkotlin/Pair;Z)Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$PackItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/Pair;", "getCategoryRange", "key", "Ljava/lang/String;", "getKey", "Z", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "getPack", "<init>", "(Lcom/discord/models/sticker/dto/ModelStickerPack;Lkotlin/Pair;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PackItem extends StickerCategoryItem {
        private final Tuples2<Integer, Integer> categoryRange;
        private final boolean isSelected;
        private final String key;
        private final ModelStickerPack pack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PackItem(ModelStickerPack modelStickerPack, Tuples2<Integer, Integer> tuples2, boolean z2) {
            super(z2, tuples2, modelStickerPack.getId(), null);
            Intrinsics3.checkNotNullParameter(modelStickerPack, "pack");
            Intrinsics3.checkNotNullParameter(tuples2, "categoryRange");
            this.pack = modelStickerPack;
            this.categoryRange = tuples2;
            this.isSelected = z2;
            this.key = String.valueOf(modelStickerPack.getId());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PackItem copy$default(PackItem packItem, ModelStickerPack modelStickerPack, Tuples2 tuples2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelStickerPack = packItem.pack;
            }
            if ((i & 2) != 0) {
                tuples2 = packItem.getCategoryRange();
            }
            if ((i & 4) != 0) {
                z2 = packItem.getIsSelected();
            }
            return packItem.copy(modelStickerPack, tuples2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelStickerPack getPack() {
            return this.pack;
        }

        public final Tuples2<Integer, Integer> component2() {
            return getCategoryRange();
        }

        public final boolean component3() {
            return getIsSelected();
        }

        public final PackItem copy(ModelStickerPack pack, Tuples2<Integer, Integer> categoryRange, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(pack, "pack");
            Intrinsics3.checkNotNullParameter(categoryRange, "categoryRange");
            return new PackItem(pack, categoryRange, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PackItem)) {
                return false;
            }
            PackItem packItem = (PackItem) other;
            return Intrinsics3.areEqual(this.pack, packItem.pack) && Intrinsics3.areEqual(getCategoryRange(), packItem.getCategoryRange()) && getIsSelected() == packItem.getIsSelected();
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        public Tuples2<Integer, Integer> getCategoryRange() {
            return this.categoryRange;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final ModelStickerPack getPack() {
            return this.pack;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            ModelStickerPack modelStickerPack = this.pack;
            int iHashCode = (modelStickerPack != null ? modelStickerPack.hashCode() : 0) * 31;
            Tuples2<Integer, Integer> categoryRange = getCategoryRange();
            int iHashCode2 = (iHashCode + (categoryRange != null ? categoryRange.hashCode() : 0)) * 31;
            boolean isSelected = getIsSelected();
            ?? r1 = isSelected;
            if (isSelected) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        /* renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PackItem(pack=");
            sbU.append(this.pack);
            sbU.append(", categoryRange=");
            sbU.append(getCategoryRange());
            sbU.append(", isSelected=");
            sbU.append(getIsSelected());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StickerCategoryItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\r8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\t\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$RecentItem;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem;", "", "component1", "()Z", "Lkotlin/Pair;", "", "component2", "()Lkotlin/Pair;", "isSelected", "categoryRange", "copy", "(ZLkotlin/Pair;)Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$RecentItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "Lkotlin/Pair;", "getCategoryRange", "Z", "<init>", "(ZLkotlin/Pair;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class RecentItem extends StickerCategoryItem {
        private final Tuples2<Integer, Integer> categoryRange;
        private final boolean isSelected;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecentItem(boolean z2, Tuples2<Integer, Integer> tuples2) {
            super(z2, tuples2, -1L, null);
            Intrinsics3.checkNotNullParameter(tuples2, "categoryRange");
            this.isSelected = z2;
            this.categoryRange = tuples2;
            this.key = "recent";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RecentItem copy$default(RecentItem recentItem, boolean z2, Tuples2 tuples2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = recentItem.getIsSelected();
            }
            if ((i & 2) != 0) {
                tuples2 = recentItem.getCategoryRange();
            }
            return recentItem.copy(z2, tuples2);
        }

        public final boolean component1() {
            return getIsSelected();
        }

        public final Tuples2<Integer, Integer> component2() {
            return getCategoryRange();
        }

        public final RecentItem copy(boolean isSelected, Tuples2<Integer, Integer> categoryRange) {
            Intrinsics3.checkNotNullParameter(categoryRange, "categoryRange");
            return new RecentItem(isSelected, categoryRange);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecentItem)) {
                return false;
            }
            RecentItem recentItem = (RecentItem) other;
            return getIsSelected() == recentItem.getIsSelected() && Intrinsics3.areEqual(getCategoryRange(), recentItem.getCategoryRange());
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        public Tuples2<Integer, Integer> getCategoryRange() {
            return this.categoryRange;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean isSelected = getIsSelected();
            ?? r0 = isSelected;
            if (isSelected) {
                r0 = 1;
            }
            int i = r0 * 31;
            Tuples2<Integer, Integer> categoryRange = getCategoryRange();
            return i + (categoryRange != null ? categoryRange.hashCode() : 0);
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        /* renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RecentItem(isSelected=");
            sbU.append(getIsSelected());
            sbU.append(", categoryRange=");
            sbU.append(getCategoryRange());
            sbU.append(")");
            return sbU.toString();
        }
    }

    private StickerCategoryItem(boolean z2, Tuples2<Integer, Integer> tuples2, long j) {
        this.isSelected = z2;
        this.categoryRange = tuples2;
        this.categoryId = j;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public Tuples2<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    /* renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public /* synthetic */ StickerCategoryItem(boolean z2, Tuples2 tuples2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, tuples2, j);
    }
}
