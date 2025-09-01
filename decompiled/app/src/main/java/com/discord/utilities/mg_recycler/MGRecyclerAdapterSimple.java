package com.discord.utilities.mg_recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.p.Schedulers2;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: MGRecyclerAdapterSimple.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001b\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\b\b\u0002\u0010/\u001a\u00020.¢\u0006\u0004\b3\u00104J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0012\u001a\u00020\u00062$\u0010\u0011\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u001f\u0010 R0\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R:\u0010(\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00028\u00000'0&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R6\u0010\u0011\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "D", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;", "", "throwable", "", "handleError", "(Ljava/lang/Throwable;)V", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diffResult", "", "oldData", "newData", "dispatchUpdates", "(Landroidx/recyclerview/widget/DiffUtil$DiffResult;Ljava/util/List;Ljava/util/List;)V", "Lkotlin/Function2;", "onUpdated", "setOnUpdated", "(Lkotlin/jvm/functions/Function2;)V", "unsubscribeFromUpdates", "()V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getItemViewType", "(I)I", "getItemCount", "()I", "getItem", "(I)Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "data", "setData", "(Ljava/util/List;)V", "<set-?>", "internalData", "Ljava/util/List;", "getInternalData", "()Ljava/util/List;", "Lcom/discord/utilities/recycler/DiffCreator;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "diffCreator", "Lcom/discord/utilities/recycler/DiffCreator;", "Lkotlin/jvm/functions/Function2;", "Lrx/Subscription;", "diffingSubscription", "Lrx/Subscription;", "", "deferredDiffs", "Z", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class MGRecyclerAdapterSimple<D extends MGRecyclerDataPayload> extends MGRecyclerAdapter<D> {
    private final boolean deferredDiffs;
    private final DiffCreator<List<D>, MGRecyclerViewHolder<MGRecyclerAdapterSimple<D>, D>> diffCreator;
    private Subscription diffingSubscription;
    private List<? extends D> internalData;
    private Function2<? super List<? extends D>, ? super List<? extends D>, Unit> onUpdated;

    /* compiled from: MGRecyclerAdapterSimple.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "D", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", NotificationCompat.CATEGORY_CALL, "()Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$1, reason: invalid class name */
    public static final class AnonymousClass1<V> implements Callable<DiffUtil.DiffResult> {
        public final /* synthetic */ List $newData;
        public final /* synthetic */ List $oldData;

        public AnonymousClass1(List list, List list2) {
            this.$oldData = list;
            this.$newData = list2;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ DiffUtil.DiffResult call() {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public final DiffUtil.DiffResult call() {
            return MGRecyclerAdapterSimple.access$getDiffCreator$p(MGRecyclerAdapterSimple.this).calculateDiffResult(this.$oldData, this.$newData);
        }
    }

    /* compiled from: MGRecyclerAdapterSimple.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "D", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diffResult", "", "invoke", "(Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<DiffUtil.DiffResult, Unit> {
        public final /* synthetic */ List $newData;
        public final /* synthetic */ List $oldData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list, List list2) {
            super(1);
            this.$oldData = list;
            this.$newData = list2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DiffUtil.DiffResult diffResult) {
            invoke2(diffResult);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DiffUtil.DiffResult diffResult) {
            MGRecyclerAdapterSimple.access$dispatchUpdates(MGRecyclerAdapterSimple.this, diffResult, this.$oldData, this.$newData);
        }
    }

    /* compiled from: MGRecyclerAdapterSimple.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "D", "Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            MGRecyclerAdapterSimple mGRecyclerAdapterSimple = MGRecyclerAdapterSimple.this;
            Throwable throwable = error.getThrowable();
            Intrinsics3.checkNotNullExpressionValue(throwable, "error.throwable");
            MGRecyclerAdapterSimple.access$handleError(mGRecyclerAdapterSimple, throwable);
        }
    }

    /* compiled from: MGRecyclerAdapterSimple.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "D", "Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple$setData$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass4() {
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
            MGRecyclerAdapterSimple.access$setDiffingSubscription$p(MGRecyclerAdapterSimple.this, subscription);
        }
    }

    public MGRecyclerAdapterSimple(RecyclerView recyclerView) {
        this(recyclerView, false, 2, null);
    }

    public /* synthetic */ MGRecyclerAdapterSimple(RecyclerView recyclerView, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? true : z2);
    }

    public static final /* synthetic */ void access$dispatchUpdates(MGRecyclerAdapterSimple mGRecyclerAdapterSimple, DiffUtil.DiffResult diffResult, List list, List list2) {
        mGRecyclerAdapterSimple.dispatchUpdates(diffResult, list, list2);
    }

    public static final /* synthetic */ DiffCreator access$getDiffCreator$p(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
        return mGRecyclerAdapterSimple.diffCreator;
    }

    public static final /* synthetic */ Subscription access$getDiffingSubscription$p(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
        return mGRecyclerAdapterSimple.diffingSubscription;
    }

    public static final /* synthetic */ void access$handleError(MGRecyclerAdapterSimple mGRecyclerAdapterSimple, Throwable th) {
        mGRecyclerAdapterSimple.handleError(th);
    }

    public static final /* synthetic */ void access$setDiffingSubscription$p(MGRecyclerAdapterSimple mGRecyclerAdapterSimple, Subscription subscription) {
        mGRecyclerAdapterSimple.diffingSubscription = subscription;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void dispatchUpdates(DiffUtil.DiffResult diffResult, List<? extends D> oldData, List<? extends D> newData) {
        this.internalData = newData;
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo(this);
        } else {
            notifyDataSetChanged();
        }
        Function2<? super List<? extends D>, ? super List<? extends D>, Unit> function2 = this.onUpdated;
        if (function2 != null) {
            function2.invoke(oldData, newData);
        }
    }

    private final void handleError(Throwable throwable) {
        AppLog.g.e("Unable to configure recycler.", throwable, MapsJVM.mapOf(Tuples.to("adapterClass", getClass().getSimpleName())));
    }

    public final List<D> getInternalData() {
        return this.internalData;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapter
    public /* bridge */ /* synthetic */ Object getItem(int i) {
        return getItem(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.internalData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    public void setData(List<? extends D> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        unsubscribeFromUpdates();
        List<? extends D> list = this.internalData;
        if (list.isEmpty()) {
            dispatchUpdates(null, list, data);
            return;
        }
        if (!this.deferredDiffs) {
            try {
                dispatchUpdates(this.diffCreator.calculateDiffResult(list, data), list, data);
                return;
            } catch (Throwable th) {
                handleError(th);
                return;
            }
        }
        Observable observableX = Observable.D(new AnonymousClass1(list, data)).X(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableX, "Observable\n            .…Schedulers.computation())");
        Observable observableUi = ObservableExtensionsKt.ui(observableX);
        Class<?> cls = getClass();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(list, data);
        ObservableExtensionsKt.appSubscribe$default(observableUi, cls, (Context) null, new AnonymousClass4(), new AnonymousClass3(), (Function0) null, (Function0) null, anonymousClass2, 50, (Object) null);
    }

    public final void setOnUpdated(Function2<? super List<? extends D>, ? super List<? extends D>, Unit> onUpdated) {
        Intrinsics3.checkNotNullParameter(onUpdated, "onUpdated");
        this.onUpdated = onUpdated;
    }

    public final void unsubscribeFromUpdates() {
        Subscription subscription = this.diffingSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.diffingSubscription = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGRecyclerAdapterSimple(RecyclerView recyclerView, boolean z2) {
        super(recyclerView);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.deferredDiffs = z2;
        this.internalData = Collections2.emptyList();
        this.diffCreator = new DiffCreator<>(null);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapter
    public D getItem(int position) {
        return this.internalData.get(position);
    }
}
