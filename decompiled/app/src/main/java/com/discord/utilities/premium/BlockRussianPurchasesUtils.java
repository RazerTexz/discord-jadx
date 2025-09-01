package com.discord.utilities.premium;

import b.a.a.WidgetBlockRussianPurchasesDialog;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BlockRussianPurchasesUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/utilities/premium/BlockRussianPurchasesUtils;", "", "", "isBlockedFromPurchases", "()Z", "showDialog", "Ljava/lang/Boolean;", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BlockRussianPurchasesUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(BlockRussianPurchasesUtils2.INSTANCE);
    private Boolean isBlockedFromPurchases;

    /* compiled from: BlockRussianPurchasesUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/utilities/premium/BlockRussianPurchasesUtils$Companion;", "", "Lcom/discord/utilities/premium/BlockRussianPurchasesUtils;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/utilities/premium/BlockRussianPurchasesUtils;", "INSTANCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final BlockRussianPurchasesUtils getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = BlockRussianPurchasesUtils.access$getINSTANCE$cp();
            Companion companion = BlockRussianPurchasesUtils.INSTANCE;
            return (BlockRussianPurchasesUtils) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isBlockedFromPurchases() {
        if (this.isBlockedFromPurchases == null) {
            Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2022-03_block_russian_purchases", true);
            this.isBlockedFromPurchases = Boolean.valueOf(userExperiment != null && userExperiment.getBucket() == 1);
        }
        Boolean bool = this.isBlockedFromPurchases;
        Intrinsics3.checkNotNull(bool);
        return bool.booleanValue();
    }

    public final boolean showDialog() {
        if (!isBlockedFromPurchases()) {
            return false;
        }
        Objects.requireNonNull(WidgetBlockRussianPurchasesDialog.INSTANCE);
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("Block Russian Purchases Dialog", null, 0L, 0, false, null, 0L, true, 0L, BlockRussianPurchasesUtils3.INSTANCE, 54, null));
        return true;
    }
}
