package com.discord.widgets.guilds.list;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildListItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u000b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\n\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListItem;", "", "", "itemId", "J", "getItemId", "()J", "<init>", "(J)V", "Companion", "CreateItem", "DividerItem", "FolderItem", "FriendsItem", "GuildItem", "HelpItem", "HubItem", "PrivateChannelItem", "SpaceItem", "UnavailableItem", "Lcom/discord/widgets/guilds/list/GuildListItem$GuildItem;", "Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;", "Lcom/discord/widgets/guilds/list/GuildListItem$PrivateChannelItem;", "Lcom/discord/widgets/guilds/list/GuildListItem$UnavailableItem;", "Lcom/discord/widgets/guilds/list/GuildListItem$FriendsItem;", "Lcom/discord/widgets/guilds/list/GuildListItem$DividerItem;", "Lcom/discord/widgets/guilds/list/GuildListItem$CreateItem;", "Lcom/discord/widgets/guilds/list/GuildListItem$HubItem;", "Lcom/discord/widgets/guilds/list/GuildListItem$HelpItem;", "Lcom/discord/widgets/guilds/list/GuildListItem$SpaceItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class GuildListItem {
    private static final long ID_BOTTOM_NAV_SPACE = -6;
    private static final long ID_CREATE = -3;
    private static final long ID_DIVIDER = -4;
    private static final long ID_FRIENDS_LIST = -2;
    private static final long ID_HELP = -5;
    private static final long ID_HUB = -8;
    public static final long ID_PENDING_GUILDS_FOLDER = -7;
    private static final long ID_UNIDENTIFIED = -1;
    public static final int TYPE_BOTTOM_NAV_SPACE = 8;
    public static final int TYPE_CREATE = 5;
    public static final int TYPE_DIVIDER = 1;
    public static final int TYPE_DM = 2;
    public static final int TYPE_FOLDER = 6;
    public static final int TYPE_FRIENDS = 0;
    public static final int TYPE_GUILD = 3;
    public static final int TYPE_HELP = 7;
    public static final int TYPE_HUB = 9;
    public static final int TYPE_UNAVAILABLE = 4;
    private final long itemId;

    /* compiled from: GuildListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListItem$CreateItem;", "Lcom/discord/widgets/guilds/list/GuildListItem;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class CreateItem extends GuildListItem {
        public static final CreateItem INSTANCE = new CreateItem();

        private CreateItem() {
            super(-3L, null);
        }
    }

    /* compiled from: GuildListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListItem$DividerItem;", "Lcom/discord/widgets/guilds/list/GuildListItem;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class DividerItem extends GuildListItem {
        public static final DividerItem INSTANCE = new DividerItem();

        private DividerItem() {
            super(GuildListItem.ID_DIVIDER, null);
        }
    }

    /* compiled from: GuildListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002Bo\u0012\n\u0010\u001b\u001a\u00060\u0003j\u0002`\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010 \u001a\u00020\r\u0012\u0006\u0010!\u001a\u00020\r\u0012\u0006\u0010\"\u001a\u00020\r\u0012\u0006\u0010#\u001a\u00020\u0007\u0012\u0006\u0010$\u001a\u00020\r\u0012\b\b\u0002\u0010%\u001a\u00020\r¢\u0006\u0004\b:\u0010;J\u0014\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000fJ\u0010\u0010\u0015\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000fJ\u0010\u0010\u0017\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u000fJ\u0010\u0010\u001a\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u000fJ\u008c\u0001\u0010&\u001a\u00020\u00002\f\b\u0002\u0010\u001b\u001a\u00060\u0003j\u0002`\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001e\u001a\u00020\r2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\r2\b\b\u0002\u0010%\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b(\u0010\fJ\u0010\u0010)\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b)\u0010\u0018J\u001a\u0010,\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b,\u0010-R\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b/\u0010\u0013R\u0019\u0010!\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00100\u001a\u0004\b!\u0010\u000fR\u0019\u0010\u001e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b\u001e\u0010\u000fR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b2\u0010\tR\u0019\u0010\"\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00100\u001a\u0004\b\"\u0010\u000fR\u0019\u00103\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b3\u0010\u000fR\u0019\u0010 \u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b \u0010\u000fR\u0019\u0010%\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b%\u00100\u001a\u0004\b%\u0010\u000fR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b5\u0010\fR\u001c\u0010$\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u00100\u001a\u0004\b$\u0010\u000fR\u001d\u0010\u001b\u001a\u00060\u0003j\u0002`\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00106\u001a\u0004\b7\u0010\u0006R\u001c\u0010#\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u00108\u001a\u0004\b9\u0010\u0018¨\u0006<"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;", "Lcom/discord/widgets/guilds/list/GuildListItem;", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$UnreadItem;", "", "Lcom/discord/primitives/FolderId;", "component1", "()J", "", "component2", "()Ljava/lang/Integer;", "", "component3", "()Ljava/lang/String;", "", "component4", "()Z", "", "Lcom/discord/models/guild/Guild;", "component5", "()Ljava/util/List;", "component6", "component7", "component8", "component9", "()I", "component10", "component11", "folderId", ModelAuditLogEntry.CHANGE_KEY_COLOR, ModelAuditLogEntry.CHANGE_KEY_NAME, "isOpen", "guilds", "isAnyGuildSelected", "isAnyGuildConnectedToVoice", "isAnyGuildConnectedToStageChannel", "mentionCount", "isUnread", "isTargetedForFolderAddition", "copy", "(JLjava/lang/Integer;Ljava/lang/String;ZLjava/util/List;ZZZIZZ)Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getGuilds", "Z", "Ljava/lang/Integer;", "getColor", "isPendingGuildsFolder", "Ljava/lang/String;", "getName", "J", "getFolderId", "I", "getMentionCount", "<init>", "(JLjava/lang/Integer;Ljava/lang/String;ZLjava/util/List;ZZZIZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class FolderItem extends GuildListItem implements WidgetChannelListUnreads.UnreadItem {
        private final Integer color;
        private final long folderId;
        private final List<Guild> guilds;
        private final boolean isAnyGuildConnectedToStageChannel;
        private final boolean isAnyGuildConnectedToVoice;
        private final boolean isAnyGuildSelected;
        private final boolean isOpen;
        private final boolean isPendingGuildsFolder;
        private final boolean isTargetedForFolderAddition;
        private final boolean isUnread;
        private final int mentionCount;
        private final String name;

        public /* synthetic */ FolderItem(long j, Integer num, String str, boolean z2, List list, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, num, str, z2, list, z3, z4, z5, i, z6, (i2 & 1024) != 0 ? false : z7);
        }

        public static /* synthetic */ FolderItem copy$default(FolderItem folderItem, long j, Integer num, String str, boolean z2, List list, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, int i2, Object obj) {
            return folderItem.copy((i2 & 1) != 0 ? folderItem.folderId : j, (i2 & 2) != 0 ? folderItem.color : num, (i2 & 4) != 0 ? folderItem.name : str, (i2 & 8) != 0 ? folderItem.isOpen : z2, (i2 & 16) != 0 ? folderItem.guilds : list, (i2 & 32) != 0 ? folderItem.isAnyGuildSelected : z3, (i2 & 64) != 0 ? folderItem.isAnyGuildConnectedToVoice : z4, (i2 & 128) != 0 ? folderItem.isAnyGuildConnectedToStageChannel : z5, (i2 & 256) != 0 ? folderItem.getMentionCount() : i, (i2 & 512) != 0 ? folderItem.getIsUnread() : z6, (i2 & 1024) != 0 ? folderItem.isTargetedForFolderAddition : z7);
        }

        /* renamed from: component1, reason: from getter */
        public final long getFolderId() {
            return this.folderId;
        }

        public final boolean component10() {
            return getIsUnread();
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getIsTargetedForFolderAddition() {
            return this.isTargetedForFolderAddition;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getColor() {
            return this.color;
        }

        /* renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsOpen() {
            return this.isOpen;
        }

        public final List<Guild> component5() {
            return this.guilds;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsAnyGuildSelected() {
            return this.isAnyGuildSelected;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsAnyGuildConnectedToVoice() {
            return this.isAnyGuildConnectedToVoice;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsAnyGuildConnectedToStageChannel() {
            return this.isAnyGuildConnectedToStageChannel;
        }

        public final int component9() {
            return getMentionCount();
        }

        public final FolderItem copy(long folderId, Integer color, String name, boolean isOpen, List<Guild> guilds, boolean isAnyGuildSelected, boolean isAnyGuildConnectedToVoice, boolean isAnyGuildConnectedToStageChannel, int mentionCount, boolean isUnread, boolean isTargetedForFolderAddition) {
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            return new FolderItem(folderId, color, name, isOpen, guilds, isAnyGuildSelected, isAnyGuildConnectedToVoice, isAnyGuildConnectedToStageChannel, mentionCount, isUnread, isTargetedForFolderAddition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FolderItem)) {
                return false;
            }
            FolderItem folderItem = (FolderItem) other;
            return this.folderId == folderItem.folderId && Intrinsics3.areEqual(this.color, folderItem.color) && Intrinsics3.areEqual(this.name, folderItem.name) && this.isOpen == folderItem.isOpen && Intrinsics3.areEqual(this.guilds, folderItem.guilds) && this.isAnyGuildSelected == folderItem.isAnyGuildSelected && this.isAnyGuildConnectedToVoice == folderItem.isAnyGuildConnectedToVoice && this.isAnyGuildConnectedToStageChannel == folderItem.isAnyGuildConnectedToStageChannel && getMentionCount() == folderItem.getMentionCount() && getIsUnread() == folderItem.getIsUnread() && this.isTargetedForFolderAddition == folderItem.isTargetedForFolderAddition;
        }

        public final Integer getColor() {
            return this.color;
        }

        public final long getFolderId() {
            return this.folderId;
        }

        public final List<Guild> getGuilds() {
            return this.guilds;
        }

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
        public int getMentionCount() {
            return this.mentionCount;
        }

        public final String getName() {
            return this.name;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.folderId) * 31;
            Integer num = this.color;
            int iHashCode = (iA + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.isOpen;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            List<Guild> list = this.guilds;
            int iHashCode3 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z3 = this.isAnyGuildSelected;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (iHashCode3 + i3) * 31;
            boolean z4 = this.isAnyGuildConnectedToVoice;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.isAnyGuildConnectedToStageChannel;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int mentionCount = (getMentionCount() + ((i6 + i7) * 31)) * 31;
            boolean isUnread = getIsUnread();
            int i8 = isUnread;
            if (isUnread) {
                i8 = 1;
            }
            int i9 = (mentionCount + i8) * 31;
            boolean z6 = this.isTargetedForFolderAddition;
            return i9 + (z6 ? 1 : z6 ? 1 : 0);
        }

        public final boolean isAnyGuildConnectedToStageChannel() {
            return this.isAnyGuildConnectedToStageChannel;
        }

        public final boolean isAnyGuildConnectedToVoice() {
            return this.isAnyGuildConnectedToVoice;
        }

        public final boolean isAnyGuildSelected() {
            return this.isAnyGuildSelected;
        }

        public final boolean isOpen() {
            return this.isOpen;
        }

        /* renamed from: isPendingGuildsFolder, reason: from getter */
        public final boolean getIsPendingGuildsFolder() {
            return this.isPendingGuildsFolder;
        }

        public final boolean isTargetedForFolderAddition() {
            return this.isTargetedForFolderAddition;
        }

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
        /* renamed from: isUnread, reason: from getter */
        public boolean getIsUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("FolderItem(folderId=");
            sbU.append(this.folderId);
            sbU.append(", color=");
            sbU.append(this.color);
            sbU.append(", name=");
            sbU.append(this.name);
            sbU.append(", isOpen=");
            sbU.append(this.isOpen);
            sbU.append(", guilds=");
            sbU.append(this.guilds);
            sbU.append(", isAnyGuildSelected=");
            sbU.append(this.isAnyGuildSelected);
            sbU.append(", isAnyGuildConnectedToVoice=");
            sbU.append(this.isAnyGuildConnectedToVoice);
            sbU.append(", isAnyGuildConnectedToStageChannel=");
            sbU.append(this.isAnyGuildConnectedToStageChannel);
            sbU.append(", mentionCount=");
            sbU.append(getMentionCount());
            sbU.append(", isUnread=");
            sbU.append(getIsUnread());
            sbU.append(", isTargetedForFolderAddition=");
            return outline.O(sbU, this.isTargetedForFolderAddition, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FolderItem(long j, Integer num, String str, boolean z2, List<Guild> list, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7) {
            super(j, null);
            Intrinsics3.checkNotNullParameter(list, "guilds");
            this.folderId = j;
            this.color = num;
            this.name = str;
            this.isOpen = z2;
            this.guilds = list;
            this.isAnyGuildSelected = z3;
            this.isAnyGuildConnectedToVoice = z4;
            this.isAnyGuildConnectedToStageChannel = z5;
            this.mentionCount = i;
            this.isUnread = z6;
            this.isTargetedForFolderAddition = z7;
            this.isPendingGuildsFolder = j == -7;
        }
    }

    /* compiled from: GuildListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListItem$FriendsItem;", "Lcom/discord/widgets/guilds/list/GuildListItem;", "", "component1", "()Z", "isSelected", "copy", "(Z)Lcom/discord/widgets/guilds/list/GuildListItem$FriendsItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class FriendsItem extends GuildListItem {
        private final boolean isSelected;

        public FriendsItem(boolean z2) {
            super(-2L, null);
            this.isSelected = z2;
        }

        public static /* synthetic */ FriendsItem copy$default(FriendsItem friendsItem, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = friendsItem.isSelected;
            }
            return friendsItem.copy(z2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final FriendsItem copy(boolean isSelected) {
            return new FriendsItem(isSelected);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof FriendsItem) && this.isSelected == ((FriendsItem) other).isSelected;
            }
            return true;
        }

        public int hashCode() {
            boolean z2 = this.isSelected;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            return outline.O(outline.U("FriendsItem(isSelected="), this.isSelected, ")");
        }
    }

    /* compiled from: GuildListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u009d\u0001\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\t\u0012\u000e\u0010#\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f\u0012\b\b\u0002\u0010$\u001a\u00020\t\u0012\b\b\u0002\u0010%\u001a\u00020\t\u0012\b\b\u0002\u0010&\u001a\u00020\t\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010)\u001a\u00020\t\u0012\b\b\u0002\u0010*\u001a\u00020\t\u0012\b\b\u0002\u0010+\u001a\u00020\t\u0012\b\b\u0002\u0010,\u001a\u00020\t¢\u0006\u0004\bD\u0010EJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0018\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000bJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u000bJ\u0010\u0010\u001b\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u000bJ\u0010\u0010\u001d\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u000bJ²\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\t2\u0010\b\u0002\u0010#\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f2\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020\t2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010)\u001a\u00020\t2\b\b\u0002\u0010*\u001a\u00020\t2\b\b\u0002\u0010+\u001a\u00020\t2\b\b\u0002\u0010,\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u00100\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b2\u0010\bJ\u001a\u00105\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b5\u00106R\u0019\u0010\"\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\b\"\u0010\u000bR\u0019\u0010%\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b%\u00107\u001a\u0004\b8\u0010\u000bR\u001b\u0010(\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b(\u00109\u001a\u0004\b:\u0010\u0019R\u0019\u0010$\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u00107\u001a\u0004\b$\u0010\u000bR!\u0010#\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010;\u001a\u0004\b<\u0010\u0011R\u0019\u0010,\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b,\u00107\u001a\u0004\b=\u0010\u000bR\u001c\u0010\u001f\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010>\u001a\u0004\b?\u0010\bR\u0019\u0010\u001e\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010@\u001a\u0004\bA\u0010\u0005R\u0019\u0010+\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b+\u00107\u001a\u0004\b+\u0010\u000bR\u0019\u0010&\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b&\u00107\u001a\u0004\b&\u0010\u000bR\u001c\u0010!\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b!\u0010\u000bR\u001b\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010B\u001a\u0004\b'\u0010\u0016R\u0019\u0010*\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b*\u00107\u001a\u0004\bC\u0010\u000bR\u0019\u0010)\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b)\u00107\u001a\u0004\b)\u0010\u000bR\u0019\u0010 \u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u00107\u001a\u0004\b \u0010\u000b¨\u0006F"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListItem$GuildItem;", "Lcom/discord/widgets/guilds/list/GuildListItem;", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$UnreadItem;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "component2", "()I", "", "component3", "()Z", "component4", "component5", "", "Lcom/discord/primitives/FolderId;", "component6", "()Ljava/lang/Long;", "component7", "component8", "component9", "component10", "()Ljava/lang/Boolean;", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "component11", "()Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "component12", "component13", "component14", "component15", "guild", "mentionCount", "isLurkingGuild", "isUnread", "isSelected", "folderId", "isConnectedToVoice", "hasOngoingApplicationStream", "isTargetedForFolderCreation", "isLastGuildInFolder", "applicationStatus", "isPendingGuild", "hasActiveStageChannel", "isConnectedToStageChannel", "hasActiveScheduledEvent", "copy", "(Lcom/discord/models/guild/Guild;IZZZLjava/lang/Long;ZZZLjava/lang/Boolean;Lcom/discord/api/guildjoinrequest/ApplicationStatus;ZZZZ)Lcom/discord/widgets/guilds/list/GuildListItem$GuildItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHasOngoingApplicationStream", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "getApplicationStatus", "Ljava/lang/Long;", "getFolderId", "getHasActiveScheduledEvent", "I", "getMentionCount", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/lang/Boolean;", "getHasActiveStageChannel", "<init>", "(Lcom/discord/models/guild/Guild;IZZZLjava/lang/Long;ZZZLjava/lang/Boolean;Lcom/discord/api/guildjoinrequest/ApplicationStatus;ZZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildItem extends GuildListItem implements WidgetChannelListUnreads.UnreadItem {
        private final ApplicationStatus applicationStatus;
        private final Long folderId;
        private final Guild guild;
        private final boolean hasActiveScheduledEvent;
        private final boolean hasActiveStageChannel;
        private final boolean hasOngoingApplicationStream;
        private final boolean isConnectedToStageChannel;
        private final boolean isConnectedToVoice;
        private final Boolean isLastGuildInFolder;
        private final boolean isLurkingGuild;
        private final boolean isPendingGuild;
        private final boolean isSelected;
        private final boolean isTargetedForFolderCreation;
        private final boolean isUnread;
        private final int mentionCount;

        public /* synthetic */ GuildItem(Guild guild, int i, boolean z2, boolean z3, boolean z4, Long l, boolean z5, boolean z6, boolean z7, Boolean bool, ApplicationStatus applicationStatus, boolean z8, boolean z9, boolean z10, boolean z11, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(guild, i, z2, z3, z4, l, (i2 & 64) != 0 ? false : z5, (i2 & 128) != 0 ? false : z6, (i2 & 256) != 0 ? false : z7, (i2 & 512) != 0 ? null : bool, (i2 & 1024) != 0 ? null : applicationStatus, (i2 & 2048) != 0 ? false : z8, (i2 & 4096) != 0 ? false : z9, (i2 & 8192) != 0 ? false : z10, (i2 & 16384) != 0 ? false : z11);
        }

        public static /* synthetic */ GuildItem copy$default(GuildItem guildItem, Guild guild, int i, boolean z2, boolean z3, boolean z4, Long l, boolean z5, boolean z6, boolean z7, Boolean bool, ApplicationStatus applicationStatus, boolean z8, boolean z9, boolean z10, boolean z11, int i2, Object obj) {
            return guildItem.copy((i2 & 1) != 0 ? guildItem.guild : guild, (i2 & 2) != 0 ? guildItem.getMentionCount() : i, (i2 & 4) != 0 ? guildItem.isLurkingGuild : z2, (i2 & 8) != 0 ? guildItem.getIsUnread() : z3, (i2 & 16) != 0 ? guildItem.isSelected : z4, (i2 & 32) != 0 ? guildItem.folderId : l, (i2 & 64) != 0 ? guildItem.isConnectedToVoice : z5, (i2 & 128) != 0 ? guildItem.hasOngoingApplicationStream : z6, (i2 & 256) != 0 ? guildItem.isTargetedForFolderCreation : z7, (i2 & 512) != 0 ? guildItem.isLastGuildInFolder : bool, (i2 & 1024) != 0 ? guildItem.applicationStatus : applicationStatus, (i2 & 2048) != 0 ? guildItem.isPendingGuild : z8, (i2 & 4096) != 0 ? guildItem.hasActiveStageChannel : z9, (i2 & 8192) != 0 ? guildItem.isConnectedToStageChannel : z10, (i2 & 16384) != 0 ? guildItem.hasActiveScheduledEvent : z11);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component10, reason: from getter */
        public final Boolean getIsLastGuildInFolder() {
            return this.isLastGuildInFolder;
        }

        /* renamed from: component11, reason: from getter */
        public final ApplicationStatus getApplicationStatus() {
            return this.applicationStatus;
        }

        /* renamed from: component12, reason: from getter */
        public final boolean getIsPendingGuild() {
            return this.isPendingGuild;
        }

        /* renamed from: component13, reason: from getter */
        public final boolean getHasActiveStageChannel() {
            return this.hasActiveStageChannel;
        }

        /* renamed from: component14, reason: from getter */
        public final boolean getIsConnectedToStageChannel() {
            return this.isConnectedToStageChannel;
        }

        /* renamed from: component15, reason: from getter */
        public final boolean getHasActiveScheduledEvent() {
            return this.hasActiveScheduledEvent;
        }

        public final int component2() {
            return getMentionCount();
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsLurkingGuild() {
            return this.isLurkingGuild;
        }

        public final boolean component4() {
            return getIsUnread();
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        /* renamed from: component6, reason: from getter */
        public final Long getFolderId() {
            return this.folderId;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsConnectedToVoice() {
            return this.isConnectedToVoice;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getHasOngoingApplicationStream() {
            return this.hasOngoingApplicationStream;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsTargetedForFolderCreation() {
            return this.isTargetedForFolderCreation;
        }

        public final GuildItem copy(Guild guild, int mentionCount, boolean isLurkingGuild, boolean isUnread, boolean isSelected, Long folderId, boolean isConnectedToVoice, boolean hasOngoingApplicationStream, boolean isTargetedForFolderCreation, Boolean isLastGuildInFolder, ApplicationStatus applicationStatus, boolean isPendingGuild, boolean hasActiveStageChannel, boolean isConnectedToStageChannel, boolean hasActiveScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new GuildItem(guild, mentionCount, isLurkingGuild, isUnread, isSelected, folderId, isConnectedToVoice, hasOngoingApplicationStream, isTargetedForFolderCreation, isLastGuildInFolder, applicationStatus, isPendingGuild, hasActiveStageChannel, isConnectedToStageChannel, hasActiveScheduledEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildItem)) {
                return false;
            }
            GuildItem guildItem = (GuildItem) other;
            return Intrinsics3.areEqual(this.guild, guildItem.guild) && getMentionCount() == guildItem.getMentionCount() && this.isLurkingGuild == guildItem.isLurkingGuild && getIsUnread() == guildItem.getIsUnread() && this.isSelected == guildItem.isSelected && Intrinsics3.areEqual(this.folderId, guildItem.folderId) && this.isConnectedToVoice == guildItem.isConnectedToVoice && this.hasOngoingApplicationStream == guildItem.hasOngoingApplicationStream && this.isTargetedForFolderCreation == guildItem.isTargetedForFolderCreation && Intrinsics3.areEqual(this.isLastGuildInFolder, guildItem.isLastGuildInFolder) && Intrinsics3.areEqual(this.applicationStatus, guildItem.applicationStatus) && this.isPendingGuild == guildItem.isPendingGuild && this.hasActiveStageChannel == guildItem.hasActiveStageChannel && this.isConnectedToStageChannel == guildItem.isConnectedToStageChannel && this.hasActiveScheduledEvent == guildItem.hasActiveScheduledEvent;
        }

        public final ApplicationStatus getApplicationStatus() {
            return this.applicationStatus;
        }

        public final Long getFolderId() {
            return this.folderId;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final boolean getHasActiveScheduledEvent() {
            return this.hasActiveScheduledEvent;
        }

        public final boolean getHasActiveStageChannel() {
            return this.hasActiveStageChannel;
        }

        public final boolean getHasOngoingApplicationStream() {
            return this.hasOngoingApplicationStream;
        }

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
        public int getMentionCount() {
            return this.mentionCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int mentionCount = (getMentionCount() + ((guild != null ? guild.hashCode() : 0) * 31)) * 31;
            boolean z2 = this.isLurkingGuild;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (mentionCount + i) * 31;
            boolean isUnread = getIsUnread();
            int i3 = isUnread;
            if (isUnread) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z3 = this.isSelected;
            int i5 = z3;
            if (z3 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            Long l = this.folderId;
            int iHashCode = (i6 + (l != null ? l.hashCode() : 0)) * 31;
            boolean z4 = this.isConnectedToVoice;
            int i7 = z4;
            if (z4 != 0) {
                i7 = 1;
            }
            int i8 = (iHashCode + i7) * 31;
            boolean z5 = this.hasOngoingApplicationStream;
            int i9 = z5;
            if (z5 != 0) {
                i9 = 1;
            }
            int i10 = (i8 + i9) * 31;
            boolean z6 = this.isTargetedForFolderCreation;
            int i11 = z6;
            if (z6 != 0) {
                i11 = 1;
            }
            int i12 = (i10 + i11) * 31;
            Boolean bool = this.isLastGuildInFolder;
            int iHashCode2 = (i12 + (bool != null ? bool.hashCode() : 0)) * 31;
            ApplicationStatus applicationStatus = this.applicationStatus;
            int iHashCode3 = (iHashCode2 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
            boolean z7 = this.isPendingGuild;
            int i13 = z7;
            if (z7 != 0) {
                i13 = 1;
            }
            int i14 = (iHashCode3 + i13) * 31;
            boolean z8 = this.hasActiveStageChannel;
            int i15 = z8;
            if (z8 != 0) {
                i15 = 1;
            }
            int i16 = (i14 + i15) * 31;
            boolean z9 = this.isConnectedToStageChannel;
            int i17 = z9;
            if (z9 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            boolean z10 = this.hasActiveScheduledEvent;
            return i18 + (z10 ? 1 : z10 ? 1 : 0);
        }

        public final boolean isConnectedToStageChannel() {
            return this.isConnectedToStageChannel;
        }

        public final boolean isConnectedToVoice() {
            return this.isConnectedToVoice;
        }

        public final Boolean isLastGuildInFolder() {
            return this.isLastGuildInFolder;
        }

        public final boolean isLurkingGuild() {
            return this.isLurkingGuild;
        }

        public final boolean isPendingGuild() {
            return this.isPendingGuild;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final boolean isTargetedForFolderCreation() {
            return this.isTargetedForFolderCreation;
        }

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
        /* renamed from: isUnread, reason: from getter */
        public boolean getIsUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildItem(guild=");
            sbU.append(this.guild);
            sbU.append(", mentionCount=");
            sbU.append(getMentionCount());
            sbU.append(", isLurkingGuild=");
            sbU.append(this.isLurkingGuild);
            sbU.append(", isUnread=");
            sbU.append(getIsUnread());
            sbU.append(", isSelected=");
            sbU.append(this.isSelected);
            sbU.append(", folderId=");
            sbU.append(this.folderId);
            sbU.append(", isConnectedToVoice=");
            sbU.append(this.isConnectedToVoice);
            sbU.append(", hasOngoingApplicationStream=");
            sbU.append(this.hasOngoingApplicationStream);
            sbU.append(", isTargetedForFolderCreation=");
            sbU.append(this.isTargetedForFolderCreation);
            sbU.append(", isLastGuildInFolder=");
            sbU.append(this.isLastGuildInFolder);
            sbU.append(", applicationStatus=");
            sbU.append(this.applicationStatus);
            sbU.append(", isPendingGuild=");
            sbU.append(this.isPendingGuild);
            sbU.append(", hasActiveStageChannel=");
            sbU.append(this.hasActiveStageChannel);
            sbU.append(", isConnectedToStageChannel=");
            sbU.append(this.isConnectedToStageChannel);
            sbU.append(", hasActiveScheduledEvent=");
            return outline.O(sbU, this.hasActiveScheduledEvent, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildItem(Guild guild, int i, boolean z2, boolean z3, boolean z4, Long l, boolean z5, boolean z6, boolean z7, Boolean bool, ApplicationStatus applicationStatus, boolean z8, boolean z9, boolean z10, boolean z11) {
            super(guild.getId(), null);
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.guild = guild;
            this.mentionCount = i;
            this.isLurkingGuild = z2;
            this.isUnread = z3;
            this.isSelected = z4;
            this.folderId = l;
            this.isConnectedToVoice = z5;
            this.hasOngoingApplicationStream = z6;
            this.isTargetedForFolderCreation = z7;
            this.isLastGuildInFolder = bool;
            this.applicationStatus = applicationStatus;
            this.isPendingGuild = z8;
            this.hasActiveStageChannel = z9;
            this.isConnectedToStageChannel = z10;
            this.hasActiveScheduledEvent = z11;
        }
    }

    /* compiled from: GuildListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListItem$HelpItem;", "Lcom/discord/widgets/guilds/list/GuildListItem;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HelpItem extends GuildListItem {
        public static final HelpItem INSTANCE = new HelpItem();

        private HelpItem() {
            super(GuildListItem.ID_HELP, null);
        }
    }

    /* compiled from: GuildListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListItem$HubItem;", "Lcom/discord/widgets/guilds/list/GuildListItem;", "", "component1", "()Z", "showSparkle", "copy", "(Z)Lcom/discord/widgets/guilds/list/GuildListItem$HubItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowSparkle", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class HubItem extends GuildListItem {
        private final boolean showSparkle;

        public HubItem(boolean z2) {
            super(GuildListItem.ID_HUB, null);
            this.showSparkle = z2;
        }

        public static /* synthetic */ HubItem copy$default(HubItem hubItem, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = hubItem.showSparkle;
            }
            return hubItem.copy(z2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getShowSparkle() {
            return this.showSparkle;
        }

        public final HubItem copy(boolean showSparkle) {
            return new HubItem(showSparkle);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof HubItem) && this.showSparkle == ((HubItem) other).showSparkle;
            }
            return true;
        }

        public final boolean getShowSparkle() {
            return this.showSparkle;
        }

        public int hashCode() {
            boolean z2 = this.showSparkle;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public String toString() {
            return outline.O(outline.U("HubItem(showSparkle="), this.showSparkle, ")");
        }
    }

    /* compiled from: GuildListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\bJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00138\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001c\u0010\n\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\t\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListItem$PrivateChannelItem;", "Lcom/discord/widgets/guilds/list/GuildListItem;", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$UnreadItem;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()I", "channel", "mentionCount", "copy", "(Lcom/discord/api/channel/Channel;I)Lcom/discord/widgets/guilds/list/GuildListItem$PrivateChannelItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "isUnread", "Z", "()Z", "I", "getMentionCount", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PrivateChannelItem extends GuildListItem implements WidgetChannelListUnreads.UnreadItem {
        private final Channel channel;
        private final boolean isUnread;
        private final int mentionCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateChannelItem(Channel channel, int i) {
            super(channel.getId(), null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.mentionCount = i;
        }

        public static /* synthetic */ PrivateChannelItem copy$default(PrivateChannelItem privateChannelItem, Channel channel, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                channel = privateChannelItem.channel;
            }
            if ((i2 & 2) != 0) {
                i = privateChannelItem.getMentionCount();
            }
            return privateChannelItem.copy(channel, i);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final int component2() {
            return getMentionCount();
        }

        public final PrivateChannelItem copy(Channel channel, int mentionCount) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new PrivateChannelItem(channel, mentionCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PrivateChannelItem)) {
                return false;
            }
            PrivateChannelItem privateChannelItem = (PrivateChannelItem) other;
            return Intrinsics3.areEqual(this.channel, privateChannelItem.channel) && getMentionCount() == privateChannelItem.getMentionCount();
        }

        public final Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
        public int getMentionCount() {
            return this.mentionCount;
        }

        public int hashCode() {
            Channel channel = this.channel;
            return getMentionCount() + ((channel != null ? channel.hashCode() : 0) * 31);
        }

        @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
        /* renamed from: isUnread, reason: from getter */
        public boolean getIsUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PrivateChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(", mentionCount=");
            sbU.append(getMentionCount());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListItem$SpaceItem;", "Lcom/discord/widgets/guilds/list/GuildListItem;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class SpaceItem extends GuildListItem {
        public static final SpaceItem INSTANCE = new SpaceItem();

        private SpaceItem() {
            super(GuildListItem.ID_BOTTOM_NAV_SPACE, null);
        }
    }

    /* compiled from: GuildListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListItem$UnavailableItem;", "Lcom/discord/widgets/guilds/list/GuildListItem;", "", "component1", "()I", "unavailableGuildCount", "copy", "(I)Lcom/discord/widgets/guilds/list/GuildListItem$UnavailableItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getUnavailableGuildCount", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UnavailableItem extends GuildListItem {
        private final int unavailableGuildCount;

        public UnavailableItem(int i) {
            super(-1L, null);
            this.unavailableGuildCount = i;
        }

        public static /* synthetic */ UnavailableItem copy$default(UnavailableItem unavailableItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = unavailableItem.unavailableGuildCount;
            }
            return unavailableItem.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getUnavailableGuildCount() {
            return this.unavailableGuildCount;
        }

        public final UnavailableItem copy(int unavailableGuildCount) {
            return new UnavailableItem(unavailableGuildCount);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UnavailableItem) && this.unavailableGuildCount == ((UnavailableItem) other).unavailableGuildCount;
            }
            return true;
        }

        public final int getUnavailableGuildCount() {
            return this.unavailableGuildCount;
        }

        public int hashCode() {
            return this.unavailableGuildCount;
        }

        public String toString() {
            return outline.B(outline.U("UnavailableItem(unavailableGuildCount="), this.unavailableGuildCount, ")");
        }
    }

    private GuildListItem(long j) {
        this.itemId = j;
    }

    public final long getItemId() {
        return this.itemId;
    }

    public /* synthetic */ GuildListItem(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }
}
