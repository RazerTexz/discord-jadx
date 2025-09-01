package com.discord.widgets.chat.input.emoji;

import b.d.b.a.outline;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.models.guild.Guild;
import com.discord.utilities.recycler.DiffKeyProvider;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmojiCategoryItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB-\b\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0002\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem;", "Lcom/discord/utilities/recycler/DiffKeyProvider;", "", "containsOnlyUnicodeEmoji", "()Z", "isSelected", "Z", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "Lkotlin/Pair;", "", "categoryRange", "Lkotlin/Pair;", "getCategoryRange", "()Lkotlin/Pair;", "", "stableId", "J", "getStableId", "()J", "<init>", "(JLkotlin/Pair;Z)V", "Companion", "GuildItem", "StandardItem", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$StandardItem;", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$GuildItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class EmojiCategoryItem implements DiffKeyProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int TYPE_GUILD = 1;
    public static final int TYPE_STANDARD = 0;
    private final Tuples2<Integer, Integer> categoryRange;
    private final boolean isSelected;
    private final String key;
    private final long stableId;

    /* compiled from: EmojiCategoryItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$Companion;", "", "Lcom/discord/models/domain/emoji/EmojiCategory;", "emojiCategory", "", "mapEmojiCategoryToItemId", "(Lcom/discord/models/domain/emoji/EmojiCategory;)J", "Lcom/discord/models/guild/Guild;", "guild", "mapGuildToItemId", "(Lcom/discord/models/guild/Guild;)J", "", "TYPE_GUILD", "I", "TYPE_STANDARD", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final long mapEmojiCategoryToItemId(EmojiCategory emojiCategory) {
            Intrinsics3.checkNotNullParameter(emojiCategory, "emojiCategory");
            return emojiCategory.name().hashCode();
        }

        public final long mapGuildToItemId(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return guild.getId();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EmojiCategoryItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R(\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\b¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$GuildItem;", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lkotlin/Pair;", "", "component2", "()Lkotlin/Pair;", "", "component3", "()Z", "guild", "categoryRange", "isSelected", "copy", "(Lcom/discord/models/guild/Guild;Lkotlin/Pair;Z)Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$GuildItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Lkotlin/Pair;", "getCategoryRange", "<init>", "(Lcom/discord/models/guild/Guild;Lkotlin/Pair;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildItem extends EmojiCategoryItem {
        private final Tuples2<Integer, Integer> categoryRange;
        private final Guild guild;
        private final boolean isSelected;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildItem(Guild guild, Tuples2<Integer, Integer> tuples2, boolean z2) {
            super(EmojiCategoryItem.INSTANCE.mapGuildToItemId(guild), tuples2, z2, null);
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(tuples2, "categoryRange");
            this.guild = guild;
            this.categoryRange = tuples2;
            this.isSelected = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildItem copy$default(GuildItem guildItem, Guild guild, Tuples2 tuples2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = guildItem.guild;
            }
            if ((i & 2) != 0) {
                tuples2 = guildItem.getCategoryRange();
            }
            if ((i & 4) != 0) {
                z2 = guildItem.getIsSelected();
            }
            return guildItem.copy(guild, tuples2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Tuples2<Integer, Integer> component2() {
            return getCategoryRange();
        }

        public final boolean component3() {
            return getIsSelected();
        }

        public final GuildItem copy(Guild guild, Tuples2<Integer, Integer> categoryRange, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(categoryRange, "categoryRange");
            return new GuildItem(guild, categoryRange, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildItem)) {
                return false;
            }
            GuildItem guildItem = (GuildItem) other;
            return Intrinsics3.areEqual(this.guild, guildItem.guild) && Intrinsics3.areEqual(getCategoryRange(), guildItem.getCategoryRange()) && getIsSelected() == guildItem.getIsSelected();
        }

        @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
        public Tuples2<Integer, Integer> getCategoryRange() {
            return this.categoryRange;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Tuples2<Integer, Integer> categoryRange = getCategoryRange();
            int iHashCode2 = (iHashCode + (categoryRange != null ? categoryRange.hashCode() : 0)) * 31;
            boolean isSelected = getIsSelected();
            ?? r1 = isSelected;
            if (isSelected) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
        /* renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildItem(guild=");
            sbU.append(this.guild);
            sbU.append(", categoryRange=");
            sbU.append(getCategoryRange());
            sbU.append(", isSelected=");
            sbU.append(getIsSelected());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: EmojiCategoryItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u000e\u0010\u000bR(\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\b¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$StandardItem;", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem;", "Lcom/discord/models/domain/emoji/EmojiCategory;", "component1", "()Lcom/discord/models/domain/emoji/EmojiCategory;", "Lkotlin/Pair;", "", "component2", "()Lkotlin/Pair;", "", "component3", "()Z", "emojiCategory", "categoryRange", "isSelected", "copy", "(Lcom/discord/models/domain/emoji/EmojiCategory;Lkotlin/Pair;Z)Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$StandardItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/emoji/EmojiCategory;", "getEmojiCategory", "Z", "Lkotlin/Pair;", "getCategoryRange", "<init>", "(Lcom/discord/models/domain/emoji/EmojiCategory;Lkotlin/Pair;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StandardItem extends EmojiCategoryItem {
        private final Tuples2<Integer, Integer> categoryRange;
        private final EmojiCategory emojiCategory;
        private final boolean isSelected;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StandardItem(EmojiCategory emojiCategory, Tuples2<Integer, Integer> tuples2, boolean z2) {
            super(EmojiCategoryItem.INSTANCE.mapEmojiCategoryToItemId(emojiCategory), tuples2, z2, null);
            Intrinsics3.checkNotNullParameter(emojiCategory, "emojiCategory");
            Intrinsics3.checkNotNullParameter(tuples2, "categoryRange");
            this.emojiCategory = emojiCategory;
            this.categoryRange = tuples2;
            this.isSelected = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StandardItem copy$default(StandardItem standardItem, EmojiCategory emojiCategory, Tuples2 tuples2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                emojiCategory = standardItem.emojiCategory;
            }
            if ((i & 2) != 0) {
                tuples2 = standardItem.getCategoryRange();
            }
            if ((i & 4) != 0) {
                z2 = standardItem.getIsSelected();
            }
            return standardItem.copy(emojiCategory, tuples2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final EmojiCategory getEmojiCategory() {
            return this.emojiCategory;
        }

        public final Tuples2<Integer, Integer> component2() {
            return getCategoryRange();
        }

        public final boolean component3() {
            return getIsSelected();
        }

        public final StandardItem copy(EmojiCategory emojiCategory, Tuples2<Integer, Integer> categoryRange, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(emojiCategory, "emojiCategory");
            Intrinsics3.checkNotNullParameter(categoryRange, "categoryRange");
            return new StandardItem(emojiCategory, categoryRange, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StandardItem)) {
                return false;
            }
            StandardItem standardItem = (StandardItem) other;
            return Intrinsics3.areEqual(this.emojiCategory, standardItem.emojiCategory) && Intrinsics3.areEqual(getCategoryRange(), standardItem.getCategoryRange()) && getIsSelected() == standardItem.getIsSelected();
        }

        @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
        public Tuples2<Integer, Integer> getCategoryRange() {
            return this.categoryRange;
        }

        public final EmojiCategory getEmojiCategory() {
            return this.emojiCategory;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            EmojiCategory emojiCategory = this.emojiCategory;
            int iHashCode = (emojiCategory != null ? emojiCategory.hashCode() : 0) * 31;
            Tuples2<Integer, Integer> categoryRange = getCategoryRange();
            int iHashCode2 = (iHashCode + (categoryRange != null ? categoryRange.hashCode() : 0)) * 31;
            boolean isSelected = getIsSelected();
            ?? r1 = isSelected;
            if (isSelected) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
        /* renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StandardItem(emojiCategory=");
            sbU.append(this.emojiCategory);
            sbU.append(", categoryRange=");
            sbU.append(getCategoryRange());
            sbU.append(", isSelected=");
            sbU.append(getIsSelected());
            sbU.append(")");
            return sbU.toString();
        }
    }

    private EmojiCategoryItem(long j, Tuples2<Integer, Integer> tuples2, boolean z2) {
        this.stableId = j;
        this.categoryRange = tuples2;
        this.isSelected = z2;
        this.key = String.valueOf(j);
    }

    public final boolean containsOnlyUnicodeEmoji() {
        return (this instanceof StandardItem) && ((StandardItem) this).getEmojiCategory().containsOnlyUnicode;
    }

    public Tuples2<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getStableId() {
        return this.stableId;
    }

    /* renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public /* synthetic */ EmojiCategoryItem(long j, Tuples2 tuples2, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, tuples2, z2);
    }
}
