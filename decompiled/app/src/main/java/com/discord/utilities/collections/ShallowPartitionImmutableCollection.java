package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.g0.KMarkers;
import d0.z.d.g0.KMarkers5;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ShallowPartitionImmutableCollection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0010\b\u0001\u0010\u0003 \u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005:\u0001\u001cB-\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u001d\u0010\u0011\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u001d\u0010\u0012\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\tR$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/collections/ShallowPartitionImmutableCollection;", ExifInterface.LONGITUDE_EAST, "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/discord/utilities/collections/ShallowPartitionCollection;", "element", "", "add", "(Ljava/lang/Object;)Z", "elements", "addAll", "(Ljava/util/Collection;)Z", "", "clear", "()Ljava/lang/Void;", "remove", "removeAll", "retainAll", "contains", "Lkotlin/Function1;", "", "readOnlyPartitionStrategy", "Lkotlin/jvm/functions/Function1;", "", "partitions", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Set", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class ShallowPartitionImmutableCollection<E, T extends Collection<E>> extends ShallowPartitionCollection<E, T> implements Collection<E>, KMarkers {
    private final Function1<E, Integer> readOnlyPartitionStrategy;

    /* compiled from: ShallowPartitionImmutableCollection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\u0002 \u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.LONGITUDE_EAST, "", ExifInterface.GPS_DIRECTION_TRUE, "it", "", "invoke", "(Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.collections.ShallowPartitionImmutableCollection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<E, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(E e) {
            return -1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
            return Integer.valueOf(invoke2((AnonymousClass1) obj));
        }
    }

    /* compiled from: ShallowPartitionImmutableCollection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0010\b\u0003\u0010\u0003 \u0001*\b\u0012\u0004\u0012\u00028\u00020\u00022\b\u0012\u0004\u0012\u00028\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B)\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/discord/utilities/collections/ShallowPartitionImmutableCollection$Set;", ExifInterface.LONGITUDE_EAST, "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/collections/ShallowPartitionImmutableCollection;", "", "partitions", "Lkotlin/Function1;", "", "partitionStrategy", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Set<E, T extends java.util.Set<E>> extends ShallowPartitionImmutableCollection<E, T> implements java.util.Set<E>, KMarkers5 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Set(List<? extends T> list, Function1<? super E, Integer> function1) {
            super(list, function1);
            Intrinsics3.checkNotNullParameter(list, "partitions");
            Intrinsics3.checkNotNullParameter(function1, "partitionStrategy");
        }
    }

    public /* synthetic */ ShallowPartitionImmutableCollection(List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : function1);
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean add(E element) {
        throw new UnsupportedOperationException();
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean contains(Object element) {
        Integer numInvoke;
        Function1<E, Integer> function1 = this.readOnlyPartitionStrategy;
        if (function1 != null && (numInvoke = function1.invoke(element)) != null) {
            return getPartitions().get(numInvoke.intValue()).contains(element);
        }
        List<T> partitions = getPartitions();
        if ((partitions instanceof Collection) && partitions.isEmpty()) {
            return false;
        }
        Iterator<T> it = partitions.iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(element)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean remove(Object element) {
        throw new UnsupportedOperationException();
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // com.discord.utilities.collections.ShallowPartitionCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShallowPartitionImmutableCollection(List<? extends T> list, Function1<? super E, Integer> function1) {
        super(list, AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullParameter(list, "partitions");
        this.readOnlyPartitionStrategy = function1;
    }

    @Override // java.util.Collection
    public Void clear() {
        throw new UnsupportedOperationException();
    }
}
