package com.discord.utilities.premium;

import android.content.Context;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.a.b.GuildBoostUpsellDialog;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.api.guild.GuildFeature;
import com.discord.api.premium.PremiumTier;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelStoreListing;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.gifting.GiftStyle;
import com.discord.utilities.gifting.GiftStyle3;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import d0.t.Sets5;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: PremiumUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001mB\t\b\u0002¢\u0006\u0004\bk\u0010lJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\t\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0006*\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\"\u001a\u0004\u0018\u00010\u00172\n\u0010!\u001a\u00060\u0017j\u0002` ¢\u0006\u0004\b\"\u0010#J'\u0010'\u001a\u0004\u0018\u00010%2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b'\u0010(J%\u0010*\u001a\u0004\u0018\u00010\u00112\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110$2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b*\u0010+J\u0015\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u001d\u00103\u001a\u00020\u000e2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000200¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006¢\u0006\u0004\b:\u0010;J\u0015\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u001d\u0010>\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u000e¢\u0006\u0004\b>\u0010AJ\u001d\u0010C\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u000e¢\u0006\u0004\bC\u0010AJ\u0017\u0010F\u001a\u0004\u0018\u00010\u00062\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GJ!\u0010H\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bH\u0010IJ\u001f\u0010K\u001a\u00020\u000e2\b\u0010=\u001a\u0004\u0018\u00010<2\u0006\u0010J\u001a\u00020D¢\u0006\u0004\bK\u0010LJc\u0010W\u001a\u00020V2\b\u0010=\u001a\u0004\u0018\u00010<2\u000e\u0010N\u001a\n\u0018\u00010,j\u0004\u0018\u0001`M2\u0006\u0010E\u001a\u00020D2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010P\u001a\u00020O2\u0016\b\u0002\u0010S\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\u0014\u0018\u00010Q2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T¢\u0006\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020,8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020D0[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020D0[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010]R\u0016\u0010_\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010b\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010e\u001a\u00020d8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010g\u001a\u00020d8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bg\u0010fR\u0016\u0010h\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bh\u0010cR\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020D0[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010]R\u0016\u0010j\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bj\u0010c¨\u0006n"}, d2 = {"Lcom/discord/utilities/premium/PremiumUtils;", "", "Lcom/discord/models/domain/ModelGift;", "gift", "Landroid/content/Context;", "context", "", "getNitroGiftBackground", "(Lcom/discord/models/domain/ModelGift;Landroid/content/Context;)I", "getNitroGiftIcon", "(Lcom/discord/models/domain/ModelGift;)I", "Lcom/discord/models/domain/ModelSku;", "sku", "(Lcom/discord/models/domain/ModelSku;)I", "", "isNitroSku", "(Lcom/discord/models/domain/ModelSku;)Z", "Lcom/discord/models/domain/ModelSubscription;", "getGuildBoostCountFromSubscription", "(Lcom/discord/models/domain/ModelSubscription;)I", "", "openAppleBilling", "(Landroid/content/Context;)V", "", "skuName", "openGooglePlayBilling", "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/android/billingclient/api/SkuDetails;", "skuDetails", "", "getPlanPriceText", "(Landroid/content/Context;Lcom/android/billingclient/api/SkuDetails;)Ljava/lang/CharSequence;", "Lcom/discord/primitives/PaymentGatewaySkuId;", "paymentGatewaySkuId", "getSkuPrice", "(Ljava/lang/String;)Ljava/lang/String;", "", "Lcom/android/billingclient/api/Purchase;", "purchases", "findPurchaseForSkuName", "(Ljava/util/List;Ljava/lang/String;)Lcom/android/billingclient/api/Purchase;", "subscriptions", "findSubscriptionForSku", "(Ljava/util/List;Ljava/lang/String;)Lcom/discord/models/domain/ModelSubscription;", "", "amount", "microAmountToMinor", "(J)I", "Lcom/discord/api/premium/PremiumTier;", "premiumTier", "minimumLevel", "isPremiumTierAtLeast", "(Lcom/discord/api/premium/PremiumTier;Lcom/discord/api/premium/PremiumTier;)Z", "Lcom/discord/models/user/User;", "user", "getMaxFileSizeMB", "(Lcom/discord/models/user/User;)I", "guildPremiumTier", "getGuildMaxFileSizeMB", "(I)I", "Lcom/discord/models/guild/Guild;", "guild", "getGuildEmojiMaxCount", "(Lcom/discord/models/guild/Guild;)I", "hasMoreEmoji", "(IZ)I", "hasMoreSticker", "getGuildStickerMaxCount", "Lcom/discord/api/guild/GuildFeature;", "guildFeature", "getMinimumBoostTierForGuildFeature", "(Lcom/discord/api/guild/GuildFeature;)Ljava/lang/Integer;", "getBoostTierShortText", "(Landroid/content/Context;Ljava/lang/Integer;)Ljava/lang/CharSequence;", "feature", "doesGuildHaveEnoughBoostsForFeature", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/guild/GuildFeature;)Z", "Lcom/discord/primitives/ChannelId;", "channelId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function1;", "Landroid/view/View;", "onEnabledClickListener", "Lcom/discord/utilities/analytics/Traits$Location;", "locationTrait", "Lcom/discord/utilities/premium/PremiumUtils$BoostFeatureBadgeData;", "getBoostFeatureBadgeDataForGuildFeature", "(Lcom/discord/models/guild/Guild;Ljava/lang/Long;Lcom/discord/api/guild/GuildFeature;Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function1;Lcom/discord/utilities/analytics/Traits$Location;)Lcom/discord/utilities/premium/PremiumUtils$BoostFeatureBadgeData;", "PREMIUM_APPLICATION_ID", "J", "", "tier3BoostFeatures", "Ljava/util/Set;", "tier1BoostFeatures", "MONTHLY_ISO8601", "Ljava/lang/String;", "YEARLY_ISO8601", "MAX_PREMIUM_GUILD_COUNT", "I", "", "GUILD_BOOST_FOR_PREMIUM_USER_DISCOUNT_PERCENT", "F", "PREMIUM_YEARLY_DISCOUNT_PERCENT", "NUM_FREE_GUILD_BOOSTS_WITH_PREMIUM", "tier2BoostFeatures", "MAX_NON_PREMIUM_GUILD_COUNT", "<init>", "()V", "BoostFeatureBadgeData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PremiumUtils {
    public static final float GUILD_BOOST_FOR_PREMIUM_USER_DISCOUNT_PERCENT = 0.3f;
    public static final PremiumUtils INSTANCE = new PremiumUtils();
    public static final int MAX_NON_PREMIUM_GUILD_COUNT = 100;
    public static final int MAX_PREMIUM_GUILD_COUNT = 200;
    private static final String MONTHLY_ISO8601 = "P1M";
    public static final int NUM_FREE_GUILD_BOOSTS_WITH_PREMIUM = 2;
    public static final long PREMIUM_APPLICATION_ID = 521842831262875670L;
    public static final float PREMIUM_YEARLY_DISCOUNT_PERCENT = 0.16f;
    private static final String YEARLY_ISO8601 = "P1Y";
    private static final Set<GuildFeature> tier1BoostFeatures;
    private static final Set<GuildFeature> tier2BoostFeatures;
    private static final Set<GuildFeature> tier3BoostFeatures;

    /* compiled from: PremiumUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\r\u0010\tJF\u0010\u0012\u001a\u00020\u00002\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0017\u0010\tJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\tR\u0019\u0010\u0011\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001e\u0010\tR'\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u0006R\u0019\u0010\u0010\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\f¨\u0006%"}, d2 = {"Lcom/discord/utilities/premium/PremiumUtils$BoostFeatureBadgeData;", "", "Lkotlin/Function1;", "Landroid/view/View;", "", "component1", "()Lkotlin/jvm/functions/Function1;", "", "component2", "()I", "", "component3", "()Ljava/lang/CharSequence;", "component4", "onClickListener", "iconColor", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "textColor", "copy", "(Lkotlin/jvm/functions/Function1;ILjava/lang/CharSequence;I)Lcom/discord/utilities/premium/PremiumUtils$BoostFeatureBadgeData;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getIconColor", "getTextColor", "Lkotlin/jvm/functions/Function1;", "getOnClickListener", "Ljava/lang/CharSequence;", "getText", "<init>", "(Lkotlin/jvm/functions/Function1;ILjava/lang/CharSequence;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class BoostFeatureBadgeData {
        private final int iconColor;
        private final Function1<View, Unit> onClickListener;
        private final CharSequence text;
        private final int textColor;

        /* JADX WARN: Multi-variable type inference failed */
        public BoostFeatureBadgeData(Function1<? super View, Unit> function1, int i, CharSequence charSequence, int i2) {
            Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.onClickListener = function1;
            this.iconColor = i;
            this.text = charSequence;
            this.textColor = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BoostFeatureBadgeData copy$default(BoostFeatureBadgeData boostFeatureBadgeData, Function1 function1, int i, CharSequence charSequence, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                function1 = boostFeatureBadgeData.onClickListener;
            }
            if ((i3 & 2) != 0) {
                i = boostFeatureBadgeData.iconColor;
            }
            if ((i3 & 4) != 0) {
                charSequence = boostFeatureBadgeData.text;
            }
            if ((i3 & 8) != 0) {
                i2 = boostFeatureBadgeData.textColor;
            }
            return boostFeatureBadgeData.copy(function1, i, charSequence, i2);
        }

        public final Function1<View, Unit> component1() {
            return this.onClickListener;
        }

        /* renamed from: component2, reason: from getter */
        public final int getIconColor() {
            return this.iconColor;
        }

        /* renamed from: component3, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        /* renamed from: component4, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        public final BoostFeatureBadgeData copy(Function1<? super View, Unit> onClickListener, int iconColor, CharSequence text, int textColor) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            return new BoostFeatureBadgeData(onClickListener, iconColor, text, textColor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BoostFeatureBadgeData)) {
                return false;
            }
            BoostFeatureBadgeData boostFeatureBadgeData = (BoostFeatureBadgeData) other;
            return Intrinsics3.areEqual(this.onClickListener, boostFeatureBadgeData.onClickListener) && this.iconColor == boostFeatureBadgeData.iconColor && Intrinsics3.areEqual(this.text, boostFeatureBadgeData.text) && this.textColor == boostFeatureBadgeData.textColor;
        }

        public final int getIconColor() {
            return this.iconColor;
        }

        public final Function1<View, Unit> getOnClickListener() {
            return this.onClickListener;
        }

        public final CharSequence getText() {
            return this.text;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public int hashCode() {
            Function1<View, Unit> function1 = this.onClickListener;
            int iHashCode = (((function1 != null ? function1.hashCode() : 0) * 31) + this.iconColor) * 31;
            CharSequence charSequence = this.text;
            return ((iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31) + this.textColor;
        }

        public String toString() {
            StringBuilder sbU = outline.U("BoostFeatureBadgeData(onClickListener=");
            sbU.append(this.onClickListener);
            sbU.append(", iconColor=");
            sbU.append(this.iconColor);
            sbU.append(", text=");
            sbU.append(this.text);
            sbU.append(", textColor=");
            return outline.B(sbU, this.textColor, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ModelSku.SkuCategory.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ModelSku.SkuCategory.NITRO_CLASSIC.ordinal()] = 1;
            iArr[ModelSku.SkuCategory.NITRO.ordinal()] = 2;
        }
    }

    /* compiled from: PremiumUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.premium.PremiumUtils$getBoostFeatureBadgeDataForGuildFeature$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ Guild $guild;
        public final /* synthetic */ Traits.Location $locationTrait;
        public final /* synthetic */ Integer $minimumBoostTier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Guild guild, FragmentManager fragmentManager, Integer num, Traits.Location location, Long l) {
            super(1);
            this.$guild = guild;
            this.$fragmentManager = fragmentManager;
            this.$minimumBoostTier = num;
            this.$locationTrait = location;
            this.$channelId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            Guild guild = this.$guild;
            if (guild != null) {
                GuildBoostUpsellDialog.INSTANCE.a(this.$fragmentManager, guild.getId(), this.$channelId, this.$minimumBoostTier, this.$locationTrait);
            }
        }
    }

    static {
        Set<GuildFeature> of = Sets5.setOf((Object[]) new GuildFeature[]{GuildFeature.INVITE_SPLASH, GuildFeature.ANIMATED_ICON});
        tier1BoostFeatures = of;
        Set<GuildFeature> setPlus = _Sets.plus((Set) of, (Iterable) Sets5.setOf((Object[]) new GuildFeature[]{GuildFeature.BANNER, GuildFeature.PRIVATE_THREADS, GuildFeature.ROLE_ICONS}));
        tier2BoostFeatures = setPlus;
        tier3BoostFeatures = _Sets.plus((Set) setPlus, (Iterable) Sets5.setOf((Object[]) new GuildFeature[]{GuildFeature.VANITY_URL, GuildFeature.ANIMATED_BANNER}));
    }

    private PremiumUtils() {
    }

    public static /* synthetic */ BoostFeatureBadgeData getBoostFeatureBadgeDataForGuildFeature$default(PremiumUtils premiumUtils, Guild guild, Long l, GuildFeature guildFeature, Context context, FragmentManager fragmentManager, Function1 function1, Traits.Location location, int i, Object obj) {
        return premiumUtils.getBoostFeatureBadgeDataForGuildFeature(guild, l, guildFeature, context, fragmentManager, (i & 32) != 0 ? null : function1, (i & 64) != 0 ? null : location);
    }

    public final boolean doesGuildHaveEnoughBoostsForFeature(Guild guild, GuildFeature feature) {
        Intrinsics3.checkNotNullParameter(feature, "feature");
        int premiumTier = guild != null ? guild.getPremiumTier() : -1;
        Integer minimumBoostTierForGuildFeature = getMinimumBoostTierForGuildFeature(feature);
        return premiumTier >= (minimumBoostTierForGuildFeature != null ? minimumBoostTierForGuildFeature.intValue() : 0);
    }

    public final Purchase findPurchaseForSkuName(List<? extends Purchase> purchases, String skuName) {
        Intrinsics3.checkNotNullParameter(skuName, "skuName");
        Object obj = null;
        if (purchases == null) {
            return null;
        }
        Iterator<T> it = purchases.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Purchase) next).b().contains(skuName)) {
                obj = next;
                break;
            }
        }
        return (Purchase) obj;
    }

    public final ModelSubscription findSubscriptionForSku(List<ModelSubscription> subscriptions, String skuName) {
        Object next;
        Intrinsics3.checkNotNullParameter(subscriptions, "subscriptions");
        Intrinsics3.checkNotNullParameter(skuName, "skuName");
        Iterator<T> it = subscriptions.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics3.areEqual(((ModelSubscription) next).getPaymentGatewayPlanId(), skuName)) {
                break;
            }
        }
        return (ModelSubscription) next;
    }

    public final BoostFeatureBadgeData getBoostFeatureBadgeDataForGuildFeature(Guild guild, Long channelId, GuildFeature guildFeature, Context context, FragmentManager fragmentManager, Function1<? super View, Unit> onEnabledClickListener, Traits.Location locationTrait) {
        Intrinsics3.checkNotNullParameter(guildFeature, "guildFeature");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (guild != null && guild.hasFeature(guildFeature)) {
            String string = context.getString(R.string.guild_settings_premium_guild_unlocked);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…s_premium_guild_unlocked)");
            return new BoostFeatureBadgeData(onEnabledClickListener, ColorCompat.getColor(context, R.color.guild_boosting_pink), string, ColorCompat.getThemedColor(context, R.attr.colorTextNormal));
        }
        Integer minimumBoostTierForGuildFeature = getMinimumBoostTierForGuildFeature(guildFeature);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(guild, fragmentManager, minimumBoostTierForGuildFeature, locationTrait, channelId);
        CharSequence boostTierShortText = getBoostTierShortText(context, minimumBoostTierForGuildFeature);
        if (boostTierShortText == null) {
            boostTierShortText = "";
        }
        return new BoostFeatureBadgeData(anonymousClass1, ColorCompat.getThemedColor(context, R.attr.colorInteractiveNormal), boostTierShortText, ColorCompat.getThemedColor(context, R.attr.colorTextMuted));
    }

    public final CharSequence getBoostTierShortText(Context context, Integer premiumTier) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (premiumTier != null && premiumTier.intValue() == 1) {
            return FormatUtils.h(context, R.string.premium_guild_tier_1_short, new Object[0], null, 4);
        }
        if (premiumTier != null && premiumTier.intValue() == 2) {
            return FormatUtils.h(context, R.string.premium_guild_tier_2_short, new Object[0], null, 4);
        }
        if (premiumTier != null && premiumTier.intValue() == 3) {
            return FormatUtils.h(context, R.string.premium_guild_tier_3_short, new Object[0], null, 4);
        }
        return null;
    }

    public final int getGuildBoostCountFromSubscription(ModelSubscription modelSubscription) {
        Intrinsics3.checkNotNullParameter(modelSubscription, "$this$getGuildBoostCountFromSubscription");
        return (modelSubscription.getPremiumBasePlanId() == SubscriptionPlanType.PREMIUM_MONTH_TIER_2.getPlanId() || modelSubscription.getPremiumBasePlanId() == SubscriptionPlanType.PREMIUM_YEAR_TIER_2.getPlanId() || modelSubscription.getPremiumBasePlanId() == SubscriptionPlanType.PREMIUM_3_MONTH_TIER_2.getPlanId() || modelSubscription.getPremiumBasePlanId() == SubscriptionPlanType.PREMIUM_6_MONTH_TIER_2.getPlanId()) ? 2 : 0;
    }

    public final int getGuildEmojiMaxCount(int guildPremiumTier, boolean hasMoreEmoji) {
        if (hasMoreEmoji && guildPremiumTier <= 2) {
            return 200;
        }
        if (guildPremiumTier == 1) {
            return 100;
        }
        if (guildPremiumTier != 2) {
            return guildPremiumTier != 3 ? 50 : 250;
        }
        return 150;
    }

    public final int getGuildEmojiMaxCount(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        return getGuildEmojiMaxCount(guild.getPremiumTier(), guild.getFeatures().contains(GuildFeature.MORE_EMOJI));
    }

    public final int getGuildMaxFileSizeMB(int guildPremiumTier) {
        if (guildPremiumTier == 0 || guildPremiumTier == 1) {
            return 8;
        }
        return guildPremiumTier != 2 ? 100 : 50;
    }

    public final int getGuildStickerMaxCount(int guildPremiumTier, boolean hasMoreSticker) {
        if (hasMoreSticker && guildPremiumTier <= 2) {
            return 60;
        }
        if (guildPremiumTier == 1) {
            return 15;
        }
        if (guildPremiumTier != 2) {
            return guildPremiumTier != 3 ? 0 : 60;
        }
        return 30;
    }

    public final int getMaxFileSizeMB(User user) {
        if (user != null && UserUtils.INSTANCE.isStaff(user)) {
            return 200;
        }
        if ((user != null ? user.getPremiumTier() : null) == PremiumTier.TIER_1) {
            return 50;
        }
        if ((user != null ? user.getPremiumTier() : null) == PremiumTier.TIER_2) {
            return 100;
        }
        return (user != null ? user.getPremiumTier() : null) == PremiumTier.TIER_0 ? 20 : 8;
    }

    public final Integer getMinimumBoostTierForGuildFeature(GuildFeature guildFeature) {
        Intrinsics3.checkNotNullParameter(guildFeature, "guildFeature");
        if (tier1BoostFeatures.contains(guildFeature)) {
            return 1;
        }
        if (tier2BoostFeatures.contains(guildFeature)) {
            return 2;
        }
        return tier3BoostFeatures.contains(guildFeature) ? 3 : null;
    }

    @DrawableRes
    public final int getNitroGiftBackground(ModelGift gift, Context context) {
        Intrinsics3.checkNotNullParameter(gift, "gift");
        Intrinsics3.checkNotNullParameter(context, "context");
        return GiftStyle3.hasCustomStyle(gift) ? ColorCompat.getThemedColor(context, R.attr.colorBackgroundSecondaryAlt) : DrawableCompat.getThemedDrawableRes(context, R.attr.gift_nitro_splash, R.drawable.img_nitro_splash_dark);
    }

    @DrawableRes
    public final int getNitroGiftIcon(ModelGift gift) {
        Intrinsics3.checkNotNullParameter(gift, "gift");
        GiftStyle customStyle = GiftStyle3.getCustomStyle(gift);
        if (customStyle != null) {
            return customStyle.getStaticRes();
        }
        ModelStoreListing storeListing = gift.getStoreListing();
        return getNitroGiftIcon(storeListing != null ? storeListing.getSku() : null);
    }

    public final CharSequence getPlanPriceText(Context context, SkuDetails skuDetails) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
        String strOptString = skuDetails.f2006b.optString("subscriptionPeriod");
        int iHashCode = strOptString.hashCode();
        if (iHashCode != 78476) {
            if (iHashCode == 78488 && strOptString.equals(YEARLY_ISO8601)) {
                return FormatUtils.h(context, R.string.billing_price_per_year, new Object[]{skuDetails.b()}, null, 4);
            }
        } else if (strOptString.equals(MONTHLY_ISO8601)) {
            return FormatUtils.h(context, R.string.billing_price_per_month, new Object[]{skuDetails.b()}, null, 4);
        }
        return "";
    }

    public final String getSkuPrice(String paymentGatewaySkuId) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        StoreGooglePlaySkuDetails.State state = StoreStream.INSTANCE.getGooglePlaySkuDetails().getSkuStateSnapshot();
        if (!(state instanceof StoreGooglePlaySkuDetails.State.Loaded)) {
            Logger.w$default(AppLog.g, outline.w("SkuDetails not loaded. Unable to get price for sku id ", paymentGatewaySkuId), null, 2, null);
            return null;
        }
        SkuDetails skuDetails = ((StoreGooglePlaySkuDetails.State.Loaded) state).getSkuDetails().get(paymentGatewaySkuId);
        if (skuDetails != null) {
            return skuDetails.b();
        }
        return null;
    }

    public final boolean isNitroSku(ModelSku sku) {
        Intrinsics3.checkNotNullParameter(sku, "sku");
        return sku.getSkuCategory() == ModelSku.SkuCategory.NITRO_CLASSIC || sku.getSkuCategory() == ModelSku.SkuCategory.NITRO;
    }

    public final boolean isPremiumTierAtLeast(PremiumTier premiumTier, PremiumTier minimumLevel) {
        Intrinsics3.checkNotNullParameter(premiumTier, "premiumTier");
        Intrinsics3.checkNotNullParameter(minimumLevel, "minimumLevel");
        return premiumTier.ordinal() >= minimumLevel.ordinal();
    }

    public final int microAmountToMinor(long amount) {
        return (int) (amount / 10000);
    }

    public final void openAppleBilling(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        UriHandler.handle$default(UriHandler.INSTANCE, context, FormatUtils.h(context, R.string.apple_billing_url, new Object[0], null, 4).toString(), false, false, null, 28, null);
    }

    public final void openGooglePlayBilling(Context context, String skuName) {
        String strP;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (skuName == null || (strP = outline.P(new Object[]{skuName, context.getPackageName()}, 2, GooglePlayBillingManager.PLAY_STORE_SUBSCRIPTION_DEEPLINK_URL, "java.lang.String.format(this, *args)")) == null) {
            strP = GooglePlayBillingManager.PLAY_STORE_SUBSCRIPTION_URL;
        }
        UriHandler.handle$default(UriHandler.INSTANCE, context, strP, false, false, null, 28, null);
    }

    @DrawableRes
    public final int getNitroGiftIcon(ModelSku sku) {
        ModelSku.SkuCategory skuCategory = sku != null ? sku.getSkuCategory() : null;
        if (skuCategory != null) {
            int iOrdinal = skuCategory.ordinal();
            if (iOrdinal == 1) {
                return R.drawable.drawable_ic_nitro;
            }
            if (iOrdinal == 2) {
                return R.drawable.drawable_ic_nitro_classic;
            }
        }
        return 0;
    }
}
