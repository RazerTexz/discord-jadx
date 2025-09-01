package com.discord.widgets.botuikit.views.select;

import b.d.b.a.outline;
import com.discord.api.botuikit.SelectComponent2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SelectComponentBottomSheetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetItem;", "", "Lcom/discord/api/botuikit/SelectItem;", "component1", "()Lcom/discord/api/botuikit/SelectItem;", "", "component2", "()Z", "selectItem", "selected", "copy", "(Lcom/discord/api/botuikit/SelectItem;Z)Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/botuikit/SelectItem;", "getSelectItem", "Z", "getSelected", "<init>", "(Lcom/discord/api/botuikit/SelectItem;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheetItem, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class SelectComponentBottomSheetAdapter2 {
    private final SelectComponent2 selectItem;
    private final boolean selected;

    public SelectComponentBottomSheetAdapter2(SelectComponent2 selectComponent2, boolean z2) {
        Intrinsics3.checkNotNullParameter(selectComponent2, "selectItem");
        this.selectItem = selectComponent2;
        this.selected = z2;
    }

    public static /* synthetic */ SelectComponentBottomSheetAdapter2 copy$default(SelectComponentBottomSheetAdapter2 selectComponentBottomSheetAdapter2, SelectComponent2 selectComponent2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            selectComponent2 = selectComponentBottomSheetAdapter2.selectItem;
        }
        if ((i & 2) != 0) {
            z2 = selectComponentBottomSheetAdapter2.selected;
        }
        return selectComponentBottomSheetAdapter2.copy(selectComponent2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final SelectComponent2 getSelectItem() {
        return this.selectItem;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final SelectComponentBottomSheetAdapter2 copy(SelectComponent2 selectItem, boolean selected) {
        Intrinsics3.checkNotNullParameter(selectItem, "selectItem");
        return new SelectComponentBottomSheetAdapter2(selectItem, selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectComponentBottomSheetAdapter2)) {
            return false;
        }
        SelectComponentBottomSheetAdapter2 selectComponentBottomSheetAdapter2 = (SelectComponentBottomSheetAdapter2) other;
        return Intrinsics3.areEqual(this.selectItem, selectComponentBottomSheetAdapter2.selectItem) && this.selected == selectComponentBottomSheetAdapter2.selected;
    }

    public final SelectComponent2 getSelectItem() {
        return this.selectItem;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        SelectComponent2 selectComponent2 = this.selectItem;
        int iHashCode = (selectComponent2 != null ? selectComponent2.hashCode() : 0) * 31;
        boolean z2 = this.selected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("SelectComponentBottomSheetItem(selectItem=");
        sbU.append(this.selectItem);
        sbU.append(", selected=");
        return outline.O(sbU, this.selected, ")");
    }
}
