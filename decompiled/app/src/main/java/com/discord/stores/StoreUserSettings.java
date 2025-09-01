package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserConsents2;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreUserSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u001e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u009e\u00012\u00020\u0001:\u0002\u009e\u0001B\u001d\u0012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001\u0012\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\r\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b#\u0010\u0016J\r\u0010$\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\"¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014¢\u0006\u0004\b)\u0010*J\u001b\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b+\u0010\u0016J\u0013\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u0014¢\u0006\u0004\b-\u0010*J\u0019\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0\u0014¢\u0006\u0004\b0\u0010*J\u0019\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010.0\u0014¢\u0006\u0004\b2\u0010*J\u0013\u00103\u001a\b\u0012\u0004\u0012\u00020\"0\u0014¢\u0006\u0004\b3\u0010*J\u0013\u00104\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014¢\u0006\u0004\b4\u0010*J\u0013\u00106\u001a\b\u0012\u0004\u0012\u0002050\u0014¢\u0006\u0004\b6\u0010*J\u0013\u00107\u001a\b\u0012\u0004\u0012\u00020\"0\u0014¢\u0006\u0004\b7\u0010*J\u0013\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0004\b8\u0010*J\r\u00109\u001a\u00020\u0002¢\u0006\u0004\b9\u0010\u001eJ\u001f\u0010;\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010:\u001a\u00020\u0002¢\u0006\u0004\b;\u0010\u001bJ\r\u0010<\u001a\u00020\u0002¢\u0006\u0004\b<\u0010\u001eJ\u001f\u0010>\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010=\u001a\u00020\u0002¢\u0006\u0004\b>\u0010\u001bJ\r\u0010?\u001a\u00020\u0002¢\u0006\u0004\b?\u0010\u001eJ\u001f\u0010A\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010@\u001a\u00020\u0002¢\u0006\u0004\bA\u0010\u001bJ\u0013\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014¢\u0006\u0004\bB\u0010*J\r\u0010C\u001a\u00020\u0002¢\u0006\u0004\bC\u0010\u001eJ\u0015\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0002¢\u0006\u0004\bE\u0010\u0006J\r\u0010F\u001a\u00020\u0002¢\u0006\u0004\bF\u0010\u001eJ\u0015\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0002¢\u0006\u0004\bF\u0010\u0006J\r\u0010H\u001a\u00020\u0002¢\u0006\u0004\bH\u0010\u001eJ\u0015\u0010J\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0002¢\u0006\u0004\bJ\u0010\u0006J\r\u0010K\u001a\u00020\u0002¢\u0006\u0004\bK\u0010\u001eJ\u0015\u0010M\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0002¢\u0006\u0004\bM\u0010\u0006J\r\u0010N\u001a\u00020\u0002¢\u0006\u0004\bN\u0010\u001eJ\u001f\u0010O\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\bO\u0010\u001bJ\r\u0010P\u001a\u00020\u0002¢\u0006\u0004\bP\u0010\u001eJ\u0015\u0010R\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u0002¢\u0006\u0004\bR\u0010\u0006J\u0013\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014¢\u0006\u0004\bS\u0010*J\r\u0010T\u001a\u00020\u0002¢\u0006\u0004\bT\u0010\u001eJ\u0015\u0010V\u001a\u00020\u00022\u0006\u0010U\u001a\u00020\u0002¢\u0006\u0004\bV\u0010!J\u0013\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014¢\u0006\u0004\bW\u0010*J\u001f\u0010Y\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010X\u001a\u00020\u0002¢\u0006\u0004\bY\u0010\u001bJ'\u0010\\\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010Z\u001a\u0002012\u0006\u0010[\u001a\u00020\u0002¢\u0006\u0004\b\\\u0010]J7\u0010`\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u000e\u0010_\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010^2\u0006\u0010Z\u001a\u0002012\u0006\u0010[\u001a\u00020\u0002¢\u0006\u0004\b`\u0010aJ/\u0010c\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010b\u001a\u00020\u00022\u000e\u0010_\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010^¢\u0006\u0004\bc\u0010dJ\u001f\u0010f\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010e\u001a\u00020\"¢\u0006\u0004\bf\u0010(J5\u0010j\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010g\u001a\u0004\u0018\u00010\u00022\b\u0010h\u001a\u0004\u0018\u00010\u00022\b\u0010i\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bj\u0010kJ\u001f\u0010m\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010l\u001a\u00020\"¢\u0006\u0004\bm\u0010(J\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bn\u0010oJ\r\u0010p\u001a\u00020\u0004¢\u0006\u0004\bp\u0010\nJ\u0017\u0010s\u001a\u00020\u00042\u0006\u0010r\u001a\u00020qH\u0017¢\u0006\u0004\bs\u0010tJ\u0015\u0010w\u001a\u00020\u00042\u0006\u0010v\u001a\u00020u¢\u0006\u0004\bw\u0010xJ\u0017\u0010y\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\by\u0010\u0012R2\u0010|\u001a\u001e\u0012\f\u0012\n {*\u0004\u0018\u00010505\u0012\f\u0012\n {*\u0004\u0018\u000105050z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R(\u0010~\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001a\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R4\u0010\u0087\u0001\u001a\u001e\u0012\f\u0012\n {*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n {*\u0004\u0018\u00010\u00020\u00020z8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010}R\u001a\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R4\u0010\u008b\u0001\u001a\u001e\u0012\f\u0012\n {*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n {*\u0004\u0018\u00010\u000b0\u000b0z8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010}R \u0010\u008d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u008c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u008c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u008e\u0001R \u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u008c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008e\u0001R4\u0010\u0091\u0001\u001a\u001e\u0012\f\u0012\n {*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n {*\u0004\u0018\u00010\u00020\u00020z8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010}R \u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\"0\u008c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u008e\u0001R&\u0010\u0093\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0\u008c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u008e\u0001R4\u0010\u0094\u0001\u001a\u001e\u0012\f\u0012\n {*\u0004\u0018\u00010\"0\"\u0012\f\u0012\n {*\u0004\u0018\u00010\"0\"0z8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010}R \u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u008c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u008e\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R4\u0010\u0099\u0001\u001a\u001e\u0012\f\u0012\n {*\u0004\u0018\u00010\"0\"\u0012\f\u0012\n {*\u0004\u0018\u00010\"0\"0z8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010}R \u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u008c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u008e\u0001R&\u0010\u009b\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002010.0\u008c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u008e\u0001¨\u0006\u009f\u0001"}, d2 = {"Lcom/discord/stores/StoreUserSettings;", "Lcom/discord/stores/Store;", "", "allowAccessibilityDetection", "", "updateAllowAccessibilityDetectionInternal", "(Z)V", "isDeveloperMode", "setDeveloperModeInternal", "expireCustomStatus", "()V", "Lcom/discord/models/domain/ModelCustomStatusSetting;", "customStatus", "updateLocalCustomStatus", "(Lcom/discord/models/domain/ModelCustomStatusSetting;)V", "Lcom/discord/models/domain/ModelUserSettings;", "userSettings", "handleUserSettings", "(Lcom/discord/models/domain/ModelUserSettings;)V", "respectReducedMotion", "Lrx/Observable;", "observeIsAnimatedEmojisEnabled", "(Z)Lrx/Observable;", "Lcom/discord/app/AppActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "isAnimatedEmojisEnabled", "setIsAnimatedEmojisEnabled", "(Lcom/discord/app/AppActivity;Z)V", "observeIsAutoPlayGifsEnabled", "getIsAutoPlayGifsEnabled", "()Z", "isAutoPlayGifsEnabled", "setIsAutoPlayGifsEnabled", "(Z)Z", "", "observeStickerAnimationSettings", "getStickerAnimationSettings", "()I", "stickerAnimationSettings", "setStickerAnimationSettings", "(Lcom/discord/app/AppActivity;I)V", "observeIsAccessibilityDetectionAllowed", "()Lrx/Observable;", "setIsAccessibilityDetectionAllowed", "Lcom/discord/models/domain/Consents;", "observeConsents", "", "Lcom/discord/models/domain/ModelGuildFolder;", "observeGuildFolders", "", "observeRestrictedGuildIds", "observeExplicitContentFilter", "observeIsDefaultGuildsRestricted", "Lcom/discord/models/domain/ModelUserSettings$FriendSourceFlags;", "observeFriendSourceFlags", "observeFriendDiscoveryFlags", "observeCustomStatus", "getIsEmbedMediaInlined", "isInlineEmbedMediaEnabled", "setIsEmbedMediaInlined", "getIsAttachmentMediaInline", "isAttachmentMediaInline", "setIsAttachmentMediaInline", "getIsRenderEmbedsEnabled", "isRenderEmbedsEnabled", "setIsRenderEmbedsEnabled", "observeIsRenderEmbedsEnabled", "getIsAutoImageCompressionEnabled", "isAutoImageCompressionEnabled", "setIsAutoImageCompressionEnabled", "getIsSyncTextAndImagesEnabled", "isSyncTextAndImagesEnabled", "getIsMobileOverlayEnabled", "isMobileOverlayEnabled", "setIsMobileOverlayEnabled", "getIsShiftEnterToSendEnabled", "isShiftEnterToSendEnabled", "setIsShiftEnterToSendEnabled", "getIsDeveloperMode", "setIsDeveloperMode", "getIsChromeCustomTabsEnabled", "isUseChromeCustomTabsEnabled", "setIsChromeCustomTabsEnabled", "observeIsStickerSuggestionsEnabled", "getIsStickerSuggestionsEnabled", "enabled", "setIsStickerSuggestionsEnabled", "observeIsShowCurrentGameEnabled", "isShowCurrentGameEnabled", "setIsShowCurrentGameEnabled", "guildId", "restricted", "setRestrictedGuildId", "(Lcom/discord/app/AppActivity;JZ)V", "", "restrictedGuilds", "setRestrictedGuildIds", "(Lcom/discord/app/AppActivity;Ljava/util/Collection;JZ)V", "defaultGuildsRestricted", "setDefaultGuildsRestricted", "(Lcom/discord/app/AppActivity;ZLjava/util/Collection;)V", "explicitContentFilter", "setExplicitContentFilter", "all", "mutualGuilds", "mutualFriends", "setFriendSourceFlags", "(Lcom/discord/app/AppActivity;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "flags", "setFriendDiscoveryFlags", "updateCustomStatus", "(Lcom/discord/models/domain/ModelCustomStatusSetting;)Lrx/Observable;", "updateContactSyncShown", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleUserSettingsUpdate", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "friendSourceFlagsSubject", "Lrx/subjects/SerializedSubject;", "contactSyncUpsellShown", "Ljava/lang/Boolean;", "getContactSyncUpsellShown", "()Ljava/lang/Boolean;", "setContactSyncUpsellShown", "(Ljava/lang/Boolean;)V", "Lcom/discord/stores/StoreAccessibility;", "accessibilityStore", "Lcom/discord/stores/StoreAccessibility;", "defaultGuildsRestrictedSubject", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "customStatusSubject", "Lcom/discord/utilities/persister/Persister;", "allowAccessibilityDetectionPublisher", "Lcom/discord/utilities/persister/Persister;", "showCurrentGame", "autoPlayGifsPublisher", "shouldRenderEmbedsSubject", "stickerAnimationSettingsPublisher", "guildFoldersPublisher", "friendDiscoveryFlagsSubject", "stickerSuggestionsPublisher", "Lrx/Subscription;", "expireCustomStatusSubscription", "Lrx/Subscription;", "explicitContentFilterSubject", "allowAnimatedEmojisPublisher", "restrictedGuildIdsPublisher", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreAccessibility;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUserSettings extends Store {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreAccessibility accessibilityStore;
    private final Persister<Boolean> allowAccessibilityDetectionPublisher;
    private final Persister<Boolean> allowAnimatedEmojisPublisher;
    private final Persister<Boolean> autoPlayGifsPublisher;
    private Boolean contactSyncUpsellShown;
    private final SerializedSubject<ModelCustomStatusSetting, ModelCustomStatusSetting> customStatusSubject;
    private final SerializedSubject<Boolean, Boolean> defaultGuildsRestrictedSubject;
    private final Dispatcher dispatcher;
    private Subscription expireCustomStatusSubscription;
    private final SerializedSubject<Integer, Integer> explicitContentFilterSubject;
    private final SerializedSubject<Integer, Integer> friendDiscoveryFlagsSubject;
    private final SerializedSubject<ModelUserSettings.FriendSourceFlags, ModelUserSettings.FriendSourceFlags> friendSourceFlagsSubject;
    private final Persister<List<ModelGuildFolder>> guildFoldersPublisher;
    private final Persister<List<Long>> restrictedGuildIdsPublisher;
    private final SerializedSubject<Boolean, Boolean> shouldRenderEmbedsSubject;
    private final Persister<Boolean> showCurrentGame;
    private final Persister<Integer> stickerAnimationSettingsPublisher;
    private final Persister<Boolean> stickerSuggestionsPublisher;

    /* compiled from: StoreUserSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/stores/StoreUserSettings$Companion;", "", "Lcom/discord/app/AppActivity;", "Lcom/discord/restapi/RestAPIParams$UserSettings;", "settings", "", "successStringResId", "", "updateUserSettings", "(Lcom/discord/app/AppActivity;Lcom/discord/restapi/RestAPIParams$UserSettings;Ljava/lang/Integer;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ void access$updateUserSettings(Companion companion, AppActivity appActivity, RestAPIParams.UserSettings userSettings, Integer num) {
            companion.updateUserSettings(appActivity, userSettings, num);
        }

        private final void updateUserSettings(AppActivity appActivity, RestAPIParams.UserSettings userSettings, Integer num) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(userSettings), false, 1, null), appActivity, null, 2, null), StoreUserSettings.class, appActivity, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUserSettings2(appActivity, num), 60, (Object) null);
        }

        public static /* synthetic */ void updateUserSettings$default(Companion companion, AppActivity appActivity, RestAPIParams.UserSettings userSettings, Integer num, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            companion.updateUserSettings(appActivity, userSettings, num);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreUserSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUserSettings;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelUserSettings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSettings$expireCustomStatus$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserSettings, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
        }
    }

    /* compiled from: StoreUserSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/models/domain/Consents;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Lcom/discord/models/domain/Consents;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSettings$observeConsents$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Throwable, ModelUserConsents2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ ModelUserConsents2 call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModelUserConsents2 call2(Throwable th) {
            return ModelUserConsents2.INSTANCE.getDEFAULT();
        }
    }

    /* compiled from: StoreUserSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelUserSettings;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelUserSettings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSettings$setIsAccessibilityDetectionAllowed$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<ModelUserSettings> {
        public final /* synthetic */ boolean $allowAccessibilityDetection;

        public AnonymousClass1(boolean z2) {
            this.$allowAccessibilityDetection = z2;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelUserSettings modelUserSettings) {
            call2(modelUserSettings);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelUserSettings modelUserSettings) {
            StoreUserSettings.access$updateAllowAccessibilityDetectionInternal(StoreUserSettings.this, this.$allowAccessibilityDetection);
        }
    }

    /* compiled from: StoreUserSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSettings$updateAllowAccessibilityDetectionInternal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $allowAccessibilityDetection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$allowAccessibilityDetection = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUserSettings.access$getAccessibilityStore$p(StoreUserSettings.this).updateDetectionAllowed(this.$allowAccessibilityDetection);
        }
    }

    /* compiled from: StoreUserSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUserSettings;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelUserSettings;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSettings$updateContactSyncShown$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserSettings, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
        }
    }

    /* compiled from: StoreUserSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSettings$updateLocalCustomStatus$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
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
            StoreUserSettings.access$setExpireCustomStatusSubscription$p(StoreUserSettings.this, subscription);
        }
    }

    /* compiled from: StoreUserSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSettings$updateLocalCustomStatus$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreUserSettings.access$expireCustomStatus(StoreUserSettings.this);
        }
    }

    public StoreUserSettings(Dispatcher dispatcher, StoreAccessibility storeAccessibility) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeAccessibility, "accessibilityStore");
        this.dispatcher = dispatcher;
        this.accessibilityStore = storeAccessibility;
        this.shouldRenderEmbedsSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.explicitContentFilterSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.defaultGuildsRestrictedSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.friendSourceFlagsSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.friendDiscoveryFlagsSubject = new SerializedSubject<>(BehaviorSubject.l0(0));
        this.customStatusSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.restrictedGuildIdsPublisher = new Persister<>("RESTRICTED_GUILD_IDS", new ArrayList());
        this.guildFoldersPublisher = new Persister<>("STORE_SETTINGS_FOLDERS_V1", new ArrayList());
        Boolean bool = Boolean.TRUE;
        this.allowAnimatedEmojisPublisher = new Persister<>("STORE_SETTINGS_ALLOW_ANIMATED_EMOJIS", bool);
        this.stickerAnimationSettingsPublisher = new Persister<>("CACHE_KEY_STICKER_ANIMATION_SETTINGS_V1", 0);
        this.showCurrentGame = new Persister<>("STORE_SETTINGS_ALLOW_GAME_STATUS", bool);
        this.stickerSuggestionsPublisher = new Persister<>("CACHE_KEY_STICKER_SUGGESTIONS", bool);
        this.allowAccessibilityDetectionPublisher = new Persister<>("STORE_SETTINGS_ALLOW_ACCESSIBILITY_DETECTION", Boolean.FALSE);
        this.autoPlayGifsPublisher = new Persister<>("STORE_SETTINGS_AUTO_PLAY_GIFS", bool);
    }

    public static final /* synthetic */ void access$expireCustomStatus(StoreUserSettings storeUserSettings) {
        storeUserSettings.expireCustomStatus();
    }

    public static final /* synthetic */ StoreAccessibility access$getAccessibilityStore$p(StoreUserSettings storeUserSettings) {
        return storeUserSettings.accessibilityStore;
    }

    public static final /* synthetic */ Subscription access$getExpireCustomStatusSubscription$p(StoreUserSettings storeUserSettings) {
        return storeUserSettings.expireCustomStatusSubscription;
    }

    public static final /* synthetic */ void access$setExpireCustomStatusSubscription$p(StoreUserSettings storeUserSettings, Subscription subscription) {
        storeUserSettings.expireCustomStatusSubscription = subscription;
    }

    public static final /* synthetic */ void access$updateAllowAccessibilityDetectionInternal(StoreUserSettings storeUserSettings, boolean z2) {
        storeUserSettings.updateAllowAccessibilityDetectionInternal(z2);
    }

    private final void expireCustomStatus() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(updateCustomStatus(null), false, 1, null), StoreUserSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    private final void handleUserSettings(ModelUserSettings userSettings) {
        List<ModelGuildFolder> guildFolders = userSettings.getGuildFolders();
        List<Long> restrictedGuilds = userSettings.getRestrictedGuilds();
        if (getIsSyncTextAndImagesEnabled()) {
            if (userSettings.getInlineEmbedMedia() != null) {
                Boolean inlineEmbedMedia = userSettings.getInlineEmbedMedia();
                Intrinsics3.checkNotNullExpressionValue(inlineEmbedMedia, "userSettings.inlineEmbedMedia");
                setIsEmbedMediaInlined(null, inlineEmbedMedia.booleanValue());
            }
            if (userSettings.getInlineAttachmentMedia() != null) {
                Boolean inlineAttachmentMedia = userSettings.getInlineAttachmentMedia();
                Intrinsics3.checkNotNullExpressionValue(inlineAttachmentMedia, "userSettings.inlineAttachmentMedia");
                setIsAttachmentMediaInline(null, inlineAttachmentMedia.booleanValue());
            }
            if (userSettings.getRenderEmbeds() != null) {
                Boolean renderEmbeds = userSettings.getRenderEmbeds();
                Intrinsics3.checkNotNullExpressionValue(renderEmbeds, "userSettings.renderEmbeds");
                setIsRenderEmbedsEnabled(null, renderEmbeds.booleanValue());
            }
            if (userSettings.getAnimateEmoji() != null) {
                Boolean animateEmoji = userSettings.getAnimateEmoji();
                Intrinsics3.checkNotNullExpressionValue(animateEmoji, "userSettings.animateEmoji");
                setIsAnimatedEmojisEnabled(null, animateEmoji.booleanValue());
            }
            if (userSettings.getAnimateStickers() != null) {
                Integer animateStickers = userSettings.getAnimateStickers();
                Intrinsics3.checkNotNullExpressionValue(animateStickers, "userSettings.animateStickers");
                setStickerAnimationSettings(null, animateStickers.intValue());
            }
        }
        if (guildFolders != null) {
            Persister.set$default(this.guildFoldersPublisher, guildFolders, false, 2, null);
        }
        if (restrictedGuilds != null) {
            Persister.set$default(this.restrictedGuildIdsPublisher, restrictedGuilds, false, 2, null);
        }
        if (userSettings.getDeveloperMode() != null) {
            Boolean developerMode = userSettings.getDeveloperMode();
            Intrinsics3.checkNotNullExpressionValue(developerMode, "userSettings.developerMode");
            setDeveloperModeInternal(developerMode.booleanValue());
        }
        if (userSettings.getShowCurrentGame() != null) {
            Persister<Boolean> persister = this.showCurrentGame;
            Boolean showCurrentGame = userSettings.getShowCurrentGame();
            Intrinsics3.checkNotNullExpressionValue(showCurrentGame, "userSettings.showCurrentGame");
            Persister.set$default(persister, showCurrentGame, false, 2, null);
        }
        if (userSettings.getExplicitContentFilter() != null) {
            SerializedSubject<Integer, Integer> serializedSubject = this.explicitContentFilterSubject;
            serializedSubject.k.onNext(userSettings.getExplicitContentFilter());
        }
        if (userSettings.getFriendSourceFlags() != null) {
            SerializedSubject<ModelUserSettings.FriendSourceFlags, ModelUserSettings.FriendSourceFlags> serializedSubject2 = this.friendSourceFlagsSubject;
            serializedSubject2.k.onNext(userSettings.getFriendSourceFlags());
        }
        if (userSettings.getDefaultGuildsRestricted() != null) {
            SerializedSubject<Boolean, Boolean> serializedSubject3 = this.defaultGuildsRestrictedSubject;
            serializedSubject3.k.onNext(userSettings.getDefaultGuildsRestricted());
        }
        if (userSettings.getCustomStatus() != null) {
            updateLocalCustomStatus(userSettings.getCustomStatus());
        }
        if (userSettings.getFriendDiscoveryFlags() != null) {
            SerializedSubject<Integer, Integer> serializedSubject4 = this.friendDiscoveryFlagsSubject;
            serializedSubject4.k.onNext(userSettings.getFriendDiscoveryFlags());
        }
        if (userSettings.getContactSyncUpsellShown() != null) {
            this.contactSyncUpsellShown = userSettings.getContactSyncUpsellShown();
        }
    }

    public static /* synthetic */ Observable observeIsAnimatedEmojisEnabled$default(StoreUserSettings storeUserSettings, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return storeUserSettings.observeIsAnimatedEmojisEnabled(z2);
    }

    public static /* synthetic */ Observable observeIsAutoPlayGifsEnabled$default(StoreUserSettings storeUserSettings, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return storeUserSettings.observeIsAutoPlayGifsEnabled(z2);
    }

    public static /* synthetic */ Observable observeStickerAnimationSettings$default(StoreUserSettings storeUserSettings, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return storeUserSettings.observeStickerAnimationSettings(z2);
    }

    private final void setDeveloperModeInternal(boolean isDeveloperMode) {
        getPrefs().edit().putBoolean("CACHE_KEY_DEVELOPER_MODE", isDeveloperMode).apply();
    }

    private final void updateAllowAccessibilityDetectionInternal(boolean allowAccessibilityDetection) {
        Persister.set$default(this.allowAccessibilityDetectionPublisher, Boolean.valueOf(allowAccessibilityDetection), false, 2, null);
        this.dispatcher.schedule(new AnonymousClass1(allowAccessibilityDetection));
    }

    private final synchronized void updateLocalCustomStatus(ModelCustomStatusSetting customStatus) {
        Subscription subscription = this.expireCustomStatusSubscription;
        if (subscription != null) {
            Intrinsics3.checkNotNull(subscription);
            subscription.unsubscribe();
        }
        this.customStatusSubject.k.onNext(customStatus);
        if (!Intrinsics3.areEqual(customStatus, ModelCustomStatusSetting.INSTANCE.getCLEAR())) {
            Intrinsics3.checkNotNull(customStatus);
            if (customStatus.getExpiresAt() != null) {
                Observable<Long> observableD0 = Observable.d0(_Ranges.coerceAtLeast(TimeUtils.parseUTCDate(customStatus.getExpiresAt()) - ClockFactory.get().currentTimeMillis(), 0L), TimeUnit.MILLISECONDS);
                Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n            .…l, TimeUnit.MILLISECONDS)");
                ObservableExtensionsKt.appSubscribe$default(observableD0, getClass(), (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
            }
        }
    }

    public final Boolean getContactSyncUpsellShown() {
        return this.contactSyncUpsellShown;
    }

    public final boolean getIsAttachmentMediaInline() {
        return getPrefs().getBoolean("CACHE_KEY_INLINE_ATTACHMENT_MEDIA", true);
    }

    public final boolean getIsAutoImageCompressionEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_IMAGE_COMPRESSION", false);
    }

    public final boolean getIsAutoPlayGifsEnabled() {
        return getPrefs().getBoolean("STORE_SETTINGS_AUTO_PLAY_GIFS", true);
    }

    public final boolean getIsChromeCustomTabsEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_USE_CHROME_CUSTOM_TABS", true);
    }

    public final boolean getIsDeveloperMode() {
        return getPrefs().getBoolean("CACHE_KEY_DEVELOPER_MODE", false);
    }

    public final boolean getIsEmbedMediaInlined() {
        return getPrefs().getBoolean("CACHE_KEY_INLINE_EMBED_MEDIA", true);
    }

    public final boolean getIsMobileOverlayEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_MOBILE_OVERLAY", false);
    }

    public final boolean getIsRenderEmbedsEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_RENDER_EMBEDS", true);
    }

    public final boolean getIsShiftEnterToSendEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_SHIFT_ENTER_TO_SEND", false);
    }

    public final boolean getIsStickerSuggestionsEnabled() {
        return this.stickerSuggestionsPublisher.get().booleanValue();
    }

    public final boolean getIsSyncTextAndImagesEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_SYNC_TEXT_AND_IMAGES", true);
    }

    public final int getStickerAnimationSettings() {
        return this.stickerAnimationSettingsPublisher.get().intValue();
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        ModelUserSettings userSettings = payload.getUserSettings();
        Intrinsics3.checkNotNullExpressionValue(userSettings, "userSettings");
        handleUserSettings(userSettings);
    }

    @Store3
    public final void handleUserSettingsUpdate(ModelUserSettings userSettings) {
        Intrinsics3.checkNotNullParameter(userSettings, "userSettings");
        handleUserSettings(userSettings);
    }

    @Override // com.discord.stores.Store
    @Store3
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        SerializedSubject<Boolean, Boolean> serializedSubject = this.shouldRenderEmbedsSubject;
        serializedSubject.k.onNext(Boolean.valueOf(getIsRenderEmbedsEnabled()));
    }

    public final Observable<ModelUserConsents2> observeConsents() {
        Observable<ModelUserConsents2> observableM = RestAPI.INSTANCE.getApi().getConsents().M(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM, "RestAPI\n          .api\n …turn { Consents.DEFAULT }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableM, false, 1, null);
    }

    public final Observable<ModelCustomStatusSetting> observeCustomStatus() {
        Observable<ModelCustomStatusSetting> observableR = ObservableExtensionsKt.computationLatest(this.customStatusSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "customStatusSubject\n    …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observeExplicitContentFilter() {
        Observable<Integer> observableR = ObservableExtensionsKt.computationLatest(this.explicitContentFilterSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "explicitContentFilterSub…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observeFriendDiscoveryFlags() {
        Observable<Integer> observableR = ObservableExtensionsKt.computationLatest(this.friendDiscoveryFlagsSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "friendDiscoveryFlagsSubj…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<ModelUserSettings.FriendSourceFlags> observeFriendSourceFlags() {
        Observable<ModelUserSettings.FriendSourceFlags> observableR = ObservableExtensionsKt.computationLatest(this.friendSourceFlagsSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "friendSourceFlagsSubject…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<List<ModelGuildFolder>> observeGuildFolders() {
        Observable<List<ModelGuildFolder>> observableR = ObservableExtensionsKt.computationLatest(this.guildFoldersPublisher.getObservable()).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "guildFoldersPublisher\n  …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsAccessibilityDetectionAllowed() {
        Observable<Boolean> observableR = this.allowAccessibilityDetectionPublisher.getObservable().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "allowAccessibilityDetect…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsAnimatedEmojisEnabled(boolean respectReducedMotion) {
        Observable<Boolean> observable = this.allowAnimatedEmojisPublisher.getObservable();
        if (respectReducedMotion) {
            observable = Observable.j(observable, this.accessibilityStore.observeReducedMotionEnabled(), StoreUserSettings3.INSTANCE);
        }
        Observable<Boolean> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "allowAnimatedEmojisPubli…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsAutoPlayGifsEnabled(boolean respectReducedMotion) {
        Observable<Boolean> observable = this.autoPlayGifsPublisher.getObservable();
        if (respectReducedMotion) {
            observable = Observable.j(observable, this.accessibilityStore.observeReducedMotionEnabled(), StoreUserSettings4.INSTANCE);
        }
        Observable<Boolean> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "autoPlayGifsPublisher\n  …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsDefaultGuildsRestricted() {
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(this.defaultGuildsRestrictedSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "defaultGuildsRestrictedS…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsRenderEmbedsEnabled() {
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(this.shouldRenderEmbedsSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "shouldRenderEmbedsSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsShowCurrentGameEnabled() {
        return this.showCurrentGame.getObservable();
    }

    public final Observable<Boolean> observeIsStickerSuggestionsEnabled() {
        return this.stickerSuggestionsPublisher.getObservable();
    }

    public final Observable<List<Long>> observeRestrictedGuildIds() {
        Observable<List<Long>> observableR = ObservableExtensionsKt.computationLatest(this.restrictedGuildIdsPublisher.getObservable()).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "restrictedGuildIdsPublis…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observeStickerAnimationSettings(boolean respectReducedMotion) {
        Observable<Integer> observable = this.stickerAnimationSettingsPublisher.getObservable();
        if (respectReducedMotion) {
            observable = Observable.j(observable, this.accessibilityStore.observeReducedMotionEnabled(), StoreUserSettings5.INSTANCE);
        }
        Observable<Integer> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "stickerAnimationSettings…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setContactSyncUpsellShown(Boolean bool) {
        this.contactSyncUpsellShown = bool;
    }

    public final void setDefaultGuildsRestricted(AppActivity activity, boolean defaultGuildsRestricted, Collection<Long> restrictedGuilds) {
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithRestrictedGuilds(Boolean.valueOf(defaultGuildsRestricted), restrictedGuilds), null, 2, null);
        }
    }

    public final void setExplicitContentFilter(AppActivity activity, int explicitContentFilter) {
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithExplicitContentFilter(explicitContentFilter), null, 2, null);
        }
    }

    public final void setFriendDiscoveryFlags(AppActivity activity, int flags) {
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithFriendDiscoveryFlags(Integer.valueOf(flags)), null, 2, null);
        }
    }

    public final void setFriendSourceFlags(AppActivity activity, Boolean all, Boolean mutualGuilds, Boolean mutualFriends) {
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithFriendSourceFlags(all, mutualGuilds, mutualFriends), null, 2, null);
        }
    }

    public final Observable<ModelUserSettings> setIsAccessibilityDetectionAllowed(boolean allowAccessibilityDetection) {
        Observable<ModelUserSettings> observableU = RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithAllowAccessibilityDetection(Boolean.valueOf(allowAccessibilityDetection))).u(new AnonymousClass1(allowAccessibilityDetection));
        Intrinsics3.checkNotNullExpressionValue(observableU, "RestAPI\n          .api\n …AccessibilityDetection) }");
        return observableU;
    }

    public final void setIsAnimatedEmojisEnabled(AppActivity activity, boolean isAnimatedEmojisEnabled) {
        Persister.set$default(this.allowAnimatedEmojisPublisher, Boolean.valueOf(isAnimatedEmojisEnabled), false, 2, null);
        if (!getIsSyncTextAndImagesEnabled() || activity == null) {
            return;
        }
        Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithAllowAnimatedEmojis(Boolean.valueOf(isAnimatedEmojisEnabled)), null, 2, null);
    }

    public final void setIsAttachmentMediaInline(AppActivity activity, boolean isAttachmentMediaInline) {
        if (getIsAttachmentMediaInline() != isAttachmentMediaInline) {
            getPrefs().edit().putBoolean("CACHE_KEY_INLINE_ATTACHMENT_MEDIA", isAttachmentMediaInline).apply();
        }
        if (!getIsSyncTextAndImagesEnabled() || activity == null) {
            return;
        }
        Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithInlineAttachmentMedia(isAttachmentMediaInline), null, 2, null);
    }

    public final void setIsAutoImageCompressionEnabled(boolean isAutoImageCompressionEnabled) {
        if (getIsAutoImageCompressionEnabled() != isAutoImageCompressionEnabled) {
            getPrefs().edit().putBoolean("CACHE_KEY_IMAGE_COMPRESSION", isAutoImageCompressionEnabled).apply();
        }
    }

    public final boolean setIsAutoPlayGifsEnabled(boolean isAutoPlayGifsEnabled) {
        return ((Boolean) Persister.set$default(this.autoPlayGifsPublisher, Boolean.valueOf(isAutoPlayGifsEnabled), false, 2, null)).booleanValue();
    }

    public final void setIsChromeCustomTabsEnabled(boolean isUseChromeCustomTabsEnabled) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean("CACHE_KEY_USE_CHROME_CUSTOM_TABS", isUseChromeCustomTabsEnabled);
        editorEdit.apply();
    }

    public final void setIsDeveloperMode(AppActivity activity, boolean isDeveloperMode) {
        if (getIsDeveloperMode() != isDeveloperMode) {
            if (activity != null) {
                Companion.access$updateUserSettings(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithDeveloperMode(isDeveloperMode), Integer.valueOf(R.string.theme_updated));
            }
            setDeveloperModeInternal(isDeveloperMode);
        }
    }

    public final void setIsEmbedMediaInlined(AppActivity activity, boolean isInlineEmbedMediaEnabled) {
        if (getIsEmbedMediaInlined() != isInlineEmbedMediaEnabled) {
            getPrefs().edit().putBoolean("CACHE_KEY_INLINE_EMBED_MEDIA", isInlineEmbedMediaEnabled).apply();
        }
        if (!getIsSyncTextAndImagesEnabled() || activity == null) {
            return;
        }
        Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithInlineEmbedMedia(isInlineEmbedMediaEnabled), null, 2, null);
    }

    public final void setIsMobileOverlayEnabled(boolean isMobileOverlayEnabled) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        if (getIsMobileOverlayEnabled() != isMobileOverlayEnabled) {
            editorEdit.putBoolean("CACHE_KEY_MOBILE_OVERLAY", isMobileOverlayEnabled);
            AnalyticsTracker.overlayToggled(isMobileOverlayEnabled);
        }
        editorEdit.apply();
    }

    public final void setIsRenderEmbedsEnabled(AppActivity activity, boolean isRenderEmbedsEnabled) {
        if (getIsRenderEmbedsEnabled() != isRenderEmbedsEnabled) {
            getPrefs().edit().putBoolean("CACHE_KEY_RENDER_EMBEDS", isRenderEmbedsEnabled).apply();
            SerializedSubject<Boolean, Boolean> serializedSubject = this.shouldRenderEmbedsSubject;
            serializedSubject.k.onNext(Boolean.valueOf(isRenderEmbedsEnabled));
        }
        if (!getIsSyncTextAndImagesEnabled() || activity == null) {
            return;
        }
        Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithRenderEmbeds(isRenderEmbedsEnabled), null, 2, null);
    }

    public final void setIsShiftEnterToSendEnabled(boolean isShiftEnterToSendEnabled) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        if (getIsShiftEnterToSendEnabled() != isShiftEnterToSendEnabled) {
            editorEdit.putBoolean("CACHE_KEY_SHIFT_ENTER_TO_SEND", isShiftEnterToSendEnabled);
        }
        editorEdit.apply();
    }

    public final void setIsShowCurrentGameEnabled(AppActivity activity, boolean isShowCurrentGameEnabled) {
        Persister.set$default(this.showCurrentGame, Boolean.valueOf(isShowCurrentGameEnabled), false, 2, null);
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithShowCurrentGame(isShowCurrentGameEnabled), null, 2, null);
        }
    }

    public final boolean setIsStickerSuggestionsEnabled(boolean enabled) {
        return this.stickerSuggestionsPublisher.set(Boolean.valueOf(enabled), true).booleanValue();
    }

    public final void setRestrictedGuildId(AppActivity activity, long guildId, boolean restricted) {
        setRestrictedGuildIds(activity, this.restrictedGuildIdsPublisher.get(), guildId, restricted);
    }

    public final void setRestrictedGuildIds(AppActivity activity, Collection<Long> restrictedGuilds, long guildId, boolean restricted) {
        ArrayList arrayList = new ArrayList(restrictedGuilds);
        if (restricted && !arrayList.contains(Long.valueOf(guildId))) {
            arrayList.add(Long.valueOf(guildId));
        }
        if (!restricted) {
            arrayList.remove(Long.valueOf(guildId));
        }
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithRestrictedGuilds(null, arrayList), null, 2, null);
        }
    }

    public final void setStickerAnimationSettings(AppActivity activity, int stickerAnimationSettings) {
        Persister.set$default(this.stickerAnimationSettingsPublisher, Integer.valueOf(stickerAnimationSettings), false, 2, null);
        if (!getIsSyncTextAndImagesEnabled() || activity == null) {
            return;
        }
        Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithStickerAnimationSettings(Integer.valueOf(stickerAnimationSettings)), null, 2, null);
    }

    public final void updateContactSyncShown() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithContactSyncUpsellShown()), false, 1, null), StoreUserSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    public final Observable<ModelUserSettings> updateCustomStatus(ModelCustomStatusSetting customStatus) {
        return RestAPI.INSTANCE.getApiSerializeNulls().updateUserSettingsCustomStatus(new RestAPIParams.UserSettingsCustomStatus(customStatus));
    }

    public final void getIsSyncTextAndImagesEnabled(boolean isSyncTextAndImagesEnabled) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        if (getIsSyncTextAndImagesEnabled() != isSyncTextAndImagesEnabled) {
            editorEdit.putBoolean("CACHE_KEY_SYNC_TEXT_AND_IMAGES", isSyncTextAndImagesEnabled);
        }
        editorEdit.apply();
    }
}
