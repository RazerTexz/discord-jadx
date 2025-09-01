package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetRadioSelectorBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/widgets/hubs/RadioSelectorItems;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/widgets/hubs/RadioSelectorItem;", "component2", "()Ljava/util/List;", "title", "items", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/discord/widgets/hubs/RadioSelectorItems;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getItems", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.RadioSelectorItems, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetRadioSelectorBottomSheet3 implements Parcelable {
    public static final Parcelable.Creator<WidgetRadioSelectorBottomSheet3> CREATOR = new Creator();
    private final List<WidgetRadioSelectorBottomSheet2> items;
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.RadioSelectorItems$Creator */
    public static class Creator implements Parcelable.Creator<WidgetRadioSelectorBottomSheet3> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetRadioSelectorBottomSheet3 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            while (i != 0) {
                arrayList.add(WidgetRadioSelectorBottomSheet2.CREATOR.createFromParcel(parcel));
                i--;
            }
            return new WidgetRadioSelectorBottomSheet3(string, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetRadioSelectorBottomSheet3 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetRadioSelectorBottomSheet3[] newArray(int i) {
            return new WidgetRadioSelectorBottomSheet3[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetRadioSelectorBottomSheet3[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetRadioSelectorBottomSheet3(String str, List<WidgetRadioSelectorBottomSheet2> list) {
        Intrinsics3.checkNotNullParameter(str, "title");
        Intrinsics3.checkNotNullParameter(list, "items");
        this.title = str;
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetRadioSelectorBottomSheet3 copy$default(WidgetRadioSelectorBottomSheet3 widgetRadioSelectorBottomSheet3, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetRadioSelectorBottomSheet3.title;
        }
        if ((i & 2) != 0) {
            list = widgetRadioSelectorBottomSheet3.items;
        }
        return widgetRadioSelectorBottomSheet3.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<WidgetRadioSelectorBottomSheet2> component2() {
        return this.items;
    }

    public final WidgetRadioSelectorBottomSheet3 copy(String title, List<WidgetRadioSelectorBottomSheet2> items) {
        Intrinsics3.checkNotNullParameter(title, "title");
        Intrinsics3.checkNotNullParameter(items, "items");
        return new WidgetRadioSelectorBottomSheet3(title, items);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetRadioSelectorBottomSheet3)) {
            return false;
        }
        WidgetRadioSelectorBottomSheet3 widgetRadioSelectorBottomSheet3 = (WidgetRadioSelectorBottomSheet3) other;
        return Intrinsics3.areEqual(this.title, widgetRadioSelectorBottomSheet3.title) && Intrinsics3.areEqual(this.items, widgetRadioSelectorBottomSheet3.items);
    }

    public final List<WidgetRadioSelectorBottomSheet2> getItems() {
        return this.items;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<WidgetRadioSelectorBottomSheet2> list = this.items;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("RadioSelectorItems(title=");
        sbU.append(this.title);
        sbU.append(", items=");
        return outline.L(sbU, this.items, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        List<WidgetRadioSelectorBottomSheet2> list = this.items;
        parcel.writeInt(list.size());
        Iterator<WidgetRadioSelectorBottomSheet2> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, 0);
        }
    }
}
