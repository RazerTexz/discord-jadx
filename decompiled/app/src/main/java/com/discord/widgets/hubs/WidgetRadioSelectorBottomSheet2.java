package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetRadioSelectorBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/discord/widgets/hubs/RadioSelectorItem;", "Landroid/os/Parcelable;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", ModelAuditLogEntry.CHANGE_KEY_ID, NotificationCompat.MessagingStyle.Message.KEY_TEXT, "selected", "copy", "(ILjava/lang/String;Z)Lcom/discord/widgets/hubs/RadioSelectorItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getText", "Z", "getSelected", "I", "getId", "<init>", "(ILjava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.RadioSelectorItem, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetRadioSelectorBottomSheet2 implements Parcelable {
    public static final Parcelable.Creator<WidgetRadioSelectorBottomSheet2> CREATOR = new Creator();
    private final int id;
    private final boolean selected;
    private final String text;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.RadioSelectorItem$Creator */
    public static class Creator implements Parcelable.Creator<WidgetRadioSelectorBottomSheet2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetRadioSelectorBottomSheet2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetRadioSelectorBottomSheet2(parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetRadioSelectorBottomSheet2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetRadioSelectorBottomSheet2[] newArray(int i) {
            return new WidgetRadioSelectorBottomSheet2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetRadioSelectorBottomSheet2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetRadioSelectorBottomSheet2(int i, String str, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.id = i;
        this.text = str;
        this.selected = z2;
    }

    public static /* synthetic */ WidgetRadioSelectorBottomSheet2 copy$default(WidgetRadioSelectorBottomSheet2 widgetRadioSelectorBottomSheet2, int i, String str, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetRadioSelectorBottomSheet2.id;
        }
        if ((i2 & 2) != 0) {
            str = widgetRadioSelectorBottomSheet2.text;
        }
        if ((i2 & 4) != 0) {
            z2 = widgetRadioSelectorBottomSheet2.selected;
        }
        return widgetRadioSelectorBottomSheet2.copy(i, str, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final WidgetRadioSelectorBottomSheet2 copy(int id2, String text, boolean selected) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new WidgetRadioSelectorBottomSheet2(id2, text, selected);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetRadioSelectorBottomSheet2)) {
            return false;
        }
        WidgetRadioSelectorBottomSheet2 widgetRadioSelectorBottomSheet2 = (WidgetRadioSelectorBottomSheet2) other;
        return this.id == widgetRadioSelectorBottomSheet2.id && Intrinsics3.areEqual(this.text, widgetRadioSelectorBottomSheet2.text) && this.selected == widgetRadioSelectorBottomSheet2.selected;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.id * 31;
        String str = this.text;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.selected;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return iHashCode + i2;
    }

    public String toString() {
        StringBuilder sbU = outline.U("RadioSelectorItem(id=");
        sbU.append(this.id);
        sbU.append(", text=");
        sbU.append(this.text);
        sbU.append(", selected=");
        return outline.O(sbU, this.selected, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.text);
        parcel.writeInt(this.selected ? 1 : 0);
    }
}
