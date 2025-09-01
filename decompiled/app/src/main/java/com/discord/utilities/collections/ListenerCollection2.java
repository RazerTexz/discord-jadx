package com.discord.utilities.collections;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ListenerCollection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/collections/ListenerCollectionSubject;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/collections/ListenerCollection;", "listener", "", "add", "(Ljava/lang/Object;)V", "", "remove", "(Ljava/lang/Object;)Z", "clear", "()V", "Lkotlin/Function1;", "action", "notify", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "<init>", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.collections.ListenerCollectionSubject, reason: use source file name */
/* loaded from: classes2.dex */
public final class ListenerCollection2<T> implements ListenerCollection<T> {
    private final CopyOnWriteArraySet<T> listeners = new CopyOnWriteArraySet<>();

    @Override // com.discord.utilities.collections.ListenerCollection
    public void add(T listener) {
        this.listeners.add(listener);
    }

    public final void clear() {
        this.listeners.clear();
    }

    public final void notify(Function1<? super T, Unit> action) {
        Intrinsics3.checkNotNullParameter(action, "action");
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            try {
                action.invoke(it.next());
            } catch (Exception e) {
                Log.e("ListenerCollection", "Exception calling handler: " + e);
            }
        }
    }

    @Override // com.discord.utilities.collections.ListenerCollection
    public boolean remove(T listener) {
        return this.listeners.remove(listener);
    }
}
