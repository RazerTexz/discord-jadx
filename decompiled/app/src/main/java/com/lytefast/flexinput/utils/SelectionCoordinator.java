package com.lytefast.flexinput.utils;

import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.b.a.g.SelectionCoordinator2;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: SelectionCoordinator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00028\u00002\u00020\u0003:\u0003'(\bJ\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0012\u001a\u00020\n2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0001\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0001\u0012\u00028\u0000`\u0010¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00050\u00148\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010 8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/lytefast/flexinput/utils/SelectionCoordinator;", "I", ExifInterface.GPS_DIRECTION_TRUE, "", "item", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "a", "(Ljava/lang/Object;I)Z", "", "c", "(Ljava/lang/Object;I)V", "d", "(Ljava/lang/Object;)Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectedItems", "b", "(Ljava/util/ArrayList;)V", "Landroidx/collection/ArrayMap;", "Landroidx/collection/ArrayMap;", "getSelectedItemPositionMap", "()Landroidx/collection/ArrayMap;", "selectedItemPositionMap", "Lcom/lytefast/flexinput/utils/SelectionCoordinator$ItemSelectionListener;", "Lcom/lytefast/flexinput/utils/SelectionCoordinator$ItemSelectionListener;", "getItemSelectionListener", "()Lcom/lytefast/flexinput/utils/SelectionCoordinator$ItemSelectionListener;", "setItemSelectionListener", "(Lcom/lytefast/flexinput/utils/SelectionCoordinator$ItemSelectionListener;)V", "itemSelectionListener", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "adapter", "ItemSelectionListener", "RestorationException", "flexinput_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class SelectionCoordinator<I, T extends I> {

    /* renamed from: a, reason: from kotlin metadata */
    public RecyclerView.Adapter<?> adapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ArrayMap<T, Integer> selectedItemPositionMap;

    /* renamed from: c, reason: from kotlin metadata */
    public ItemSelectionListener<? super I> itemSelectionListener;

    /* compiled from: SelectionCoordinator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00002\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/lytefast/flexinput/utils/SelectionCoordinator$ItemSelectionListener;", "I", "", "item", "", "onItemSelected", "(Ljava/lang/Object;)V", "onItemUnselected", "unregister", "()V", "flexinput_release"}, k = 1, mv = {1, 4, 2})
    public interface ItemSelectionListener<I> {
        void onItemSelected(I item);

        void onItemUnselected(I item);

        void unregister();
    }

    /* compiled from: SelectionCoordinator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/lytefast/flexinput/utils/SelectionCoordinator$RestorationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", NotificationCompat.CATEGORY_MESSAGE, "<init>", "(Ljava/lang/String;)V", "flexinput_release"}, k = 1, mv = {1, 4, 2})
    public static final class RestorationException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RestorationException(String str) {
            super(str);
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        }
    }

    /* compiled from: SelectionCoordinator.kt */
    public static final class a<T> {
        public final T a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3171b;

        public a(T t, boolean z2) {
            this.a = t;
            this.f3171b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.a, aVar.a) && this.f3171b == aVar.f3171b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            T t = this.a;
            int iHashCode = (t != null ? t.hashCode() : 0) * 31;
            boolean z2 = this.f3171b;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SelectionEvent(item=");
            sbU.append(this.a);
            sbU.append(", isSelected=");
            return outline.O(sbU, this.f3171b, ")");
        }
    }

    public SelectionCoordinator() {
        this(null, null, 3);
    }

    public SelectionCoordinator(ArrayMap arrayMap, ItemSelectionListener itemSelectionListener, int i) {
        ArrayMap<T, Integer> arrayMap2 = (i & 1) != 0 ? new ArrayMap<>(4) : null;
        SelectionCoordinator2 selectionCoordinator2 = (i & 2) != 0 ? new SelectionCoordinator2() : null;
        Intrinsics3.checkNotNullParameter(arrayMap2, "selectedItemPositionMap");
        Intrinsics3.checkNotNullParameter(selectionCoordinator2, "itemSelectionListener");
        this.selectedItemPositionMap = arrayMap2;
        this.itemSelectionListener = selectionCoordinator2;
    }

    public final boolean a(T item, int position) {
        Integer num = this.selectedItemPositionMap.get(item);
        if (num == null) {
            return false;
        }
        if (position == num.intValue()) {
            return true;
        }
        this.selectedItemPositionMap.put(item, Integer.valueOf(position));
        return true;
    }

    public final void b(ArrayList<? extends I> selectedItems) throws RestorationException {
        Intrinsics3.checkNotNullParameter(selectedItems, "selectedItems");
        if (this.adapter != null) {
            throw new RestorationException("cannot restoreSelections after adapter set: prevents mismatches");
        }
        Iterator<? extends I> it = selectedItems.iterator();
        while (it.hasNext()) {
            I next = it.next();
            if (!(next instanceof Object)) {
                next = null;
            }
            if (next != null) {
                this.selectedItemPositionMap.put(next, -1);
            }
        }
    }

    public final void c(T item, int position) {
        this.selectedItemPositionMap.put(item, Integer.valueOf(position));
        RecyclerView.Adapter<?> adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyItemChanged(position, new a(item, true));
        }
        this.itemSelectionListener.onItemSelected(item);
    }

    public final boolean d(I item) {
        ArrayMap<T, Integer> arrayMap = this.selectedItemPositionMap;
        Objects.requireNonNull(arrayMap, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        Integer num = (Integer) TypeIntrinsics.asMutableMap(arrayMap).remove(item);
        if (num == null) {
            return false;
        }
        int iIntValue = num.intValue();
        RecyclerView.Adapter<?> adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyItemChanged(iIntValue, new a(item, false));
        }
        this.itemSelectionListener.onItemUnselected(item);
        return true;
    }
}
