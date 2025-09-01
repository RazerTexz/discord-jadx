package com.discord.utilities.recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import b.d.b.a.outline;
import com.discord.app.AppComponent;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.collections.ShallowPartitionMap;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* compiled from: DiffCreator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0016\u0018\u0000 +*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\b\u0001\u0010\u0005*\u00020\u00042\u00020\u0006:\u0002+,B\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b*\u0010\u000bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJC\u0010\u0013\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u0010\u001a\u00028\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00162\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u001c\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ?\u0010\u001e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u001e\u0010\u001dJ\u001f\u0010\u001f\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010 Rj\u0010$\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 #*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\"0\" #**\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 #*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\"0\"\u0018\u00010!0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/discord/utilities/recycler/DiffCreator;", "", "Lcom/discord/utilities/recycler/DiffKeyProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "", "Lcom/discord/app/AppComponent;", "asyncDiffSubscriptionScope", "", "subscribeToAsyncUpdateRequests", "(Lcom/discord/app/AppComponent;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lkotlin/Function1;", "setItems", "newItems", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diffResult", "setItemsAndDispatchUpdate", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Lkotlin/jvm/functions/Function1;Ljava/util/List;Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "oldItems", "com/discord/utilities/recycler/DiffCreator$createDiffUtilCallback$1", "createDiffUtilCallback", "(Ljava/util/List;Ljava/util/List;)Lcom/discord/utilities/recycler/DiffCreator$createDiffUtilCallback$1;", "", "isExpensiveDiff", "(Ljava/util/List;Ljava/util/List;)Z", "dispatchDiffUpdatesAsync", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Lkotlin/jvm/functions/Function1;Ljava/util/List;Ljava/util/List;)V", "dispatchDiffUpdates", "calculateDiffResult", "(Ljava/util/List;Ljava/util/List;)Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "Lrx/subjects/PublishSubject;", "Lcom/discord/utilities/recycler/DiffCreator$UpdateRequest;", "kotlin.jvm.PlatformType", "updateRequestsSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/app/AppComponent;", "Lrx/Subscription;", "asyncDiffSubscription", "Lrx/Subscription;", "<init>", "Companion", "UpdateRequest", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DiffCreator<T extends List<? extends DiffKeyProvider>, VH extends RecyclerView.ViewHolder> {
    private static final int EXPENSIVE_DIFF_THRESHOLD = 225;
    private Subscription asyncDiffSubscription;
    private final AppComponent asyncDiffSubscriptionScope;
    private final PublishSubject<UpdateRequest<T, VH>> updateRequestsSubject = PublishSubject.k0();

    /* compiled from: DiffCreator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0004B9\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0011\u001a\u00028\u0002\u0012\u0006\u0010\u0012\u001a\u00028\u0002¢\u0006\u0004\b&\u0010'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJV\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0011\u001a\u00028\u00022\b\b\u0002\u0010\u0012\u001a\u00028\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0012\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\rR\u0019\u0010\u0011\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b!\u0010\rR\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0007R%\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\u000b¨\u0006("}, d2 = {"Lcom/discord/utilities/recycler/DiffCreator$UpdateRequest;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "component1", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lkotlin/Function1;", "", "component2", "()Lkotlin/jvm/functions/Function1;", "component3", "()Ljava/lang/Object;", "component4", "adapter", "setItems", "oldItems", "newItems", "copy", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Object;)Lcom/discord/utilities/recycler/DiffCreator$UpdateRequest;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getNewItems", "getOldItems", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "Lkotlin/jvm/functions/Function1;", "getSetItems", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Object;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UpdateRequest<T, VH extends RecyclerView.ViewHolder> {
        private final RecyclerView.Adapter<VH> adapter;
        private final T newItems;
        private final T oldItems;
        private final Function1<T, Unit> setItems;

        /* JADX WARN: Multi-variable type inference failed */
        public UpdateRequest(RecyclerView.Adapter<VH> adapter, Function1<? super T, Unit> function1, T t, T t2) {
            Intrinsics3.checkNotNullParameter(adapter, "adapter");
            Intrinsics3.checkNotNullParameter(function1, "setItems");
            this.adapter = adapter;
            this.setItems = function1;
            this.oldItems = t;
            this.newItems = t2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpdateRequest copy$default(UpdateRequest updateRequest, RecyclerView.Adapter adapter, Function1 function1, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                adapter = updateRequest.adapter;
            }
            if ((i & 2) != 0) {
                function1 = updateRequest.setItems;
            }
            if ((i & 4) != 0) {
                obj = updateRequest.oldItems;
            }
            if ((i & 8) != 0) {
                obj2 = updateRequest.newItems;
            }
            return updateRequest.copy(adapter, function1, obj, obj2);
        }

        public final RecyclerView.Adapter<VH> component1() {
            return this.adapter;
        }

        public final Function1<T, Unit> component2() {
            return this.setItems;
        }

        public final T component3() {
            return this.oldItems;
        }

        public final T component4() {
            return this.newItems;
        }

        public final UpdateRequest<T, VH> copy(RecyclerView.Adapter<VH> adapter, Function1<? super T, Unit> setItems, T oldItems, T newItems) {
            Intrinsics3.checkNotNullParameter(adapter, "adapter");
            Intrinsics3.checkNotNullParameter(setItems, "setItems");
            return new UpdateRequest<>(adapter, setItems, oldItems, newItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateRequest)) {
                return false;
            }
            UpdateRequest updateRequest = (UpdateRequest) other;
            return Intrinsics3.areEqual(this.adapter, updateRequest.adapter) && Intrinsics3.areEqual(this.setItems, updateRequest.setItems) && Intrinsics3.areEqual(this.oldItems, updateRequest.oldItems) && Intrinsics3.areEqual(this.newItems, updateRequest.newItems);
        }

        public final RecyclerView.Adapter<VH> getAdapter() {
            return this.adapter;
        }

        public final T getNewItems() {
            return this.newItems;
        }

        public final T getOldItems() {
            return this.oldItems;
        }

        public final Function1<T, Unit> getSetItems() {
            return this.setItems;
        }

        public int hashCode() {
            RecyclerView.Adapter<VH> adapter = this.adapter;
            int iHashCode = (adapter != null ? adapter.hashCode() : 0) * 31;
            Function1<T, Unit> function1 = this.setItems;
            int iHashCode2 = (iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31;
            T t = this.oldItems;
            int iHashCode3 = (iHashCode2 + (t != null ? t.hashCode() : 0)) * 31;
            T t2 = this.newItems;
            return iHashCode3 + (t2 != null ? t2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UpdateRequest(adapter=");
            sbU.append(this.adapter);
            sbU.append(", setItems=");
            sbU.append(this.setItems);
            sbU.append(", oldItems=");
            sbU.append(this.oldItems);
            sbU.append(", newItems=");
            sbU.append(this.newItems);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: DiffCreator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"com/discord/utilities/recycler/DiffCreator$createDiffUtilCallback$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "(II)Z", "getOldListSize", "()I", "getNewListSize", "areContentsTheSame", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.recycler.DiffCreator$createDiffUtilCallback$1, reason: invalid class name */
    public static final class AnonymousClass1 extends DiffUtil.Callback {
        public final /* synthetic */ List $newItems;
        public final /* synthetic */ List $oldItems;

        public AnonymousClass1(List list, List list2) {
            this.$oldItems = list;
            this.$newItems = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics3.areEqual((DiffKeyProvider) this.$oldItems.get(oldItemPosition), (DiffKeyProvider) this.$newItems.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics3.areEqual(((DiffKeyProvider) this.$oldItems.get(oldItemPosition)).getKey(), ((DiffKeyProvider) this.$newItems.get(newItemPosition)).getKey());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.$newItems.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.$oldItems.size();
        }
    }

    /* compiled from: DiffCreator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001af\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0006*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00050\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t \u0006*2\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0006*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00050\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b0\b\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\"\b\b\u0001\u0010\u0004*\u00020\u00032&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0006*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "Lcom/discord/utilities/recycler/DiffKeyProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lcom/discord/utilities/recycler/DiffCreator$UpdateRequest;", "kotlin.jvm.PlatformType", "updateRequest", "Lkotlin/Pair;", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/recycler/DiffCreator$UpdateRequest;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.recycler.DiffCreator$subscribeToAsyncUpdateRequests$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<UpdateRequest<T, VH>, Tuples2<? extends UpdateRequest<T, VH>, ? extends DiffUtil.DiffResult>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((UpdateRequest) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Tuples2<UpdateRequest<T, VH>, DiffUtil.DiffResult> call(UpdateRequest<T, VH> updateRequest) {
            return new Tuples2<>(updateRequest, DiffCreator.this.calculateDiffResult((List) updateRequest.getOldItems(), (List) updateRequest.getNewItems()));
        }
    }

    /* compiled from: DiffCreator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lcom/discord/utilities/recycler/DiffKeyProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.recycler.DiffCreator$subscribeToAsyncUpdateRequests$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            DiffCreator.access$setAsyncDiffSubscription$p(DiffCreator.this, subscription);
        }
    }

    /* compiled from: DiffCreator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\"\b\b\u0001\u0010\u0004*\u00020\u00032j\u0010\t\u001af\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0007*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00060\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b \u0007*2\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0007*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00060\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "Lcom/discord/utilities/recycler/DiffKeyProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lkotlin/Pair;", "Lcom/discord/utilities/recycler/DiffCreator$UpdateRequest;", "kotlin.jvm.PlatformType", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "<name for destructuring parameter 0>", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.recycler.DiffCreator$subscribeToAsyncUpdateRequests$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Tuples2<? extends UpdateRequest<T, VH>, ? extends DiffUtil.DiffResult>, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((Tuples2) obj);
            return Unit.a;
        }

        public final void invoke(Tuples2<UpdateRequest<T, VH>, ? extends DiffUtil.DiffResult> tuples2) {
            UpdateRequest<T, VH> updateRequestComponent1 = tuples2.component1();
            DiffCreator.access$setItemsAndDispatchUpdate(DiffCreator.this, updateRequestComponent1.getAdapter(), updateRequestComponent1.getSetItems(), updateRequestComponent1.getNewItems(), tuples2.component2());
        }
    }

    public DiffCreator(AppComponent appComponent) {
        this.asyncDiffSubscriptionScope = appComponent;
        if (appComponent != null) {
            subscribeToAsyncUpdateRequests(appComponent);
        }
    }

    public static final /* synthetic */ Subscription access$getAsyncDiffSubscription$p(DiffCreator diffCreator) {
        return diffCreator.asyncDiffSubscription;
    }

    public static final /* synthetic */ void access$setAsyncDiffSubscription$p(DiffCreator diffCreator, Subscription subscription) {
        diffCreator.asyncDiffSubscription = subscription;
    }

    public static final /* synthetic */ void access$setItemsAndDispatchUpdate(DiffCreator diffCreator, RecyclerView.Adapter adapter, Function1 function1, List list, DiffUtil.DiffResult diffResult) {
        diffCreator.setItemsAndDispatchUpdate(adapter, function1, list, diffResult);
    }

    private final AnonymousClass1 createDiffUtilCallback(T oldItems, T newItems) {
        return new AnonymousClass1(oldItems, newItems);
    }

    private final boolean isExpensiveDiff(T oldItems, T newItems) {
        if (Math.abs(newItems.size() - oldItems.size()) > 225) {
            return true;
        }
        ShallowPartitionMap shallowPartitionMapCreate$default = ShallowPartitionMap.Companion.create$default(ShallowPartitionMap.INSTANCE, oldItems.size(), 0, 0, null, 14, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = oldItems.iterator();
        while (it.hasNext()) {
            shallowPartitionMapCreate$default.put(((DiffKeyProvider) it.next()).getKey(), Unit.a);
        }
        Iterator it2 = newItems.iterator();
        while (it2.hasNext()) {
            String key = ((DiffKeyProvider) it2.next()).getKey();
            if (!shallowPartitionMapCreate$default.containsKey(key)) {
                arrayList.add(key);
            }
            shallowPartitionMapCreate$default.remove(key);
        }
        return arrayList.size() + shallowPartitionMapCreate$default.size() > 225;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NotifyDataSetChanged"})
    private final void setItemsAndDispatchUpdate(RecyclerView.Adapter<VH> adapter, Function1<? super T, Unit> setItems, T newItems, DiffUtil.DiffResult diffResult) {
        setItems.invoke(newItems);
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private final void subscribeToAsyncUpdateRequests(AppComponent asyncDiffSubscriptionScope) {
        PublishSubject<UpdateRequest<T, VH>> publishSubject = this.updateRequestsSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "updateRequestsSubject");
        Observable observableG = ObservableExtensionsKt.computationBuffered(publishSubject).G(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableG, "updateRequestsSubject\n  …ms)\n          )\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableG, asyncDiffSubscriptionScope, null, 2, null), DiffCreator.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 58, (Object) null);
    }

    public final DiffUtil.DiffResult calculateDiffResult(T oldItems, T newItems) {
        Intrinsics3.checkNotNullParameter(oldItems, "oldItems");
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        if (isExpensiveDiff(oldItems, newItems)) {
            return null;
        }
        return DiffUtil.calculateDiff(createDiffUtilCallback(oldItems, newItems), true);
    }

    public final void dispatchDiffUpdates(RecyclerView.Adapter<VH> adapter, Function1<? super T, Unit> setItems, T oldItems, T newItems) {
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        Intrinsics3.checkNotNullParameter(setItems, "setItems");
        Intrinsics3.checkNotNullParameter(oldItems, "oldItems");
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        setItemsAndDispatchUpdate(adapter, setItems, newItems, calculateDiffResult(oldItems, newItems));
    }

    @MainThread
    public final void dispatchDiffUpdatesAsync(RecyclerView.Adapter<VH> adapter, Function1<? super T, Unit> setItems, T oldItems, T newItems) {
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        Intrinsics3.checkNotNullParameter(setItems, "setItems");
        Intrinsics3.checkNotNullParameter(oldItems, "oldItems");
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        if (this.asyncDiffSubscriptionScope == null) {
            throw new IllegalStateException("to use async diffs, provide an asyncDiffSubscriptionScope");
        }
        Subscription subscription = this.asyncDiffSubscription;
        if (subscription == null || subscription.isUnsubscribed()) {
            subscribeToAsyncUpdateRequests(this.asyncDiffSubscriptionScope);
        }
        PublishSubject<UpdateRequest<T, VH>> publishSubject = this.updateRequestsSubject;
        publishSubject.k.onNext(new UpdateRequest<>(adapter, setItems, oldItems, newItems));
    }
}
