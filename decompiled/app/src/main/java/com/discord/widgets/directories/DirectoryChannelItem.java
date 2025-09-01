package com.discord.widgets.directories;

import androidx.annotation.StringRes;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/directories/DirectoryChannelItem;", "", "Lcom/discord/widgets/directories/DirectoryChannelItem$ViewType;", "viewType", "Lcom/discord/widgets/directories/DirectoryChannelItem$ViewType;", "getViewType", "()Lcom/discord/widgets/directories/DirectoryChannelItem$ViewType;", "<init>", "(Lcom/discord/widgets/directories/DirectoryChannelItem$ViewType;)V", "AddServer", "DirectoryItem", "SectionHeader", "ViewType", "Lcom/discord/widgets/directories/DirectoryChannelItem$DirectoryItem;", "Lcom/discord/widgets/directories/DirectoryChannelItem$AddServer;", "Lcom/discord/widgets/directories/DirectoryChannelItem$SectionHeader;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class DirectoryChannelItem {
    private final ViewType viewType;

    /* compiled from: WidgetDirectoryEntryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/directories/DirectoryChannelItem$AddServer;", "Lcom/discord/widgets/directories/DirectoryChannelItem;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AddServer extends DirectoryChannelItem {
        public static final AddServer INSTANCE = new AddServer();

        private AddServer() {
            super(ViewType.AddServer, null);
        }
    }

    /* compiled from: WidgetDirectoryEntryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/directories/DirectoryChannelItem$DirectoryItem;", "Lcom/discord/widgets/directories/DirectoryChannelItem;", "Lcom/discord/widgets/directories/DirectoryEntryData;", "component1", "()Lcom/discord/widgets/directories/DirectoryEntryData;", "directoryEntryData", "copy", "(Lcom/discord/widgets/directories/DirectoryEntryData;)Lcom/discord/widgets/directories/DirectoryChannelItem$DirectoryItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/directories/DirectoryEntryData;", "getDirectoryEntryData", "<init>", "(Lcom/discord/widgets/directories/DirectoryEntryData;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class DirectoryItem extends DirectoryChannelItem {
        private final DirectoryEntryData directoryEntryData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectoryItem(DirectoryEntryData directoryEntryData) {
            super(ViewType.Item, null);
            Intrinsics3.checkNotNullParameter(directoryEntryData, "directoryEntryData");
            this.directoryEntryData = directoryEntryData;
        }

        public static /* synthetic */ DirectoryItem copy$default(DirectoryItem directoryItem, DirectoryEntryData directoryEntryData, int i, Object obj) {
            if ((i & 1) != 0) {
                directoryEntryData = directoryItem.directoryEntryData;
            }
            return directoryItem.copy(directoryEntryData);
        }

        /* renamed from: component1, reason: from getter */
        public final DirectoryEntryData getDirectoryEntryData() {
            return this.directoryEntryData;
        }

        public final DirectoryItem copy(DirectoryEntryData directoryEntryData) {
            Intrinsics3.checkNotNullParameter(directoryEntryData, "directoryEntryData");
            return new DirectoryItem(directoryEntryData);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof DirectoryItem) && Intrinsics3.areEqual(this.directoryEntryData, ((DirectoryItem) other).directoryEntryData);
            }
            return true;
        }

        public final DirectoryEntryData getDirectoryEntryData() {
            return this.directoryEntryData;
        }

        public int hashCode() {
            DirectoryEntryData directoryEntryData = this.directoryEntryData;
            if (directoryEntryData != null) {
                return directoryEntryData.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("DirectoryItem(directoryEntryData=");
            sbU.append(this.directoryEntryData);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetDirectoryEntryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/directories/DirectoryChannelItem$SectionHeader;", "Lcom/discord/widgets/directories/DirectoryChannelItem;", "", "component1", "()I", "textRes", "copy", "(I)Lcom/discord/widgets/directories/DirectoryChannelItem$SectionHeader;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTextRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SectionHeader extends DirectoryChannelItem {
        private final int textRes;

        public SectionHeader(@StringRes int i) {
            super(ViewType.SectionHeader, null);
            this.textRes = i;
        }

        public static /* synthetic */ SectionHeader copy$default(SectionHeader sectionHeader, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = sectionHeader.textRes;
            }
            return sectionHeader.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getTextRes() {
            return this.textRes;
        }

        public final SectionHeader copy(@StringRes int textRes) {
            return new SectionHeader(textRes);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof SectionHeader) && this.textRes == ((SectionHeader) other).textRes;
            }
            return true;
        }

        public final int getTextRes() {
            return this.textRes;
        }

        public int hashCode() {
            return this.textRes;
        }

        public String toString() {
            return outline.B(outline.U("SectionHeader(textRes="), this.textRes, ")");
        }
    }

    /* compiled from: WidgetDirectoryEntryViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/directories/DirectoryChannelItem$ViewType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "Item", "AddServer", "SectionHeader", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum ViewType {
        Item,
        AddServer,
        SectionHeader;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: WidgetDirectoryEntryViewHolder.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/directories/DirectoryChannelItem$ViewType$Companion;", "", "", "type", "Lcom/discord/widgets/directories/DirectoryChannelItem$ViewType;", "findType", "(I)Lcom/discord/widgets/directories/DirectoryChannelItem$ViewType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final ViewType findType(int type) {
                return ViewType.values()[type];
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    private DirectoryChannelItem(ViewType viewType) {
        this.viewType = viewType;
    }

    public final ViewType getViewType() {
        return this.viewType;
    }

    public /* synthetic */ DirectoryChannelItem(ViewType viewType, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewType);
    }
}
