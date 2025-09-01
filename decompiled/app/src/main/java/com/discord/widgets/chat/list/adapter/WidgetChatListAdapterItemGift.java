package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.application.Application;
import com.discord.api.user.User;
import com.discord.databinding.WidgetChatListAdapterItemGiftBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelStoreListing;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.fresco.GrayscalePostprocessor;
import com.discord.utilities.gifting.GiftStyle3;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GiftEntry;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.material.button.MaterialButton;
import d0.g0.StringsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemGift.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0003$%&B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;)V", "configureLoadingUI", "()V", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Resolved;", "configureResolvedUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Resolved;)V", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Invalid;", "configureInvalidUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Invalid;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "Lcom/discord/widgets/chat/list/entries/GiftEntry;", "item", "Lcom/discord/widgets/chat/list/entries/GiftEntry;", "Lcom/discord/databinding/WidgetChatListAdapterItemGiftBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemGiftBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "Companion", ExifInterface.TAG_MODEL, "ModelProvider", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift extends WidgetChatListItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final GrayscalePostprocessor SPLASH_IMAGE_POSTPROCESSOR = new GrayscalePostprocessor();
    private final WidgetChatListAdapterItemGiftBinding binding;
    private GiftEntry item;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemGift.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Companion;", "", "", "skuId", "", "getDiscordStoreURL", "(J)Ljava/lang/String;", "Lcom/discord/utilities/fresco/GrayscalePostprocessor;", "SPLASH_IMAGE_POSTPROCESSOR", "Lcom/discord/utilities/fresco/GrayscalePostprocessor;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$getDiscordStoreURL(Companion companion, long j) {
            return companion.getDiscordStoreURL(j);
        }

        private final String getDiscordStoreURL(long skuId) {
            return outline.t("https://discord.com/store/skus/", skuId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListAdapterItemGift.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", "", "<init>", "()V", "Invalid", "Loading", "Resolved", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Loading;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Resolved;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Model {

        /* compiled from: WidgetChatListAdapterItemGift.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R!\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Invalid;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", "", "Lcom/discord/primitives/UserId;", "component1", "()Ljava/lang/Long;", "component2", "()J", "gifterUserId", "meId", "copy", "(Ljava/lang/Long;J)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Invalid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getMeId", "Ljava/lang/Long;", "getGifterUserId", "<init>", "(Ljava/lang/Long;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Invalid extends Model {
            private final Long gifterUserId;
            private final long meId;

            public Invalid(Long l, long j) {
                super(null);
                this.gifterUserId = l;
                this.meId = j;
            }

            public static /* synthetic */ Invalid copy$default(Invalid invalid, Long l, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = invalid.gifterUserId;
                }
                if ((i & 2) != 0) {
                    j = invalid.meId;
                }
                return invalid.copy(l, j);
            }

            /* renamed from: component1, reason: from getter */
            public final Long getGifterUserId() {
                return this.gifterUserId;
            }

            /* renamed from: component2, reason: from getter */
            public final long getMeId() {
                return this.meId;
            }

            public final Invalid copy(Long gifterUserId, long meId) {
                return new Invalid(gifterUserId, meId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Invalid)) {
                    return false;
                }
                Invalid invalid = (Invalid) other;
                return Intrinsics3.areEqual(this.gifterUserId, invalid.gifterUserId) && this.meId == invalid.meId;
            }

            public final Long getGifterUserId() {
                return this.gifterUserId;
            }

            public final long getMeId() {
                return this.meId;
            }

            public int hashCode() {
                Long l = this.gifterUserId;
                return b.a(this.meId) + ((l != null ? l.hashCode() : 0) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Invalid(gifterUserId=");
                sbU.append(this.gifterUserId);
                sbU.append(", meId=");
                return outline.C(sbU, this.meId, ")");
            }
        }

        /* compiled from: WidgetChatListAdapterItemGift.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Loading;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends Model {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: WidgetChatListAdapterItemGift.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\"\u0010\n¨\u0006%"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Resolved;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", "Lcom/discord/models/domain/ModelGift;", "component1", "()Lcom/discord/models/domain/ModelGift;", "Lcom/discord/models/user/MeUser;", "component2", "()Lcom/discord/models/user/MeUser;", "", "component3", "()Z", "component4", "gift", "meUser", "inLibrary", "redeeming", "copy", "(Lcom/discord/models/domain/ModelGift;Lcom/discord/models/user/MeUser;ZZ)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model$Resolved;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getRedeeming", "Lcom/discord/models/user/MeUser;", "getMeUser", "Lcom/discord/models/domain/ModelGift;", "getGift", "getInLibrary", "<init>", "(Lcom/discord/models/domain/ModelGift;Lcom/discord/models/user/MeUser;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Resolved extends Model {
            private final ModelGift gift;
            private final boolean inLibrary;
            private final MeUser meUser;
            private final boolean redeeming;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelGift modelGift, MeUser meUser, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGift, "gift");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                this.gift = modelGift;
                this.meUser = meUser;
                this.inLibrary = z2;
                this.redeeming = z3;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelGift modelGift, MeUser meUser, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = resolved.gift;
                }
                if ((i & 2) != 0) {
                    meUser = resolved.meUser;
                }
                if ((i & 4) != 0) {
                    z2 = resolved.inLibrary;
                }
                if ((i & 8) != 0) {
                    z3 = resolved.redeeming;
                }
                return resolved.copy(modelGift, meUser, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGift getGift() {
                return this.gift;
            }

            /* renamed from: component2, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getInLibrary() {
                return this.inLibrary;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getRedeeming() {
                return this.redeeming;
            }

            public final Resolved copy(ModelGift gift, MeUser meUser, boolean inLibrary, boolean redeeming) {
                Intrinsics3.checkNotNullParameter(gift, "gift");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                return new Resolved(gift, meUser, inLibrary, redeeming);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Resolved)) {
                    return false;
                }
                Resolved resolved = (Resolved) other;
                return Intrinsics3.areEqual(this.gift, resolved.gift) && Intrinsics3.areEqual(this.meUser, resolved.meUser) && this.inLibrary == resolved.inLibrary && this.redeeming == resolved.redeeming;
            }

            public final ModelGift getGift() {
                return this.gift;
            }

            public final boolean getInLibrary() {
                return this.inLibrary;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final boolean getRedeeming() {
                return this.redeeming;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelGift modelGift = this.gift;
                int iHashCode = (modelGift != null ? modelGift.hashCode() : 0) * 31;
                MeUser meUser = this.meUser;
                int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
                boolean z2 = this.inLibrary;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                boolean z3 = this.redeeming;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Resolved(gift=");
                sbU.append(this.gift);
                sbU.append(", meUser=");
                sbU.append(this.meUser);
                sbU.append(", inLibrary=");
                sbU.append(this.inLibrary);
                sbU.append(", redeeming=");
                return outline.O(sbU, this.redeeming, ")");
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListAdapterItemGift.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$ModelProvider;", "", "Lcom/discord/widgets/chat/list/entries/GiftEntry;", "item", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", "getInvalidGift", "(Lcom/discord/widgets/chat/list/entries/GiftEntry;)Lrx/Observable;", "Lcom/discord/models/domain/ModelGift;", "gift", "", "redeeming", "getResolvedGiftModel", "(Lcom/discord/models/domain/ModelGift;Z)Lrx/Observable;", "get", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        public static final /* synthetic */ Observable access$getInvalidGift(ModelProvider modelProvider, GiftEntry giftEntry) {
            return modelProvider.getInvalidGift(giftEntry);
        }

        public static final /* synthetic */ Observable access$getResolvedGiftModel(ModelProvider modelProvider, ModelGift modelGift, boolean z2) {
            return modelProvider.getResolvedGiftModel(modelGift, z2);
        }

        private final Observable<Model> getInvalidGift(GiftEntry item) {
            Observable<Model> observableJ = Observable.j(new ScalarSynchronousObservable(Long.valueOf(item.getUserId())), StoreStream.INSTANCE.getUsers().observeMeId(), WidgetChatListAdapterItemGift4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…lid(authorUserId, meId) }");
            return observableJ;
        }

        private final Observable<Model> getResolvedGiftModel(ModelGift gift, boolean redeeming) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Model> observableJ = Observable.j(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getLibrary().observeApplications(), new WidgetChatListAdapterItemGift5(gift, redeeming));
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest… me.id)\n        }\n      }");
            return observableJ;
        }

        public static /* synthetic */ Observable getResolvedGiftModel$default(ModelProvider modelProvider, ModelGift modelGift, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return modelProvider.getResolvedGiftModel(modelGift, z2);
        }

        public final Observable<Model> get(GiftEntry item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            Observable observableY = StoreStream.INSTANCE.getGifting().requestGift(item.getGiftCode()).Y(new WidgetChatListAdapterItemGift3(item));
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
            return observableY;
        }
    }

    /* compiled from: WidgetChatListAdapterItemGift.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "it", "", "invoke", "(Lcom/facebook/imagepipeline/request/ImageRequestBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ImageRequestBuilder, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            invoke2(imageRequestBuilder);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
            Intrinsics3.checkNotNullParameter(imageRequestBuilder, "it");
            imageRequestBuilder.l = WidgetChatListAdapterItemGift.access$getSPLASH_IMAGE_POSTPROCESSOR$cp();
        }
    }

    /* compiled from: WidgetChatListAdapterItemGift.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            WidgetSettingsPremium.Companion.launch$default(companion, context, null, null, 6, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGift.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Model.Resolved $model;

        public AnonymousClass4(Context context, Model.Resolved resolved) {
            this.$context = context;
            this.$model = resolved;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context context = this.$context;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            UriHandler.handle$default(uriHandler, context, Companion.access$getDiscordStoreURL(WidgetChatListAdapterItemGift.INSTANCE, this.$model.getGift().getSkuId()), false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGift.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$onConfigure$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift) {
            super(1, widgetChatListAdapterItemGift, WidgetChatListAdapterItemGift.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetChatListAdapterItemGift.access$configureUI((WidgetChatListAdapterItemGift) this.receiver, model);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGift.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetChatListAdapterItemGift.access$configureInvalidUI(WidgetChatListAdapterItemGift.this, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGift.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$onConfigure$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGift.access$setSubscription$p(WidgetChatListAdapterItemGift.this, subscription);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGift(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_gift, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.barrier;
        Barrier barrier = (Barrier) view.findViewById(R.id.barrier);
        if (barrier != null) {
            i = R.id.buttonsContainer;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.buttonsContainer);
            if (frameLayout != null) {
                i = R.id.item_gift_accept_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.item_gift_accept_button);
                if (materialButton != null) {
                    i = R.id.item_gift_cannot_claim_button;
                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.item_gift_cannot_claim_button);
                    if (materialButton2 != null) {
                        i = R.id.item_gift_details;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.item_gift_details);
                        if (linearLayout != null) {
                            i = R.id.item_gift_expires;
                            TextView textView = (TextView) view.findViewById(R.id.item_gift_expires);
                            if (textView != null) {
                                i = R.id.item_gift_header;
                                TextView textView2 = (TextView) view.findViewById(R.id.item_gift_header);
                                if (textView2 != null) {
                                    i = R.id.item_gift_image;
                                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.item_gift_image);
                                    if (simpleDraweeView != null) {
                                        i = R.id.item_gift_image_background;
                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R.id.item_gift_image_background);
                                        if (simpleDraweeView2 != null) {
                                            i = R.id.item_gift_loading_button_placeholder;
                                            View viewFindViewById = view.findViewById(R.id.item_gift_loading_button_placeholder);
                                            if (viewFindViewById != null) {
                                                i = R.id.item_gift_name;
                                                TextView textView3 = (TextView) view.findViewById(R.id.item_gift_name);
                                                if (textView3 != null) {
                                                    i = R.id.item_gift_open_button;
                                                    MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.item_gift_open_button);
                                                    if (materialButton3 != null) {
                                                        i = R.id.item_gift_subtext;
                                                        TextView textView4 = (TextView) view.findViewById(R.id.item_gift_subtext);
                                                        if (textView4 != null) {
                                                            i = R.id.item_gift_verify_button;
                                                            MaterialButton materialButton4 = (MaterialButton) view.findViewById(R.id.item_gift_verify_button);
                                                            if (materialButton4 != null) {
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                WidgetChatListAdapterItemGiftBinding widgetChatListAdapterItemGiftBinding = new WidgetChatListAdapterItemGiftBinding(constraintLayout, barrier, frameLayout, materialButton, materialButton2, linearLayout, textView, textView2, simpleDraweeView, simpleDraweeView2, viewFindViewById, textView3, materialButton3, textView4, materialButton4, constraintLayout);
                                                                Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGiftBinding, "WidgetChatListAdapterIte…iftBinding.bind(itemView)");
                                                                this.binding = widgetChatListAdapterItemGiftBinding;
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureInvalidUI(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift, Model.Invalid invalid) {
        widgetChatListAdapterItemGift.configureInvalidUI(invalid);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift, Model model) {
        widgetChatListAdapterItemGift.configureUI(model);
    }

    public static final /* synthetic */ GiftEntry access$getItem$p(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift) {
        GiftEntry giftEntry = widgetChatListAdapterItemGift.item;
        if (giftEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        return giftEntry;
    }

    public static final /* synthetic */ GrayscalePostprocessor access$getSPLASH_IMAGE_POSTPROCESSOR$cp() {
        return SPLASH_IMAGE_POSTPROCESSOR;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift) {
        return widgetChatListAdapterItemGift.subscription;
    }

    public static final /* synthetic */ void access$setItem$p(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift, GiftEntry giftEntry) {
        widgetChatListAdapterItemGift.item = giftEntry;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift, Subscription subscription) {
        widgetChatListAdapterItemGift.subscription = subscription;
    }

    private final void configureInvalidUI(Model.Invalid model) {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        boolean zAreEqual = Intrinsics3.areEqual(model != null ? model.getGifterUserId() : null, model != null ? Long.valueOf(model.getMeId()) : null);
        SimpleDraweeView simpleDraweeView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemGiftImageBackground");
        simpleDraweeView.setVisibility(4);
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        FormatUtils.o(textView, zAreEqual ? context.getString(R.string.gift_embed_invalid_title_self) : context.getString(R.string.gift_embed_invalid_title_other), new Object[0], null, 4);
        TextView textView2 = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        FormatUtils.n(textView2, R.string.gift_embed_invalid, new Object[0], null, 4);
        this.binding.j.setTextColor(ColorCompat.getColor(context, R.color.status_red_500));
        this.binding.j.setBackgroundResource(0);
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        this.binding.g.setImageResource(DrawableCompat.getThemedDrawableRes(context, R.attr.img_poop, R.drawable.img_poop_dark));
        TextView textView3 = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemGiftSubtext");
        textView3.setVisibility(8);
        TextView textView4 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
        textView4.setVisibility(8);
        MaterialButton materialButton = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGiftAcceptButton");
        materialButton.setVisibility(8);
        MaterialButton materialButton2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemGiftCannotClaimButton");
        materialButton2.setVisibility(8);
        View view2 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.itemGiftLoadingButtonPlaceholder");
        view2.setVisibility(8);
        this.itemView.setOnClickListener(null);
    }

    private final void configureLoadingUI() {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        FormatUtils.n(textView, R.string.gift_embed_resolving, new Object[0], null, 4);
        TextView textView2 = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        textView2.setText((CharSequence) null);
        this.binding.j.setTextColor(ColorCompat.getThemedColor(context, R.attr.primary_100));
        this.binding.j.setBackgroundResource(R.drawable.drawable_empty_text_placeholder_dark);
        this.binding.g.setActualImageResource(R.drawable.drawable_empty_text_placeholder_dark);
        SimpleDraweeView simpleDraweeView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemGiftImageBackground");
        simpleDraweeView.setVisibility(4);
        TextView textView3 = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemGiftSubtext");
        textView3.setVisibility(8);
        TextView textView4 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
        textView4.setVisibility(8);
        MaterialButton materialButton = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGiftAcceptButton");
        materialButton.setVisibility(8);
        MaterialButton materialButton2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemGiftCannotClaimButton");
        materialButton2.setVisibility(8);
        View view2 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.itemGiftLoadingButtonPlaceholder");
        view2.setVisibility(0);
        this.itemView.setOnClickListener(null);
    }

    private final void configureResolvedUI(Model.Resolved model) {
        String applicationIcon$default;
        ModelSku sku;
        Application application;
        String icon;
        ModelSku sku2;
        String string;
        MaterialButton materialButton;
        ModelSku sku3;
        ModelSku sku4;
        Application application2;
        ModelSku sku5;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        User user = model.getGift().getUser();
        boolean z2 = user != null && user.getId() == model.getMeUser().getId();
        boolean zIsClaimedByMe = model.getGift().isClaimedByMe();
        boolean z3 = model.getGift().getUses() == model.getGift().getMaxUses();
        boolean z4 = (model.getInLibrary() || z3 || model.getRedeeming() || !model.getMeUser().isVerified() || zIsClaimedByMe) ? false : true;
        IconUtils iconUtils = IconUtils.INSTANCE;
        ModelStoreListing storeListing = model.getGift().getStoreListing();
        long applicationId = (storeListing == null || (sku5 = storeListing.getSku()) == null) ? 0L : sku5.getApplicationId();
        ModelStoreListing storeListing2 = model.getGift().getStoreListing();
        String splash = (storeListing2 == null || (sku4 = storeListing2.getSku()) == null || (application2 = sku4.getApplication()) == null) ? null : application2.getSplash();
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        String giftSplashUrl = iconUtils.getGiftSplashUrl(applicationId, splash, Integer.valueOf(view2.getWidth()));
        if (model.getGift().isAnyNitroGift()) {
            SimpleDraweeView simpleDraweeView = this.binding.h;
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            ModelGift gift = model.getGift();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            simpleDraweeView.setActualImageResource(premiumUtils.getNitroGiftBackground(gift, context));
            SimpleDraweeView simpleDraweeView2 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemGiftImageBackground");
            simpleDraweeView2.setVisibility(0);
        } else if (giftSplashUrl != null) {
            SimpleDraweeView simpleDraweeView3 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemGiftImageBackground");
            MGImages.setImage$default(simpleDraweeView3, giftSplashUrl, 0, 0, false, AnonymousClass1.INSTANCE, null, 92, null);
            SimpleDraweeView simpleDraweeView4 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.itemGiftImageBackground");
            simpleDraweeView4.setVisibility(0);
        } else {
            SimpleDraweeView simpleDraweeView5 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.itemGiftImageBackground");
            simpleDraweeView5.setVisibility(8);
        }
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        FormatUtils.o(textView, z2 ? context.getString(R.string.gift_embed_title_self) : context.getString(R.string.gift_embed_title), new Object[0], null, 4);
        TextView textView2 = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        ModelStoreListing storeListing3 = model.getGift().getStoreListing();
        textView2.setText((storeListing3 == null || (sku3 = storeListing3.getSku()) == null) ? null : sku3.getName());
        this.binding.j.setTextColor(ColorCompat.getThemedColor(context, R.attr.primary_100));
        this.binding.j.setBackgroundResource(0);
        TextView textView3 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemGiftExpires");
        textView3.setVisibility(model.getGift().getExpiresAt() != null ? 0 : 8);
        if (model.getGift().getExpiresAt() != null) {
            TextView textView4 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            textView4.setText(FormatUtils.h(context, R.string.gift_embed_expiration, new Object[]{GiftingUtils.INSTANCE.getTimeString(model.getGift().getExpiresDiff(ClockFactory.get().currentTimeMillis()), context)}, null, 4));
        }
        if (model.getGift().isAnyNitroGift()) {
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView6 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.itemGiftImage");
            MGImages.setImage$default(mGImages, simpleDraweeView6, PremiumUtils.INSTANCE.getNitroGiftIcon(model.getGift()), (MGImages.ChangeDetector) null, 4, (Object) null);
        } else {
            ModelStoreListing storeListing4 = model.getGift().getStoreListing();
            if (storeListing4 == null || (sku = storeListing4.getSku()) == null || (application = sku.getApplication()) == null || (icon = application.getIcon()) == null) {
                applicationIcon$default = null;
            } else {
                ModelStoreListing storeListing5 = model.getGift().getStoreListing();
                applicationIcon$default = IconUtils.getApplicationIcon$default((storeListing5 == null || (sku2 = storeListing5.getSku()) == null) ? 0L : sku2.getApplicationId(), icon, 0, 4, (Object) null);
            }
            this.binding.g.setImageURI(applicationIcon$default);
        }
        if (!model.getMeUser().isVerified()) {
            String string2 = context.getString(R.string.gift_code_auth_help_text_verification_required);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…xt_verification_required)");
            string = StringsJVM.replace$default(StringsJVM.replace$default(StringsJVM.replace$default(string2, "(onClick)", "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
        } else if (zIsClaimedByMe) {
            string = context.getString(R.string.gift_embed_body_claimed_self_mobile);
        } else if (model.getInLibrary()) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            string = StringsJVM.replace$default(StringsJVM.replace$default(StringsJVM.replace$default(FormatUtils.h(context, R.string.gift_code_auth_help_text_owned, new Object[]{""}, null, 4).toString(), "()", "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
        } else {
            string = z3 ? context.getString(R.string.gift_code_auth_help_text_claimed) : null;
        }
        TextView textView5 = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.itemGiftSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView5, string);
        if (z4) {
            materialButton = GiftStyle3.hasCustomStyle(model.getGift()) ? this.binding.k : this.binding.c;
            materialButton.setOnClickListener(new WidgetChatListAdapterItemGift2(this, model));
        } else if (model.getMeUser().isVerified()) {
            materialButton = this.binding.d;
            boolean redeeming = model.getRedeeming();
            int i = R.string.gift_embed_button_claimed;
            if (redeeming) {
                i = R.string.gift_embed_button_claiming;
            } else if (!zIsClaimedByMe && model.getInLibrary()) {
                i = R.string.gift_embed_button_owned;
            }
            FormatUtils.n(materialButton, i, new Object[0], null, 4);
        } else {
            materialButton = this.binding.m;
            materialButton.setOnClickListener(WidgetChatListAdapterItemGift6.INSTANCE);
        }
        Intrinsics3.checkNotNullExpressionValue(materialButton, "if (canAccept) {\n      i…}\n        )\n      }\n    }");
        FrameLayout frameLayout = this.binding.f2320b;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.buttonsContainer");
        for (View view3 : ViewGroup.getChildren(frameLayout)) {
            if (view3 == materialButton) {
                ((MaterialButton) view3).setVisibility(0);
            } else {
                view3.setVisibility(8);
            }
        }
        if (model.getGift().isAnyNitroGift()) {
            this.itemView.setOnClickListener(AnonymousClass3.INSTANCE);
        } else {
            this.itemView.setOnClickListener(new AnonymousClass4(context, model));
        }
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Loading) {
            configureLoadingUI();
        } else if (model instanceof Model.Resolved) {
            configureResolvedUI((Model.Resolved) model);
        } else {
            if (!(model instanceof Model.Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            configureInvalidUI((Model.Invalid) model);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GiftEntry giftEntry = (GiftEntry) data;
        this.item = giftEntry;
        ModelProvider modelProvider = ModelProvider.INSTANCE;
        if (giftEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        Observable observableUi = ObservableExtensionsKt.ui(modelProvider.get(giftEntry));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this);
        ObservableExtensionsKt.appSubscribe$default(observableUi, WidgetChatListAdapterItemGift.class, (Context) null, new AnonymousClass3(), new AnonymousClass2(), (Function0) null, (Function0) null, anonymousClass1, 50, (Object) null);
    }
}
