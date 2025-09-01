package com.discord.widgets.directories;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.models.hubs.DirectoryEntryCategory;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetDirectoryCategory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/directories/DirectoryCategoryArgs;", "Landroid/os/Parcelable;", "Lcom/discord/models/hubs/DirectoryEntryCategory;", "component1", "()Lcom/discord/models/hubs/DirectoryEntryCategory;", "directoryCategory", "copy", "(Lcom/discord/models/hubs/DirectoryEntryCategory;)Lcom/discord/widgets/directories/DirectoryCategoryArgs;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/discord/models/hubs/DirectoryEntryCategory;", "getDirectoryCategory", "<init>", "(Lcom/discord/models/hubs/DirectoryEntryCategory;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.directories.DirectoryCategoryArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetDirectoryCategory2 implements Parcelable {
    public static final Parcelable.Creator<WidgetDirectoryCategory2> CREATOR = new Creator();
    private final DirectoryEntryCategory directoryCategory;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.DirectoryCategoryArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetDirectoryCategory2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetDirectoryCategory2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetDirectoryCategory2((DirectoryEntryCategory) Enum.valueOf(DirectoryEntryCategory.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetDirectoryCategory2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetDirectoryCategory2[] newArray(int i) {
            return new WidgetDirectoryCategory2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetDirectoryCategory2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetDirectoryCategory2(DirectoryEntryCategory directoryEntryCategory) {
        Intrinsics3.checkNotNullParameter(directoryEntryCategory, "directoryCategory");
        this.directoryCategory = directoryEntryCategory;
    }

    public static /* synthetic */ WidgetDirectoryCategory2 copy$default(WidgetDirectoryCategory2 widgetDirectoryCategory2, DirectoryEntryCategory directoryEntryCategory, int i, Object obj) {
        if ((i & 1) != 0) {
            directoryEntryCategory = widgetDirectoryCategory2.directoryCategory;
        }
        return widgetDirectoryCategory2.copy(directoryEntryCategory);
    }

    /* renamed from: component1, reason: from getter */
    public final DirectoryEntryCategory getDirectoryCategory() {
        return this.directoryCategory;
    }

    public final WidgetDirectoryCategory2 copy(DirectoryEntryCategory directoryCategory) {
        Intrinsics3.checkNotNullParameter(directoryCategory, "directoryCategory");
        return new WidgetDirectoryCategory2(directoryCategory);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetDirectoryCategory2) && Intrinsics3.areEqual(this.directoryCategory, ((WidgetDirectoryCategory2) other).directoryCategory);
        }
        return true;
    }

    public final DirectoryEntryCategory getDirectoryCategory() {
        return this.directoryCategory;
    }

    public int hashCode() {
        DirectoryEntryCategory directoryEntryCategory = this.directoryCategory;
        if (directoryEntryCategory != null) {
            return directoryEntryCategory.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("DirectoryCategoryArgs(directoryCategory=");
        sbU.append(this.directoryCategory);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.directoryCategory.name());
    }
}
