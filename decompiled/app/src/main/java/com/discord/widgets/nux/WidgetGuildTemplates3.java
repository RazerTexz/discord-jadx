package com.discord.widgets.nux;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetGuildTemplates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJH\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0018J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\fR\u0019\u0010\u0012\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b(\u0010\fR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b)\u0010\u0004R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010*\u001a\u0004\b+\u0010\t¨\u0006."}, d2 = {"Lcom/discord/widgets/nux/GuildTemplateArgs;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/discord/widgets/nux/GuildTemplate;", "component3", "()Ljava/util/List;", "", "component4", "()Z", "component5", "title", "subtitle", "templates", "showInvitePrompt", "skipCreationIntent", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZ)Lcom/discord/widgets/nux/GuildTemplateArgs;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSubtitle", "Z", "getShowInvitePrompt", "getSkipCreationIntent", "getTitle", "Ljava/util/List;", "getTemplates", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.nux.GuildTemplateArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetGuildTemplates3 implements Parcelable {
    public static final Parcelable.Creator<WidgetGuildTemplates3> CREATOR = new Creator();
    private final boolean showInvitePrompt;
    private final boolean skipCreationIntent;
    private final String subtitle;
    private final List<GuildTemplates> templates;
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.GuildTemplateArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetGuildTemplates3> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildTemplates3 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            while (i != 0) {
                arrayList.add((GuildTemplates) Enum.valueOf(GuildTemplates.class, parcel.readString()));
                i--;
            }
            return new WidgetGuildTemplates3(string, string2, arrayList, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetGuildTemplates3 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildTemplates3[] newArray(int i) {
            return new WidgetGuildTemplates3[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetGuildTemplates3[] newArray(int i) {
            return newArray(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGuildTemplates3(String str, String str2, List<? extends GuildTemplates> list, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(str, "title");
        Intrinsics3.checkNotNullParameter(str2, "subtitle");
        Intrinsics3.checkNotNullParameter(list, "templates");
        this.title = str;
        this.subtitle = str2;
        this.templates = list;
        this.showInvitePrompt = z2;
        this.skipCreationIntent = z3;
    }

    public static /* synthetic */ WidgetGuildTemplates3 copy$default(WidgetGuildTemplates3 widgetGuildTemplates3, String str, String str2, List list, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetGuildTemplates3.title;
        }
        if ((i & 2) != 0) {
            str2 = widgetGuildTemplates3.subtitle;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            list = widgetGuildTemplates3.templates;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            z2 = widgetGuildTemplates3.showInvitePrompt;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = widgetGuildTemplates3.skipCreationIntent;
        }
        return widgetGuildTemplates3.copy(str, str3, list2, z4, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    public final List<GuildTemplates> component3() {
        return this.templates;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getShowInvitePrompt() {
        return this.showInvitePrompt;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getSkipCreationIntent() {
        return this.skipCreationIntent;
    }

    public final WidgetGuildTemplates3 copy(String title, String subtitle, List<? extends GuildTemplates> templates, boolean showInvitePrompt, boolean skipCreationIntent) {
        Intrinsics3.checkNotNullParameter(title, "title");
        Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics3.checkNotNullParameter(templates, "templates");
        return new WidgetGuildTemplates3(title, subtitle, templates, showInvitePrompt, skipCreationIntent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildTemplates3)) {
            return false;
        }
        WidgetGuildTemplates3 widgetGuildTemplates3 = (WidgetGuildTemplates3) other;
        return Intrinsics3.areEqual(this.title, widgetGuildTemplates3.title) && Intrinsics3.areEqual(this.subtitle, widgetGuildTemplates3.subtitle) && Intrinsics3.areEqual(this.templates, widgetGuildTemplates3.templates) && this.showInvitePrompt == widgetGuildTemplates3.showInvitePrompt && this.skipCreationIntent == widgetGuildTemplates3.skipCreationIntent;
    }

    public final boolean getShowInvitePrompt() {
        return this.showInvitePrompt;
    }

    public final boolean getSkipCreationIntent() {
        return this.skipCreationIntent;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final List<GuildTemplates> getTemplates() {
        return this.templates;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subtitle;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<GuildTemplates> list = this.templates;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.showInvitePrompt;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z3 = this.skipCreationIntent;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildTemplateArgs(title=");
        sbU.append(this.title);
        sbU.append(", subtitle=");
        sbU.append(this.subtitle);
        sbU.append(", templates=");
        sbU.append(this.templates);
        sbU.append(", showInvitePrompt=");
        sbU.append(this.showInvitePrompt);
        sbU.append(", skipCreationIntent=");
        return outline.O(sbU, this.skipCreationIntent, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        List<GuildTemplates> list = this.templates;
        parcel.writeInt(list.size());
        Iterator<GuildTemplates> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next().name());
        }
        parcel.writeInt(this.showInvitePrompt ? 1 : 0);
        parcel.writeInt(this.skipCreationIntent ? 1 : 0);
    }

    public /* synthetic */ WidgetGuildTemplates3(String str, String str2, List list, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? GuildTemplates2.INSTANCE.getNUX() : list, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? false : z3);
    }
}
