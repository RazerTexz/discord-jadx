package com.discord.stores;

import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.premium.OutboundPromotion;
import com.discord.models.domain.ModelEntitlement;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: StoreOutboundPromotions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000 \u0002* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/api/premium/OutboundPromotion;", "kotlin.jvm.PlatformType", "activePromos", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreOutboundPromotions2<T, R> implements Func1<List<? extends OutboundPromotion>, Observable<? extends List<? extends OutboundPromotion>>> {
    public final /* synthetic */ StoreOutboundPromotions this$0;

    /* compiled from: StoreOutboundPromotions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lcom/discord/api/premium/OutboundPromotion;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$1, reason: invalid class name */
    public static final class AnonymousClass1<V> implements Callable<List<? extends OutboundPromotion>> {
        public final /* synthetic */ List $activePromos;

        public AnonymousClass1(List list) {
            this.$activePromos = list;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<? extends OutboundPromotion> call() {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<? extends OutboundPromotion> call2() {
            long j = StoreOutboundPromotions2.this.this$0.getPrefs().getLong("CONSUMED_ENTITLEMENT_CODE", -1L);
            List list = this.$activePromos;
            ArrayList arrayListA0 = outline.a0(list, "activePromos");
            for (T t : list) {
                if (((OutboundPromotion) t).getId() != j) {
                    arrayListA0.add(t);
                }
            }
            return arrayListA0;
        }
    }

    /* compiled from: StoreOutboundPromotions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0014 \u0002*\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\u0004j\u0002`\u00052\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/models/domain/ModelEntitlement;", "kotlin.jvm.PlatformType", "entitlements", "", "Lcom/discord/primitives/PromoId;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<List<? extends ModelEntitlement>, Long> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Long call(List<? extends ModelEntitlement> list) {
            return call2((List<ModelEntitlement>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(List<ModelEntitlement> list) {
            T next;
            Long promotionId;
            Intrinsics3.checkNotNullExpressionValue(list, "entitlements");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it.next();
                ModelEntitlement modelEntitlement = (ModelEntitlement) next;
                if (Intrinsics3.areEqual(modelEntitlement.getConsumed(), Boolean.TRUE) && modelEntitlement.getPromotionId() != null) {
                    break;
                }
            }
            ModelEntitlement modelEntitlement2 = next;
            return Long.valueOf((modelEntitlement2 == null || (promotionId = modelEntitlement2.getPromotionId()) == null) ? -1L : promotionId.longValue());
        }
    }

    /* compiled from: StoreOutboundPromotions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/primitives/PromoId;", "kotlin.jvm.PlatformType", "consumedPromoId", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Long> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Long l) {
            call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Long l) {
            SharedPreferences.Editor editorEdit = StoreOutboundPromotions2.this.this$0.getPrefs().edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            Intrinsics3.checkNotNullExpressionValue(l, "consumedPromoId");
            editorEdit.putLong("CONSUMED_ENTITLEMENT_CODE", l.longValue());
            editorEdit.apply();
        }
    }

    /* compiled from: StoreOutboundPromotions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005 \u0002*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/PromoId;", "kotlin.jvm.PlatformType", "consumedPromoId", "", "Lcom/discord/api/premium/OutboundPromotion;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<Long, List<? extends OutboundPromotion>> {
        public final /* synthetic */ List $activePromos;

        public AnonymousClass4(List list) {
            this.$activePromos = list;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends OutboundPromotion> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<OutboundPromotion> call2(Long l) {
            List list = this.$activePromos;
            ArrayList arrayListA0 = outline.a0(list, "activePromos");
            for (T t : list) {
                if (l == null || ((OutboundPromotion) t).getId() != l.longValue()) {
                    arrayListA0.add(t);
                }
            }
            return arrayListA0;
        }
    }

    public StoreOutboundPromotions2(StoreOutboundPromotions storeOutboundPromotions) {
        this.this$0 = storeOutboundPromotions;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends OutboundPromotion>> call(List<? extends OutboundPromotion> list) {
        return call2((List<OutboundPromotion>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<OutboundPromotion>> call2(List<OutboundPromotion> list) {
        if (this.this$0.getPrefs().contains("CONSUMED_ENTITLEMENT_CODE")) {
            return Observable.D(new AnonymousClass1(list));
        }
        Intrinsics3.checkNotNullExpressionValue(list, "activePromos");
        return list.isEmpty() ^ true ? ObservableExtensionsKt.restSubscribeOn$default(StoreOutboundPromotions.access$getRestAPI$p(this.this$0).getMyEntitlements(521842831262875670L, false), false, 1, null).G(AnonymousClass2.INSTANCE).u(new AnonymousClass3()).G(new AnonymousClass4(list)) : new ScalarSynchronousObservable(list);
    }
}
