package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.p.Schedulers2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreGifting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ?2\u00020\u0001:\u0003?@AB\u000f\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b=\u0010>J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\b\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0012\u001a\u00020\u00042\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u000e\u0010\u0011\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00142\n\u0010\u0018\u001a\u00060\rj\u0002`\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b \u0010\u001fJ[\u0010&\u001a\u00020\u00042\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0010\b\u0002\u0010!\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u00102\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0004H\u0007¢\u0006\u0004\b(\u0010)J)\u0010*\u001a\u00020\u00042\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u000e\u0010!\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u0010¢\u0006\u0004\b*\u0010\u0013Rj\u0010.\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t -*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010,0, -**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t -*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010,0,\u0018\u00010+0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0019\u00101\u001a\u0002008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R>\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t05j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t`68\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006B"}, d2 = {"Lcom/discord/stores/StoreGifting;", "", "", "giftCode", "", "fetchGift", "(Ljava/lang/String;)V", ModelAuditLogEntry.CHANGE_KEY_CODE, "removeGiftCode", "Lcom/discord/stores/StoreGifting$GiftState;", "giftState", "setGifts", "(Ljava/lang/String;Lcom/discord/stores/StoreGifting$GiftState;)V", "", "Lcom/discord/primitives/SkuId;", "skuId", "Lcom/discord/primitives/PlanId;", "subscriptionPlanId", "clearGiftsForSku", "(JLjava/lang/Long;)V", "Lrx/Observable;", "requestGift", "(Ljava/lang/String;)Lrx/Observable;", "Lcom/discord/primitives/UserId;", "userId", "", "Lcom/discord/models/domain/ModelGift;", "getMyResolvedGifts", "(J)Lrx/Observable;", "gift", "acceptGift", "(Lcom/discord/models/domain/ModelGift;)V", "revokeGiftCode", "planId", "Lkotlin/Function1;", "onSuccess", "Lcom/discord/utilities/error/Error;", "onError", "generateGiftCode", "(JLjava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "handlePreLogout", "()V", "fetchMyGiftsForSku", "Lrx/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "knownGiftsSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "getDispatcher", "()Lcom/discord/stores/Dispatcher;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "knownGifts", "Ljava/util/HashMap;", "getKnownGifts", "()Ljava/util/HashMap;", "setKnownGifts", "(Ljava/util/HashMap;)V", "<init>", "(Lcom/discord/stores/Dispatcher;)V", "Companion", "GiftState", "HasGift", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGifting {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dispatcher dispatcher;
    private HashMap<String, GiftState> knownGifts;
    private final BehaviorSubject<Map<String, GiftState>> knownGiftsSubject;

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/stores/StoreGifting$Companion;", "", "", "Lcom/discord/primitives/SkuId;", "skuId", "Lcom/discord/primitives/PlanId;", "planId", "", "makeComboId", "(JLjava/lang/Long;)Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final String makeComboId(long skuId, Long planId) {
            StringBuilder sb = new StringBuilder();
            sb.append(skuId);
            sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
            sb.append(planId);
            return sb.toString();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/stores/StoreGifting$GiftState;", "", "<init>", "()V", "Invalid", "LoadFailed", "Loading", "RedeemedFailed", "Redeeming", "Resolved", "Revoking", "Lcom/discord/stores/StoreGifting$GiftState$Loading;", "Lcom/discord/stores/StoreGifting$GiftState$LoadFailed;", "Lcom/discord/stores/StoreGifting$GiftState$Invalid;", "Lcom/discord/stores/StoreGifting$GiftState$Resolved;", "Lcom/discord/stores/StoreGifting$GiftState$Redeeming;", "Lcom/discord/stores/StoreGifting$GiftState$RedeemedFailed;", "Lcom/discord/stores/StoreGifting$GiftState$Revoking;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class GiftState {

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGifting$GiftState$Invalid;", "Lcom/discord/stores/StoreGifting$GiftState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends GiftState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGifting$GiftState$LoadFailed;", "Lcom/discord/stores/StoreGifting$GiftState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class LoadFailed extends GiftState {
            public static final LoadFailed INSTANCE = new LoadFailed();

            private LoadFailed() {
                super(null);
            }
        }

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGifting$GiftState$Loading;", "Lcom/discord/stores/StoreGifting$GiftState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends GiftState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005¨\u0006\""}, d2 = {"Lcom/discord/stores/StoreGifting$GiftState$RedeemedFailed;", "Lcom/discord/stores/StoreGifting$GiftState;", "Lcom/discord/stores/StoreGifting$HasGift;", "Lcom/discord/models/domain/ModelGift;", "component1", "()Lcom/discord/models/domain/ModelGift;", "", "component2", "()Z", "", "component3", "()Ljava/lang/Integer;", "gift", "canRetry", "errorCode", "copy", "(Lcom/discord/models/domain/ModelGift;ZLjava/lang/Integer;)Lcom/discord/stores/StoreGifting$GiftState$RedeemedFailed;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCanRetry", "Ljava/lang/Integer;", "getErrorCode", "Lcom/discord/models/domain/ModelGift;", "getGift", "<init>", "(Lcom/discord/models/domain/ModelGift;ZLjava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class RedeemedFailed extends GiftState implements HasGift {
            private final boolean canRetry;
            private final Integer errorCode;
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RedeemedFailed(ModelGift modelGift, boolean z2, Integer num) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
                this.canRetry = z2;
                this.errorCode = num;
            }

            public static /* synthetic */ RedeemedFailed copy$default(RedeemedFailed redeemedFailed, ModelGift modelGift, boolean z2, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = redeemedFailed.getGift();
                }
                if ((i & 2) != 0) {
                    z2 = redeemedFailed.canRetry;
                }
                if ((i & 4) != 0) {
                    num = redeemedFailed.errorCode;
                }
                return redeemedFailed.copy(modelGift, z2, num);
            }

            public final ModelGift component1() {
                return getGift();
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getCanRetry() {
                return this.canRetry;
            }

            /* renamed from: component3, reason: from getter */
            public final Integer getErrorCode() {
                return this.errorCode;
            }

            public final RedeemedFailed copy(ModelGift gift, boolean canRetry, Integer errorCode) {
                Intrinsics3.checkNotNullParameter(gift, "gift");
                return new RedeemedFailed(gift, canRetry, errorCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RedeemedFailed)) {
                    return false;
                }
                RedeemedFailed redeemedFailed = (RedeemedFailed) other;
                return Intrinsics3.areEqual(getGift(), redeemedFailed.getGift()) && this.canRetry == redeemedFailed.canRetry && Intrinsics3.areEqual(this.errorCode, redeemedFailed.errorCode);
            }

            public final boolean getCanRetry() {
                return this.canRetry;
            }

            public final Integer getErrorCode() {
                return this.errorCode;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelGift gift = getGift();
                int iHashCode = (gift != null ? gift.hashCode() : 0) * 31;
                boolean z2 = this.canRetry;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                Integer num = this.errorCode;
                return i2 + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("RedeemedFailed(gift=");
                sbU.append(getGift());
                sbU.append(", canRetry=");
                sbU.append(this.canRetry);
                sbU.append(", errorCode=");
                return outline.F(sbU, this.errorCode, ")");
            }
        }

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreGifting$GiftState$Redeeming;", "Lcom/discord/stores/StoreGifting$GiftState;", "Lcom/discord/stores/StoreGifting$HasGift;", "Lcom/discord/models/domain/ModelGift;", "component1", "()Lcom/discord/models/domain/ModelGift;", "gift", "copy", "(Lcom/discord/models/domain/ModelGift;)Lcom/discord/stores/StoreGifting$GiftState$Redeeming;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelGift;", "getGift", "<init>", "(Lcom/discord/models/domain/ModelGift;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Redeeming extends GiftState implements HasGift {
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Redeeming(ModelGift modelGift) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
            }

            public static /* synthetic */ Redeeming copy$default(Redeeming redeeming, ModelGift modelGift, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = redeeming.getGift();
                }
                return redeeming.copy(modelGift);
            }

            public final ModelGift component1() {
                return getGift();
            }

            public final Redeeming copy(ModelGift gift) {
                Intrinsics3.checkNotNullParameter(gift, "gift");
                return new Redeeming(gift);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Redeeming) && Intrinsics3.areEqual(getGift(), ((Redeeming) other).getGift());
                }
                return true;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            public int hashCode() {
                ModelGift gift = getGift();
                if (gift != null) {
                    return gift.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Redeeming(gift=");
                sbU.append(getGift());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreGifting$GiftState$Resolved;", "Lcom/discord/stores/StoreGifting$GiftState;", "Lcom/discord/stores/StoreGifting$HasGift;", "Lcom/discord/models/domain/ModelGift;", "component1", "()Lcom/discord/models/domain/ModelGift;", "gift", "copy", "(Lcom/discord/models/domain/ModelGift;)Lcom/discord/stores/StoreGifting$GiftState$Resolved;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelGift;", "getGift", "<init>", "(Lcom/discord/models/domain/ModelGift;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Resolved extends GiftState implements HasGift {
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelGift modelGift) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelGift modelGift, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = resolved.getGift();
                }
                return resolved.copy(modelGift);
            }

            public final ModelGift component1() {
                return getGift();
            }

            public final Resolved copy(ModelGift gift) {
                Intrinsics3.checkNotNullParameter(gift, "gift");
                return new Resolved(gift);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && Intrinsics3.areEqual(getGift(), ((Resolved) other).getGift());
                }
                return true;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            public int hashCode() {
                ModelGift gift = getGift();
                if (gift != null) {
                    return gift.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Resolved(gift=");
                sbU.append(getGift());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreGifting$GiftState$Revoking;", "Lcom/discord/stores/StoreGifting$GiftState;", "Lcom/discord/stores/StoreGifting$HasGift;", "Lcom/discord/models/domain/ModelGift;", "component1", "()Lcom/discord/models/domain/ModelGift;", "gift", "copy", "(Lcom/discord/models/domain/ModelGift;)Lcom/discord/stores/StoreGifting$GiftState$Revoking;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelGift;", "getGift", "<init>", "(Lcom/discord/models/domain/ModelGift;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Revoking extends GiftState implements HasGift {
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Revoking(ModelGift modelGift) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
            }

            public static /* synthetic */ Revoking copy$default(Revoking revoking, ModelGift modelGift, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = revoking.getGift();
                }
                return revoking.copy(modelGift);
            }

            public final ModelGift component1() {
                return getGift();
            }

            public final Revoking copy(ModelGift gift) {
                Intrinsics3.checkNotNullParameter(gift, "gift");
                return new Revoking(gift);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Revoking) && Intrinsics3.areEqual(getGift(), ((Revoking) other).getGift());
                }
                return true;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            public int hashCode() {
                ModelGift gift = getGift();
                if (gift != null) {
                    return gift.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Revoking(gift=");
                sbU.append(getGift());
                sbU.append(")");
                return sbU.toString();
            }
        }

        private GiftState() {
        }

        public /* synthetic */ GiftState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/discord/stores/StoreGifting$HasGift;", "", "Lcom/discord/models/domain/ModelGift;", "getGift", "()Lcom/discord/models/domain/ModelGift;", "gift", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface HasGift {
        ModelGift getGift();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            Error.Type.values();
            int[] iArr = new int[18];
            $EnumSwitchMapping$0 = iArr;
            Error.Type type = Error.Type.DISCORD_REQUEST_ERROR;
            iArr[type.ordinal()] = 1;
            Error.Type type2 = Error.Type.NETWORK;
            iArr[type2.ordinal()] = 2;
            Error.Type.values();
            int[] iArr2 = new int[18];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[type.ordinal()] = 1;
            iArr2[type2.ordinal()] = 2;
            Error.Type.values();
            int[] iArr3 = new int[18];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[type.ordinal()] = 1;
            iArr3[type2.ordinal()] = 2;
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$acceptGift$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGifting$acceptGift$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01121 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreGifting.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGifting$acceptGift$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01131 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ Error $error;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01131(Error error) {
                    super(0);
                    this.$error = error;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (this.$error.getType() != Error.Type.DISCORD_BAD_REQUEST) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        StoreGifting.access$setGifts(StoreGifting.this, anonymousClass1.$gift.getCode(), new GiftState.RedeemedFailed(AnonymousClass1.this.$gift, true, null));
                    }
                    this.$error.setShowErrorToasts(false);
                    Error.Response response = this.$error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                    switch (response.getCode()) {
                        case RestAPIAbortCodes.GIFTING_ALREADY_USED_ERROR_CODE /* 50050 */:
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            StoreGifting storeGifting = StoreGifting.this;
                            String code = anonymousClass12.$gift.getCode();
                            ModelGift modelGift = AnonymousClass1.this.$gift;
                            StoreGifting.access$setGifts(storeGifting, code, new GiftState.Resolved(ModelGift.copy$default(modelGift, 0L, false, null, null, modelGift.getMaxUses(), null, 0, null, null, null, null, 2031, null)));
                            break;
                        case RestAPIAbortCodes.GIFTING_ALREADY_OWNED_ERROR_CODE /* 50051 */:
                            AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                            StoreGifting.access$setGifts(StoreGifting.this, anonymousClass13.$gift.getCode(), new GiftState.Resolved(ModelGift.copy$default(AnonymousClass1.this.$gift, 0L, true, null, null, 0, null, 0, null, null, null, null, 2045, null)));
                            break;
                        default:
                            AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                            StoreGifting storeGifting2 = StoreGifting.this;
                            String code2 = anonymousClass14.$gift.getCode();
                            ModelGift modelGift2 = AnonymousClass1.this.$gift;
                            Error.Response response2 = this.$error.getResponse();
                            Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
                            StoreGifting.access$setGifts(storeGifting2, code2, new GiftState.RedeemedFailed(modelGift2, false, Integer.valueOf(response2.getCode())));
                            break;
                    }
                }
            }

            public C01121() {
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
                StoreGifting.this.getDispatcher().schedule(new C01131(error));
            }
        }

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGifting$acceptGift$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {

            /* compiled from: StoreGifting.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGifting$acceptGift$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01141 extends Lambda implements Function0<Unit> {
                public C01141() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass1.$gift.getCode(), new GiftState.Resolved(ModelGift.copy$default(AnonymousClass1.this.$gift, 0L, true, null, null, 0, null, 0, null, null, null, null, 2045, null)));
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r2) {
                StoreGifting.this.getDispatcher().schedule(new C01141());
                StoreStream.INSTANCE.getLibrary().fetchApplications();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelGift modelGift) {
            super(0);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.access$setGifts(StoreGifting.this, this.$gift.getCode(), new GiftState.Redeeming(this.$gift));
            Observable<Void> observableX = RestAPI.INSTANCE.getApi().acceptGift(this.$gift.getCode()).X(Schedulers2.c());
            Intrinsics3.checkNotNullExpressionValue(observableX, "RestAPI\n        .api\n   …scribeOn(Schedulers.io())");
            ObservableExtensionsKt.appSubscribe$default(observableX, StoreGifting.this.getClass(), (Context) null, (Function1) null, new C01121(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelGift;", "gift", "", "invoke", "(Lcom/discord/models/domain/ModelGift;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$fetchGift$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelGift, Unit> {
        public final /* synthetic */ String $giftCode;

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGifting$fetchGift$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01151 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelGift $gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01151(ModelGift modelGift) {
                super(0);
                this.$gift = modelGift;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnalyticsTracker.INSTANCE.giftResolved(this.$gift);
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGifting.access$setGifts(StoreGifting.this, anonymousClass1.$giftCode, new GiftState.Resolved(this.$gift));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$giftCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
            invoke2(modelGift);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGift modelGift) {
            Intrinsics3.checkNotNullParameter(modelGift, "gift");
            StoreGifting.this.getDispatcher().schedule(new C01151(modelGift));
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$fetchGift$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $giftCode;

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGifting$fetchGift$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnalyticsTracker.INSTANCE.giftResolvedFailed(AnonymousClass2.this.$giftCode);
                int iOrdinal = this.$error.getType().ordinal();
                if (iOrdinal == 3) {
                    this.$error.setShowErrorToasts(false);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass2.$giftCode, GiftState.Invalid.INSTANCE);
                } else if (iOrdinal != 11) {
                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass22.$giftCode, GiftState.LoadFailed.INSTANCE);
                } else {
                    AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass23.$giftCode, GiftState.LoadFailed.INSTANCE);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$giftCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $comboId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$comboId = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.access$setGifts(StoreGifting.this, this.$comboId, GiftState.Loading.INSTANCE);
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $comboId;

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int iOrdinal = this.$error.getType().ordinal();
                if (iOrdinal == 3) {
                    this.$error.setShowErrorToasts(false);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass2.$comboId, GiftState.Invalid.INSTANCE);
                } else if (iOrdinal == 11) {
                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass22.$comboId, GiftState.LoadFailed.INSTANCE);
                } else {
                    Logger.e$default(AppLog.g, "Fetching Gift Error", new Exception(String.valueOf(this.$error.getType())), null, 4, null);
                    AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass23.$comboId, GiftState.LoadFailed.INSTANCE);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$comboId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/models/domain/ModelGift;", "gifts", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends ModelGift>, Unit> {
        public final /* synthetic */ String $comboId;
        public final /* synthetic */ Long $planId;
        public final /* synthetic */ long $skuId;

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $gifts;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$gifts = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreGifting.access$removeGiftCode(StoreGifting.this, anonymousClass3.$comboId);
                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                StoreGifting.access$clearGiftsForSku(StoreGifting.this, anonymousClass32.$skuId, anonymousClass32.$planId);
                for (ModelGift modelGift : this.$gifts) {
                    StoreGifting.access$setGifts(StoreGifting.this, modelGift.getCode(), new GiftState.Resolved(modelGift));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, long j, Long l) {
            super(1);
            this.$comboId = str;
            this.$skuId = j;
            this.$planId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGift> list) {
            invoke2((List<ModelGift>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGift> list) {
            Intrinsics3.checkNotNullParameter(list, "gifts");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$generateGiftCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $comboId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$comboId = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.access$setGifts(StoreGifting.this, this.$comboId, GiftState.Loading.INSTANCE);
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$generateGiftCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $comboId;
        public final /* synthetic */ Function1 $onError;

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGifting$generateGiftCode$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int iOrdinal = this.$error.getType().ordinal();
                if (iOrdinal == 3) {
                    this.$error.setShowErrorToasts(false);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass2.$comboId, GiftState.Invalid.INSTANCE);
                } else if (iOrdinal != 11) {
                    Logger.e$default(AppLog.g, "Generate Gift Code Error", new Exception(String.valueOf(this.$error.getType())), null, 4, null);
                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass22.$comboId, GiftState.LoadFailed.INSTANCE);
                } else {
                    AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass23.$comboId, GiftState.LoadFailed.INSTANCE);
                }
                AnonymousClass2 anonymousClass24 = AnonymousClass2.this;
                StoreGifting.access$setGifts(StoreGifting.this, anonymousClass24.$comboId, GiftState.LoadFailed.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Function1 function1) {
            super(1);
            this.$comboId = str;
            this.$onError = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
            Function1 function1 = this.$onError;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelGift;", "newGift", "", "invoke", "(Lcom/discord/models/domain/ModelGift;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$generateGiftCode$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<ModelGift, Unit> {
        public final /* synthetic */ String $comboId;
        public final /* synthetic */ Function1 $onSuccess;

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGifting$generateGiftCode$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelGift $newGift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelGift modelGift) {
                super(0);
                this.$newGift = modelGift;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreGifting.access$removeGiftCode(StoreGifting.this, anonymousClass3.$comboId);
                StoreGifting.access$setGifts(StoreGifting.this, this.$newGift.getCode(), new GiftState.Resolved(this.$newGift));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, Function1 function1) {
            super(1);
            this.$comboId = str;
            this.$onSuccess = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
            invoke2(modelGift);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGift modelGift) {
            Intrinsics3.checkNotNullParameter(modelGift, "newGift");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(modelGift));
            Function1 function1 = this.$onSuccess;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006 \u0003*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/stores/StoreGifting$GiftState;", "kotlin.jvm.PlatformType", "giftMap", "", "Lcom/discord/models/domain/ModelGift;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$getMyResolvedGifts$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<String, ? extends GiftState>, List<? extends ModelGift>> {
        public final /* synthetic */ long $userId;

        public AnonymousClass1(long j) {
            this.$userId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends ModelGift> call(Map<String, ? extends GiftState> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ModelGift> call2(Map<String, ? extends GiftState> map) {
            User user;
            Collection<? extends GiftState> collectionValues = map.values();
            ArrayList<GiftState> arrayList = new ArrayList();
            for (T t : collectionValues) {
                GiftState giftState = (GiftState) t;
                if ((giftState instanceof GiftState.Resolved) && (user = ((GiftState.Resolved) giftState).getGift().getUser()) != null && user.getId() == this.$userId) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            for (GiftState giftState2 : arrayList) {
                Objects.requireNonNull(giftState2, "null cannot be cast to non-null type com.discord.stores.StoreGifting.GiftState.Resolved");
                arrayList2.add(((GiftState.Resolved) giftState2).getGift());
            }
            return arrayList2;
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$requestGift$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $giftCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$giftCode = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.access$fetchGift(StoreGifting.this, this.$giftCode);
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/stores/StoreGifting$GiftState;", "kotlin.jvm.PlatformType", "invites", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/stores/StoreGifting$GiftState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$requestGift$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<String, ? extends GiftState>, GiftState> {
        public final /* synthetic */ String $giftCode;

        public AnonymousClass2(String str) {
            this.$giftCode = str;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GiftState call(Map<String, ? extends GiftState> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GiftState call2(Map<String, ? extends GiftState> map) {
            GiftState giftState = map.get(this.$giftCode);
            return giftState != null ? giftState : GiftState.Loading.INSTANCE;
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$revokeGiftCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelGift modelGift) {
            super(0);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.access$setGifts(StoreGifting.this, this.$gift.getCode(), new GiftState.Revoking(this.$gift));
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$revokeGiftCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGifting$revokeGiftCode$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Logger.e$default(AppLog.g, "Revoking Gift Error", new Exception(String.valueOf(this.$error.getType())), null, 4, null);
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGifting.access$setGifts(StoreGifting.this, anonymousClass2.$gift.getCode(), new GiftState.Resolved(AnonymousClass2.this.$gift));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ModelGift modelGift) {
            super(1);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGifting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGifting$revokeGiftCode$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* compiled from: StoreGifting.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGifting$revokeGiftCode$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreGifting.access$removeGiftCode(StoreGifting.this, anonymousClass3.$gift.getCode());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ModelGift modelGift) {
            super(1);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1());
        }
    }

    public StoreGifting(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.knownGifts = new HashMap<>();
        this.knownGiftsSubject = BehaviorSubject.l0(Maps6.emptyMap());
    }

    public static final /* synthetic */ void access$clearGiftsForSku(StoreGifting storeGifting, long j, Long l) {
        storeGifting.clearGiftsForSku(j, l);
    }

    public static final /* synthetic */ void access$fetchGift(StoreGifting storeGifting, String str) {
        storeGifting.fetchGift(str);
    }

    public static final /* synthetic */ void access$removeGiftCode(StoreGifting storeGifting, String str) {
        storeGifting.removeGiftCode(str);
    }

    public static final /* synthetic */ void access$setGifts(StoreGifting storeGifting, String str, GiftState giftState) {
        storeGifting.setGifts(str, giftState);
    }

    @Store3
    private final void clearGiftsForSku(long skuId, Long subscriptionPlanId) {
        HashMap<String, GiftState> map = this.knownGifts;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, GiftState> entry : map.entrySet()) {
            GiftState value = entry.getValue();
            boolean z2 = true;
            if (value instanceof GiftState.Resolved) {
                if (((GiftState.Resolved) value).getGift().getSkuId() == skuId && subscriptionPlanId != null && !(!Intrinsics3.areEqual(r3.getGift().getSubscriptionPlanId(), subscriptionPlanId))) {
                    z2 = false;
                }
            }
            if (z2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.knownGifts = new HashMap<>(linkedHashMap);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    @Store3
    private final void fetchGift(String giftCode) {
        if (this.knownGifts.containsKey(giftCode) && !(this.knownGifts.get(giftCode) instanceof GiftState.LoadFailed)) {
            if (!(this.knownGifts.get(giftCode) instanceof GiftState.Resolved)) {
                return;
            }
            GiftState giftState = this.knownGifts.get(giftCode);
            Objects.requireNonNull(giftState, "null cannot be cast to non-null type com.discord.stores.StoreGifting.GiftState.Resolved");
            if (((GiftState.Resolved) giftState).getGift().isComplete()) {
                return;
            }
        }
        setGifts(giftCode, GiftState.Loading.INSTANCE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().resolveGiftCode(giftCode, true, true), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new AnonymousClass2(giftCode), (Function0) null, (Function0) null, new AnonymousClass1(giftCode), 54, (Object) null);
    }

    public static /* synthetic */ void generateGiftCode$default(StoreGifting storeGifting, long j, Long l, Function1 function1, Function1 function12, int i, Object obj) {
        storeGifting.generateGiftCode(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function12);
    }

    @Store3
    private final void removeGiftCode(String code) {
        this.knownGifts.remove(code);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    @Store3
    private final void setGifts(String code, GiftState giftState) {
        this.knownGifts.put(code, giftState);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    public final void acceptGift(ModelGift gift) {
        Intrinsics3.checkNotNullParameter(gift, "gift");
        this.dispatcher.schedule(new AnonymousClass1(gift));
    }

    public final void fetchMyGiftsForSku(long skuId, Long planId) {
        String strMakeComboId = INSTANCE.makeComboId(skuId, planId);
        if (!this.knownGifts.containsKey(strMakeComboId) || (this.knownGifts.get(strMakeComboId) instanceof GiftState.LoadFailed)) {
            this.dispatcher.schedule(new AnonymousClass1(strMakeComboId));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().resolveSkuIdGift(skuId, planId), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new AnonymousClass2(strMakeComboId), (Function0) null, (Function0) null, new AnonymousClass3(strMakeComboId, skuId, planId), 54, (Object) null);
        }
    }

    public final void generateGiftCode(long skuId, Long planId, Function1<? super ModelGift, Unit> onSuccess, Function1<? super Error, Unit> onError) {
        String strMakeComboId = INSTANCE.makeComboId(skuId, planId);
        if (this.knownGifts.get(strMakeComboId) instanceof GiftState.Loading) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(strMakeComboId));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().generateGiftCode(new RestAPIParams.GenerateGiftCode(skuId, planId)), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new AnonymousClass2(strMakeComboId, onError), (Function0) null, (Function0) null, new AnonymousClass3(strMakeComboId, onSuccess), 54, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final HashMap<String, GiftState> getKnownGifts() {
        return this.knownGifts;
    }

    public final Observable<List<ModelGift>> getMyResolvedGifts(long userId) {
        Observable observableG = this.knownGiftsSubject.G(new AnonymousClass1(userId));
        Intrinsics3.checkNotNullExpressionValue(observableG, "knownGiftsSubject\n      …              }\n        }");
        return observableG;
    }

    @Store3
    public final void handlePreLogout() {
        this.knownGifts.clear();
    }

    public final Observable<GiftState> requestGift(String giftCode) {
        Intrinsics3.checkNotNullParameter(giftCode, "giftCode");
        this.dispatcher.schedule(new AnonymousClass1(giftCode));
        Observable<GiftState> observableR = this.knownGiftsSubject.G(new AnonymousClass2(giftCode)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "knownGiftsSubject\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final void revokeGiftCode(ModelGift gift) {
        Intrinsics3.checkNotNullParameter(gift, "gift");
        if (this.knownGifts.containsKey(gift.getCode()) && (this.knownGifts.get(gift.getCode()) instanceof GiftState.Revoking)) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(gift));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().revokeGiftCode(gift.getCode()), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new AnonymousClass2(gift), (Function0) null, (Function0) null, new AnonymousClass3(gift), 54, (Object) null);
    }

    public final void setKnownGifts(HashMap<String, GiftState> map) {
        Intrinsics3.checkNotNullParameter(map, "<set-?>");
        this.knownGifts = map;
    }
}
