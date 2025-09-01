package com.discord.widgets.guild_role_subscriptions;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: GuildRoleSubscriptionUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b5\u00106JI\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ]\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0095\u0001\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0004\b#\u0010$Jç\u0001\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001d2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012¢\u0006\u0004\b'\u0010(JA\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+J«\u0001\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010,\u001a\u0004\u0018\u00010\t2\b\u0010-\u001a\u0004\u0018\u00010\t2\b\u0010.\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0004\b0\u00101JU\u00103\u001a\b\u0012\u0004\u0012\u0002020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\t2\b\u0010-\u001a\u0004\u0018\u00010\t2\b\u0010.\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/GuildRoleSubscriptionUtils;", "", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "memberColor", "", "memberIcon", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "guildRoleSubscriptionTierListing", "Lrx/Observable;", "updateGuildRoleSubscriptionDesign", "(Lcom/discord/utilities/rest/RestAPI;JLjava/lang/Integer;Ljava/lang/String;Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)Lrx/Observable;", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lcom/discord/nullserializable/NullSerializable;", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "trialInterval", "activeTrialUserLimit", "updateGuildRoleSubscriptionTrial", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuildRoleSubscriptions;JLcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;)Lrx/Observable;", "groupListingId", "tierName", "tierDescription", "priceTier", "tierImage", "", "canAccessAllChannels", "", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "channelBenefits", "intangibleBenefits", "createGuildRoleSubscriptionTierListing", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuildRoleSubscriptions;JJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ZLjava/util/List;Ljava/util/List;)Lrx/Observable;", "tierListingId", "published", "updateGuildRoleSubscriptionTierListing", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuildRoleSubscriptions;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Lcom/discord/nullserializable/NullSerializable;Lcom/discord/nullserializable/NullSerializable;)Lrx/Observable;", "Ljava/lang/Void;", "deleteGuildRoleSubscriptionTierListing", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuildRoleSubscriptions;JJJ)Lrx/Observable;", "coverImage", "planDescription", "isFullServerGating", "memberBadge", "createGuildRoleSubscriptionGroupListing", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuildRoleSubscriptions;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ZLjava/util/List;Ljava/util/List;)Lrx/Observable;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "updateGuildRoleSubscriptionGroupListing", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuildRoleSubscriptions;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionUtils {
    public static final GuildRoleSubscriptionUtils INSTANCE = new GuildRoleSubscriptionUtils();

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "kotlin.jvm.PlatformType", "subscriptionGroupListing", "Lrx/Observable;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$createGuildRoleSubscriptionGroupListing$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<GuildRoleSubscriptionGroupListing, Observable<? extends GuildRoleSubscriptionTierListing>> {
        public final /* synthetic */ boolean $canAccessAllChannels;
        public final /* synthetic */ List $channelBenefits;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ List $intangibleBenefits;
        public final /* synthetic */ String $memberBadge;
        public final /* synthetic */ int $memberColor;
        public final /* synthetic */ int $priceTier;
        public final /* synthetic */ RestAPI $restApi;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
        public final /* synthetic */ String $tierDescription;
        public final /* synthetic */ String $tierImage;
        public final /* synthetic */ String $tierName;

        public AnonymousClass1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, RestAPI restAPI, String str, String str2, int i, String str3, int i2, String str4, boolean z2, List list, List list2) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
            this.$restApi = restAPI;
            this.$tierName = str;
            this.$tierDescription = str2;
            this.$priceTier = i;
            this.$tierImage = str3;
            this.$memberColor = i2;
            this.$memberBadge = str4;
            this.$canAccessAllChannels = z2;
            this.$channelBenefits = list;
            this.$intangibleBenefits = list2;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            return call2(guildRoleSubscriptionGroupListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends GuildRoleSubscriptionTierListing> call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionGroupListing, "subscriptionGroupListing");
            storeGuildRoleSubscriptions.handleGuildRoleSubscriptionGroupUpdate(j, guildRoleSubscriptionGroupListing);
            return GuildRoleSubscriptionUtils.INSTANCE.createGuildRoleSubscriptionTierListing(this.$restApi, this.$storeGuildRoleSubscriptions, this.$guildId, guildRoleSubscriptionGroupListing.getId(), this.$tierName, this.$tierDescription, this.$priceTier, this.$tierImage, this.$memberColor, this.$memberBadge, this.$canAccessAllChannels, this.$channelBenefits, this.$intangibleBenefits);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "kotlin.jvm.PlatformType", "guildRoleSubscriptionTierListing", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$createGuildRoleSubscriptionTierListing$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ int $memberColor;
        public final /* synthetic */ String $memberIcon;
        public final /* synthetic */ RestAPI $restApi;

        public AnonymousClass1(RestAPI restAPI, long j, int i, String str) {
            this.$restApi = restAPI;
            this.$guildId = j;
            this.$memberColor = i;
            this.$memberIcon = str;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            return call2(guildRoleSubscriptionTierListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends GuildRoleSubscriptionTierListing> call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
            RestAPI restAPI = this.$restApi;
            long j = this.$guildId;
            Integer numValueOf = Integer.valueOf(this.$memberColor);
            String str = this.$memberIcon;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
            return GuildRoleSubscriptionUtils.access$updateGuildRoleSubscriptionDesign(guildRoleSubscriptionUtils, restAPI, j, numValueOf, str, guildRoleSubscriptionTierListing);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "kotlin.jvm.PlatformType", "tierListing", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$createGuildRoleSubscriptionTierListing$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<GuildRoleSubscriptionTierListing> {
        public final /* synthetic */ long $groupListingId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

        public AnonymousClass2(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
            this.$groupListingId = j2;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            call2(guildRoleSubscriptionTierListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            long j2 = this.$groupListingId;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "tierListing");
            storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierListingCreate(j, j2, guildRoleSubscriptionTierListing);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$deleteGuildRoleSubscriptionTierListing$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Void> {
        public final /* synthetic */ long $groupListingId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
        public final /* synthetic */ long $tierListingId;

        public AnonymousClass1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2, long j3) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
            this.$groupListingId = j2;
            this.$tierListingId = j3;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r8) {
            this.$storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierListingDelete(this.$guildId, this.$groupListingId, this.$tierListingId);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Void;", "it", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionDesign$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Void, GuildRoleSubscriptionTierListing> {
        public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;

        public AnonymousClass1(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildRoleSubscriptionTierListing call(Void r1) {
            return call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildRoleSubscriptionTierListing call2(Void r1) {
            return this.$guildRoleSubscriptionTierListing;
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "kotlin.jvm.PlatformType", "groupListing", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionGroupListing$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<GuildRoleSubscriptionGroupListing> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

        public AnonymousClass1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            call2(guildRoleSubscriptionGroupListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionGroupListing, "groupListing");
            storeGuildRoleSubscriptions.handleGuildRoleSubscriptionGroupUpdate(j, guildRoleSubscriptionGroupListing);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "kotlin.jvm.PlatformType", "guildRoleSubscriptionTierListing", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Integer $memberColor;
        public final /* synthetic */ String $memberIcon;
        public final /* synthetic */ RestAPI $restApi;

        public AnonymousClass2(RestAPI restAPI, long j, Integer num, String str) {
            this.$restApi = restAPI;
            this.$guildId = j;
            this.$memberColor = num;
            this.$memberIcon = str;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            return call2(guildRoleSubscriptionTierListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends GuildRoleSubscriptionTierListing> call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
            RestAPI restAPI = this.$restApi;
            long j = this.$guildId;
            Integer num = this.$memberColor;
            String str = this.$memberIcon;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
            return GuildRoleSubscriptionUtils.access$updateGuildRoleSubscriptionDesign(guildRoleSubscriptionUtils, restAPI, j, num, str, guildRoleSubscriptionTierListing);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "kotlin.jvm.PlatformType", "guildRoleSubscriptionTierListing", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<GuildRoleSubscriptionTierListing, Observable<? extends GuildRoleSubscriptionTierListing>> {
        public final /* synthetic */ NullSerializable $activeTrialUserLimit;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ RestAPI $restApi;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
        public final /* synthetic */ NullSerializable $trialInterval;

        public AnonymousClass3(RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, NullSerializable nullSerializable, NullSerializable nullSerializable2) {
            this.$restApi = restAPI;
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
            this.$trialInterval = nullSerializable;
            this.$activeTrialUserLimit = nullSerializable2;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends GuildRoleSubscriptionTierListing> call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            return call2(guildRoleSubscriptionTierListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends GuildRoleSubscriptionTierListing> call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            GuildRoleSubscriptionUtils guildRoleSubscriptionUtils = GuildRoleSubscriptionUtils.INSTANCE;
            RestAPI restAPI = this.$restApi;
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
            return GuildRoleSubscriptionUtils.access$updateGuildRoleSubscriptionTrial(guildRoleSubscriptionUtils, restAPI, storeGuildRoleSubscriptions, j, guildRoleSubscriptionTierListing, this.$trialInterval, this.$activeTrialUserLimit);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTierListing$4, reason: invalid class name */
    public static final class AnonymousClass4<T> implements Action1<GuildRoleSubscriptionTierListing> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

        public AnonymousClass4(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            call2(guildRoleSubscriptionTierListing);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierListing, "it");
            storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierListingUpdate(j, guildRoleSubscriptionTierListing);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTrial$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<GuildRoleSubscriptionTierFreeTrial> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;
        public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

        public AnonymousClass1(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
            this.$guildId = j;
            this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
            call2(guildRoleSubscriptionTierFreeTrial);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
            StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = this.$storeGuildRoleSubscriptions;
            long j = this.$guildId;
            long id2 = this.$guildRoleSubscriptionTierListing.getId();
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionTierFreeTrial, "it");
            storeGuildRoleSubscriptions.handleGuildRoleSubscriptionTierTrialUpdate(j, id2, guildRoleSubscriptionTierFreeTrial);
        }
    }

    /* compiled from: GuildRoleSubscriptionUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;)Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils$updateGuildRoleSubscriptionTrial$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<GuildRoleSubscriptionTierFreeTrial, GuildRoleSubscriptionTierListing> {
        public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;

        public AnonymousClass2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildRoleSubscriptionTierListing call(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
            return call2(guildRoleSubscriptionTierFreeTrial);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildRoleSubscriptionTierListing call2(GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
            return this.$guildRoleSubscriptionTierListing;
        }
    }

    private GuildRoleSubscriptionUtils() {
    }

    public static final /* synthetic */ Observable access$updateGuildRoleSubscriptionDesign(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, long j, Integer num, String str, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign(restAPI, j, num, str, guildRoleSubscriptionTierListing);
    }

    public static final /* synthetic */ Observable access$updateGuildRoleSubscriptionTrial(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, NullSerializable nullSerializable, NullSerializable nullSerializable2) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial(restAPI, storeGuildRoleSubscriptions, j, guildRoleSubscriptionTierListing, nullSerializable, nullSerializable2);
    }

    public static /* synthetic */ Observable createGuildRoleSubscriptionGroupListing$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, String str, String str2, Boolean bool, String str3, String str4, int i, String str5, int i2, String str6, boolean z2, List list, List list2, int i3, Object obj) {
        return guildRoleSubscriptionUtils.createGuildRoleSubscriptionGroupListing(restAPI, storeGuildRoleSubscriptions, j, str, str2, bool, str3, str4, i, (i3 & 512) != 0 ? null : str5, i2, (i3 & 2048) != 0 ? null : str6, z2, list, list2);
    }

    public static /* synthetic */ Observable createGuildRoleSubscriptionTierListing$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2, String str, String str2, int i, String str3, int i2, String str4, boolean z2, List list, List list2, int i3, Object obj) {
        return guildRoleSubscriptionUtils.createGuildRoleSubscriptionTierListing(restAPI, storeGuildRoleSubscriptions, j, j2, str, str2, i, (i3 & 128) != 0 ? null : str3, i2, (i3 & 512) != 0 ? null : str4, z2, list, list2);
    }

    private final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionDesign(RestAPI restApi, long guildId, Integer memberColor, String memberIcon, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Observable observableG = restApi.updateRole(guildId, guildRoleSubscriptionTierListing.getRoleId(), new RestAPIParams.Role(null, null, null, memberColor, null, null, guildRoleSubscriptionTierListing.getRoleId(), memberIcon, 55, null)).G(new AnonymousClass1(guildRoleSubscriptionTierListing));
        Intrinsics3.checkNotNullExpressionValue(observableG, "restApi\n          .updat…onTierListing\n          }");
        return observableG;
    }

    public static /* synthetic */ Observable updateGuildRoleSubscriptionDesign$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, long j, Integer num, String str, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, int i, Object obj) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionDesign(restAPI, j, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str, guildRoleSubscriptionTierListing);
    }

    public static /* synthetic */ Observable updateGuildRoleSubscriptionTierListing$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, long j2, long j3, String str, String str2, String str3, Integer num, Integer num2, String str4, Boolean bool, List list, List list2, Boolean bool2, NullSerializable nullSerializable, NullSerializable nullSerializable2, int i, Object obj) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTierListing(restAPI, storeGuildRoleSubscriptions, j, j2, j3, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : str4, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : list, (i & 8192) != 0 ? null : list2, (i & 16384) != 0 ? null : bool2, (32768 & i) != 0 ? null : nullSerializable, (i & 65536) != 0 ? null : nullSerializable2);
    }

    private final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTrial(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, NullSerializable<SubscriptionTrialInterval> trialInterval, NullSerializable<Integer> activeTrialUserLimit) {
        if (trialInterval == null && activeTrialUserLimit == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(guildRoleSubscriptionTierListing);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(guildRoleSubscriptionTierListing)");
            return scalarSynchronousObservable;
        }
        Observable observableG = restApi.updateGuildRoleSubscriptionTierFreeTrial(guildId, guildRoleSubscriptionTierListing.getId(), new RestAPIParams.UpdateGuildRoleSubscriptionTierFreeTrial(trialInterval, activeTrialUserLimit)).u(new AnonymousClass1(storeGuildRoleSubscriptions, guildId, guildRoleSubscriptionTierListing)).G(new AnonymousClass2(guildRoleSubscriptionTierListing));
        Intrinsics3.checkNotNullExpressionValue(observableG, "restApi\n          .updat…SubscriptionTierListing }");
        return observableG;
    }

    public static /* synthetic */ Observable updateGuildRoleSubscriptionTrial$default(GuildRoleSubscriptionUtils guildRoleSubscriptionUtils, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing, NullSerializable nullSerializable, NullSerializable nullSerializable2, int i, Object obj) {
        return guildRoleSubscriptionUtils.updateGuildRoleSubscriptionTrial(restAPI, storeGuildRoleSubscriptions, j, guildRoleSubscriptionTierListing, (i & 16) != 0 ? null : nullSerializable, (i & 32) != 0 ? null : nullSerializable2);
    }

    public final Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionGroupListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, String coverImage, String planDescription, Boolean isFullServerGating, String tierName, String tierDescription, int priceTier, String tierImage, int memberColor, String memberBadge, boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(tierName, "tierName");
        Intrinsics3.checkNotNullParameter(channelBenefits, "channelBenefits");
        Intrinsics3.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        Observable<R> observableA = restApi.createGuildRoleSubscriptionGroupListing(guildId, new RestAPIParams.CreateGuildRoleSubscriptionGroupListing(coverImage, planDescription, isFullServerGating)).A(new AnonymousClass1(storeGuildRoleSubscriptions, guildId, restApi, tierName, tierDescription, priceTier, tierImage, memberColor, memberBadge, canAccessAllChannels, channelBenefits, intangibleBenefits));
        Intrinsics3.checkNotNullExpressionValue(observableA, "restApi\n        .createG…ts,\n          )\n        }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null);
    }

    public final Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionTierListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, String tierName, String tierDescription, int priceTier, String tierImage, int memberColor, String memberIcon, boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(tierName, "tierName");
        Intrinsics3.checkNotNullParameter(channelBenefits, "channelBenefits");
        Intrinsics3.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        List listPlus = _Collections.plus((Collection) channelBenefits, (Iterable) intangibleBenefits);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listPlus, 10));
        Iterator it = listPlus.iterator();
        while (it.hasNext()) {
            arrayList.add(((Benefit) it.next()).toGuildRoleSubscriptionBenefit());
        }
        Observable<R> observableA = restApi.createGuildRoleSubscriptionTier(guildId, groupListingId, new RestAPIParams.CreateGuildRoleSubscriptionTierListing(tierName, tierImage, tierDescription, arrayList, priceTier, canAccessAllChannels)).A(new AnonymousClass1(restApi, guildId, memberColor, memberIcon));
        Intrinsics3.checkNotNullExpressionValue(observableA, "restApi\n        .createG…ng,\n          )\n        }");
        Observable<GuildRoleSubscriptionTierListing> observableU = ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null).u(new AnonymousClass2(storeGuildRoleSubscriptions, guildId, groupListingId));
        Intrinsics3.checkNotNullExpressionValue(observableU, "restApi\n        .createG…ing\n          )\n        }");
        return observableU;
    }

    public final Observable<Void> deleteGuildRoleSubscriptionTierListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, long tierListingId) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Observable<Void> observableU = ObservableExtensionsKt.restSubscribeOn$default(restApi.deleteGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId), false, 1, null).u(new AnonymousClass1(storeGuildRoleSubscriptions, guildId, groupListingId, tierListingId));
        Intrinsics3.checkNotNullExpressionValue(observableU, "restApi\n        .deleteG…Id,\n          )\n        }");
        return observableU;
    }

    public final Observable<GuildRoleSubscriptionGroupListing> updateGuildRoleSubscriptionGroupListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, String coverImage, String planDescription, Boolean isFullServerGating) {
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Observable<GuildRoleSubscriptionGroupListing> observableU = ObservableExtensionsKt.restSubscribeOn$default(restApi.updateGuildRoleSubscriptionGroupListing(guildId, groupListingId, new RestAPIParams.UpdateGuildRoleSubscriptionGroupListing(coverImage, planDescription, isFullServerGating)), false, 1, null).u(new AnonymousClass1(storeGuildRoleSubscriptions, guildId));
        Intrinsics3.checkNotNullExpressionValue(observableU, "restApi\n        .updateG…, groupListing)\n        }");
        return observableU;
    }

    public final Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTierListing(RestAPI restApi, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long guildId, long groupListingId, long tierListingId, String tierName, String tierDescription, String tierImage, Integer priceTier, Integer memberColor, String memberIcon, Boolean canAccessAllChannels, List<? extends Benefit> channelBenefits, List<? extends Benefit> intangibleBenefits, Boolean published, NullSerializable<SubscriptionTrialInterval> trialInterval, NullSerializable<Integer> activeTrialUserLimit) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(restApi, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        List<? extends Benefit> listPlus = (channelBenefits == null || intangibleBenefits == null) ? channelBenefits != null ? channelBenefits : intangibleBenefits : _Collections.plus((Collection) channelBenefits, (Iterable) intangibleBenefits);
        if (listPlus != null) {
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listPlus, 10));
            Iterator<T> it = listPlus.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Benefit) it.next()).toGuildRoleSubscriptionBenefit());
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        Observable observableA = restApi.updateGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId, new RestAPIParams.UpdateGuildRoleSubscriptionTierListing(tierName, tierImage, tierDescription, priceTier, arrayList, published, canAccessAllChannels)).A(new AnonymousClass2(restApi, guildId, memberColor, memberIcon)).A(new AnonymousClass3(restApi, storeGuildRoleSubscriptions, guildId, trialInterval, activeTrialUserLimit));
        Intrinsics3.checkNotNullExpressionValue(observableA, "restApi\n        .updateG…it,\n          )\n        }");
        Observable<GuildRoleSubscriptionTierListing> observableU = ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null).u(new AnonymousClass4(storeGuildRoleSubscriptions, guildId));
        Intrinsics3.checkNotNullExpressionValue(observableU, "restApi\n        .updateG…te(guildId, it)\n        }");
        return observableU;
    }
}
