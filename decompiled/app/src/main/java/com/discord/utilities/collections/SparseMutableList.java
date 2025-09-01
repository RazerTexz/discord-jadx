package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.t.Collections2;
import d0.t.MutableCollectionsJVM;
import d0.t.ReversedViews3;
import d0.z.d.CollectionToArray;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import d0.z.d.g0.KMarkers3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SparseMutableList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002:\u0002KLB\u001b\u0012\b\b\u0002\u0010H\u001a\u00020\u0003\u0012\b\b\u0002\u0010G\u001a\u00020\u0003¢\u0006\u0004\bI\u0010JJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0015H\u0016¢\u0006\u0004\b \u0010!J\u0018\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\"H\u0096\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b%\u0010\u001fJ\u0017\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000&H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000&2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010)J'\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b.\u0010\u0017J!\u0010.\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b.\u0010/J'\u00100\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00032\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00100\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018H\u0016¢\u0006\u0004\b0\u0010\u001bJ\u000f\u00102\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u0010\u0010J\u0019\u00103\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b3\u0010\u0017J\u001f\u00104\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018H\u0016¢\u0006\u0004\b4\u0010\u001bJ\u0019\u00105\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b5\u0010\u001dJ\u001f\u00106\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018H\u0016¢\u0006\u0004\b6\u0010\u001bJ$\u00107\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0096\u0002¢\u0006\u0004\b7\u00108J\u0013\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b9\u0010:J-\u00109\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010;2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010<¢\u0006\u0004\b9\u0010>R*\u0010@\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010\u0007R\"\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010A¨\u0006M"}, d2 = {"Lcom/discord/utilities/collections/SparseMutableList;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "chunkIndex", "", "incrementChunksFromIndex", "(I)V", "decrementChunksFromIndex", "Lcom/discord/utilities/collections/SparseMutableList$Chunk;", "chunk", "addChunk", "(Lcom/discord/utilities/collections/SparseMutableList$Chunk;)V", "index", "(ILcom/discord/utilities/collections/SparseMutableList$Chunk;)V", "resolveChunks", "()V", "getChunkIndex", "(I)I", "getFirstChunkIndexAfter", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "add", "(ILjava/lang/Object;)V", "addAll", "(ILjava/util/Collection;)Z", "clear", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "deepCopy", "()Lcom/discord/utilities/collections/SparseMutableList;", "R", "Lkotlin/Function1;", "transform", "(Lkotlin/jvm/functions/Function1;)Lcom/discord/utilities/collections/SparseMutableList;", "newSize", "size", "I", "getSize", "()I", "setSize", "chunks", "Ljava/util/List;", "expectedChunkSize", "initialSize", "<init>", "(II)V", "Chunk", "SparseMutableListIterator", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SparseMutableList<T> implements List<T>, KMarkers3 {
    private final List<Chunk<T>> chunks;
    private final int expectedChunkSize;
    private int size;

    /* compiled from: SparseMutableList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0080\b\u0018\u0000 ?*\u0004\b\u0001\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u0002:\u0001?B\u001f\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010&¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0004\u001a\u00020\u0003HÂ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u000b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0011J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\u001f\u0010\u001eJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b \u0010!J-\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0002\u0010\"2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020#¢\u0006\u0004\b \u0010%J\u0018\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010&HÆ\u0003¢\u0006\u0004\b'\u0010(J2\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010)\u001a\u00020\u00032\u0010\b\u0002\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010&HÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b0\u0010\u0005J\u001a\u00102\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u000101HÖ\u0003¢\u0006\u0004\b2\u00103R\u0013\u00104\u001a\u00020\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u00106R\u0013\u00108\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b7\u0010\u0005R*\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u00109\u001a\u0004\b:\u0010(\"\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/discord/utilities/collections/SparseMutableList$Chunk;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "component1", "()I", "listIndex", "", "removeAfterInclusive", "(I)V", "other", "compareTo", "(Lcom/discord/utilities/collections/SparseMutableList$Chunk;)I", "incrementStartIndex", "()V", "decrementStartIndex", "getAtListIndex", "(I)Ljava/lang/Object;", "element", "setAtListIndex", "(ILjava/lang/Object;)Ljava/lang/Object;", "addAtListIndex", "(ILjava/lang/Object;)V", "removeAtListIndex", "", "containsListIndex", "(I)Z", "beginsAfterListIndex", "elenent", "firstListIndexOf", "(Ljava/lang/Object;)I", "lastListIndexOf", "deepCopy", "()Lcom/discord/utilities/collections/SparseMutableList$Chunk;", "R", "Lkotlin/Function1;", "transform", "(Lkotlin/jvm/functions/Function1;)Lcom/discord/utilities/collections/SparseMutableList$Chunk;", "", "component2", "()Ljava/util/List;", "startIndex", "list", "copy", "(ILjava/util/List;)Lcom/discord/utilities/collections/SparseMutableList$Chunk;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "equals", "(Ljava/lang/Object;)Z", "isEmpty", "()Z", "I", "getSize", "size", "Ljava/util/List;", "getList", "setList", "(Ljava/util/List;)V", "<init>", "(ILjava/util/List;)V", "Companion", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Chunk<T> implements Comparable<Chunk<T>> {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private List<T> list;
        private int startIndex;

        /* compiled from: SparseMutableList.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007\"\u0004\b\u0002\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00018\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ7\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0007\"\u0004\b\u0002\u0010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/collections/SparseMutableList$Chunk$Companion;", "", ExifInterface.GPS_DIRECTION_TRUE, "element", "", "startIndex", "initialCapacity", "Lcom/discord/utilities/collections/SparseMutableList$Chunk;", "create", "(Ljava/lang/Object;II)Lcom/discord/utilities/collections/SparseMutableList$Chunk;", "chunk1", "chunk2", "tryMergeChunks", "(Lcom/discord/utilities/collections/SparseMutableList$Chunk;Lcom/discord/utilities/collections/SparseMutableList$Chunk;)Lcom/discord/utilities/collections/SparseMutableList$Chunk;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final <T> Chunk<T> create(T element, int startIndex, int initialCapacity) {
                ArrayList arrayList = new ArrayList(initialCapacity);
                arrayList.add(element);
                return new Chunk<>(startIndex, arrayList);
            }

            public final <T> Chunk<T> tryMergeChunks(Chunk<T> chunk1, Chunk<T> chunk2) {
                Chunk<T> chunk;
                Intrinsics3.checkNotNullParameter(chunk1, "chunk1");
                Intrinsics3.checkNotNullParameter(chunk2, "chunk2");
                if (Chunk.access$getStartIndex$p(chunk1) < Chunk.access$getStartIndex$p(chunk2)) {
                    chunk = chunk1;
                } else {
                    if (Chunk.access$getStartIndex$p(chunk2) >= Chunk.access$getStartIndex$p(chunk1)) {
                        throw new IllegalArgumentException("both chunks begin at the same index");
                    }
                    chunk = chunk2;
                }
                Chunk<T> chunk3 = chunk1 == chunk ? chunk2 : chunk1;
                int size = (chunk.getSize() + Chunk.access$getStartIndex$p(chunk)) - 1;
                if (size < Chunk.access$getStartIndex$p(chunk3)) {
                    if (size != Chunk.access$getStartIndex$p(chunk3) - 1) {
                        return null;
                    }
                    List<T> list = chunk.getList();
                    list.addAll(chunk3.getList());
                    return new Chunk<>(Chunk.access$getStartIndex$p(chunk), list);
                }
                throw new IllegalArgumentException("chunks overlap: " + chunk1 + ", " + chunk2);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Chunk(int i, List<T> list) {
            Intrinsics3.checkNotNullParameter(list, "list");
            this.startIndex = i;
            this.list = list;
        }

        public static final /* synthetic */ int access$getStartIndex$p(Chunk chunk) {
            return chunk.startIndex;
        }

        public static final /* synthetic */ void access$setStartIndex$p(Chunk chunk, int i) {
            chunk.startIndex = i;
        }

        /* renamed from: component1, reason: from getter */
        private final int getStartIndex() {
            return this.startIndex;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Chunk copy$default(Chunk chunk, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = chunk.startIndex;
            }
            if ((i2 & 2) != 0) {
                list = chunk.list;
            }
            return chunk.copy(i, list);
        }

        public final void addAtListIndex(int listIndex, T element) {
            int i = listIndex - this.startIndex;
            if (i == 0 && element == null) {
                incrementStartIndex();
            } else {
                this.list.add(i, element);
            }
        }

        public final boolean beginsAfterListIndex(int listIndex) {
            return this.startIndex > listIndex;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((Chunk) obj);
        }

        public final List<T> component2() {
            return this.list;
        }

        public final boolean containsListIndex(int listIndex) {
            return this.startIndex <= listIndex && Collections2.getLastIndex(this.list) + this.startIndex >= listIndex;
        }

        public final Chunk<T> copy(int startIndex, List<T> list) {
            Intrinsics3.checkNotNullParameter(list, "list");
            return new Chunk<>(startIndex, list);
        }

        public final void decrementStartIndex() {
            this.startIndex--;
        }

        public final Chunk<T> deepCopy() {
            return new Chunk<>(this.startIndex, new ArrayList(this.list));
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Chunk)) {
                return false;
            }
            Chunk chunk = (Chunk) other;
            return this.startIndex == chunk.startIndex && Intrinsics3.areEqual(this.list, chunk.list);
        }

        public final int firstListIndexOf(T elenent) {
            int lastIndex = Collections2.getLastIndex(this.list);
            if (lastIndex < 0) {
                return -1;
            }
            int i = 0;
            while (!Intrinsics3.areEqual(this.list.get(i), elenent)) {
                if (i == lastIndex) {
                    return -1;
                }
                i++;
            }
            return this.startIndex + i;
        }

        public final T getAtListIndex(int listIndex) {
            return this.list.get(listIndex - this.startIndex);
        }

        public final List<T> getList() {
            return this.list;
        }

        public final int getSize() {
            return this.list.size();
        }

        public int hashCode() {
            int i = this.startIndex * 31;
            List<T> list = this.list;
            return i + (list != null ? list.hashCode() : 0);
        }

        public final void incrementStartIndex() {
            this.startIndex++;
        }

        public final boolean isEmpty() {
            return this.list.isEmpty();
        }

        public final int lastListIndexOf(T element) {
            for (int lastIndex = Collections2.getLastIndex(this.list); lastIndex >= 0; lastIndex--) {
                if (Intrinsics3.areEqual(this.list.get(lastIndex), element)) {
                    return this.startIndex + lastIndex;
                }
            }
            return -1;
        }

        public final void removeAfterInclusive(int listIndex) {
            int i = listIndex - this.startIndex;
            if (i > Collections2.getLastIndex(this.list)) {
                return;
            }
            if (i <= 0) {
                this.list.clear();
            } else {
                this.list = this.list.subList(0, i);
            }
        }

        public final T removeAtListIndex(int listIndex) {
            return this.list.remove(listIndex - this.startIndex);
        }

        public final T setAtListIndex(int listIndex, T element) {
            int i = listIndex - this.startIndex;
            if (element != null) {
                return this.list.set(i, element);
            }
            if (i != 0) {
                return this.list.set(i, element);
            }
            incrementStartIndex();
            return this.list.remove(0);
        }

        public final void setList(List<T> list) {
            Intrinsics3.checkNotNullParameter(list, "<set-?>");
            this.list = list;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Chunk(startIndex=");
            sbU.append(this.startIndex);
            sbU.append(", list=");
            return outline.L(sbU, this.list, ")");
        }

        public int compareTo(Chunk<T> other) {
            Intrinsics3.checkNotNullParameter(other, "other");
            return this.startIndex - other.startIndex;
        }

        public final <R> Chunk<R> deepCopy(Function1<? super T, ? extends R> transform) {
            Intrinsics3.checkNotNullParameter(transform, "transform");
            ArrayList arrayList = new ArrayList(this.list.size());
            Iterator<T> it = this.list.iterator();
            while (it.hasNext()) {
                T next = it.next();
                arrayList.add(next != null ? transform.invoke(next) : null);
            }
            return new Chunk<>(this.startIndex, arrayList);
        }
    }

    /* compiled from: SparseMutableList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0002B\u001f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0001H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/collections/SparseMutableList$SparseMutableListIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "hasPrevious", "()Z", "", "nextIndex", "()I", "previous", "()Ljava/lang/Object;", "previousIndex", "element", "", "add", "(Ljava/lang/Object;)V", "hasNext", "next", "remove", "()V", "set", "Lcom/discord/utilities/collections/SparseMutableList;", "sparseMutableList", "Lcom/discord/utilities/collections/SparseMutableList;", "index", "I", "getIndex", "setIndex", "(I)V", "<init>", "(Lcom/discord/utilities/collections/SparseMutableList;I)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class SparseMutableListIterator<T> implements ListIterator<T>, KMarkers {
        private int index;
        private final SparseMutableList<T> sparseMutableList;

        public SparseMutableListIterator(SparseMutableList<T> sparseMutableList, int i) {
            Intrinsics3.checkNotNullParameter(sparseMutableList, "sparseMutableList");
            this.sparseMutableList = sparseMutableList;
            this.index = i;
        }

        @Override // java.util.ListIterator
        public void add(T element) {
            throw new UnsupportedOperationException("add not supported during iteration");
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return nextIndex() < Collections2.getLastIndex(this.sparseMutableList);
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            int i = this.index + 1;
            this.index = i;
            return this.sparseMutableList.get(i);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int i = this.index - 1;
            this.index = i;
            return this.sparseMutableList.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.sparseMutableList.remove(this.index);
        }

        @Override // java.util.ListIterator
        public void set(T element) {
            this.sparseMutableList.set(this.index, element);
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        public /* synthetic */ SparseMutableListIterator(SparseMutableList sparseMutableList, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(sparseMutableList, (i2 & 2) != 0 ? -1 : i);
        }
    }

    public SparseMutableList() {
        this(0, 0, 3, null);
    }

    public SparseMutableList(int i, int i2) {
        this.expectedChunkSize = i2;
        this.chunks = new ArrayList();
        this.size = i;
    }

    private final void addChunk(Chunk<T> chunk) {
        this.chunks.add(chunk);
        MutableCollectionsJVM.sort(this.chunks);
    }

    private final void decrementChunksFromIndex(int chunkIndex) {
        int lastIndex;
        int lastIndex2 = Collections2.getLastIndex(this.chunks);
        if (chunkIndex < 0 || lastIndex2 < chunkIndex || chunkIndex > (lastIndex = Collections2.getLastIndex(this.chunks))) {
            return;
        }
        while (true) {
            this.chunks.get(chunkIndex).decrementStartIndex();
            if (chunkIndex == lastIndex) {
                return;
            } else {
                chunkIndex++;
            }
        }
    }

    private final int getChunkIndex(int index) {
        Iterator<Chunk<T>> it = this.chunks.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().containsListIndex(index)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private final int getFirstChunkIndexAfter(int index) {
        Iterator<Chunk<T>> it = this.chunks.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().beginsAfterListIndex(index)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private final void incrementChunksFromIndex(int chunkIndex) {
        int lastIndex;
        int lastIndex2 = Collections2.getLastIndex(this.chunks);
        if (chunkIndex < 0 || lastIndex2 < chunkIndex || chunkIndex > (lastIndex = Collections2.getLastIndex(this.chunks))) {
            return;
        }
        while (true) {
            this.chunks.get(chunkIndex).incrementStartIndex();
            if (chunkIndex == lastIndex) {
                return;
            } else {
                chunkIndex++;
            }
        }
    }

    private final void resolveChunks() {
        MutableCollectionsJVM.sort(this.chunks);
        int i = 0;
        while (i < this.chunks.size() - 1) {
            Chunk<T> chunk = this.chunks.get(i);
            if (chunk.isEmpty()) {
                this.chunks.remove(i);
            } else {
                int i2 = i + 1;
                Chunk<T> chunkTryMergeChunks = Chunk.INSTANCE.tryMergeChunks(chunk, this.chunks.get(i2));
                if (chunkTryMergeChunks != null) {
                    this.chunks.set(i, chunkTryMergeChunks);
                    this.chunks.remove(i2);
                } else {
                    i = i2;
                }
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        set(size(), element);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends T> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.chunks.clear();
        setSize(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        if (isEmpty()) {
            return false;
        }
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            if (Intrinsics3.areEqual(it.next(), element)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        HashSet hashSet = new HashSet(elements);
        if (hashSet.size() > size()) {
            return false;
        }
        for (T t : this) {
            if (hashSet.contains(t)) {
                hashSet.remove(t);
                if (hashSet.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final SparseMutableList<T> deepCopy() {
        SparseMutableList<T> sparseMutableList = new SparseMutableList<>(size(), 0, 2, null);
        Iterator<T> it = this.chunks.iterator();
        while (it.hasNext()) {
            sparseMutableList.chunks.add(((Chunk) it.next()).deepCopy());
        }
        return sparseMutableList;
    }

    @Override // java.util.List
    public T get(int index) {
        if (index > Collections2.getLastIndex(this)) {
            StringBuilder sbV = outline.V("index ", index, " invalid in list of size ");
            sbV.append(size());
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        int chunkIndex = getChunkIndex(index);
        Chunk<T> chunk = chunkIndex >= 0 ? this.chunks.get(chunkIndex) : null;
        if (chunk != null) {
            return chunk.getAtListIndex(index);
        }
        return null;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        if (element != null) {
            Iterator<T> it = this.chunks.iterator();
            while (it.hasNext()) {
                int iFirstListIndexOf = ((Chunk) it.next()).firstListIndexOf(element);
                if (iFirstListIndexOf >= 0) {
                    return iFirstListIndexOf;
                }
            }
            return -1;
        }
        int i = 0;
        for (T t : this) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            if (Intrinsics3.areEqual(t, element)) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new SparseMutableListIterator(this, 0, 2, null);
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        if (element != null) {
            Iterator<T> it = ReversedViews3.asReversedMutable(this.chunks).iterator();
            while (it.hasNext()) {
                int iLastListIndexOf = ((Chunk) it.next()).lastListIndexOf(element);
                if (iLastListIndexOf >= 0) {
                    return iLastListIndexOf;
                }
            }
            return -1;
        }
        for (int lastIndex = Collections2.getLastIndex(this); lastIndex >= 0; lastIndex--) {
            if (Intrinsics3.areEqual(get(lastIndex), element)) {
                return lastIndex;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new SparseMutableListIterator(this, 0, 2, null);
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i) {
        return removeAt(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        boolean z2 = false;
        SparseMutableListIterator sparseMutableListIterator = new SparseMutableListIterator(this, 0, 2, null);
        while (sparseMutableListIterator.hasNext()) {
            if (elements.contains(sparseMutableListIterator.next())) {
                sparseMutableListIterator.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public T removeAt(int index) {
        T tRemoveAtListIndex;
        if (index < 0 || index >= size()) {
            StringBuilder sbV = outline.V("index: ", index, " -- size: ");
            sbV.append(size());
            throw new ArrayIndexOutOfBoundsException(sbV.toString());
        }
        int chunkIndex = getChunkIndex(index);
        if (chunkIndex >= 0) {
            tRemoveAtListIndex = this.chunks.get(chunkIndex).removeAtListIndex(index);
            decrementChunksFromIndex(chunkIndex + 1);
        } else {
            int firstChunkIndexAfter = getFirstChunkIndexAfter(index);
            if (firstChunkIndexAfter != -1) {
                decrementChunksFromIndex(firstChunkIndexAfter);
            }
            tRemoveAtListIndex = null;
        }
        setSize(size() - 1);
        resolveChunks();
        return tRemoveAtListIndex;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public T set(int index, T element) {
        if (index >= size()) {
            setSize(index + 1);
        }
        int chunkIndex = getChunkIndex(index);
        if (chunkIndex >= 0) {
            T atListIndex = this.chunks.get(chunkIndex).setAtListIndex(index, element);
            resolveChunks();
            return atListIndex;
        }
        if (element == null) {
            return null;
        }
        addChunk(Chunk.INSTANCE.create(element, index, this.expectedChunkSize));
        resolveChunks();
        return null;
    }

    public void setSize(int i) {
        int i2 = this.size;
        if (i > i2) {
            this.size = i;
            return;
        }
        if (i < i2) {
            Iterator<T> it = this.chunks.iterator();
            while (it.hasNext()) {
                ((Chunk) it.next()).removeAfterInclusive(i);
            }
            this.size = i;
            resolveChunks();
        }
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @Override // java.util.List
    public void add(int index, T element) {
        if (index == size()) {
            add(element);
            return;
        }
        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }
        int chunkIndex = getChunkIndex(index);
        if (element != null) {
            if (chunkIndex >= 0) {
                this.chunks.get(chunkIndex).addAtListIndex(index, element);
                incrementChunksFromIndex(chunkIndex + 1);
            } else {
                Chunk<T> chunkCreate = Chunk.INSTANCE.create(element, index, this.expectedChunkSize);
                int firstChunkIndexAfter = getFirstChunkIndexAfter(index);
                if (firstChunkIndexAfter == -1) {
                    addChunk(chunkCreate);
                } else {
                    addChunk(firstChunkIndexAfter, chunkCreate);
                    incrementChunksFromIndex(firstChunkIndexAfter + 1);
                }
            }
        } else if (chunkIndex >= 0) {
            this.chunks.get(chunkIndex).addAtListIndex(index, null);
            incrementChunksFromIndex(chunkIndex + 1);
        } else {
            int firstChunkIndexAfter2 = getFirstChunkIndexAfter(index);
            if (firstChunkIndexAfter2 != -1) {
                incrementChunksFromIndex(firstChunkIndexAfter2);
            }
        }
        setSize(size() + 1);
        resolveChunks();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        return addAll(size(), elements);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        return new SparseMutableListIterator(this, 0, 2, null);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        SparseMutableListIterator sparseMutableListIterator = new SparseMutableListIterator(this, 0, 2, null);
        while (sparseMutableListIterator.hasNext()) {
            if (Intrinsics3.areEqual(sparseMutableListIterator.next(), element)) {
                sparseMutableListIterator.remove();
                return true;
            }
        }
        return false;
    }

    private final void addChunk(int index, Chunk<T> chunk) {
        this.chunks.add(index, chunk);
        MutableCollectionsJVM.sort(this.chunks);
    }

    public /* synthetic */ SparseMutableList(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 5 : i2);
    }

    public final <R> SparseMutableList<R> deepCopy(Function1<? super T, ? extends R> transform) {
        Intrinsics3.checkNotNullParameter(transform, "transform");
        SparseMutableList<R> sparseMutableList = new SparseMutableList<>(size(), 0, 2, null);
        Iterator<T> it = this.chunks.iterator();
        while (it.hasNext()) {
            sparseMutableList.chunks.add(((Chunk) it.next()).deepCopy(transform));
        }
        return sparseMutableList;
    }
}
