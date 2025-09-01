package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;

/* compiled from: MutablePartitionedIterator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010\u001d\n\u0002\b\u0006\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001b\u0012\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\b@\bX\u0088\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/collections/MutablePartitionedIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "remove", "()V", "", "", "partitionIterator", "Ljava/util/Iterator;", "currentPartitionIterator", "<init>", "(Ljava/util/Iterator;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MutablePartitionedIterator<T> implements Iterator<T>, KMarkers {
    private Iterator<? extends T> currentPartitionIterator;
    private final Iterator<Iterable<T>> partitionIterator;

    /* JADX WARN: Multi-variable type inference failed */
    public MutablePartitionedIterator(Iterator<? extends Iterable<? extends T>> it) {
        Intrinsics3.checkNotNullParameter(it, "partitionIterator");
        this.partitionIterator = it;
        Iterator<? extends T> it2 = new LinkedList().iterator();
        Intrinsics3.checkNotNullExpressionValue(it2, "LinkedList<T>().iterator()");
        this.currentPartitionIterator = it2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.currentPartitionIterator.hasNext()) {
            return true;
        }
        while (this.partitionIterator.hasNext()) {
            Iterator<T> it = this.partitionIterator.next().iterator();
            this.currentPartitionIterator = it;
            if (it.hasNext()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        return this.currentPartitionIterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.currentPartitionIterator.remove();
    }
}
