package com.lytefast.flexinput.utils;

import android.os.Parcelable;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SelectionAggregator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 :*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001:B\u0085\u0001\b\u0007\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-\u0012\u0018\b\u0002\u00106\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000ej\b\u0012\u0004\u0012\u00028\u0000`\u0010\u0012,\b\u0002\u0010)\u001a&\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030!0\u000ej\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030!`\u0010\u0012$\b\u0002\u00102\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013`\u0010¢\u0006\u0004\b8\u00109J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\b\f\u0010\rJ/\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000f0\u000ej\n\u0012\u0006\b\u0000\u0012\u00020\u000f`\u0010¢\u0006\u0004\b\f\u0010\u0012J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00052\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u001f\u0010\nJ\u0015\u0010 \u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b \u0010\u0007J\u001f\u0010#\u001a\u00020\u00052\u0010\u0010\"\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030!¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u00052\u0010\u0010\"\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030!H\u0014¢\u0006\u0004\b%\u0010$R\u0013\u0010(\u001a\u00020\u00198F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010'R@\u0010)\u001a&\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030!0\u000ej\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030!`\u00108\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R>\u00102\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013`\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b2\u0010*\u001a\u0004\b3\u0010,\"\u0004\b4\u00105R)\u00106\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000ej\b\u0012\u0004\u0012\u00028\u0000`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010*\u001a\u0004\b7\u0010,¨\u0006;"}, d2 = {"Lcom/lytefast/flexinput/utils/SelectionAggregator;", "Lcom/lytefast/flexinput/model/Attachment;", "", ExifInterface.GPS_DIRECTION_TRUE, "item", "", "addItem", "(Lcom/lytefast/flexinput/model/Attachment;)V", "", "removeItem", "(Lcom/lytefast/flexinput/model/Attachment;)Z", "old", "initFrom", "(Lcom/lytefast/flexinput/utils/SelectionAggregator;)Lcom/lytefast/flexinput/utils/SelectionAggregator;", "Ljava/util/ArrayList;", "Landroid/os/Parcelable;", "Lkotlin/collections/ArrayList;", "savedAttachments", "(Ljava/util/ArrayList;)Lcom/lytefast/flexinput/utils/SelectionAggregator;", "Lcom/lytefast/flexinput/utils/SelectionCoordinator$ItemSelectionListener;", "itemSelectionListener", "addItemSelectionListener", "(Lcom/lytefast/flexinput/utils/SelectionCoordinator$ItemSelectionListener;)Lcom/lytefast/flexinput/utils/SelectionAggregator;", "removeItemSelectionListener", "(Lcom/lytefast/flexinput/utils/SelectionCoordinator$ItemSelectionListener;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "get", "(I)Lcom/lytefast/flexinput/model/Attachment;", "clear", "()V", "toggleItemInternal", "unselectItem", "Lcom/lytefast/flexinput/utils/SelectionCoordinator;", "selectionCoordinator", "registerSelectionCoordinator", "(Lcom/lytefast/flexinput/utils/SelectionCoordinator;)V", "registerSelectionCoordinatorInternal", "getSize", "()I", "size", "childSelectionCoordinators", "Ljava/util/ArrayList;", "getChildSelectionCoordinators", "()Ljava/util/ArrayList;", "Lcom/lytefast/flexinput/adapters/AttachmentPreviewAdapter;", "adapter", "Lcom/lytefast/flexinput/adapters/AttachmentPreviewAdapter;", "getAdapter", "()Lcom/lytefast/flexinput/adapters/AttachmentPreviewAdapter;", "itemSelectionListeners", "getItemSelectionListeners", "setItemSelectionListeners", "(Ljava/util/ArrayList;)V", "attachments", "getAttachments", "<init>", "(Lcom/lytefast/flexinput/adapters/AttachmentPreviewAdapter;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "Companion", "flexinput_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class SelectionAggregator<T extends Attachment<? extends Object>> {
    private static final String TAG;
    private final AttachmentPreviewAdapter<T> adapter;
    private final ArrayList<T> attachments;
    private final ArrayList<SelectionCoordinator<T, ?>> childSelectionCoordinators;
    private ArrayList<SelectionCoordinator.ItemSelectionListener<T>> itemSelectionListeners;

    /* compiled from: SelectionAggregator.kt */
    public static final class a implements SelectionCoordinator.ItemSelectionListener<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SelectionCoordinator f3169b;

        public a(SelectionCoordinator selectionCoordinator) {
            this.f3169b = selectionCoordinator;
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemSelected(Object obj) {
            Attachment attachment = (Attachment) obj;
            Intrinsics3.checkNotNullParameter(attachment, "item");
            SelectionAggregator.access$addItem(SelectionAggregator.this, attachment);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemUnselected(Object obj) {
            Attachment attachment = (Attachment) obj;
            Intrinsics3.checkNotNullParameter(attachment, "item");
            SelectionAggregator.access$removeItem(SelectionAggregator.this, attachment);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void unregister() {
            SelectionAggregator.this.getChildSelectionCoordinators().remove(this.f3169b);
        }
    }

    static {
        String canonicalName = SelectionAggregator.class.getCanonicalName();
        Intrinsics3.checkNotNull(canonicalName);
        TAG = canonicalName;
    }

    public SelectionAggregator(AttachmentPreviewAdapter<T> attachmentPreviewAdapter) {
        this(attachmentPreviewAdapter, null, null, null, 14, null);
    }

    public SelectionAggregator(AttachmentPreviewAdapter<T> attachmentPreviewAdapter, ArrayList<T> arrayList) {
        this(attachmentPreviewAdapter, arrayList, null, null, 12, null);
    }

    public SelectionAggregator(AttachmentPreviewAdapter<T> attachmentPreviewAdapter, ArrayList<T> arrayList, ArrayList<SelectionCoordinator<T, ?>> arrayList2) {
        this(attachmentPreviewAdapter, arrayList, arrayList2, null, 8, null);
    }

    public SelectionAggregator(AttachmentPreviewAdapter<T> attachmentPreviewAdapter, ArrayList<T> arrayList, ArrayList<SelectionCoordinator<T, ?>> arrayList2, ArrayList<SelectionCoordinator.ItemSelectionListener<T>> arrayList3) {
        Intrinsics3.checkNotNullParameter(attachmentPreviewAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(arrayList, "attachments");
        Intrinsics3.checkNotNullParameter(arrayList2, "childSelectionCoordinators");
        Intrinsics3.checkNotNullParameter(arrayList3, "itemSelectionListeners");
        this.adapter = attachmentPreviewAdapter;
        this.attachments = arrayList;
        this.childSelectionCoordinators = arrayList2;
        this.itemSelectionListeners = arrayList3;
    }

    public static final /* synthetic */ void access$addItem(SelectionAggregator selectionAggregator, Attachment attachment) {
        selectionAggregator.addItem(attachment);
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ boolean access$removeItem(SelectionAggregator selectionAggregator, Attachment attachment) {
        return selectionAggregator.removeItem(attachment);
    }

    private final void addItem(T item) {
        if (this.attachments.contains(item)) {
            return;
        }
        this.attachments.add(item);
        this.adapter.notifyItemInserted(this.attachments.size() - 1);
        Iterator<T> it = this.itemSelectionListeners.iterator();
        while (it.hasNext()) {
            ((SelectionCoordinator.ItemSelectionListener) it.next()).onItemSelected(item);
        }
    }

    private final boolean removeItem(T item) {
        int iIndexOf = this.attachments.indexOf(item);
        boolean zRemove = this.attachments.remove(item);
        if (zRemove) {
            this.adapter.notifyItemRemoved(iIndexOf);
        }
        Iterator<T> it = this.itemSelectionListeners.iterator();
        while (it.hasNext()) {
            ((SelectionCoordinator.ItemSelectionListener) it.next()).onItemUnselected(item);
        }
        return zRemove;
    }

    public final SelectionAggregator<T> addItemSelectionListener(SelectionCoordinator.ItemSelectionListener<? super T> itemSelectionListener) {
        Intrinsics3.checkNotNullParameter(itemSelectionListener, "itemSelectionListener");
        if (!this.itemSelectionListeners.contains(itemSelectionListener)) {
            this.itemSelectionListeners.add(itemSelectionListener);
        }
        return this;
    }

    public final void clear() {
        this.attachments.clear();
        Iterator<T> it = this.childSelectionCoordinators.iterator();
        while (it.hasNext()) {
            SelectionCoordinator selectionCoordinator = (SelectionCoordinator) it.next();
            Objects.requireNonNull(selectionCoordinator);
            ArrayList arrayList = new ArrayList(selectionCoordinator.selectedItemPositionMap.values());
            selectionCoordinator.selectedItemPositionMap.clear();
            RecyclerView.Adapter<?> adapter = selectionCoordinator.adapter;
            if (adapter != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Integer num = (Integer) it2.next();
                    Intrinsics3.checkNotNullExpressionValue(num, ModelAuditLogEntry.CHANGE_KEY_POSITION);
                    adapter.notifyItemChanged(num.intValue());
                }
            }
        }
    }

    public final T get(int position) {
        T t = this.attachments.get(position);
        Intrinsics3.checkNotNullExpressionValue(t, "attachments[position]");
        return t;
    }

    public final AttachmentPreviewAdapter<T> getAdapter() {
        return this.adapter;
    }

    public final ArrayList<T> getAttachments() {
        return this.attachments;
    }

    public final ArrayList<SelectionCoordinator<T, ?>> getChildSelectionCoordinators() {
        return this.childSelectionCoordinators;
    }

    public final ArrayList<SelectionCoordinator.ItemSelectionListener<T>> getItemSelectionListeners() {
        return this.itemSelectionListeners;
    }

    public final int getSize() {
        return this.attachments.size();
    }

    public final SelectionAggregator<T> initFrom(SelectionAggregator<T> old) {
        if (old != null) {
            this.attachments.addAll(old.attachments);
            Iterator<SelectionCoordinator<T, ?>> it = old.childSelectionCoordinators.iterator();
            while (it.hasNext()) {
                SelectionCoordinator<T, ?> next = it.next();
                Intrinsics3.checkNotNullExpressionValue(next, "coordinator");
                registerSelectionCoordinatorInternal(next);
            }
            this.itemSelectionListeners.addAll(old.itemSelectionListeners);
        }
        return this;
    }

    public final void registerSelectionCoordinator(SelectionCoordinator<T, ?> selectionCoordinator) {
        Intrinsics3.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        registerSelectionCoordinatorInternal(selectionCoordinator);
        try {
            selectionCoordinator.b(this.attachments);
        } catch (SelectionCoordinator.RestorationException e) {
            Log.d(TAG, "selections could not be synced", e);
        }
    }

    public void registerSelectionCoordinatorInternal(SelectionCoordinator<T, ?> selectionCoordinator) {
        Intrinsics3.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        a aVar = new a(selectionCoordinator);
        Objects.requireNonNull(selectionCoordinator);
        Intrinsics3.checkNotNullParameter(aVar, "<set-?>");
        selectionCoordinator.itemSelectionListener = aVar;
        this.childSelectionCoordinators.add(selectionCoordinator);
    }

    public final void removeItemSelectionListener(SelectionCoordinator.ItemSelectionListener<?> itemSelectionListener) {
        Intrinsics3.checkNotNullParameter(itemSelectionListener, "itemSelectionListener");
        ArrayList<SelectionCoordinator.ItemSelectionListener<T>> arrayList = this.itemSelectionListeners;
        Objects.requireNonNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        TypeIntrinsics.asMutableCollection(arrayList).remove(itemSelectionListener);
    }

    public final void setItemSelectionListeners(ArrayList<SelectionCoordinator.ItemSelectionListener<T>> arrayList) {
        Intrinsics3.checkNotNullParameter(arrayList, "<set-?>");
        this.itemSelectionListeners = arrayList;
    }

    public final boolean toggleItemInternal(T item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        boolean zRemoveItem = removeItem(item);
        if (!zRemoveItem) {
            addItem(item);
        }
        return zRemoveItem;
    }

    public final void unselectItem(T item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        Iterator<T> it = this.childSelectionCoordinators.iterator();
        while (it.hasNext()) {
            ((SelectionCoordinator) it.next()).d(item);
        }
        removeItem(item);
    }

    public /* synthetic */ SelectionAggregator(AttachmentPreviewAdapter attachmentPreviewAdapter, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(attachmentPreviewAdapter, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? new ArrayList(4) : arrayList2, (i & 8) != 0 ? new ArrayList(4) : arrayList3);
    }

    public final SelectionAggregator<T> initFrom(ArrayList<? super Parcelable> savedAttachments) {
        Intrinsics3.checkNotNullParameter(savedAttachments, "savedAttachments");
        ArrayList arrayList = new ArrayList();
        for (Object obj : savedAttachments) {
            if (!(obj instanceof Attachment)) {
                obj = null;
            }
            Attachment attachment = (Attachment) obj;
            if (attachment != null) {
                arrayList.add(attachment);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            toggleItemInternal((Attachment) it.next());
        }
        return this;
    }
}
