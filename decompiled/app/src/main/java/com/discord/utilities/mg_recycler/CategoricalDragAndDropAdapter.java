package com.discord.utilities.mg_recycler;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter.Payload;
import com.discord.utilities.mg_recycler.DragAndDropAdapter;
import d0.t.Iterators4;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ranges.Ranges2;

/* compiled from: CategoricalDragAndDropAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0012B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter;", "Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/mg_recycler/DragAndDropAdapter;", "", "", "", "computeChangedPositions", "()Ljava/util/Map;", "fromPosition", "toPosition", "", "isValidMove", "(II)Z", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Payload", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class CategoricalDragAndDropAdapter<T extends Payload> extends DragAndDropAdapter<T> {

    /* compiled from: CategoricalDragAndDropAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", "Lcom/discord/utilities/mg_recycler/DragAndDropAdapter$Payload;", "", "getCategory", "()Ljava/lang/String;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface Payload extends DragAndDropAdapter.Payload {
        String getCategory();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoricalDragAndDropAdapter(RecyclerView recyclerView) {
        super(recyclerView);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter
    public Map<String, Integer> computeChangedPositions() {
        HashMap map = new HashMap();
        if (getDataCopy().isEmpty()) {
            return map;
        }
        String category = getDataCopy().get(0).getCategory();
        int size = getDataCopy().size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            T t = getDataCopy().get(i2);
            if (!Intrinsics3.areEqual(t.getCategory(), category)) {
                category = t.getCategory();
                i = 0;
            }
            Integer num = getOrigPositions().get(t.getKey());
            if (num == null || num.intValue() != i) {
                map.put(t.getKey(), Integer.valueOf(i));
            }
            i++;
        }
        return map;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.Adapter
    public boolean isValidMove(int fromPosition, int toPosition) {
        String category = getDataCopy().get(fromPosition).getCategory();
        Iterable ranges2 = new Ranges2(Math.min(fromPosition, toPosition), Math.max(fromPosition, toPosition));
        if ((ranges2 instanceof Collection) && ((Collection) ranges2).isEmpty()) {
            return true;
        }
        Iterator it = ranges2.iterator();
        while (it.hasNext()) {
            if (!Intrinsics3.areEqual(getDataCopy().get(((Iterators4) it).nextInt()).getCategory(), category)) {
                return false;
            }
        }
        return true;
    }
}
