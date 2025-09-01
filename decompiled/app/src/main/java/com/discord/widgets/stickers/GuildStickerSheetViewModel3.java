package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.stickers.GuildStickerSheetViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import retrofit2.HttpException;
import rx.Observable;

/* compiled from: GuildStickerSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/guild/Guild;", "localGuild", "Lrx/Observable;", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildStickerSheetViewModel3<T, R> implements Func1<Guild, Observable<? extends GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo>> {
    public final /* synthetic */ RestAPI $restAPI;
    public final /* synthetic */ Sticker $sticker;

    /* compiled from: GuildStickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/guild/Guild;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/models/guild/Guild;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guild/Guild;)Lcom/discord/models/guild/Guild;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<com.discord.api.guild.Guild, Guild> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Guild call(com.discord.api.guild.Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Guild call2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "it");
            return new Guild(guild);
        }
    }

    /* compiled from: GuildStickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/guild/Guild;", "kotlin.jvm.PlatformType", "responseGuild", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Guild, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "responseGuild");
            return new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild, true, true, Integer.valueOf(guild.getApproximatePresenceCount()));
        }
    }

    /* compiled from: GuildStickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Throwable, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public final /* synthetic */ Guild $localGuild;

        public AnonymousClass3(Guild guild) {
            this.$localGuild = guild;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Throwable th) {
            return ((th instanceof HttpException) && ((HttpException) th).a() == 404) ? new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(this.$localGuild, false, true, null) : GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Unknown.INSTANCE;
        }
    }

    /* compiled from: GuildStickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/guild/Guild;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/models/guild/Guild;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guild/Guild;)Lcom/discord/models/guild/Guild;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<com.discord.api.guild.Guild, Guild> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Guild call(com.discord.api.guild.Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Guild call2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "it");
            return new Guild(guild);
        }
    }

    /* compiled from: GuildStickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/guild/Guild;", "kotlin.jvm.PlatformType", "responseGuild", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$5, reason: invalid class name */
    public static final class AnonymousClass5<T, R> implements Func1<Guild, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Guild guild) {
            Intrinsics3.checkNotNullExpressionValue(guild, "responseGuild");
            return new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild, true, false, Integer.valueOf(guild.getApproximatePresenceCount()));
        }
    }

    /* compiled from: GuildStickerSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$6, reason: invalid class name */
    public static final class AnonymousClass6<T, R> implements Func1<Throwable, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call2(Throwable th) {
            return GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Unknown.INSTANCE;
        }
    }

    public GuildStickerSheetViewModel3(RestAPI restAPI, Sticker sticker) {
        this.$restAPI = restAPI;
        this.$sticker = sticker;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> call(Guild guild) {
        return call2(guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> call2(Guild guild) {
        return guild != null ? guild.getFeatures().contains(GuildFeature.DISCOVERABLE) ? this.$restAPI.getStickerGuild(this.$sticker.getId()).G(AnonymousClass1.INSTANCE).G(AnonymousClass2.INSTANCE).M(new AnonymousClass3(guild)) : new ScalarSynchronousObservable(new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild, false, true, null)) : this.$restAPI.getStickerGuild(this.$sticker.getId()).G(AnonymousClass4.INSTANCE).G(AnonymousClass5.INSTANCE).M(AnonymousClass6.INSTANCE);
    }
}
