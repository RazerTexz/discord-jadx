package com.discord.utilities.mg_recycler;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.mg_recycler.DragAndDropAdapter.Payload;
import com.discord.utilities.mg_recycler.DragAndDropHelper;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ranges.Ranges2;

/* compiled from: DragAndDropAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004:\u0001,B\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0004¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\u00020\u00072\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u0013H&¢\u0006\u0004\b\u001b\u0010\u001cR.\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u001d8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u001cR(\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\t¨\u0006-"}, d2 = {"Lcom/discord/utilities/mg_recycler/DragAndDropAdapter;", "Lcom/discord/utilities/mg_recycler/DragAndDropAdapter$Payload;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/utilities/mg_recycler/DragAndDropHelper$Adapter;", "", "data", "", "setAndCopyData", "(Ljava/util/List;)V", "computeOriginalPositions", "setData", "", "fromPosition", "toPosition", "onItemMove", "(II)V", "onDrop", "()V", "", "", "computeChangedPositions", "()Ljava/util/Map;", "", "isMoveWithinBounds", "(II)Z", "newPositions", "onNewPositions", "(Ljava/util/Map;)V", "", "origPositions", "Ljava/util/Map;", "getOrigPositions", "setOrigPositions", "", "dataCopy", "Ljava/util/List;", "getDataCopy", "()Ljava/util/List;", "setDataCopy", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Payload", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class DragAndDropAdapter<T extends Payload> extends MGRecyclerAdapterSimple<T> implements DragAndDropHelper.Adapter {
    private List<T> dataCopy;
    private Map<String, Integer> origPositions;

    /* compiled from: DragAndDropAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/utilities/mg_recycler/DragAndDropAdapter$Payload;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "getPosition", "()I", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface Payload extends MGRecyclerDataPayload {
        int getPosition();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragAndDropAdapter(RecyclerView recyclerView) {
        super(recyclerView, false);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        this.dataCopy = new ArrayList();
        this.origPositions = new HashMap();
    }

    private final void computeOriginalPositions(List<? extends T> data) {
        this.origPositions.clear();
        Ranges2 indices = Collections2.getIndices(data);
        ArrayList<Payload> arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(indices, 10));
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(data.get(((Iterators4) it).nextInt()));
        }
        for (Payload payload : arrayList) {
            this.origPositions.put(payload.getKey(), Integer.valueOf(payload.getPosition()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setAndCopyData(List<? extends T> data) {
        super.setData(data);
        this.dataCopy = new ArrayList(data);
    }

    public Map<String, Integer> computeChangedPositions() {
        HashMap map = new HashMap();
        int size = this.dataCopy.size();
        for (int i = 0; i < size; i++) {
            String key = this.dataCopy.get(i).getKey();
            Integer num = this.origPositions.get(key);
            if (num == null || i != num.intValue()) {
                map.put(key, Integer.valueOf(i));
            }
        }
        return map;
    }

    public final List<T> getDataCopy() {
        return this.dataCopy;
    }

    public final Map<String, Integer> getOrigPositions() {
        return this.origPositions;
    }

    public final boolean isMoveWithinBounds(int fromPosition, int toPosition) {
        if (this.dataCopy.isEmpty()) {
            return false;
        }
        Ranges2 ranges2Until = _Ranges.until(0, this.dataCopy.size());
        return ranges2Until.contains(fromPosition) && ranges2Until.contains(toPosition);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.Adapter
    public void onDrop() {
        if (!this.dataCopy.isEmpty()) {
            Map<String, Integer> mapComputeChangedPositions = computeChangedPositions();
            if (!mapComputeChangedPositions.isEmpty()) {
                onNewPositions(mapComputeChangedPositions);
            }
        }
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.Adapter
    public void onItemMove(int fromPosition, int toPosition) {
        T t = this.dataCopy.get(fromPosition);
        this.dataCopy.remove(fromPosition);
        this.dataCopy.add(toPosition, t);
        setAndCopyData(this.dataCopy);
    }

    public abstract void onNewPositions(Map<String, Integer> newPositions);

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple
    public void setData(List<? extends T> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        computeOriginalPositions(data);
        setAndCopyData(data);
    }

    public final void setDataCopy(List<T> list) {
        Intrinsics3.checkNotNullParameter(list, "<set-?>");
        this.dataCopy = list;
    }

    public final void setOrigPositions(Map<String, Integer> map) {
        Intrinsics3.checkNotNullParameter(map, "<set-?>");
        this.origPositions = map;
    }
}
