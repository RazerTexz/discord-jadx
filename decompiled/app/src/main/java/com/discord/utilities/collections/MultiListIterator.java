package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: MultiListIterator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B'\u0012\u001e\u0010\n\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\"\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R'\u0010\n\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/collections/MultiListIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "", "lists", "[Ljava/util/List;", "getLists", "()[Ljava/util/List;", "", "listIndex", "I", "curIterator", "Ljava/util/Iterator;", "<init>", "([Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MultiListIterator<T> implements Iterator<T>, KMarkers {
    private Iterator<? extends T> curIterator;
    private int listIndex;
    private final List<T>[] lists;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiListIterator(List<? extends T>... listArr) {
        Intrinsics3.checkNotNullParameter(listArr, "lists");
        this.lists = listArr;
        this.curIterator = listArr[this.listIndex].iterator();
    }

    public final List<T>[] getLists() {
        return this.lists;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.curIterator.hasNext()) {
            return true;
        }
        while (!this.curIterator.hasNext()) {
            int i = this.listIndex + 1;
            this.listIndex = i;
            List<T>[] listArr = this.lists;
            if (i >= listArr.length) {
                return false;
            }
            this.curIterator = listArr[i].iterator();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        return this.curIterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
